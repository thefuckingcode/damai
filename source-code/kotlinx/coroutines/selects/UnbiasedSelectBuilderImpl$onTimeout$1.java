package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.lr2;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n"}, d2 = {"R", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    final /* synthetic */ long $timeMillis;
    final /* synthetic */ lr2<Object> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$onTimeout$1(lr2<Object> lr2, long j, Function1<? super Continuation<Object>, ? extends Object> function1) {
        super(0);
        this.$timeMillis = j;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        throw null;
    }
}
