package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.bp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class v {
    private static v a;

    /* renamed from: a  reason: collision with other field name */
    private Context f998a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f999a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();

    private v(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f998a = applicationContext;
        if (applicationContext == null) {
            this.f998a = context;
        }
        SharedPreferences sharedPreferences = this.f998a.getSharedPreferences("mipush_app_info", 0);
        String[] split = sharedPreferences.getString("unregistered_pkg_names", "").split(",");
        for (String str : split) {
            if (TextUtils.isEmpty(str)) {
                this.f999a.add(str);
            }
        }
        String[] split2 = sharedPreferences.getString("disable_push_pkg_names", "").split(",");
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
        }
        String[] split3 = sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",");
        for (String str3 : split3) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static v a(Context context) {
        if (a == null) {
            a = new v(context);
        }
        return a;
    }

    public void a(String str) {
        synchronized (this.f999a) {
            if (!this.f999a.contains(str)) {
                this.f999a.add(str);
                this.f998a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", bp.a(this.f999a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m874a(String str) {
        boolean contains;
        synchronized (this.f999a) {
            contains = this.f999a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f998a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", bp.a(this.b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m875b(String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f998a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", bp.a(this.c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m876c(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f999a) {
            if (this.f999a.contains(str)) {
                this.f999a.remove(str);
                this.f998a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", bp.a(this.f999a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f998a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", bp.a(this.b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f998a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", bp.a(this.c, ",")).commit();
            }
        }
    }
}
