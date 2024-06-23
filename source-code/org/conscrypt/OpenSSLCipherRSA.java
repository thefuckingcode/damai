package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

public abstract class OpenSSLCipherRSA extends CipherSpi {
    private byte[] buffer;
    private int bufferOffset;
    boolean encrypting;
    private boolean inputTooLarge;
    OpenSSLKey key;
    int padding = 1;
    boolean usingPrivateKey;

    /* access modifiers changed from: package-private */
    public void doCryptoInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException, InvalidKeyException {
    }

    /* access modifiers changed from: package-private */
    public abstract int doCryptoOperation(byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException;

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return null;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    OpenSSLCipherRSA(int i) {
        this.padding = i;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if (!"NONE".equals(upperCase) && !"ECB".equals(upperCase)) {
            throw new NoSuchAlgorithmException("mode not supported: " + str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if ("PKCS1PADDING".equals(upperCase)) {
            this.padding = 1;
        } else if ("NOPADDING".equals(upperCase)) {
            this.padding = 3;
        } else {
            throw new NoSuchPaddingException("padding not supported: " + str);
        }
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        if (this.encrypting) {
            return paddedBlockSizeBytes();
        }
        return keySizeBytes();
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        if (this.encrypting) {
            return keySizeBytes();
        }
        return paddedBlockSizeBytes();
    }

    /* access modifiers changed from: package-private */
    public int paddedBlockSizeBytes() {
        int keySizeBytes = keySizeBytes();
        return this.padding == 1 ? (keySizeBytes - 1) - 10 : keySizeBytes;
    }

    /* access modifiers changed from: package-private */
    public int keySizeBytes() {
        if (isInitialized()) {
            return NativeCrypto.RSA_size(this.key.getNativeRef());
        }
        throw new IllegalStateException("cipher is not initialized");
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.key != null;
    }

    /* access modifiers changed from: package-private */
    public void engineInitInternal(int i, Key key2, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (i == 1 || i == 3) {
            this.encrypting = true;
        } else if (i == 2 || i == 4) {
            this.encrypting = false;
        } else {
            throw new InvalidParameterException("Unsupported opmode " + i);
        }
        if (key2 instanceof OpenSSLRSAPrivateKey) {
            this.usingPrivateKey = true;
            this.key = ((OpenSSLRSAPrivateKey) key2).getOpenSSLKey();
        } else if (key2 instanceof RSAPrivateCrtKey) {
            this.usingPrivateKey = true;
            this.key = OpenSSLRSAPrivateCrtKey.getInstance((RSAPrivateCrtKey) key2);
        } else if (key2 instanceof RSAPrivateKey) {
            this.usingPrivateKey = true;
            this.key = OpenSSLRSAPrivateKey.getInstance((RSAPrivateKey) key2);
        } else if (key2 instanceof OpenSSLRSAPublicKey) {
            this.usingPrivateKey = false;
            this.key = ((OpenSSLRSAPublicKey) key2).getOpenSSLKey();
        } else if (key2 instanceof RSAPublicKey) {
            this.usingPrivateKey = false;
            this.key = OpenSSLRSAPublicKey.getInstance((RSAPublicKey) key2);
        } else if (key2 == null) {
            throw new InvalidKeyException("RSA private or public key is null");
        } else {
            throw new InvalidKeyException("Need RSA private or public key");
        }
        this.buffer = new byte[NativeCrypto.RSA_size(this.key.getNativeRef())];
        this.bufferOffset = 0;
        this.inputTooLarge = false;
        doCryptoInit(algorithmParameterSpec);
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key2) throws InvalidKeyException {
        if (key2 instanceof OpenSSLRSAPrivateKey) {
            return ((OpenSSLRSAPrivateKey) key2).getModulus().bitLength();
        }
        if (key2 instanceof RSAPrivateCrtKey) {
            return ((RSAPrivateCrtKey) key2).getModulus().bitLength();
        }
        if (key2 instanceof RSAPrivateKey) {
            return ((RSAPrivateKey) key2).getModulus().bitLength();
        }
        if (key2 instanceof OpenSSLRSAPublicKey) {
            return ((OpenSSLRSAPublicKey) key2).getModulus().bitLength();
        }
        if (key2 instanceof RSAPublicKey) {
            return ((RSAPublicKey) key2).getModulus().bitLength();
        }
        if (key2 == null) {
            throw new InvalidKeyException("RSA private or public key is null");
        }
        throw new InvalidKeyException("Need RSA private or public key");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key2, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInitInternal(i, key2, null);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("Algorithm parameters rejected when none supplied", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key2, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            engineInitInternal(i, key2, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("unknown param type: " + algorithmParameterSpec.getClass().getName());
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key2, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInitInternal(i, key2, null);
            return;
        }
        throw new InvalidAlgorithmParameterException("unknown param type: " + algorithmParameters.getClass().getName());
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int i3 = this.bufferOffset;
        int i4 = i3 + i2;
        byte[] bArr2 = this.buffer;
        if (i4 > bArr2.length) {
            this.inputTooLarge = true;
            return EmptyArray.BYTE;
        }
        System.arraycopy(bArr, i, bArr2, i3, i2);
        this.bufferOffset += i2;
        return EmptyArray.BYTE;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        engineUpdate(bArr, i, i2);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            engineUpdate(bArr, i, i2);
        }
        if (!this.inputTooLarge) {
            int i3 = this.bufferOffset;
            byte[] bArr2 = this.buffer;
            if (i3 != bArr2.length) {
                if (this.padding == 3) {
                    byte[] bArr3 = new byte[bArr2.length];
                    System.arraycopy(bArr2, 0, bArr3, bArr2.length - i3, i3);
                    bArr2 = bArr3;
                } else {
                    bArr2 = Arrays.copyOf(bArr2, i3);
                }
            }
            int length = this.buffer.length;
            byte[] bArr4 = new byte[length];
            int doCryptoOperation = doCryptoOperation(bArr2, bArr4);
            if (!this.encrypting && doCryptoOperation != length) {
                bArr4 = Arrays.copyOf(bArr4, doCryptoOperation);
            }
            this.bufferOffset = 0;
            return bArr4;
        }
        throw new IllegalBlockSizeException("input must be under " + this.buffer.length + " bytes");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        int length = engineDoFinal.length + i3;
        if (length <= bArr2.length) {
            System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
            return engineDoFinal.length;
        }
        throw new ShortBufferException("output buffer is too small " + bArr2.length + " < " + length);
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key2) throws IllegalBlockSizeException, InvalidKeyException {
        try {
            byte[] encoded = key2.getEncoded();
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

    public static abstract class DirectRSA extends OpenSSLCipherRSA {
        public DirectRSA(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.OpenSSLCipherRSA
        public int doCryptoOperation(byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException {
            if (!this.encrypting) {
                try {
                    if (this.usingPrivateKey) {
                        return NativeCrypto.RSA_private_decrypt(bArr.length, bArr, bArr2, this.key.getNativeRef(), this.padding);
                    }
                    return NativeCrypto.RSA_public_decrypt(bArr.length, bArr, bArr2, this.key.getNativeRef(), this.padding);
                } catch (SignatureException e) {
                    IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
                    illegalBlockSizeException.initCause(e);
                    throw illegalBlockSizeException;
                }
            } else if (this.usingPrivateKey) {
                return NativeCrypto.RSA_private_encrypt(bArr.length, bArr, bArr2, this.key.getNativeRef(), this.padding);
            } else {
                return NativeCrypto.RSA_public_encrypt(bArr.length, bArr, bArr2, this.key.getNativeRef(), this.padding);
            }
        }
    }

    public static final class PKCS1 extends DirectRSA {
        public PKCS1() {
            super(1);
        }
    }

    public static final class Raw extends DirectRSA {
        public Raw() {
            super(3);
        }
    }

    public static class OAEP extends OpenSSLCipherRSA {
        private byte[] label;
        private long mgf1Md;
        private long oaepMd;
        private int oaepMdSizeBytes;
        private NativeRef.EVP_PKEY_CTX pkeyCtx;

        public OAEP(long j, int i) {
            super(4);
            this.mgf1Md = j;
            this.oaepMd = j;
            this.oaepMdSizeBytes = i;
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.OpenSSLCipherRSA
        public AlgorithmParameters engineGetParameters() {
            PSource.PSpecified pSpecified;
            if (!isInitialized()) {
                return null;
            }
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("OAEP");
                if (this.label == null) {
                    pSpecified = PSource.PSpecified.DEFAULT;
                } else {
                    pSpecified = new PSource.PSpecified(this.label);
                }
                instance.init(new OAEPParameterSpec(EvpMdRef.getJcaDigestAlgorithmStandardNameFromEVP_MD(this.oaepMd), "MGF1", new MGF1ParameterSpec(EvpMdRef.getJcaDigestAlgorithmStandardNameFromEVP_MD(this.mgf1Md)), pSpecified));
                return instance;
            } catch (NoSuchAlgorithmException e) {
                throw ((Error) new AssertionError("OAEP not supported").initCause(e));
            } catch (InvalidParameterSpecException unused) {
                throw new RuntimeException("No providers of AlgorithmParameters.OAEP available");
            }
        }

        /* access modifiers changed from: protected */
        @Override // javax.crypto.CipherSpi, org.conscrypt.OpenSSLCipherRSA
        public void engineSetPadding(String str) throws NoSuchPaddingException {
            if (str.toUpperCase(Locale.US).equals("OAEPPADDING")) {
                this.padding = 4;
                return;
            }
            throw new NoSuchPaddingException("Only OAEP padding is supported");
        }

        /* access modifiers changed from: protected */
        @Override // javax.crypto.CipherSpi, org.conscrypt.OpenSSLCipherRSA
        public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
            if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof OAEPParameterSpec)) {
                engineInitInternal(i, key, algorithmParameterSpec);
                return;
            }
            throw new InvalidAlgorithmParameterException("Only OAEPParameterSpec accepted in OAEP mode");
        }

        /* access modifiers changed from: protected */
        @Override // javax.crypto.CipherSpi, org.conscrypt.OpenSSLCipherRSA
        public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
            OAEPParameterSpec oAEPParameterSpec;
            if (algorithmParameters != null) {
                try {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
                } catch (InvalidParameterSpecException e) {
                    throw new InvalidAlgorithmParameterException("Only OAEP parameters are supported", e);
                }
            } else {
                oAEPParameterSpec = null;
            }
            engineInitInternal(i, key, oAEPParameterSpec);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.OpenSSLCipherRSA
        public void engineInitInternal(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
            if (i == 1 || i == 3) {
                if (!(key instanceof PublicKey)) {
                    throw new InvalidKeyException("Only public keys may be used to encrypt");
                }
            } else if ((i == 2 || i == 4) && !(key instanceof PrivateKey)) {
                throw new InvalidKeyException("Only private keys may be used to decrypt");
            }
            OpenSSLCipherRSA.super.engineInitInternal(i, key, algorithmParameterSpec);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.OpenSSLCipherRSA
        public void doCryptoInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException, InvalidKeyException {
            long j;
            if (this.encrypting) {
                j = NativeCrypto.EVP_PKEY_encrypt_init(this.key.getNativeRef());
            } else {
                j = NativeCrypto.EVP_PKEY_decrypt_init(this.key.getNativeRef());
            }
            this.pkeyCtx = new NativeRef.EVP_PKEY_CTX(j);
            if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                readOAEPParameters((OAEPParameterSpec) algorithmParameterSpec);
            }
            NativeCrypto.EVP_PKEY_CTX_set_rsa_padding(this.pkeyCtx.address, 4);
            NativeCrypto.EVP_PKEY_CTX_set_rsa_oaep_md(this.pkeyCtx.address, this.oaepMd);
            NativeCrypto.EVP_PKEY_CTX_set_rsa_mgf1_md(this.pkeyCtx.address, this.mgf1Md);
            byte[] bArr = this.label;
            if (bArr != null && bArr.length > 0) {
                NativeCrypto.EVP_PKEY_CTX_set_rsa_oaep_label(this.pkeyCtx.address, this.label);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.OpenSSLCipherRSA
        public int paddedBlockSizeBytes() {
            return keySizeBytes() - ((this.oaepMdSizeBytes * 2) + 2);
        }

        private void readOAEPParameters(OAEPParameterSpec oAEPParameterSpec) throws InvalidAlgorithmParameterException {
            String upperCase = oAEPParameterSpec.getMGFAlgorithm().toUpperCase(Locale.US);
            AlgorithmParameterSpec mGFParameters = oAEPParameterSpec.getMGFParameters();
            if (("MGF1".equals(upperCase) || "1.2.840.113549.1.1.8".equals(upperCase)) && (mGFParameters instanceof MGF1ParameterSpec)) {
                MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) mGFParameters;
                String upperCase2 = oAEPParameterSpec.getDigestAlgorithm().toUpperCase(Locale.US);
                try {
                    this.oaepMd = EvpMdRef.getEVP_MDByJcaDigestAlgorithmStandardName(upperCase2);
                    this.oaepMdSizeBytes = EvpMdRef.getDigestSizeBytesByJcaDigestAlgorithmStandardName(upperCase2);
                    this.mgf1Md = EvpMdRef.getEVP_MDByJcaDigestAlgorithmStandardName(mGF1ParameterSpec.getDigestAlgorithm());
                    PSource pSource = oAEPParameterSpec.getPSource();
                    if (!"PSpecified".equals(pSource.getAlgorithm()) || !(pSource instanceof PSource.PSpecified)) {
                        throw new InvalidAlgorithmParameterException("Only PSpecified accepted for PSource");
                    }
                    this.label = ((PSource.PSpecified) pSource).getValue();
                } catch (NoSuchAlgorithmException e) {
                    throw new InvalidAlgorithmParameterException(e);
                }
            } else {
                throw new InvalidAlgorithmParameterException("Only MGF1 supported as mask generation function");
            }
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.OpenSSLCipherRSA
        public int doCryptoOperation(byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException {
            if (this.encrypting) {
                return NativeCrypto.EVP_PKEY_encrypt(this.pkeyCtx, bArr2, 0, bArr, 0, bArr.length);
            }
            return NativeCrypto.EVP_PKEY_decrypt(this.pkeyCtx, bArr2, 0, bArr, 0, bArr.length);
        }

        public static final class SHA1 extends OAEP {
            public SHA1() {
                super(EvpMdRef.SHA1.EVP_MD, EvpMdRef.SHA1.SIZE_BYTES);
            }
        }

        public static final class SHA224 extends OAEP {
            public SHA224() {
                super(EvpMdRef.SHA224.EVP_MD, EvpMdRef.SHA224.SIZE_BYTES);
            }
        }

        public static final class SHA256 extends OAEP {
            public SHA256() {
                super(EvpMdRef.SHA256.EVP_MD, EvpMdRef.SHA256.SIZE_BYTES);
            }
        }

        public static final class SHA384 extends OAEP {
            public SHA384() {
                super(EvpMdRef.SHA384.EVP_MD, EvpMdRef.SHA384.SIZE_BYTES);
            }
        }

        public static final class SHA512 extends OAEP {
            public SHA512() {
                super(EvpMdRef.SHA512.EVP_MD, EvpMdRef.SHA512.SIZE_BYTES);
            }
        }
    }
}
