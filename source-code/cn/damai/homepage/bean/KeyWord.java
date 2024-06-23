package cn.damai.homepage.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class KeyWord {
    private static transient /* synthetic */ IpChange $ipChange;
    public String alg;
    public String comboDispatchId;
    public String comboDispatchSystem;
    String keyword;

    public String getKeyword() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1314023922")) {
            return this.keyword;
        }
        return (String) ipChange.ipc$dispatch("-1314023922", new Object[]{this});
    }

    public void setKeyword(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598677800")) {
            ipChange.ipc$dispatch("598677800", new Object[]{this, str});
            return;
        }
        this.keyword = str;
    }
}
