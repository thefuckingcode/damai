package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.o;

/* compiled from: Taobao */
public final class SpdyStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    private final SpdyConnection connection;
    private ErrorCode errorCode = null;
    private final int id;
    private final SpdyTimeout readTimeout = new SpdyTimeout();
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final SpdyDataSink sink;
    private final SpdyDataSource source;
    long unacknowledgedBytesRead = 0;
    private final SpdyTimeout writeTimeout = new SpdyTimeout();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class SpdyDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer = new Buffer();

        SpdyDataSink() {
        }

        /* JADX INFO: finally extract failed */
        private void emitDataFrame(boolean z) throws IOException {
            long min;
            SpdyStream spdyStream;
            synchronized (SpdyStream.this) {
                SpdyStream.this.writeTimeout.enter();
                while (true) {
                    try {
                        SpdyStream spdyStream2 = SpdyStream.this;
                        if (spdyStream2.bytesLeftInWriteWindow > 0 || this.finished || this.closed || spdyStream2.errorCode != null) {
                            SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                            SpdyStream.this.checkOutNotClosed();
                            min = Math.min(SpdyStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                            spdyStream = SpdyStream.this;
                            spdyStream.bytesLeftInWriteWindow -= min;
                        } else {
                            SpdyStream.this.waitForIo();
                        }
                    } catch (Throwable th) {
                        SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                SpdyStream.this.checkOutNotClosed();
                min = Math.min(SpdyStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                spdyStream = SpdyStream.this;
                spdyStream.bytesLeftInWriteWindow -= min;
            }
            spdyStream.connection.writeData(SpdyStream.this.id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            emitDataFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r8.this$0.connection.writeData(r8.this$0.id, true, null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
            r2 = r8.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
            r8.this$0.connection.flush();
            r8.this$0.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.this$0.sink.finished != false) goto L_0x0040;
         */
        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                if (this.closed) {
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (SpdyStream.this) {
                SpdyStream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitDataFrame(false);
            }
            SpdyStream.this.connection.flush();
        }

        @Override // okio.Sink
        public o timeout() {
            return SpdyStream.this.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitDataFrame(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class SpdyDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (SpdyStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
        }

        private void waitUntilReadable() throws IOException {
            SpdyStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                try {
                    SpdyStream.this.waitForIo();
                } finally {
                    SpdyStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                SpdyStream.this.notifyAll();
            }
            SpdyStream.this.cancelStreamIfNecessary();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
            r11 = r8.this$0.connection;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
            monitor-enter(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8.this$0.connection.unacknowledgedBytesRead += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0088, code lost:
            if (r8.this$0.connection.unacknowledgedBytesRead < ((long) (r8.this$0.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
            r8.this$0.connection.writeWindowUpdateLater(0, r8.this$0.connection.unacknowledgedBytesRead);
            r8.this$0.connection.unacknowledgedBytesRead = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
            return r9;
         */
        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                synchronized (SpdyStream.this) {
                    waitUntilReadable();
                    checkNotClosed();
                    if (this.readBuffer.size() == 0) {
                        return -1;
                    }
                    Buffer buffer2 = this.readBuffer;
                    long read = buffer2.read(buffer, Math.min(j, buffer2.size()));
                    SpdyStream spdyStream = SpdyStream.this;
                    long j2 = spdyStream.unacknowledgedBytesRead + read;
                    spdyStream.unacknowledgedBytesRead = j2;
                    if (j2 >= ((long) (spdyStream.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) {
                        SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.id, SpdyStream.this.unacknowledgedBytesRead);
                        SpdyStream.this.unacknowledgedBytesRead = 0;
                    }
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
        }

        /* access modifiers changed from: package-private */
        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (SpdyStream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (SpdyStream.this) {
                            if (this.readBuffer.size() != 0) {
                                z2 = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z2) {
                                SpdyStream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // okio.Source
        public o timeout() {
            return SpdyStream.this.readTimeout;
        }

        private SpdyDataSource(long j) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class SpdyTimeout extends AsyncTimeout {
        SpdyTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws InterruptedIOException {
            if (exit()) {
                throw new InterruptedIOException("timeout");
            }
        }

        /* access modifiers changed from: protected */
        @Override // okio.AsyncTimeout
        public void timedOut() {
            SpdyStream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    SpdyStream(int i, SpdyConnection spdyConnection, boolean z, boolean z2, List<Header> list) {
        Objects.requireNonNull(spdyConnection, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.id = i;
        this.connection = spdyConnection;
        this.bytesLeftInWriteWindow = (long) spdyConnection.peerSettings.getInitialWindowSize(65536);
        SpdyDataSource spdyDataSource = new SpdyDataSource((long) spdyConnection.okHttpSettings.getInitialWindowSize(65536));
        this.source = spdyDataSource;
        SpdyDataSink spdyDataSink = new SpdyDataSink();
        this.sink = spdyDataSink;
        spdyDataSource.finished = z2;
        spdyDataSink.finished = z;
        this.requestHeaders = list;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode2;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void close(ErrorCode errorCode2) throws IOException {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    public SpdyConnection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    /* JADX INFO: finally extract failed */
    public synchronized List<Header> getResponseHeaders() throws IOException {
        List<Header> list;
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        list = this.responseHeaders;
        if (list == null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return list;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        if (this.connection.client == ((this.id & 1) == 1)) {
            return true;
        }
        return false;
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && ((this.sink.finished || this.sink.closed) && this.responseHeaders != null)) {
            return false;
        }
        return true;
    }

    public o readTimeout() {
        return this.readTimeout;
    }

    /* access modifiers changed from: package-private */
    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        this.source.receive(bufferedSource, (long) i);
    }

    /* access modifiers changed from: package-private */
    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> list, HeadersMode headersMode) {
        ErrorCode errorCode2 = null;
        boolean z = true;
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.responseHeaders = list;
                    z = isOpen();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode2 = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (errorCode2 != null) {
            closeLater(errorCode2);
        } else if (!z) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    public void reply(List<Header> list, boolean z) throws IOException {
        boolean z2 = false;
        synchronized (this) {
            if (list == null) {
                throw new NullPointerException("responseHeaders == null");
            } else if (this.responseHeaders == null) {
                this.responseHeaders = list;
                if (!z) {
                    this.sink.finished = true;
                    z2 = true;
                }
            } else {
                throw new IllegalStateException("reply already sent");
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public o writeTimeout() {
        return this.writeTimeout;
    }
}
