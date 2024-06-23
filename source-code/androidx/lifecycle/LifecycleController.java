package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.Job;
import tb.k21;

public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State state, DispatchQueue dispatchQueue2, Job job) {
        k21.i(lifecycle2, "lifecycle");
        k21.i(state, "minState");
        k21.i(dispatchQueue2, "dispatchQueue");
        k21.i(job, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        LifecycleController$observer$1 lifecycleController$observer$1 = new LifecycleController$observer$1(this, job);
        this.observer = lifecycleController$observer$1;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            Job.a.b(job, null, 1, null);
            finish();
            return;
        }
        lifecycle2.addObserver(lifecycleController$observer$1);
    }

    /* access modifiers changed from: public */
    private final void handleDestroy(Job job) {
        Job.a.b(job, null, 1, null);
        finish();
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
