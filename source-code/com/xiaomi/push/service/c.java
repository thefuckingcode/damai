package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class c extends XMPushService.j {
    private XMPushService a = null;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f955a;

    public c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.a = xMPushService;
        this.f955a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m841a() {
        try {
            fl[] flVarArr = this.f955a;
            if (flVarArr != null) {
                this.a.a(flVarArr);
            }
        } catch (gh e) {
            b.a(e);
            this.a.a(10, e);
        }
    }
}
