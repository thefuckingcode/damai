package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.f.a;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class e {
    public static f a(Context context) {
        if (context == null) {
            return null;
        }
        String a = a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (com.alipay.sdk.m.z.a.a(a)) {
            a = a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (com.alipay.sdk.m.z.a.a(a)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(a);
            f fVar = new f();
            fVar.a(jSONObject.getString("imei"));
            fVar.b(jSONObject.getString("imsi"));
            fVar.c(jSONObject.getString("mac"));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }
}
