package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.m;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class aa extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f869a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aa(int i, XMPushService xMPushService, Cif ifVar) {
        super(i);
        this.f869a = xMPushService;
        this.a = ifVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m781a() {
        Map<String, String> map = null;
        try {
            if (m.m735a((Context) this.f869a)) {
                try {
                    map = ag.a((Context) this.f869a, this.a);
                } catch (Throwable unused) {
                }
            }
            ah.a(this.f869a, y.a(this.f869a, this.a, map));
        } catch (gh e) {
            b.a(e);
            this.f869a.a(10, e);
        }
    }
}
