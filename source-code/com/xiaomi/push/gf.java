package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class gf extends XMPushService.j {
    final /* synthetic */ gd a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f418a;
    final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    gf(gd gdVar, int i, int i2, Exception exc) {
        super(i);
        this.a = gdVar;
        this.b = i2;
        this.f418a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "shutdown the connection. " + this.b + AVFSCacheConstants.COMMA_SEP + this.f418a;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m514a() {
        this.a.b.a(this.b, this.f418a);
    }
}
