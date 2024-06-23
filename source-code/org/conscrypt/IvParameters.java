package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

public class IvParameters extends AlgorithmParametersSpi {
    private byte[] iv;

    public static class AES extends IvParameters {
    }

    public static class ChaCha20 extends IvParameters {
    }

    public static class DESEDE extends IvParameters {
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt IV AlgorithmParameters";
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.iv = (byte[]) ((IvParameterSpec) algorithmParameterSpec).getIV().clone();
            return;
        }
        throw new InvalidParameterSpecException("Only IvParameterSpec is supported");
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        Throwable th;
        long j;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
            try {
                byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(j);
                if (NativeCrypto.asn1_read_is_empty(j)) {
                    this.iv = asn1_read_octetstring;
                    NativeCrypto.asn1_read_free(j);
                    return;
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j = 0;
            NativeCrypto.asn1_read_free(j);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
        } else if (str.equals("RAW")) {
            this.iv = (byte[]) bArr.clone();
        } else {
            throw new IOException("Unsupported format: " + str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == IvParameterSpec.class) {
            return new IvParameterSpec(this.iv);
        }
        throw new InvalidParameterSpecException("Incompatible AlgorithmParametersSpec class: " + cls);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j = 0;
        try {
            j = NativeCrypto.asn1_write_init();
            NativeCrypto.asn1_write_octetstring(j, this.iv);
            byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j);
            NativeCrypto.asn1_write_free(j);
            return asn1_write_finish;
        } catch (IOException e) {
            NativeCrypto.asn1_write_cleanup(j);
            throw e;
        } catch (Throwable th) {
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
        if (str.equals("RAW")) {
            return (byte[]) this.iv.clone();
        }
        throw new IOException("Unsupported format: " + str);
    }
}
