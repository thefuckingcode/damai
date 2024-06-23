package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public class PSSParameters extends AlgorithmParametersSpi {
    private PSSParameterSpec spec = PSSParameterSpec.DEFAULT;

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt PSS AlgorithmParameters";
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            this.spec = (PSSParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only PSSParameterSpec is supported");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        Throwable th;
        long j;
        long asn1_read_sequence;
        int i;
        Throwable th2;
        long j2 = 0;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
            try {
                asn1_read_sequence = NativeCrypto.asn1_read_sequence(j);
            } catch (Throwable th3) {
                th = th3;
                NativeCrypto.asn1_read_free(j2);
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
            try {
                String readHash = OAEPParameters.readHash(asn1_read_sequence);
                String readMgfHash = OAEPParameters.readMgfHash(asn1_read_sequence);
                if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                    try {
                        long asn1_read_tagged = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        try {
                            int asn1_read_uint64 = (int) NativeCrypto.asn1_read_uint64(asn1_read_tagged);
                            NativeCrypto.asn1_read_free(asn1_read_tagged);
                            i = asn1_read_uint64;
                        } catch (Throwable th4) {
                            th2 = th4;
                            j2 = asn1_read_tagged;
                            NativeCrypto.asn1_read_free(j2);
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        NativeCrypto.asn1_read_free(j2);
                        throw th2;
                    }
                } else {
                    i = 20;
                }
                if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 3)) {
                    try {
                        j2 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        NativeCrypto.asn1_read_free(j2);
                        if (((long) ((int) NativeCrypto.asn1_read_uint64(j2))) != 1) {
                            throw new IOException("Error reading ASN.1 encoding");
                        }
                    } catch (Throwable th6) {
                        NativeCrypto.asn1_read_free(j2);
                        throw th6;
                    }
                }
                if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(j)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                this.spec = new PSSParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), i, 1);
                NativeCrypto.asn1_read_free(asn1_read_sequence);
                NativeCrypto.asn1_read_free(j);
            } catch (Throwable th7) {
                th = th7;
                j2 = asn1_read_sequence;
                NativeCrypto.asn1_read_free(j2);
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            j = 0;
            NativeCrypto.asn1_read_free(j2);
            NativeCrypto.asn1_read_free(j);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1") || str.equals("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls == PSSParameterSpec.class) {
            return this.spec;
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        Throwable th;
        IOException e;
        long j3 = 0;
        try {
            j2 = NativeCrypto.asn1_write_init();
            try {
                j = NativeCrypto.asn1_write_sequence(j2);
            } catch (IOException e2) {
                e = e2;
                j = j3;
                try {
                    NativeCrypto.asn1_write_cleanup(j2);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    NativeCrypto.asn1_write_free(j);
                    NativeCrypto.asn1_write_free(j2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j = j3;
                NativeCrypto.asn1_write_free(j);
                NativeCrypto.asn1_write_free(j2);
                throw th;
            }
            try {
                OAEPParameters.writeHashAndMgfHash(j, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                if (this.spec.getSaltLength() != 20) {
                    try {
                        j3 = NativeCrypto.asn1_write_tag(j, 2);
                        NativeCrypto.asn1_write_uint64(j3, (long) this.spec.getSaltLength());
                    } finally {
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j3);
                    }
                }
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j2);
                NativeCrypto.asn1_write_free(j);
                NativeCrypto.asn1_write_free(j2);
                return asn1_write_finish;
            } catch (IOException e3) {
                e = e3;
                NativeCrypto.asn1_write_cleanup(j2);
                throw e;
            }
        } catch (IOException e4) {
            j = j3;
            e = e4;
            j2 = j;
            NativeCrypto.asn1_write_cleanup(j2);
            throw e;
        } catch (Throwable th4) {
            j = j3;
            th = th4;
            j2 = j;
            NativeCrypto.asn1_write_free(j);
            NativeCrypto.asn1_write_free(j2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1") || str.equals("X.509")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }
}
