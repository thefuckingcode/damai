package tb;

import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView;

/* compiled from: Taobao */
public final /* synthetic */ class tu1 implements View.OnClickListener {
    public final /* synthetic */ ProjectTimerAndStrategyTmPromptView a;
    public final /* synthetic */ ProjectMemberPrompt b;

    public /* synthetic */ tu1(ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView, ProjectMemberPrompt projectMemberPrompt) {
        this.a = projectTimerAndStrategyTmPromptView;
        this.b = projectMemberPrompt;
    }

    public final void onClick(View view) {
        ProjectTimerAndStrategyTmPromptView.f(this.a, this.b, view);
    }
}
