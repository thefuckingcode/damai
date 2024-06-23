package tb;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
public class n90 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    private void m(JSONObject jSONObject) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40869911")) {
            ipChange.ipc$dispatch("40869911", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            if (jSONObject.containsKey("richTextUrl")) {
                JSONArray jSONArray = jSONObject.getJSONArray("richTextUrl");
                if (jSONArray.size() > 0) {
                    str = jSONArray.get(0).toString();
                    if (TextUtils.isEmpty(str)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("url", str);
                        DMNav.from(this.b).withExtras(bundle).toUri("damai://webview");
                        return;
                    }
                    return;
                }
            }
            str = "";
            if (TextUtils.isEmpty(str)) {
            }
        }
    }

    private void n(IDMComponent iDMComponent) {
        String tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898020568")) {
            ipChange.ipc$dispatch("-898020568", new Object[]{this, iDMComponent});
        } else if (iDMComponent != null && (tag = iDMComponent.getTag()) != null && tag.equals("dmProtocol")) {
            m(iDMComponent.getFields());
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306229795")) {
            ipChange.ipc$dispatch("1306229795", new Object[]{this, jn2});
        } else if (jn2 != null) {
            n(jn2.a());
        }
    }
}
