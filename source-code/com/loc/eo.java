package com.loc;

import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class eo extends AMapLocation {
    protected String d = "";
    boolean e = true;
    String f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private String g = null;
    private String h = "";
    private int i;
    private String j = "";
    private int k = 0;
    private String l = "new";
    private JSONObject m = null;
    private String n = "";
    private String o = "";
    private String p = null;

    public eo(String str) {
        super(str);
    }

    private void i(String str) {
        this.n = str;
    }

    private void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\*");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                if (!TextUtils.isEmpty(str2)) {
                    String[] split2 = str2.split(",");
                    setLongitude(m1.J(split2[0]));
                    setLatitude(m1.J(split2[1]));
                    setAccuracy((float) m1.S(split2[2]));
                    break;
                }
                i2++;
            }
            this.o = str;
        }
    }

    public final String a() {
        return this.g;
    }

    public final void a(int i2) {
        this.k = i2;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(JSONObject jSONObject) {
        this.m = jSONObject;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final String b() {
        return this.h;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void b(JSONObject jSONObject) {
        try {
            j1.f(this, jSONObject);
            e(jSONObject.optString("type", this.l));
            d(jSONObject.optString("retype", this.j));
            j(jSONObject.optString("cens", this.o));
            g(jSONObject.optString(SocialConstants.PARAM_APP_DESC, this.d));
            c(jSONObject.optString("coord", String.valueOf(this.i)));
            i(jSONObject.optString("mcell", this.n));
            a(jSONObject.optBoolean("isReversegeo", this.e));
            f(jSONObject.optString("geoLanguage", this.f));
            if (m1.u(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (m1.u(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (m1.u(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (m1.u(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            j1.h(th, "AmapLoc", "AmapLoc");
        }
    }

    public final int c() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    public final void c(String str) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("0")) {
                i2 = 0;
            } else if (str.equals("1")) {
                i2 = 1;
            }
            this.i = i2;
            super.setCoordType(this.i != 0 ? AMapLocation.COORD_TYPE_WGS84 : AMapLocation.COORD_TYPE_GCJ02);
        }
        i2 = -1;
        this.i = i2;
        super.setCoordType(this.i != 0 ? AMapLocation.COORD_TYPE_WGS84 : AMapLocation.COORD_TYPE_GCJ02);
    }

    public final String d() {
        return this.j;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String e() {
        return this.l;
    }

    public final void e(String str) {
        this.l = str;
    }

    public final JSONObject f() {
        return this.m;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final String g() {
        return this.n;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final eo h() {
        String g2 = g();
        if (TextUtils.isEmpty(g2)) {
            return null;
        }
        String[] split = g2.split(",");
        if (split.length != 3) {
            return null;
        }
        eo eoVar = new eo("");
        eoVar.setProvider(getProvider());
        eoVar.setLongitude(m1.J(split[0]));
        eoVar.setLatitude(m1.J(split[1]));
        eoVar.setAccuracy(m1.O(split[2]));
        eoVar.setCityCode(getCityCode());
        eoVar.setAdCode(getAdCode());
        eoVar.setCountry(getCountry());
        eoVar.setProvince(getProvince());
        eoVar.setCity(getCity());
        eoVar.setTime(getTime());
        eoVar.e(e());
        eoVar.c(String.valueOf(c()));
        if (!m1.r(eoVar)) {
            return null;
        }
        return eoVar;
    }

    public final void h(String str) {
        this.p = str;
    }

    public final boolean i() {
        return this.e;
    }

    public final String j() {
        return this.f;
    }

    public final String k() {
        return this.p;
    }

    public final int l() {
        return this.k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i2) {
        try {
            JSONObject json = super.toJson(i2);
            if (i2 == 1) {
                json.put("retype", this.j);
                json.put("cens", this.o);
                json.put("coord", this.i);
                json.put("mcell", this.n);
                json.put(SocialConstants.PARAM_APP_DESC, this.d);
                json.put(ILocatable.ADDRESS, getAddress());
                if (this.m != null && m1.u(json, "offpct")) {
                    json.put("offpct", this.m.getString("offpct"));
                }
            } else if (!(i2 == 2 || i2 == 3)) {
                return json;
            }
            json.put("type", this.l);
            json.put("isReversegeo", this.e);
            json.put("geoLanguage", this.f);
            return json;
        } catch (Throwable th) {
            j1.h(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i2);
            jSONObject.put("nb", this.p);
        } catch (Throwable th) {
            j1.h(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
