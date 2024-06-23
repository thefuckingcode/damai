package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class Java8EngineWrapper extends AbstractConscryptEngine {
    private final ConscryptEngine delegate;
    private BiFunction<SSLEngine, List<String>, String> selector;

    Java8EngineWrapper(ConscryptEngine conscryptEngine) {
        this.delegate = (ConscryptEngine) Preconditions.checkNotNull(conscryptEngine, "delegate");
    }

    static SSLEngine getDelegate(SSLEngine sSLEngine) {
        return sSLEngine instanceof Java8EngineWrapper ? ((Java8EngineWrapper) sSLEngine).delegate : sSLEngine;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        return this.delegate.wrap(byteBufferArr, byteBuffer);
    }

    public SSLParameters getSSLParameters() {
        return this.delegate.getSSLParameters();
    }

    public void setSSLParameters(SSLParameters sSLParameters) {
        this.delegate.setSSLParameters(sSLParameters);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        this.delegate.setBufferAllocator(bufferAllocator);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.delegate.maxSealOverhead();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z) {
        this.delegate.setChannelIdEnabled(z);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() throws SSLException {
        return this.delegate.getChannelId();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.delegate.setChannelIdPrivateKey(privateKey);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        this.delegate.setHandshakeListener(handshakeListener);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.delegate.setHostname(str);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        return this.delegate.getHostname();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getPeerHost() {
        return this.delegate.getPeerHost();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public int getPeerPort() {
        return this.delegate.getPeerPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        this.delegate.beginHandshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        this.delegate.closeInbound();
    }

    public void closeOutbound() {
        this.delegate.closeOutbound();
    }

    public Runnable getDelegatedTask() {
        return this.delegate.getDelegatedTask();
    }

    public String[] getEnabledCipherSuites() {
        return this.delegate.getEnabledCipherSuites();
    }

    public String[] getEnabledProtocols() {
        return this.delegate.getEnabledProtocols();
    }

    public boolean getEnableSessionCreation() {
        return this.delegate.getEnableSessionCreation();
    }

    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.delegate.getHandshakeStatus();
    }

    public boolean getNeedClientAuth() {
        return this.delegate.getNeedClientAuth();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        return this.delegate.handshakeSession();
    }

    public SSLSession getSession() {
        return this.delegate.getSession();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public String[] getSupportedProtocols() {
        return this.delegate.getSupportedProtocols();
    }

    public boolean getUseClientMode() {
        return this.delegate.getUseClientMode();
    }

    public boolean getWantClientAuth() {
        return this.delegate.getWantClientAuth();
    }

    public boolean isInboundDone() {
        return this.delegate.isInboundDone();
    }

    public boolean isOutboundDone() {
        return this.delegate.isOutboundDone();
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.delegate.setEnabledCipherSuites(strArr);
    }

    public void setEnabledProtocols(String[] strArr) {
        this.delegate.setEnabledProtocols(strArr);
    }

    public void setEnableSessionCreation(boolean z) {
        this.delegate.setEnableSessionCreation(z);
    }

    public void setNeedClientAuth(boolean z) {
        this.delegate.setNeedClientAuth(z);
    }

    public void setUseClientMode(boolean z) {
        this.delegate.setUseClientMode(z);
    }

    public void setWantClientAuth(boolean z) {
        this.delegate.setWantClientAuth(z);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.delegate.unwrap(byteBuffer, byteBuffer2);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        return this.delegate.unwrap(byteBuffer, byteBufferArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        return this.delegate.unwrap(byteBuffer, byteBufferArr, i, i2);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return this.delegate.unwrap(byteBufferArr, byteBufferArr2);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2, int i3, int i4) throws SSLException {
        return this.delegate.unwrap(byteBufferArr, i, i2, byteBufferArr2, i3, i4);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.delegate.wrap(byteBuffer, byteBuffer2);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        return this.delegate.wrap(byteBufferArr, i, i2, byteBuffer);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z) {
        this.delegate.setUseSessionTickets(z);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.delegate.setApplicationProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.delegate.getApplicationProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getApplicationProtocol() {
        return this.delegate.getApplicationProtocol();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter;
        ConscryptEngine conscryptEngine = this.delegate;
        if (applicationProtocolSelector == null) {
            applicationProtocolSelectorAdapter = null;
        } else {
            applicationProtocolSelectorAdapter = new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector);
        }
        conscryptEngine.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.delegate.getTlsUnique();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        return this.delegate.exportKeyingMaterial(str, bArr, i);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHandshakeApplicationProtocol() {
        return this.delegate.getHandshakeApplicationProtocol();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        this.selector = biFunction;
        setApplicationProtocolSelector(toApplicationProtocolSelector(biFunction));
    }

    @Override // javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return this.selector;
    }

    private static ApplicationProtocolSelector toApplicationProtocolSelector(final BiFunction<SSLEngine, List<String>, String> biFunction) {
        if (biFunction == null) {
            return null;
        }
        return new ApplicationProtocolSelector() {
            /* class org.conscrypt.Java8EngineWrapper.AnonymousClass1 */

            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLEngine sSLEngine, List<String> list) {
                return (String) biFunction.apply(sSLEngine, list);
            }

            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLSocket sSLSocket, List<String> list) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
