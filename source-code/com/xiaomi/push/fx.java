package com.xiaomi.push;

import java.util.Map;

/* compiled from: Taobao */
public class fx implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ah.a;
    public static String c;

    /* renamed from: a  reason: collision with other field name */
    private int f410a;

    /* renamed from: a  reason: collision with other field name */
    private ga f411a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f412a = fw.f395a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f413b = true;
    private String d;
    private String e;
    private String f;

    public fx(Map<String, Integer> map, int i, String str, ga gaVar) {
        a(map, i, str, gaVar);
    }

    public static final String a() {
        String str = c;
        return str != null ? str : ae.m250a() ? "sandbox.xmpush.xiaomi.com" : ae.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (!m.m735a(v.m879a()) || !ae.b()) {
            c = str;
        }
    }

    private void a(Map<String, Integer> map, int i, String str, ga gaVar) {
        this.f410a = i;
        this.d = str;
        this.f411a = gaVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m506a() {
        return this.f410a;
    }

    public void a(boolean z) {
        this.f412a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m507a() {
        return this.f412a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m508a() {
        return null;
    }

    public String b() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }
}
