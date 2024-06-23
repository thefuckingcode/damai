package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class WrapFirstGuideBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String firstMemberGuideUrl;
    public String tipType;

    public WrapFirstGuideBean(String str, String str2) {
        this.tipType = str;
        this.firstMemberGuideUrl = str2;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-973080850")) {
            return !TextUtils.isEmpty(this.tipType) && !TextUtils.isEmpty(this.firstMemberGuideUrl);
        }
        return ((Boolean) ipChange.ipc$dispatch("-973080850", new Object[]{this})).booleanValue();
    }
}
