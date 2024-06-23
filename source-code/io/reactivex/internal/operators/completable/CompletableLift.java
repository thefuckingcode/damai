package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class CompletableLift extends a {
    final CompletableOperator onLift;
    final CompletableSource source;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.source = completableSource;
        this.onLift = completableOperator;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.source.subscribe(this.onLift.apply(completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            ff0.b(th);
            k22.u(th);
        }
    }
}
