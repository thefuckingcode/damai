package kotlinx.coroutines.experimental.selects;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: SelectUnbiased.kt */
final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ long $time;
    final /* synthetic */ TimeUnit $unit;
    final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$onTimeout$1(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, long j, TimeUnit timeUnit, Function1 function1) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$time = j;
        this.$unit = timeUnit;
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.getInstance().onTimeout(this.$time, this.$unit, this.$block);
    }
}
