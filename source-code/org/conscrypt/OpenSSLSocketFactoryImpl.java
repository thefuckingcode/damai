package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLSocketFactory;

/* access modifiers changed from: package-private */
public final class OpenSSLSocketFactoryImpl extends SSLSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private final IOException instantiationException;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket = useEngineSocketByDefault;

    OpenSSLSocketFactoryImpl() {
        IOException iOException;
        SSLParametersImpl sSLParametersImpl = null;
        try {
            iOException = null;
            sSLParametersImpl = SSLParametersImpl.getDefault();
        } catch (KeyManagementException e) {
            iOException = new IOException("Delayed instantiation exception:", e);
        }
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = iOException;
    }

    OpenSSLSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = null;
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

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        IOException iOException = this.instantiationException;
        if (iOException != null) {
            throw iOException;
        } else if (this.useEngineSocket) {
            return Platform.createEngineSocket((SSLParametersImpl) this.sslParameters.clone());
        } else {
            return Platform.createFileDescriptorSocket((SSLParametersImpl) this.sslParameters.clone());
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i, inetAddress, i2, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i, inetAddress, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i, inetAddress2, i2, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i, inetAddress2, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Preconditions.checkNotNull(socket, "socket");
        if (!socket.isConnected()) {
            throw new SocketException("Socket is not connected.");
        } else if (this.useEngineSocket || !hasFileDescriptor(socket)) {
            return Platform.createEngineSocket(socket, str, i, z, (SSLParametersImpl) this.sslParameters.clone());
        } else {
            return Platform.createFileDescriptorSocket(socket, str, i, z, (SSLParametersImpl) this.sslParameters.clone());
        }
    }

    private boolean hasFileDescriptor(Socket socket) {
        try {
            Platform.getFileDescriptor(socket);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
