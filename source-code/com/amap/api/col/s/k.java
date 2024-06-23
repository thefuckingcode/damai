package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class k extends b<DistrictSearchQuery, DistrictResult> {
    public k(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public DistrictResult a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult(((a) this).b, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT));
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                return districtResult;
            }
            q.a(optJSONArray, arrayList, null);
            return districtResult;
        } catch (JSONException e) {
            i.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            i.a(e2, "DistrictServerHandler", "paseJSONException");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((a) this).b.getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((a) this).b.getPageSize());
        if (((a) this).b.isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((a) this).b.checkKeyWords()) {
            String b = b.b(((a) this).b.getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&key=" + bk.f(((a) this).e));
        stringBuffer.append("&subdistrict=" + String.valueOf(((a) this).b.getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/config/district?";
    }
}
