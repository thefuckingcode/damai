package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.huawei.hms.api.ConnectionResult;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.ui.component.AbstractEditComponent;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.uc.CoreClassPreLoader;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.uc.wa.a;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.m;
import com.uc.webview.export.internal.utility.n;
import com.uc.webview.export.internal.utility.p;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.usercenter.passport.result.VerifyCookieResult;
import com.youku.vpm.track.OnePlayTrack;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public final class am {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static final AtomicBoolean d = new AtomicBoolean(false);
    private static final AtomicBoolean e = new AtomicBoolean(false);
    private static final AtomicBoolean f = new AtomicBoolean(false);
    private static final AtomicBoolean g = new AtomicBoolean(false);
    private static final AtomicBoolean h = new AtomicBoolean(false);
    private static final AtomicBoolean i = new AtomicBoolean(false);
    private static final AtomicBoolean j = new AtomicBoolean(false);
    private static final AtomicBoolean k = new AtomicBoolean(false);
    private static final AtomicBoolean l = new AtomicBoolean(false);
    private static String m = null;

    private am() {
    }

    private static void a() {
        n.a(new an());
        ae.a();
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        Log.e("SetupPreprocess", "commonInitPreprocess " + context);
        b.a(VerifyCookieResult.USER_ALREADY_LOGOUT);
        d(context);
        b();
        a(context, (String) null);
        a();
        o.a().b();
        b.a(517);
    }

    private static void d(Context context) {
        if (a.compareAndSet(false, true)) {
            a("preInitCore.preloadStart", OnePlayTrack.PlayType.BEGIN);
            Log.e("SetupPreprocess", "preloadStart " + context);
        }
    }

    private static void b() {
        Log.e("SetupPreprocess", "preloadSdkClass ");
        if (c.compareAndSet(false, true)) {
            b.a(520);
            try {
                ClassLoader classLoader = am.class.getClassLoader();
                a(o.class, classLoader);
                a(SDKFactory.class, classLoader);
                a(UCCyclone.class, classLoader);
                a(bt.class, classLoader);
                a(a.class, classLoader);
                a(IWaStat.class, classLoader);
                a(p.class, classLoader);
                i.a().a("gk_preload_cl", Boolean.TRUE);
            } catch (Throwable th) {
                th.printStackTrace();
            } finally {
                b.a(521);
            }
        }
    }

    public static void a(Context context) {
        Log.e("SetupPreprocess", "asyncInitPreprocess " + context);
        if (b.compareAndSet(false, true)) {
            n.a(new ao(context));
        }
    }

    private static void a(Class cls, ClassLoader classLoader) {
        try {
            Class.forName(cls.getName(), true, classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Context context, String str) {
        Log.e("SetupPreprocess", "preloadIo " + context + AVFSCacheConstants.COMMA_SEP + str);
        if (context != null) {
            int i2 = 0;
            if (e.compareAndSet(false, true)) {
                b.a(522);
                try {
                    i.a().a("gk_preload_io", Boolean.TRUE);
                    m.c(context);
                    SDKFactory.c(context);
                    IWaStat.WaStat.stat("pre_head");
                    if (p.f()) {
                        String[] strArr = new String[2];
                        if (!p.a(str)) {
                            strArr[0] = aj.a(UCCore.getExtractDirPath(context, new File(str, "libkernelu4_7z_uc.so").getAbsolutePath()));
                            i2 = 1;
                        }
                        if (m.a() != null) {
                            strArr[i2] = aj.a(m.a().soDirPath);
                            i2++;
                        }
                        if (i2 > 0) {
                            aj.a(context, strArr);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                } finally {
                    b.a(523);
                }
            }
        }
    }

    private static boolean a(ClassLoader classLoader) {
        AtomicBoolean atomicBoolean = l;
        if (atomicBoolean.get()) {
            return true;
        }
        if (classLoader != null) {
            try {
                Class.forName("com.uc.webkit.sdk.CoreFactoryImpl", true, classLoader);
            } catch (ClassNotFoundException unused) {
                com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "shouldPreLaunchCoreSetupTask failed.");
                return false;
            }
        } else {
            Class.forName("com.uc.webkit.sdk.CoreFactoryImpl");
        }
        atomicBoolean.set(true);
        return true;
    }

    private static void a(int i2, Object[] objArr) {
        String.valueOf(i2);
        com.uc.webview.export.internal.uc.startup.a.a(i2, objArr);
        String.valueOf(i2);
    }

    private static void a(String str, String str2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        d.a(str, String.format(Locale.US, "%s at timestamp %d", str2, Long.valueOf(uptimeMillis)));
    }

    public static Object a(int i2, Context context, Object[] objArr) {
        try {
            d(context);
            switch (i2) {
                case 0:
                    a("preInitCore.decompress.start", AbstractEditComponent.ReturnTypes.DONE);
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    String str3 = (String) objArr[2];
                    boolean booleanValue = ((Boolean) objArr[3]).booleanValue();
                    Log.e("SetupPreprocess", "preDecompress " + context + AVFSCacheConstants.COMMA_SEP + str + AVFSCacheConstants.COMMA_SEP + str2 + AVFSCacheConstants.COMMA_SEP + str3 + AVFSCacheConstants.COMMA_SEP + booleanValue);
                    if (context != null && !p.a(str) && !p.a(str3) && g.compareAndSet(false, true)) {
                        b.a(528);
                        try {
                            new File(str3).mkdirs();
                            boolean extractWebCoreLibraryIfNeeded = UCCore.extractWebCoreLibraryIfNeeded(context, str, str2, str3, false);
                            com.uc.webview.export.internal.utility.Log.d("SetupPreprocess", "preDecompress extract: " + extractWebCoreLibraryIfNeeded);
                        } catch (Throwable th) {
                            b.a(529);
                            throw th;
                        }
                        b.a(529);
                    }
                    a("preInitCore.decompress.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 1:
                    a(context, (String) objArr[0]);
                    a("preInitCore.loadIO", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 2:
                    b();
                    a();
                    o.a().b();
                    a("preInitCore.loadSdkClass", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 3:
                    Log.e("SetupPreprocess", "preloadCoreClass");
                    if (d.compareAndSet(false, true)) {
                        try {
                            if (p.f()) {
                                CoreClassPreLoader.a(am.class.getClassLoader());
                            } else if (com.uc.webview.export.internal.uc.startup.a.b()) {
                                com.uc.webview.export.internal.uc.startup.a.a(9001, null);
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    a("preInitCore.loadCoreClass", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 4:
                    a("preInitCore.loadJar.start", AbstractEditComponent.ReturnTypes.DONE);
                    String str4 = (String) objArr[0];
                    Log.e("SetupPreprocess", "preloadJar " + context + ", decompressRootDir:" + str4);
                    b.a(530);
                    String absolutePath = new File(str4, "core.jar").getAbsolutePath();
                    if (new File(absolutePath).exists()) {
                        File b2 = p.b(p.a(context, "odexs"), p.e(p.b(context, absolutePath)));
                        if (b2.exists()) {
                            af.a(absolutePath, b2.getAbsolutePath(), null);
                            com.uc.webview.export.internal.uc.startup.a.a();
                        }
                    }
                    b.a(530);
                    a("preInitCore.loadJar.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 5:
                    a("preInitCore.loadSo.start", AbstractEditComponent.ReturnTypes.DONE);
                    String str5 = (String) objArr[0];
                    Log.e("SetupPreprocess", "preloadSo " + context + ", decompressRootDir");
                    com.uc.webview.export.internal.uc.startup.a.a();
                    ClassLoader e2 = af.e();
                    if (context != null && !p.a(str5) && !f.getAndSet(true) && a(e2)) {
                        try {
                            b.a(524);
                            String canonicalPath = p.a(new File(str5, SolidMonitor.CHECK_TYPE_LIB)).getCanonicalPath();
                            if (new File(canonicalPath, "libwebviewuc.so").exists()) {
                                boolean booleanValue2 = ((Boolean) com.uc.webview.export.internal.uc.startup.a.a(9004, new Object[]{context, canonicalPath})).booleanValue();
                                if (booleanValue2) {
                                    m = str5;
                                    i.a().a("gk_preload_so", Boolean.TRUE);
                                }
                                com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "preloadSoInternal  libwebviewuc res:" + booleanValue2);
                            } else {
                                com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "preloadSoInternal failed libwebviewuc not exist. libDir:" + canonicalPath);
                            }
                        } catch (Throwable th3) {
                            b.a(525);
                            throw th3;
                        }
                        b.a(525);
                    }
                    a("preInitCore.loadSo.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 6:
                    Log.e("SetupPreprocess", "prePartialInitWebView " + context);
                    if (!h.compareAndSet(false, true) || !a(af.e())) {
                        com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "prePartialInitWebView failed");
                    } else {
                        b.a(535);
                        com.uc.webview.export.internal.uc.startup.a.a();
                        Log.e("SetupPreprocess", "preInitWebviewProvider " + context);
                        a((int) ConnectionResult.SIGN_IN_FAILED, new Object[]{context});
                        j.a(context);
                        a(9006, (Object[]) null);
                        b.a(536);
                    }
                    a("preInitCore.initWebViewProvider", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 7:
                    a("preInitCore.startCoreEngine.start", AbstractEditComponent.ReturnTypes.DONE);
                    Log.e("SetupPreprocess", "preStartCoreEngine " + context);
                    a(9009, new Object[]{context});
                    a("preInitCore.startCoreEngine.end", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 8:
                    Log.e("SetupPreprocess", "preInitPak " + context);
                    com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "preInitPak sDecompressRootDir:" + m);
                    if (!i.compareAndSet(false, true) || !a((ClassLoader) null) || m == null) {
                        com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "preInitPak failed, sDecompressRootDir:" + m);
                    } else {
                        com.uc.webview.export.internal.uc.startup.a.a();
                        a(9008, new Object[]{new File(m, "assets").getAbsolutePath()});
                    }
                    a("preInitCore.initPAK", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 9:
                    Log.e("SetupPreprocess", "preInitIcu " + context);
                    com.uc.webview.export.internal.utility.Log.i("SetupPreprocess", "preInitIcu sDecompressRootDir:" + m);
                    if (!j.compareAndSet(false, true) || !a((ClassLoader) null) || m == null) {
                        com.uc.webview.export.internal.utility.Log.e("SetupPreprocess", "preInitIcu failed, sDecompressRootDir:" + m);
                    } else {
                        com.uc.webview.export.internal.uc.startup.a.a();
                        a(9007, (Object[]) null);
                    }
                    a("preInitCore.initICU", AbstractEditComponent.ReturnTypes.DONE);
                    break;
                case 10:
                    Log.e("SetupPreprocess", "initPreprocess " + context);
                    if (b.compareAndSet(false, true)) {
                        b.a(518);
                        c(context);
                        i.a().a("gk_init_pre", Boolean.TRUE);
                        b.a(519);
                    }
                    a("preInitCore.initPreprocess", AbstractEditComponent.ReturnTypes.DONE);
                    break;
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        return null;
    }
}
