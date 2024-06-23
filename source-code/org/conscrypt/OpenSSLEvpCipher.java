package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLCipher;

public abstract class OpenSSLEvpCipher extends OpenSSLCipher {
    private boolean calledUpdate;
    private final NativeRef.EVP_CIPHER_CTX cipherCtx = new NativeRef.EVP_CIPHER_CTX(NativeCrypto.EVP_CIPHER_CTX_new());
    private int modeBlockSize;

    /* access modifiers changed from: package-private */
    public abstract String getCipherName(int i, OpenSSLCipher.Mode mode);

    public OpenSSLEvpCipher(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] iv = algorithmParameterSpec instanceof IvParameterSpec ? ((IvParameterSpec) algorithmParameterSpec).getIV() : null;
        long EVP_get_cipherbyname = NativeCrypto.EVP_get_cipherbyname(getCipherName(bArr.length, this.mode));
        if (EVP_get_cipherbyname != 0) {
            boolean isEncrypting = isEncrypting();
            int EVP_CIPHER_iv_length = NativeCrypto.EVP_CIPHER_iv_length(EVP_get_cipherbyname);
            if (iv != null || EVP_CIPHER_iv_length == 0) {
                if (EVP_CIPHER_iv_length == 0 && iv != null) {
                    throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
                } else if (!(iv == null || iv.length == EVP_CIPHER_iv_length)) {
                    throw new InvalidAlgorithmParameterException("expected IV length of " + EVP_CIPHER_iv_length + " but was " + iv.length);
                }
            } else if (isEncrypting) {
                iv = new byte[EVP_CIPHER_iv_length];
                if (secureRandom != null) {
                    secureRandom.nextBytes(iv);
                } else {
                    NativeCrypto.RAND_bytes(iv);
                }
            } else {
                throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
            }
            this.iv = iv;
            if (supportsVariableSizeKey()) {
                NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, EVP_get_cipherbyname, null, null, isEncrypting);
                NativeCrypto.EVP_CIPHER_CTX_set_key_length(this.cipherCtx, bArr.length);
                NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0, bArr, iv, isEncrypting());
            } else {
                NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, EVP_get_cipherbyname, bArr, iv, isEncrypting);
            }
            NativeCrypto.EVP_CIPHER_CTX_set_padding(this.cipherCtx, getPadding() == OpenSSLCipher.Padding.PKCS5PADDING);
            this.modeBlockSize = NativeCrypto.EVP_CIPHER_CTX_block_size(this.cipherCtx);
            this.calledUpdate = false;
            return;
        }
        throw new InvalidAlgorithmParameterException("Cannot find name for key length = " + (bArr.length * 8) + " and mode = " + this.mode);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
        int length = bArr2.length - i3;
        if (length >= i4) {
            this.calledUpdate = true;
            return (NativeCrypto.EVP_CipherUpdate(this.cipherCtx, bArr2, i3, bArr, i, i2) + i3) - i3;
        }
        throw new ShortBufferException("output buffer too small during update: " + length + " < " + i4);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i3;
        if (!isEncrypting() && !this.calledUpdate) {
            return 0;
        }
        int length = bArr.length - i;
        if (length >= i2) {
            i3 = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr, i);
        } else {
            byte[] bArr2 = new byte[i2];
            int EVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr2, 0);
            if (EVP_CipherFinal_ex <= length) {
                if (EVP_CipherFinal_ex > 0) {
                    System.arraycopy(bArr2, 0, bArr, i, EVP_CipherFinal_ex);
                }
                i3 = EVP_CipherFinal_ex;
            } else {
                throw new ShortBufferException("buffer is too short: " + EVP_CipherFinal_ex + " > " + length);
            }
        }
        reset();
        return (i3 + i) - i;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i) {
        if (this.modeBlockSize == 1) {
            return i;
        }
        int i2 = NativeCrypto.get_EVP_CIPHER_CTX_buf_len(this.cipherCtx);
        if (getPadding() == OpenSSLCipher.Padding.NOPADDING) {
            return i2 + i;
        }
        int i3 = i + i2;
        int i4 = 0;
        int i5 = i3 + (NativeCrypto.get_EVP_CIPHER_CTX_final_used(this.cipherCtx) ? this.modeBlockSize : 0);
        if (i5 % this.modeBlockSize != 0 || isEncrypting()) {
            i4 = this.modeBlockSize;
        }
        int i6 = i5 + i4;
        return i6 - (i6 % this.modeBlockSize);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i) {
        return getOutputSizeForFinal(i);
    }

    private void reset() {
        NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0, this.encodedKey, this.iv, isEncrypting());
        this.calledUpdate = false;
    }
}
