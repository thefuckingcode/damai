package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import kotlin.UByte;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.SSLParametersImpl;

/* access modifiers changed from: package-private */
public class ConscryptFileDescriptorSocket extends OpenSSLSocketImpl implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final boolean DBG_STATE = false;
    private final ActiveSession activeSession;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
        /* class org.conscrypt.ConscryptFileDescriptorSocket.AnonymousClass1 */

        @Override // org.conscrypt.ExternalSession.Provider
        public ConscryptSession provideSession() {
            return ConscryptFileDescriptorSocket.this.provideSession();
        }
    }));
    private final Object guard = Platform.closeGuardGet();
    private int handshakeTimeoutMilliseconds = -1;
    private SSLInputStream is;
    private SSLOutputStream os;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state = 0;
    private int writeTimeoutMilliseconds = 0;

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final long serverSessionRequested(byte[] bArr) {
        return 0;
    }

    ConscryptFileDescriptorSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i, inetAddress, i2);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i, z);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptFileDescriptorSocket conscryptFileDescriptorSocket) throws SSLException {
        return NativeSsl.newInstance(sSLParametersImpl, conscryptFileDescriptorSocket, conscryptFileDescriptorSocket, conscryptFileDescriptorSocket);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (getUseClientMode() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0115, code lost:
        if (r1.getMessage().contains("unexpected CCS") != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0117, code lost:
        org.conscrypt.Platform.logEvent(java.lang.String.format("ssl_unexpected_ccs: host=%s", getHostnameOrIP()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0128, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x012c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x012d, code lost:
        r3 = new javax.net.ssl.SSLHandshakeException(r1.getMessage());
        r3.initCause(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0139, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = clientSessionContext().getCachedSession(getHostnameOrIP(), getPort(), r9.sslParameters);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x013d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x013f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x014d, code lost:
        throw ((javax.net.ssl.SSLHandshakeException) new javax.net.ssl.SSLHandshakeException("Handshake failed").initCause(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x014e, code lost:
        if (1 != 0) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0152, code lost:
        monitor-enter(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r3 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0163, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r3.offerToResume(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r3 = getSoTimeout();
        r4 = getSoWriteTimeout();
        r5 = r9.handshakeTimeoutMilliseconds;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r5 < 0) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        setSoTimeout(r5);
        setSoWriteTimeout(r9.handshakeTimeoutMilliseconds);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        r5 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r9.state != 8) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r1 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r9.ssl.doHandshake(org.conscrypt.Platform.getFileDescriptor(r9.socket), getSoTimeout());
        r9.activeSession.onPeerCertificateAvailable(getHostnameOrIP(), getPort());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        r6 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0095, code lost:
        if (r9.state != 8) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0098, code lost:
        r1 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ab, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ae, code lost:
        if (r9.handshakeTimeoutMilliseconds < 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b0, code lost:
        setSoTimeout(r3);
        setSoWriteTimeout(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b6, code lost:
        r3 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b8, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r4 = r9.state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bb, code lost:
        if (r4 != 8) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00be, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00bf, code lost:
        if (r4 != 2) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c1, code lost:
        transitionTo(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c6, code lost:
        transitionTo(5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ca, code lost:
        if (r0 != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00cc, code lost:
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d1, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d2, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d4, code lost:
        r0 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d6, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00df, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00ee, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00f1, code lost:
        monitor-enter(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00f4, code lost:
        if (r9.state == 8) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00f9, code lost:
        monitor-enter(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        org.conscrypt.Platform.closeGuardOpen(r9.guard, com.lzy.okgo.model.HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
        r9.ssl.initialize(getHostname(), r9.channelIdPrivateKey);
     */
    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() throws IOException {
        checkOpen();
        synchronized (this.ssl) {
            if (this.state == 0) {
                transitionTo(2);
            }
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void onSSLStateChange(int i, int i2) {
        if (i == 32) {
            synchronized (this.ssl) {
                if (this.state != 8) {
                    transitionTo(5);
                    notifyHandshakeCompletedListeners();
                    synchronized (this.ssl) {
                        this.ssl.notifyAll();
                    }
                }
            }
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void onNewSessionEstablished(long j) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager != null) {
                        this.activeSession.onPeerCertificatesReceived(getHostnameOrIP(), getPort(), decodeX509CertificateChain);
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

    @Override // java.net.Socket, org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final InputStream getInputStream() throws IOException {
        SSLInputStream sSLInputStream;
        checkOpen();
        synchronized (this.ssl) {
            if (this.state != 8) {
                if (this.is == null) {
                    this.is = new SSLInputStream();
                }
                sSLInputStream = this.is;
            } else {
                throw new SocketException("Socket is closed.");
            }
        }
        waitForHandshake();
        return sSLInputStream;
    }

    @Override // java.net.Socket, org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final OutputStream getOutputStream() throws IOException {
        SSLOutputStream sSLOutputStream;
        checkOpen();
        synchronized (this.ssl) {
            if (this.state != 8) {
                if (this.os == null) {
                    this.os = new SSLOutputStream();
                }
                sSLOutputStream = this.os;
            } else {
                throw new SocketException("Socket is closed.");
            }
        }
        waitForHandshake();
        return sSLOutputStream;
    }

    private void assertReadableOrWriteableState() {
        int i = this.state;
        if (i != 5 && i != 4) {
            throw new AssertionError("Invalid state: " + this.state);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c  */
    private void waitForHandshake() throws IOException {
        int i;
        startHandshake();
        synchronized (this.ssl) {
            while (true) {
                i = this.state;
                if (i != 5 && i != 4 && i != 8) {
                    try {
                        this.ssl.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new IOException("Interrupted waiting for handshake", e);
                    }
                } else if (i != 8) {
                    throw new SocketException("Socket is closed");
                }
            }
            if (i != 8) {
            }
        }
    }

    private class SSLInputStream extends InputStream {
        private final Object readLock = new Object();

        SSLInputStream() {
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr, 0, 1) != -1) {
                return bArr[0] & UByte.MAX_VALUE;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            Platform.blockGuardOnNetwork();
            ConscryptFileDescriptorSocket.this.checkOpen();
            ArrayUtils.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 == 0) {
                return 0;
            }
            synchronized (this.readLock) {
                synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                    if (ConscryptFileDescriptorSocket.this.state == 8) {
                        throw new SocketException("socket is closed");
                    }
                }
                read = ConscryptFileDescriptorSocket.this.ssl.read(Platform.getFileDescriptor(ConscryptFileDescriptorSocket.this.socket), bArr, i, i2, ConscryptFileDescriptorSocket.this.getSoTimeout());
                if (read == -1) {
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                }
            }
            return read;
        }

        @Override // java.io.InputStream
        public int available() {
            return ConscryptFileDescriptorSocket.this.ssl.getPendingReadableBytes();
        }

        /* access modifiers changed from: package-private */
        public void awaitPendingOps() {
            synchronized (this.readLock) {
            }
        }
    }

    private class SSLOutputStream extends OutputStream {
        private final Object writeLock = new Object();

        SSLOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) (i & 255)});
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            Platform.blockGuardOnNetwork();
            ConscryptFileDescriptorSocket.this.checkOpen();
            ArrayUtils.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 != 0) {
                synchronized (this.writeLock) {
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                    ConscryptFileDescriptorSocket.this.ssl.write(Platform.getFileDescriptor(ConscryptFileDescriptorSocket.this.socket), bArr, i, i2, ConscryptFileDescriptorSocket.this.writeTimeoutMilliseconds);
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void awaitPendingOps() {
            synchronized (this.writeLock) {
            }
        }
    }

    public final SSLSession getSession() {
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
            }
            boolean z = true;
            boolean z2 = i >= 5;
            if (!z2) {
                try {
                    if (isConnected()) {
                        waitForHandshake();
                        z2 = z;
                    }
                } catch (IOException unused) {
                    if (!z2) {
                        return SSLNullSession.getNullSession();
                    }
                    return this.activeSession;
                }
            }
            z = z2;
            z2 = z;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ConscryptSession provideHandshakeSession() {
        ConscryptSession conscryptSession;
        synchronized (this.ssl) {
            int i = this.state;
            if (i < 2 || i >= 5) {
                conscryptSession = SSLNullSession.getNullSession();
            } else {
                conscryptSession = this.activeSession;
            }
        }
        return conscryptSession;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final SSLSession getActiveSession() {
        return this.activeSession;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final SSLSession getHandshakeSession() {
        synchronized (this.ssl) {
            int i = this.state;
            if (i < 2 || i >= 5) {
                return null;
            }
            return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
                /* class org.conscrypt.ConscryptFileDescriptorSocket.AnonymousClass2 */

                @Override // org.conscrypt.ExternalSession.Provider
                public ConscryptSession provideSession() {
                    return ConscryptFileDescriptorSocket.this.provideHandshakeSession();
                }
            }));
        }
    }

    public final boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    public final String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    public final void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        super.setHostname(str);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdEnabled(boolean z) {
        if (!getUseClientMode()) {
            synchronized (this.ssl) {
                if (this.state != 0) {
                    throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
                }
            }
            this.sslParameters.channelIdEnabled = z;
            return;
        }
        throw new IllegalStateException("Client mode");
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final byte[] getChannelId() throws SSLException {
        if (!getUseClientMode()) {
            synchronized (this.ssl) {
                if (this.state != 5) {
                    throw new IllegalStateException("Channel ID is only available after handshake completes");
                }
            }
            return this.ssl.getTlsChannelId();
        }
        throw new IllegalStateException("Client mode");
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (getUseClientMode()) {
            synchronized (this.ssl) {
                if (this.state != 0) {
                    throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
                }
            }
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
        } else {
            throw new IllegalStateException("Server mode");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
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

    public final boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    public final void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            if (this.state != 0) {
                throw new IllegalArgumentException("Could not change the mode after the initial handshake has begun.");
            }
        }
        this.sslParameters.setUseClientMode(z);
    }

    public final boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    public final boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    public final void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setSoWriteTimeout(int i) throws SocketException {
        this.writeTimeoutMilliseconds = i;
        Platform.setSocketWriteTimeout(this, (long) i);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final int getSoWriteTimeout() throws SocketException {
        return this.writeTimeoutMilliseconds;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setHandshakeTimeout(int i) throws SocketException {
        this.handshakeTimeoutMilliseconds = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (r1 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r2 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        r3.ssl.interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (r1 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
        r1.awaitPendingOps();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r2 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        r2.awaitPendingOps();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004f, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0052, code lost:
        return;
     */
    @Override // java.net.Socket, org.conscrypt.OpenSSLSocketImpl, java.io.Closeable, org.conscrypt.AbstractConscryptSocket, java.lang.AutoCloseable
    public final void close() throws IOException {
        NativeSsl nativeSsl = this.ssl;
        if (nativeSsl != null) {
            synchronized (nativeSsl) {
                int i = this.state;
                if (i != 8) {
                    transitionTo(8);
                    if (i == 0) {
                        free();
                        closeUnderlyingSocket();
                        this.ssl.notifyAll();
                    } else if (i == 5 || i == 4) {
                        this.ssl.notifyAll();
                        SSLInputStream sSLInputStream = this.is;
                        SSLOutputStream sSLOutputStream = this.os;
                    } else {
                        this.ssl.interrupt();
                        this.ssl.notifyAll();
                    }
                }
            }
        }
    }

    private void shutdownAndFreeSslNative() throws IOException {
        try {
            Platform.blockGuardOnNetwork();
            this.ssl.shutdown(Platform.getFileDescriptor(this.socket));
        } catch (IOException unused) {
        } catch (Throwable th) {
            free();
            closeUnderlyingSocket();
            throw th;
        }
        free();
        closeUnderlyingSocket();
    }

    private void closeUnderlyingSocket() throws IOException {
        super.close();
    }

    private void free() {
        if (!this.ssl.isClosed()) {
            this.ssl.close();
            Platform.closeGuardClose(this.guard);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        try {
            Object obj = this.guard;
            if (obj != null) {
                Platform.closeGuardWarnIfOpen(obj);
            }
            NativeSsl nativeSsl = this.ssl;
            if (nativeSsl != null) {
                synchronized (nativeSsl) {
                    transitionTo(8);
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final String getApplicationProtocol() {
        return SSLUtils.toProtocolString(this.ssl.getApplicationProtocol());
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            int i = this.state;
            applicationProtocol = (i < 2 || i >= 5) ? null : getApplicationProtocol();
        }
        return applicationProtocol;
    }

    public final SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    public final void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public final String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager.chooseServerAlias(str, null, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public final String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public final String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public final String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public final SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    private void transitionTo(int i) {
        int i2;
        if (i == 8 && !this.ssl.isClosed() && (i2 = this.state) >= 2 && i2 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i;
    }
}
