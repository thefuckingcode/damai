package tb;

import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment;

/* compiled from: Taobao */
public final /* synthetic */ class rt1 implements View.OnClickListener {
    public final /* synthetic */ ProjectDetailItemMainFragment a;
    public final /* synthetic */ VIPCreditExchangePopFragment b;

    public /* synthetic */ rt1(ProjectDetailItemMainFragment projectDetailItemMainFragment, VIPCreditExchangePopFragment vIPCreditExchangePopFragment) {
        this.a = projectDetailItemMainFragment;
        this.b = vIPCreditExchangePopFragment;
    }

    public final void onClick(View view) {
        this.a.lambda$showVIPCreditExchangeFragment$0(this.b, view);
    }
}
