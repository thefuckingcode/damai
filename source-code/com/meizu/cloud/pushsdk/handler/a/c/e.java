package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class e {
    private int a;
    private String b = String.valueOf(-1);
    private String c = "";
    private String d = "";
    private int e = -1;
    private String f = "";

    /* compiled from: Taobao */
    public static class a {
        public String a;
        public String b;
        String c;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.isNull("code")) {
                        a(jSONObject.getString("code"));
                    }
                    if (!jSONObject.isNull("message")) {
                        b(jSONObject.getString("message"));
                    }
                    if (!jSONObject.isNull("value")) {
                        c(jSONObject.getString("value"));
                    }
                } catch (JSONException e) {
                    DebugLogger.e("SecurityMessage", "covert json error " + e.getMessage());
                }
            }
        }

        public String a() {
            return this.c;
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public String toString() {
            return "PublicKeyStatus{code='" + this.a + '\'' + ", message='" + this.b + '\'' + ", publicKey='" + this.c + '\'' + '}';
        }
    }

    public static String a(MessageV3 messageV3) {
        JSONObject jSONObject;
        String notificationMessage = messageV3.getNotificationMessage();
        String str = null;
        if (!TextUtils.isEmpty(notificationMessage)) {
            try {
                JSONObject jSONObject2 = new JSONObject(notificationMessage).getJSONObject("data");
                if (!jSONObject2.isNull("extra")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("extra");
                    if (!jSONObject3.isNull("se")) {
                        str = jSONObject3.getString("se");
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    try {
                        jSONObject = new JSONObject(notificationMessage);
                        str = jSONObject.getString("se");
                    } catch (Exception unused) {
                    }
                }
            } catch (JSONException e2) {
                DebugLogger.e("SecurityMessage", "parse notification message error " + e2.getMessage());
                if (TextUtils.isEmpty(null)) {
                    jSONObject = new JSONObject(notificationMessage);
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(null)) {
                    try {
                        new JSONObject(notificationMessage).getString("se");
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        DebugLogger.i("SecurityMessage", "encrypt message " + str);
        return str;
    }

    public static boolean a(String str, MessageV3 messageV3) {
        String str2;
        e e2 = e(str);
        DebugLogger.e("SecurityMessage", "securityMessage " + e2);
        if (System.currentTimeMillis() / 1000 > ((long) e2.a())) {
            str2 = "message expire";
        } else if (!messageV3.getTitle().contains(e2.c())) {
            str2 = "invalid title";
        } else if (!messageV3.getContent().contains(e2.d())) {
            str2 = "invalid content";
        } else if (!String.valueOf(-1).equals(e2.b()) && !e2.b().equals(messageV3.getTaskId())) {
            str2 = "invalid taskId";
        } else if (e2.e() != -1) {
            int e3 = e2.e();
            if (e3 != 1) {
                if (e3 != 2) {
                    if (e3 == 3 && !MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e2.f())) {
                        str2 = "invalid self define";
                    }
                } else if (!messageV3.getWebUrl().contains(e2.f())) {
                    str2 = "invalid web url";
                }
            } else if (!messageV3.getActivity().contains(e2.f())) {
                str2 = "invalid click activity";
            }
            return true;
        } else {
            str2 = "invalid click type";
        }
        DebugLogger.e("SecurityMessage", str2);
        return false;
    }

    private static e e(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                eVar.a(jSONObject.getInt(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP));
            }
            if (!jSONObject.isNull(IRequestConst.TI)) {
                eVar.a(jSONObject.getString(IRequestConst.TI));
            }
            if (!jSONObject.isNull("tl")) {
                eVar.b(jSONObject.getString("tl"));
            }
            if (!jSONObject.isNull("cont")) {
                eVar.c(jSONObject.getString("cont"));
            }
            if (!jSONObject.isNull(IRequestConst.CT)) {
                eVar.b(jSONObject.getInt(IRequestConst.CT));
            }
            if (!jSONObject.isNull("pm")) {
                eVar.d(jSONObject.getString("pm"));
            }
        } catch (Exception e2) {
            DebugLogger.e("SecurityMessage", "parse decryptSign error " + e2.getMessage());
        }
        return eVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.f = str;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        return "SecurityMessage{timestamp=" + this.a + ", taskId='" + this.b + '\'' + ", title='" + this.c + '\'' + ", content='" + this.d + '\'' + ", clickType=" + this.e + ", params='" + this.f + '\'' + '}';
    }
}
