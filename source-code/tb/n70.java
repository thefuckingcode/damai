package tb;

/* compiled from: Taobao */
public class n70 {
    public static final n70 CodeExact;
    public static final n70 CodeExactUnNotify;
    public static final n70 DeadLock;
    public static final n70 DeadLockUnNotify;
    public static final n70 Default;
    public static final n70 DefaultUnNotify;
    public static final n70 XmlExact;
    public static final n70 XmlExactUnNotify;
    public static final n70 XmlLayout;
    public static final n70 XmlLayoutUnNotify;
    public static final n70 XmlWrap;
    public static final n70 XmlWrapUnNotify;
    public static final n70[] values;
    public final int a;
    public final boolean b;

    static {
        n70 n70 = new n70(0, false);
        DefaultUnNotify = n70;
        n70 n702 = new n70(1, true);
        Default = n702;
        n70 n703 = new n70(2, false);
        XmlWrapUnNotify = n703;
        n70 n704 = new n70(3, true);
        XmlWrap = n704;
        n70 n705 = new n70(4, false);
        XmlExactUnNotify = n705;
        n70 n706 = new n70(5, true);
        XmlExact = n706;
        n70 n707 = new n70(6, false);
        XmlLayoutUnNotify = n707;
        n70 n708 = new n70(7, true);
        XmlLayout = n708;
        n70 n709 = new n70(8, false);
        CodeExactUnNotify = n709;
        n70 n7010 = new n70(9, true);
        CodeExact = n7010;
        n70 n7011 = new n70(10, false);
        DeadLockUnNotify = n7011;
        n70 n7012 = new n70(10, true);
        DeadLock = n7012;
        values = new n70[]{n70, n702, n703, n704, n705, n706, n707, n708, n709, n7010, n7011, n7012};
    }

    private n70(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public boolean a(n70 n70) {
        int i = this.a;
        int i2 = n70.a;
        return i < i2 || ((!this.b || CodeExact == this) && i == i2);
    }

    public n70 b() {
        return !this.b ? values[this.a + 1] : this;
    }

    public n70 c() {
        if (!this.b) {
            return this;
        }
        n70 n70 = values[this.a - 1];
        if (!n70.b) {
            return n70;
        }
        return DefaultUnNotify;
    }
}
