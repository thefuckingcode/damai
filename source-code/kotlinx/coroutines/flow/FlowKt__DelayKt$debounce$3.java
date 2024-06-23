package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;
import tb.gc0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n"}, d2 = {"T", "emittedItem", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class FlowKt__DelayKt$debounce$3 extends Lambda implements Function1<Object, Long> {
    final /* synthetic */ Function1<Object, gc0> $timeout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$3(Function1<Object, gc0> function1) {
        super(1);
        this.$timeout = function1;
    }

    /* Return type fixed from 'long' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(Object obj) {
        return DelayKt.d(this.$timeout.invoke(obj).C());
    }
}
