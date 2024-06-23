package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements Function1<Object, Object> {
    final /* synthetic */ Function1<Object, ur2> $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEach$1(Function1<Object, ur2> function1) {
        super(1);
        this.$action = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.$action.invoke(obj);
        return obj;
    }
}
