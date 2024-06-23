package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableScalarXMap {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ScalarXMapFlowable<T, R> extends b<R> {
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final T value;

        ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.value = t;
            this.mapper = function;
        }

        @Override // io.reactivex.b
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                        } else {
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                        }
                    } catch (Throwable th) {
                        ff0.b(th);
                        EmptySubscription.error(th, subscriber);
                    }
                } else {
                    publisher.subscribe(subscriber);
                }
            } catch (Throwable th2) {
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> b<U> scalarXMap(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return k22.l(new ScalarXMapFlowable(t, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Callable)) {
            return false;
        }
        try {
            Object obj = (Object) ((Callable) publisher).call();
            if (obj == 0) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(function.apply(obj), "The mapper returned a null Publisher");
                if (publisher2 instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher2).call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                    } catch (Throwable th) {
                        ff0.b(th);
                        EmptySubscription.error(th, subscriber);
                        return true;
                    }
                } else {
                    publisher2.subscribe(subscriber);
                }
                return true;
            } catch (Throwable th2) {
                ff0.b(th2);
                EmptySubscription.error(th2, subscriber);
                return true;
            }
        } catch (Throwable th3) {
            ff0.b(th3);
            EmptySubscription.error(th3, subscriber);
            return true;
        }
    }
}
