package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PraiseInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean hasPraised;
    private int praiseCount;

    public boolean getHasPraised() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "349795516")) {
            return this.hasPraised;
        }
        return ((Boolean) ipChange.ipc$dispatch("349795516", new Object[]{this})).booleanValue();
    }

    public int getPraiseCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1910423228")) {
            return this.praiseCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-1910423228", new Object[]{this})).intValue();
    }

    public void setHasPraised(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313619240")) {
            ipChange.ipc$dispatch("1313619240", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasPraised = z;
    }

    public void setPraiseCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826485574")) {
            ipChange.ipc$dispatch("1826485574", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.praiseCount = i;
    }
}
