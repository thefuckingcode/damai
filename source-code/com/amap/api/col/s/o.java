package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.col.s.ae;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class o extends b<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public o(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(AdUtConstants.XAD_UT_ARG_COUNT) && jSONObject.getInt(AdUtConstants.XAD_UT_ARG_COUNT) > 0) {
                return q.g(jSONObject);
            }
            return arrayList;
        } catch (JSONException e) {
            i.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            i.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ ArrayList<GeocodeAddress> a(String str) throws AMapException {
        return c(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b.b(((a) this).b.getLocationName()));
        String city = ((a) this).b.getCity();
        if (!q.g(city)) {
            String b = b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        if (!q.g(((a) this).b.getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(b.b(((a) this).b.getCountry()));
        }
        stringBuffer.append("&key=" + bk.f(((a) this).e));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public final ae.b d() {
        ae.b bVar = new ae.b();
        bVar.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/geocode/geo?";
    }
}
