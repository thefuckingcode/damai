package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableOperator;
import io.reactivex.b;
import org.reactivestreams.Subscriber;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {
    final FlowableOperator<? extends R, ? super T> operator;

    public FlowableLift(b<T> bVar, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(bVar);
        this.operator = flowableOperator;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: io.reactivex.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super Object> apply = this.operator.apply(subscriber);
            if (apply != null) {
                this.source.subscribe(apply);
                return;
            }
            throw new NullPointerException("Operator " + this.operator + " returned a null Subscriber");
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            ff0.b(th);
            k22.u(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
