package com.taobao.rxm.produce;

import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import tb.c02;
import tb.ct1;
import tb.d42;
import tb.e42;
import tb.j22;
import tb.kg0;
import tb.n50;
import tb.ng;
import tb.qg;

/* compiled from: Taobao */
public abstract class BaseChainProducer<OUT, NEXT_OUT extends Releasable, CONTEXT extends c02> extends qg<OUT, NEXT_OUT, CONTEXT> {
    private e42 h;
    private n50<OUT, NEXT_OUT, CONTEXT> i;

    public BaseChainProducer(int i2, int i3) {
        this(null, i2, i3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void E(Consumer<OUT, CONTEXT> consumer, d42<NEXT_OUT> d42, ScheduledAction scheduledAction) {
        if (d42 != null) {
            int i2 = d42.a;
            if (i2 == 1) {
                consumeNewResult(consumer, d42.b, d42.c);
            } else if (i2 == 4) {
                consumeProgressUpdate(consumer, d42.d);
            } else if (i2 == 8) {
                consumeCancellation(consumer);
            } else if (i2 == 16) {
                consumeFailure(consumer, d42.e);
            }
        } else if (consumer.getContext().i()) {
            kg0.f("RxSysLog", "[ChainProducer] ID=%d cancelled before conducting result, producer=%s type=%s", Integer.valueOf(consumer.getContext().d()), getName(), ct1.a(k()));
            consumer.onCancellation();
        } else if (!b(consumer, scheduledAction) && k() == 1) {
            G(consumer);
        }
    }

    private ng<OUT, NEXT_OUT, CONTEXT> F(Consumer<OUT, CONTEXT> consumer) {
        ng<OUT, NEXT_OUT, CONTEXT> a = g().offer();
        return a != null ? a.d(consumer, this) : new ng<>(consumer, this);
    }

    private void G(Consumer<OUT, CONTEXT> consumer) {
        if (i() != null) {
            i().produceResults(F(consumer).consumeOn(getConsumeScheduler()));
            return;
        }
        throw new RuntimeException(getName() + " can't conduct result while no next producer");
    }

    /* renamed from: D */
    public void consumeNewResult(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out) {
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    public void consumeCancellation(Consumer<OUT, CONTEXT> consumer) {
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    public void consumeFailure(Consumer<OUT, CONTEXT> consumer, Throwable th) {
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    public void consumeProgressUpdate(Consumer<OUT, CONTEXT> consumer, float f) {
    }

    @Override // tb.qg
    public n50<OUT, NEXT_OUT, CONTEXT> g() {
        return this.i;
    }

    @Override // com.taobao.rxm.produce.Producer
    public void produceResults(Consumer<OUT, CONTEXT> consumer) {
        if (consumer.getContext().i()) {
            kg0.f("RxSysLog", "[ChainProducer] ID=%d cancelled before leading to produce result, producer=%s type=%s", Integer.valueOf(consumer.getContext().d()), getName(), ct1.a(k()));
            consumer.onCancellation();
        } else if (k() != 0) {
            v(getProduceScheduler(), consumer, null);
        } else {
            G(consumer);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public void w(Scheduler scheduler, Consumer<OUT, CONTEXT> consumer, d42<NEXT_OUT> d42, boolean z) {
        if (scheduler == null || (z && scheduler.isScheduleMainThread() && j22.b())) {
            E(consumer, d42, null);
            return;
        }
        ScheduledAction a = this.h.offer();
        if (a == null) {
            a = new ScheduledAction(consumer.getContext().h(), consumer, d42, z) {
                /* class com.taobao.rxm.produce.BaseChainProducer.AnonymousClass1 */

                @Override // com.taobao.rxm.schedule.ScheduledAction
                public void run(Consumer consumer, d42 d42) {
                    BaseChainProducer.this.E(consumer, d42, this);
                }
            };
            a.setScheduledActionPool(this.h);
        } else {
            a.reset(consumer.getContext().h(), consumer, d42, z);
        }
        scheduler.schedule(a);
    }

    public BaseChainProducer(String str, int i2, int i3) {
        super(str, i2, i3);
        this.h = new e42();
        this.i = new n50<>();
    }
}
