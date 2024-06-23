package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import tb.jl1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public abstract class AbstractScheduledService implements Service {
    private static final Logger b = Logger.getLogger(AbstractScheduledService.class.getName());
    private final c a = new ServiceDelegate(this, null);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends Service.b {
        final /* synthetic */ ScheduledExecutorService a;

        a(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.b
        public void a(Service.State state, Throwable th) {
            this.a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.b
        public void e(Service.State state) {
            this.a.shutdown();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements ThreadFactory {
        b() {
        }

        public Thread newThread(Runnable runnable) {
            return MoreExecutors.d(AbstractScheduledService.this.f(), runnable);
        }
    }

    /* compiled from: Taobao */
    public static abstract class c {
    }

    protected AbstractScheduledService() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.b bVar, Executor executor) {
        this.a.addListener(bVar, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.awaitTerminated();
    }

    /* access modifiers changed from: protected */
    public ScheduledExecutorService c() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        addListener(new a(this, newSingleThreadScheduledExecutor), MoreExecutors.a());
        return newSingleThreadScheduledExecutor;
    }

    /* access modifiers changed from: protected */
    public abstract void d() throws Exception;

    /* access modifiers changed from: protected */
    public abstract c e();

    /* access modifiers changed from: protected */
    public String f() {
        return AbstractScheduledService.class.getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.a.failureCause();
    }

    /* access modifiers changed from: protected */
    public void g() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void h() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.a.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.a.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.a.stopAsync();
        return this;
    }

    public String toString() {
        return f() + " [" + state() + jl1.ARRAY_END_STR;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitTerminated(j, timeUnit);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class ServiceDelegate extends c {
        @MonotonicNonNullDecl
        private volatile Future<?> p;
        @MonotonicNonNullDecl
        private volatile ScheduledExecutorService q;
        private final ReentrantLock r;
        private final Runnable s;

        /* compiled from: Taobao */
        class Task implements Runnable {
            Task() {
            }

            public void run() {
                ServiceDelegate.this.r.lock();
                try {
                    if (ServiceDelegate.this.p.isCancelled()) {
                        ServiceDelegate.this.r.unlock();
                        return;
                    }
                    AbstractScheduledService.this.d();
                    ServiceDelegate.this.r.unlock();
                } catch (Throwable th) {
                    ServiceDelegate.this.r.unlock();
                    throw th;
                }
            }
        }

        /* compiled from: Taobao */
        class a implements Supplier<String> {
            a() {
            }

            /* renamed from: a */
            public String get() {
                return AbstractScheduledService.this.f() + " " + ServiceDelegate.this.state();
            }
        }

        private ServiceDelegate() {
            this.r = new ReentrantLock();
            this.s = new Task();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.c
        public final void e() {
            this.q = MoreExecutors.h(AbstractScheduledService.this.c(), new a());
            this.q.execute(new Runnable() {
                /* class com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.AnonymousClass2 */

                public void run() {
                    ServiceDelegate.this.r.lock();
                    try {
                        AbstractScheduledService.this.h();
                        AbstractScheduledService.this.e();
                        c unused = AbstractScheduledService.this.a;
                        ScheduledExecutorService unused2 = ServiceDelegate.this.q;
                        Runnable unused3 = ServiceDelegate.this.s;
                        throw null;
                    } catch (Throwable th) {
                        ServiceDelegate.this.r.unlock();
                        throw th;
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.c
        public final void f() {
            this.p.cancel(false);
            this.q.execute(new Runnable() {
                /* class com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.AnonymousClass3 */

                public void run() {
                    try {
                        ServiceDelegate.this.r.lock();
                        try {
                            if (ServiceDelegate.this.state() == Service.State.STOPPING) {
                                AbstractScheduledService.this.g();
                                ServiceDelegate.this.r.unlock();
                                ServiceDelegate.this.n();
                            }
                        } finally {
                            ServiceDelegate.this.r.unlock();
                        }
                    } catch (Throwable th) {
                        ServiceDelegate.this.l(th);
                    }
                }
            });
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }

        /* synthetic */ ServiceDelegate(AbstractScheduledService abstractScheduledService, a aVar) {
            this();
        }
    }
}
