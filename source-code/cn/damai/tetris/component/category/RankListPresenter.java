package cn.damai.tetris.component.category;

import android.os.Bundle;
import android.view.View;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.commonbusiness.rank.CommonRankHolder;
import cn.damai.commonbusiness.rank.RankItemBean;
import cn.damai.tetris.component.category.RankListContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.qa;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public class RankListPresenter extends BasePresenter<RankListContract.Model, RankListContract.View, BaseSection> implements RankListContract.Presenter<RankListContract.Model, RankListContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankListContract.Model a;
        final /* synthetic */ String b;

        a(RankListContract.Model model, String str) {
            this.a = model;
            this.b = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1006644979")) {
                ipChange.ipc$dispatch("-1006644979", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(RankListFragment.KEY_RANK_ID, this.a.getBean().id);
            NavProxy.from(RankListPresenter.this.getContext().getActivity()).withExtras(bundle).toHost("ranking");
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", this.b);
            hashMap.put("card_type", "5");
            RankListPresenter rankListPresenter = RankListPresenter.this;
            TrackType trackType = TrackType.click;
            String str = rankListPresenter.mTrackInfo.trackB;
            String str2 = RankListPresenter.this.mTrackInfo.trackC;
            rankListPresenter.userTrack(trackType, view, str, str2, "item_" + this.a.getIndex(), hashMap, true);
        }
    }

    public RankListPresenter(RankListView rankListView, String str, w9 w9Var) {
        super(rankListView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889065012")) {
            ipChange.ipc$dispatch("-1889065012", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(RankListContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887888797")) {
            ipChange.ipc$dispatch("887888797", new Object[]{this, model});
            return;
        }
        TrackInfo trackInfo = model.getTrackInfo();
        this.mTrackInfo = trackInfo;
        String string = trackInfo != null ? trackInfo.getString(qa.TRACKKEY_CATEGORY_NAME) : "";
        if (((RankListContract.View) getView()).getHolder() != null && model.getBean() != null) {
            CommonRankHolder holder = ((RankListContract.View) getView()).getHolder();
            RankItemBean bean = model.getBean();
            holder.a(bean);
            HashMap<String, String> f = a03.f();
            a03.h(f, za.PRE_CONTENT_ID, bean.id);
            a03.h(f, za.PRE_CONTENT_TYPE, "ranklist");
            if (getContext().getActivity().getClass().getName().equals("cn.damai.homepage.MainActivity")) {
                holder.b();
            }
            View view = holder.itemView;
            userTrackExpose(view, "item_" + model.getIndex(), f, false);
            ((RankListContract.View) getView()).getRootView().setOnClickListener(new a(model, string));
        }
    }
}
