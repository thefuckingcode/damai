package kotlin.concurrent;

import java.util.TimerTask;
import kotlin.jvm.functions.Function1;
import tb.ur2;

/* compiled from: Taobao */
public final class TimersKt$timerTask$1 extends TimerTask {
    final /* synthetic */ Function1<TimerTask, ur2> $action;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.util.TimerTask, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public TimersKt$timerTask$1(Function1<? super TimerTask, ur2> function1) {
        this.$action = function1;
    }

    public void run() {
        this.$action.invoke(this);
    }
}
