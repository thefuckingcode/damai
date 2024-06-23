package com.alibaba.pictures.bricks.component.scriptmurder;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoContract;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.wm2;

/* compiled from: Taobao */
public final class ShopInfoPresent extends AbsPresenter<GenericItem<ItemValue>, ShopInfoModel, ShopInfoView> implements ShopInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACTION_KEY_REPORT = "report";
    @NotNull
    public static final String ACTION_KEY_SHARE = "share";
    @NotNull
    public static final String ACTION_TO_AUTH = "certification";
    @NotNull
    public static final String ACTION_TO_CALL = "telephone";
    @NotNull
    public static final String ACTION_TO_EVALUATE = "score";
    @NotNull
    public static final String ACTION_TO_MAP = "map";
    @NotNull
    public static final String ACTION_TO_SHOP_INFO = "detail";
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
    public static final class b implements ShopInfoViewHolder.OnShopInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShopInfoPresent a;
        final /* synthetic */ GenericItem<ItemValue> b;

        /* compiled from: Taobao */
        public static final class a implements BottomActionDialog.OnActionListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Activity a;
            final /* synthetic */ Ref$ObjectRef<Action> b;
            final /* synthetic */ View c;

            a(Activity activity, Ref$ObjectRef<Action> ref$ObjectRef, View view) {
                this.a = activity;
                this.b = ref$ObjectRef;
                this.c = view;
            }

            @Override // com.alibaba.pictures.bricks.view.BottomActionDialog.OnActionListener
            public void onClick(@NotNull BottomAction bottomAction, @NotNull View view, @NotNull Dialog dialog) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-601845616")) {
                    ipChange.ipc$dispatch("-601845616", new Object[]{this, bottomAction, view, dialog});
                    return;
                }
                k21.i(bottomAction, "action");
                k21.i(view, "v");
                k21.i(dialog, "dialog");
                dialog.dismiss();
                wm2.INSTANCE.h(this.a, bottomAction.getExtra());
                T t = this.b.element;
                if (t != null) {
                    View view2 = this.c;
                    TrackInfo trackInfo = t.getTrackInfo();
                    if (trackInfo != null) {
                        k21.h(trackInfo, "trackInfo");
                        UserTrackProviderProxy.click(view2, trackInfo, true);
                    }
                }
            }
        }

        b(ShopInfoPresent shopInfoPresent, GenericItem<ItemValue> genericItem) {
            this.a = shopInfoPresent;
            this.b = genericItem;
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onEvaluateEntranceBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-708776908")) {
                ipChange.ipc$dispatch("-708776908", new Object[]{this, view, shopInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(shopInfoBean, "bean");
            this.a.dispatchActionQueryClick(this.b, "score", view);
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopAuthBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2101819579")) {
                ipChange.ipc$dispatch("-2101819579", new Object[]{this, view, shopInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(shopInfoBean, "bean");
            this.a.dispatchActionQueryClick(this.b, ShopInfoPresent.ACTION_TO_AUTH, view);
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopInfoEntranceClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1010243949")) {
                ipChange.ipc$dispatch("1010243949", new Object[]{this, view, shopInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(shopInfoBean, "bean");
            if (shopInfoBean.isShopOpened()) {
                this.a.dispatchActionQueryClick(this.b, "detail", view);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopInfoViewExpose(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1552947102")) {
                ipChange.ipc$dispatch("-1552947102", new Object[]{this, view, shopInfoBean});
                return;
            }
            k21.i(view, "itemView");
            k21.i(shopInfoBean, "bean");
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopMapBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "74160457")) {
                ipChange.ipc$dispatch("74160457", new Object[]{this, view, shopInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(shopInfoBean, "bean");
            this.a.dispatchActionQueryClick(this.b, "map", view);
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopPhoneBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1064953993")) {
                ipChange.ipc$dispatch("-1064953993", new Object[]{this, view, shopInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(shopInfoBean, "bean");
            Activity activity = this.b.getPageContext().getActivity();
            if (activity != null) {
                ShopInfoPresent shopInfoPresent = this.a;
                if (!activity.isFinishing()) {
                    ArrayList<BottomAction> arrayList = null;
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    T t = (T) shopInfoPresent.getAction("telephone");
                    if (t != null) {
                        ref$ObjectRef.element = t;
                        arrayList = wm2.INSTANCE.a(t.getActionUrl());
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z = false;
                    }
                    ArrayList<BottomAction> callActionList = z ? shopInfoBean.getCallActionList() : arrayList;
                    if (callActionList != null) {
                        new BottomActionDialog(activity, callActionList, new a(activity, ref$ObjectRef, view), 0, 8, null).show();
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopInfoPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void dispatchActionQueryClick(GenericItem<ItemValue> genericItem, String str, View view) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209466605")) {
            ipChange.ipc$dispatch("209466605", new Object[]{this, genericItem, str, view});
            return;
        }
        Activity activity = genericItem.getPageContext().getActivity();
        if (activity != null && (action = getAction(str)) != null) {
            TrackInfo trackInfo = action.getTrackInfo();
            if (trackInfo != null) {
                k21.h(trackInfo, "trackInfo");
                UserTrackProviderProxy.click(view, trackInfo, true);
            }
            NavProviderProxy.getProxy().toUri(activity, action);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-884965791")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-884965791", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-272811564")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-272811564", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-127968236")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-127968236", new Object[]{this})).booleanValue();
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031219899")) {
            ipChange.ipc$dispatch("1031219899", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        ShopInfoViewHolder viewHolder = ((ShopInfoView) getView()).getViewHolder();
        viewHolder.l(new b(this, genericItem));
        viewHolder.k((ShopInfoBean) ((ShopInfoModel) getModel()).getValue());
        HashMap hashMap = new HashMap();
        hashMap.put("value", ((ShopInfoModel) getModel()).getValue());
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
