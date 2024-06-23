package org.conscrypt;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.UByte;

/* access modifiers changed from: package-private */
public final class SSLUtils {
    private static final String KEY_TYPE_EC = "EC";
    private static final String KEY_TYPE_RSA = "RSA";
    private static final int MAX_ENCRYPTION_OVERHEAD_DIFF = 2147483561;
    private static final int MAX_ENCRYPTION_OVERHEAD_LENGTH = 86;
    private static final int MAX_PROTOCOL_LENGTH = 255;
    static final boolean USE_ENGINE_SOCKET_BY_DEFAULT = Boolean.parseBoolean(System.getProperty("org.conscrypt.useEngineSocketByDefault", "false"));
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    static String getClientKeyType(byte b) {
        if (b == 1) {
            return KEY_TYPE_RSA;
        }
        if (b != 64) {
            return null;
        }
        return KEY_TYPE_EC;
    }

    private static short unsignedByte(byte b) {
        return (short) (b & UByte.MAX_VALUE);
    }

    private static int unsignedShort(short s) {
        return s & 65535;
    }

    /* access modifiers changed from: package-private */
    public enum SessionType {
        OPEN_SSL(1),
        OPEN_SSL_WITH_OCSP(2),
        OPEN_SSL_WITH_TLS_SCT(3);
        
        final int value;

        private SessionType(int i) {
            this.value = i;
        }

        static boolean isSupportedType(int i) {
            return i == OPEN_SSL.value || i == OPEN_SSL_WITH_OCSP.value || i == OPEN_SSL_WITH_TLS_SCT.value;
        }
    }

    static final class EngineStates {
        static final int STATE_CLOSED = 8;
        static final int STATE_CLOSED_INBOUND = 6;
        static final int STATE_CLOSED_OUTBOUND = 7;
        static final int STATE_HANDSHAKE_COMPLETED = 3;
        static final int STATE_HANDSHAKE_STARTED = 2;
        static final int STATE_MODE_SET = 1;
        static final int STATE_NEW = 0;
        static final int STATE_READY = 5;
        static final int STATE_READY_HANDSHAKE_CUT_THROUGH = 4;

        private EngineStates() {
        }
    }

    static X509Certificate[] decodeX509CertificateChain(byte[][] bArr) throws CertificateException {
        CertificateFactory certificateFactory = getCertificateFactory();
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i = 0; i < length; i++) {
            x509CertificateArr[i] = decodeX509Certificate(certificateFactory, bArr[i]);
        }
        return x509CertificateArr;
    }

    private static CertificateFactory getCertificateFactory() {
        try {
            return CertificateFactory.getInstance("X.509");
        } catch (CertificateException unused) {
            return null;
        }
    }

    private static X509Certificate decodeX509Certificate(CertificateFactory certificateFactory, byte[] bArr) throws CertificateException {
        if (certificateFactory != null) {
            return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
        }
        return OpenSSLX509Certificate.fromX509Der(bArr);
    }

    static String getServerX509KeyType(long j) throws SSLException {
        String SSL_CIPHER_get_kx_name = NativeCrypto.SSL_CIPHER_get_kx_name(j);
        if (SSL_CIPHER_get_kx_name.equals(KEY_TYPE_RSA) || SSL_CIPHER_get_kx_name.equals("DHE_RSA") || SSL_CIPHER_get_kx_name.equals("ECDHE_RSA")) {
            return KEY_TYPE_RSA;
        }
        if (SSL_CIPHER_get_kx_name.equals("ECDHE_ECDSA")) {
            return KEY_TYPE_EC;
        }
        return null;
    }

    static String getClientKeyTypeFromSignatureAlg(int i) {
        int SSL_get_signature_algorithm_key_type = NativeCrypto.SSL_get_signature_algorithm_key_type(i);
        if (SSL_get_signature_algorithm_key_type == 6) {
            return KEY_TYPE_RSA;
        }
        if (SSL_get_signature_algorithm_key_type != 408) {
            return null;
        }
        return KEY_TYPE_EC;
    }

    static Set<String> getSupportedClientKeyTypes(byte[] bArr, int[] iArr) {
        HashSet hashSet = new HashSet(bArr.length);
        for (byte b : bArr) {
            String clientKeyType = getClientKeyType(b);
            if (clientKeyType != null) {
                hashSet.add(clientKeyType);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(iArr.length);
        for (int i : iArr) {
            String clientKeyTypeFromSignatureAlg = getClientKeyTypeFromSignatureAlg(i);
            if (clientKeyTypeFromSignatureAlg != null) {
                linkedHashSet.add(clientKeyTypeFromSignatureAlg);
            }
        }
        if (bArr.length <= 0 || iArr.length <= 0) {
            return iArr.length > 0 ? linkedHashSet : hashSet;
        }
        linkedHashSet.retainAll(hashSet);
        return linkedHashSet;
    }

    static byte[][] encodeSubjectX509Principals(X509Certificate[] x509CertificateArr) throws CertificateEncodingException {
        byte[][] bArr = new byte[x509CertificateArr.length][];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            bArr[i] = x509CertificateArr[i].getSubjectX500Principal().getEncoded();
        }
        return bArr;
    }

    static javax.security.cert.X509Certificate[] toCertificateChain(X509Certificate[] x509CertificateArr) throws SSLPeerUnverifiedException {
        try {
            javax.security.cert.X509Certificate[] x509CertificateArr2 = new javax.security.cert.X509Certificate[x509CertificateArr.length];
            for (int i = 0; i < x509CertificateArr.length; i++) {
                x509CertificateArr2[i] = javax.security.cert.X509Certificate.getInstance(x509CertificateArr[i].getEncoded());
            }
            return x509CertificateArr2;
        } catch (CertificateEncodingException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(sSLPeerUnverifiedException);
            throw sSLPeerUnverifiedException;
        } catch (javax.security.cert.CertificateException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException2 = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException2.initCause(sSLPeerUnverifiedException2);
            throw sSLPeerUnverifiedException2;
        }
    }

    static int calculateOutNetBufSize(int i) {
        return Math.min(16709, Math.min((int) MAX_ENCRYPTION_OVERHEAD_DIFF, i) + 86);
    }

    static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        if (th instanceof SSLHandshakeException) {
            return (SSLHandshakeException) th;
        }
        return (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    static SSLException toSSLException(Throwable th) {
        if (th instanceof SSLException) {
            return (SSLException) th;
        }
        return new SSLException(th);
    }

    static String toProtocolString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, US_ASCII);
    }

    static byte[] toProtocolBytes(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes(US_ASCII);
    }

    static String[] decodeProtocols(byte[] bArr) {
        String str;
        if (bArr.length == 0) {
            return EmptyArray.STRING;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            byte b = bArr[i2];
            if (b < 0 || b > bArr.length - i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Protocol has invalid length (");
                sb.append((int) b);
                sb.append(" at position ");
                sb.append(i2);
                sb.append("): ");
                if (bArr.length < 50) {
                    str = Arrays.toString(bArr);
                } else {
                    str = bArr.length + " byte array";
                }
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            i3++;
            i2 += b + 1;
        }
        String[] strArr = new String[i3];
        int i4 = 0;
        while (i < bArr.length) {
            byte b2 = bArr[i];
            int i5 = i4 + 1;
            strArr[i4] = b2 > 0 ? new String(bArr, i + 1, b2, US_ASCII) : "";
            i += b2 + 1;
            i4 = i5;
        }
        return strArr;
    }

    static byte[] encodeProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("protocols array must be non-null");
        } else if (strArr.length == 0) {
            return EmptyArray.BYTE;
        } else {
            int i = 0;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2] != null) {
                    int length = strArr[i2].length();
                    if (length == 0 || length > 255) {
                        throw new IllegalArgumentException("protocol[" + i2 + "] has invalid length: " + length);
                    }
                    i += length + 1;
                } else {
                    throw new IllegalArgumentException("protocol[" + i2 + "] is null");
                }
            }
            byte[] bArr = new byte[i];
            int i3 = 0;
            for (String str : strArr) {
                int length2 = str.length();
                bArr[i3] = (byte) length2;
                i3++;
                int i4 = 0;
                while (i4 < length2) {
                    char charAt = str.charAt(i4);
                    if (charAt <= 127) {
                        bArr[i3] = (byte) charAt;
                        i4++;
                        i3++;
                    } else {
                        throw new IllegalArgumentException("Protocol contains invalid character: " + charAt + "(protocol=" + str + ")");
                    }
                }
            }
            return bArr;
        }
    }

    /* JADX INFO: finally extract failed */
    static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer = byteBufferArr[i];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer allocate = ByteBuffer.allocate(5);
        while (true) {
            int i2 = i + 1;
            ByteBuffer byteBuffer2 = byteBufferArr[i];
            int position = byteBuffer2.position();
            int limit = byteBuffer2.limit();
            if (byteBuffer2.remaining() > allocate.remaining()) {
                byteBuffer2.limit(allocate.remaining() + position);
            }
            try {
                allocate.put(byteBuffer2);
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
                if (!allocate.hasRemaining()) {
                    allocate.flip();
                    return getEncryptedPacketLength(allocate);
                }
                i = i2;
            } catch (Throwable th) {
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
                throw th;
            }
        }
    }

    private static int getEncryptedPacketLength(ByteBuffer byteBuffer) {
        int unsignedShort;
        int position = byteBuffer.position();
        switch (unsignedByte(byteBuffer.get(position))) {
            case 20:
            case 21:
            case 22:
            case 23:
                if (unsignedByte(byteBuffer.get(position + 1)) == 3 && (unsignedShort = unsignedShort(byteBuffer.getShort(position + 3)) + 5) > 5) {
                    return unsignedShort;
                }
                return -1;
            default:
                return -1;
        }
    }

    static String[] concat(String[]... strArr) {
        int i = 0;
        for (String[] strArr2 : strArr) {
            i += strArr2.length;
        }
        String[] strArr3 = new String[i];
        int i2 = 0;
        for (String[] strArr4 : strArr) {
            System.arraycopy(strArr4, 0, strArr3, i2, strArr4.length);
            i2 += strArr4.length;
        }
        return strArr3;
    }

    private SSLUtils() {
    }
}
