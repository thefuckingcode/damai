package tb;

/* compiled from: Taobao */
public final class i43 extends a63 {
    private static int a(z53 z53) {
        return z53.n();
    }

    public static int b(z53 z53, int i) {
        z53.q(1);
        d(z53, i);
        return a(z53);
    }

    public static int c(z53 z53, int[] iArr) {
        z53.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            z53.e(iArr[length]);
        }
        return z53.a();
    }

    private static void d(z53 z53, int i) {
        z53.r(0, i);
    }
}
