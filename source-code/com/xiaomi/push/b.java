package com.xiaomi.push;

import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.InputStream;
import java.util.Vector;
import tb.as2;
import tb.z7;

/* compiled from: Taobao */
public final class b {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f118a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f119a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private b(InputStream inputStream) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = ConfigReporter.BIT_GETTER_IMP;
        this.f119a = new byte[4096];
        this.a = 0;
        this.c = 0;
        this.f118a = inputStream;
    }

    private b(byte[] bArr, int i2, int i3) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = ConfigReporter.BIT_GETTER_IMP;
        this.f119a = bArr;
        this.a = i3 + i2;
        this.c = i2;
        this.f118a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.c;
        int i3 = this.a;
        if (i2 >= i3) {
            int i4 = this.e;
            if (i4 + i3 != this.f) {
                this.e = i4 + i3;
                this.c = 0;
                InputStream inputStream = this.f118a;
                int read = inputStream == null ? -1 : inputStream.read(this.f119a);
                this.a = read;
                if (read == 0 || read < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.a + "\nThe InputStream implementation is buggy.");
                } else if (read == -1) {
                    this.a = 0;
                    if (!z) {
                        return false;
                    }
                    throw d.a();
                } else {
                    b();
                    int i5 = this.e + this.a + this.b;
                    if (i5 <= this.i && i5 >= 0) {
                        return true;
                    }
                    throw d.h();
                }
            } else if (!z) {
                return false;
            } else {
                throw d.a();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    private void b() {
        int i2 = this.a + this.b;
        this.a = i2;
        int i3 = this.e + i2;
        int i4 = this.f;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.b = i5;
            this.a = i2 - i5;
            return;
        }
        this.b = 0;
    }

    public byte a() {
        if (this.c == this.a) {
            a(true);
        }
        byte[] bArr = this.f119a;
        int i2 = this.c;
        this.c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m260a() {
        if (m271b()) {
            this.d = 0;
            return 0;
        }
        int d2 = d();
        this.d = d2;
        if (d2 != 0) {
            return d2;
        }
        throw d.d();
    }

    public int a(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.e + this.c;
            int i4 = this.f;
            if (i3 <= i4) {
                this.f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m261a() {
        return m272c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m262a() {
        int d2 = d();
        int i2 = this.a;
        int i3 = this.c;
        if (d2 > i2 - i3 || d2 <= 0) {
            return a.a(m268a(d2));
        }
        a a2 = a.a(this.f119a, i3, d2);
        this.c += d2;
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m263a() {
        int d2 = d();
        int i2 = this.a;
        int i3 = this.c;
        if (d2 > i2 - i3 || d2 <= 0) {
            return new String(m268a(d2), "UTF-8");
        }
        String str = new String(this.f119a, i3, d2, "UTF-8");
        this.c += d2;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m264a() {
        int a2;
        do {
            a2 = m260a();
            if (a2 == 0) {
                return;
            }
        } while (m267a(a2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m265a(int i2) {
        if (this.d != i2) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.g < this.h) {
            int a2 = a(d2);
            this.g++;
            eVar.a(this);
            m265a(0);
            this.g--;
            b(a2);
            return;
        }
        throw d.g();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m266a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m267a(int i2) {
        int a2 = f.a(i2);
        if (a2 == 0) {
            m269b();
            return true;
        } else if (a2 == 1) {
            m273d();
            return true;
        } else if (a2 == 2) {
            c(d());
            return true;
        } else if (a2 == 3) {
            m264a();
            m265a(f.a(f.b(i2), 4));
            return true;
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                e();
                return true;
            }
            throw d.f();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m268a(int i2) {
        if (i2 >= 0) {
            int i3 = this.e;
            int i4 = this.c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f;
            if (i5 <= i6) {
                int i7 = this.a;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f119a, i4, bArr, 0, i2);
                    this.c += i2;
                    return bArr;
                } else if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.f119a, i4, bArr2, 0, i8);
                    this.c = this.a;
                    while (true) {
                        a(true);
                        int i9 = i2 - i8;
                        int i10 = this.a;
                        if (i9 > i10) {
                            System.arraycopy(this.f119a, 0, bArr2, i8, i10);
                            int i11 = this.a;
                            i8 += i11;
                            this.c = i11;
                        } else {
                            System.arraycopy(this.f119a, 0, bArr2, i8, i9);
                            this.c = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.e = i3 + i7;
                    this.c = 0;
                    this.a = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    Vector vector = new Vector();
                    while (i13 > 0) {
                        int min = Math.min(i13, 4096);
                        byte[] bArr3 = new byte[min];
                        int i14 = 0;
                        while (i14 < min) {
                            InputStream inputStream = this.f118a;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, min - i14);
                            if (read != -1) {
                                this.e += read;
                                i14 += read;
                            } else {
                                throw d.a();
                            }
                        }
                        i13 -= min;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.f119a, i4, bArr4, 0, i12);
                    for (int i15 = 0; i15 < vector.size(); i15++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i15);
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i6 - i3) - i4);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m269b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m270b() {
        return m272c();
    }

    public void b(int i2) {
        this.f = i2;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m271b() {
        return this.c == this.a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m272c() {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte a2 = a();
            j |= ((long) (a2 & z7.DEL)) << i2;
            if ((a2 & as2.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public void c(int i2) {
        if (i2 >= 0) {
            int i3 = this.e;
            int i4 = this.c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f;
            if (i5 <= i6) {
                int i7 = this.a;
                if (i2 <= i7 - i4) {
                    this.c = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.e = i3 + i7;
                this.c = 0;
                this.a = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.f118a;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i2 - i8));
                    if (skip > 0) {
                        i8 += skip;
                        this.e += skip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i6 - i3) - i4);
            throw d.a();
        }
        throw d.b();
    }

    public int d() {
        int i2;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i3 = a2 & z7.DEL;
        byte a3 = a();
        if (a3 >= 0) {
            i2 = a3 << 7;
        } else {
            i3 |= (a3 & z7.DEL) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i2 = a4 << 14;
            } else {
                i3 |= (a4 & z7.DEL) << 14;
                byte a5 = a();
                if (a5 >= 0) {
                    i2 = a5 << 21;
                } else {
                    int i4 = i3 | ((a5 & z7.DEL) << 21);
                    byte a6 = a();
                    int i5 = i4 | (a6 << 28);
                    if (a6 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (a() >= 0) {
                            return i5;
                        }
                    }
                    throw d.c();
                }
            }
        }
        return i3 | i2;
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m273d() {
        byte a2 = a();
        byte a3 = a();
        return ((((long) a3) & 255) << 8) | (((long) a2) & 255) | ((((long) a()) & 255) << 16) | ((((long) a()) & 255) << 24) | ((((long) a()) & 255) << 32) | ((((long) a()) & 255) << 40) | ((((long) a()) & 255) << 48) | ((((long) a()) & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
