package com.efs.sdk.base.a.c.a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.d.a;
import com.efs.sdk.base.a.e.b;
import com.efs.sdk.base.a.e.f;
import java.io.File;
import java.util.Map;
import tb.c13;
import tb.k23;
import tb.n13;
import tb.t43;
import tb.w23;

/* compiled from: Taobao */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile SharedPreferences a;

    static boolean a() {
        c13 a2 = a.a();
        File c = n13.c(a2.c, a2.a);
        if (!c.exists()) {
            return false;
        }
        w23.i(c);
        return true;
    }

    static void c() {
        File b = n13.b(a.a().c, a.a().a);
        if (b.exists()) {
            b.delete();
        }
    }

    private void e() {
        if (this.a == null) {
            synchronized (b.class) {
                if (this.a == null) {
                    String str = a.a().a;
                    this.a = com.alibaba.android.newsharedpreferences.a.c(a.a().c, k23.b(("config_" + str.toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(@NonNull a aVar) {
        d();
        if (this.a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        edit.putInt("cver", aVar.a);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : aVar.f.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        try {
            e();
        } catch (Throwable th) {
            t43.c("efs.config", "init sharedpreferences error", th);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (!f.a.a.b()) {
            c.a().h();
        }
    }
}
