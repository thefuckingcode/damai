package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Lkotlinx/coroutines/internal/e;", "state", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "<no name provided>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class ThreadContextKt$updateState$1 extends Lambda implements Function2<e, CoroutineContext.Element, e> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    @NotNull
    public final e invoke(@NotNull e eVar, @NotNull CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            ThreadContextElement<?> threadContextElement = (ThreadContextElement) element;
            eVar.a(threadContextElement, threadContextElement.updateThreadContext(eVar.a));
        }
        return eVar;
    }
}
