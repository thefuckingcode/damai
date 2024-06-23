package tb;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c82;

/* compiled from: Taobao */
public abstract class c82<S extends c82<S>> extends tl<S> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(c82.class, "cleanedAndPointers");
    private final long c;
    @NotNull
    private volatile /* synthetic */ int cleanedAndPointers;

    public c82(long j, @Nullable S s, int i) {
        super(s);
        this.c = j;
        this.cleanedAndPointers = i << 16;
    }

    @Override // tb.tl
    public boolean g() {
        return this.cleanedAndPointers == n() && !i();
    }

    public final boolean l() {
        return d.addAndGet(this, SupportMenu.CATEGORY_MASK) == n() && !i();
    }

    public final long m() {
        return this.c;
    }

    public abstract int n();

    public final void o() {
        if (d.incrementAndGet(this) == n() && !i()) {
            j();
        }
    }

    public final boolean p() {
        int i;
        do {
            i = this.cleanedAndPointers;
            if (!(i != n() || i())) {
                return false;
            }
        } while (!d.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
