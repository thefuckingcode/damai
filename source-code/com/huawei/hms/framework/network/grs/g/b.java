package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.a;
import com.huawei.hms.framework.network.grs.g.k.c;
import com.huawei.hms.framework.network.grs.h.e;
import org.json.JSONException;

/* compiled from: Taobao */
public class b {
    private final Context a;
    private final GrsBaseInfo b;
    private final a c;

    public b(Context context, a aVar, GrsBaseInfo grsBaseInfo) {
        this.a = context;
        this.b = grsBaseInfo;
        this.c = aVar;
    }

    public String a(boolean z) {
        String str;
        String str2 = com.huawei.hms.framework.network.grs.a.a(this.c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        String a2 = this.c.a().a("geoipCountryCodetime", "0");
        long j = 0;
        if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
            try {
                j = Long.parseLong(a2);
            } catch (NumberFormatException e) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        if (TextUtils.isEmpty(str2) || e.a(Long.valueOf(j))) {
            c cVar = new c(this.b, this.a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c2 = this.c.c();
            if (c2 != null) {
                try {
                    str = i.a(c2.a("services", ""), cVar.c());
                } catch (JSONException e2) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e2.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    c2.b("services", str);
                }
            }
            if (z) {
                d a3 = this.c.b().a(cVar, "geoip.countrycode", c2);
                if (a3 != null) {
                    str2 = com.huawei.hms.framework.network.grs.a.a(a3.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str2);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.c.b().a(cVar, null, "geoip.countrycode", c2);
            }
        }
        return str2;
    }
}
