package cn.damai.tetris.component.rank;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.tetris.component.rank.RankSelectContract;
import cn.damai.tetris.component.rank.bean.RankCityIdTarget;
import cn.damai.tetris.component.rank.bean.RankCityValue;
import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.container.ValueKey;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a03;
import tb.d20;
import tb.k21;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public final class RankSelectPresenter extends BasePresenter<RankSelectModel, RankSelectView, BaseSection> implements RankSelectContract.Presenter<RankSelectModel, RankSelectView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public RankSelectPresenter(@Nullable RankSelectView rankSelectView, @Nullable String str, @Nullable w9 w9Var) {
        super(rankSelectView, str, w9Var);
    }

    private final RankCityValue getRankCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529729410")) {
            return (RankCityValue) ipChange.ipc$dispatch("-1529729410", new Object[]{this});
        }
        w9 context = getContext();
        if (context == null || context.getContainer() == null) {
            return new RankCityValue(d20.c(), d20.d());
        }
        Object containerValue = context.getContainer().getContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, new RankCityIdTarget());
        k21.h(containerValue, "{\n                contex…          )\n            }");
        return (RankCityValue) containerValue;
    }

    @Override // cn.damai.tetris.component.rank.RankSelectContract.Presenter
    public void expose(@Nullable View view, @Nullable RankSelectItemBean rankSelectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070638447")) {
            ipChange.ipc$dispatch("-1070638447", new Object[]{this, view, rankSelectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = a03.g();
        a03.h(g, "city", getRankCity().cityName);
        String str = null;
        a03.h(g, "titlelabel", rankSelectItemBean != null ? rankSelectItemBean.shortName : null);
        if (rankSelectItemBean != null) {
            str = rankSelectItemBean.id;
        }
        a03.h(g, za.CNT_CONTENT_ID, str);
        TrackType trackType = TrackType.expose;
        k21.f(view);
        View rootView = view.getRootView();
        String str2 = ((RankSelectModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, rootView, str2, "theme_ranklist", "item_" + i, g, true);
    }

    @Override // cn.damai.tetris.component.rank.RankSelectContract.Presenter
    public void itemClick(@Nullable RankSelectView rankSelectView, @Nullable RankSelectItemBean rankSelectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761329312")) {
            ipChange.ipc$dispatch("761329312", new Object[]{this, rankSelectView, rankSelectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = a03.g();
        a03.h(g, "city", getRankCity().cityName);
        k21.f(rankSelectItemBean);
        a03.h(g, "titlelabel", rankSelectItemBean.shortName);
        a03.h(g, za.CNT_CONTENT_ID, rankSelectItemBean.id);
        TrackType trackType = TrackType.click;
        String str = ((RankSelectModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, null, str, "theme_ranklist", "item_" + i, g, true);
        try {
            Bundle bundle = new Bundle();
            String str2 = rankSelectItemBean.id;
            k21.f(str2);
            bundle.putLong(RankListFragment.KEY_RANK_ID, Long.parseLong(str2));
            bundle.putString("cityId", getRankCity().cityId);
            DMNav.from(getContext().getActivity().getBaseContext()).withExtras(bundle).toUri(NavUri.b("ranking"));
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e("RankSelectPresenter", message);
            }
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25406756")) {
            ipChange.ipc$dispatch("-25406756", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(@NotNull RankSelectModel rankSelectModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857787181")) {
            ipChange.ipc$dispatch("-1857787181", new Object[]{this, rankSelectModel});
            return;
        }
        k21.i(rankSelectModel, "dramaWorthSeeModel");
        RankSelectBean bean = rankSelectModel.getBean();
        IView view = getView();
        k21.f(view);
        ((RankSelectView) view).setData(bean, 0);
    }
}
