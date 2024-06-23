package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.experimental.intrinsics.CancellableKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/experimental/RunnableKt$Runnable$1"}, k = 3, mv = {1, 1, 10})
/* compiled from: Runnable.kt */
public final class SelectBuilderImpl$onTimeout$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ Function1 $block$inlined;
    final /* synthetic */ SelectBuilderImpl this$0;

    public SelectBuilderImpl$onTimeout$$inlined$Runnable$1(SelectBuilderImpl selectBuilderImpl, Function1 function1) {
        this.this$0 = selectBuilderImpl;
        this.$block$inlined = function1;
    }

    public final void run() {
        if (this.this$0.trySelect(null)) {
            CancellableKt.startCoroutineCancellable(this.$block$inlined, this.this$0.getCompletion());
        }
    }
}
