package com.taobao.rxm.consume;

import android.util.Log;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import tb.c02;
import tb.cs1;
import tb.d42;
import tb.e42;
import tb.j22;
import tb.jl1;
import tb.kg0;

/* compiled from: Taobao */
public abstract class BaseConsumer<OUT, CONTEXT extends c02> implements Consumer<OUT, CONTEXT> {
    final CONTEXT a;
    boolean b;
    private Scheduler c;
    private final e42 d = new e42();

    public BaseConsumer(CONTEXT context) {
        cs1.c(context);
        this.a = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(d42<OUT> d42) {
        try {
            if (8 != d42.a) {
                if (!this.a.j()) {
                    int i = d42.a;
                    if (i == 1) {
                        g(d42.c, d42.b);
                        return;
                    } else if (i == 4) {
                        h(d42.d);
                        return;
                    } else if (i == 16) {
                        f(d42.e);
                        return;
                    } else {
                        return;
                    }
                }
            }
            e();
        } catch (Exception e) {
            i(e);
        }
    }

    private void j(d42<OUT> d42) {
        if (d()) {
            ScheduledAction a2 = this.d.offer();
            if (a2 == null) {
                a2 = new ScheduledAction(getContext().h(), this, d42) {
                    /* class com.taobao.rxm.consume.BaseConsumer.AnonymousClass1 */

                    @Override // com.taobao.rxm.schedule.ScheduledAction
                    public void run(Consumer consumer, d42 d42) {
                        BaseConsumer.this.b(d42);
                    }
                };
                a2.setScheduledActionPool(this.d);
            } else {
                a2.reset(getContext().h(), this, d42);
            }
            this.c.schedule(a2);
            return;
        }
        b(d42);
    }

    /* renamed from: c */
    public CONTEXT getContext() {
        return this.a;
    }

    @Override // com.taobao.rxm.consume.Consumer
    public Consumer<OUT, CONTEXT> consumeOn(Scheduler scheduler) {
        this.c = scheduler;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        Scheduler scheduler = this.c;
        return scheduler != null && (!scheduler.isScheduleMainThread() || !j22.b());
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    /* access modifiers changed from: protected */
    public abstract void f(Throwable th);

    /* access modifiers changed from: protected */
    public abstract void g(OUT out, boolean z);

    /* access modifiers changed from: protected */
    public abstract void h(float f);

    /* access modifiers changed from: protected */
    public void i(Exception exc) {
        kg0.c("RxSysLog", "UnhandledException when BaseConsumer dispatch result: %s", Log.getStackTraceString(exc));
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onCancellation() {
        if (!this.b) {
            this.b = true;
            j(new d42<>(8, true));
        }
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onFailure(Throwable th) {
        if (!this.b) {
            if (this.a.j()) {
                onCancellation();
                return;
            }
            this.b = true;
            d42<OUT> d42 = new d42<>(16, true);
            d42.e = th;
            j(d42);
        }
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onNewResult(OUT out, boolean z) {
        if (!this.b) {
            if (this.a.j()) {
                onCancellation();
                return;
            }
            this.b = z;
            d42<OUT> d42 = new d42<>(1, z);
            d42.c = out;
            j(d42);
        }
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onProgressUpdate(float f) {
        if (!this.b) {
            d42<OUT> d42 = new d42<>(4, false);
            d42.d = f;
            j(d42);
        }
    }

    public String toString() {
        return j22.a(getClass()) + "[cxt-id:" + getContext().d() + jl1.ARRAY_END_STR;
    }
}
