package com.alibaba.gaiax.studio.third.socket.java_websocket;

import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.util.ByteBufferUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

@Keep
/* compiled from: Taobao */
public class SSLSocketChannel implements WrappedByteChannel, ByteChannel {
    private final SSLEngine engine;
    private ExecutorService executor;
    private ByteBuffer myAppData;
    private ByteBuffer myNetData;
    private ByteBuffer peerAppData;
    private ByteBuffer peerNetData;
    private final SocketChannel socketChannel;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0063 */
        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            b = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            b[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 4;
            b[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            int[] iArr2 = new int[SSLEngineResult.Status.values().length];
            a = iArr2;
            iArr2[SSLEngineResult.Status.OK.ordinal()] = 1;
            a[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 2;
            a[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 3;
            a[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
        }
    }

    public SSLSocketChannel(SocketChannel socketChannel2, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws IOException {
        if (socketChannel2 == null || sSLEngine == null || this.executor == executorService) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel2;
        this.engine = sSLEngine;
        this.executor = executorService;
        this.myNetData = ByteBuffer.allocate(sSLEngine.getSession().getPacketBufferSize());
        this.peerNetData = ByteBuffer.allocate(sSLEngine.getSession().getPacketBufferSize());
        sSLEngine.beginHandshake();
        if (!doHandshake()) {
            try {
                socketChannel2.close();
            } catch (IOException e) {
                Log.e("[GaiaX]", "Exception during the closing of the channel", e);
            }
        } else if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
        }
    }

    private void closeConnection() throws IOException {
        this.engine.closeOutbound();
        try {
            doHandshake();
        } catch (IOException unused) {
        }
        this.socketChannel.close();
    }

    private boolean doHandshake() throws IOException {
        SSLEngineResult.HandshakeStatus handshakeStatus;
        int applicationBufferSize = this.engine.getSession().getApplicationBufferSize();
        this.myAppData = ByteBuffer.allocate(applicationBufferSize);
        this.peerAppData = ByteBuffer.allocate(applicationBufferSize);
        this.myNetData.clear();
        this.peerNetData.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus2 = this.engine.getHandshakeStatus();
        boolean z = false;
        while (!z) {
            int i = a.b[handshakeStatus2.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.myNetData.clear();
                        try {
                            SSLEngineResult wrap = this.engine.wrap(this.myAppData, this.myNetData);
                            handshakeStatus = wrap.getHandshakeStatus();
                            int i2 = a.a[wrap.getStatus().ordinal()];
                            if (i2 == 1) {
                                this.myNetData.flip();
                                while (this.myNetData.hasRemaining()) {
                                    this.socketChannel.write(this.myNetData);
                                }
                            } else if (i2 == 2) {
                                throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                            } else if (i2 == 3) {
                                this.myNetData = enlargePacketBuffer(this.myNetData);
                            } else if (i2 == 4) {
                                try {
                                    this.myNetData.flip();
                                    while (this.myNetData.hasRemaining()) {
                                        this.socketChannel.write(this.myNetData);
                                    }
                                    this.peerNetData.clear();
                                } catch (Exception unused) {
                                    handshakeStatus2 = this.engine.getHandshakeStatus();
                                }
                            } else {
                                throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
                            }
                        } catch (SSLException unused2) {
                            this.engine.closeOutbound();
                            handshakeStatus2 = this.engine.getHandshakeStatus();
                        }
                    } else if (i == 4) {
                        while (true) {
                            Runnable delegatedTask = this.engine.getDelegatedTask();
                            if (delegatedTask == null) {
                                break;
                            }
                            this.executor.execute(delegatedTask);
                        }
                        handshakeStatus2 = this.engine.getHandshakeStatus();
                    } else if (i != 5) {
                        throw new IllegalStateException("Invalid SSL status: " + handshakeStatus2);
                    }
                } else if (this.socketChannel.read(this.peerNetData) >= 0) {
                    this.peerNetData.flip();
                    try {
                        SSLEngineResult unwrap = this.engine.unwrap(this.peerNetData, this.peerAppData);
                        this.peerNetData.compact();
                        handshakeStatus = unwrap.getHandshakeStatus();
                        int i3 = a.a[unwrap.getStatus().ordinal()];
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.peerNetData = handleBufferUnderflow(this.peerNetData);
                            } else if (i3 == 3) {
                                this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                            } else if (i3 != 4) {
                                throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                            } else if (this.engine.isOutboundDone()) {
                                return false;
                            } else {
                                this.engine.closeOutbound();
                                handshakeStatus2 = this.engine.getHandshakeStatus();
                            }
                        }
                    } catch (SSLException unused3) {
                        this.engine.closeOutbound();
                        handshakeStatus2 = this.engine.getHandshakeStatus();
                    }
                } else if (this.engine.isInboundDone() && this.engine.isOutboundDone()) {
                    return false;
                } else {
                    try {
                        this.engine.closeInbound();
                    } catch (SSLException unused4) {
                    }
                    this.engine.closeOutbound();
                    handshakeStatus2 = this.engine.getHandshakeStatus();
                }
                handshakeStatus2 = handshakeStatus;
            } else {
                z = !this.peerNetData.hasRemaining();
                if (z) {
                    return true;
                }
                this.socketChannel.write(this.peerNetData);
            }
        }
        return true;
    }

    private ByteBuffer enlargeApplicationBuffer(ByteBuffer byteBuffer) {
        return enlargeBuffer(byteBuffer, this.engine.getSession().getApplicationBufferSize());
    }

    private ByteBuffer enlargeBuffer(ByteBuffer byteBuffer, int i) {
        if (i > byteBuffer.capacity()) {
            return ByteBuffer.allocate(i);
        }
        return ByteBuffer.allocate(byteBuffer.capacity() * 2);
    }

    private ByteBuffer enlargePacketBuffer(ByteBuffer byteBuffer) {
        return enlargeBuffer(byteBuffer, this.engine.getSession().getPacketBufferSize());
    }

    private ByteBuffer handleBufferUnderflow(ByteBuffer byteBuffer) {
        if (this.engine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer enlargePacketBuffer = enlargePacketBuffer(byteBuffer);
        byteBuffer.flip();
        enlargePacketBuffer.put(byteBuffer);
        return enlargePacketBuffer;
    }

    private void handleEndOfStream() throws IOException {
        try {
            this.engine.closeInbound();
        } catch (Exception unused) {
            Log.e("[GaiaX]", "This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
        }
        closeConnection();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        closeConnection();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return this.peerNetData.hasRemaining() || this.peerAppData.hasRemaining();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return false;
    }

    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.peerAppData.hasRemaining()) {
            this.peerAppData.flip();
            return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
        }
        this.peerNetData.compact();
        int read = this.socketChannel.read(this.peerNetData);
        if (read > 0 || this.peerNetData.hasRemaining()) {
            this.peerNetData.flip();
            if (this.peerNetData.hasRemaining()) {
                this.peerAppData.compact();
                try {
                    SSLEngineResult unwrap = this.engine.unwrap(this.peerNetData, this.peerAppData);
                    int i = a.a[unwrap.getStatus().ordinal()];
                    if (i == 1) {
                        this.peerAppData.flip();
                        return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                    } else if (i == 2) {
                        this.peerAppData.flip();
                        return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                    } else if (i == 3) {
                        this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                        return read(byteBuffer);
                    } else if (i == 4) {
                        closeConnection();
                        byteBuffer.clear();
                        return -1;
                    } else {
                        throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                    }
                } catch (SSLException e) {
                    Log.e("[GaiaX]", "SSLExcpetion during unwrap", e);
                    throw e;
                }
            }
        } else if (read < 0) {
            handleEndOfStream();
        }
        ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
        return read;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) throws IOException {
        return read(byteBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer byteBuffer) throws IOException {
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            this.myNetData.clear();
            SSLEngineResult wrap = this.engine.wrap(byteBuffer, this.myNetData);
            int i2 = a.a[wrap.getStatus().ordinal()];
            if (i2 == 1) {
                this.myNetData.flip();
                while (this.myNetData.hasRemaining()) {
                    i += this.socketChannel.write(this.myNetData);
                }
            } else if (i2 == 2) {
                throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
            } else if (i2 == 3) {
                this.myNetData = enlargePacketBuffer(this.myNetData);
            } else if (i2 == 4) {
                closeConnection();
                return 0;
            } else {
                throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
            }
        }
        return i;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public void writeMore() throws IOException {
    }
}
