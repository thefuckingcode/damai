package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class ul1 extends xg1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnEventListener e;
    @Nullable
    private JSONObject f;
    @Nullable
    private String g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ul1(@NotNull Context context, @Nullable OnEventListener onEventListener, @Nullable JSONObject jSONObject) {
        super(context, "damai", "", null);
        Object obj;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        String str = null;
        this.e = onEventListener;
        this.f = jSONObject;
        if (!(jSONObject == null || (obj = jSONObject.get("itemId")) == null)) {
            str = obj.toString();
        }
        this.g = str;
    }

    @Override // tb.yg1
    public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        JSONObject data;
        Object obj2;
        Object obj3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338064297")) {
            ipChange.ipc$dispatch("338064297", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        k21.i(jSONObject, "data");
        JSONObject data2 = eventParams.getData();
        if (data2 != null && (obj = data2.get("eventName")) != null && k21.d("selectPaymentMethod", obj) && (data = eventParams.getData()) != null && (obj2 = data.get("selectIndex")) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject data3 = eventParams.getData();
                jSONObject2.put((Object) "payType", data3 != null ? data3.get("selectValue") : null);
                int parseInt = Integer.parseInt(obj2.toString());
                OnEventListener onEventListener = this.e;
                if (onEventListener != null) {
                    onEventListener.onEvent(CouponOrderConfirmFragment.EVENT_PAY_TYPE, null, jSONObject2);
                }
                vl1 vl1 = vl1.INSTANCE;
                String str = this.g;
                JSONObject data4 = eventParams.getData();
                vl1.f(null, str, (data4 == null || (obj3 = data4.get("selectValue")) == null) ? null : obj3.toString(), String.valueOf(parseInt));
            } catch (Exception unused) {
            }
        }
    }

    @Override // tb.yg1
    public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085605191")) {
            ipChange.ipc$dispatch("-2085605191", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(jSONObject, "data");
    }

    @Override // tb.yg1, tb.xg1
    public void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        Object obj2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28210418")) {
            ipChange.ipc$dispatch("28210418", new Object[]{this, trackParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(trackParams, "trackParams");
        k21.i(jSONObject, "data");
        String str = null;
        if (k21.d("payment_holder_0", trackParams.getViewId())) {
            vl1 vl1 = vl1.INSTANCE;
            View view = trackParams.getView();
            String str2 = this.g;
            JSONObject data = trackParams.getData();
            if (!(data == null || (obj2 = data.get("selectValue")) == null)) {
                str = obj2.toString();
            }
            vl1.g(view, str2, str, "0");
        } else if (k21.d("payment_holder_1", trackParams.getViewId())) {
            vl1 vl12 = vl1.INSTANCE;
            View view2 = trackParams.getView();
            String str3 = this.g;
            JSONObject data2 = trackParams.getData();
            if (!(data2 == null || (obj = data2.get("selectValue")) == null)) {
                str = obj.toString();
            }
            vl12.g(view2, str3, str, "1");
        }
    }
}
