package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.cj;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ck extends al.a {
    final /* synthetic */ cj a;

    ck(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.xiaomi.push.al.a
    public String a() {
        return "100957";
    }

    public void run() {
        synchronized (this.a.f156a) {
            if (this.a.f156a.size() > 0) {
                if (this.a.f156a.size() > 1) {
                    cj cjVar = this.a;
                    cjVar.a(cjVar.f156a);
                } else {
                    cj cjVar2 = this.a;
                    cjVar2.b((cj.a) cjVar2.f156a.get(0));
                }
                this.a.f156a.clear();
                System.gc();
            }
        }
    }
}
