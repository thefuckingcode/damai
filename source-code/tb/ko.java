package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment;
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
public class ko extends xg1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String BIZ_ID = "damai";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String GAIAX_COUPON_PAYRESULT_NATIVE_URL = "nativeUrl";
    @NotNull
    public static final String TEMPLATE_ID = "damai_script_play_pay_result_item";
    @NotNull
    public static final String VERSION = "1";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ko(@NotNull Context context, @Nullable String str) {
        super(context, "damai", TEMPLATE_ID, "1");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // tb.yg1
    public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597334690")) {
            ipChange.ipc$dispatch("597334690", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        k21.i(jSONObject, "data");
        JSONObject data = eventParams.getData();
        if (data != null && (obj = data.get("eventName")) != null) {
            JSONObject data2 = eventParams.getData();
            Object obj2 = data2 != null ? data2.get(GAIAX_COUPON_PAYRESULT_NATIVE_URL) : null;
            k21.g(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            if (k21.d((String) obj, CouponPayResultFragment.HOME_CLICK)) {
                if (jSONObject != null) {
                    Action action = new Action();
                    action.setActionType(1);
                    action.setActionUrl(str);
                    bp1.INSTANCE.f(null);
                    NavProviderProxy.getProxy().toUri(b(), action);
                }
            } else if (jSONObject != null) {
                Action action2 = new Action();
                action2.setActionType(1);
                action2.setActionUrl(y3.INSTANCE.a(str, "CouponCreateOrderPage=true"));
                bp1.INSTANCE.d(null);
                NavProviderProxy.getProxy().toUri(b(), action2);
            }
        }
    }

    @Override // tb.yg1
    public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366038240")) {
            ipChange.ipc$dispatch("1366038240", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(jSONObject, "data");
    }

    @Override // tb.yg1, tb.xg1
    public void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70729319")) {
            ipChange.ipc$dispatch("-70729319", new Object[]{this, trackParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(trackParams, "trackParams");
        k21.i(jSONObject, "data");
        if (k21.d("home_btn", trackParams.getViewId())) {
            bp1.INSTANCE.g(trackParams.getView());
        } else if (k21.d("order_btn", trackParams.getViewId())) {
            bp1.INSTANCE.e(trackParams.getView());
        }
    }
}
