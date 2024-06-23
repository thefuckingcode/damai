package org.conscrypt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

final class OpenSSLRSAPrivateCrtKey extends OpenSSLRSAPrivateKey implements RSAPrivateCrtKey {
    private static final long serialVersionUID = 3785291944868707197L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    OpenSSLRSAPrivateCrtKey(OpenSSLKey openSSLKey) {
        super(openSSLKey);
    }

    OpenSSLRSAPrivateCrtKey(OpenSSLKey openSSLKey, byte[][] bArr) {
        super(openSSLKey, bArr);
    }

    OpenSSLRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) throws InvalidKeySpecException {
        super(init(rSAPrivateCrtKeySpec));
    }

    private static OpenSSLKey init(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) throws InvalidKeySpecException {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        BigInteger modulus = rSAPrivateCrtKeySpec.getModulus();
        BigInteger privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeySpecException("modulus == null");
        } else if (privateExponent != null) {
            try {
                BigInteger publicExponent2 = rSAPrivateCrtKeySpec.getPublicExponent();
                BigInteger primeP2 = rSAPrivateCrtKeySpec.getPrimeP();
                BigInteger primeQ2 = rSAPrivateCrtKeySpec.getPrimeQ();
                BigInteger primeExponentP2 = rSAPrivateCrtKeySpec.getPrimeExponentP();
                BigInteger primeExponentQ2 = rSAPrivateCrtKeySpec.getPrimeExponentQ();
                BigInteger crtCoefficient2 = rSAPrivateCrtKeySpec.getCrtCoefficient();
                byte[] byteArray = modulus.toByteArray();
                byte[] bArr6 = null;
                if (publicExponent2 == null) {
                    bArr = null;
                } else {
                    bArr = publicExponent2.toByteArray();
                }
                byte[] byteArray2 = privateExponent.toByteArray();
                if (primeP2 == null) {
                    bArr2 = null;
                } else {
                    bArr2 = primeP2.toByteArray();
                }
                if (primeQ2 == null) {
                    bArr3 = null;
                } else {
                    bArr3 = primeQ2.toByteArray();
                }
                if (primeExponentP2 == null) {
                    bArr4 = null;
                } else {
                    bArr4 = primeExponentP2.toByteArray();
                }
                if (primeExponentQ2 == null) {
                    bArr5 = null;
                } else {
                    bArr5 = primeExponentQ2.toByteArray();
                }
                if (crtCoefficient2 != null) {
                    bArr6 = crtCoefficient2.toByteArray();
                }
                return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(byteArray, bArr, byteArray2, bArr2, bArr3, bArr4, bArr5, bArr6));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e);
            }
        } else {
            throw new InvalidKeySpecException("privateExponent == null");
        }
    }

    static OpenSSLKey getInstance(RSAPrivateCrtKey rSAPrivateCrtKey) throws InvalidKeyException {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        if (rSAPrivateCrtKey.getFormat() == null) {
            return wrapPlatformKey(rSAPrivateCrtKey);
        }
        BigInteger modulus = rSAPrivateCrtKey.getModulus();
        BigInteger privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeyException("modulus == null");
        } else if (privateExponent != null) {
            try {
                BigInteger publicExponent2 = rSAPrivateCrtKey.getPublicExponent();
                BigInteger primeP2 = rSAPrivateCrtKey.getPrimeP();
                BigInteger primeQ2 = rSAPrivateCrtKey.getPrimeQ();
                BigInteger primeExponentP2 = rSAPrivateCrtKey.getPrimeExponentP();
                BigInteger primeExponentQ2 = rSAPrivateCrtKey.getPrimeExponentQ();
                BigInteger crtCoefficient2 = rSAPrivateCrtKey.getCrtCoefficient();
                byte[] byteArray = modulus.toByteArray();
                byte[] bArr6 = null;
                if (publicExponent2 == null) {
                    bArr = null;
                } else {
                    bArr = publicExponent2.toByteArray();
                }
                byte[] byteArray2 = privateExponent.toByteArray();
                if (primeP2 == null) {
                    bArr2 = null;
                } else {
                    bArr2 = primeP2.toByteArray();
                }
                if (primeQ2 == null) {
                    bArr3 = null;
                } else {
                    bArr3 = primeQ2.toByteArray();
                }
                if (primeExponentP2 == null) {
                    bArr4 = null;
                } else {
                    bArr4 = primeExponentP2.toByteArray();
                }
                if (primeExponentQ2 == null) {
                    bArr5 = null;
                } else {
                    bArr5 = primeExponentQ2.toByteArray();
                }
                if (crtCoefficient2 != null) {
                    bArr6 = crtCoefficient2.toByteArray();
                }
                return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(byteArray, bArr, byteArray2, bArr2, bArr3, bArr4, bArr5, bArr6));
            } catch (Exception e) {
                throw new InvalidKeyException(e);
            }
        } else {
            throw new InvalidKeyException("privateExponent == null");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public synchronized void readParams(byte[][] bArr) {
        super.readParams(bArr);
        if (bArr[1] != null) {
            this.publicExponent = new BigInteger(bArr[1]);
        }
        if (bArr[3] != null) {
            this.primeP = new BigInteger(bArr[3]);
        }
        if (bArr[4] != null) {
            this.primeQ = new BigInteger(bArr[4]);
        }
        if (bArr[5] != null) {
            this.primeExponentP = new BigInteger(bArr[5]);
        }
        if (bArr[6] != null) {
            this.primeExponentQ = new BigInteger(bArr[6]);
        }
        if (bArr[7] != null) {
            this.crtCoefficient = new BigInteger(bArr[7]);
        }
    }

    public BigInteger getPublicExponent() {
        ensureReadParams();
        return this.publicExponent;
    }

    public BigInteger getPrimeP() {
        ensureReadParams();
        return this.primeP;
    }

    public BigInteger getPrimeQ() {
        ensureReadParams();
        return this.primeQ;
    }

    public BigInteger getPrimeExponentP() {
        ensureReadParams();
        return this.primeExponentP;
    }

    public BigInteger getPrimeExponentQ() {
        ensureReadParams();
        return this.primeExponentQ;
    }

    public BigInteger getCrtCoefficient() {
        ensureReadParams();
        return this.crtCoefficient;
    }

    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLRSAPrivateKey) {
            return getOpenSSLKey().equals(((OpenSSLRSAPrivateKey) obj).getOpenSSLKey());
        }
        if (obj instanceof RSAPrivateCrtKey) {
            ensureReadParams();
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
            if (!getModulus().equals(rSAPrivateCrtKey.getModulus()) || !this.publicExponent.equals(rSAPrivateCrtKey.getPublicExponent()) || !getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) || !this.primeP.equals(rSAPrivateCrtKey.getPrimeP()) || !this.primeQ.equals(rSAPrivateCrtKey.getPrimeQ()) || !this.primeExponentP.equals(rSAPrivateCrtKey.getPrimeExponentP()) || !this.primeExponentQ.equals(rSAPrivateCrtKey.getPrimeExponentQ()) || !this.crtCoefficient.equals(rSAPrivateCrtKey.getCrtCoefficient())) {
                return false;
            }
            return true;
        } else if (!(obj instanceof RSAPrivateKey)) {
            return false;
        } else {
            ensureReadParams();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
            if (!getModulus().equals(rSAPrivateKey.getModulus()) || !getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent())) {
                return false;
            }
            return true;
        }
    }

    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public final int hashCode() {
        int hashCode = super.hashCode();
        BigInteger bigInteger = this.publicExponent;
        return bigInteger != null ? hashCode ^ bigInteger.hashCode() : hashCode;
    }

    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateCrtKey{");
        ensureReadParams();
        sb.append("modulus=");
        sb.append(getModulus().toString(16));
        if (this.publicExponent != null) {
            sb.append(',');
            sb.append("publicExponent=");
            sb.append(this.publicExponent.toString(16));
        }
        sb.append('}');
        return sb.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        byte[] byteArray = this.modulus.toByteArray();
        BigInteger bigInteger = this.publicExponent;
        byte[] bArr = null;
        byte[] byteArray2 = bigInteger == null ? null : bigInteger.toByteArray();
        byte[] byteArray3 = this.privateExponent.toByteArray();
        BigInteger bigInteger2 = this.primeP;
        byte[] byteArray4 = bigInteger2 == null ? null : bigInteger2.toByteArray();
        BigInteger bigInteger3 = this.primeQ;
        byte[] byteArray5 = bigInteger3 == null ? null : bigInteger3.toByteArray();
        BigInteger bigInteger4 = this.primeExponentP;
        byte[] byteArray6 = bigInteger4 == null ? null : bigInteger4.toByteArray();
        BigInteger bigInteger5 = this.primeExponentQ;
        byte[] byteArray7 = bigInteger5 == null ? null : bigInteger5.toByteArray();
        BigInteger bigInteger6 = this.crtCoefficient;
        if (bigInteger6 != null) {
            bArr = bigInteger6.toByteArray();
        }
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(byteArray, byteArray2, byteArray3, byteArray4, byteArray5, byteArray6, byteArray7, bArr));
        this.fetchedParams = true;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ensureReadParams();
        objectOutputStream.defaultWriteObject();
    }
}
