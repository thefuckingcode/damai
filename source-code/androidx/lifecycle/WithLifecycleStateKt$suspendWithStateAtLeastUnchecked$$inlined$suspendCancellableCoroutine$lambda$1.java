package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import tb.k12;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b¸\u0006\u0000"}, d2 = {"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "Ltb/ur2;", "onStateChanged", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 implements LifecycleEventObserver {
    final /* synthetic */ Function0 $block$inlined;
    final /* synthetic */ CancellableContinuation $co;
    final /* synthetic */ boolean $dispatchNeeded$inlined;
    final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    final /* synthetic */ Lifecycle.State $state$inlined;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, Lifecycle lifecycle, Lifecycle.State state, Function0 function0, boolean z, CoroutineDispatcher coroutineDispatcher) {
        this.$co = cancellableContinuation;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Object obj;
        k21.i(lifecycleOwner, "source");
        k21.i(event, "event");
        if (event == Lifecycle.Event.upTo(this.$state$inlined)) {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
            CancellableContinuation cancellableContinuation = this.$co;
            Function0 function0 = this.$block$inlined;
            try {
                Result.a aVar = Result.Companion;
                obj = Result.m913constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m913constructorimpl(k12.a(th));
            }
            cancellableContinuation.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
            CancellableContinuation cancellableContinuation2 = this.$co;
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            Result.a aVar3 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m913constructorimpl(k12.a(lifecycleDestroyedException)));
        }
    }
}
