package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.detect.NetworkDetector;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.IAmdcSign;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.preloader.Preloader;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.apache.commons.lang3.time.DateUtils;
import tb.a92;
import tb.ag2;
import tb.b92;
import tb.d92;
import tb.h9;
import tb.ju2;
import tb.ke1;
import tb.ss0;
import tb.yy0;

/* compiled from: Taobao */
public class c {
    public static final String TAG = "awcn.SessionCenter";
    static Map<a, c> i = new HashMap();
    private static boolean j = false;
    Context a;
    String b;
    a c;
    final d d = new d();
    final LruCache<String, SessionRequest> e = new LruCache<>(32);
    final b f = new b();
    final AccsSessionManager g;
    final b h;

    /* compiled from: Taobao */
    class a implements IAmdcSign {
        final /* synthetic */ String a;
        final /* synthetic */ ISecurity b;

        a(String str, ISecurity iSecurity) {
            this.a = str;
            this.b = iSecurity;
        }

        @Override // anet.channel.strategy.dispatch.IAmdcSign
        public String getAppkey() {
            return this.a;
        }

        @Override // anet.channel.strategy.dispatch.IAmdcSign
        public String sign(String str) {
            return this.b.sign(c.this.a, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
        }

        @Override // anet.channel.strategy.dispatch.IAmdcSign
        public boolean useSecurityGuard() {
            return !this.b.isSecOff();
        }
    }

    private c(a aVar) {
        b bVar = new b(this, null);
        this.h = bVar;
        this.a = ss0.c();
        this.c = aVar;
        this.b = aVar.i();
        bVar.a();
        this.g = new AccsSessionManager(this);
        if (!aVar.i().equals("[default]")) {
            AmdcRuntimeInfo.i(new a(aVar.i(), aVar.m()));
        }
    }

    public static synchronized void D(ENV env) {
        synchronized (c.class) {
            try {
                if (ss0.e() != env) {
                    ALog.f(TAG, "switch env", null, "old", ss0.e(), "new", env);
                    ss0.n(env);
                    anet.channel.strategy.a.a().switchEnv();
                    SpdyAgent.getInstance(ss0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
                }
                Iterator<Map.Entry<a, c>> it = i.entrySet().iterator();
                while (it.hasNext()) {
                    c value = it.next().getValue();
                    if (value.c.l() != env) {
                        ALog.f(TAG, "remove instance", value.b, "ENVIRONMENT", value.c.l());
                        value.g.d(false);
                        value.h.b();
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                ALog.d(TAG, "switch env error.", null, th, new Object[0]);
            }
        }
        return;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(b.g gVar) {
        try {
            b.d[] dVarArr = gVar.c;
            if (dVarArr == null) {
                return;
            }
            if (dVarArr.length != 0) {
                for (b.d dVar : dVarArr) {
                    if (dVar.g) {
                        v(dVar);
                    }
                    String str = dVar.e;
                    if (str != null) {
                        x(dVar.c, dVar.a, str);
                    }
                    if (dVar.i) {
                        w(dVar.c, dVar.a);
                    }
                }
            }
        } catch (Exception e2) {
            ALog.d(TAG, "checkStrategy failed", this.b, e2, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(b.g gVar) {
        try {
            b.e[] eVarArr = gVar.b;
            for (b.e eVar : eVarArr) {
                if (eVar.k) {
                    u(eVar);
                }
                String str = eVar.e;
                if (str != null) {
                    x(eVar.c, eVar.a, str);
                }
                if (eVar.m) {
                    w(eVar.c, eVar.a);
                }
            }
        } catch (Exception e2) {
            ALog.d(TAG, "checkStrategy failed", this.b, e2, new Object[0]);
        }
    }

    @Deprecated
    public static synchronized c k() {
        Context b2;
        synchronized (c.class) {
            if (!j && (b2 = anet.channel.util.c.b()) != null) {
                y(b2);
            }
            c cVar = null;
            for (Map.Entry<a, c> entry : i.entrySet()) {
                c value = entry.getValue();
                if (entry.getKey() != a.DEFAULT_CONFIG) {
                    return value;
                }
                cVar = value;
            }
            return cVar;
        }
    }

    public static synchronized c l(a aVar) {
        c cVar;
        Context b2;
        synchronized (c.class) {
            if (aVar != null) {
                if (!j && (b2 = anet.channel.util.c.b()) != null) {
                    y(b2);
                }
                cVar = i.get(aVar);
                if (cVar == null) {
                    cVar = new c(aVar);
                    i.put(aVar, cVar);
                }
            } else {
                throw new NullPointerException("config is null!");
            }
        }
        return cVar;
    }

    public static synchronized c m(String str) {
        c l;
        synchronized (c.class) {
            a k = a.k(str);
            if (k != null) {
                l = l(k);
            } else {
                throw new RuntimeException("tag not exist!");
            }
        }
        return l;
    }

    private SessionRequest q(yy0 yy0) {
        String cNameByHost = anet.channel.strategy.a.a().getCNameByHost(yy0.d());
        if (cNameByHost == null) {
            cNameByHost = yy0.d();
        }
        String j2 = yy0.j();
        if (!yy0.e()) {
            j2 = anet.channel.strategy.a.a().getSchemeByHost(cNameByHost, j2);
        }
        return p(ag2.e(j2, ke1.SCHEME_SLASH, cNameByHost));
    }

    private void u(b.e eVar) {
        boolean z;
        boolean z2;
        ALog.f(TAG, "find effectNow", this.b, "host", eVar.a);
        b.a[] aVarArr = eVar.h;
        String[] strArr = eVar.f;
        for (Session session : this.d.g(p(ag2.a(eVar.c, eVar.a)))) {
            if (!session.g().i()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= strArr.length) {
                        z = false;
                        break;
                    } else if (session.i().equals(strArr[i2])) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    if (ALog.g(2)) {
                        ALog.f(TAG, "ip not match", session.r, "session ip", session.i(), "ips", Arrays.toString(strArr));
                    }
                    session.c(true);
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= aVarArr.length) {
                            z2 = false;
                            break;
                        }
                        if (session.j() == aVarArr[i3].a && session.g().equals(ConnType.l(ConnProtocol.valueOf(aVarArr[i3])))) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z2) {
                        if (ALog.g(2)) {
                            ALog.f(TAG, "aisle not match", session.r, "port", Integer.valueOf(session.j()), "connType", session.g(), "aisle", Arrays.toString(aVarArr));
                        }
                        session.c(true);
                    }
                }
            }
        }
    }

    private void v(b.d dVar) {
        boolean z;
        boolean z2;
        ALog.f(TAG, "find effectNow by dns", this.b, "host", dVar.a);
        b.i[] iVarArr = dVar.k;
        if (!(iVarArr == null || iVarArr.length == 0)) {
            for (Session session : this.d.g(p(ag2.a(dVar.c, dVar.a)))) {
                if (!session.g().i()) {
                    int i2 = 0;
                    while (true) {
                        b.i[] iVarArr2 = dVar.k;
                        if (i2 < iVarArr2.length) {
                            b.C0004b[] bVarArr = iVarArr2[i2].a;
                            if (!(bVarArr == null || bVarArr.length == 0)) {
                                for (int i3 = 0; i3 < bVarArr.length; i3++) {
                                    b.c[] cVarArr = bVarArr[i3].b;
                                    String[] strArr = bVarArr[i3].a;
                                    if (!(cVarArr == null || cVarArr.length == 0 || strArr == null || strArr.length == 0)) {
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= strArr.length) {
                                                z = false;
                                                break;
                                            } else if (session.i().equals(strArr[i4])) {
                                                z = true;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= cVarArr.length) {
                                                z2 = false;
                                                break;
                                            }
                                            if (session.j() == cVarArr[i5].a && session.g().equals(ConnType.l(ConnProtocol.valueOf(cVarArr[i5])))) {
                                                z2 = true;
                                                break;
                                            }
                                            i5++;
                                        }
                                        if (z && z2) {
                                            if (ALog.g(2)) {
                                                ALog.f(TAG, "ip & ConnStrategy match", session.r, TbAuthConstants.IP, session.i(), "port", Integer.valueOf(session.j()), "connType", session.g());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                continue;
                            }
                            i2++;
                        } else {
                            if (ALog.g(2)) {
                                ALog.f(TAG, "ip & ConnStrategy not match", session.r, TbAuthConstants.IP, session.i(), "port", Integer.valueOf(session.j()), "connType", session.g());
                            }
                            session.c(true);
                        }
                    }
                }
            }
        }
    }

    private void w(String str, String str2) {
        if (h9.E()) {
            for (Session session : this.d.g(p(ag2.a(str, str2)))) {
                if (!ju2.d(session.f) && !session.z) {
                    ALog.e(TAG, "reconnect to ipv6", session.r, "session host", session.d, TbAuthConstants.IP, session.f);
                    session.c(true);
                }
            }
        }
    }

    private void x(String str, String str2, String str3) {
        for (Session session : this.d.g(p(ag2.a(str, str2)))) {
            if (!ag2.g(session.m, str3)) {
                ALog.f(TAG, "unit change", session.r, "session unit", session.m, "unit", str3);
                session.c(true);
            }
        }
    }

    public static synchronized void y(Context context) {
        synchronized (c.class) {
            if (context != null) {
                ss0.l(context.getApplicationContext());
                if (!j) {
                    Map<a, c> map = i;
                    a aVar = a.DEFAULT_CONFIG;
                    map.put(aVar, new c(aVar));
                    AppLifecycle.b();
                    NetworkStatusHelper.t(context);
                    if (!h9.O()) {
                        anet.channel.strategy.a.a().initialize(ss0.c());
                    }
                    if (ss0.j()) {
                        NetworkDetector.c();
                    }
                    j = true;
                }
            } else {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
        }
    }

    public static synchronized void z(Context context, a aVar) {
        synchronized (c.class) {
            if (context == null) {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            } else if (aVar != null) {
                y(context);
                if (!i.containsKey(aVar)) {
                    i.put(aVar, new c(aVar));
                }
            } else {
                ALog.e(TAG, "paramter config is null!", null, new Object[0]);
                throw new NullPointerException("init failed. config is null");
            }
        }
    }

    public void A(ISessionListener iSessionListener) {
        this.g.g(iSessionListener);
    }

    public void B(String str, int i2) {
        this.f.d(str, i2);
    }

    public void C(a92 a92) {
        this.f.e(a92);
        if (a92.b) {
            this.g.b();
        }
    }

    public void E(ISessionListener iSessionListener) {
        this.g.h(iSessionListener);
    }

    public void F(String str) {
        a92 f2 = this.f.f(str);
        if (f2 != null && f2.b) {
            this.g.b();
        }
    }

    public void d(yy0 yy0, int i2, long j2, SessionGetCallback sessionGetCallback) {
        Objects.requireNonNull(sessionGetCallback, "cb is null");
        if (j2 > 0) {
            try {
                o(yy0, i2, j2, sessionGetCallback);
            } catch (Exception unused) {
                sessionGetCallback.onSessionGetFail();
            }
        } else {
            throw new InvalidParameterException("timeout must > 0");
        }
    }

    public void g() {
        this.g.d(true);
    }

    public Session h(String str, long j2) {
        return j(yy0.g(str), d92.c, j2);
    }

    @Deprecated
    public Session i(String str, ConnType.TypeLevel typeLevel, long j2) {
        return j(yy0.g(str), typeLevel == ConnType.TypeLevel.SPDY ? d92.a : d92.b, j2);
    }

    public Session j(yy0 yy0, int i2, long j2) {
        try {
            return n(yy0, i2, j2, null);
        } catch (InvalidParameterException e2) {
            ALog.d(TAG, "[Get]param url is invalid", this.b, e2, "url", yy0);
            return null;
        } catch (TimeoutException e3) {
            ALog.d(TAG, "[Get]timeout exception", this.b, e3, "url", yy0.n());
            return null;
        } catch (ConnectException e4) {
            ALog.e(TAG, "[Get]connect exception", this.b, "errMsg", e4.getMessage(), "url", yy0.n());
            return null;
        } catch (NoAvailStrategyException e5) {
            ALog.f(TAG, "[Get]" + e5.getMessage(), this.b, null, "url", yy0.n());
            return null;
        } catch (Exception e6) {
            ALog.d(TAG, "[Get]" + e6.getMessage(), this.b, null, "url", yy0.n());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Session n(yy0 yy0, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        a92 b2;
        if (!j) {
            ALog.e(TAG, "getInternal not inited!", this.b, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        } else if (yy0 != null) {
            String str = this.b;
            Object[] objArr = new Object[6];
            objArr[0] = IRequestConst.U;
            objArr[1] = yy0.n();
            objArr[2] = "sessionType";
            objArr[3] = i2 == d92.a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j2);
            ALog.f(TAG, "getInternal", str, objArr);
            SessionRequest q = q(yy0);
            Session f2 = this.d.f(q, i2);
            if (f2 != null) {
                ALog.c(TAG, "get internal hit cache session", this.b, Preloader.KEY_SESSION, f2);
            } else if (this.c != a.DEFAULT_CONFIG || i2 == d92.b) {
                if (!ss0.i() || i2 != d92.a || !h9.i() || (b2 = this.f.b(yy0.d())) == null || !b2.c) {
                    q.F(this.a, i2, b92.a(this.b), sessionGetCallback, j2);
                    if (sessionGetCallback == null && j2 > 0 && (i2 == d92.c || q.x() == i2)) {
                        q.n(j2);
                        f2 = this.d.f(q, i2);
                        if (f2 == null) {
                            throw new ConnectException("session connecting failed or timeout");
                        }
                    }
                } else {
                    ALog.k(TAG, "app background, forbid to create accs session", this.b, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
            } else if (sessionGetCallback == null) {
                return null;
            } else {
                sessionGetCallback.onSessionGetFail();
                return null;
            }
            return f2;
        } else {
            throw new InvalidParameterException("httpUrl is null");
        }
    }

    /* access modifiers changed from: protected */
    public void o(yy0 yy0, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        a92 b2;
        if (!j) {
            ALog.e(TAG, "getInternal not inited!", this.b, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        } else if (yy0 == null) {
            throw new InvalidParameterException("httpUrl is null");
        } else if (sessionGetCallback != null) {
            String str = this.b;
            Object[] objArr = new Object[6];
            objArr[0] = IRequestConst.U;
            objArr[1] = yy0.n();
            objArr[2] = "sessionType";
            objArr[3] = i2 == d92.a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j2);
            ALog.c(TAG, "getInternal", str, objArr);
            SessionRequest q = q(yy0);
            Session f2 = this.d.f(q, i2);
            if (f2 != null) {
                ALog.c(TAG, "get internal hit cache session", this.b, Preloader.KEY_SESSION, f2);
                sessionGetCallback.onSessionGetSuccess(f2);
            } else if (this.c == a.DEFAULT_CONFIG && i2 != d92.b) {
                sessionGetCallback.onSessionGetFail();
            } else if (!ss0.i() || i2 != d92.a || !h9.i() || (b2 = this.f.b(yy0.d())) == null || !b2.c) {
                q.G(this.a, i2, b92.a(this.b), sessionGetCallback, j2);
            } else {
                ALog.k(TAG, "app background, forbid to create accs session", this.b, new Object[0]);
                throw new ConnectException("accs session connecting forbidden in background");
            }
        } else {
            throw new InvalidParameterException("sessionGetCallback is null");
        }
    }

    /* access modifiers changed from: protected */
    public SessionRequest p(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.e) {
            sessionRequest = this.e.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.e.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }

    public Session r(String str, long j2) throws Exception {
        return n(yy0.g(str), d92.c, j2, null);
    }

    @Deprecated
    public Session s(String str, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return n(yy0.g(str), typeLevel == ConnType.TypeLevel.SPDY ? d92.a : d92.b, j2, null);
    }

    public Session t(yy0 yy0, int i2, long j2) throws Exception {
        return n(yy0, i2, j2, null);
    }

    /* compiled from: Taobao */
    private class b implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {
        boolean a;

        private b() {
            this.a = false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AppLifecycle.f(this);
            NetworkStatusHelper.a(this);
            anet.channel.strategy.a.a().registerListener(this);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            anet.channel.strategy.a.a().unregisterListener(this);
            AppLifecycle.g(this);
            NetworkStatusHelper.s(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.f(c.TAG, "[background]", c.this.b, new Object[0]);
            if (!c.j) {
                ALog.e(c.TAG, "background not inited!", c.this.b, new Object[0]);
                return;
            }
            try {
                anet.channel.strategy.a.a().saveData();
                if (h9.i() && "OPPO".equalsIgnoreCase(Build.getBRAND())) {
                    ALog.f(c.TAG, "close session for OPPO", c.this.b, new Object[0]);
                    c.this.g.d(false);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00a0 */
        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.f(c.TAG, "[forground]", c.this.b, new Object[0]);
            if (c.this.a != null && !this.a) {
                this.a = true;
                if (!c.j) {
                    ALog.e(c.TAG, "forground not inited!", c.this.b, new Object[0]);
                    return;
                }
                try {
                    if (!h9.K() || AppLifecycle.b == 0 || System.currentTimeMillis() - AppLifecycle.b <= DateUtils.MILLIS_PER_MINUTE) {
                        c.this.g.b();
                    } else {
                        c.this.g.d(true);
                    }
                    if (h9.o() && AppLifecycle.b != 0 && System.currentTimeMillis() - AppLifecycle.b > 30000) {
                        ALog.e(c.TAG, "foreground check session available.", c.this.b, new Object[0]);
                        List<SessionRequest> d = c.this.d.d();
                        if (!d.isEmpty()) {
                            for (SessionRequest sessionRequest : d) {
                                sessionRequest.o();
                            }
                        }
                    }
                } catch (Exception unknown) {
                    this.a = false;
                } catch (Exception unused) {
                    return;
                } catch (Throwable th) {
                    this.a = false;
                    throw th;
                }
                this.a = false;
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(c.TAG, "onNetworkStatusChanged.", c.this.b, "networkStatus", networkStatus);
            List<SessionRequest> d = c.this.d.d();
            if (!d.isEmpty()) {
                for (SessionRequest sessionRequest : d) {
                    ALog.c(c.TAG, "network change, try recreate session", c.this.b, new Object[0]);
                    sessionRequest.z(null);
                }
            }
            c.this.g.b();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(b.g gVar) {
            if (h9.N()) {
                c.this.e(gVar);
            } else {
                c.this.f(gVar);
            }
            c.this.g.b();
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }
}
