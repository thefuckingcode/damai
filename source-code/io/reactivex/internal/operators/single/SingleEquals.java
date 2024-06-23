package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class SingleEquals<T> extends e<Boolean> {
    final SingleSource<? extends T> first;
    final SingleSource<? extends T> second;

    /* compiled from: Taobao */
    static class InnerObserver<T> implements SingleObserver<T> {
        final AtomicInteger count;
        final int index;
        final SingleObserver<? super Boolean> s;
        final ql set;
        final Object[] values;

        InnerObserver(int i, ql qlVar, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.index = i;
            this.set = qlVar;
            this.values = objArr;
            this.s = singleObserver;
            this.count = atomicInteger;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            int i;
            do {
                i = this.count.get();
                if (i >= 2) {
                    k22.u(th);
                    return;
                }
            } while (!this.count.compareAndSet(i, 2));
            this.set.dispose();
            this.s.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.values[this.index] = t;
            if (this.count.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.s;
                Object[] objArr = this.values;
                singleObserver.onSuccess(Boolean.valueOf(ObjectHelper.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.first = singleSource;
        this.second = singleSource2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        ql qlVar = new ql();
        singleObserver.onSubscribe(qlVar);
        this.first.subscribe(new InnerObserver(0, qlVar, objArr, singleObserver, atomicInteger));
        this.second.subscribe(new InnerObserver(1, qlVar, objArr, singleObserver, atomicInteger));
    }
}
