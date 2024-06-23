package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: Taobao */
public final class n extends b<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public n(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 c(String str) throws AMapException {
        return q.c(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ DriveRouteResultV2 a(String str) throws AMapException {
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
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((a) this).b.getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((a) this).b.getFromAndTo().getTo()));
            if (!q.g(((a) this).b.getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((a) this).b.getFromAndTo().getDestinationPoiID());
            }
            if (!q.g(((a) this).b.getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((a) this).b.getFromAndTo().getOriginType());
            }
            if (!q.g(((a) this).b.getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((a) this).b.getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((a) this).b.getMode());
        stringBuffer.append(sb.toString());
        int showFields = ((a) this).b.getShowFields();
        stringBuffer.append("&show_fields=");
        if ((showFields & 1) != 0) {
            stringBuffer.append("cost,");
        }
        if ((showFields & 2) != 0) {
            stringBuffer.append("tmcs,");
        }
        if ((showFields & 4) != 0) {
            stringBuffer.append("navi,");
        }
        if ((showFields & 8) != 0) {
            stringBuffer.append("cities,");
        }
        if ((showFields & 16) != 0) {
            stringBuffer.append("polyline,");
        }
        if ((showFields & 32) != 0) {
            stringBuffer.append("elec_consume_info,");
        }
        if ((showFields & 64) != 0) {
            stringBuffer.append("charge_station_info,");
        }
        stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), "");
        RouteSearchV2.NewEnergy newEnergy = ((a) this).b.getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
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
        return h.c() + "/direction/driving?";
    }
}
