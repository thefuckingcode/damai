package anet.channel.detect;

import android.content.Context;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.a;
import anet.channel.session.TnetSpdySession;
import anet.channel.session.a;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.b;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.netutil.PingTask;
import tb.fe0;
import tb.h9;
import tb.hm;
import tb.ju2;
import tb.ke1;
import tb.pd;
import tb.ss0;
import tb.ue0;
import tb.w6;
import tb.yy0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class HorseRaceDetector {
    private TreeMap<String, b.f> a = new TreeMap<>();
    private AtomicInteger b = new AtomicInteger(1);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IStrategyListener {
        a() {
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(b.g gVar) {
            b.f[] fVarArr;
            int i = 0;
            ALog.f("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
            if (h9.s() && (fVarArr = gVar.d) != null && fVarArr.length != 0) {
                synchronized (HorseRaceDetector.this.a) {
                    while (true) {
                        b.f[] fVarArr2 = gVar.d;
                        if (i < fVarArr2.length) {
                            b.f fVar = fVarArr2[i];
                            HorseRaceDetector.this.a.put(fVar.a, fVar);
                            i++;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements EventCb {
        final /* synthetic */ HorseRaceStat a;
        final /* synthetic */ long b;
        final /* synthetic */ String c;
        final /* synthetic */ b.j d;
        final /* synthetic */ TnetSpdySession e;

        /* compiled from: Taobao */
        class a implements RequestCb {
            a() {
            }

            @Override // anet.channel.RequestCb
            public void onDataReceive(pd pdVar, boolean z) {
            }

            @Override // anet.channel.RequestCb
            public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                int i2 = 0;
                ALog.f("anet.HorseRaceDetector", "LongLinkTask request finish", b.this.c, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i), "msg", str);
                if (b.this.a.reqErrorCode == 0) {
                    b.this.a.reqErrorCode = i;
                } else {
                    HorseRaceStat horseRaceStat = b.this.a;
                    if (horseRaceStat.reqErrorCode == 200) {
                        i2 = 1;
                    }
                    horseRaceStat.reqRet = i2;
                }
                HorseRaceStat horseRaceStat2 = b.this.a;
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = b.this;
                horseRaceStat2.reqTime = (currentTimeMillis - bVar.b) + bVar.a.connTime;
                synchronized (b.this.a) {
                    b.this.a.notify();
                }
            }

            @Override // anet.channel.RequestCb
            public void onResponseCode(int i, Map<String, List<String>> map) {
                b.this.a.reqErrorCode = i;
            }
        }

        b(HorseRaceDetector horseRaceDetector, HorseRaceStat horseRaceStat, long j, String str, b.j jVar, TnetSpdySession tnetSpdySession) {
            this.a = horseRaceStat;
            this.b = j;
            this.c = str;
            this.d = jVar;
            this.e = tnetSpdySession;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, ue0 ue0) {
            if (this.a.connTime == 0) {
                this.a.connTime = System.currentTimeMillis() - this.b;
                if (i == 1) {
                    ALog.f("anet.HorseRaceDetector", "tnetSpdySession connect success", this.c, new Object[0]);
                    this.a.connRet = 1;
                    yy0 g = yy0.g(session.h() + this.d.c);
                    if (g != null) {
                        this.e.w(new a.b().a0(g).T(this.d.b.d).U(false).X(this.c).J(), new a());
                        return;
                    }
                    return;
                }
                this.a.connErrorCode = ue0.a;
                synchronized (this.a) {
                    this.a.notify();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c implements IConnStrategy {
        final /* synthetic */ b.j a;
        final /* synthetic */ ConnProtocol b;

        c(b.j jVar, ConnProtocol connProtocol) {
            this.a = jVar;
            this.b = connProtocol;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getConnectionTimeout() {
            return this.a.b.c;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getHeartbeat() {
            return 0;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public String getIp() {
            return this.a.a;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpSource() {
            return 2;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpType() {
            return 1;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getPort() {
            return this.a.b.a;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public ConnProtocol getProtocol() {
            return this.b;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getReadTimeout() {
            return this.a.b.d;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getRetryTimes() {
            return 0;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getStatus() {
            return -1;
        }
    }

    HorseRaceDetector() {
    }

    private static IConnStrategy c(ConnProtocol connProtocol, b.j jVar) {
        return new c(jVar, connProtocol);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r1 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        i(r1.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        anet.channel.util.ALog.d("anet.HorseRaceDetector", "start hr task failed", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    private void e() {
        ALog.e("anet.HorseRaceDetector", "network detect thread start", null, new Object[0]);
        while (true) {
            synchronized (this.a) {
                if (!h9.s()) {
                    this.a.clear();
                    return;
                }
                Map.Entry<String, b.f> pollFirstEntry = this.a.pollFirstEntry();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d9 */
    private void f(String str, b.j jVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(jVar.b);
        ConnType l = ConnType.l(valueOf);
        if (l != null) {
            ALog.f("anet.HorseRaceDetector", "startLongLinkTask", null, "host", str, TbAuthConstants.IP, jVar.a, "port", Integer.valueOf(jVar.b.a), "protocol", valueOf);
            String str2 = "HR" + this.b.getAndIncrement();
            Context c2 = ss0.c();
            StringBuilder sb = new StringBuilder();
            sb.append(l.k() ? "https://" : "http://");
            sb.append(str);
            TnetSpdySession tnetSpdySession = new TnetSpdySession(c2, new hm(sb.toString(), str2, c(valueOf, jVar)));
            HorseRaceStat horseRaceStat = new HorseRaceStat(str, jVar);
            long currentTimeMillis = System.currentTimeMillis();
            tnetSpdySession.v(257, new b(this, horseRaceStat, currentTimeMillis, str2, jVar, tnetSpdySession));
            tnetSpdySession.e();
            synchronized (horseRaceStat) {
                int i = jVar.b.c;
                if (i == 0) {
                    i = 10000;
                }
                horseRaceStat.wait((long) i);
                if (horseRaceStat.connTime == 0) {
                    horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
                }
                g(jVar.a, horseRaceStat);
                w6.b().commitStat(horseRaceStat);
            }
            tnetSpdySession.c(false);
        }
    }

    private void g(String str, HorseRaceStat horseRaceStat) {
        if (ju2.d(str)) {
            try {
                org.android.netutil.b bVar = new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (bVar != null) {
                    horseRaceStat.pingSuccessCount = bVar.f();
                    horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                    horseRaceStat.localIP = bVar.d();
                }
            } catch (Throwable th) {
                ALog.d("anet.HorseRaceDetector", "ping6 task fail.", null, th, new Object[0]);
            }
        }
    }

    private void h(String str, b.j jVar) {
        yy0 g = yy0.g(jVar.b.b + ke1.SCHEME_SLASH + str + jVar.c);
        if (g != null) {
            int i = 0;
            ALog.f("anet.HorseRaceDetector", "startShortLinkTask", null, "url", g);
            a.b Y = new a.b().a0(g).I(IRequestConst.CONNECTION, "close").O(jVar.b.c).T(jVar.b.d).U(false).Y(new anet.channel.util.b(str));
            anet.channel.request.a J = Y.X("HR" + this.b.getAndIncrement()).J();
            J.w(jVar.a, jVar.b.a);
            long currentTimeMillis = System.currentTimeMillis();
            a.b a2 = anet.channel.session.a.a(J);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            HorseRaceStat horseRaceStat = new HorseRaceStat(str, jVar);
            horseRaceStat.connTime = currentTimeMillis2;
            int i2 = a2.a;
            if (i2 <= 0) {
                horseRaceStat.connErrorCode = i2;
            } else {
                horseRaceStat.connRet = 1;
                if (a2.a == 200) {
                    i = 1;
                }
                horseRaceStat.reqRet = i;
                horseRaceStat.reqErrorCode = a2.a;
                horseRaceStat.reqTime = horseRaceStat.connTime;
            }
            g(jVar.a, horseRaceStat);
            w6.b().commitStat(horseRaceStat);
        }
    }

    private void i(b.f fVar) {
        b.j[] jVarArr = fVar.b;
        if (jVarArr != null && jVarArr.length != 0) {
            String str = fVar.a;
            int i = 0;
            while (true) {
                b.j[] jVarArr2 = fVar.b;
                if (i < jVarArr2.length) {
                    b.j jVar = jVarArr2[i];
                    String str2 = jVar.b.b;
                    if (str2.equalsIgnoreCase("http") || str2.equalsIgnoreCase("https")) {
                        h(str, jVar);
                    } else if (str2.equalsIgnoreCase(ConnType.HTTP2) || str2.equalsIgnoreCase(ConnType.SPDY) || str2.equalsIgnoreCase(ConnType.QUIC)) {
                        f(str, jVar);
                    } else if (str2.equalsIgnoreCase("tcp")) {
                        j(str, jVar);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void j(String str, b.j jVar) {
        String str2 = "HR" + this.b.getAndIncrement();
        ALog.f("anet.HorseRaceDetector", "startTcpTask", str2, TbAuthConstants.IP, jVar.a, "port", Integer.valueOf(jVar.b.a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, jVar);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(jVar.a, jVar.b.a);
            int i = jVar.b.c;
            if (i == 0) {
                i = 10000;
            }
            socket.setSoTimeout(i);
            ALog.f("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            horseRaceStat.connErrorCode = fe0.ERROR_IO_EXCEPTION;
        }
        w6.b().commitStat(horseRaceStat);
    }

    public void d() {
        anet.channel.strategy.a.a().registerListener(new a());
        AppLifecycle.f(new AppLifecycle.AppLifecycleListener() {
            /* class anet.channel.detect.HorseRaceDetector.AnonymousClass2 */

            @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
            public void background() {
                ALog.f("anet.HorseRaceDetector", "background", null, new Object[0]);
                if (h9.s()) {
                    ThreadPoolExecutorFactory.f(new Runnable() {
                        /* class anet.channel.detect.HorseRaceDetector.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            HorseRaceDetector.this.e();
                        }
                    });
                }
            }

            @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
            public void forground() {
            }
        });
    }
}
