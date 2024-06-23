package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Collection;

/* compiled from: Taobao */
public class w extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private String f1000a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f1001a;
    private String b;
    private String c;

    public w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1000a = str;
        this.f1001a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m877a() {
        bg.b bVar;
        t a2 = u.m870a((Context) this.a);
        if (a2 == null) {
            try {
                a2 = u.a(this.a, this.f1000a, this.b, this.c);
            } catch (Exception e) {
                b.d("fail to register push account. " + e);
            }
        }
        if (a2 == null) {
            b.d("no account for registration.");
            x.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        b.m182a("do registration now.");
        Collection<bg.b> a3 = bg.a().m823a("5");
        if (a3.isEmpty()) {
            bVar = a2.a(this.a);
            ah.a(this.a, bVar);
            bg.a().a(bVar);
        } else {
            bVar = a3.iterator().next();
        }
        if (this.a.m763c()) {
            try {
                bg.c cVar = bVar.f923a;
                if (cVar == bg.c.binded) {
                    ah.a(this.a, this.f1000a, this.f1001a);
                } else if (cVar == bg.c.unbind) {
                    x.a(this.f1000a, this.f1001a);
                    XMPushService xMPushService = this.a;
                    xMPushService.getClass();
                    xMPushService.a(new XMPushService.b(bVar));
                }
            } catch (gh e2) {
                b.d("meet error, disconnect connection. " + e2);
                this.a.a(10, e2);
            }
        } else {
            x.a(this.f1000a, this.f1001a);
            this.a.a(true);
        }
    }
}
