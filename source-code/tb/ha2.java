package tb;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import cn.damai.commonbusiness.scriptmurder.bean.GaiaXEventTelephone;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.alibaba.pictures.bricks.gaiaxholder.UtParam;
import com.alibaba.pictures.bricks.gaiaxholder.UtType;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProvider;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IStable;
import com.youku.gaiax.api.data.EventParams;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ha2 extends y0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static final class a implements BottomActionDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // com.alibaba.pictures.bricks.view.BottomActionDialog.OnActionListener
        public void onClick(@NotNull BottomAction bottomAction, @NotNull View view, @NotNull Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1575413735")) {
                ipChange.ipc$dispatch("-1575413735", new Object[]{this, bottomAction, view, dialog});
                return;
            }
            k21.i(bottomAction, "action");
            k21.i(view, "v");
            k21.i(dialog, "dialog");
            wm2.INSTANCE.h(this.a, bottomAction.getExtra());
        }
    }

    public ha2() {
        super("damai", "damai_script_play_apply_store");
    }

    private final void h(String str, boolean z, GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        UtParam generate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480661417")) {
            ipChange.ipc$dispatch("-480661417", new Object[]{this, str, Boolean.valueOf(z), gaiaXUtParamsGenerator});
        } else if (gaiaXUtParamsGenerator != null && (generate = gaiaXUtParamsGenerator.generate(UtType.click, b(), c(), str)) != null) {
            qm1.INSTANCE.q(generate, z);
        }
    }

    @Override // tb.y0
    public void e(@NotNull View view, @NotNull Activity activity, @NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        ShopInfoBean shopInfoBean;
        JSONObject data;
        Object obj;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2070260784")) {
            ipChange.ipc$dispatch("-2070260784", new Object[]{this, view, activity, eventParams, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        k21.i(view, "itemView");
        k21.i(activity, "activity");
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        if (!activity.isFinishing() && jSONObject != null && (shopInfoBean = (ShopInfoBean) wm2.INSTANCE.j(jSONObject, ShopInfoBean.class)) != null && (data = eventParams.getData()) != null && (obj = data.get("eventName")) != null) {
            if (k21.d(GaiaXEventTelephone.GAIAX_TELEPHONES_EVENT, obj) || k21.d("telephone", obj)) {
                h("UT_APPLY_STORE_CALL_CLICK", false, gaiaXUtParamsGenerator);
                new BottomActionDialog(activity, shopInfoBean.getCallActionList(), new a(activity), 0, 8, null).show();
            } else if (k21.d("map", obj)) {
                String mapUrl = shopInfoBean.getMapUrl();
                if (mapUrl == null || (o.y(mapUrl))) {
                    z = true;
                }
                if (!z) {
                    h("UT_APPLY_STORE_ADDR_CLICK", true, gaiaXUtParamsGenerator);
                    NavProvider proxy = NavProviderProxy.getProxy();
                    Action action = new Action();
                    action.setActionType(1);
                    action.setActionUrl(shopInfoBean.getMapUrl());
                    ur2 ur2 = ur2.INSTANCE;
                    proxy.toUri(activity, action);
                }
            }
        }
    }

    @Override // tb.y0
    public void f(@NotNull View view, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        String id;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281631595")) {
            ipChange.ipc$dispatch("281631595", new Object[]{this, view, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        k21.i(view, "itemView");
        k21.i(activity, "activity");
        ShopInfoBean shopInfoBean = (ShopInfoBean) wm2.INSTANCE.j(jSONObject, ShopInfoBean.class);
        if (shopInfoBean != null && (id = shopInfoBean.getId()) != null) {
            Action action = new Action();
            action.setActionUrl("damai://V1/ScriptPlay?storeId=" + id);
            action.setActionType(1);
            NavProviderProxy.getProxy().toUri(activity, action);
        }
    }

    @Override // tb.y0
    public void g(@NotNull GaiaX.Params params, @NotNull View view, @NotNull View view2, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        View findViewById;
        UtParam generate;
        View findViewById2;
        UtParam generate2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1326405177")) {
            ipChange.ipc$dispatch("-1326405177", new Object[]{this, params, view, view2, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        k21.i(params, "params");
        k21.i(view, "resultView");
        k21.i(view2, "itemView");
        k21.i(activity, "activity");
        try {
            GaiaX.Companion companion = GaiaX.Companion;
            IStable stable = companion.getInstance().stable();
            if (!(stable == null || (findViewById2 = stable.findViewById(params, "loc_holder")) == null || gaiaXUtParamsGenerator == null || (generate2 = gaiaXUtParamsGenerator.generate(UtType.expose, b(), c(), "UT_APPLY_STORE_ADDR_EXPOSE")) == null)) {
                qm1.INSTANCE.d(findViewById2, generate2);
            }
            IStable stable2 = companion.getInstance().stable();
            if (stable2 != null && (findViewById = stable2.findViewById(params, "tele_holder")) != null && gaiaXUtParamsGenerator != null && (generate = gaiaXUtParamsGenerator.generate(UtType.expose, b(), c(), "UT_APPLY_STORE_CALL_EXPOSE")) != null) {
                qm1.INSTANCE.d(findViewById, generate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
