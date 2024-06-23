package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.db;
import com.xiaomi.push.eo;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.gk;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.h;
import com.xiaomi.push.hb;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.fw0;

/* compiled from: Taobao */
public class y {
    public static Intent a(byte[] bArr, long j) {
        Cif a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f624b);
        return intent;
    }

    public static Cif a(Context context, Cif ifVar) {
        return a(context, ifVar, (Map<String, String>) null);
    }

    public static Cif a(Context context, Cif ifVar, Map<String, String> map) {
        hz hzVar = new hz();
        hzVar.b(ifVar.m618a());
        hw a = ifVar.m617a();
        if (a != null) {
            hzVar.a(a.m583a());
            hzVar.a(a.m581a());
            if (!TextUtils.isEmpty(a.m588b())) {
                hzVar.c(a.m588b());
            }
        }
        hzVar.a(it.a(context, ifVar));
        Cif a2 = ah.a(ifVar.b(), ifVar.m618a(), hzVar, hj.AckMessage);
        hw a3 = ifVar.m617a();
        if (a3 != null) {
            a3 = br.a(a3.m582a());
        }
        a3.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        a3.a(str, map.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a2.a(a3);
        return a2;
    }

    public static Cif a(byte[] bArr) {
        Cif ifVar = new Cif();
        try {
            it.a(ifVar, bArr);
            return ifVar;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static void a(Context context, Cif ifVar, byte[] bArr) {
        try {
            al.a(ifVar);
            ifVar.m617a();
            al.c a = al.m792a(context, ifVar, bArr);
            if (a.a > 0 && !TextUtils.isEmpty(a.f887a)) {
                hb.a(context, a.f887a, a.a, true, false, System.currentTimeMillis());
            }
            if (!m.m735a(context) || !ag.a(context, ifVar, a.f888a)) {
                b(context, ifVar, bArr);
                return;
            }
            ag.m787a(context, ifVar);
            b.m182a("consume this broadcast by tts");
        } catch (Exception e) {
            b.m182a("notify push msg error " + e);
            e.printStackTrace();
        }
    }

    private static void a(XMPushService xMPushService, Cif ifVar) {
        xMPushService.a(new z(4, xMPushService, ifVar));
    }

    private static void a(XMPushService xMPushService, Cif ifVar, ii iiVar) {
        xMPushService.a(new af(4, iiVar, ifVar, xMPushService));
    }

    private static void a(XMPushService xMPushService, Cif ifVar, String str) {
        xMPushService.a(new ad(4, xMPushService, ifVar, str));
    }

    private static void a(XMPushService xMPushService, Cif ifVar, String str, String str2) {
        xMPushService.a(new ae(4, xMPushService, ifVar, str, str2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x03a3 A[SYNTHETIC, Splitter:B:128:0x03a3] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0427  */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        boolean z;
        ii iiVar;
        String str2;
        int i;
        eo a;
        String b;
        String a2;
        int i2;
        String str3;
        String str4;
        eo a3;
        String b2;
        String b3;
        String a4;
        String str5;
        String str6;
        Cif a5 = a(bArr);
        hw a6 = a5.m617a();
        iu iuVar = null;
        String str7 = null;
        if (bArr != null) {
            db.a(a5.b(), xMPushService.getApplicationContext(), null, a5.a(), bArr.length);
        }
        if (c(a5) && a(xMPushService, str)) {
            if (al.e(a5)) {
                eo.a(xMPushService.getApplicationContext()).a(a5.b(), al.b(a5), a6.m583a(), "5");
            }
            c(xMPushService, a5);
        } else if (a(a5) && !a(xMPushService, str) && !b(a5)) {
            if (al.e(a5)) {
                eo.a(xMPushService.getApplicationContext()).a(a5.b(), al.b(a5), a6.m583a(), "6");
            }
            d(xMPushService, a5);
        } else if ((al.m796a(a5) && h.m541b((Context) xMPushService, a5.f624b)) || a(xMPushService, intent)) {
            boolean z2 = false;
            if (hj.Registration == a5.a()) {
                String b4 = a5.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b4, a5.f620a);
                edit.commit();
                ik a7 = n.a(a5);
                if (a7.a() != 0 || TextUtils.isEmpty(a7.b())) {
                    b.d("read regSecret failed");
                } else {
                    n.a(xMPushService, b4, a7.b());
                }
                v.a(xMPushService).e(b4);
                v.a(xMPushService).f(b4);
                eo.a(xMPushService.getApplicationContext()).a(b4, "E100003", a6.m583a(), 6003, null);
                if (!TextUtils.isEmpty(a6.m583a())) {
                    intent.putExtra("messageId", a6.m583a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (al.c(a5)) {
                eo.a(xMPushService.getApplicationContext()).a(a5.b(), al.b(a5), a6.m583a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(a6.m583a())) {
                    intent.putExtra("messageId", a6.m583a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (al.m800b(a5)) {
                eo.a(xMPushService.getApplicationContext()).a(a5.b(), al.b(a5), a6.m583a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(a6.m583a())) {
                    intent.putExtra("messageId", a6.m583a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (al.m796a(a5)) {
                eo.a(xMPushService.getApplicationContext()).a(a5.b(), al.b(a5), a6.m583a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(a6.m583a())) {
                    intent.putExtra("messageId", a6.m583a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (a6 != null && !TextUtils.isEmpty(a6.m591c()) && !TextUtils.isEmpty(a6.d()) && a6.f534b != 1 && !al.m795a((Context) xMPushService, a5.f624b, al.m797a(a6.m584a()))) {
                Map<String, String> map = a6.f532a;
                if (map != null) {
                    str7 = map.get("jobkey");
                }
                if (TextUtils.isEmpty(str7)) {
                    str7 = a6.m583a();
                }
                if (an.a(xMPushService, a5.f624b, str7)) {
                    eo.a(xMPushService.getApplicationContext()).c(a5.b(), al.b(a5), a6.m583a(), "1:" + str7);
                    str6 = "drop a duplicate message, key=" + str7;
                } else if (!m.m735a((Context) xMPushService) || !ag.m788a(a5)) {
                    a(xMPushService, a5, bArr);
                    b(xMPushService, a5);
                } else {
                    str6 = "receive pull down message";
                }
                b.m182a(str6);
                b(xMPushService, a5);
            } else if ("com.xiaomi.xmsf".contains(a5.f624b) && !a5.m625b() && a6 != null && a6.m584a() != null && a6.m584a().containsKey(fw0.VALUE_MODEL_DEFAULT)) {
                b(xMPushService, a5);
                b.c("receive abtest message. ack it." + a6.m583a());
            } else if (a(xMPushService, str, a5, a6)) {
                if (a6 != null && !TextUtils.isEmpty(a6.m583a())) {
                    if (al.m800b(a5)) {
                        a = eo.a(xMPushService.getApplicationContext());
                        b = a5.b();
                        str4 = al.b(a5);
                        a2 = a6.m583a();
                        i2 = 2002;
                        str3 = null;
                    } else {
                        if (al.m796a(a5)) {
                            a3 = eo.a(xMPushService.getApplicationContext());
                            b2 = a5.b();
                            b3 = al.b(a5);
                            a4 = a6.m583a();
                            str5 = "7";
                        } else if (al.c(a5)) {
                            a3 = eo.a(xMPushService.getApplicationContext());
                            b2 = a5.b();
                            b3 = al.b(a5);
                            a4 = a6.m583a();
                            str5 = "8";
                        } else if (al.d(a5)) {
                            a = eo.a(xMPushService.getApplicationContext());
                            b = a5.b();
                            a2 = a6.m583a();
                            i2 = 6004;
                            str3 = null;
                            str4 = "E100003";
                        }
                        a3.a(b2, b3, a4, str5);
                    }
                    a.a(b, str4, a2, i2, str3);
                }
                if (hj.Notification == a5.f617a) {
                    try {
                        iuVar = ce.a(xMPushService, a5);
                        if (iuVar == null) {
                            b.d("receiving an un-recognized notification message. " + a5.f617a);
                            z = false;
                            if (z && (iuVar instanceof ii)) {
                                iiVar = (ii) iuVar;
                                if (ht.CancelPushMessage.f497a.equals(iiVar.f641d) && iiVar.m633a() != null) {
                                    str2 = iiVar.m633a().get(bk.M);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            i = Integer.parseInt(str2);
                                        } catch (NumberFormatException e) {
                                            b.m182a("parse notifyId from STRING to INT failed: " + e);
                                        }
                                    }
                                    if (i < -1) {
                                        b.m182a("try to retract a message by notifyId=" + i);
                                        al.a(xMPushService, a5.f624b, i);
                                    } else {
                                        b.m182a("try to retract a message by title&description.");
                                        al.a(xMPushService, a5.f624b, iiVar.m633a().get(bk.K), iiVar.m633a().get(bk.L));
                                    }
                                    if (a6 != null && a6.m584a() != null && m.m735a((Context) xMPushService) && "pulldown".equals(ay.a((Object) a6.m584a()))) {
                                        ag.a(a5);
                                    }
                                    a(xMPushService, a5, iiVar);
                                    if (z2) {
                                        b.m182a("broadcast passthrough message.");
                                        xMPushService.sendBroadcast(intent, ah.a(a5.f624b));
                                    }
                                }
                            }
                        } else {
                            z = true;
                            iiVar = (ii) iuVar;
                            str2 = iiVar.m633a().get(bk.M);
                            i = -2;
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            if (i < -1) {
                            }
                            ag.a(a5);
                            a(xMPushService, a5, iiVar);
                            if (z2) {
                            }
                        }
                    } catch (iz e2) {
                        b.d("receive a message which action string is not valid. " + e2);
                    }
                }
                z2 = true;
                if (z2) {
                }
            } else {
                eo.a(xMPushService.getApplicationContext()).a(a5.b(), al.b(a5), a6.m583a(), "9");
            }
            if (a5.a() == hj.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                xMPushService.stopSelf();
            }
        } else if (!h.m541b((Context) xMPushService, a5.f624b)) {
            if (al.e(a5)) {
                eo.a(xMPushService.getApplicationContext()).b(a5.b(), al.b(a5), a6.m583a(), "2");
            }
            a(xMPushService, a5);
        } else {
            b.m182a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (al.e(a5)) {
                eo.a(xMPushService.getApplicationContext()).b(a5.b(), al.b(a5), a6.m583a(), "3");
            }
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> a;
        Cif a2 = a(bArr);
        if (a2 != null) {
            if (TextUtils.isEmpty(a2.f624b)) {
                b.m182a("receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a3 = a(bArr, valueOf.longValue());
            String a4 = al.a(a2);
            hb.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
            hw a5 = a2.m617a();
            if (!(a5 == null || a5.m583a() == null)) {
                b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a2.m618a(), bd.a(a5.m583a()), a2.a()));
            }
            if (a5 != null) {
                a5.a("mrt", Long.toString(valueOf.longValue()));
            }
            hj hjVar = hj.SendMessage;
            String str = "";
            if (hjVar == a2.a() && v.a(xMPushService).m874a(a2.f624b) && !al.m796a(a2)) {
                if (a5 != null) {
                    str = a5.m583a();
                    if (al.e(a2)) {
                        eo.a(xMPushService.getApplicationContext()).a(a2.b(), al.b(a2), str, "1");
                    }
                }
                b.m182a("Drop a message for unregistered, msgid=" + str);
                a(xMPushService, a2, a2.f624b);
            } else if (hjVar == a2.a() && v.a(xMPushService).m876c(a2.f624b) && !al.m796a(a2)) {
                if (a5 != null) {
                    str = a5.m583a();
                    if (al.e(a2)) {
                        eo.a(xMPushService.getApplicationContext()).a(a2.b(), al.b(a2), str, "2");
                    }
                }
                b.m182a("Drop a message for push closed, msgid=" + str);
                a(xMPushService, a2, a2.f624b);
            } else if (hjVar == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f624b)) {
                b.m182a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f624b);
                a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f624b);
                if (a5 != null && al.e(a2)) {
                    eo.a(xMPushService.getApplicationContext()).a(a2.b(), al.b(a2), a5.m583a(), "3");
                }
            } else if (hjVar == a2.a() && j.a() == 999 && j.a(xMPushService, a4)) {
                b.m182a("Receive the uninstalled dual app message");
                try {
                    ah.a(xMPushService, ah.a(a4, a2.m618a()));
                    b.m182a("uninstall " + a4 + " msg sent");
                } catch (gh e) {
                    b.d("Fail to send Message: " + e.getMessage());
                    xMPushService.a(10, e);
                }
                al.m793a((Context) xMPushService, a4);
            } else if (a5 == null || (a = a5.m584a()) == null || !a.containsKey("hide") || !"true".equalsIgnoreCase(a.get("hide"))) {
                a(xMPushService, a4, bArr, a3);
            } else {
                b(xMPushService, a2);
            }
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return !packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() || !packageManager.queryIntentServices(intent, 32).isEmpty();
        } catch (Exception e) {
            b.a(e);
            return false;
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!h.m539a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            b.m182a("broadcast message arrived.");
            context.sendBroadcast(intent, ah.a(str));
            return true;
        } catch (Exception e) {
            b.m182a("meet error when broadcast message arrived. " + e);
            return false;
        }
    }

    private static boolean a(Cif ifVar) {
        return "com.xiaomi.xmsf".equals(ifVar.f624b) && ifVar.m617a() != null && ifVar.m617a().m584a() != null && ifVar.m617a().m584a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, Cif ifVar, hw hwVar) {
        boolean z = true;
        if (hwVar != null && hwVar.m584a() != null && hwVar.m584a().containsKey("__check_alive") && hwVar.m584a().containsKey("__awake")) {
            ii iiVar = new ii();
            iiVar.b(ifVar.m618a());
            iiVar.d(str);
            iiVar.c(ht.AwakeSystemApp.f497a);
            iiVar.a(hwVar.m583a());
            iiVar.f636a = new HashMap();
            boolean a = h.m539a(xMPushService.getApplicationContext(), str);
            iiVar.f636a.put("app_running", Boolean.toString(a));
            if (!a) {
                boolean parseBoolean = Boolean.parseBoolean(hwVar.m584a().get("__awake"));
                iiVar.f636a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ah.a(xMPushService, ah.a(ifVar.b(), ifVar.m618a(), iiVar, hj.Notification));
            } catch (gh e) {
                b.a(e);
            }
        }
        return z;
    }

    private static void b(Context context, Cif ifVar, byte[] bArr) {
        if (!al.m796a(ifVar)) {
            String a = al.a(ifVar);
            if (!TextUtils.isEmpty(a) && !a(context, a, bArr)) {
                eo.a(context).b(a, al.b(ifVar), ifVar.m617a().m583a(), "1");
            }
        }
    }

    private static void b(XMPushService xMPushService, Cif ifVar) {
        xMPushService.a(new aa(4, xMPushService, ifVar));
    }

    private static boolean b(Cif ifVar) {
        Map<String, String> a = ifVar.m617a().m584a();
        return a != null && a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, Cif ifVar) {
        xMPushService.a(new ab(4, xMPushService, ifVar));
    }

    private static boolean c(Cif ifVar) {
        if (ifVar.m617a() == null || ifVar.m617a().m584a() == null) {
            return false;
        }
        return "1".equals(ifVar.m617a().m584a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, Cif ifVar) {
        xMPushService.a(new ac(4, xMPushService, ifVar));
    }

    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        t a;
        if (!z && (a = u.m870a(context)) != null && "token-expired".equals(str)) {
            u.a(context, a.f, a.d, a.e);
        }
    }

    public void a(XMPushService xMPushService, fl flVar, bg.b bVar) {
        try {
            a(xMPushService, flVar.m486a(bVar.h), (long) flVar.c());
        } catch (IllegalArgumentException e) {
            b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gn gnVar, bg.b bVar) {
        if (gnVar instanceof gm) {
            gm gmVar = (gm) gnVar;
            gk a = gmVar.a("s");
            if (a != null) {
                try {
                    a(xMPushService, bp.a(bp.a(bVar.h, gmVar.j()), a.c()), (long) hb.a(gnVar.m523a()));
                } catch (IllegalArgumentException e) {
                    b.a(e);
                }
            }
        } else {
            b.m182a("not a mipush message");
        }
    }
}
