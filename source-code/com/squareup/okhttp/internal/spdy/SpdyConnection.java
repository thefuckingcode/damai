package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.h;

/* compiled from: Taobao */
public final class SpdyConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map<Integer, SpdyStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    /* compiled from: Taobao */
    public static class Builder {
        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private Protocol protocol;
        private PushObserver pushObserver;
        private Socket socket;

        public Builder(boolean z, Socket socket2) throws IOException {
            this(((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), z, socket2);
        }

        public SpdyConnection build() throws IOException {
            return new SpdyConnection(this);
        }

        public Builder handler(IncomingStreamHandler incomingStreamHandler) {
            this.handler = incomingStreamHandler;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder(String str, boolean z, Socket socket2) throws IOException {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.protocol = Protocol.SPDY_3;
            this.pushObserver = PushObserver.CANCEL;
            this.hostName = str;
            this.client = z;
            this.socket = socket2;
        }
    }

    /* compiled from: Taobao */
    class Reader extends NamedRunnable implements FrameReader.Handler {
        FrameReader frameReader;

        private void ackSettingsLater(final Settings settings) {
            SpdyConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{SpdyConnection.this.hostName}) {
                /* class com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.AnonymousClass2 */

                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        SpdyConnection.this.frameWriter.ackSettings(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream == null) {
                SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip((long) i2);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r0 = com.squareup.okhttp.internal.spdy.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
            r5.this$0.close(r0, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
            r2 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003a */
        @Override // com.squareup.okhttp.internal.NamedRunnable
        public void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                SpdyConnection spdyConnection = SpdyConnection.this;
                FrameReader newReader = spdyConnection.variant.newReader(h.d(h.m(spdyConnection.socket)), SpdyConnection.this.client);
                this.frameReader = newReader;
                if (!SpdyConnection.this.client) {
                    newReader.readConnectionPreface();
                }
                while (this.frameReader.nextFrame(this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                errorCode2 = ErrorCode.CANCEL;
                try {
                    SpdyConnection.this.close(errorCode, errorCode2);
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                errorCode = errorCode2;
            } catch (Throwable th) {
                Throwable th2 = th;
                ErrorCode errorCode3 = errorCode2;
                try {
                    SpdyConnection.this.close(errorCode3, errorCode2);
                } catch (IOException unused3) {
                }
                Util.closeQuietly(this.frameReader);
                throw th2;
            }
            Util.closeQuietly(this.frameReader);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            SpdyStream[] spdyStreamArr;
            byteString.size();
            synchronized (SpdyConnection.this) {
                spdyStreamArr = (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                SpdyConnection.this.shutdown = true;
            }
            for (SpdyStream spdyStream : spdyStreamArr) {
                if (spdyStream.getId() > i && spdyStream.isLocallyInitiated()) {
                    spdyStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    SpdyConnection.this.removeStream(spdyStream.getId());
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
            if (r14.failIfStreamPresent() == false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
            r0.closeLater(com.squareup.okhttp.internal.spdy.ErrorCode.PROTOCOL_ERROR);
            r8.this$0.removeStream(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
            r0.receiveHeaders(r13, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushHeadersLater(i, list, z2);
                return;
            }
            synchronized (SpdyConnection.this) {
                if (!SpdyConnection.this.shutdown) {
                    SpdyStream stream = SpdyConnection.this.getStream(i);
                    if (stream == null) {
                        if (headersMode.failIfStreamAbsent()) {
                            SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                        } else if (i > SpdyConnection.this.lastGoodStreamId) {
                            if (i % 2 != SpdyConnection.this.nextStreamId % 2) {
                                final SpdyStream spdyStream = new SpdyStream(i, SpdyConnection.this, z, z2, list);
                                SpdyConnection.this.lastGoodStreamId = i;
                                SpdyConnection.this.streams.put(Integer.valueOf(i), spdyStream);
                                SpdyConnection.executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{SpdyConnection.this.hostName, Integer.valueOf(i)}) {
                                    /* class com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.AnonymousClass1 */

                                    @Override // com.squareup.okhttp.internal.NamedRunnable
                                    public void execute() {
                                        try {
                                            SpdyConnection.this.handler.receive(spdyStream);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            if (z) {
                Ping removePing = SpdyConnection.this.removePing(i);
                if (removePing != null) {
                    removePing.receive();
                    return;
                }
                return;
            }
            SpdyConnection.this.writePingLater(true, i, i2, null);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            SpdyConnection.this.pushRequestLater(i2, list);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushResetLater(i, errorCode);
                return;
            }
            SpdyStream removeStream = SpdyConnection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            SpdyStream[] spdyStreamArr;
            long j;
            synchronized (SpdyConnection.this) {
                int initialWindowSize = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
                if (z) {
                    SpdyConnection.this.peerSettings.clear();
                }
                SpdyConnection.this.peerSettings.merge(settings);
                if (SpdyConnection.this.getProtocol() == Protocol.HTTP_2) {
                    ackSettingsLater(settings);
                }
                int initialWindowSize2 = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
                spdyStreamArr = null;
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    j = 0;
                } else {
                    j = (long) (initialWindowSize2 - initialWindowSize);
                    if (!SpdyConnection.this.receivedInitialPeerSettings) {
                        SpdyConnection.this.addBytesToWriteWindow(j);
                        SpdyConnection.this.receivedInitialPeerSettings = true;
                    }
                    if (!SpdyConnection.this.streams.isEmpty()) {
                        spdyStreamArr = (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                    }
                }
            }
            if (!(spdyStreamArr == null || j == 0)) {
                for (SpdyStream spdyStream : spdyStreamArr) {
                    synchronized (spdyStream) {
                        spdyStream.addBytesToWriteWindow(j);
                    }
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (SpdyConnection.this) {
                    SpdyConnection spdyConnection = SpdyConnection.this;
                    spdyConnection.bytesLeftInWriteWindow += j;
                    spdyConnection.notifyAll();
                }
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        private Reader() {
            super("OkHttp %s", SpdyConnection.this.hostName);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pushDataLater(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
                /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass6 */

                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = SpdyConnection.this.pushObserver.onData(i, buffer, i2, z);
                        if (onData) {
                            SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (SpdyConnection.this) {
                                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pushHeadersLater(final int i, final List<Header> list, final boolean z) {
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass5 */

            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                boolean onHeaders = SpdyConnection.this.pushObserver.onHeaders(i, list, z);
                if (onHeaders) {
                    try {
                        SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || z) {
                    synchronized (SpdyConnection.this) {
                        SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pushRequestLater(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
                /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass4 */

                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    if (SpdyConnection.this.pushObserver.onRequest(i, list)) {
                        try {
                            SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                            synchronized (SpdyConnection.this) {
                                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pushResetLater(final int i, final ErrorCode errorCode) {
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass7 */

            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                SpdyConnection.this.pushObserver.onReset(i, errorCode);
                synchronized (SpdyConnection.this) {
                    SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean pushedStream(int i) {
        return this.protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized Ping removePing(int i) {
        Map<Integer, Ping> map;
        map = this.pings;
        return map != null ? map.remove(Integer.valueOf(i)) : null;
    }

    private synchronized void setIdle(boolean z) {
        long j;
        if (z) {
            try {
                j = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j = AbsPerformance.LONG_NIL;
        }
        this.idleStartTimeNs = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(z, i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void writePingLater(final boolean z, final int i, final int i2, final Ping ping) {
        executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}) {
            /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass3 */

            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writePing(z, i, i2, ping);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    /* access modifiers changed from: package-private */
    public synchronized SpdyStream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != AbsPerformance.LONG_NIL;
    }

    public SpdyStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (!this.shutdown) {
                i = this.nextPingId;
                this.nextPingId = i + 2;
                if (this.pings == null) {
                    this.pings = new HashMap();
                }
                this.pings.put(Integer.valueOf(i), ping);
            } else {
                throw new IOException("shutdown");
            }
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public SpdyStream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.protocol == Protocol.HTTP_2) {
            return newStream(i, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized SpdyStream removeStream(int i) {
        SpdyStream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        if (remove != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        return remove;
    }

    public void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int initialWindowSize = this.okHttpSettings.getInitialWindowSize(65536);
        if (initialWindowSize != 65536) {
            this.frameWriter.windowUpdate(0, (long) (initialWindowSize - 65536));
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    this.frameWriter.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        long j2;
        int min;
        long j3;
        if (j == 0) {
            this.frameWriter.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.bytesLeftInWriteWindow;
                        if (j2 > 0) {
                            break;
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, j2), this.frameWriter.maxDataLength());
                j3 = (long) min;
                this.bytesLeftInWriteWindow -= j3;
            }
            j -= j3;
            this.frameWriter.data(z && j == 0, i, buffer, min);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(final int i, final ErrorCode errorCode) {
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass1 */

            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writeSynReset(i, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(final int i, final long j) {
        executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) {
            /* class com.squareup.okhttp.internal.spdy.SpdyConnection.AnonymousClass2 */

            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.frameWriter.windowUpdate(i, j);
                } catch (IOException unused) {
                }
            }
        });
    }

    private SpdyConnection(Builder builder) throws IOException {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0;
        Settings settings = new Settings();
        this.okHttpSettings = settings;
        Settings settings2 = new Settings();
        this.peerSettings = settings2;
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        Protocol protocol2 = builder.protocol;
        this.protocol = protocol2;
        this.pushObserver = builder.pushObserver;
        boolean z = builder.client;
        this.client = z;
        this.handler = builder.handler;
        int i = 2;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && protocol2 == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = builder.client ? 1 : i;
        if (builder.client) {
            settings.set(7, 0, 16777216);
        }
        String str = builder.hostName;
        this.hostName = str;
        if (protocol2 == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", str), true));
            settings2.set(7, 0, 65535);
            settings2.set(5, 0, 16384);
        } else if (protocol2 == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(protocol2);
        }
        this.bytesLeftInWriteWindow = (long) settings2.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(h.c(h.i(builder.socket)), z);
        Reader reader = new Reader();
        this.readerRunnable = reader;
        new Thread(reader).start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException e;
        int i;
        SpdyStream[] spdyStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                spdyStreamArr = (SpdyStream[]) this.streams.values().toArray(new SpdyStream[this.streams.size()]);
                this.streams.clear();
                setIdle(false);
            } else {
                spdyStreamArr = null;
            }
            Map<Integer, Ping> map = this.pings;
            if (map != null) {
                this.pings = null;
                pingArr = (Ping[]) map.values().toArray(new Ping[this.pings.size()]);
            }
        }
        if (spdyStreamArr != null) {
            for (SpdyStream spdyStream : spdyStreamArr) {
                try {
                    spdyStream.close(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.cancel();
            }
        }
        try {
            this.frameWriter.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    private SpdyStream newStream(int i, List<Header> list, boolean z, boolean z2) throws IOException {
        int i2;
        SpdyStream spdyStream;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    i2 = this.nextStreamId;
                    this.nextStreamId = i2 + 2;
                    spdyStream = new SpdyStream(i2, this, z3, z4, list);
                    if (spdyStream.isOpen()) {
                        this.streams.put(Integer.valueOf(i2), spdyStream);
                        setIdle(false);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            if (i == 0) {
                this.frameWriter.synStream(z3, z4, i2, i, list);
            } else if (!this.client) {
                this.frameWriter.pushPromise(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (!z) {
            this.frameWriter.flush();
        }
        return spdyStream;
    }
}
