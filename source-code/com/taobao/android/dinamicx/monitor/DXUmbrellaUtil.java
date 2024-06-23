package com.taobao.android.dinamicx.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.Map;
import tb.f10;
import tb.js;
import tb.ry;

/* compiled from: Taobao */
public class DXUmbrellaUtil {
    private static js a;

    /* access modifiers changed from: private */
    public static String g(String str) {
        return str + "_umbrella2";
    }

    private static Map<String, Object> h(DXTemplateItem dXTemplateItem, e.a aVar) {
        HashMap hashMap = new HashMap();
        if (dXTemplateItem != null) {
            hashMap.put(f10.a, dXTemplateItem.name);
            hashMap.put(f10.b, Long.valueOf(dXTemplateItem.version));
            hashMap.put(f10.c, dXTemplateItem.templateUrl);
        }
        if (aVar != null) {
            hashMap.put(f10.d, aVar.b);
        }
        return hashMap;
    }

    public static void i(e eVar, boolean z) {
    }

    /* access modifiers changed from: private */
    public static void j(String str, DXTemplateItem dXTemplateItem, e.a aVar) {
        if (aVar != null) {
            String g = g(aVar.c);
            m();
            Map<String, String> l = l(str, g, aVar.b, dXTemplateItem, aVar.f);
            String str2 = "" + aVar.d;
            String str3 = aVar.e;
            if (l != null) {
                l.put("errorMsg", str3);
                l.put("errorCode", str2);
            }
            throw null;
        }
    }

    public static void k(int i, @NonNull String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map, double d) {
    }

    /* access modifiers changed from: private */
    public static Map<String, String> l(String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("bizName", ry.TAG);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sceneName", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("serviceId", str3);
        } else {
            hashMap.put("serviceId", "DX_Default_Service_Id");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("featureType", str2);
        }
        hashMap.put("version", m());
        hashMap.put("samplingRate", "1.0");
        if (dXTemplateItem != null) {
            if (!TextUtils.isEmpty(dXTemplateItem.name)) {
                hashMap.put("templateName", dXTemplateItem.name);
            }
            hashMap.put("templateVersion", dXTemplateItem.version + "");
            if (!TextUtils.isEmpty(dXTemplateItem.templateUrl)) {
                hashMap.put("templateUrl", dXTemplateItem.templateUrl);
            }
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry == null || entry.getKey() == null || entry.getValue() == null)) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static String m() {
        return LiveFullInfo.VER;
    }

    /* access modifiers changed from: private */
    public static void n(String str, DXTemplateItem dXTemplateItem, e.a aVar) {
        if (aVar != null) {
            String g = g(aVar.c);
            String str2 = "" + aVar.d;
            String str3 = aVar.e;
            h(dXTemplateItem, aVar);
            HashMap hashMap = new HashMap();
            Map<String, String> l = l(str, g, aVar.b, dXTemplateItem, aVar.f);
            if (l != null) {
                l.put("errorMsg", str3);
                l.put("errorCode", str2);
            }
            hashMap.put("args", l);
            throw null;
        }
    }
}
