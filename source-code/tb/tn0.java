package tb;

/* compiled from: Taobao */
public final class tn0 {
    public static final tn0 DATA_MATRIX_FIELD = new tn0(301);
    public static final tn0 QR_CODE_FIELD = new tn0(285);
    private final int[] a = new int[256];
    private final int[] b = new int[256];
    private final un0 c;

    private tn0(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 256; i3++) {
            this.a[i3] = i2;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= i;
            }
        }
        for (int i4 = 0; i4 < 255; i4++) {
            this.b[this.a[i4]] = i4;
        }
        this.c = new un0(this, new int[]{0});
        new un0(this, new int[]{1});
    }

    static int a(int i, int i2) {
        return i ^ i2;
    }

    /* access modifiers changed from: package-private */
    public un0 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new un0(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i) {
        return this.a[i];
    }

    /* access modifiers changed from: package-private */
    public un0 d() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int e(int i) {
        if (i != 0) {
            return this.a[255 - this.b[i]];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int f(int i) {
        if (i != 0) {
            return this.b[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int g(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.b;
        int i3 = iArr[i] + iArr[i2];
        return this.a[(i3 & 255) + (i3 >>> 8)];
    }
}
