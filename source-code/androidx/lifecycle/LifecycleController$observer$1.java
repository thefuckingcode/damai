package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "<anonymous parameter 1>", "Ltb/ur2;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class LifecycleController$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ Job $parentJob;
    final /* synthetic */ LifecycleController this$0;

    LifecycleController$observer$1(LifecycleController lifecycleController, Job job) {
        this.this$0 = lifecycleController;
        this.$parentJob = job;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        k21.i(lifecycleOwner, "source");
        k21.i(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        k21.h(lifecycle, "source.lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            LifecycleController lifecycleController = this.this$0;
            Job.a.b(this.$parentJob, null, 1, null);
            lifecycleController.finish();
            return;
        }
        Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
        k21.h(lifecycle2, "source.lifecycle");
        if (lifecycle2.getCurrentState().compareTo((Enum) LifecycleController.access$getMinState$p(this.this$0)) < 0) {
            LifecycleController.access$getDispatchQueue$p(this.this$0).pause();
        } else {
            LifecycleController.access$getDispatchQueue$p(this.this$0).resume();
        }
    }
}
