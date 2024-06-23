package cn.damai.user.userhome.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ContentInfoBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private int contentCount;
    private int featureCount;
    private int recommendCount;

    public int getContentCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "83677280")) {
            return this.contentCount;
        }
        return ((Integer) ipChange.ipc$dispatch("83677280", new Object[]{this})).intValue();
    }

    public int getFeatureCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1834202659")) {
            return this.featureCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-1834202659", new Object[]{this})).intValue();
    }

    public int getRecommendCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1433747933")) {
            return this.recommendCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-1433747933", new Object[]{this})).intValue();
    }

    public void setContentCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1050297666")) {
            ipChange.ipc$dispatch("1050297666", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.contentCount = i;
    }

    public void setFeatureCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725561701")) {
            ipChange.ipc$dispatch("1725561701", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.featureCount = i;
    }

    public void setRecommendCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039727839")) {
            ipChange.ipc$dispatch("1039727839", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.recommendCount = i;
    }
}
