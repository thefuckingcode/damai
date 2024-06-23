package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: Taobao */
public final class q extends v {
    protected InsideNotificationItem a;
    private String b;

    public q() {
        super(4);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s, com.vivo.push.b.v
    public final void c(a aVar) {
        super.c(aVar);
        String b2 = com.vivo.push.util.q.b(this.a);
        this.b = b2;
        aVar.a("notification_v1", b2);
    }

    public final InsideNotificationItem d() {
        return this.a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        InsideNotificationItem insideNotificationItem = this.a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.q.b(insideNotificationItem);
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s, com.vivo.push.b.v
    public final void d(a aVar) {
        super.d(aVar);
        String a2 = aVar.a("notification_v1");
        this.b = a2;
        if (!TextUtils.isEmpty(a2)) {
            InsideNotificationItem a3 = com.vivo.push.util.q.a(this.b);
            this.a = a3;
            if (a3 != null) {
                a3.setMsgId(f());
            }
        }
    }
}
