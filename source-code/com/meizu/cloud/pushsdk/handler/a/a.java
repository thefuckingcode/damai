package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.c.e;
import com.meizu.cloud.pushsdk.handler.c;
import com.meizu.cloud.pushsdk.handler.d;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.b;
import org.json.JSONObject;

/* compiled from: Taobao */
public abstract class a<T> implements c {
    private com.meizu.cloud.pushsdk.handler.a a;
    private Context b;
    private SparseArray<String> c;

    protected a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context != null) {
            this.b = context.getApplicationContext();
            this.a = aVar;
            SparseArray<String> sparseArray = new SparseArray<>();
            this.c = sparseArray;
            sparseArray.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
            this.c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
            this.c.put(16, "MESSAGE_TYPE_REGISTER");
            this.c.put(32, "MESSAGE_TYPE_UNREGISTER");
            this.c.put(8, "MESSAGE_TYPE_THROUGH");
            this.c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
            this.c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
            this.c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
            this.c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
            this.c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
            this.c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
            this.c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
            this.c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
            this.c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
            this.c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
            this.c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
            this.c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
            this.c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
            this.c.put(524288, "MESSAGE_TYPE_BRIGHT_NOTIFICATION");
            this.c.put(1048576, "MESSAGE_TYPE_NOTIFICATION_CLOSE");
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    private String a(int i) {
        return this.c.get(i);
    }

    private boolean a(String str, MessageV3 messageV3, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "sa, public key not empty";
        } else if (!PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(str2)) {
            str3 = "sa, message not click method";
        } else if (!b.l(d(), messageV3.getPackageName())) {
            str3 = "sa, not first request";
        } else {
            b.c(d(), messageV3.getPackageName(), false);
            return true;
        }
        DebugLogger.i("AbstractMessageHandler", str3);
        return false;
    }

    private boolean b(String str, MessageV3 messageV3, String str2) {
        if (TextUtils.isEmpty(str)) {
            DebugLogger.e("AbstractMessageHandler", "security check fail, public key is null");
            return false;
        }
        String a2 = com.meizu.cloud.pushsdk.util.c.a(str, str2);
        DebugLogger.i("AbstractMessageHandler", "decrypt sign: " + a2);
        boolean a3 = e.a(a2, messageV3);
        DebugLogger.i("AbstractMessageHandler", "check public key result: " + a3);
        return a3;
    }

    private String e() {
        String str = null;
        for (int i = 0; i < 2; i++) {
            str = b();
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.a.a.a b2;
        com.meizu.cloud.pushsdk.notification.model.a a2;
        if (messageV3.getAdvertisementOption() != null && !TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage()) && (b2 = com.meizu.cloud.pushsdk.b.a(context).b()) != null && (a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3)) != null) {
            b2.a(a2.a());
        }
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3) {
        if (messageV3 != null && messageV3.getAdvertisementOption() != null && !TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            return;
        }
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            c().b(d(), MzPushMessage.fromMessageV3(messageV3));
        } else if (MzSystemUtils.isRunningProcess(d(), messageV3.getUploadDataPackageName())) {
            DebugLogger.i("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
            Intent intent = new Intent();
            if (MinSdkChecker.isSupportTransmitMessageValue(this.b, messageV3.getUploadDataPackageName())) {
                intent.putExtra(PushConstants.MZ_MESSAGE_VALUE, d.a(messageV3));
            } else {
                intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
            }
            intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
            MzSystemUtils.sendMessageFromBroadcast(d(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    /* access modifiers changed from: protected */
    public boolean a(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = b.e(d(), str);
        } else if (i == 1) {
            z = b.h(d(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        DebugLogger.i("AbstractMessageHandler", sb.toString());
        return z;
    }

    /* access modifiers changed from: protected */
    public final boolean a(MessageV3 messageV3, String str) {
        String a2 = e.a(messageV3);
        if (TextUtils.isEmpty(a2)) {
            DebugLogger.i("AbstractMessageHandler", "message does not contain signature field");
            return false;
        }
        String k = b.k(d(), messageV3.getPackageName());
        DebugLogger.i("AbstractMessageHandler", "local public key is: " + k);
        if (a(k, messageV3, str)) {
            DebugLogger.i("AbstractMessageHandler", "message special approval no check");
            return true;
        } else if (b(k, messageV3, a2)) {
            DebugLogger.i("AbstractMessageHandler", "security check passed");
            return true;
        } else {
            String e = e();
            DebugLogger.i("AbstractMessageHandler", "network request public key: " + e);
            if (b(e, messageV3, a2)) {
                b.k(d(), messageV3.getPackageName(), e);
                DebugLogger.i("AbstractMessageHandler", "security check passed");
                return true;
            }
            DebugLogger.e("AbstractMessageHandler", "security check fail");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(T t, String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        try {
            return d().getPackageName().equals(new JSONObject(str).getString(ALBiometricsKeys.KEY_APP_ID));
        } catch (Exception unused) {
            DebugLogger.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String b() {
        return new e.a((String) com.meizu.cloud.pushsdk.c.a.a(PushConstants.GET_PUBLIC_KEY).a().a().a()).a();
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("launcher");
            return (!jSONObject.has("pkg") || TextUtils.isEmpty(jSONObject.getString("pkg"))) ? "" : jSONObject.getString("pkg");
        } catch (Exception unused) {
            DebugLogger.e("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public void b(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            c(messageV3);
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null) {
            DebugLogger.e("AbstractMessageHandler", "delete notifyId " + a2.a() + " notifyKey " + a2.b());
            if (!TextUtils.isEmpty(a2.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a2.b());
                return;
            }
            com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a2.a());
        }
    }

    /* access modifiers changed from: protected */
    public void b(T t) {
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean b(Intent intent) {
        String str;
        String str2;
        boolean z = false;
        if (!a(intent)) {
            return false;
        }
        DebugLogger.i("AbstractMessageHandler", "current message Type " + a(a()));
        T c2 = c(intent);
        if (!a((Object) c2, k(intent))) {
            DebugLogger.e("AbstractMessageHandler", "invalid push message");
            return false;
        }
        DebugLogger.i("AbstractMessageHandler", "current Handler message " + ((Object) c2));
        b((Object) c2);
        int d = d((Object) c2);
        boolean z2 = true;
        if (d != 0) {
            if (d == 1) {
                str2 = "expire notification, don't show message";
                DebugLogger.i("AbstractMessageHandler", str2);
            } else if (d != 2) {
                if (d == 3) {
                    DebugLogger.i("AbstractMessageHandler", "schedule notification");
                    e((Object) c2);
                } else if (d == 4) {
                    DebugLogger.i("AbstractMessageHandler", "bright notification");
                    f((Object) c2);
                } else if (d == 5) {
                    str2 = "ad cannot show message";
                    DebugLogger.i("AbstractMessageHandler", str2);
                }
                z = true;
            } else {
                str = "notification on time ,show message";
            }
            z2 = false;
            boolean g = g((Object) c2);
            DebugLogger.i("AbstractMessageHandler", "can send message " + g);
            if (z && z2 && g) {
                a(c2, a((Object) c2));
                c((Object) c2);
                DebugLogger.i("AbstractMessageHandler", "send message end ");
            }
            return z;
        }
        str = "schedule send message off, send message directly";
        DebugLogger.i("AbstractMessageHandler", str);
        z = true;
        boolean g2 = g((Object) c2);
        DebugLogger.i("AbstractMessageHandler", "can send message " + g2);
        a(c2, a((Object) c2));
        c((Object) c2);
        DebugLogger.i("AbstractMessageHandler", "send message end ");
        return z;
    }

    /* access modifiers changed from: protected */
    public com.meizu.cloud.pushsdk.handler.a c() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public abstract T c(Intent intent);

    /* access modifiers changed from: protected */
    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null) {
            DebugLogger.i("AbstractMessageHandler", "delete notifyKey " + a2.b() + " notifyId " + a2.a());
            if (!TextUtils.isEmpty(a2.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.a(d(), messageV3.getUploadDataPackageName(), a2.b());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.c(d(), messageV3.getUploadDataPackageName(), a2.a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(T t) {
    }

    /* access modifiers changed from: protected */
    public int d(T t) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public Context d() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        String a2 = com.meizu.cloud.pushsdk.b.c.a(d());
        DebugLogger.e("AbstractMessageHandler", "force get deviceId " + a2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    /* access modifiers changed from: protected */
    public void e(T t) {
    }

    /* access modifiers changed from: protected */
    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    /* access modifiers changed from: protected */
    public void f(T t) {
    }

    /* access modifiers changed from: protected */
    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return TextUtils.isEmpty(stringExtra) ? d().getPackageName() : stringExtra;
    }

    /* access modifiers changed from: protected */
    public boolean g(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        DebugLogger.i("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return TextUtils.isEmpty(stringExtra) ? String.valueOf(System.currentTimeMillis() / 1000) : stringExtra;
    }

    /* access modifiers changed from: protected */
    public boolean i(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        DebugLogger.i("AbstractMessageHandler", "receive push whiteList from pushservice " + booleanExtra);
        return booleanExtra;
    }

    /* access modifiers changed from: protected */
    public long j(Intent intent) {
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0);
        DebugLogger.i("AbstractMessageHandler", "receive push delayedReportMillis from pushservice " + longExtra);
        return longExtra;
    }

    /* access modifiers changed from: protected */
    public String k(Intent intent) {
        return intent.getStringExtra("method");
    }
}
