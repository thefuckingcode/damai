package com.alibaba.android.onescheduler.threadpool;

import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.utils.OneSchedulerException;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tb.ms1;
import tb.pf0;
import tb.ve0;

/* compiled from: Taobao */
public class a implements ListeningExecutorService {
    private ListeningExecutorService a;
    private ListeningExecutorService b;
    private int c;
    private PriorityBlockingQueue d;
    private TaskType e;
    private int f;

    public a(pf0 pf0, TaskType taskType) {
        this.e = taskType;
        this.f = pf0.c();
        ThreadFactory e2 = pf0.e() != null ? pf0.e() : Executors.defaultThreadFactory();
        this.d = new PriorityBlockingQueue(11, new ms1());
        this.c = pf0.d() > 0 ? pf0.d() : Integer.MAX_VALUE;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(pf0.a(), this.f, pf0.b(), TimeUnit.MILLISECONDS, this.d, e2);
        threadPoolExecutor.allowCoreThreadTimeOut(pf0.f());
        this.a = MoreExecutors.c(threadPoolExecutor);
        this.b = a(e2);
    }

    private ListeningExecutorService a(ThreadFactory threadFactory) {
        return MoreExecutors.c(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory));
    }

    private boolean b() {
        return this.d.size() >= this.c;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        if (runnable == null || !(runnable instanceof PriorityFutureTask)) {
            throw new OneSchedulerException("Runnable is not valid");
        }
        this.a.execute(runnable);
        if (b()) {
            ve0.a().g(this.e, this.f);
            Runnable runnable2 = (Runnable) this.d.poll();
            if (runnable2 != null) {
                this.b.execute(runnable2);
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throw new OneSchedulerException("This api is not implemented");
    }

    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    public void shutdown() {
        this.a.shutdown();
        this.b.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        this.b.shutdown();
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public ListenableFuture<?> submit(Runnable runnable) {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> ListenableFuture<T> submit(Runnable runnable, T t) {
        throw new OneSchedulerException("This api is not implemented");
    }
}
