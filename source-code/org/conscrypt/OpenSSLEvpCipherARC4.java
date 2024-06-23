package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

public class OpenSSLEvpCipherARC4 extends OpenSSLEvpCipher {
    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ARCFOUR";
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i, OpenSSLCipher.Mode mode) {
        return "rc4";
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public boolean supportsVariableSizeKey() {
        return true;
    }

    public OpenSSLEvpCipherARC4() {
        super(OpenSSLCipher.Mode.ECB, OpenSSLCipher.Padding.NOPADDING);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode != OpenSSLCipher.Mode.NONE && mode != OpenSSLCipher.Mode.ECB) {
            throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
        }
    }
}
