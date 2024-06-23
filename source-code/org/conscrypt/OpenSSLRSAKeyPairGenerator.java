package org.conscrypt;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;

public final class OpenSSLRSAKeyPairGenerator extends KeyPairGeneratorSpi {
    private int modulusBits = 2048;
    private byte[] publicExponent = {1, 0, 1};

    public KeyPair generateKeyPair() {
        OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.RSA_generate_key_ex(this.modulusBits, this.publicExponent));
        return new KeyPair(new OpenSSLRSAPublicKey(openSSLKey), OpenSSLRSAPrivateKey.getInstance(openSSLKey));
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.modulusBits = i;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof RSAKeyGenParameterSpec) {
            RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
            BigInteger publicExponent2 = rSAKeyGenParameterSpec.getPublicExponent();
            if (publicExponent2 != null) {
                this.publicExponent = publicExponent2.toByteArray();
            }
            this.modulusBits = rSAKeyGenParameterSpec.getKeysize();
            return;
        }
        throw new InvalidAlgorithmParameterException("Only RSAKeyGenParameterSpec supported");
    }
}
