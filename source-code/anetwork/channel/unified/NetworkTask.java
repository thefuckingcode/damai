package anetwork.channel.unified;

import android.support.v4.media.session.PlaybackStateCompat;
import android.taobao.windvane.connect.HttpConnector;
import android.text.TextUtils;
import anet.channel.NoAvailStrategyException;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.SessionGetCallback;
import anet.channel.a;
import anet.channel.entity.ENV;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.request.Cancelable;
import anet.channel.request.a;
import anet.channel.session.HttpSession;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.http.NetworkSdkSetting;
import anetwork.channel.interceptor.Callback;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.ag2;
import tb.b02;
import tb.d92;
import tb.fe0;
import tb.hm;
import tb.il0;
import tb.ke1;
import tb.pd;
import tb.rh1;
import tb.ry0;
import tb.sh1;
import tb.ss0;
import tb.w6;
import tb.yy0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class NetworkTask implements IUnifiedTask {
    public static final int MAX_RSP_BUFFER_LENGTH = 131072;
    public static final String TAG = "anet.NetworkTask";
    String bizReqId;
    Cache cache = null;
    ByteArrayOutputStream cacheBuffer = null;
    volatile Cancelable cancelable = null;
    int contentLength = 0;
    int dataChunkIndex = 0;
    Cache.Entry entry = null;
    String f_refer = "other";
    volatile boolean isCanceled = false;
    boolean isDataChuckCallback = false;
    volatile AtomicBoolean isDone = null;
    boolean isHeaderCallback = false;
    b rc;
    c responseBuffer = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements SessionGetCallback {
        final /* synthetic */ RequestStatistic a;
        final /* synthetic */ long b;
        final /* synthetic */ anet.channel.request.a c;
        final /* synthetic */ anet.channel.c d;
        final /* synthetic */ yy0 e;
        final /* synthetic */ boolean f;

        a(RequestStatistic requestStatistic, long j, anet.channel.request.a aVar, anet.channel.c cVar, yy0 yy0, boolean z) {
            this.a = requestStatistic;
            this.b = j;
            this.c = aVar;
            this.d = cVar;
            this.e = yy0;
            this.f = z;
        }

        @Override // anet.channel.SessionGetCallback
        public void onSessionGetFail() {
            ALog.e(NetworkTask.TAG, "onSessionGetFail", NetworkTask.this.rc.c, "url", this.a.url);
            this.a.connWaitTime = System.currentTimeMillis() - this.b;
            NetworkTask networkTask = NetworkTask.this;
            networkTask.sendRequest(networkTask.tryGetHttpSession(null, this.d, this.e, this.f), this.c);
        }

        @Override // anet.channel.SessionGetCallback
        public void onSessionGetSuccess(Session session) {
            ALog.f(NetworkTask.TAG, "onSessionGetSuccess", NetworkTask.this.rc.c, "Session", session);
            this.a.connWaitTime = System.currentTimeMillis() - this.b;
            this.a.spdyRequestSend = true;
            NetworkTask.this.sendRequest(session, this.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements RequestCb {
        final /* synthetic */ anet.channel.request.a a;
        final /* synthetic */ RequestStatistic b;

        b(anet.channel.request.a aVar, RequestStatistic requestStatistic) {
            this.a = aVar;
            this.b = requestStatistic;
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(pd pdVar, boolean z) {
            if (!NetworkTask.this.isDone.get()) {
                if (NetworkTask.this.rc.f == null || !NetworkTask.this.rc.f.isResponseReturn()) {
                    NetworkTask networkTask = NetworkTask.this;
                    if (networkTask.dataChunkIndex == 0) {
                        ALog.f(NetworkTask.TAG, "[onDataReceive] receive first data chunk!", networkTask.rc.c, new Object[0]);
                    }
                    if (z) {
                        ALog.f(NetworkTask.TAG, "[onDataReceive] receive last data chunk!", NetworkTask.this.rc.c, new Object[0]);
                    }
                    NetworkTask networkTask2 = NetworkTask.this;
                    int i = networkTask2.dataChunkIndex + 1;
                    networkTask2.dataChunkIndex = i;
                    try {
                        c cVar = networkTask2.responseBuffer;
                        if (cVar != null) {
                            cVar.c.add(pdVar);
                            if (this.b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z) {
                                NetworkTask networkTask3 = NetworkTask.this;
                                networkTask3.dataChunkIndex = networkTask3.responseBuffer.a(networkTask3.rc.b, networkTask3.contentLength);
                                NetworkTask networkTask4 = NetworkTask.this;
                                networkTask4.isHeaderCallback = true;
                                networkTask4.isDataChuckCallback = networkTask4.dataChunkIndex > 1;
                                networkTask4.responseBuffer = null;
                            }
                        } else {
                            networkTask2.rc.b.onDataReceiveSize(i, networkTask2.contentLength, pdVar);
                            NetworkTask.this.isDataChuckCallback = true;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = NetworkTask.this.cacheBuffer;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.write(pdVar.c(), 0, pdVar.d());
                            if (z) {
                                String h = NetworkTask.this.rc.a.h();
                                NetworkTask networkTask5 = NetworkTask.this;
                                networkTask5.entry.data = networkTask5.cacheBuffer.toByteArray();
                                long currentTimeMillis = System.currentTimeMillis();
                                NetworkTask networkTask6 = NetworkTask.this;
                                networkTask6.cache.put(h, networkTask6.entry);
                                ALog.f(NetworkTask.TAG, "write cache", NetworkTask.this.rc.c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "size", Integer.valueOf(NetworkTask.this.entry.data.length), "key", h);
                            }
                        }
                    } catch (Exception e) {
                        ALog.j(NetworkTask.TAG, "[onDataReceive] error.", NetworkTask.this.rc.c, e, new Object[0]);
                    }
                }
            }
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            DefaultFinishEvent defaultFinishEvent;
            String str2;
            if (!NetworkTask.this.isDone.getAndSet(true)) {
                if (NetworkTask.this.rc.f == null || !NetworkTask.this.rc.f.isResponseReturn()) {
                    int i2 = 3;
                    if (ALog.g(2)) {
                        ALog.f(NetworkTask.TAG, "[onFinish]", NetworkTask.this.rc.c, "code", Integer.valueOf(i), "msg", str);
                    }
                    if (i < 0) {
                        try {
                            if (NetworkTask.this.rc.a.l()) {
                                NetworkTask networkTask = NetworkTask.this;
                                if (networkTask.isHeaderCallback || networkTask.isDataChuckCallback) {
                                    requestStatistic.msg += ":回调后触发重试";
                                    NetworkTask networkTask2 = NetworkTask.this;
                                    if (networkTask2.isDataChuckCallback) {
                                        requestStatistic.roaming = 2;
                                    } else if (networkTask2.isHeaderCallback) {
                                        requestStatistic.roaming = 1;
                                    }
                                    ALog.e(NetworkTask.TAG, "Cannot retry request after onHeader/onDataReceived callback!", networkTask2.rc.c, new Object[0]);
                                } else {
                                    ALog.e(NetworkTask.TAG, "clear response buffer and retry", networkTask.rc.c, new Object[0]);
                                    c cVar = NetworkTask.this.responseBuffer;
                                    if (cVar != null) {
                                        if (!cVar.c.isEmpty()) {
                                            i2 = 4;
                                        }
                                        requestStatistic.roaming = i2;
                                        NetworkTask.this.responseBuffer.b();
                                        NetworkTask.this.responseBuffer = null;
                                    }
                                    if (NetworkTask.this.rc.a.e == 0) {
                                        requestStatistic.firstProtocol = requestStatistic.protocolType;
                                        requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i;
                                    }
                                    NetworkTask.this.rc.a.q();
                                    NetworkTask.this.rc.d = new AtomicBoolean();
                                    NetworkTask networkTask3 = NetworkTask.this;
                                    b bVar = networkTask3.rc;
                                    bVar.e = new NetworkTask(bVar, networkTask3.cache, networkTask3.entry);
                                    if (requestStatistic.tnetErrorCode != 0) {
                                        str2 = i + "|" + requestStatistic.protocolType + "|" + requestStatistic.tnetErrorCode;
                                        requestStatistic.tnetErrorCode = 0;
                                    } else {
                                        str2 = String.valueOf(i);
                                    }
                                    requestStatistic.appendErrorTrace(str2);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    requestStatistic.retryCostTime += currentTimeMillis - requestStatistic.start;
                                    requestStatistic.start = currentTimeMillis;
                                    ThreadPoolExecutorFactory.g(NetworkTask.this.rc.e, ThreadPoolExecutorFactory.b.a);
                                    return;
                                }
                            }
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    NetworkTask networkTask4 = NetworkTask.this;
                    c cVar2 = networkTask4.responseBuffer;
                    if (cVar2 != null) {
                        cVar2.a(networkTask4.rc.b, networkTask4.contentLength);
                    }
                    NetworkTask.this.rc.c();
                    requestStatistic.isDone.set(true);
                    if (!(!NetworkTask.this.rc.a.s() || requestStatistic.contentLength == 0 || requestStatistic.contentLength == requestStatistic.rspBodyDeflateSize)) {
                        requestStatistic.ret = 0;
                        requestStatistic.statusCode = fe0.ERROR_DATA_LENGTH_NOT_MATCH;
                        str = fe0.b(fe0.ERROR_DATA_LENGTH_NOT_MATCH);
                        requestStatistic.msg = str;
                        NetworkTask networkTask5 = NetworkTask.this;
                        ALog.e(NetworkTask.TAG, "received data length not match with content-length", networkTask5.rc.c, "content-length", Integer.valueOf(networkTask5.contentLength), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
                        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(fe0.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
                        exceptionStatistic.url = NetworkTask.this.rc.a.h();
                        w6.b().commitStat(exceptionStatistic);
                        i = fe0.ERROR_DATA_LENGTH_NOT_MATCH;
                    }
                    if (i != 304 || NetworkTask.this.entry == null) {
                        defaultFinishEvent = new DefaultFinishEvent(i, str, this.a);
                    } else {
                        requestStatistic.protocolType = "cache";
                        defaultFinishEvent = new DefaultFinishEvent(200, str, this.a);
                    }
                    NetworkTask.this.rc.b.onFinish(defaultFinishEvent);
                    if (i >= 0) {
                        BandWidthSampler.f().i(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
                    } else {
                        requestStatistic.netType = NetworkStatusHelper.e();
                    }
                    rh1.a().commitFlow(new il0(NetworkTask.this.f_refer, requestStatistic));
                }
            }
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
            String d;
            if (!NetworkTask.this.isDone.get()) {
                if (NetworkTask.this.rc.f == null || !NetworkTask.this.rc.f.isResponseReturn()) {
                    NetworkTask.this.rc.a();
                    if (ALog.g(2)) {
                        ALog.f(NetworkTask.TAG, "onResponseCode", this.a.n(), "code", Integer.valueOf(i));
                        ALog.f(NetworkTask.TAG, "onResponseCode", this.a.n(), "headers", map);
                    }
                    if (ry0.a(this.a, i) && (d = ry0.d(map, "Location")) != null) {
                        yy0 g = yy0.g(d);
                        if (g == null) {
                            ALog.e(NetworkTask.TAG, "redirect url is invalid!", this.a.n(), "redirect url", d);
                        } else if (NetworkTask.this.isDone.compareAndSet(false, true)) {
                            g.f();
                            NetworkTask.this.rc.a.p(g);
                            NetworkTask.this.rc.d = new AtomicBoolean();
                            b bVar = NetworkTask.this.rc;
                            bVar.e = new NetworkTask(bVar, null, null);
                            this.b.recordRedirect(i, g.l());
                            this.b.locationUrl = d;
                            ThreadPoolExecutorFactory.g(NetworkTask.this.rc.e, ThreadPoolExecutorFactory.b.a);
                            return;
                        } else {
                            return;
                        }
                    }
                    try {
                        NetworkTask.this.rc.c();
                        CookieManager.l(NetworkTask.this.rc.a.h(), map);
                        NetworkTask.this.contentLength = ry0.f(map);
                        String h = NetworkTask.this.rc.a.h();
                        NetworkTask networkTask = NetworkTask.this;
                        Cache.Entry entry = networkTask.entry;
                        if (entry == null || i != 304) {
                            if (networkTask.cache != null) {
                                if ("no-store".equals(ry0.d(map, "Cache-Control"))) {
                                    NetworkTask.this.cache.remove(h);
                                } else {
                                    NetworkTask networkTask2 = NetworkTask.this;
                                    Cache.Entry b2 = anetwork.channel.cache.a.b(map);
                                    networkTask2.entry = b2;
                                    if (b2 != null) {
                                        ry0.j(map, "Cache-Control");
                                        map.put("Cache-Control", Arrays.asList("no-store"));
                                        NetworkTask networkTask3 = NetworkTask.this;
                                        int i2 = NetworkTask.this.contentLength;
                                        if (i2 == 0) {
                                            i2 = 5120;
                                        }
                                        networkTask3.cacheBuffer = new ByteArrayOutputStream(i2);
                                    }
                                }
                            }
                            map.put("x-protocol", Arrays.asList(this.b.protocolType));
                            if (!"open".equalsIgnoreCase(ry0.d(map, "streaming-parser")) && sh1.D()) {
                                NetworkTask networkTask4 = NetworkTask.this;
                                if (networkTask4.contentLength <= 131072) {
                                    networkTask4.responseBuffer = new c(i, map);
                                    return;
                                }
                            }
                            NetworkTask.this.rc.b.onResponseCode(i, map);
                            NetworkTask.this.isHeaderCallback = true;
                            return;
                        }
                        entry.responseHeaders.putAll(map);
                        Cache.Entry b3 = anetwork.channel.cache.a.b(map);
                        if (b3 != null) {
                            long j = b3.ttl;
                            Cache.Entry entry2 = NetworkTask.this.entry;
                            if (j > entry2.ttl) {
                                entry2.ttl = j;
                            }
                        }
                        NetworkTask networkTask5 = NetworkTask.this;
                        networkTask5.rc.b.onResponseCode(200, networkTask5.entry.responseHeaders);
                        NetworkTask networkTask6 = NetworkTask.this;
                        Callback callback = networkTask6.rc.b;
                        byte[] bArr = networkTask6.entry.data;
                        callback.onDataReceiveSize(1, bArr.length, pd.g(bArr));
                        long currentTimeMillis = System.currentTimeMillis();
                        NetworkTask networkTask7 = NetworkTask.this;
                        networkTask7.cache.put(h, networkTask7.entry);
                        ALog.f(NetworkTask.TAG, "update cache", NetworkTask.this.rc.c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "key", h);
                    } catch (Exception e) {
                        ALog.j(NetworkTask.TAG, "[onResponseCode] error.", NetworkTask.this.rc.c, e, new Object[0]);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static class c {
        int a;
        Map<String, List<String>> b;
        List<pd> c = new ArrayList();

        c(int i, Map<String, List<String>> map) {
            this.a = i;
            this.b = map;
        }

        /* access modifiers changed from: package-private */
        public int a(Callback callback, int i) {
            callback.onResponseCode(this.a, this.b);
            int i2 = 1;
            for (pd pdVar : this.c) {
                callback.onDataReceiveSize(i2, i, pdVar);
                i2++;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            for (pd pdVar : this.c) {
                pdVar.f();
            }
        }
    }

    NetworkTask(b bVar, Cache cache2, Cache.Entry entry2) {
        this.rc = bVar;
        this.isDone = bVar.d;
        this.cache = cache2;
        this.entry = entry2;
        Map<String, String> d = bVar.a.d();
        this.f_refer = d.get(HttpHeaderConstant.F_REFER);
        this.bizReqId = d.get("f-biz-req-id");
    }

    private yy0 checkCName(yy0 yy0) {
        yy0 g;
        String str = this.rc.a.d().get("x-host-cname");
        return (TextUtils.isEmpty(str) || (g = yy0.g(yy0.n().replaceFirst(yy0.d(), str))) == null) ? yy0 : g;
    }

    private void executeRequest() {
        anet.channel.c sessionCenter = getSessionCenter();
        yy0 e = this.rc.a.e();
        boolean a2 = e.a();
        b02 b02 = this.rc.a;
        RequestStatistic requestStatistic = b02.f;
        anet.channel.request.a b2 = b02.b();
        if (this.rc.a.j != 1 || !sh1.F() || this.rc.a.e != 0 || a2) {
            sendRequest(tryGetHttpSession(null, sessionCenter, e, a2), b2);
            return;
        }
        sessionCenter.d(checkCName(e), d92.a, 3000, new a(requestStatistic, System.currentTimeMillis(), b2, sessionCenter, e, a2));
    }

    private anet.channel.c getSessionCenter() {
        String g = this.rc.a.g("APPKEY");
        if (TextUtils.isEmpty(g)) {
            return anet.channel.c.k();
        }
        ENV env = ENV.ONLINE;
        String g2 = this.rc.a.g("ENVIRONMENT");
        if ("pre".equalsIgnoreCase(g2)) {
            env = ENV.PREPARE;
        } else if ("test".equalsIgnoreCase(g2)) {
            env = ENV.TEST;
        }
        if (env != NetworkSdkSetting.CURRENT_ENV) {
            NetworkSdkSetting.CURRENT_ENV = env;
            anet.channel.c.D(env);
        }
        anet.channel.a j = anet.channel.a.j(g, env);
        if (j == null) {
            j = new a.C0000a().c(g).e(env).d(this.rc.a.g("AuthCode")).a();
        }
        return anet.channel.c.l(j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    private anet.channel.request.a preProcessRequest(anet.channel.request.a aVar) {
        a.b bVar;
        if (this.rc.a.n()) {
            String i = CookieManager.i(this.rc.a.h());
            if (!TextUtils.isEmpty(i)) {
                bVar = aVar.u();
                String str = aVar.g().get(IRequestConst.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    i = ag2.e(str, "; ", i);
                }
                bVar.I(IRequestConst.COOKIE, i);
                if (this.entry != null) {
                    if (bVar == null) {
                        bVar = aVar.u();
                    }
                    String str2 = this.entry.etag;
                    if (str2 != null) {
                        bVar.I(HttpConnector.IF_NONE_MATCH, str2);
                    }
                    long j = this.entry.lastModified;
                    if (j > 0) {
                        bVar.I(HttpConnector.IF_MODIFY_SINCE, anetwork.channel.cache.a.d(j));
                    }
                }
                if (this.rc.a.e == 0 && ("weex".equalsIgnoreCase(this.f_refer) || sh1.f(this.rc.a.e()))) {
                    if (bVar == null) {
                        bVar = aVar.u();
                    }
                    bVar.T(3000);
                    b bVar2 = this.rc;
                    bVar2.a.f.isFastDegrade = true;
                    ALog.e(TAG, "set read time out 3s.", bVar2.c, new Object[0]);
                }
                return bVar != null ? aVar : bVar.J();
            }
        }
        bVar = null;
        if (this.entry != null) {
        }
        if (bVar == null) {
        }
        bVar.T(3000);
        b bVar22 = this.rc;
        bVar22.a.f.isFastDegrade = true;
        ALog.e(TAG, "set read time out 3s.", bVar22.c, new Object[0]);
        if (bVar != null) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendRequest(Session session, anet.channel.request.a aVar) {
        if (session != null && !this.isCanceled) {
            anet.channel.request.a preProcessRequest = preProcessRequest(aVar);
            RequestStatistic requestStatistic = this.rc.a.f;
            requestStatistic.reqStart = System.currentTimeMillis();
            anet.channel.fulltrace.a.f().log(requestStatistic.span, "netReqProcessStart", null);
            this.cancelable = session.w(preProcessRequest, new b(preProcessRequest, requestStatistic));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Session tryGetHttpSession(Session session, anet.channel.c cVar, yy0 yy0, boolean z) {
        b02 b02 = this.rc.a;
        RequestStatistic requestStatistic = b02.f;
        if (session == null && b02.m() && !z && !NetworkStatusHelper.o()) {
            session = cVar.j(yy0, d92.b, 0);
        }
        if (session == null) {
            ALog.f(TAG, "create HttpSession with local DNS", this.rc.c, new Object[0]);
            session = new HttpSession(ss0.c(), new hm(ag2.e(yy0.j(), ke1.SCHEME_SLASH, yy0.d()), this.rc.c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.f(TAG, "tryGetHttpSession", this.rc.c, "Session", session);
        return session;
    }

    private Session tryGetSession() {
        Session session;
        final anet.channel.c sessionCenter = getSessionCenter();
        final yy0 e = this.rc.a.e();
        final boolean a2 = e.a();
        b02 b02 = this.rc.a;
        final RequestStatistic requestStatistic = b02.f;
        if (b02.j != 1 || !sh1.F() || this.rc.a.e != 0 || a2) {
            return tryGetHttpSession(null, sessionCenter, e, a2);
        }
        final yy0 checkCName = checkCName(e);
        try {
            session = sessionCenter.t(checkCName, d92.a, 0);
        } catch (NoAvailStrategyException unused) {
            return tryGetHttpSession(null, sessionCenter, e, a2);
        } catch (Exception unused2) {
            session = null;
        }
        if (session == null) {
            ThreadPoolExecutorFactory.g(new Runnable() {
                /* class anetwork.channel.unified.NetworkTask.AnonymousClass2 */

                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    Session j = sessionCenter.j(checkCName, d92.a, 3000);
                    requestStatistic.connWaitTime = System.currentTimeMillis() - currentTimeMillis;
                    requestStatistic.spdyRequestSend = j != null;
                    Session tryGetHttpSession = NetworkTask.this.tryGetHttpSession(j, sessionCenter, e, a2);
                    NetworkTask networkTask = NetworkTask.this;
                    networkTask.sendRequest(tryGetHttpSession, networkTask.rc.a.b());
                }
            }, ThreadPoolExecutorFactory.b.b);
            return null;
        }
        ALog.f(TAG, "tryGetSession", this.rc.c, "Session", session);
        requestStatistic.spdyRequestSend = true;
        return session;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        if (this.cancelable != null) {
            this.cancelable.cancel();
        }
    }

    public void run() {
        if (!this.isCanceled) {
            RequestStatistic requestStatistic = this.rc.a.f;
            requestStatistic.f_refer = this.f_refer;
            requestStatistic.bizReqId = this.bizReqId;
            if (!NetworkStatusHelper.n()) {
                if (!sh1.B() || requestStatistic.statusCode == -200) {
                    if (ALog.g(2)) {
                        ALog.f(TAG, HttpUtils.NetworkUnavailableException.ERROR_INFO, this.rc.c, "NetworkStatus", NetworkStatusHelper.i());
                    }
                    this.isDone.set(true);
                    this.rc.c();
                    requestStatistic.isDone.set(true);
                    requestStatistic.statusCode = -200;
                    requestStatistic.msg = fe0.b(-200);
                    requestStatistic.rspEnd = System.currentTimeMillis();
                    anet.channel.fulltrace.a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                    this.rc.b.onFinish(new DefaultFinishEvent(-200, (String) null, this.rc.a.b()));
                    return;
                }
                requestStatistic.statusCode = -200;
                ThreadPoolExecutorFactory.j(new Runnable() {
                    /* class anetwork.channel.unified.NetworkTask.AnonymousClass1 */

                    public void run() {
                        ThreadPoolExecutorFactory.g(NetworkTask.this, ThreadPoolExecutorFactory.b.a);
                    }
                }, 1000, TimeUnit.MILLISECONDS);
            } else if (!sh1.i() || !ss0.i() || AppLifecycle.b <= 0 || AppLifecycle.c || System.currentTimeMillis() - AppLifecycle.b <= ((long) sh1.a()) || sh1.H(this.rc.a.e()) || sh1.l(this.rc.a.b().c()) || this.rc.a.b().r()) {
                if (ALog.g(2)) {
                    b bVar = this.rc;
                    ALog.f(TAG, "exec request", bVar.c, "retryTimes", Integer.valueOf(bVar.a.e));
                }
                if (sh1.o()) {
                    executeRequest();
                    return;
                }
                try {
                    Session tryGetSession = tryGetSession();
                    if (tryGetSession != null) {
                        sendRequest(tryGetSession, this.rc.a.b());
                    }
                } catch (Exception e) {
                    ALog.d(TAG, "send request failed.", this.rc.c, e, new Object[0]);
                }
            } else {
                this.isDone.set(true);
                this.rc.c();
                if (ALog.g(2)) {
                    b bVar2 = this.rc;
                    ALog.f(TAG, "request forbidden in background", bVar2.c, "url", bVar2.a.e());
                }
                requestStatistic.isDone.set(true);
                requestStatistic.statusCode = fe0.ERROR_REQUEST_FORBIDDEN_IN_BG;
                requestStatistic.msg = fe0.b(fe0.ERROR_REQUEST_FORBIDDEN_IN_BG);
                requestStatistic.rspEnd = System.currentTimeMillis();
                anet.channel.fulltrace.a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                this.rc.b.onFinish(new DefaultFinishEvent((int) fe0.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, this.rc.a.b()));
                ExceptionStatistic exceptionStatistic = new ExceptionStatistic(fe0.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
                exceptionStatistic.host = this.rc.a.e().d();
                exceptionStatistic.url = this.rc.a.h();
                w6.b().commitStat(exceptionStatistic);
            }
        }
    }
}
