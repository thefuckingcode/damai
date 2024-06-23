package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;

/* access modifiers changed from: package-private */
public final class SessionSnapshot implements ConscryptSession {
    private final String cipherSuite;
    private final long creationTime;
    private final byte[] id;
    private final long lastAccessedTime;
    private final String peerHost;
    private final int peerPort;
    private final byte[] peerTlsSctData;
    private final String protocol;
    private final String requestedServerName;
    private final SSLSessionContext sessionContext;
    private final List<byte[]> statusResponses;

    public int getApplicationBufferSize() {
        return 16384;
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

    public void invalidate() {
    }

    public boolean isValid() {
        return false;
    }

    SessionSnapshot(ConscryptSession conscryptSession) {
        this.sessionContext = conscryptSession.getSessionContext();
        this.id = conscryptSession.getId();
        this.requestedServerName = conscryptSession.getRequestedServerName();
        this.statusResponses = conscryptSession.getStatusResponses();
        this.peerTlsSctData = conscryptSession.getPeerSignedCertificateTimestamp();
        this.creationTime = conscryptSession.getCreationTime();
        this.lastAccessedTime = conscryptSession.getLastAccessedTime();
        this.cipherSuite = conscryptSession.getCipherSuite();
        this.protocol = conscryptSession.getProtocol();
        this.peerHost = conscryptSession.getPeerHost();
        this.peerPort = conscryptSession.getPeerPort();
    }

    @Override // org.conscrypt.ConscryptSession
    public String getRequestedServerName() {
        return this.requestedServerName;
    }

    @Override // org.conscrypt.ConscryptSession
    public List<byte[]> getStatusResponses() {
        ArrayList arrayList = new ArrayList(this.statusResponses.size());
        for (byte[] bArr : this.statusResponses) {
            arrayList.add(bArr.clone());
        }
        return arrayList;
    }

    @Override // org.conscrypt.ConscryptSession
    public byte[] getPeerSignedCertificateTimestamp() {
        byte[] bArr = this.peerTlsSctData;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public byte[] getId() {
        return this.id;
    }

    public SSLSessionContext getSessionContext() {
        return this.sessionContext;
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public long getLastAccessedTime() {
        return this.lastAccessedTime;
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
        throw new SSLPeerUnverifiedException("No peer certificates");
    }

    @Override // javax.net.ssl.SSLSession
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificates");
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificates");
    }

    public String getCipherSuite() {
        return this.cipherSuite;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getPeerHost() {
        return this.peerHost;
    }

    public int getPeerPort() {
        return this.peerPort;
    }
}
