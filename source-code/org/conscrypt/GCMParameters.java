package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public final class GCMParameters extends AlgorithmParametersSpi {
    private static final int DEFAULT_TLEN = 96;
    private byte[] iv;
    private int tLen;

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt GCM AlgorithmParameters";
    }

    public GCMParameters() {
    }

    GCMParameters(int i, byte[] bArr) {
        this.tLen = i;
        this.iv = bArr;
    }

    /* access modifiers changed from: package-private */
    public int getTLen() {
        return this.tLen;
    }

    /* access modifiers changed from: package-private */
    public byte[] getIV() {
        return this.iv;
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
        if (fromGCMParameterSpec != null) {
            this.tLen = fromGCMParameterSpec.tLen;
            this.iv = fromGCMParameterSpec.iv;
            return;
        }
        throw new InvalidParameterSpecException("Only GCMParameterSpec is supported");
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        Throwable th;
        long j;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j);
                byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(asn1_read_sequence);
                int i = 96;
                if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence)) {
                    i = ((int) NativeCrypto.asn1_read_uint64(asn1_read_sequence)) * 8;
                }
                if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(j)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                this.iv = asn1_read_octetstring;
                this.tLen = i;
                NativeCrypto.asn1_read_free(asn1_read_sequence);
                NativeCrypto.asn1_read_free(j);
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_read_free(0);
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j = 0;
            NativeCrypto.asn1_read_free(0);
            NativeCrypto.asn1_read_free(j);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls.getName().equals("javax.crypto.spec.GCMParameterSpec")) {
            return cls.cast(Platform.toGCMParameterSpec(this.tLen, this.iv));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        Throwable th;
        long j;
        IOException e;
        long j2;
        long j3 = 0;
        try {
            j = NativeCrypto.asn1_write_init();
            try {
                long asn1_write_sequence = NativeCrypto.asn1_write_sequence(j);
                NativeCrypto.asn1_write_octetstring(asn1_write_sequence, this.iv);
                int i = this.tLen;
                if (i != 96) {
                    NativeCrypto.asn1_write_uint64(asn1_write_sequence, (long) (i / 8));
                }
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j);
                NativeCrypto.asn1_write_free(asn1_write_sequence);
                NativeCrypto.asn1_write_free(j);
                return asn1_write_finish;
            } catch (IOException e2) {
                e = e2;
                j3 = j;
                j2 = 0;
                try {
                    NativeCrypto.asn1_write_cleanup(j3);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    j3 = j2;
                    j = j3;
                    NativeCrypto.asn1_write_free(j3);
                    NativeCrypto.asn1_write_free(j);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                NativeCrypto.asn1_write_free(j3);
                NativeCrypto.asn1_write_free(j);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            j2 = 0;
            NativeCrypto.asn1_write_cleanup(j3);
            throw e;
        } catch (Throwable th4) {
            th = th4;
            j = 0;
            NativeCrypto.asn1_write_free(j3);
            NativeCrypto.asn1_write_free(j);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }
}
