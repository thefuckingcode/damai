package org.conscrypt;

import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* access modifiers changed from: package-private */
public final class OpenSSLKey {
    private final NativeRef.EVP_PKEY ctx;
    private final boolean wrapped;

    OpenSSLKey(long j) {
        this(j, false);
    }

    OpenSSLKey(long j, boolean z) {
        this.ctx = new NativeRef.EVP_PKEY(j);
        this.wrapped = z;
    }

    /* access modifiers changed from: package-private */
    public NativeRef.EVP_PKEY getNativeRef() {
        return this.ctx;
    }

    /* access modifiers changed from: package-private */
    public boolean isWrapped() {
        return this.wrapped;
    }

    static OpenSSLKey fromPrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) privateKey).getOpenSSLKey();
        }
        String format = privateKey.getFormat();
        if (format == null) {
            return wrapPrivateKey(privateKey);
        }
        if (!"PKCS#8".equals(privateKey.getFormat())) {
            throw new InvalidKeyException("Unknown key format " + format);
        } else if (privateKey.getEncoded() != null) {
            try {
                return new OpenSSLKey(NativeCrypto.EVP_parse_private_key(privateKey.getEncoded()));
            } catch (OpenSSLX509CertificateFactory.ParsingException e) {
                throw new InvalidKeyException(e);
            }
        } else {
            throw new InvalidKeyException("Key encoding is null");
        }
    }

    static OpenSSLKey fromPrivateKeyPemInputStream(InputStream inputStream) throws InvalidKeyException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            long PEM_read_bio_PrivateKey = NativeCrypto.PEM_read_bio_PrivateKey(openSSLBIOInputStream.getBioContext());
            if (PEM_read_bio_PrivateKey == 0) {
                openSSLBIOInputStream.release();
                return null;
            }
            OpenSSLKey openSSLKey = new OpenSSLKey(PEM_read_bio_PrivateKey);
            openSSLBIOInputStream.release();
            return openSSLKey;
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    static OpenSSLKey fromPrivateKeyForTLSStackOnly(PrivateKey privateKey, PublicKey publicKey) throws InvalidKeyException {
        OpenSSLKey openSSLKey = getOpenSSLKey(privateKey);
        if (openSSLKey != null) {
            return openSSLKey;
        }
        OpenSSLKey fromKeyMaterial = fromKeyMaterial(privateKey);
        if (fromKeyMaterial != null) {
            return fromKeyMaterial;
        }
        return wrapJCAPrivateKeyForTLSStackOnly(privateKey, publicKey);
    }

    static OpenSSLKey fromECPrivateKeyForTLSStackOnly(PrivateKey privateKey, ECParameterSpec eCParameterSpec) throws InvalidKeyException {
        OpenSSLKey openSSLKey = getOpenSSLKey(privateKey);
        if (openSSLKey != null) {
            return openSSLKey;
        }
        OpenSSLKey fromKeyMaterial = fromKeyMaterial(privateKey);
        if (fromKeyMaterial != null) {
            return fromKeyMaterial;
        }
        return OpenSSLECPrivateKey.wrapJCAPrivateKeyForTLSStackOnly(privateKey, eCParameterSpec);
    }

    private static OpenSSLKey getOpenSSLKey(PrivateKey privateKey) {
        if (privateKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) privateKey).getOpenSSLKey();
        }
        if ("RSA".equals(privateKey.getAlgorithm())) {
            return Platform.wrapRsaKey(privateKey);
        }
        return null;
    }

    private static OpenSSLKey fromKeyMaterial(PrivateKey privateKey) throws InvalidKeyException {
        byte[] encoded;
        if (!"PKCS#8".equals(privateKey.getFormat()) || (encoded = privateKey.getEncoded()) == null) {
            return null;
        }
        try {
            return new OpenSSLKey(NativeCrypto.EVP_parse_private_key(encoded));
        } catch (OpenSSLX509CertificateFactory.ParsingException e) {
            throw new InvalidKeyException(e);
        }
    }

    private static OpenSSLKey wrapJCAPrivateKeyForTLSStackOnly(PrivateKey privateKey, PublicKey publicKey) throws InvalidKeyException {
        String algorithm = privateKey.getAlgorithm();
        if ("RSA".equals(algorithm)) {
            return OpenSSLRSAPrivateKey.wrapJCAPrivateKeyForTLSStackOnly(privateKey, publicKey);
        }
        if ("EC".equals(algorithm)) {
            return OpenSSLECPrivateKey.wrapJCAPrivateKeyForTLSStackOnly(privateKey, publicKey);
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    private static OpenSSLKey wrapPrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            return OpenSSLRSAPrivateKey.wrapPlatformKey((RSAPrivateKey) privateKey);
        }
        if (privateKey instanceof ECPrivateKey) {
            return OpenSSLECPrivateKey.wrapPlatformKey((ECPrivateKey) privateKey);
        }
        throw new InvalidKeyException("Unknown key type: " + privateKey.toString());
    }

    static OpenSSLKey fromPublicKey(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) publicKey).getOpenSSLKey();
        }
        if (!"X.509".equals(publicKey.getFormat())) {
            throw new InvalidKeyException("Unknown key format " + publicKey.getFormat());
        } else if (publicKey.getEncoded() != null) {
            try {
                return new OpenSSLKey(NativeCrypto.EVP_parse_public_key(publicKey.getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeyException(e);
            }
        } else {
            throw new InvalidKeyException("Key encoding is null");
        }
    }

    static OpenSSLKey fromPublicKeyPemInputStream(InputStream inputStream) throws InvalidKeyException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            long PEM_read_bio_PUBKEY = NativeCrypto.PEM_read_bio_PUBKEY(openSSLBIOInputStream.getBioContext());
            if (PEM_read_bio_PUBKEY == 0) {
                openSSLBIOInputStream.release();
                return null;
            }
            OpenSSLKey openSSLKey = new OpenSSLKey(PEM_read_bio_PUBKEY);
            openSSLBIOInputStream.release();
            return openSSLKey;
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public PublicKey getPublicKey() throws NoSuchAlgorithmException {
        int EVP_PKEY_type = NativeCrypto.EVP_PKEY_type(this.ctx);
        if (EVP_PKEY_type == 6) {
            return new OpenSSLRSAPublicKey(this);
        }
        if (EVP_PKEY_type == 408) {
            return new OpenSSLECPublicKey(this);
        }
        throw new NoSuchAlgorithmException("unknown PKEY type");
    }

    static PublicKey getPublicKey(X509EncodedKeySpec x509EncodedKeySpec, int i) throws InvalidKeySpecException {
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EVP_parse_public_key(x509EncodedKeySpec.getEncoded()));
            if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) == i) {
                try {
                    return openSSLKey.getPublicKey();
                } catch (NoSuchAlgorithmException e) {
                    throw new InvalidKeySpecException(e);
                }
            } else {
                throw new InvalidKeySpecException("Unexpected key type");
            }
        } catch (Exception e2) {
            throw new InvalidKeySpecException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public PrivateKey getPrivateKey() throws NoSuchAlgorithmException {
        int EVP_PKEY_type = NativeCrypto.EVP_PKEY_type(this.ctx);
        if (EVP_PKEY_type == 6) {
            return new OpenSSLRSAPrivateKey(this);
        }
        if (EVP_PKEY_type == 408) {
            return new OpenSSLECPrivateKey(this);
        }
        throw new NoSuchAlgorithmException("unknown PKEY type");
    }

    static PrivateKey getPrivateKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec, int i) throws InvalidKeySpecException {
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EVP_parse_private_key(pKCS8EncodedKeySpec.getEncoded()));
            if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) == i) {
                try {
                    return openSSLKey.getPrivateKey();
                } catch (NoSuchAlgorithmException e) {
                    throw new InvalidKeySpecException(e);
                }
            } else {
                throw new InvalidKeySpecException("Unexpected key type");
            }
        } catch (Exception e2) {
            throw new InvalidKeySpecException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OpenSSLKey)) {
            return false;
        }
        OpenSSLKey openSSLKey = (OpenSSLKey) obj;
        if (!this.ctx.equals(openSSLKey.getNativeRef()) && NativeCrypto.EVP_PKEY_cmp(this.ctx, openSSLKey.getNativeRef()) != 1) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.ctx.hashCode();
    }
}
