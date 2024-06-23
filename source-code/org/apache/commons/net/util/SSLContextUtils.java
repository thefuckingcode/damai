package org.apache.commons.net.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* compiled from: Taobao */
public class SSLContextUtils {
    private SSLContextUtils() {
    }

    public static SSLContext createSSLContext(String str, KeyManager keyManager, TrustManager trustManager) throws IOException {
        TrustManager[] trustManagerArr = null;
        KeyManager[] keyManagerArr = keyManager == null ? null : new KeyManager[]{keyManager};
        if (trustManager != null) {
            trustManagerArr = new TrustManager[]{trustManager};
        }
        return createSSLContext(str, keyManagerArr, trustManagerArr);
    }

    public static SSLContext createSSLContext(String str, KeyManager[] keyManagerArr, TrustManager[] trustManagerArr) throws IOException {
        try {
            SSLContext instance = SSLContext.getInstance(str);
            instance.init(keyManagerArr, trustManagerArr, null);
            return instance;
        } catch (GeneralSecurityException e) {
            IOException iOException = new IOException("Could not initialize SSL context");
            iOException.initCause(e);
            throw iOException;
        }
    }
}
