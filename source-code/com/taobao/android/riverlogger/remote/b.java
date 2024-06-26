package com.taobao.android.riverlogger.remote;

import android.content.SharedPreferences;
import android.util.Base64;
import com.taobao.android.riverlogger.RVLLog;
import com.taobao.android.riverlogger.RVLRemoteConnectCallback;
import com.taobao.android.riverlogger.RVLRemoteInfo;
import com.taobao.android.riverlogger.inspector.Inspector;
import com.taobao.android.riverlogger.remote.RemoteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b {
    private static RemoteChannel a;
    private static SharedPreferences b;
    private static final AtomicBoolean c = new AtomicBoolean(false);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements RemoteChannel.RemoteCommandCallback {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ RemoteChannel c;
        final /* synthetic */ RVLRemoteInfo d;
        final /* synthetic */ RVLRemoteConnectCallback e;

        a(String str, String str2, RemoteChannel remoteChannel, RVLRemoteInfo rVLRemoteInfo, RVLRemoteConnectCallback rVLRemoteConnectCallback) {
            this.a = str;
            this.b = str2;
            this.c = remoteChannel;
            this.d = rVLRemoteInfo;
            this.e = rVLRemoteConnectCallback;
        }

        @Override // com.taobao.android.riverlogger.remote.RemoteChannel.RemoteCommandCallback
        public void finish(JSONObject jSONObject, Integer num, String str) {
            String str2;
            boolean z = false;
            if (num == null) {
                if (b.h(Base64.decode(jSONObject.optString("token").getBytes(), 0), this.a, this.b)) {
                    b.f(this.c, this.d.c());
                    str2 = null;
                } else {
                    str2 = "Server connect failed, try again";
                }
                str = str2;
            }
            RVLRemoteConnectCallback rVLRemoteConnectCallback = this.e;
            if (rVLRemoteConnectCallback != null) {
                if (str == null) {
                    z = true;
                }
                rVLRemoteConnectCallback.finish(z, str);
            }
        }
    }

    public static void b() {
        f(null, true);
    }

    public static RemoteChannel c() {
        return a;
    }

    public static void d(RVLRemoteInfo rVLRemoteInfo, RVLRemoteConnectCallback rVLRemoteConnectCallback) {
        if (rVLRemoteInfo != null) {
            RemoteChannel remoteChannel = new RemoteChannel(rVLRemoteInfo.d(), rVLRemoteInfo.b());
            if (rVLRemoteInfo.e()) {
                f(remoteChannel, rVLRemoteInfo.c());
                return;
            }
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                sb.append((char) (random.nextInt(95) + 32));
            }
            String sb2 = sb.toString();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clientToken", sb2);
            } catch (JSONException unused) {
            }
            remoteChannel.k("Dev.verify", null, jSONObject, new a(sb2, rVLRemoteInfo.a(), remoteChannel, rVLRemoteInfo, rVLRemoteConnectCallback));
        } else if (rVLRemoteConnectCallback != null) {
            rVLRemoteConnectCallback.finish(false, "Invalid parameter");
        }
    }

    private static void e() {
        if (c.compareAndSet(false, true)) {
            RVLLog.f(new c());
        }
    }

    static void f(RemoteChannel remoteChannel, boolean z) {
        SharedPreferences sharedPreferences;
        a = remoteChannel;
        if (remoteChannel == null) {
            SharedPreferences sharedPreferences2 = b;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().remove("server").apply();
            }
        } else {
            if (z && (sharedPreferences = b) != null) {
                sharedPreferences.edit().putString("server", remoteChannel.e()).apply();
            }
            e();
        }
        Inspector.g(a != null);
    }

    public static void g(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            b = sharedPreferences;
            String string = sharedPreferences.getString("server", null);
            if (string != null) {
                RemoteChannel remoteChannel = new RemoteChannel(string, null);
                a = remoteChannel;
                f(remoteChannel, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean h(byte[] bArr, String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        return a.b((simpleDateFormat.format(new Date()) + " " + str + "-" + str2).getBytes(), bArr);
    }
}
