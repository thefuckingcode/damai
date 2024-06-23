package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ba;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.bx;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class aj extends bx.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ t f880a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(String str, long j, XMPushService xMPushService, t tVar) {
        super(str, j);
        this.a = xMPushService;
        this.f880a = tVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.service.bx.a
    public void a(bx bxVar) {
        ba a2 = ba.a(this.a);
        String a3 = bxVar.a("MSAID", "msaid");
        String str = a2.b() + a2.a() + a2.c() + a2.d();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a3, str)) {
            bxVar.a("MSAID", "msaid", str);
            ii iiVar = new ii();
            iiVar.b(this.f880a.d);
            iiVar.c(ht.ClientInfoUpdate.f497a);
            iiVar.a(bd.a());
            iiVar.a(new HashMap());
            a2.a(iiVar.m633a());
            byte[] a4 = it.a(ah.a(this.a.getPackageName(), this.f880a.d, iiVar, hj.Notification));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a4, true);
        }
    }
}
