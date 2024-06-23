package com.alipay.sdk.m.m0;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.l0.f;

/* compiled from: Taobao */
public class a {
    public String a = "";
    public SharedPreferences b = null;
    public SharedPreferences.Editor c = null;
    public Context d = null;
    public boolean e = false;

    public a(Context context, String str, String str2, boolean z, boolean z2) {
        this.e = z2;
        this.a = str2;
        this.d = context;
        if (context != null) {
            this.b = context.getSharedPreferences(str2, 0);
        }
    }

    private void b() {
        SharedPreferences sharedPreferences;
        if (this.c == null && (sharedPreferences = this.b) != null) {
            this.c = sharedPreferences.edit();
        }
    }

    public void a(String str, String str2) {
        if (!f.m180a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.c;
            if (editor != null) {
                editor.putString(str, str2);
            }
        }
    }

    public void b(String str) {
        if (!f.m180a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.c;
            if (editor != null) {
                editor.remove(str);
            }
        }
    }

    public boolean a() {
        boolean z;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            if (!this.e && this.b != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.c.commit()) {
                z = false;
                if (!(this.b == null || (context = this.d) == null)) {
                    this.b = context.getSharedPreferences(this.a, 0);
                }
                return z;
            }
        }
        z = true;
        this.b = context.getSharedPreferences(this.a, 0);
        return z;
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.m180a(string)) {
                return string;
            }
        }
        return "";
    }
}
