package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ThemeBean extends Extra {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentCount;
    public String desc;
    public String id;
    public String ipvuv;
    public String name;
    public String pic;
    public String themePrize;

    public boolean hasPrize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1461551807")) {
            return TextUtils.equals("1", this.themePrize);
        }
        return ((Boolean) ipChange.ipc$dispatch("1461551807", new Object[]{this})).booleanValue();
    }
}
