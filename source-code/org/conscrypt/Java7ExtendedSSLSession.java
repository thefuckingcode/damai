package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;

class Java7ExtendedSSLSession extends ExtendedSSLSession implements ConscryptSession {
    private static final String[] LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS = {"SHA512withRSA", "SHA512withECDSA", "SHA384withRSA", "SHA384withECDSA", "SHA256withRSA", "SHA256withECDSA", "SHA224withRSA", "SHA224withECDSA", "SHA1withRSA", "SHA1withECDSA"};
    private static final String[] PEER_SUPPORTED_SIGNATURE_ALGORITHMS = {"SHA1withRSA", "SHA1withECDSA"};
    protected final ExternalSession delegate;

    Java7ExtendedSSLSession(ExternalSession externalSession) {
        this.delegate = externalSession;
    }

    public final String[] getLocalSupportedSignatureAlgorithms() {
        return (String[]) LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
    }

    public final String[] getPeerSupportedSignatureAlgorithms() {
        return (String[]) PEER_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
    }

    @Override // org.conscrypt.ConscryptSession
    public final String getRequestedServerName() {
        return this.delegate.getRequestedServerName();
    }

    @Override // org.conscrypt.ConscryptSession
    public final List<byte[]> getStatusResponses() {
        return this.delegate.getStatusResponses();
    }

    @Override // org.conscrypt.ConscryptSession
    public final byte[] getPeerSignedCertificateTimestamp() {
        return this.delegate.getPeerSignedCertificateTimestamp();
    }

    public final byte[] getId() {
        return this.delegate.getId();
    }

    public final SSLSessionContext getSessionContext() {
        return this.delegate.getSessionContext();
    }

    public final long getCreationTime() {
        return this.delegate.getCreationTime();
    }

    public final long getLastAccessedTime() {
        return this.delegate.getLastAccessedTime();
    }

    public final void invalidate() {
        this.delegate.invalidate();
    }

    public final boolean isValid() {
        return this.delegate.isValid();
    }

    public final void putValue(String str, Object obj) {
        this.delegate.putValue(this, str, obj);
    }

    public final Object getValue(String str) {
        return this.delegate.getValue(str);
    }

    public final void removeValue(String str) {
        this.delegate.removeValue(this, str);
    }

    public final String[] getValueNames() {
        return this.delegate.getValueNames();
    }

    @Override // org.conscrypt.ConscryptSession, javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return this.delegate.getPeerCertificates();
    }

    public final Certificate[] getLocalCertificates() {
        return this.delegate.getLocalCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public final javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return this.delegate.getPeerCertificateChain();
    }

    @Override // javax.net.ssl.SSLSession
    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.delegate.getPeerPrincipal();
    }

    public final Principal getLocalPrincipal() {
        return this.delegate.getLocalPrincipal();
    }

    public final String getCipherSuite() {
        return this.delegate.getCipherSuite();
    }

    public final String getProtocol() {
        return this.delegate.getProtocol();
    }

    public final String getPeerHost() {
        return this.delegate.getPeerHost();
    }

    public final int getPeerPort() {
        return this.delegate.getPeerPort();
    }

    public final int getPacketBufferSize() {
        return this.delegate.getPacketBufferSize();
    }

    public final int getApplicationBufferSize() {
        return this.delegate.getApplicationBufferSize();
    }
}
