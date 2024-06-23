package tb;

import android.text.TextUtils;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.ChainConsumer;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.Producer;
import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb.c02;

/* compiled from: Taobao */
public abstract class qg<OUT, NEXT_OUT extends Releasable, CONTEXT extends c02> implements Producer<OUT, CONTEXT>, ChainConsumer<OUT, NEXT_OUT, CONTEXT> {
    private final String a;
    private final int b;
    private final sm c;
    private Type[] d;
    private Producer<NEXT_OUT, CONTEXT> e;
    private Scheduler f;
    private Scheduler g;

    public qg(String str, int i, int i2) {
        this.a = f(str);
        this.b = i;
        this.c = new sm(i2);
    }

    private boolean d() {
        if (this.d == null) {
            try {
                this.d = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            } catch (Exception e2) {
                kg0.c("RxSysLog", "chain producer get generic types error=%s", e2);
                return false;
            }
        }
        return true;
    }

    private String f(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf != -1 ? name.substring(lastIndexOf + 1) : name;
    }

    private boolean l() {
        return this.b == 2;
    }

    private void r(Consumer<OUT, CONTEXT> consumer, boolean z, boolean z2, boolean z3) {
        ProducerListener g2 = consumer.getContext().g();
        if (g2 != null) {
            g2.onExitOut(consumer.getContext(), getClass(), z, z2, z3);
        }
    }

    private void s(Consumer<OUT, CONTEXT> consumer, boolean z, boolean z2) {
        ProducerListener g2 = consumer.getContext().g();
        if (g2 != null) {
            g2.onEnterIn(consumer.getContext(), getClass(), z, z2);
        }
    }

    public void A(Consumer<OUT, CONTEXT> consumer, float f2) {
        d42<NEXT_OUT> d42 = new d42<>(4, false);
        d42.d = f2;
        v(this.g, consumer, d42);
    }

    public <NN_OUT extends Releasable> qg B(qg<NEXT_OUT, NN_OUT, CONTEXT> qgVar) {
        cs1.c(qgVar);
        this.e = qgVar;
        return qgVar;
    }

    /* access modifiers changed from: protected */
    public boolean a(Consumer<OUT, CONTEXT> consumer) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean b(Consumer<OUT, CONTEXT> consumer, ScheduledAction scheduledAction) {
        return a(consumer);
    }

    /* renamed from: c */
    public qg<OUT, NEXT_OUT, CONTEXT> consumeOn(Scheduler scheduler) {
        this.g = scheduler;
        return this;
    }

    public sm e() {
        return this.c;
    }

    public abstract n50<OUT, NEXT_OUT, CONTEXT> g();

    @Override // com.taobao.rxm.consume.ChainConsumer
    public Scheduler getConsumeScheduler() {
        return this.g;
    }

    @Override // com.taobao.rxm.produce.Producer
    public String getName() {
        return this.a;
    }

    @Override // com.taobao.rxm.produce.Producer
    public Scheduler getProduceScheduler() {
        return this.f;
    }

    public Type h() {
        if (!d()) {
            return null;
        }
        Type[] typeArr = this.d;
        if (typeArr[1] == c02.class) {
            return typeArr[0];
        }
        return typeArr[1];
    }

    public Producer<NEXT_OUT, CONTEXT> i() {
        return this.e;
    }

    public Type j() {
        if (!d()) {
            return null;
        }
        return this.d[0];
    }

    public int k() {
        return this.b;
    }

    public boolean m() {
        return !l() && !e().a(1);
    }

    /* access modifiers changed from: protected */
    public void n(Consumer<OUT, CONTEXT> consumer, boolean z) {
        r(consumer, false, z, false);
    }

    /* access modifiers changed from: protected */
    public void o(Consumer<OUT, CONTEXT> consumer) {
        s(consumer, false, false);
    }

    /* access modifiers changed from: protected */
    public void p(Consumer<OUT, CONTEXT> consumer, boolean z, boolean z2) {
        r(consumer, true, z, z2);
    }

    /* access modifiers changed from: protected */
    public void q(Consumer<OUT, CONTEXT> consumer, boolean z) {
        s(consumer, true, z);
    }

    /* renamed from: t */
    public qg<OUT, NEXT_OUT, CONTEXT> produceOn(Scheduler scheduler) {
        this.f = scheduler;
        return this;
    }

    public void u(Consumer<OUT, CONTEXT> consumer) {
        v(this.g, consumer, new d42<>(8, true));
    }

    /* access modifiers changed from: protected */
    public void v(Scheduler scheduler, Consumer<OUT, CONTEXT> consumer, d42<NEXT_OUT> d42) {
        w(scheduler, consumer, d42, true);
    }

    /* access modifiers changed from: protected */
    public abstract void w(Scheduler scheduler, Consumer<OUT, CONTEXT> consumer, d42<NEXT_OUT> d42, boolean z);

    public void x(Consumer<OUT, CONTEXT> consumer, Throwable th) {
        d42<NEXT_OUT> d42 = new d42<>(16, true);
        d42.e = th;
        v(this.g, consumer, d42);
    }

    public void y(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out) {
        z(consumer, z, next_out, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: NEXT_OUT extends com.taobao.rxm.common.Releasable */
    /* JADX WARN: Multi-variable type inference failed */
    public void z(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out, boolean z2) {
        d42<NEXT_OUT> d42 = new d42<>(1, z);
        d42.c = next_out;
        w(this.g, consumer, d42, z2);
    }
}
