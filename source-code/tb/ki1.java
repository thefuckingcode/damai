package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceSummary;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ki1 extends ji1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private PriceLevel e;
    private Map<String, HashMap<String, String>> f;
    private ArrayMap<String, String> g;
    private Map<String, List<PriceSummary>> h = new HashMap();

    public ki1(@Nullable PriceLevel priceLevel, PriceInfo priceInfo, List<Region> list, Map<String, HashMap<String, String>> map, ArrayMap<String, String> arrayMap) {
        super(list, priceInfo);
        this.e = priceLevel;
        this.g = arrayMap;
        try {
            j(map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private Map<String, HashMap<String, String>> i(Map<String, HashMap<String, String>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546970669")) {
            return (Map) ipChange.ipc$dispatch("546970669", new Object[]{this, map});
        } else if (map == null) {
            return null;
        } else {
            HashMap hashMap = new HashMap((int) ((((float) map.size()) / 0.75f) + 1.0f));
            for (Map.Entry<String, HashMap<String, String>> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new HashMap(entry.getValue()));
            }
            return hashMap;
        }
    }

    private void j(Map<String, HashMap<String, String>> map) {
        PriceInfo priceInfo;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909344966")) {
            ipChange.ipc$dispatch("-909344966", new Object[]{this, map});
        } else if (f92.d(this.b) || (priceInfo = this.c) == null || priceInfo.standColor == null) {
            this.f = map;
        } else {
            Map<String, HashMap<String, String>> i = i(map);
            this.f = i;
            if (!f92.f(i)) {
                HashMap<String, ArrayList<PriceSummary>> hashMap = this.c.standColor;
                for (String str : this.f.keySet()) {
                    HashMap<String, String> hashMap2 = this.f.get(str);
                    if (!f92.f(this.g)) {
                        ArrayList<PriceSummary> arrayList = hashMap.get(this.g.get(str));
                        if (!f92.f(hashMap2)) {
                            for (Map.Entry<String, String> entry : hashMap2.entrySet()) {
                                String value = entry.getValue();
                                if (f92.d(arrayList)) {
                                    entry.setValue("#DDE0E5");
                                } else {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= arrayList.size()) {
                                            z = false;
                                            break;
                                        } else if (k(value, arrayList.get(i2))) {
                                            z = true;
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                    if (!z) {
                                        entry.setValue("#DDE0E5");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean k(String str, PriceSummary priceSummary) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "789704049")) {
            return ((Boolean) ipChange.ipc$dispatch("789704049", new Object[]{str, priceSummary})).booleanValue();
        } else if (TextUtils.isEmpty(str) || priceSummary == null) {
            return false;
        } else {
            return str.equalsIgnoreCase(priceSummary.color);
        }
    }

    @Override // tb.i32
    public void d(@NonNull int[] iArr, @NonNull Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679123889")) {
            ipChange.ipc$dispatch("679123889", new Object[]{this, iArr, shape});
            return;
        }
        e(shape);
        String str = shape.floorId;
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(shape.rowId) || f92.f(this.f))) {
            if (this.e != null) {
                String str2 = null;
                Region h2 = h(str);
                if (h2 != null && !f92.d(h2.priceLevelIdList)) {
                    if (this.e.isFreeCombineTiaoPiao()) {
                        List<PriceSummary> list = this.h.get(str);
                        if (list == null) {
                            list = new ArrayList<>();
                            List<SubPrice> subPriceList = this.e.getSubPriceList();
                            ArrayList arrayList = new ArrayList();
                            if (!f92.d(subPriceList)) {
                                for (SubPrice subPrice : subPriceList) {
                                    if (h2.priceLevelIdList.contains(Long.valueOf(subPrice.getPriceId()))) {
                                        arrayList.add(subPrice.getPriceId() + "");
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                ArrayList<PriceSummary> g2 = g(h2.id + "");
                                if (!f92.d(g2)) {
                                    Iterator<PriceSummary> it = g2.iterator();
                                    while (it.hasNext()) {
                                        PriceSummary next = it.next();
                                        if (arrayList.contains(next.priceId)) {
                                            list.add(next);
                                        }
                                    }
                                }
                            }
                            this.h.put(str, list);
                        }
                        if (list.size() == 1) {
                            str2 = list.get(0).getFormatColor();
                        } else if (list.size() > 1) {
                            HashMap<String, String> hashMap = this.f.get(str);
                            if (!f92.f(hashMap)) {
                                String str3 = hashMap.get(shape.rowId);
                                for (PriceSummary priceSummary : list) {
                                    if (k(str3, priceSummary)) {
                                        str2 = priceSummary.getFormatColor();
                                    }
                                }
                            }
                        }
                    } else if (h2.priceLevelIdList.contains(Long.valueOf(this.e.getPriceId()))) {
                        PriceSummary f2 = f(g(h2.id + ""), this.e);
                        if (f2 != null) {
                            str2 = f2.getFormatColor();
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    HashMap<String, String> hashMap2 = this.f.get(str);
                    if (!f92.f(hashMap2)) {
                        String str4 = hashMap2.get(shape.rowId);
                        if (!TextUtils.isEmpty(str4)) {
                            iArr[0] = a(c(str4));
                            iArr[1] = a(shape.strokeColor);
                            return;
                        }
                        return;
                    }
                    return;
                }
                iArr[0] = c(str2);
                return;
            }
            HashMap<String, String> hashMap3 = this.f.get(str);
            if (hashMap3 != null) {
                String str5 = hashMap3.get(shape.rowId);
                if (!TextUtils.isEmpty(str5)) {
                    iArr[0] = c(str5);
                }
            }
        }
    }
}
