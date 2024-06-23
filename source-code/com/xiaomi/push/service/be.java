package com.xiaomi.push.service;

import android.text.TextUtils;
import com.ali.user.mobile.rpc.ApiConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cr;
import com.xiaomi.push.cv;
import com.xiaomi.push.df;
import com.xiaomi.push.dx;
import com.xiaomi.push.ez;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.hb;
import com.xiaomi.push.service.bg;
import java.util.Date;

/* compiled from: Taobao */
public class be {
    private XMPushService a;

    be(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(gk gkVar) {
        String c = gkVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            cr a2 = cv.a().a(fx.a(), false);
            if (a2 != null && split.length > 0) {
                a2.a(split);
                this.a.a(20, (Exception) null);
                this.a.a(true);
            }
        }
    }

    private void b(gn gnVar) {
        bg.b a2;
        String l = gnVar.l();
        String k = gnVar.k();
        if (!TextUtils.isEmpty(l) && !TextUtils.isEmpty(k) && (a2 = bg.a().a(k, l)) != null) {
            hb.a(this.a, a2.f925a, (long) hb.a(gnVar.m523a()), true, true, System.currentTimeMillis());
        }
    }

    private void c(fl flVar) {
        bg.b a2;
        String g = flVar.g();
        String num = Integer.toString(flVar.a());
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(num) && (a2 = bg.a().a(num, g)) != null) {
            hb.a(this.a, a2.f925a, (long) flVar.c(), true, true, System.currentTimeMillis());
        }
    }

    public void a(fl flVar) {
        if (5 != flVar.a()) {
            c(flVar);
        }
        try {
            b(flVar);
        } catch (Exception e) {
            b.a("handle Blob chid = " + flVar.a() + " cmd = " + flVar.m481a() + " packetid = " + flVar.e() + " failure ", e);
        }
    }

    public void a(gn gnVar) {
        if (!"5".equals(gnVar.k())) {
            b(gnVar);
        }
        String k = gnVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            gnVar.l(k);
        }
        if (k.equals("0")) {
            b.m182a("Received wrong packet with chid = 0 : " + gnVar.m523a());
        }
        if (gnVar instanceof gl) {
            gk a2 = gnVar.a("kick");
            if (a2 != null) {
                String l = gnVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a("reason");
                b.m182a("kicked by server, chid=" + k + " res=" + bg.b.a(l) + " type=" + a3 + " reason=" + a4);
                if ("wait".equals(a3)) {
                    bg.b a5 = bg.a().a(k, l);
                    if (a5 != null) {
                        this.a.a(a5);
                        a5.a(bg.c.unbind, 3, 0, a4, a3);
                        return;
                    }
                    return;
                }
                this.a.a(k, l, 3, a4, a3);
                bg.a().m827a(k, l);
                return;
            }
        } else if (gnVar instanceof gm) {
            gm gmVar = (gm) gnVar;
            if ("redir".equals(gmVar.b())) {
                gk a6 = gmVar.a("hosts");
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.a.m760b().a(this.a, k, gnVar);
    }

    public void b(fl flVar) {
        StringBuilder sb;
        String a2;
        String str;
        int i;
        int i2;
        bg.c cVar;
        String a3 = flVar.m481a();
        if (flVar.a() != 0) {
            String num = Integer.toString(flVar.a());
            if ("SECMSG".equals(flVar.m481a())) {
                if (!flVar.m484a()) {
                    this.a.m760b().a(this.a, num, flVar);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(flVar.b());
                sb.append(" errStr = ");
                a2 = flVar.m488c();
            } else if ("BIND".equals(a3)) {
                dx.d a4 = dx.d.a(flVar.m485a());
                String g = flVar.g();
                bg.b a5 = bg.a().a(num, g);
                if (a5 != null) {
                    if (a4.m394a()) {
                        b.m182a("SMACK: channel bind succeeded, chid=" + flVar.a());
                        a5.a(bg.c.binded, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a6 = a4.m393a();
                    if ("auth".equals(a6)) {
                        if ("invalid-sig".equals(a4.m395b())) {
                            b.m182a("SMACK: bind error invalid-sig token = " + a5.c + " sec = " + a5.h);
                            fj.a(0, ez.BIND_INVALID_SIG.a(), 1, null, 0);
                        }
                        cVar = bg.c.unbind;
                        i2 = 1;
                        i = 5;
                    } else if ("cancel".equals(a6)) {
                        cVar = bg.c.unbind;
                        i2 = 1;
                        i = 7;
                    } else {
                        if ("wait".equals(a6)) {
                            this.a.a(a5);
                            a5.a(bg.c.unbind, 1, 7, a4.m395b(), a6);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.m395b();
                        b.m182a(str);
                    }
                    a5.a(cVar, i2, i, a4.m395b(), a6);
                    bg.a().m827a(num, g);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.m395b();
                    b.m182a(str);
                }
                return;
            } else if ("KICK".equals(a3)) {
                dx.g a7 = dx.g.a(flVar.m485a());
                String g2 = flVar.g();
                String a8 = a7.m415a();
                String b = a7.m417b();
                b.m182a("kicked by server, chid=" + num + " res= " + bg.b.a(g2) + " type=" + a8 + " reason=" + b);
                if ("wait".equals(a8)) {
                    bg.b a9 = bg.a().a(num, g2);
                    if (a9 != null) {
                        this.a.a(a9);
                        a9.a(bg.c.unbind, 3, 0, b, a8);
                        return;
                    }
                    return;
                }
                this.a.a(num, g2, 3, b, a8);
                bg.a().m827a(num, g2);
                return;
            } else {
                return;
            }
        } else if ("PING".equals(a3)) {
            byte[] a10 = flVar.m485a();
            if (a10 != null && a10.length > 0) {
                dx.j a11 = dx.j.a(a10);
                if (a11.m428b()) {
                    bv.a().a(a11.m426a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.m757a();
            }
            if ("1".equals(flVar.e())) {
                b.m182a("received a server ping");
            } else {
                fj.b();
            }
            this.a.m761b();
            return;
        } else if ("SYNC".equals(a3)) {
            if ("CONF".equals(flVar.m487b())) {
                bv.a().a(dx.b.a(flVar.m485a()));
                return;
            } else if (TextUtils.equals("U", flVar.m487b())) {
                dx.k a12 = dx.k.a(flVar.m485a());
                df.a(this.a).a(a12.m430a(), a12.m433b(), new Date(a12.m429a()), new Date(a12.m432b()), a12.c() * 1024, a12.e());
                fl flVar2 = new fl();
                flVar2.a(0);
                flVar2.a(flVar.m481a(), "UCA");
                flVar2.a(flVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new bt(xMPushService, flVar2));
                return;
            } else if (TextUtils.equals("P", flVar.m487b())) {
                dx.i a13 = dx.i.a(flVar.m485a());
                fl flVar3 = new fl();
                flVar3.a(0);
                flVar3.a(flVar.m481a(), "PCA");
                flVar3.a(flVar.e());
                dx.i iVar = new dx.i();
                if (a13.m424a()) {
                    iVar.a(a13.m423a());
                }
                flVar3.a(iVar.m437a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new bt(xMPushService2, flVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                a2 = flVar.e();
            } else {
                return;
            }
        } else if (ApiConstants.ResultActionType.NOTIFY.equals(flVar.m481a())) {
            dx.h a14 = dx.h.a(flVar.m485a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a14.c());
            sb.append(" desc = ");
            a2 = a14.m420a();
        } else {
            return;
        }
        sb.append(a2);
        str = sb.toString();
        b.m182a(str);
    }
}
