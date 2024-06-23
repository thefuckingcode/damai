package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.bricks.bean.HomeProjectItemBean;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alibaba.pictures.bricks.onearch.TrackType;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ca1;
import tb.eb0;
import tb.ex0;
import tb.k21;

/* compiled from: Taobao */
public final class HomeProjectItemPresent extends AbsPresenter<GenericItem<ItemValue>, HomeProjectItemModel, HomeProjectItemView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeProjectItemPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-3$lambda-2  reason: not valid java name */
    public static final void m102init$lambda3$lambda2(TextView textView, HomeProjectItemPresent homeProjectItemPresent, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036083143")) {
            ipChange.ipc$dispatch("2036083143", new Object[]{textView, homeProjectItemPresent, view});
            return;
        }
        k21.i(textView, "$this_apply");
        k21.i(homeProjectItemPresent, "this$0");
        textView.setTag(((HomeProjectItemBean) ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue()).id);
        homeProjectItemPresent.requestToFollow(!((HomeProjectItemBean) ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue()).followState(), ((HomeProjectItemBean) ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue()).id);
    }

    private final void requestToFollow(boolean z, String str) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754274060")) {
            ipChange.ipc$dispatch("-1754274060", new Object[]{this, Boolean.valueOf(z), str});
        } else if (DoloresLoginHandler.Companion.a().c()) {
            FollowUpdateRequest followUpdateRequest = new FollowUpdateRequest();
            followUpdateRequest.init(z, str);
            eb0.a(followUpdateRequest).doOnKTStart(HomeProjectItemPresent$requestToFollow$2.INSTANCE).doOnKTSuccess(new HomeProjectItemPresent$requestToFollow$3(this)).doOnKTFail(HomeProjectItemPresent$requestToFollow$4.INSTANCE);
            Map<String, Action> actions = getActions();
            TrackInfo trackInfo = (actions == null || (action = actions.get("wantSee")) == null) ? null : action.getTrackInfo();
            if (trackInfo != null) {
                String str2 = z ? "0" : "1";
                HashMap<String, String> args = trackInfo.getArgs();
                if (args != null) {
                    args.put("type", str2);
                }
                userTrack(TrackType.click, ((HomeProjectItemView) getView()).getMWantSeeBtn(), trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), trackInfo.getArgs(), false);
            }
        } else {
            GenericFragment fragment = ((GenericItem) getItem()).getPageContext().getFragment();
            if (fragment != null) {
                ca1.Companion.d(fragment, 10);
            }
        }
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Action action;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "373702619")) {
            ipChange.ipc$dispatch("373702619", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        Object value = ((HomeProjectItemModel) getModel()).getValue();
        k21.h(value, "model.value");
        ((HomeProjectItemView) getView()).bindView((HomeProjectItemBean) value);
        TextView mWantSeeBtn = ((HomeProjectItemView) getView()).getMWantSeeBtn();
        if (mWantSeeBtn != null) {
            if (mWantSeeBtn.getVisibility() != 0) {
                z = false;
            }
            TrackInfo trackInfo = null;
            if (!z) {
                mWantSeeBtn = null;
            }
            if (mWantSeeBtn != null) {
                Map<String, Action> actions = getActions();
                if (!(actions == null || (action = actions.get("wantSee")) == null)) {
                    trackInfo = action.getTrackInfo();
                }
                if (trackInfo != null) {
                    String str = !((HomeProjectItemBean) ((HomeProjectItemModel) getModel()).getValue()).followState() ? "0" : "1";
                    HashMap<String, String> args = trackInfo.getArgs();
                    if (args != null) {
                        args.put("type", str);
                    }
                    userTrack(TrackType.expose, ((HomeProjectItemView) getView()).getMWantSeeBtn(), trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), trackInfo.getArgs(), false);
                }
                mWantSeeBtn.setOnClickListener(new ex0(mWantSeeBtn, this));
            }
        }
    }
}
