package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.nio.channels.FileLock;

/* access modifiers changed from: package-private */
/* compiled from: X5CoreEngine */
public class u {
    private static u a;
    private static FileLock e;
    private v b;
    private boolean c;
    private boolean d;

    private u() {
    }

    public static u a() {
        if (a == null) {
            synchronized (u.class) {
                if (a == null) {
                    a = new u();
                }
            }
        }
        return a;
    }

    public boolean b() {
        if (QbSdk.a) {
            return false;
        }
        return this.c;
    }

    public v a(boolean z) {
        if (z) {
            return this.b;
        }
        return c();
    }

    public v c() {
        if (QbSdk.a) {
            return null;
        }
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a4  */
    public synchronized void a(Context context) {
        Throwable th;
        TbsLog.i("X5CoreEngine", "init #1");
        d a2 = d.a(true);
        a2.a(context, false, false);
        StringBuilder sb = new StringBuilder();
        s a3 = a2.a();
        Object obj = null;
        if (!a2.b() || a3 == null) {
            this.c = false;
            sb.append("can not use X5 by !tbs available");
        } else if (!this.d) {
            v vVar = new v(a3.b());
            this.b = vVar;
            try {
                boolean a4 = vVar.a();
                this.c = a4;
                if (!a4) {
                    sb.append("can not use X5 by x5corewizard return false");
                }
            } catch (NoSuchMethodException unused) {
                this.c = true;
            } catch (Throwable th2) {
                th = th2;
                this.c = false;
                sb.append("can not use x5 by throwable " + Log.getStackTraceString(th));
            }
            th = null;
            if (this.c) {
                CookieManager.getInstance().a(context, true, true);
                CookieManager.getInstance().a();
            }
            TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
            if (this.c) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (a2.b() && a3 != null && th == null) {
                    try {
                        DexLoader b2 = a3.b();
                        if (b2 != null) {
                            obj = b2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj instanceof Throwable) {
                            Throwable th3 = (Throwable) obj;
                            sb.append("#" + th3.getMessage() + "; cause: " + th3.getCause() + "; th: " + th3);
                        }
                        if (obj instanceof String) {
                            sb.append("failure detail:" + obj);
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    if (sb.toString().contains("isPreloadX5Disabled:-10000")) {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + sb.toString()));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_X5, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + sb.toString()));
                    }
                } else if (a2.b()) {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new Throwable("mCanUseX5=false, available true, reason: " + th));
                } else {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new Throwable("mCanUseX5=false, available false, reason: " + th));
                }
            } else {
                TbsLog.i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + e);
                if (e == null) {
                    b(context);
                }
            }
            this.d = true;
        }
        th = null;
        TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
        if (this.c) {
        }
        this.d = true;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.d;
    }

    public FileLock b(Context context) {
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = e;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (u.class) {
            if (e == null) {
                FileLock e2 = f.e(context);
                e = e2;
                if (e2 == null) {
                    TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock failed!");
                } else {
                    TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock succeeded: " + e);
                }
            }
        }
        return e;
    }
}
