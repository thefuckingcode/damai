package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import com.google.common.base.i;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.h;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class MoreExecutors {

    @GwtIncompatible
    /* compiled from: Taobao */
    private static final class ScheduledListeningDecorator extends d implements ListeningScheduledExecutorService {
        final ScheduledExecutorService b;

        /* access modifiers changed from: private */
        @GwtIncompatible
        /* compiled from: Taobao */
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.g<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.delegate = (Runnable) ds1.p(runnable);
            }

            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th) {
                    setException(th);
                    throw i.e(th);
                }
            }
        }

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static final class a<V> extends h.a<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> b;

            public a(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.b = scheduledFuture;
            }

            /* renamed from: c */
            public int compareTo(Delayed delayed) {
                return this.b.compareTo(delayed);
            }

            @Override // com.google.common.util.concurrent.g
            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.b.cancel(z);
                }
                return cancel;
            }

            public long getDelay(TimeUnit timeUnit) {
                return this.b.getDelay(timeUnit);
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.b = (ScheduledExecutorService) ds1.p(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService, com.google.common.util.concurrent.ListeningScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService, com.google.common.util.concurrent.ListeningScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService, com.google.common.util.concurrent.ListeningScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
            return new a(create, this.b.schedule(create, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService, com.google.common.util.concurrent.ListeningScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(callable);
            return new a(create, this.b.schedule(create, j, timeUnit));
        }
    }

    /* compiled from: Taobao */
    static class a implements Executor {
        final /* synthetic */ Executor a;
        final /* synthetic */ Supplier b;

        a(Executor executor, Supplier supplier) {
            this.a = executor;
            this.b = supplier;
        }

        public void execute(Runnable runnable) {
            this.a.execute(Callables.b(runnable, this.b));
        }
    }

    /* compiled from: Taobao */
    static class b extends s {
        final /* synthetic */ Supplier c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
            super(scheduledExecutorService);
            this.c = supplier;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.r
        public Runnable a(Runnable runnable) {
            return Callables.b(runnable, this.c);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.r
        public <T> Callable<T> b(Callable<T> callable) {
            return Callables.c(callable, this.c);
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    /* compiled from: Taobao */
    static class c {
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class d extends b {
        private final ExecutorService a;

        d(ExecutorService executorService) {
            this.a = (ExecutorService) ds1.p(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.a.awaitTermination(j, timeUnit);
        }

        public final void execute(Runnable runnable) {
            this.a.execute(runnable);
        }

        public final boolean isShutdown() {
            return this.a.isShutdown();
        }

        public final boolean isTerminated() {
            return this.a.isTerminated();
        }

        public final void shutdown() {
            this.a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.a.shutdownNow();
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    @GwtIncompatible
    private static boolean b() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @GwtIncompatible
    public static ListeningExecutorService c(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new d(executorService);
    }

    @GwtIncompatible
    static Thread d(String str, Runnable runnable) {
        ds1.p(str);
        ds1.p(runnable);
        Thread newThread = e().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @Beta
    @GwtIncompatible
    public static ThreadFactory e() {
        if (!b()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (InvocationTargetException e4) {
            throw i.e(e4.getCause());
        }
    }

    static Executor f(final Executor executor, final AbstractFuture<?> abstractFuture) {
        ds1.p(executor);
        ds1.p(abstractFuture);
        if (executor == a()) {
            return executor;
        }
        return new Executor() {
            /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass5 */
            boolean a = true;

            public void execute(final Runnable runnable) {
                try {
                    executor.execute(new Runnable() {
                        /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            AnonymousClass5.this.a = false;
                            runnable.run();
                        }
                    });
                } catch (RejectedExecutionException e) {
                    if (this.a) {
                        abstractFuture.setException(e);
                    }
                }
            }
        };
    }

    @GwtIncompatible
    static Executor g(Executor executor, Supplier<String> supplier) {
        ds1.p(executor);
        ds1.p(supplier);
        if (b()) {
            return executor;
        }
        return new a(executor, supplier);
    }

    @GwtIncompatible
    static ScheduledExecutorService h(ScheduledExecutorService scheduledExecutorService, Supplier<String> supplier) {
        ds1.p(scheduledExecutorService);
        ds1.p(supplier);
        if (b()) {
            return scheduledExecutorService;
        }
        return new b(scheduledExecutorService, supplier);
    }
}
