package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import mtopsdk.common.util.HttpHeaderConstant;
import org.apache.commons.lang3.time.DateUtils;
import tb.ag2;
import tb.hm;
import tb.jl1;
import tb.ke1;
import tb.ry0;
import tb.ue0;

/* compiled from: Taobao */
public abstract class Session implements Comparable<Session> {
    public boolean A;
    protected Context a;
    Map<EventCb, Integer> b = new LinkedHashMap();
    private boolean c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected int h;
    protected String i;
    protected int j;
    protected ConnType k;
    protected IConnStrategy l;
    protected String m;
    protected boolean n;
    protected int o;
    protected Runnable p;
    private Future<?> q;
    public final String r;
    public final SessionStatistic s;
    protected int t;
    protected int u;
    protected boolean v;
    protected boolean w;
    private List<Long> x;
    private long y;
    public boolean z;

    /* compiled from: Taobao */
    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;
        static final String[] a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        static String a(int i) {
            return a[i];
        }
    }

    public Session(Context context, hm hmVar) {
        boolean z2 = false;
        this.c = false;
        this.m = null;
        this.n = false;
        this.o = 6;
        this.v = false;
        this.w = true;
        this.x = null;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.a = context;
        String e2 = hmVar.e();
        this.f = e2;
        this.g = e2;
        this.h = hmVar.f();
        this.k = hmVar.a();
        String d2 = hmVar.d();
        this.d = d2;
        this.e = d2.substring(d2.indexOf(ke1.SCHEME_SLASH) + 3);
        this.u = hmVar.g();
        this.t = hmVar.b();
        IConnStrategy iConnStrategy = hmVar.a;
        this.l = iConnStrategy;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z2 = true;
        }
        this.n = z2;
        this.r = hmVar.h();
        SessionStatistic sessionStatistic = new SessionStatistic(hmVar);
        this.s = sessionStatistic;
        sessionStatistic.host = this.e;
    }

    /* access modifiers changed from: protected */
    public void a() {
        Future<?> future;
        if (this.p != null && (future = this.q) != null) {
            future.cancel(true);
        }
    }

    public abstract void b();

    public void c(boolean z2) {
        this.v = z2;
        b();
    }

    /* renamed from: d */
    public int compareTo(Session session) {
        return ConnType.a(this.k, session.k);
    }

    public void e() {
    }

    public IConnStrategy f() {
        return this.l;
    }

    public ConnType g() {
        return this.k;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.f;
    }

    public int j() {
        return this.h;
    }

    public String k() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public abstract Runnable l();

    public String m() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public void n(final int i2, final ue0 ue0) {
        ThreadPoolExecutorFactory.k(new Runnable() {
            /* class anet.channel.Session.AnonymousClass1 */

            public void run() {
                try {
                    Map<EventCb, Integer> map = Session.this.b;
                    if (map != null) {
                        for (EventCb eventCb : map.keySet()) {
                            if (eventCb != null) {
                                int intValue = Session.this.b.get(eventCb).intValue();
                                int i = i2;
                                if ((intValue & i) != 0) {
                                    try {
                                        eventCb.onEvent(Session.this, i, ue0);
                                    } catch (Exception e) {
                                        ALog.e("awcn.Session", e.toString(), Session.this.r, new Object[0]);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    ALog.d("awcn.Session", "handleCallbacks", Session.this.r, e2, new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void o(anet.channel.request.a aVar, int i2) {
        if (aVar.g().containsKey(HttpHeaderConstant.X_PV) && i2 >= 500 && i2 < 600) {
            synchronized (this) {
                if (this.x == null) {
                    this.x = new LinkedList();
                }
                if (this.x.size() < 5) {
                    this.x.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long longValue = this.x.remove(0).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue <= DateUtils.MILLIS_PER_MINUTE) {
                        anet.channel.strategy.a.a().forceRefreshStrategy(aVar.h());
                        this.x.clear();
                    } else {
                        this.x.add(Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p(anet.channel.request.a aVar, Map<String, List<String>> map) {
        try {
            if (map.containsKey("x-switch-unit")) {
                String d2 = ry0.d(map, "x-switch-unit");
                if (TextUtils.isEmpty(d2)) {
                    d2 = null;
                }
                if (!ag2.g(this.m, d2)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.y > DateUtils.MILLIS_PER_MINUTE) {
                        anet.channel.strategy.a.a().forceRefreshStrategy(aVar.h());
                        this.y = currentTimeMillis;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean q();

    /* access modifiers changed from: protected */
    public synchronized void r(int i2, ue0 ue0) {
        ALog.e("awcn.Session", "notifyStatus", this.r, "status", a.a(i2));
        if (i2 == this.o) {
            ALog.f("awcn.Session", "ignore notifyStatus", this.r, new Object[0]);
            return;
        }
        this.o = i2;
        if (i2 == 0) {
            n(1, ue0);
        } else if (i2 == 2) {
            n(256, ue0);
        } else if (i2 == 4) {
            this.m = anet.channel.strategy.a.a().getUnitByHost(this.e);
            n(512, ue0);
        } else if (i2 == 5) {
            n(1024, ue0);
        } else if (i2 == 6) {
            s();
            if (!this.c) {
                n(2, ue0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
    }

    public void t(boolean z2) {
    }

    public String toString() {
        return "Session@[" + this.r + '|' + this.k + jl1.ARRAY_END;
    }

    public void u(boolean z2, int i2) {
    }

    public void v(int i2, EventCb eventCb) {
        Map<EventCb, Integer> map = this.b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i2));
        }
    }

    public abstract Cancelable w(anet.channel.request.a aVar, RequestCb requestCb);

    public void x(int i2, byte[] bArr, int i3) {
    }

    /* access modifiers changed from: protected */
    public void y(int i2) {
        if (this.p == null) {
            this.p = l();
        }
        a();
        Runnable runnable = this.p;
        if (runnable != null) {
            this.q = ThreadPoolExecutorFactory.j(runnable, (long) i2, TimeUnit.MILLISECONDS);
        }
    }
}
