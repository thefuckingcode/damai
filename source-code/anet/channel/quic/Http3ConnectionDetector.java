package anet.channel.quic;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.b;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import tb.d92;
import tb.h9;
import tb.hm;
import tb.ss0;
import tb.ue0;
import tb.w6;
import tb.x60;
import tb.yy0;

/* compiled from: Taobao */
public class Http3ConnectionDetector {
    private static x60 a;
    private static String b;
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static AtomicBoolean e = new AtomicBoolean(false);
    private static SharedPreferences f;
    private static boolean g = false;
    private static IStrategyFilter h = new a();
    private static AtomicInteger i = new AtomicInteger(1);
    private static IStrategyListener j = new b();
    private static NetworkStatusHelper.INetworkStatusChangeListener k = new c();
    private static AppLifecycle.AppLifecycleListener l = new d();

    /* compiled from: Taobao */
    static class a implements IStrategyFilter {
        a() {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            String str = iConnStrategy.getProtocol().protocol;
            return ConnType.HTTP3.equals(str) || ConnType.HTTP3_PLAIN.equals(str);
        }
    }

    /* compiled from: Taobao */
    static class b implements IStrategyListener {
        b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
            if (r3.equals(anet.channel.quic.Http3ConnectionDetector.b) != false) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
            r0 = anet.channel.quic.Http3ConnectionDetector.b = r3;
            r12 = anet.channel.quic.Http3ConnectionDetector.f.edit();
            r12.putString("http3_detector_host", anet.channel.quic.Http3ConnectionDetector.b);
            r12.apply();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0076, code lost:
            anet.channel.quic.Http3ConnectionDetector.o(anet.channel.status.NetworkStatusHelper.i());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007d, code lost:
            return;
         */
        private void a(b.d[] dVarArr) {
            if (!(dVarArr == null || dVarArr.length == 0)) {
                loop0:
                for (b.d dVar : dVarArr) {
                    String str = dVar.a;
                    if (!h9.t(str) && dVar.k != null) {
                        int i = 0;
                        while (true) {
                            b.i[] iVarArr = dVar.k;
                            if (i >= iVarArr.length) {
                                continue;
                                break;
                            }
                            b.C0004b[] bVarArr = iVarArr[i].a;
                            if (!(bVarArr == null || bVarArr.length == 0)) {
                                for (b.C0004b bVar : bVarArr) {
                                    b.c[] cVarArr = bVar.b;
                                    if (!(cVarArr == null || cVarArr.length == 0)) {
                                        for (b.c cVar : cVarArr) {
                                            String str2 = cVar.b;
                                            if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
                                            }
                                        }
                                        continue;
                                    }
                                }
                                continue;
                            }
                            i++;
                        }
                    }
                }
            }
        }

        private void b(b.e[] eVarArr) {
            if (!(eVarArr == null || eVarArr.length == 0)) {
                for (int i = 0; i < eVarArr.length; i++) {
                    String str = eVarArr[i].a;
                    if (!h9.t(str)) {
                        b.a[] aVarArr = eVarArr[i].h;
                        if (aVarArr != null && aVarArr.length > 0) {
                            for (b.a aVar : aVarArr) {
                                String str2 = aVar.b;
                                if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
                                    if (!str.equals(Http3ConnectionDetector.b)) {
                                        String unused = Http3ConnectionDetector.b = str;
                                        SharedPreferences.Editor edit = Http3ConnectionDetector.f.edit();
                                        edit.putString("http3_detector_host", Http3ConnectionDetector.b);
                                        edit.apply();
                                    }
                                    Http3ConnectionDetector.o(NetworkStatusHelper.i());
                                    return;
                                }
                            }
                        }
                        b.j[] jVarArr = eVarArr[i].i;
                        if (jVarArr != null) {
                            for (int i2 = 0; i2 < jVarArr.length; i2++) {
                                if (jVarArr[i2].b != null) {
                                    String str3 = jVarArr[i2].b.b;
                                    if (ConnType.HTTP3.equals(str3) || ConnType.HTTP3_PLAIN.equals(str3)) {
                                        if (!str.equals(Http3ConnectionDetector.b)) {
                                            String unused2 = Http3ConnectionDetector.b = str;
                                            SharedPreferences.Editor edit2 = Http3ConnectionDetector.f.edit();
                                            edit2.putString("http3_detector_host", Http3ConnectionDetector.b);
                                            edit2.apply();
                                        }
                                        Http3ConnectionDetector.o(NetworkStatusHelper.i());
                                        return;
                                    }
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(b.g gVar) {
            if (gVar != null) {
                if (h9.N()) {
                    a(gVar.c);
                } else {
                    b(gVar.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    static class c implements NetworkStatusHelper.INetworkStatusChangeListener {
        c() {
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        }
    }

    /* compiled from: Taobao */
    static class d implements AppLifecycle.AppLifecycleListener {
        d() {
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            if (Http3ConnectionDetector.g) {
                Http3ConnectionDetector.o(NetworkStatusHelper.i());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class e implements IConnStrategy {
        final /* synthetic */ IConnStrategy a;

        e(IConnStrategy iConnStrategy) {
            this.a = iConnStrategy;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getConnectionTimeout() {
            return this.a.getConnectionTimeout();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getHeartbeat() {
            return this.a.getHeartbeat();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public String getIp() {
            return this.a.getIp();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpSource() {
            return this.a.getIpSource();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpType() {
            return this.a.getIpType();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getPort() {
            return this.a.getPort();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public ConnProtocol getProtocol() {
            this.a.getProtocol();
            return ConnProtocol.valueOf(ConnType.HTTP3_1RTT, null, null);
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getReadTimeout() {
            return this.a.getReadTimeout();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getRetryTimes() {
            return this.a.getRetryTimes();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getStatus() {
            return this.a.getStatus();
        }
    }

    public static int i() {
        x60 x60 = a;
        if (x60 != null) {
            return x60.a(NetworkStatusHelper.j(NetworkStatusHelper.i()));
        }
        return -1;
    }

    public static boolean j() {
        return i() == 1;
    }

    /* access modifiers changed from: private */
    public static IConnStrategy k(IConnStrategy iConnStrategy) {
        return new e(iConnStrategy);
    }

    public static void l() {
        try {
            if (c.compareAndSet(false, true)) {
                ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(h9.u()));
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ss0.c());
                f = defaultSharedPreferences;
                b = defaultSharedPreferences.getString("http3_detector_host", "");
                m();
                NetworkStatusHelper.a(k);
                AppLifecycle.f(l);
                anet.channel.strategy.a.a().registerListener(j);
            }
        } catch (Exception e2) {
            ALog.d("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    private static void m() {
        if (!o(NetworkStatusHelper.i()) && h9.r()) {
            anet.channel.c.k().j(yy0.g("https://guide-acs.m.taobao.com"), d92.a, 0);
        }
    }

    public static void n(long j2) {
    }

    public static boolean o(final NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!h9.u()) {
            ALog.f("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return false;
        } else if (e.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return false;
        } else if (!NetworkStatusHelper.n()) {
            return false;
        } else {
            if (TextUtils.isEmpty(b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return false;
            }
            final List<IConnStrategy> connStrategyListByHost = anet.channel.strategy.a.a().getConnStrategyListByHost(b, h);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return false;
            }
            if (d.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(ss0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    ALog.d("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    e.set(true);
                    return false;
                }
            }
            if (a == null) {
                a = new x60("networksdk_http3_history_records");
            }
            if (!a.b(NetworkStatusHelper.j(networkStatus))) {
                return false;
            }
            ThreadPoolExecutorFactory.e(new Runnable() {
                /* class anet.channel.quic.Http3ConnectionDetector.AnonymousClass5 */

                /* renamed from: anet.channel.quic.Http3ConnectionDetector$5$a */
                /* compiled from: Taobao */
                class a implements EventCb {
                    final /* synthetic */ IConnStrategy a;

                    a(IConnStrategy iConnStrategy) {
                        this.a = iConnStrategy;
                    }

                    @Override // anet.channel.entity.EventCb
                    public void onEvent(Session session, int i, ue0 ue0) {
                        boolean z = i == 1;
                        boolean unused = Http3ConnectionDetector.g = false;
                        if (!ss0.i() || z) {
                            String j = NetworkStatusHelper.j(networkStatus);
                            ALog.e("awcn.Http3ConnDetector", "enable http3", null, "uniqueId", j, "enable", Boolean.valueOf(z));
                            Http3ConnectionDetector.a.e(j, z);
                            session.c(false);
                            Http3DetectStat http3DetectStat = new Http3DetectStat(Http3ConnectionDetector.b, this.a);
                            int i2 = z ? 1 : 0;
                            int i3 = z ? 1 : 0;
                            int i4 = z ? 1 : 0;
                            http3DetectStat.ret = i2;
                            if (!z && ue0 != null) {
                                http3DetectStat.code = ue0.a;
                            }
                            http3DetectStat.isBg = ss0.i() ? "bg" : "fg";
                            w6.b().commitStat(http3DetectStat);
                            anet.channel.c.k().j(yy0.g("https://guide-acs.m.taobao.com"), d92.a, 0);
                            return;
                        }
                        boolean unused2 = Http3ConnectionDetector.g = true;
                    }
                }

                public void run() {
                    IConnStrategy iConnStrategy = (IConnStrategy) connStrategyListByHost.get(0);
                    TnetSpdySession tnetSpdySession = new TnetSpdySession(ss0.c(), new hm("https://" + Http3ConnectionDetector.b, "Http3Detect" + Http3ConnectionDetector.i.getAndIncrement(), Http3ConnectionDetector.k(iConnStrategy)));
                    tnetSpdySession.v(257, new a(iConnStrategy));
                    tnetSpdySession.s.isCommitted = true;
                    tnetSpdySession.e();
                }
            });
            return true;
        }
    }
}
