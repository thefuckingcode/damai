package tb;

/* compiled from: Taobao */
public final class m33 extends a63 {
    private static int a(z53 z53) {
        return z53.n();
    }

    public static int b(z53 z53, int i, int i2, int i3) {
        z53.q(3);
        h(z53, i3);
        g(z53, i2);
        e(z53, i);
        return a(z53);
    }

    public static int c(z53 z53, byte[] bArr) {
        z53.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            z53.d(bArr[length]);
        }
        return z53.a();
    }

    public static int d(z53 z53, int[] iArr) {
        z53.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            z53.e(iArr[length]);
        }
        return z53.a();
    }

    private static void e(z53 z53, int i) {
        z53.r(0, i);
    }

    public static int f(z53 z53, byte[] bArr) {
        z53.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            z53.d(bArr[length]);
        }
        return z53.a();
    }

    private static void g(z53 z53, int i) {
        z53.r(1, i);
    }

    private static void h(z53 z53, int i) {
        z53.r(2, i);
    }
}
