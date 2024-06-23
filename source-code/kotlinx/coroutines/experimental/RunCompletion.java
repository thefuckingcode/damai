package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/RunCompletion;", "T", "Lkotlinx/coroutines/experimental/AbstractContinuation;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "delegate", "Lkotlin/coroutines/experimental/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/Continuation;I)V", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "useCancellingState", "", "getUseCancellingState", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Builders.common.kt */
public final class RunCompletion<T> extends AbstractContinuation<T> {
    private final CoroutineContext context;

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.experimental.AbstractContinuation
    public boolean getUseCancellingState() {
        return true;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RunCompletion(CoroutineContext coroutineContext, Continuation<? super T> continuation, int i) {
        super(continuation, i);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        this.context = coroutineContext;
    }
}
