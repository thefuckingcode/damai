package org.conscrypt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class DefaultSSLContextImpl extends OpenSSLContextImpl {
    private static KeyManager[] KEY_MANAGERS;
    private static TrustManager[] TRUST_MANAGERS;

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    public KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {
        char[] cArr;
        Throwable th;
        KeyManager[] keyManagerArr = KEY_MANAGERS;
        if (keyManagerArr != null) {
            return keyManagerArr;
        }
        String property = System.getProperty("javax.net.ssl.keyStore");
        BufferedInputStream bufferedInputStream = null;
        if (property == null) {
            return null;
        }
        String property2 = System.getProperty("javax.net.ssl.keyStorePassword");
        if (property2 == null) {
            cArr = null;
        } else {
            cArr = property2.toCharArray();
        }
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(property));
            try {
                instance.load(bufferedInputStream2, cArr);
                bufferedInputStream2.close();
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, cArr);
                KeyManager[] keyManagers = instance2.getKeyManagers();
                KEY_MANAGERS = keyManagers;
                return keyManagers;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    public TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {
        char[] cArr;
        Throwable th;
        TrustManager[] trustManagerArr = TRUST_MANAGERS;
        if (trustManagerArr != null) {
            return trustManagerArr;
        }
        String property = System.getProperty("javax.net.ssl.trustStore");
        BufferedInputStream bufferedInputStream = null;
        if (property == null) {
            return null;
        }
        String property2 = System.getProperty("javax.net.ssl.trustStorePassword");
        if (property2 == null) {
            cArr = null;
        } else {
            cArr = property2.toCharArray();
        }
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(property));
            try {
                instance.load(bufferedInputStream2, cArr);
                bufferedInputStream2.close();
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                TrustManager[] trustManagers = instance2.getTrustManagers();
                TRUST_MANAGERS = trustManagers;
                return trustManagers;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
            }
            throw th;
        }
    }

    @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        throw new KeyManagementException("Do not init() the default SSLContext ");
    }
}
