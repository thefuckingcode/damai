package com.youku.live.livesdk.model.mtop.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class LivePlayShowData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int NORMAL = 1;
    public static final int STOP = 2;
    public long createTime;
    public int id;
    public int playStatus;
    public int sort;
    public long startTime;
    public String startTimeFormat;
    public String vid;
    public String videoImg;
    public int videoLengthSeconds;
    public String videoTitle;

    public boolean isPlay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1819391486")) {
            return this.playStatus == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("1819391486", new Object[]{this})).booleanValue();
    }
}
