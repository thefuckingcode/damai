package tb;

import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class tt0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(List<OrderDetailPriceInfo> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1186151224")) {
            return ((Integer) ipChange.ipc$dispatch("1186151224", new Object[]{list})).intValue();
        }
        if (!f92.d(list)) {
            for (OrderDetailPriceInfo orderDetailPriceInfo : list) {
                i += Integer.parseInt(orderDetailPriceInfo.buyQuantity);
            }
        }
        return i;
    }
}
