package com.meizu.cloud.pushsdk.c.g;

import androidx.annotation.NonNull;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.jl1;

/* compiled from: Taobao */
public final class b implements c, d, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    j a;
    long b;

    public int a(byte[] bArr, int i, int i2) {
        o.a((long) bArr.length, (long) i, (long) i2);
        j jVar = this.a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i2, jVar.c - jVar.b);
        System.arraycopy(jVar.a, jVar.b, bArr, i, min);
        int i3 = jVar.b + min;
        jVar.b = i3;
        this.b -= (long) min;
        if (i3 == jVar.c) {
            this.a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) throws IOException {
        if (mVar != null) {
            long j = 0;
            while (true) {
                long b2 = mVar.b(this, 2048);
                if (b2 == -1) {
                    return j;
                }
                j += b2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public b a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                } else if (i <= 1114111) {
                    b((i >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                    i2 = ((i >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                b(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            b(i3);
            i = (i & 63) | 128;
        }
        b(i);
        return this;
    }

    /* renamed from: a */
    public b b(e eVar) {
        if (eVar != null) {
            eVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public b b(String str) {
        return a(str, 0, str.length());
    }

    public b a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    j c2 = c(1);
                    byte[] bArr = c2.a;
                    int i4 = c2.c - i;
                    int min = Math.min(i2, 2048 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = c2.c;
                    int i7 = (i4 + i5) - i6;
                    c2.c = i6 + i7;
                    this.b += (long) i7;
                    i = i5;
                } else {
                    if (charAt < 2048) {
                        i3 = (charAt >> 6) | 192;
                    } else if (charAt < 55296 || charAt > 57343) {
                        b((charAt >> '\f') | 224);
                        i3 = ((charAt >> 6) & 63) | 128;
                    } else {
                        int i8 = i + 1;
                        char charAt3 = i8 < i2 ? str.charAt(i8) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            b(63);
                            i = i8;
                        } else {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            b((i9 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                            b(((i9 >> 12) & 63) | 128);
                            b(((i9 >> 6) & 63) | 128);
                            b((i9 & 63) | 128);
                            i += 2;
                        }
                    }
                    b(i3);
                    b((charAt & jl1.CONDITION_IF) | 128);
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        o.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            j jVar = this.a;
            int i = jVar.b;
            if (((long) i) + j > ((long) jVar.c)) {
                return new String(a(j), charset);
            }
            String str = new String(jVar.a, i, (int) j, charset);
            int i2 = (int) (((long) jVar.b) + j);
            jVar.b = i2;
            this.b -= j;
            if (i2 == jVar.c) {
                this.a = jVar.a();
                k.a(jVar);
            }
            return str;
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (bVar != this) {
            o.a(bVar.b, 0, j);
            while (j > 0) {
                j jVar = bVar.a;
                if (j < ((long) (jVar.c - jVar.b))) {
                    j jVar2 = this.a;
                    j jVar3 = jVar2 != null ? jVar2.g : null;
                    if (jVar3 != null && jVar3.e) {
                        if ((((long) jVar3.c) + j) - ((long) (jVar3.d ? 0 : jVar3.b)) <= 2048) {
                            jVar.a(jVar3, (int) j);
                            bVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    bVar.a = jVar.a((int) j);
                }
                j jVar4 = bVar.a;
                long j2 = (long) (jVar4.c - jVar4.b);
                bVar.a = jVar4.a();
                j jVar5 = this.a;
                if (jVar5 == null) {
                    this.a = jVar4;
                    jVar4.g = jVar4;
                    jVar4.f = jVar4;
                } else {
                    jVar5.g.a(jVar4).b();
                }
                bVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public byte[] a(long j) throws EOFException {
        o.a(this.b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            bVar.a(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this;
    }

    public b b(int i) {
        j c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* renamed from: b */
    public b c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public b c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            o.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                j c2 = c(1);
                int min = Math.min(i3 - i, 2048 - c2.c);
                System.arraycopy(bArr, i, c2.a, c2.c, min);
                i += min;
                c2.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        while (j > 0) {
            j jVar = this.a;
            if (jVar != null) {
                int min = (int) Math.min(j, (long) (jVar.c - jVar.b));
                long j2 = (long) min;
                this.b -= j2;
                j -= j2;
                j jVar2 = this.a;
                int i = jVar2.b + min;
                jVar2.b = i;
                if (i == jVar2.c) {
                    this.a = jVar2.a();
                    k.a(jVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: c */
    public b e(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return b(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        j c2 = c(i2);
        byte[] bArr = c2.a;
        int i3 = c2.c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        c2.c += i2;
        this.b += (long) i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public j c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.a;
        if (jVar == null) {
            j a2 = k.a();
            this.a = a2;
            a2.g = a2;
            a2.f = a2;
            return a2;
        }
        j jVar2 = jVar.g;
        return (jVar2.c + i > 2048 || !jVar2.e) ? jVar2.a(k.a()) : jVar2;
    }

    public boolean c() {
        return this.b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m, com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public b d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i = c2.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b += (long) numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public InputStream d() {
        return new InputStream() {
            /* class com.meizu.cloud.pushsdk.c.g.b.AnonymousClass1 */

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.b, 2147483647L);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.b > 0) {
                    return bVar.f() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(@NonNull byte[] bArr, int i, int i2) {
                return b.this.a(bArr, i, i2);
            }

            public String toString() {
                return b.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j = this.b;
        if (j == 0) {
            return 0;
        }
        j jVar = this.a.g;
        int i = jVar.c;
        return (i >= 2048 || !jVar.e) ? j : j - ((long) (i - jVar.b));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        long j = this.b;
        if (j != bVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        j jVar = this.a;
        j jVar2 = bVar.a;
        int i = jVar.b;
        int i2 = jVar2.b;
        while (j2 < this.b) {
            long min = (long) Math.min(jVar.c - i, jVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (jVar.a[i] != jVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == jVar.c) {
                jVar = jVar.f;
                i = jVar.b;
            }
            if (i2 == jVar2.c) {
                jVar2 = jVar2.f;
                i2 = jVar2.b;
            }
            j2 += min;
        }
        return true;
    }

    public byte f() {
        long j = this.b;
        if (j != 0) {
            j jVar = this.a;
            int i = jVar.b;
            int i2 = jVar.c;
            int i3 = i + 1;
            byte b2 = jVar.a[i];
            this.b = j - 1;
            if (i3 == i2) {
                this.a = jVar.a();
                k.a(jVar);
            } else {
                jVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() {
    }

    public e g() {
        return new e(i());
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public String h() {
        try {
            return a(this.b, o.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        j jVar = this.a;
        if (jVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jVar.c;
            for (int i3 = jVar.b; i3 < i2; i3++) {
                i = (i * 31) + jVar.a[i3];
            }
            jVar = jVar.f;
        } while (jVar != this.a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        j jVar = new j(this.a);
        bVar.a = jVar;
        jVar.g = jVar;
        jVar.f = jVar;
        j jVar2 = this.a;
        while (true) {
            jVar2 = jVar2.f;
            if (jVar2 != this.a) {
                bVar.a.g.a(new j(jVar2));
            } else {
                bVar.b = this.b;
                return bVar;
            }
        }
    }

    public String toString() {
        long j = this.b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().g().c());
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            j jVar = this.a;
            byte[] bArr = jVar.a;
            int i = jVar.b;
            instance.update(bArr, i, jVar.c - i);
            j jVar2 = this.a;
            while (true) {
                jVar2 = jVar2.f;
                if (jVar2 != this.a) {
                    byte[] bArr2 = jVar2.a;
                    int i2 = jVar2.b;
                    instance.update(bArr2, i2, jVar2.c - i2);
                } else {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), e.a(instance.digest()).c());
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
