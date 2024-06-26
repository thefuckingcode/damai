package com.alibaba.pictures.bricks.component.scriptmurder;

import android.app.Activity;
import android.view.View;
import com.alibaba.pictures.bricks.bean.VenueInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoContract;
import com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoViewHolder;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class VenueInfoPresent extends AbsPresenter<GenericItem<ItemValue>, VenueInfoModel, VenueInfoView> implements VenueInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACTION_MAP = "map";
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements VenueInfoViewHolder.OnVenueInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ GenericItem<ItemValue> a;
        final /* synthetic */ VenueInfoPresent b;

        b(GenericItem<ItemValue> genericItem, VenueInfoPresent venueInfoPresent) {
            this.a = genericItem;
            this.b = venueInfoPresent;
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoViewHolder.OnVenueInfoListener
        public void onVenueMapClick(@NotNull View view, @NotNull VenueInfoBean venueInfoBean) {
            Action action;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "572942834")) {
                ipChange.ipc$dispatch("572942834", new Object[]{this, view, venueInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(venueInfoBean, "venueInfo");
            Activity activity = this.a.getPageContext().getActivity();
            if (activity != null && (action = this.b.getAction("map")) != null) {
                NavProviderProxy.getProxy().toUri(activity, action);
                TrackInfo trackInfo = action.getTrackInfo();
                if (trackInfo != null) {
                    k21.h(trackInfo, "trackInfo");
                    UserTrackProviderProxy.click(view, trackInfo, true);
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoViewHolder.OnVenueInfoListener
        public void onVenueViewExpose(@NotNull View view, @NotNull VenueInfoBean venueInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "151950959")) {
                ipChange.ipc$dispatch("151950959", new Object[]{this, view, venueInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(venueInfoBean, "venueInfo");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VenueInfoPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-178342818")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-178342818", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-744085167")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-744085167", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1852548041")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1852548041", new Object[]{this})).booleanValue();
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632901154")) {
            ipChange.ipc$dispatch("-632901154", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        VenueInfoViewHolder viewHolder = ((VenueInfoView) getView()).getViewHolder();
        viewHolder.d(new b(genericItem, this));
        viewHolder.c((VenueInfoBean) ((VenueInfoModel) getModel()).getValue());
        HashMap hashMap = new HashMap();
        hashMap.put("value", ((VenueInfoModel) getModel()).getValue());
        Map<String, Action> actions = getActions();
        if (actions != null) {
            Action action = actions.get("share");
            if (action != null) {
                hashMap.put("share", action);
            }
            Action action2 = actions.get("report");
            if (action2 != null) {
                hashMap.put("report", action2);
            }
        }
        EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent("EventBus://business/notification/scriptMurder/get_header_info", hashMap);
        }
    }
}
