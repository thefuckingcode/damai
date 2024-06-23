package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.conscrypt.NativeRef;

public class ECParameters extends AlgorithmParametersSpi {
    private OpenSSLECGroupContext curve;

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt EC AlgorithmParameters";
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            String name = ((ECGenParameterSpec) algorithmParameterSpec).getName();
            OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(name);
            if (curveByName != null) {
                this.curve = curveByName;
                return;
            }
            throw new InvalidParameterSpecException("Unknown EC curve name: " + name);
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            try {
                OpenSSLECGroupContext instance = OpenSSLECGroupContext.getInstance(eCParameterSpec);
                if (instance != null) {
                    this.curve = instance;
                    return;
                }
                throw new InvalidParameterSpecException("Unknown EC curve: " + eCParameterSpec);
            } catch (InvalidAlgorithmParameterException e) {
                throw new InvalidParameterSpecException(e.getMessage());
            }
        } else {
            throw new InvalidParameterSpecException("Only ECParameterSpec and ECGenParameterSpec are supported");
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        long EC_KEY_parse_curve_name = NativeCrypto.EC_KEY_parse_curve_name(bArr);
        if (EC_KEY_parse_curve_name != 0) {
            this.curve = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(EC_KEY_parse_curve_name));
            return;
        }
        throw new IOException("Error reading ASN.1 encoding");
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
        if (cls == ECParameterSpec.class) {
            return this.curve.getECParameterSpec();
        }
        if (cls == ECGenParameterSpec.class) {
            return new ECGenParameterSpec(Platform.getCurveName(this.curve.getECParameterSpec()));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        return NativeCrypto.EC_KEY_marshal_curve_name(this.curve.getNativeRef());
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
