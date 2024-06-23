package anet.channel.detect;

import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.detect.NetworkDetector;
import anet.channel.request.a;
import anet.channel.session.HttpSession;
import anet.channel.statist.NetworkDiagnosticStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import org.android.netutil.NetUtils;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONException;
import tb.a90;
import tb.h9;
import tb.hm;
import tb.jl1;
import tb.pd;
import tb.ss0;
import tb.w6;
import tb.yy0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ExceptionDetector {
    private long a;
    private String b;
    private String c;
    private String d;
    private int e = 0;
    private LimitedQueue<Pair<String, Integer>> f = new LimitedQueue<>(10);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class LimitedQueue<E> extends LinkedList<E> {
        private int limit;

        public LimitedQueue(int i) {
            this.limit = i;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.Queue, java.util.LinkedList, java.util.Deque
        public boolean add(E e) {
            boolean add = super.add(e);
            while (add && size() > this.limit) {
                super.remove();
            }
            return add;
        }
    }

    /* compiled from: Taobao */
    private interface TaskType {
        public static final int MTU_1000 = 2;
        public static final int MTU_1200 = 3;
        public static final int MTU_1460 = 4;
        public static final int PING = 1;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements RequestCb {
        final /* synthetic */ long a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ String c;
        final /* synthetic */ CountDownLatch d;

        a(ExceptionDetector exceptionDetector, long j, JSONObject jSONObject, String str, CountDownLatch countDownLatch) {
            this.a = j;
            this.b = jSONObject;
            this.c = str;
            this.d = countDownLatch;
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(pd pdVar, boolean z) {
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            this.b.put("detectUrl", (Object) this.c);
            this.b.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, (Object) Integer.valueOf(i));
            this.b.put("errorMsg", (Object) str);
            this.b.put("requestTime", (Object) Long.valueOf(currentTimeMillis));
            this.d.countDown();
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b {
        String a;
        String b;
        String c;
        long d;
        Future<org.android.netutil.b> e;
        Future<org.android.netutil.b> f;
        Future<org.android.netutil.b> g;
        Future<org.android.netutil.b> h;

        private b(ExceptionDetector exceptionDetector) {
        }
    }

    ExceptionDetector() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void A(String str, JSONObject jSONObject, NetworkDetector.INetworkDiagnosisCallback iNetworkDiagnosisCallback) {
        if (iNetworkDiagnosisCallback != null && jSONObject != null) {
            jSONObject.put("type", (Object) str);
            jSONObject.put("isFinish", (Object) Boolean.FALSE);
            ALog.e("anet.ExceptionDetector", "networkDiagnosisCallbackData :" + jSONObject.toString(), null, new Object[0]);
            iNetworkDiagnosisCallback.onNetworkDiagnosisFinished(jSONObject);
        }
    }

    private ArrayList<String> C(String str, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            org.android.netutil.b bVar = null;
            try {
                bVar = new PingTask(str, 0, 1, 0, i2).launch().get();
            } catch (Exception unused) {
            }
            StringBuilder sb = new StringBuilder();
            if (bVar != null) {
                String c2 = bVar.c();
                double d2 = bVar.e()[0].a;
                int b2 = bVar.b();
                if (TextUtils.isEmpty(c2)) {
                    c2 = jl1.MUL;
                }
                sb.append("hop=");
                sb.append(c2);
                sb.append(",rtt=");
                sb.append(d2);
                sb.append(",errCode=");
                sb.append(b2);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private b p(String str, String str2) {
        b bVar = new b();
        bVar.a = str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            bVar.b = InetAddress.getByName(str).getHostAddress();
            bVar.d = System.currentTimeMillis() - currentTimeMillis;
        } catch (UnknownHostException unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            bVar.c = str2;
        } else {
            List<IConnStrategy> connStrategyListByHost = anet.channel.strategy.a.a().getConnStrategyListByHost(str);
            if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
                bVar.c = connStrategyListByHost.get(0).getIp();
            }
        }
        String str3 = !TextUtils.isEmpty(bVar.c) ? bVar.c : bVar.b;
        if (!TextUtils.isEmpty(str3)) {
            bVar.e = new PingTask(str3, 1000, 3, 0, 0).launch();
            bVar.f = new PingTask(str3, 1000, 3, 972, 0).launch();
            bVar.g = new PingTask(str3, 1000, 3, 1172, 0).launch();
            bVar.h = new PingTask(str3, 1000, 3, 1432, 0).launch();
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject r() throws JSONException {
        ALog.e("anet.ExceptionDetector", "[network_diagnosis_auto]start.", null, new Object[0]);
        SpdyAgent.getInstance(ss0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        JSONObject jSONObject = new JSONObject();
        NetworkStatusHelper.NetworkStatus i = NetworkStatusHelper.i();
        jSONObject.put("networkInfo", (Object) v(i));
        jSONObject.put("localDetect", (Object) u(i));
        b p = p(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN, this.b);
        b p2 = p("gw.alicdn.com", this.d);
        b p3 = p("msgacs.m.taobao.com", this.c);
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(x(p));
        jSONArray.add(x(p2));
        jSONArray.add(x(p3));
        jSONObject.put("internetDetect", (Object) jSONArray);
        jSONObject.put("bizDetect", (Object) t());
        ALog.e("anet.ExceptionDetector", "[network_diagnosis_auto]finish.", null, "result", jSONObject.toString());
        w6.b().commitStat(new NetworkDiagnosticStat(2));
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<Pair<String, Integer>> it = this.f.iterator();
        while (it.hasNext()) {
            Pair<String, Integer> next = it.next();
            jSONObject2.put((String) next.first, next.second);
        }
        jSONObject.put("bizDetect", (Object) jSONObject2);
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject u(NetworkStatusHelper.NetworkStatus networkStatus) {
        String defaultGateway = networkStatus.isWifi() ? NetUtils.getDefaultGateway("114.114.114.114") : NetUtils.getPreferNextHop("114.114.114.114", 2);
        Future<org.android.netutil.b> future = null;
        if (!TextUtils.isEmpty(defaultGateway)) {
            future = new PingTask(defaultGateway, 1000, 3, 0, 0).launch();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nextHop", (Object) defaultGateway);
        jSONObject.put("ping", (Object) w(1, future));
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject v(NetworkStatusHelper.NetworkStatus networkStatus) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) networkStatus.getType());
        jSONObject.put("subType", (Object) NetworkStatusHelper.e());
        if (networkStatus != NetworkStatusHelper.NetworkStatus.NO) {
            if (networkStatus.isMobile()) {
                jSONObject.put("apn", (Object) NetworkStatusHelper.b());
                jSONObject.put(a90.CARRIER, (Object) NetworkStatusHelper.c());
            } else {
                jSONObject.put(a90.BSSID, (Object) NetworkStatusHelper.k());
                jSONObject.put("ssid", (Object) NetworkStatusHelper.m());
            }
            jSONObject.put("proxy", (Object) NetworkStatusHelper.f());
            jSONObject.put("ipStack", (Object) Integer.valueOf(Inet64Util.n()));
        }
        return jSONObject;
    }

    private JSONObject w(int i, Future<org.android.netutil.b> future) {
        JSONObject jSONObject = new JSONObject();
        if (future == null) {
            return jSONObject;
        }
        org.android.netutil.b bVar = null;
        try {
            bVar = future.get();
        } catch (Exception unused) {
        }
        if (bVar == null) {
            return jSONObject;
        }
        jSONObject.put("errCode", Integer.valueOf(bVar.b()));
        int f2 = bVar.f();
        if (f2 > 0) {
            if (i == 2) {
                this.e = Math.max(this.e, 1000);
            } else if (i == 3) {
                this.e = Math.max(this.e, 1200);
            } else if (i == 4) {
                this.e = Math.max(this.e, 1460);
            }
        }
        jSONObject.put("successCnt", Integer.valueOf(f2));
        JSONArray jSONArray = new JSONArray();
        org.android.netutil.a[] e2 = bVar.e();
        for (org.android.netutil.a aVar : e2) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("seq", (Object) Integer.valueOf(aVar.b));
            jSONObject2.put("hop", (Object) Integer.valueOf(aVar.c));
            jSONObject2.put("rtt", (Object) Double.valueOf(aVar.a));
            jSONArray.add(jSONObject2);
        }
        jSONObject.put("pingCnt", Integer.valueOf(jSONArray.size()));
        jSONObject.put("response", (Object) jSONArray);
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject x(b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (!(bVar == null || bVar.e == null)) {
            jSONObject.put("host", (Object) bVar.a);
            jSONObject.put("currentIp", (Object) bVar.c);
            jSONObject.put("localIp", (Object) bVar.b);
            jSONObject.put("dnsTime", (Object) Long.valueOf(bVar.d));
            jSONObject.put("ping", (Object) w(1, bVar.e));
            jSONObject.put("MTU1000", (Object) w(2, bVar.f));
            jSONObject.put("MTU1200", (Object) w(3, bVar.g));
            jSONObject.put("MTU1460", (Object) w(4, bVar.h));
            if (MtopUnitStrategy.GUIDE_ONLINE_DOMAIN.equals(bVar.a)) {
                ArrayList<String> C = C(!TextUtils.isEmpty(bVar.c) ? bVar.c : bVar.b, 5);
                JSONObject jSONObject2 = new JSONObject();
                int i = 0;
                while (i < C.size()) {
                    int i2 = i + 1;
                    jSONObject2.put(String.valueOf(i2), (Object) C.get(i));
                    i = i2;
                }
                jSONObject.put("traceRoute", (Object) jSONObject2);
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject y(String str) {
        yy0 g = yy0.g(str);
        JSONObject jSONObject = new JSONObject();
        if (g == null) {
            return jSONObject;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new HttpSession(ss0.c(), new hm(g.d(), "exceptionDetect", null)).w(new a.b().a0(g).R("GET").J(), new a(this, System.currentTimeMillis(), jSONObject, str, countDownLatch));
        try {
            countDownLatch.await(20000, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean z() {
        boolean z = false;
        if (this.f.size() != 10) {
            return false;
        }
        if (NetworkStatusHelper.i() == NetworkStatusHelper.NetworkStatus.NO) {
            ALog.e("anet.ExceptionDetector", "no network", null, new Object[0]);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.a) {
            return false;
        }
        Iterator<Pair<String, Integer>> it = this.f.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next().second).intValue();
            if (intValue == -202 || intValue == -400 || intValue == -401 || intValue == -405 || intValue == -406) {
                i++;
            }
        }
        if (i * 2 > 10) {
            z = true;
        }
        if (z) {
            this.a = currentTimeMillis + ConfigStorage.DEFAULT_SMALL_MAX_AGE;
        }
        return z;
    }

    public void B() {
        NetworkStatusHelper.a(new NetworkStatusHelper.INetworkStatusChangeListener() {
            /* class anet.channel.detect.ExceptionDetector.AnonymousClass1 */

            @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
            public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
                ThreadPoolExecutorFactory.e(new Runnable() {
                    /* class anet.channel.detect.ExceptionDetector.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        ExceptionDetector.this.f.clear();
                        ExceptionDetector.this.a = 0;
                        ExceptionDetector.this.e = 0;
                    }
                });
            }
        });
    }

    public void q(final RequestStatistic requestStatistic) {
        if (!h9.J()) {
            ALog.f("anet.ExceptionDetector", "exception detect closed.", null, new Object[0]);
        } else {
            ThreadPoolExecutorFactory.e(new Runnable() {
                /* class anet.channel.detect.ExceptionDetector.AnonymousClass2 */

                public void run() {
                    try {
                        RequestStatistic requestStatistic = requestStatistic;
                        if (requestStatistic != null) {
                            if (!TextUtils.isEmpty(requestStatistic.ip) && requestStatistic.ret == 0) {
                                if (MtopUnitStrategy.GUIDE_ONLINE_DOMAIN.equalsIgnoreCase(requestStatistic.host)) {
                                    ExceptionDetector.this.b = requestStatistic.ip;
                                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(requestStatistic.host)) {
                                    ExceptionDetector.this.c = requestStatistic.ip;
                                } else if ("gw.alicdn.com".equalsIgnoreCase(requestStatistic.host)) {
                                    ExceptionDetector.this.d = requestStatistic.ip;
                                }
                            }
                            if (!TextUtils.isEmpty(requestStatistic.url)) {
                                ExceptionDetector.this.f.add(Pair.create(requestStatistic.url, Integer.valueOf(requestStatistic.statusCode)));
                            }
                            if (ExceptionDetector.this.z()) {
                                ExceptionDetector.this.r();
                            }
                        }
                    } catch (Throwable th) {
                        ALog.d("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
                    }
                }
            });
        }
    }

    public int s() {
        return this.e;
    }
}
