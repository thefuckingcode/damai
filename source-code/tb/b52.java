package tb;

import android.content.Context;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class b52 extends xg1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b52(@NotNull Context context) {
        super(context, "damai", "damai_script_play_cell", null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // tb.yg1
    public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        ScriptBean scriptBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127068794")) {
            ipChange.ipc$dispatch("-1127068794", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        k21.i(jSONObject, "data");
        JSONObject data = eventParams.getData();
        if (data != null && (obj = data.get("eventName")) != null && k21.d("item", obj) && (scriptBean = (ScriptBean) s41.d(jSONObject, ScriptBean.class)) != null) {
            k21.h(scriptBean, "toJavaObject(data, ScriptBean::class.java)");
            DMNav from = DMNav.from(b());
            from.toUri("damai://V1/ScriptDetail?scriptId=" + scriptBean.getId());
        }
    }

    @Override // tb.yg1
    public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615673980")) {
            ipChange.ipc$dispatch("1615673980", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(jSONObject, "data");
    }
}
