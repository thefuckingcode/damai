package tb;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class li1 extends ji1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private PriceLevel e;
    private Map<String, String> f;

    public li1(@Nullable PriceLevel priceLevel, PriceInfo priceInfo, List<Region> list) {
        super(list, priceInfo);
        this.e = priceLevel;
        try {
            i();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // tb.i32
    public void d(@NonNull int[] iArr, @NonNull Shape shape) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985098715")) {
            ipChange.ipc$dispatch("-1985098715", new Object[]{this, iArr, shape});
            return;
        }
        e(shape);
        String str = shape.floorId;
        if (!TextUtils.isEmpty(str)) {
            if (!f92.f(this.f)) {
                if (this.e != null) {
                    String str2 = null;
                    Region h = h(str);
                    if (h != null && !f92.d(h.priceLevelIdList)) {
                        if (this.e.isFreeCombineTiaoPiao()) {
                            List<SubPrice> subPriceList = this.e.getSubPriceList();
                            if (!f92.d(subPriceList)) {
                                Iterator<SubPrice> it = subPriceList.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (h.priceLevelIdList.contains(Long.valueOf(it.next().getPriceId()))) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            z = false;
                        } else {
                            z = h.priceLevelIdList.contains(Long.valueOf(this.e.getPriceId()));
                        }
                        if (z) {
                            PriceSummary f2 = f(g(h.id + ""), this.e);
                            if (f2 != null) {
                                str2 = f2.getFormatColor();
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        iArr[0] = a(c(this.f.get(str)));
                        iArr[1] = a(shape.strokeColor);
                    } else {
                        iArr[0] = c(str2);
                    }
                } else {
                    String str3 = this.f.get(str);
                    if (!TextUtils.isEmpty(str3)) {
                        iArr[0] = c(str3);
                    }
                }
            }
            Log.e("color", "------------------------- floorId = " + shape.floorId + " , temp1 = " + iArr[0] + " ,temp2 = " + iArr[1]);
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405507575")) {
            ipChange.ipc$dispatch("1405507575", new Object[]{this});
        } else if (!f92.d(this.b)) {
            PriceInfo priceInfo = this.c;
            if (priceInfo == null || priceInfo.standColor == null) {
                this.f = new HashMap();
                for (Region region : this.b) {
                    if (region.state != 0) {
                        Map<String, String> map = this.f;
                        map.put(region.vid + "", region.color);
                    } else {
                        this.f.put(region.vid, "#DDE0E5");
                    }
                }
                return;
            }
            this.f = new HashMap();
            HashMap<String, ArrayList<PriceSummary>> hashMap = this.c.standColor;
            for (Region region2 : this.b) {
                if (!f92.f(hashMap)) {
                    ArrayList<PriceSummary> arrayList = hashMap.get(region2.id + "");
                    if (!f92.d(arrayList)) {
                        int i = 0;
                        while (true) {
                            if (i >= arrayList.size()) {
                                break;
                            }
                            PriceSummary priceSummary = arrayList.get(i);
                            if (priceSummary.maxPrice) {
                                this.f.put(region2.vid, priceSummary.getFormatColor());
                                break;
                            }
                            i++;
                        }
                    } else {
                        this.f.put(region2.vid, "#DDE0E5");
                    }
                } else {
                    this.f.put(region2.vid, "#DDE0E5");
                }
            }
        }
    }
}
