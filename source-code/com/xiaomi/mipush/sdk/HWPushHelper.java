package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class HWPushHelper {
    private static boolean a;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return i.m241a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String a2 = i.a(e.ASSEMBLE_PUSH_HUAWEI);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String a3 = i.a(context, a2);
        String a4 = af.a(context).a(au.UPLOAD_HUAWEI_TOKEN);
        return !TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a4) && "synced".equals(a4);
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return a;
    }

    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("pushMsg")) {
                            str2 = jSONObject.getString("pushMsg");
                            break;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                b.d(e.toString());
            }
        }
        PushMessageReceiver a2 = i.a(context);
        if (a2 != null) {
            MiPushMessage a3 = i.a(str2);
            if (!a3.getExtra().containsKey("notify_effect")) {
                a2.onNotificationMessageClicked(context, a3);
            }
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e) {
            b.d(e.toString());
        }
        PushMessageReceiver a2 = i.a(context);
        if (a2 != null) {
            a2.onReceivePassThroughMessage(context, i.a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_HUAWEI);
        if (a2 != null) {
            a2.register();
        }
    }

    public static void reportError(String str, int i) {
        i.a(str, i);
    }

    public static synchronized void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z) {
        a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1)) > 172800000) {
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = false;
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1)) > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                z = true;
            }
        }
        return z;
    }

    public static void uploadToken(Context context, String str) {
        i.m240a(context, e.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
