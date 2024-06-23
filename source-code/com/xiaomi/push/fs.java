package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.bp;
import com.xiaomi.push.service.bv;
import tb.jl1;

/* compiled from: Taobao */
public class fs extends gd {
    private fn a;

    /* renamed from: a  reason: collision with other field name */
    private fo f385a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f386a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f387a;

    public fs(XMPushService xMPushService, fx fxVar) {
        super(xMPushService, fxVar);
    }

    @Override // com.xiaomi.push.gd
    private fl a(boolean z) {
        fr frVar = new fr();
        if (z) {
            frVar.a("1");
        }
        byte[] a2 = fj.m480a();
        if (a2 != null) {
            dx.j jVar = new dx.j();
            jVar.a(a.a(a2));
            frVar.a(jVar.m437a(), (String) null);
        }
        return frVar;
    }

    private void h() {
        try {
            this.a = new fn(((gd) this).f415a.getInputStream(), this, ((fw) this).f400a);
            this.f385a = new fo(((gd) this).f415a.getOutputStream(), this);
            ft ftVar = new ft(this, "Blob Reader (" + ((fw) this).b + jl1.BRACKET_END_STR);
            this.f386a = ftVar;
            ftVar.start();
        } catch (Exception e) {
            throw new gh("Error to init reader and writer", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.gd, com.xiaomi.push.gd, com.xiaomi.push.gd, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw
    public synchronized void a() {
        h();
        this.f385a.a();
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.gd
    public synchronized void a(int i, Exception exc) {
        fn fnVar = this.a;
        if (fnVar != null) {
            fnVar.b();
            this.a = null;
        }
        fo foVar = this.f385a;
        if (foVar != null) {
            try {
                foVar.b();
            } catch (Exception e) {
                b.a(e);
            }
            this.f385a = null;
        }
        this.f387a = null;
        super.a(i, exc);
    }

    /* access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar != null) {
            if (flVar.m484a()) {
                b.m182a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m488c());
            }
            if (flVar.a() == 0) {
                if ("PING".equals(flVar.m481a())) {
                    b.m182a("[Slim] RCV ping id=" + flVar.e());
                    g();
                } else if (StandOutWindow.ACTION_CLOSE.equals(flVar.m481a())) {
                    c(13, null);
                }
            }
            for (fw.a aVar : ((fw) this).f404a.values()) {
                aVar.a(flVar);
            }
        }
    }

    @Override // com.xiaomi.push.fw
    @Deprecated
    public void a(gn gnVar) {
        b(fl.a(gnVar, (String) null));
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a(bg.b bVar) {
        fk.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a(String str, String str2) {
        fk.a(str, str2, this);
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.gd
    /* renamed from: a  reason: collision with other method in class */
    public void m492a(boolean z) {
        if (this.f385a != null) {
            fl a2 = a(z);
            b.m182a("[Slim] SND ping id=" + a2.e());
            b(a2);
            f();
            return;
        }
        throw new gh("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.fw
    public void a(fl[] flVarArr) {
        for (fl flVar : flVarArr) {
            b(flVar);
        }
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.gd, com.xiaomi.push.gd, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw
    /* renamed from: a  reason: collision with other method in class */
    public boolean m493a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.gd, com.xiaomi.push.gd, com.xiaomi.push.gd, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw, com.xiaomi.push.fw
    /* renamed from: a  reason: collision with other method in class */
    public synchronized byte[] m494a() {
        if (this.f387a == null && !TextUtils.isEmpty(((fw) this).f401a)) {
            String a2 = bv.m837a();
            StringBuilder sb = new StringBuilder();
            String str = ((fw) this).f401a;
            sb.append(str.substring(str.length() / 2));
            sb.append(a2.substring(a2.length() / 2));
            this.f387a = bp.a(((fw) this).f401a.getBytes(), sb.toString().getBytes());
        }
        return this.f387a;
    }

    @Override // com.xiaomi.push.fw
    public void b(fl flVar) {
        fo foVar = this.f385a;
        if (foVar != null) {
            try {
                int a2 = foVar.a(flVar);
                ((fw) this).d = SystemClock.elapsedRealtime();
                String f = flVar.f();
                if (!TextUtils.isEmpty(f)) {
                    hb.a(((fw) this).f400a, f, (long) a2, false, true, System.currentTimeMillis());
                }
                for (fw.a aVar : ((fw) this).f407b.values()) {
                    aVar.a(flVar);
                }
            } catch (Exception e) {
                throw new gh(e);
            }
        } else {
            throw new gh("the writer is null.");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(gn gnVar) {
        if (gnVar != null) {
            for (fw.a aVar : ((fw) this).f404a.values()) {
                aVar.a(gnVar);
            }
        }
    }
}
