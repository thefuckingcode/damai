package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import tb.o91;
import tb.oa1;

/* compiled from: Taobao */
public class LottieTask<T> {
    public static Executor e = Executors.newCachedThreadPool();
    private final Set<LottieListener<T>> a;
    private final Set<LottieListener<Throwable>> b;
    private final Handler c;
    @Nullable
    private volatile oa1<T> d;

    /* compiled from: Taobao */
    private class LottieFutureTask extends FutureTask<oa1<T>> {
        LottieFutureTask(Callable<oa1<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.l((oa1) get());
                } catch (InterruptedException | ExecutionException e) {
                    LottieTask.this.l(new oa1(e));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<oa1<T>> callable) {
        this(callable, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void g(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            o91.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener lottieListener : arrayList) {
            lottieListener.onResult(th);
        }
    }

    private void h() {
        this.c.post(new Runnable() {
            /* class com.airbnb.lottie.LottieTask.AnonymousClass1 */

            public void run() {
                if (LottieTask.this.d != null) {
                    oa1 oa1 = LottieTask.this.d;
                    if (oa1.b() != null) {
                        LottieTask.this.i(oa1.b());
                    } else {
                        LottieTask.this.g(oa1.a());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void i(T t) {
        for (LottieListener lottieListener : new ArrayList(this.a)) {
            lottieListener.onResult(t);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(@Nullable oa1<T> oa1) {
        if (this.d == null) {
            this.d = oa1;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> e(LottieListener<Throwable> lottieListener) {
        if (!(this.d == null || this.d.a() == null)) {
            lottieListener.onResult(this.d.a());
        }
        this.b.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> f(LottieListener<T> lottieListener) {
        if (!(this.d == null || this.d.b() == null)) {
            lottieListener.onResult(this.d.b());
        }
        this.a.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> j(LottieListener<Throwable> lottieListener) {
        this.b.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> k(LottieListener<T> lottieListener) {
        this.a.remove(lottieListener);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    LottieTask(Callable<oa1<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (z) {
            try {
                l(callable.call());
            } catch (Throwable th) {
                l(new oa1<>(th));
            }
        } else {
            e.execute(new LottieFutureTask(callable));
        }
    }
}
