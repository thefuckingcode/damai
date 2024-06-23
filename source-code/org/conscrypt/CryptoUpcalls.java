package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

final class CryptoUpcalls {
    private static final Logger logger = Logger.getLogger(CryptoUpcalls.class.getName());

    private CryptoUpcalls() {
    }

    private static ArrayList<Provider> getExternalProviders(String str) {
        ArrayList<Provider> arrayList = new ArrayList<>(1);
        Provider[] providers = Security.getProviders(str);
        for (Provider provider : providers) {
            if (!Conscrypt.isConscrypt(provider)) {
                arrayList.add(provider);
            }
        }
        if (arrayList.isEmpty()) {
            logger.warning("Could not find external provider for algorithm: " + str);
        }
        return arrayList;
    }

    static byte[] ecSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        if ("EC".equals(privateKey.getAlgorithm())) {
            return signDigestWithPrivateKey(privateKey, bArr, "NONEwithECDSA");
        }
        throw new RuntimeException("Unexpected key type: " + privateKey.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (org.conscrypt.Conscrypt.isConscrypt(r1.getProvider()) != false) goto L_0x001e;
     */
    private static byte[] signDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr, String str) {
        Signature signature;
        try {
            signature = Signature.getInstance(str);
            signature.initSign(privateKey);
        } catch (NoSuchAlgorithmException unused) {
            logger.warning("Unsupported signature algorithm: " + str);
            return null;
        } catch (InvalidKeyException e) {
            logger.warning("Preferred provider doesn't support key:");
            e.printStackTrace();
        }
        signature = null;
        signature = null;
        if (signature == null) {
            Iterator<Provider> it = getExternalProviders("Signature." + str).iterator();
            RuntimeException runtimeException = null;
            while (it.hasNext()) {
                try {
                    signature = Signature.getInstance(str, it.next());
                    signature.initSign(privateKey);
                    break;
                } catch (InvalidKeyException | NoSuchAlgorithmException unused2) {
                } catch (RuntimeException e2) {
                    if (runtimeException == null) {
                        runtimeException = e2;
                    }
                }
            }
            if (signature == null) {
                if (runtimeException == null) {
                    logger.warning("Could not find provider for algorithm: " + str);
                    return null;
                }
                throw runtimeException;
            }
        }
        try {
            signature.update(bArr);
            return signature.sign();
        } catch (Exception e3) {
            logger.log(Level.WARNING, "Exception while signing message with " + privateKey.getAlgorithm() + " private key:", (Throwable) e3);
            return null;
        }
    }

    static byte[] rsaSignDigestWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 1, bArr);
    }

    static byte[] rsaDecryptWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 2, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        if (org.conscrypt.Conscrypt.isConscrypt(r1.getProvider()) != false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    private static byte[] rsaOpWithPrivateKey(PrivateKey privateKey, int i, int i2, byte[] bArr) {
        String str;
        String str2;
        Cipher cipher;
        Iterator<Provider> it;
        String algorithm = privateKey.getAlgorithm();
        if (!"RSA".equals(algorithm)) {
            logger.warning("Unexpected key type: " + algorithm);
            return null;
        }
        if (i == 1) {
            str = "PKCS1Padding";
        } else if (i == 3) {
            str = "NoPadding";
        } else if (i != 4) {
            logger.warning("Unsupported OpenSSL/BoringSSL padding: " + i);
            return null;
        } else {
            str = "OAEPPadding";
        }
        str2 = "RSA/ECB/" + str;
        try {
            cipher = Cipher.getInstance(str2);
            cipher.init(i2, privateKey);
        } catch (NoSuchAlgorithmException unused) {
            logger.warning("Unsupported cipher algorithm: " + str2);
            return null;
        } catch (NoSuchPaddingException unused2) {
            logger.warning("Unsupported cipher algorithm: " + str2);
            return null;
        } catch (InvalidKeyException e) {
            logger.log(Level.WARNING, "Preferred provider doesn't support key:", (Throwable) e);
        }
        while (it.hasNext()) {
            try {
                cipher = Cipher.getInstance(str2, it.next());
                cipher.init(i2, privateKey);
                break;
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException unused3) {
                cipher = null;
            }
        }
        if (cipher == null) {
            logger.warning("Could not find provider for algorithm: " + str2);
            return null;
        }
        try {
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            logger.log(Level.WARNING, "Exception while decrypting message with " + privateKey.getAlgorithm() + " private key using " + str2 + ":", (Throwable) e2);
            return null;
        }
        cipher = null;
        if (cipher == null) {
            it = getExternalProviders("Cipher." + str2).iterator();
            while (it.hasNext()) {
            }
            if (cipher == null) {
            }
        }
        return cipher.doFinal(bArr);
    }
}
