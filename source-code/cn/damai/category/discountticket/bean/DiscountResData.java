package cn.damai.category.discountticket.bean;

import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.biz.BannerBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class DiscountResData {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<BannerBean> bannerData;
    public CommonDiscountData commonDiscountData;
    public HeaderData headerData;
    public NearDiscountData nearDiscountData;

    @Nullable
    public ProjectItemBean getFirstProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-27088562")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("-27088562", new Object[]{this});
        }
        NearDiscountData nearDiscountData2 = this.nearDiscountData;
        if (nearDiscountData2 != null && xf2.e(nearDiscountData2.nearDiscountItems) > 0) {
            return this.nearDiscountData.nearDiscountItems.get(0);
        }
        CommonDiscountData commonDiscountData2 = this.commonDiscountData;
        if (commonDiscountData2 == null || xf2.e(commonDiscountData2.commonDiscountItems) <= 0) {
            return null;
        }
        return this.commonDiscountData.commonDiscountItems.get(0);
    }

    public int getUnNearProjectCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385897053")) {
            return ((Integer) ipChange.ipc$dispatch("1385897053", new Object[]{this})).intValue();
        }
        CommonDiscountData commonDiscountData2 = this.commonDiscountData;
        if (commonDiscountData2 != null) {
            return xf2.e(commonDiscountData2.commonDiscountItems);
        }
        return 0;
    }
}
