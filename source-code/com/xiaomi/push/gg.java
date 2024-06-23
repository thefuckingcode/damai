package com.xiaomi.push;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class gg implements Runnable {
    final /* synthetic */ gd a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f419a;

    gg(gd gdVar, String str) {
        this.a = gdVar;
        this.f419a = str;
    }

    public void run() {
        cv.a().a(this.f419a, true);
    }
}
