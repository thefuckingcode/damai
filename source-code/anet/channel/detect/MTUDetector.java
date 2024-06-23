package anet.channel.detect;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.statist.MtuDetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.a;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.ali.user.open.tbauth.TbAuthConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import org.android.netutil.PingTask;
import org.android.netutil.b;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import tb.e03;
import tb.h9;
import tb.ss0;
import tb.w6;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class MTUDetector {
    private static HashMap<String, Long> a = new HashMap<>();
    private static Map<String, Integer> b = new ConcurrentHashMap();

    MTUDetector() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(String str) {
        b bVar;
        if (!h9.H()) {
            ALog.f("anet.MTUDetector", "mtu detect closed.", null, new Object[0]);
            return;
        }
        ALog.e("anet.MTUDetector", "mtuDetectTask start", null, new Object[0]);
        SpdyAgent.getInstance(ss0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l = a.get(str);
            if (l == null || currentTimeMillis >= l.longValue()) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ss0.c());
                long j = defaultSharedPreferences.getLong("sp_mtu_" + str, 0);
                if (currentTimeMillis < j) {
                    a.put(str, Long.valueOf(j));
                    ALog.e("anet.MTUDetector", "mtuDetectTask in period of validity", null, new Object[0]);
                    return;
                }
                List<IConnStrategy> connStrategyListByHost = a.a().getConnStrategyListByHost(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN);
                String ip = (connStrategyListByHost == null || connStrategyListByHost.isEmpty()) ? null : connStrategyListByHost.get(0).getIp();
                if (!TextUtils.isEmpty(ip)) {
                    ALog.e("anet.MTUDetector", "[mtuDetectTask]", null, TbAuthConstants.IP, ip);
                    Future<b> launch = new PingTask(ip, 1000, 3, 0, 0).launch();
                    Future<b> launch2 = new PingTask(ip, 1000, 3, 972, 0).launch();
                    Future<b> launch3 = new PingTask(ip, 1000, 3, 1172, 0).launch();
                    Future<b> launch4 = new PingTask(ip, 1000, 3, 1272, 0).launch();
                    Future<b> launch5 = new PingTask(ip, 1000, 3, 1372, 0).launch();
                    Future<b> launch6 = new PingTask(ip, 1000, 3, 1432, 0).launch();
                    try {
                        bVar = launch.get();
                    } catch (Exception unused) {
                        bVar = null;
                    }
                    if (bVar != null) {
                        if (bVar.f() < 2) {
                            ALog.e("anet.MTUDetector", "MTU detect preTask error", null, "errCode", Integer.valueOf(bVar.b()), e03.POINT_SUCCESS_COUNT_MEASURE, Integer.valueOf(bVar.f()));
                            return;
                        }
                        int i = 1000;
                        if (!e(ip, 1000, launch2)) {
                            i = 0;
                        }
                        if (e(ip, 1200, launch3)) {
                            i = 1200;
                        }
                        if (e(ip, 1300, launch4)) {
                            i = 1300;
                        }
                        if (e(ip, 1400, launch5)) {
                            i = 1400;
                        }
                        if (e(ip, 1460, launch6)) {
                            i = 1460;
                        }
                        ALog.e("anet.MTUDetector", "MTU detect.", null, "uniqueId", str, "maxAvailableMTU", Integer.valueOf(i));
                        long j2 = currentTimeMillis + 432000000;
                        a.put(str, Long.valueOf(j2));
                        b.put(str, Integer.valueOf(i));
                        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                        edit.putLong("sp_mtu_" + str, j2).apply();
                    }
                }
            }
        }
    }

    private boolean e(String str, int i, Future<b> future) {
        b bVar;
        try {
            bVar = future.get();
        } catch (Exception unused) {
            bVar = null;
        }
        if (bVar == null) {
            return false;
        }
        int f = bVar.f();
        int i2 = 3 - f;
        StringBuilder sb = new StringBuilder();
        org.android.netutil.a[] e = bVar.e();
        int length = e.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(e[i3].a);
            if (i3 != length - 1) {
                sb.append(",");
            }
        }
        ALog.e("anet.MTUDetector", "MTU detect result", null, "mtu", Integer.valueOf(i), e03.POINT_SUCCESS_COUNT_MEASURE, Integer.valueOf(f), "timeoutCount", Integer.valueOf(i2));
        MtuDetectStat mtuDetectStat = new MtuDetectStat();
        mtuDetectStat.mtu = i;
        mtuDetectStat.ip = str;
        mtuDetectStat.pingSuccessCount = f;
        mtuDetectStat.pingTimeoutCount = i2;
        mtuDetectStat.rtt = sb.toString();
        mtuDetectStat.errCode = bVar.b();
        w6.b().commitStat(mtuDetectStat);
        if (f > i2) {
            return true;
        }
        return false;
    }

    public int b() {
        Integer num = b.get(NetworkStatusHelper.j(NetworkStatusHelper.i()));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void d() {
        NetworkStatusHelper.a(new NetworkStatusHelper.INetworkStatusChangeListener() {
            /* class anet.channel.detect.MTUDetector.AnonymousClass1 */

            @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
            public void onNetworkStatusChanged(final NetworkStatusHelper.NetworkStatus networkStatus) {
                ThreadPoolExecutorFactory.e(new Runnable() {
                    /* class anet.channel.detect.MTUDetector.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        try {
                            NetworkStatusHelper.NetworkStatus networkStatus = networkStatus;
                            if (networkStatus == NetworkStatusHelper.NetworkStatus.NO) {
                                return;
                            }
                            if (networkStatus != NetworkStatusHelper.NetworkStatus.NONE) {
                                MTUDetector.this.c(NetworkStatusHelper.j(networkStatus));
                            }
                        } catch (Throwable th) {
                            ALog.d("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
                        }
                    }
                });
            }
        });
    }
}
