package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class tm1 extends xg1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String BIZ_ID = "damai";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TEMPLATE_ID = "damai_script_order_list_cell";
    @NotNull
    public static final String VERSION = "";
    @Nullable
    private JSONObject e;
    @Nullable
    private Object f;
    @Nullable
    private String g;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tm1(@NotNull Context context, @Nullable JSONObject jSONObject) {
        super(context, "damai", TEMPLATE_ID, null);
        String str;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        String str2 = null;
        this.e = jSONObject;
        Object obj = jSONObject != null ? jSONObject.get("pageType") : null;
        this.f = obj;
        if (obj != null) {
            if (k21.d(obj, 0)) {
                str = "all";
            } else if (k21.d(obj, 1)) {
                str = "unused";
            } else {
                str = k21.d(obj, 2) ? "unpay" : "";
            }
            str2 = str;
        }
        this.g = str2;
    }

    @Override // tb.yg1
    public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        Object obj2;
        String obj3;
        String obj4;
        String obj5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237401496")) {
            ipChange.ipc$dispatch("-237401496", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        k21.i(jSONObject, "data");
        JSONObject data = eventParams.getData();
        if (data != null && (obj = data.get("eventName")) != null) {
            Action action = new Action();
            action.setActionType(1);
            if (k21.d(obj, "item")) {
                Object obj6 = jSONObject.get("detailUrl");
                if (obj6 != null && (obj5 = obj6.toString()) != null) {
                    action.setActionUrl(obj5);
                    NavProviderProxy.getProxy().toUri(b(), action);
                    vm1 vm1 = vm1.INSTANCE;
                    Object obj7 = jSONObject.get("orderId");
                    vm1.f(null, obj7 != null ? obj7.toString() : null, i, this.g);
                }
            } else if (k21.d(obj, "store_detail_action")) {
                Object obj8 = jSONObject.get("shopDetailUrl");
                if (obj8 != null && (obj4 = obj8.toString()) != null) {
                    action.setActionUrl(obj4);
                    NavProviderProxy.getProxy().toUri(b(), action);
                }
            } else if (k21.d(obj, "bottom_btn_action") && (obj2 = jSONObject.get("commentJumpUrl")) != null && (obj3 = obj2.toString()) != null) {
                action.setActionUrl(obj3);
                NavProviderProxy.getProxy().toUri(b(), action);
                if (k21.d("1", jSONObject.get(p21.ISSUE_PARAM_COMMENT_TYPE))) {
                    vm1 vm12 = vm1.INSTANCE;
                    Object obj9 = jSONObject.get("orderId");
                    vm12.d(null, obj9 != null ? obj9.toString() : null, i, this.g);
                } else if (k21.d("2", jSONObject.get(p21.ISSUE_PARAM_COMMENT_TYPE))) {
                    vm1 vm13 = vm1.INSTANCE;
                    Object obj10 = jSONObject.get("orderId");
                    vm13.b(null, obj10 != null ? obj10.toString() : null, i, this.g);
                }
            }
        }
    }

    @Override // tb.yg1
    public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658825766")) {
            ipChange.ipc$dispatch("-1658825766", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(jSONObject, "data");
    }

    @Override // tb.yg1, tb.xg1
    public void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939423853")) {
            ipChange.ipc$dispatch("-1939423853", new Object[]{this, trackParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(trackParams, "trackParams");
        k21.i(jSONObject, "data");
        if (k21.d("btn_status", trackParams.getViewId())) {
            String str = null;
            if (k21.d("1", jSONObject.get(p21.ISSUE_PARAM_COMMENT_TYPE))) {
                vm1 vm1 = vm1.INSTANCE;
                View view = trackParams.getView();
                Object obj = jSONObject.get("orderId");
                if (obj != null) {
                    str = obj.toString();
                }
                vm1.e(view, str, i, this.g);
            } else if (k21.d("2", jSONObject.get(p21.ISSUE_PARAM_COMMENT_TYPE))) {
                vm1 vm12 = vm1.INSTANCE;
                View view2 = trackParams.getView();
                Object obj2 = jSONObject.get("orderId");
                if (obj2 != null) {
                    str = obj2.toString();
                }
                vm12.c(view2, str, i, this.g);
            }
        }
    }
}
