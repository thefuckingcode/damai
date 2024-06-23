package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public abstract class OpenSSLSocketImpl extends AbstractConscryptSocket {
    @Override // org.conscrypt.AbstractConscryptSocket
    public abstract byte[] getChannelId() throws SSLException;

    @Override // org.conscrypt.AbstractConscryptSocket
    public abstract SSLSession getHandshakeSession();

    @Override // org.conscrypt.AbstractConscryptSocket
    public abstract void setChannelIdEnabled(boolean z);

    @Override // org.conscrypt.AbstractConscryptSocket
    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    @Override // org.conscrypt.AbstractConscryptSocket
    public abstract void setUseSessionTickets(boolean z);

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        super.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void bind(SocketAddress socketAddress) throws IOException {
        super.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, org.conscrypt.AbstractConscryptSocket, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ SocketChannel getChannel() {
        return super.getChannel();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ InetAddress getInetAddress() {
        return super.getInetAddress();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ InputStream getInputStream() throws IOException {
        return super.getInputStream();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean getKeepAlive() throws SocketException {
        return super.getKeepAlive();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ InetAddress getLocalAddress() {
        return super.getLocalAddress();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ int getLocalPort() {
        return super.getLocalPort();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ SocketAddress getLocalSocketAddress() {
        return super.getLocalSocketAddress();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean getOOBInline() throws SocketException {
        return super.getOOBInline();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ OutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ int getReceiveBufferSize() throws SocketException {
        return super.getReceiveBufferSize();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ SocketAddress getRemoteSocketAddress() {
        return super.getRemoteSocketAddress();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean getReuseAddress() throws SocketException {
        return super.getReuseAddress();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ int getSendBufferSize() throws SocketException {
        return super.getSendBufferSize();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ int getSoLinger() throws SocketException {
        return super.getSoLinger();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean getTcpNoDelay() throws SocketException {
        return super.getTcpNoDelay();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ int getTrafficClass() throws SocketException {
        return super.getTrafficClass();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean isBound() {
        return super.isBound();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean isClosed() {
        return super.isClosed();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean isInputShutdown() {
        return super.isInputShutdown();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ boolean isOutputShutdown() {
        return super.isOutputShutdown();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        super.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setKeepAlive(boolean z) throws SocketException {
        super.setKeepAlive(z);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setPerformancePreferences(int i, int i2, int i3) {
        super.setPerformancePreferences(i, i2, i3);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setReceiveBufferSize(int i) throws SocketException {
        super.setReceiveBufferSize(i);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setReuseAddress(boolean z) throws SocketException {
        super.setReuseAddress(z);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setSendBufferSize(int i) throws SocketException {
        super.setSendBufferSize(i);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setSoLinger(boolean z, int i) throws SocketException {
        super.setSoLinger(z, i);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setTcpNoDelay(boolean z) throws SocketException {
        super.setTcpNoDelay(z);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void setTrafficClass(int i) throws SocketException {
        super.setTrafficClass(i);
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void shutdownInput() throws IOException {
        super.shutdownInput();
    }

    @Override // java.net.Socket, org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ void shutdownOutput() throws IOException {
        super.shutdownOutput();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    OpenSSLSocketImpl() throws IOException {
    }

    OpenSSLSocketImpl(String str, int i) throws IOException {
        super(str, i);
    }

    OpenSSLSocketImpl(InetAddress inetAddress, int i) throws IOException {
        super(inetAddress, i);
    }

    OpenSSLSocketImpl(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        super(str, i, inetAddress, i2);
    }

    OpenSSLSocketImpl(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
    }

    OpenSSLSocketImpl(Socket socket, String str, int i, boolean z) throws IOException {
        super(socket, str, i, z);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public String getHostname() {
        return super.getHostname();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public void setHostname(String str) {
        super.setHostname(str);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public String getHostnameOrIP() {
        return super.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public FileDescriptor getFileDescriptor$() {
        return super.getFileDescriptor$();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public void setSoWriteTimeout(int i) throws SocketException {
        super.setSoWriteTimeout(i);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public int getSoWriteTimeout() throws SocketException {
        return super.getSoWriteTimeout();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public void setHandshakeTimeout(int i) throws SocketException {
        super.setHandshakeTimeout(i);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    @Deprecated
    public final byte[] getNpnSelectedProtocol() {
        return super.getNpnSelectedProtocol();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    @Deprecated
    public final void setNpnProtocols(byte[] bArr) {
        super.setNpnProtocols(bArr);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    @Deprecated
    public final void setAlpnProtocols(String[] strArr) {
        if (strArr == null) {
            strArr = EmptyArray.STRING;
        }
        setApplicationProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    @Deprecated
    public final byte[] getAlpnSelectedProtocol() {
        return SSLUtils.toProtocolBytes(getApplicationProtocol());
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    @Deprecated
    public final void setAlpnProtocols(byte[] bArr) {
        if (bArr == null) {
            bArr = EmptyArray.BYTE;
        }
        setApplicationProtocols(SSLUtils.decodeProtocols(bArr));
    }
}
