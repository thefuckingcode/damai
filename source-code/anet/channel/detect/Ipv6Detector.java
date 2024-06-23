package anet.channel.detect;

import android.text.TextUtils;
import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.session.HttpSession;
import anet.channel.statist.Ipv6DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.uc.crashsdk.export.LogType;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.a90;
import tb.h9;
import tb.hm;
import tb.jl1;
import tb.ju2;
import tb.ss0;
import tb.ue0;
import tb.w6;
import tb.x60;

/* compiled from: Taobao */
public class Ipv6Detector {
    private static x60 a;
    private static AtomicInteger b = new AtomicInteger(1);
    private static AtomicBoolean c = new AtomicBoolean(false);
    static Random d = new Random();
    private static IStrategyFilter e = new a();
    private static NetworkStatusHelper.INetworkStatusChangeListener f = new b();

    /* compiled from: Taobao */
    static class a implements IStrategyFilter {
        a() {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            return ju2.d(iConnStrategy.getIp());
        }
    }

    /* compiled from: Taobao */
    static class b implements NetworkStatusHelper.INetworkStatusChangeListener {
        b() {
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            Ipv6Detector.f();
        }
    }

    static {
        new ConcurrentHashMap();
    }

    public static int d() {
        if (!h9.B()) {
            return 1;
        }
        String j = NetworkStatusHelper.j(NetworkStatusHelper.i());
        x60 x60 = a;
        if (x60 != null) {
            return x60.a(j);
        }
        return -1;
    }

    public static void e() {
        if (c.compareAndSet(false, true)) {
            a = new x60("networksdk_ipv6_history_records");
            f();
            NetworkStatusHelper.a(f);
        }
    }

    public static void f() {
        if (!h9.B()) {
            ALog.e("awcn.Ipv6Detector", "ipv6 detect is disable.", null, new Object[0]);
        } else if (!NetworkStatusHelper.n()) {
            ALog.e("awcn.Ipv6Detector", "network is not connected.", null, new Object[0]);
        } else if (NetworkStatusHelper.i() != NetworkStatusHelper.NetworkStatus.WIFI) {
            ALog.e("awcn.Ipv6Detector", "current network is not wifi.", null, new Object[0]);
        } else if (Inet64Util.n() != 3) {
            ALog.e("awcn.Ipv6Detector", "ip stack is not dual-stack.", null, new Object[0]);
        } else {
            final String j = NetworkStatusHelper.j(NetworkStatusHelper.i());
            if (a == null) {
                a = new x60("networksdk_ipv6_history_records");
            }
            if (!a.b(j)) {
                ALog.e("awcn.Ipv6Detector", "detectHistoryRecord has ipv6-detect-record.", null, "uniqueId", j, "status", Integer.valueOf(d()));
                return;
            }
            ThreadPoolExecutorFactory.e(new Runnable() {
                /* class anet.channel.detect.Ipv6Detector.AnonymousClass1 */

                /* renamed from: anet.channel.detect.Ipv6Detector$1$a */
                /* compiled from: Taobao */
                class a implements EventCb {
                    final /* synthetic */ Ipv6DetectStat a;
                    final /* synthetic */ long b;

                    a(Ipv6DetectStat ipv6DetectStat, long j) {
                        this.a = ipv6DetectStat;
                        this.b = j;
                    }

                    @Override // anet.channel.entity.EventCb
                    public void onEvent(Session session, int i, ue0 ue0) {
                        boolean z = i == 512;
                        this.a.cip = anet.channel.strategy.a.a().getClientIp();
                        Ipv6DetectStat ipv6DetectStat = this.a;
                        int i2 = z ? 1 : 0;
                        int i3 = z ? 1 : 0;
                        int i4 = z ? 1 : 0;
                        ipv6DetectStat.ret = i2;
                        ipv6DetectStat.detectTime = System.currentTimeMillis() - this.b;
                        ALog.e("awcn.Ipv6Detector", "start ipv6 detect finish.", null, "uniqueId", j, "isSucc", Boolean.valueOf(z));
                        Ipv6Detector.a.e(j, z);
                        w6.b().commitStat(this.a);
                    }
                }

                public void run() {
                    String str;
                    List<IConnStrategy> connStrategyListByHost = anet.channel.strategy.a.a().getConnStrategyListByHost("amdc.m.taobao.com", Ipv6Detector.e);
                    StringBuilder sb = new StringBuilder("http://");
                    if (connStrategyListByHost == null || connStrategyListByHost.size() <= 0) {
                        String[] c = a90.c();
                        str = c.length > 0 ? c[Ipv6Detector.d.nextInt(c.length)] : null;
                    } else {
                        str = connStrategyListByHost.get(0).getIp();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(jl1.ARRAY_START_STR);
                        sb.append(str);
                        sb.append(jl1.ARRAY_END_STR);
                        Ipv6DetectStat ipv6DetectStat = new Ipv6DetectStat("amdc.m.taobao.com");
                        ipv6DetectStat.ip = str;
                        ipv6DetectStat.detectUrl = sb.toString();
                        long currentTimeMillis = System.currentTimeMillis();
                        ALog.e("awcn.Ipv6Detector", "start ipv6 detect.", null, "url", sb);
                        String sb2 = sb.toString();
                        HttpSession httpSession = new HttpSession(ss0.c(), new hm(sb2, "Ipv6Detector-" + Ipv6Detector.b.getAndIncrement(), null));
                        httpSession.v(LogType.UNEXP_OTHER, new a(ipv6DetectStat, currentTimeMillis));
                        httpSession.e();
                    }
                }
            });
        }
    }
}
