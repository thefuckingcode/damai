package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
public final class aj extends b<RouteSearch.RideRouteQuery, RideRouteResult> {
    public aj(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResult c(String str) throws AMapException {
        return q.h(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ RideRouteResult a(String str) throws AMapException {
        return c(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((a) this).e));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((a) this).b.getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((a) this).b.getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (!TextUtils.isEmpty(((a) this).b.getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((a) this).b.getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.b() + "/direction/bicycling?";
    }
}
