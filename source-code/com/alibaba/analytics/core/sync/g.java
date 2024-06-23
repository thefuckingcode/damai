package com.alibaba.analytics.core.sync;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.store.ILogChangeListener;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.UploadLog;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.concurrent.ScheduledFuture;
import org.apache.commons.lang3.time.DateUtils;
import tb.gj2;
import tb.t6;

/* compiled from: Taobao */
public class g implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    static g k = new g();
    private long a = 30000;
    private UploadMode b = null;
    private ScheduledFuture c;
    private ILogChangeListener d;
    private UploadTask e = new UploadTask();
    private UploadLog.NetworkStatus f = UploadLog.NetworkStatus.ALL;
    private boolean g = false;
    private final Object h = new Object();
    private boolean i = false;
    private long j = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IUploadExcuted {
        a() {
        }

        @Override // com.alibaba.analytics.core.sync.IUploadExcuted
        public void onUploadExcuted(long j) {
            e.h().c(g.this.f);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements ILogChangeListener {
        b() {
        }

        @Override // com.alibaba.analytics.core.store.ILogChangeListener
        public void onDelete(long j, long j2) {
        }

        @Override // com.alibaba.analytics.core.store.ILogChangeListener
        public void onInsert(long j, long j2) {
            if (com.alibaba.analytics.core.config.b.a()) {
                synchronized (g.this.h) {
                    if (g.this.d != null) {
                        LogStoreMgr.l().o(g.this.d);
                    }
                    try {
                        Variables.n().p0();
                    } catch (Throwable th) {
                        Logger.h(null, th, new Object[0]);
                    }
                }
                return;
            }
            Logger.f("RealTimeMode", AdUtConstants.XAD_UT_ARG_COUNT, Long.valueOf(j), "dbSize", Long.valueOf(j2));
            if (j > 0 && j2 > 0 && UploadMode.REALTIME == g.this.b) {
                g.this.c = gj2.c().d(null, g.this.e, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements IUploadExcuted {
        c() {
        }

        @Override // com.alibaba.analytics.core.sync.IUploadExcuted
        public void onUploadExcuted(long j) {
            g gVar = g.this;
            gVar.a = gVar.k();
            Logger.f("UploadMgr", "CurrentUploadInterval", Long.valueOf(g.this.a));
            f.i().c(g.this.f);
            g.this.c = gj2.c().d(g.this.c, g.this.e, g.this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UploadMode.values().length];
            a = iArr;
            try {
                iArr[UploadMode.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private g() {
        UTServerAppStatusTrigger.d(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long k() {
        if (this.g) {
            long m = m();
            if (r()) {
                return n();
            }
            return m;
        }
        this.i = false;
        long o = o();
        if (o == 0) {
            return 30000;
        }
        return o;
    }

    private long m() {
        long j2 = (long) (SystemConfigMgr.i().j("bu") * 1000);
        if (j2 <= 0) {
            return 300000;
        }
        return j2;
    }

    private long n() {
        long j2 = (long) (SystemConfigMgr.i().j("bu2") * 1000);
        if (j2 <= 0) {
            return 600000;
        }
        return j2;
    }

    private long o() {
        long j2 = (long) (SystemConfigMgr.i().j(IRequestConst.FU) * 1000);
        if (j2 <= 0) {
            return 30000;
        }
        return j2;
    }

    public static g p() {
        return k;
    }

    private boolean r() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.j > DateUtils.MILLIS_PER_MINUTE) {
            this.j = elapsedRealtime;
            boolean j2 = t6.j(Variables.n().j());
            this.i = j2;
            Logger.f("UploadMgr", "isMainProcessDeadExtend", Boolean.valueOf(j2));
        } else {
            Logger.f("UploadMgr", "time limit. isMainProcessDeadExtend", Boolean.valueOf(this.i));
        }
        return this.i;
    }

    private void s() {
        String f2 = t6.f(Variables.n().j(), "UTANALYTICS_UPLOAD_ALLOWED_NETWORK_STATUS");
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        if ("ALL".equalsIgnoreCase(f2)) {
            this.f = UploadLog.NetworkStatus.ALL;
        } else if ("2G".equalsIgnoreCase(f2)) {
            this.f = UploadLog.NetworkStatus.TWO_GENERATION;
        } else if ("3G".equalsIgnoreCase(f2)) {
            this.f = UploadLog.NetworkStatus.THRID_GENERATION;
        } else if ("4G".equalsIgnoreCase(f2)) {
            this.f = UploadLog.NetworkStatus.FOUR_GENERATION;
        } else if ("WIFI".equalsIgnoreCase(f2)) {
            this.f = UploadLog.NetworkStatus.WIFI;
        }
    }

    private synchronized void v(UploadMode uploadMode) {
        Logger.f("startMode", "mode", uploadMode);
        if (d.a[uploadMode.ordinal()] != 1) {
            w();
        } else {
            x();
        }
    }

    private void w() {
        Logger.f("UploadMgr", "startIntervalMode CurrentUploadInterval", Long.valueOf(this.a));
        f.i().d(new c());
        this.c = gj2.c().d(this.c, this.e, 3000);
    }

    private void x() {
        if (this.d != null) {
            LogStoreMgr.l().o(this.d);
        }
        this.d = new b();
        LogStoreMgr.l().m(this.d);
    }

    public void l() {
        Logger.d();
        gj2.c().f(this.e);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        Logger.f("UploadMgr", "onBackground", Boolean.TRUE);
        l();
        if (UploadMode.INTERVAL == this.b) {
            this.g = true;
            long k2 = k();
            if (this.a != k2) {
                this.a = k2;
                u();
            }
        }
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
        Logger.f("UploadMgr", "onForeground", Boolean.TRUE);
        l();
        if (UploadMode.INTERVAL == this.b) {
            this.g = false;
            long k2 = k();
            if (this.a != k2) {
                this.a = k2;
                u();
            }
        }
    }

    public synchronized void q(Context context) {
        boolean z = !t6.g(context);
        this.g = z;
        Logger.f("UploadMgr", "init mIsAppOnBackground", Boolean.valueOf(z));
        u();
    }

    public void t(UploadMode uploadMode) {
        if (uploadMode != null && this.b != uploadMode) {
            this.b = uploadMode;
            u();
        }
    }

    public synchronized void u() {
        Logger.q();
        s();
        UploadQueueMgr.getInstance().start();
        e.h().c(this.f);
        e.h().d(new a());
        if (this.b == null) {
            this.b = UploadMode.INTERVAL;
        }
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        v(this.b);
    }
}
