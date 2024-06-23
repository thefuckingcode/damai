package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import cn.damai.common.bean.MemberAuthDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class GuideInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public MemberAuthDetail detail;
    public String memberStatus;
    public String title;

    public boolean isValid4DailyBind() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-44269050")) {
            return !TextUtils.isEmpty(this.memberStatus) && this.detail != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("-44269050", new Object[]{this})).booleanValue();
    }
}
