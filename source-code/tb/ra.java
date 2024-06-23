package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ra {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public static String a(PerformBean performBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1335938612")) {
            return (String) ipChange.ipc$dispatch("-1335938612", new Object[]{performBean});
        } else if (performBean == null || f92.d(performBean.skuList)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (PriceBean priceBean : performBean.skuList) {
                if (priceBean.buyPermission) {
                    sb.append(priceBean.skuId);
                    sb.append(",");
                }
            }
            if (sb.length() <= 0) {
                return null;
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    public static boolean b(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "445773331")) {
            return TextUtils.isEmpty(str) || "0".equals(str.trim());
        }
        return ((Boolean) ipChange.ipc$dispatch("445773331", new Object[]{str})).booleanValue();
    }
}
