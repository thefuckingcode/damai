package com.alibaba.android.onescheduler.threadpool;

import com.alibaba.android.onescheduler.Priority;
import java.util.concurrent.Callable;
import tb.ve0;
import tb.zk1;

/* compiled from: Taobao */
public class PriorityFutureTask<V> extends ListenableFutureTask<V> {
    private Priority mGoupPriority;
    private Priority mPriority;
    private long mPrioritySequence;

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
    }

    public Priority getGoupPriority() {
        return this.mGoupPriority;
    }

    public Priority getPriority() {
        return this.mPriority;
    }

    public long getPrioritySequence() {
        return this.mPrioritySequence;
    }

    public void run() {
        ve0.a().c(this);
        super.run();
        ve0.a().d(this);
        if (zk1.a) {
            try {
                get();
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public void setGoupPriority(Priority priority) {
        this.mGoupPriority = priority;
    }

    public void setPriority(Priority priority) {
        this.mPriority = priority;
    }

    public void setPrioritySequence(long j) {
        this.mPrioritySequence = j;
    }

    public PriorityFutureTask(Runnable runnable, V v) {
        super(runnable, v);
    }
}
