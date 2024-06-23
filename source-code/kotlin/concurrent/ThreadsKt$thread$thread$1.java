package kotlin.concurrent;

import kotlin.jvm.functions.Function0;
import tb.ur2;

/* compiled from: Taobao */
public final class ThreadsKt$thread$thread$1 extends Thread {
    final /* synthetic */ Function0<ur2> $block;

    ThreadsKt$thread$thread$1(Function0<ur2> function0) {
        this.$block = function0;
    }

    public void run() {
        this.$block.invoke();
    }
}
