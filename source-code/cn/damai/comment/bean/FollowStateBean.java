package cn.damai.comment.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class FollowStateBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String status;

    public boolean isFollowed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "856817891")) {
            return TextUtils.equals("1", this.status) || TextUtils.equals("2", this.status);
        }
        return ((Boolean) ipChange.ipc$dispatch("856817891", new Object[]{this})).booleanValue();
    }
}
