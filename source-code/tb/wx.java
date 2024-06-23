package tb;

import java.nio.charset.Charset;

/* compiled from: Taobao */
public class wx {
    private int a;
    private int[] b;
    private int[] c;
    private int[] d;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;

    private void a() {
        if (xd.d(this.e, this.f) == 1718843492) {
            int b2 = xd.b(this.e, this.f + 4);
            if (b2 <= 1) {
                int d2 = xd.d(this.e, this.f + 8);
                this.i = d2;
                if (this.f + d2 > this.e.length) {
                    throw new IllegalArgumentException("Invalid binary, offset: " + this.f + "+ fileLen: " + this.i + " > bytes.length: " + this.e.length);
                }
                return;
            }
            throw new IllegalArgumentException("Invalid binary, newer format not support: " + b2);
        }
        throw new IllegalArgumentException("Invalid binary, invalid magic number");
    }

    public byte[] b() {
        return this.e;
    }

    public ey c(int i2) {
        int i3 = this.b[i2];
        int d2 = xd.d(this.e, this.f + i3);
        if (d2 == 0) {
            return ey.N(new String(this.e, this.f + i3 + 8, xd.d(this.e, (this.f + i3) + 4) - 1, Charset.forName("UTF-8")));
        }
        throw new IllegalArgumentException("not support const type:" + d2);
    }

    public int d() {
        return this.g;
    }

    public int e(int i2) {
        return this.d[i2];
    }

    public int f(int i2) {
        return this.c[i2] + this.f;
    }

    public void g(byte[] bArr, int i2) {
        this.e = bArr;
        this.f = i2;
        a();
        int d2 = xd.d(bArr, i2 + 12);
        int i3 = 0;
        while (true) {
            if (i3 >= d2) {
                break;
            }
            int i4 = i2 + 16 + (i3 * 12);
            if (xd.d(bArr, i4) == 1) {
                this.a = xd.d(bArr, i4 + 4);
                break;
            }
            i3++;
        }
        if (this.a != 0) {
            int i5 = i2 + 16 + (d2 * 12);
            int d3 = xd.d(bArr, i5);
            this.h = d3;
            if (d3 != 0) {
                this.c = new int[d3];
                this.d = new int[d3];
                for (int i6 = 0; i6 < this.h; i6++) {
                    int i7 = i5 + 4;
                    int i8 = i6 * 8;
                    this.c[i6] = xd.d(bArr, i7 + i8);
                    this.d[i6] = xd.d(bArr, i7 + 4 + i8);
                }
                int d4 = xd.d(bArr, this.a + i2);
                this.g = d4;
                this.b = new int[d4];
                for (int i9 = 0; i9 < this.g; i9++) {
                    this.b[i9] = xd.d(bArr, this.a + i2 + 4 + (i9 * 4));
                }
                return;
            }
            throw new IllegalArgumentException("Empty binary, 0 expression");
        }
        throw new IllegalArgumentException("Invalid binary, no const section");
    }
}
