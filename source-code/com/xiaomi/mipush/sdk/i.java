package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.al;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bo;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.t;
import com.xiaomi.push.v;
import com.xiaomi.push.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
public class i {
    private static HashMap<String, String> a = new HashMap<>();

    public static int a() {
        Integer num = (Integer) bk.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r6 = r0.getInt(b(r7), 0);
     */
    private static int a(Context context, e eVar, String str) {
        int i;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        String string = sharedPreferences.getString(a2, "");
        String c = b.m219a(context).m227c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a2)) {
            b.m182a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        } else if (TextUtils.isEmpty(string)) {
            return 1;
        } else {
            if (!string.equals(str)) {
                return 2;
            }
            if (!TextUtils.equals(c, string2)) {
                return 3;
            }
            return (!m243a(eVar) || a() == i) ? 0 : 4;
        }
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has(SocialConstants.PARAM_COMMENT)) {
                    miPushMessage.setDescription(jSONObject.getString(SocialConstants.PARAM_COMMENT));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[RETURN] */
    protected static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    resolveInfo = it.next();
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
                if (resolveInfo == null) {
                    return (PushMessageReceiver) v.a(context, resolveInfo.activityInfo.name).newInstance();
                }
                return null;
            }
            resolveInfo = null;
            if (resolveInfo == null) {
            }
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
    }

    static String a(Context context, e eVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        if (!TextUtils.isEmpty(a2)) {
            return sharedPreferences.getString(a2, "");
        }
        return null;
    }

    protected static synchronized String a(Context context, String str) {
        String str2;
        synchronized (i.class) {
            str2 = a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(e eVar) {
        int i = k.a[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token_v2";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        if (r12 != 0) goto L_0x005d;
     */
    /* renamed from: a  reason: collision with other method in class */
    public static HashMap<String, String> m237a(Context context, e eVar) {
        w.a a2;
        int a3;
        HashMap<String, String> hashMap = new HashMap<>();
        String a4 = a(eVar);
        if (TextUtils.isEmpty(a4)) {
            return hashMap;
        }
        int i = k.a[eVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i != 1) {
            if (i == 2) {
                a2 = new w.a(":", Constants.WAVE_SEPARATOR).a("brand", ag.FCM.name()).a("token", a(context, a4)).a("package_name", context.getPackageName());
                a3 = a();
                if (a3 == 0) {
                    a3 = 40091;
                }
            } else if (i == 3) {
                str = "brand:" + ag.OPPO.name() + Constants.WAVE_SEPARATOR + "token" + ":" + a(context, a4) + Constants.WAVE_SEPARATOR + "package_name" + ":" + context.getPackageName();
            } else if (i == 4) {
                a2 = new w.a(":", Constants.WAVE_SEPARATOR).a("brand", ag.VIVO.name()).a("token", a(context, a4)).a("package_name", context.getPackageName());
                a3 = a();
            }
            a2.a("version", Integer.valueOf(a3));
            str = a2.toString();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e) {
                b.d(e.toString());
            }
            int i2 = -1;
            if (applicationInfo != null) {
                i2 = applicationInfo.metaData.getInt("com.huawei.hms.client.appid");
            }
            str = "brand:" + n.a(context).name() + Constants.WAVE_SEPARATOR + "token" + ":" + a(context, a4) + Constants.WAVE_SEPARATOR + "package_name" + ":" + context.getPackageName() + Constants.WAVE_SEPARATOR + "app_id" + ":" + i2;
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m238a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(e.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(e.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            ao.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m239a(Context context, e eVar) {
        String a2 = a(eVar);
        if (!TextUtils.isEmpty(a2)) {
            t.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m240a(Context context, e eVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            int a2 = a(context, eVar, str);
            if (a2 != 0) {
                b.m182a("ASSEMBLE_PUSH : send token upload, check:" + a2);
                a(eVar, str);
                au a3 = l.a(eVar);
                if (a3 != null) {
                    ao.a(context).a((String) null, a3, eVar);
                    return;
                }
                return;
            }
            b.m182a("ASSEMBLE_PUSH : do not need to send token");
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("pushMsg")) {
            intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
        }
    }

    private static synchronized void a(e eVar, String str) {
        synchronized (i.class) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                b.m182a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                b.m182a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1, "error code = " + i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m241a(Context context) {
        if (context == null) {
            return false;
        }
        return bj.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m242a(Context context, e eVar) {
        if (l.m245a(eVar) != null) {
            return ba.a(context).a(l.m245a(eVar).a(), true);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m243a(e eVar) {
        return eVar == e.ASSEMBLE_PUSH_FTOS || eVar == e.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(Cif ifVar, e eVar) {
        if (ifVar == null || ifVar.m617a() == null || ifVar.m617a().m584a() == null) {
            return false;
        }
        return (eVar == e.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(ifVar.m617a().m584a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, Cif ifVar, e eVar) {
        if (a(ifVar, eVar)) {
            return bo.m291a(a(context, eVar));
        }
        return null;
    }

    public static String b(e eVar) {
        return a(eVar) + "_version";
    }

    public static void b(Context context) {
        f.a(context).register();
    }

    public static void b(Context context, e eVar, String str) {
        al.a(context).a(new j(str, context, eVar));
    }

    public static String c(e eVar) {
        int i = k.a[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_error";
        }
        if (i == 2) {
            return "fcm_push_error";
        }
        if (i == 3) {
            return "cos_push_error";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    public static void c(Context context) {
        f.a(context).unregister();
    }

    /* access modifiers changed from: private */
    public static synchronized void d(Context context, e eVar, String str) {
        synchronized (i.class) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                b.m182a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a2, str).putString("last_check_token", b.m219a(context).m227c());
            if (m243a(eVar)) {
                edit.putInt(b(eVar), a());
            }
            t.a(edit);
            b.m182a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
