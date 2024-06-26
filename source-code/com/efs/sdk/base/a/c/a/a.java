package com.efs.sdk.base.a.c.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import tb.j23;

/* compiled from: Taobao */
public final class a {
    public int a = -1;
    String b = "https://";
    private String c = "px.ucweb.com";
    private Boolean d = null;
    public Map<String, Double> e = new HashMap();
    public Map<String, String> f = new HashMap();

    private a() {
    }

    static a c() {
        a aVar = new a();
        aVar.c = com.efs.sdk.base.a.d.a.a().j ? "px-intl.ucweb.com" : "px.ucweb.com";
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        if (this.d == null) {
            this.d = Boolean.valueOf(j23.b(j23.a("debug_host")));
        }
        return this.d.booleanValue() ? "px1.test.uae-2.uc.cn" : this.c;
    }

    /* access modifiers changed from: package-private */
    public final void b(@NonNull Map<String, String> map) {
        if (map.containsKey(WPKFactory.INIT_KEY_GATE_WAY)) {
            String str = map.get(WPKFactory.INIT_KEY_GATE_WAY);
            if (!TextUtils.isEmpty(str)) {
                this.c = str;
            }
        }
        if (map.containsKey(WPKFactory.INIT_KEY_GATE_WAY_HTTPS)) {
            String str2 = map.get(WPKFactory.INIT_KEY_GATE_WAY_HTTPS);
            if (!TextUtils.isEmpty(str2)) {
                this.b = Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String replace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                double d2 = 100.0d;
                try {
                    d2 = Double.parseDouble(entry.getValue());
                } catch (Throwable unused) {
                }
                hashMap.put(replace, Double.valueOf(d2));
            }
        }
        this.e = hashMap;
        this.f = map;
    }
}
