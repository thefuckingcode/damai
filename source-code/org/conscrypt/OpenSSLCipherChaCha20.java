package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

public class OpenSSLCipherChaCha20 extends OpenSSLCipher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLOCK_SIZE_BYTES = 64;
    private static final int NONCE_SIZE_BYTES = 12;
    private int blockCounter = 0;
    private int currentBlockConsumedBytes = 0;

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ChaCha20";
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i) {
        return i;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i) {
        return i;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
            if (ivParameterSpec.getIV().length == 12) {
                this.iv = ivParameterSpec.getIV();
                return;
            }
            throw new InvalidAlgorithmParameterException("IV must be 12 bytes long");
        } else if (isEncrypting()) {
            this.iv = new byte[12];
            if (secureRandom != null) {
                secureRandom.nextBytes(this.iv);
            } else {
                NativeCrypto.RAND_bytes(this.iv);
            }
        } else {
            throw new InvalidAlgorithmParameterException("IV must be specified when decrypting");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
        int i5;
        int i6;
        int i7;
        if (i2 <= bArr2.length - i3) {
            int i8 = this.currentBlockConsumedBytes;
            if (i8 > 0) {
                int min = Math.min(64 - i8, i2);
                byte[] bArr3 = new byte[64];
                byte[] bArr4 = new byte[64];
                System.arraycopy(bArr, i, bArr3, this.currentBlockConsumedBytes, min);
                NativeCrypto.chacha20_encrypt_decrypt(bArr3, 0, bArr4, 0, 64, this.encodedKey, this.iv, this.blockCounter);
                System.arraycopy(bArr4, this.currentBlockConsumedBytes, bArr2, i3, min);
                int i9 = this.currentBlockConsumedBytes + min;
                this.currentBlockConsumedBytes = i9;
                if (i9 < 64) {
                    return min;
                }
                this.currentBlockConsumedBytes = 0;
                int i10 = i + min;
                int i11 = i3 + min;
                int i12 = i2 - min;
                this.blockCounter++;
                i5 = i11;
                i6 = i10;
                i7 = i12;
            } else {
                i6 = i;
                i7 = i2;
                i5 = i3;
            }
            NativeCrypto.chacha20_encrypt_decrypt(bArr, i6, bArr2, i5, i7, this.encodedKey, this.iv, this.blockCounter);
            this.currentBlockConsumedBytes = i7 % 64;
            this.blockCounter += i7 / 64;
            return i2;
        }
        throw new ShortBufferException("Insufficient output space");
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        reset();
        return 0;
    }

    private void reset() {
        this.blockCounter = 0;
        this.currentBlockConsumedBytes = 0;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i != 32) {
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode != OpenSSLCipher.Mode.NONE) {
            throw new NoSuchAlgorithmException("Mode must be NONE");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding");
        }
    }
}
