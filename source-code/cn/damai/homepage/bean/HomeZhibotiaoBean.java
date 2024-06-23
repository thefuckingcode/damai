package cn.damai.homepage.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.s41;

/* compiled from: Taobao */
public class HomeZhibotiaoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3618090976100965132L;
    public String artistHeadPic;
    public String itemId;
    public String itemName;
    public String schema;

    public static HomeZhibotiaoBean getValidBean(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604007820")) {
            return (HomeZhibotiaoBean) ipChange.ipc$dispatch("-1604007820", new Object[]{jSONObject});
        } else if (jSONObject != null) {
            return (HomeZhibotiaoBean) s41.d(jSONObject, HomeZhibotiaoBean.class);
        } else {
            return null;
        }
    }
}
