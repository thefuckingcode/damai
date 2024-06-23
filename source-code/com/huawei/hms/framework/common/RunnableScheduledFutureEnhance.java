package com.huawei.hms.framework.common;

import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
public class RunnableScheduledFutureEnhance<T> implements RunnableScheduledFuture<T> {
    private String parentName = Thread.currentThread().getName();
    private RunnableScheduledFuture<T> proxy;

    public RunnableScheduledFutureEnhance(RunnableScheduledFuture<T> runnableScheduledFuture) {
        this.proxy = runnableScheduledFuture;
    }

    public boolean cancel(boolean z) {
        return this.proxy.cancel(z);
    }

    public boolean equals(Object obj) {
        return this.proxy.equals(obj);
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return (T) this.proxy.get();
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.proxy.getDelay(timeUnit);
    }

    public String getParentName() {
        return this.parentName;
    }

    public int hashCode() {
        return this.proxy.hashCode();
    }

    public boolean isCancelled() {
        return this.proxy.isCancelled();
    }

    public boolean isDone() {
        return this.proxy.isDone();
    }

    public boolean isPeriodic() {
        return this.proxy.isPeriodic();
    }

    public void run() {
        this.proxy.run();
    }

    public int compareTo(Delayed delayed) {
        return this.proxy.compareTo(delayed);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.proxy.get(j, timeUnit);
    }
}
