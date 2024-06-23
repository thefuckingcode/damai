package com.xiaomi.push;

import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
class fc implements bg.b.a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fw f344a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f345a;

    /* renamed from: a  reason: collision with other field name */
    private bg.b f346a;

    /* renamed from: a  reason: collision with other field name */
    private bg.c f347a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f348a = false;

    fc(XMPushService xMPushService, bg.b bVar) {
        this.f345a = xMPushService;
        this.f347a = bg.c.binding;
        this.f346a = bVar;
    }

    private void b() {
        this.f346a.b(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public void c() {
        ez ezVar;
        b();
        if (this.f348a && this.a != 11) {
            fa a2 = fh.m474a().m476a();
            int i = fe.a[this.f347a.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    ezVar = ez.BIND_SUCCESS;
                }
                if (a2 != null) {
                    a2.b(this.f344a.m499a());
                    a2.d(this.f346a.f928b);
                    a2.f333b = 1;
                    try {
                        a2.a((byte) Integer.parseInt(this.f346a.g));
                    } catch (NumberFormatException unused) {
                    }
                    fh.m474a().a(a2);
                    return;
                }
                return;
            }
            int i2 = this.a;
            if (i2 == 17) {
                ezVar = ez.BIND_TCP_READ_TIMEOUT;
            } else if (i2 == 21) {
                ezVar = ez.BIND_TIMEOUT;
            } else {
                try {
                    ff.a c = ff.c(fh.a().a());
                    a2.f330a = c.a.a();
                    a2.c(c.f349a);
                } catch (NullPointerException unused2) {
                    a2 = null;
                }
                if (a2 != null) {
                }
            }
            a2.f330a = ezVar.a();
            if (a2 != null) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f346a.a(this);
        this.f344a = this.f345a.m755a();
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (!this.f348a && cVar == bg.c.binding) {
            this.f347a = cVar2;
            this.a = i;
            this.f348a = true;
        }
        this.f345a.a(new fd(this, 4));
    }
}
