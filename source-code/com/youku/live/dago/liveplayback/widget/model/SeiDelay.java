package com.youku.live.dago.liveplayback.widget.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SeiDelay {
    private static transient /* synthetic */ IpChange $ipChange;
    public String localTimestamp = "0";
    public long mDelay = 0;
    public long ntpOffset;
    public String seiTimestamp = "0";

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50604938")) {
            ipChange.ipc$dispatch("-50604938", new Object[]{this});
            return;
        }
        this.mDelay = 0;
        this.seiTimestamp = "0";
        this.ntpOffset = 0;
        this.localTimestamp = "0";
    }
}
