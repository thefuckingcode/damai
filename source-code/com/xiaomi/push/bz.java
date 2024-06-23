package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bz extends al.a {
    final /* synthetic */ bx a;

    bz(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.a
    public String a() {
        return "10054";
    }

    public void run() {
        b.c("exec== DbSizeControlJob");
        cj.a(bx.a(this.a)).a(new cc(bx.a(this.a), new WeakReference(bx.a(this.a))));
        this.a.b("check_time");
    }
}
