package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.ag;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class z extends x<ac, PoiResult> {
    private int k = 0;
    private boolean l = false;
    private List<String> m = new ArrayList();
    private List<SuggestionCity> n = new ArrayList();

    public z(Context context, ac acVar) {
        super(context, acVar);
    }

    private static String b(boolean z) {
        return z ? "distance" : "weight";
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public PoiResult a(String str) throws AMapException {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            T t = ((a) this).b;
            return PoiResult.createPagedResult(t.a, t.b, this.m, this.n, t.a.getPageSize(), this.k, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.k = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
            arrayList = q.c(jSONObject);
            if (!jSONObject.has("suggestion")) {
                T t2 = ((a) this).b;
                return PoiResult.createPagedResult(t2.a, t2.b, this.m, this.n, t2.a.getPageSize(), this.k, arrayList);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject == null) {
                T t3 = ((a) this).b;
                return PoiResult.createPagedResult(t3.a, t3.b, this.m, this.n, t3.a.getPageSize(), this.k, arrayList);
            }
            this.n = q.a(optJSONObject);
            this.m = q.b(optJSONObject);
            T t4 = ((a) this).b;
            return PoiResult.createPagedResult(t4.a, t4.b, this.m, this.n, t4.a.getPageSize(), this.k, arrayList);
        } catch (JSONException e) {
            i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            i.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
    }

    private static ag j() {
        af a = ae.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (ag) a;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        return a(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public final ae.b d() {
        ae.b bVar = new ae.b();
        if (this.l) {
            ag j = j();
            double d = 0.0d;
            if (j != null) {
                d = j.a();
            }
            bVar.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((a) this).b.b.getShape().equals("Bound")) {
                bVar.b = new ag.a(i.a(((a) this).b.b.getCenter().getLatitude()), i.a(((a) this).b.b.getCenter().getLongitude()), d);
            }
        } else {
            bVar.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str = h.a() + "/place";
        T t = ((a) this).b;
        if (t.b == null) {
            return str + "/text?";
        } else if (t.b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.l = true;
            return str2;
        } else if (!((a) this).b.b.getShape().equals("Rectangle") && !((a) this).b.b.getShape().equals("Polygon")) {
            return str;
        } else {
            return str + "/polygon?";
        }
    }

    private String a(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((a) this).b;
        if (t.b != null) {
            if (t.b.getShape().equals("Bound")) {
                if (z) {
                    double a = i.a(((a) this).b.b.getCenter().getLongitude());
                    double a2 = i.a(((a) this).b.b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a + "," + a2);
                }
                sb.append("&radius=");
                sb.append(((a) this).b.b.getRange());
                sb.append("&sortrule=");
                sb.append(b(((a) this).b.b.isDistanceSort()));
            } else if (((a) this).b.b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((a) this).b.b.getLowerLeft();
                LatLonPoint upperRight = ((a) this).b.b.getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((a) this).b.b.getShape().equals("Polygon") && (polyGonList = ((a) this).b.b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + i.a(polyGonList));
            }
        }
        String city = ((a) this).b.a.getCity();
        if (!x.c(city)) {
            String b = b.b(city);
            sb.append("&city=");
            sb.append(b);
        }
        String b2 = b.b(((a) this).b.a.getQueryString());
        if (!x.c(b2)) {
            sb.append("&keywords=");
            sb.append(b2);
        }
        sb.append("&offset=");
        sb.append(((a) this).b.a.getPageSize());
        sb.append("&page=");
        sb.append(((a) this).b.a.getPageNum());
        String building = ((a) this).b.a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((a) this).b.a.getBuilding());
        }
        String b3 = b.b(((a) this).b.a.getCategory());
        if (!x.c(b3)) {
            sb.append("&types=");
            sb.append(b3);
        }
        if (!x.c(((a) this).b.a.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((a) this).b.a.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&key=");
        sb.append(bk.f(((a) this).e));
        if (((a) this).b.a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((a) this).b.a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.l) {
            if (((a) this).b.a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t2 = ((a) this).b;
        if (t2.b == null && t2.a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(b(((a) this).b.a.isDistanceSort()));
            double a7 = i.a(((a) this).b.a.getLocation().getLongitude());
            double a8 = i.a(((a) this).b.a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        return sb.toString();
    }
}
