package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import tb.tl;

public abstract class tl<N extends tl<N>> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(tl.class, Object.class, "_next");
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(tl.class, Object.class, "_prev");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    public tl(N n) {
        this._prev = n;
    }

    private final N c() {
        N f = f();
        while (f != null && f.g()) {
            f = (N) ((tl) f._prev);
        }
        return f;
    }

    private final Object e() {
        return this._next;
    }

    private final N h() {
        if (!n30.a() || (!i())) {
            N d = d();
            k21.f(d);
            while (d.g()) {
                d = (N) d.d();
                k21.f(d);
            }
            return d;
        }
        throw new AssertionError();
    }

    public final void b() {
        b.lazySet(this, null);
    }

    public final N d() {
        Object e = e();
        if (e == sl.a) {
            return null;
        }
        return (N) ((tl) e);
    }

    public final N f() {
        return (N) ((tl) this._prev);
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final void j() {
        if (n30.a() && !g()) {
            throw new AssertionError();
        } else if (!n30.a() || (!i())) {
            while (true) {
                N c = c();
                N h = h();
                h._prev = c;
                if (c != null) {
                    c._next = h;
                }
                if (!h.g() && (c == null || !c.g())) {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public final boolean k(N n) {
        return a.compareAndSet(this, null, n);
    }
}
