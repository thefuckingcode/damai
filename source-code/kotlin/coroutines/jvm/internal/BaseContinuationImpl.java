package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.o30;
import tb.p30;
import tb.ur2;

@SinceKotlin(version = "1.3")
/* compiled from: Taobao */
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    @Nullable
    private final Continuation<Object> completion;

    public BaseContinuationImpl(@Nullable Continuation<Object> continuation) {
        this.completion = continuation;
    }

    @NotNull
    public Continuation<ur2> create(@NotNull Continuation<?> continuation) {
        k21.i(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return o30.d(this);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object invokeSuspend(@NotNull Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object, kotlin.coroutines.Continuation */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Continuation continuation = this;
        while (true) {
            p30.b(continuation);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) continuation;
            Continuation continuation2 = baseContinuationImpl.completion;
            k21.f(continuation2);
            try {
                Object invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                if (invokeSuspend != b.d()) {
                    Result.a aVar = Result.Companion;
                    obj = Result.m913constructorimpl(invokeSuspend);
                    baseContinuationImpl.releaseIntercepted();
                    if (continuation2 instanceof BaseContinuationImpl) {
                        continuation = continuation2;
                    } else {
                        continuation2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m913constructorimpl(k12.a(th));
            }
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @NotNull
    public Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        k21.i(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
