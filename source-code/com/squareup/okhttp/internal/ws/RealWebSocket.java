package com.squareup.okhttp.internal.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.ws.WebSocketReader;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Random;
import java.util.concurrent.Executor;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

/* compiled from: Taobao */
public abstract class RealWebSocket implements WebSocket {
    private static final int CLOSE_PROTOCOL_EXCEPTION = 1002;
    private final Object closeLock = new Object();
    private final WebSocketListener listener;
    private final WebSocketReader reader;
    private volatile boolean readerSentClose;
    private final WebSocketWriter writer;
    private volatile boolean writerSentClose;

    public RealWebSocket(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, Random random, final Executor executor, final WebSocketListener webSocketListener, final String str) {
        this.listener = webSocketListener;
        this.writer = new WebSocketWriter(z, bufferedSink, random);
        this.reader = new WebSocketReader(z, bufferedSource, new WebSocketReader.FrameCallback() {
            /* class com.squareup.okhttp.internal.ws.RealWebSocket.AnonymousClass1 */

            @Override // com.squareup.okhttp.internal.ws.WebSocketReader.FrameCallback
            public void onClose(final int i, final String str) {
                executor.execute(new NamedRunnable("OkHttp %s WebSocket Close Reply", new Object[]{str}) {
                    /* class com.squareup.okhttp.internal.ws.RealWebSocket.AnonymousClass1.AnonymousClass2 */

                    /* access modifiers changed from: protected */
                    @Override // com.squareup.okhttp.internal.NamedRunnable
                    public void execute() {
                        RealWebSocket.this.peerClose(i, str);
                    }
                });
            }

            @Override // com.squareup.okhttp.internal.ws.WebSocketReader.FrameCallback
            public void onMessage(BufferedSource bufferedSource, WebSocket.PayloadType payloadType) throws IOException {
                webSocketListener.onMessage(bufferedSource, payloadType);
            }

            @Override // com.squareup.okhttp.internal.ws.WebSocketReader.FrameCallback
            public void onPing(final Buffer buffer) {
                executor.execute(new NamedRunnable("OkHttp %s WebSocket Pong Reply", new Object[]{str}) {
                    /* class com.squareup.okhttp.internal.ws.RealWebSocket.AnonymousClass1.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    @Override // com.squareup.okhttp.internal.NamedRunnable
                    public void execute() {
                        try {
                            RealWebSocket.this.writer.writePong(buffer);
                        } catch (IOException unused) {
                        }
                    }
                });
            }

            @Override // com.squareup.okhttp.internal.ws.WebSocketReader.FrameCallback
            public void onPong(Buffer buffer) {
                webSocketListener.onPong(buffer);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|2|(2:10|11)|12|13|14|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0014 */
    private void peerClose(int i, String str) {
        boolean z;
        synchronized (this.closeLock) {
            z = true;
            this.readerSentClose = true;
            if (this.writerSentClose) {
                z = false;
            }
        }
        if (z) {
            this.writer.writeClose(i, str);
        }
        closeConnection();
        this.listener.onClose(i, str);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001b */
    private void readerErrorClose(IOException iOException) {
        boolean z;
        synchronized (this.closeLock) {
            z = true;
            this.readerSentClose = true;
            if (this.writerSentClose) {
                z = false;
            }
        }
        if (z && (iOException instanceof ProtocolException)) {
            this.writer.writeClose(1002, null);
        }
        try {
            closeConnection();
        } catch (IOException unused) {
        }
        this.listener.onFailure(iOException);
    }

    @Override // com.squareup.okhttp.ws.WebSocket
    public void close(int i, String str) throws IOException {
        boolean z;
        if (!this.writerSentClose) {
            synchronized (this.closeLock) {
                this.writerSentClose = true;
                z = this.readerSentClose;
            }
            this.writer.writeClose(i, str);
            if (z) {
                closeConnection();
                return;
            }
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    /* access modifiers changed from: protected */
    public abstract void closeConnection() throws IOException;

    @Override // com.squareup.okhttp.ws.WebSocket
    public BufferedSink newMessageSink(WebSocket.PayloadType payloadType) {
        if (!this.writerSentClose) {
            return this.writer.newMessageSink(payloadType);
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    public boolean readMessage() {
        try {
            this.reader.processNextFrame();
            return !this.readerSentClose;
        } catch (IOException e) {
            readerErrorClose(e);
            return false;
        }
    }

    @Override // com.squareup.okhttp.ws.WebSocket
    public void sendMessage(WebSocket.PayloadType payloadType, Buffer buffer) throws IOException {
        if (!this.writerSentClose) {
            this.writer.sendMessage(payloadType, buffer);
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.squareup.okhttp.ws.WebSocket
    public void sendPing(Buffer buffer) throws IOException {
        if (!this.writerSentClose) {
            this.writer.writePing(buffer);
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    public void sendPong(Buffer buffer) throws IOException {
        if (!this.writerSentClose) {
            this.writer.writePong(buffer);
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }
}
