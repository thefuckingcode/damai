package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class r {
    private static volatile r a;

    /* renamed from: a */
    private Context f818a;

    /* renamed from: a */
    private Handler f819a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private Map<String, Map<String, String>> f820a = new HashMap();

    private r(Context context) {
        this.f818a = context;
    }

    public static r a(Context context) {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        if (this.f820a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Map<String, String> map = this.f820a.get(str);
            if (map == null) {
                return "";
            }
            return map.get(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f820a == null) {
            this.f820a = new HashMap();
        }
        Map<String, String> map = this.f820a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f820a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return this.f818a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a */
    public synchronized void m743a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f819a.post(new s(this, str, str2, str3));
    }
}
