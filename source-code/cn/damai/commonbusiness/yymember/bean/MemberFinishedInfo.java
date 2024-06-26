package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class MemberFinishedInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String avatar;
    public String gifUrl;
    public String memberFlag;
    public String profitImageUrl;
    public String showTimes;
    public String userNick;

    public boolean isValid4FinishDialog() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "719000009")) {
            return !TextUtils.isEmpty(this.profitImageUrl) && !TextUtils.isEmpty(this.userNick);
        }
        return ((Boolean) ipChange.ipc$dispatch("719000009", new Object[]{this})).booleanValue();
    }
}
