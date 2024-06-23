package tb;

/* compiled from: Taobao */
public abstract class g33 {
    g33 a;

    public g33() {
    }

    public g33(g33 g33) {
        this.a = g33;
    }

    public void a(int i) {
        g33 g33 = this.a;
        if (g33 != null) {
            g33.a(i);
        }
    }

    public void b(boolean z) {
        g33 g33 = this.a;
        if (g33 != null) {
            g33.b(z);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean c();

    public int d() {
        g33 g33 = this.a;
        return Math.min(Integer.MAX_VALUE, g33 != null ? g33.d() : Integer.MAX_VALUE);
    }

    public final boolean e() {
        g33 g33 = this.a;
        if (!(g33 != null ? g33.e() : true)) {
            return false;
        }
        return c();
    }
}
