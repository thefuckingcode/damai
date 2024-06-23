package cn.damai.tetris.component.rank;

import android.os.Bundle;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.discover.mvp.NotePresenter;
import cn.damai.tetris.component.rank.RankProjectContract;
import cn.damai.tetris.component.rank.bean.RankCityIdTarget;
import cn.damai.tetris.component.rank.bean.RankCityValue;
import cn.damai.tetris.component.rank.bean.RankFilterTarget;
import cn.damai.tetris.component.rank.bean.RankFilterValue;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.container.ValueKey;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a03;
import tb.d20;
import tb.k21;
import tb.m40;
import tb.tb2;
import tb.w9;
import tb.wz1;
import tb.za;

/* compiled from: Taobao */
public final class RankProjectPresenter extends BasePresenter<RankProjectModel, RankProjectView, BaseSection> implements RankProjectContract.Presenter<RankProjectModel, RankProjectView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int LOGIN_FOR_FAVORITE = 4097;
    @Nullable
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public RankProjectPresenter(@Nullable RankProjectView rankProjectView, @Nullable String str, @Nullable w9 w9Var) {
        super(rankProjectView, str, w9Var);
    }

    private final RankCityValue getRankCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931249391")) {
            return (RankCityValue) ipChange.ipc$dispatch("931249391", new Object[]{this});
        }
        w9 context = getContext();
        if (context == null || context.getContainer() == null) {
            return new RankCityValue(d20.c(), d20.d());
        }
        Object containerValue = context.getContainer().getContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, new RankCityIdTarget());
        k21.h(containerValue, "{\n                contex…          )\n            }");
        return (RankCityValue) containerValue;
    }

    private final RankFilterValue getRankFilterValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653849500")) {
            return (RankFilterValue) ipChange.ipc$dispatch("-1653849500", new Object[]{this});
        }
        w9 context = getContext();
        if (context == null || context.getContainer() == null) {
            return new RankFilterValue(null, null);
        }
        Object containerValue = context.getContainer().getContainerValue(ValueKey.KEY_RANK_SQUARE_FILTER_INFO, new RankFilterTarget());
        k21.h(containerValue, "{\n                contex…          )\n            }");
        return (RankFilterValue) containerValue;
    }

    private final Map<String, String> getUtArgs(RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788897322")) {
            return (Map) ipChange.ipc$dispatch("-788897322", new Object[]{this, rankItemBean});
        }
        HashMap<String, String> g = a03.g();
        a03.h(g, "city", getRankCity().cityName);
        k21.f(rankItemBean);
        a03.h(g, za.CNT_CONTENT_ID, rankItemBean.rankId);
        a03.h(g, "item_id", rankItemBean.id + "");
        a03.h(g, "titlelabel", getRankFilterValue().weiDuTabName);
        k21.h(g, "map");
        return g;
    }

    private final String getUtD(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821320612")) {
            return (String) ipChange.ipc$dispatch("-1821320612", new Object[]{this, Integer.valueOf(i)});
        }
        return "category_" + getRankFilterValue().mainTabIndex + "_dimension_" + getRankFilterValue().subTabIndex + "_item_" + i;
    }

    private final void navToProjcet(RankItemBean rankItemBean, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995275543")) {
            ipChange.ipc$dispatch("1995275543", new Object[]{this, rankItemBean, map});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IssueConstants.ProjectID, rankItemBean.id + "");
        bundle.putString("projectName", rankItemBean.name);
        bundle.putString("projectImage", rankItemBean.headPic);
        RankInfo rankInfo = new RankInfo();
        rankInfo.setId(rankItemBean.rankId);
        rankInfo.setName(rankItemBean.rankName);
        rankInfo.setOrder(rankItemBean.order + "");
        bundle.putParcelable("rankInfo", rankInfo);
        tb2.a(getContext().getActivity(), rankItemBean.schema, bundle);
    }

    private final void navToRepro(RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004131895")) {
            ipChange.ipc$dispatch("-2004131895", new Object[]{this, rankItemBean});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RepertoireDetailFragment.REPERTOIREID, rankItemBean.id + "");
        NavProxy.from(getContext().getActivity()).withExtras(bundle).toUri(INavUri.page(wz1.REPERTOITE));
    }

    @Override // cn.damai.tetris.component.rank.RankProjectContract.Presenter
    public void itemClick(@Nullable RankProjectView rankProjectView, @Nullable RankItemBean rankItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005673970")) {
            ipChange.ipc$dispatch("1005673970", new Object[]{this, rankProjectView, rankItemBean, Integer.valueOf(i)});
            return;
        }
        w9 context = getContext();
        if (rankItemBean != null && context != null) {
            userTrack(TrackType.click, null, ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", getUtD(i), getUtArgs(rankItemBean), true);
            if (rankItemBean.id > 0 && getContext().getActivity() != null) {
                if (rankItemBean.type != 99) {
                    TrackInfo trackInfo = this.mTrackInfo;
                    k21.f(trackInfo);
                    Map<String, String> argsMap = trackInfo.getArgsMap();
                    k21.h(argsMap, "mTrackInfo!!.argsMap");
                    navToProjcet(rankItemBean, argsMap);
                    return;
                }
                navToRepro(rankItemBean);
            }
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661325749")) {
            ipChange.ipc$dispatch("-1661325749", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.rank.RankProjectContract.Presenter
    public void wantSeeClick(@Nullable RankProjectView rankProjectView, @Nullable RankItemBean rankItemBean, int i, @NotNull FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727876435")) {
            ipChange.ipc$dispatch("727876435", new Object[]{this, rankProjectView, rankItemBean, Integer.valueOf(i), followDataBean});
            return;
        }
        k21.i(followDataBean, "followDataBean");
        userTrack(TrackType.click, null, ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", "like", getUtArgs(rankItemBean), true);
        if (followDataBean.getStatus() > 0) {
            followDataBean.tempRank = rankItemBean;
            sendMsg(new Message(24, followDataBean));
        }
    }

    public void init(@NotNull RankProjectModel rankProjectModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657156849")) {
            ipChange.ipc$dispatch("1657156849", new Object[]{this, rankProjectModel});
            return;
        }
        k21.i(rankProjectModel, "rankModel");
        this.mTrackInfo = rankProjectModel.getTrackInfo();
        RankItemBean bean = rankProjectModel.getBean();
        RankProjectView rankProjectView = (RankProjectView) getView();
        k21.f(rankProjectView);
        k21.f(bean);
        rankProjectView.setData(bean, bean.index);
        if (NotePresenter.isTrackInfoValid(this.mTrackInfo)) {
            TrackType trackType = TrackType.expose;
            userTrack(trackType, rankProjectView.getRootView(), ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", getUtD(bean.index), getUtArgs(bean), true);
            userTrack(trackType, rankProjectView.getRootView(), ((RankProjectModel) this.mModel).getTrackInfo().trackB, "list", "like", getUtArgs(bean), true);
        }
    }
}
