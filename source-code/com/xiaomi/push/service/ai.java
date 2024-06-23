package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.j;
import com.xiaomi.push.service.bx;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ai extends bx.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ t f879a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ai(String str, long j, XMPushService xMPushService, t tVar) {
        super(str, j);
        this.a = xMPushService;
        this.f879a = tVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.service.bx.a
    public void a(bx bxVar) {
        String a2 = bxVar.a("GAID", "gaid");
        String a3 = j.a((Context) this.a);
        if (!TextUtils.isEmpty(a3) && !TextUtils.equals(a2, a3)) {
            bxVar.a("GAID", "gaid", a3);
            ii iiVar = new ii();
            iiVar.b(this.f879a.d);
            iiVar.c(ht.ClientInfoUpdate.f497a);
            iiVar.a(bd.a());
            iiVar.a(new HashMap());
            iiVar.m633a().put("gaid", a3);
            byte[] a4 = it.a(ah.a(this.a.getPackageName(), this.f879a.d, iiVar, hj.Notification));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a4, true);
        }
    }
}
