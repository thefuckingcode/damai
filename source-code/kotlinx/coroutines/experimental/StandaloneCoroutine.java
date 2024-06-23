package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0010¢\u0006\u0002\b\u000bJ\u0017\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0010¢\u0006\u0002\b\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/StandaloneCoroutine;", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Z)V", "hasOnFinishingHandler", "update", "", "hasOnFinishingHandler$kotlinx_coroutines_core", "onFinishingInternal", "onFinishingInternal$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Builders.common.kt */
public class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    private final CoroutineContext parentContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        this.parentContext = coroutineContext;
    }

    @Override // kotlinx.coroutines.experimental.JobSupport
    public boolean hasOnFinishingHandler$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedExceptionally;
    }

    @Override // kotlinx.coroutines.experimental.JobSupport
    public void onFinishingInternal$kotlinx_coroutines_core(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.parentContext, ((CompletedExceptionally) obj).cause);
        }
    }
}
