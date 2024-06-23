package com.uc.webview.export.internal.utility;

import android.util.Pair;
import cn.damai.h5container.H5MainActivity;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestException;
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
import tb.dq2;

/* compiled from: Taobao */
public final class a {

    /* renamed from: com.uc.webview.export.internal.utility.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0246a extends Exception {
        public C0246a(String str) {
            super(str);
        }

        public C0246a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends c {
        private byte[] a;

        public b(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.a = bArr;
        }

        @Override // com.uc.webview.export.internal.utility.a.c, java.security.cert.Certificate
        public final byte[] getEncoded() throws CertificateEncodingException {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    static class c extends X509Certificate {
        private final X509Certificate a;

        public c(X509Certificate x509Certificate) {
            this.a = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            this.a.checkValidity();
        }

        public int getBasicConstraints() {
            return this.a.getBasicConstraints();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            return this.a.getCriticalExtensionOIDs();
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.a.getEncoded();
        }

        public byte[] getExtensionValue(String str) {
            return this.a.getExtensionValue(str);
        }

        public Principal getIssuerDN() {
            return this.a.getIssuerDN();
        }

        public boolean[] getIssuerUniqueID() {
            return this.a.getIssuerUniqueID();
        }

        public boolean[] getKeyUsage() {
            return this.a.getKeyUsage();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            return this.a.getNonCriticalExtensionOIDs();
        }

        public Date getNotAfter() {
            return this.a.getNotAfter();
        }

        public Date getNotBefore() {
            return this.a.getNotBefore();
        }

        public PublicKey getPublicKey() {
            return this.a.getPublicKey();
        }

        public BigInteger getSerialNumber() {
            return this.a.getSerialNumber();
        }

        public String getSigAlgName() {
            return this.a.getSigAlgName();
        }

        public String getSigAlgOID() {
            return this.a.getSigAlgOID();
        }

        public byte[] getSigAlgParams() {
            return this.a.getSigAlgParams();
        }

        public byte[] getSignature() {
            return this.a.getSignature();
        }

        public Principal getSubjectDN() {
            return this.a.getSubjectDN();
        }

        public boolean[] getSubjectUniqueID() {
            return this.a.getSubjectUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return this.a.getTBSCertificate();
        }

        public int getVersion() {
            return this.a.getVersion();
        }

        public boolean hasUnsupportedCriticalExtension() {
            return this.a.hasUnsupportedCriticalExtension();
        }

        public String toString() {
            return this.a.toString();
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.a.verify(publicKey);
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            this.a.checkValidity(date);
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.a.verify(publicKey, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    public static boolean a(String str) throws IOException {
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                long length = randomAccessFile2.length();
                if (length > 2147483647L) {
                    randomAccessFile2.close();
                    return false;
                }
                try {
                    MappedByteBuffer map = randomAccessFile2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, length);
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    int a = (int) a(map, b(map));
                    e(a(map, c(map, a), a));
                    randomAccessFile2.close();
                    return true;
                } catch (IOException e) {
                    if (e.getCause() instanceof OutOfMemoryError) {
                        randomAccessFile2.close();
                        return false;
                    }
                    throw new IOException("Failed to memory-map APK", e);
                }
            } catch (C0246a unused) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (C0246a unused2) {
            if (randomAccessFile != null) {
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
    public static X509Certificate[][] b(String str) throws C0246a, SecurityException, IOException {
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                X509Certificate[][] a = a(randomAccessFile2);
                randomAccessFile2.close();
                return a;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    private static int c(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static byte[] d(ByteBuffer byteBuffer) throws IOException {
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

    private static ByteBuffer e(ByteBuffer byteBuffer) throws C0246a {
        f(byteBuffer);
        ByteBuffer a = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (a.hasRemaining()) {
            i++;
            if (a.remaining() >= 8) {
                long j = a.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new C0246a("APK Signing Block entry #" + i + " size out of range: " + j);
                }
                int i2 = (int) j;
                int position = a.position() + i2;
                if (i2 > a.remaining()) {
                    throw new C0246a("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a.remaining());
                } else if (a.getInt() == 1896449818) {
                    return b(a, i2 - 4);
                } else {
                    a.position(position);
                }
            } else {
                throw new C0246a("Insufficient data to read size of APK Signing Block entry #" + i);
            }
        }
        throw new C0246a("No APK Signature Scheme v2 block in APK Signing Block");
    }

    private static void f(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer c(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return b(byteBuffer, i);
            } else {
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
        } else {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
    }

    private static String b(int i) {
        if (i == 1) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (i == 2) {
            return MessageDigestAlgorithms.SHA_512;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
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

    private static int c(ByteBuffer byteBuffer, int i) throws C0246a {
        f(byteBuffer);
        if (i < 32) {
            throw new C0246a("APK too small for APK Signing Block. ZIP Central Directory offset: " + i);
        } else if (byteBuffer.getLong(i - 16) == 2334950737559900225L && byteBuffer.getLong(i - 8) == 3617552046287187010L) {
            long j = byteBuffer.getLong(i - 24);
            if (j < 24 || j > 2147483639) {
                throw new C0246a("APK Signing Block size out of range: " + j);
            }
            int i2 = (int) j;
            int i3 = i - (i2 + 8);
            if (i3 >= 0) {
                long j2 = byteBuffer.getLong(i3);
                if (j2 == ((long) i2)) {
                    return i3;
                }
                throw new C0246a("APK Signing Block sizes in header and footer do not match: " + j2 + " vs " + i2);
            }
            throw new C0246a("APK Signing Block offset out of range: " + i3);
        } else {
            throw new C0246a("No APK Signing Block before ZIP Central Directory");
        }
    }

    private static int b(ByteBuffer byteBuffer) throws C0246a {
        int i;
        x.a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity >= 22) {
            int i2 = capacity - 22;
            int min = Math.min(i2, 65535);
            int i3 = 0;
            while (true) {
                if (i3 >= min) {
                    break;
                }
                i = i2 - i3;
                if (byteBuffer.getInt(i) == 101010256 && (byteBuffer.getShort(i + 20) & dq2.MAX_VALUE) == i3) {
                    break;
                }
                i3++;
            }
        } else {
            System.out.println("File size smaller than EOCD min size");
        }
        i = -1;
        if (i != -1) {
            return i;
        }
        throw new C0246a("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static X509Certificate[][] a(RandomAccessFile randomAccessFile) throws C0246a, SecurityException, IOException {
        long length = randomAccessFile.length();
        if (length <= 2147483647L) {
            try {
                MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, length);
                map.load();
                return a(map);
            } catch (IOException e) {
                if (e.getCause() instanceof OutOfMemoryError) {
                    throw new C0246a("Failed to memory-map APK", e);
                }
                throw new IOException("Failed to memory-map APK", e);
            }
        } else {
            throw new IOException("File too large: " + randomAccessFile.length() + " bytes");
        }
    }

    public static X509Certificate[][] a(ByteBuffer byteBuffer) throws C0246a, SecurityException {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        int b2 = b(slice);
        int a = (int) a(slice, b2);
        int c2 = c(slice, a);
        return a(slice, e(a(slice, c2, a)), c2, a, b2);
    }

    private static X509Certificate[][] a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer c2 = c(byteBuffer2);
                int i4 = 0;
                while (c2.hasRemaining()) {
                    i4++;
                    try {
                        arrayList.add(a(c(c2), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i4 + " block", e);
                    }
                }
                if (i4 <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    a(hashMap, byteBuffer, i, i2, i3);
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

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0015 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d A[Catch:{ IOException | BufferUnderflowException -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e A[Catch:{ IOException | BufferUnderflowException -> 0x00b5 }] */
    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        byte[] bArr;
        Pair pair;
        boolean z;
        ByteBuffer c2 = c(byteBuffer);
        ByteBuffer c3 = c(byteBuffer);
        byte[] d = d(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i = -1;
        int i2 = 0;
        byte[] bArr2 = null;
        while (true) {
            char c4 = 1;
            if (c3.hasRemaining()) {
                i2++;
                try {
                    ByteBuffer c5 = c(c3);
                    if (c5.remaining() >= 8) {
                        int i3 = c5.getInt();
                        arrayList.add(Integer.valueOf(i3));
                        if (!(i3 == 513 || i3 == 514 || i3 == 769 || i3 == 770)) {
                            switch (i3) {
                                case 257:
                                case 258:
                                case H5MainActivity.REQUEST_CORP:
                                case H5MainActivity.REQUEST_REALNAME:
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                            if (!z) {
                                if (i != -1) {
                                    int a = a(i3);
                                    int a2 = a(i);
                                    if (a != 1) {
                                        if (a == 2) {
                                            if (a2 != 1) {
                                                if (a2 != 2) {
                                                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + a2);
                                                }
                                            }
                                            if (c4 <= 0) {
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Unknown digestAlgorithm1: " + a);
                                        }
                                    } else if (a2 != 1) {
                                        if (a2 == 2) {
                                            c4 = 65535;
                                            if (c4 <= 0) {
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Unknown digestAlgorithm2: " + a2);
                                        }
                                    }
                                    c4 = 0;
                                    if (c4 <= 0) {
                                    }
                                }
                                bArr2 = d(c5);
                                i = i3;
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    } else {
                        throw new SecurityException("Signature record too short");
                    }
                } catch (IOException | BufferUnderflowException e) {
                    throw new SecurityException("Failed to parse signature record #" + i2, e);
                }
            } else if (i != -1) {
                if (i != 513 && i != 514) {
                    if (i != 769 && i != 770) {
                        switch (i) {
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i & -1)));
                            case 257:
                            case 258:
                            case H5MainActivity.REQUEST_CORP:
                            case H5MainActivity.REQUEST_REALNAME:
                                str = "RSA";
                                break;
                        }
                    } else {
                        str = "DSA";
                    }
                } else {
                    str = "EC";
                }
                if (i == 513) {
                    bArr = null;
                    pair = Pair.create("SHA256withECDSA", null);
                } else if (i == 514) {
                    bArr = null;
                    pair = Pair.create("SHA512withECDSA", null);
                } else if (i == 769) {
                    bArr = null;
                    pair = Pair.create("SHA256withDSA", null);
                } else if (i != 770) {
                    switch (i) {
                        case 257:
                            pair = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                            bArr = null;
                            break;
                        case 258:
                            pair = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                            bArr = null;
                            break;
                        case H5MainActivity.REQUEST_CORP:
                            bArr = null;
                            pair = Pair.create("SHA256withRSA", null);
                            break;
                        case H5MainActivity.REQUEST_REALNAME:
                            bArr = null;
                            pair = Pair.create("SHA512withRSA", null);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString((long) (i & -1)));
                    }
                } else {
                    bArr = null;
                    pair = Pair.create("SHA512withDSA", null);
                }
                String str2 = (String) pair.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(d));
                    Signature instance = Signature.getInstance(str2);
                    instance.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        instance.setParameter(algorithmParameterSpec);
                    }
                    instance.update(c2);
                    if (instance.verify(bArr2)) {
                        c2.clear();
                        ByteBuffer c6 = c(c2);
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (c6.hasRemaining()) {
                            i4++;
                            try {
                                ByteBuffer c7 = c(c6);
                                if (c7.remaining() >= 8) {
                                    int i5 = c7.getInt();
                                    arrayList2.add(Integer.valueOf(i5));
                                    if (i5 == i) {
                                        bArr = d(c7);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #" + i4, e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int a3 = a(i);
                            byte[] put = map.put(Integer.valueOf(a3), bArr);
                            if (put == null || MessageDigest.isEqual(put, bArr)) {
                                ByteBuffer c8 = c(c2);
                                ArrayList arrayList3 = new ArrayList();
                                int i6 = 0;
                                while (c8.hasRemaining()) {
                                    i6++;
                                    byte[] d2 = d(c8);
                                    try {
                                        arrayList3.add(new b((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(d2)), d2));
                                    } catch (CertificateException e3) {
                                        throw new SecurityException("Failed to decode certificate #" + i6, e3);
                                    }
                                }
                                if (arrayList3.isEmpty()) {
                                    throw new SecurityException("No certificates listed");
                                } else if (Arrays.equals(d, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                                } else {
                                    throw new SecurityException("Public key mismatch between certificate and signature record");
                                }
                            } else {
                                throw new SecurityException(b(a3) + " contents digest does not match the digest specified by a preceding signer");
                            }
                        } else {
                            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                        }
                    } else {
                        throw new SecurityException(str2 + " signature did not verify");
                    }
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                    throw new SecurityException("Failed to verify " + str2 + " signature", e4);
                }
            } else if (i2 == 0) {
                throw new SecurityException("No signatures found");
            } else {
                throw new SecurityException("No supported signatures found");
            }
        }
    }

    private static void a(Map<Integer, byte[]> map, ByteBuffer byteBuffer, int i, int i2, int i3) throws SecurityException {
        if (!map.isEmpty()) {
            ByteBuffer a = a(byteBuffer, 0, i);
            ByteBuffer a2 = a(byteBuffer, i2, i3);
            byte[] bArr = new byte[(byteBuffer.capacity() - i3)];
            byteBuffer.position(i3);
            byteBuffer.get(bArr);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(byteBuffer.order());
            long j = (long) i;
            x.a(wrap);
            int position = wrap.position() + 16;
            if (j < 0 || j > 4294967295L) {
                throw new IllegalArgumentException("uint32 value of out range: " + j);
            }
            wrap.putInt(wrap.position() + position, (int) j);
            int[] iArr = new int[map.size()];
            int i4 = 0;
            for (Integer num : map.keySet()) {
                iArr[i4] = num.intValue();
                i4++;
            }
            try {
                Map<Integer, byte[]> a3 = a(iArr, new ByteBuffer[]{a, a2, wrap});
                for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    if (!MessageDigest.isEqual(entry.getValue(), a3.get(Integer.valueOf(intValue)))) {
                        throw new SecurityException(b(intValue) + " digest of contents did not verify");
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    private static Map<Integer, byte[]> a(int[] iArr, ByteBuffer[] byteBufferArr) throws DigestException {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            i3 += ((byteBufferArr[i2].remaining() + 1048576) - 1) / 1048576;
            i2++;
        }
        HashMap hashMap = new HashMap(i3);
        for (int i4 : iArr) {
            byte[] bArr = new byte[((c(i4) * i3) + 5)];
            bArr[0] = 90;
            a(i3, bArr);
            hashMap.put(Integer.valueOf(i4), bArr);
        }
        byte[] bArr2 = new byte[5];
        bArr2[0] = -91;
        int i5 = 0;
        int i6 = 0;
        for (i = 3; i5 < i; i = 3) {
            ByteBuffer byteBuffer = byteBufferArr[i5];
            while (byteBuffer.hasRemaining()) {
                ByteBuffer b2 = b(byteBuffer, Math.min(byteBuffer.remaining(), 1048576));
                for (int i7 : iArr) {
                    String b3 = b(i7);
                    try {
                        MessageDigest instance = MessageDigest.getInstance(b3);
                        b2.clear();
                        a(b2.remaining(), bArr2);
                        instance.update(bArr2);
                        instance.update(b2);
                        int c2 = c(i7);
                        int digest = instance.digest((byte[]) hashMap.get(Integer.valueOf(i7)), (i6 * c2) + 5, c2);
                        if (digest != c2) {
                            throw new RuntimeException("Unexpected output size of " + instance.getAlgorithm() + " digest: " + digest);
                        }
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(b3 + " digest not supported", e);
                    }
                }
                i6++;
            }
            i5++;
        }
        HashMap hashMap2 = new HashMap(iArr.length);
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            byte[] bArr3 = (byte[]) entry.getValue();
            String b4 = b(intValue);
            try {
                hashMap2.put(Integer.valueOf(intValue), MessageDigest.getInstance(b4).digest(bArr3));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(b4 + " digest not supported", e2);
            }
        }
        return hashMap2;
    }

    private static int a(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 770) {
            return 2;
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

    /* JADX INFO: finally extract failed */
    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
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

    private static void a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) ((i >>> 24) & 255);
    }

    private static long a(ByteBuffer byteBuffer, int i) throws C0246a {
        x.a(byteBuffer);
        int i2 = i - 20;
        if (!(i2 >= 0 && byteBuffer.getInt(i2) == 117853008)) {
            ByteBuffer a = a(byteBuffer, i, byteBuffer.capacity());
            x.a(a);
            long a2 = x.a(a, a.position() + 16);
            long j = (long) i;
            if (a2 < j) {
                x.a(a);
                if (x.a(a, a.position() + 12) + a2 == j) {
                    return a2;
                }
                throw new C0246a("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            throw new C0246a("ZIP Central Directory offset out of range: " + a2 + ". ZIP End of Central Directory offset: " + i);
        }
        throw new C0246a("ZIP64 APK not supported");
    }
}
