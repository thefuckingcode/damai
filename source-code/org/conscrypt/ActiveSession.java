package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;

/* access modifiers changed from: package-private */
public final class ActiveSession implements ConscryptSession {
    private long creationTime;
    private byte[] id;
    private long lastAccessedTime = 0;
    private X509Certificate[] localCertificates;
    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    private byte[] peerCertificateOcspData;
    private X509Certificate[] peerCertificates;
    private String peerHost;
    private int peerPort = -1;
    private byte[] peerTlsSctData;
    private String protocol;
    private AbstractSessionContext sessionContext;
    private final NativeSsl ssl;

    public int getApplicationBufferSize() {
        return 16384;
    }

    public int getPacketBufferSize() {
        return 16709;
    }

    ActiveSession(NativeSsl nativeSsl, AbstractSessionContext abstractSessionContext) {
        this.ssl = (NativeSsl) Preconditions.checkNotNull(nativeSsl, "ssl");
        this.sessionContext = (AbstractSessionContext) Preconditions.checkNotNull(abstractSessionContext, "sessionContext");
    }

    public byte[] getId() {
        if (this.id == null) {
            synchronized (this.ssl) {
                this.id = this.ssl.getSessionId();
            }
        }
        byte[] bArr = this.id;
        return bArr != null ? (byte[]) bArr.clone() : EmptyArray.BYTE;
    }

    public SSLSessionContext getSessionContext() {
        if (isValid()) {
            return this.sessionContext;
        }
        return null;
    }

    public long getCreationTime() {
        if (this.creationTime == 0) {
            synchronized (this.ssl) {
                this.creationTime = this.ssl.getTime();
            }
        }
        return this.creationTime;
    }

    public long getLastAccessedTime() {
        long j = this.lastAccessedTime;
        return j == 0 ? getCreationTime() : j;
    }

    /* access modifiers changed from: package-private */
    public void setLastAccessedTime(long j) {
        this.lastAccessedTime = j;
    }

    @Override // org.conscrypt.ConscryptSession
    public List<byte[]> getStatusResponses() {
        byte[] bArr = this.peerCertificateOcspData;
        if (bArr == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(bArr.clone());
    }

    @Override // org.conscrypt.ConscryptSession
    public byte[] getPeerSignedCertificateTimestamp() {
        byte[] bArr = this.peerTlsSctData;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    @Override // org.conscrypt.ConscryptSession
    public String getRequestedServerName() {
        String requestedServerName;
        synchronized (this.ssl) {
            requestedServerName = this.ssl.getRequestedServerName();
        }
        return requestedServerName;
    }

    public void invalidate() {
        synchronized (this.ssl) {
            this.ssl.setTimeout(0);
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.ssl) {
            z = System.currentTimeMillis() - this.ssl.getTimeout() < this.ssl.getTime();
        }
        return z;
    }

    public void putValue(String str, Object obj) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    public Object getValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    public void removeValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    public String[] getValueNames() {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    @Override // org.conscrypt.ConscryptSession, javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return (X509Certificate[]) this.peerCertificates.clone();
    }

    public Certificate[] getLocalCertificates() {
        if (this.localCertificates == null) {
            synchronized (this.ssl) {
                this.localCertificates = this.ssl.getLocalCertificates();
            }
        }
        X509Certificate[] x509CertificateArr = this.localCertificates;
        if (x509CertificateArr == null) {
            return null;
        }
        return (X509Certificate[]) x509CertificateArr.clone();
    }

    @Override // javax.net.ssl.SSLSession
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] x509CertificateArr = this.peerCertificateChain;
        if (x509CertificateArr != null) {
            return x509CertificateArr;
        }
        javax.security.cert.X509Certificate[] certificateChain = SSLUtils.toCertificateChain(this.peerCertificates);
        this.peerCertificateChain = certificateChain;
        return certificateChain;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return this.peerCertificates[0].getSubjectX500Principal();
    }

    public Principal getLocalPrincipal() {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) getLocalCertificates();
        if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
            return null;
        }
        return x509CertificateArr[0].getSubjectX500Principal();
    }

    public String getCipherSuite() {
        String cipherSuite;
        synchronized (this.ssl) {
            cipherSuite = this.ssl.getCipherSuite();
        }
        return cipherSuite == null ? "SSL_NULL_WITH_NULL_NULL" : cipherSuite;
    }

    public String getProtocol() {
        String str = this.protocol;
        if (str == null) {
            synchronized (this.ssl) {
                str = this.ssl.getVersion();
            }
            this.protocol = str;
        }
        return str;
    }

    public String getPeerHost() {
        return this.peerHost;
    }

    public int getPeerPort() {
        return this.peerPort;
    }

    /* access modifiers changed from: package-private */
    public void onPeerCertificatesReceived(String str, int i, X509Certificate[] x509CertificateArr) {
        configurePeer(str, i, x509CertificateArr);
    }

    private void configurePeer(String str, int i, X509Certificate[] x509CertificateArr) {
        this.peerHost = str;
        this.peerPort = i;
        this.peerCertificates = x509CertificateArr;
        synchronized (this.ssl) {
            this.peerCertificateOcspData = this.ssl.getPeerCertificateOcspData();
            this.peerTlsSctData = this.ssl.getPeerTlsSctData();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPeerCertificateAvailable(String str, int i) throws CertificateException {
        synchronized (this.ssl) {
            this.id = null;
            if (this.localCertificates == null) {
                this.localCertificates = this.ssl.getLocalCertificates();
            }
            if (this.peerCertificates == null) {
                configurePeer(str, i, this.ssl.getPeerCertificates());
            }
        }
    }

    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        X509Certificate[] x509CertificateArr = this.peerCertificates;
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new SSLPeerUnverifiedException("No peer certificates");
        }
    }
}
