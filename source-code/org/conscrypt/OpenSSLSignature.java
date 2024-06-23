package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

public class OpenSSLSignature extends SignatureSpi {
    private NativeRef.EVP_MD_CTX ctx;
    private final EngineType engineType;
    private final long evpMdRef;
    private long evpPkeyCtx;
    private OpenSSLKey key;
    private boolean signing;
    private final byte[] singleByte;

    /* access modifiers changed from: private */
    public enum EngineType {
        RSA,
        EC
    }

    /* access modifiers changed from: protected */
    public void configureEVP_PKEY_CTX(long j) throws InvalidAlgorithmParameterException {
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    @Deprecated
    public Object engineGetParameter(String str) throws InvalidParameterException {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    @Deprecated
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
    }

    /* synthetic */ OpenSSLSignature(long j, EngineType engineType2, AnonymousClass1 r4) {
        this(j, engineType2);
    }

    private OpenSSLSignature(long j, EngineType engineType2) {
        this.singleByte = new byte[1];
        this.engineType = engineType2;
        this.evpMdRef = j;
    }

    private void resetContext() throws InvalidAlgorithmParameterException {
        NativeRef.EVP_MD_CTX evp_md_ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
        if (this.signing) {
            this.evpPkeyCtx = NativeCrypto.EVP_DigestSignInit(evp_md_ctx, this.evpMdRef, this.key.getNativeRef());
        } else {
            this.evpPkeyCtx = NativeCrypto.EVP_DigestVerifyInit(evp_md_ctx, this.evpMdRef, this.key.getNativeRef());
        }
        configureEVP_PKEY_CTX(this.evpPkeyCtx);
        this.ctx = evp_md_ctx;
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        engineUpdate(bArr, 0, 1);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        NativeRef.EVP_MD_CTX evp_md_ctx = this.ctx;
        if (this.signing) {
            NativeCrypto.EVP_DigestSignUpdate(evp_md_ctx, bArr, i, i2);
        } else {
            NativeCrypto.EVP_DigestVerifyUpdate(evp_md_ctx, bArr, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!byteBuffer.isDirect()) {
                super.engineUpdate(byteBuffer);
                return;
            }
            long directBufferAddress = NativeCrypto.getDirectBufferAddress(byteBuffer);
            if (directBufferAddress == 0) {
                super.engineUpdate(byteBuffer);
                return;
            }
            int position = byteBuffer.position();
            if (position >= 0) {
                long j = directBufferAddress + ((long) position);
                int remaining = byteBuffer.remaining();
                if (remaining >= 0) {
                    NativeRef.EVP_MD_CTX evp_md_ctx = this.ctx;
                    if (this.signing) {
                        NativeCrypto.EVP_DigestSignUpdateDirect(evp_md_ctx, j, remaining);
                    } else {
                        NativeCrypto.EVP_DigestVerifyUpdateDirect(evp_md_ctx, j, remaining);
                    }
                    byteBuffer.position(position + remaining);
                    return;
                }
                throw new RuntimeException("Negative remaining amount");
            }
            throw new RuntimeException("Negative position");
        }
    }

    private void checkEngineType(OpenSSLKey openSSLKey) throws InvalidKeyException {
        int EVP_PKEY_type = NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef());
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[this.engineType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new InvalidKeyException("Key must be of type " + this.engineType);
            } else if (EVP_PKEY_type != 408) {
                throw new InvalidKeyException("Signature initialized as " + this.engineType + " (not EC)");
            }
        } else if (EVP_PKEY_type != 6) {
            throw new InvalidKeyException("Signature initialized as " + this.engineType + " (not RSA)");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.conscrypt.OpenSSLSignature$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[EngineType.values().length];
            $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType = iArr;
            iArr[EngineType.RSA.ordinal()] = 1;
            $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[EngineType.EC.ordinal()] = 2;
        }
    }

    private void initInternal(OpenSSLKey openSSLKey, boolean z) throws InvalidKeyException {
        checkEngineType(openSSLKey);
        this.key = openSSLKey;
        this.signing = z;
        try {
            resetContext();
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        initInternal(OpenSSLKey.fromPrivateKey(privateKey), true);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        initInternal(OpenSSLKey.fromPublicKey(publicKey), false);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            byte[] EVP_DigestSignFinal = NativeCrypto.EVP_DigestSignFinal(this.ctx);
            try {
                resetContext();
                return EVP_DigestSignFinal;
            } catch (InvalidAlgorithmParameterException unused) {
                throw new AssertionError("Reset of context failed after it was successful once");
            }
        } catch (Exception e) {
            throw new SignatureException(e);
        } catch (Throwable th) {
            try {
                resetContext();
                throw th;
            } catch (InvalidAlgorithmParameterException unused2) {
                throw new AssertionError("Reset of context failed after it was successful once");
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        try {
            boolean EVP_DigestVerifyFinal = NativeCrypto.EVP_DigestVerifyFinal(this.ctx, bArr, 0, bArr.length);
            try {
                resetContext();
                return EVP_DigestVerifyFinal;
            } catch (InvalidAlgorithmParameterException unused) {
                throw new AssertionError("Reset of context failed after it was successful once");
            }
        } catch (Exception e) {
            throw new SignatureException(e);
        } catch (Throwable th) {
            try {
                resetContext();
                throw th;
            } catch (InvalidAlgorithmParameterException unused2) {
                throw new AssertionError("Reset of context failed after it was successful once");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final long getEVP_PKEY_CTX() {
        return this.evpPkeyCtx;
    }

    static abstract class RSAPKCS1Padding extends OpenSSLSignature {
        RSAPKCS1Padding(long j) {
            super(j, EngineType.RSA, null);
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.OpenSSLSignature
        public final void configureEVP_PKEY_CTX(long j) throws InvalidAlgorithmParameterException {
            NativeCrypto.EVP_PKEY_CTX_set_rsa_padding(j, 1);
        }
    }

    public static final class MD5RSA extends RSAPKCS1Padding {
        public MD5RSA() {
            super(EvpMdRef.MD5.EVP_MD);
        }
    }

    public static final class SHA1RSA extends RSAPKCS1Padding {
        public SHA1RSA() {
            super(EvpMdRef.SHA1.EVP_MD);
        }
    }

    public static final class SHA224RSA extends RSAPKCS1Padding {
        public SHA224RSA() {
            super(EvpMdRef.SHA224.EVP_MD);
        }
    }

    public static final class SHA256RSA extends RSAPKCS1Padding {
        public SHA256RSA() {
            super(EvpMdRef.SHA256.EVP_MD);
        }
    }

    public static final class SHA384RSA extends RSAPKCS1Padding {
        public SHA384RSA() {
            super(EvpMdRef.SHA384.EVP_MD);
        }
    }

    public static final class SHA512RSA extends RSAPKCS1Padding {
        public SHA512RSA() {
            super(EvpMdRef.SHA512.EVP_MD);
        }
    }

    public static final class SHA1ECDSA extends OpenSSLSignature {
        public SHA1ECDSA() {
            super(EvpMdRef.SHA1.EVP_MD, EngineType.EC, null);
        }
    }

    public static final class SHA224ECDSA extends OpenSSLSignature {
        public SHA224ECDSA() {
            super(EvpMdRef.SHA224.EVP_MD, EngineType.EC, null);
        }
    }

    public static final class SHA256ECDSA extends OpenSSLSignature {
        public SHA256ECDSA() {
            super(EvpMdRef.SHA256.EVP_MD, EngineType.EC, null);
        }
    }

    public static final class SHA384ECDSA extends OpenSSLSignature {
        public SHA384ECDSA() {
            super(EvpMdRef.SHA384.EVP_MD, EngineType.EC, null);
        }
    }

    public static final class SHA512ECDSA extends OpenSSLSignature {
        public SHA512ECDSA() {
            super(EvpMdRef.SHA512.EVP_MD, EngineType.EC, null);
        }
    }

    static abstract class RSAPSSPadding extends OpenSSLSignature {
        private static final int TRAILER_FIELD_BC_ID = 1;
        private final String contentDigestAlgorithm;
        private String mgf1DigestAlgorithm;
        private long mgf1EvpMdRef;
        private int saltSizeBytes;

        RSAPSSPadding(long j, String str, int i) {
            super(j, EngineType.RSA, null);
            this.contentDigestAlgorithm = str;
            this.mgf1DigestAlgorithm = str;
            this.mgf1EvpMdRef = j;
            this.saltSizeBytes = i;
        }

        /* access modifiers changed from: protected */
        @Override // org.conscrypt.OpenSSLSignature
        public final void configureEVP_PKEY_CTX(long j) throws InvalidAlgorithmParameterException {
            NativeCrypto.EVP_PKEY_CTX_set_rsa_padding(j, 6);
            NativeCrypto.EVP_PKEY_CTX_set_rsa_mgf1_md(j, this.mgf1EvpMdRef);
            NativeCrypto.EVP_PKEY_CTX_set_rsa_pss_saltlen(j, this.saltSizeBytes);
        }

        /* access modifiers changed from: protected */
        @Override // java.security.SignatureSpi
        public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof PSSParameterSpec) {
                PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
                String jcaDigestAlgorithmStandardName = EvpMdRef.getJcaDigestAlgorithmStandardName(pSSParameterSpec.getDigestAlgorithm());
                if (jcaDigestAlgorithmStandardName == null) {
                    throw new InvalidAlgorithmParameterException("Unsupported content digest algorithm: " + pSSParameterSpec.getDigestAlgorithm());
                } else if (this.contentDigestAlgorithm.equalsIgnoreCase(jcaDigestAlgorithmStandardName)) {
                    String mGFAlgorithm = pSSParameterSpec.getMGFAlgorithm();
                    if ("MGF1".equalsIgnoreCase(mGFAlgorithm) || "1.2.840.113549.1.1.8".equals(mGFAlgorithm)) {
                        AlgorithmParameterSpec mGFParameters = pSSParameterSpec.getMGFParameters();
                        if (mGFParameters instanceof MGF1ParameterSpec) {
                            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                            String jcaDigestAlgorithmStandardName2 = EvpMdRef.getJcaDigestAlgorithmStandardName(mGF1ParameterSpec.getDigestAlgorithm());
                            if (jcaDigestAlgorithmStandardName2 != null) {
                                try {
                                    long eVP_MDByJcaDigestAlgorithmStandardName = EvpMdRef.getEVP_MDByJcaDigestAlgorithmStandardName(jcaDigestAlgorithmStandardName2);
                                    int saltLength = pSSParameterSpec.getSaltLength();
                                    if (saltLength >= 0) {
                                        int trailerField = pSSParameterSpec.getTrailerField();
                                        if (trailerField == 1) {
                                            this.mgf1DigestAlgorithm = jcaDigestAlgorithmStandardName2;
                                            this.mgf1EvpMdRef = eVP_MDByJcaDigestAlgorithmStandardName;
                                            this.saltSizeBytes = saltLength;
                                            long evp_pkey_ctx = getEVP_PKEY_CTX();
                                            if (evp_pkey_ctx != 0) {
                                                configureEVP_PKEY_CTX(evp_pkey_ctx);
                                                return;
                                            }
                                            return;
                                        }
                                        throw new InvalidAlgorithmParameterException("Unsupported trailer field: " + trailerField + ". Only " + 1 + " supported");
                                    }
                                    throw new InvalidAlgorithmParameterException("Salt length must be non-negative: " + saltLength);
                                } catch (NoSuchAlgorithmException e) {
                                    throw new ProviderException("Failed to obtain EVP_MD for " + jcaDigestAlgorithmStandardName2, e);
                                }
                            } else {
                                throw new InvalidAlgorithmParameterException("Unsupported MGF1 digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("Unsupported MGF parameters: " + mGFParameters + ". Only " + MGF1ParameterSpec.class.getName() + " supported");
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("Unsupported MGF algorithm: " + mGFAlgorithm + ". Only " + "MGF1" + " supported");
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("Changing content digest algorithm not supported");
                }
            } else {
                throw new InvalidAlgorithmParameterException("Unsupported parameter: " + algorithmParameterSpec + ". Only " + PSSParameterSpec.class.getName() + " supported");
            }
        }

        /* access modifiers changed from: protected */
        public final AlgorithmParameters engineGetParameters() {
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("PSS");
                instance.init(new PSSParameterSpec(this.contentDigestAlgorithm, "MGF1", new MGF1ParameterSpec(this.mgf1DigestAlgorithm), this.saltSizeBytes, 1));
                return instance;
            } catch (NoSuchAlgorithmException e) {
                throw new ProviderException("Failed to create PSS AlgorithmParameters", e);
            } catch (InvalidParameterSpecException e2) {
                throw new ProviderException("Failed to create PSS AlgorithmParameters", e2);
            }
        }
    }

    public static final class SHA1RSAPSS extends RSAPSSPadding {
        public SHA1RSAPSS() {
            super(EvpMdRef.SHA1.EVP_MD, "SHA-1", EvpMdRef.SHA1.SIZE_BYTES);
        }
    }

    public static final class SHA224RSAPSS extends RSAPSSPadding {
        public SHA224RSAPSS() {
            super(EvpMdRef.SHA224.EVP_MD, "SHA-224", EvpMdRef.SHA224.SIZE_BYTES);
        }
    }

    public static final class SHA256RSAPSS extends RSAPSSPadding {
        public SHA256RSAPSS() {
            super(EvpMdRef.SHA256.EVP_MD, "SHA-256", EvpMdRef.SHA256.SIZE_BYTES);
        }
    }

    public static final class SHA384RSAPSS extends RSAPSSPadding {
        public SHA384RSAPSS() {
            super(EvpMdRef.SHA384.EVP_MD, "SHA-384", EvpMdRef.SHA384.SIZE_BYTES);
        }
    }

    public static final class SHA512RSAPSS extends RSAPSSPadding {
        public SHA512RSAPSS() {
            super(EvpMdRef.SHA512.EVP_MD, "SHA-512", EvpMdRef.SHA512.SIZE_BYTES);
        }
    }
}
