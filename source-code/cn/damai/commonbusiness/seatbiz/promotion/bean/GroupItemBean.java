package cn.damai.commonbusiness.seatbiz.promotion.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class GroupItemBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<String> promotionContentList;
    public String promotionTag;
    public int promotionType;

    public boolean isWednesdayDiscount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-958076269")) {
            return 6 == this.promotionType;
        }
        return ((Boolean) ipChange.ipc$dispatch("-958076269", new Object[]{this})).booleanValue();
    }
}
