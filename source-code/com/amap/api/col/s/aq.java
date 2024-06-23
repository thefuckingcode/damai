package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: Taobao */
public final class aq extends b<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public aq(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    private static WalkRouteResult c(String str) throws AMapException {
        return q.d(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ WalkRouteResult a(String str) throws AMapException {
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
        stringBuffer.append("&multipath=0");
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
        return h.a() + "/direction/walking?";
    }
}
