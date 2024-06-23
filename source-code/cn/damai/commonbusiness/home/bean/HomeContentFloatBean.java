package cn.damai.commonbusiness.home.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.s41;

/* compiled from: Taobao */
public class HomeContentFloatBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HIGH_LIGHT_CARD_JSON = "high_light_card_json";
    public String data;
    public String msg;
    public String pic;
    public String target;

    /* compiled from: Taobao */
    public static class Data implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String id;
        public String type;

        public boolean isValid() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2092514523")) {
                return !TextUtils.isEmpty(this.type) && !TextUtils.isEmpty(this.id);
            }
            return ((Boolean) ipChange.ipc$dispatch("2092514523", new Object[]{this})).booleanValue();
        }
    }

    @Nullable
    public static TabExtraBean getValidBean(JSONObject jSONObject) {
        Data data2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246907493")) {
            return (TabExtraBean) ipChange.ipc$dispatch("-1246907493", new Object[]{jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        HomeContentFloatBean homeContentFloatBean = (HomeContentFloatBean) s41.d(jSONObject, HomeContentFloatBean.class);
        if (TextUtils.isEmpty(homeContentFloatBean.data) || (data2 = (Data) s41.a(homeContentFloatBean.data, Data.class)) == null || !data2.isValid()) {
            return null;
        }
        TabExtraBean tabExtraBean = new TabExtraBean();
        tabExtraBean.iconUrl = homeContentFloatBean.pic;
        tabExtraBean.msg = homeContentFloatBean.msg;
        tabExtraBean.mFind = data2;
        return tabExtraBean;
    }
}
