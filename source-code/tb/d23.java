package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.loc.bg;
import com.loc.j1;
import com.loc.l;
import com.loc.o1;
import com.loc.q1;
import com.loc.t1;
import com.loc.v1;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class d23 {
    public d23(Context context) {
        try {
            q1.a().c(context);
        } catch (Throwable unused) {
        }
        bg.b();
    }

    private String d(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            q53 q53 = new q53();
            hashMap.clear();
            hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            hashMap.put(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
            hashMap.put(IRequestConst.USER_AGENT, "AMAP_Location_SDK_Android 6.1.0");
            String a = o1.a();
            String c = o1.c(context, a, v1.s(map));
            map.put("ts", a);
            map.put("scode", c);
            q53.M(map);
            q53.J(hashMap);
            q53.L(str);
            q53.h(t1.c(context));
            q53.c(j1.i);
            q53.l(j1.i);
            try {
                return new String(bg.c(q53).a, "utf-8");
            } catch (Throwable th) {
                j1.h(th, "GeoFenceNetManager", gl1.TYPE_OPEN_URL_METHOD_POST);
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, String> e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", l.j(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(OneArchConstants.LayoutKey.KEY_WORDS, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(BQCCameraParam.FOCUS_AREA_RADIUS, str7);
        }
        return hashMap;
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> e = e(context, str2, null, null, null, null, null, null);
        e.put("extensions", "all");
        e.put("subdistrict", "0");
        return d(context, str, e);
    }

    public final String b(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> e = e(context, str2, str3, str4, str5, null, null, null);
        e.put(RichTextNode.CHILDREN, "1");
        e.put("page", "1");
        e.put("extensions", "base");
        return d(context, str, e);
    }

    public final String c(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> e = e(context, str2, str3, null, str4, str5, str6, str7);
        e.put(RichTextNode.CHILDREN, "1");
        e.put("page", "1");
        e.put("extensions", "base");
        return d(context, str, e);
    }
}
