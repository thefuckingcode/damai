package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tb.jl1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger b = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service a = new c() {
        /* class com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1 */

        /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1$a */
        /* compiled from: Taobao */
        class a implements Supplier<String> {
            a() {
            }

            /* renamed from: a */
            public String get() {
                return AbstractExecutionThreadService.this.d();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.c
        public final void e() {
            MoreExecutors.g(AbstractExecutionThreadService.this.b(), new a()).execute(new Runnable() {
                /* class com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.AnonymousClass2 */

                public void run() {
                    try {
                        AbstractExecutionThreadService.this.f();
                        AnonymousClass1.this.m();
                        if (AnonymousClass1.this.isRunning()) {
                            try {
                                AbstractExecutionThreadService.this.c();
                            } catch (Throwable th) {
                                try {
                                    AbstractExecutionThreadService.this.e();
                                } catch (Exception e) {
                                    AbstractExecutionThreadService.b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                                }
                                AnonymousClass1.this.l(th);
                                return;
                            }
                        }
                        AbstractExecutionThreadService.this.e();
                        AnonymousClass1.this.n();
                    } catch (Throwable th2) {
                        AnonymousClass1.this.l(th2);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.c
        public void f() {
            AbstractExecutionThreadService.this.g();
        }

        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Executor {
        a() {
        }

        public void execute(Runnable runnable) {
            MoreExecutors.d(AbstractExecutionThreadService.this.d(), runnable).start();
        }
    }

    protected AbstractExecutionThreadService() {
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
    public Executor b() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public abstract void c() throws Exception;

    /* access modifiers changed from: protected */
    public String d() {
        return AbstractExecutionThreadService.class.getSimpleName();
    }

    /* access modifiers changed from: protected */
    public void e() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void f() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.a.failureCause();
    }

    /* access modifiers changed from: protected */
    public void g() {
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
        return d() + " [" + state() + jl1.ARRAY_END_STR;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitTerminated(j, timeUnit);
    }
}
