package org.conscrypt;

import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* access modifiers changed from: package-private */
public interface ConscryptSession extends SSLSession {
    @Override // javax.net.ssl.SSLSession
    X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException;

    byte[] getPeerSignedCertificateTimestamp();

    String getRequestedServerName();

    List<byte[]> getStatusResponses();
}
