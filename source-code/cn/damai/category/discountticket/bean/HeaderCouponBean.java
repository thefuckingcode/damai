package cn.damai.category.discountticket.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.q80;

/* compiled from: Taobao */
public class HeaderCouponBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CouponActivityBean> couponActivities;
    public String desc;
    public String h5Url;
    public String title;

    public HeaderCouponBean() {
    }

    public int pos(CouponActivityBean couponActivityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208505077")) {
            return ((Integer) ipChange.ipc$dispatch("208505077", new Object[]{this, couponActivityBean})).intValue();
        } else if (q80.b(this.couponActivities) || couponActivityBean == null) {
            return -1;
        } else {
            return this.couponActivities.indexOf(couponActivityBean);
        }
    }

    public HeaderCouponBean(String str, String str2, String str3, List<CouponActivityBean> list) {
        this.title = str;
        this.desc = str2;
        this.h5Url = str3;
        this.couponActivities = list;
    }
}
