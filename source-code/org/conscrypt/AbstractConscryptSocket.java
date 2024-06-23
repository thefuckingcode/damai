package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* access modifiers changed from: package-private */
public abstract class AbstractConscryptSocket extends SSLSocket {
    private final boolean autoClose;
    private final List<HandshakeCompletedListener> listeners;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final int peerPort;
    private int readTimeoutMilliseconds;
    final Socket socket;

    /* access modifiers changed from: package-private */
    public abstract byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException;

    /* access modifiers changed from: package-private */
    public abstract SSLSession getActiveSession();

    /* access modifiers changed from: package-private */
    @Deprecated
    public abstract byte[] getAlpnSelectedProtocol();

    public abstract String getApplicationProtocol();

    /* access modifiers changed from: package-private */
    public abstract String[] getApplicationProtocols();

    public SocketChannel getChannel() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] getChannelId() throws SSLException;

    public abstract String getHandshakeApplicationProtocol();

    public abstract SSLSession getHandshakeSession();

    /* access modifiers changed from: package-private */
    @Deprecated
    public byte[] getNpnSelectedProtocol() {
        return null;
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getSoWriteTimeout() throws SocketException {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] getTlsUnique();

    /* access modifiers changed from: package-private */
    @Deprecated
    public abstract void setAlpnProtocols(byte[] bArr);

    /* access modifiers changed from: package-private */
    @Deprecated
    public abstract void setAlpnProtocols(String[] strArr);

    /* access modifiers changed from: package-private */
    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector);

    /* access modifiers changed from: package-private */
    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter);

    /* access modifiers changed from: package-private */
    public abstract void setApplicationProtocols(String[] strArr);

    /* access modifiers changed from: package-private */
    public abstract void setChannelIdEnabled(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    /* access modifiers changed from: package-private */
    @Deprecated
    public void setNpnProtocols(byte[] bArr) {
    }

    /* access modifiers changed from: package-private */
    public abstract void setUseSessionTickets(boolean z);

    AbstractConscryptSocket() throws IOException {
        this.peerInfoProvider = new PeerInfoProvider() {
            /* class org.conscrypt.AbstractConscryptSocket.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    AbstractConscryptSocket(String str, int i) throws IOException {
        super(str, i);
        this.peerInfoProvider = new PeerInfoProvider() {
            /* class org.conscrypt.AbstractConscryptSocket.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
    }

    AbstractConscryptSocket(InetAddress inetAddress, int i) throws IOException {
        super(inetAddress, i);
        this.peerInfoProvider = new PeerInfoProvider() {
            /* class org.conscrypt.AbstractConscryptSocket.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    AbstractConscryptSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        super(str, i, inetAddress, i2);
        this.peerInfoProvider = new PeerInfoProvider() {
            /* class org.conscrypt.AbstractConscryptSocket.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
    }

    AbstractConscryptSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.peerInfoProvider = new PeerInfoProvider() {
            /* class org.conscrypt.AbstractConscryptSocket.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    AbstractConscryptSocket(Socket socket2, String str, int i, boolean z) throws IOException {
        this.peerInfoProvider = new PeerInfoProvider() {
            /* class org.conscrypt.AbstractConscryptSocket.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = z;
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        connect(socketAddress, 0);
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        if (this.peerHostname == null && (socketAddress instanceof InetSocketAddress)) {
            this.peerHostname = Platform.getHostStringFromInetSocketAddress((InetSocketAddress) socketAddress);
        }
        if (isDelegating()) {
            this.socket.connect(socketAddress, i);
        } else {
            super.connect(socketAddress, i);
        }
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        if (isDelegating()) {
            this.socket.bind(socketAddress);
        } else {
            super.bind(socketAddress);
        }
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isDelegating()) {
            if (this.autoClose && !this.socket.isClosed()) {
                this.socket.close();
            }
        } else if (!super.isClosed()) {
            super.close();
        }
    }

    public InetAddress getInetAddress() {
        if (isDelegating()) {
            return this.socket.getInetAddress();
        }
        return super.getInetAddress();
    }

    public InetAddress getLocalAddress() {
        if (isDelegating()) {
            return this.socket.getLocalAddress();
        }
        return super.getLocalAddress();
    }

    public int getLocalPort() {
        if (isDelegating()) {
            return this.socket.getLocalPort();
        }
        return super.getLocalPort();
    }

    public SocketAddress getRemoteSocketAddress() {
        if (isDelegating()) {
            return this.socket.getRemoteSocketAddress();
        }
        return super.getRemoteSocketAddress();
    }

    public SocketAddress getLocalSocketAddress() {
        if (isDelegating()) {
            return this.socket.getLocalSocketAddress();
        }
        return super.getLocalSocketAddress();
    }

    public final int getPort() {
        if (isDelegating()) {
            return this.socket.getPort();
        }
        int i = this.peerPort;
        if (i != -1) {
            return i;
        }
        return super.getPort();
    }

    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        this.listeners.add(handshakeCompletedListener);
    }

    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        if (!this.listeners.remove(handshakeCompletedListener)) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
    }

    public FileDescriptor getFileDescriptor$() {
        if (isDelegating()) {
            return Platform.getFileDescriptor(this.socket);
        }
        return Platform.getFileDescriptorFromSSLSocket(this);
    }

    @Override // java.net.Socket
    public final void setSoTimeout(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setSoTimeout(i);
            return;
        }
        super.setSoTimeout(i);
        this.readTimeoutMilliseconds = i;
    }

    @Override // java.net.Socket
    public final int getSoTimeout() throws SocketException {
        if (isDelegating()) {
            return this.socket.getSoTimeout();
        }
        return this.readTimeoutMilliseconds;
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i) throws IOException {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) throws SocketException {
        throw new SocketException("Method setOOBInline() is not supported.");
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        if (isDelegating()) {
            return this.socket.getInputStream();
        }
        return super.getInputStream();
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        if (isDelegating()) {
            return this.socket.getOutputStream();
        }
        return super.getOutputStream();
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setTcpNoDelay(z);
        } else {
            super.setTcpNoDelay(z);
        }
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        if (isDelegating()) {
            return this.socket.getTcpNoDelay();
        }
        return super.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setSoLinger(z, i);
        } else {
            super.setSoLinger(z, i);
        }
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        if (isDelegating()) {
            return this.socket.getSoLinger();
        }
        return super.getSoLinger();
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setSendBufferSize(i);
        } else {
            super.setSendBufferSize(i);
        }
    }

    @Override // java.net.Socket
    public int getSendBufferSize() throws SocketException {
        if (isDelegating()) {
            return this.socket.getSendBufferSize();
        }
        return super.getSendBufferSize();
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setReceiveBufferSize(i);
        } else {
            super.setReceiveBufferSize(i);
        }
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() throws SocketException {
        if (isDelegating()) {
            return this.socket.getReceiveBufferSize();
        }
        return super.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setKeepAlive(z);
        } else {
            super.setKeepAlive(z);
        }
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        if (isDelegating()) {
            return this.socket.getKeepAlive();
        }
        return super.getKeepAlive();
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setTrafficClass(i);
        } else {
            super.setTrafficClass(i);
        }
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        if (isDelegating()) {
            return this.socket.getTrafficClass();
        }
        return super.getTrafficClass();
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setReuseAddress(z);
        } else {
            super.setReuseAddress(z);
        }
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        if (isDelegating()) {
            return this.socket.getReuseAddress();
        }
        return super.getReuseAddress();
    }

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        if (isDelegating()) {
            this.socket.shutdownInput();
        } else {
            super.shutdownInput();
        }
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        if (isDelegating()) {
            this.socket.shutdownOutput();
        } else {
            super.shutdownOutput();
        }
    }

    public boolean isConnected() {
        if (isDelegating()) {
            return this.socket.isConnected();
        }
        return super.isConnected();
    }

    public boolean isBound() {
        if (isDelegating()) {
            return this.socket.isBound();
        }
        return super.isBound();
    }

    public boolean isClosed() {
        if (isDelegating()) {
            return this.socket.isClosed();
        }
        return super.isClosed();
    }

    public boolean isInputShutdown() {
        if (isDelegating()) {
            return this.socket.isInputShutdown();
        }
        return super.isInputShutdown();
    }

    public boolean isOutputShutdown() {
        if (isDelegating()) {
            return this.socket.isOutputShutdown();
        }
        return super.isOutputShutdown();
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
        if (isDelegating()) {
            this.socket.setPerformancePreferences(i, i2, i3);
        } else {
            super.setPerformancePreferences(i, i2, i3);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SSL socket over ");
        if (isDelegating()) {
            sb.append(this.socket.toString());
        } else {
            sb.append(super.toString());
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public String getHostname() {
        return this.peerHostname;
    }

    /* access modifiers changed from: package-private */
    public void setHostname(String str) {
        this.peerHostname = str;
    }

    /* access modifiers changed from: package-private */
    public String getHostnameOrIP() {
        String str = this.peerHostname;
        if (str != null) {
            return str;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return Platform.getOriginalHostNameFromInetAddress(inetAddress);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setSoWriteTimeout(int i) throws SocketException {
        throw new SocketException("Method setSoWriteTimeout() is not supported.");
    }

    /* access modifiers changed from: package-private */
    public void setHandshakeTimeout(int i) throws SocketException {
        throw new SocketException("Method setHandshakeTimeout() is not supported.");
    }

    /* access modifiers changed from: package-private */
    public final void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    /* access modifiers changed from: package-private */
    public final PeerInfoProvider peerInfoProvider() {
        return this.peerInfoProvider;
    }

    /* access modifiers changed from: package-private */
    public final void notifyHandshakeCompletedListeners() {
        List<HandshakeCompletedListener> list = this.listeners;
        if (!(list == null || list.isEmpty())) {
            HandshakeCompletedEvent handshakeCompletedEvent = new HandshakeCompletedEvent(this, getActiveSession());
            for (HandshakeCompletedListener handshakeCompletedListener : this.listeners) {
                try {
                    handshakeCompletedListener.handshakeCompleted(handshakeCompletedEvent);
                } catch (RuntimeException e) {
                    Thread currentThread = Thread.currentThread();
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e);
                }
            }
        }
    }

    private boolean isDelegating() {
        Socket socket2 = this.socket;
        return (socket2 == null || socket2 == this) ? false : true;
    }
}
