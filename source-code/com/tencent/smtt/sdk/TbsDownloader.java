package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.h;
import com.tencent.smtt.utils.n;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
    static boolean a = false;
    private static String b = null;
    private static Context c = null;
    private static Handler d = null;
    private static String e = null;
    private static Object f = new byte[0];
    private static j g = null;
    private static HandlerThread h = null;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    public static String getBackupFileName(boolean z) {
        return z ? b.c() ? "x5.tbs.decouple.64" : "x5.tbs.decouple" : b.c() ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    private static boolean c() {
        try {
            for (String str : TbsShareManager.getCoreProviderAppList()) {
                if (TbsShareManager.getSharedTbsCoreVersion(c, str) > 0) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static void setAppContext(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            c = context.getApplicationContext();
        }
    }

    public static boolean needSendRequest(Context context, boolean z) {
        boolean z2;
        c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        boolean z3 = false;
        if (!a(c, z)) {
            return false;
        }
        int m = m.a().m(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
        if (m > 0) {
            return false;
        }
        if (a(c, false, true)) {
            return true;
        }
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        boolean contains = instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        if (!contains) {
            z2 = true;
        } else {
            z2 = instance.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=" + z2);
        if (z2 && h()) {
            z3 = true;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=" + z3);
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x017a, code lost:
        if (r9.equals(r5) != false) goto L_0x01e6;
     */
    private static boolean a(Context context, boolean z, boolean z2) {
        boolean z3;
        String str;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (!z) {
            String string = instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i2 = instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            String a2 = b.a(c);
            int b2 = b.b(c);
            String a3 = b.a(c, TBS_METADATA);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + a2 + " oldAppVersionName=" + string + " appVersionCode=" + b2 + " oldAppVersionCode=" + i2 + " appMetadata=" + a3 + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            sb.append(j2);
            sb.append(" timeNow=");
            sb.append(currentTimeMillis);
            TbsLog.i(LOGTAG, sb.toString());
            if (z2) {
                boolean contains = instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
                if (contains && j2 == 0) {
                    j2 = currentTimeMillis;
                }
            }
            long j3 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0);
            long j4 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0);
            long retryInterval = instance.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
            int i3 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            long j5 = currentTimeMillis - j2;
            long j6 = retryInterval * 1000;
            if (j5 <= j6 && ((emergentCoreVersion <= m.a().i(c) || emergentCoreVersion <= i3) && (!TbsShareManager.isThirdPartyApp(c) || j3 <= 0 || currentTimeMillis - j3 <= j6 || j4 >= 11))) {
                if (!TbsShareManager.isThirdPartyApp(c) || TbsShareManager.findCoreForThirdPartyApp(c) != 0 || e()) {
                    if (a2 == null || b2 == 0 || a3 == null) {
                        if (TbsShareManager.isThirdPartyApp(c)) {
                            str = "timeNow - timeLastCheck is " + j5 + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + a2 + " appVersionCode is " + b2 + " appMetadata is " + a3 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i2 + " oldAppVersionMetadata is " + string2;
                            z3 = false;
                            if (!z3 && TbsShareManager.isThirdPartyApp(c)) {
                                TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                                tbsLogInfo.setErrorCode(-119);
                                tbsLogInfo.setFailDetail(str);
                                TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                            }
                            return z3;
                        }
                    } else if (a2.equals(string)) {
                        if (b2 == i2) {
                        }
                    }
                    str = null;
                    z3 = false;
                    TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(c).tbsLogInfo();
                    tbsLogInfo2.setErrorCode(-119);
                    tbsLogInfo2.setFailDetail(str);
                    TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                    return z3;
                }
                m.a().d(c);
            }
        }
        str = null;
        z3 = true;
        TbsLogReport.TbsLogInfo tbsLogInfo22 = TbsLogReport.getInstance(c).tbsLogInfo();
        tbsLogInfo22.setErrorCode(-119);
        tbsLogInfo22.setFailDetail(str);
        TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo22);
        return z3;
    }

    private static boolean a(Context context, boolean z) {
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (Build.VERSION.SDK_INT < 8) {
            instance.setDownloadInterruptCode(-102);
            return false;
        } else if (!QbSdk.c && TbsShareManager.isThirdPartyApp(c) && !c()) {
            return false;
        } else {
            if (!instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z && !TbsConfig.APP_WX.equals(context.getApplicationInfo().packageName)) {
                    TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                    z = false;
                }
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
                instance.commit();
                j = z;
                TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z);
            }
            if (!getOverSea(context) || Build.VERSION.SDK_INT == 16 || Build.VERSION.SDK_INT == 17 || Build.VERSION.SDK_INT == 18) {
                Matcher matcher = null;
                String string = instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
                e = string;
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (Exception unused) {
                }
                if (matcher == null || !matcher.find()) {
                    return true;
                }
                TbsLog.e(LOGTAG, "can not support x86 devices!!");
                instance.setDownloadInterruptCode(-104);
                return false;
            }
            TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
            instance.setDownloadInterruptCode(-103);
            return false;
        }
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, true, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z, z2, true, tbsDownloaderCallback);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        boolean z4;
        boolean z5;
        TbsLog.i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        TbsDownloadUpload.clear();
        TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
        instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_1));
        instance.commit();
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        TbsLog.initIfNeed(context);
        if (m.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return " + false);
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1));
            instance.commit();
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(applicationContext);
        instance2.setDownloadInterruptCode(-100);
        if (!a(c, z)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return " + false);
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_2));
            instance.commit();
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2));
            instance.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        d();
        if (i) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            instance2.setDownloadInterruptCode(-105);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return " + false);
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_3));
            instance.commit();
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3));
            instance.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean a2 = a(c, z2, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + a2);
        if (a2) {
            a(z2, tbsDownloaderCallback, z3);
            instance2.setDownloadInterruptCode(-114);
        } else {
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_4));
            instance.commit();
        }
        d.removeMessages(102);
        Message.obtain(d, 102).sendToTarget();
        if (QbSdk.c || !TbsShareManager.isThirdPartyApp(context)) {
            z4 = instance2.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + z4);
            if (z4 || TbsShareManager.isThirdPartyApp(context)) {
                z5 = instance2.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
            } else {
                z5 = true;
            }
        } else {
            z5 = false;
            z4 = false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z5 + ",hasNeedDownloadKey=" + z4);
        if (!z5) {
            int m = m.a().m(c);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + a2);
            if (a2 || m <= 0) {
                d.removeMessages(103);
                if (m > 0 || a2) {
                    Message.obtain(d, 103, 1, 0, c).sendToTarget();
                } else {
                    Message.obtain(d, 103, 0, 0, c).sendToTarget();
                }
                instance2.setDownloadInterruptCode(-121);
            } else {
                instance2.setDownloadInterruptCode(-119);
            }
        } else if (!h()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z5 = false;
        } else {
            instance2.setDownloadInterruptCode(-118);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
        }
        if (!a2 && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + z5);
        instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z5 ? TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE : TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4));
        instance.commit();
        return z5;
    }

    static boolean a(Context context) {
        return TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (TbsDownloader.class) {
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 160);
            instance.commit();
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + c);
            if (m.b) {
                instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_2));
                instance.commit();
                return;
            }
            int i2 = 1;
            a = true;
            Context applicationContext = context.getApplicationContext();
            c = applicationContext;
            TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
            if (Build.VERSION.SDK_INT < 8) {
                QbSdk.m.onDownloadFinish(110);
                TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
                instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_3));
                instance.commit();
                return;
            }
            d();
            if (i) {
                QbSdk.m.onDownloadFinish(121);
                TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
                instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_4));
                instance.commit();
                return;
            }
            if (z) {
                stopDownload();
            }
            d.removeMessages(101);
            d.removeMessages(100);
            Message obtain = Message.obtain(d, 101, QbSdk.m);
            if (!z) {
                i2 = 0;
            }
            obtain.arg1 = i2;
            obtain.sendToTarget();
        }
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return m.a().h(context);
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return m.a().h(c);
    }

    public static boolean needDownloadDecoupleCore() {
        int i2;
        if (TbsShareManager.isThirdPartyApp(c) || a(c)) {
            return false;
        }
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0) >= TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000 && (i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i2 != m.a().h(c) && TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2) {
            return true;
        }
        return false;
    }

    public static boolean startDecoupleCoreIfNeeded() {
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(c)) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (a(c) || d == null) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        long j2 = TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
        if (System.currentTimeMillis() - j2 < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        if (i2 <= 0 || i2 == m.a().h(c)) {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + m.a().h(c));
        } else if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2 || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
            a = true;
            d.removeMessages(108);
            Message obtain = Message.obtain(d, 108, QbSdk.m);
            obtain.arg1 = 0;
            obtain.sendToTarget();
            TbsDownloadConfig.getInstance(c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
            return true;
        } else {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + " deCoupleCoreVersion is " + i2 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0));
        }
        return false;
    }

    public static void stopDownload() {
        if (!i) {
            TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
            j jVar = g;
            if (jVar != null) {
                jVar.b();
            }
            Handler handler = d;
            if (handler != null) {
                handler.removeMessages(100);
                d.removeMessages(101);
                d.removeMessages(108);
            }
        }
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + a);
            z = a;
        }
        return z;
    }

    public static boolean isDownloadForeground() {
        j jVar = g;
        return jVar != null && jVar.d();
    }

    private static synchronized void d() {
        synchronized (TbsDownloader.class) {
            if (h == null) {
                h = l.a();
                try {
                    g = new j(c);
                    d = new Handler(h.getLooper()) {
                        /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass1 */

                        public void handleMessage(Message message) {
                            FileLock fileLock;
                            int i;
                            int i2 = message.what;
                            boolean z = true;
                            if (i2 != 108) {
                                switch (i2) {
                                    case 100:
                                        boolean z2 = message.arg1 == 1;
                                        boolean b = TbsDownloader.b(true, false, false, message.arg2 == 1);
                                        if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                                            TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + b);
                                            String str = (TbsDownloader.c == null || TbsDownloader.c.getApplicationContext() == null || TbsDownloader.c.getApplicationContext().getApplicationInfo() == null) ? "" : TbsDownloader.c.getApplicationContext().getApplicationInfo().packageName;
                                            if (!b || z2) {
                                                ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                            } else if (TbsConfig.APP_WX.equals(str) || TbsConfig.APP_QQ.equals(str)) {
                                                TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + b);
                                                ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                            }
                                        }
                                        if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && b) {
                                            TbsDownloader.startDownload(TbsDownloader.c);
                                            return;
                                        }
                                        return;
                                    case 101:
                                        break;
                                    case 102:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                        if (TbsShareManager.isThirdPartyApp(TbsDownloader.c)) {
                                            i = TbsShareManager.a(TbsDownloader.c, false);
                                        } else {
                                            i = m.a().m(TbsDownloader.c);
                                        }
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + i);
                                        TbsDownloader.g.a(i);
                                        TbsLogReport.getInstance(TbsDownloader.c).dailyReport();
                                        return;
                                    case 103:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                        if (message.arg1 == 0) {
                                            m.a().a((Context) message.obj, true);
                                            return;
                                        } else {
                                            m.a().a((Context) message.obj, false);
                                            return;
                                        }
                                    case 104:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                        TbsLogReport.getInstance(TbsDownloader.c).reportTbsLog();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            FileOutputStream fileOutputStream = null;
                            FileLock fileLock2 = null;
                            if (!TbsShareManager.isThirdPartyApp(TbsDownloader.c)) {
                                FileOutputStream b2 = f.b(TbsDownloader.c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                                if (b2 != null) {
                                    fileLock2 = f.a(TbsDownloader.c, b2);
                                    if (fileLock2 == null) {
                                        QbSdk.m.onDownloadFinish(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                        TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                                        TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-203);
                                        TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                                        return;
                                    }
                                } else if (f.a(TbsDownloader.c)) {
                                    TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-204);
                                    TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                                    return;
                                }
                                fileOutputStream = b2;
                                fileLock = fileLock2;
                            } else {
                                fileLock = null;
                            }
                            boolean z3 = message.arg1 == 1;
                            TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.c);
                            if (!TbsDownloader.b(false, z3, 108 == message.what, true)) {
                                QbSdk.m.onDownloadFinish(110);
                            } else if (z3 && m.a().b(TbsDownloader.c, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                QbSdk.m.onDownloadFinish(122);
                                instance.setDownloadInterruptCode(-213);
                            } else if (instance.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-215);
                                j jVar = TbsDownloader.g;
                                if (108 != message.what) {
                                    z = false;
                                }
                                jVar.b(z3, z);
                            } else {
                                QbSdk.m.onDownloadFinish(110);
                            }
                            TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                            f.a(fileLock, fileOutputStream);
                        }
                    };
                } catch (Exception unused) {
                    i = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        Message obtain = Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        obtain.arg1 = z ? 1 : 0;
        obtain.arg2 = z2 ? 1 : 0;
        obtain.sendToTarget();
    }

    private static boolean e() {
        try {
            return TbsDownloadConfig.getInstance(c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(g().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    private static String[] f() {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{c.getApplicationContext().getPackageName()};
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        String packageName = c.getApplicationContext().getPackageName();
        if (!packageName.equals(TbsShareManager.f(c))) {
            return coreProviderAppList;
        }
        int length = coreProviderAppList.length;
        String[] strArr = new String[(length + 1)];
        System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
        strArr[length] = packageName;
        return strArr;
    }

    static boolean a(Context context, int i2) {
        return Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i2 > 0 && i2 < 45114;
    }

    private static void a(JSONArray jSONArray) {
        boolean z;
        String[] f2 = f();
        int length = f2.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            String str = f2[i2];
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(c, str, true);
                if (packageContext != null && !m.a().f(packageContext)) {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                } else if (a(c, sharedTbsCoreVersion)) {
                    TbsLog.i(LOGTAG, "add CoreVersionToJsonData,version+" + sharedTbsCoreVersion + " is in black list");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i3) == sharedTbsCoreVersion) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                }
            }
            i2++;
        }
        String[] f3 = f();
        for (String str2 : f3) {
            int coreShareDecoupleCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str2);
            if (coreShareDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(c, str2, true);
                if (packageContext2 == null || m.a().f(packageContext2)) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.optInt(i4) == coreShareDecoupleCoreVersion) {
                            z = true;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        jSONArray.put(coreShareDecoupleCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str2);
                }
            }
        }
    }

    private static void b(JSONArray jSONArray) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a2 = m.a().a(TbsShareManager.getHostCorePathAppDefined());
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray.length()) {
                    break;
                } else if (jSONArray.optInt(i2) == a2) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                jSONArray.put(a2);
            }
        }
    }

    private static JSONArray g() {
        if (!TbsShareManager.isThirdPartyApp(c)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        a(jSONArray);
        c(jSONArray);
        b(jSONArray);
        return jSONArray;
    }

    private static void c(JSONArray jSONArray) {
        boolean z;
        if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore()) {
            String[] f2 = f();
            for (String str : f2) {
                int backupCoreVersion = TbsShareManager.getBackupCoreVersion(c, str);
                boolean z2 = true;
                if (backupCoreVersion > 0) {
                    Context packageContext = TbsShareManager.getPackageContext(c, str, false);
                    if (packageContext != null && !m.a().f(packageContext)) {
                        TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                    } else if (a(c, backupCoreVersion)) {
                        TbsLog.i(LOGTAG, "add addBackupVersionToJsonData,version+" + backupCoreVersion + " is in black list");
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                z = false;
                                break;
                            } else if (jSONArray.optInt(i2) == backupCoreVersion) {
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z) {
                            jSONArray.put(backupCoreVersion);
                        }
                    }
                }
                int backupDecoupleCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
                if (backupDecoupleCoreVersion > 0) {
                    Context packageContext2 = TbsShareManager.getPackageContext(c, str, false);
                    if (packageContext2 == null || m.a().f(packageContext2)) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= jSONArray.length()) {
                                z2 = false;
                                break;
                            } else if (jSONArray.optInt(i3) == backupDecoupleCoreVersion) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (!z2) {
                            jSONArray.put(backupDecoupleCoreVersion);
                        }
                    } else {
                        TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                    }
                }
            }
        }
    }

    private static JSONObject a(boolean z, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        int i5;
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        String b2 = b(c);
        String e2 = b.e(c);
        String d2 = b.d(c);
        String g2 = b.g(c);
        String id = TimeZone.getDefault().getID();
        String str = "";
        String str2 = id != null ? id : str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
            if (telephonyManager != null) {
                id = telephonyManager.getSimCountryIso();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (id != null) {
            str = id;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z4 = false;
            if (k.a(c).c("tpatch_num") < 5) {
                jSONObject.put("REQUEST_TPATCH", 1);
            } else {
                jSONObject.put("REQUEST_TPATCH", 0);
            }
            jSONObject.put("TIMEZONEID", str2);
            jSONObject.put("COUNTRYISO", str);
            if (b.c()) {
                i2 = 1;
                jSONObject.put("REQUEST_64", 1);
            } else {
                i2 = 1;
            }
            jSONObject.put("PROTOCOLVERSION", i2);
            if (!TbsShareManager.isThirdPartyApp(c)) {
                if (z3) {
                    i3 = m.a().i(c);
                } else {
                    i3 = m.a().m(c);
                }
                if (i3 == 0 && m.a().l(c)) {
                    i3 = -1;
                    if (TbsConfig.APP_QQ.equals(c.getApplicationInfo().packageName)) {
                        TbsDownloadUpload.clear();
                        TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(c);
                        instance2.a.put(TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, -1);
                        instance2.commit();
                        TbsPVConfig.releaseInstance();
                        if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                            i3 = m.a().i(c);
                        }
                    }
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + i3 + " isDownloadForeground=" + z2);
                if (z2 && !m.a().l(c)) {
                    i3 = 0;
                }
            } else if (QbSdk.c) {
                i3 = TbsShareManager.a(c, false);
            } else {
                i3 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            }
            if (z) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", i3 == 0 ? 0 : 1);
            }
            if (TbsShareManager.isThirdPartyApp(c)) {
                JSONArray g3 = g();
                jSONObject.put("TBSVLARR", g3);
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, g3.toString());
                instance.commit();
                if (QbSdk.c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            } else {
                JSONArray a2 = a(z3);
                if (Apn.getApnType(c) != 3 && a2.length() != 0 && i3 == 0 && z) {
                    jSONObject.put("TBSBACKUPARR", a2);
                }
            }
            jSONObject.put("APPN", c.getPackageName());
            jSONObject.put("APPVN", a(instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43903);
            jSONObject.put("TBSV", i3);
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
            instance.commit();
            if (i3 != 0) {
                jSONObject.put("TBSBACKUPV", g.b(z3));
            }
            jSONObject.put("CPU", e);
            jSONObject.put("UA", b2);
            jSONObject.put("IMSI", a(e2));
            jSONObject.put("IMEI", a(d2));
            jSONObject.put("ANDROID_ID", a(g2));
            jSONObject.put("GUID", b.c(c));
            if (!TbsShareManager.isThirdPartyApp(c)) {
                if (i3 != 0) {
                    jSONObject.put("STATUS", QbSdk.a(c, i3) ? 0 : 1);
                } else {
                    jSONObject.put("STATUS", 0);
                }
                jSONObject.put("TBSDV", m.a().h(c));
            }
            boolean z5 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
            Object a3 = QbSdk.a(c, "can_unlzma", (Bundle) null);
            if ((a3 == null || !(a3 instanceof Boolean)) ? false : ((Boolean) a3).booleanValue()) {
                i4 = 1;
                z4 = !z5;
            } else {
                i4 = 1;
            }
            if (z4) {
                jSONObject.put("REQUEST_LZMA", i4);
            }
            if (getOverSea(c)) {
                i5 = 1;
                jSONObject.put("OVERSEA", 1);
            } else {
                i5 = 1;
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", i5);
            }
        } catch (Exception unused) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!k) {
                k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                    j = instance.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
            }
            z = j;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0338 A[Catch:{ all -> 0x03a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x035e A[Catch:{ all -> 0x03a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02b4  */
    public static boolean b(final boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i2;
        JSONObject jSONObject;
        boolean z6;
        Throwable th;
        if (z) {
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(c);
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_5));
            instance.commit();
        } else if (!z3) {
            TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(c);
            instance2.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_5));
            instance2.commit();
        }
        if (QbSdk.n == null || !QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
            if (m.a().c(c)) {
                TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
                if (z) {
                    TbsDownloadUpload instance3 = TbsDownloadUpload.getInstance(c);
                    instance3.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_7));
                    instance3.commit();
                } else if (!z3) {
                    TbsDownloadUpload instance4 = TbsDownloadUpload.getInstance(c);
                    instance4.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_7));
                    instance4.commit();
                }
                return false;
            }
            final TbsDownloadConfig instance5 = TbsDownloadConfig.getInstance(c);
            String str = "x5.oversea.tbs.org";
            File file = new File(f.a(c, 1), getOverSea(c) ? str : getBackupFileName(false));
            File file2 = new File(f.a(c, 2), getOverSea(c) ? str : getBackupFileName(false));
            File file3 = new File(f.a(c, 3), getOverSea(c) ? str : getBackupFileName(false));
            String a2 = f.a(c, 4);
            if (!getOverSea(c)) {
                str = getBackupFileName(false);
            }
            File file4 = new File(a2, str);
            if (!file4.exists()) {
                if (file3.exists()) {
                    file3.renameTo(file4);
                } else if (file2.exists()) {
                    file2.renameTo(file4);
                } else if (file.exists()) {
                    file.renameTo(file4);
                }
            }
            if (e == null) {
                e = b.a();
                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, e);
                instance5.commit();
            }
            if (!TextUtils.isEmpty(e)) {
                Matcher matcher = null;
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (Exception unused) {
                }
                if (matcher != null && matcher.find()) {
                    if (TbsShareManager.isThirdPartyApp(c)) {
                        TbsLog.e(LOGTAG, "don't support x86 devices,skip send request");
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                        if (z) {
                            instance5.setDownloadInterruptCode(-104);
                            tbsLogInfo.setErrorCode(-104);
                        } else {
                            instance5.setDownloadInterruptCode(-205);
                            tbsLogInfo.setErrorCode(-205);
                        }
                        tbsLogInfo.setFailDetail("mycpu is " + e);
                        TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    } else if (z) {
                        instance5.setDownloadInterruptCode(-104);
                    } else {
                        instance5.setDownloadInterruptCode(-205);
                    }
                    z5 = true;
                    instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, b.a(c));
                    instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.b(c)));
                    instance5.commit();
                    JSONObject a3 = a(z, z2, z3);
                    i2 = a3.getInt("TBSV");
                    if (!z5 || i2 != -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!TbsShareManager.isThirdPartyApp(c)) {
                            z6 = z5;
                            long j2 = instance5.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0);
                            jSONObject = a3;
                            long j3 = instance5.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0);
                            long j4 = 1;
                            if (currentTimeMillis - j2 < instance5.getRetryInterval() * 1000) {
                                j4 = j3 + 1;
                            }
                            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(j4));
                        } else {
                            z6 = z5;
                            jSONObject = a3;
                        }
                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(currentTimeMillis));
                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, b.a(c));
                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.b(c)));
                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, b.a(c, TBS_METADATA));
                        instance5.commit();
                        if (z6) {
                            if (z) {
                                TbsDownloadUpload instance6 = TbsDownloadUpload.getInstance(c);
                                instance6.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_8));
                                instance6.commit();
                                return false;
                            } else if (z3) {
                                return false;
                            } else {
                                TbsDownloadUpload instance7 = TbsDownloadUpload.getInstance(c);
                                instance7.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_8));
                                instance7.commit();
                                return false;
                            }
                        }
                    } else {
                        jSONObject = a3;
                    }
                    if (i2 == -1 || z3) {
                        String d2 = n.a(c).d();
                        TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + d2);
                        if (!z) {
                            TbsDownloadUpload instance8 = TbsDownloadUpload.getInstance(c);
                            instance8.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_9));
                            instance8.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 1);
                            instance8.commit();
                            TbsLog.i(LOGTAG, "sendRequest query 148");
                        } else if (!z3) {
                            TbsDownloadUpload instance9 = TbsDownloadUpload.getInstance(c);
                            instance9.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_9));
                            instance9.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 1);
                            instance9.commit();
                            TbsLog.i(LOGTAG, "sendRequest download 168");
                        }
                        try {
                            return a(g.a(d2, jSONObject.toString().getBytes("utf-8"), new g.a() {
                                /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass2 */

                                @Override // com.tencent.smtt.utils.g.a
                                public void a(int i) {
                                    instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
                                    instance5.commit();
                                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i);
                                    if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && i == 200) {
                                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
                                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                                        instance5.commit();
                                    }
                                    if (i < 300) {
                                        return;
                                    }
                                    if (z) {
                                        instance5.setDownloadInterruptCode(-107);
                                    } else {
                                        instance5.setDownloadInterruptCode(-207);
                                    }
                                }
                            }, false), i2, z, z2, z4);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        if (z) {
                            TbsDownloadUpload instance10 = TbsDownloadUpload.getInstance(c);
                            instance10.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_10));
                            instance10.commit();
                        } else if (!z3) {
                            TbsDownloadUpload instance11 = TbsDownloadUpload.getInstance(c);
                            instance11.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_10));
                            instance11.commit();
                        }
                        return false;
                    }
                }
            }
            z5 = false;
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, b.a(c));
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.b(c)));
            instance5.commit();
            JSONObject a32 = a(z, z2, z3);
            try {
                i2 = a32.getInt("TBSV");
            } catch (Exception unused2) {
                i2 = -1;
            }
            if (!z5) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!TbsShareManager.isThirdPartyApp(c)) {
            }
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(currentTimeMillis2));
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, b.a(c));
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.b(c)));
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, b.a(c, TBS_METADATA));
            instance5.commit();
            if (z6) {
            }
            if (i2 == -1) {
            }
            try {
                String d22 = n.a(c).d();
                TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + d22);
                if (!z) {
                }
                return a(g.a(d22, jSONObject.toString().getBytes("utf-8"), new g.a() {
                    /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass2 */

                    @Override // com.tencent.smtt.utils.g.a
                    public void a(int i) {
                        instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
                        instance5.commit();
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=" + i);
                        if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && i == 200) {
                            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
                            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                            instance5.commit();
                        }
                        if (i < 300) {
                            return;
                        }
                        if (z) {
                            instance5.setDownloadInterruptCode(-107);
                        } else {
                            instance5.setDownloadInterruptCode(-207);
                        }
                    }
                }, false), i2, z, z2, z4);
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                if (z) {
                    instance5.setDownloadInterruptCode(-106);
                } else {
                    instance5.setDownloadInterruptCode(-206);
                }
                return false;
            }
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            if (z) {
                TbsDownloadUpload instance12 = TbsDownloadUpload.getInstance(c);
                instance12.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_6));
                instance12.commit();
            } else if (!z3) {
                TbsDownloadUpload instance13 = TbsDownloadUpload.getInstance(c);
                instance13.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_6));
                instance13.commit();
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x07da  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0230 A[Catch:{ Exception -> 0x0278 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0240 A[Catch:{ Exception -> 0x0278 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x024e  */
    private static boolean a(String str, int i2, boolean z, boolean z2, boolean z3) throws Exception {
        int i3;
        int i4;
        String str2;
        String str3;
        int i5;
        String str4;
        int i6;
        int i7;
        boolean z4;
        boolean z5;
        String str5;
        boolean z6;
        int i8;
        int i9;
        int i10;
        int i11;
        long j2;
        int i12;
        int i13;
        boolean z7;
        int i14;
        Integer num;
        boolean z8;
        boolean z9;
        boolean z10;
        int i15;
        int i16;
        String str6;
        boolean z11;
        String str7;
        Throwable th;
        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] response=" + str + "isNeedInstall=" + z3);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                instance.setDownloadInterruptCode(-108);
            } else {
                instance.setDownloadInterruptCode(-208);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        int i17 = jSONObject.getInt("RET");
        if (i17 != 0) {
            if (z) {
                instance.setDownloadInterruptCode(-109);
            } else {
                instance.setDownloadInterruptCode(-209);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=" + i17);
            return false;
        }
        int i18 = jSONObject.getInt("RESPONSECODE");
        String string = jSONObject.getString("DOWNLOADURL");
        String optString = jSONObject.optString("URLLIST", "");
        int i19 = jSONObject.getInt("TBSAPKSERVERVERSION");
        int i20 = jSONObject.getInt("DOWNLOADMAXFLOW");
        int i21 = jSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i22 = jSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i23 = jSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j3 = jSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j4 = jSONObject.getLong("TBSAPKFILESIZE");
        long optLong = jSONObject.optLong("RETRY_INTERVAL", 0);
        int optInt = jSONObject.optInt("FLOWCTR", -1);
        try {
            i3 = jSONObject.getInt("USEBBACKUPVER");
        } catch (Exception unused) {
            i3 = 0;
        }
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, Integer.valueOf(i3));
        if (!z || !QbSdk.i || !TbsShareManager.isThirdPartyApp(c)) {
            i4 = i21;
        } else {
            try {
                i4 = i21;
                try {
                    TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME, jSONObject.optInt("BUGLY", 0) == 1);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                i4 = i21;
                TbsLog.i("qbsdk", "throwable:" + th.toString());
                if (z) {
                }
                str2 = "";
                str6 = jSONObject.getString("PKGMD5");
                i16 = jSONObject.getInt("RESETX5");
                try {
                    i15 = jSONObject.getInt("UPLOADLOG");
                    try {
                        if (!jSONObject.has("RESETTOKEN")) {
                        }
                    } catch (Exception unused2) {
                        z11 = false;
                        z10 = true;
                        str4 = str6;
                        str3 = optString;
                        z5 = z10;
                        i5 = i20;
                        i7 = i15;
                        i6 = i16;
                        z4 = z11;
                        str5 = str2;
                        z6 = true;
                        i8 = jSONObject.getInt("RESETDECOUPLECORE");
                        i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                        synchronized (f) {
                        }
                    }
                } catch (Exception unused3) {
                    z11 = false;
                    i15 = 0;
                    z10 = true;
                    str4 = str6;
                    str3 = optString;
                    z5 = z10;
                    i5 = i20;
                    i7 = i15;
                    i6 = i16;
                    z4 = z11;
                    str5 = str2;
                    z6 = true;
                    i8 = jSONObject.getInt("RESETDECOUPLECORE");
                    i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                    synchronized (f) {
                    }
                }
                try {
                    if (jSONObject.has("SETTOKEN")) {
                    }
                    if (!jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK")) {
                    }
                    try {
                        if (jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT")) {
                        }
                        str3 = optString;
                        z4 = z11;
                        str5 = str7;
                        str4 = str6;
                        z5 = z10;
                        i5 = i20;
                        i7 = i15;
                        i6 = i16;
                    } catch (Exception unused4) {
                        str2 = str7;
                        str4 = str6;
                        str3 = optString;
                        z5 = z10;
                        i5 = i20;
                        i7 = i15;
                        i6 = i16;
                        z4 = z11;
                        str5 = str2;
                        z6 = true;
                        i8 = jSONObject.getInt("RESETDECOUPLECORE");
                        i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                        synchronized (f) {
                        }
                    }
                } catch (Exception unused5) {
                    str2 = str7;
                    z10 = true;
                    str4 = str6;
                    str3 = optString;
                    z5 = z10;
                    i5 = i20;
                    i7 = i15;
                    i6 = i16;
                    z4 = z11;
                    str5 = str2;
                    z6 = true;
                    i8 = jSONObject.getInt("RESETDECOUPLECORE");
                    i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                    synchronized (f) {
                    }
                }
                i8 = jSONObject.getInt("RESETDECOUPLECORE");
                i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                synchronized (f) {
                }
            }
        }
        if (z) {
            try {
                int optInt2 = jSONObject.optInt("TEMPLATESWITCH", 0);
                boolean z12 = (optInt2 & 1) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME, z12);
                TbsLog.w(LOGTAG, "useCookieCompatiable:" + z12);
                boolean z13 = (optInt2 & 2) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME, z13);
                TbsLog.w(LOGTAG, "disableGetApkVersionByReadFile:" + z13);
                boolean z14 = (optInt2 & 4) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.DISABLE_UNPREINIT, z14);
                QbSdk.setDisableUnpreinitBySwitch(z14);
                TbsLog.i(LOGTAG, "disableUnpreinitBySwitch:" + z14);
                boolean z15 = (optInt2 & 8) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.DISABLE_USE_HOST_BACKUP_CORE, z15);
                QbSdk.setDisableUseHostBackupCoreBySwitch(z15);
                TbsLog.i(LOGTAG, "disableUseHostBackupCoreBySwitch:" + z15);
            } catch (Throwable th4) {
                TbsLog.i("qbsdk", "throwable:" + th4.toString());
            }
        }
        str2 = "";
        try {
            str6 = jSONObject.getString("PKGMD5");
            try {
                i16 = jSONObject.getInt("RESETX5");
                i15 = jSONObject.getInt("UPLOADLOG");
                if (!jSONObject.has("RESETTOKEN")) {
                    try {
                        z11 = jSONObject.getInt("RESETTOKEN") != 0;
                        str7 = str2;
                    } catch (Exception unused6) {
                        z11 = false;
                        z10 = true;
                        str4 = str6;
                        str3 = optString;
                        z5 = z10;
                        i5 = i20;
                        i7 = i15;
                        i6 = i16;
                        z4 = z11;
                        str5 = str2;
                        z6 = true;
                        i8 = jSONObject.getInt("RESETDECOUPLECORE");
                        i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                        synchronized (f) {
                        }
                    }
                } else {
                    str7 = str2;
                    z11 = false;
                }
                if (jSONObject.has("SETTOKEN")) {
                    str7 = jSONObject.getString("SETTOKEN");
                }
                if (!jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK")) {
                    z10 = jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK") != 0;
                } else {
                    z10 = true;
                }
                z6 = jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT") || jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT") != 0;
                str3 = optString;
                z4 = z11;
                str5 = str7;
                str4 = str6;
                z5 = z10;
                i5 = i20;
                i7 = i15;
                i6 = i16;
            } catch (Exception unused7) {
                z11 = false;
                i16 = 0;
                i15 = 0;
                z10 = true;
                str4 = str6;
                str3 = optString;
                z5 = z10;
                i5 = i20;
                i7 = i15;
                i6 = i16;
                z4 = z11;
                str5 = str2;
                z6 = true;
                i8 = jSONObject.getInt("RESETDECOUPLECORE");
                i9 = jSONObject.getInt("RESETTODECOUPLECORE");
                synchronized (f) {
                }
            }
        } catch (Exception unused8) {
            z11 = false;
            str6 = null;
            i16 = 0;
            i15 = 0;
            z10 = true;
            str4 = str6;
            str3 = optString;
            z5 = z10;
            i5 = i20;
            i7 = i15;
            i6 = i16;
            z4 = z11;
            str5 = str2;
            z6 = true;
            i8 = jSONObject.getInt("RESETDECOUPLECORE");
            i9 = jSONObject.getInt("RESETTODECOUPLECORE");
            synchronized (f) {
            }
        }
        try {
            i8 = jSONObject.getInt("RESETDECOUPLECORE");
        } catch (Exception unused9) {
            i8 = 0;
        }
        try {
            i9 = jSONObject.getInt("RESETTODECOUPLECORE");
        } catch (Exception unused10) {
            i9 = 0;
        }
        synchronized (f) {
            if (z4) {
                i11 = i18;
                i10 = i19;
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
            } else {
                i11 = i18;
                i10 = i19;
            }
            if (!TextUtils.isEmpty(str5) && str5.length() == 96) {
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, str5 + "&" + h.c());
            }
        }
        if (i6 == 1) {
            if (z) {
                instance.setDownloadInterruptCode(-110);
            } else {
                instance.setDownloadInterruptCode(-210);
            }
            QbSdk.reset(c, i9 == 1);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=" + z);
            return false;
        }
        if (!z5) {
            instance.setTbsCoreLoadRenameFileLockEnable(z5);
        }
        if (!z6) {
            instance.setTbsCoreLoadRenameFileLockWaitEnable(z6);
        }
        if (i8 == 1) {
            QbSdk.resetDecoupleCore(c);
        }
        if (i7 == 1) {
            d.removeMessages(104);
            Message.obtain(d, 104).sendToTarget();
        }
        long j5 = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        if (optInt == 1) {
            if (optLong > 604800) {
                optLong = 604800;
            }
            j2 = 0;
            if (optLong > 0) {
                j5 = optLong;
            }
        } else {
            j2 = 0;
        }
        if (getRetryIntervalInSeconds() >= j2) {
            j5 = getRetryIntervalInSeconds();
        }
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(j5));
        if (z) {
            try {
                i12 = jSONObject.getInt("DECOUPLECOREVERSION");
            } catch (Exception unused11) {
                i12 = 0;
            }
        } else {
            i12 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        }
        try {
            i13 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        } catch (Exception unused12) {
            i13 = 0;
        }
        if (z && !TbsShareManager.isThirdPartyApp(c) && i12 == 0) {
            i12 = m.a().h(c);
        }
        TbsLog.i(LOGTAG, "in response decoupleCoreVersion is " + i12);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, Integer.valueOf(i12));
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(i13));
        if (!TbsShareManager.isThirdPartyApp(c)) {
            if (i12 > 0 && i12 != m.a().h(c) && i12 == m.a().i(c)) {
                m.a().n(c);
            } else if (i12 == 0) {
                try {
                    f.b(m.a().p(c));
                } catch (Throwable unused13) {
                }
            }
        }
        if (!TextUtils.isEmpty(string) || !TbsShareManager.isThirdPartyApp(c)) {
            TbsLog.i(LOGTAG, "in response responseCode is " + i11);
            if (i11 == 0) {
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i11));
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                if (z) {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -111);
                } else {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -211);
                    instance.setDownloadInterruptCode(-211);
                }
                instance.commit();
                if (!TbsShareManager.isThirdPartyApp(c)) {
                    startDecoupleCoreIfNeeded();
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
                return false;
            }
            int i24 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (i24 > i10) {
                g.c();
                m.a().o(c);
            }
            if (!TbsShareManager.isThirdPartyApp(c)) {
                int e2 = m.a().e(c, 0);
                z7 = e2 >= i10;
                TbsLog.i(LOGTAG, "tmpCoreVersion is " + e2 + " tbsDownloadVersion is" + i10);
                i14 = i2;
            } else {
                i14 = i2;
                z7 = false;
            }
            if ((i14 >= i10 || TextUtils.isEmpty(string) || z7) && i13 != 1) {
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                if (!z) {
                    int i25 = -212;
                    if (TextUtils.isEmpty(string)) {
                        i25 = -217;
                    } else if (i10 <= 0) {
                        i25 = -218;
                    } else if (i14 >= i10) {
                        i25 = -219;
                    }
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(i25));
                    instance.setDownloadInterruptCode(i25);
                } else if (TextUtils.isEmpty(string)) {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -124);
                } else if (i10 <= 0) {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -125);
                } else if (i14 >= i10) {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -127);
                } else {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -112);
                }
                instance.commit();
                TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i14 + " tbsDownloadVersion=" + i10 + " tbsLastDownloadVersion=" + i24 + " downloadUrl=" + string);
                return false;
            }
            if (!string.equals(instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                g.c();
                num = 0;
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, null);
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, null);
            } else {
                num = 0;
            }
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i10));
            TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is " + i10);
            if (i10 > 0) {
                if (i13 == 1) {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 1);
                } else {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, num);
                }
                TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is " + i13);
            }
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string);
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, str3);
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i11));
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i5));
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i4));
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i22));
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i23));
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j3));
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j4));
            instance.commit();
            if (str4 != null) {
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, str4);
            }
            if (z2 || !z3 || !m.a().b(c, i10)) {
                if (!z2 && z3) {
                    if (g.a(z2, i11 == 1 || i11 == 2)) {
                        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                        tbsLogInfo.setErrorCode(100);
                        tbsLogInfo.setFailDetail("use local backup apk in needDownload" + g.a);
                        if (a(c)) {
                            TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                        } else {
                            TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        }
                        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##7 set needDownload=false");
                    }
                }
                if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 || !g.a()) {
                    if (!z) {
                        instance.setDownloadInterruptCode(-216);
                    }
                    z8 = true;
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                    TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##9 set needDownload=true");
                    if (jSONObject.optInt("stop_pre_oat", 0) == z8) {
                        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, Boolean.valueOf(z8));
                    }
                    instance.commit();
                    return z8;
                }
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(c).tbsLogInfo();
                tbsLogInfo2.setErrorCode(100);
                tbsLogInfo2.setFailDetail("installDecoupleCoreFromBackup" + g.a);
                if (a(c)) {
                    TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo2);
                } else {
                    TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##8 set needDownload=false");
            } else {
                if (z) {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -113);
                } else {
                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -213);
                    instance.setDownloadInterruptCode(-213);
                }
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##6 set needDownload=false");
            }
            z8 = true;
            if (jSONObject.optInt("stop_pre_oat", 0) == z8) {
            }
            instance.commit();
            return z8;
        }
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        instance.commit();
        if (z) {
            z9 = false;
            TbsShareManager.writeCoreInfoForThirdPartyApp(c, i10, false);
        } else {
            z9 = false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #4,current app is third app...");
        return z9;
    }

    public static void setRetryIntervalInSeconds(Context context, long j2) {
        if (context != null) {
            if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
                l = j2;
            }
            TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
        }
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    static String b(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (str == null) {
            stringBuffer.append("1.0");
        } else if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            try {
                str2 = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused2) {
            }
            if (str2 == null) {
                stringBuffer.append("; ");
            } else if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String replaceAll = (Build.ID == null ? "" : Build.ID).replaceAll("[一-龥]", "");
        if (replaceAll == null) {
            stringBuffer.append(" Build/");
            stringBuffer.append("00");
        } else if (replaceAll.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(replaceAll);
        }
        String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        b = format;
        return format;
    }

    static void c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        j.c(context);
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("tbs_extension_config", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("tbs_extension_config", 0);
        }
        sharedPreferences.edit().clear().commit();
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        } else {
            sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
        }
        sharedPreferences2.edit().clear().commit();
    }

    private static boolean h() {
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            instance.setDownloadInterruptCode(-115);
            return false;
        } else if (instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            instance.setDownloadInterruptCode(-116);
            return false;
        } else if (!f.b(c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            instance.setDownloadInterruptCode(-117);
            return false;
        } else {
            if (System.currentTimeMillis() - instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= 86400000) {
                long j2 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j2);
                if (j2 >= instance.getDownloadMaxflow()) {
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    instance.setDownloadInterruptCode(-120);
                    return false;
                }
            }
            return true;
        }
    }

    protected static File a(int i2) {
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = coreProviderAppList[i3];
            if (!str.equals(c.getApplicationInfo().packageName)) {
                file = new File(f.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
                if (!file.exists()) {
                    TbsLog.i(LOGTAG, "can not find local backup core file");
                } else if (a.a(c, file) == i2) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i(LOGTAG, "version is not match");
                }
            }
            i3++;
        }
        return file;
    }

    protected static File b(int i2) {
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i3 = 0;
        while (i3 < length) {
            String str = coreProviderAppList[i3];
            File file2 = new File(f.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            if (!file2.exists() || a.a(c, file2) != i2) {
                file2 = new File(f.a(c, str, 4, false), "x5.tbs.decouple");
                if (!file2.exists() || a.a(c, file2) != i2) {
                    i3++;
                    file = file2;
                } else {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                }
            } else {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
            }
            return file2;
        }
        return file;
    }

    private static JSONArray a(boolean z) {
        File file;
        boolean z2;
        JSONArray jSONArray = new JSONArray();
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            if (z) {
                file = new File(f.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            } else {
                file = new File(f.a(c, str, 4, false), "x5.tbs.decouple");
            }
            if (file.exists()) {
                long a2 = (long) a.a(c, file);
                if (a2 > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (((long) jSONArray.optInt(i2)) == a2) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }
}
