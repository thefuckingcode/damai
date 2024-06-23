package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class d<T> extends b<T, Object> {
    private int k = 0;
    private List<String> l = new ArrayList();
    private List<SuggestionCity> m = new ArrayList();

    public d(Context context, T t) {
        super(context, t);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.m = q.a(optJSONObject);
                this.l = q.b(optJSONObject);
            }
            this.k = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
            if (((a) this).b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult(((a) this).b, this.k, this.m, this.l, q.f(jSONObject));
            }
            return BusStationResult.createPagedResult(((a) this).b, this.k, this.m, this.l, q.e(jSONObject));
        } catch (Exception e) {
            i.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((a) this).b;
        if (t instanceof BusLineQuery) {
            T t2 = t;
            if (!TextUtils.isEmpty(t2.getExtensions())) {
                sb.append("&extensions=");
                sb.append(t2.getExtensions());
            } else {
                sb.append("&extensions=base");
            }
            if (t2.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b.b(((a) this).b.getQueryString()));
            } else {
                String city = t2.getCity();
                if (!q.g(city)) {
                    String b = b.b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + b.b(t2.getQueryString()));
                sb.append("&offset=" + t2.getPageSize());
                sb.append("&page=" + t2.getPageNumber());
            }
        } else {
            T t3 = t;
            String city2 = t3.getCity();
            if (!q.g(city2)) {
                String b2 = b.b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + b.b(t3.getQueryString()));
            sb.append("&offset=" + t3.getPageSize());
            sb.append("&page=" + t3.getPageNumber());
        }
        sb.append("&key=" + bk.f(((a) this).e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str;
        T t = ((a) this).b;
        if (t instanceof BusLineQuery) {
            str = t.getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((a) this).b.getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        } else {
            str = "stopname";
        }
        return h.a() + "/bus/" + str + "?";
    }
}
