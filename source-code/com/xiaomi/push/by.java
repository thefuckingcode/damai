package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class by extends al.a {
    final /* synthetic */ bx a;

    by(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.a
    public String a() {
        return "10052";
    }

    public void run() {
        b.c("exec== mUploadJob");
        if (bx.a(this.a) != null) {
            bx.a(this.a).a(bx.a(this.a));
            this.a.b("upload_time");
        }
    }
}
