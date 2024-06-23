package tb;

/* compiled from: Taobao */
public class gw1 {
    private boolean a = false;
    private boolean b = true;
    protected long c;

    /* access modifiers changed from: protected */
    public final boolean a() {
        if (!this.b) {
            return false;
        }
        if (System.currentTimeMillis() - this.c <= ((long) (c() * 1000))) {
            return true;
        }
        this.b = false;
        return false;
    }

    public boolean b(double d) {
        return d < 40.0d;
    }

    public int c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final void e(boolean z) {
        this.a = z;
    }
}
