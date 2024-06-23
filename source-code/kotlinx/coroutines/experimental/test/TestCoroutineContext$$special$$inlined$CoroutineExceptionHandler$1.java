package kotlinx.coroutines.experimental.test;

import kotlin.Metadata;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineExceptionHandler;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/experimental/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/experimental/CoroutineExceptionHandler;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/experimental/CoroutineContext$Key;)V", "handleException", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoroutineExceptionHandler.kt */
public final class TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ TestCoroutineContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1(CoroutineContext.Key key, TestCoroutineContext testCoroutineContext) {
        super(key);
        this.this$0 = testCoroutineContext;
    }

    @Override // kotlinx.coroutines.experimental.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        TestCoroutineContext.access$getUncaughtExceptions$p(this.this$0).add(th);
    }
}
