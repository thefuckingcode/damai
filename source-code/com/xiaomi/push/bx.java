package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.al;
import com.xiaomi.push.cj;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bz;

/* compiled from: Taobao */
public class bx {
    private static volatile bx a;

    /* renamed from: a  reason: collision with other field name */
    private Context f141a;

    /* renamed from: a  reason: collision with other field name */
    private al.a f142a = new by(this);

    /* renamed from: a  reason: collision with other field name */
    private cm f143a;

    /* renamed from: a  reason: collision with other field name */
    private cn f144a;

    /* renamed from: a  reason: collision with other field name */
    private final String f145a = "push_stat_sp";
    private al.a b = new bz(this);

    /* renamed from: b  reason: collision with other field name */
    private final String f146b = "upload_time";
    private al.a c = new ca(this);

    /* renamed from: c  reason: collision with other field name */
    private final String f147c = "delete_time";
    private final String d = "check_time";
    private String e;
    private String f;

    private bx(Context context) {
        this.f141a = context;
    }

    public static bx a(Context context) {
        if (a == null) {
            synchronized (bx.class) {
                if (a == null) {
                    a = new bx(context);
                }
            }
        }
        return a;
    }

    private boolean a() {
        return ba.a(this.f141a).a(ho.StatDataSwitch.a(), true);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f141a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        t.a(edit);
    }

    private String c() {
        return this.f141a.getDatabasePath(cb.f151a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m302a() {
        return this.e;
    }

    public void a(cj.a aVar) {
        cj.a(this.f141a).a(aVar);
    }

    public void a(hn hnVar) {
        if (a() && bz.a(hnVar.e())) {
            a(cg.a(this.f141a, c(), hnVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(co.a(this.f141a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f143a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f143a.a(this.f141a, str2, str);
        } else {
            this.f143a.b(this.f141a, str2, str);
        }
    }

    public String b() {
        return this.f;
    }
}
