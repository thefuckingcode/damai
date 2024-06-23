package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class OpenSSLCipher extends CipherSpi {
    private int blockSize;
    byte[] encodedKey;
    private boolean encrypting;
    byte[] iv;
    Mode mode = Mode.ECB;
    private Padding padding = Padding.PKCS5PADDING;

    /* access modifiers changed from: package-private */
    public abstract void checkSupportedKeySize(int i) throws InvalidKeyException;

    /* access modifiers changed from: package-private */
    public abstract void checkSupportedMode(Mode mode2) throws NoSuchAlgorithmException;

    /* access modifiers changed from: package-private */
    public abstract void checkSupportedPadding(Padding padding2) throws NoSuchPaddingException;

    /* access modifiers changed from: package-private */
    public abstract int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException;

    /* access modifiers changed from: package-private */
    public abstract void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* access modifiers changed from: package-private */
    public abstract String getBaseCipherName();

    /* access modifiers changed from: package-private */
    public abstract int getCipherBlockSize();

    /* access modifiers changed from: package-private */
    public abstract int getOutputSizeForFinal(int i);

    /* access modifiers changed from: package-private */
    public abstract int getOutputSizeForUpdate(int i);

    /* access modifiers changed from: package-private */
    public boolean supportsVariableSizeIv() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsVariableSizeKey() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException;

    enum Mode {
        NONE,
        CBC,
        CTR,
        ECB,
        GCM,
        GCM_SIV,
        POLY1305;

        public static Mode getNormalized(String str) {
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.equals("GCM-SIV")) {
                return GCM_SIV;
            }
            if (!upperCase.equals("GCM_SIV")) {
                return valueOf(upperCase);
            }
            throw new IllegalArgumentException("Invalid mode");
        }
    }

    enum Padding {
        NOPADDING,
        PKCS5PADDING,
        PKCS7PADDING;

        public static Padding getNormalized(String str) {
            Padding valueOf = valueOf(str.toUpperCase(Locale.US));
            return valueOf == PKCS7PADDING ? PKCS5PADDING : valueOf;
        }
    }

    OpenSSLCipher() {
    }

    OpenSSLCipher(Mode mode2, Padding padding2) {
        this.mode = mode2;
        this.padding = padding2;
        this.blockSize = getCipherBlockSize();
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        try {
            Mode normalized = Mode.getNormalized(str);
            checkSupportedMode(normalized);
            this.mode = normalized;
        } catch (IllegalArgumentException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = new NoSuchAlgorithmException("No such mode: " + str);
            noSuchAlgorithmException.initCause(e);
            throw noSuchAlgorithmException;
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        try {
            Padding normalized = Padding.getNormalized(str);
            checkSupportedPadding(normalized);
            this.padding = normalized;
        } catch (IllegalArgumentException e) {
            NoSuchPaddingException noSuchPaddingException = new NoSuchPaddingException("No such padding: " + str);
            noSuchPaddingException.initCause(e);
            throw noSuchPaddingException;
        }
    }

    /* access modifiers changed from: package-private */
    public Padding getPadding() {
        return this.padding;
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return this.blockSize;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return Math.max(getOutputSizeForUpdate(i), getOutputSizeForFinal(i));
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return this.iv;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        byte[] bArr = this.iv;
        if (bArr != null && bArr.length > 0) {
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance(getBaseCipherName());
                instance.init(new IvParameterSpec(this.iv));
                return instance;
            } catch (NoSuchAlgorithmException | InvalidParameterSpecException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            return null;
        }
        try {
            return algorithmParameters.getParameterSpec(IvParameterSpec.class);
        } catch (InvalidParameterSpecException e) {
            throw new InvalidAlgorithmParameterException("Params must be convertible to IvParameterSpec", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        checkAndSetEncodedKey(i, key);
        try {
            engineInitInternal(this.encodedKey, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        checkAndSetEncodedKey(i, key);
        engineInitInternal(this.encodedKey, algorithmParameterSpec, secureRandom);
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        engineInit(i, key, getParameterSpec(algorithmParameters), secureRandom);
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int outputSizeForUpdate = getOutputSizeForUpdate(i2);
        if (outputSizeForUpdate > 0) {
            bArr2 = new byte[outputSizeForUpdate];
        } else {
            bArr2 = EmptyArray.BYTE;
        }
        try {
            int updateInternal = updateInternal(bArr, i, i2, bArr2, 0, outputSizeForUpdate);
            if (bArr2.length == updateInternal) {
                return bArr2;
            }
            if (updateInternal == 0) {
                return EmptyArray.BYTE;
            }
            return Arrays.copyOfRange(bArr2, 0, updateInternal);
        } catch (ShortBufferException unused) {
            throw new RuntimeException("calculated buffer size was wrong: " + outputSizeForUpdate);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        return updateInternal(bArr, i, i2, bArr2, i3, getOutputSizeForUpdate(i2));
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        int i3;
        int outputSizeForFinal = getOutputSizeForFinal(i2);
        byte[] bArr2 = new byte[outputSizeForFinal];
        if (i2 > 0) {
            try {
                i3 = updateInternal(bArr, i, i2, bArr2, 0, outputSizeForFinal);
            } catch (ShortBufferException e) {
                throw new RuntimeException("our calculated buffer was too small", e);
            }
        } else {
            i3 = 0;
        }
        try {
            int doFinalInternal = i3 + doFinalInternal(bArr2, i3, outputSizeForFinal - i3);
            if (doFinalInternal == outputSizeForFinal) {
                return bArr2;
            }
            if (doFinalInternal == 0) {
                return EmptyArray.BYTE;
            }
            return Arrays.copyOfRange(bArr2, 0, doFinalInternal);
        } catch (ShortBufferException e2) {
            throw new RuntimeException("our calculated buffer was too small", e2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        int i4;
        if (bArr2 != null) {
            int outputSizeForFinal = getOutputSizeForFinal(i2);
            if (i2 > 0) {
                i4 = updateInternal(bArr, i, i2, bArr2, i3, outputSizeForFinal);
                i3 += i4;
                outputSizeForFinal -= i4;
            } else {
                i4 = 0;
            }
            return i4 + doFinalInternal(bArr2, i3, outputSizeForFinal);
        }
        throw new NullPointerException("output == null");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e);
            throw illegalBlockSizeException;
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(engineDoFinal));
            }
            if (i == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
            }
            if (i == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i);
        } catch (IllegalBlockSizeException e) {
            throw new InvalidKeyException(e);
        } catch (BadPaddingException e2) {
            throw new InvalidKeyException(e2);
        } catch (InvalidKeySpecException e3) {
            throw new InvalidKeyException(e3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key instanceof SecretKey) {
            byte[] encoded = key.getEncoded();
            if (encoded != null) {
                checkSupportedKeySize(encoded.length);
                return encoded.length * 8;
            }
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        throw new InvalidKeyException("Only SecretKey is supported");
    }

    private byte[] checkAndSetEncodedKey(int i, Key key) throws InvalidKeyException {
        if (i == 1 || i == 3) {
            this.encrypting = true;
        } else if (i == 2 || i == 4) {
            this.encrypting = false;
        } else {
            throw new InvalidParameterException("Unsupported opmode " + i);
        }
        if (key instanceof SecretKey) {
            byte[] encoded = key.getEncoded();
            if (encoded != null) {
                checkSupportedKeySize(encoded.length);
                this.encodedKey = encoded;
                return encoded;
            }
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        throw new InvalidKeyException("Only SecretKey is supported");
    }

    /* access modifiers changed from: package-private */
    public boolean isEncrypting() {
        return this.encrypting;
    }
}
