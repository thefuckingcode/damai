package anet.channel.strategy;

import android.content.Context;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.util.ALog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import tb.ag2;
import tb.b90;
import tb.gm;
import tb.h42;
import tb.h9;
import tb.ju2;
import tb.y4;
import tb.yy0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class StrategyInstance implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {
    boolean a = false;
    StrategyInfoHolder b = null;
    long c = 0;
    CopyOnWriteArraySet<IStrategyListener> d = new CopyOnWriteArraySet<>();
    private IStrategyFilter e = new a(this);

    /* compiled from: Taobao */
    class a implements IStrategyFilter {
        a(StrategyInstance strategyInstance) {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            String str = iConnStrategy.getProtocol().protocol;
            if (ConnType.QUIC.equals(str) || ConnType.QUIC_PLAIN.equals(str)) {
                ALog.f("awcn.StrategyCenter", "gquic strategy disabled", null, "strategy", iConnStrategy);
                return false;
            }
            boolean u = h9.u();
            boolean j = Http3ConnectionDetector.j();
            if ((u && j) || (!ConnType.HTTP3.equals(str) && !ConnType.HTTP3_PLAIN.equals(str))) {
                return true;
            }
            ALog.f("awcn.StrategyCenter", "http3 strategy disabled", null, "strategy", iConnStrategy);
            return false;
        }
    }

    StrategyInstance() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean b() {
        if (this.b != null) {
            return false;
        }
        ALog.k("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.a));
        return true;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void forceRefreshStrategy(String str) {
        if (!b() && !TextUtils.isEmpty(str)) {
            ALog.f("awcn.StrategyCenter", "force refresh strategy", null, "host", str);
            this.b.e().sendAmdcRequest(str, true);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public boolean getAbStrategyStatusByHost(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || b()) {
            return false;
        }
        return this.b.e().getAbStrategyStatusByHost(str, str2);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getCNameByHost(String str) {
        if (b() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.e().getCnameByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getClientIp() {
        if (b()) {
            return "";
        }
        return this.b.e().clientIp;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.e);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListWithoutWait(String str) {
        if (TextUtils.isEmpty(str) || b()) {
            return Collections.EMPTY_LIST;
        }
        String cnameByHost = this.b.e().getCnameByHost(str);
        if (!TextUtils.isEmpty(cnameByHost)) {
            str = cnameByHost;
        }
        List<IConnStrategy> queryByHost = this.b.e().queryByHost(str);
        if (queryByHost.isEmpty()) {
            queryByHost = this.b.c.g(str);
        }
        ListIterator<IConnStrategy> listIterator = queryByHost.listIterator();
        while (listIterator.hasNext()) {
            if (!this.e.accept(listIterator.next())) {
                listIterator.remove();
            }
        }
        return queryByHost;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getFormalizeUrl(String str) {
        yy0 g = yy0.g(str);
        if (g == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", null, "URL", str);
            return null;
        }
        String n = g.n();
        try {
            String schemeByHost = getSchemeByHost(g.d(), g.j());
            if (!schemeByHost.equalsIgnoreCase(g.j())) {
                n = ag2.e(schemeByHost, ":", str.substring(str.indexOf(WVUtils.URL_SEPARATOR)));
            }
            if (ALog.g(1)) {
                ALog.c("awcn.StrategyCenter", "", null, "raw", ag2.i(str, 128), "ret", ag2.i(n, 128));
            }
        } catch (Exception e2) {
            ALog.d("awcn.StrategyCenter", "getFormalizeUrl failed", null, e2, "raw", str);
        }
        return n;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getIpv4ConnStrategyListByHost(String str, boolean z, int i) {
        List<IConnStrategy> f = this.b.c.f(str, z, i);
        if (f.isEmpty()) {
            return f;
        }
        ListIterator<IConnStrategy> listIterator = f.listIterator();
        while (listIterator.hasNext()) {
            if (!this.e.accept(listIterator.next())) {
                listIterator.remove();
            }
        }
        return f;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getUnitByHost(String str) {
        if (b()) {
            return null;
        }
        return this.b.b.getUnitByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void initialize(Context context) {
        if (!this.a && context != null) {
            try {
                ALog.f("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
                h9.f(context);
                NetworkStatusHelper.t(context);
                AmdcRuntimeInfo.g(context);
                c.e(context);
                HttpDispatcher.f().b(this);
                this.b = StrategyInfoHolder.k();
                this.a = true;
                ALog.f("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
            } catch (Exception e2) {
                ALog.d("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e2, new Object[0]);
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, gm gmVar) {
        if (!b() && iConnStrategy != null && (iConnStrategy instanceof IPConnStrategy)) {
            IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
            if (iPConnStrategy.ipSource == 1) {
                this.b.c.d(str, iConnStrategy, gmVar);
            } else if (iPConnStrategy.ipSource == 0) {
                this.b.e().notifyConnEvent(str, iConnStrategy, gmVar);
            }
        }
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(b90 b90) {
        if (b90.a == 1 && this.b != null) {
            ALog.c("awcn.StrategyCenter", "receive amdc event", null, new Object[0]);
            b.g a2 = b.a((JSONObject) b90.b);
            if (a2 != null) {
                this.b.n(a2);
                saveData();
                Iterator<IStrategyListener> it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onStrategyUpdated(a2);
                    } catch (Exception e2) {
                        ALog.d("awcn.StrategyCenter", "onStrategyUpdated failed", null, e2, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "registerListener", null, "listener", this.d);
        if (iStrategyListener != null) {
            this.d.add(iStrategyListener);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void saveData() {
        ALog.f("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c > 30000) {
            this.c = currentTimeMillis;
            y4.c(new Runnable() {
                /* class anet.channel.strategy.StrategyInstance.AnonymousClass2 */

                public void run() {
                    if (!StrategyInstance.this.b()) {
                        StrategyInstance.this.b.m();
                    }
                }
            }, 500);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void switchEnv() {
        c.b();
        HttpDispatcher.f().i();
        StrategyInfoHolder strategyInfoHolder = this.b;
        if (strategyInfoHolder != null) {
            strategyInfoHolder.d();
            this.b = StrategyInfoHolder.k();
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "unregisterListener", null, "listener", this.d);
        this.d.remove(iStrategyListener);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter) {
        if (TextUtils.isEmpty(str) || b()) {
            return Collections.EMPTY_LIST;
        }
        String cnameByHost = this.b.e().getCnameByHost(str);
        if (TextUtils.isEmpty(cnameByHost)) {
            cnameByHost = str;
        }
        List queryByHost = this.b.e().queryByHost(cnameByHost);
        if (queryByHost.isEmpty()) {
            queryByHost = this.b.c.e(cnameByHost);
        }
        if (queryByHost.isEmpty() || iStrategyFilter == null) {
            ALog.c("getConnStrategyListByHost", null, "host", cnameByHost, "result", queryByHost);
            return queryByHost;
        }
        boolean z = !h9.C() || (h9.A() && this.b.e().isHostInIpv6BlackList(cnameByHost, h9.d()));
        ListIterator<IConnStrategy> listIterator = queryByHost.listIterator();
        while (listIterator.hasNext()) {
            IConnStrategy next = listIterator.next();
            if (!iStrategyFilter.accept(next)) {
                listIterator.remove();
            } else if (z && ju2.d(next.getIp())) {
                listIterator.remove();
            } else if ((ConnType.HTTP3.equals(next.getProtocol().protocol) || ConnType.HTTP3_PLAIN.equals(next.getProtocol().protocol)) && h9.t(cnameByHost)) {
                ALog.e("awcn.StrategyCenter", "the host in  http3 strategy black list", null, "host", cnameByHost);
                listIterator.remove();
            }
        }
        if (ALog.g(1)) {
            ALog.c("getConnStrategyListByHost", null, "host", cnameByHost, "result", queryByHost);
        }
        return queryByHost;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b()) {
            return str2;
        }
        String safeAislesByHost = this.b.b.getSafeAislesByHost(str);
        if (safeAislesByHost != null || TextUtils.isEmpty(str2)) {
            str2 = safeAislesByHost;
        }
        if (str2 == null && (str2 = h42.a().b(str)) == null) {
            str2 = "http";
        }
        ALog.c("awcn.StrategyCenter", "getSchemeByHost", null, "host", str, "scheme", str2);
        return str2;
    }
}
