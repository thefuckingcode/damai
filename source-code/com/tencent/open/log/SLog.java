package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.d;
import com.tencent.open.utils.g;
import java.io.File;

/* compiled from: Taobao */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";
    private static boolean c;
    public static SLog instance;
    protected a a;
    private Tracer b;

    private SLog() {
    }

    private void d() {
        this.a = new a(new b(a(), c.m, c.g, c.h, c.c, (long) c.i, 10, c.e, c.n));
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    SLog sLog = new SLog();
                    instance = sLog;
                    sLog.d();
                    c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str, String str2, Throwable th) {
        if (c) {
            String b2 = g.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.a != null) {
                    e.a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                    this.a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                    c = false;
                } else {
                    return;
                }
            }
        }
        e.a.a(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.b, i)) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            } else {
                return;
            }
        }
        Tracer tracer = this.b;
        if (tracer != null) {
            try {
                tracer.a(i, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
            } catch (Exception e) {
                Log.e(str, "Exception", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
            this.a.b();
            this.a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.b = tracer;
    }

    public static final void e(String str, String str2, Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static final void i(String str, String str2, Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static final void u(String str, String str2, Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(String str, String str2, Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void d(String str, String str2, Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return d.a(str) ? "xxxxxx" : str;
    }

    protected static File a() {
        String str = c.d;
        try {
            d.c b2 = d.b.b();
            if (b2 != null && b2.c() > c.f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(g.c(), str);
        } catch (Throwable th) {
            e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}
