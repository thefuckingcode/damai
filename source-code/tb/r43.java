package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.c;

/* compiled from: Taobao */
public class r43 {
    private Context a;
    private SharedPreferences b;
    private Object c;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        static r43 a = new r43();
    }

    private r43() {
        this.c = new Object();
        Context k = c.m().k();
        if (k != null) {
            this.a = a(k);
        }
        Context context = this.a;
        if (context != null) {
            this.b = context.getSharedPreferences("shared_msg_sdk", 0);
        }
    }

    private Context a(Context context) {
        boolean b2 = y03.b();
        w33.a("fbeVersion is " + b2);
        return (!b2 || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static r43 f() {
        return b.a;
    }

    private SharedPreferences g() {
        Context context;
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.c) {
            SharedPreferences sharedPreferences2 = this.b;
            if (sharedPreferences2 != null || (context = this.a) == null) {
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("shared_msg_sdk", 0);
            this.b = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    public void b(boolean z) {
        SharedPreferences g = g();
        if (g != null) {
            g.edit().putBoolean("hasDefaultChannelCreated", z).commit();
        }
    }

    public boolean c() {
        SharedPreferences g = g();
        if (g != null) {
            return g.getBoolean("hasDefaultChannelCreated", false);
        }
        return false;
    }

    public void d(String str) {
        SharedPreferences g = g();
        if (g != null) {
            g.edit().putString("decryptTag", str).commit();
        }
    }

    public String e() {
        SharedPreferences g = g();
        return g != null ? g.getString("decryptTag", com.alibaba.security.common.d.c.a) : com.alibaba.security.common.d.c.a;
    }
}
