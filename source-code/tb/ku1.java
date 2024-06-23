package tb;

import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView;

/* compiled from: Taobao */
public final /* synthetic */ class ku1 implements View.OnClickListener {
    public final /* synthetic */ ProjectSpecialBuyPromptView a;
    public final /* synthetic */ ProjectMemberPrompt b;

    public /* synthetic */ ku1(ProjectSpecialBuyPromptView projectSpecialBuyPromptView, ProjectMemberPrompt projectMemberPrompt) {
        this.a = projectSpecialBuyPromptView;
        this.b = projectMemberPrompt;
    }

    public final void onClick(View view) {
        ProjectSpecialBuyPromptView.d(this.a, this.b, view);
    }
}
