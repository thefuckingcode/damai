package cn.damai.commonbusiness.banner.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PageVipInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String expiryHour;
    public String reduceMoney;
    public String showActivity;
    public String targetUrl;

    public boolean isShowVipInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-365367402")) {
            return !TextUtils.isEmpty(this.showActivity) && "true".equals(this.showActivity);
        }
        return ((Boolean) ipChange.ipc$dispatch("-365367402", new Object[]{this})).booleanValue();
    }
}
