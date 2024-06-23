package com.xiaomi.push;

import com.xiaomi.push.al;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ca extends al.a {
    final /* synthetic */ bx a;

    ca(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.a
    public String a() {
        return "10053";
    }

    public void run() {
        if (bx.a(this.a) != null) {
            bx.a(this.a).b(bx.a(this.a));
            this.a.b("delete_time");
        }
    }
}
