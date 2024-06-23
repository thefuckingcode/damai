package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.huawei.hms.opendevice.c;
import com.xiaomi.push.h;
import com.xiaomi.push.m;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.v;
import com.xiaomi.push.w;
import java.util.Locale;
import tb.fw0;

/* compiled from: Taobao */
public class t {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f996a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public t(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f996a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }

    private static String a(Context context) {
        if (!"com.xiaomi.xmsf".equals(context)) {
            return m.b();
        }
        if (!TextUtils.isEmpty(null)) {
            return null;
        }
        String a2 = m.m732a("ro.miui.region");
        return TextUtils.isEmpty(a2) ? m.m732a("ro.product.locale.region") : a2;
    }

    public static boolean a() {
        try {
            return v.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m869a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public bg.b a(XMPushService xMPushService) {
        bg.b bVar = new bg.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m760b(), c.a);
        return bVar;
    }

    public bg.b a(bg.b bVar, Context context, j jVar, String str) {
        bVar.f925a = context.getPackageName();
        bVar.f928b = this.f996a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f927a = false;
        w.a aVar = new w.a();
        aVar.a("sdk_ver", 48).a("cpvn", "4_9_1").a("cpvc", 40091).a(RegistConstants.REGISTER_COUNTRY_CODE, a.a(context).b()).a(RegistConstants.REGION_INFO, a.a(context).a()).a("miui_vn", m.c()).a("miui_vc", Integer.valueOf(m.a(context))).a("xmsf_vc", Integer.valueOf(h.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(ax.m809a(context))).a("systemui_vc", Integer.valueOf(h.a(context)));
        String a2 = a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.a("latest_country_code", a2);
        }
        String d2 = m.d();
        if (!TextUtils.isEmpty(d2)) {
            aVar.a("device_ch", d2);
        }
        String e2 = m.e();
        if (!TextUtils.isEmpty(e2)) {
            aVar.a("device_mfr", e2);
        }
        bVar.e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.d;
        w.a aVar2 = new w.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m869a(context)) {
            aVar2.a(fw0.VALUE_MODEL_DEFAULT, str);
        }
        bVar.f = aVar2.toString();
        bVar.f924a = jVar;
        return bVar;
    }
}
