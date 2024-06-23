package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.im;
import com.xiaomi.push.it;
import com.xiaomi.push.m;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.y;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class FCMPushHelper {
    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(hj.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf((int) it.a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    private static void a(Context context, Cif ifVar) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((im) ai.a(context, ifVar), ifVar.m617a(), false);
            PushMessageReceiver a = i.a(context);
            if (a != null) {
                a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            b.a("fcm broadcast notification come error ", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    private static void a(Context context, byte[] bArr) {
        String str;
        boolean a = ao.a(context).m212a();
        boolean z = true;
        boolean z2 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean a2 = m193a(context);
        boolean z3 = false;
        if (!a || !z2 || !a2) {
            str = String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(a), Boolean.valueOf(z2), Boolean.valueOf(a2));
        } else {
            bArr = n.a(bArr, b.m219a(context).d());
            if (bArr == null) {
                str = "fcm message encrypt failed";
            } else {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    b.m182a("fcm message buf base64 encode failed");
                    z = false;
                } else {
                    Intent intent = new Intent(bk.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    b.m182a("fcm message reroute to xmsf");
                }
                z3 = z;
                if (z3) {
                    b.b("fcm message post local");
                    al.m792a(context, y.a(bArr), bArr);
                    return;
                }
                return;
            }
        }
        b.m182a(str);
        if (z3) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m193a(Context context) {
        return ((long) m.b(context)) >= 50002000 && b(context);
    }

    private static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        i.m239a(context, e.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return i.m242a(context, e.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = i.a(context)) != null) {
            a.onNotificationMessageArrived(context, i.a(str));
        }
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = i.a(context)) != null) {
            a.onReceivePassThroughMessage(context, i.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            a(context, y.a(decode));
            a(context, decode);
        } catch (Throwable th) {
            b.a("fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        boolean z = false;
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        if (((long) m.b(context)) >= 50002000) {
            z = true;
        }
        edit.putBoolean("is_xmsf_sup_decrypt", z).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(i.c(e.ASSEMBLE_PUSH_FCM), "fcm", 1, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        i.m240a(context, e.ASSEMBLE_PUSH_FCM, str);
    }
}
