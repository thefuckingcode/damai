package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import okhttp3.internal.connection.RealConnection;

public class TbsShareManager {
    private static Context a = null;
    private static boolean b = false;
    private static String c = null;
    private static String d = null;
    private static int e = 0;
    private static String f = null;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static String j = null;
    private static boolean k = false;
    private static boolean l = false;
    public static boolean mHasQueryed = false;

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_WX, TbsConfig.APP_QQ, TbsConfig.APP_QZONE, "com.tencent.qqlite"};
    }

    static void a(Context context) {
        TbsLog.i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, m.a().q(context));
            File r = m.a().r(context);
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + r.getAbsolutePath());
            tbsLinuxToolsJni.a(r.getAbsolutePath(), "755");
        } catch (Throwable th) {
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            th.printStackTrace();
        }
    }

    static void b(Context context) {
        try {
            a(context, new TbsLinuxToolsJni(context), m.a().p(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file != null && file.exists() && file.isDirectory()) {
            TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
            tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    public static void setHostCorePathAppDefined(String str) {
        c = str;
    }

    public static String getHostCorePathAppDefined() {
        return c;
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
            Context context2 = a;
            if (context2 != null && context2.equals(context.getApplicationContext())) {
                return b;
            }
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            String packageName = applicationContext.getPackageName();
            for (String str : getCoreProviderAppList()) {
                if (packageName.equals(str)) {
                    b = false;
                    return false;
                }
            }
            b = true;
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long getHostCoreVersions(Context context) {
        long sharedTbsCoreVersion;
        long sharedTbsCoreVersion2;
        long j2;
        String[] coreProviderAppList = getCoreProviderAppList();
        long j3 = 0;
        for (String str : coreProviderAppList) {
            if (str.equalsIgnoreCase(TbsConfig.APP_WX)) {
                sharedTbsCoreVersion2 = (long) getSharedTbsCoreVersion(context, str);
                j2 = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QQ)) {
                sharedTbsCoreVersion2 = (long) getSharedTbsCoreVersion(context, str);
                j2 = 100000;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QZONE)) {
                sharedTbsCoreVersion = (long) getSharedTbsCoreVersion(context, str);
                j3 += sharedTbsCoreVersion;
            }
            sharedTbsCoreVersion = sharedTbsCoreVersion2 * j2;
            j3 += sharedTbsCoreVersion;
        }
        return j3;
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return m.a().i(packageContext);
        }
        return 0;
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return m.a().h(packageContext);
        }
        return 0;
    }

    public static int getBackupCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                return a.b(file);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return a.b(file);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static File getBackupCoreFile(Context context, String str) {
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, true), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    static String c(Context context) {
        j(context);
        return d;
    }

    static String a() {
        return d;
    }

    static int d(Context context) {
        return a(context, true);
    }

    static int a(Context context, boolean z) {
        b(context, z);
        return e;
    }

    static Context e(Context context) {
        j(context);
        String str = f;
        Context context2 = null;
        if (str != null) {
            Context packageContext = getPackageContext(context, str, true);
            if (m.a().f(packageContext)) {
                context2 = packageContext;
            }
        }
        return c != null ? a : context2;
    }

    private static boolean k(Context context) {
        String str = f;
        if (str == null) {
            return false;
        }
        if (e == getSharedTbsCoreVersion(context, str) || e == getCoreShareDecoupleCoreVersion(context, f)) {
            return true;
        }
        return false;
    }

    private static boolean l(Context context) {
        if (QbSdk.getOnlyDownload()) {
            return false;
        }
        String[] coreProviderAppList = getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            int i2 = e;
            if (i2 > 0 && i2 == getSharedTbsCoreVersion(context, str)) {
                Context packageContext = getPackageContext(context, str, true);
                if (m.a().f(context)) {
                    d = m.a().b(context, packageContext).getAbsolutePath();
                    f = str;
                    return true;
                }
            }
        }
        for (String str2 : coreProviderAppList) {
            int i3 = e;
            if (i3 > 0 && i3 == getCoreShareDecoupleCoreVersion(context, str2)) {
                Context packageContext2 = getPackageContext(context, str2, true);
                if (m.a().f(context)) {
                    d = m.a().c(context, packageContext2).getAbsolutePath();
                    f = str2;
                    return true;
                }
            }
        }
        return false;
    }

    public static int findCoreForThirdPartyApp(Context context) {
        n(context);
        TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
        if (f == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        String str = f;
        if (str == null || !str.equals("AppDefined")) {
            if (!k(context) && !l(context)) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            }
        } else if (e != m.a().a(c)) {
            e = 0;
            d = null;
            f = null;
            TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + m.a().a(c));
        }
        if (e > 0) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((!("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || "com.jd.jrapp".equals(applicationInfo.packageName)) ? QbSdk.a(context, e) : false) || g) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        return e;
    }

    private static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.Properties */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:5|6|7|(1:9)|10|11|12|13|14|15|16|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[SYNTHETIC, Splitter:B:26:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    private static void c(Context context, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream = 0;
        try {
            File tbsShareFile = getTbsShareFile(context, "core_info");
            if (tbsShareFile != null) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    properties.setProperty("core_disabled", String.valueOf(false));
                    if (z) {
                        String absolutePath = m.a().q(context).getAbsolutePath();
                        String packageName = context.getApplicationContext().getPackageName();
                        int b2 = b.b(context);
                        properties.setProperty("core_packagename", packageName);
                        properties.setProperty("core_path", absolutePath);
                        properties.setProperty("app_version", String.valueOf(b2));
                    }
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
                    try {
                        properties.store(bufferedOutputStream, (String) bufferedInputStream);
                        bufferedInputStream2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                        } finally {
                            if (bufferedInputStream != 0) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = bufferedInputStream;
                    bufferedInputStream = bufferedInputStream2;
                    th.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = bufferedInputStream;
            th.printStackTrace();
        }
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        int sharedTbsCoreVersion;
        if (context == null || m.a().a(context, (File[]) null) || (sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO)) <= 0) {
            return false;
        }
        writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, m.a().q(getPackageContext(context, TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
        return true;
    }

    public static synchronized void writeCoreInfoForThirdPartyApp(Context context, int i2, boolean z) {
        synchronized (TbsShareManager.class) {
            TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + i2);
            if (i2 == 0) {
                m(context);
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
                return;
            }
            int h2 = h(context);
            TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + h2);
            if (h2 < 0) {
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
            } else if (i2 == h2) {
                if (d(context) == 0 && !z) {
                    a(context, i2);
                }
                c(context, z);
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
            } else if (i2 < h2) {
                m(context);
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
            } else {
                int i3 = m.a().i(context);
                TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + i3);
                if (i2 < i3) {
                    m(context);
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
                    return;
                }
                String[] d2 = d(context, z);
                boolean z2 = false;
                if (c != null) {
                    if (i2 == m.a().a(c)) {
                        writeProperties(context, Integer.toString(i2), "AppDefined", c, Integer.toString(1));
                        try {
                            File tbsShareFile = getTbsShareFile(context, "core_info");
                            if (!i && tbsShareFile != null) {
                                TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(a);
                                tbsLinuxToolsJni.a(tbsShareFile.getAbsolutePath(), "644");
                                tbsLinuxToolsJni.a(m.a().r(context).getAbsolutePath(), "755");
                                i = true;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return;
                    } else if (i2 > m.a().a(c)) {
                        for (String str : d2) {
                            if (i2 == getSharedTbsCoreVersion(context, str)) {
                                Context packageContext = getPackageContext(context, str, true);
                                String absolutePath = m.a().q(packageContext).getAbsolutePath();
                                b.b(context);
                                if (m.a().f(packageContext)) {
                                    try {
                                        f.a(new File(absolutePath), new File(c), new FileFilter() {
                                            /* class com.tencent.smtt.sdk.TbsShareManager.AnonymousClass1 */

                                            public boolean accept(File file) {
                                                return !file.getName().endsWith(".dex");
                                            }
                                        });
                                        writeProperties(context, Integer.toString(i2), "AppDefined", c, Integer.toString(1));
                                        File tbsShareFile2 = getTbsShareFile(context, "core_info");
                                        if (!i && tbsShareFile2 != null) {
                                            TbsLinuxToolsJni tbsLinuxToolsJni2 = new TbsLinuxToolsJni(a);
                                            tbsLinuxToolsJni2.a(tbsShareFile2.getAbsolutePath(), "644");
                                            tbsLinuxToolsJni2.a(m.a().r(context).getAbsolutePath(), "755");
                                            i = true;
                                        }
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
                int length = d2.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    String str2 = d2[i4];
                    if (i2 == getSharedTbsCoreVersion(context, str2)) {
                        Context packageContext2 = getPackageContext(context, str2, true);
                        String absolutePath2 = m.a().q(packageContext2).getAbsolutePath();
                        int b2 = b.b(context);
                        if (!m.a().f(packageContext2)) {
                            i4++;
                        } else {
                            if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                                k.a(a).a("remove_old_core", 1);
                            }
                            writeProperties(context, Integer.toString(i2), str2, absolutePath2, Integer.toString(b2));
                            try {
                                File tbsShareFile3 = getTbsShareFile(context, "core_info");
                                if (!i && tbsShareFile3 != null) {
                                    TbsLinuxToolsJni tbsLinuxToolsJni3 = new TbsLinuxToolsJni(a);
                                    tbsLinuxToolsJni3.a(tbsShareFile3.getAbsolutePath(), "644");
                                    tbsLinuxToolsJni3.a(m.a().r(context).getAbsolutePath(), "755");
                                    i = true;
                                }
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    } else {
                        if (i2 == getCoreShareDecoupleCoreVersion(context, str2)) {
                            Context packageContext3 = getPackageContext(context, str2, true);
                            String absolutePath3 = m.a().p(packageContext3).getAbsolutePath();
                            int b3 = b.b(context);
                            if (m.a().f(packageContext3)) {
                                if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                                    try {
                                        f.b(m.a().q(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                }
                                writeProperties(context, Integer.toString(i2), str2, absolutePath3, Integer.toString(b3));
                                try {
                                    File tbsShareFile4 = getTbsShareFile(context, "core_info");
                                    if (!i && tbsShareFile4 != null) {
                                        TbsLinuxToolsJni tbsLinuxToolsJni4 = new TbsLinuxToolsJni(a);
                                        tbsLinuxToolsJni4.a(tbsShareFile4.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni4.a(m.a().r(context).getAbsolutePath(), "755");
                                        i = true;
                                    }
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                        } else {
                            continue;
                        }
                        i4++;
                    }
                }
                z2 = true;
                if (!z2 && !z) {
                    a(context, i2);
                }
            }
        }
    }

    private static String[] d(Context context, boolean z) {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{context.getApplicationContext().getPackageName()};
        }
        String[] coreProviderAppList = getCoreProviderAppList();
        if (!z) {
            return coreProviderAppList;
        }
        return new String[]{context.getApplicationContext().getPackageName()};
    }

    private static void a(Context context, int i2) {
        if (!TbsPVConfig.getInstance(a).isDisableHostBackupCore() && m.a().t(context)) {
            String[] strArr = {TbsConfig.APP_DEMO, TbsConfig.APP_WX, TbsConfig.APP_QQ, TbsConfig.APP_QZONE, context.getPackageName()};
            TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    break;
                }
                String str = strArr[i3];
                if (i2 == getBackupCoreVersion(context, str)) {
                    if (m.a().f(getPackageContext(context, str, false))) {
                        File backupCoreFile = getBackupCoreFile(context, str);
                        if (a.a(context, backupCoreFile, 0, i2)) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i2 + " packageName is " + str);
                            m.a().b(context, backupCoreFile, i2);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (i2 == getBackupDecoupleCoreVersion(context, str)) {
                    if (m.a().f(getPackageContext(context, str, false))) {
                        File backupDecoupleCoreFile = getBackupDecoupleCoreFile(context, str);
                        if (a.a(context, backupDecoupleCoreFile, 0, i2)) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + i2 + " packageName is " + str);
                            m.a().b(context, backupDecoupleCoreFile, i2);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
                i3++;
            }
            m.a().b();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2 A[SYNTHETIC, Splitter:B:36:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        int i2;
        TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        StringBuilder sb = new StringBuilder();
        sb.append("writeProperties -- stack: ");
        sb.append(Log.getStackTraceString(new Throwable("#")));
        TbsLog.i("TbsShareManager", sb.toString());
        BufferedInputStream bufferedInputStream = null;
        try {
            File tbsShareFile = getTbsShareFile(context, "core_info");
            if (tbsShareFile == null) {
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-405);
                return;
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                try {
                    i2 = Integer.parseInt(str);
                } catch (Exception unused) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", String.valueOf(false));
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", String.valueOf(true));
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
                try {
                    properties.store(bufferedOutputStream2, (String) null);
                    l = false;
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-406);
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Throwable th2) {
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream = bufferedOutputStream2;
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                th.printStackTrace();
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            th.printStackTrace();
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[SYNTHETIC, Splitter:B:28:0x0043] */
    static synchronized String f(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        synchronized (TbsShareManager.class) {
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    return null;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_packagename", "");
                    if (!"".equals(property)) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused) {
                        }
                        return property;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th3) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                th.printStackTrace();
                if (bufferedInputStream != null) {
                }
                return null;
            }
        }
    }

    static String g(Context context) {
        try {
            n(context);
            String str = d;
            if (str != null) {
                if (!TextUtils.isEmpty(str)) {
                    return d + File.separator + "res.apk";
                }
            }
            return null;
        } catch (Throwable th) {
            Log.e("", "getTbsResourcesPath exception: " + Log.getStackTraceString(th));
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074 A[SYNTHETIC, Splitter:B:36:0x0074] */
    static synchronized int h(Context context) {
        Throwable th;
        synchronized (TbsShareManager.class) {
            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #1");
            BufferedInputStream bufferedInputStream = null;
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #2");
                    return 0;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("core_version", "");
                    if (!"".equals(property)) {
                        TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #3");
                        int max = Math.max(Integer.parseInt(property), 0);
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return max;
                    }
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #4");
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return 0;
                } catch (Throwable th2) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th2;
                    try {
                        th.printStackTrace();
                        TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #5");
                        return -2;
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #5");
                return -2;
            }
        }
    }

    public static boolean getCoreFormOwn() {
        return k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e3 A[SYNTHETIC, Splitter:B:49:0x00e3] */
    private static void n(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Context context2;
        if (!l) {
            synchronized (TbsShareManager.class) {
                if (!l) {
                    try {
                        File tbsShareFile = getTbsShareFile(context, "core_info");
                        if (tbsShareFile != null) {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                            try {
                                Properties properties = new Properties();
                                properties.load(bufferedInputStream);
                                String property = properties.getProperty("core_version", "");
                                if (!"".equals(property)) {
                                    e = Math.max(Integer.parseInt(property), 0);
                                    TbsLog.i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                                }
                                String property2 = properties.getProperty("core_packagename", "");
                                if (!"".equals(property2)) {
                                    f = property2;
                                }
                                String str = f;
                                if (!(str == null || (context2 = a) == null)) {
                                    if (str.equals(context2.getPackageName())) {
                                        k = true;
                                    } else {
                                        k = false;
                                    }
                                }
                                String property3 = properties.getProperty("core_path", "");
                                if (!"".equals(property3)) {
                                    d = property3;
                                }
                                String property4 = properties.getProperty("app_version", "");
                                if (!"".equals(property4)) {
                                    j = property4;
                                }
                                g = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                                l = true;
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    th.printStackTrace();
                                } finally {
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
        File r;
        int a2;
        try {
            if (!QbSdk.isNeedInitX5FirstTime() || !isThirdPartyApp(context) || QbSdk.getOnlyDownload() || (r = m.a().r(context)) == null) {
                return;
            }
            if (z && new File(r, "core_info").exists()) {
                return;
            }
            if (c == null || (a2 = m.a().a(c)) <= 0) {
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
                int h2 = h(context);
                int i2 = m.a().i(context);
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is " + h2);
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is " + i2);
                String[] coreProviderAppList = getCoreProviderAppList();
                for (String str : coreProviderAppList) {
                    int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str);
                    if (coreShareDecoupleCoreVersion >= h2 && coreShareDecoupleCoreVersion >= i2 && coreShareDecoupleCoreVersion > 0) {
                        d = m.a().c(context, getPackageContext(context, str, true)).getAbsolutePath();
                        f = str;
                        e = coreShareDecoupleCoreVersion;
                        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                        if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            int b2 = b.b(context);
                            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
                            writeProperties(context, Integer.toString(e), f, d, Integer.toString(b2));
                            return;
                        }
                        e = 0;
                        d = null;
                        f = null;
                    }
                }
                for (String str2 : coreProviderAppList) {
                    int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                    if (sharedTbsCoreVersion >= h2 && sharedTbsCoreVersion >= i2 && sharedTbsCoreVersion > 0) {
                        d = m.a().b(context, getPackageContext(context, str2, true)).getAbsolutePath();
                        f = str2;
                        e = sharedTbsCoreVersion;
                        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                        if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            writeProperties(context, Integer.toString(e), f, d, Integer.toString(b.b(context)));
                            return;
                        }
                        e = 0;
                        d = null;
                        f = null;
                    }
                }
                if (TbsPVConfig.getInstance(a).isDisableHostBackupCore()) {
                    return;
                }
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    for (String str3 : coreProviderAppList) {
                        int backupCoreVersion = getBackupCoreVersion(context, str3);
                        if (backupCoreVersion < h2 || backupCoreVersion < i2 || backupCoreVersion <= 0) {
                            int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                            if (backupDecoupleCoreVersion >= h2 && backupDecoupleCoreVersion >= i2 && backupDecoupleCoreVersion > 0) {
                                TbsLog.i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + backupDecoupleCoreVersion + " packageName is " + str3);
                                m.a().a(context, getBackupCoreFile(context, str3), backupDecoupleCoreVersion);
                                TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                                return;
                            }
                        } else {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + backupCoreVersion + " packageName is " + str3);
                            m.a().a(context, getBackupCoreFile(context, str3), backupCoreVersion);
                            TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                            return;
                        }
                    }
                    return;
                }
                TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
                return;
            }
            d = c;
            f = "AppDefined";
            e = a2;
            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
            writeProperties(context, Integer.toString(e), f, d, Integer.toString(1));
        } catch (Exception unused) {
        }
    }

    public static File getTbsShareFile(Context context, String str) {
        File r = m.a().r(context);
        if (r == null) {
            return null;
        }
        File file = new File(r, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static boolean i(Context context) {
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            int i2 = e;
            if (i2 == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                return false;
            }
            if (c == null) {
                if (i2 != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    return true;
                }
            } else if (i2 != 0 && m.a().a(c) == e) {
                return true;
            }
            if (l(context)) {
                return true;
            }
            TbsCoreLoadStat instance = TbsCoreLoadStat.getInstance();
            instance.a(context, TbsListener.ErrorCode.INFO_CORE_EXIST_NOT_LOAD, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            d = null;
            e = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            return false;
        }
    }

    static boolean j(Context context) {
        return b(context, true);
    }

    static boolean b(Context context, boolean z) {
        if (i(context)) {
            return true;
        }
        if (!z) {
            return false;
        }
        QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        return false;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                    TbsLog.i("TbsShareManager", "gray no core app,skip get context");
                    return null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }
}
