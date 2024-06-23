package com.alibaba.gaiax.studio.third.socket.java_websocket.client;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.AbstractWebSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketImpl;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft_6455;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.ReadyState;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidHandshakeException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.HandshakeImpl1Client;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ServerHandshake;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.jl1;

@Keep
/* compiled from: Taobao */
public abstract class WebSocketClient extends AbstractWebSocket implements WebSocket, Runnable {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private Draft draft;
    private WebSocketImpl engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    protected URI uri;
    private Thread writeThread;

    /* compiled from: Taobao */
    private class WebsocketWriteThread implements Runnable {
        private final WebSocketClient webSocketClient;

        WebsocketWriteThread(WebSocketClient webSocketClient2) {
            this.webSocketClient = webSocketClient2;
        }

        private void closeSocket() {
            try {
                if (WebSocketClient.this.socket != null) {
                    WebSocketClient.this.socket.close();
                }
            } catch (IOException e) {
                WebSocketClient.this.onWebsocketError(this.webSocketClient, e);
            }
        }

        private void runWriteData() throws IOException {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = WebSocketClient.this.engine.outQueue.take();
                    WebSocketClient.this.ostream.write(take.array(), 0, take.limit());
                    WebSocketClient.this.ostream.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer : WebSocketClient.this.engine.outQueue) {
                        WebSocketClient.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                        WebSocketClient.this.ostream.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                runWriteData();
            } catch (IOException e) {
                WebSocketClient.this.handleIOException(e);
            } catch (Throwable th) {
                closeSocket();
                WebSocketClient.this.writeThread = null;
                throw th;
            }
            closeSocket();
            WebSocketClient.this.writeThread = null;
        }
    }

    public WebSocketClient(URI uri2) {
        this(uri2, new Draft_6455());
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.uri.getScheme();
        if ("wss".equals(scheme)) {
            return 443;
        }
        if ("ws".equals(scheme)) {
            return 80;
        }
        throw new IllegalArgumentException("unknown scheme: " + scheme);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.eot();
    }

    private void reset() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.writeThread || currentThread == this.connectReadThread) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
        }
        try {
            closeBlocking();
            Thread thread = this.writeThread;
            if (thread != null) {
                thread.interrupt();
                this.writeThread = null;
            }
            Thread thread2 = this.connectReadThread;
            if (thread2 != null) {
                thread2.interrupt();
                this.connectReadThread = null;
            }
            this.draft.reset();
            Socket socket2 = this.socket;
            if (socket2 != null) {
                socket2.close();
                this.socket = null;
            }
            this.connectLatch = new CountDownLatch(1);
            this.closeLatch = new CountDownLatch(1);
            this.engine = new WebSocketImpl(this, this.draft);
        } catch (Exception e) {
            onError(e);
            this.engine.closeConnection(1006, e.getMessage());
        }
    }

    private void sendHandshake() throws InvalidHandshakeException {
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + jl1.CONDITION_IF + rawQuery;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append((port == 80 || port == 443) ? "" : ":" + port);
        String sb2 = sb.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(rawPath);
        handshakeImpl1Client.put(BizTime.HOST, sb2);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.startHandshake(handshakeImpl1Client);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void closeConnection(int i, String str) {
        this.engine.closeConnection(i, str);
    }

    public void connect() {
        if (this.connectReadThread == null) {
            Thread thread = new Thread(this);
            this.connectReadThread = thread;
            thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
            this.connectReadThread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public <T> T getAttachment() {
        return (T) this.engine.getAttachment();
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.AbstractWebSocket
    public Collection<WebSocket> getConnections() {
        return Collections.singletonList(this.engine);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            return (InetSocketAddress) socket2.getLocalSocketAddress();
        }
        return null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public ReadyState getReadyState() {
        return this.engine.getReadyState();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            return (InetSocketAddress) socket2.getRemoteSocketAddress();
        }
        return null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public boolean isClosed() {
        return this.engine.isClosed();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public boolean isClosing() {
        return this.engine.isClosing();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public abstract void onClose(int i, String str, boolean z);

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(ServerHandshake serverHandshake);

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        stopConnectionLostTimer();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        onClose(i, str, z);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        startConnectionLostTimer();
        onOpen((ServerHandshake) handshakedata);
        this.connectLatch.countDown();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }

    public void reconnect() {
        reset();
        connect();
    }

    public boolean reconnectBlocking() throws InterruptedException {
        reset();
        return connectBlocking();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e A[Catch:{ Exception -> 0x00e7 }] */
    public void run() {
        boolean z;
        byte[] bArr;
        int read;
        try {
            SocketFactory socketFactory2 = this.socketFactory;
            if (socketFactory2 != null) {
                this.socket = socketFactory2.createSocket();
            } else {
                Socket socket2 = this.socket;
                if (socket2 == null) {
                    this.socket = new Socket(this.proxy);
                    z = true;
                    this.socket.setTcpNoDelay(isTcpNoDelay());
                    this.socket.setReuseAddress(isReuseAddr());
                    if (!this.socket.isBound()) {
                        this.socket.connect(new InetSocketAddress(this.uri.getHost(), getPort()), this.connectTimeout);
                    }
                    if (z && "wss".equals(this.uri.getScheme())) {
                        SSLContext instance = SSLContext.getInstance("TLSv1.2");
                        instance.init(null, null, null);
                        this.socket = instance.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
                    }
                    InputStream inputStream = this.socket.getInputStream();
                    this.ostream = this.socket.getOutputStream();
                    sendHandshake();
                    Thread thread = new Thread(new WebsocketWriteThread(this));
                    this.writeThread = thread;
                    thread.start();
                    bArr = new byte[16384];
                    while (!isClosing() && !isClosed() && (read = inputStream.read(bArr)) != -1) {
                        try {
                            this.engine.decode(ByteBuffer.wrap(bArr, 0, read));
                        } catch (IOException e) {
                            handleIOException(e);
                        } catch (RuntimeException e2) {
                            onError(e2);
                            this.engine.closeConnection(1006, e2.getMessage());
                        }
                    }
                    this.engine.eot();
                    this.connectReadThread = null;
                } else if (socket2.isClosed()) {
                    throw new IOException();
                }
            }
            z = false;
            this.socket.setTcpNoDelay(isTcpNoDelay());
            this.socket.setReuseAddress(isReuseAddr());
            if (!this.socket.isBound()) {
            }
            SSLContext instance2 = SSLContext.getInstance("TLSv1.2");
            instance2.init(null, null, null);
            this.socket = instance2.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
            InputStream inputStream2 = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            sendHandshake();
            Thread thread2 = new Thread(new WebsocketWriteThread(this));
            this.writeThread = thread2;
            thread2.start();
            bArr = new byte[16384];
            while (!isClosing()) {
                this.engine.decode(ByteBuffer.wrap(bArr, 0, read));
            }
            this.engine.eot();
            this.connectReadThread = null;
        } catch (Exception e3) {
            onWebsocketError(this.engine, e3);
            this.engine.closeConnection(-1, e3.getMessage());
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void send(String str) {
        this.engine.send(str);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, z);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void sendPing() {
        this.engine.sendPing();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public <T> void setAttachment(T t) {
        this.engine.setAttachment(t);
    }

    public void setProxy(Proxy proxy2) {
        if (proxy2 != null) {
            this.proxy = proxy2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public void setSocket(Socket socket2) {
        if (this.socket == null) {
            this.socket = socket2;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void setSocketFactory(SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
    }

    public WebSocketClient(URI uri2, Draft draft2) {
        this(uri2, draft2, null, 0);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void send(byte[] bArr) {
        this.engine.send(bArr);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void sendFrame(Collection<Framedata> collection) {
        this.engine.sendFrame(collection);
    }

    public WebSocketClient(URI uri2, Map<String, String> map) {
        this(uri2, new Draft_6455(), map);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void close(int i) {
        this.engine.close(i);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) {
        this.engine.send(byteBuffer);
    }

    public WebSocketClient(URI uri2, Draft draft2, Map<String, String> map) {
        this(uri2, draft2, map, 0);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket
    public void close(int i, String str) {
        this.engine.close(i, str);
    }

    public boolean connectBlocking(long j, TimeUnit timeUnit) throws InterruptedException {
        connect();
        return this.connectLatch.await(j, timeUnit) && this.engine.isOpen();
    }

    public WebSocketClient(URI uri2, Draft draft2, Map<String, String> map, int i) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        if (uri2 == null) {
            throw new IllegalArgumentException();
        } else if (draft2 != null) {
            this.uri = uri2;
            this.draft = draft2;
            this.headers = map;
            this.connectTimeout = i;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.engine = new WebSocketImpl(this, draft2);
        } else {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
    }
}
