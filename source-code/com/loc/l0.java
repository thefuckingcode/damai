package com.loc;

import android.os.Bundle;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;
import mtopsdk.common.util.SymbolExpUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class l0 {
    private static long a;

    private static double a(DPoint dPoint, DPoint dPoint2, DPoint dPoint3) {
        double d;
        double d2;
        double longitude = dPoint.getLongitude() - dPoint2.getLongitude();
        double latitude = dPoint.getLatitude() - dPoint2.getLatitude();
        double longitude2 = dPoint3.getLongitude() - dPoint2.getLongitude();
        double latitude2 = dPoint3.getLatitude() - dPoint2.getLatitude();
        double d3 = ((longitude * longitude2) + (latitude * latitude2)) / ((longitude2 * longitude2) + (latitude2 * latitude2));
        boolean z = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
        if (d3 < 0.0d || z) {
            d2 = dPoint2.getLongitude();
            d = dPoint2.getLatitude();
        } else if (d3 > 1.0d) {
            d2 = dPoint3.getLongitude();
            d = dPoint3.getLatitude();
        } else {
            d = dPoint2.getLatitude() + (d3 * latitude2);
            d2 = dPoint2.getLongitude() + (longitude2 * d3);
        }
        return (double) m1.d(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(d, d2));
    }

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c = 0;
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("pois")) != null) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    GeoFence geoFence = new GeoFence();
                    PoiItem poiItem = new PoiItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    poiItem.setPoiId(jSONObject2.optString("id"));
                    poiItem.setPoiName(jSONObject2.optString("name"));
                    poiItem.setPoiType(jSONObject2.optString("type"));
                    poiItem.setTypeCode(jSONObject2.optString("typecode"));
                    poiItem.setAddress(jSONObject2.optString(ILocatable.ADDRESS));
                    String optString = jSONObject2.optString("location");
                    if (optString != null) {
                        String[] split = optString.split(",");
                        poiItem.setLongitude(Double.parseDouble(split[c]));
                        poiItem.setLatitude(Double.parseDouble(split[1]));
                        List<List<DPoint>> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        i = optInt2;
                        DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                        arrayList2.add(dPoint);
                        arrayList.add(arrayList2);
                        geoFence.setPointList(arrayList);
                        geoFence.setCenter(dPoint);
                    } else {
                        i = optInt2;
                    }
                    poiItem.setTel(jSONObject2.optString("tel"));
                    poiItem.setProvince(jSONObject2.optString("pname"));
                    poiItem.setCity(jSONObject2.optString("cityname"));
                    poiItem.setAdname(jSONObject2.optString("adname"));
                    geoFence.setPoiItem(poiItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c());
                    geoFence.setFenceId(sb.toString());
                    if (bundle != null) {
                        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                        geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                        geoFence.setType(2);
                        geoFence.setRadius(bundle.getFloat("fenceRadius"));
                        geoFence.setExpiration(bundle.getLong("expiration"));
                        geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                    }
                    if (list != null) {
                        list.add(geoFence);
                    }
                    i2++;
                    optInt2 = i;
                    c = 0;
                }
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static synchronized long c() {
        long j;
        synchronized (l0.class) {
            long B = m1.B();
            long j2 = a;
            if (B > j2) {
                a = B;
            } else {
                a = j2 + 1;
            }
            j = a;
        }
        return j;
    }

    private List<DPoint> d(List<DPoint> list, float f) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        double d = 0.0d;
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = list.get(0);
        DPoint dPoint2 = list.get(list.size() - 1);
        int i = 0;
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            double a2 = a(list.get(i2), dPoint, dPoint2);
            if (a2 > d) {
                i = i2;
                d = a2;
            }
        }
        if (d < ((double) f)) {
            arrayList.add(dPoint);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> d2 = d(list.subList(0, i + 1), f);
        List<DPoint> d3 = d(list.subList(i, list.size()), f);
        arrayList.addAll(d2);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(d3);
        return arrayList;
    }

    public static int e(String str, List<GeoFence> list, Bundle bundle) {
        return b(str, list, bundle);
    }

    public final int f(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        String str2;
        ArrayList arrayList;
        long j;
        float f;
        String str3;
        String str4;
        int i;
        int i2;
        long j2;
        String str5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
            String string2 = bundle.getString("pendingIntentAction");
            float f2 = bundle.getFloat("fenceRadius");
            long j3 = bundle.getLong("expiration");
            int i3 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i4 = 0;
                while (i4 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString("name");
                    String string3 = jSONObject2.getString("center");
                    DPoint dPoint = new DPoint();
                    String str6 = ",";
                    if (string3 != null) {
                        String[] split = string3.split(str6);
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[1]));
                        dPoint.setLongitude(Double.parseDouble(split[0]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f2);
                    geoFence.setExpiration(j3);
                    geoFence.setActivatesAction(i3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c());
                    geoFence.setFenceId(sb.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                        int length = split2.length;
                        i = i3;
                        float f3 = Float.MAX_VALUE;
                        int i5 = 0;
                        float f4 = Float.MIN_VALUE;
                        while (i5 < length) {
                            String str7 = split2[i5];
                            DistrictItem districtItem = new DistrictItem();
                            List<DPoint> arrayList4 = new ArrayList<>();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            districtItem.setDistrictName(str2);
                            str2 = str2;
                            String[] split3 = str7.split(";");
                            int i6 = 0;
                            while (i6 < split3.length) {
                                String[] split4 = split3[i6].split(str6);
                                if (split4.length > 1) {
                                    String str8 = split4[1];
                                    String str9 = split4[0];
                                    j2 = j3;
                                    double parseDouble = Double.parseDouble(str8);
                                    i2 = length;
                                    str5 = optString;
                                    arrayList4.add(new DPoint(parseDouble, Double.parseDouble(str9)));
                                } else {
                                    j2 = j3;
                                    i2 = length;
                                    str5 = optString;
                                }
                                i6++;
                                optString = str5;
                                str6 = str6;
                                split3 = split3;
                                j3 = j2;
                                length = i2;
                            }
                            if (((float) arrayList4.size()) > 100.0f) {
                                try {
                                    arrayList4 = d(arrayList4, 100.0f);
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            arrayList.add(districtItem);
                            f4 = Math.max(f4, a.z(dPoint, arrayList4));
                            f3 = Math.min(f3, a.b(dPoint, arrayList4));
                            i5++;
                            optString = optString;
                            arrayList = arrayList;
                            string = string;
                            split2 = split2;
                            string2 = string2;
                            optString2 = optString2;
                            f2 = f2;
                            str6 = str6;
                            j3 = j3;
                            length = length;
                        }
                        str4 = string;
                        str3 = string2;
                        f = f2;
                        j = j3;
                        geoFence.setMaxDis2Center(f4);
                        geoFence.setMinDis2Center(f3);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i = i3;
                        str4 = string;
                        str3 = string2;
                        f = f2;
                        j = j3;
                    }
                    i4++;
                    optJSONArray = optJSONArray;
                    optInt2 = optInt2;
                    i3 = i;
                    string = str4;
                    string2 = str3;
                    f2 = f;
                    j3 = j;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
            return 5;
        }
    }
}
