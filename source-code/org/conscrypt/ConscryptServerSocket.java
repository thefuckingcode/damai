package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

final class ConscryptServerSocket extends SSLServerSocket {
    private boolean channelIdEnabled;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    ConscryptServerSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.sslParameters = sSLParametersImpl;
    }

    ConscryptServerSocket(int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(i);
        this.sslParameters = sSLParametersImpl;
    }

    ConscryptServerSocket(int i, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(i, i2);
        this.sslParameters = sSLParametersImpl;
    }

    ConscryptServerSocket(int i, int i2, InetAddress inetAddress, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(i, i2, inetAddress);
        this.sslParameters = sSLParametersImpl;
    }

    /* access modifiers changed from: package-private */
    public ConscryptServerSocket setUseEngineSocket(boolean z) {
        this.useEngineSocket = z;
        return this;
    }

    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    /* access modifiers changed from: package-private */
    public void setChannelIdEnabled(boolean z) {
        this.channelIdEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isChannelIdEnabled() {
        return this.channelIdEnabled;
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    public void setUseClientMode(boolean z) {
        this.sslParameters.setUseClientMode(z);
    }

    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // java.net.ServerSocket
    public Socket accept() throws IOException {
        AbstractConscryptSocket abstractConscryptSocket;
        if (this.useEngineSocket) {
            abstractConscryptSocket = Platform.createEngineSocket(this.sslParameters);
        } else {
            abstractConscryptSocket = Platform.createFileDescriptorSocket(this.sslParameters);
        }
        abstractConscryptSocket.setChannelIdEnabled(this.channelIdEnabled);
        implAccept(abstractConscryptSocket);
        return abstractConscryptSocket;
    }
}
