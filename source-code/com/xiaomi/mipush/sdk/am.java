package com.xiaomi.mipush.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bp;
import com.xiaomi.push.bx;
import com.xiaomi.push.db;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import com.xiaomi.push.hj;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.br;
import com.xiaomi.push.service.i;
import com.xiaomi.push.t;
import com.xiaomi.push.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* compiled from: Taobao */
public class am {
    private static am a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f43a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f44a;

    /* renamed from: a  reason: collision with other field name */
    private Context f45a;

    private am(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f45a = applicationContext;
        if (applicationContext == null) {
            this.f45a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return al.b(context, str, map, i);
    }

    private PushMessageHandler.a a(Cif ifVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        eo a2;
        String packageName;
        String a3;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        String str5;
        int i2;
        String str6;
        String str7;
        eo eoVar;
        ArrayList arrayList = null;
        try {
            iu a4 = ai.a(this.f45a, ifVar);
            if (a4 == null) {
                b.d("receiving an un-recognized message. " + ifVar.f617a);
                eo.a(this.f45a).b(this.f45a.getPackageName(), en.m443a(i), str, "18");
                s.c(this.f45a, ifVar, z);
                return null;
            }
            hj a5 = ifVar.a();
            b.m182a("processing a message, action=" + a5);
            switch (an.a[a5.ordinal()]) {
                case 1:
                    if (!ifVar.m625b()) {
                        b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (!b.m219a(this.f45a).m230e() || z) {
                        im imVar = (im) a4;
                        hv a6 = imVar.a();
                        if (a6 == null) {
                            b.d("receive an empty message without push content, drop it");
                            eo.a(this.f45a).b(this.f45a.getPackageName(), en.m443a(i), str, "22");
                            s.d(this.f45a, ifVar, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (al.m796a(ifVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f45a, a6.m575a(), ifVar.m617a(), ifVar.f624b, a6.b());
                            } else {
                                hw hwVar = ifVar.m617a() != null ? new hw(ifVar.m617a()) : new hw();
                                if (hwVar.m584a() == null) {
                                    hwVar.a(new HashMap());
                                }
                                hwVar.m584a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f45a, a6.m575a(), hwVar, a6.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(imVar.d()) && MiPushClient.aliasSetTime(this.f45a, imVar.d()) < 0) {
                                MiPushClient.addAlias(this.f45a, imVar.d());
                            } else if (!TextUtils.isEmpty(imVar.c()) && MiPushClient.topicSubscribedTime(this.f45a, imVar.c()) < 0) {
                                MiPushClient.addTopic(this.f45a, imVar.c());
                            }
                        }
                        hw hwVar2 = ifVar.f618a;
                        if (hwVar2 == null || hwVar2.m584a() == null) {
                            str4 = null;
                            str3 = null;
                        } else {
                            str4 = ifVar.f618a.f532a.get("jobkey");
                            str3 = str4;
                        }
                        if (TextUtils.isEmpty(str4)) {
                            str4 = a6.m575a();
                        }
                        if (z || !m202a(this.f45a, str4)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, ifVar.m617a(), z);
                            if (generateMessage.getPassThrough() != 0 || z || !al.m797a(generateMessage.getExtra())) {
                                b.m182a("receive a message, msgid=" + a6.m575a() + ", jobkey=" + str4 + ", btn=" + intExtra);
                                String a7 = al.a(generateMessage.getExtra(), intExtra);
                                if (!z || generateMessage.getExtra() == null || TextUtils.isEmpty(a7)) {
                                    miPushMessage = generateMessage;
                                } else {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    if (!(intExtra == 0 || ifVar.m617a() == null)) {
                                        ao.a(this.f45a).a(ifVar.m617a().c(), intExtra);
                                    }
                                    if (al.m796a(ifVar)) {
                                        Intent a8 = a(this.f45a, ifVar.f624b, extra, intExtra);
                                        a8.putExtra("eventMessageType", i);
                                        a8.putExtra("messageId", str);
                                        a8.putExtra("jobkey", str3);
                                        String c = a6.c();
                                        if (!TextUtils.isEmpty(c)) {
                                            a8.putExtra("payload", c);
                                        }
                                        this.f45a.startActivity(a8);
                                        s.a(this.f45a, ifVar);
                                        eo.a(this.f45a).a(this.f45a.getPackageName(), en.m443a(i), str, 3006, a7);
                                        return null;
                                    }
                                    Context context = this.f45a;
                                    Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                    if (a9 == null) {
                                        return null;
                                    }
                                    if (!a7.equals(bk.c)) {
                                        a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a9.putExtra("eventMessageType", i);
                                        a9.putExtra("messageId", str);
                                        a9.putExtra("jobkey", str3);
                                    }
                                    this.f45a.startActivity(a9);
                                    s.a(this.f45a, ifVar);
                                    b.m182a("start activity succ");
                                    eo.a(this.f45a).a(this.f45a.getPackageName(), en.m443a(i), str, 1006, a7);
                                    if (!a7.equals(bk.c)) {
                                        return null;
                                    }
                                    eo.a(this.f45a).a(this.f45a.getPackageName(), en.m443a(i), str, "13");
                                    return null;
                                }
                            } else {
                                al.m792a(this.f45a, ifVar, bArr);
                                return null;
                            }
                        } else {
                            b.m182a("drop a duplicate message, key=" + str4);
                            eo a10 = eo.a(this.f45a);
                            String packageName2 = this.f45a.getPackageName();
                            String a11 = en.m443a(i);
                            a10.c(packageName2, a11, str, "2:" + str4);
                            miPushMessage = null;
                        }
                        if (ifVar.m617a() == null && !z) {
                            a(imVar, ifVar);
                        }
                        return miPushMessage;
                    } else {
                        b.m182a("receive a message in pause state. drop it");
                        eo.a(this.f45a).a(this.f45a.getPackageName(), en.m443a(i), str, "12");
                        return null;
                    }
                case 2:
                    ik ikVar = (ik) a4;
                    String str8 = b.m219a(this.f45a).f62a;
                    if (TextUtils.isEmpty(str8) || !TextUtils.equals(str8, ikVar.m646a())) {
                        b.m182a("bad Registration result:");
                        eo.a(this.f45a).b(this.f45a.getPackageName(), en.m443a(i), str, "21");
                        return null;
                    }
                    long a12 = ao.a(this.f45a).m209a();
                    if (a12 <= 0 || SystemClock.elapsedRealtime() - a12 <= 900000) {
                        b.m219a(this.f45a).f62a = null;
                        int i3 = (ikVar.f680a > 0 ? 1 : (ikVar.f680a == 0 ? 0 : -1));
                        Context context2 = this.f45a;
                        if (i3 == 0) {
                            b.m219a(context2).b(ikVar.f692e, ikVar.f693f, ikVar.f699l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f45a);
                            eoVar = eo.a(this.f45a);
                            str7 = this.f45a.getPackageName();
                            str6 = en.m443a(i);
                            i2 = 6006;
                            str5 = "1";
                        } else {
                            eoVar = eo.a(context2);
                            str7 = this.f45a.getPackageName();
                            str6 = en.m443a(i);
                            i2 = 6006;
                            str5 = "2";
                        }
                        eoVar.a(str7, str6, str, i2, str5);
                        if (!TextUtils.isEmpty(ikVar.f692e)) {
                            arrayList = new ArrayList();
                            arrayList.add(ikVar.f692e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.COMMAND_REGISTER.f325a, arrayList, ikVar.f680a, ikVar.f691d, null, ikVar.m647a());
                        ao.a(this.f45a).m217d();
                        return generateCommandMessage;
                    }
                    b.m182a("The received registration result has expired.");
                    eo.a(this.f45a).b(this.f45a.getPackageName(), en.m443a(i), str, "26");
                    return null;
                case 3:
                    if (ifVar.m625b()) {
                        if (((iq) a4).f758a == 0) {
                            b.m219a(this.f45a).m221a();
                            MiPushClient.clearExtras(this.f45a);
                        }
                        PushMessageHandler.a();
                        break;
                    } else {
                        b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                case 4:
                    io ioVar = (io) a4;
                    if (ioVar.f733a == 0) {
                        MiPushClient.addTopic(this.f45a, ioVar.b());
                    }
                    if (!TextUtils.isEmpty(ioVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(ioVar.b());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("resp-cmd:");
                    ey eyVar = ey.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(eyVar);
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                    sb.append(ioVar.a());
                    b.e(sb.toString());
                    return PushMessageHelper.generateCommandMessage(eyVar.f325a, arrayList, ioVar.f733a, ioVar.f739d, ioVar.c(), null);
                case 5:
                    is isVar = (is) a4;
                    if (isVar.f778a == 0) {
                        MiPushClient.removeTopic(this.f45a, isVar.b());
                    }
                    if (!TextUtils.isEmpty(isVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(isVar.b());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ey eyVar2 = ey.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(eyVar2);
                    sb2.append(AVFSCacheConstants.COMMA_SEP);
                    sb2.append(isVar.a());
                    b.e(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(eyVar2.f325a, arrayList, isVar.f778a, isVar.f784d, isVar.c(), null);
                case 6:
                    db.a(this.f45a.getPackageName(), this.f45a, a4, hj.Command, bArr.length);
                    ie ieVar = (ie) a4;
                    String b = ieVar.b();
                    List<String> a13 = ieVar.m611a();
                    if (ieVar.f605a == 0) {
                        if (TextUtils.equals(b, ey.COMMAND_SET_ACCEPT_TIME.f325a) && a13 != null && a13.size() > 1) {
                            MiPushClient.addAcceptTime(this.f45a, a13.get(0), a13.get(1));
                            if (!"00:00".equals(a13.get(0)) || !"00:00".equals(a13.get(1))) {
                                b.m219a(this.f45a).a(false);
                            } else {
                                b.m219a(this.f45a).a(true);
                            }
                            a13 = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), a13);
                        } else if (TextUtils.equals(b, ey.COMMAND_SET_ALIAS.f325a) && a13 != null && a13.size() > 0) {
                            MiPushClient.addAlias(this.f45a, a13.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_UNSET_ALIAS.f325a) && a13 != null && a13.size() > 0) {
                            MiPushClient.removeAlias(this.f45a, a13.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_SET_ACCOUNT.f325a) && a13 != null && a13.size() > 0) {
                            MiPushClient.addAccount(this.f45a, a13.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_UNSET_ACCOUNT.f325a) && a13 != null && a13.size() > 0) {
                            MiPushClient.removeAccount(this.f45a, a13.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_CHK_VDEVID.f325a)) {
                            return null;
                        }
                    }
                    b.e("resp-cmd:" + b + AVFSCacheConstants.COMMA_SEP + ieVar.a());
                    return PushMessageHelper.generateCommandMessage(b, a13, ieVar.f605a, ieVar.f613d, ieVar.c(), null);
                case 7:
                    db.a(this.f45a.getPackageName(), this.f45a, a4, hj.Notification, bArr.length);
                    if (!(a4 instanceof ia)) {
                        if (a4 instanceof ii) {
                            ii iiVar = (ii) a4;
                            if (!"registration id expired".equalsIgnoreCase(iiVar.f641d)) {
                                if (ht.ClientInfoUpdateOk.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    if (iiVar.m633a() != null && iiVar.m633a().containsKey("app_version")) {
                                        b.m219a(this.f45a).m222a(iiVar.m633a().get("app_version"));
                                        break;
                                    }
                                } else if (ht.AwakeApp.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    if (ifVar.m625b() && iiVar.m633a() != null && iiVar.m633a().containsKey("awake_info")) {
                                        Context context3 = this.f45a;
                                        o.a(context3, b.m219a(context3).m220a(), ba.a(this.f45a).a(ho.AwakeInfoUploadWaySwitch.a(), 0), iiVar.m633a().get("awake_info"));
                                        break;
                                    }
                                } else if (!ht.NormalClientConfigUpdate.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    if (!ht.CustomClientConfigUpdate.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                        if (!ht.SyncInfoResult.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                            if (!ht.ForceSync.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                                if (!ht.CancelPushMessage.f497a.equals(iiVar.f641d)) {
                                                    if (!ht.HybridRegisterResult.f497a.equals(iiVar.f641d)) {
                                                        if (!ht.HybridUnregisterResult.f497a.equals(iiVar.f641d)) {
                                                            if (!ht.PushLogUpload.f497a.equals(iiVar.f641d)) {
                                                                if (!ht.DetectAppAlive.f497a.equals(iiVar.f641d)) {
                                                                    if (i.a(iiVar)) {
                                                                        b.b("receive notification handle by cpra");
                                                                        break;
                                                                    }
                                                                } else {
                                                                    b.b("receive detect msg");
                                                                    b(iiVar);
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            iq iqVar = new iq();
                                                            it.a(iqVar, iiVar.m638a());
                                                            MiPushClient4Hybrid.onReceiveUnregisterResult(this.f45a, iqVar);
                                                            break;
                                                        }
                                                    } else {
                                                        try {
                                                            ik ikVar2 = new ik();
                                                            it.a(ikVar2, iiVar.m638a());
                                                            MiPushClient4Hybrid.onReceiveRegisterResult(this.f45a, ikVar2);
                                                            break;
                                                        } catch (iz e) {
                                                            b.a(e);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    b.e("resp-type:" + iiVar.f641d + AVFSCacheConstants.COMMA_SEP + iiVar.m632a());
                                                    if (iiVar.m633a() != null) {
                                                        int i4 = -2;
                                                        if (iiVar.m633a().containsKey(bk.M)) {
                                                            String str9 = iiVar.m633a().get(bk.M);
                                                            if (!TextUtils.isEmpty(str9)) {
                                                                try {
                                                                    i4 = Integer.parseInt(str9);
                                                                } catch (NumberFormatException e2) {
                                                                    e2.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        if (i4 >= -1) {
                                                            MiPushClient.clearNotification(this.f45a, i4);
                                                        } else {
                                                            String str10 = "";
                                                            String str11 = "";
                                                            if (iiVar.m633a().containsKey(bk.K)) {
                                                                str10 = iiVar.m633a().get(bk.K);
                                                            }
                                                            if (iiVar.m633a().containsKey(bk.L)) {
                                                                str11 = iiVar.m633a().get(bk.L);
                                                            }
                                                            MiPushClient.clearNotification(this.f45a, str10, str11);
                                                        }
                                                    }
                                                    a(iiVar);
                                                    break;
                                                }
                                            } else {
                                                b.m182a("receive force sync notification");
                                                av.a(this.f45a, false);
                                                break;
                                            }
                                        } else {
                                            av.a(this.f45a, iiVar);
                                            break;
                                        }
                                    } else {
                                        ig igVar = new ig();
                                        it.a(igVar, iiVar.m638a());
                                        bb.a(ba.a(this.f45a), igVar);
                                        break;
                                    }
                                } else {
                                    ih ihVar = new ih();
                                    try {
                                        it.a(ihVar, iiVar.m638a());
                                        bb.a(ba.a(this.f45a), ihVar);
                                        break;
                                    } catch (iz unused) {
                                        break;
                                    }
                                }
                            } else {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f45a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f45a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f45a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f45a);
                                b.e("resp-type:" + iiVar.f641d + AVFSCacheConstants.COMMA_SEP + iiVar.m632a());
                                MiPushClient.reInitialize(this.f45a, hx.RegIdExpired);
                                for (String str12 : allAlias) {
                                    MiPushClient.removeAlias(this.f45a, str12);
                                    MiPushClient.setAlias(this.f45a, str12, null);
                                }
                                for (String str13 : allTopic) {
                                    MiPushClient.removeTopic(this.f45a, str13);
                                    MiPushClient.subscribe(this.f45a, str13, null);
                                }
                                for (String str14 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f45a, str14);
                                    MiPushClient.setUserAccount(this.f45a, str14, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f45a);
                                    MiPushClient.addAcceptTime(this.f45a, split[0], split[1]);
                                    break;
                                }
                            }
                        }
                    } else {
                        ia iaVar = (ia) a4;
                        String a14 = iaVar.a();
                        b.e("resp-type:" + iaVar.b() + ", code:" + iaVar.f575a + AVFSCacheConstants.COMMA_SEP + a14);
                        if (ht.DisablePushMessage.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            if (iaVar.f575a != 0) {
                                if ("syncing".equals(af.a(this.f45a).a(au.DISABLE_PUSH))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f45a).m201a(a14)) {
                                            if (af.a(this.f45a).a(a14) < 10) {
                                                af.a(this.f45a).b(a14);
                                                ao.a(this.f45a).a(true, a14);
                                            } else {
                                                af.a(this.f45a).c(a14);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (af.class) {
                                    if (af.a(this.f45a).m201a(a14)) {
                                        af.a(this.f45a).c(a14);
                                        af a15 = af.a(this.f45a);
                                        au auVar = au.DISABLE_PUSH;
                                        if ("syncing".equals(a15.a(auVar))) {
                                            af.a(this.f45a).a(auVar, "synced");
                                            MiPushClient.clearNotification(this.f45a);
                                            MiPushClient.clearLocalNotificationType(this.f45a);
                                            PushMessageHandler.a();
                                            ao.a(this.f45a).m214b();
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (ht.EnablePushMessage.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            if (iaVar.f575a != 0) {
                                if ("syncing".equals(af.a(this.f45a).a(au.ENABLE_PUSH))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f45a).m201a(a14)) {
                                            if (af.a(this.f45a).a(a14) < 10) {
                                                af.a(this.f45a).b(a14);
                                                ao.a(this.f45a).a(false, a14);
                                            } else {
                                                af.a(this.f45a).c(a14);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (af.class) {
                                    if (af.a(this.f45a).m201a(a14)) {
                                        af.a(this.f45a).c(a14);
                                        af a16 = af.a(this.f45a);
                                        au auVar2 = au.ENABLE_PUSH;
                                        if ("syncing".equals(a16.a(auVar2))) {
                                            af.a(this.f45a).a(auVar2, "synced");
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (!ht.ThirdPartyRegUpdate.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            if (ht.UploadTinyData.f497a.equalsIgnoreCase(iaVar.f582d)) {
                                a(iaVar);
                                break;
                            }
                        } else {
                            b(iaVar);
                            break;
                        }
                        af.a(this.f45a).c(a14);
                        break;
                    }
                    break;
            }
            return null;
        } catch (u e3) {
            b.a(e3);
            a(ifVar);
            a2 = eo.a(this.f45a);
            packageName = this.f45a.getPackageName();
            a3 = en.m443a(i);
            str2 = Constants.VIA_ACT_TYPE_NINETEEN;
            a2.b(packageName, a3, str, str2);
            s.c(this.f45a, ifVar, z);
            return null;
        } catch (iz e4) {
            b.a(e4);
            b.d("receive a message which action string is not valid. is the reg expired?");
            a2 = eo.a(this.f45a);
            packageName = this.f45a.getPackageName();
            a3 = en.m443a(i);
            str2 = "20";
            a2.b(packageName, a3, str, str2);
            s.c(this.f45a, ifVar, z);
            return null;
        }
    }

    private PushMessageHandler.a a(Cif ifVar, byte[] bArr) {
        String str;
        String str2 = null;
        try {
            iu a2 = ai.a(this.f45a, ifVar);
            if (a2 == null) {
                b.d("message arrived: receiving an un-recognized message. " + ifVar.f617a);
                return null;
            }
            hj a3 = ifVar.a();
            b.m182a("message arrived: processing an arrived message, action=" + a3);
            if (an.a[a3.ordinal()] != 1) {
                return null;
            }
            if (!ifVar.m625b()) {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            } else {
                im imVar = (im) a2;
                hv a4 = imVar.a();
                if (a4 == null) {
                    str = "message arrived: receive an empty message without push content, drop it";
                } else {
                    hw hwVar = ifVar.f618a;
                    if (!(hwVar == null || hwVar.m584a() == null)) {
                        str2 = ifVar.f618a.f532a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, ifVar.m617a(), false);
                    generateMessage.setArrivedMessage(true);
                    b.m182a("message arrived: receive a message, msgid=" + a4.m575a() + ", jobkey=" + str2);
                    return generateMessage;
                }
            }
            b.d(str);
            return null;
        } catch (u e) {
            b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (iz e2) {
            b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    public static am a(Context context) {
        if (a == null) {
            a = new am(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f45a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > ConfigStorage.DEFAULT_SMALL_MAX_AGE) {
            MiPushClient.reInitialize(this.f45a, hx.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f43a) {
            f44a.remove(str);
            b.m219a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bp.a(f44a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            t.a(edit);
        }
    }

    private void a(ia iaVar) {
        String a2 = iaVar.a();
        b.b("receive ack " + a2);
        Map<String, String> a3 = iaVar.m598a();
        if (a3 != null) {
            String str = a3.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bx.a(this.f45a).a(a2, str, Boolean.valueOf(iaVar.f575a == 0));
            }
        }
    }

    private void a(Cif ifVar) {
        b.m182a("receive a message but decrypt failed. report now.");
        ii iiVar = new ii(ifVar.m617a().f530a, false);
        iiVar.c(ht.DecryptMessageFail.f497a);
        iiVar.b(ifVar.m618a());
        iiVar.d(ifVar.f624b);
        HashMap hashMap = new HashMap();
        iiVar.f636a = hashMap;
        hashMap.put(com.taobao.accs.common.Constants.SP_KEY_REG_ID, MiPushClient.getRegId(this.f45a));
        ao.a(this.f45a).a((iu) iiVar, hj.Notification, false, (hw) null);
    }

    private void a(ii iiVar) {
        ia iaVar = new ia();
        iaVar.c(ht.CancelPushMessageACK.f497a);
        iaVar.a(iiVar.m632a());
        iaVar.a(iiVar.a());
        iaVar.b(iiVar.b());
        iaVar.e(iiVar.c());
        iaVar.a(0);
        iaVar.d("success clear push message.");
        ao.a(this.f45a).a(iaVar, hj.Notification, false, true, null, false, this.f45a.getPackageName(), b.m219a(this.f45a).m220a(), false);
    }

    private void a(im imVar, Cif ifVar) {
        hw a2 = ifVar.m617a();
        if (a2 != null) {
            a2 = br.a(a2.m582a());
        }
        hz hzVar = new hz();
        hzVar.b(imVar.b());
        hzVar.a(imVar.m655a());
        hzVar.a(imVar.a().a());
        if (!TextUtils.isEmpty(imVar.c())) {
            hzVar.c(imVar.c());
        }
        if (!TextUtils.isEmpty(imVar.d())) {
            hzVar.d(imVar.d());
        }
        hzVar.a(it.a(this.f45a, ifVar));
        ao.a(this.f45a).a(hzVar, hj.AckMessage, a2);
    }

    private void a(String str, long j, e eVar) {
        au a2 = l.a(eVar);
        if (a2 != null) {
            if (j == 0) {
                synchronized (af.class) {
                    if (af.a(this.f45a).m201a(str)) {
                        af.a(this.f45a).c(str);
                        if ("syncing".equals(af.a(this.f45a).a(a2))) {
                            af.a(this.f45a).a(a2, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(af.a(this.f45a).a(a2))) {
                synchronized (af.class) {
                    if (af.a(this.f45a).m201a(str)) {
                        if (af.a(this.f45a).a(str) < 10) {
                            af.a(this.f45a).b(str);
                            ao.a(this.f45a).a(str, a2, eVar);
                        } else {
                            af.a(this.f45a).c(str);
                        }
                    }
                }
            } else {
                af.a(this.f45a).c(str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m202a(Context context, String str) {
        synchronized (f43a) {
            b.m219a(context);
            SharedPreferences a2 = b.a(context);
            if (f44a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f44a = new LinkedList();
                for (String str2 : split) {
                    f44a.add(str2);
                }
            }
            if (f44a.contains(str)) {
                return true;
            }
            f44a.add(str);
            if (f44a.size() > 25) {
                f44a.poll();
            }
            String a3 = bp.a(f44a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            t.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m203a(Cif ifVar) {
        Map<String, String> a2 = ifVar.m617a() == null ? null : ifVar.m617a().m584a();
        if (a2 == null) {
            return false;
        }
        String str = a2.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(ia iaVar) {
        Context context;
        e eVar;
        b.c("ASSEMBLE_PUSH : " + iaVar.toString());
        String a2 = iaVar.a();
        Map<String, String> a3 = iaVar.m598a();
        if (a3 != null) {
            String str = a3.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + ag.FCM.name())) {
                    b.m182a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    context = this.f45a;
                    eVar = e.ASSEMBLE_PUSH_FCM;
                } else {
                    if (str.contains("brand:" + ag.HUAWEI.name())) {
                        b.m182a("ASSEMBLE_PUSH : receive hw token sync ack");
                        context = this.f45a;
                        eVar = e.ASSEMBLE_PUSH_HUAWEI;
                    } else {
                        if (str.contains("brand:" + ag.OPPO.name())) {
                            b.m182a("ASSEMBLE_PUSH : receive COS token sync ack");
                            context = this.f45a;
                            eVar = e.ASSEMBLE_PUSH_COS;
                        } else {
                            if (str.contains("brand:" + ag.VIVO.name())) {
                                b.m182a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                context = this.f45a;
                                eVar = e.ASSEMBLE_PUSH_FTOS;
                            } else {
                                return;
                            }
                        }
                    }
                }
                i.b(context, eVar, str);
                a(a2, iaVar.f575a, eVar);
            }
        }
    }

    private void b(Cif ifVar) {
        hw a2 = ifVar.m617a();
        if (a2 != null) {
            a2 = br.a(a2.m582a());
        }
        hz hzVar = new hz();
        hzVar.b(ifVar.m618a());
        hzVar.a(a2.m583a());
        hzVar.a(a2.m581a());
        if (!TextUtils.isEmpty(a2.m588b())) {
            hzVar.c(a2.m588b());
        }
        hzVar.a(it.a(this.f45a, ifVar));
        ao.a(this.f45a).a((iu) hzVar, hj.AckMessage, false, a2);
    }

    private void b(ii iiVar) {
        String str;
        Map<String, String> a2 = iiVar.m633a();
        if (a2 == null) {
            str = "detect failed because null";
        } else {
            String str2 = (String) ay.a(a2, "pkgList", (Object) null);
            if (TextUtils.isEmpty(str2)) {
                str = "detect failed because empty";
            } else {
                try {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f45a.getSystemService("activity")).getRunningAppProcesses();
                    if (!w.a(runningAppProcesses)) {
                        String[] split = str2.split(",");
                        HashMap hashMap = new HashMap();
                        for (String str3 : split) {
                            String[] split2 = str3.split(Constants.WAVE_SEPARATOR);
                            if (split2.length >= 2) {
                                hashMap.put(split2[1], split2[0]);
                            }
                        }
                        w.a aVar = new w.a(Constants.WAVE_SEPARATOR, ",");
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (hashMap.containsKey(runningAppProcessInfo.processName)) {
                                aVar.a((String) hashMap.get(runningAppProcessInfo.processName), String.valueOf(runningAppProcessInfo.importance));
                                hashMap.remove(runningAppProcessInfo.processName);
                            }
                        }
                        if (aVar.toString().length() > 0) {
                            ii iiVar2 = new ii();
                            iiVar2.a(iiVar.m632a());
                            iiVar2.b(iiVar.b());
                            iiVar2.d(iiVar.c());
                            iiVar2.c(ht.DetectAppAliveResult.f497a);
                            HashMap hashMap2 = new HashMap();
                            iiVar2.f636a = hashMap2;
                            hashMap2.put("alive", aVar.toString());
                            if (Boolean.parseBoolean((String) ay.a(a2, "reportNotAliveApp", "false")) && hashMap.size() > 0) {
                                w.a aVar2 = new w.a("", ",");
                                for (String str4 : hashMap.keySet()) {
                                    aVar2.a((String) hashMap.get(str4), "");
                                }
                                iiVar2.f636a.put("notAlive", aVar2.toString());
                            }
                            ao.a(this.f45a).a((iu) iiVar2, hj.Notification, false, (hw) null);
                            return;
                        }
                        b.b("detect failed because no alive process");
                        return;
                    }
                    b.m182a("detect failed because params illegal");
                    return;
                } catch (Throwable th) {
                    b.m182a("detect failed " + th);
                    return;
                }
            }
        }
        b.m182a(str);
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        String str2;
        String str3;
        eo eoVar;
        Throwable e;
        eo a2;
        String packageName;
        String format;
        String action = intent.getAction();
        b.m182a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                b.d("receiving an empty message, drop");
                eo.a(this.f45a).a(this.f45a.getPackageName(), intent, "12");
                return null;
            }
            Cif ifVar = new Cif();
            try {
                it.a(ifVar, byteArrayExtra);
                b a3 = b.m219a(this.f45a);
                hw a4 = ifVar.m617a();
                hj a5 = ifVar.a();
                hj hjVar = hj.SendMessage;
                if (a5 == hjVar && a4 != null && !a3.m230e() && !booleanExtra) {
                    a4.a("mrt", stringExtra);
                    a4.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m203a(ifVar)) {
                        b(ifVar);
                    } else {
                        b.b("this is a mina's message, ack later");
                        a4.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(a4.m581a()));
                        a4.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) it.a(this.f45a, ifVar)));
                    }
                }
                String str4 = "";
                if (ifVar.a() == hjVar && !ifVar.m625b()) {
                    if (al.m796a(ifVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = ifVar.b();
                        if (a4 != null) {
                            str4 = a4.m583a();
                        }
                        objArr[1] = str4;
                        b.m182a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a2 = eo.a(this.f45a);
                        packageName = this.f45a.getPackageName();
                        format = String.format("13: %1$s", ifVar.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = ifVar.b();
                        if (a4 != null) {
                            str4 = a4.m583a();
                        }
                        objArr2[1] = str4;
                        b.m182a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a2 = eo.a(this.f45a);
                        packageName = this.f45a.getPackageName();
                        format = String.format("14: %1$s", ifVar.b());
                    }
                    a2.a(packageName, intent, format);
                    s.a(this.f45a, ifVar, booleanExtra);
                    return null;
                } else if (ifVar.a() == hjVar && ifVar.m625b() && al.m796a(ifVar) && (!booleanExtra || a4 == null || a4.m584a() == null || !a4.m584a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = ifVar.b();
                    if (a4 != null) {
                        str4 = a4.m583a();
                    }
                    objArr3[1] = str4;
                    b.m182a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    eo.a(this.f45a).a(this.f45a.getPackageName(), intent, String.format("25: %1$s", ifVar.b()));
                    s.b(this.f45a, ifVar, booleanExtra);
                    return null;
                } else if (a3.m228c() || ifVar.f617a == hj.Registration) {
                    if (!a3.m228c() || !a3.m231f()) {
                        return a(ifVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (ifVar.f617a != hj.UnRegistration) {
                        s.e(this.f45a, ifVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f45a);
                    } else if (ifVar.m625b()) {
                        a3.m221a();
                        MiPushClient.clearExtras(this.f45a);
                        PushMessageHandler.a();
                    } else {
                        b.d("receiving an un-encrypt unregistration message");
                    }
                } else if (al.m796a(ifVar)) {
                    return a(ifVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    s.e(this.f45a, ifVar, booleanExtra);
                    boolean d = a3.m229d();
                    b.d("receive message without registration. need re-register!registered?" + d);
                    eo.a(this.f45a).a(this.f45a.getPackageName(), intent, "15");
                    if (d) {
                        a();
                    }
                }
            } catch (iz e2) {
                e = e2;
                eoVar = eo.a(this.f45a);
                str3 = this.f45a.getPackageName();
                str2 = Constants.VIA_REPORT_TYPE_START_WAP;
                eoVar.a(str3, intent, str2);
                b.a(e);
                return null;
            } catch (Exception e3) {
                e = e3;
                eoVar = eo.a(this.f45a);
                str3 = this.f45a.getPackageName();
                str2 = Constants.VIA_REPORT_TYPE_START_GROUP;
                eoVar.a(str3, intent, str2);
                b.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            Cif ifVar2 = new Cif();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    it.a(ifVar2, byteArrayExtra2);
                }
            } catch (iz unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(ifVar2.a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            Cif ifVar3 = new Cif();
            try {
                it.a(ifVar3, byteArrayExtra3);
                b a6 = b.m219a(this.f45a);
                if (al.m796a(ifVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!a6.m228c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!a6.m228c() || !a6.m231f()) {
                    return a(ifVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                b.d(str);
            } catch (Exception e4) {
                b.d("fail to deal with arrived message. " + e4);
            }
        }
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(list.get(0).split(":")[0]);
        long parseLong2 = Long.parseLong(list.get(0).split(":")[1]);
        long j = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)));
        return arrayList;
    }
}
