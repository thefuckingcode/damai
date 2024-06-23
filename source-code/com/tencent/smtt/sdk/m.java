package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.p;
import com.tencent.smtt.utils.q;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* access modifiers changed from: package-private */
/* compiled from: TbsInstaller */
public class m {
    public static ThreadLocal<Integer> a = new ThreadLocal<Integer>() {
        /* class com.tencent.smtt.sdk.m.AnonymousClass1 */

        /* renamed from: a */
        public Integer initialValue() {
            return 0;
        }
    };
    static boolean b = false;
    static final FileFilter c = new FileFilter() {
        /* class com.tencent.smtt.sdk.m.AnonymousClass2 */

        public boolean accept(File file) {
            String name = file.getName();
            if (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21 && name.endsWith(".dex")) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26 && name.endsWith(".prof")) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 26 || !name.equals("oat")) {
                return true;
            }
            return false;
        }
    };
    private static m d;
    private static final ReentrantLock i = new ReentrantLock();
    private static final Lock j = new ReentrantLock();
    private static FileLock l = null;
    private static Handler m = null;
    private static final Long[][] n = {new Long[]{44006L, 39094008L}, new Long[]{44005L, 39094008L}, new Long[]{43910L, 38917816L}, new Long[]{44027L, 39094008L}, new Long[]{44028L, 39094008L}, new Long[]{44029L, 39094008L}, new Long[]{44030L, 39094008L}, new Long[]{44032L, 39094008L}, new Long[]{44033L, 39094008L}, new Long[]{44034L, 39094008L}, new Long[]{43909L, 38917816L}};
    private static int o = 0;
    private static boolean p = false;
    private int e = 0;
    private FileLock f;
    private FileOutputStream g;
    private boolean h = false;
    private boolean k = false;

    public boolean a(Context context, File[] fileArr) {
        return false;
    }

    private m() {
        if (m == null) {
            m = new Handler(l.a().getLooper()) {
                /* class com.tencent.smtt.sdk.m.AnonymousClass3 */

                public void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    int i = message.what;
                    if (i == 1) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                        Object[] objArr = (Object[]) message.obj;
                        m.this.b((m) ((Context) objArr[0]), (Context) ((String) objArr[1]), (String) ((Integer) objArr[2]).intValue());
                    } else if (i == 2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                        Object[] objArr2 = (Object[]) message.obj;
                        m.this.a((m) ((Context) objArr2[0]), (Context) objArr2[1], (Context) ((Integer) objArr2[2]).intValue());
                    } else if (i == 3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                        Object[] objArr3 = (Object[]) message.obj;
                        m.this.b((Context) objArr3[0], (Bundle) objArr3[1]);
                    } else if (i == 4) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                        Object[] objArr4 = (Object[]) message.obj;
                        m.this.b((Context) objArr4[0], (File) objArr4[1], ((Integer) objArr4[2]).intValue());
                        QbSdk.setTBSInstallingStatus(false);
                        super.handleMessage(message);
                    }
                }
            };
        }
    }

    static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (d == null) {
                synchronized (m.class) {
                    if (d == null) {
                        d = new m();
                    }
                }
            }
            mVar = d;
        }
        return mVar;
    }

    public int a(boolean z, Context context) {
        if (z || a.get().intValue() <= 0) {
            a.set(Integer.valueOf(i(context)));
        }
        return a.get().intValue();
    }

    private synchronized boolean c(Context context, boolean z) {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
        boolean z2 = false;
        try {
            if (!t(context)) {
                return false;
            }
            ReentrantLock reentrantLock = i;
            boolean tryLock = reentrantLock.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + tryLock);
            if (tryLock) {
                try {
                    int b2 = k.a(context).b("tpatch_status");
                    int a2 = a(false, context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + b2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + a2);
                    if (b2 == 1) {
                        if (a2 == 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                            y(context);
                        } else if (z) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                            y(context);
                        }
                        z2 = true;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    i.unlock();
                    throw th;
                }
            }
            b();
            return z2;
        } catch (Throwable th2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, th2.toString());
            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(th2));
        }
    }

    private synchronized boolean d(Context context, boolean z) {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
        boolean z2 = false;
        try {
            if (!t(context)) {
                return false;
            }
            ReentrantLock reentrantLock = i;
            boolean tryLock = reentrantLock.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
            if (tryLock) {
                try {
                    int b2 = k.a(context).b("copy_status");
                    int a2 = a(false, context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + b2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + a2);
                    if (b2 == 1) {
                        if (a2 == 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                            z(context);
                        } else if (z) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                            z(context);
                        }
                        z2 = true;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    i.unlock();
                    throw th;
                }
            }
            b();
            return z2;
        } catch (Throwable th2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, th2.toString());
            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th2));
        }
    }

    private synchronized boolean e(Context context, boolean z) {
        if (context != null) {
            if (TbsConfig.APP_WX.equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INSTALL_FROM_UNZIP, " ");
            }
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
        TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
        boolean z2 = false;
        try {
            if (!t(context)) {
                return false;
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
            ReentrantLock reentrantLock = i;
            boolean tryLock = reentrantLock.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
            if (tryLock) {
                try {
                    int c2 = k.a(context).c();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + c2);
                    int a2 = a(false, context);
                    if (c2 == 2) {
                        TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                        if (a2 == 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                            x(context);
                        } else if (z) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                            x(context);
                        }
                        z2 = true;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    i.unlock();
                    throw th;
                }
            }
            b();
            return z2;
        } catch (Exception e2) {
            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e2);
            e2.printStackTrace();
        }
    }

    private synchronized boolean f(Context context, boolean z) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        boolean z2 = true;
        if (z) {
            this.k = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (t(context)) {
            ReentrantLock reentrantLock = i;
            if (reentrantLock.tryLock()) {
                try {
                    i2 = k.a(context).c();
                    i5 = k.a(context).b();
                    str = k.a(context).d("install_apk_path");
                    i4 = k.a(context).c("copy_core_ver");
                    i3 = k.a(context).b("copy_status");
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    i.unlock();
                    throw th;
                }
            } else {
                str = null;
                i2 = -1;
                i5 = 0;
                i4 = 0;
                i3 = -1;
            }
            b();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + i2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + i5);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + i4);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i3);
            if (TbsShareManager.isThirdPartyApp(context)) {
                c(context, TbsShareManager.a(context, false));
                return;
            }
            int i6 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            if (!(i6 == 1 || i6 == 2 || i6 == 4)) {
                z2 = false;
            }
            if (!(z2 || i6 == 0 || i6 == 5)) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (i2 > -1 && i2 < 2) {
                a(context, str, i5);
            }
            if (i3 == 0) {
                b(context, i4);
            }
        }
    }

    public static void a(Context context) {
        if (v(context)) {
            return;
        }
        if (a(context, "core_unzip_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
            TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
        } else if (a(context, "core_share_backup_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
            TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        } else if (a(context, "core_copy_tmp")) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
            TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context, boolean z) {
        if (!QbSdk.b) {
            if (Build.VERSION.SDK_INT < 8) {
                TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
            if (TbsShareManager.isThirdPartyApp(context) && k.a(context).b("remove_old_core") == 1 && z) {
                try {
                    f.b(a().q(context));
                    TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                k.a(context).a("remove_old_core", 0);
            }
            if (v(context)) {
                TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
                if (a(context, "core_unzip_tmp") && e(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                } else if (a(context, "core_share_backup_tmp") && f(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
                } else if (a(context, "core_copy_tmp") && d(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
                } else if (a(context, "tpatch_tmp") && c(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
                } else {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                }
            }
        }
    }

    static boolean a(Context context, String str) {
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
            return false;
        } else if (!new File(file, "tbs.conf").exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
            return false;
        } else {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str, int i2) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object[] objArr = {context, str, Integer.valueOf(i2)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        m.sendMessage(message);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0497 A[SYNTHETIC, Splitter:B:150:0x0497] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x064f  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0675  */
    /* JADX WARNING: Removed duplicated region for block: B:270:? A[RETURN, SYNTHETIC] */
    private void b(Context context, String str, int i2) {
        SharedPreferences sharedPreferences;
        boolean z;
        Throwable th;
        Throwable th2;
        boolean z2;
        String str2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        SharedPreferences sharedPreferences2;
        String str3;
        String str4;
        boolean z4;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (c(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
        }
        if (sharedPreferences.getInt("tbs_precheck_disable_version", -1) == i2) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i2 + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
        } else if (!f.b(context)) {
            long a2 = q.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            TbsLogReport instance = TbsLogReport.getInstance(context);
            instance.setInstallErrorCode(TbsListener.ErrorCode.ROM_NOT_ENOUGH, "rom is not enough when installing tbs core! curAvailROM=" + a2 + ",minReqRom=" + downloadMinFreeSpace);
        } else if (!t(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
        } else {
            Lock lock = j;
            boolean tryLock = lock.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
            if (tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
                ReentrantLock reentrantLock = i;
                reentrantLock.lock();
                try {
                    int c2 = k.a(context).c("copy_core_ver");
                    int b2 = k.a(context).b();
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + c2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + b2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i2);
                    if ((b2 > 0 && i2 > b2) || (c2 > 0 && i2 > c2)) {
                        try {
                            o(context);
                        } catch (Throwable th3) {
                            th2 = th3;
                        }
                    }
                    int c3 = k.a(context).c();
                    int i6 = i(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + c3);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + i6);
                    if (c3 < 0 || c3 >= 2) {
                        if (c3 == 3 && i6 >= 0 && (i2 > i6 || i2 == 88888888)) {
                            o(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                            c3 = -1;
                        }
                        z2 = false;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        z2 = true;
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + c3);
                    if (c3 < 1) {
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                        if (z2) {
                            int c4 = k.a(context).c("unzip_retry_num");
                            if (c4 > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_UNZIP_RETRY_NUM, "exceed unzip retry num!");
                                E(context);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                                try {
                                    reentrantLock.unlock();
                                    lock.unlock();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                try {
                                    b();
                                    return;
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            } else {
                                k.a(context).b(c4 + 1);
                            }
                        }
                        if (str == null) {
                            str4 = k.a(context).d("install_apk_path");
                            if (str4 == null) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_PATH_ERROR, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                try {
                                    reentrantLock.unlock();
                                    lock.unlock();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                                try {
                                    b();
                                    return;
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    return;
                                }
                            }
                        } else {
                            str4 = str;
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + str4);
                        i3 = c(context, str4);
                        if (i3 == 0) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_VERSION_ERROR, "apk version is 0!");
                            try {
                                reentrantLock.unlock();
                                lock.unlock();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                            try {
                                b();
                                return;
                            } catch (Exception e7) {
                                e7.printStackTrace();
                                return;
                            }
                        } else {
                            k.a(context).a("install_apk_path", str4);
                            k.a(context).c(i3, 0);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                            str2 = "tbs_preloadx5_check_cfg_file";
                            if (TbsDownloader.a(context)) {
                                if (!a(context, new File(str4), true)) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_OTHER_ERROR, "unzipTbsApk failed", TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
                                    try {
                                        reentrantLock.unlock();
                                        lock.unlock();
                                    } catch (Exception e8) {
                                        e8.printStackTrace();
                                    }
                                    try {
                                        b();
                                        return;
                                    } catch (Exception e9) {
                                        e9.printStackTrace();
                                        return;
                                    }
                                }
                            } else if (!a(context, new File(str4))) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_OTHER_ERROR, "unzipTbsApk failed");
                                try {
                                    reentrantLock.unlock();
                                    lock.unlock();
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                                try {
                                    b();
                                    return;
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    return;
                                }
                            }
                            if (z2) {
                                int b3 = k.a(context).b("unlzma_status");
                                if (b3 > 5) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, "exceed unlzma retry num!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                                    E(context);
                                    j.c(context);
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, true);
                                    TbsDownloadConfig.getInstance(context).commit();
                                    try {
                                        reentrantLock.unlock();
                                        lock.unlock();
                                    } catch (Exception e12) {
                                        e12.printStackTrace();
                                    }
                                    try {
                                        b();
                                        return;
                                    } catch (Exception e13) {
                                        e13.printStackTrace();
                                        return;
                                    }
                                } else {
                                    k.a(context).d(b3 + 1);
                                }
                            }
                            TbsLog.i("TbsInstaller", "unlzma begin");
                            int i7 = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                            if (i(context) != 0) {
                                Object a3 = QbSdk.a(context, "can_unlzma", (Bundle) null);
                                if ((a3 == null || !(a3 instanceof Boolean)) ? false : ((Boolean) a3).booleanValue()) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("responseCode", i7);
                                    if (TbsDownloader.a(context)) {
                                        bundle.putString("unzip_temp_path", p(context).getAbsolutePath());
                                    } else {
                                        bundle.putString("unzip_temp_path", f(context, 0).getAbsolutePath());
                                    }
                                    Object a4 = QbSdk.a(context, "unlzma", bundle);
                                    if (a4 == null) {
                                        TbsLog.i("TbsInstaller", "unlzma return null");
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma is null");
                                    } else {
                                        if (a4 instanceof Boolean) {
                                            if (((Boolean) a4).booleanValue()) {
                                                TbsLog.i("TbsInstaller", "unlzma success");
                                            } else {
                                                TbsLog.i("TbsInstaller", "unlzma return false");
                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma return false");
                                            }
                                        } else if (!(a4 instanceof Bundle)) {
                                            if (a4 instanceof Throwable) {
                                                TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) a4));
                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, (Throwable) a4);
                                            }
                                        }
                                        z4 = true;
                                        if (!z4) {
                                            try {
                                                reentrantLock.unlock();
                                                lock.unlock();
                                            } catch (Exception e14) {
                                                e14.printStackTrace();
                                            }
                                            try {
                                                b();
                                                return;
                                            } catch (Exception e15) {
                                                e15.printStackTrace();
                                                return;
                                            }
                                        }
                                    }
                                    z4 = false;
                                    if (!z4) {
                                    }
                                }
                            }
                            TbsLog.i("TbsInstaller", "unlzma finished");
                            k.a(context).c(i3, 1);
                            i4 = 2;
                        }
                    } else {
                        str2 = "tbs_preloadx5_check_cfg_file";
                        if (TbsDownloader.a(context)) {
                            if (str == null) {
                                str3 = k.a(context).d("install_apk_path");
                                if (str3 == null) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_PATH_ERROR, "apk path is null!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                    try {
                                        reentrantLock.unlock();
                                        lock.unlock();
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                    }
                                    try {
                                        b();
                                        return;
                                    } catch (Exception e17) {
                                        e17.printStackTrace();
                                        return;
                                    }
                                }
                            } else {
                                str3 = str;
                            }
                            a(context, new File(str3), true);
                        }
                        i4 = 2;
                        i3 = 0;
                    }
                    if (c3 < i4) {
                        if (z2) {
                            int c5 = k.a(context).c("dexopt_retry_num");
                            if (c5 > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, "exceed dexopt retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                                E(context);
                                try {
                                    reentrantLock.unlock();
                                    lock.unlock();
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                }
                                try {
                                    b();
                                    return;
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                    return;
                                }
                            } else {
                                k.a(context).a(c5 + 1);
                            }
                        }
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                        if (!j(context, 0)) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                            try {
                                reentrantLock.unlock();
                                lock.unlock();
                            } catch (Exception e20) {
                                e20.printStackTrace();
                            }
                            try {
                                b();
                                return;
                            } catch (Exception e21) {
                                e21.printStackTrace();
                                return;
                            }
                        } else {
                            k.a(context).c(i3, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i2);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                            if (Build.VERSION.SDK_INT >= 11) {
                                sharedPreferences2 = context.getSharedPreferences(str2, 4);
                                i5 = 0;
                            } else {
                                i5 = 0;
                                sharedPreferences2 = context.getSharedPreferences(str2, 0);
                            }
                            try {
                                SharedPreferences.Editor edit = sharedPreferences2.edit();
                                edit.putInt("tbs_preload_x5_counter", i5);
                                edit.putInt("tbs_preload_x5_recorder", i5);
                                edit.putInt("tbs_preload_x5_version", i2);
                                edit.commit();
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                            } catch (Throwable th4) {
                                TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(th4));
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-518);
                            }
                            if (i2 == 88888888) {
                                a(i2, str, context);
                            }
                            if (this.k) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(u(context), "continueInstallWithout core success");
                            } else {
                                TbsLogReport.getInstance(context).setInstallErrorCode(u(context), "success");
                            }
                        }
                    } else if (c3 == i4) {
                        try {
                            QbSdk.m.onInstallFinish(200);
                        } catch (Throwable th5) {
                            th = th5;
                            z = true;
                            try {
                                i.unlock();
                                j.unlock();
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                            try {
                                b();
                            } catch (Exception e23) {
                                e23.printStackTrace();
                            }
                            if (z) {
                                QbSdk.m.onInstallFinish(TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK);
                            }
                            throw th;
                        }
                    } else {
                        z3 = false;
                        i.unlock();
                        j.unlock();
                        b();
                        if (!z3) {
                            QbSdk.m.onInstallFinish(TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK);
                            return;
                        }
                        return;
                    }
                    z3 = true;
                    try {
                        i.unlock();
                        j.unlock();
                    } catch (Exception e24) {
                        e24.printStackTrace();
                    }
                    try {
                        b();
                    } catch (Exception e25) {
                        e25.printStackTrace();
                    }
                    if (!z3) {
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    th = th2;
                    z = false;
                    i.unlock();
                    j.unlock();
                    b();
                    if (z) {
                    }
                    throw th;
                }
            } else {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
                b();
            }
        }
    }

    private int u(Context context) {
        boolean z = true;
        if (k.a(context).d() != 1) {
            z = false;
        }
        boolean a2 = TbsDownloader.a(context);
        if (z) {
            return a2 ? TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS : TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        }
        if (a2) {
            return TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        }
        return 200;
    }

    public void b(Context context) {
        g(context, true);
        k.a(context).c(h(context), 2);
    }

    public void a(Context context, int i2) {
        g(context, true);
        k.a(context).c(i2, 2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080 A[SYNTHETIC, Splitter:B:28:0x0080] */
    public boolean c(Context context) {
        Throwable th;
        File file = new File(q(context), "tbs.conf");
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                boolean booleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                if (booleanValue) {
                    try {
                        if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                            z = true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = booleanValue;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                            return z;
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
                TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z);
                boolean z2 = booleanValue & (!z);
                try {
                    bufferedInputStream2.close();
                    return z2;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return z2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                th.printStackTrace();
                return z;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return z;
        }
    }

    private static boolean v(Context context) {
        if (context == null) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
            return true;
        }
        try {
            if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                return true;
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
            return false;
        } catch (Exception unused) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
            return true;
        }
    }

    private void g(Context context, boolean z) {
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z) {
                f.b(file);
            } else if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e2) {
            TbsLogReport instance = TbsLogReport.getInstance(context);
            instance.setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead Exception message is " + e2.getMessage() + " Exception cause is " + e2.getCause());
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0035 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public void d(Context context) {
        BufferedInputStream bufferedInputStream;
        File file = new File(q(context), "tbs.conf");
        Properties properties = new Properties();
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    properties.setProperty("tbs_local_installation", "false");
                    properties.store(bufferedOutputStream2, (String) null);
                    bufferedOutputStream2.close();
                } catch (Throwable unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (bufferedInputStream == null) {
                        return;
                    }
                    bufferedInputStream.close();
                }
            } catch (Throwable unused3) {
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream == null) {
                }
                bufferedInputStream.close();
            }
        } catch (Throwable unused4) {
            bufferedInputStream = null;
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream == null) {
            }
            bufferedInputStream.close();
        }
        try {
            bufferedInputStream.close();
        } catch (Throwable unused5) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[SYNTHETIC, Splitter:B:24:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    private void a(int i2, String str, Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        new File(str).delete();
        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        properties.setProperty("tbs_local_installation", "true");
                        properties.store(bufferedOutputStream2, (String) null);
                        TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            th.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } catch (Throwable th3) {
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th.printStackTrace();
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
                th.printStackTrace();
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(Context context, int i2) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        Context d2 = d(context, i2);
        if (d2 != null) {
            Object[] objArr = {d2, context, Integer.valueOf(i2)};
            Message message = new Message();
            message.what = 2;
            message.obj = objArr;
            m.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, Bundle bundle) {
        if (bundle != null && context != null) {
            Object[] objArr = {context, bundle};
            Message message = new Message();
            message.what = 3;
            message.obj = objArr;
            m.sendMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, File file, int i2) {
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + context + "File=" + file + "coreVersion=" + i2);
        if (file != null && context != null) {
            Object[] objArr = {context, file, Integer.valueOf(i2)};
            Message message = new Message();
            message.what = 4;
            message.obj = objArr;
            m.sendMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x05ae  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x05b2  */
    public void b(Context context, Bundle bundle) {
        String str;
        Throwable th;
        String str2;
        String str3;
        int i2;
        String str4;
        Bundle bundle2;
        Bundle bundle3;
        Exception e2;
        Throwable th2;
        Throwable th3;
        String str5;
        String str6;
        String str7;
        String str8;
        Bundle bundle4;
        Bundle bundle5;
        Throwable th4;
        TbsLogReport instance;
        StringBuilder sb;
        TbsLog.i("TbsInstaller", "TbsInstaller installLocalTbsCoreExInThreadthread " + Thread.currentThread().getName() + Log.getStackTraceString(new Throwable()));
        if (c(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle != null && context != null) {
            if (!f.b(context)) {
                long a2 = q.a();
                long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.ROM_NOT_ENOUGH, "rom is not enough when patching tbs core! curAvailROM=" + a2 + ",minReqRom=" + downloadMinFreeSpace);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            } else if (!t(context)) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            } else {
                Lock lock = j;
                boolean tryLock = lock.tryLock();
                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + tryLock);
                if (tryLock) {
                    int i3 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                    try {
                        QbSdk.setTBSInstallingStatus(true);
                        if (i3 == 5) {
                            try {
                                int c2 = c(context, bundle);
                                if (c2 == 1) {
                                    try {
                                        k.a(context).a("tpatch_num", k.a(context).c("tpatch_num") + 1);
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                        str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                        i2 = c2;
                                        str = "incrUpdate fail! patch ret=";
                                        str2 = "decouple incrUpdate fail! patch ret=";
                                    } catch (Throwable th5) {
                                        th = th5;
                                        str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                        str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                        i2 = c2;
                                        str = "incrUpdate fail! patch ret=";
                                        str2 = "decouple incrUpdate fail! patch ret=";
                                        bundle2 = null;
                                        j.unlock();
                                        b();
                                        if (i3 == 5) {
                                        }
                                    }
                                }
                                lock.unlock();
                                b();
                                if (i3 == 5) {
                                    h(context, c2);
                                    return;
                                }
                                if (c2 == 0) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                    k.a(context).a("incrupdate_retry_num", 0);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                    k.a(context).c(0, -1);
                                    k.a(context).c(1);
                                    Bundle bundle6 = null;
                                    String string = bundle6.getString("apk_path");
                                    j.a(new File(string), context);
                                    b(context, string, bundle6.getInt("tbs_core_ver"));
                                    if (TbsDownloader.a(context)) {
                                        k.a(context).c(-1);
                                    }
                                } else if (c2 == 2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                } else {
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                                    TbsDownloadConfig.getInstance(context).commit();
                                    if (TbsDownloader.a(context)) {
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, "decouple incrUpdate fail! patch ret=" + c2);
                                    } else {
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_FAIL, "incrUpdate fail! patch ret=" + c2);
                                    }
                                }
                                QbSdk.setTBSInstallingStatus(false);
                            } catch (Exception e4) {
                                e2 = e4;
                                bundle3 = null;
                                str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                str = "incrUpdate fail! patch ret=";
                                str2 = "decouple incrUpdate fail! patch ret=";
                                i2 = 2;
                                try {
                                    StringBuilder sb2 = new StringBuilder();
                                    try {
                                        sb2.append("installLocalTbsCoreExInThread exception:");
                                        sb2.append(Log.getStackTraceString(e2));
                                        TbsLog.i("TbsInstaller", sb2.toString());
                                        e2.printStackTrace();
                                    } catch (Throwable th6) {
                                        th2 = th6;
                                        i2 = i2;
                                        th = th2;
                                        bundle2 = bundle3;
                                        j.unlock();
                                        b();
                                        if (i3 == 5) {
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    th = th2;
                                    bundle2 = bundle3;
                                    j.unlock();
                                    b();
                                    if (i3 == 5) {
                                    }
                                }
                                try {
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                    j.unlock();
                                    b();
                                    if (i3 != 5) {
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    bundle2 = bundle3;
                                    i2 = 1;
                                    j.unlock();
                                    b();
                                    if (i3 == 5) {
                                    }
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                bundle2 = null;
                                str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                str = "incrUpdate fail! patch ret=";
                                str2 = "decouple incrUpdate fail! patch ret=";
                                i2 = 2;
                                j.unlock();
                                b();
                                if (i3 == 5) {
                                }
                            }
                        } else {
                            str = "incrUpdate fail! patch ret=";
                            try {
                                if (i(context) <= 0 || k.a(context).d() == 1) {
                                    str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                    str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                    str2 = "decouple incrUpdate fail! patch ret=";
                                    try {
                                        QbSdk.setTBSInstallingStatus(false);
                                        lock.unlock();
                                        b();
                                        if (i3 == 5) {
                                            h(context, 2);
                                            return;
                                        }
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                        QbSdk.setTBSInstallingStatus(false);
                                    } catch (Exception e5) {
                                        e2 = e5;
                                        i2 = 2;
                                        bundle3 = null;
                                        StringBuilder sb22 = new StringBuilder();
                                        sb22.append("installLocalTbsCoreExInThread exception:");
                                        sb22.append(Log.getStackTraceString(e2));
                                        TbsLog.i("TbsInstaller", sb22.toString());
                                        e2.printStackTrace();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                        j.unlock();
                                        b();
                                        if (i3 != 5) {
                                        }
                                    } catch (Throwable th10) {
                                        th3 = th10;
                                        th = th3;
                                        bundle2 = null;
                                        i2 = 2;
                                        j.unlock();
                                        b();
                                        if (i3 == 5) {
                                        }
                                    }
                                } else {
                                    if ((i3 == 1 || i3 == 2 || i3 == 4) || i3 == 0) {
                                        str7 = "decouple incrUpdate fail! patch ret=";
                                        str5 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                        str6 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                        str8 = str;
                                    } else {
                                        try {
                                            int c3 = k.a(context).c("incrupdate_retry_num");
                                            if (c3 > 5) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                                String string2 = bundle.getString("old_apk_location");
                                                try {
                                                    String string3 = bundle.getString("new_apk_location");
                                                    try {
                                                        String string4 = bundle.getString("diff_file_location");
                                                        if (!TextUtils.isEmpty(string2)) {
                                                            f.b(new File(string2));
                                                        }
                                                        if (!TextUtils.isEmpty(string3)) {
                                                            f.b(new File(string3));
                                                        }
                                                        if (!TextUtils.isEmpty(string4)) {
                                                            f.b(new File(string4));
                                                        }
                                                        TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                                                        TbsDownloadConfig.getInstance(context).commit();
                                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, "incrUpdate exceed retry max num");
                                                        lock.unlock();
                                                        b();
                                                        if (i3 == 5) {
                                                            h(context, 2);
                                                            return;
                                                        }
                                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                        QbSdk.setTBSInstallingStatus(false);
                                                        return;
                                                    } catch (Exception e6) {
                                                        e2 = e6;
                                                        str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                        str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                        str = str;
                                                        str2 = "decouple incrUpdate fail! patch ret=";
                                                        i2 = 2;
                                                        bundle3 = null;
                                                        StringBuilder sb222 = new StringBuilder();
                                                        sb222.append("installLocalTbsCoreExInThread exception:");
                                                        sb222.append(Log.getStackTraceString(e2));
                                                        TbsLog.i("TbsInstaller", sb222.toString());
                                                        e2.printStackTrace();
                                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                        j.unlock();
                                                        b();
                                                        if (i3 != 5) {
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                        str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                        str = str;
                                                        str2 = "decouple incrUpdate fail! patch ret=";
                                                        bundle2 = null;
                                                        i2 = 2;
                                                        j.unlock();
                                                        b();
                                                        if (i3 == 5) {
                                                        }
                                                    }
                                                } catch (Exception e7) {
                                                    e2 = e7;
                                                    str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                    str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                    str = str;
                                                    bundle3 = null;
                                                    str2 = "decouple incrUpdate fail! patch ret=";
                                                    i2 = 2;
                                                    StringBuilder sb2222 = new StringBuilder();
                                                    sb2222.append("installLocalTbsCoreExInThread exception:");
                                                    sb2222.append(Log.getStackTraceString(e2));
                                                    TbsLog.i("TbsInstaller", sb2222.toString());
                                                    e2.printStackTrace();
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                    j.unlock();
                                                    b();
                                                    if (i3 != 5) {
                                                    }
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                    str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                    str = str;
                                                    bundle2 = null;
                                                    str2 = "decouple incrUpdate fail! patch ret=";
                                                    i2 = 2;
                                                    j.unlock();
                                                    b();
                                                    if (i3 == 5) {
                                                    }
                                                }
                                            } else {
                                                str7 = "decouple incrUpdate fail! patch ret=";
                                                str8 = str;
                                                k.a(context).a("incrupdate_retry_num", c3 + 1);
                                                File s = s(context);
                                                if (s == null || !new File(s, "x5.tbs").exists()) {
                                                    str5 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                    str6 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                } else {
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                                    bundle4 = QbSdk.a(context, bundle);
                                                    if (bundle4 == null) {
                                                        try {
                                                            instance = TbsLogReport.getInstance(context);
                                                            str6 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                            try {
                                                                sb = new StringBuilder();
                                                                str5 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                            } catch (Exception e8) {
                                                                e2 = e8;
                                                                str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                                bundle3 = bundle4;
                                                                str = str8;
                                                                str2 = str7;
                                                                str3 = str6;
                                                                i2 = 1;
                                                                StringBuilder sb22222 = new StringBuilder();
                                                                sb22222.append("installLocalTbsCoreExInThread exception:");
                                                                sb22222.append(Log.getStackTraceString(e2));
                                                                TbsLog.i("TbsInstaller", sb22222.toString());
                                                                e2.printStackTrace();
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                                j.unlock();
                                                                b();
                                                                if (i3 != 5) {
                                                                }
                                                            } catch (Throwable th13) {
                                                                th = th13;
                                                                str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                                bundle2 = bundle4;
                                                                str = str8;
                                                                str2 = str7;
                                                                str3 = str6;
                                                                i2 = 1;
                                                                j.unlock();
                                                                b();
                                                                if (i3 == 5) {
                                                                }
                                                            }
                                                        } catch (Exception e9) {
                                                            e2 = e9;
                                                            str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                            str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                            bundle3 = bundle4;
                                                            str = str8;
                                                            str2 = str7;
                                                            i2 = 1;
                                                            StringBuilder sb222222 = new StringBuilder();
                                                            sb222222.append("installLocalTbsCoreExInThread exception:");
                                                            sb222222.append(Log.getStackTraceString(e2));
                                                            TbsLog.i("TbsInstaller", sb222222.toString());
                                                            e2.printStackTrace();
                                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                            j.unlock();
                                                            b();
                                                            if (i3 != 5) {
                                                            }
                                                        } catch (Throwable th14) {
                                                            th = th14;
                                                            str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                            str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                            bundle2 = bundle4;
                                                            str = str8;
                                                            str2 = str7;
                                                            i2 = 1;
                                                            j.unlock();
                                                            b();
                                                            if (i3 == 5) {
                                                            }
                                                        }
                                                        try {
                                                            sb.append("result null : ");
                                                            sb.append(bundle.getInt("new_core_ver"));
                                                            instance.setInstallErrorCode(TbsListener.ErrorCode.INCR_ERROR_DETAIL, sb.toString());
                                                            i2 = 1;
                                                            lock.unlock();
                                                            b();
                                                            if (i3 == 5) {
                                                                h(context, i2);
                                                                return;
                                                            }
                                                            if (i2 == 0) {
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                                k.a(context).a("incrupdate_retry_num", 0);
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                                k.a(context).c(0, -1);
                                                                k.a(context).c(1);
                                                                String string5 = bundle4.getString("apk_path");
                                                                j.a(new File(string5), context);
                                                                b(context, string5, bundle4.getInt("tbs_core_ver"));
                                                                if (TbsDownloader.a(context)) {
                                                                    k.a(context).c(-1);
                                                                }
                                                            } else if (i2 == 2) {
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                            } else {
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                                TbsLog.i("TbsInstaller", str5);
                                                                TbsDownloadConfig.getInstance(context).mSyncMap.put(str6, true);
                                                                TbsDownloadConfig.getInstance(context).commit();
                                                                if (TbsDownloader.a(context)) {
                                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, str7 + i2);
                                                                } else {
                                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_FAIL, str8 + i2);
                                                                }
                                                            }
                                                            QbSdk.setTBSInstallingStatus(false);
                                                            return;
                                                        } catch (Exception e10) {
                                                            e2 = e10;
                                                            bundle3 = bundle4;
                                                            str = str8;
                                                            str2 = str7;
                                                            str3 = str6;
                                                            str4 = str5;
                                                            i2 = 1;
                                                            StringBuilder sb2222222 = new StringBuilder();
                                                            sb2222222.append("installLocalTbsCoreExInThread exception:");
                                                            sb2222222.append(Log.getStackTraceString(e2));
                                                            TbsLog.i("TbsInstaller", sb2222222.toString());
                                                            e2.printStackTrace();
                                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                            j.unlock();
                                                            b();
                                                            if (i3 != 5) {
                                                            }
                                                        } catch (Throwable th15) {
                                                            th = th15;
                                                            bundle2 = bundle4;
                                                            str = str8;
                                                            str2 = str7;
                                                            str3 = str6;
                                                            str4 = str5;
                                                            i2 = 1;
                                                            j.unlock();
                                                            b();
                                                            if (i3 == 5) {
                                                            }
                                                        }
                                                    } else {
                                                        str5 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                                        str6 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                                        try {
                                                            i2 = bundle4.getInt("patch_result");
                                                            if (i2 != 0) {
                                                                try {
                                                                    TbsLogReport instance2 = TbsLogReport.getInstance(context);
                                                                    StringBuilder sb3 = new StringBuilder();
                                                                    bundle5 = bundle4;
                                                                    try {
                                                                        sb3.append("result ");
                                                                        sb3.append(i2);
                                                                        sb3.append(" : ");
                                                                        sb3.append(bundle.getInt("new_core_ver"));
                                                                        instance2.setInstallErrorCode(TbsListener.ErrorCode.INCR_ERROR_DETAIL, sb3.toString());
                                                                    } catch (Exception e11) {
                                                                        e2 = e11;
                                                                    } catch (Throwable th16) {
                                                                        th4 = th16;
                                                                        th = th4;
                                                                        str = str8;
                                                                        str2 = str7;
                                                                        str3 = str6;
                                                                        str4 = str5;
                                                                        bundle2 = bundle5;
                                                                        j.unlock();
                                                                        b();
                                                                        if (i3 == 5) {
                                                                        }
                                                                    }
                                                                } catch (Exception e12) {
                                                                    e2 = e12;
                                                                    bundle5 = bundle4;
                                                                    str = str8;
                                                                    str2 = str7;
                                                                    str3 = str6;
                                                                    str4 = str5;
                                                                    bundle3 = bundle5;
                                                                    StringBuilder sb22222222 = new StringBuilder();
                                                                    sb22222222.append("installLocalTbsCoreExInThread exception:");
                                                                    sb22222222.append(Log.getStackTraceString(e2));
                                                                    TbsLog.i("TbsInstaller", sb22222222.toString());
                                                                    e2.printStackTrace();
                                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                                    j.unlock();
                                                                    b();
                                                                    if (i3 != 5) {
                                                                    }
                                                                } catch (Throwable th17) {
                                                                    th4 = th17;
                                                                    bundle5 = bundle4;
                                                                    th = th4;
                                                                    str = str8;
                                                                    str2 = str7;
                                                                    str3 = str6;
                                                                    str4 = str5;
                                                                    bundle2 = bundle5;
                                                                    j.unlock();
                                                                    b();
                                                                    if (i3 == 5) {
                                                                    }
                                                                }
                                                            } else {
                                                                bundle5 = bundle4;
                                                            }
                                                            bundle4 = bundle5;
                                                            lock.unlock();
                                                            b();
                                                            if (i3 == 5) {
                                                            }
                                                        } catch (Exception e13) {
                                                            e2 = e13;
                                                            str = str8;
                                                            str2 = str7;
                                                            str3 = str6;
                                                            str4 = str5;
                                                            bundle3 = bundle4;
                                                            i2 = 2;
                                                            StringBuilder sb222222222 = new StringBuilder();
                                                            sb222222222.append("installLocalTbsCoreExInThread exception:");
                                                            sb222222222.append(Log.getStackTraceString(e2));
                                                            TbsLog.i("TbsInstaller", sb222222222.toString());
                                                            e2.printStackTrace();
                                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                                            j.unlock();
                                                            b();
                                                            if (i3 != 5) {
                                                                h(context, 1);
                                                                return;
                                                            }
                                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                            TbsLog.i("TbsInstaller", str4);
                                                            TbsDownloadConfig.getInstance(context).mSyncMap.put(str3, true);
                                                            TbsDownloadConfig.getInstance(context).commit();
                                                            if (TbsDownloader.a(context)) {
                                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, str2 + 1);
                                                            } else {
                                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_FAIL, str + 1);
                                                            }
                                                            QbSdk.setTBSInstallingStatus(false);
                                                            return;
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            str = str8;
                                                            str2 = str7;
                                                            str3 = str6;
                                                            str4 = str5;
                                                            bundle2 = bundle4;
                                                            i2 = 2;
                                                            j.unlock();
                                                            b();
                                                            if (i3 == 5) {
                                                                h(context, i2);
                                                                return;
                                                            }
                                                            if (i2 == 0) {
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                                k.a(context).a("incrupdate_retry_num", 0);
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                                k.a(context).c(0, -1);
                                                                k.a(context).c(1);
                                                                String string6 = bundle2.getString("apk_path");
                                                                j.a(new File(string6), context);
                                                                b(context, string6, bundle2.getInt("tbs_core_ver"));
                                                                if (TbsDownloader.a(context)) {
                                                                    k.a(context).c(-1);
                                                                }
                                                            } else if (i2 != 2) {
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                                TbsLog.i("TbsInstaller", str4);
                                                                TbsDownloadConfig.getInstance(context).mSyncMap.put(str3, true);
                                                                TbsDownloadConfig.getInstance(context).commit();
                                                                if (TbsDownloader.a(context)) {
                                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, str2 + i2);
                                                                } else {
                                                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_FAIL, str + i2);
                                                                }
                                                            } else {
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                            }
                                                            QbSdk.setTBSInstallingStatus(false);
                                                            throw th;
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e14) {
                                            e2 = e14;
                                            str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                            str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                            bundle3 = null;
                                            str2 = "decouple incrUpdate fail! patch ret=";
                                            i2 = 2;
                                            StringBuilder sb2222222222 = new StringBuilder();
                                            sb2222222222.append("installLocalTbsCoreExInThread exception:");
                                            sb2222222222.append(Log.getStackTraceString(e2));
                                            TbsLog.i("TbsInstaller", sb2222222222.toString());
                                            e2.printStackTrace();
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                            j.unlock();
                                            b();
                                            if (i3 != 5) {
                                            }
                                        } catch (Throwable th19) {
                                            th = th19;
                                            str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                            str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                            bundle2 = null;
                                            str2 = "decouple incrUpdate fail! patch ret=";
                                            i2 = 2;
                                            j.unlock();
                                            b();
                                            if (i3 == 5) {
                                            }
                                        }
                                    }
                                    i2 = 2;
                                    bundle4 = null;
                                    lock.unlock();
                                    b();
                                    if (i3 == 5) {
                                    }
                                }
                            } catch (Exception e15) {
                                e2 = e15;
                                str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                str2 = "decouple incrUpdate fail! patch ret=";
                                i2 = 2;
                                bundle3 = null;
                                StringBuilder sb22222222222 = new StringBuilder();
                                sb22222222222.append("installLocalTbsCoreExInThread exception:");
                                sb22222222222.append(Log.getStackTraceString(e2));
                                TbsLog.i("TbsInstaller", sb22222222222.toString());
                                e2.printStackTrace();
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                                j.unlock();
                                b();
                                if (i3 != 5) {
                                }
                            } catch (Throwable th20) {
                                th3 = th20;
                                str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                str2 = "decouple incrUpdate fail! patch ret=";
                                th = th3;
                                bundle2 = null;
                                i2 = 2;
                                j.unlock();
                                b();
                                if (i3 == 5) {
                                }
                            }
                        }
                    } catch (Exception e16) {
                        e2 = e16;
                        str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                        str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                        str = "incrUpdate fail! patch ret=";
                        str2 = "decouple incrUpdate fail! patch ret=";
                        i2 = 2;
                        bundle3 = null;
                        StringBuilder sb222222222222 = new StringBuilder();
                        sb222222222222.append("installLocalTbsCoreExInThread exception:");
                        sb222222222222.append(Log.getStackTraceString(e2));
                        TbsLog.i("TbsInstaller", sb222222222222.toString());
                        e2.printStackTrace();
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e2.toString());
                        j.unlock();
                        b();
                        if (i3 != 5) {
                        }
                    } catch (Throwable th21) {
                        th3 = th21;
                        str4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                        str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                        str = "incrUpdate fail! patch ret=";
                        str2 = "decouple incrUpdate fail! patch ret=";
                        th = th3;
                        bundle2 = null;
                        i2 = 2;
                        j.unlock();
                        b();
                        if (i3 == 5) {
                        }
                    }
                } else {
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
                    b();
                }
            }
        }
    }

    private void h(Context context, int i2) {
        TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + i2);
        if (i2 == 0) {
            if (TbsDownloader.a(context)) {
                i(context, 6);
            } else {
                g(context, true);
                k.a(context).b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
            }
        }
        QbSdk.setTBSInstallingStatus(false);
    }

    private int c(Context context, Bundle bundle) {
        try {
            Bundle a2 = QbSdk.a(context, bundle);
            TbsLog.i("TbsInstaller", "tpatch finished,ret is" + a2);
            int i2 = a2.getInt("patch_result");
            if (i2 == 0) {
                String string = bundle.getString("new_apk_location");
                int i3 = bundle.getInt("new_core_ver");
                int a3 = a(new File(string));
                if (i3 != a3) {
                    TbsLog.i("TbsInstaller", "version not equals!!!" + i3 + "patchVersion:" + a3);
                    TbsLogReport instance = TbsLogReport.getInstance(context);
                    instance.setInstallErrorCode(240, "version=" + i3 + ",patchVersion=" + a3);
                    return 1;
                }
                File file = new File(bundle.getString("backup_apk"));
                String a4 = b.a(context, true, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(a4)) {
                    TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + file + "signature:" + a4);
                    TbsLogReport instance2 = TbsLogReport.getInstance(context);
                    instance2.setInstallErrorCode(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, "version=" + i3 + ",patchVersion=" + a3);
                    f.b(file);
                    return 0;
                }
                if (TbsDownloader.a(context)) {
                    TbsLog.i("TbsInstaller", "Tpatch decouple success!");
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, "");
                } else {
                    TbsLog.i("TbsInstaller", "Tpatch success!");
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, "");
                }
                return 0;
            }
            String string2 = bundle.getString("new_apk_location");
            if (!TextUtils.isEmpty(string2)) {
                f.b(new File(string2));
            }
            TbsLogReport instance3 = TbsLogReport.getInstance(context);
            instance3.setInstallErrorCode(i2, "tpatch fail,patch error_code=" + i2);
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport instance4 = TbsLogReport.getInstance(context);
            instance4.setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, "patch exception" + Log.getStackTraceString(e2));
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Context context, int i2) {
        int i3;
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i2 > 0 && (i3 = i(context)) != i2) {
            Context e2 = TbsShareManager.e(context);
            if (e2 != null || TbsShareManager.getHostCorePathAppDefined() != null) {
                TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                a(context, e2);
            } else if (i3 <= 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02cd, code lost:
        r3 = r0;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02d6, code lost:
        r1 = r0;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02e3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x04a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x04a3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02cc A[ExcHandler: all (r0v13 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:84:0x028e] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02de A[SYNTHETIC, Splitter:B:113:0x02de] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03b0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x049e A[SYNTHETIC, Splitter:B:170:0x049e] */
    private void a(Context context, Context context2, int i2) {
        SharedPreferences sharedPreferences;
        File file;
        Exception exc;
        File file2;
        Exception e2;
        p pVar;
        long currentTimeMillis;
        boolean a2;
        StringBuilder sb;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Properties properties;
        boolean z;
        boolean z2;
        File b2;
        SharedPreferences sharedPreferences2;
        int i3;
        Exception exc2;
        BufferedInputStream bufferedInputStream2;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-524);
        if (!c(context2)) {
            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is " + i2);
            if (Build.VERSION.SDK_INT >= 11) {
                sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
            } else {
                sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            }
            if (sharedPreferences.getInt("tbs_precheck_disable_version", -1) == i2) {
                TbsLog.e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i2 + " is disabled by preload_x5_check!");
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-525);
            } else if (!t(context2)) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-526);
            } else {
                Lock lock = j;
                boolean tryLock = lock.tryLock();
                TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread #1 locked is " + tryLock);
                if (tryLock) {
                    ReentrantLock reentrantLock = i;
                    reentrantLock.lock();
                    try {
                        int c2 = k.a(context2).c("copy_core_ver");
                        int b3 = k.a(context2).b("copy_status");
                        if (c2 == i2) {
                            QbSdk.m.onInstallFinish(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                            reentrantLock.unlock();
                            lock.unlock();
                            b();
                            return;
                        }
                        int i4 = i(context2);
                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=" + i4);
                        if (i4 == i2) {
                            QbSdk.m.onInstallFinish(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is " + i4);
                            reentrantLock.unlock();
                            lock.unlock();
                            b();
                            return;
                        }
                        int b4 = k.a(context2).b();
                        if ((b4 > 0 && i2 > b4) || (c2 > 0 && i2 > c2)) {
                            o(context2);
                        }
                        if (b3 == 3 && i4 > 0 && (i2 > i4 || i2 == 88888888)) {
                            o(context2);
                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                            b3 = -1;
                        }
                        if (!f.b(context2)) {
                            long a3 = q.a();
                            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context2).getDownloadMinFreeSpace();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-529);
                            TbsLogReport instance = TbsLogReport.getInstance(context2);
                            instance.setInstallErrorCode(TbsListener.ErrorCode.ROM_NOT_ENOUGH, "rom is not enough when copying tbs core! curAvailROM=" + a3 + ",minReqRom=" + downloadMinFreeSpace);
                            reentrantLock.unlock();
                            lock.unlock();
                            b();
                        } else if (b3 <= 0 || (!TbsShareManager.isThirdPartyApp(context2) && TbsDownloader.a(context2) && i2 != h(context2))) {
                            if (b3 == 0) {
                                int c3 = k.a(context2).c("copy_retry_num");
                                if (c3 > 2) {
                                    TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_COPY_RETRY_NUM, "exceed copy retry num!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-530);
                                    reentrantLock.unlock();
                                    lock.unlock();
                                    b();
                                    return;
                                }
                                k.a(context2).a("copy_retry_num", c3 + 1);
                            }
                            File q = q(context);
                            if (TbsShareManager.isThirdPartyApp(context2)) {
                                file2 = f(context2, 1);
                            } else if (TbsDownloader.a(context2)) {
                                file2 = p(context2);
                            } else {
                                file2 = f(context2, 1);
                            }
                            if (q == null || file2 == null) {
                                if (q == null) {
                                    TbsLogReport.getInstance(context2).setInstallErrorCode(213, "src-dir is null when copying tbs core!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-535);
                                }
                                if (file2 == null) {
                                    TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_TMPDIR_ERROR, "dst-dir is null when copying tbs core!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-536);
                                }
                                i.unlock();
                                j.unlock();
                                b();
                            }
                            try {
                                k.a(context2).a(i2, 0);
                                pVar = new p();
                                pVar.a(q);
                                currentTimeMillis = System.currentTimeMillis();
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-551);
                                a2 = f.a(q, file2, c);
                                if (TbsDownloader.a(context2)) {
                                    TbsShareManager.b(context2);
                                }
                                sb = new StringBuilder();
                                sb.append("TbsInstaller-copyTbsCoreInThread time=");
                            } catch (Exception e3) {
                                e2 = e3;
                                exc = e2;
                                file = file2;
                                try {
                                    TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, exc.toString());
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                                    try {
                                        f.a(file, false);
                                        k.a(context2).a(0, -1);
                                    } catch (Exception e4) {
                                        TbsLog.e("TbsInstaller", "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:" + e4.getMessage() + "," + e4.getCause());
                                    }
                                    i.unlock();
                                    j.unlock();
                                    b();
                                } catch (Throwable th2) {
                                    th = th2;
                                    i.unlock();
                                    j.unlock();
                                    b();
                                    throw th;
                                }
                            }
                            try {
                                sb.append(System.currentTimeMillis() - currentTimeMillis);
                                TbsLog.i("TbsInstaller", sb.toString());
                                if (a2) {
                                    pVar.b(q);
                                    if (!pVar.a()) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                                        f.a(file2, true);
                                        TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify fail after copying tbs core!");
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-531);
                                        reentrantLock.unlock();
                                        lock.unlock();
                                        b();
                                        return;
                                    }
                                    try {
                                        File file3 = new File(file2, "1");
                                        properties = new Properties();
                                        if (file3.exists()) {
                                            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                                            try {
                                                properties.load(bufferedInputStream3);
                                                bufferedInputStream2 = bufferedInputStream3;
                                                z = true;
                                            } catch (Exception e5) {
                                                bufferedInputStream = bufferedInputStream3;
                                                exc2 = e5;
                                                try {
                                                    exc2.printStackTrace();
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    z = true;
                                                    if (z) {
                                                    }
                                                    z2 = true;
                                                    TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                                    if (z) {
                                                    }
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                    g(context2, true);
                                                    b2 = j.b(context);
                                                    j.a(new File(b2, !TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)), context2);
                                                    k.a(context2).a(i2, 1);
                                                    if (!this.k) {
                                                    }
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i2);
                                                    if (Build.VERSION.SDK_INT < 11) {
                                                    }
                                                    try {
                                                        SharedPreferences.Editor edit = sharedPreferences2.edit();
                                                        edit.putInt("tbs_preload_x5_counter", i3);
                                                        edit.putInt("tbs_preload_x5_recorder", i3);
                                                        edit.putInt("tbs_preload_x5_version", i2);
                                                        edit.commit();
                                                    } catch (Throwable th3) {
                                                        TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + Log.getStackTraceString(th3));
                                                    }
                                                    q.a(context2);
                                                    i.unlock();
                                                    j.unlock();
                                                    b();
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                bufferedInputStream = bufferedInputStream3;
                                                if (bufferedInputStream != null) {
                                                }
                                                throw th;
                                            }
                                        } else {
                                            z = false;
                                            bufferedInputStream2 = null;
                                        }
                                        if (bufferedInputStream2 != null) {
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                    } catch (Exception e7) {
                                        exc2 = e7;
                                        bufferedInputStream = null;
                                        exc2.printStackTrace();
                                        if (bufferedInputStream != null) {
                                        }
                                        z = true;
                                        if (z) {
                                        }
                                        z2 = true;
                                        TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                        if (z) {
                                        }
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        g(context2, true);
                                        b2 = j.b(context);
                                        j.a(new File(b2, !TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)), context2);
                                        k.a(context2).a(i2, 1);
                                        if (!this.k) {
                                        }
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i2);
                                        if (Build.VERSION.SDK_INT < 11) {
                                        }
                                        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                                        edit2.putInt("tbs_preload_x5_counter", i3);
                                        edit2.putInt("tbs_preload_x5_recorder", i3);
                                        edit2.putInt("tbs_preload_x5_version", i2);
                                        edit2.commit();
                                        q.a(context2);
                                        i.unlock();
                                        j.unlock();
                                        b();
                                    } catch (Throwable th6) {
                                    }
                                    if (z) {
                                        File[] listFiles = file2.listFiles();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= listFiles.length) {
                                                break;
                                            }
                                            File file4 = listFiles[i5];
                                            if (!"1".equals(file4.getName()) && !file4.getName().endsWith(".dex") && !"tbs.conf".equals(file4.getName()) && !file4.isDirectory() && !file4.getName().endsWith(".prof")) {
                                                String a4 = a.a(file4);
                                                String property = properties.getProperty(file4.getName(), "");
                                                if (property.equals("") || !a4.equals(property)) {
                                                    TbsLog.e("TbsInstaller", "md5_check_failure for (" + file4.getName() + ")" + " targetMd5:" + property + ", realMd5:" + a4);
                                                    z2 = false;
                                                } else {
                                                    TbsLog.i("TbsInstaller", "md5_check_success for (" + file4.getName() + ")");
                                                }
                                            }
                                            i5++;
                                        }
                                    }
                                    z2 = true;
                                    TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                    if (z || z2) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        g(context2, true);
                                        b2 = j.b(context);
                                        if (b2 != null && b2.exists()) {
                                            j.a(new File(b2, !TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)), context2);
                                        }
                                        k.a(context2).a(i2, 1);
                                        if (!this.k) {
                                            TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, "continueInstallWithout core success");
                                        } else {
                                            TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, "success");
                                        }
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i2);
                                        if (Build.VERSION.SDK_INT < 11) {
                                            sharedPreferences2 = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                                            i3 = 0;
                                        } else {
                                            i3 = 0;
                                            sharedPreferences2 = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                                        }
                                        SharedPreferences.Editor edit22 = sharedPreferences2.edit();
                                        edit22.putInt("tbs_preload_x5_counter", i3);
                                        edit22.putInt("tbs_preload_x5_recorder", i3);
                                        edit22.putInt("tbs_preload_x5_version", i2);
                                        edit22.commit();
                                        q.a(context2);
                                    } else {
                                        TbsLog.e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                        f.a(file2, true);
                                        TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify md5 fail after copying tbs core!");
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-532);
                                        i.unlock();
                                        j.unlock();
                                        b();
                                        return;
                                    }
                                } else {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                                    k.a(context2).a(i2, 2);
                                    f.a(file2, false);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-534);
                                    TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_FAIL, "copy fail!");
                                }
                            } catch (Exception e8) {
                                e2 = e8;
                                exc = e2;
                                file = file2;
                                TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, exc.toString());
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                                f.a(file, false);
                                k.a(context2).a(0, -1);
                                i.unlock();
                                j.unlock();
                                b();
                            } catch (Throwable th7) {
                                th = th7;
                                i.unlock();
                                j.unlock();
                                b();
                                throw th;
                            }
                            i.unlock();
                            j.unlock();
                            b();
                        } else {
                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + h(context2));
                            reentrantLock.unlock();
                            lock.unlock();
                            b();
                        }
                    } catch (Exception e9) {
                        exc = e9;
                        file = null;
                        TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, exc.toString());
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                        f.a(file, false);
                        k.a(context2).a(0, -1);
                        i.unlock();
                        j.unlock();
                        b();
                    }
                } else {
                    b();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-538);
                }
            }
        }
    }

    private boolean e(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* access modifiers changed from: package-private */
    public Context b(Context context, String str) {
        try {
            if (context.getPackageName() == str || !TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                return context.createPackageContext(str, 2);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(Context context, File file, int i2) {
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean a2 = a(context, file, false);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + a2);
        if (a2) {
            a().a(context, i2);
        }
        return a2;
    }

    private boolean a(Context context, File file) {
        return a(context, file, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016e, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r17).setInstallInterruptCode(-523);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(r17).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.UNZIP_IO_ERROR, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0187, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.tencent.smtt.utils.f.b(r0);
        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + r0.exists());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01a7, code lost:
        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + android.util.Log.getStackTraceString(r0));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016d A[ExcHandler: IOException (r0v3 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:24:0x0092] */
    private boolean a(Context context, File file, boolean z) {
        File file2;
        String[] list;
        File file3;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (!f.c(file)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.APK_INVALID, "apk is invalid!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-520);
            return false;
        }
        try {
            File tbsFolderDir = QbSdk.getTbsFolderDir(context);
            if (z) {
                file3 = new File(tbsFolderDir, "core_share_decouple");
            } else {
                file3 = new File(tbsFolderDir, "core_unzip_tmp");
            }
            if (file3.exists() && !TbsDownloader.a(context)) {
                f.b(file3);
            }
        } catch (Throwable th) {
            TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
        }
        if (z) {
            file2 = f(context, 2);
        } else {
            file2 = f(context, 0);
        }
        if (file2 == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_DIR_ERROR, "tmp unzip dir is null!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-521);
            return false;
        }
        boolean z2 = true;
        try {
            f.a(file2);
            if (z) {
                f.a(file2, true);
            }
            boolean a2 = f.a(file, file2);
            if (a2) {
                a2 = a(file2, context);
            }
            if (z) {
                for (String str : file2.list()) {
                    File file4 = new File(file2, str);
                    if (file4.getName().endsWith(".dex")) {
                        file4.delete();
                    }
                }
                new File(s(context), "x5.tbs").delete();
            }
            if (!a2) {
                f.b(file2);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + file2.exists());
            } else {
                g(context, true);
                if (z) {
                    File p2 = p(context);
                    f.a(p2, true);
                    file2.renameTo(p2);
                    TbsShareManager.b(context);
                }
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
            return a2;
        } catch (IOException e2) {
        } catch (Exception e3) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNZIP_OTHER_ERROR, e3);
            if (file2 == null || !file2.exists()) {
                z2 = false;
            }
            if (z2 && file2 != null) {
                f.b(file2);
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + file2.exists());
            }
        } catch (Throwable th2) {
            TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th2));
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
        return false;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        r4 = null;
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        r14.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0157, code lost:
        r14.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062 A[SYNTHETIC, Splitter:B:25:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0140 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0152 A[SYNTHETIC, Splitter:B:63:0x0152] */
    private boolean a(File file, Context context) {
        Properties properties;
        boolean z;
        boolean z2;
        File file2;
        String a2;
        String property;
        Exception e2;
        BufferedInputStream bufferedInputStream;
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file3 = new File(file, "1");
            properties = new Properties();
            if (file3.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream2 = bufferedInputStream;
                    z = true;
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        e2.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                        z = true;
                        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z);
                        if (z) {
                        }
                        z2 = true;
                        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z2);
                        if (z) {
                        }
                        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                        return true;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                        }
                        throw th2;
                    }
                }
            } else {
                z = false;
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            properties = null;
            e2 = e5;
            bufferedInputStream = null;
            e2.printStackTrace();
            if (bufferedInputStream != null) {
            }
            z = true;
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z);
            if (z) {
            }
            z2 = true;
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z2);
            if (z) {
            }
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
            return true;
        } catch (Throwable th3) {
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z);
        if (z) {
            File[] listFiles = file.listFiles();
            int i2 = 0;
            while (true) {
                if (i2 >= listFiles.length) {
                    break;
                }
                file2 = listFiles[i2];
                if (!"1".equals(file2.getName()) && !file2.getName().endsWith(".dex") && !"tbs.conf".equals(file2.getName()) && !file2.isDirectory() && !file2.getName().endsWith(".prof")) {
                    a2 = a.a(file2);
                    property = properties.getProperty(file2.getName(), "");
                    if (property.equals("") || !property.equals(a2)) {
                        TbsLog.e("TbsInstaller", "md5_check_failure for (" + file2.getName() + ")" + " targetMd5:" + property + ", realMd5:" + a2);
                        z2 = false;
                    } else {
                        TbsLog.i("TbsInstaller", "md5_check_success for (" + file2.getName() + ")");
                    }
                }
                i2++;
            }
            TbsLog.e("TbsInstaller", "md5_check_failure for (" + file2.getName() + ")" + " targetMd5:" + property + ", realMd5:" + a2);
            z2 = false;
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z2);
            if (z || z2) {
                TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                return true;
            }
            TbsLog.e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
            return false;
        }
        z2 = true;
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z2);
        if (z) {
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
        return true;
    }

    public boolean e(Context context) {
        String[] list;
        try {
            File file = new File(f.a(context, 4), TbsDownloader.getBackupFileName(true));
            File f2 = a().f(context, 2);
            f.a(f2);
            f.a(f2, true);
            f.a(file, f2);
            for (String str : f2.list()) {
                File file2 = new File(f2, str);
                if (file2.getName().endsWith(".dex")) {
                    file2.delete();
                }
            }
            i(context, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void i(Context context, int i2) {
        File f2 = a().f(context, i2);
        a().g(context, true);
        File p2 = p(context);
        f.a(p2, true);
        f2.renameTo(p2);
        TbsShareManager.b(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0098  */
    private boolean j(Context context, int i2) {
        File file;
        boolean z;
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + i2);
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 == 1) {
                file = f(context, 1);
            } else if (i2 != 2) {
                try {
                    TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + i2);
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOPT_EXCEPTION, e2.toString());
                }
            } else {
                file = q(context);
            }
        } else if (TbsDownloader.a(context)) {
            return true;
        } else {
            file = f(context, 0);
        }
        try {
            String property = System.getProperty("java.vm.version");
            if (property != null && property.startsWith("2")) {
                z = true;
                boolean z3 = Build.VERSION.SDK_INT != 23;
                boolean z4 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
                if (z && z3 && !z4) {
                    z2 = true;
                }
                if (!z2 && c(context, file)) {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
                    return true;
                } else if (!z) {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
                    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
                    return true;
                } else {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
                    return b(context, file);
                }
            }
        } catch (Throwable th) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, th);
        }
        z = false;
        if (Build.VERSION.SDK_INT != 23) {
        }
        boolean z42 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
        z2 = true;
        if (!z2) {
        }
        if (!z) {
        }
    }

    public synchronized boolean a(final Context context, final Context context2) {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (p) {
            return true;
        }
        p = true;
        new Thread() {
            /* class com.tencent.smtt.sdk.m.AnonymousClass4 */

            public void run() {
                File file;
                TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                try {
                    if (context2 == null) {
                        file = new File(TbsShareManager.getHostCorePathAppDefined());
                    } else if (!TbsShareManager.isThirdPartyApp(context)) {
                        file = m.this.q(context2);
                    } else if (TbsShareManager.c(context) == null || !TbsShareManager.c(context).contains("decouple")) {
                        file = m.this.q(context2);
                    } else {
                        file = m.this.p(context2);
                    }
                    File q = m.this.q(context);
                    int i = Build.VERSION.SDK_INT;
                    if (i != 19 && i < 21) {
                        f.a(file, q, new FileFilter() {
                            /* class com.tencent.smtt.sdk.m.AnonymousClass4.AnonymousClass1 */

                            public boolean accept(File file) {
                                return file.getName().endsWith(".dex");
                            }
                        });
                    }
                    f.a(file, q, new FileFilter() {
                        /* class com.tencent.smtt.sdk.m.AnonymousClass4.AnonymousClass2 */

                        public boolean accept(File file) {
                            return file.getName().endsWith("tbs.conf");
                        }
                    });
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean f(Context context) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_WX)) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QQ)) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (!context.getPackageName().equals(TbsConfig.APP_QZONE)) {
                return !context.getPackageName().equals("com.tencent.qqpimsecure") || signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
            } else {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    return false;
                }
            }
        } catch (Exception unused) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    public Context d(Context context, int i2) {
        Context b2;
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i2);
        if (i2 <= 0) {
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        for (int i3 = 0; i3 < coreProviderAppList.length; i3++) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i3]) && e(context, coreProviderAppList[i3]) && (b2 = b(context, coreProviderAppList[i3])) != null) {
                if (!f(b2)) {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i3] + " illegal signature go on next");
                } else {
                    int i4 = i(b2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i4);
                    if (i4 != 0 && i4 == i2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i3]);
                        return b2;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int c(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    public void g(Context context) {
        boolean z;
        FileLock fileLock;
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable unused) {
            z = true;
        }
        if (z && (fileLock = l) != null) {
            f.a(context, fileLock);
        }
    }

    private boolean w(Context context) {
        boolean z;
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable unused) {
            z = true;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is " + z);
        if (!z) {
            l = u.a().b(context);
        } else {
            l = f.f(context);
        }
        if (l == null) {
            TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    private void x(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!w(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            B(context);
            TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
            if (!TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
                TbsShareManager.a(context);
            } else {
                TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
            }
            k.a(context).a(0);
            k.a(context).b(0);
            k.a(context).d(0);
            k.a(context).a("incrupdate_retry_num", 0);
            k.a(context).c(0, 3);
            k.a(context).a("");
            k.a(context).a("tpatch_num", 0);
            k.a(context).c(-1);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().h(context) || i2 != a().i(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                } else {
                    n(context);
                }
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, m(context), true);
            }
            a.set(0);
            o = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLogReport instance = TbsLogReport.getInstance(context);
            instance.setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from unzip:" + th.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        g(context);
    }

    private void y(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!w(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            D(context);
            TbsShareManager.a(context);
            k.a(context).b(0, -1);
            k.a(context).a("tpatch_num", 0);
            a.set(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport instance = TbsLogReport.getInstance(context);
            instance.setInstallErrorCode(TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, "exception when renameing from tpatch:" + e2.toString());
        }
        g(context);
    }

    private void z(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (!w(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            C(context);
            TbsShareManager.a(context);
            k.a(context).a(0, 3);
            k.a(context).a("tpatch_num", 0);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().h(context) || i2 != a().i(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                } else {
                    n(context);
                }
            }
            a.set(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport instance = TbsLogReport.getInstance(context);
            instance.setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from copy:" + e2.toString());
        }
        g(context);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0050 A[SYNTHETIC, Splitter:B:33:0x0050] */
    public int a(String str) {
        Throwable th;
        if (str == null) {
            return 0;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(new File(str), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused5) {
                }
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public int e(Context context, int i2) {
        return a(f(context, i2));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A[SYNTHETIC, Splitter:B:24:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[SYNTHETIC, Splitter:B:30:0x005e] */
    public int a(File file) {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            File file2 = new File(file, "tbs.conf");
            if (!file2.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused5) {
                }
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[SYNTHETIC, Splitter:B:19:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046 A[SYNTHETIC, Splitter:B:26:0x0046] */
    public String d(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(q(context), "tbs.conf");
            if (!file.exists()) {
                return null;
            }
            Properties properties = new Properties();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                String property = properties.getProperty(str);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return property;
            } catch (Exception unused2) {
                if (bufferedInputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[SYNTHETIC, Splitter:B:24:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[SYNTHETIC, Splitter:B:30:0x004c] */
    public int h(Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(p(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused5) {
                }
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a A[SYNTHETIC, Splitter:B:31:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8 A[SYNTHETIC, Splitter:B:37:0x00b8] */
    public int i(Context context) {
        Throwable th;
        Exception e2;
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(q(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e3.toString());
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                if (o == 0) {
                    o = parseInt;
                }
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e4.toString());
                }
                return parseInt;
            } catch (Exception e5) {
                e2 = e5;
                bufferedInputStream = bufferedInputStream2;
                try {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e2.toString());
                    if (bufferedInputStream != null) {
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e6.toString());
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            e2 = e7;
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e2.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e8) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e8.toString());
                }
            }
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public int j(Context context) {
        int i2 = o;
        if (i2 != 0) {
            return i2;
        }
        return i(context);
    }

    /* access modifiers changed from: package-private */
    public void k(Context context) {
        if (o == 0) {
            o = i(context);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l(Context context) {
        return new File(q(context), "tbs.conf").exists();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0133 A[SYNTHETIC, Splitter:B:55:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0156 A[Catch:{ all -> 0x015a }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0173 A[SYNTHETIC, Splitter:B:68:0x0173] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0196 A[Catch:{ all -> 0x019a }] */
    public int m(Context context) {
        Throwable th;
        ReentrantLock reentrantLock;
        Exception e2;
        ReentrantLock reentrantLock2;
        if (!t(context)) {
            return -1;
        }
        ReentrantLock reentrantLock3 = i;
        boolean tryLock = reentrantLock3.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock locked=" + tryLock);
        if (tryLock) {
            BufferedInputStream bufferedInputStream = null;
            try {
                File file = new File(q(context), "tbs.conf");
                if (!file.exists()) {
                    try {
                        if (reentrantLock3.isHeldByCurrentThread()) {
                            reentrantLock3.unlock();
                        }
                    } catch (Throwable th2) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                    }
                    b();
                    return 0;
                }
                Properties properties = new Properties();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e3.toString());
                        }
                        try {
                            ReentrantLock reentrantLock4 = i;
                            if (reentrantLock4.isHeldByCurrentThread()) {
                                reentrantLock4.unlock();
                            }
                        } catch (Throwable th3) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                        }
                        b();
                        return 0;
                    }
                    a.set(Integer.valueOf(Integer.parseInt(property)));
                    int intValue = a.get().intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e4) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e4.toString());
                    }
                    try {
                        ReentrantLock reentrantLock5 = i;
                        if (reentrantLock5.isHeldByCurrentThread()) {
                            reentrantLock5.unlock();
                        }
                    } catch (Throwable th4) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th4);
                    }
                    b();
                    return intValue;
                } catch (Exception e5) {
                    e2 = e5;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e2.toString());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e6.toString());
                            }
                        }
                        try {
                            reentrantLock2 = i;
                            if (reentrantLock2.isHeldByCurrentThread()) {
                                reentrantLock2.unlock();
                            }
                        } catch (Throwable th5) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th5);
                        }
                        b();
                        return 0;
                    } catch (Throwable th6) {
                        th = th6;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e7) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e7.toString());
                            }
                        }
                        try {
                            reentrantLock = i;
                            if (reentrantLock.isHeldByCurrentThread()) {
                                reentrantLock.unlock();
                            }
                        } catch (Throwable th7) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th7);
                        }
                        b();
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    reentrantLock = i;
                    if (reentrantLock.isHeldByCurrentThread()) {
                    }
                    b();
                    throw th;
                }
            } catch (Exception e8) {
                e2 = e8;
                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e2.toString());
                if (bufferedInputStream != null) {
                }
                reentrantLock2 = i;
                if (reentrantLock2.isHeldByCurrentThread()) {
                }
                b();
                return 0;
            }
        } else {
            b();
            return 0;
        }
    }

    private void A(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        f.a(q(context), false);
    }

    private void B(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File f2 = f(context, 0);
        File q = q(context);
        if (f2 == null || q == null) {
            TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + f2 + "tbsSharePath=" + q);
            return;
        }
        boolean renameTo = f2.renameTo(q);
        TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + renameTo);
        if (context != null && TbsConfig.APP_WX.equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            if (renameTo) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.RENAME_SUCCESS, " ");
            } else {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.RENAME_FAIL, " ");
            }
        }
        g(context, false);
    }

    public boolean n(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File q = q(context);
        File p2 = p(context);
        try {
            f.a(p2, true);
            f.a(q, p2, new FileFilter() {
                /* class com.tencent.smtt.sdk.m.AnonymousClass5 */

                public boolean accept(File file) {
                    return !file.getName().endsWith(".dex") && !file.getName().endsWith(".jar_is_first_load_dex_flag_file");
                }
            });
            TbsShareManager.b(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void C(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File f2 = f(context, 1);
        File q = q(context);
        if (f2 != null && q != null) {
            f2.renameTo(q);
            g(context, false);
        }
    }

    private void D(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File f2 = f(context, 5);
        File q = q(context);
        if (f2 != null && q != null) {
            f2.renameTo(q);
            g(context, false);
        }
    }

    private void E(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File f2 = f(context, 0);
        if (f2 != null) {
            f.a(f2, false);
        }
        k.a(context).c(0, 5);
        k.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    /* access modifiers changed from: package-private */
    public void o(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        k.a(context).a(0);
        k.a(context).b(0);
        k.a(context).d(0);
        k.a(context).a("incrupdate_retry_num", 0);
        if (!TbsDownloader.a(context)) {
            k.a(context).c(0, -1);
            k.a(context).a("");
            k.a(context).a("copy_retry_num", 0);
            k.a(context).c(-1);
            k.a(context).a(0, -1);
            f.a(f(context, 0), true);
            f.a(f(context, 1), true);
        }
    }

    /* access modifiers changed from: package-private */
    public File b(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
    }

    /* access modifiers changed from: package-private */
    public File p(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public File c(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share_decouple");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public File q(Context context) {
        return b((Context) null, context);
    }

    /* access modifiers changed from: package-private */
    public File r(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "share");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    static File s(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public File f(Context context, int i2) {
        return a(context, i2, true);
    }

    /* access modifiers changed from: package-private */
    public File a(Context context, int i2, boolean z) {
        String str;
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        switch (i2) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
            default:
                str = "";
                break;
        }
        TbsLog.i("TbsInstaller", "type=" + i2 + "needMakeDir=" + z + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (!z) {
                TbsLog.i("TbsInstaller", "getCoreDir,no need mkdir");
                return null;
            } else if (!file.mkdir()) {
                TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
                return null;
            }
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    public boolean g(Context context, int i2) {
        File file;
        try {
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                file = q(context);
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context));
                if (file.getAbsolutePath().contains(TbsConfig.APP_DEMO)) {
                    return true;
                }
            } else {
                TbsLog.e("TbsInstaller", "321");
                return false;
            }
            if (file != null) {
                Long[][] lArr = n;
                int length = lArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    Long[] lArr2 = lArr[i3];
                    if (i2 == lArr2[0].intValue()) {
                        File file2 = new File(file, "libmttwebview.so");
                        if (!file2.exists() || file2.length() != lArr2[1].longValue()) {
                            if (!isThirdPartyApp) {
                                f.b(QbSdk.getTbsFolderDir(context));
                            }
                            a.set(0);
                            TbsLog.e("TbsInstaller", "322");
                            return false;
                        }
                        TbsLog.d("TbsInstaller", "check so success: " + i2 + "; file: " + file2);
                    } else {
                        i3++;
                    }
                }
                return true;
            }
            TbsLog.e("TbsInstaller", "323");
            return false;
        } catch (Throwable th) {
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean t(Context context) {
        if (this.e > 0) {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            this.e++;
            return true;
        }
        FileOutputStream b2 = f.b(context, true, "tbslock.txt");
        this.g = b2;
        if (b2 != null) {
            FileLock a2 = f.a(context, b2);
            this.f = a2;
            if (a2 == null) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
                return false;
            }
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
            this.e++;
            return true;
        }
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
        return false;
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        int i2 = this.e;
        if (i2 <= 0) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
        } else if (i2 > 1) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            this.e--;
        } else {
            if (i2 == 1) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                f.a(this.f, this.g);
                this.e = 0;
            }
        }
    }

    private boolean b(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new FileFilter() {
                /* class com.tencent.smtt.sdk.m.AnonymousClass6 */

                public boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            int length = listFiles.length;
            if (Build.VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000);
                } catch (Exception unused) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i2 = 0; i2 < length; i2++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i2].getAbsolutePath());
                new DexClassLoader(listFiles[i2].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOPT_EXCEPTION, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    private boolean c(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String a2 = c.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a2)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, "can not find oat command");
                return false;
            }
            File[] listFiles = file.listFiles(new FileFilter() {
                /* class com.tencent.smtt.sdk.m.AnonymousClass7 */

                public boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            for (File file4 : listFiles) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + a2.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + a().q(context) + File.separator + substring + ".jar").waitFor();
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, e2);
            return false;
        }
    }
}
