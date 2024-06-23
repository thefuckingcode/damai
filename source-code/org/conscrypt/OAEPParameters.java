package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class OAEPParameters extends AlgorithmParametersSpi {
    private static final String MGF1_OID = "1.2.840.113549.1.1.8";
    private static final Map<String, String> NAME_TO_OID = new HashMap();
    private static final Map<String, String> OID_TO_NAME;
    private static final String PSPECIFIED_OID = "1.2.840.113549.1.1.9";
    private OAEPParameterSpec spec = OAEPParameterSpec.DEFAULT;

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt OAEP AlgorithmParameters";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        HashMap hashMap = new HashMap();
        OID_TO_NAME = hashMap;
        hashMap.put("1.3.14.3.2.26", "SHA-1");
        hashMap.put("2.16.840.1.101.3.4.2.4", "SHA-224");
        hashMap.put("2.16.840.1.101.3.4.2.1", "SHA-256");
        hashMap.put("2.16.840.1.101.3.4.2.2", "SHA-384");
        hashMap.put("2.16.840.1.101.3.4.2.3", "SHA-512");
        for (Map.Entry entry : hashMap.entrySet()) {
            NAME_TO_OID.put(entry.getValue(), entry.getKey());
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            this.spec = (OAEPParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only OAEPParameterSpec is supported");
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        Throwable th;
        long j;
        long asn1_read_sequence;
        Throwable th2;
        long j2;
        long j3 = 0;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
            try {
                asn1_read_sequence = NativeCrypto.asn1_read_sequence(j);
            } catch (Throwable th3) {
                th = th3;
                NativeCrypto.asn1_read_free(j3);
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
            try {
                PSource.PSpecified pSpecified = PSource.PSpecified.DEFAULT;
                String readHash = readHash(asn1_read_sequence);
                String readMgfHash = readMgfHash(asn1_read_sequence);
                if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                    try {
                        j2 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        try {
                            long asn1_read_sequence2 = NativeCrypto.asn1_read_sequence(j2);
                            if (NativeCrypto.asn1_read_oid(asn1_read_sequence2).equals(PSPECIFIED_OID)) {
                                pSpecified = new PSource.PSpecified(NativeCrypto.asn1_read_octetstring(asn1_read_sequence2));
                                if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence2)) {
                                    NativeCrypto.asn1_read_free(asn1_read_sequence2);
                                    NativeCrypto.asn1_read_free(j2);
                                } else {
                                    throw new IOException("Error reading ASN.1 encoding");
                                }
                            } else {
                                throw new IOException("Error reading ASN.1 encoding");
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            NativeCrypto.asn1_read_free(0);
                            NativeCrypto.asn1_read_free(j2);
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        j2 = 0;
                        NativeCrypto.asn1_read_free(0);
                        NativeCrypto.asn1_read_free(j2);
                        throw th2;
                    }
                }
                if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(j)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                this.spec = new OAEPParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), pSpecified);
                NativeCrypto.asn1_read_free(asn1_read_sequence);
                NativeCrypto.asn1_read_free(j);
            } catch (Throwable th6) {
                th = th6;
                j3 = asn1_read_sequence;
                NativeCrypto.asn1_read_free(j3);
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            j = 0;
            NativeCrypto.asn1_read_free(j3);
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

    static String readHash(long j) throws IOException {
        if (!NativeCrypto.asn1_read_next_tag_is(j, 0)) {
            return "SHA-1";
        }
        long j2 = 0;
        try {
            j2 = NativeCrypto.asn1_read_tagged(j);
            return getHashName(j2);
        } finally {
            NativeCrypto.asn1_read_free(j2);
        }
    }

    static String readMgfHash(long j) throws IOException {
        long j2;
        Throwable th;
        if (!NativeCrypto.asn1_read_next_tag_is(j, 1)) {
            return "SHA-1";
        }
        long j3 = 0;
        try {
            j2 = NativeCrypto.asn1_read_tagged(j);
            try {
                j3 = NativeCrypto.asn1_read_sequence(j2);
                if (NativeCrypto.asn1_read_oid(j3).equals(MGF1_OID)) {
                    String hashName = getHashName(j3);
                    if (NativeCrypto.asn1_read_is_empty(j3)) {
                        NativeCrypto.asn1_read_free(j3);
                        NativeCrypto.asn1_read_free(j2);
                        return hashName;
                    }
                    throw new IOException("Error reading ASN.1 encoding");
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_read_free(j3);
                NativeCrypto.asn1_read_free(j2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = 0;
            NativeCrypto.asn1_read_free(j3);
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    private static String getHashName(long j) throws IOException {
        long j2;
        Throwable th;
        try {
            j2 = NativeCrypto.asn1_read_sequence(j);
            try {
                String asn1_read_oid = NativeCrypto.asn1_read_oid(j2);
                if (!NativeCrypto.asn1_read_is_empty(j2)) {
                    NativeCrypto.asn1_read_null(j2);
                }
                if (NativeCrypto.asn1_read_is_empty(j2)) {
                    Map<String, String> map = OID_TO_NAME;
                    if (map.containsKey(asn1_read_oid)) {
                        String str = map.get(asn1_read_oid);
                        NativeCrypto.asn1_read_free(j2);
                        return str;
                    }
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_read_free(j2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = 0;
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls == OAEPParameterSpec.class) {
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
        long j3;
        Throwable th2;
        long j4 = 0;
        try {
            j2 = NativeCrypto.asn1_write_init();
            try {
                j = NativeCrypto.asn1_write_sequence(j2);
            } catch (IOException e2) {
                e = e2;
                j = 0;
                try {
                    NativeCrypto.asn1_write_cleanup(j2);
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                    NativeCrypto.asn1_write_free(j);
                    NativeCrypto.asn1_write_free(j2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                j = 0;
                NativeCrypto.asn1_write_free(j);
                NativeCrypto.asn1_write_free(j2);
                throw th;
            }
            try {
                writeHashAndMgfHash(j, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                PSource.PSpecified pSpecified = (PSource.PSpecified) this.spec.getPSource();
                if (pSpecified.getValue().length != 0) {
                    try {
                        j3 = NativeCrypto.asn1_write_tag(j, 2);
                        try {
                            j4 = writeAlgorithmIdentifier(j3, PSPECIFIED_OID);
                            NativeCrypto.asn1_write_octetstring(j4, pSpecified.getValue());
                            NativeCrypto.asn1_write_flush(j);
                            NativeCrypto.asn1_write_free(j4);
                            NativeCrypto.asn1_write_free(j3);
                        } catch (Throwable th5) {
                            th2 = th5;
                            NativeCrypto.asn1_write_flush(j);
                            NativeCrypto.asn1_write_free(j4);
                            NativeCrypto.asn1_write_free(j3);
                            throw th2;
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        j3 = 0;
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j4);
                        NativeCrypto.asn1_write_free(j3);
                        throw th2;
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
            j = 0;
            e = e4;
            j2 = 0;
            NativeCrypto.asn1_write_cleanup(j2);
            throw e;
        } catch (Throwable th7) {
            j = 0;
            th = th7;
            j2 = 0;
            NativeCrypto.asn1_write_free(j);
            NativeCrypto.asn1_write_free(j2);
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

    static void writeHashAndMgfHash(long j, String str, MGF1ParameterSpec mGF1ParameterSpec) throws IOException {
        Throwable th;
        long j2;
        long j3;
        Throwable th2;
        long j4;
        long writeAlgorithmIdentifier;
        long j5 = 0;
        if (!str.equals("SHA-1")) {
            try {
                j4 = NativeCrypto.asn1_write_tag(j, 0);
                try {
                    writeAlgorithmIdentifier = writeAlgorithmIdentifier(j4, NAME_TO_OID.get(str));
                } catch (Throwable th3) {
                    th2 = th3;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j4);
                    throw th2;
                }
                try {
                    NativeCrypto.asn1_write_null(writeAlgorithmIdentifier);
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(writeAlgorithmIdentifier);
                    NativeCrypto.asn1_write_free(j4);
                } catch (Throwable th4) {
                    th2 = th4;
                    j5 = writeAlgorithmIdentifier;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j4);
                    throw th2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                j4 = 0;
                NativeCrypto.asn1_write_flush(j);
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j4);
                throw th2;
            }
        }
        if (!mGF1ParameterSpec.getDigestAlgorithm().equals("SHA-1")) {
            try {
                j3 = NativeCrypto.asn1_write_tag(j, 1);
                try {
                    j2 = writeAlgorithmIdentifier(j3, MGF1_OID);
                    try {
                        j5 = writeAlgorithmIdentifier(j2, NAME_TO_OID.get(mGF1ParameterSpec.getDigestAlgorithm()));
                        NativeCrypto.asn1_write_null(j5);
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j5);
                        NativeCrypto.asn1_write_free(j2);
                        NativeCrypto.asn1_write_free(j3);
                    } catch (Throwable th6) {
                        th = th6;
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j5);
                        NativeCrypto.asn1_write_free(j2);
                        NativeCrypto.asn1_write_free(j3);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    j2 = 0;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j2);
                    NativeCrypto.asn1_write_free(j3);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                j3 = 0;
                j2 = 0;
                NativeCrypto.asn1_write_flush(j);
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j2);
                NativeCrypto.asn1_write_free(j3);
                throw th;
            }
        }
    }

    private static long writeAlgorithmIdentifier(long j, String str) throws IOException {
        IOException e;
        long j2;
        try {
            j2 = NativeCrypto.asn1_write_sequence(j);
            try {
                NativeCrypto.asn1_write_oid(j2, str);
                return j2;
            } catch (IOException e2) {
                e = e2;
                NativeCrypto.asn1_write_free(j2);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            j2 = 0;
            NativeCrypto.asn1_write_free(j2);
            throw e;
        }
    }
}
