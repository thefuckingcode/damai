package cn.damai.discover.content.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class FollowedUser implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String havanaIdStr;
    public String headImg;
    public boolean mySelf;
    public String nickName;

    public FollowedUser() {
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493671753")) {
            return ((Boolean) ipChange.ipc$dispatch("-493671753", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof FollowedUser) || !this.mySelf || !((FollowedUser) obj).mySelf) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "67814950")) {
            return !TextUtils.isEmpty(this.havanaIdStr);
        }
        return ((Boolean) ipChange.ipc$dispatch("67814950", new Object[]{this})).booleanValue();
    }

    public FollowedUser(String str, String str2, String str3) {
        this.headImg = str3;
        this.havanaIdStr = str2;
        this.mySelf = true;
    }
}
