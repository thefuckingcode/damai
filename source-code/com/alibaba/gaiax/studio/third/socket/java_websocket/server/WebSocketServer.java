package com.alibaba.gaiax.studio.third.socket.java_websocket.server;

import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.AbstractWebSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.SocketChannelIOHelper;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocket;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketAdapter;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketImpl;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.WebsocketNotConnectedException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.ClientHandshake;
import com.alibaba.gaiax.studio.third.socket.java_websocket.handshake.Handshakedata;
import java.io.IOException;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Keep
/* compiled from: Taobao */
public abstract class WebSocketServer extends AbstractWebSocket implements Runnable {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final InetSocketAddress address;
    private BlockingQueue<ByteBuffer> buffers;
    private final Collection<WebSocket> connections;
    protected List<WebSocketWorker> decoders;
    private List<Draft> drafts;
    private List<WebSocketImpl> iqueue;
    private final AtomicBoolean isclosed;
    private int queueinvokes;
    private final AtomicInteger queuesize;
    private Selector selector;
    private Thread selectorthread;
    private ServerSocketChannel server;
    private WebSocketServerFactory wsf;

    @Keep
    /* compiled from: Taobao */
    public class WebSocketWorker extends Thread {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();

        /* compiled from: Taobao */
        class a implements Thread.UncaughtExceptionHandler {
            a(WebSocketWorker webSocketWorker, WebSocketServer webSocketServer) {
            }

            public void uncaughtException(Thread thread, Throwable th) {
                Log.e("[GaiaX]", "Uncaught exception in thread {}: {}");
            }
        }

        public WebSocketWorker() {
            setName("WebSocketWorker-" + getId());
            setUncaughtExceptionHandler(new a(this, WebSocketServer.this));
        }

        private void doDecode(WebSocketImpl webSocketImpl, ByteBuffer byteBuffer) throws InterruptedException {
            try {
                webSocketImpl.decode(byteBuffer);
            } catch (Exception e) {
                Log.e("[GaiaX]", "Error while reading from remote connection", e);
            } catch (Throwable th) {
                WebSocketServer.this.pushBuffer(byteBuffer);
                throw th;
            }
            WebSocketServer.this.pushBuffer(byteBuffer);
        }

        public void put(WebSocketImpl webSocketImpl) throws InterruptedException {
            this.iqueue.put(webSocketImpl);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:10:? A[ExcHandler: InterruptedException (unused java.lang.InterruptedException), SYNTHETIC, Splitter:B:1:0x0001] */
        public void run() {
            WebSocketImpl webSocketImpl;
            while (true) {
                try {
                    webSocketImpl = this.iqueue.take();
                    doDecode(webSocketImpl, webSocketImpl.inQueue.poll());
                } catch (InterruptedException unused) {
                } catch (RuntimeException e) {
                    webSocketImpl = null;
                    RuntimeException e2 = e;
                    WebSocketServer.this.handleFatal(webSocketImpl, e2);
                    return;
                }
            }
        }
    }

    public WebSocketServer() {
        this(new InetSocketAddress(80), AVAILABLE_PROCESSORS, null);
    }

    private void doAccept(SelectionKey selectionKey, Iterator<SelectionKey> it) throws IOException, InterruptedException {
        if (!onConnect(selectionKey)) {
            selectionKey.cancel();
            return;
        }
        SocketChannel accept = this.server.accept();
        if (accept != null) {
            accept.configureBlocking(false);
            Socket socket = accept.socket();
            socket.setTcpNoDelay(isTcpNoDelay());
            socket.setKeepAlive(true);
            WebSocketImpl createWebSocket = this.wsf.createWebSocket((WebSocketAdapter) this, this.drafts);
            createWebSocket.setSelectionKey(accept.register(this.selector, 1, createWebSocket));
            try {
                createWebSocket.setChannel(this.wsf.wrapChannel(accept, createWebSocket.getSelectionKey()));
                it.remove();
                allocateBuffers(createWebSocket);
            } catch (IOException e) {
                if (createWebSocket.getSelectionKey() != null) {
                    createWebSocket.getSelectionKey().cancel();
                }
                handleIOException(createWebSocket.getSelectionKey(), null, e);
            }
        }
    }

    private void doAdditionalRead() throws InterruptedException, IOException {
        while (!this.iqueue.isEmpty()) {
            WebSocketImpl remove = this.iqueue.remove(0);
            WrappedByteChannel wrappedByteChannel = (WrappedByteChannel) remove.getChannel();
            ByteBuffer takeBuffer = takeBuffer();
            try {
                if (SocketChannelIOHelper.readMore(takeBuffer, remove, wrappedByteChannel)) {
                    this.iqueue.add(remove);
                }
                if (takeBuffer.hasRemaining()) {
                    remove.inQueue.put(takeBuffer);
                    queue(remove);
                } else {
                    pushBuffer(takeBuffer);
                }
            } catch (IOException e) {
                pushBuffer(takeBuffer);
                throw e;
            }
        }
    }

    private void doBroadcast(Object obj, Collection<WebSocket> collection) {
        ByteBuffer byteBuffer = null;
        String str = obj instanceof String ? (String) obj : null;
        if (obj instanceof ByteBuffer) {
            byteBuffer = (ByteBuffer) obj;
        }
        if (!(str == null && byteBuffer == null)) {
            HashMap hashMap = new HashMap();
            for (WebSocket webSocket : collection) {
                if (webSocket != null) {
                    Draft draft = webSocket.getDraft();
                    fillFrames(draft, hashMap, str, byteBuffer);
                    try {
                        webSocket.sendFrame(hashMap.get(draft));
                    } catch (WebsocketNotConnectedException unused) {
                    }
                }
            }
        }
    }

    private boolean doEnsureSingleThread() {
        synchronized (this) {
            if (this.selectorthread == null) {
                this.selectorthread = Thread.currentThread();
                if (this.isclosed.get()) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException(getClass().getName() + " can only be started once.");
        }
    }

    private boolean doRead(SelectionKey selectionKey, Iterator<SelectionKey> it) throws InterruptedException, IOException {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        ByteBuffer takeBuffer = takeBuffer();
        if (webSocketImpl.getChannel() == null) {
            selectionKey.cancel();
            handleIOException(selectionKey, webSocketImpl, new IOException());
            return false;
        }
        try {
            if (!SocketChannelIOHelper.read(takeBuffer, webSocketImpl, webSocketImpl.getChannel())) {
                pushBuffer(takeBuffer);
                return true;
            } else if (takeBuffer.hasRemaining()) {
                webSocketImpl.inQueue.put(takeBuffer);
                queue(webSocketImpl);
                it.remove();
                if (!(webSocketImpl.getChannel() instanceof WrappedByteChannel) || !((WrappedByteChannel) webSocketImpl.getChannel()).isNeedRead()) {
                    return true;
                }
                this.iqueue.add(webSocketImpl);
                return true;
            } else {
                pushBuffer(takeBuffer);
                return true;
            }
        } catch (IOException e) {
            pushBuffer(takeBuffer);
            throw e;
        }
    }

    private void doServerShutdown() {
        stopConnectionLostTimer();
        List<WebSocketWorker> list = this.decoders;
        if (list != null) {
            for (WebSocketWorker webSocketWorker : list) {
                webSocketWorker.interrupt();
            }
        }
        Selector selector2 = this.selector;
        if (selector2 != null) {
            try {
                selector2.close();
            } catch (IOException e) {
                Log.e("[GaiaX]", "IOException during selector.close", e);
                onError(null, e);
            }
        }
        ServerSocketChannel serverSocketChannel = this.server;
        if (serverSocketChannel != null) {
            try {
                serverSocketChannel.close();
            } catch (IOException e2) {
                Log.e("[GaiaX]", "IOException during server.close", e2);
                onError(null, e2);
            }
        }
    }

    private boolean doSetupSelectorAndServerThread() {
        Thread thread = this.selectorthread;
        thread.setName("WebSocketSelector-" + this.selectorthread.getId());
        try {
            ServerSocketChannel open = ServerSocketChannel.open();
            this.server = open;
            open.configureBlocking(false);
            ServerSocket socket = this.server.socket();
            socket.setReceiveBufferSize(16384);
            socket.setReuseAddress(isReuseAddr());
            socket.bind(this.address);
            Selector open2 = Selector.open();
            this.selector = open2;
            ServerSocketChannel serverSocketChannel = this.server;
            serverSocketChannel.register(open2, serverSocketChannel.validOps());
            startConnectionLostTimer();
            for (WebSocketWorker webSocketWorker : this.decoders) {
                webSocketWorker.start();
            }
            onStart();
            return true;
        } catch (IOException e) {
            handleFatal(null, e);
            return false;
        }
    }

    private void doWrite(SelectionKey selectionKey) throws IOException {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        if (SocketChannelIOHelper.batch(webSocketImpl, webSocketImpl.getChannel()) && selectionKey.isValid()) {
            selectionKey.interestOps(1);
        }
    }

    private void fillFrames(Draft draft, Map<Draft, List<Framedata>> map, String str, ByteBuffer byteBuffer) {
        if (!map.containsKey(draft)) {
            List<Framedata> list = null;
            if (str != null) {
                list = draft.createFrames(str, false);
            }
            if (byteBuffer != null) {
                list = draft.createFrames(byteBuffer, false);
            }
            if (list != null) {
                map.put(draft, list);
            }
        }
    }

    private Socket getSocket(WebSocket webSocket) {
        return ((SocketChannel) ((WebSocketImpl) webSocket).getSelectionKey().channel()).socket();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleFatal(WebSocket webSocket, Exception exc) {
        Log.e("[GaiaX]", "Shutdown due to fatal error", exc);
        onError(webSocket, exc);
        List<WebSocketWorker> list = this.decoders;
        if (list != null) {
            for (WebSocketWorker webSocketWorker : list) {
                webSocketWorker.interrupt();
            }
        }
        Thread thread = this.selectorthread;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            stop();
        } catch (IOException e) {
            Log.e("[GaiaX]", "Error during shutdown", e);
            onError(null, e);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            Log.e("[GaiaX]", "Interrupt during stop", exc);
            onError(null, e2);
        }
    }

    private void handleIOException(SelectionKey selectionKey, WebSocket webSocket, IOException iOException) {
        SelectableChannel channel;
        if (webSocket != null) {
            webSocket.closeConnection(1006, iOException.getMessage());
        } else if (selectionKey != null && (channel = selectionKey.channel()) != null && channel.isOpen()) {
            try {
                channel.close();
            } catch (IOException unused) {
            }
            Log.e("[GaiaX]", "Connection closed because of exception", iOException);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pushBuffer(ByteBuffer byteBuffer) throws InterruptedException {
        if (this.buffers.size() <= this.queuesize.intValue()) {
            this.buffers.put(byteBuffer);
        }
    }

    private ByteBuffer takeBuffer() throws InterruptedException {
        return this.buffers.take();
    }

    /* access modifiers changed from: protected */
    public boolean addConnection(WebSocket webSocket) {
        boolean add;
        if (!this.isclosed.get()) {
            synchronized (this.connections) {
                add = this.connections.add(webSocket);
            }
            return add;
        }
        webSocket.close(1001);
        return true;
    }

    /* access modifiers changed from: protected */
    public void allocateBuffers(WebSocket webSocket) throws InterruptedException {
        if (this.queuesize.get() < (this.decoders.size() * 2) + 1) {
            this.queuesize.incrementAndGet();
            this.buffers.put(createBuffer());
        }
    }

    public void broadcast(String str) {
        broadcast(str, this.connections);
    }

    public ByteBuffer createBuffer() {
        return ByteBuffer.allocate(16384);
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.AbstractWebSocket
    public Collection<WebSocket> getConnections() {
        return Collections.unmodifiableCollection(new ArrayList(this.connections));
    }

    public List<Draft> getDraft() {
        return Collections.unmodifiableList(this.drafts);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getLocalSocketAddress();
    }

    public int getPort() {
        ServerSocketChannel serverSocketChannel;
        int port = getAddress().getPort();
        return (port != 0 || (serverSocketChannel = this.server) == null) ? port : serverSocketChannel.socket().getLocalPort();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getRemoteSocketAddress();
    }

    public final WebSocketFactory getWebSocketFactory() {
        return this.wsf;
    }

    public abstract void onClose(WebSocket webSocket, int i, String str, boolean z);

    public void onCloseInitiated(WebSocket webSocket, int i, String str) {
    }

    public void onClosing(WebSocket webSocket, int i, String str, boolean z) {
    }

    /* access modifiers changed from: protected */
    public boolean onConnect(SelectionKey selectionKey) {
        return true;
    }

    public abstract void onError(WebSocket webSocket, Exception exc);

    public abstract void onMessage(WebSocket webSocket, String str);

    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(WebSocket webSocket, ClientHandshake clientHandshake);

    public abstract void onStart();

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        this.selector.wakeup();
        try {
            if (removeConnection(webSocket)) {
                onClose(webSocket, i, str, z);
            }
        } finally {
            try {
                releaseBuffers(webSocket);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(webSocket, i, str);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(webSocket, i, str, z);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(webSocket, exc);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(webSocket, str);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        if (addConnection(webSocket)) {
            onOpen(webSocket, (ClientHandshake) handshakedata);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
        try {
            webSocketImpl.getSelectionKey().interestOps(5);
        } catch (CancelledKeyException unused) {
            webSocketImpl.outQueue.clear();
        }
        this.selector.wakeup();
    }

    /* access modifiers changed from: protected */
    public void queue(WebSocketImpl webSocketImpl) throws InterruptedException {
        if (webSocketImpl.getWorkerThread() == null) {
            List<WebSocketWorker> list = this.decoders;
            webSocketImpl.setWorkerThread(list.get(this.queueinvokes % list.size()));
            this.queueinvokes++;
        }
        webSocketImpl.getWorkerThread().put(webSocketImpl);
    }

    /* access modifiers changed from: protected */
    public void releaseBuffers(WebSocket webSocket) throws InterruptedException {
    }

    /* access modifiers changed from: protected */
    public boolean removeConnection(WebSocket webSocket) {
        boolean z;
        synchronized (this.connections) {
            if (this.connections.contains(webSocket)) {
                z = this.connections.remove(webSocket);
            } else {
                Log.e("[GaiaX]", "Removing connection which is not in the connections collection! Possible no handshake recieved! {}");
                z = false;
            }
        }
        if (this.isclosed.get() && this.connections.isEmpty()) {
            this.selectorthread.interrupt();
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0078, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0079, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007f, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0081, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008e, code lost:
        r5.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0096, code lost:
        doServerShutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0099, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[ExcHandler: InterruptedException (unused java.lang.InterruptedException), PHI: r0 r2 
      PHI: (r0v8 int) = (r0v3 int), (r0v9 int), (r0v9 int) binds: [B:13:0x001c, B:24:0x0043, B:28:0x004f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v4 int) = (r2v1 int), (r2v5 int), (r2v5 int) binds: [B:13:0x001c, B:24:0x0043, B:28:0x004f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:13:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ExcHandler: ClosedByInterruptException (unused java.nio.channels.ClosedByInterruptException), SYNTHETIC, Splitter:B:13:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[ExcHandler: CancelledKeyException (unused java.nio.channels.CancelledKeyException), PHI: r0 r2 
      PHI: (r0v11 int) = (r0v3 int), (r0v9 int), (r0v9 int) binds: [B:13:0x001c, B:24:0x0043, B:28:0x004f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v7 int) = (r2v1 int), (r2v5 int), (r2v5 int) binds: [B:13:0x001c, B:24:0x0043, B:28:0x004f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:13:0x001c] */
    public void run() {
        SelectionKey selectionKey;
        if (doEnsureSingleThread() && doSetupSelectorAndServerThread()) {
            int i = 0;
            int i2 = 5;
            while (!this.selectorthread.isInterrupted() && i2 != 0) {
                try {
                    try {
                        if (this.isclosed.get()) {
                            i = 5;
                        }
                        if (this.selector.select((long) i) == 0 && this.isclosed.get()) {
                            i2--;
                        }
                        Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                        selectionKey = null;
                        while (it.hasNext()) {
                            SelectionKey next = it.next();
                            if (next.isValid()) {
                                if (next.isAcceptable()) {
                                    doAccept(next, it);
                                } else if (!next.isReadable() || doRead(next, it)) {
                                    if (next.isWritable()) {
                                        doWrite(next);
                                    }
                                }
                            }
                            selectionKey = next;
                        }
                        doAdditionalRead();
                    } catch (CancelledKeyException unused) {
                    } catch (ClosedByInterruptException unused2) {
                    } catch (IOException e) {
                        IOException e2 = e;
                        selectionKey = null;
                        if (selectionKey != null) {
                        }
                        handleIOException(selectionKey, null, e2);
                    } catch (InterruptedException unused3) {
                    }
                } catch (RuntimeException e3) {
                    handleFatal(null, e3);
                } catch (Throwable th) {
                    doServerShutdown();
                    throw th;
                }
            }
            doServerShutdown();
        }
    }

    public final void setWebSocketFactory(WebSocketServerFactory webSocketServerFactory) {
        WebSocketServerFactory webSocketServerFactory2 = this.wsf;
        if (webSocketServerFactory2 != null) {
            webSocketServerFactory2.close();
        }
        this.wsf = webSocketServerFactory;
    }

    public void start() {
        if (this.selectorthread == null) {
            new Thread(this).start();
            return;
        }
        throw new IllegalStateException(getClass().getName() + " can only be started once.");
    }

    public void stop(int i) throws InterruptedException {
        ArrayList<WebSocket> arrayList;
        Selector selector2;
        if (this.isclosed.compareAndSet(false, true)) {
            synchronized (this.connections) {
                arrayList = new ArrayList(this.connections);
            }
            for (WebSocket webSocket : arrayList) {
                webSocket.close(1001);
            }
            this.wsf.close();
            synchronized (this) {
                if (!(this.selectorthread == null || (selector2 = this.selector) == null)) {
                    selector2.wakeup();
                    this.selectorthread.join((long) i);
                }
            }
        }
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, null);
    }

    public void broadcast(byte[] bArr) {
        broadcast(bArr, this.connections);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(webSocket, byteBuffer);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i) {
        this(inetSocketAddress, i, null);
    }

    public void broadcast(ByteBuffer byteBuffer) {
        broadcast(byteBuffer, this.connections);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, List<Draft> list) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, list);
    }

    public void broadcast(byte[] bArr, Collection<WebSocket> collection) {
        if (bArr == null || collection == null) {
            throw new IllegalArgumentException();
        }
        broadcast(ByteBuffer.wrap(bArr), collection);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i, List<Draft> list) {
        this(inetSocketAddress, i, list, new HashSet());
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i, List<Draft> list, Collection<WebSocket> collection) {
        this.isclosed = new AtomicBoolean(false);
        this.queueinvokes = 0;
        this.queuesize = new AtomicInteger(0);
        this.wsf = new DefaultWebSocketServerFactory();
        if (inetSocketAddress == null || i < 1 || collection == null) {
            throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
        }
        if (list == null) {
            this.drafts = Collections.emptyList();
        } else {
            this.drafts = list;
        }
        this.address = inetSocketAddress;
        this.connections = collection;
        setTcpNoDelay(false);
        setReuseAddr(false);
        this.iqueue = new LinkedList();
        this.decoders = new ArrayList(i);
        this.buffers = new LinkedBlockingQueue();
        for (int i2 = 0; i2 < i; i2++) {
            this.decoders.add(new WebSocketWorker());
        }
    }

    public void broadcast(ByteBuffer byteBuffer, Collection<WebSocket> collection) {
        if (byteBuffer == null || collection == null) {
            throw new IllegalArgumentException();
        }
        doBroadcast(byteBuffer, collection);
    }

    public void broadcast(String str, Collection<WebSocket> collection) {
        if (str == null || collection == null) {
            throw new IllegalArgumentException();
        }
        doBroadcast(str, collection);
    }

    public void stop() throws IOException, InterruptedException {
        stop(0);
    }
}
