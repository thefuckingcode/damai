package com.youku.live.arch.theadpool;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class PriorityRunnable implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int priority;

    public PriorityRunnable() {
        this.priority = 2;
    }

    public int getPriority() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-402672924")) {
            return this.priority;
        }
        return ((Integer) ipChange.ipc$dispatch("-402672924", new Object[]{this})).intValue();
    }

    public PriorityRunnable(int i) {
        this.priority = i;
    }
}
