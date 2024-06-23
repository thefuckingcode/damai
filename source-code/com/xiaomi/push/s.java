package com.xiaomi.push;

import android.content.SharedPreferences;

/* compiled from: Taobao */
class s implements Runnable {
    final /* synthetic */ r a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f821a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    s(r rVar, String str, String str2, String str3) {
        this.a = rVar;
        this.f821a = str;
        this.b = str2;
        this.c = str3;
    }

    public void run() {
        SharedPreferences.Editor edit = r.a(this.a).getSharedPreferences(this.f821a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
