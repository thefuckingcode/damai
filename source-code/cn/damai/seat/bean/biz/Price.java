package cn.damai.seat.bean.biz;

import android.graphics.Color;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPrice;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import tb.f92;
import tb.xf2;

/* compiled from: Taobao */
public class Price implements PriceLevel, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String color;
    private int colorInt = -1;
    public float dashPrice;
    public String mktPromotionText;
    public long priceId;
    private String priceText;
    public String priceTitle;
    public int priceType;
    public Tag promotionTag;
    public boolean salable;
    public float salePrice;
    public long skuId;
    private HashSet<Long> subPriceIdSet;
    public List<SubPrice> subPriceList;
    public List<PriceTag> tags;

    public Price() {
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public int colorInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507122791")) {
            return ((Integer) ipChange.ipc$dispatch("-507122791", new Object[]{this})).intValue();
        }
        int i = this.colorInt;
        if (i != -1) {
            return i;
        }
        try {
            this.colorInt = Color.parseColor(this.color);
        } catch (Exception unused) {
            this.colorInt = Color.parseColor("#FF0000");
        }
        return this.colorInt;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458925837")) {
            return ((Boolean) ipChange.ipc$dispatch("-458925837", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof PriceLevel)) {
            return super.equals(obj);
        } else {
            if (this.priceId == ((PriceLevel) obj).getPriceId()) {
                return true;
            }
            return false;
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    @Nullable
    public String getDiscountTip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "220400722")) {
            return this.mktPromotionText;
        }
        return (String) ipChange.ipc$dispatch("220400722", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public long getPriceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1511411048")) {
            return this.priceId;
        }
        return ((Long) ipChange.ipc$dispatch("-1511411048", new Object[]{this})).longValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public String getPriceTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "179559757")) {
            return this.priceTitle;
        }
        return (String) ipChange.ipc$dispatch("179559757", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public int getPriceType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1074996632")) {
            return this.priceType;
        }
        return ((Integer) ipChange.ipc$dispatch("1074996632", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public String getShowPriceText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925532049")) {
            return (String) ipChange.ipc$dispatch("925532049", new Object[]{this});
        }
        if (this.priceText == null) {
            this.priceText = "¥" + xf2.d(this.dashPrice);
        }
        return this.priceText;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public long getSkuId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-961164284")) {
            return this.skuId;
        }
        return ((Long) ipChange.ipc$dispatch("-961164284", new Object[]{this})).longValue();
    }

    @Nullable
    public SubPrice getSubPrice(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986218956")) {
            return (SubPrice) ipChange.ipc$dispatch("1986218956", new Object[]{this, Long.valueOf(j)});
        } else if (f92.d(this.subPriceList)) {
            return null;
        } else {
            for (SubPrice subPrice : this.subPriceList) {
                if (subPrice.priceId == j) {
                    return subPrice;
                }
            }
            return null;
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public HashSet<Long> getSubPriceIds() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083711318")) {
            return (HashSet) ipChange.ipc$dispatch("2083711318", new Object[]{this});
        }
        if (this.subPriceIdSet == null) {
            this.subPriceIdSet = new HashSet<>();
            if (!f92.d(this.subPriceList)) {
                for (SubPrice subPrice : this.subPriceList) {
                    this.subPriceIdSet.add(Long.valueOf(subPrice.priceId));
                }
            }
        }
        return this.subPriceIdSet;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public List<SubPrice> getSubPriceList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "927438860")) {
            return this.subPriceList;
        }
        return (List) ipChange.ipc$dispatch("927438860", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    @Nullable
    public String getTagDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1014640967")) {
            return (String) ipChange.ipc$dispatch("-1014640967", new Object[]{this, str});
        }
        PriceTag priceTag = PriceTag.get(this.tags, str);
        if (priceTag != null) {
            return priceTag.tagDesc;
        }
        return null;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public boolean isFreeCombineTiaoPiao() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-201164855")) {
            return this.priceType == 2;
        }
        return ((Boolean) ipChange.ipc$dispatch("-201164855", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public boolean isSalable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1397319022")) {
            return this.salable;
        }
        return ((Boolean) ipChange.ipc$dispatch("1397319022", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public boolean isSinglePrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-856948059")) {
            return this.priceType == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-856948059", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public boolean isTaoPiao() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "122151773")) {
            return this.priceType == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("122151773", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public float originalPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1023088816")) {
            return this.dashPrice;
        }
        return ((Float) ipChange.ipc$dispatch("-1023088816", new Object[]{this})).floatValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel
    public float skuPriceValue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "645975939")) {
            return this.salePrice;
        }
        return ((Float) ipChange.ipc$dispatch("645975939", new Object[]{this})).floatValue();
    }

    public Price(SkuPrice skuPrice) {
        this.priceId = skuPrice.priceId;
        this.skuId = skuPrice.skuId;
    }

    public Price(PriceBean priceBean) {
        this.priceId = priceBean.priceId;
        this.skuId = priceBean.skuId;
    }
}
