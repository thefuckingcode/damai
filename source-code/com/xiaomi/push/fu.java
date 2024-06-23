package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bg;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class fu implements gi {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private a f388a = null;

    /* renamed from: a  reason: collision with other field name */
    private fw f389a = null;

    /* renamed from: a  reason: collision with other field name */
    private fz f390a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f391a = "[Slim] ";

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f392a = new SimpleDateFormat("hh:mm:ss aaa");
    private a b = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements gb, gj {

        /* renamed from: a  reason: collision with other field name */
        String f393a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f394a = true;

        a(boolean z) {
            this.f394a = z;
            this.f393a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.gb
        public void a(fl flVar) {
            String str;
            StringBuilder sb;
            if (fu.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                str = flVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                sb.append(" Blob [");
                sb.append(flVar.m481a());
                sb.append(",");
                sb.append(flVar.a());
                sb.append(",");
                sb.append(bd.a(flVar.e()));
                str = jl1.ARRAY_END_STR;
            }
            sb.append(str);
            b.c(sb.toString());
            if (flVar != null && flVar.a() == 99999) {
                String a2 = flVar.m481a();
                fl flVar2 = null;
                if (!this.f394a) {
                    if ("BIND".equals(a2)) {
                        b.m182a("build binded result for loopback.");
                        dx.d dVar = new dx.d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a("success");
                        fl flVar3 = new fl();
                        flVar3.a(dVar.m437a(), (String) null);
                        flVar3.a((short) 2);
                        flVar3.a(99999);
                        flVar3.a("BIND", (String) null);
                        flVar3.a(flVar.e());
                        flVar3.b((String) null);
                        flVar3.c(flVar.g());
                        flVar2 = flVar3;
                    } else if (!"UBND".equals(a2) && "SECMSG".equals(a2)) {
                        fl flVar4 = new fl();
                        flVar4.a(99999);
                        flVar4.a("SECMSG", (String) null);
                        flVar4.c(flVar.g());
                        flVar4.a(flVar.e());
                        flVar4.a(flVar.m483a());
                        flVar4.b(flVar.f());
                        flVar4.a(flVar.m486a(bg.a().a(String.valueOf(99999), flVar.g()).h), (String) null);
                        flVar2 = flVar4;
                    }
                }
                if (flVar2 != null) {
                    for (Map.Entry<gb, fw.a> entry : fu.this.f389a.m500a().entrySet()) {
                        if (fu.this.f388a != entry.getKey()) {
                            entry.getValue().a(flVar2);
                        }
                    }
                }
            }
        }

        @Override // com.xiaomi.push.gb, com.xiaomi.push.gj
        public void a(gn gnVar) {
            String str;
            StringBuilder sb;
            if (fu.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                sb.append(" PKT ");
                str = gnVar.m523a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                sb.append(" PKT [");
                sb.append(gnVar.k());
                sb.append(",");
                sb.append(gnVar.j());
                str = jl1.ARRAY_END_STR;
            }
            sb.append(str);
            b.c(sb.toString());
        }

        @Override // com.xiaomi.push.gb, com.xiaomi.push.gj
        /* renamed from: a  reason: collision with other method in class */
        public boolean m495a(gn gnVar) {
            return true;
        }
    }

    public fu(fw fwVar) {
        this.f389a = fwVar;
        a();
    }

    private void a() {
        this.f388a = new a(true);
        this.b = new a(false);
        fw fwVar = this.f389a;
        a aVar = this.f388a;
        fwVar.a(aVar, aVar);
        fw fwVar2 = this.f389a;
        a aVar2 = this.b;
        fwVar2.b(aVar2, aVar2);
        this.f390a = new fv(this);
    }
}
