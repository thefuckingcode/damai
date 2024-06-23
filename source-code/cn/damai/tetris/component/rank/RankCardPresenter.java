package cn.damai.tetris.component.rank;

import android.os.Bundle;
import android.view.View;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.rank.RankCardContract;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import tb.tb2;
import tb.w9;
import tb.wz1;
import tb.za;

/* compiled from: Taobao */
public class RankCardPresenter extends BasePresenter<RankCardContract.Model, RankCardContract.View, BaseSection> implements RankCardContract.Presenter<RankCardContract.Model, RankCardContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-836330487")) {
                ipChange.ipc$dispatch("-836330487", new Object[]{this, view});
                return;
            }
            RankCardPresenter rankCardPresenter = RankCardPresenter.this;
            rankCardPresenter.userTrackClick("item_" + ((RankCardContract.Model) RankCardPresenter.this.getModel()).getOffset(), RankCardPresenter.this.mTrackInfo.getArgsMap(), true);
            if (((RankCardContract.Model) RankCardPresenter.this.getModel()).getData() != null && ((RankCardContract.Model) RankCardPresenter.this.getModel()).getData().id > 0 && RankCardPresenter.this.getContext().getActivity() != null) {
                if (((RankCardContract.Model) RankCardPresenter.this.getModel()).getData().type != 99) {
                    RankCardPresenter rankCardPresenter2 = RankCardPresenter.this;
                    rankCardPresenter2.navToProjcet(((RankCardContract.Model) rankCardPresenter2.getModel()).getData(), RankCardPresenter.this.mTrackInfo.getArgsMap());
                    return;
                }
                RankCardPresenter rankCardPresenter3 = RankCardPresenter.this;
                rankCardPresenter3.navToRepro(((RankCardContract.Model) rankCardPresenter3.getModel()).getData());
            }
        }
    }

    public RankCardPresenter(RankCardView rankCardView, String str, w9 w9Var) {
        super(rankCardView, str, w9Var);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void navToProjcet(RankItemBean rankItemBean, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103124026")) {
            ipChange.ipc$dispatch("1103124026", new Object[]{this, rankItemBean, map});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IssueConstants.ProjectID, rankItemBean.id + "");
        bundle.putString("projectName", rankItemBean.name);
        bundle.putString("projectImage", rankItemBean.headPic);
        RankInfo rankInfo = new RankInfo();
        rankInfo.setId(map.get(za.CNT_CONTENT_ID));
        rankInfo.setName(map.get("titlelabel"));
        rankInfo.setOrder(rankItemBean.order + "");
        bundle.putParcelable("rankInfo", rankInfo);
        tb2.a(getContext().getActivity(), rankItemBean.schema, bundle);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void navToRepro(RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392556614")) {
            ipChange.ipc$dispatch("392556614", new Object[]{this, rankItemBean});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RepertoireDetailFragment.REPERTOIREID, rankItemBean.id + "");
        NavProxy.from(getContext().getActivity()).withExtras(bundle).toUri(INavUri.page(wz1.REPERTOITE));
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718750520")) {
            ipChange.ipc$dispatch("-1718750520", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(RankCardContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736654877")) {
            ipChange.ipc$dispatch("736654877", new Object[]{this, model});
        } else if (model != null) {
            this.mTrackInfo = model.getTrackInfo();
            if (model.getData() != null && getView() != null && ((RankCardContract.View) getView()).getHolder() != null) {
                TrackInfo trackInfo = this.mTrackInfo;
                trackInfo.put("item_id", (Object) (model.getData().id + ""));
                ((RankCardContract.View) getView()).getHolder().a(model.getOffset(), 0, model.getData());
                ((RankCardContract.View) getView()).getRootView().setOnClickListener(new a());
                View rootView = ((RankCardContract.View) getView()).getRootView();
                userTrackExpose(rootView, "item_" + ((RankCardContract.Model) getModel()).getOffset(), this.mTrackInfo.getArgsMap(), true);
            }
        }
    }
}
