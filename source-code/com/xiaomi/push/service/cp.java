package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.fx;
import com.xiaomi.push.ga;
import java.util.Map;

/* compiled from: Taobao */
class cp extends fx {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cp(XMPushService xMPushService, Map map, int i, String str, ga gaVar) {
        super(map, i, str, gaVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fx, com.xiaomi.push.fx, com.xiaomi.push.fx
    public byte[] a() {
        try {
            dx.b bVar = new dx.b();
            bVar.a(bv.a().m838a());
            return bVar.m437a();
        } catch (Exception e) {
            b.m182a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
