package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.ag;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class ai extends b<RegeocodeQuery, RegeocodeAddress> {
    public ai(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject == null) {
                return regeocodeAddress;
            }
            regeocodeAddress.setFormatAddress(q.a(optJSONObject, "formatted_address"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            if (optJSONObject2 != null) {
                q.a(optJSONObject2, regeocodeAddress);
            }
            regeocodeAddress.setPois(q.c(optJSONObject));
            JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
            if (optJSONArray != null) {
                q.b(optJSONArray, regeocodeAddress);
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
            if (optJSONArray2 != null) {
                q.a(optJSONArray2, regeocodeAddress);
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
            if (optJSONArray3 != null) {
                q.c(optJSONArray3, regeocodeAddress);
            }
            return regeocodeAddress;
        } catch (JSONException e) {
            i.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
    }

    private static ag j() {
        af a = ae.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (ag) a;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ RegeocodeAddress a(String str) throws AMapException {
        return c(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        return a(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public final ae.b d() {
        ag j = j();
        double a = j != null ? j.a() : 0.0d;
        ae.b bVar = new ae.b();
        bVar.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t = ((a) this).b;
        if (!(t == null || t.getPoint() == null)) {
            bVar.b = new ag.a(((a) this).b.getPoint().getLatitude(), ((a) this).b.getPoint().getLongitude(), a);
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/geocode/regeo?";
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(i.a(((a) this).b.getPoint().getLongitude()));
            sb.append(",");
            sb.append(i.a(((a) this).b.getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((a) this).b.getPoiType())) {
            sb.append("&poitype=");
            sb.append(((a) this).b.getPoiType());
        }
        if (!TextUtils.isEmpty(((a) this).b.getMode())) {
            sb.append("&mode=");
            sb.append(((a) this).b.getMode());
        }
        if (!TextUtils.isEmpty(((a) this).b.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((a) this).b.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&radius=");
        sb.append((int) ((a) this).b.getRadius());
        sb.append("&coordsys=");
        sb.append(((a) this).b.getLatLonType());
        sb.append("&key=");
        sb.append(bk.f(((a) this).e));
        return sb.toString();
    }
}
