package tb;

/* compiled from: Taobao */
public final class ge0 {
    public static final ge0 H = new ge0(3, 2, "H");
    public static final ge0 L = new ge0(0, 1, "L");
    public static final ge0 M = new ge0(1, 0, "M");
    public static final ge0 Q = new ge0(2, 3, "Q");
    private final int a;
    private final int b;
    private final String c;

    private ge0(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return this.c;
    }
}
