package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class al extends a<String, String> {
    private String k;

    public al(Context context, String str) {
        super(context, str);
        this.k = str;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a = q.a(jSONObject, "code");
            String a2 = q.a(jSONObject, "message");
            if ("1".equals(a)) {
                return q.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a2);
            } else if ("2".equals(a)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, a2);
            } else if ("3".equals(a)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a2);
            } else if ("4".equals(a)) {
                throw new AMapException("用户签名未通过", 0, a2);
            } else if (!"5".equals(a)) {
                return null;
            } else {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a2);
            }
        } catch (JSONException e) {
            i.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a
    public final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.df
    public final Map<String, String> e() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.k));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.k);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a = bs.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = au.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", bp.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.f();
    }
}
