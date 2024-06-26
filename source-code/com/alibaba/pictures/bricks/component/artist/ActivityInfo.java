package com.alibaba.pictures.bricks.component.artist;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ActivityInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String activityId;
    public String couponId;
    public String picUrl;
    public String targetId;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-275227440")) {
            return !TextUtils.isEmpty(this.couponId);
        }
        return ((Boolean) ipChange.ipc$dispatch("-275227440", new Object[]{this})).booleanValue();
    }
}
