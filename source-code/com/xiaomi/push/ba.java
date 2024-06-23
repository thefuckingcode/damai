package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

/* compiled from: Taobao */
public class ba implements au {
    private static volatile ba a;

    /* renamed from: a  reason: collision with other field name */
    private int f120a = az.a;

    /* renamed from: a  reason: collision with other field name */
    private au f121a;

    private ba(Context context) {
        this.f121a = az.a(context);
        b.m182a("create id manager is: " + this.f120a);
    }

    public static ba a(Context context) {
        if (a == null) {
            synchronized (ba.class) {
                if (a == null) {
                    a = new ba(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    public String a() {
        return a(this.f121a.a());
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public void m274a() {
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            String b = b();
            if (!TextUtils.isEmpty(b)) {
                map.put("udid", b);
            }
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                map.put(IRequestConst.OAID, a2);
            }
            String c = c();
            if (!TextUtils.isEmpty(c)) {
                map.put("vaid", c);
            }
            String d = d();
            if (!TextUtils.isEmpty(d)) {
                map.put("aaid", d);
            }
            map.put("oaid_type", String.valueOf(this.f120a));
        }
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public boolean m275a() {
        return this.f121a.m256a();
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }
}
