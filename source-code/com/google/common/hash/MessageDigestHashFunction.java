package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import tb.ds1;

@Immutable
/* compiled from: Taobao */
final class MessageDigestHashFunction extends b implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* compiled from: Taobao */
    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        private SerializedForm(String str, int i, String str2) {
            this.algorithmName = str;
            this.bytes = i;
            this.toString = str2;
        }
    }

    /* compiled from: Taobao */
    private static final class b extends a {
        private final MessageDigest b;
        private final int c;
        private boolean d;

        private void f() {
            ds1.x(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.a
        public void b(byte b2) {
            f();
            this.b.update(b2);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.a
        public void c(ByteBuffer byteBuffer) {
            f();
            this.b.update(byteBuffer);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.a
        public void e(byte[] bArr, int i, int i2) {
            f();
            this.b.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.d = true;
            if (this.c == this.b.getDigestLength()) {
                return HashCode.fromBytesNoCopy(this.b.digest());
            }
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.b.digest(), this.c));
        }

        private b(MessageDigest messageDigest, int i) {
            this.b = messageDigest;
            this.c = i;
        }
    }

    MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        this.toString = (String) ds1.p(str2);
        this.supportsClone = supportsClone(messageDigest);
    }

    private static MessageDigest getMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean supportsClone(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new b((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(getMessageDigest(this.prototype.getAlgorithm()), this.bytes);
    }

    public String toString() {
        return this.toString;
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    MessageDigestHashFunction(String str, int i, String str2) {
        this.toString = (String) ds1.p(str2);
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        ds1.g(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.bytes = i;
        this.supportsClone = supportsClone(messageDigest);
    }
}
