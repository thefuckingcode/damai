package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ Function1 $action;
    final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(View view, Function1 function1) {
        this.$this_doOnPreDraw = view;
        this.$action = function1;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
