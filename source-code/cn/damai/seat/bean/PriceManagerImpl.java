package cn.damai.seat.bean;

import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.seat.bean.biz.Price;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class PriceManagerImpl implements IPriceManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private final LongSparseArray<PriceLine> mPid2PriceLineMap = new LongSparseArray<>();
    private final LongSparseArray<PriceLevel> mPid2PriceSkuIdMap = new LongSparseArray<>();
    private final LongSparseArray<PriceLevel> mPid2SalablePackagePriceLevelMap = new LongSparseArray<>();
    private final LongSparseArray<PriceLine> mPid2SalablePriceLineMap = new LongSparseArray<>();
    private final List<Price> mPriceList;

    public PriceManagerImpl(List<Price> list) {
        this.mPriceList = list;
        if (!f92.d(list)) {
            for (Price price : list) {
                if (price.isSalable()) {
                    if (price.isTaoPiao()) {
                        this.mPid2SalablePackagePriceLevelMap.put(price.getPriceId(), price);
                    } else if (price.isFreeCombineTiaoPiao()) {
                        List<SubPrice> subPriceList = price.getSubPriceList();
                        if (!f92.d(subPriceList)) {
                            for (SubPrice subPrice : subPriceList) {
                                this.mPid2SalablePriceLineMap.put(subPrice.getPriceId(), subPrice);
                            }
                        }
                    } else {
                        this.mPid2SalablePriceLineMap.put(price.getPriceId(), price);
                    }
                }
                if (price.isFreeCombineTiaoPiao()) {
                    List<SubPrice> subPriceList2 = price.getSubPriceList();
                    if (!f92.d(subPriceList2)) {
                        for (SubPrice subPrice2 : subPriceList2) {
                            this.mPid2PriceLineMap.put(subPrice2.getPriceId(), subPrice2);
                        }
                    }
                } else {
                    this.mPid2PriceLineMap.put(price.getPriceId(), price);
                }
                this.mPid2PriceSkuIdMap.put(price.getPriceId(), price);
            }
        }
    }

    public static IPriceManager emptyManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "400395223") ? (IPriceManager) ipChange.ipc$dispatch("400395223", new Object[0]) : new PriceManagerImpl(null);
    }

    @Override // cn.damai.seat.bean.IPriceManager
    @Nullable
    public PriceLevel findSalablePackagePriceLevel(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1664087372")) {
            return this.mPid2SalablePackagePriceLevelMap.get(j);
        }
        return (PriceLevel) ipChange.ipc$dispatch("1664087372", new Object[]{this, Long.valueOf(j)});
    }

    @Override // cn.damai.seat.bean.IPriceManager
    @Nullable
    public PriceLine findSalablePriceLine(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "834028622")) {
            return this.mPid2SalablePriceLineMap.get(j);
        }
        return (PriceLine) ipChange.ipc$dispatch("834028622", new Object[]{this, Long.valueOf(j)});
    }

    @Override // cn.damai.seat.bean.IPriceManager
    public Price firstPriceLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328660826")) {
            return (Price) ipChange.ipc$dispatch("328660826", new Object[]{this});
        } else if (!f92.d(this.mPriceList)) {
            return this.mPriceList.get(0);
        } else {
            return null;
        }
    }

    @Override // cn.damai.seat.bean.IPriceManager
    public long getBuySkuId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1611155815")) {
            return ((Long) ipChange.ipc$dispatch("1611155815", new Object[]{this, Long.valueOf(j)})).longValue();
        }
        PriceLevel priceLevel = this.mPid2PriceSkuIdMap.get(j);
        if (priceLevel != null) {
            return priceLevel.getSkuId();
        }
        return -1;
    }

    @Override // cn.damai.seat.bean.IPriceManager
    public List<Price> getFullPriceList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1209785768")) {
            return this.mPriceList;
        }
        return (List) ipChange.ipc$dispatch("-1209785768", new Object[]{this});
    }

    @Override // cn.damai.seat.bean.IPriceManager
    public LongSparseArray<PriceLine> getPid2PriceLineMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1047447332")) {
            return this.mPid2PriceLineMap;
        }
        return (LongSparseArray) ipChange.ipc$dispatch("-1047447332", new Object[]{this});
    }
}
