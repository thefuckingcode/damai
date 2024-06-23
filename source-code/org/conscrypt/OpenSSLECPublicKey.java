package org.conscrypt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* access modifiers changed from: package-private */
public final class OpenSSLECPublicKey implements ECPublicKey, OpenSSLKeyHolder {
    private static final String ALGORITHM = "EC";
    private static final long serialVersionUID = 3215842926808298020L;
    protected transient OpenSSLECGroupContext group;
    protected transient OpenSSLKey key;

    public String getAlgorithm() {
        return ALGORITHM;
    }

    public String getFormat() {
        return "X.509";
    }

    OpenSSLECPublicKey(OpenSSLECGroupContext openSSLECGroupContext, OpenSSLKey openSSLKey) {
        this.group = openSSLECGroupContext;
        this.key = openSSLKey;
    }

    OpenSSLECPublicKey(OpenSSLKey openSSLKey) {
        this.group = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(openSSLKey.getNativeRef())));
        this.key = openSSLKey;
    }

    OpenSSLECPublicKey(ECPublicKeySpec eCPublicKeySpec) throws InvalidKeySpecException {
        try {
            OpenSSLECGroupContext instance = OpenSSLECGroupContext.getInstance(eCPublicKeySpec.getParams());
            this.group = instance;
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(this.group.getNativeRef(), OpenSSLECPointContext.getInstance(instance, eCPublicKeySpec.getW()).getNativeRef(), null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    static OpenSSLKey getInstance(ECPublicKey eCPublicKey) throws InvalidKeyException {
        try {
            OpenSSLECGroupContext instance = OpenSSLECGroupContext.getInstance(eCPublicKey.getParams());
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(instance.getNativeRef(), OpenSSLECPointContext.getInstance(instance, eCPublicKey.getW()).getNativeRef(), null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    public byte[] getEncoded() {
        return NativeCrypto.EVP_marshal_public_key(this.key.getNativeRef());
    }

    public ECParameterSpec getParams() {
        return this.group.getECParameterSpec();
    }

    private ECPoint getPublicKey() {
        return new OpenSSLECPointContext(this.group, new NativeRef.EC_POINT(NativeCrypto.EC_KEY_get_public_key(this.key.getNativeRef()))).getECPoint();
    }

    public ECPoint getW() {
        return getPublicKey();
    }

    @Override // org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLECPublicKey) {
            return this.key.equals(((OpenSSLECPublicKey) obj).key);
        }
        if (!(obj instanceof ECPublicKey)) {
            return false;
        }
        ECPublicKey eCPublicKey = (ECPublicKey) obj;
        if (!getPublicKey().equals(eCPublicKey.getW())) {
            return false;
        }
        ECParameterSpec params = getParams();
        ECParameterSpec params2 = eCPublicKey.getParams();
        if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(NativeCrypto.EVP_marshal_public_key(this.key.getNativeRef()));
    }

    public String toString() {
        return NativeCrypto.EVP_PKEY_print_public(this.key.getNativeRef());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EVP_parse_public_key((byte[]) objectInputStream.readObject()));
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
