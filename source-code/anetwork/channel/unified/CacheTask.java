package anetwork.channel.unified;

import anet.channel.request.a;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.interceptor.Callback;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.b02;
import tb.pd;

/* compiled from: Taobao */
public class CacheTask implements IUnifiedTask {
    private static final String TAG = "anet.CacheTask";
    private Cache cache = null;
    private volatile boolean isCanceled = false;
    private b rc = null;

    public CacheTask(b bVar, Cache cache2) {
        this.rc = bVar;
        this.cache = cache2;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        this.rc.a.f.ret = 2;
    }

    public void run() {
        Cache.Entry entry;
        boolean z;
        if (!this.isCanceled) {
            b02 b02 = this.rc.a;
            RequestStatistic requestStatistic = b02.f;
            if (this.cache != null) {
                String h = b02.h();
                a b = this.rc.a.b();
                String str = b.g().get("Cache-Control");
                boolean equals = "no-store".equals(str);
                long currentTimeMillis = System.currentTimeMillis();
                if (equals) {
                    this.cache.remove(h);
                    z = false;
                    entry = null;
                } else {
                    z = HttpHeaderConstant.NO_CACHE.equals(str);
                    entry = this.cache.get(h);
                    if (ALog.g(2)) {
                        String str2 = this.rc.c;
                        Object[] objArr = new Object[8];
                        objArr[0] = "hit";
                        objArr[1] = Boolean.valueOf(entry != null);
                        objArr[2] = "cost";
                        objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                        objArr[4] = "length";
                        objArr[5] = Integer.valueOf(entry != null ? entry.data.length : 0);
                        objArr[6] = "key";
                        objArr[7] = h;
                        ALog.f(TAG, "read cache", str2, objArr);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.cacheTime = currentTimeMillis2 - currentTimeMillis;
                if (entry == null || z || !entry.isFresh()) {
                    if (!this.isCanceled) {
                        NetworkTask networkTask = new NetworkTask(this.rc, equals ? null : this.cache, entry);
                        this.rc.e = networkTask;
                        networkTask.run();
                    }
                } else if (this.rc.d.compareAndSet(false, true)) {
                    this.rc.c();
                    requestStatistic.ret = 1;
                    requestStatistic.statusCode = 200;
                    requestStatistic.msg = "SUCCESS";
                    requestStatistic.protocolType = "cache";
                    requestStatistic.rspEnd = currentTimeMillis2;
                    anet.channel.fulltrace.a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                    requestStatistic.processTime = currentTimeMillis2 - requestStatistic.start;
                    if (ALog.g(2)) {
                        b bVar = this.rc;
                        ALog.f(TAG, "hit fresh cache", bVar.c, "URL", bVar.a.e().n());
                    }
                    this.rc.b.onResponseCode(200, entry.responseHeaders);
                    Callback callback = this.rc.b;
                    byte[] bArr = entry.data;
                    callback.onDataReceiveSize(1, bArr.length, pd.g(bArr));
                    this.rc.b.onFinish(new DefaultFinishEvent(200, "SUCCESS", b));
                }
            }
        }
    }
}
