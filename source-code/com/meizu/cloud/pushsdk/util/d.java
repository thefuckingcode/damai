package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.d.a;
import com.meizu.cloud.pushsdk.d.b.f;
import com.meizu.cloud.pushsdk.d.c.b;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.taobao.tao.log.TLogConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONObject;

/* compiled from: Taobao */
public class d {
    private static int a(Context context) {
        if (MzSystemUtils.isMeizu(context)) {
            return 1;
        }
        if (MzSystemUtils.isXiaoMi()) {
            return 2;
        }
        return MzSystemUtils.isHuaWei() ? 3 : 0;
    }

    private static Intent a(Context context, Map<String, String> map) {
        String str;
        String str2;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION), 0);
        if (queryIntentServices != null) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    str = null;
                    break;
                }
                ResolveInfo next = it.next();
                if (PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = next.serviceInfo;
                    str = serviceInfo.packageName;
                    str2 = serviceInfo.name;
                    break;
                }
            }
            if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                str = queryIntentServices.get(0).serviceInfo.packageName;
                str2 = queryIntentServices.get(0).serviceInfo.name;
            }
        } else {
            str2 = null;
            str = null;
        }
        DebugLogger.i("UxIPUtils", "current process packageName " + str);
        if (!TextUtils.isEmpty(str2)) {
            try {
                String jSONObject = e.a((Map) map).toString();
                Intent intent = new Intent();
                intent.setPackage(str);
                intent.setAction(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION);
                intent.putExtra(PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA, jSONObject);
                return intent;
            } catch (Exception e) {
                e.printStackTrace();
                DebugLogger.e("UxIPUtils", "getRemotePushTrackerIntent error " + e.getMessage());
            }
        }
        return null;
    }

    public static com.meizu.cloud.pushsdk.handler.a.c.d a(String str) {
        String str2;
        com.meizu.cloud.pushsdk.handler.a.c.d dVar = new com.meizu.cloud.pushsdk.handler.a.c.d();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str3 = null;
                String string = jSONObject.has("task_id") ? jSONObject.getString("task_id") : null;
                String string2 = jSONObject.has(PushConstants.SEQ_ID) ? jSONObject.getString(PushConstants.SEQ_ID) : null;
                String string3 = jSONObject.has(PushConstants.PUSH_TIMESTAMP) ? jSONObject.getString(PushConstants.PUSH_TIMESTAMP) : null;
                if (jSONObject.has(PushConstants.DEVICE_ID)) {
                    str3 = jSONObject.getString(PushConstants.DEVICE_ID);
                }
                return com.meizu.cloud.pushsdk.handler.a.c.d.a().a(string).d(str3).c(string3).b(string2).a();
            } catch (Exception unused) {
                str2 = "the platformExtra parse error";
            }
        } else {
            str2 = "the platformExtra is empty";
            DebugLogger.e("UxIPUtils", str2);
            return dVar;
        }
    }

    public static String a(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        try {
            MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            return mPushMessage != null ? mPushMessage.getTaskId() : stringExtra;
        } catch (Exception e) {
            DebugLogger.e("UxIPUtils", "parse MessageV2 error " + e.getMessage());
            return "no push platform task";
        }
    }

    public static void a(Context context, Intent intent, String str, int i) {
        a(context, intent, PushManager.TAG, str, i);
    }

    public static void a(Context context, Intent intent, String str, String str2, int i) {
        if (!TextUtils.isEmpty(a(intent))) {
            a(context, context.getPackageName(), intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), a(intent), str, str2, i);
        }
    }

    public static void a(Context context, String str, int i, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            a(context, context.getPackageName(), str3, str2, PushManager.TAG, str, i);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "dpm", str5);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        HashMap hashMap = new HashMap(8);
        hashMap.put(TLogConstant.PERSIST_TASK_ID, str3);
        hashMap.put("deviceId", str2);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("package_name", str);
        hashMap.put("pushsdk_version", str4);
        hashMap.put("push_info", str5);
        hashMap.put("push_info_type", String.valueOf(i));
        a(context, false, "notification_service_message", (Map<String, String>) hashMap);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        a(context, true, str, str2, str3, str4, "spm", str5, j);
    }

    public static void a(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        a(context, z, str, str2, str3, str4, str5, str6, 0);
    }

    public static void a(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6, long j) {
        HashMap hashMap = new HashMap(8);
        hashMap.put("en", str5);
        hashMap.put(IRequestConst.TI, str3);
        hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, str2);
        if (TextUtils.isEmpty(str6)) {
            str6 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        hashMap.put("ts", str6);
        hashMap.put(IRequestConst.PN, str);
        hashMap.put(XStateConstants.KEY_PV, PushManager.TAG);
        hashMap.put("nm", String.valueOf(System.currentTimeMillis() / 1000));
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("si", str4);
        }
        if (!a(context, hashMap, z, j)) {
            a(context, z, str5, hashMap);
        }
    }

    public static void a(Context context, boolean z, String str, Map<String, String> map) {
        DebugLogger.e("UxIPUtils", "onLogEvent eventName [" + str + "] properties = " + map);
        if (!"notification_service_message".equals(str)) {
            a.a(context, (com.meizu.cloud.pushsdk.c.c.a) null, (f) null).a(((b.a) b.d().a(str).a(a(context)).a(Long.valueOf(map.get("ts")).longValue())).h(map.get("nm") != null ? map.get("nm") : String.valueOf(System.currentTimeMillis() / 1000)).c(map.get(AppIconSetting.DEFAULT_LARGE_ICON)).e(map.get(IRequestConst.PN)).d(map.get(XStateConstants.KEY_PV)).b(map.get(IRequestConst.TI)).f(TextUtils.isEmpty(map.get("si")) ? "" : map.get("si")).g(String.valueOf(b.j(context, map.get(IRequestConst.PN)))).b(), z);
        }
    }

    private static boolean a(final Context context, final Intent intent, final boolean z, final Map<String, String> map, final long j) {
        String str;
        if (intent == null) {
            str = "startRemotePushTracker error intent is null";
        } else if (j == 0) {
            try {
                context.startService(intent);
                DebugLogger.i("UxIPUtils", "immediately start tracker data in mz_tracker process " + intent.getStringExtra(PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                str = "startRemotePushTracker error " + e.getMessage();
            }
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() {
                /* class com.meizu.cloud.pushsdk.util.d.AnonymousClass1 */

                public void run() {
                    try {
                        context.startService(intent);
                        DebugLogger.i("UxIPUtils", "delayed " + j + " ms start tracker data in mz_tracker process " + intent.getStringExtra(PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        DebugLogger.e("UxIPUtils", "delayed startRemotePushTracker error " + e2.getMessage());
                        d.a(context, z, (String) map.get("en"), map);
                    }
                }
            }, j);
            return true;
        }
        DebugLogger.e("UxIPUtils", str);
        return false;
    }

    private static boolean a(Context context, Map<String, String> map, boolean z, long j) {
        return a(context, a(context, map), z, map, j);
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, false, str, str2, str3, str4, "rpe", str5);
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        a(context, false, str, str2, str3, str4, "rpe", str5, j);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "rpe", str5);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        a(context, false, str, str2, str3, str4, "sipm", str5, j);
    }

    public static void d(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "cpm", str5);
    }

    public static void d(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        a(context, false, str, str2, str3, str4, "nspm", str5, j);
    }

    public static void e(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "acce", str5);
    }

    public static void e(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        a(context, false, str, str2, str3, str4, "fspm", str5, j);
    }

    public static void f(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "acsm", str5);
    }

    public static void f(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        a(context, false, str, str2, str3, str4, "npm", str5, j);
    }
}
