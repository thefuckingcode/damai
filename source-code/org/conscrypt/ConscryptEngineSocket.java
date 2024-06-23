package org.conscrypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* access modifiers changed from: package-private */
public class ConscryptEngineSocket extends OpenSSLSocketImpl {
    private static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocate(0);
    private BufferAllocator bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
    private final ConscryptEngine engine;
    private final Object handshakeLock = new Object();
    private SSLInputStream in;
    private SSLOutputStream out;
    private int state = 0;
    private final Object stateLock = new Object();

    ConscryptEngineSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i, inetAddress, i2);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i, z);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    private static ConscryptEngine newEngine(SSLParametersImpl sSLParametersImpl, ConscryptEngineSocket conscryptEngineSocket) {
        ConscryptEngine conscryptEngine = new ConscryptEngine(Platform.supportsX509ExtendedTrustManager() ? sSLParametersImpl.cloneWithTrustManager(getDelegatingTrustManager(sSLParametersImpl.getX509TrustManager(), conscryptEngineSocket)) : sSLParametersImpl, conscryptEngineSocket.peerInfoProvider());
        conscryptEngine.setHandshakeListener(new HandshakeListener() {
            /* class org.conscrypt.ConscryptEngineSocket.AnonymousClass1 */

            @Override // org.conscrypt.HandshakeListener
            public void onHandshakeFinished() {
                ConscryptEngineSocket.this.onHandshakeFinished();
            }
        });
        conscryptEngine.setUseClientMode(sSLParametersImpl.getUseClientMode());
        return conscryptEngine;
    }

    private static X509TrustManager getDelegatingTrustManager(X509TrustManager x509TrustManager, final ConscryptEngineSocket conscryptEngineSocket) {
        if (!(x509TrustManager instanceof X509ExtendedTrustManager)) {
            return x509TrustManager;
        }
        final X509ExtendedTrustManager x509ExtendedTrustManager = (X509ExtendedTrustManager) x509TrustManager;
        return new X509ExtendedTrustManager() {
            /* class org.conscrypt.ConscryptEngineSocket.AnonymousClass2 */

            @Override // javax.net.ssl.X509ExtendedTrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
                throw new AssertionError("Should not be called");
            }

            @Override // javax.net.ssl.X509ExtendedTrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
                throw new AssertionError("Should not be called");
            }

            @Override // javax.net.ssl.X509ExtendedTrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
                x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str, conscryptEngineSocket);
            }

            @Override // javax.net.ssl.X509ExtendedTrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
                x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, conscryptEngineSocket);
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str);
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str);
            }

            public X509Certificate[] getAcceptedIssuers() {
                return x509ExtendedTrustManager.getAcceptedIssuers();
            }
        };
    }

    public final SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    public final void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() throws IOException {
        checkOpen();
        try {
            synchronized (this.handshakeLock) {
                synchronized (this.stateLock) {
                    if (this.state == 0) {
                        this.state = 2;
                        this.engine.beginHandshake();
                        this.in = new SSLInputStream();
                        this.out = new SSLOutputStream();
                        doHandshake();
                    }
                }
            }
        } catch (SSLException e) {
            close();
            throw e;
        } catch (IOException e2) {
            close();
            throw e2;
        } catch (Exception e3) {
            close();
            throw SSLUtils.toSSLHandshakeException(e3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doHandshake() throws IOException {
        boolean z = false;
        while (!z) {
            try {
                int i = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[this.engine.getHandshakeStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        this.out.writeInternal(EMPTY_BUFFER);
                        this.out.flushInternal();
                    } else if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw new IllegalStateException("Unknown handshake status: " + this.engine.getHandshakeStatus());
                            }
                        }
                        z = true;
                    } else {
                        throw new IllegalStateException("Engine tasks are unsupported");
                    }
                } else if (this.in.processDataFromSocket(EmptyArray.BYTE, 0, 0) < 0) {
                    throw SSLUtils.toSSLHandshakeException(new EOFException());
                }
            } catch (SSLException e) {
                drainOutgoingQueue();
                close();
                throw e;
            } catch (IOException e2) {
                close();
                throw e2;
            } catch (Exception e3) {
                close();
                throw SSLUtils.toSSLHandshakeException(e3);
            }
        }
    }

    @Override // java.net.Socket, org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final InputStream getInputStream() throws IOException {
        checkOpen();
        waitForHandshake();
        return this.in;
    }

    @Override // java.net.Socket, org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final OutputStream getOutputStream() throws IOException {
        checkOpen();
        waitForHandshake();
        return this.out;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final SSLSession getHandshakeSession() {
        return this.engine.handshakeSession();
    }

    public final SSLSession getSession() {
        if (isConnected()) {
            try {
                waitForHandshake();
            } catch (IOException unused) {
            }
        }
        return this.engine.getSession();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final SSLSession getActiveSession() {
        return this.engine.getSession();
    }

    public final boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.engine.setEnableSessionCreation(z);
    }

    public final String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.engine.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    public final void setEnabledProtocols(String[] strArr) {
        this.engine.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setHostname(String str) {
        this.engine.setHostname(str);
        super.setHostname(str);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setUseSessionTickets(boolean z) {
        this.engine.setUseSessionTickets(z);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdEnabled(boolean z) {
        this.engine.setChannelIdEnabled(z);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final byte[] getChannelId() throws SSLException {
        return this.engine.getChannelId();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.engine.setChannelIdPrivateKey(privateKey);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] getTlsUnique() {
        return this.engine.getTlsUnique();
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        return this.engine.exportKeyingMaterial(str, bArr, i);
    }

    public final boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    public final void setUseClientMode(boolean z) {
        this.engine.setUseClientMode(z);
    }

    public final boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    public final boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    public final void setNeedClientAuth(boolean z) {
        this.engine.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.engine.setWantClientAuth(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        super.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r3.engine.closeInbound();
        r3.engine.closeOutbound();
        r0 = r3.in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r0.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r3.engine.closeInbound();
        r3.engine.closeOutbound();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r3.in != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r3.in.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    @Override // java.net.Socket, org.conscrypt.OpenSSLSocketImpl, java.io.Closeable, org.conscrypt.AbstractConscryptSocket, java.lang.AutoCloseable
    public final void close() throws IOException {
        Object obj = this.stateLock;
        if (obj != null) {
            synchronized (obj) {
                if (this.state != 8) {
                    this.state = 8;
                    this.stateLock.notifyAll();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocols(String[] strArr) {
        this.engine.setApplicationProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final String[] getApplicationProtocols() {
        return this.engine.getApplicationProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final String getApplicationProtocol() {
        return this.engine.getApplicationProtocol();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final String getHandshakeApplicationProtocol() {
        return this.engine.getHandshakeApplicationProtocol();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.engine.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* access modifiers changed from: package-private */
    public void setBufferAllocator(BufferAllocator bufferAllocator2) {
        this.engine.setBufferAllocator(bufferAllocator2);
        this.bufferAllocator = bufferAllocator2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onHandshakeFinished() {
        boolean z;
        synchronized (this.stateLock) {
            int i = this.state;
            if (i != 8) {
                if (i == 2) {
                    this.state = 4;
                } else if (i == 3) {
                    this.state = 5;
                }
                this.stateLock.notifyAll();
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            notifyHandshakeCompletedListeners();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c  */
    private void waitForHandshake() throws IOException {
        int i;
        startHandshake();
        synchronized (this.stateLock) {
            while (true) {
                i = this.state;
                if (i != 5 && i != 4 && i != 8) {
                    try {
                        this.stateLock.wait();
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

    private void drainOutgoingQueue() {
        while (this.engine.pendingOutboundEncryptedBytes() > 0) {
            try {
                this.out.writeInternal(EMPTY_BUFFER);
                this.out.flushInternal();
            } catch (IOException unused) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private OutputStream getUnderlyingOutputStream() throws IOException {
        return super.getOutputStream();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private InputStream getUnderlyingInputStream() throws IOException {
        return super.getInputStream();
    }

    /* access modifiers changed from: private */
    public final class SSLOutputStream extends OutputStream {
        private OutputStream socketOutputStream;
        private final ByteBuffer target;
        private final int targetArrayOffset;
        private final Object writeLock = new Object();

        SSLOutputStream() {
            ByteBuffer allocate = ByteBuffer.allocate(ConscryptEngineSocket.this.engine.getSession().getPacketBufferSize());
            this.target = allocate;
            this.targetArrayOffset = allocate.arrayOffset();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ConscryptEngineSocket.this.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                write(new byte[]{(byte) i});
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                writeInternal(ByteBuffer.wrap(bArr));
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                writeInternal(ByteBuffer.wrap(bArr, i, i2));
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void writeInternal(ByteBuffer byteBuffer) throws IOException {
            Platform.blockGuardOnNetwork();
            ConscryptEngineSocket.this.checkOpen();
            init();
            int remaining = byteBuffer.remaining();
            do {
                this.target.clear();
                SSLEngineResult wrap = ConscryptEngineSocket.this.engine.wrap(byteBuffer, this.target);
                if (wrap.getStatus() != SSLEngineResult.Status.OK) {
                    throw new SSLException("Unexpected engine result " + wrap.getStatus());
                } else if (this.target.position() == wrap.bytesProduced()) {
                    remaining -= wrap.bytesConsumed();
                    if (remaining == byteBuffer.remaining()) {
                        this.target.flip();
                        writeToSocket();
                    } else {
                        throw new SSLException("Engine did not read the correct number of bytes");
                    }
                } else {
                    throw new SSLException("Engine bytesProduced " + wrap.bytesProduced() + " does not match bytes written " + this.target.position());
                }
            } while (remaining > 0);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                flushInternal();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void flushInternal() throws IOException {
            ConscryptEngineSocket.this.checkOpen();
            init();
            this.socketOutputStream.flush();
        }

        private void init() throws IOException {
            if (this.socketOutputStream == null) {
                this.socketOutputStream = ConscryptEngineSocket.this.getUnderlyingOutputStream();
            }
        }

        private void writeToSocket() throws IOException {
            this.socketOutputStream.write(this.target.array(), this.targetArrayOffset, this.target.limit());
        }
    }

    /* access modifiers changed from: private */
    public final class SSLInputStream extends InputStream {
        private final AllocatedBuffer allocatedBuffer;
        private final ByteBuffer fromEngine;
        private final ByteBuffer fromSocket;
        private final int fromSocketArrayOffset;
        private final Object readLock = new Object();
        private final byte[] singleByte = new byte[1];
        private InputStream socketInputStream;

        SSLInputStream() {
            if (ConscryptEngineSocket.this.bufferAllocator != null) {
                AllocatedBuffer allocateDirectBuffer = ConscryptEngineSocket.this.bufferAllocator.allocateDirectBuffer(ConscryptEngineSocket.this.engine.getSession().getApplicationBufferSize());
                this.allocatedBuffer = allocateDirectBuffer;
                this.fromEngine = allocateDirectBuffer.nioBuffer();
            } else {
                this.allocatedBuffer = null;
                this.fromEngine = ByteBuffer.allocateDirect(ConscryptEngineSocket.this.engine.getSession().getApplicationBufferSize());
            }
            this.fromEngine.flip();
            ByteBuffer allocate = ByteBuffer.allocate(ConscryptEngineSocket.this.engine.getSession().getPacketBufferSize());
            this.fromSocket = allocate;
            this.fromSocketArrayOffset = allocate.arrayOffset();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            ConscryptEngineSocket.this.close();
        }

        /* access modifiers changed from: package-private */
        public void release() {
            synchronized (this.readLock) {
                AllocatedBuffer allocatedBuffer2 = this.allocatedBuffer;
                if (allocatedBuffer2 != null) {
                    allocatedBuffer2.release();
                }
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                int read = read(this.singleByte, 0, 1);
                if (read == -1) {
                    return -1;
                }
                if (read == 1) {
                    return this.singleByte[0];
                }
                throw new SSLException("read incorrect number of bytes " + read);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int read;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                read = read(bArr, 0, bArr.length);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int readUntilDataAvailable;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                readUntilDataAvailable = readUntilDataAvailable(bArr, i, i2);
            }
            return readUntilDataAvailable;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int remaining;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                init();
                remaining = this.fromEngine.remaining();
            }
            return remaining;
        }

        private boolean isHandshaking(SSLEngineResult.HandshakeStatus handshakeStatus) {
            int i = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
            return i == 1 || i == 2 || i == 3;
        }

        private int readUntilDataAvailable(byte[] bArr, int i, int i2) throws IOException {
            int processDataFromSocket;
            do {
                processDataFromSocket = processDataFromSocket(bArr, i, i2);
            } while (processDataFromSocket == 0);
            return processDataFromSocket;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a0, code lost:
            if (r1.bytesProduced() == 0) goto L_0x00a4;
         */
        private int processDataFromSocket(byte[] bArr, int i, int i2) throws IOException {
            Platform.blockGuardOnNetwork();
            ConscryptEngineSocket.this.checkOpen();
            init();
            while (this.fromEngine.remaining() <= 0) {
                this.fromSocket.flip();
                this.fromEngine.clear();
                boolean isHandshaking = isHandshaking(ConscryptEngineSocket.this.engine.getHandshakeStatus());
                SSLEngineResult unwrap = ConscryptEngineSocket.this.engine.unwrap(this.fromSocket, this.fromEngine);
                this.fromSocket.compact();
                this.fromEngine.flip();
                int i3 = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[unwrap.getStatus().ordinal()];
                boolean z = true;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            return -1;
                        }
                        throw new SSLException("Unexpected engine result " + unwrap.getStatus());
                    } else if (!isHandshaking && isHandshaking(unwrap.getHandshakeStatus()) && isHandshakeFinished()) {
                        renegotiate();
                        return 0;
                    }
                }
                z = false;
                if (!z && unwrap.bytesProduced() == 0) {
                    return 0;
                }
                if (z && readFromSocket() == -1) {
                    return -1;
                }
            }
            int min = Math.min(this.fromEngine.remaining(), i2);
            this.fromEngine.get(bArr, i, min);
            return min;
        }

        private boolean isHandshakeFinished() {
            boolean z;
            synchronized (ConscryptEngineSocket.this.stateLock) {
                z = ConscryptEngineSocket.this.state >= 4;
            }
            return z;
        }

        private void renegotiate() throws IOException {
            synchronized (ConscryptEngineSocket.this.handshakeLock) {
                ConscryptEngineSocket.this.doHandshake();
            }
        }

        private void init() throws IOException {
            if (this.socketInputStream == null) {
                this.socketInputStream = ConscryptEngineSocket.this.getUnderlyingInputStream();
            }
        }

        private int readFromSocket() throws IOException {
            try {
                int position = this.fromSocket.position();
                int read = this.socketInputStream.read(this.fromSocket.array(), this.fromSocketArrayOffset + position, this.fromSocket.limit() - position);
                if (read > 0) {
                    this.fromSocket.position(position + read);
                }
                return read;
            } catch (EOFException unused) {
                return -1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.conscrypt.ConscryptEngineSocket$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            iArr2[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 1;
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 2;
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 4;
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
