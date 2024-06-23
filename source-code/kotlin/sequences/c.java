package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.p30;
import tb.s82;
import tb.ur2;

/* compiled from: Taobao */
final class c<T> extends s82<T> implements Iterator<T>, Continuation<ur2>, KMappedMarker {
    private int a;
    @Nullable
    private T b;
    @Nullable
    private Iterator<? extends T> c;
    @Nullable
    private Continuation<? super ur2> d;

    private final Throwable d() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    private final T e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // tb.s82
    @Nullable
    public Object a(T t, @NotNull Continuation<? super ur2> continuation) {
        this.b = t;
        this.a = 3;
        this.d = continuation;
        Object obj = b.d();
        if (obj == b.d()) {
            p30.c(continuation);
        }
        return obj == b.d() ? obj : ur2.INSTANCE;
    }

    @Override // tb.s82
    @Nullable
    public Object b(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super ur2> continuation) {
        if (!it.hasNext()) {
            return ur2.INSTANCE;
        }
        this.c = it;
        this.a = 2;
        this.d = continuation;
        Object obj = b.d();
        if (obj == b.d()) {
            p30.c(continuation);
        }
        return obj == b.d() ? obj : ur2.INSTANCE;
    }

    public final void f(@Nullable Continuation<? super ur2> continuation) {
        this.d = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i == 1) {
                    Iterator<? extends T> it = this.c;
                    k21.f(it);
                    if (it.hasNext()) {
                        this.a = 2;
                        return true;
                    }
                    this.c = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw d();
                }
            }
            this.a = 5;
            Continuation<? super ur2> continuation = this.d;
            k21.f(continuation);
            this.d = null;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(ur2.INSTANCE));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return e();
        }
        if (i == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.c;
            k21.f(it);
            return (T) it.next();
        } else if (i == 3) {
            this.a = 0;
            T t = this.b;
            this.b = null;
            return t;
        } else {
            throw d();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        k12.b(obj);
        this.a = 4;
    }
}
