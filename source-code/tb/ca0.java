package tb;

import android.text.TextUtils;
import cn.damai.ultron.net.UltronPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.ut.mini.UTAnalytics;

/* compiled from: Taobao */
public class ca0 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    public ca0() {
        a();
    }

    @Override // tb.va
    public void h(jn2 jn2) {
        JSONObject parseObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628738099")) {
            ipChange.ipc$dispatch("628738099", new Object[]{this, jn2});
            return;
        }
        IDMComponent e = ha0.e(this.c);
        if (e != null) {
            JSONObject fields = e.getFields();
            if (fields != null) {
                String string = fields.getString("extraAttributes");
                if (!TextUtils.isEmpty(string) && (parseObject = JSON.parseObject(string)) != null) {
                    Object obj = null;
                    try {
                        obj = UTAnalytics.getInstance().getDefaultTracker().getGlobalProperty("utm");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (obj != null) {
                        parseObject.put("utm", obj);
                        i(e, parseObject.getInnerMap());
                        this.c.getDataManager().respondToLinkage(e);
                    }
                }
            }
            ((UltronPresenter) this.c).createOrder();
        }
    }
}
