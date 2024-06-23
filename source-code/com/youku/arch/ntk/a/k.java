package com.youku.arch.ntk.a;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.i63;

/* compiled from: Taobao */
public class k {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = "bandwidth")
    public String a;
    @JSONField(name = "cmdConnectionTime")
    public String b;
    @JSONField(name = "id")
    public String c;
    @JSONField(name = "task_id")
    public String d;
    @JSONField(name = "url")
    public String e;
    @JSONField(name = TbAuthConstants.IP)
    public String f;
    @JSONField(name = "detail")
    public String g;
    @JSONField(name = "error_code")
    public String h;
    @JSONField(name = "ruleId")
    public String i;

    public void a(i63 i63) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207343547")) {
            ipChange.ipc$dispatch("207343547", new Object[]{this, i63});
            return;
        }
        this.a = "" + i63.h;
        this.b = "" + i63.n;
        this.c = i63.b;
        this.d = "" + i63.d;
        this.e = i63.e;
        this.f = i63.f;
        this.g = JSON.toJSONString(i63.i);
        this.h = "" + i63.a;
        this.i = i63.c;
    }
}
