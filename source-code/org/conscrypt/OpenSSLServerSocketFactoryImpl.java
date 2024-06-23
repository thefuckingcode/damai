package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import javax.net.ssl.SSLServerSocketFactory;

/* access modifiers changed from: package-private */
public final class OpenSSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private IOException instantiationException;
    private SSLParametersImpl sslParameters;
    private boolean useEngineSocket = useEngineSocketByDefault;

    OpenSSLServerSocketFactoryImpl() {
        try {
            SSLParametersImpl sSLParametersImpl = SSLParametersImpl.getDefault();
            this.sslParameters = sSLParametersImpl;
            sSLParametersImpl.setUseClientMode(false);
        } catch (KeyManagementException e) {
            IOException iOException = new IOException("Delayed instantiation exception:");
            this.instantiationException = iOException;
            iOException.initCause(e);
        }
    }

    OpenSSLServerSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.clone();
        this.sslParameters = sSLParametersImpl2;
        sSLParametersImpl2.setUseClientMode(false);
    }

    static void setUseEngineSocketByDefault(boolean z) {
        useEngineSocketByDefault = z;
    }

    /* access modifiers changed from: package-private */
    public void setUseEngineSocket(boolean z) {
        this.useEngineSocket = z;
    }

    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket() throws IOException {
        return new ConscryptServerSocket((SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i) throws IOException {
        return new ConscryptServerSocket(i, (SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2) throws IOException {
        return new ConscryptServerSocket(i, i2, (SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        return new ConscryptServerSocket(i, i2, inetAddress, (SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }
}
