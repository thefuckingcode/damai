package com.alibaba.pictures.bricks.component.scriptcoupon;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoContract;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ir1;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class CouponInfoPresent extends AbsPresenter<GenericItem<ItemValue>, CouponInfoModel, CouponInfoView> implements CouponInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACTION_KEY_SHARE = "share";
    @NotNull
    public static final String BANNER_HIDDEN = "0";
    @NotNull
    public static final String BANNER_SHOW = "1";
    @NotNull
    private static final String BANNER_STATUS = "BannerStatus";
    @NotNull
    public static final String CHANGE_BAR_EVENT = "EventBus://business/BannerStatus";
    public static final int COUPON_TOP_BANNER_TYPE = 7521;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String NO_BANNER = "-1";
    @NotNull
    private String currentBannerStatus = "";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements CouponInfoViewHolder.OnScriptCouponInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder.OnScriptCouponInfoListener
        public void onScriptCouponMoreBtnClick(@NotNull View view, @NotNull CouponInfoBean couponInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1220751361")) {
                ipChange.ipc$dispatch("1220751361", new Object[]{this, view, couponInfoBean});
                return;
            }
            k21.i(view, "view");
            k21.i(couponInfoBean, "bean");
            List<TicketNote> serviceNoteList = couponInfoBean.getServiceNoteList();
            if (serviceNoteList != null) {
                new ir1().d(view, serviceNoteList, "服务说明");
            }
        }

        @Override // com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder.OnScriptCouponInfoListener
        public void onScriptCouponViewExpose(@NotNull View view, @NotNull CouponInfoBean couponInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1432314489")) {
                ipChange.ipc$dispatch("1432314489", new Object[]{this, view, couponInfoBean});
                return;
            }
            k21.i(view, "itemView");
            k21.i(couponInfoBean, "bean");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponInfoPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public final void disPatch(@NotNull String str, @NotNull HashMap<String, Object> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766547663")) {
            ipChange.ipc$dispatch("1766547663", new Object[]{this, str, hashMap});
            return;
        }
        k21.i(str, "msg");
        k21.i(hashMap, "arg");
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, hashMap);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "704376592")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("704376592", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1394427133")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1394427133", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-538312507")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-538312507", new Object[]{this})).booleanValue();
    }

    @NotNull
    public final String getCurrentBannerStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1268954189")) {
            return this.currentBannerStatus;
        }
        return (String) ipChange.ipc$dispatch("1268954189", new Object[]{this});
    }

    public final void setCurrentBannerStatus(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1937403703")) {
            ipChange.ipc$dispatch("-1937403703", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.currentBannerStatus = str;
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Action action;
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38073236")) {
            ipChange.ipc$dispatch("-38073236", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        CouponInfoViewHolder viewHolder = ((CouponInfoView) getView()).getViewHolder();
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        for (T t : genericItem.getComponent().getModule().getComponents()) {
            if (t.getType() == 7521) {
                List<IItem<ItemValue>> items = t.getItems();
                if (!(items == null || items.isEmpty())) {
                    ref$BooleanRef.element = true;
                }
            }
        }
        if (!ref$BooleanRef.element && !k21.d(this.currentBannerStatus, "-1")) {
            HashMap<String, Object> hashMap = new HashMap<>();
            this.currentBannerStatus = "-1";
            hashMap.put("bannerStatus", "-1");
            disPatch(CHANGE_BAR_EVENT, hashMap);
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        Bundle bundle = genericItem.getPageContext().getBundle();
        if (bundle != null) {
            ref$IntRef.element = Integer.valueOf(bundle.getInt("offset")).intValue();
        }
        if (!ref$BooleanRef.element) {
            viewHolder.e(ref$IntRef.element);
        } else {
            viewHolder.e(0);
        }
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        if (!(fragment == null || (recyclerView = fragment.getRecyclerView()) == null)) {
            recyclerView.addOnScrollListener(new CouponInfoPresent$init$3(ref$IntRef, ref$BooleanRef, viewHolder, this, genericItem));
        }
        viewHolder.d(new b());
        viewHolder.b((CouponInfoBean) ((CouponInfoModel) getModel()).getValue());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("value", ((CouponInfoModel) getModel()).getValue());
        Map<String, Action> actions = getActions();
        if (!(actions == null || (action = actions.get("share")) == null)) {
            hashMap2.put("share", action);
        }
        EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent("EventBus://business/notification/scriptMurder/get_header_info", hashMap2);
        }
    }
}
