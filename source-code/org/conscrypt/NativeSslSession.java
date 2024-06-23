package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.conscrypt.NativeRef;
import org.conscrypt.SSLUtils;

abstract class NativeSslSession {
    private static final Logger logger = Logger.getLogger(NativeSslSession.class.getName());

    /* access modifiers changed from: package-private */
    public abstract String getCipherSuite();

    /* access modifiers changed from: package-private */
    public abstract byte[] getId();

    /* access modifiers changed from: package-private */
    public abstract String getPeerHost();

    /* access modifiers changed from: package-private */
    public abstract byte[] getPeerOcspStapledResponse();

    /* access modifiers changed from: package-private */
    public abstract int getPeerPort();

    /* access modifiers changed from: package-private */
    public abstract byte[] getPeerSignedCertificateTimestamp();

    /* access modifiers changed from: package-private */
    public abstract String getProtocol();

    /* access modifiers changed from: package-private */
    public abstract boolean isSingleUse();

    /* access modifiers changed from: package-private */
    public abstract boolean isValid();

    /* access modifiers changed from: package-private */
    public abstract void offerToResume(NativeSsl nativeSsl) throws SSLException;

    /* access modifiers changed from: package-private */
    public abstract byte[] toBytes();

    /* access modifiers changed from: package-private */
    public abstract SSLSession toSSLSession();

    NativeSslSession() {
    }

    static NativeSslSession newInstance(NativeRef.SSL_SESSION ssl_session, ConscryptSession conscryptSession) throws SSLPeerUnverifiedException {
        AbstractSessionContext abstractSessionContext = (AbstractSessionContext) conscryptSession.getSessionContext();
        if (abstractSessionContext instanceof ClientSessionContext) {
            return new Impl(abstractSessionContext, ssl_session, conscryptSession.getPeerHost(), conscryptSession.getPeerPort(), conscryptSession.getPeerCertificates(), getOcspResponse(conscryptSession), conscryptSession.getPeerSignedCertificateTimestamp());
        }
        return new Impl(abstractSessionContext, ssl_session, null, -1, null, null, null);
    }

    private static byte[] getOcspResponse(ConscryptSession conscryptSession) {
        List<byte[]> statusResponses = conscryptSession.getStatusResponses();
        if (statusResponses.size() >= 1) {
            return statusResponses.get(0);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    static NativeSslSession newInstance(AbstractSessionContext abstractSessionContext, byte[] bArr, String str, int i) {
        byte[] bArr2;
        byte[] bArr3;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        try {
            int i2 = wrap.getInt();
            if (SSLUtils.SessionType.isSupportedType(i2)) {
                int i3 = wrap.getInt();
                checkRemaining(wrap, i3);
                byte[] bArr4 = new byte[i3];
                wrap.get(bArr4);
                int i4 = wrap.getInt();
                checkRemaining(wrap, i4);
                X509Certificate[] x509CertificateArr = new X509Certificate[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = wrap.getInt();
                    checkRemaining(wrap, i6);
                    byte[] bArr5 = new byte[i6];
                    wrap.get(bArr5);
                    try {
                        x509CertificateArr[i5] = OpenSSLX509Certificate.fromX509Der(bArr5);
                    } catch (Exception unused) {
                        throw new IOException("Can not read certificate " + i5 + "/" + i4);
                    }
                }
                if (i2 >= SSLUtils.SessionType.OPEN_SSL_WITH_OCSP.value) {
                    int i7 = wrap.getInt();
                    checkRemaining(wrap, i7);
                    if (i7 >= 1) {
                        int i8 = wrap.getInt();
                        checkRemaining(wrap, i8);
                        byte[] bArr6 = new byte[i8];
                        wrap.get(bArr6);
                        for (int i9 = 1; i9 < i7; i9++) {
                            int i10 = wrap.getInt();
                            checkRemaining(wrap, i10);
                            wrap.position(wrap.position() + i10);
                        }
                        bArr2 = bArr6;
                        if (i2 == SSLUtils.SessionType.OPEN_SSL_WITH_TLS_SCT.value) {
                            int i11 = wrap.getInt();
                            checkRemaining(wrap, i11);
                            if (i11 > 0) {
                                byte[] bArr7 = new byte[i11];
                                wrap.get(bArr7);
                                bArr3 = bArr7;
                                if (wrap.remaining() == 0) {
                                    return new Impl(abstractSessionContext, new NativeRef.SSL_SESSION(NativeCrypto.d2i_SSL_SESSION(bArr4)), str, i, x509CertificateArr, bArr2, bArr3);
                                }
                                log(new AssertionError("Read entire session, but data still remains; rejecting"));
                                return null;
                            }
                        }
                        bArr3 = null;
                        if (wrap.remaining() == 0) {
                        }
                    }
                }
                bArr2 = null;
                if (i2 == SSLUtils.SessionType.OPEN_SSL_WITH_TLS_SCT.value) {
                }
                bArr3 = null;
                if (wrap.remaining() == 0) {
                }
            } else {
                throw new IOException("Unexpected type ID: " + i2);
            }
        } catch (IOException e) {
            log(e);
            return null;
        } catch (BufferUnderflowException e2) {
            log(e2);
            return null;
        }
    }

    private static final class Impl extends NativeSslSession {
        private final String cipherSuite;
        private final AbstractSessionContext context;
        private final String host;
        private final X509Certificate[] peerCertificates;
        private final byte[] peerOcspStapledResponse;
        private final byte[] peerSignedCertificateTimestamp;
        private final int port;
        private final String protocol;
        private final NativeRef.SSL_SESSION ref;

        private Impl(AbstractSessionContext abstractSessionContext, NativeRef.SSL_SESSION ssl_session, String str, int i, X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2) {
            this.context = abstractSessionContext;
            this.host = str;
            this.port = i;
            this.peerCertificates = x509CertificateArr;
            this.peerOcspStapledResponse = bArr;
            this.peerSignedCertificateTimestamp = bArr2;
            this.protocol = NativeCrypto.SSL_SESSION_get_version(ssl_session.address);
            this.cipherSuite = NativeCrypto.cipherSuiteToJava(NativeCrypto.SSL_SESSION_cipher(ssl_session.address));
            this.ref = ssl_session;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public byte[] getId() {
            return NativeCrypto.SSL_SESSION_session_id(this.ref.address);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long getCreationTime() {
            return NativeCrypto.SSL_SESSION_get_time(this.ref.address);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public boolean isValid() {
            return System.currentTimeMillis() - (Math.max(0, Math.min((long) this.context.getSessionTimeout(), NativeCrypto.SSL_SESSION_get_timeout(this.ref.address))) * 1000) < getCreationTime();
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public boolean isSingleUse() {
            return NativeCrypto.SSL_SESSION_should_be_single_use(this.ref.address);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public void offerToResume(NativeSsl nativeSsl) throws SSLException {
            nativeSsl.offerToResumeSession(this.ref.address);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public String getCipherSuite() {
            return this.cipherSuite;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public String getProtocol() {
            return this.protocol;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public String getPeerHost() {
            return this.host;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public int getPeerPort() {
            return this.port;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public byte[] getPeerOcspStapledResponse() {
            return this.peerOcspStapledResponse;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public byte[] getPeerSignedCertificateTimestamp() {
            return this.peerSignedCertificateTimestamp;
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public byte[] toBytes() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(SSLUtils.SessionType.OPEN_SSL_WITH_TLS_SCT.value);
                byte[] i2d_SSL_SESSION = NativeCrypto.i2d_SSL_SESSION(this.ref.address);
                dataOutputStream.writeInt(i2d_SSL_SESSION.length);
                dataOutputStream.write(i2d_SSL_SESSION);
                dataOutputStream.writeInt(this.peerCertificates.length);
                for (X509Certificate x509Certificate : this.peerCertificates) {
                    byte[] encoded = x509Certificate.getEncoded();
                    dataOutputStream.writeInt(encoded.length);
                    dataOutputStream.write(encoded);
                }
                if (this.peerOcspStapledResponse != null) {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeInt(this.peerOcspStapledResponse.length);
                    dataOutputStream.write(this.peerOcspStapledResponse);
                } else {
                    dataOutputStream.writeInt(0);
                }
                byte[] bArr = this.peerSignedCertificateTimestamp;
                if (bArr != null) {
                    dataOutputStream.writeInt(bArr.length);
                    dataOutputStream.write(this.peerSignedCertificateTimestamp);
                } else {
                    dataOutputStream.writeInt(0);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                NativeSslSession.logger.log(Level.WARNING, "Failed to convert saved SSL Session: ", (Throwable) e);
                return null;
            } catch (CertificateEncodingException e2) {
                NativeSslSession.log(e2);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeSslSession
        public SSLSession toSSLSession() {
            return new SSLSession() {
                /* class org.conscrypt.NativeSslSession.Impl.AnonymousClass1 */

                public byte[] getId() {
                    return Impl.this.getId();
                }

                public String getCipherSuite() {
                    return Impl.this.getCipherSuite();
                }

                public String getProtocol() {
                    return Impl.this.getProtocol();
                }

                public String getPeerHost() {
                    return Impl.this.getPeerHost();
                }

                public int getPeerPort() {
                    return Impl.this.getPeerPort();
                }

                public long getCreationTime() {
                    return Impl.this.getCreationTime();
                }

                public boolean isValid() {
                    return Impl.this.isValid();
                }

                public SSLSessionContext getSessionContext() {
                    throw new UnsupportedOperationException();
                }

                public long getLastAccessedTime() {
                    throw new UnsupportedOperationException();
                }

                public void invalidate() {
                    throw new UnsupportedOperationException();
                }

                public void putValue(String str, Object obj) {
                    throw new UnsupportedOperationException();
                }

                public Object getValue(String str) {
                    throw new UnsupportedOperationException();
                }

                public void removeValue(String str) {
                    throw new UnsupportedOperationException();
                }

                public String[] getValueNames() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
                    throw new UnsupportedOperationException();
                }

                public Certificate[] getLocalCertificates() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
                    throw new UnsupportedOperationException();
                }

                public Principal getLocalPrincipal() {
                    throw new UnsupportedOperationException();
                }

                public int getPacketBufferSize() {
                    throw new UnsupportedOperationException();
                }

                public int getApplicationBufferSize() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    /* access modifiers changed from: private */
    public static void log(Throwable th) {
        logger.log(Level.INFO, "Error inflating SSL session: {0}", th.getMessage() != null ? th.getMessage() : th.getClass().getName());
    }

    private static void checkRemaining(ByteBuffer byteBuffer, int i) throws IOException {
        if (i < 0) {
            throw new IOException("Length is negative: " + i);
        } else if (i > byteBuffer.remaining()) {
            throw new IOException("Length of blob is longer than available: " + i + " > " + byteBuffer.remaining());
        }
    }
}
