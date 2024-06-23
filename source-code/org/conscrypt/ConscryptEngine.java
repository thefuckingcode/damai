package org.conscrypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.NativeSsl;
import org.conscrypt.SSLParametersImpl;

/* access modifiers changed from: package-private */
public final class ConscryptEngine extends AbstractConscryptEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    private static final SSLEngineResult NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static BufferAllocator defaultBufferAllocator = null;
    private ActiveSession activeSession;
    private BufferAllocator bufferAllocator;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private boolean handshakeFinished;
    private HandshakeListener handshakeListener;
    private ByteBuffer lazyDirectBuffer;
    private int maxSealOverhead;
    private final NativeSsl.BioWrapper networkBio;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;

    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public long serverSessionRequested(byte[] bArr) {
        return 0;
    }

    ConscryptEngine(SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
            /* class org.conscrypt.ConscryptEngine.AnonymousClass1 */

            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.nullProvider();
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    ConscryptEngine(String str, int i, SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
            /* class org.conscrypt.ConscryptEngine.AnonymousClass1 */

            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.forHostAndPort(str, i);
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    ConscryptEngine(SSLParametersImpl sSLParametersImpl, PeerInfoProvider peerInfoProvider2) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
            /* class org.conscrypt.ConscryptEngine.AnonymousClass1 */

            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = (PeerInfoProvider) Preconditions.checkNotNull(peerInfoProvider2, "peerInfoProvider");
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        try {
            return NativeSsl.newInstance(sSLParametersImpl, conscryptEngine, conscryptEngine, conscryptEngine);
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    static void setDefaultBufferAllocator(BufferAllocator bufferAllocator2) {
        defaultBufferAllocator = bufferAllocator2;
    }

    static BufferAllocator getDefaultBufferAllocator() {
        return defaultBufferAllocator;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator2) {
        synchronized (this.ssl) {
            if (!isHandshakeStarted()) {
                this.bufferAllocator = bufferAllocator2;
            } else {
                throw new IllegalStateException("Could not set buffer allocator after the initial handshake has begun.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.maxSealOverhead;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z) {
        synchronized (this.ssl) {
            if (getUseClientMode()) {
                throw new IllegalStateException("Not allowed in client mode");
            } else if (!isHandshakeStarted()) {
                this.sslParameters.channelIdEnabled = z;
            } else {
                throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() throws SSLException {
        byte[] tlsChannelId;
        synchronized (this.ssl) {
            if (getUseClientMode()) {
                throw new IllegalStateException("Not allowed in client mode");
            } else if (!isHandshakeStarted()) {
                tlsChannelId = this.ssl.getTlsChannelId();
            } else {
                throw new IllegalStateException("Channel ID is only available after handshake completes");
            }
        }
        return tlsChannelId;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (getUseClientMode()) {
            synchronized (this.ssl) {
                if (!isHandshakeStarted()) {
                    ECParameterSpec eCParameterSpec = null;
                    if (privateKey == null) {
                        this.sslParameters.channelIdEnabled = false;
                        this.channelIdPrivateKey = null;
                        return;
                    }
                    this.sslParameters.channelIdEnabled = true;
                    try {
                        if (privateKey instanceof ECKey) {
                            eCParameterSpec = ((ECKey) privateKey).getParams();
                        }
                        if (eCParameterSpec == null) {
                            eCParameterSpec = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                        }
                        this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, eCParameterSpec);
                    } catch (InvalidKeyException unused) {
                    }
                    return;
                }
                throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
            }
        }
        throw new IllegalStateException("Not allowed in server mode");
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener2) {
        synchronized (this.ssl) {
            if (!isHandshakeStarted()) {
                this.handshakeListener = handshakeListener2;
            } else {
                throw new IllegalStateException("Handshake listener must be set before starting the handshake.");
            }
        }
    }

    private boolean isHandshakeStarted() {
        int i = this.state;
        return (i == 0 || i == 1) ? false : true;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostname();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getPeerHost() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public int getPeerPort() {
        return this.peerInfoProvider.getPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        synchronized (this.ssl) {
            beginHandshakeInternal();
        }
    }

    private void beginHandshakeInternal() throws SSLException {
        NativeSslSession cachedSession;
        int i = this.state;
        if (i == 0) {
            throw new IllegalStateException("Client/server mode must be set before handshake");
        } else if (i == 1) {
            transitionTo(2);
            try {
                this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostname(), getPeerPort(), this.sslParameters)) != null) {
                    cachedSession.offerToResume(this.ssl);
                }
                this.maxSealOverhead = this.ssl.getMaxSealOverhead();
                handshake();
            } catch (IOException e) {
                if (e.getMessage().contains("unexpected CCS")) {
                    Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getPeerHost()));
                }
                throw SSLUtils.toSSLHandshakeException(e);
            } catch (Throwable th) {
                closeAndFreeResources();
                throw th;
            }
        } else if (i == 6 || i == 7 || i == 8) {
            throw new IllegalStateException("Engine has already been closed");
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() {
        synchronized (this.ssl) {
            int i = this.state;
            if (i != 8) {
                if (i != 6) {
                    if (isHandshakeStarted()) {
                        if (this.state == 7) {
                            transitionTo(8);
                        } else {
                            transitionTo(6);
                        }
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            }
        }
    }

    public void closeOutbound() {
        synchronized (this.ssl) {
            int i = this.state;
            if (i != 8) {
                if (i != 7) {
                    if (isHandshakeStarted()) {
                        if (this.state == 6) {
                            transitionTo(8);
                        } else {
                            transitionTo(7);
                        }
                        sendSSLShutdown();
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            }
        }
    }

    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    public void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus handshakeStatusInternal;
        synchronized (this.ssl) {
            handshakeStatusInternal = getHandshakeStatusInternal();
        }
        return handshakeStatusInternal;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatusInternal() {
        if (this.handshakeFinished) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        switch (this.state) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            case 2:
                return pendingStatus(pendingOutboundEncryptedBytes());
            case 3:
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            default:
                throw new IllegalStateException("Unexpected engine state: " + this.state);
        }
    }

    /* access modifiers changed from: package-private */
    public int pendingOutboundEncryptedBytes() {
        return this.networkBio.getPendingWrittenBytes();
    }

    private int pendingInboundCleartextBytes() {
        return this.ssl.getPendingReadableBytes();
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        synchronized (this.ssl) {
            if (this.state != 2) {
                return null;
            }
            return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
                /* class org.conscrypt.ConscryptEngine.AnonymousClass2 */

                @Override // org.conscrypt.ExternalSession.Provider
                public ConscryptSession provideSession() {
                    return ConscryptEngine.this.provideHandshakeSession();
                }
            }));
        }
    }

    public SSLSession getSession() {
        return this.externalSession;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ConscryptSession provideSession() {
        synchronized (this.ssl) {
            int i = this.state;
            if (i == 8) {
                ConscryptSession conscryptSession = this.closedSession;
                if (conscryptSession == null) {
                    conscryptSession = SSLNullSession.getNullSession();
                }
                return conscryptSession;
            } else if (i < 3) {
                return SSLNullSession.getNullSession();
            } else {
                return this.activeSession;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ConscryptSession provideHandshakeSession() {
        ConscryptSession conscryptSession;
        synchronized (this.ssl) {
            if (this.state == 2) {
                conscryptSession = this.activeSession;
            } else {
                conscryptSession = SSLNullSession.getNullSession();
            }
        }
        return conscryptSession;
    }

    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    public boolean isInboundDone() {
        boolean z;
        synchronized (this.ssl) {
            int i = this.state;
            z = (i == 8 || i == 6 || this.ssl.wasShutdownReceived()) && pendingInboundCleartextBytes() == 0;
        }
        return z;
    }

    public boolean isOutboundDone() {
        boolean z;
        synchronized (this.ssl) {
            int i = this.state;
            z = (i == 8 || i == 7 || this.ssl.wasShutdownSent()) && pendingOutboundEncryptedBytes() == 0;
        }
        return z;
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    public void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            if (!isHandshakeStarted()) {
                transitionTo(1);
                this.sslParameters.setUseClientMode(z);
            } else {
                throw new IllegalArgumentException("Can not change mode after handshake: state == " + this.state);
            }
        }
    }

    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            try {
                unwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
                resetSingleSrcBuffer();
                resetSingleDstBuffer();
            } catch (Throwable th) {
                resetSingleSrcBuffer();
                resetSingleDstBuffer();
                throw th;
            }
        }
        return unwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            try {
                unwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
                resetSingleSrcBuffer();
            } catch (Throwable th) {
                resetSingleSrcBuffer();
                throw th;
            }
        }
        return unwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            try {
                unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
                resetSingleSrcBuffer();
            } catch (Throwable th) {
                resetSingleSrcBuffer();
                throw th;
            }
        }
        return unwrap;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        boolean z = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        if (byteBufferArr2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "dsts is null");
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0170, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0171, code lost:
        sendSSLShutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0178, code lost:
        throw convertException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0179, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x017a, code lost:
        closeAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0181, code lost:
        throw convertException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0188, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0189, code lost:
        sendSSLShutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0190, code lost:
        throw convertException(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:81:0x00f4, B:112:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0170 A[ExcHandler: IOException (r0v8 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:81:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0179 A[ExcHandler: EOFException (r0v6 'e' java.io.EOFException A[CUSTOM_DECLARE]), Splitter:B:81:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0188 A[ExcHandler: SSLException (r0v3 'e' javax.net.ssl.SSLException A[CUSTOM_DECLARE]), Splitter:B:81:0x00f4] */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2, int i3, int i4) throws SSLException {
        int i5;
        int i6;
        int i7;
        SSLEngineResult.HandshakeStatus handshakeStatus;
        int i8 = i;
        int i9 = i3;
        boolean z = true;
        int i10 = 0;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        int i11 = i8 + i2;
        Preconditions.checkPositionIndexes(i8, i11, byteBufferArr.length);
        int i12 = i9 + i4;
        Preconditions.checkPositionIndexes(i9, i12, byteBufferArr2.length);
        int calcDstsLength = calcDstsLength(byteBufferArr2, i3, i4);
        long calcSrcsLength = calcSrcsLength(byteBufferArr, i8, i11);
        synchronized (this.ssl) {
            int i13 = this.state;
            if (i13 != 0) {
                if (i13 == 1) {
                    beginHandshakeInternal();
                } else if (i13 == 6 || i13 == 8) {
                    freeIfDone();
                    return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                }
                SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                if (!this.handshakeFinished) {
                    handshakeStatus2 = handshake();
                    if (handshakeStatus2 == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                        return NEED_WRAP_OK;
                    } else if (this.state == 8) {
                        return NEED_WRAP_CLOSED;
                    }
                }
                if (pendingInboundCleartextBytes() > 0) {
                    z = false;
                }
                if (calcSrcsLength <= 0 || !z) {
                    if (z) {
                        return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                    }
                    i5 = 0;
                } else if (calcSrcsLength < 5) {
                    return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                } else {
                    i5 = SSLUtils.getEncryptedPacketLength(byteBufferArr, i);
                    if (i5 < 0) {
                        throw new SSLException("Unable to parse TLS packet header");
                    } else if (calcSrcsLength < ((long) i5)) {
                        return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                    }
                }
                if (i5 > 0 && i8 < i11) {
                    i6 = 0;
                    while (true) {
                        ByteBuffer byteBuffer = byteBufferArr[i8];
                        int remaining = byteBuffer.remaining();
                        if (remaining != 0) {
                            int writeEncryptedData = writeEncryptedData(byteBuffer, Math.min(i5, remaining));
                            if (writeEncryptedData <= 0) {
                                NativeCrypto.SSL_clear_error();
                                break;
                            }
                            i6 += writeEncryptedData;
                            i5 -= writeEncryptedData;
                            if (i5 != 0) {
                                if (writeEncryptedData != remaining) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i8++;
                        if (i8 >= i11) {
                            break;
                        }
                    }
                } else {
                    i6 = 0;
                }
                if (calcDstsLength > 0) {
                    i7 = 0;
                    while (true) {
                        if (i9 >= i12) {
                            break;
                        }
                        try {
                            ByteBuffer byteBuffer2 = byteBufferArr2[i9];
                            if (byteBuffer2.hasRemaining()) {
                                int readPlaintextData = readPlaintextData(byteBuffer2);
                                if (readPlaintextData > 0) {
                                    i7 += readPlaintextData;
                                    if (byteBuffer2.hasRemaining()) {
                                        break;
                                    }
                                } else if (readPlaintextData != -6) {
                                    if (readPlaintextData != -3) {
                                        if (readPlaintextData != -2) {
                                            sendSSLShutdown();
                                            throw newSslExceptionWithMessage("SSL_read");
                                        }
                                    }
                                    return newResult(i6, i7, handshakeStatus2);
                                } else {
                                    closeInbound();
                                    sendSSLShutdown();
                                    SSLEngineResult.Status status = SSLEngineResult.Status.CLOSED;
                                    if (pendingOutboundEncryptedBytes() > 0) {
                                        handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_WRAP;
                                    } else {
                                        handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                                    }
                                    return new SSLEngineResult(status, handshakeStatus, i6, i7);
                                }
                            }
                            i9++;
                        } catch (SSLException e) {
                        } catch (InterruptedIOException unused) {
                            i10 = i7;
                            return newResult(i6, i10, handshakeStatus2);
                        } catch (EOFException e2) {
                        } catch (IOException e3) {
                        }
                    }
                } else {
                    this.ssl.forceRead();
                    i7 = 0;
                }
                if (this.handshakeFinished) {
                    i10 = pendingInboundCleartextBytes();
                }
                if (i10 > 0) {
                    SSLEngineResult.Status status2 = SSLEngineResult.Status.BUFFER_OVERFLOW;
                    if (handshakeStatus2 != SSLEngineResult.HandshakeStatus.FINISHED) {
                        handshakeStatus2 = getHandshakeStatusInternal();
                    }
                    return new SSLEngineResult(status2, mayFinishHandshake(handshakeStatus2), i6, i7);
                }
                return newResult(i6, i7, handshakeStatus2);
            }
            throw new IllegalStateException("Client/server mode must be set before calling unwrap");
        }
    }

    private static int calcDstsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < byteBufferArr.length; i4++) {
            ByteBuffer byteBuffer = byteBufferArr[i4];
            Preconditions.checkArgument(byteBuffer != null, "dsts[%d] is null", Integer.valueOf(i4));
            if (!byteBuffer.isReadOnly()) {
                if (i4 >= i && i4 < i + i2) {
                    i3 += byteBuffer.remaining();
                }
            } else {
                throw new ReadOnlyBufferException();
            }
        }
        return i3;
    }

    private static long calcSrcsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        long j = 0;
        while (i < i2) {
            ByteBuffer byteBuffer = byteBufferArr[i];
            if (byteBuffer != null) {
                j += (long) byteBuffer.remaining();
                i++;
            } else {
                throw new IllegalArgumentException("srcs[" + i + "] is null");
            }
        }
        return j;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        try {
            int doHandshake = this.ssl.doHandshake();
            if (doHandshake == 2) {
                return pendingStatus(pendingOutboundEncryptedBytes());
            }
            if (doHandshake == 3) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            try {
                this.activeSession.onPeerCertificateAvailable(getPeerHost(), getPeerPort());
                finishHandshake();
                return SSLEngineResult.HandshakeStatus.FINISHED;
            } catch (Exception e) {
                throw SSLUtils.toSSLHandshakeException(e);
            }
        } catch (SSLException e2) {
            sendSSLShutdown();
            throw e2;
        } catch (IOException e3) {
            sendSSLShutdown();
            throw e3;
        }
    }

    private void finishHandshake() throws SSLException {
        this.handshakeFinished = true;
        HandshakeListener handshakeListener2 = this.handshakeListener;
        if (handshakeListener2 != null) {
            handshakeListener2.onHandshakeFinished();
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) throws SSLException {
        int i2;
        try {
            int position = byteBuffer.position();
            if (byteBuffer.isDirect()) {
                i2 = writePlaintextDataDirect(byteBuffer, position, i);
            } else {
                i2 = writePlaintextDataHeap(byteBuffer, position, i);
            }
            if (i2 > 0) {
                byteBuffer.position(position + i2);
            }
            return i2;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int writePlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.ssl.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writePlaintextDataHeap(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        ByteBuffer byteBuffer2;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator2 = this.bufferAllocator;
            if (bufferAllocator2 != null) {
                allocatedBuffer = bufferAllocator2.allocateDirectBuffer(i2);
                byteBuffer2 = allocatedBuffer.nioBuffer();
            } else {
                byteBuffer2 = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(i2, byteBuffer2.remaining());
            byteBuffer.limit(i + min);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            byteBuffer.limit(limit);
            byteBuffer.position(i);
            return writePlaintextDataDirect(byteBuffer2, 0, min);
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws IOException {
        try {
            int position = byteBuffer.position();
            int min = Math.min(16709, byteBuffer.limit() - position);
            if (!byteBuffer.isDirect()) {
                return readPlaintextDataHeap(byteBuffer, min);
            }
            int readPlaintextDataDirect = readPlaintextDataDirect(byteBuffer, position, min);
            if (readPlaintextDataDirect > 0) {
                byteBuffer.position(position + readPlaintextDataDirect);
            }
            return readPlaintextDataDirect;
        } catch (CertificateException e) {
            throw convertException(e);
        }
    }

    private int readPlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException, CertificateException {
        return this.ssl.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readPlaintextDataHeap(ByteBuffer byteBuffer, int i) throws IOException, CertificateException {
        ByteBuffer byteBuffer2;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator2 = this.bufferAllocator;
            if (bufferAllocator2 != null) {
                allocatedBuffer = bufferAllocator2.allocateDirectBuffer(i);
                byteBuffer2 = allocatedBuffer.nioBuffer();
            } else {
                byteBuffer2 = getOrCreateLazyDirectBuffer();
            }
            int readPlaintextDataDirect = readPlaintextDataDirect(byteBuffer2, 0, Math.min(i, byteBuffer2.remaining()));
            if (readPlaintextDataDirect > 0) {
                byteBuffer2.position(readPlaintextDataDirect);
                byteBuffer2.flip();
                byteBuffer.put(byteBuffer2);
            }
            return readPlaintextDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private SSLException convertException(Throwable th) {
        if ((th instanceof SSLHandshakeException) || !this.handshakeFinished) {
            return SSLUtils.toSSLHandshakeException(th);
        }
        return SSLUtils.toSSLException(th);
    }

    private int writeEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        int i2;
        try {
            int position = byteBuffer.position();
            if (byteBuffer.isDirect()) {
                i2 = writeEncryptedDataDirect(byteBuffer, position, i);
            } else {
                i2 = writeEncryptedDataHeap(byteBuffer, position, i);
            }
            if (i2 > 0) {
                byteBuffer.position(position + i2);
            }
            return i2;
        } catch (IOException e) {
            throw new SSLException(e);
        }
    }

    private int writeEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.networkBio.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writeEncryptedDataHeap(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        ByteBuffer byteBuffer2;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator2 = this.bufferAllocator;
            if (bufferAllocator2 != null) {
                allocatedBuffer = bufferAllocator2.allocateDirectBuffer(i2);
                byteBuffer2 = allocatedBuffer.nioBuffer();
            } else {
                byteBuffer2 = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(Math.min(limit - i, i2), byteBuffer2.remaining());
            byteBuffer.limit(i + min);
            byteBuffer2.put(byteBuffer);
            byteBuffer.limit(limit);
            byteBuffer.position(i);
            int writeEncryptedDataDirect = writeEncryptedDataDirect(byteBuffer2, 0, min);
            byteBuffer.position(i);
            return writeEncryptedDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private ByteBuffer getOrCreateLazyDirectBuffer() {
        if (this.lazyDirectBuffer == null) {
            this.lazyDirectBuffer = ByteBuffer.allocateDirect(Math.max(16384, 16709));
        }
        this.lazyDirectBuffer.clear();
        return this.lazyDirectBuffer;
    }

    private long directByteBufferAddress(ByteBuffer byteBuffer, int i) {
        return NativeCrypto.getDirectBufferAddress(byteBuffer) + ((long) i);
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        try {
            int pendingOutboundEncryptedBytes = pendingOutboundEncryptedBytes();
            if (pendingOutboundEncryptedBytes <= 0) {
                return null;
            }
            if (byteBuffer.remaining() < pendingOutboundEncryptedBytes) {
                SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
                }
                return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i, i2);
            }
            int readEncryptedData = readEncryptedData(byteBuffer, pendingOutboundEncryptedBytes);
            if (readEncryptedData <= 0) {
                NativeCrypto.SSL_clear_error();
            } else {
                i2 += readEncryptedData;
                pendingOutboundEncryptedBytes -= readEncryptedData;
            }
            SSLEngineResult.Status engineStatus = getEngineStatus();
            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
            }
            return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int position = byteBuffer.position();
            if (byteBuffer.remaining() < i) {
                return 0;
            }
            int min = Math.min(i, byteBuffer.limit() - position);
            if (!byteBuffer.isDirect()) {
                return readEncryptedDataHeap(byteBuffer, min);
            }
            int readEncryptedDataDirect = readEncryptedDataDirect(byteBuffer, position, min);
            if (readEncryptedDataDirect <= 0) {
                return readEncryptedDataDirect;
            }
            byteBuffer.position(position + readEncryptedDataDirect);
            return readEncryptedDataDirect;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.networkBio.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readEncryptedDataHeap(ByteBuffer byteBuffer, int i) throws IOException {
        ByteBuffer byteBuffer2;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator2 = this.bufferAllocator;
            if (bufferAllocator2 != null) {
                allocatedBuffer = bufferAllocator2.allocateDirectBuffer(i);
                byteBuffer2 = allocatedBuffer.nioBuffer();
            } else {
                byteBuffer2 = getOrCreateLazyDirectBuffer();
            }
            int readEncryptedDataDirect = readEncryptedDataDirect(byteBuffer2, 0, Math.min(i, byteBuffer2.remaining()));
            if (readEncryptedDataDirect > 0) {
                byteBuffer2.position(readEncryptedDataDirect);
                byteBuffer2.flip();
                byteBuffer.put(byteBuffer2);
            }
            return readEncryptedDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        return (this.handshakeFinished || handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) ? handshakeStatus : handshake();
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        return !this.handshakeFinished ? pendingStatus(i) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private SSLEngineResult.Status getEngineStatus() {
        int i = this.state;
        if (i == 6 || i == 7 || i == 8) {
            return SSLEngineResult.Status.CLOSED;
        }
        return SSLEngineResult.Status.OK;
    }

    private void closeAll() {
        closeOutbound();
        closeInbound();
    }

    private void freeIfDone() {
        if (isInboundDone() && isOutboundDone()) {
            closeAndFreeResources();
        }
    }

    private SSLException newSslExceptionWithMessage(String str) {
        if (!this.handshakeFinished) {
            return new SSLException(str);
        }
        return new SSLHandshakeException(str);
    }

    private SSLEngineResult newResult(int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatusInternal();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult wrap;
        synchronized (this.ssl) {
            try {
                wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
                resetSingleSrcBuffer();
            } catch (Throwable th) {
                resetSingleSrcBuffer();
                throw th;
            }
        }
        return wrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        SSLEngineResult readPendingBytesFromBIO;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBuffer != null, "dst is null");
        int i3 = i2 + i;
        Preconditions.checkPositionIndexes(i, i3, byteBufferArr.length);
        if (!byteBuffer.isReadOnly()) {
            synchronized (this.ssl) {
                int i4 = this.state;
                if (i4 != 0) {
                    if (i4 == 1) {
                        beginHandshakeInternal();
                    } else if (i4 == 7 || i4 == 8) {
                        SSLEngineResult readPendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, 0, 0, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
                        if (readPendingBytesFromBIO2 == null) {
                            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                        }
                        freeIfDone();
                        return readPendingBytesFromBIO2;
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    if (!this.handshakeFinished) {
                        handshakeStatus = handshake();
                        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                            return NEED_UNWRAP_OK;
                        }
                        if (this.state == 8) {
                            return NEED_UNWRAP_CLOSED;
                        }
                    }
                    int i5 = 0;
                    for (int i6 = i; i6 < i3; i6++) {
                        ByteBuffer byteBuffer2 = byteBufferArr[i6];
                        if (byteBuffer2 != null) {
                            if (i5 != 16384) {
                                i5 += byteBuffer2.remaining();
                                if (i5 > 16384 || i5 < 0) {
                                    i5 = 16384;
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("srcs[" + i6 + "] is null");
                        }
                    }
                    if (byteBuffer.remaining() < SSLUtils.calculateOutNetBufSize(i5)) {
                        return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatusInternal(), 0, 0);
                    }
                    int i7 = 0;
                    int i8 = 0;
                    loop1:
                    while (true) {
                        if (i >= i3) {
                            break;
                        }
                        ByteBuffer byteBuffer3 = byteBufferArr[i];
                        Preconditions.checkArgument(byteBuffer3 != null, "srcs[%d] is null", Integer.valueOf(i));
                        while (byteBuffer3.hasRemaining()) {
                            int writePlaintextData = writePlaintextData(byteBuffer3, Math.min(byteBuffer3.remaining(), 16384 - i8));
                            if (writePlaintextData > 0) {
                                i8 += writePlaintextData;
                                SSLEngineResult readPendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, i8, i7, handshakeStatus);
                                if (readPendingBytesFromBIO3 != null) {
                                    if (readPendingBytesFromBIO3.getStatus() != SSLEngineResult.Status.OK) {
                                        return readPendingBytesFromBIO3;
                                    }
                                    i7 = readPendingBytesFromBIO3.bytesProduced();
                                    continue;
                                }
                                if (i8 == 16384) {
                                    break loop1;
                                }
                            } else {
                                int error = this.ssl.getError(writePlaintextData);
                                if (error == 2) {
                                    SSLEngineResult readPendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, i8, i7, handshakeStatus);
                                    if (readPendingBytesFromBIO4 == null) {
                                        readPendingBytesFromBIO4 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, i8, i7);
                                    }
                                    return readPendingBytesFromBIO4;
                                } else if (error == 3) {
                                    SSLEngineResult readPendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, i8, i7, handshakeStatus);
                                    if (readPendingBytesFromBIO5 == null) {
                                        readPendingBytesFromBIO5 = NEED_WRAP_CLOSED;
                                    }
                                    return readPendingBytesFromBIO5;
                                } else if (error == 6) {
                                    closeAll();
                                    SSLEngineResult readPendingBytesFromBIO6 = readPendingBytesFromBIO(byteBuffer, i8, i7, handshakeStatus);
                                    if (readPendingBytesFromBIO6 == null) {
                                        readPendingBytesFromBIO6 = CLOSED_NOT_HANDSHAKING;
                                    }
                                    return readPendingBytesFromBIO6;
                                } else {
                                    sendSSLShutdown();
                                    throw newSslExceptionWithMessage("SSL_write");
                                }
                            }
                        }
                        i++;
                    }
                    if (i8 != 0 || (readPendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, i7, handshakeStatus)) == null) {
                        return newResult(i8, i7, handshakeStatus);
                    }
                    return readPendingBytesFromBIO;
                }
                throw new IllegalStateException("Client/server mode must be set before calling wrap");
            }
        }
        throw new ReadOnlyBufferException();
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(int i, int i2) {
        synchronized (this.ssl) {
            if (i == 16) {
                transitionTo(2);
            } else if (i == 32) {
                int i3 = this.state;
                if (i3 != 2) {
                    if (i3 != 4) {
                        throw new IllegalStateException("Completed handshake while in mode " + this.state);
                    }
                }
                transitionTo(3);
            }
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onNewSessionEstablished(long j) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager != null) {
                        this.activeSession.onPeerCertificatesReceived(getPeerHost(), getPeerPort(), decodeX509CertificateChain);
                        if (getUseClientMode()) {
                            Platform.checkServerTrusted(x509TrustManager, decodeX509CertificateChain, str, this);
                            return;
                        } else {
                            Platform.checkClientTrusted(x509TrustManager, decodeX509CertificateChain, decodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                            return;
                        }
                    } else {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                }
            } catch (CertificateException e) {
                throw e;
            } catch (Exception e2) {
                throw new CertificateException(e2);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    private void sendSSLShutdown() {
        try {
            this.ssl.shutdown();
        } catch (IOException unused) {
        }
    }

    private void closeAndFreeResources() {
        transitionTo(8);
        if (!this.ssl.isClosed()) {
            this.ssl.close();
            this.networkBio.close();
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            transitionTo(8);
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        if (x509KeyManager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this);
        }
        return x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        if (x509KeyManager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this);
        }
        return x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        synchronized (this.ssl) {
            int i2 = this.state;
            if (i2 >= 3) {
                if (i2 != 8) {
                    return this.ssl.exportKeyingMaterial(str, bArr, i);
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getApplicationProtocol() {
        return SSLUtils.toProtocolString(this.ssl.getApplicationProtocol());
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            applicationProtocol = this.state == 2 ? getApplicationProtocol() : null;
        }
        return applicationProtocol;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    private void transitionTo(int i) {
        int i2;
        if (i == 2) {
            this.handshakeFinished = false;
            this.activeSession = new ActiveSession(this.ssl, this.sslParameters.getSessionContext());
        } else if (i == 8 && !this.ssl.isClosed() && (i2 = this.state) >= 2 && i2 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i;
    }
}
