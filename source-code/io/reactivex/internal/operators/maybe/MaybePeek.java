package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onCompleteCall;
    final Action onDisposeCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super Disposable> onSubscribeCall;
    final Consumer<? super T> onSuccessCall;

    /* compiled from: Taobao */
    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;
        Disposable d;
        final MaybePeek<T> parent;

        MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.actual = maybeObserver;
            this.parent = maybePeek;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                this.parent.onDisposeCall.run();
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(th);
            }
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void onAfterTerminate() {
            try {
                this.parent.onAfterTerminate.run();
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Disposable disposable = this.d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.parent.onCompleteCall.run();
                    this.d = disposableHelper;
                    this.actual.onComplete();
                    onAfterTerminate();
                } catch (Throwable th) {
                    ff0.b(th);
                    onErrorInner(th);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.d == DisposableHelper.DISPOSED) {
                k22.u(th);
            } else {
                onErrorInner(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void onErrorInner(Throwable th) {
            try {
                this.parent.onErrorCall.accept(th);
            } catch (Throwable th2) {
                ff0.b(th2);
                th = new CompositeException(th, th2);
            }
            this.d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
            onAfterTerminate();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                try {
                    this.parent.onSubscribeCall.accept(disposable);
                    this.d = disposable;
                    this.actual.onSubscribe(this);
                } catch (Throwable th) {
                    ff0.b(th);
                    disposable.dispose();
                    this.d = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.actual);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            Disposable disposable = this.d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.parent.onSuccessCall.accept(t);
                    this.d = disposableHelper;
                    this.actual.onSuccess(t);
                    onAfterTerminate();
                } catch (Throwable th) {
                    ff0.b(th);
                    onErrorInner(th);
                }
            }
        }
    }

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.onSubscribeCall = consumer;
        this.onSuccessCall = consumer2;
        this.onErrorCall = consumer3;
        this.onCompleteCall = action;
        this.onAfterTerminate = action2;
        this.onDisposeCall = action3;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new MaybePeekObserver(maybeObserver, this));
    }
}
