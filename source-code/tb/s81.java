package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class s81<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(s81.class, Object.class, "_cur");
    @NotNull
    private volatile /* synthetic */ Object _cur;

    public s81(boolean z) {
        this._cur = new t81(8, z);
    }

    public final boolean a(@NotNull E e) {
        while (true) {
            t81 t81 = (t81) this._cur;
            int a2 = t81.a(e);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.compareAndSet(this, t81, t81.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            t81 t81 = (t81) this._cur;
            if (!t81.d()) {
                a.compareAndSet(this, t81, t81.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((t81) this._cur).f();
    }

    @Nullable
    public final E d() {
        while (true) {
            t81 t81 = (t81) this._cur;
            E e = (E) t81.j();
            if (e != t81.REMOVE_FROZEN) {
                return e;
            }
            a.compareAndSet(this, t81, t81.i());
        }
    }
}
