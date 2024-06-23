package anet.channel.session;

import android.content.Context;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.request.Cancelable;
import anet.channel.request.a;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import anet.channel.util.b;
import anet.channel.util.c;
import com.ali.user.open.tbauth.TbAuthConstants;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.fe0;
import tb.h9;
import tb.hm;
import tb.i02;
import tb.ju2;
import tb.pd;
import tb.ry0;
import tb.sn0;
import tb.ue0;

/* compiled from: Taobao */
public class HttpSession extends Session {
    private SSLSocketFactory B;
    private boolean C = false;

    public HttpSession(Context context, hm hmVar) {
        super(context, hmVar);
        if (this.l == null) {
            String str = this.d;
            this.k = (str == null || !str.startsWith("https")) ? ConnType.d : ConnType.e;
        } else if (h9.w() && this.k.equals(ConnType.e)) {
            this.B = new b(this.e);
        }
    }

    public void F(boolean z) {
        this.C = z;
    }

    @Override // anet.channel.Session
    public void b() {
        r(6, null);
    }

    @Override // anet.channel.Session
    public void c(boolean z) {
        this.v = false;
        b();
    }

    @Override // anet.channel.Session
    public void e() {
        try {
            IConnStrategy iConnStrategy = this.l;
            if (iConnStrategy == null || iConnStrategy.getIpSource() != 1) {
                IConnStrategy iConnStrategy2 = this.l;
                if (iConnStrategy2 == null || iConnStrategy2.getStatus() != 1) {
                    a.b U = new a.b().Z(this.d).X(this.r).O((int) (((float) this.t) * c.f())).T((int) (((float) this.u) * c.f())).U(false);
                    SSLSocketFactory sSLSocketFactory = this.B;
                    if (sSLSocketFactory != null) {
                        U.Y(sSLSocketFactory);
                    }
                    if (this.n) {
                        U.I(BizTime.HOST, this.f);
                    }
                    if (h9.k() && Inet64Util.p() && ju2.c(this.f)) {
                        try {
                            this.g = Inet64Util.e(this.f);
                        } catch (Exception unused) {
                        }
                    }
                    ALog.e("awcn.HttpSession", "HttpSession connect", null, "host", this.d, TbAuthConstants.IP, this.g, "port", Integer.valueOf(this.h));
                    final a J = U.J();
                    J.w(this.g, this.h);
                    ThreadPoolExecutorFactory.g(new Runnable() {
                        /* class anet.channel.session.HttpSession.AnonymousClass1 */

                        public void run() {
                            int i = a.a(J).a;
                            if (i > 0) {
                                HttpSession.this.r(4, new ue0(1));
                            } else {
                                HttpSession.this.n(256, new ue0(256, i, "Http connect fail"));
                            }
                        }
                    }, ThreadPoolExecutorFactory.b.c);
                    return;
                }
                r(4, new ue0(1));
                return;
            }
            r(4, new ue0(1));
        } catch (Throwable th) {
            ALog.d("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable l() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean q() {
        return this.o == 4;
    }

    @Override // anet.channel.Session
    public Cancelable w(final a aVar, final RequestCb requestCb) {
        sn0 sn0;
        sn0 sn02 = sn0.NULL;
        a.b bVar = null;
        final RequestStatistic requestStatistic = aVar != null ? aVar.r : new RequestStatistic(this.e, null);
        requestStatistic.setConnType(this.k);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        requestStatistic.isComplex = this.s.isComplex;
        if (aVar == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, fe0.b(-102), requestStatistic);
            }
            return sn02;
        }
        try {
            if (aVar.o() == null && this.B != null) {
                bVar = aVar.u().Y(this.B);
            }
            if (this.n) {
                if (bVar == null) {
                    bVar = aVar.u();
                }
                bVar.I(BizTime.HOST, this.f);
            }
            if (bVar != null) {
                aVar = bVar.J();
            }
            if (this.g == null) {
                String d = aVar.j().d();
                if (h9.k() && Inet64Util.p() && ju2.c(d)) {
                    try {
                        this.g = Inet64Util.e(d);
                    } catch (Exception unused) {
                    }
                }
            }
            aVar.w(this.g, this.h);
            aVar.x(this.k.k());
            IConnStrategy iConnStrategy = this.l;
            if (iConnStrategy != null) {
                aVar.r.setIpInfo(iConnStrategy.getIpSource(), this.l.getIpType());
            } else {
                aVar.r.setIpInfo(1, 1);
            }
            aVar.r.unit = this.m;
            AnonymousClass2 r1 = new Runnable() {
                /* class anet.channel.session.HttpSession.AnonymousClass2 */

                /* renamed from: anet.channel.session.HttpSession$2$a */
                /* compiled from: Taobao */
                class a implements RequestCb {
                    a() {
                    }

                    @Override // anet.channel.RequestCb
                    public void onDataReceive(pd pdVar, boolean z) {
                        requestCb.onDataReceive(pdVar, z);
                    }

                    @Override // anet.channel.RequestCb
                    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                        if (i <= 0 && i != -204) {
                            HttpSession.this.n(2, new ue0(2, 0, "Http connect fail"));
                        }
                        requestCb.onFinish(i, str, requestStatistic);
                    }

                    @Override // anet.channel.RequestCb
                    public void onResponseCode(int i, Map<String, List<String>> map) {
                        ALog.f("awcn.HttpSession", "", aVar.n(), "httpStatusCode", Integer.valueOf(i));
                        ALog.f("awcn.HttpSession", "", aVar.n(), "response headers", map);
                        requestCb.onResponseCode(i, map);
                        requestStatistic.serverRT = ry0.h(map);
                        requestStatistic.eagleEyeId = ry0.g(map);
                        requestStatistic.isHitCache = ry0.e(map);
                        AnonymousClass2 r0 = AnonymousClass2.this;
                        HttpSession.this.o(aVar, i);
                        AnonymousClass2 r8 = AnonymousClass2.this;
                        HttpSession.this.p(aVar, map);
                    }
                }

                public void run() {
                    aVar.r.sendBeforeTime = System.currentTimeMillis() - aVar.r.reqStart;
                    a.c(aVar, new a(), HttpSession.this.C);
                }
            };
            if (!this.C) {
                sn0 = new sn0(ThreadPoolExecutorFactory.g(r1, i02.a(aVar)), aVar.n());
            } else {
                sn0 = new sn0(ThreadPoolExecutorFactory.c(r1), aVar.n());
            }
            return sn0;
        } catch (Throwable th) {
            requestCb.onFinish(-101, fe0.a(-101, th.toString()), requestStatistic);
            return sn02;
        }
    }
}
