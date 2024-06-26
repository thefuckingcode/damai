package cn.damai.tetris.component.discover.mvp;

import android.os.Bundle;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.tetris.component.discover.mvp.DiscussContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.Point;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.gr;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public class DiscussPresenter extends BasePresenter<DiscussContract.Model, DiscussView, BaseSection> implements DiscussContract.Presenter<DiscussContract.Model, DiscussView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;
    private DiscussContract.Model tempModel;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DiscussContract.Model a;

        a(DiscussContract.Model model) {
            this.a = model;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1746978404")) {
                ipChange.ipc$dispatch("1746978404", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getDiscussData().contentDetail.contentId);
            DMNav.from(DiscussPresenter.this.getContext().getActivity()).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CONTENT_DETAIL));
            HashMap<String, String> f = a03.f();
            f.put("content_id", this.a.getDiscussData().contentDetail.contentId);
            f.put("content_type", "note");
            f.put("quanziid", ((DiscussContract.Model) DiscussPresenter.this.getModel()).getTrackInfo().getArgsMap().get(za.CNT_CONTENT_ID));
            DiscussPresenter discussPresenter = DiscussPresenter.this;
            discussPresenter.userTrack(TrackType.click, null, ((DiscussContract.Model) ((BasePresenter) discussPresenter).mModel).getTrackInfo().trackB, "hot_discussion", "hot_discussion", f, true);
        }
    }

    public DiscussPresenter(DiscussView discussView, String str, w9 w9Var) {
        super(discussView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864558371")) {
            ipChange.ipc$dispatch("864558371", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-251468160")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-251468160", new Object[]{this})).booleanValue();
    }

    public void init(DiscussContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525289489")) {
            ipChange.ipc$dispatch("-1525289489", new Object[]{this, model});
            return;
        }
        this.tempModel = model;
        this.mTrackInfo = model.getTrackInfo();
        ((DiscussView) getView()).getHotDiscussView().bindData(model.getDiscussData());
        ((DiscussView) getView()).getHotDiscussView().setBackground("#00ffffff");
        if (model.getDiscussData() != null && model.getDiscussData().contentDetail != null) {
            ((DiscussView) getView()).getHotDiscussView().setItemId(model.getDiscussData().contentDetail.contentId);
            ((DiscussView) getView()).getHotDiscussView().updateSpmBC(getTrackPointFromModel(Point.TRACK_B), "hot_discussion");
            ((DiscussView) getView()).getHotDiscussView().setCntContentId(this.mTrackInfo.getArgsMap().get(za.CNT_CONTENT_ID));
            ((DiscussView) getView()).getTitleView().setOnClickListener(new a(model));
        }
    }

    public void rebindData(DiscussContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1739768517")) {
            ipChange.ipc$dispatch("1739768517", new Object[]{this, model});
            return;
        }
        DiscussContract.Model model2 = this.tempModel;
        if (model2 != null) {
            super.rebindData((IModel) model2);
        } else {
            super.rebindData((IModel) model);
        }
    }
}
