package org.conscrypt;

import com.android.org.conscrypt.OpenSSLSocketImpl;
import com.android.org.conscrypt.SSLParametersImpl;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

public class KitKatPlatformOpenSSLSocketImplAdapter extends OpenSSLSocketImpl {
    private final AbstractConscryptSocket delegate;

    public KitKatPlatformOpenSSLSocketImplAdapter(AbstractConscryptSocket abstractConscryptSocket) throws IOException {
        super((SSLParametersImpl) null);
        this.delegate = abstractConscryptSocket;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    public int getLocalPort() {
        return this.delegate.getLocalPort();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    public int getPort() {
        return this.delegate.getPort();
    }

    public void connect(SocketAddress socketAddress, int i) throws IOException {
        this.delegate.connect(socketAddress, i);
    }

    public void connect(SocketAddress socketAddress) throws IOException {
        this.delegate.connect(socketAddress);
    }

    public void bind(SocketAddress socketAddress) throws IOException {
        this.delegate.bind(socketAddress);
    }

    public SocketAddress getRemoteSocketAddress() {
        return this.delegate.getRemoteSocketAddress();
    }

    public SocketAddress getLocalSocketAddress() {
        return this.delegate.getLocalSocketAddress();
    }

    public InetAddress getLocalAddress() {
        return this.delegate.getLocalAddress();
    }

    public InetAddress getInetAddress() {
        return this.delegate.getInetAddress();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public void setSoLinger(boolean z, int i) throws SocketException {
        this.delegate.setSoLinger(z, i);
    }

    public void setTcpNoDelay(boolean z) throws SocketException {
        this.delegate.setTcpNoDelay(z);
    }

    public void setReuseAddress(boolean z) throws SocketException {
        this.delegate.setReuseAddress(z);
    }

    public void setKeepAlive(boolean z) throws SocketException {
        this.delegate.setKeepAlive(z);
    }

    public void setTrafficClass(int i) throws SocketException {
        this.delegate.setTrafficClass(i);
    }

    public void setSoTimeout(int i) throws SocketException {
        this.delegate.setSoTimeout(i);
    }

    public void setSendBufferSize(int i) throws SocketException {
        this.delegate.setSendBufferSize(i);
    }

    public void setReceiveBufferSize(int i) throws SocketException {
        this.delegate.setReceiveBufferSize(i);
    }

    public boolean getTcpNoDelay() throws SocketException {
        return this.delegate.getTcpNoDelay();
    }

    public boolean getReuseAddress() throws SocketException {
        return this.delegate.getReuseAddress();
    }

    public boolean getKeepAlive() throws SocketException {
        return this.delegate.getKeepAlive();
    }

    public int getSoTimeout() throws SocketException {
        return this.delegate.getSoTimeout();
    }

    public int getSoLinger() throws SocketException {
        return this.delegate.getSoLinger();
    }

    public int getSendBufferSize() throws SocketException {
        return this.delegate.getSendBufferSize();
    }

    public int getReceiveBufferSize() throws SocketException {
        return this.delegate.getReceiveBufferSize();
    }

    public boolean isConnected() {
        return this.delegate.isConnected();
    }

    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    public boolean isBound() {
        return this.delegate.isBound();
    }

    public boolean isOutputShutdown() {
        return this.delegate.isOutputShutdown();
    }

    public boolean isInputShutdown() {
        return this.delegate.isInputShutdown();
    }

    public void shutdownInput() throws IOException {
        this.delegate.shutdownInput();
    }

    public void shutdownOutput() throws IOException {
        this.delegate.shutdownOutput();
    }

    public void setOOBInline(boolean z) throws SocketException {
        this.delegate.setOOBInline(z);
    }

    public boolean getOOBInline() throws SocketException {
        return this.delegate.getOOBInline();
    }

    public int getTrafficClass() throws SocketException {
        return this.delegate.getTrafficClass();
    }

    public void sendUrgentData(int i) throws IOException {
        this.delegate.sendUrgentData(i);
    }

    public SocketChannel getChannel() {
        return this.delegate.getChannel();
    }

    public FileDescriptor getFileDescriptor$() {
        return this.delegate.getFileDescriptor$();
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
        this.delegate.setPerformancePreferences(i, i2, i3);
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public String[] getEnabledCipherSuites() {
        return this.delegate.getEnabledCipherSuites();
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.delegate.setEnabledCipherSuites(strArr);
    }

    public String[] getSupportedProtocols() {
        return this.delegate.getSupportedProtocols();
    }

    public String[] getEnabledProtocols() {
        return this.delegate.getEnabledProtocols();
    }

    public void setEnabledProtocols(String[] strArr) {
        this.delegate.setEnabledProtocols(strArr);
    }

    public SSLSession getSession() {
        return this.delegate.getSession();
    }

    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.delegate.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.delegate.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public void startHandshake() throws IOException {
        this.delegate.startHandshake();
    }

    public void setUseClientMode(boolean z) {
        this.delegate.setUseClientMode(z);
    }

    public boolean getUseClientMode() {
        return this.delegate.getUseClientMode();
    }

    public void setNeedClientAuth(boolean z) {
        this.delegate.setNeedClientAuth(z);
    }

    public void setWantClientAuth(boolean z) {
        this.delegate.setWantClientAuth(z);
    }

    public boolean getNeedClientAuth() {
        return this.delegate.getNeedClientAuth();
    }

    public boolean getWantClientAuth() {
        return this.delegate.getWantClientAuth();
    }

    public void setEnableSessionCreation(boolean z) {
        this.delegate.setEnableSessionCreation(z);
    }

    public boolean getEnableSessionCreation() {
        return this.delegate.getEnableSessionCreation();
    }

    public SSLParameters getSSLParameters() {
        return this.delegate.getSSLParameters();
    }

    public void setSSLParameters(SSLParameters sSLParameters) {
        this.delegate.setSSLParameters(sSLParameters);
    }

    public void clientCertificateRequested(byte[] bArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        throw new RuntimeException("Shouldn't be here!");
    }

    public void handshakeCompleted() {
        throw new RuntimeException("Shouldn't be here!");
    }

    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        throw new RuntimeException("Shouldn't be here!");
    }

    public void setUseSessionTickets(boolean z) {
        this.delegate.setUseSessionTickets(z);
    }

    public void setHostname(String str) {
        this.delegate.setHostname(str);
    }

    public void setChannelIdEnabled(boolean z) {
        this.delegate.setChannelIdEnabled(z);
    }

    public byte[] getChannelId() throws SSLException {
        return this.delegate.getChannelId();
    }

    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.delegate.setChannelIdPrivateKey(privateKey);
    }

    public void setSoWriteTimeout(int i) throws SocketException {
        this.delegate.setSoWriteTimeout(i);
    }

    public int getSoWriteTimeout() throws SocketException {
        return this.delegate.getSoWriteTimeout();
    }

    public void setHandshakeTimeout(int i) throws SocketException {
        this.delegate.setHandshakeTimeout(i);
    }

    public byte[] getNpnSelectedProtocol() {
        return this.delegate.getNpnSelectedProtocol();
    }

    public void setNpnProtocols(byte[] bArr) {
        this.delegate.setNpnProtocols(bArr);
    }

    public byte[] getAlpnSelectedProtocol() {
        return this.delegate.getAlpnSelectedProtocol();
    }

    public void setAlpnProtocols(byte[] bArr) {
        this.delegate.setAlpnProtocols(bArr);
    }
}
