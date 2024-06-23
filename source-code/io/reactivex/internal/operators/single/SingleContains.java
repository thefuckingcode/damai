package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.functions.BiPredicate;
import tb.ff0;

/* compiled from: Taobao */
public final class SingleContains<T> extends e<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    /* compiled from: Taobao */
    final class Single implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> s;

        Single(SingleObserver<? super Boolean> singleObserver) {
            this.s = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.s.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.s.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                SingleContains singleContains = SingleContains.this;
                this.s.onSuccess(Boolean.valueOf(singleContains.comparer.test(t, singleContains.value)));
            } catch (Throwable th) {
                ff0.b(th);
                this.s.onError(th);
            }
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.source = singleSource;
        this.value = obj;
        this.comparer = biPredicate;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new Single(singleObserver));
    }
}
