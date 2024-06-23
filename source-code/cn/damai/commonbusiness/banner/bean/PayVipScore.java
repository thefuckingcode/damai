package cn.damai.commonbusiness.banner.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class PayVipScore implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bindAuthorization;
    public String id;
    public int memberFlag;
    public boolean memberThreshold;
    public String oriScore;
    public String primaryContent;
    public String secondaryContent;

    public boolean isEmpty() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-249966570")) {
            return TextUtils.isEmpty(this.oriScore) || "0".equals(this.oriScore);
        }
        return ((Boolean) ipChange.ipc$dispatch("-249966570", new Object[]{this})).booleanValue();
    }

    public boolean isUnbind() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-429130343")) {
            return "0".equals(this.bindAuthorization);
        }
        return ((Boolean) ipChange.ipc$dispatch("-429130343", new Object[]{this})).booleanValue();
    }

    public boolean isbindAuth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2043343702")) {
            return "2".equals(this.bindAuthorization);
        }
        return ((Boolean) ipChange.ipc$dispatch("-2043343702", new Object[]{this})).booleanValue();
    }

    public boolean isbindNotAuth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1040636933")) {
            return "1".equals(this.bindAuthorization);
        }
        return ((Boolean) ipChange.ipc$dispatch("1040636933", new Object[]{this})).booleanValue();
    }
}
