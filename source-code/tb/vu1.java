package tb;

import android.view.View;
import android.view.animation.Animation;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView;

/* compiled from: Taobao */
public final /* synthetic */ class vu1 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Animation c;

    public /* synthetic */ vu1(int i, View view, Animation animation) {
        this.a = i;
        this.b = view;
        this.c = animation;
    }

    public final void run() {
        ProjectTimerAndStrategyTmPromptView.d(this.a, this.b, this.c);
    }
}
