package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hi;
import com.xiaomi.push.m;
import com.xiaomi.push.service.bg;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: Taobao */
public class j {
    private y a = new y();

    public static String a(bg.b bVar) {
        StringBuilder sb;
        String str;
        if (!"9".equals(bVar.g)) {
            sb = new StringBuilder();
            sb.append(bVar.f925a);
            str = ".permission.MIPUSH_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f925a);
            str = ".permission.MIMC_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, bg.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    /* access modifiers changed from: package-private */
    public bg.b a(fl flVar) {
        Collection<bg.b> a2 = bg.a().m823a(Integer.toString(flVar.a()));
        if (a2.isEmpty()) {
            return null;
        }
        Iterator<bg.b> it = a2.iterator();
        if (a2.size() == 1) {
            return it.next();
        }
        String g = flVar.g();
        while (it.hasNext()) {
            bg.b next = it.next();
            if (TextUtils.equals(g, next.f928b)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    public bg.b a(gn gnVar) {
        Collection<bg.b> a2 = bg.a().m823a(gnVar.k());
        if (a2.isEmpty()) {
            return null;
        }
        Iterator<bg.b> it = a2.iterator();
        if (a2.size() == 1) {
            return it.next();
        }
        String m = gnVar.m();
        String l = gnVar.l();
        while (it.hasNext()) {
            bg.b next = it.next();
            if (TextUtils.equals(m, next.f928b) || TextUtils.equals(l, next.f928b)) {
                return next;
            }
            while (it.hasNext()) {
            }
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (m.m739c()) {
            intent.addFlags(16777216);
        }
        b.m182a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f925a);
            intent.putExtra(bk.t, bVar.g);
            intent.putExtra("ext_reason", i);
            intent.putExtra(bk.q, bVar.f928b);
            intent.putExtra(bk.F, bVar.i);
            if (bVar.f919a == null || !"9".equals(bVar.g)) {
                b.m182a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f925a, Integer.valueOf(i)));
                a(context, intent, bVar);
                return;
            }
            try {
                bVar.f919a.send(Message.obtain(null, 17, intent));
            } catch (RemoteException unused) {
                bVar.f919a = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str = bVar.f928b;
                sb.append(str.substring(str.lastIndexOf(64)));
                b.m182a(sb.toString());
            }
        }
    }

    public void a(Context context, bg.b bVar, String str, String str2) {
        if (bVar == null) {
            b.d("error while notify kick by server!");
        } else if ("5".equalsIgnoreCase(bVar.g)) {
            b.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f925a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.g);
            intent.putExtra(bk.q, bVar.f928b);
            intent.putExtra(bk.F, bVar.i);
            b.m182a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f925a, str2));
            a(context, intent, bVar);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f925a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(bk.q, bVar.f928b);
        intent.putExtra(bk.F, bVar.i);
        b.m182a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f925a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fl flVar) {
        ao aoVar;
        bg.b a2 = a(flVar);
        if (a2 == null) {
            b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, flVar, a2);
        } else {
            String str2 = a2.f925a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", flVar.m486a(a2.h));
            intent.putExtra(bk.F, a2.i);
            intent.putExtra(bk.x, a2.h);
            if (a2.f919a != null) {
                try {
                    a2.f919a.send(Message.obtain(null, 17, intent));
                    b.m182a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a2.f919a = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("peer may died: ");
                    String str3 = a2.f928b;
                    sb.append(str3.substring(str3.lastIndexOf(64)));
                    b.m182a(sb.toString());
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                b.m182a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a2.g, a2.f925a, flVar.e()));
                a(xMPushService, intent, a2);
                if ("10".equals(str) && (aoVar = flVar.f364a) != null) {
                    aoVar.d = System.currentTimeMillis();
                    if (hi.a(xMPushService, 1)) {
                        bz.a("category_coord_down", "coord_down", "com.xiaomi.xmsf", flVar.f364a);
                    }
                }
            }
        }
    }

    public void a(XMPushService xMPushService, String str, gn gnVar) {
        String str2;
        String str3;
        bg.b a2 = a(gnVar);
        if (a2 == null) {
            str3 = "error while notify channel closed! channel " + str + " not registered";
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, gnVar, a2);
            return;
        } else {
            String str4 = a2.f925a;
            if (gnVar instanceof gm) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (gnVar instanceof gl) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (gnVar instanceof gp) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                str3 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", gnVar.a());
            intent.putExtra(bk.F, a2.i);
            intent.putExtra(bk.x, a2.h);
            b.m182a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a2.g, a2.f925a, gnVar.j()));
            a(xMPushService, intent, a2);
            return;
        }
        b.d(str3);
    }
}
