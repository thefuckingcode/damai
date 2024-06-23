package org.conscrypt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* access modifiers changed from: package-private */
public final class OpenSSLECPrivateKey implements ECPrivateKey, OpenSSLKeyHolder {
    private static final String ALGORITHM = "EC";
    private static final long serialVersionUID = -4036633595001083922L;
    protected transient OpenSSLECGroupContext group;
    protected transient OpenSSLKey key;

    public String getAlgorithm() {
        return ALGORITHM;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    OpenSSLECPrivateKey(OpenSSLECGroupContext openSSLECGroupContext, OpenSSLKey openSSLKey) {
        this.group = openSSLECGroupContext;
        this.key = openSSLKey;
    }

    OpenSSLECPrivateKey(OpenSSLKey openSSLKey) {
        this.group = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(openSSLKey.getNativeRef())));
        this.key = openSSLKey;
    }

    OpenSSLECPrivateKey(ECPrivateKeySpec eCPrivateKeySpec) throws InvalidKeySpecException {
        try {
            this.group = OpenSSLECGroupContext.getInstance(eCPrivateKeySpec.getParams());
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(this.group.getNativeRef(), null, eCPrivateKeySpec.getS().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    static OpenSSLKey wrapPlatformKey(ECPrivateKey eCPrivateKey) throws InvalidKeyException {
        try {
            return wrapPlatformKey(eCPrivateKey, OpenSSLECGroupContext.getInstance(eCPrivateKey.getParams()));
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("Unknown group parameters", e);
        }
    }

    static OpenSSLKey wrapJCAPrivateKeyForTLSStackOnly(PrivateKey privateKey, PublicKey publicKey) throws InvalidKeyException {
        ECParameterSpec eCParameterSpec;
        if (privateKey instanceof ECKey) {
            eCParameterSpec = ((ECKey) privateKey).getParams();
        } else {
            eCParameterSpec = publicKey instanceof ECKey ? ((ECKey) publicKey).getParams() : null;
        }
        if (eCParameterSpec != null) {
            return wrapJCAPrivateKeyForTLSStackOnly(privateKey, eCParameterSpec);
        }
        throw new InvalidKeyException("EC parameters not available. Private: " + privateKey + ", public: " + publicKey);
    }

    static OpenSSLKey wrapJCAPrivateKeyForTLSStackOnly(PrivateKey privateKey, ECParameterSpec eCParameterSpec) throws InvalidKeyException {
        if (eCParameterSpec == null && (privateKey instanceof ECKey)) {
            eCParameterSpec = ((ECKey) privateKey).getParams();
        }
        if (eCParameterSpec != null) {
            try {
                return new OpenSSLKey(NativeCrypto.getECPrivateKeyWrapper(privateKey, OpenSSLECGroupContext.getInstance(eCParameterSpec).getNativeRef()), true);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidKeyException("Invalid EC parameters: " + eCParameterSpec);
            }
        } else {
            throw new InvalidKeyException("EC parameters not available: " + privateKey);
        }
    }

    private static OpenSSLKey wrapPlatformKey(ECPrivateKey eCPrivateKey, OpenSSLECGroupContext openSSLECGroupContext) throws InvalidKeyException {
        return new OpenSSLKey(NativeCrypto.getECPrivateKeyWrapper(eCPrivateKey, openSSLECGroupContext.getNativeRef()), true);
    }

    static OpenSSLKey getInstance(ECPrivateKey eCPrivateKey) throws InvalidKeyException {
        try {
            OpenSSLECGroupContext instance = OpenSSLECGroupContext.getInstance(eCPrivateKey.getParams());
            if (eCPrivateKey.getFormat() == null) {
                return wrapPlatformKey(eCPrivateKey, instance);
            }
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(instance.getNativeRef(), null, eCPrivateKey.getS().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    public byte[] getEncoded() {
        return NativeCrypto.EVP_marshal_private_key(this.key.getNativeRef());
    }

    public ECParameterSpec getParams() {
        return this.group.getECParameterSpec();
    }

    public BigInteger getS() {
        return getPrivateKey();
    }

    private BigInteger getPrivateKey() {
        return new BigInteger(NativeCrypto.EC_KEY_get_private_key(this.key.getNativeRef()));
    }

    @Override // org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLECPrivateKey) {
            return this.key.equals(((OpenSSLECPrivateKey) obj).key);
        }
        if (!(obj instanceof ECPrivateKey)) {
            return false;
        }
        ECPrivateKey eCPrivateKey = (ECPrivateKey) obj;
        if (!getPrivateKey().equals(eCPrivateKey.getS())) {
            return false;
        }
        ECParameterSpec params = getParams();
        ECParameterSpec params2 = eCPrivateKey.getParams();
        if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(NativeCrypto.EVP_marshal_private_key(this.key.getNativeRef()));
    }

    public String toString() {
        return "OpenSSLECPrivateKey{" + "params={" + NativeCrypto.EVP_PKEY_print_params(this.key.getNativeRef()) + "}}";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EVP_parse_private_key((byte[]) objectInputStream.readObject()));
            this.key = openSSLKey;
            this.group = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(openSSLKey.getNativeRef())));
        } catch (OpenSSLX509CertificateFactory.ParsingException e) {
            throw new IOException(e);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
