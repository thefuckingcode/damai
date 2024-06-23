package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.detect.HttpStrategyDetector;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import com.alibaba.analytics.core.network.NetworkUtil;
import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.a90;
import tb.ag2;
import tb.h9;
import tb.ss0;
import tb.y4;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {
    Map<String, StrategyTable> a = new LruStrategyMap();
    volatile StrategyConfig b = null;
    final LocalDnsStrategyTable c = new LocalDnsStrategyTable();
    private final StrategyTable d = new StrategyTable(NetworkUtil.NETWORK_CLASS_UNKNOWN);
    private final Set<String> e = new HashSet();
    private String f;
    private volatile String g = "";
    private volatile boolean h = false;
    private volatile NetworkStatusHelper.NetworkStatus i;

    /* compiled from: Taobao */
    private static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        private static final long serialVersionUID = 1866478394612290927L;

        public LruStrategyMap() {
            super(3);
        }

        /* access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(final Map.Entry<String, StrategyTable> entry) {
            y4.d(new Runnable() {
                /* class anet.channel.strategy.StrategyInfoHolder.LruStrategyMap.AnonymousClass1 */

                public void run() {
                    StrategyTable strategyTable = (StrategyTable) entry.getValue();
                    if (strategyTable.isChanged) {
                        StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                        strategyStatObject.writeStrategyFileId = strategyTable.uniqueId;
                        c.f((Serializable) entry.getValue(), strategyTable.uniqueId, strategyStatObject);
                        strategyTable.isChanged = false;
                    }
                }
            });
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            h();
            l();
        } catch (Throwable unused) {
        }
        c();
    }

    private void c() {
        synchronized (this.a) {
            for (Map.Entry<String, StrategyTable> entry : this.a.entrySet()) {
                entry.getValue().checkInit();
            }
        }
        synchronized (this) {
            if (this.b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.checkInit();
                strategyConfig.setHolder(this);
                this.b = strategyConfig;
            }
        }
    }

    private String f() {
        String str;
        File[] c2 = c.c();
        if (c2 == null) {
            return this.f;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= c2.length) {
                str = "";
                break;
            }
            File file = c2[i2];
            if (!file.isDirectory()) {
                str = file.getName();
                if (str.startsWith("WIFI")) {
                    break;
                }
            }
            i2++;
        }
        return TextUtils.isEmpty(str) ? this.f : str;
    }

    private String g(NetworkStatusHelper.NetworkStatus networkStatus) {
        String str;
        String str2 = "";
        if (networkStatus.isWifi()) {
            String k = NetworkStatusHelper.k();
            if (h9.M()) {
                if (this.b != null && !TextUtils.isEmpty(k) && !"02:00:00:00:00:00".equals(k)) {
                    str2 = this.b.getUniqueIdByBssid(ag2.h(k));
                }
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                this.h = true;
                str = f();
            } else {
                String h2 = ag2.h(k);
                if (!TextUtils.isEmpty(h2)) {
                    str2 = h2;
                }
                str = "WIFI$" + str2;
            }
            return str;
        } else if (!networkStatus.isMobile()) {
            return str2;
        } else {
            return networkStatus.getType() + "$" + NetworkStatusHelper.b();
        }
    }

    private void h() {
        NetworkStatusHelper.a(this);
        this.i = NetworkStatusHelper.i();
        this.f = "WIFI$" + ss0.h();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        this.g = g(this.i);
        if (h9.M() && this.i.isWifi() && this.h) {
            e().sendAmdcRequest(a90.a(), true);
            this.h = false;
        }
    }

    public static StrategyInfoHolder k() {
        return new StrategyInfoHolder();
    }

    private void l() {
        ALog.f("awcn.StrategyInfoHolder", "restore", null, new Object[0]);
        if (!h9.n()) {
            this.b = (StrategyConfig) c.h("StrategyConfig", null);
            if (this.b != null) {
                this.b.checkInit();
                this.b.setHolder(this);
            }
            j();
            String str = this.g;
            if (!TextUtils.isEmpty(str)) {
                i(str, true);
            }
        }
        y4.d(new Runnable() {
            /* class anet.channel.strategy.StrategyInfoHolder.AnonymousClass1 */

            public void run() {
                try {
                    ALog.f("awcn.StrategyInfoHolder", "start loading strategy files", null, new Object[0]);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (h9.n()) {
                        ALog.f("awcn.StrategyInfoHolder", "load strategy async", null, new Object[0]);
                        StrategyConfig strategyConfig = (StrategyConfig) c.h("StrategyConfig", null);
                        if (strategyConfig != null) {
                            strategyConfig.checkInit();
                            strategyConfig.setHolder(StrategyInfoHolder.this);
                            synchronized (StrategyInfoHolder.this) {
                                StrategyInfoHolder.this.b = strategyConfig;
                            }
                        }
                        StrategyInfoHolder.this.j();
                        String str = StrategyInfoHolder.this.g;
                        if (!TextUtils.isEmpty(str)) {
                            StrategyInfoHolder.this.i(str, true);
                        }
                    }
                    File[] c = c.c();
                    if (c != null) {
                        int i = 0;
                        for (int i2 = 0; i2 < c.length && i < 2; i2++) {
                            File file = c[i2];
                            if (!file.isDirectory()) {
                                String name = file.getName();
                                if (!name.equals(StrategyInfoHolder.this.g) && !name.startsWith("StrategyConfig")) {
                                    StrategyInfoHolder.this.i(name, false);
                                    i++;
                                }
                            }
                        }
                        ALog.f("awcn.StrategyInfoHolder", "end loading strategy files", null, "total cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void d() {
        NetworkStatusHelper.s(this);
    }

    /* access modifiers changed from: package-private */
    public StrategyTable e() {
        StrategyTable strategyTable = this.d;
        String str = this.g;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                strategyTable = this.a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r2 = (anet.channel.strategy.StrategyTable) anet.channel.strategy.c.h(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r2 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r2.checkInit();
        r2.parseStrategyData();
        r3 = r6.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r6.a.put(r2.uniqueId, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        r3 = r6.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r6.e.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        if (r8 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        if (r2 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r0.isSucceed = r1;
        tb.w6.b().commitStat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r0 = null;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r8 == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r0 = new anet.channel.statist.StrategyStatObject(0);
        r0.readStrategyFileId = r7;
     */
    public void i(String str, boolean z) {
        synchronized (this.e) {
            if (!this.e.contains(str)) {
                this.e.add(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        synchronized (this.a) {
            for (StrategyTable strategyTable : this.a.values()) {
                if (strategyTable.isChanged) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    String str = strategyTable.uniqueId;
                    strategyStatObject.writeStrategyFileId = str;
                    c.f(strategyTable, str, strategyStatObject);
                    strategyTable.isChanged = false;
                }
            }
            c.f(this.b.createSelf(), "StrategyConfig", null);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(b.g gVar) {
        int i2 = gVar.f;
        if (i2 != 0) {
            AmdcRuntimeInfo.k(i2, gVar.g);
        }
        o(gVar.h);
        e().update(gVar);
        this.b.update(gVar);
    }

    /* access modifiers changed from: package-private */
    public void o(String str) {
        if (h9.M() && this.i.isWifi()) {
            String str2 = "WIFI$" + str;
            if (TextUtils.isEmpty(str)) {
                str2 = this.f;
            }
            if (!str2.equals(this.g)) {
                ALog.f("awcn.StrategyInfoHolder", "update uniqueId old uniqueId :" + this.g, str2, new Object[0]);
                this.g = str2;
                String k = NetworkStatusHelper.k();
                if (!TextUtils.isEmpty(k) && !"02:00:00:00:00:00".equals(k) && !this.g.equals(this.f)) {
                    this.b.updateBssidUniqueIdMap(ag2.h(k), this.g);
                }
                synchronized (this.a) {
                    if (!this.a.containsKey(this.g)) {
                        i(this.g, true);
                    }
                }
            }
        }
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(final NetworkStatusHelper.NetworkStatus networkStatus) {
        this.i = networkStatus;
        j();
        final String str = this.g;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                if (!this.a.containsKey(str)) {
                    y4.d(new Runnable() {
                        /* class anet.channel.strategy.StrategyInfoHolder.AnonymousClass2 */

                        public void run() {
                            StrategyInfoHolder.this.i(str, true);
                            Http3ConnectionDetector.o(networkStatus);
                            HttpStrategyDetector.h();
                        }
                    });
                } else {
                    Http3ConnectionDetector.o(networkStatus);
                    HttpStrategyDetector.h();
                }
            }
        }
    }
}
