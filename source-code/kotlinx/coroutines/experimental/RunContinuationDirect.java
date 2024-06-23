package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/RunContinuationDirect;", "T", "Lkotlin/coroutines/experimental/Continuation;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "continuation", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/Continuation;)V", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Builders.common.kt */
public final class RunContinuationDirect<T> implements Continuation<T> {
    private final /* synthetic */ Continuation $$delegate_0;
    private final CoroutineContext context;

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(T t) {
        this.$$delegate_0.resume(t);
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        this.$$delegate_0.resumeWithException(th);
    }

    public RunContinuationDirect(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        this.$$delegate_0 = continuation;
        this.context = coroutineContext;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }
}
