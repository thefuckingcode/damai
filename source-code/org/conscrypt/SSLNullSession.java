package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* access modifiers changed from: package-private */
public final class SSLNullSession implements ConscryptSession, Cloneable {
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    private long creationTime;
    private long lastAccessedTime;

    public int getApplicationBufferSize() {
        return 16384;
    }

    public String getCipherSuite() {
        return INVALID_CIPHER;
    }

    public Certificate[] getLocalCertificates() {
        return null;
    }

    public Principal getLocalPrincipal() {
        return null;
    }

    public int getPacketBufferSize() {
        return 16709;
    }

    public String getPeerHost() {
        return null;
    }

    public int getPeerPort() {
        return -1;
    }

    public String getProtocol() {
        return "NONE";
    }

    @Override // org.conscrypt.ConscryptSession
    public String getRequestedServerName() {
        return null;
    }

    public SSLSessionContext getSessionContext() {
        return null;
    }

    public void invalidate() {
    }

    public boolean isValid() {
        return false;
    }

    /* access modifiers changed from: private */
    public static class DefaultHolder {
        static final SSLNullSession NULL_SESSION = new SSLNullSession();

        private DefaultHolder() {
        }
    }

    static ConscryptSession getNullSession() {
        return DefaultHolder.NULL_SESSION;
    }

    private SSLNullSession() {
        long currentTimeMillis = System.currentTimeMillis();
        this.creationTime = currentTimeMillis;
        this.lastAccessedTime = currentTimeMillis;
    }

    @Override // org.conscrypt.ConscryptSession
    public List<byte[]> getStatusResponses() {
        return Collections.emptyList();
    }

    @Override // org.conscrypt.ConscryptSession
    public byte[] getPeerSignedCertificateTimestamp() {
        return EmptyArray.BYTE;
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public byte[] getId() {
        return EmptyArray.BYTE;
    }

    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    @Override // javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificate");
    }

    @Override // org.conscrypt.ConscryptSession, javax.net.ssl.SSLSession
    public java.security.cert.X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificate");
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificate");
    }

    public Object getValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    public String[] getValueNames() {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    public void putValue(String str, Object obj) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    public void removeValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }
}
