package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.db;
import com.xiaomi.push.fl;
import com.xiaomi.push.fw;
import com.xiaomi.push.gh;
import com.xiaomi.push.gn;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.bg;
import java.nio.ByteBuffer;
import java.util.Map;
import tb.o70;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ah {
    static fl a(XMPushService xMPushService, byte[] bArr) {
        Cif ifVar = new Cif();
        try {
            it.a(ifVar, bArr);
            return a(u.m870a((Context) xMPushService), xMPushService, ifVar);
        } catch (iz e) {
            b.a(e);
            return null;
        }
    }

    static fl a(t tVar, Context context, Cif ifVar) {
        try {
            fl flVar = new fl();
            flVar.a(5);
            flVar.c(tVar.f996a);
            flVar.b(a(ifVar));
            flVar.a("SECMSG", "message");
            String str = tVar.f996a;
            ifVar.f619a.f546a = str.substring(0, str.indexOf(o70.DINAMIC_PREFIX_AT));
            ifVar.f619a.f550c = str.substring(str.indexOf("/") + 1);
            flVar.a(it.a(ifVar), tVar.c);
            flVar.a((short) 1);
            b.m182a("try send mi push message. packagename:" + ifVar.f624b + " action:" + ifVar.f617a);
            return flVar;
        } catch (NullPointerException e) {
            b.a(e);
            return null;
        }
    }

    static Cif a(String str, String str2) {
        ii iiVar = new ii();
        iiVar.b(str2);
        iiVar.c("package uninstalled");
        iiVar.a(gn.i());
        iiVar.a(false);
        return a(str, str2, iiVar, hj.Notification);
    }

    static <T extends iu<T, ?>> Cif a(String str, String str2, T t, hj hjVar) {
        return a(str, str2, t, hjVar, true);
    }

    private static <T extends iu<T, ?>> Cif a(String str, String str2, T t, hj hjVar, boolean z) {
        byte[] a = it.a(t);
        Cif ifVar = new Cif();
        hy hyVar = new hy();
        hyVar.f545a = 5;
        hyVar.f546a = "fakeid";
        ifVar.a(hyVar);
        ifVar.a(ByteBuffer.wrap(a));
        ifVar.a(hjVar);
        ifVar.b(z);
        ifVar.b(str);
        ifVar.a(false);
        ifVar.a(str2);
        return ifVar;
    }

    private static String a(Cif ifVar) {
        Map<String, String> map;
        hw hwVar = ifVar.f618a;
        if (!(hwVar == null || (map = hwVar.f536b) == null)) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ifVar.f624b;
    }

    static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    static void a(XMPushService xMPushService) {
        t a = u.m870a(xMPushService.getApplicationContext());
        if (a != null) {
            bg.b a2 = u.m870a(xMPushService.getApplicationContext()).a(xMPushService);
            b.m182a("prepare account. " + a2.f925a);
            a(xMPushService, a2);
            bg.a().a(a2);
            bx.a(xMPushService).a(new ai("GAID", 172800, xMPushService, a));
            a(xMPushService, a, 172800);
        }
    }

    static void a(XMPushService xMPushService, Cif ifVar) {
        db.a(ifVar.b(), xMPushService.getApplicationContext(), ifVar, -1);
        fw a = xMPushService.m755a();
        if (a == null) {
            throw new gh("try send msg while connection is null.");
        } else if (a.m501a()) {
            fl a2 = a(u.m870a((Context) xMPushService), xMPushService, ifVar);
            if (a2 != null) {
                a.b(a2);
            }
        } else {
            throw new gh("Don't support XMPP connection.");
        }
    }

    static void a(XMPushService xMPushService, bg.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new ak(xMPushService));
    }

    private static void a(XMPushService xMPushService, t tVar, int i) {
        bx.a(xMPushService).a(new aj("MSAID", (long) i, xMPushService, tVar));
    }

    static void a(XMPushService xMPushService, String str, byte[] bArr) {
        db.a(str, xMPushService.getApplicationContext(), bArr);
        fw a = xMPushService.m755a();
        if (a == null) {
            throw new gh("try send msg while connection is null.");
        } else if (a.m501a()) {
            fl a2 = a(xMPushService, bArr);
            if (a2 != null) {
                a.b(a2);
            } else {
                x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        } else {
            throw new gh("Don't support XMPP connection.");
        }
    }

    static Cif b(String str, String str2) {
        ii iiVar = new ii();
        iiVar.b(str2);
        iiVar.c(ht.AppDataCleared.f497a);
        iiVar.a(bd.a());
        iiVar.a(false);
        return a(str, str2, iiVar, hj.Notification);
    }

    static <T extends iu<T, ?>> Cif b(String str, String str2, T t, hj hjVar) {
        return a(str, str2, t, hjVar, false);
    }
}
