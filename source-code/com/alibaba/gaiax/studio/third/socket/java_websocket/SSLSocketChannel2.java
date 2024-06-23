package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

@Keep
/* compiled from: Taobao */
public class SSLSocketChannel2 implements WrappedByteChannel, ByteChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);
    protected int bufferallocations = 0;
    protected ExecutorService exec;
    protected ByteBuffer inCrypt;
    protected ByteBuffer inData;
    protected ByteBuffer outCrypt;
    protected SSLEngineResult readEngineResult;
    protected SelectionKey selectionKey;
    protected SocketChannel socketChannel;
    protected SSLEngine sslEngine;
    protected List<Future<?>> tasks;
    protected SSLEngineResult writeEngineResult;

    public SSLSocketChannel2(SocketChannel socketChannel2, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey2) throws IOException {
        if (socketChannel2 == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel2;
        this.sslEngine = sSLEngine;
        this.exec = executorService;
        SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.writeEngineResult = sSLEngineResult;
        this.readEngineResult = sSLEngineResult;
        this.tasks = new ArrayList(3);
        if (selectionKey2 != null) {
            selectionKey2.interestOps(selectionKey2.interestOps() | 4);
            this.selectionKey = selectionKey2;
        }
        createBuffers(sSLEngine.getSession());
        this.socketChannel.write(wrap(emptybuffer));
        processHandshake();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0006 */
    private void consumeFutureUninterruptible(Future<?> future) {
        while (true) {
            future.get();
            try {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isHandShakeComplete() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private synchronized void processHandshake() throws IOException {
        if (this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            if (!this.tasks.isEmpty()) {
                Iterator<Future<?>> it = this.tasks.iterator();
                while (it.hasNext()) {
                    Future<?> next = it.next();
                    if (next.isDone()) {
                        it.remove();
                    } else {
                        if (isBlocking()) {
                            consumeFutureUninterruptible(next);
                        }
                        return;
                    }
                }
            }
            if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                if (!isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                    this.inCrypt.compact();
                    if (this.socketChannel.read(this.inCrypt) != -1) {
                        this.inCrypt.flip();
                    } else {
                        throw new IOException("connection closed unexpectedly by peer");
                    }
                }
                this.inData.compact();
                unwrap();
                if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                    createBuffers(this.sslEngine.getSession());
                    return;
                }
            }
            consumeDelegatedTasks();
            if (this.tasks.isEmpty() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                this.socketChannel.write(wrap(emptybuffer));
                if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                    createBuffers(this.sslEngine.getSession());
                    return;
                }
            }
            this.bufferallocations = 1;
        }
    }

    private int readRemaining(ByteBuffer byteBuffer) throws SSLException {
        if (this.inData.hasRemaining()) {
            return transfereTo(this.inData, byteBuffer);
        }
        if (!this.inData.hasRemaining()) {
            this.inData.clear();
        }
        if (!this.inCrypt.hasRemaining()) {
            return 0;
        }
        unwrap();
        int transfereTo = transfereTo(this.inData, byteBuffer);
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
            return -1;
        }
        if (transfereTo > 0) {
            return transfereTo;
        }
        return 0;
    }

    private int transfereTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            for (int i = 0; i < min; i++) {
                byteBuffer2.put(byteBuffer.get());
            }
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }

    private synchronized ByteBuffer unwrap() throws SSLException {
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            try {
                close();
            } catch (IOException unused) {
            }
        }
        while (true) {
            int remaining = this.inData.remaining();
            SSLEngineResult unwrap = this.sslEngine.unwrap(this.inCrypt, this.inData);
            this.readEngineResult = unwrap;
            if (unwrap.getStatus() != SSLEngineResult.Status.OK || (remaining == this.inData.remaining() && this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                this.inData.flip();
            }
        }
        this.inData.flip();
        return this.inData;
    }

    private synchronized ByteBuffer wrap(ByteBuffer byteBuffer) throws SSLException {
        this.outCrypt.compact();
        this.writeEngineResult = this.sslEngine.wrap(byteBuffer, this.outCrypt);
        this.outCrypt.flip();
        return this.outCrypt;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.sslEngine.closeOutbound();
        this.sslEngine.getSession().invalidate();
        if (this.socketChannel.isOpen()) {
            this.socketChannel.write(wrap(emptybuffer));
        }
        this.socketChannel.close();
    }

    public SelectableChannel configureBlocking(boolean z) throws IOException {
        return this.socketChannel.configureBlocking(z);
    }

    public boolean connect(SocketAddress socketAddress) throws IOException {
        return this.socketChannel.connect(socketAddress);
    }

    /* access modifiers changed from: protected */
    public void consumeDelegatedTasks() {
        while (true) {
            Runnable delegatedTask = this.sslEngine.getDelegatedTask();
            if (delegatedTask != null) {
                this.tasks.add(this.exec.submit(delegatedTask));
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void createBuffers(SSLSession sSLSession) {
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int max = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.inData;
        if (byteBuffer == null) {
            this.inData = ByteBuffer.allocate(max);
            this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            this.inCrypt = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != max) {
                this.inData = ByteBuffer.allocate(max);
            }
            if (this.outCrypt.capacity() != packetBufferSize) {
                this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.inCrypt.capacity() != packetBufferSize) {
                this.inCrypt = ByteBuffer.allocate(packetBufferSize);
            }
        }
        this.inData.rewind();
        this.inData.flip();
        this.inCrypt.rewind();
        this.inCrypt.flip();
        this.outCrypt.rewind();
        this.outCrypt.flip();
        this.bufferallocations++;
    }

    public boolean finishConnect() throws IOException {
        return this.socketChannel.finishConnect();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    public boolean isConnected() {
        return this.socketChannel.isConnected();
    }

    public boolean isInboundDone() {
        return this.sslEngine.isInboundDone();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return this.inData.hasRemaining() || !(!this.inCrypt.hasRemaining() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return this.outCrypt.hasRemaining() || !isHandShakeComplete();
    }

    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0008  */
    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            if (!isHandShakeComplete()) {
                if (isBlocking()) {
                    while (!isHandShakeComplete()) {
                        processHandshake();
                    }
                } else {
                    processHandshake();
                    if (!isHandShakeComplete()) {
                        return 0;
                    }
                }
            }
            int readRemaining = readRemaining(byteBuffer);
            if (readRemaining != 0) {
                return readRemaining;
            }
            this.inData.clear();
            if (!this.inCrypt.hasRemaining()) {
                this.inCrypt.clear();
            } else {
                this.inCrypt.compact();
            }
            if ((isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.socketChannel.read(this.inCrypt) == -1) {
                return -1;
            }
            this.inCrypt.flip();
            unwrap();
            int transfereTo = transfereTo(this.inData, byteBuffer);
            if (transfereTo != 0 || !isBlocking()) {
                return transfereTo;
            }
            while (byteBuffer.hasRemaining()) {
            }
        }
        return 0;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) throws SSLException {
        return readRemaining(byteBuffer);
    }

    public Socket socket() {
        return this.socketChannel.socket();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!isHandShakeComplete()) {
            processHandshake();
            return 0;
        }
        int write = this.socketChannel.write(wrap(byteBuffer));
        if (this.writeEngineResult.getStatus() != SSLEngineResult.Status.CLOSED) {
            return write;
        }
        throw new EOFException("Connection is closed");
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public void writeMore() throws IOException {
        write(this.outCrypt);
    }
}
