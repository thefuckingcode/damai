package tb;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerformBase;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class n72 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public static SeatPreloadExtra a(long j, ProjectStaticDataBean projectStaticDataBean, ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025341154")) {
            return (SeatPreloadExtra) ipChange.ipc$dispatch("-1025341154", new Object[]{Long.valueOf(j), projectStaticDataBean, projectItemDataBean});
        }
        if (!(projectStaticDataBean == null || projectItemDataBean == null)) {
            try {
                if (projectStaticDataBean.getItemBase() != null) {
                    List<SkuPerformBase> performBases = projectItemDataBean.getPerformBases();
                    if (f92.d(performBases)) {
                        return null;
                    }
                    List<SkuPerform> performs = performBases.get(0).getPerforms();
                    if (f92.d(performs)) {
                        return null;
                    }
                    SkuPerform skuPerform = performs.get(0);
                    if (skuPerform.chooseSeatType != 1) {
                        return null;
                    }
                    return new SeatPreloadExtra(17, j, skuPerform.performId, projectStaticDataBean.getItemBase().getNationalStandardCityId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
