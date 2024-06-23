package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;

public class TrustManagerFactoryImpl extends TrustManagerFactorySpi {
    private KeyStore keyStore;

    @Override // javax.net.ssl.TrustManagerFactorySpi
    public void engineInit(KeyStore keyStore2) throws KeyStoreException {
        if (keyStore2 != null) {
            this.keyStore = keyStore2;
        } else {
            this.keyStore = Platform.getDefaultCertKeyStore();
        }
    }

    @Override // javax.net.ssl.TrustManagerFactorySpi
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("ManagerFactoryParameters not supported");
    }

    public TrustManager[] engineGetTrustManagers() {
        if (this.keyStore != null) {
            return new TrustManager[]{new TrustManagerImpl(this.keyStore)};
        }
        throw new IllegalStateException("TrustManagerFactory is not initialized");
    }
}
