package tb;

import android.text.TextUtils;
import cn.damai.ultron.view.activity.DMUltronPayDetailBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;

/* compiled from: Taobao */
public class p90 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    private void m(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104989263")) {
            ipChange.ipc$dispatch("1104989263", new Object[]{this, iDMComponent});
            return;
        }
        JSONObject fields = iDMComponent != null ? iDMComponent.getFields() : null;
        if (fields != null) {
            String string = fields.getString("payDetail");
            if (!TextUtils.isEmpty(string)) {
                DMUltronPayDetailBean dMUltronPayDetailBean = (DMUltronPayDetailBean) JSON.parseObject(string, DMUltronPayDetailBean.class);
                dMUltronPayDetailBean.status = "false";
                HashMap hashMap = new HashMap();
                hashMap.put("payDetail", JSON.toJSON(dMUltronPayDetailBean));
                i(iDMComponent, hashMap);
                this.c.getDataManager().respondToLinkage(iDMComponent);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1144050078")) {
            ipChange.ipc$dispatch("-1144050078", new Object[]{this, jn2});
            return;
        }
        m(ha0.h(this.c));
    }
}
