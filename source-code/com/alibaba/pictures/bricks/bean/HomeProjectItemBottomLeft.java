package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class HomeProjectItemBottomLeft extends HomepageMarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange;
    public String value;
    public String valueType;

    public boolean isFormatAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1012038466")) {
            return "FORMAT".equals(this.valueType);
        }
        return ((Boolean) ipChange.ipc$dispatch("1012038466", new Object[]{this})).booleanValue();
    }
}
