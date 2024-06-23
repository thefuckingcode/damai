package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import tb.jl0;
import tb.k22;

/* compiled from: Taobao */
public final class AsyncProcessor<T> extends jl0<T> {

    /* compiled from: Taobao */
    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.tryCancel()) {
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!isCancelled()) {
                this.actual.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (isCancelled()) {
                k22.u(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
