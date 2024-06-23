package tb;

/* compiled from: Taobao */
public class gd2 {
    public static final gd2 FixedBehind;
    public static final gd2 FixedFront;
    public static final gd2 MatchLayout;
    @Deprecated
    public static final gd2 Scale;
    public static final gd2 Translate;
    public static final gd2[] values;
    public final int a;
    public final boolean b;
    public final boolean c;

    static {
        gd2 gd2 = new gd2(0, true, false);
        Translate = gd2;
        gd2 gd22 = new gd2(1, true, true);
        Scale = gd22;
        gd2 gd23 = new gd2(2, false, false);
        FixedBehind = gd23;
        gd2 gd24 = new gd2(3, true, false);
        FixedFront = gd24;
        gd2 gd25 = new gd2(4, true, false);
        MatchLayout = gd25;
        values = new gd2[]{gd2, gd22, gd23, gd24, gd25};
    }

    private gd2(int i, boolean z, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = z2;
    }
}
