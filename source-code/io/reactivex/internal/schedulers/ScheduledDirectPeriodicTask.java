package io.reactivex.internal.schedulers;

/* compiled from: Taobao */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection, io.reactivex.internal.schedulers.AbstractDirectTask
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
        } catch (Throwable th) {
            this.runner = null;
            throw th;
        }
        this.runner = null;
    }
}
