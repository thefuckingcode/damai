package tb;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class or2<T> extends d<T> {
    @Nullable
    private CoroutineContext a;
    @Nullable
    private Object b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public or2(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext.get(r0) == null ? coroutineContext.plus(r0) : coroutineContext, continuation);
        qr2 qr2 = qr2.INSTANCE;
    }

    public final boolean a() {
        if (this.a == null) {
            return false;
        }
        this.a = null;
        this.b = null;
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.d, kotlinx.coroutines.a
    public void afterResume(@Nullable Object obj) {
        CoroutineContext coroutineContext = this.a;
        or2<?> or2 = null;
        if (coroutineContext != null) {
            ThreadContextKt.a(coroutineContext, this.b);
            this.a = or2;
            this.b = or2;
        }
        Object a2 = kl.a(obj, this.uCont);
        Continuation<T> continuation = this.uCont;
        CoroutineContext context = continuation.getContext();
        Object c = ThreadContextKt.c(context, or2);
        if (c != ThreadContextKt.NO_THREAD_ELEMENTS) {
            or2 = qn.e(continuation, context, c);
        }
        try {
            this.uCont.resumeWith(a2);
            ur2 ur2 = ur2.INSTANCE;
        } finally {
            if (or2 == null || or2.a()) {
                ThreadContextKt.a(context, c);
            }
        }
    }

    public final void b(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        this.a = coroutineContext;
        this.b = obj;
    }
}
