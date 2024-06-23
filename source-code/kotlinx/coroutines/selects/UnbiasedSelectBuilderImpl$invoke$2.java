package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import tb.lr2;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0000H\n"}, d2 = {"Q", "R", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class UnbiasedSelectBuilderImpl$invoke$2 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $block;
    final /* synthetic */ SelectClause1<Object> $this_invoke;
    final /* synthetic */ lr2<Object> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$invoke$2(SelectClause1<Object> selectClause1, lr2<Object> lr2, Function2<Object, ? super Continuation<Object>, ? extends Object> function2) {
        super(0);
        this.$this_invoke = selectClause1;
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        throw null;
    }
}
