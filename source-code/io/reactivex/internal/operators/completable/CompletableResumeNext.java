package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import tb.ff0;

/* compiled from: Taobao */
public final class CompletableResumeNext extends a {
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    final CompletableSource source;

    /* compiled from: Taobao */
    final class ResumeNext implements CompletableObserver {
        final CompletableObserver s;
        final SequentialDisposable sd;

        /* compiled from: Taobao */
        final class OnErrorObserver implements CompletableObserver {
            OnErrorObserver() {
            }

            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
                ResumeNext.this.s.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                ResumeNext.this.s.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                ResumeNext.this.sd.update(disposable);
            }
        }

        ResumeNext(CompletableObserver completableObserver, SequentialDisposable sequentialDisposable) {
            this.s = completableObserver;
            this.sd = sequentialDisposable;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.s.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                CompletableSource completableSource = (CompletableSource) CompletableResumeNext.this.errorMapper.apply(th);
                if (completableSource == null) {
                    NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                    nullPointerException.initCause(th);
                    this.s.onError(nullPointerException);
                    return;
                }
                completableSource.subscribe(new OnErrorObserver());
            } catch (Throwable th2) {
                ff0.b(th2);
                this.s.onError(new CompositeException(th2, th));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.sd.update(disposable);
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.source = completableSource;
        this.errorMapper = function;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        completableObserver.onSubscribe(sequentialDisposable);
        this.source.subscribe(new ResumeNext(completableObserver, sequentialDisposable));
    }
}
