package tb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class hl {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(hl.class, "_handled");
    @NotNull
    private volatile /* synthetic */ int _handled;
    @JvmField
    @NotNull
    public final Throwable a;

    public hl(@NotNull Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return q30.a(this) + jl1.ARRAY_START + this.a + jl1.ARRAY_END;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hl(Throwable th, boolean z, int i, m40 m40) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
