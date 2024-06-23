package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
public final class m extends b<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public m(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResult c(String str) throws AMapException {
        return q.b(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ DriveRouteResult a(String str) throws AMapException {
        return c(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((a) this).e));
        if (((a) this).b.getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((a) this).b.getFromAndTo().getFrom()));
            if (!q.g(((a) this).b.getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((a) this).b.getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((a) this).b.getFromAndTo().getTo()));
            if (!q.g(((a) this).b.getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((a) this).b.getFromAndTo().getDestinationPoiID());
            }
            if (!q.g(((a) this).b.getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((a) this).b.getFromAndTo().getOriginType());
            }
            if (!q.g(((a) this).b.getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((a) this).b.getFromAndTo().getDestinationType());
            }
            if (!q.g(((a) this).b.getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((a) this).b.getFromAndTo().getPlateProvince());
            }
            if (!q.g(((a) this).b.getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((a) this).b.getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((a) this).b.getMode());
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(((a) this).b.getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((a) this).b.getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((a) this).b.isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((a) this).b.getCarType());
        stringBuffer.append(sb2.toString());
        if (((a) this).b.hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((a) this).b.getPassedPointStr());
        }
        if (((a) this).b.hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((a) this).b.getAvoidpolygonsStr());
        }
        if (((a) this).b.hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b.b(((a) this).b.getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((a) this).b.getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((a) this).b.getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/direction/driving?";
    }
}
