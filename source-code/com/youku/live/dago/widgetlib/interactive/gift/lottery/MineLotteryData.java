package com.youku.live.dago.widgetlib.interactive.gift.lottery;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MineLotteryData {
    private static transient /* synthetic */ IpChange $ipChange;
    public String actorName;
    public boolean isPushMsg;
    public boolean isThirdView = false;
    public boolean isViewer = false;
    public int lotteryCount;
    public int lotteryTimes;
    public String roomId;
    private String viewerName;

    public MineLotteryData() {
    }

    public String getActorName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1732079868")) {
            return this.actorName;
        }
        return (String) ipChange.ipc$dispatch("-1732079868", new Object[]{this});
    }

    public int getLotteryCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1409546949")) {
            return this.lotteryCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-1409546949", new Object[]{this})).intValue();
    }

    public int getLotteryTimes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1180995492")) {
            return this.lotteryTimes;
        }
        return ((Integer) ipChange.ipc$dispatch("1180995492", new Object[]{this})).intValue();
    }

    public String getRoomId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-438857304")) {
            return this.roomId;
        }
        return (String) ipChange.ipc$dispatch("-438857304", new Object[]{this});
    }

    public String getViwerName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "984378592")) {
            return this.viewerName;
        }
        return (String) ipChange.ipc$dispatch("984378592", new Object[]{this});
    }

    public boolean isPushMsg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1489314091")) {
            return this.isPushMsg;
        }
        return ((Boolean) ipChange.ipc$dispatch("1489314091", new Object[]{this})).booleanValue();
    }

    public boolean isThirdView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1762085414")) {
            return this.isThirdView;
        }
        return ((Boolean) ipChange.ipc$dispatch("1762085414", new Object[]{this})).booleanValue();
    }

    public boolean isViewer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-872822802")) {
            return this.isViewer;
        }
        return ((Boolean) ipChange.ipc$dispatch("-872822802", new Object[]{this})).booleanValue();
    }

    public void setLotteryCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004986823")) {
            ipChange.ipc$dispatch("2004986823", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.lotteryCount = i;
    }

    public void setLotteryTimes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707423870")) {
            ipChange.ipc$dispatch("707423870", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.lotteryTimes = i;
    }

    public void setThirdView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833941988")) {
            ipChange.ipc$dispatch("-833941988", new Object[]{this});
            return;
        }
        this.isThirdView = true;
    }

    public void setViewer(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1799855452")) {
            ipChange.ipc$dispatch("-1799855452", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isViewer = z;
    }

    public void setViewerName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846272687")) {
            ipChange.ipc$dispatch("846272687", new Object[]{this, str});
            return;
        }
        this.viewerName = str;
    }

    public MineLotteryData(int i, int i2) {
        this.lotteryTimes = i;
        this.lotteryCount = i2;
        this.isPushMsg = false;
    }

    public MineLotteryData(int i, String str, String str2, String str3) {
        this.lotteryTimes = i;
        this.isPushMsg = true;
        this.viewerName = str;
        this.actorName = str2;
        this.lotteryCount = 1;
        this.roomId = str3;
    }
}
