package cn.damai.category.discountticket.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class CouponListRes {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CouponActivityBean> couponActivities;

    public boolean hasCoupons() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1594889399")) {
            return xf2.e(this.couponActivities) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1594889399", new Object[]{this})).booleanValue();
    }
}
