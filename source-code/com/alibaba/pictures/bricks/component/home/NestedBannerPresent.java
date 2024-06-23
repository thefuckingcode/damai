package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.onearch.adapter.view.GenericViewCard;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.wm2;

/* compiled from: Taobao */
public final class NestedBannerPresent extends AbsPresenter<GenericItem<ItemValue>, NestedBannerModel, NestedBannerView> implements OnBannerListener {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static final class a extends TypeReference<HashMap<String, Action>> {
        a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedBannerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final HashMap<String, Action> getActions(NestedBannerBean nestedBannerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263394102")) {
            return (HashMap) ipChange.ipc$dispatch("-1263394102", new Object[]{this, nestedBannerBean});
        }
        try {
            JSONObject jSONObject = nestedBannerBean.action;
            if (jSONObject != null) {
                return (HashMap) JSON.parseObject(jSONObject.toJSONString(), new a(), new Feature[0]);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Action getItemAction(NestedBannerBean nestedBannerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666077732")) {
            return (Action) ipChange.ipc$dispatch("-666077732", new Object[]{this, nestedBannerBean});
        }
        try {
            HashMap<String, Action> actions = getActions(nestedBannerBean);
            if (actions != null) {
                return actions.get("item");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045445051")) {
            return ((Boolean) ipChange.ipc$dispatch("2045445051", new Object[]{this})).booleanValue();
        } else if (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) {
            return false;
        } else {
            return true;
        }
    }

    private final void setScreenModeIfScreenChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447827879")) {
            ipChange.ipc$dispatch("-447827879", new Object[]{this});
            return;
        }
        boolean isLargeScreenMode = isLargeScreenMode();
        if (isLargeScreenMode != ((NestedBannerView) getView()).isLargeScreenMode()) {
            ((NestedBannerView) getView()).setScreenMode(isLargeScreenMode);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1515991170")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1515991170", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-509658330")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-509658330", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
    public void onBannerItemClick(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1925842507")) {
            ipChange.ipc$dispatch("-1925842507", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "view");
        k21.i(nestedBannerBean, "bean");
        Activity activity = ((GenericItem) getItem()).getPageContext().getActivity();
        if (activity != null) {
            GenericViewCard genericViewCard = nestedBannerBean.temp;
            if ((genericViewCard != null ? genericViewCard.getItemAction() : null) != null) {
                genericViewCard.onItemClick(view);
                return;
            }
            Action itemAction = getItemAction(nestedBannerBean);
            if (itemAction != null) {
                NavProviderProxy.getProxy().toUri(activity, itemAction);
                TrackInfo trackInfo = itemAction.getTrackInfo();
                if (trackInfo != null) {
                    k21.h(trackInfo, "trackInfo");
                    if (trackInfo.getSpmd() != null) {
                        String spmd = trackInfo.getSpmd();
                        k21.h(spmd, "spmd");
                        if (o.v(spmd, JSMethod.NOT_SET, false, 2, null)) {
                            trackInfo.setSpmd(trackInfo.getSpmd() + i);
                        }
                    }
                    UserTrackProviderProxy.click(view, trackInfo, true);
                }
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
    public void onBannerViewExpose(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
        TrackInfo trackInfo;
        Action itemAction;
        TrackInfo trackInfo2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102120701")) {
            ipChange.ipc$dispatch("-102120701", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "view");
        k21.i(nestedBannerBean, "bean");
        GenericViewCard genericViewCard = nestedBannerBean.temp;
        if ((genericViewCard != null ? genericViewCard.getItemAction() : null) != null) {
            GenericViewCard genericViewCard2 = nestedBannerBean.temp;
            if (genericViewCard2 != null && (itemAction = genericViewCard2.getItemAction()) != null && (trackInfo2 = itemAction.getTrackInfo()) != null) {
                k21.h(trackInfo2, "trackInfo");
                UserTrackProviderProxy.expose(view, trackInfo2);
                return;
            }
            return;
        }
        Action itemAction2 = getItemAction(nestedBannerBean);
        if (itemAction2 != null && (trackInfo = itemAction2.getTrackInfo()) != null) {
            k21.h(trackInfo, "trackInfo");
            if (trackInfo.getSpmd() != null) {
                String spmd = trackInfo.getSpmd();
                k21.h(spmd, "spmd");
                if (o.v(spmd, JSMethod.NOT_SET, false, 2, null)) {
                    trackInfo.setSpmd(trackInfo.getSpmd() + i);
                }
            }
            UserTrackProviderProxy.expose(view, trackInfo);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter
    public void responsiveLayoutStateChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "359975938")) {
            ipChange.ipc$dispatch("359975938", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.responsiveLayoutStateChanged(z);
        setScreenModeIfScreenChanged();
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        List<DATA> list;
        Node node;
        JSONObject data;
        NestedBannerBean nestedBannerBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2016375757")) {
            ipChange.ipc$dispatch("2016375757", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = genericItem.getComponent().getInnerAdapter();
        if (!(innerAdapter == null || (list = innerAdapter.data) == null)) {
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (!(!(t instanceof GenericItem) || (node = t.getNode()) == null || node.getType() != 7538 || (data = node.getData()) == null || (nestedBannerBean = (NestedBannerBean) wm2.INSTANCE.j(data, NestedBannerBean.class)) == null)) {
                    try {
                        HashMap<String, Action> actions = getActions(nestedBannerBean);
                        if (actions != null) {
                            nestedBannerBean.temp = new GenericViewCard(this, t, actions, null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    arrayList.add(nestedBannerBean);
                }
            }
            ((NestedBannerView) getView()).setMBannerListener(this);
            setScreenModeIfScreenChanged();
            ((NestedBannerView) getView()).bind(arrayList);
        }
    }
}
