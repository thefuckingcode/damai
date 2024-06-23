package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.service.bg;
import java.util.HashMap;

/* compiled from: Taobao */
class fk {
    public static void a(bg.b bVar, String str, fw fwVar) {
        String str2;
        dx.c cVar = new dx.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f927a ? "1" : "0");
        if (!TextUtils.isEmpty(bVar.d)) {
            cVar.c(bVar.d);
        } else {
            cVar.c("XIAOMI-SASL");
        }
        fl flVar = new fl();
        flVar.c(bVar.f928b);
        flVar.a(Integer.parseInt(bVar.g));
        flVar.b(bVar.f925a);
        flVar.a("BIND", (String) null);
        flVar.a(flVar.e());
        b.m182a("[Slim]: bind id=" + flVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f928b);
        hashMap.put("id", flVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f927a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            hashMap.put("client_attrs", bVar.e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            hashMap.put("cloud_attrs", bVar.f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
            str2 = bn.a(bVar.d, null, hashMap, bVar.h);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            str2 = null;
        }
        cVar.f(str2);
        flVar.a(cVar.m437a(), (String) null);
        fwVar.b(flVar);
    }

    public static void a(String str, String str2, fw fwVar) {
        fl flVar = new fl();
        flVar.c(str2);
        flVar.a(Integer.parseInt(str));
        flVar.a("UBND", (String) null);
        fwVar.b(flVar);
    }
}
