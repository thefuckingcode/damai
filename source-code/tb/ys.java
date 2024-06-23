package tb;

import android.util.Log;

/* compiled from: Taobao */
public class ys {
    private byte[] a;
    private int b;
    private int c;

    public byte[] a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public byte d() {
        int i;
        byte[] bArr = this.a;
        if (bArr == null || (i = this.b) >= this.c) {
            Log.e("CodeReader_TMTEST", "readByte error mCode:" + this.a + "  mCurIndex:" + this.b + "  mCount:" + this.c);
            return -1;
        }
        this.b = i + 1;
        return bArr[i];
    }

    public double e() {
        return Double.longBitsToDouble(g());
    }

    public int f() {
        int i;
        byte[] bArr = this.a;
        if (bArr == null || (i = this.b) >= this.c - 3) {
            Log.e("CodeReader_TMTEST", "readInt error mCode:" + this.a + "  mCurIndex:" + this.b + "  mCount:" + this.c);
            return -1;
        }
        int i2 = i + 1;
        this.b = i2;
        int i3 = i2 + 1;
        this.b = i3;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        this.b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.b = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public long g() {
        int i;
        byte[] bArr = this.a;
        if (bArr == null || (i = this.b) >= this.c - 7) {
            Log.e("CodeReader_TMTEST", "readLong error mCode:" + this.a + "  mCurIndex:" + this.b + "  mCount:" + this.c);
            return -1;
        }
        int i2 = i + 1;
        this.b = i2;
        int i3 = i2 + 1;
        this.b = i3;
        int i4 = i3 + 1;
        this.b = i4;
        int i5 = i4 + 1;
        this.b = i5;
        int i6 = i5 + 1;
        this.b = i6;
        int i7 = i6 + 1;
        this.b = i7;
        int i8 = i7 + 1;
        this.b = i8;
        this.b = i8 + 1;
        return ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40) | ((((long) bArr[i4]) & 255) << 32) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 16) | ((((long) bArr[i7]) & 255) << 8) | (((long) bArr[i8]) & 255);
    }

    public short h() {
        int i;
        byte[] bArr = this.a;
        if (bArr == null || (i = this.b) >= this.c - 1) {
            Log.e("CodeReader_TMTEST", "readShort error mCode:" + this.a + "  mCurIndex:" + this.b + "  mCount:" + this.c);
            return -1;
        }
        int i2 = i + 1;
        this.b = i2;
        this.b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public boolean i(int i) {
        int i2 = this.c;
        if (i > i2) {
            this.b = i2;
            return false;
        } else if (i < 0) {
            this.b = 0;
            return false;
        } else {
            this.b = i;
            return true;
        }
    }

    public boolean j(int i) {
        return i(this.b + i);
    }

    public void k(byte[] bArr) {
        this.a = bArr;
        if (bArr != null) {
            this.c = bArr.length;
        } else {
            this.c = 0;
        }
        this.b = 0;
    }

    public void l(int i) {
    }
}
