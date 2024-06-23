package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* compiled from: Taobao */
public final class ap extends b<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    private final String k = "/direction/truck?";
    private final String l = "|";
    private final String m = ",";

    public ap(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
    }

    private static TruckRouteRestult c(String str) throws AMapException {
        return q.j(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ TruckRouteRestult a(String str) throws AMapException {
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
        stringBuffer.append(((a) this).b.getMode());
        if (((a) this).b.hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((a) this).b.getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((a) this).b.getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((a) this).b.getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((a) this).b.getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((a) this).b.getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((a) this).b.getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((a) this).b.getTruckAxis());
        if (!TextUtils.isEmpty(((a) this).b.getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((a) this).b.getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.b() + "/direction/truck?";
    }
}
