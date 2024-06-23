package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.CoroutineContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/experimental/CoroutineScope;", "", "coroutineContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "isActive", "", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoroutineScope.kt */
public interface CoroutineScope {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: CoroutineScope.kt */
    public static final class DefaultImpls {
        @Deprecated(message = "Replace with top-level coroutineContext", replaceWith = @ReplaceWith(expression = "coroutineContext", imports = {"kotlin.coroutines.experimental.coroutineContext"}))
        public static /* synthetic */ void coroutineContext$annotations() {
        }
    }

    CoroutineContext getCoroutineContext();

    boolean isActive();
}
