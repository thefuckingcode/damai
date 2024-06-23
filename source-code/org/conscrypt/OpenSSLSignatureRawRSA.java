package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public final class OpenSSLSignatureRawRSA extends SignatureSpi {
    private byte[] inputBuffer;
    private boolean inputIsTooLong;
    private int inputOffset;
    private OpenSSLKey key;

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) throws InvalidParameterException {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        int i = this.inputOffset;
        int i2 = i + 1;
        this.inputOffset = i2;
        byte[] bArr = this.inputBuffer;
        if (i2 > bArr.length) {
            this.inputIsTooLong = true;
        } else {
            bArr[i] = b;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        int i3 = this.inputOffset;
        int i4 = i3 + i2;
        this.inputOffset = i4;
        byte[] bArr2 = this.inputBuffer;
        if (i4 > bArr2.length) {
            this.inputIsTooLong = true;
        } else {
            System.arraycopy(bArr, i, bArr2, i3, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof OpenSSLRSAPrivateKey) {
            this.key = ((OpenSSLRSAPrivateKey) privateKey).getOpenSSLKey();
        } else if (privateKey instanceof RSAPrivateCrtKey) {
            this.key = OpenSSLRSAPrivateCrtKey.getInstance((RSAPrivateCrtKey) privateKey);
        } else if (privateKey instanceof RSAPrivateKey) {
            this.key = OpenSSLRSAPrivateKey.getInstance((RSAPrivateKey) privateKey);
        } else {
            throw new InvalidKeyException("Need RSA private key");
        }
        this.inputBuffer = new byte[NativeCrypto.RSA_size(this.key.getNativeRef())];
        this.inputOffset = 0;
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof OpenSSLRSAPublicKey) {
            this.key = ((OpenSSLRSAPublicKey) publicKey).getOpenSSLKey();
        } else if (publicKey instanceof RSAPublicKey) {
            this.key = OpenSSLRSAPublicKey.getInstance((RSAPublicKey) publicKey);
        } else {
            throw new InvalidKeyException("Need RSA public key");
        }
        this.inputBuffer = new byte[NativeCrypto.RSA_size(this.key.getNativeRef())];
        this.inputOffset = 0;
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        OpenSSLKey openSSLKey = this.key;
        if (openSSLKey == null) {
            throw new SignatureException("Need RSA private key");
        } else if (!this.inputIsTooLong) {
            byte[] bArr = this.inputBuffer;
            byte[] bArr2 = new byte[bArr.length];
            try {
                NativeCrypto.RSA_private_encrypt(this.inputOffset, bArr, bArr2, openSSLKey.getNativeRef(), 1);
                this.inputOffset = 0;
                return bArr2;
            } catch (Exception e) {
                throw new SignatureException(e);
            } catch (Throwable th) {
                this.inputOffset = 0;
                throw th;
            }
        } else {
            throw new SignatureException("input length " + this.inputOffset + " != " + this.inputBuffer.length + " (modulus size)");
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        OpenSSLKey openSSLKey = this.key;
        if (openSSLKey == null) {
            throw new SignatureException("Need RSA public key");
        } else if (this.inputIsTooLong) {
            return false;
        } else {
            int length = bArr.length;
            byte[] bArr2 = this.inputBuffer;
            if (length <= bArr2.length) {
                byte[] bArr3 = new byte[bArr2.length];
                try {
                    boolean z = true;
                    int RSA_public_decrypt = NativeCrypto.RSA_public_decrypt(bArr.length, bArr, bArr3, openSSLKey.getNativeRef(), 1);
                    try {
                        if (RSA_public_decrypt != this.inputOffset) {
                            z = false;
                        }
                        for (int i = 0; i < RSA_public_decrypt; i++) {
                            if (this.inputBuffer[i] != bArr3[i]) {
                                z = false;
                            }
                        }
                        this.inputOffset = 0;
                        return z;
                    } catch (Exception e) {
                        throw new SignatureException(e);
                    } catch (Throwable th) {
                        this.inputOffset = 0;
                        throw th;
                    }
                } catch (SignatureException e2) {
                    throw e2;
                } catch (Exception unused) {
                    this.inputOffset = 0;
                    return false;
                }
            } else {
                throw new SignatureException("Input signature length is too large: " + bArr.length + " > " + this.inputBuffer.length);
            }
        }
    }
}
