package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.OpenSSLX509CertificateFactory;

final class OpenSSLX509CertPath extends CertPath {
    private static final List<String> ALL_ENCODINGS = Collections.unmodifiableList(Arrays.asList(Encoding.PKI_PATH.apiName, Encoding.PKCS7.apiName));
    private static final Encoding DEFAULT_ENCODING = Encoding.PKI_PATH;
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final int PUSHBACK_SIZE = 64;
    private static final long serialVersionUID = -3249106005255170761L;
    private final List<? extends X509Certificate> mCertificates;

    /* access modifiers changed from: private */
    public enum Encoding {
        PKI_PATH("PkiPath"),
        PKCS7("PKCS7");
        
        private final String apiName;

        private Encoding(String str) {
            this.apiName = str;
        }

        static Encoding findByApiName(String str) throws CertificateEncodingException {
            Encoding[] values = values();
            for (Encoding encoding : values) {
                if (encoding.apiName.equals(str)) {
                    return encoding;
                }
            }
            return null;
        }
    }

    static Iterator<String> getEncodingsIterator() {
        return ALL_ENCODINGS.iterator();
    }

    OpenSSLX509CertPath(List<? extends X509Certificate> list) {
        super("X.509");
        this.mCertificates = list;
    }

    @Override // java.security.cert.CertPath
    public List<? extends Certificate> getCertificates() {
        return Collections.unmodifiableList(this.mCertificates);
    }

    private byte[] getEncoded(Encoding encoding) throws CertificateEncodingException {
        int size = this.mCertificates.size();
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[size];
        long[] jArr = new long[size];
        int i = 0;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            X509Certificate x509Certificate = (X509Certificate) this.mCertificates.get(i);
            if (x509Certificate instanceof OpenSSLX509Certificate) {
                openSSLX509CertificateArr[i2] = (OpenSSLX509Certificate) x509Certificate;
            } else {
                openSSLX509CertificateArr[i2] = OpenSSLX509Certificate.fromX509Der(x509Certificate.getEncoded());
            }
            jArr[i2] = openSSLX509CertificateArr[i2].getContext();
            i++;
        }
        int i3 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()];
        if (i3 == 1) {
            return NativeCrypto.ASN1_seq_pack_X509(jArr);
        }
        if (i3 == 2) {
            return NativeCrypto.i2d_PKCS7(jArr);
        }
        throw new CertificateEncodingException("Unknown encoding");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.conscrypt.OpenSSLX509CertPath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[Encoding.values().length];
            $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding = iArr;
            iArr[Encoding.PKI_PATH.ordinal()] = 1;
            $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[Encoding.PKCS7.ordinal()] = 2;
        }
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() throws CertificateEncodingException {
        return getEncoded(DEFAULT_ENCODING);
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String str) throws CertificateEncodingException {
        Encoding findByApiName = Encoding.findByApiName(str);
        if (findByApiName != null) {
            return getEncoded(findByApiName);
        }
        throw new CertificateEncodingException("Invalid encoding: " + str);
    }

    @Override // java.security.cert.CertPath
    public Iterator<String> getEncodings() {
        return getEncodingsIterator();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|(2:24|25)|26|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005d */
    private static CertPath fromPkiPathEncoding(InputStream inputStream) throws CertificateException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        boolean markSupported = inputStream.markSupported();
        if (markSupported) {
            inputStream.mark(64);
        }
        try {
            long[] ASN1_seq_unpack_X509_bio = NativeCrypto.ASN1_seq_unpack_X509_bio(openSSLBIOInputStream.getBioContext());
            openSSLBIOInputStream.release();
            if (ASN1_seq_unpack_X509_bio == null) {
                return new OpenSSLX509CertPath(Collections.emptyList());
            }
            ArrayList arrayList = new ArrayList(ASN1_seq_unpack_X509_bio.length);
            for (int length = ASN1_seq_unpack_X509_bio.length - 1; length >= 0; length--) {
                if (ASN1_seq_unpack_X509_bio[length] != 0) {
                    try {
                        arrayList.add(new OpenSSLX509Certificate(ASN1_seq_unpack_X509_bio[length]));
                    } catch (OpenSSLX509CertificateFactory.ParsingException e) {
                        throw new CertificateParsingException(e);
                    }
                }
            }
            return new OpenSSLX509CertPath(arrayList);
        } catch (Exception e2) {
            if (markSupported) {
                inputStream.reset();
            }
            throw new CertificateException(e2);
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    private static CertPath fromPkcs7Encoding(InputStream inputStream) throws CertificateException {
        if (inputStream != null) {
            try {
                if (inputStream.available() != 0) {
                    boolean markSupported = inputStream.markSupported();
                    if (markSupported) {
                        inputStream.mark(64);
                    }
                    PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                    try {
                        byte[] bArr = PKCS7_MARKER;
                        byte[] bArr2 = new byte[bArr.length];
                        int read = pushbackInputStream.read(bArr2);
                        if (read >= 0) {
                            pushbackInputStream.unread(bArr2, 0, read);
                            if (read != bArr.length || !Arrays.equals(bArr, bArr2)) {
                                return new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7DerInputStream(pushbackInputStream));
                            }
                            return new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7PemInputStream(pushbackInputStream));
                        }
                        throw new OpenSSLX509CertificateFactory.ParsingException("inStream is empty");
                    } catch (Exception e) {
                        if (markSupported) {
                            try {
                                inputStream.reset();
                            } catch (IOException unused) {
                            }
                        }
                        throw new CertificateException(e);
                    }
                }
            } catch (IOException e2) {
                throw new CertificateException("Problem reading input stream", e2);
            }
        }
        return new OpenSSLX509CertPath(Collections.emptyList());
    }

    private static CertPath fromEncoding(InputStream inputStream, Encoding encoding) throws CertificateException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()];
        if (i == 1) {
            return fromPkiPathEncoding(inputStream);
        }
        if (i == 2) {
            return fromPkcs7Encoding(inputStream);
        }
        throw new CertificateEncodingException("Unknown encoding");
    }

    static CertPath fromEncoding(InputStream inputStream, String str) throws CertificateException {
        if (inputStream != null) {
            Encoding findByApiName = Encoding.findByApiName(str);
            if (findByApiName != null) {
                return fromEncoding(inputStream, findByApiName);
            }
            throw new CertificateException("Invalid encoding: " + str);
        }
        throw new CertificateException("inStream == null");
    }

    static CertPath fromEncoding(InputStream inputStream) throws CertificateException {
        if (inputStream != null) {
            return fromEncoding(inputStream, DEFAULT_ENCODING);
        }
        throw new CertificateException("inStream == null");
    }
}
