package cn.damai.tetris.component.star.header;

import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.tetris.component.star.header.StarHeaderContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public abstract class StarHeaderPresenterBase extends BasePresenter<StarHeaderContract.Model, StarHeaderView, BaseSection> implements StarHeaderContract.Presenter<StarHeaderContract.Model, StarHeaderView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    StarHeaderData headerData;
    private int refreshTime = 0;

    public StarHeaderPresenterBase(StarHeaderView starHeaderView, String str, w9 w9Var) {
        super(starHeaderView, str, w9Var);
    }

    /* access modifiers changed from: package-private */
    public abstract int getType();

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520836066")) {
            ipChange.ipc$dispatch("520836066", new Object[]{this, Integer.valueOf(i), obj});
        } else if (getContext().getActivity() != null) {
            if (i == 7002) {
                a.k(((StarHeaderContract.Model) getModel()).getData(), getContext().getActivity(), ((StarHeaderView) getView()).getHeaderView(), this);
            } else if (i == 103 && (obj instanceof StarHeaderData)) {
                StarHeaderData starHeaderData = (StarHeaderData) obj;
                this.headerData = starHeaderData;
                ((StarHeaderContract.Model) getModel()).setData(starHeaderData);
                a.d(getContext().getActivity(), ((StarHeaderView) getView()).getHeaderView(), ((StarHeaderContract.Model) getModel()).getData(), getType(), (StarHeaderContract.Model) getModel(), this);
            }
            if (i == 11004) {
                this.refreshTime = 0;
                AttentionView attentionView = (AttentionView) ((StarHeaderView) getView()).getHeaderView().findViewById(R$id.attent_view_star);
                if (attentionView != null) {
                    attentionView.cleanAttenList();
                }
            }
        }
    }

    public void init(StarHeaderContract.Model model) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1250084476")) {
            ipChange.ipc$dispatch("1250084476", new Object[]{this, model});
            return;
        }
        if (this.refreshTime > 0) {
            model.getData().followStatus = ((AttentionView) ((StarHeaderView) getView()).getHeaderView().findViewById(R$id.attent_view_star)).getState();
        }
        this.headerData = model.getData();
        if (getSection().getExtraArgs() != null) {
            try {
                i = getSection().getExtraArgs().getIntValue("showType");
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.setFragmentType(i);
        }
        this.refreshTime++;
        a.d(getContext().getActivity(), ((StarHeaderView) getView()).getHeaderView(), this.headerData, getType(), model, this);
        sendMsg(new Message(103, this.headerData));
    }
}
