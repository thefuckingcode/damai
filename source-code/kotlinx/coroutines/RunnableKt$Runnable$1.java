package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class RunnableKt$Runnable$1 implements Runnable {
    final /* synthetic */ Function0<ur2> $block;

    public RunnableKt$Runnable$1(Function0<ur2> function0) {
        this.$block = function0;
    }

    public final void run() {
        this.$block.invoke();
    }
}
