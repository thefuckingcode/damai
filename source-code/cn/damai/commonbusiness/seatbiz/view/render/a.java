package cn.damai.commonbusiness.seatbiz.view.render;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionColorListResult;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.h32;
import tb.i32;
import tb.lz1;

/* compiled from: Taobao */
public abstract class a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected boolean isHasFloorId;
    public List<RegionBound> mRegionBounds = new ArrayList(256);
    private lz1 mRegionManager = new lz1();
    protected HashMap<String, ArrayList<RegionColorListResult.RegionColorList.RegionColor>> mRegionVid2ColorMap;
    protected HashMap<String, HashMap<String, String>> rainbowColorMap;
    protected HashMap<String, String> regionColorMap;
    protected List<List<PointLocation>> regionLocationList;
    protected float svgScale;

    /* access modifiers changed from: protected */
    public int addAlpha2Color(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420014207")) {
            return ((Integer) ipChange.ipc$dispatch("-420014207", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        try {
            String hexString = Integer.toHexString(i);
            if (hexString == null || hexString.length() < 6) {
                return i;
            }
            String substring = hexString.substring(hexString.length() - 6, hexString.length());
            return Color.parseColor("#33" + substring);
        } catch (Exception unused) {
            return i;
        }
    }

    /* access modifiers changed from: protected */
    public abstract String addAlpha2Color(String str);

    public Picture buildPicture() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "320132408")) {
            return buildPicture(false);
        }
        return (Picture) ipChange.ipc$dispatch("320132408", new Object[]{this});
    }

    public abstract Picture buildPicture(@NonNull i32 i32);

    public abstract Picture buildPicture(boolean z);

    public abstract Picture buildPictureWithColorIntercepter(List<h32> list);

    public abstract Picture buildPriceFilterPicture2(SeatPrice seatPrice, RegionData regionData);

    public abstract Picture buildRegionPicture(String str, RectF rectF, Path path);

    public abstract Picture buildStrokePicture(List<SeatPrice> list, RegionData regionData);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    public String getPricePointColor(SeatPrice seatPrice, String str, RegionData regionData) {
        ArrayList<Long> arrayList;
        HashMap<String, ArrayList<RegionColorListResult.RegionColorList.RegionColor>> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310858358")) {
            return (String) ipChange.ipc$dispatch("310858358", new Object[]{this, seatPrice, str, regionData});
        }
        Region a = this.mRegionManager.c(regionData).a(regionData, str);
        if (!(a == null || (arrayList = a.priceLevelIdList) == null || arrayList.isEmpty() || !a.priceLevelIdList.contains(Long.valueOf(seatPrice.maitixPriceId)) || (hashMap = this.mRegionVid2ColorMap) == null)) {
            ArrayList<RegionColorListResult.RegionColorList.RegionColor> arrayList2 = hashMap.get(a.id + "");
            if (!f92.d(arrayList2)) {
                Iterator<RegionColorListResult.RegionColorList.RegionColor> it = arrayList2.iterator();
                while (it.hasNext()) {
                    RegionColorListResult.RegionColorList.RegionColor next = it.next();
                    long j = 0;
                    try {
                        j = Long.parseLong(next.priceId);
                    } catch (Exception unused) {
                    }
                    if (j == seatPrice.priceLevelId || j == seatPrice.maitixPriceId) {
                        return next.color;
                    }
                    while (it.hasNext()) {
                    }
                }
            }
        }
        return null;
    }

    public List<RegionBound> getRegionBounds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1663202527")) {
            return this.mRegionBounds;
        }
        return (List) ipChange.ipc$dispatch("1663202527", new Object[]{this});
    }

    public abstract int getRegionCount();

    public List<List<PointLocation>> getRegionLocationList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1339227491")) {
            return this.regionLocationList;
        }
        return (List) ipChange.ipc$dispatch("-1339227491", new Object[]{this});
    }

    public abstract int getShapeCount();

    public float getSvgScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-647861573")) {
            return this.svgScale;
        }
        return ((Float) ipChange.ipc$dispatch("-647861573", new Object[]{this})).floatValue();
    }

    public boolean hasFloorData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-505129909")) {
            return this.isHasFloorId;
        }
        return ((Boolean) ipChange.ipc$dispatch("-505129909", new Object[]{this})).booleanValue();
    }

    public boolean hasSelectedColor(List<SeatPrice> list, String str, RegionData regionData) {
        ArrayList<Long> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615942843")) {
            return ((Boolean) ipChange.ipc$dispatch("-1615942843", new Object[]{this, list, str, regionData})).booleanValue();
        }
        Region a = this.mRegionManager.c(regionData).a(regionData, str);
        if (!(a == null || (arrayList = a.priceLevelIdList) == null || arrayList.isEmpty())) {
            for (int i = 0; i < list.size(); i++) {
                if (a.priceLevelIdList.contains(Long.valueOf(list.get(i).maitixPriceId))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int parseColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655848400")) {
            return ((Integer) ipChange.ipc$dispatch("-1655848400", new Object[]{this, str})).intValue();
        } else if (TextUtils.isEmpty(str) || !str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return 0;
        } else {
            try {
                return Color.parseColor(str);
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public void setDynamicRegionColor(RegionColorListResult regionColorListResult) {
        HashMap<String, ArrayList<RegionColorListResult.RegionColorList.RegionColor>> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2010714978")) {
            ipChange.ipc$dispatch("2010714978", new Object[]{this, regionColorListResult});
            return;
        }
        this.mRegionVid2ColorMap = null;
        if (regionColorListResult != null && regionColorListResult.getData() != null && (hashMap = regionColorListResult.getData().standColor) != null && hashMap.size() != 0) {
            this.mRegionVid2ColorMap = hashMap;
        }
    }

    public void setRainbowColorData(HashMap<String, HashMap<String, String>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854424485")) {
            ipChange.ipc$dispatch("1854424485", new Object[]{this, hashMap});
            return;
        }
        this.rainbowColorMap = hashMap;
    }

    public void setRegionColorData(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1676074425")) {
            ipChange.ipc$dispatch("-1676074425", new Object[]{this, hashMap});
            return;
        }
        this.regionColorMap = hashMap;
    }

    public void setSvgScale(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993059999")) {
            ipChange.ipc$dispatch("-1993059999", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.svgScale = f;
    }
}
