package cn.damai.tetris.component.star.vipcard;

import cn.damai.tetris.component.star.vipcard.VipCardContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class VipCardPresenter extends BasePresenter<VipCardContract.Model, VipCardView, BaseSection> implements VipCardContract.Presenter<VipCardContract.Model, VipCardView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    UserVipPanel vipPanel;

    public VipCardPresenter(VipCardView vipCardView, String str, w9 w9Var) {
        super(vipCardView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782577287")) {
            ipChange.ipc$dispatch("1782577287", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(VipCardContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327380663")) {
            ipChange.ipc$dispatch("327380663", new Object[]{this, model});
            return;
        }
        if (this.vipPanel == null) {
            this.vipPanel = new UserVipPanel(this.mContext.getActivity(), ((VipCardView) getView()).getVipView(), this);
        }
        this.vipPanel.d(model.getData());
    }
}
