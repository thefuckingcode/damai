package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
final class aq implements Runnable {
    final /* synthetic */ List a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f898a;

    aq(List list, boolean z) {
        this.a = list;
        this.f898a = z;
    }

    public void run() {
        int i;
        boolean a2 = ap.a("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            a2 = a2 || ap.a((String) it.next());
            if (a2 && !this.f898a) {
                break;
            }
        }
        if (!a2) {
            i = 2;
        }
        fj.a(i);
    }
}
