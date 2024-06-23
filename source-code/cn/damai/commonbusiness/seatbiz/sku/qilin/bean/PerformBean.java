package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ep1;
import tb.f92;

/* compiled from: Taobao */
public class PerformBean extends PromotionTag {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 730211245219904615L;
    public boolean buyPermission;
    public int chooseSeatType;
    public boolean hasFreePackage;
    public boolean hasPromotion;
    public int limitQuantity;
    public String performBeginDTStr;
    public String performDesc;
    public long performId;
    public String performName;
    public boolean performSalable;
    public String performTimeDetailStr;
    public boolean presale;
    public int saleForm;
    public String seatImg;
    public List<PriceBean> skuList;

    public boolean containSkuId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30840493")) {
            return ((Boolean) ipChange.ipc$dispatch("-30840493", new Object[]{this, Long.valueOf(j)})).booleanValue();
        }
        if (!f92.d(this.skuList)) {
            for (PriceBean priceBean : this.skuList) {
                if (priceBean.skuId == j) {
                    return true;
                }
            }
        }
        return false;
    }

    public long getXorPerformId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1940773106")) {
            return ep1.a(this.performId);
        }
        return ((Long) ipChange.ipc$dispatch("-1940773106", new Object[]{this})).longValue();
    }
}
