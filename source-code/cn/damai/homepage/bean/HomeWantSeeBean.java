package cn.damai.homepage.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.s41;

/* compiled from: Taobao */
public class HomeWantSeeBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3618090976100965134L;
    public String projectId;
    public String schema;
    public String subTitle;
    public String title;
    public String titleSuffix;
    public String titleType;
    public String verticalPic;

    public static HomeWantSeeBean getValidBean(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071975052")) {
            return (HomeWantSeeBean) ipChange.ipc$dispatch("-2071975052", new Object[]{jSONObject});
        } else if (jSONObject != null) {
            return (HomeWantSeeBean) s41.d(jSONObject, HomeWantSeeBean.class);
        } else {
            return null;
        }
    }
}
