package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c82;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class d extends c82<d> {
    @NotNull
    /* synthetic */ AtomicReferenceArray e = new AtomicReferenceArray(SemaphoreKt.f());

    public d(long j, @Nullable d dVar, int i) {
        super(j, dVar, i);
    }

    @Override // tb.c82
    public int n() {
        return SemaphoreKt.f();
    }

    public final void q(int i) {
        this.e.set(i, SemaphoreKt.c());
        o();
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + m() + ", hashCode=" + hashCode() + jl1.ARRAY_END;
    }
}
