package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;

/* compiled from: Taobao */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> {
    final AtomicBoolean once = new AtomicBoolean();
    final CacheState<T> state;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
        static final ReplayDisposable[] TERMINATED = new ReplayDisposable[0];
        final SequentialDisposable connection = new SequentialDisposable();
        volatile boolean isConnected;
        final AtomicReference<ReplayDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
        final d<? extends T> source;
        boolean sourceDone;

        CacheState(d<? extends T> dVar, int i) {
            super(i);
            this.source = dVar;
        }

        public boolean addChild(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.observers.get();
                if (replayDisposableArr == TERMINATED) {
                    return false;
                }
                int length = replayDisposableArr.length;
                replayDisposableArr2 = new ReplayDisposable[(length + 1)];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
                replayDisposableArr2[length] = replayDisposable;
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
            return true;
        }

        public void connect() {
            this.source.subscribe(this);
            this.isConnected = true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.complete());
                this.connection.dispose();
                for (ReplayDisposable<T> replayDisposable : this.observers.getAndSet(TERMINATED)) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                this.connection.dispose();
                for (ReplayDisposable<T> replayDisposable : this.observers.getAndSet(TERMINATED)) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t));
                for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.connection.update(disposable);
        }

        public void removeChild(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.observers.get();
                int length = replayDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayDisposableArr[i2].equals(replayDisposable)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            replayDisposableArr2 = EMPTY;
                        } else {
                            ReplayDisposable<T>[] replayDisposableArr3 = new ReplayDisposable[(length - 1)];
                            System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                            System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                            replayDisposableArr2 = replayDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 7058506693698832024L;
        volatile boolean cancelled;
        final Observer<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final CacheState<T> state;

        ReplayDisposable(Observer<? super T> observer, CacheState<T> cacheState) {
            this.child = observer;
            this.state = cacheState;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.removeChild(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void replay() {
            if (getAndIncrement() == 0) {
                Observer<? super T> observer = this.child;
                int i = 1;
                while (!this.cancelled) {
                    int size = this.state.size();
                    if (size != 0) {
                        Object[] objArr = this.currentBuffer;
                        if (objArr == null) {
                            objArr = this.state.head();
                            this.currentBuffer = objArr;
                        }
                        int length = objArr.length - 1;
                        int i2 = this.index;
                        int i3 = this.currentIndexInBuffer;
                        while (i2 < size) {
                            if (!this.cancelled) {
                                if (i3 == length) {
                                    objArr = (Object[]) objArr[length];
                                    i3 = 0;
                                }
                                if (!NotificationLite.accept(objArr[i3], observer)) {
                                    i3++;
                                    i2++;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!this.cancelled) {
                            this.index = i2;
                            this.currentIndexInBuffer = i3;
                            this.currentBuffer = objArr;
                        } else {
                            return;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    private ObservableCache(d<T> dVar, CacheState<T> cacheState) {
        super(dVar);
        this.state = cacheState;
    }

    public static <T> d<T> from(d<T> dVar) {
        return from(dVar, 16);
    }

    /* access modifiers changed from: package-private */
    public int cachedEventCount() {
        return this.state.size();
    }

    /* access modifiers changed from: package-private */
    public boolean hasObservers() {
        return this.state.observers.get().length != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.state.isConnected;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this.state);
        observer.onSubscribe(replayDisposable);
        this.state.addChild(replayDisposable);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
        replayDisposable.replay();
    }

    public static <T> d<T> from(d<T> dVar, int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return k22.n(new ObservableCache(dVar, new CacheState(dVar, i)));
    }
}
