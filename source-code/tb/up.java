package tb;

/* compiled from: Taobao */
public class up {
    public static int f = 32768;
    public static int g = 10000;
    public static int h = 15000;
    public static boolean i = true;
    public int a = 3;
    public int b = 3;
    private u21 c;
    private int d;
    private int e;

    public up(lb2 lb2) {
        this.c = lb2.e;
        int i2 = lb2.f.l;
        if (i2 > 0) {
            this.a = i2;
            this.b = i2;
        }
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return g;
    }

    public int c() {
        long j = this.c.b;
        if (0 == j) {
            return h * 10;
        }
        int i2 = (int) (j / 10);
        int i3 = h;
        return i2 > i3 ? i2 : i3;
    }

    public boolean d() {
        return this.a - this.d == 1;
    }

    public boolean e() {
        return this.b - this.e == 1;
    }
}
