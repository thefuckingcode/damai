package org.conscrypt;

import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

class KeyManagerImpl extends X509ExtendedKeyManager {
    private final HashMap<String, KeyStore.PrivateKeyEntry> hash = new HashMap<>();

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ExcHandler: KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:9:0x002e] */
    KeyManagerImpl(KeyStore keyStore, char[] cArr) {
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                if (keyStore.entryInstanceOf(nextElement, KeyStore.PrivateKeyEntry.class)) {
                    KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(nextElement, new KeyStore.PasswordProtection(cArr));
                    try {
                        privateKeyEntry = new KeyStore.PrivateKeyEntry((PrivateKey) keyStore.getKey(nextElement, cArr), keyStore.getCertificateChain(nextElement));
                        this.hash.put(nextElement, privateKeyEntry);
                    } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException unused) {
                    }
                }
            }
        } catch (KeyStoreException unused2) {
        }
    }

    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        String[] chooseAlias = chooseAlias(strArr, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        String[] chooseAlias = chooseAlias(new String[]{str}, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    public X509Certificate[] getCertificateChain(String str) {
        X509Certificate[] x509CertificateArr = null;
        if (str == null) {
            return null;
        }
        if (this.hash.containsKey(str)) {
            Certificate[] certificateChain = this.hash.get(str).getCertificateChain();
            if (certificateChain[0] instanceof X509Certificate) {
                x509CertificateArr = new X509Certificate[certificateChain.length];
                for (int i = 0; i < certificateChain.length; i++) {
                    x509CertificateArr[i] = (X509Certificate) certificateChain[i];
                }
            }
        }
        return x509CertificateArr;
    }

    public String[] getClientAliases(String str, Principal[] principalArr) {
        return chooseAlias(new String[]{str}, principalArr);
    }

    public String[] getServerAliases(String str, Principal[] principalArr) {
        return chooseAlias(new String[]{str}, principalArr);
    }

    public PrivateKey getPrivateKey(String str) {
        if (str != null && this.hash.containsKey(str)) {
            return this.hash.get(str).getPrivateKey();
        }
        return null;
    }

    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        String[] chooseAlias = chooseAlias(strArr, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        String[] chooseAlias = chooseAlias(new String[]{str}, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    private String[] chooseAlias(String[] strArr, Principal[] principalArr) {
        List list;
        String str;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (principalArr == null) {
            list = null;
        } else {
            list = Arrays.asList(principalArr);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, KeyStore.PrivateKeyEntry> entry : this.hash.entrySet()) {
            String key = entry.getKey();
            Certificate[] certificateChain = entry.getValue().getCertificateChain();
            int i = 0;
            Certificate certificate = certificateChain[0];
            String algorithm = certificate.getPublicKey().getAlgorithm();
            String upperCase = certificate instanceof X509Certificate ? ((X509Certificate) certificate).getSigAlgName().toUpperCase(Locale.US) : null;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArr[i2];
                if (str2 != null) {
                    int indexOf = str2.indexOf(95);
                    if (indexOf == -1) {
                        str = null;
                    } else {
                        str = str2.substring(indexOf + 1);
                        str2 = str2.substring(i, indexOf);
                    }
                    if (algorithm.equals(str2) && (str == null || upperCase == null || upperCase.contains(str))) {
                        if (principalArr == null || principalArr.length == 0) {
                            arrayList.add(key);
                        } else {
                            for (Certificate certificate2 : certificateChain) {
                                if ((certificate2 instanceof X509Certificate) && list.contains(((X509Certificate) certificate2).getIssuerX500Principal())) {
                                    arrayList.add(key);
                                }
                            }
                        }
                    }
                }
                i2++;
                i = 0;
            }
        }
        if (!arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }
}
