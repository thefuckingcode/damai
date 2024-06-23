package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, vj1<T>> {

    /* compiled from: Taobao */
    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, vj1<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        MaterializeSubscriber(Subscriber<? super vj1<T>> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(vj1.a());
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        public /* bridge */ /* synthetic */ void onDrop(Object obj) {
            onDrop((vj1) ((vj1) obj));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            complete(vj1.b(th));
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(vj1.c(t));
        }

        /* access modifiers changed from: protected */
        public void onDrop(vj1<T> vj1) {
            if (vj1.g()) {
                k22.u(vj1.d());
            }
        }
    }

    public FlowableMaterialize(b<T> bVar) {
        super(bVar);
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super vj1<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new MaterializeSubscriber(subscriber));
    }
}
