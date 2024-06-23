package tb;

/* compiled from: Taobao */
public final class b43 extends a63 {
    private static int a(z53 z53) {
        return z53.n();
    }

    public static int b(z53 z53, byte b, int i) {
        z53.q(2);
        e(z53, i);
        d(z53, b);
        return a(z53);
    }

    public static int c(z53 z53, byte[] bArr) {
        z53.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            z53.d(bArr[length]);
        }
        return z53.a();
    }

    private static void d(z53 z53, byte b) {
        z53.f(0, b);
    }

    private static void e(z53 z53, int i) {
        z53.r(1, i);
    }
}
