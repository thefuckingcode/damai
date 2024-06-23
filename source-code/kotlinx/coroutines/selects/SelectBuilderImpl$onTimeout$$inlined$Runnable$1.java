package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import tb.lf;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"Ltb/ur2;", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class SelectBuilderImpl$onTimeout$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ Function1 $block$inlined;
    final /* synthetic */ SelectBuilderImpl this$0;

    public SelectBuilderImpl$onTimeout$$inlined$Runnable$1(SelectBuilderImpl selectBuilderImpl, Function1 function1) {
        this.this$0 = selectBuilderImpl;
        this.$block$inlined = function1;
    }

    public final void run() {
        if (this.this$0.trySelect()) {
            lf.b(this.$block$inlined, this.this$0.getCompletion());
        }
    }
}
