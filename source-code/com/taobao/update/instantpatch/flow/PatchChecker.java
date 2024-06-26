package com.taobao.update.instantpatch.flow;

import android.os.Build;
import android.util.Pair;
import cn.damai.h5container.H5MainActivity;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.common.IPatchVerifier;
import com.taobao.update.datasource.logger.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.p03;
import tb.y91;

/* compiled from: Taobao */
public class PatchChecker implements IPatchVerifier {
    private Log a = y91.getLog(PatchChecker.class, (Log) null);

    /* compiled from: Taobao */
    public static class ApkSignatureSchemeV2Verifier {
        public static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 2;
        public static final String SF_ATTRIBUTE_ANDROID_APK_SIGNED_NAME = "X-Android-APK-Signed";

        /* compiled from: Taobao */
        private interface DataSource {
            void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException;

            long size();
        }

        /* compiled from: Taobao */
        public static class SignatureNotFoundException extends Exception {
            private static final long serialVersionUID = 1;

            public SignatureNotFoundException(String str) {
                super(str);
            }

            public SignatureNotFoundException(String str, Throwable th) {
                super(str, th);
            }
        }

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static class VerbatimX509Certificate extends WrappedX509Certificate {
            private byte[] encodedVerbatim;

            public VerbatimX509Certificate(X509Certificate x509Certificate, byte[] bArr) {
                super(x509Certificate);
                this.encodedVerbatim = bArr;
            }

            @Override // java.security.cert.Certificate, com.taobao.update.instantpatch.flow.PatchChecker.ApkSignatureSchemeV2Verifier.WrappedX509Certificate
            public byte[] getEncoded() throws CertificateEncodingException {
                return this.encodedVerbatim;
            }
        }

        /* compiled from: Taobao */
        private static class WrappedX509Certificate extends X509Certificate {
            private final X509Certificate wrapped;

            public WrappedX509Certificate(X509Certificate x509Certificate) {
                this.wrapped = x509Certificate;
            }

            @Override // java.security.cert.X509Certificate
            public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
                this.wrapped.checkValidity();
            }

            public int getBasicConstraints() {
                return this.wrapped.getBasicConstraints();
            }

            @Override // java.security.cert.X509Extension
            public Set<String> getCriticalExtensionOIDs() {
                return this.wrapped.getCriticalExtensionOIDs();
            }

            @Override // java.security.cert.Certificate
            public byte[] getEncoded() throws CertificateEncodingException {
                return this.wrapped.getEncoded();
            }

            public byte[] getExtensionValue(String str) {
                return this.wrapped.getExtensionValue(str);
            }

            public Principal getIssuerDN() {
                return this.wrapped.getIssuerDN();
            }

            public boolean[] getIssuerUniqueID() {
                return this.wrapped.getIssuerUniqueID();
            }

            public boolean[] getKeyUsage() {
                return this.wrapped.getKeyUsage();
            }

            @Override // java.security.cert.X509Extension
            public Set<String> getNonCriticalExtensionOIDs() {
                return this.wrapped.getNonCriticalExtensionOIDs();
            }

            public Date getNotAfter() {
                return this.wrapped.getNotAfter();
            }

            public Date getNotBefore() {
                return this.wrapped.getNotBefore();
            }

            public PublicKey getPublicKey() {
                return this.wrapped.getPublicKey();
            }

            public BigInteger getSerialNumber() {
                return this.wrapped.getSerialNumber();
            }

            public String getSigAlgName() {
                return this.wrapped.getSigAlgName();
            }

            public String getSigAlgOID() {
                return this.wrapped.getSigAlgOID();
            }

            public byte[] getSigAlgParams() {
                return this.wrapped.getSigAlgParams();
            }

            public byte[] getSignature() {
                return this.wrapped.getSignature();
            }

            public Principal getSubjectDN() {
                return this.wrapped.getSubjectDN();
            }

            public boolean[] getSubjectUniqueID() {
                return this.wrapped.getSubjectUniqueID();
            }

            @Override // java.security.cert.X509Certificate
            public byte[] getTBSCertificate() throws CertificateEncodingException {
                return this.wrapped.getTBSCertificate();
            }

            public int getVersion() {
                return this.wrapped.getVersion();
            }

            public boolean hasUnsupportedCriticalExtension() {
                return this.wrapped.hasUnsupportedCriticalExtension();
            }

            public String toString() {
                return this.wrapped.toString();
            }

            @Override // java.security.cert.Certificate
            public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
                this.wrapped.verify(publicKey);
            }

            @Override // java.security.cert.X509Certificate
            public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
                this.wrapped.checkValidity(date);
            }

            @Override // java.security.cert.Certificate
            public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
                this.wrapped.verify(publicKey, str);
            }
        }

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static class a {
            private final ByteBuffer a;

            private a(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
                this.a = byteBuffer;
            }
        }

        private static void a(ByteBuffer byteBuffer) {
            if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
        }

        private static int b(int i, int i2) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
                } else if (i2 == 1) {
                    return 1;
                } else {
                    if (i2 == 2) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            } else if (i2 == 1) {
                return 0;
            } else {
                if (i2 == 2) {
                    return -1;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
            }
        }

        private static int c(int i, int i2) {
            return b(l(i), l(i2));
        }

        private static ByteBuffer d(ByteBuffer byteBuffer) throws SignatureNotFoundException {
            a(byteBuffer);
            ByteBuffer q = q(byteBuffer, 8, byteBuffer.capacity() - 24);
            int i = 0;
            while (q.hasRemaining()) {
                i++;
                if (q.remaining() >= 8) {
                    long j = q.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                    int i2 = (int) j;
                    int position = q.position() + i2;
                    if (i2 > q.remaining()) {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + q.remaining());
                    } else if (q.getInt() == 1896449818) {
                        return g(q, i2 - 4);
                    } else {
                        q.position(position);
                    }
                } else {
                    throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
                }
            }
            throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
        }

        private static Pair<ByteBuffer, Long> e(RandomAccessFile randomAccessFile, long j) throws IOException, SignatureNotFoundException {
            if (j >= 32) {
                ByteBuffer allocate = ByteBuffer.allocate(24);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                allocate.order(byteOrder);
                randomAccessFile.seek(j - ((long) allocate.capacity()));
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                    long j2 = allocate.getLong(0);
                    if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                        throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
                    }
                    int i = (int) (8 + j2);
                    long j3 = j - ((long) i);
                    if (j3 >= 0) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(i);
                        allocate2.order(byteOrder);
                        randomAccessFile.seek(j3);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j4 = allocate2.getLong(0);
                        if (j4 == j2) {
                            return Pair.create(allocate2, Long.valueOf(j3));
                        }
                        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                    }
                    throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
                }
                throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
            }
            throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }

        private static a f(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
            Pair<ByteBuffer, Long> j = j(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) j.first;
            long longValue = ((Long) j.second).longValue();
            if (!p03.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long h = h(byteBuffer, longValue);
                Pair<ByteBuffer, Long> e = e(randomAccessFile, h);
                return new a(d((ByteBuffer) e.first), ((Long) e.second).longValue(), h, longValue, byteBuffer);
            }
            throw new SignatureNotFoundException("ZIP64 APK not supported");
        }

        private static ByteBuffer g(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
            if (i >= 0) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                int i2 = i + position;
                if (i2 < position || i2 > limit) {
                    throw new BufferUnderflowException();
                }
                byteBuffer.limit(i2);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            } else {
                throw new IllegalArgumentException("size: " + i);
            }
        }

        private static long h(ByteBuffer byteBuffer, long j) throws SignatureNotFoundException {
            long zipEocdCentralDirectoryOffset = p03.getZipEocdCentralDirectoryOffset(byteBuffer);
            if (zipEocdCentralDirectoryOffset > j) {
                throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j);
            } else if (p03.getZipEocdCentralDirectorySizeBytes(byteBuffer) + zipEocdCentralDirectoryOffset == j) {
                return zipEocdCentralDirectoryOffset;
            } else {
                throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
        }

        private static String i(int i) {
            if (i == 1) {
                return MessageDigestAlgorithms.SHA_256;
            }
            if (i == 2) {
                return MessageDigestAlgorithms.SHA_512;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }

        private static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
            Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord = p03.findZipEndOfCentralDirectoryRecord(randomAccessFile);
            if (findZipEndOfCentralDirectoryRecord != null) {
                return findZipEndOfCentralDirectoryRecord;
            }
            throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
        }

        private static ByteBuffer k(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.remaining() >= 4) {
                int i = byteBuffer.getInt();
                if (i < 0) {
                    throw new IllegalArgumentException("Negative length");
                } else if (i <= byteBuffer.remaining()) {
                    return g(byteBuffer, i);
                } else {
                    throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
                }
            } else {
                throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
            }
        }

        private static int l(int i) {
            if (i == 513) {
                return 1;
            }
            if (i == 514) {
                return 2;
            }
            if (i == 769) {
                return 1;
            }
            switch (i) {
                case 257:
                case H5MainActivity.REQUEST_CORP:
                    return 1;
                case 258:
                case H5MainActivity.REQUEST_REALNAME:
                    return 2;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i & -1)));
            }
        }

        private static String m(int i) {
            if (i == 513 || i == 514) {
                return "EC";
            }
            if (i == 769) {
                return "DSA";
            }
            switch (i) {
                case 257:
                case 258:
                case H5MainActivity.REQUEST_CORP:
                case H5MainActivity.REQUEST_REALNAME:
                    return "RSA";
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i & -1)));
            }
        }

        private static Pair<String, ? extends AlgorithmParameterSpec> n(int i) {
            if (i == 513) {
                return Pair.create("SHA256withECDSA", null);
            }
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i == 769) {
                return Pair.create("SHA256withDSA", null);
            }
            switch (i) {
                case 257:
                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                case 258:
                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                case H5MainActivity.REQUEST_CORP:
                    return Pair.create("SHA256withRSA", null);
                case H5MainActivity.REQUEST_REALNAME:
                    return Pair.create("SHA512withRSA", null);
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i & -1)));
            }
        }

        private static boolean o(int i) {
            if (i == 513 || i == 514 || i == 769) {
                return true;
            }
            switch (i) {
                case 257:
                case 258:
                case H5MainActivity.REQUEST_CORP:
                case H5MainActivity.REQUEST_REALNAME:
                    return true;
                default:
                    return false;
            }
        }

        private static byte[] p(ByteBuffer byteBuffer) throws IOException {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IOException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            } else {
                throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
            }
        }

        /* JADX INFO: finally extract failed */
        private static ByteBuffer q(ByteBuffer byteBuffer, int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("start: " + i);
            } else if (i2 >= i) {
                int capacity = byteBuffer.capacity();
                if (i2 <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i2);
                        byteBuffer.position(i);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                        return slice;
                    } catch (Throwable th) {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                        throw th;
                    }
                } else {
                    throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
                }
            } else {
                throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
            }
        }

        private static X509Certificate[][] r(FileDescriptor fileDescriptor, a aVar) throws SecurityException {
            HashMap hashMap = Build.VERSION.SDK_INT >= 19 ? new HashMap() : null;
            ArrayList arrayList = new ArrayList();
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                try {
                    ByteBuffer k = k(aVar.a);
                    int i = 0;
                    while (k.hasRemaining()) {
                        i++;
                        try {
                            arrayList.add(t(k(k), hashMap, instance));
                        } catch (IOException | SecurityException | BufferUnderflowException e) {
                            throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                        }
                    }
                    if (i < 1) {
                        throw new SecurityException("No signers found");
                    } else if (!hashMap.isEmpty()) {
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                    } else {
                        throw new SecurityException("No content digests found");
                    }
                } catch (IOException e2) {
                    throw new SecurityException("Failed to read list of signers", e2);
                }
            } catch (CertificateException e3) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
            }
        }

        private static X509Certificate[][] s(RandomAccessFile randomAccessFile) throws SignatureNotFoundException, SecurityException, IOException {
            return r(randomAccessFile.getFD(), f(randomAccessFile));
        }

        private static X509Certificate[] t(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
            ByteBuffer k = k(byteBuffer);
            ByteBuffer k2 = k(byteBuffer);
            byte[] p = p(byteBuffer);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = null;
            byte[] bArr2 = null;
            int i = -1;
            int i2 = 0;
            while (k2.hasRemaining()) {
                i2++;
                try {
                    ByteBuffer k3 = k(k2);
                    if (k3.remaining() >= 8) {
                        int i3 = k3.getInt();
                        arrayList.add(Integer.valueOf(i3));
                        if (o(i3)) {
                            if (i == -1 || c(i3, i) > 0) {
                                bArr2 = p(k3);
                                i = i3;
                            }
                        }
                    } else {
                        throw new SecurityException("Signature record too short");
                    }
                } catch (IOException | BufferUnderflowException e) {
                    throw new SecurityException("Failed to parse signature record #" + i2, e);
                }
            }
            if (i != -1) {
                String m = m(i);
                Pair<String, ? extends AlgorithmParameterSpec> n = n(i);
                String str = (String) n.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) n.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(m).generatePublic(new X509EncodedKeySpec(p));
                    Signature instance = Signature.getInstance(str);
                    instance.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        instance.setParameter(algorithmParameterSpec);
                    }
                    instance.update(k);
                    if (instance.verify(bArr2)) {
                        k.clear();
                        ByteBuffer k4 = k(k);
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (k4.hasRemaining()) {
                            i4++;
                            try {
                                ByteBuffer k5 = k(k4);
                                if (k5.remaining() >= 8) {
                                    int i5 = k5.getInt();
                                    arrayList2.add(Integer.valueOf(i5));
                                    if (i5 == i) {
                                        bArr = p(k5);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #" + i4, e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int l = l(i);
                            byte[] put = map.put(Integer.valueOf(l), bArr);
                            if (put == null || MessageDigest.isEqual(put, bArr)) {
                                ByteBuffer k6 = k(k);
                                ArrayList arrayList3 = new ArrayList();
                                int i6 = 0;
                                while (k6.hasRemaining()) {
                                    i6++;
                                    byte[] p2 = p(k6);
                                    try {
                                        arrayList3.add(new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(p2)), p2));
                                    } catch (CertificateException e3) {
                                        throw new SecurityException("Failed to decode certificate #" + i6, e3);
                                    }
                                }
                                if (arrayList3.isEmpty()) {
                                    throw new SecurityException("No certificates listed");
                                } else if (Arrays.equals(p, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                                } else {
                                    throw new SecurityException("Public key mismatch between certificate and signature record");
                                }
                            } else {
                                throw new SecurityException(i(l) + " contents digest does not match the digest specified by a preceding signer");
                            }
                        } else {
                            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                        }
                    } else {
                        throw new SecurityException(str + " signature did not verify");
                    }
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                    throw new SecurityException("Failed to verify " + str + " signature", e4);
                }
            } else if (i2 == 0) {
                throw new SecurityException("No signatures found");
            } else {
                throw new SecurityException("No supported signatures found");
            }
        }

        public static X509Certificate[][] verify(String str) throws SignatureNotFoundException, SecurityException, IOException {
            return s(new RandomAccessFile(str, UploadQueueMgr.MSGTYPE_REALTIME));
        }
    }

    @Override // com.android.alibaba.ip.common.IPatchVerifier
    public boolean authenticate(File file) {
        try {
            X509Certificate[][] verify = ApkSignatureSchemeV2Verifier.verify(file.getAbsolutePath());
            this.a.w("patch verify success");
            if (verify.length > 0) {
                return true;
            }
            return false;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
            this.a.w("patch verify failed");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            this.a.w("patch verify failed");
            return false;
        }
    }
}
