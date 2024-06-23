package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class uh extends h41 implements ChildHandle {
    @JvmField
    @NotNull
    public final ChildJob e;

    public uh(@NotNull ChildJob childJob) {
        this.e = childJob;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable th) {
        return v().childCancelled(th);
    }

    @Override // kotlinx.coroutines.ChildHandle
    @NotNull
    public Job getParent() {
        return v();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        u(th);
        return ur2.INSTANCE;
    }

    @Override // tb.jl
    public void u(@Nullable Throwable th) {
        this.e.parentCancelled(v());
    }
}
