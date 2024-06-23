package org.conscrypt;

import com.tencent.smtt.sdk.TbsListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class KeyGeneratorImpl extends KeyGeneratorSpi {
    private final String algorithm;
    private int keySizeBits;
    protected SecureRandom secureRandom;

    private KeyGeneratorImpl(String str, int i) {
        this.algorithm = str;
        this.keySizeBits = i;
    }

    /* access modifiers changed from: protected */
    public void checkKeySize(int i) {
        if (i <= 0) {
            throw new InvalidParameterException("Key size must be positive");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(SecureRandom secureRandom2) {
        this.secureRandom = secureRandom2;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom2) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            throw new InvalidAlgorithmParameterException("No params provided");
        }
        throw new InvalidAlgorithmParameterException("Unknown param type: " + algorithmParameterSpec.getClass().getName());
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom2) {
        checkKeySize(i);
        this.keySizeBits = i;
        this.secureRandom = secureRandom2;
    }

    /* access modifiers changed from: protected */
    public byte[] doKeyGeneration(int i) {
        byte[] bArr = new byte[i];
        this.secureRandom.nextBytes(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public SecretKey engineGenerateKey() {
        if (this.secureRandom == null) {
            this.secureRandom = new SecureRandom();
        }
        return new SecretKeySpec(doKeyGeneration((this.keySizeBits + 7) / 8), this.algorithm);
    }

    public static final class HmacMD5 extends KeyGeneratorImpl {
        public HmacMD5() {
            super("HmacMD5", 128);
        }
    }

    public static final class HmacSHA1 extends KeyGeneratorImpl {
        public HmacSHA1() {
            super("HmacSHA1", 160);
        }
    }

    public static final class HmacSHA224 extends KeyGeneratorImpl {
        public HmacSHA224() {
            super("HmacSHA224", TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
        }
    }

    public static final class HmacSHA256 extends KeyGeneratorImpl {
        public HmacSHA256() {
            super("HmacSHA256", 256);
        }
    }

    public static final class HmacSHA384 extends KeyGeneratorImpl {
        public HmacSHA384() {
            super("HmacSHA384", 384);
        }
    }

    public static final class HmacSHA512 extends KeyGeneratorImpl {
        public HmacSHA512() {
            super("HmacSHA512", 512);
        }
    }

    public static final class DESEDE extends KeyGeneratorImpl {
        public DESEDE() {
            super("DESEDE", 192);
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i) {
            if (i != 112 && i != 168) {
                throw new InvalidParameterException("Key size must be either 112 or 168 bits");
            }
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.KeyGeneratorImpl
        public byte[] doKeyGeneration(int i) {
            byte[] bArr = new byte[24];
            this.secureRandom.nextBytes(bArr);
            for (int i2 = 0; i2 < 24; i2++) {
                if (Integer.bitCount(bArr[i2]) % 2 == 0) {
                    bArr[i2] = (byte) (bArr[i2] ^ 1);
                }
            }
            if (i == 14) {
                System.arraycopy(bArr, 0, bArr, 16, 8);
            }
            return bArr;
        }
    }

    public static final class AES extends KeyGeneratorImpl {
        public AES() {
            super("AES", 128);
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i) {
            if (i != 128 && i != 192 && i != 256) {
                throw new InvalidParameterException("Key size must be either 128, 192, or 256 bits");
            }
        }
    }

    public static final class ChaCha20 extends KeyGeneratorImpl {
        public ChaCha20() {
            super("ChaCha20", 256);
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i) {
            if (i != 256) {
                throw new InvalidParameterException("Key size must be 256 bits");
            }
        }
    }

    public static final class ARC4 extends KeyGeneratorImpl {
        public ARC4() {
            super("ARC4", 128);
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i) {
            if (i < 40 || 2048 < i) {
                throw new InvalidParameterException("Key size must be between 40 and 2048 bits");
            }
        }
    }
}
