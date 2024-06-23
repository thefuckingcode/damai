package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.ff0;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class SingleAmb<T> extends e<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    /* compiled from: Taobao */
    static final class AmbSingleObserver<T> extends AtomicBoolean implements SingleObserver<T> {
        private static final long serialVersionUID = -1944085461036028108L;
        final SingleObserver<? super T> s;
        final ql set;

        AmbSingleObserver(SingleObserver<? super T> singleObserver, ql qlVar) {
            this.s = singleObserver;
            this.set = qlVar;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onError(th);
                return;
            }
            k22.u(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(t);
            }
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.sources = singleSourceArr;
        this.sourcesIterable = iterable;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        int i;
        SingleSource<? extends T>[] singleSourceArr = this.sources;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                i = 0;
                for (SingleSource<? extends T> singleSource : this.sourcesIterable) {
                    if (singleSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (i == singleSourceArr.length) {
                        SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[((i >> 2) + i)];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, i);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i2 = i + 1;
                    singleSourceArr[i] = singleSource;
                    i = i2;
                }
            } catch (Throwable th) {
                ff0.b(th);
                EmptyDisposable.error(th, singleObserver);
                return;
            }
        } else {
            i = singleSourceArr.length;
        }
        ql qlVar = new ql();
        AmbSingleObserver ambSingleObserver = new AmbSingleObserver(singleObserver, qlVar);
        singleObserver.onSubscribe(qlVar);
        for (int i3 = 0; i3 < i; i3++) {
            SingleSource<? extends T> singleSource2 = singleSourceArr[i3];
            if (ambSingleObserver.get()) {
                return;
            }
            if (singleSource2 == null) {
                qlVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (ambSingleObserver.compareAndSet(false, true)) {
                    singleObserver.onError(nullPointerException);
                    return;
                } else {
                    k22.u(nullPointerException);
                    return;
                }
            } else {
                singleSource2.subscribe(ambSingleObserver);
            }
        }
    }
}
