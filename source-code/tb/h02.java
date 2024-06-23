package tb;

import android.text.TextUtils;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.taobao.rxm.request.MultiplexCancelListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.c02;

/* compiled from: Taobao */
public class h02<OUT extends Releasable, CONTEXT extends c02> extends BaseChainProducer<OUT, OUT, CONTEXT> implements MultiplexCancelListener {
    public Class<OUT> j;
    private Map<String, Integer> k = new ConcurrentHashMap();
    private Map<Integer, ArrayList<Consumer<OUT, CONTEXT>>> l = new ConcurrentHashMap();

    public h02(Class<OUT> cls) {
        super(1, 29);
        this.j = cls;
    }

    private void H(ArrayList<Consumer<OUT, CONTEXT>> arrayList, Consumer<OUT, CONTEXT> consumer) {
        arrayList.add(consumer);
        int h = consumer.getContext().h();
        CONTEXT context = J(arrayList).getContext();
        if (h > context.h()) {
            context.q(h);
        }
        if (context.i() && !consumer.getContext().j()) {
            context.c(false);
        }
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, OUT] */
    private void I(Consumer<OUT, CONTEXT> consumer, d42<OUT> d42) {
        CONTEXT context = consumer.getContext();
        ArrayList<Consumer<OUT, CONTEXT>> arrayList = this.l.get(Integer.valueOf(context.d()));
        String e = context.e();
        int i = 4;
        if (arrayList == null) {
            kg0.i("RxSysLog", "[RequestMultiplex] group has been removed from multiplex, but pipeline is still producing new result(multiplex:%s, id:%d, pipeline:%d, type:%d)", e, Integer.valueOf(context.d()), Integer.valueOf(context.f()), Integer.valueOf(d42.a));
            return;
        }
        synchronized (this) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Consumer<OUT, CONTEXT> consumer2 = arrayList.get(i2);
                CONTEXT context2 = consumer2.getContext();
                if (consumer2 != consumer) {
                    context2.r(context);
                }
                if (!context2.j()) {
                    int i3 = d42.a;
                    if (i3 == 1) {
                        consumer2.onNewResult(d42.c, d42.b);
                    } else if (i3 == i) {
                        consumer2.onProgressUpdate(d42.d);
                    } else if (i3 == 8) {
                        kg0.c("RxSysLog", "[RequestMultiplex] ID=%d consumers of the group were not all cancelled, but pipeline dispatched cancellation result", Integer.valueOf(context2.d()));
                        consumer2.onCancellation();
                    } else if (i3 == 16) {
                        consumer2.onFailure(d42.e);
                    }
                } else {
                    if (d42.a == 16) {
                        kg0.f("RxSysLog", "[RequestMultiplex] ID=%d received error after cancellation, throwable=%s", Integer.valueOf(context2.d()), d42.e);
                    }
                    consumer2.onCancellation();
                }
                i2++;
                i = 4;
            }
            if (d42.b) {
                if (!TextUtils.isEmpty(e)) {
                    this.k.remove(e);
                }
                this.l.remove(Integer.valueOf(context.d()));
            }
        }
    }

    private Consumer<OUT, CONTEXT> J(ArrayList<Consumer<OUT, CONTEXT>> arrayList) {
        return arrayList.get(0);
    }

    private boolean K(ArrayList<Consumer<OUT, CONTEXT>> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).getContext().j()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer
    /* renamed from: D */
    public void consumeNewResult(Consumer<OUT, CONTEXT> consumer, boolean z, OUT out) {
        d42<OUT> d42 = new d42<>(1, z);
        d42.c = out;
        I(consumer, d42);
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean a(Consumer<OUT, CONTEXT> consumer) {
        boolean z;
        ArrayList<Consumer<OUT, CONTEXT>> arrayList;
        CONTEXT context = consumer.getContext();
        String e = context.e();
        synchronized (this) {
            Integer num = this.k.get(e);
            if (num == null) {
                num = Integer.valueOf(context.d());
                this.k.put(e, num);
                arrayList = new ArrayList<>(2);
                this.l.put(num, arrayList);
                z = false;
            } else {
                arrayList = this.l.get(num);
                z = true;
            }
            context.o(num.intValue());
            context.n(this);
            H(arrayList, consumer);
        }
        return z;
    }

    @Override // com.taobao.rxm.consume.ChainConsumer, com.taobao.rxm.produce.BaseChainProducer
    public void consumeCancellation(Consumer<OUT, CONTEXT> consumer) {
        I(consumer, new d42<>(8, true));
    }

    @Override // com.taobao.rxm.consume.ChainConsumer, com.taobao.rxm.produce.BaseChainProducer
    public void consumeFailure(Consumer<OUT, CONTEXT> consumer, Throwable th) {
        d42<OUT> d42 = new d42<>(16, true);
        d42.e = th;
        I(consumer, d42);
    }

    @Override // com.taobao.rxm.consume.ChainConsumer, com.taobao.rxm.produce.BaseChainProducer
    public void consumeProgressUpdate(Consumer<OUT, CONTEXT> consumer, float f) {
        d42<OUT> d42 = new d42<>(4, false);
        d42.d = f;
        I(consumer, d42);
    }

    @Override // tb.qg
    public Type h() {
        return this.j;
    }

    @Override // tb.qg
    public Type j() {
        return this.j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    @Override // com.taobao.rxm.request.MultiplexCancelListener
    public void onCancelRequest(c02 c02) {
        ArrayList<Consumer<OUT, CONTEXT>> arrayList;
        Consumer<OUT, CONTEXT> J;
        boolean z;
        String e = c02.e();
        if (this.k.containsKey(e) && (arrayList = this.l.get(Integer.valueOf(c02.f()))) != null) {
            synchronized (this) {
                J = J(arrayList);
                if (!J.getContext().i()) {
                    if (!K(arrayList)) {
                        z = false;
                        if (z) {
                            this.k.remove(e);
                            kg0.a("RxSysLog", "[RequestMultiplex] all of context in group[key:%s] were cancelled, remove it from KeyToGroupId", e);
                        }
                    }
                }
                z = true;
                if (z) {
                }
            }
            if (z) {
                J.getContext().c(true);
            }
        }
    }
}
