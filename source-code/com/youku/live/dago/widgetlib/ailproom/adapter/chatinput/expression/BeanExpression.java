package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BeanExpression {
    private static transient /* synthetic */ IpChange $ipChange;
    private String RealName = "";
    private String ResName = "";

    public BeanExpression() {
    }

    public String getRealName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1306303757")) {
            return this.RealName;
        }
        return (String) ipChange.ipc$dispatch("1306303757", new Object[]{this});
    }

    public String getResName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1873453565")) {
            return this.ResName;
        }
        return (String) ipChange.ipc$dispatch("1873453565", new Object[]{this});
    }

    public void setRealName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958382961")) {
            ipChange.ipc$dispatch("1958382961", new Object[]{this, str});
            return;
        }
        this.RealName = str;
    }

    public void setResName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626232089")) {
            ipChange.ipc$dispatch("626232089", new Object[]{this, str});
            return;
        }
        this.ResName = str;
    }

    public BeanExpression(String str, String str2) {
        this.ResName = str;
        this.RealName = str2;
    }
}
