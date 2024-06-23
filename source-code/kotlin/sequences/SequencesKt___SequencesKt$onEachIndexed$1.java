package kotlin.sequences;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements Function2<Integer, Object, Object> {
    final /* synthetic */ Function2<Integer, Object, ur2> $action;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, java.lang.Object, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEachIndexed$1(Function2<? super Integer, Object, ur2> function2) {
        super(2);
        this.$action = function2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
        return invoke(num.intValue(), obj);
    }

    public final Object invoke(int i, Object obj) {
        this.$action.invoke(Integer.valueOf(i), obj);
        return obj;
    }
}
