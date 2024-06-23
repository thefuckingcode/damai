package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0000H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Q", "R", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: SelectUnbiased.kt */
final class UnbiasedSelectBuilderImpl$invoke$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ SelectClause1 receiver$0;
    final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$invoke$2(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, SelectClause1 selectClause1, Function2 function2) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.receiver$0 = selectClause1;
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.receiver$0.registerSelectClause1(this.this$0.getInstance(), this.$block);
    }
}
