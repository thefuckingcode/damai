package org.conscrypt;

import javax.net.ssl.SSLSession;

/* access modifiers changed from: package-private */
public interface SSLServerSessionCache {
    byte[] getSessionData(byte[] bArr);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}
