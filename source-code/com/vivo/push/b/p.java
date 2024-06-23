package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.o;
import com.vivo.push.util.q;

/* compiled from: Taobao */
public final class p extends o {
    private String a;
    private String b;
    private byte[] c;
    private long d;
    private InsideNotificationItem e;

    public p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.d = j;
        this.e = insideNotificationItem;
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void c(a aVar) {
        aVar.a("package_name", this.a);
        aVar.a("notify_id", this.d);
        aVar.a("notification_v1", q.b(this.e));
        aVar.a("open_pkg_name", this.b);
        aVar.a("open_pkg_name_encode", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final long e() {
        return this.d;
    }

    public final InsideNotificationItem f() {
        return this.e;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void d(a aVar) {
        this.a = aVar.a("package_name");
        this.d = aVar.b("notify_id", -1L);
        this.b = aVar.a("open_pkg_name");
        this.c = aVar.b("open_pkg_name_encode");
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.e = q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.d);
        }
    }

    public p() {
        super(5);
    }
}
