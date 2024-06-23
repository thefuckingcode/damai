package tb;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYu;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYuInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataSeatPrice;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionLocation;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class oa {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public Region a(RegionData regionData, String str) {
        RegionInfo regionInfo;
        ArrayMap<String, Region> arrayMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892430383")) {
            return (Region) ipChange.ipc$dispatch("-1892430383", new Object[]{this, regionData, str});
        }
        if (regionData == null || (regionInfo = regionData.ri) == null || (arrayMap = regionInfo.mRegionArrayMap) == null) {
            return null;
        }
        return arrayMap.get(b(regionData, str));
    }

    @Nullable
    public String b(RegionData regionData, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877945925")) {
            return (String) ipChange.ipc$dispatch("1877945925", new Object[]{this, regionData, str});
        } else if (c(regionData) == null) {
            return null;
        } else {
            return c(regionData).get(str);
        }
    }

    public ArrayMap<String, String> c(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624697711")) {
            return (ArrayMap) ipChange.ipc$dispatch("1624697711", new Object[]{this, regionData});
        }
        if (regionData == null || (regionInfo = regionData.ri) == null) {
            return null;
        }
        return regionInfo.mRegionIdMatchList;
    }

    public boolean d(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609882883")) {
            return ((Boolean) ipChange.ipc$dispatch("1609882883", new Object[]{this, regionData})).booleanValue();
        }
        return (regionData == null || (regionInfo = regionData.ri) == null || !regionInfo.rainbowSupportII) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0258  */
    @Nullable
    public RegionData e(RegionDataNew regionDataNew, long j) {
        String str;
        int i;
        String str2;
        String[] strArr;
        int i2;
        float f;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410562238")) {
            return (RegionData) ipChange.ipc$dispatch("410562238", new Object[]{this, regionDataNew, Long.valueOf(j)});
        }
        RegionData regionData = new RegionData();
        regionData.regionSeatData = new RegionSeatData();
        try {
            regionData.cityId = regionDataNew.cityId;
            regionData.xorPerformId = regionDataNew.xorPerfromId;
            RegionDataQuYu regionDataQuYu = regionDataNew.seatQuYu;
            regionData.regionTopListModelList = regionDataQuYu.taopiaoList;
            regionData.floors = regionDataQuYu.floors;
            regionData.regionPriceList = new ArrayList();
            regionData.regionPriceMap = new ArrayMap<>();
            int i3 = 0;
            while (true) {
                int size = regionDataQuYu.seatPriceList.size();
                str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (i3 >= size) {
                    break;
                }
                SeatPrice seatPrice = new SeatPrice();
                RegionDataSeatPrice regionDataSeatPrice = regionDataQuYu.seatPriceList.get(i3);
                if (TextUtils.isEmpty(regionDataSeatPrice.c) || regionDataSeatPrice.c.length() != 6) {
                    seatPrice.priceColor = "FF0000";
                } else {
                    seatPrice.priceColor = regionDataSeatPrice.c.toUpperCase();
                }
                try {
                    seatPrice.priceColorValue = Color.parseColor(str + seatPrice.priceColor);
                } catch (Exception unused) {
                    seatPrice.priceColorValue = Color.parseColor("#FF0000");
                }
                seatPrice.priceLevelId = regionDataSeatPrice.damaiPriceId;
                seatPrice.maitixPriceId = regionDataSeatPrice.maitixPriceId;
                seatPrice.priceLevelName = regionDataSeatPrice.dm;
                seatPrice.priceValue = regionDataSeatPrice.p;
                regionData.immutableSeatPriceList.add(seatPrice);
                regionData.regionPriceList.add(seatPrice);
                regionData.regionPriceMap.put(seatPrice.maitixPriceId + "", seatPrice);
                regionData.regionPriceMap.put(seatPrice.priceLevelId + "", seatPrice);
                i3++;
            }
            RegionSeatData regionSeatData = regionData.regionSeatData;
            regionSeatData.resourcesPath = regionDataQuYu.resourcesPath;
            regionSeatData.resourcesCompressPath = regionDataQuYu.resourcesCompressPath;
            regionSeatData.resourcesCompressPathII = regionDataQuYu.resourcesCompressPathII;
            regionSeatData.seatEncodingType = regionDataQuYu.seatEncodingType;
            regionSeatData.seatStaticHash = regionDataQuYu.seatStaticHash;
            regionSeatData.seatEncodeUri = regionDataQuYu.seatEncodeUri;
            regionSeatData.has3dvrImg = regionDataQuYu.has3dvrImg;
            regionSeatData.seatExtInfo = regionDataQuYu.seatExtInfo;
            RegionInfo regionInfo = new RegionInfo();
            regionData.ri = regionInfo;
            regionInfo.vesion = regionDataQuYu.ver;
            regionInfo.performanceId = regionDataQuYu.maitixPfId;
            regionInfo.seatImg = regionDataQuYu.seatimg;
            regionInfo.seatOssImg = regionDataQuYu.seatOssImg;
            regionInfo.seatSvgImg = regionDataQuYu.seatSvgImg;
            regionInfo.rainbowSvgImg = regionDataQuYu.rainbowSvgImg;
            regionInfo.seatStyle = regionDataQuYu.getSeatStyle();
            regionInfo.rainbowSupport = regionDataQuYu.rainbowSupport;
            regionInfo.rainbowSupportII = regionDataQuYu.rainbowSupportII;
            regionInfo.venueScale = regionDataQuYu.venueScale;
            String str3 = regionDataQuYu.compressMode;
            regionInfo.compressMode = str3;
            if (TextUtils.isEmpty(str3) || !regionDataQuYu.compressMode.equals("gzip/xml")) {
                regionInfo.isZWB2b2c = false;
            } else {
                regionInfo.isZWB2b2c = true;
            }
            if (!TextUtils.isEmpty(regionDataQuYu.areaStatusGroup)) {
                String[] split = regionDataQuYu.areaStatusGroup.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                regionInfo.regionIdGroup = new ArrayList(split.length);
                for (String str4 : split) {
                    regionInfo.regionIdGroup.add(Arrays.asList(str4.split(",")));
                }
            }
            regionInfo.regionList = new ArrayList<>();
            List<RegionDataQuYuInfo> list = regionDataQuYu.quyu;
            if (list != null) {
                ArrayMap<String, String> arrayMap = new ArrayMap<>(list.size());
                ArrayMap<String, Region> arrayMap2 = new ArrayMap<>(regionDataQuYu.quyu.size());
                int i4 = 0;
                while (i4 < regionDataQuYu.quyu.size()) {
                    Region region = new Region();
                    RegionDataQuYuInfo regionDataQuYuInfo = regionDataQuYu.quyu.get(i4);
                    String str5 = regionDataQuYuInfo.c;
                    if (str5 == null || str5.length() == 0) {
                        regionDataQuYuInfo.c = "e41b46";
                    }
                    region.id = regionDataQuYuInfo.i;
                    region.name = regionDataQuYuInfo.n;
                    region.vid = regionDataQuYuInfo.vid;
                    String str6 = str + regionDataQuYuInfo.c;
                    region.color = str6;
                    try {
                        Color.parseColor(str6);
                    } catch (Exception unused2) {
                        region.color = "#e41b46";
                    }
                    String str7 = regionDataQuYuInfo.pis;
                    String[] split2 = str7 != null ? str7.split(SymbolExpUtil.SYMBOL_VERTICALBAR) : null;
                    region.regionLocationList = new ArrayList<>();
                    if (split2 != null && split2.length > 0) {
                        int length = split2.length;
                        int i5 = 0;
                        while (i5 < length) {
                            String str8 = split2[i5];
                            if (!TextUtils.isEmpty(str8)) {
                                String[] split3 = str8.split(",");
                                strArr = split2;
                                i2 = length;
                                if (split3.length >= 2) {
                                    RegionLocation regionLocation = new RegionLocation();
                                    float f2 = 0.0f;
                                    try {
                                        f = Float.parseFloat(split3[0]);
                                        try {
                                            f2 = Float.parseFloat(split3[1]);
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        f = 0.0f;
                                        e.printStackTrace();
                                        str2 = str;
                                        if (!regionInfo.isZWB2b2c) {
                                        }
                                        region.regionLocationList.add(regionLocation);
                                        i5++;
                                        split2 = strArr;
                                        str = str2;
                                        length = i2;
                                    }
                                    str2 = str;
                                    if (!regionInfo.isZWB2b2c) {
                                        regionLocation.x = f / 2.0f;
                                        regionLocation.y = f2 / 2.0f;
                                    } else {
                                        regionLocation.x = f;
                                        regionLocation.y = f2;
                                    }
                                    region.regionLocationList.add(regionLocation);
                                    i5++;
                                    split2 = strArr;
                                    str = str2;
                                    length = i2;
                                }
                            } else {
                                strArr = split2;
                                i2 = length;
                            }
                            str2 = str;
                            i5++;
                            split2 = strArr;
                            str = str2;
                            length = i2;
                        }
                    }
                    if (!region.regionLocationList.isEmpty()) {
                        RegionLocation regionLocation2 = new RegionLocation();
                        regionLocation2.x = region.regionLocationList.get(0).x;
                        regionLocation2.y = region.regionLocationList.get(0).y;
                        region.regionLocationList.add(regionLocation2);
                    }
                    region.priceLevelIdList = new ArrayList<>();
                    if (!TextUtils.isEmpty(regionDataQuYuInfo.j)) {
                        if (regionDataQuYuInfo.j.contains(",")) {
                            for (String str9 : regionDataQuYuInfo.j.split(",")) {
                                region.priceLevelIdList.add(Long.valueOf(Long.parseLong(str9)));
                            }
                        } else {
                            region.priceLevelIdList.add(Long.valueOf(Long.parseLong(regionDataQuYuInfo.j)));
                        }
                    }
                    if (!TextUtils.isEmpty(regionDataQuYuInfo.rainbow)) {
                        String[] split4 = regionDataQuYuInfo.rainbow.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                        for (String str10 : split4) {
                            String[] split5 = str10.split("=");
                            if (split5.length >= 2) {
                                region.rainbowColorList.put(split5[0], split5[1].toUpperCase());
                            }
                        }
                        regionInfo.standColorList.put(region.vid, region.rainbowColorList);
                    }
                    arrayMap.put(region.vid, region.id + "");
                    arrayMap2.put(region.id + "", region);
                    regionInfo.regionList.add(region);
                    i4++;
                    str = str;
                }
                regionInfo.mRegionIdMatchList = arrayMap;
                regionInfo.mRegionArrayMap = arrayMap2;
            }
            if (regionInfo.isZWB2b2c) {
                regionInfo.renderMode = regionDataQuYu.renderMode;
            } else {
                List<RegionDataQuYuInfo> list2 = regionDataQuYu.quyu;
                if (list2 != null) {
                    i = 1;
                    if (list2.size() == 1) {
                        regionInfo.renderMode = 2;
                    }
                } else {
                    i = 1;
                }
                regionInfo.renderMode = i;
            }
            regionData.intervalTime = regionDataQuYu.intervalTime;
            regionData.svgDecrypt = regionDataQuYu.svgDecrypt;
            regionData.sameRowNotify = regionDataQuYu.sameRowNotify;
            regionData.seatStatusUseCompress = regionDataQuYu.seatStatusUseCompress;
            regionData.seatStaticUseCompress = regionDataQuYu.seatStaticUseCompress;
            regionData.isNeedPreCheck = regionDataQuYu.precheck;
            return regionData;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
