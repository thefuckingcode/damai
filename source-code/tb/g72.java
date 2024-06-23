package tb;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketSubUiModel;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.SeatGroup;
import cn.damai.seat.bean.Tuple;
import cn.damai.seat.bean.biz.Price;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class g72 extends ra {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Comparator<SeatNew> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public int compare(SeatNew seatNew, SeatNew seatNew2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "324476982")) {
                return ((Integer) ipChange.ipc$dispatch("324476982", new Object[]{this, seatNew, seatNew2})).intValue();
            }
            return (seatNew.sid + "").compareTo(seatNew2.sid + "");
        }
    }

    public static boolean A(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280856987")) {
            return ((Boolean) ipChange.ipc$dispatch("-280856987", new Object[]{list})).booleanValue();
        }
        if (!f92.d(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (((PriceLevel) list.get(i)).isSalable()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Nullable
    public static PriceLevel B(List<? extends PriceLevel> list, PriceLevel priceLevel) {
        int indexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697391638")) {
            return (PriceLevel) ipChange.ipc$dispatch("-1697391638", new Object[]{list, priceLevel});
        }
        if (f92.d(list) || priceLevel == null || (indexOf = list.indexOf(priceLevel)) < 0) {
            return null;
        }
        PriceLevel priceLevel2 = (PriceLevel) list.get(indexOf);
        if (priceLevel2.isSalable()) {
            return priceLevel2;
        }
        return null;
    }

    @Nullable
    public static Region C(String str, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210951691")) {
            return (Region) ipChange.ipc$dispatch("-1210951691", new Object[]{str, regionData});
        } else if (regionData == null || !regionData.checkBaseValid()) {
            return null;
        } else {
            Iterator<Region> it = regionData.ri.regionList.iterator();
            while (it.hasNext()) {
                Region next = it.next();
                if (TextUtils.equals(next.id + "", str)) {
                    return next;
                }
            }
            return null;
        }
    }

    @Nullable
    public static PriceLevel D(long j) {
        PriceBean priceBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "255311013")) {
            return (PriceLevel) ipChange.ipc$dispatch("255311013", new Object[]{Long.valueOf(j)});
        }
        mi1 b = ni1.a().b(j);
        if (b == null || (priceBean = b.d) == null) {
            return null;
        }
        return new Price(priceBean);
    }

    public static List<PriceLevel> E(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052110230")) {
            return (List) ipChange.ipc$dispatch("-1052110230", new Object[]{list});
        }
        ArrayList arrayList = new ArrayList();
        if (!f92.d(list)) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static void F(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "100190936")) {
            ipChange.ipc$dispatch("100190936", new Object[]{textView, str});
            return;
        }
        textView.setText(str);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public static String G(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831734894")) {
            return (String) ipChange.ipc$dispatch("-1831734894", new Object[]{list});
        } else if (f92.d(list)) {
            return "";
        } else {
            ArrayList<SeatNew> arrayList = new ArrayList(list);
            Collections.sort(arrayList, new a());
            StringBuilder sb = new StringBuilder();
            for (SeatNew seatNew : arrayList) {
                sb.append(seatNew.sid);
            }
            return sb.toString();
        }
    }

    private static void H(List<SeatNew> list, PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050960700")) {
            ipChange.ipc$dispatch("-2050960700", new Object[]{list, priceLevel});
        } else if (!f92.d(list) && priceLevel != null) {
            List<SubPrice> subPriceList = priceLevel.getSubPriceList();
            if (!f92.d(subPriceList)) {
                Collections.sort(list, new mn1(subPriceList));
            }
        }
    }

    public static long c(long j, long j2) {
        PerformBean performBean;
        PriceBean priceBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895425427")) {
            return ((Long) ipChange.ipc$dispatch("1895425427", new Object[]{Long.valueOf(j), Long.valueOf(j2)})).longValue();
        }
        mi1 b = ni1.a().b(j);
        if (b == null || (performBean = b.c) == null || (priceBean = b.d) == null || performBean.performId != j2) {
            return -1;
        }
        List<PriceBean> list = performBean.skuList;
        if (f92.d(list)) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            long j3 = list.get(i).skuId;
            long j4 = priceBean.skuId;
            if (j3 == j4) {
                return j4;
            }
        }
        return -1;
    }

    public static double d(List<SeatNew> list) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899071885")) {
            return ((Double) ipChange.ipc$dispatch("899071885", new Object[]{list})).doubleValue();
        }
        double d = 0.0d;
        if (!f92.d(list)) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                SeatNew seatNew = list.get(i);
                if (!seatNew.isPackaged) {
                    f = seatNew.seatValue;
                } else if (!arrayList.contains(Long.valueOf(seatNew.packageCombinedId))) {
                    arrayList.add(Long.valueOf(seatNew.packageCombinedId));
                    f = seatNew.seatTaoPiaoValue;
                }
                d += (double) f;
            }
        }
        return d;
    }

    public static String e(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380444711")) {
            return (String) ipChange.ipc$dispatch("-380444711", new Object[]{list});
        } else if (f92.d(list)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (SeatNew seatNew : list) {
                long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
                sb.append(seatNew.kanTaiId);
                sb.append(JSMethod.NOT_SET);
                sb.append(seatNew.sid);
                sb.append(JSMethod.NOT_SET);
                sb.append(j);
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

    @Nullable
    public static List<SeatCalcParams> f(ArrayMap<String, ArrayList<SeatGroup>> arrayMap, LongSparseArray<PriceLine> longSparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101811277")) {
            return (List) ipChange.ipc$dispatch("-101811277", new Object[]{arrayMap, longSparseArray});
        } else if (f92.c(arrayMap)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < arrayMap.size(); i++) {
                ArrayList<SeatGroup> valueAt = arrayMap.valueAt(i);
                if (!f92.d(valueAt)) {
                    for (int i2 = 0; i2 < valueAt.size(); i2++) {
                        PriceLine priceLine = longSparseArray.get(valueAt.get(i2).priceId);
                        if (priceLine == null) {
                            return null;
                        }
                        SeatCalcParams seatCalcParams = new SeatCalcParams(priceLine.getPriceId() + "", (int) (priceLine.originalPrice() * 100.0f), 1);
                        int indexOf = arrayList.indexOf(seatCalcParams);
                        if (indexOf >= 0) {
                            ((SeatCalcParams) arrayList.get(indexOf)).count++;
                        } else {
                            arrayList.add(seatCalcParams);
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        }
    }

    @Nullable
    public static List<Region> g(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878597066")) {
            return (List) ipChange.ipc$dispatch("1878597066", new Object[]{list});
        } else if (!f92.d(list)) {
            return new ArrayList(list);
        } else {
            return null;
        }
    }

    public static List<PriceLevel> h(List<PriceLevel> list, Region region) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43046569")) {
            return (List) ipChange.ipc$dispatch("43046569", new Object[]{list, region});
        }
        if (!f92.d(list) && region != null && !f92.d(region.priceLevelIdList)) {
            Iterator<PriceLevel> it = list.iterator();
            while (it.hasNext()) {
                if (!region.priceLevelIdList.contains(Long.valueOf(it.next().getPriceId()))) {
                    it.remove();
                }
            }
        }
        return list;
    }

    private static Price i(List<Price> list, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1952433914")) {
            return (Price) ipChange.ipc$dispatch("1952433914", new Object[]{list, Long.valueOf(j)});
        } else if (f92.d(list)) {
            return null;
        } else {
            for (Price price : list) {
                if (price.getPriceId() == j) {
                    return price;
                }
            }
            return null;
        }
    }

    @Nullable
    public static Region j(RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683499067")) {
            return (Region) ipChange.ipc$dispatch("683499067", new Object[]{regionData});
        } else if (regionData == null || !regionData.checkBaseValid()) {
            return null;
        } else {
            return regionData.ri.regionList.get(0);
        }
    }

    public static long k(@Nullable TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285986281")) {
            return ((Long) ipChange.ipc$dispatch("-285986281", new Object[]{tbParams})).longValue();
        } else if (tbParams == null) {
            return -1;
        } else {
            return tbParams.itemId;
        }
    }

    @Nullable
    public static List<SeatNew> l(Map<Long, List<SeatNew>> map, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957817507")) {
            return (List) ipChange.ipc$dispatch("1957817507", new Object[]{map, Long.valueOf(j)});
        } else if (!f92.f(map)) {
            return map.get(Long.valueOf(j));
        } else {
            return null;
        }
    }

    public static long m(@Nullable TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723720715")) {
            return ((Long) ipChange.ipc$dispatch("-723720715", new Object[]{tbParams})).longValue();
        } else if (tbParams == null) {
            return -1;
        } else {
            return tbParams.performId;
        }
    }

    public static PriceLevel n(@Nullable PriceBean priceBean, @Nullable List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875644779")) {
            return (PriceLevel) ipChange.ipc$dispatch("1875644779", new Object[]{priceBean, list});
        } else if (priceBean == null || f92.d(list)) {
            return null;
        } else {
            for (int i = 0; i < list.size(); i++) {
                PriceLevel priceLevel = (PriceLevel) list.get(i);
                if (priceLevel.getPriceId() == priceBean.priceId) {
                    return priceLevel;
                }
            }
            return null;
        }
    }

    public static long o(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770529850")) {
            return ((Long) ipChange.ipc$dispatch("-1770529850", new Object[]{priceLevel})).longValue();
        } else if (priceLevel == null) {
            return -1;
        } else {
            return priceLevel.getPriceId();
        }
    }

    @Nullable
    public static String p(String str, long j, boolean z) {
        mi1 b;
        PerformBean performBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469181155")) {
            return (String) ipChange.ipc$dispatch("-469181155", new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)});
        }
        if (z || ra.b(str) || (b = ni1.a().b(j)) == null || (performBean = b.c) == null) {
            return null;
        }
        return ra.a(performBean);
    }

    public static String q(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444222336")) {
            return (String) ipChange.ipc$dispatch("1444222336", new Object[]{seatNew});
        }
        String str = seatNew.rn;
        String str2 = "";
        if (str != null && !str.trim().equals(str2)) {
            if (xf2.h(str)) {
                str2 = str2 + str + bk2.b(xs0.a(), R$string.damai_cinemaseat_row);
            } else {
                str2 = str2 + str;
            }
        }
        String str3 = seatNew.sn;
        if (TextUtils.isEmpty(str3)) {
            return str2;
        }
        if (xf2.h(str3)) {
            return str2 + str3 + bk2.b(xs0.a(), R$string.damai_cinemaseat_number);
        }
        return str2 + str3;
    }

    public static List<ItemSeatV2> r(List<SeatNew> list, HashMap<String, Region> hashMap, List<Price> list2) {
        Region region;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052449436")) {
            return (List) ipChange.ipc$dispatch("2052449436", new Object[]{list, hashMap, list2});
        }
        LongSparseArray longSparseArray = null;
        if (f92.d(list)) {
            return null;
        }
        ArrayList<ItemSeatV2> arrayList = new ArrayList();
        for (SeatNew seatNew : list) {
            if (!(hashMap == null || (region = hashMap.get(seatNew.kanTaiId)) == null)) {
                seatNew.kanTaiName = region.name;
            }
            if (seatNew.isPackaged) {
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                }
                long j = seatNew.packageCombinedId;
                ItemSeatV2 itemSeatV2 = (ItemSeatV2) longSparseArray.get(j);
                if (itemSeatV2 == null) {
                    ItemSeatV2 itemSeatV22 = new ItemSeatV2(seatNew, true);
                    longSparseArray.put(j, itemSeatV22);
                    arrayList.add(itemSeatV22);
                } else {
                    itemSeatV2.addPackageSeat(seatNew);
                }
            } else {
                arrayList.add(new ItemSeatV2(seatNew, false));
            }
        }
        if (arrayList.size() > 0) {
            for (ItemSeatV2 itemSeatV23 : arrayList) {
                if (itemSeatV23.isPackageSeat) {
                    H(itemSeatV23.seatList, i(list2, itemSeatV23.priceId));
                }
            }
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    public static int s(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "573109929")) {
            return ((Integer) ipChange.ipc$dispatch("573109929", new Object[]{priceLevel})).intValue();
        }
        if (priceLevel != null && ((priceLevel.isTaoPiao() || priceLevel.isFreeCombineTiaoPiao()) && !f92.d(priceLevel.getSubPriceList()))) {
            for (SubPrice subPrice : priceLevel.getSubPriceList()) {
                i += subPrice.count;
            }
        }
        return i;
    }

    private static List<TicketSubUiModel> t(@NonNull List<SeatNew> list, LongSparseArray<PriceLine> longSparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152757333")) {
            return (List) ipChange.ipc$dispatch("152757333", new Object[]{list, longSparseArray});
        }
        LongSparseArray longSparseArray2 = new LongSparseArray();
        ArrayList arrayList = new ArrayList();
        for (SeatNew seatNew : list) {
            boolean z = seatNew.isPackaged;
            long j = z ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            if (!z || !arrayList.contains(Long.valueOf(seatNew.packageCombinedId))) {
                if (seatNew.isPackaged) {
                    arrayList.add(Long.valueOf(seatNew.packageCombinedId));
                }
                Tuple tuple = (Tuple) longSparseArray2.get(j);
                if (tuple == null) {
                    longSparseArray2.put(j, new Tuple(seatNew, 1));
                } else {
                    tuple.second = (S) Integer.valueOf(tuple.second.intValue() + 1);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < longSparseArray2.size(); i++) {
            long keyAt = longSparseArray2.keyAt(i);
            Tuple tuple2 = (Tuple) longSparseArray2.valueAt(i);
            F f = tuple2.first;
            int intValue = tuple2.second.intValue();
            String str = null;
            PriceLine priceLine = longSparseArray.get(keyAt);
            if (priceLine != null) {
                str = priceLine.getPriceTitle();
            }
            double d = ((double) (f.isPackaged ? f.seatTaoPiaoValue : f.seatValue)) * ((double) intValue);
            String c = xf2.c(d);
            TicketSubUiModel ticketSubUiModel = new TicketSubUiModel();
            ticketSubUiModel.count = intValue + "";
            ticketSubUiModel.skuName = str;
            ticketSubUiModel.amount = d + "";
            ticketSubUiModel.amountText = "¥" + c;
            arrayList2.add(ticketSubUiModel);
        }
        return arrayList2;
    }

    public static int u(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "143196733")) {
            return s(priceLevel) * i;
        }
        return ((Integer) ipChange.ipc$dispatch("143196733", new Object[]{priceLevel, Integer.valueOf(i)})).intValue();
    }

    public static int v(List<SeatNew> list, long j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1425266398")) {
            return ((Integer) ipChange.ipc$dispatch("1425266398", new Object[]{list, Long.valueOf(j)})).intValue();
        }
        if (!f92.d(list)) {
            for (SeatNew seatNew : list) {
                if (seatNew.priceLevel == j) {
                    i++;
                }
            }
        }
        return i;
    }

    @Nullable
    public static List<TicketMainUiModel> w(List<SeatNew> list, LongSparseArray<PriceLine> longSparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515706785")) {
            return (List) ipChange.ipc$dispatch("-515706785", new Object[]{list, longSparseArray});
        } else if (f92.d(list) || f92.e(longSparseArray)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            TicketMainUiModel ticketMainUiModel = new TicketMainUiModel();
            ticketMainUiModel.moduleTitle = "商品原价";
            double d = d(list);
            ticketMainUiModel.moduleTotalAmt = d + "";
            ticketMainUiModel.moduleType = "1";
            ticketMainUiModel.moduleTotalAmtText = "¥" + xf2.c(d);
            ticketMainUiModel.moduleDetailVOList = t(list, longSparseArray);
            arrayList.add(ticketMainUiModel);
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    public static boolean x(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "521458288")) {
            return ((Boolean) ipChange.ipc$dispatch("521458288", new Object[]{list})).booleanValue();
        }
        if (!f92.d(list)) {
            for (PriceLevel priceLevel : list) {
                if (priceLevel.isFreeCombineTiaoPiao() || priceLevel.isTaoPiao()) {
                    return true;
                }
                while (r5.hasNext()) {
                }
            }
        }
        return false;
    }

    public static boolean y(List<Region> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122413123")) {
            return ((Boolean) ipChange.ipc$dispatch("1122413123", new Object[]{list, str})).booleanValue();
        } else if (f92.d(list)) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                Region region = list.get(i);
                if (TextUtils.equals(region.vid, str)) {
                    if (region.state == 1) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public static boolean z(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814927927")) {
            return ((Boolean) ipChange.ipc$dispatch("-1814927927", new Object[]{list})).booleanValue();
        }
        if (!f92.d(list)) {
            String str = null;
            for (int i = 0; i < list.size(); i++) {
                SeatNew seatNew = list.get(i);
                if (str == null) {
                    str = seatNew.rn;
                } else if (!TextUtils.equals(str, seatNew.rn)) {
                    return true;
                }
            }
        }
        return false;
    }
}
