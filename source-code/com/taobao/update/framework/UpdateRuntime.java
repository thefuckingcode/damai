package com.taobao.update.framework;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.update.adapter.ThreadExecutor;
import com.taobao.update.adapter.UIConfirm;
import com.taobao.update.adapter.UIToast;
import com.taobao.update.adapter.UserAction;
import org.android.agoo.common.AgooConstants;
import tb.ab1;
import tb.eb;
import tb.h3;
import tb.mk2;
import tb.mp2;
import tb.op2;
import tb.qp2;
import tb.rp2;
import tb.ul;
import tb.z81;

/* compiled from: Taobao */
public class UpdateRuntime {
    private static Application a = null;
    public static int bundleUpdateMinDisk = 200;
    public static boolean forceInstallAfaterDownload;
    public static boolean installBundleAfterDownload;
    public static boolean popDialogBeforeInstall;
    public static String processName;
    public static String sAppName;
    public static boolean sBundleUpdateSuccess;
    public static String sGroup;
    public static int sLogoResourceId;
    public static String sTTid;
    public boolean commited;

    public static void doUIAlertForConfirm(final String str, final UserAction userAction) {
        ab1.execute(new Runnable() {
            /* class com.taobao.update.framework.UpdateRuntime.AnonymousClass1 */

            public void run() {
                UIConfirm uIConfirm = (UIConfirm) eb.getInstance(UIConfirm.class);
                if (uIConfirm != null) {
                    uIConfirm.alertForConfirm(str, userAction);
                } else {
                    Log.e("Updater", "UIConfirm is null");
                }
            }
        });
    }

    public static void execute(final Runnable runnable) {
        ThreadExecutor threadExecutor = (ThreadExecutor) eb.getInstance(ThreadExecutor.class);
        if (threadExecutor != null) {
            threadExecutor.execute(runnable);
        } else {
            new Thread(new Runnable() {
                /* class com.taobao.update.framework.UpdateRuntime.AnonymousClass3 */

                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            }).start();
        }
    }

    public static Application getContext() {
        return a;
    }

    public static void init(Application application, String str, String str2, String str3) {
        a = application;
        sGroup = str3;
        sTTid = str;
        if (!TextUtils.isEmpty(str2)) {
            sAppName = str2;
        } else {
            sAppName = application.getApplicationInfo().loadLabel(application.getPackageManager()).toString();
        }
        a.registerActivityLifecycleCallbacks(new h3());
        mp2.sClickbg2Exit = false;
        eb.registerClass(rp2.class);
        eb.registerClass("sysnotify", qp2.class);
        eb.registerClass(AgooConstants.MESSAGE_NOTIFICATION, op2.class);
        eb.registerClass(mp2.class);
        eb.registerInstance(new z81());
        eb.registerInstance(new mk2());
        popDialogBeforeInstall = true;
        forceInstallAfaterDownload = false;
        bundleUpdateMinDisk = 200;
        sLogoResourceId = a.getApplicationInfo().icon;
    }

    public static void log(String str) {
        com.taobao.update.adapter.Log log = (com.taobao.update.adapter.Log) eb.getInstance(com.taobao.update.adapter.Log.class);
        if (log != null) {
            log.debug("update.sdk", str);
        } else {
            Log.d("update.sdk", str);
        }
    }

    public static void tips(boolean z, String str, String str2) {
        Log.d(str, str2);
        if (z) {
            toast(str2);
        }
    }

    public static void toast(final String str) {
        ab1.execute(new Runnable() {
            /* class com.taobao.update.framework.UpdateRuntime.AnonymousClass2 */

            public void run() {
                UIToast uIToast = (UIToast) eb.getInstance(UIToast.class);
                if (uIToast != null) {
                    uIToast.toast(str);
                }
            }
        });
    }

    public static void log(String str, Throwable th) {
        com.taobao.update.adapter.Log log = (com.taobao.update.adapter.Log) eb.getInstance(com.taobao.update.adapter.Log.class);
        if (log != null) {
            log.error("update.sdk", str, th);
            return;
        }
        Log.e("update.sdk", str, th);
    }

    public static void execute(final Runnable runnable, final int i) {
        ThreadExecutor threadExecutor = (ThreadExecutor) eb.getInstance(ThreadExecutor.class);
        if (threadExecutor != null) {
            threadExecutor.delayExecute(runnable, i);
        } else {
            new Thread(new Runnable() {
                /* class com.taobao.update.framework.UpdateRuntime.AnonymousClass4 */

                public void run() {
                    Process.setThreadPriority(10);
                    try {
                        Thread.sleep((long) i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runnable.run();
                }
            }).start();
        }
    }

    public static void init(Application application, ul ulVar) {
        a = application;
        sGroup = ulVar.group;
        sTTid = ulVar.ttid;
        if (!TextUtils.isEmpty(ulVar.appName)) {
            sAppName = ulVar.appName;
        } else {
            sAppName = application.getApplicationInfo().loadLabel(application.getPackageManager()).toString();
        }
        a.registerActivityLifecycleCallbacks(new h3());
        mp2.sClickbg2Exit = false;
        Class[] clsArr = new Class[1];
        Class<rp2> cls = ulVar.uiToastClass;
        if (cls == null) {
            cls = rp2.class;
        }
        clsArr[0] = cls;
        eb.registerClass(clsArr);
        Class<qp2> cls2 = ulVar.uiSysNotifyClass;
        if (cls2 == null) {
            cls2 = qp2.class;
        }
        eb.registerClass("sysnotify", cls2);
        Class<op2> cls3 = ulVar.uiNotifyClass;
        if (cls3 == null) {
            cls3 = op2.class;
        }
        eb.registerClass(AgooConstants.MESSAGE_NOTIFICATION, cls3);
        Class[] clsArr2 = new Class[1];
        Class<mp2> cls4 = ulVar.uiConfirmClass;
        if (cls4 == null) {
            cls4 = mp2.class;
        }
        clsArr2[0] = cls4;
        eb.registerClass(clsArr2);
        Object obj = ulVar.logImpl;
        if (obj == null) {
            obj = new z81();
        }
        eb.registerInstance(obj);
        Object obj2 = ulVar.threadExecutorImpl;
        if (obj2 == null) {
            obj2 = new mk2();
        }
        eb.registerInstance(obj2);
        popDialogBeforeInstall = ulVar.popDialogBeforeInstall;
        forceInstallAfaterDownload = ulVar.forceInstallAfaterDownload;
        installBundleAfterDownload = ulVar.installBundleAfterDownload;
        bundleUpdateMinDisk = ulVar.bundleUpdateMinDisk;
        sLogoResourceId = a.getApplicationInfo().icon;
    }
}
