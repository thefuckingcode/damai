package org.apache.commons.net.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509ExtendedKeyManager;
import org.apache.commons.net.io.Util;

/* compiled from: Taobao */
public final class KeyManagerUtils {
    private static final String DEFAULT_STORE_TYPE = KeyStore.getDefaultType();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ClientKeyStore {
        private final X509Certificate[] certChain;
        private final PrivateKey key;
        private final String keyAlias;

        ClientKeyStore(KeyStore keyStore, String str, String str2) throws GeneralSecurityException {
            this.keyAlias = str;
            this.key = (PrivateKey) keyStore.getKey(str, str2.toCharArray());
            Certificate[] certificateChain = keyStore.getCertificateChain(str);
            X509Certificate[] x509CertificateArr = new X509Certificate[certificateChain.length];
            for (int i = 0; i < certificateChain.length; i++) {
                x509CertificateArr[i] = (X509Certificate) certificateChain[i];
            }
            this.certChain = x509CertificateArr;
        }

        /* access modifiers changed from: package-private */
        public final String getAlias() {
            return this.keyAlias;
        }

        /* access modifiers changed from: package-private */
        public final X509Certificate[] getCertificateChain() {
            return this.certChain;
        }

        /* access modifiers changed from: package-private */
        public final PrivateKey getPrivateKey() {
            return this.key;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class X509KeyManager extends X509ExtendedKeyManager {
        private final ClientKeyStore keyStore;

        X509KeyManager(ClientKeyStore clientKeyStore) {
            this.keyStore = clientKeyStore;
        }

        public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
            return this.keyStore.getAlias();
        }

        public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
            return null;
        }

        public X509Certificate[] getCertificateChain(String str) {
            return this.keyStore.getCertificateChain();
        }

        public String[] getClientAliases(String str, Principal[] principalArr) {
            return new String[]{this.keyStore.getAlias()};
        }

        public PrivateKey getPrivateKey(String str) {
            return this.keyStore.getPrivateKey();
        }

        public String[] getServerAliases(String str, Principal[] principalArr) {
            return null;
        }
    }

    private KeyManagerUtils() {
    }

    public static KeyManager createClientKeyManager(KeyStore keyStore, String str, String str2) throws GeneralSecurityException {
        if (str == null) {
            str = findAlias(keyStore);
        }
        return new X509KeyManager(new ClientKeyStore(keyStore, str, str2));
    }

    private static String findAlias(KeyStore keyStore) throws KeyStoreException {
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            if (keyStore.isKeyEntry(nextElement)) {
                return nextElement;
            }
        }
        throw new KeyStoreException("Cannot find a private key entry");
    }

    private static KeyStore loadStore(String str, File file, String str2) throws KeyStoreException, IOException, GeneralSecurityException {
        Throwable th;
        KeyStore instance = KeyStore.getInstance(str);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                instance.load(fileInputStream2, str2.toCharArray());
                Util.closeQuietly(fileInputStream2);
                return instance;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                Util.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Util.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static KeyManager createClientKeyManager(String str, File file, String str2, String str3, String str4) throws IOException, GeneralSecurityException {
        return createClientKeyManager(loadStore(str, file, str2), str3, str4);
    }

    public static KeyManager createClientKeyManager(File file, String str, String str2) throws IOException, GeneralSecurityException {
        return createClientKeyManager(DEFAULT_STORE_TYPE, file, str, str2, str);
    }

    public static KeyManager createClientKeyManager(File file, String str) throws IOException, GeneralSecurityException {
        return createClientKeyManager(DEFAULT_STORE_TYPE, file, str, null, str);
    }
}
