package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.conscrypt.OpenSSLCipher;

public class OpenSSLAeadCipherChaCha20 extends OpenSSLAeadCipher {
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

    public OpenSSLAeadCipherChaCha20() {
        super(OpenSSLCipher.Mode.POLY1305);
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
        if (mode != OpenSSLCipher.Mode.POLY1305) {
            throw new NoSuchAlgorithmException("Mode must be Poly1305");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLAeadCipher
    public long getEVP_AEAD(int i) throws InvalidKeyException {
        if (i == 32) {
            return NativeCrypto.EVP_aead_chacha20_poly1305();
        }
        throw new RuntimeException("Unexpected key length: " + i);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher, org.conscrypt.OpenSSLAeadCipher
    public int getOutputSizeForFinal(int i) {
        if (isEncrypting()) {
            return this.bufCount + i + 16;
        }
        return Math.max(0, (this.bufCount + i) - 16);
    }
}
