package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import tb.f90;
import tb.k21;
import tb.k41;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001c\u0010\u000b\u001a\u00020\n8\u0010@\u0010X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Ltb/ur2;", "register", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    @NotNull
    private final CoroutineContext coroutineContext;
    @NotNull
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(@NotNull Lifecycle lifecycle2, @NotNull CoroutineContext coroutineContext2) {
        k21.i(lifecycle2, "lifecycle");
        k21.i(coroutineContext2, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = coroutineContext2;
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState() == Lifecycle.State.DESTROYED) {
            k41.d(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @NotNull
    public Lifecycle getLifecycle$lifecycle_runtime_ktx_release() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        k21.i(lifecycleOwner, "source");
        k21.i(event, "event");
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo((Enum) Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_runtime_ktx_release().removeObserver(this);
            k41.d(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        d.b(this, f90.c().a(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
