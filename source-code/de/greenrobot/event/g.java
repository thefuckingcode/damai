package de.greenrobot.event;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class g {
    final Object a;
    final e b;
    final int c;
    volatile boolean d = true;

    g(Object obj, e eVar, int i) {
        this.a = obj;
        this.b = eVar;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.a != gVar.a || !this.b.equals(gVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.d.hashCode();
    }
}
