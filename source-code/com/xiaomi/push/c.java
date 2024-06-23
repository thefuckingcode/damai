package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
public final class c {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f148a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f149a;
    private int b;

    /* compiled from: Taobao */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f148a = outputStream;
        this.f149a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f148a = null;
        this.f149a = bArr;
        this.b = i;
        this.a = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    public static int a(e eVar) {
        int b2 = eVar.b();
        return d(b2) + b2;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int b(int i) {
        return d(i);
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int c(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() {
        OutputStream outputStream = this.f148a;
        if (outputStream != null) {
            outputStream.write(this.f149a, 0, this.b);
            this.b = 0;
            return;
        }
        throw new a();
    }

    public static int d(int i) {
        if ((i & com.alipay.sdk.m.n.a.g) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f148a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m303a() {
        if (this.f148a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f149a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m304a(int i) {
        if (i >= 0) {
            m323d(i);
        } else {
            m322c((long) i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m305a(int i, int i2) {
        c(i, 0);
        m304a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m306a(int i, long j) {
        c(i, 0);
        m311a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m307a(int i, a aVar) {
        c(i, 2);
        m312a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m308a(int i, e eVar) {
        c(i, 2);
        m313a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m309a(int i, String str) {
        c(i, 2);
        m314a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m310a(int i, boolean z) {
        c(i, 0);
        m315a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m311a(long j) {
        m322c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m312a(a aVar) {
        byte[] a2 = aVar.m247a();
        m323d(a2.length);
        a(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m313a(e eVar) {
        m323d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m314a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m323d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m315a(boolean z) {
        m321c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m316a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m316a(byte[] bArr, int i, int i2) {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f149a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f149a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 <= this.a) {
            System.arraycopy(bArr, i6, this.f149a, 0, i7);
            this.b = i7;
            return;
        }
        this.f148a.write(bArr, i6, i7);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m317b(int i) {
        m323d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m318b(int i, int i2) {
        c(i, 0);
        m317b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m319b(int i, long j) {
        c(i, 0);
        m320b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m320b(long j) {
        m322c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m321c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m323d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m322c(long j) {
        while ((-128 & j) != 0) {
            m321c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m321c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m323d(int i) {
        while ((i & com.alipay.sdk.m.n.a.g) != 0) {
            m321c((i & 127) | 128);
            i >>>= 7;
        }
        m321c(i);
    }
}
