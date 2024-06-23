package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* access modifiers changed from: package-private */
/* compiled from: SDKEngine */
public class d {
    static int a = 0;
    static boolean b = false;
    private static d e = null;
    private static int h = 0;
    private static int i = 3;
    private static String k;
    private s c = null;
    private s d = null;
    private boolean f = false;
    private boolean g = false;
    private File j = null;

    private d() {
    }

    public static d a(boolean z) {
        if (e == null && z) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    public synchronized void a(Context context, boolean z, boolean z2) {
        File file;
        File file2;
        Context context2;
        String str;
        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INIT, null, new Object[0]);
        TbsLog.initIfNeed(context);
        TbsLog.i("SDKEngine", "init -- context: " + context + ", isPreIniting: " + z2);
        a = a + 1;
        TbsCoreLoadStat.getInstance().a();
        m.a().b(context, a == 1);
        m.a().k(context);
        TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        boolean a2 = QbSdk.a(context, z, z2);
        boolean z3 = Build.VERSION.SDK_INT >= 7;
        boolean z4 = a2 && z3;
        if (z4) {
            long currentTimeMillis = System.currentTimeMillis();
            z4 = m.a().g(context, d());
            TbsLog.i("SDKEngine", "isTbsCoreLegal: " + z4 + "; cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!z4) {
            String str2 = "can_load_x5=" + a2 + "; is_compatible=" + z3;
            TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str2);
            if (!QbSdk.a || !this.f) {
                this.f = false;
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_TBS, new Throwable(str2));
            }
        } else if (!this.f) {
            try {
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                    if (TbsShareManager.j(context)) {
                        file2 = new File(TbsShareManager.c(context));
                        file = m.a().q(context);
                        context2 = TbsShareManager.e(context);
                        if (file == null) {
                            this.f = false;
                            QbSdk.a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                            return;
                        }
                    } else {
                        this.f = false;
                        QbSdk.a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                        return;
                    }
                } else {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                    file2 = m.a().q(context);
                    int i2 = h;
                    context2 = i2 == 25436 || i2 == 25437 ? context.getApplicationContext() : context;
                    if (file2 == null) {
                        this.f = false;
                        QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        return;
                    }
                    file = file2;
                }
                String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, context2, file2.getAbsolutePath());
                for (int i3 = 0; i3 < dexLoaderFileList.length; i3++) {
                }
                if (TbsShareManager.getHostCorePathAppDefined() != null) {
                    str = TbsShareManager.getHostCorePathAppDefined();
                } else {
                    str = file.getAbsolutePath();
                }
                TbsLog.i("SDKEngine", "SDKEngine init optDir is " + str);
                s sVar = this.d;
                if (sVar != null) {
                    this.c = sVar;
                    sVar.a(context, context2, file2.getAbsolutePath(), str, dexLoaderFileList, QbSdk.d);
                } else {
                    this.c = new s(context, context2, file2.getAbsolutePath(), str, dexLoaderFileList, QbSdk.d);
                }
                this.f = true;
            } catch (Throwable th) {
                TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                this.f = false;
                QbSdk.a(context, "SDKEngine::useSystemWebView by exception: " + th);
            }
        } else {
            return;
        }
        this.j = m.s(context);
        this.g = true;
    }

    public s a() {
        if (this.f) {
            return this.c;
        }
        return null;
    }

    public boolean b() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public s c() {
        return this.c;
    }

    public static int d() {
        return h;
    }

    static void a(int i2) {
        h = i2;
    }

    public String e() {
        return (this.c == null || QbSdk.a) ? "system webview get nothing..." : this.c.a();
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (b) {
            if (k == null) {
                return false;
            }
            int i2 = i();
            if (i2 == 0) {
                b(1);
            } else {
                int i3 = i2 + 1;
                if (i3 > i) {
                    return false;
                }
                b(i3);
            }
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    public boolean b(boolean z) {
        b = z;
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        k = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a A[SYNTHETIC, Splitter:B:20:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057 A[SYNTHETIC, Splitter:B:28:0x0057] */
    private int i() {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(this.j, "count.prop");
            if (!file.exists()) {
                return 0;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                int intValue = Integer.valueOf(properties.getProperty(k, "1")).intValue();
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return intValue;
            } catch (Exception e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            bufferedInputStream = null;
            e2 = e7;
            e2.printStackTrace();
            if (bufferedInputStream != null) {
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
    }

    private void b(int i2) {
        String valueOf = String.valueOf(i2);
        Properties properties = new Properties();
        properties.setProperty(k, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.j, "count.prop")), (String) null);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public boolean h() {
        return QbSdk.useSoftWare();
    }
}
