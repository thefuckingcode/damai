package com.alibaba.motu.crashreporter2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.ArrayMap;
import android.util.Log;
import android.webkit.ValueCallback;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.motu.crashreporter.CrashReport;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter.ReporterContext;
import com.alibaba.motu.crashreporter.async.AsyncThreadPool;
import com.alibaba.motu.crashreporter.ignores.NonSystemThreadIgnore;
import com.alibaba.motu.crashreporter.ignores.UncaughtExceptionIgnore;
import com.alibaba.motu.crashreporter.memory.MemoryTracker;
import com.alibaba.motu.crashreporter2.DelayANRChecker;
import com.alibaba.motu.crashreporter2.LooperMessagePrinter;
import com.alibaba.motu.crashreporter2.Utils;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.annotation.JSMethod;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.VersionInfo;
import com.uc.webview.export.media.MessageID;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public final class CatcherManager {
    private static final String DEFAULT_VALUE = "false";
    private static final int MAX_COUNT = 64;
    private static final String TAG = "CatcherManager";
    private String[] activityInfoList = new String[64];
    private String lastUrl = null;
    ANRCatcher mANRCatcher;
    final String mAppVersion;
    Configuration mConfiguration;
    Context mContext;
    CrashApi mCrashApi = null;
    String mCurrentViewName;
    boolean mIsForeground = false;
    Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        /* class com.alibaba.motu.crashreporter2.CatcherManager.AnonymousClass1 */
        private static final String KEY_PRE = "track";
        private int count = 0;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        private AtomicInteger index = new AtomicInteger(0);
        private int mStartCount;

        @TargetApi(14)
        private void appendActivityInfo(final Activity activity, final String str, final String str2) {
            final int i = this.count;
            this.count = i + 1;
            final String simpleName = activity.getClass().getSimpleName();
            AsyncThreadPool.start(new Runnable() {
                /* class com.alibaba.motu.crashreporter2.CatcherManager.AnonymousClass1.AnonymousClass1 */

                public void run() {
                    try {
                        AnonymousClass1.this.date.setTime(System.currentTimeMillis());
                        StringBuilder sb = new StringBuilder();
                        sb.append(simpleName);
                        sb.append(JSMethod.NOT_SET);
                        sb.append(str);
                        sb.append(" ,data:");
                        sb.append(str2);
                        sb.append(" ,");
                        AnonymousClass1 r3 = AnonymousClass1.this;
                        sb.append(r3.dateFormat.format(r3.date));
                        Debug.MemoryInfo realTimeStatus = MemoryTracker.getRealTimeStatus(activity);
                        if (realTimeStatus != null) {
                            sb.append(" ,totalPss:");
                            sb.append(realTimeStatus.getTotalPss() >> 10);
                            sb.append(" ,dalvikPss:");
                            sb.append(realTimeStatus.dalvikPss >> 10);
                            sb.append(" ,nativePss:");
                            sb.append(realTimeStatus.nativePss >> 10);
                            if (Build.VERSION.SDK_INT >= 23) {
                                try {
                                    sb.append(" ,graphics:");
                                    sb.append(Integer.valueOf(realTimeStatus.getMemoryStat("summary.graphics")).intValue() >> 10);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        sb.append(MemReader.readMemContent());
                        String sb2 = sb.toString();
                        int andIncrement = AnonymousClass1.this.index.getAndIncrement() & 63;
                        String[] strArr = CatcherManager.this.activityInfoList;
                        strArr[andIncrement] = "track_" + andIncrement + ": " + i + ":" + sb2;
                        CrashApi crashApi = CatcherManager.this.mCrashApi;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("track_");
                        sb3.append(andIncrement);
                        String sb4 = sb3.toString();
                        crashApi.addHeaderInfo(sb4, i + ":" + sb2);
                    } catch (Throwable unused) {
                    }
                }
            });
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            CatcherManager.this.mCurrentViewName = activity.getClass().getName();
        }

        public void onActivityDestroyed(Activity activity) {
            LogUtil.d("onActivityDestroyed：" + activity.getClass().getName());
        }

        public void onActivityPaused(Activity activity) {
            LogUtil.d("onActivityPaused：" + activity.getClass().getName());
        }

        public void onActivityResumed(Activity activity) {
            LogUtil.d("onActivityResumed：" + activity.getClass().getName());
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            LogUtil.d("onActivitySaveInstanceState：" + activity.getClass().getName());
        }

        public void onActivityStarted(Activity activity) {
            LogUtil.d("onActivityStarted：" + activity.getClass().getName());
            this.mStartCount = this.mStartCount + 1;
            Intent intent = activity.getIntent();
            String dataString = intent != null ? intent.getDataString() : null;
            if (dataString == null) {
                dataString = "null";
            }
            CatcherManager catcherManager = CatcherManager.this;
            if (!catcherManager.mIsForeground) {
                catcherManager.mIsForeground = true;
                catcherManager.mCrashApi.setForeground(true);
                LogUtil.d("nativeSetForeground foreground");
                appendActivityInfo(activity, "onForeground", dataString);
            } else {
                appendActivityInfo(activity, "onStart", dataString);
            }
            CatcherManager.this.mCurrentViewName = activity.getClass().getName();
            CatcherManager catcherManager2 = CatcherManager.this;
            catcherManager2.addNativeHeaderInfo(Constants.CONTROLLER, catcherManager2.mCurrentViewName);
            CatcherManager catcherManager3 = CatcherManager.this;
            catcherManager3.addNativeHeaderInfo(Constants.FOREGROUND, String.valueOf(catcherManager3.mIsForeground));
            CatcherManager.this.lastUrl = dataString;
            CatcherManager.this.mCrashApi.addHeaderInfo("last_page_url", dataString);
        }

        public void onActivityStopped(Activity activity) {
            LogUtil.d("onActivityStopped：" + activity.getClass().getName());
            this.mStartCount = this.mStartCount + -1;
            Intent intent = activity.getIntent();
            String dataString = intent != null ? intent.getDataString() : null;
            if (dataString == null) {
                dataString = "null";
            }
            if (this.mStartCount <= 0) {
                CatcherManager catcherManager = CatcherManager.this;
                if (catcherManager.mIsForeground) {
                    this.mStartCount = 0;
                    catcherManager.mIsForeground = false;
                    catcherManager.mCurrentViewName = "background";
                    catcherManager.mCrashApi.setForeground(false);
                    LogUtil.d("nativeSetForeground background");
                    CatcherManager catcherManager2 = CatcherManager.this;
                    catcherManager2.addNativeHeaderInfo(Constants.FOREGROUND, String.valueOf(catcherManager2.mIsForeground));
                    appendActivityInfo(activity, "onBackground", dataString);
                    return;
                }
            }
            appendActivityInfo(activity, MessageID.onStop, dataString);
        }
    };
    String mProcessName;
    ReportBuilder mReportBuilder;
    ReporterContext mReporterContext;
    SendManager mSendManager;
    StorageManager mStorageManager;
    UCNativeExceptionCatcher mUCNativeExceptionCatcher;
    UncaughtExceptionCatcher mUncaughtExceptionCatcher;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class UCNativeExceptionCatcher {
        volatile boolean enable = false;
        volatile boolean initCrashsdkSuccess = false;
        Context mContext;
        File mUCCrashsdkBackupDir;
        String mUCCrashsdkBackupDirPath;
        File mUCCrashsdkLogsDir;
        String mUCCrashsdkLogsDirPath;
        File mUCCrashsdkTagsDir;
        String mUCCrashsdkTagsDirPath;
        File mUCCrashsdkTombstonesDir;
        String mUCCrashsdkTombstonesDirPath;

        public UCNativeExceptionCatcher(Context context) {
            this.mContext = context;
            StringBuilder sb = new StringBuilder();
            sb.append(CatcherManager.this.mStorageManager.mProcessTombstoneDirPath);
            String str = File.separator;
            sb.append(str);
            sb.append("crashsdk");
            this.mUCCrashsdkTombstonesDirPath = sb.toString();
            this.mUCCrashsdkTagsDirPath = this.mUCCrashsdkTombstonesDirPath + str + IRequestConst.TAGS;
            this.mUCCrashsdkLogsDirPath = this.mUCCrashsdkTombstonesDirPath + str + "logs";
            this.mUCCrashsdkBackupDirPath = this.mUCCrashsdkTombstonesDirPath + str + "backup";
            this.mUCCrashsdkTombstonesDir = new File(this.mUCCrashsdkTombstonesDirPath);
            this.mUCCrashsdkTagsDir = new File(this.mUCCrashsdkTagsDirPath);
            this.mUCCrashsdkLogsDir = new File(this.mUCCrashsdkLogsDirPath);
            this.mUCCrashsdkBackupDir = new File(this.mUCCrashsdkBackupDirPath);
            if (!this.mUCCrashsdkTombstonesDir.exists()) {
                this.mUCCrashsdkTombstonesDir.mkdirs();
            }
            if (!this.mUCCrashsdkTagsDir.exists()) {
                this.mUCCrashsdkTagsDir.mkdirs();
            }
            if (!this.mUCCrashsdkLogsDir.exists()) {
                this.mUCCrashsdkLogsDir.mkdirs();
            }
            if (!this.mUCCrashsdkBackupDir.exists()) {
                this.mUCCrashsdkBackupDir.mkdirs();
            }
            Bundle bundle = new Bundle();
            String name = CatcherManager.this.mStorageManager.mTombstoneDir.getName();
            bundle.putBoolean("mBackupLogs", false);
            bundle.putString("mLogsBackupPathName", this.mUCCrashsdkBackupDirPath);
            bundle.putString("mTagFilesFolderName", name + "/" + CatcherManager.this.mStorageManager.mProcessName + "/crashsdk/tags");
            bundle.putString("mCrashLogsFolderName", name + "/" + CatcherManager.this.mStorageManager.mProcessName + "/crashsdk/logs");
            try {
                if (new Random().nextFloat() < Float.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getString("ANRPercent", "1")).floatValue()) {
                    bundle.putInt("mAnrTraceStrategy", 2);
                } else {
                    bundle.putInt("mAnrTraceStrategy", 1);
                }
            } catch (Exception unused) {
                bundle.putInt("mAnrTraceStrategy", 2);
            }
            bundle.putInt("mMaxAnrLogcatLineCount", 200);
            bundle.putBoolean("mEncryptLog", false);
            bundle.putString("mJavaCrashLogFileName", "java_" + System.currentTimeMillis() + "_java.log");
            bundle.putString("mNativeCrashLogFileName", "native_" + System.currentTimeMillis() + "_jni.log");
            bundle.putBoolean("enableJavaLog", false);
            bundle.putBoolean("enableUnexpLog", true);
            bundle.putBoolean("mCallJavaDefaultHandler", false);
            bundle.putBoolean("mCallNativeDefaultHandler", true);
            bundle.putBoolean("mZipLog", false);
            bundle.putBoolean("mEnableStatReport", false);
            bundle.putBoolean("useApplicationContext", false);
            bundle.putBoolean("mSyncUploadSetupCrashLogs", false);
            bundle.putBoolean("mSyncUploadLogs", false);
            bundle.putLong("mDisableSignals", 16386);
            bundle.putLong("mDisableBackgroundSignals", PlaybackStateCompat.ACTION_PREPARE);
            bundle.putInt("uploadLogDelaySeconds", -1);
            bundle.putInt("mUnexpInfoUpdateInterval", 900);
            bundle.putString("mBuildId", CatcherManager.this.mAppVersion);
            bundle.putBoolean("mMonitorBattery", false);
            CrashApi createInstanceEx = CrashApi.createInstanceEx(context, "native", false, bundle);
            CatcherManager.this.mCrashApi = createInstanceEx;
            createInstanceEx.registerCallback(1, new ValueCallback<Bundle>(CatcherManager.this) {
                /* class com.alibaba.motu.crashreporter2.CatcherManager.UCNativeExceptionCatcher.AnonymousClass1 */

                public void onReceiveValue(Bundle bundle) {
                    try {
                        if ("anr".equals(bundle.getString("logType"))) {
                            CatcherManager.this.sigQuitAction(bundle.getString("filePathName"));
                            return;
                        }
                        TLogAdapter.log(CatcherManager.TAG, "native", "crash happened");
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            CatcherManager.this.mCrashApi.registerInfoCallback(CatcherManager.TAG, 1, new Callable<String>(CatcherManager.this) {
                /* class com.alibaba.motu.crashreporter2.CatcherManager.UCNativeExceptionCatcher.AnonymousClass2 */

                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    try {
                        return "aliab=" + SendService.getInstance().aliab + ";" + "aliabTest=" + SendService.getInstance().aliabTest;
                    } catch (Throwable unused) {
                        return "";
                    }
                }
            });
            CatcherManager.this.mCrashApi.registerCallback(4, new ValueCallback<Bundle>(CatcherManager.this) {
                /* class com.alibaba.motu.crashreporter2.CatcherManager.UCNativeExceptionCatcher.AnonymousClass3 */

                public void onReceiveValue(Bundle bundle) {
                    String string = bundle.getString("filePathName");
                    String string2 = bundle.getString(com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME);
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (file.exists()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME, string2);
                            if ("anr".equals(bundle.getString("logType"))) {
                                try {
                                    String str = SendService.getInstance().aliab;
                                    String str2 = SendService.getInstance().aliabTest;
                                } catch (Throwable unused) {
                                }
                                CatcherManager.this.sigQuitAction(string);
                                return;
                            }
                            CatcherManager.this.mSendManager.sendReport(CatcherManager.this.mReportBuilder.buildNativeExceptionReport(file, hashMap));
                        }
                    }
                }
            });
            if (Build.VERSION.SDK_INT > 23 && "true".equals(PreferenceManager.getDefaultSharedPreferences(context).getString("useMoreMessage", "false"))) {
                Looper.getMainLooper().setMessageLogging(new LooperMessagePrinter(new LooperMessagePrinter.Callback(CatcherManager.this) {
                    /* class com.alibaba.motu.crashreporter2.CatcherManager.UCNativeExceptionCatcher.AnonymousClass4 */
                    final String LONG_MESSAGE = "LONG_MESSAGE";
                    final int LONG_MESSAGE_CAPACITY = 15;
                    final String MESSAGE = "MESSAGE";
                    final int MESSAGE_CAPACITY = 31;
                    CharBuffer charBuffer = CharBuffer.allocate(1024);
                    int longMessageIndex = 0;
                    int messageIndex = 0;

                    @Override // com.alibaba.motu.crashreporter2.LooperMessagePrinter.Callback
                    public void onLongMessage(String str) {
                        if (str.length() > 1000) {
                            str = str.substring(0, 999);
                        }
                        this.charBuffer.clear();
                        CharBuffer append = this.charBuffer.append((CharSequence) "LONG_MESSAGE");
                        StringBuilder sb = new StringBuilder();
                        sb.append(" ");
                        int i = this.longMessageIndex;
                        this.longMessageIndex = i + 1;
                        sb.append(i & 15);
                        append.append((CharSequence) sb.toString());
                        String obj = this.charBuffer.flip().toString();
                        this.charBuffer.clear();
                        CharBuffer charBuffer2 = this.charBuffer;
                        charBuffer2.append((CharSequence) (this.messageIndex + " ")).append((CharSequence) str);
                        UCNativeExceptionCatcher.this.addNativeHeaderInfo(obj, this.charBuffer.flip().toString());
                    }

                    @Override // com.alibaba.motu.crashreporter2.LooperMessagePrinter.Callback
                    public void onMessage(String str) {
                        if (str.length() > 1000) {
                            str = str.substring(0, 999);
                        }
                        this.charBuffer.clear();
                        CharBuffer append = this.charBuffer.append((CharSequence) "MESSAGE");
                        StringBuilder sb = new StringBuilder();
                        sb.append(" ");
                        int i = this.messageIndex;
                        this.messageIndex = i + 1;
                        sb.append(i & 31);
                        append.append((CharSequence) sb.toString());
                        String obj = this.charBuffer.flip().toString();
                        this.charBuffer.clear();
                        CharBuffer charBuffer2 = this.charBuffer;
                        charBuffer2.append((CharSequence) (this.messageIndex + " ")).append((CharSequence) str);
                        UCNativeExceptionCatcher.this.addNativeHeaderInfo(obj, this.charBuffer.flip().toString());
                    }
                }));
            }
            initCrashsdkSo(null);
            LogUtil.d("nativeSetForeground set background after startup");
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void doScan() {
            File[] listFiles;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                File file = this.mUCCrashsdkLogsDir;
                if (file != null && file.exists() && (listFiles = this.mUCCrashsdkLogsDir.listFiles(new FileFilter() {
                    /* class com.alibaba.motu.crashreporter2.CatcherManager.UCNativeExceptionCatcher.AnonymousClass5 */

                    public boolean accept(File file) {
                        if (file.getName().endsWith("jni.log") && file.canRead()) {
                            return true;
                        }
                        if (file.getName().endsWith("anr.log")) {
                            return false;
                        }
                        file.delete();
                        return false;
                    }
                })) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        CatcherManager.this.mSendManager.sendReport(CatcherManager.this.mReportBuilder.buildNativeExceptionReport(file2, new HashMap()));
                    }
                }
            } catch (Exception e) {
                LogUtil.e("find uc native log.", e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.d("find uc native log complete elapsed time:" + (currentTimeMillis2 - currentTimeMillis) + ".ms");
        }

        public void addNativeHeaderInfo(String str, String str2) {
            if (this.initCrashsdkSuccess) {
                try {
                    CatcherManager.this.mCrashApi.addHeaderInfo(str, str2);
                } catch (Exception e) {
                    LogUtil.e("refresh native header info", e);
                } catch (UnsatisfiedLinkError unused) {
                    LogUtil.i("not impl this method  nativeAddHeaderInfo");
                }
            }
        }

        public void closeNativeSignalTerm() {
        }

        public void disable() {
            if (this.initCrashsdkSuccess && this.enable) {
                try {
                    CatcherManager.this.mCrashApi.disableLog(1);
                } catch (Exception e) {
                    LogUtil.e("disable crashsdk", e);
                }
                this.enable = false;
            }
        }

        public void enable() {
            if (this.initCrashsdkSuccess && !this.enable) {
                this.enable = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void initCrashsdkSo(String str) {
            try {
                System.loadLibrary("crashsdk");
                CatcherManager.this.mCrashApi.crashSoLoaded();
                CatcherManager.this.mCrashApi.setForeground(true);
                VersionInfo versionInfo = new VersionInfo();
                CatcherManager catcherManager = CatcherManager.this;
                String str2 = catcherManager.mAppVersion;
                versionInfo.mVersion = str2;
                versionInfo.mBuildId = str2;
                catcherManager.mCrashApi.updateVersionInfo(versionInfo);
                this.initCrashsdkSuccess = true;
            } catch (Throwable th) {
                LogUtil.e("init uc crashsdk", th);
            }
        }

        public void refreshNativeInfo() {
            if (this.initCrashsdkSuccess) {
                try {
                    VersionInfo versionInfo = new VersionInfo();
                    CatcherManager catcherManager = CatcherManager.this;
                    String str = catcherManager.mAppVersion;
                    versionInfo.mBuildId = str;
                    versionInfo.mVersion = str;
                    catcherManager.mCrashApi.updateVersionInfo(versionInfo);
                } catch (Throwable th) {
                    LogUtil.e("refresh native version info", th);
                }
            }
        }

        public void setNativeForeground(boolean z) {
            if (this.initCrashsdkSuccess) {
                try {
                    CatcherManager.this.mCrashApi.setForeground(z);
                } catch (Exception e) {
                    LogUtil.e("setNativeForeground", e);
                } catch (UnsatisfiedLinkError unused) {
                    LogUtil.i("not impl this method  setNativeForeground");
                }
            }
        }
    }

    /* compiled from: Taobao */
    class UncaughtExceptionCatcher implements Thread.UncaughtExceptionHandler {
        Context context;
        private AtomicInteger count;
        volatile boolean enable;
        Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
        CopyOnWriteArrayList<UncaughtExceptionIgnore> mIgnoreList = new CopyOnWriteArrayList<>();
        UncaughtExceptionLinsterAdapterCopyOnWriteArrayList mLinsterList;

        UncaughtExceptionCatcher() {
            this.mLinsterList = new UncaughtExceptionLinsterAdapterCopyOnWriteArrayList();
            this.count = new AtomicInteger(0);
        }

        private Throwable getCausedThrowable(Throwable th) {
            Throwable cause = th.getCause();
            while (true) {
                th = cause;
                if (th == null || th == th) {
                    return th;
                }
                cause = th.getCause();
            }
            return th;
        }

        @TargetApi(26)
        private String getLoadedApkInfo() {
            Application application;
            ArrayMap arrayMap;
            ArrayMap arrayMap2;
            if (Build.VERSION.SDK_INT < 26) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Context context2 = CatcherManager.this.mContext;
            if (context2 instanceof Application) {
                application = (Application) context2;
            } else {
                application = (Application) context2.getApplicationContext();
            }
            ObjectInvoker objectInvoker = ObjectInvoker.wrap(application).get("mLoadedApk");
            ArrayMap arrayMap3 = (ArrayMap) objectInvoker.get("mReceivers").toObject();
            ArrayMap arrayMap4 = new ArrayMap();
            synchronized (arrayMap3) {
                arrayMap4.putAll(arrayMap3);
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < arrayMap4.size(); i++) {
                synchronized (arrayMap3) {
                    arrayMap2 = new ArrayMap((ArrayMap) arrayMap4.valueAt(i));
                }
                for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
                    String name = ((BroadcastReceiver) arrayMap2.keyAt(i2)).getClass().getName();
                    Integer num = (Integer) hashMap.get(name);
                    if (num != null) {
                        hashMap.put(name, Integer.valueOf(num.intValue() + 1));
                    } else {
                        hashMap.put(name, 1);
                    }
                }
            }
            sb.append("receivers:");
            sb.append(hashMap.toString());
            sb.append(StringUtils.LF);
            ArrayMap arrayMap5 = (ArrayMap) objectInvoker.get("mServices").toObject();
            ArrayMap arrayMap6 = new ArrayMap();
            synchronized (arrayMap5) {
                arrayMap6.putAll(arrayMap5);
            }
            HashMap hashMap2 = new HashMap();
            for (int i3 = 0; i3 < arrayMap6.size(); i3++) {
                Context context3 = (Context) arrayMap6.keyAt(i3);
                synchronized (arrayMap5) {
                    arrayMap = new ArrayMap((ArrayMap) arrayMap6.valueAt(i3));
                }
                for (int i4 = 0; i4 < arrayMap.size(); i4++) {
                    String name2 = ((ServiceConnection) arrayMap.keyAt(i4)).getClass().getName();
                    Integer num2 = (Integer) hashMap2.get(name2);
                    if (num2 != null) {
                        hashMap2.put(name2, Integer.valueOf(num2.intValue() + 1));
                    } else {
                        hashMap2.put(name2, 1);
                    }
                }
            }
            sb.append("services:");
            sb.append(hashMap2.toString());
            sb.append(StringUtils.LF);
            return sb.toString();
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00b1 */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[Catch:{ all -> 0x013e }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0083 A[Catch:{ all -> 0x008c }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0 A[Catch:{ all -> 0x00f1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00d2 A[Catch:{ all -> 0x00f1 }, LOOP:1: B:48:0x00b7->B:54:0x00d2, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00dd A[EDGE_INSN: B:80:0x00dd->B:55:0x00dd ?: BREAK  , SYNTHETIC] */
        private void onUncaughtException(Thread thread, Throwable th, boolean z) {
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put(Constants.REPORT_IGNORE, "true");
            }
            String mTLString = Utils.getMTLString(this.context, "build_id");
            if (!TextUtils.isEmpty(mTLString)) {
                hashMap.put("bid", mTLString);
            }
            String str = "null";
            hashMap.put("aliab", SendService.getInstance().aliab != null ? SendService.getInstance().aliab : str);
            if (SendService.getInstance().aliabTest != null) {
                str = SendService.getInstance().aliabTest;
            }
            hashMap.put("aliabTest", str);
            try {
                if (CatcherManager.this.mConfiguration.getBoolean(Configuration.enableExternalLinster, true)) {
                    Iterator it = this.mLinsterList.iterator();
                    while (it.hasNext()) {
                        try {
                            Map<String, Object> onUncaughtException = ((UncaughtExceptionLinster) it.next()).onUncaughtException(thread, th);
                            if (onUncaughtException != null) {
                                hashMap.putAll(onUncaughtException);
                            }
                        } catch (Throwable th2) {
                            LogUtil.w("call linster onUncaughtException", th2);
                        }
                    }
                }
                Throwable causedThrowable = getCausedThrowable(th);
                try {
                    if (causedThrowable instanceof OutOfMemoryError) {
                        hashMap.put("threads list", ThreadHelper.getThreads2String());
                    }
                } catch (Throwable unused) {
                }
                if ((causedThrowable instanceof AndroidRuntimeException) || (causedThrowable instanceof IllegalArgumentException)) {
                    String message = causedThrowable.getMessage();
                    if ("can't deliver broadcast".equals(message) || "regist too many Broadcast Receivers".equals(message)) {
                        hashMap.put("receivers&services", getLoadedApkInfo());
                    }
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < CatcherManager.this.activityInfoList.length && i < 64) {
                        String str2 = CatcherManager.this.activityInfoList[i];
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                        sb.append(str2);
                        sb.append(StringUtils.LF);
                        i++;
                    }
                    hashMap.put("last_page_url", CatcherManager.this.lastUrl);
                    hashMap.put("track list:", sb.toString());
                } catch (Throwable unused2) {
                }
                Long contextFirstInstallTime = Utils.getContextFirstInstallTime(this.context);
                if (contextFirstInstallTime != null) {
                    hashMap.put(Constants.FIRST_INSTALL_TIME, contextFirstInstallTime);
                }
                Long contextLastUpdateTime = Utils.getContextLastUpdateTime(this.context);
                if (contextLastUpdateTime != null) {
                    hashMap.put(Constants.LAST_UPDATE_TIME, contextLastUpdateTime);
                }
                if (!TextUtils.isEmpty(CatcherManager.this.mCurrentViewName)) {
                    hashMap.put(Constants.CONTROLLER, CatcherManager.this.mCurrentViewName);
                } else if (CatcherManager.this.mIsForeground) {
                    hashMap.put(Constants.CONTROLLER, "noActivity:foreground");
                } else {
                    hashMap.put(Constants.CONTROLLER, "noActivity:background");
                }
                hashMap.put(Constants.FOREGROUND, Boolean.valueOf(CatcherManager.this.mIsForeground));
            } catch (Throwable th3) {
                LogUtil.e("externalData", th3);
            }
            CatcherManager.this.mSendManager.sendReport(CatcherManager.this.mReportBuilder.buildUncaughtExceptionReport(th, thread, hashMap));
        }

        public boolean addIgnore(UncaughtExceptionIgnore uncaughtExceptionIgnore) {
            if (uncaughtExceptionIgnore == null || !com.alibaba.motu.tbrest.utils.StringUtils.isNotBlank(uncaughtExceptionIgnore.getName())) {
                return false;
            }
            return this.mIgnoreList.add(uncaughtExceptionIgnore);
        }

        public boolean addLinster(UncaughtExceptionLinster uncaughtExceptionLinster) {
            if (uncaughtExceptionLinster != null) {
                return this.mLinsterList.add(uncaughtExceptionLinster);
            }
            return false;
        }

        public void disable() {
            if (this.enable) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultUncaughtExceptionHandler;
                if (uncaughtExceptionHandler != null) {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                this.enable = false;
            }
        }

        public void enable(Context context2) {
            if (context2 != null) {
                this.context = context2;
            }
            if (!this.enable) {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                this.mDefaultUncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                "com.android.internal.osRuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName());
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.enable = true;
            }
        }

        public List<UncaughtExceptionLinster> getAllLinster() {
            return this.mLinsterList;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                StringBuilder sb = new StringBuilder();
                StackTraceElement[] stackTrace = th.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append("\tat " + stackTraceElement);
                }
                TLogAdapter.log(CatcherManager.TAG, thread.getName(), sb.toString());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                LogUtil.d(String.format("catch uncaught exception:%s on thread:%s.", thread.getName(), th.toString()));
                boolean booleanValue = Utils.isMainThread(thread).booleanValue();
                if (CatcherManager.this.mConfiguration.getBoolean(Configuration.enableUncaughtExceptionIgnore, true) && !booleanValue) {
                    Iterator<UncaughtExceptionIgnore> it = this.mIgnoreList.iterator();
                    while (it.hasNext()) {
                        if (it.next().uncaughtExceptionIgnore(thread, th)) {
                            onUncaughtException(thread, th, true);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                LogUtil.e("ignore uncaught exception.", e);
            } catch (Throwable th3) {
                LogUtil.e("uncaught exception.", th3);
            }
            if (1 == this.count.addAndGet(1)) {
                onUncaughtException(thread, th, false);
            } else {
                LogUtil.i("uncaught exception count: " + this.count.get());
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.d("catch uncaught exception complete elapsed time:" + (currentTimeMillis2 - currentTimeMillis) + ".ms");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultUncaughtExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    /* compiled from: Taobao */
    public interface UncaughtExceptionLinster {
        Map<String, Object> onUncaughtException(Thread thread, Throwable th);

        boolean originalEquals(Object obj);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class UncaughtExceptionLinsterAdapterCopyOnWriteArrayList extends CopyOnWriteArrayList<UncaughtExceptionLinster> {
        private static final long serialVersionUID = 4393313111950638180L;

        UncaughtExceptionLinsterAdapterCopyOnWriteArrayList() {
        }

        @Override // java.util.List, java.util.concurrent.CopyOnWriteArrayList
        public boolean remove(Object obj) {
            Iterator it = iterator();
            while (it.hasNext()) {
                UncaughtExceptionLinster uncaughtExceptionLinster = (UncaughtExceptionLinster) it.next();
                if (uncaughtExceptionLinster.originalEquals(obj)) {
                    return super.remove(uncaughtExceptionLinster);
                }
            }
            return false;
        }
    }

    public CatcherManager(Context context, String str, ReporterContext reporterContext, Configuration configuration, StorageManager storageManager, ReportBuilder reportBuilder, SendManager sendManager) {
        Global.setContext(context);
        Global.setProcessName(str);
        this.mReporterContext = reporterContext;
        this.mContext = context;
        this.mProcessName = str;
        this.mConfiguration = configuration;
        this.mStorageManager = storageManager;
        this.mReportBuilder = reportBuilder;
        this.mSendManager = sendManager;
        if (reporterContext != null) {
            this.mAppVersion = reporterContext.getProperty(Constants.APP_VERSION);
        } else {
            this.mAppVersion = "DEFAULT";
        }
        if (configuration.getBoolean(Configuration.enableUncaughtExceptionCatch, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            UncaughtExceptionCatcher uncaughtExceptionCatcher = new UncaughtExceptionCatcher();
            this.mUncaughtExceptionCatcher = uncaughtExceptionCatcher;
            uncaughtExceptionCatcher.addIgnore(new NonSystemThreadIgnore());
            LogUtil.d("CrashSDK UncaughtExceptionCatcher initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
        if (configuration.getBoolean(Configuration.enableNativeExceptionCatch, true)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.mUCNativeExceptionCatcher = new UCNativeExceptionCatcher(context);
            LogUtil.d("CrashSDK UCNativeExceptionCatcher initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
        }
        if (configuration.getBoolean(Configuration.enableANRCatch, true)) {
            long currentTimeMillis3 = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT <= 23) {
                ANRCatcher aNRCatcher = new ANRCatcher();
                this.mANRCatcher = aNRCatcher;
                AsyncThreadPool.start(aNRCatcher);
            } else {
                doAnrAction();
            }
            LogUtil.d("CrashSDK ANRCatcher initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
        }
        if (configuration.getBoolean(Configuration.enableMainLoopBlockCatch, true)) {
            LogUtil.d("CrashSDK MainLoopCatcher initialize failure，please use MotuWatch SDK ");
        }
    }

    private void doAnrAction() {
        AsyncThreadPool.start(new Runnable() {
            /* class com.alibaba.motu.crashreporter2.CatcherManager.AnonymousClass2 */

            public void run() {
                File[] listFiles;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CatcherManager.this.mStorageManager.mProcessTombstoneDirPath);
                    String str = File.separator;
                    sb.append(str);
                    sb.append("crashsdk");
                    File file = new File(sb.toString() + str + "logs");
                    if (file.exists() && (listFiles = file.listFiles(new FileFilter() {
                        /* class com.alibaba.motu.crashreporter2.CatcherManager.AnonymousClass2.AnonymousClass1 */

                        public boolean accept(File file) {
                            return file.getName().endsWith("anr.log") && file.canRead();
                        }
                    })) != null) {
                        boolean isIdle = LastAnrStatusManager.instance().isIdle();
                        LastAnrStatusManager.instance().clearIdle();
                        for (File file2 : listFiles) {
                            if (file2 != null && !isIdle) {
                                new ANRCatcher(file2.getAbsolutePath(), true, false).doScan();
                            } else if (file2 != null) {
                                file2.delete();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sigQuitAction(final String str) {
        Log.e(TAG, str);
        if (Build.VERSION.SDK_INT > 23) {
            final File file = new File(str);
            if (file.exists()) {
                DelayANRChecker.performAnrCheck(this.mContext, new DelayANRChecker.Callback() {
                    /* class com.alibaba.motu.crashreporter2.CatcherManager.AnonymousClass3 */

                    @Override // com.alibaba.motu.crashreporter2.DelayANRChecker.Callback
                    public void onMyANRHappened() {
                        Log.d(CatcherManager.TAG, "my process anr");
                        new ANRCatcher(str, true, true).doScan();
                        LastAnrStatusManager.instance().clearIdle();
                    }

                    @Override // com.alibaba.motu.crashreporter2.DelayANRChecker.Callback
                    public void onOtherANRHappened() {
                        Log.d(CatcherManager.TAG, "other process anr");
                        try {
                            file.delete();
                            LastAnrStatusManager.instance().clearIdle();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
    }

    public void addNativeHeaderInfo(String str, String str2) {
        this.mUCNativeExceptionCatcher.addNativeHeaderInfo(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void addUncaughtExceptionIgnore(UncaughtExceptionIgnore uncaughtExceptionIgnore) {
        UncaughtExceptionCatcher uncaughtExceptionCatcher = this.mUncaughtExceptionCatcher;
        if (uncaughtExceptionCatcher != null) {
            uncaughtExceptionCatcher.addIgnore(uncaughtExceptionIgnore);
        }
    }

    /* access modifiers changed from: package-private */
    public void addUncaughtExceptionLinster(UncaughtExceptionLinster uncaughtExceptionLinster) {
        UncaughtExceptionCatcher uncaughtExceptionCatcher = this.mUncaughtExceptionCatcher;
        if (uncaughtExceptionCatcher != null) {
            uncaughtExceptionCatcher.addLinster(uncaughtExceptionLinster);
        }
    }

    public void closeNativeSignalTerm() {
        this.mUCNativeExceptionCatcher.closeNativeSignalTerm();
    }

    /* access modifiers changed from: package-private */
    public void disable() {
        UncaughtExceptionCatcher uncaughtExceptionCatcher = this.mUncaughtExceptionCatcher;
        if (uncaughtExceptionCatcher != null) {
            uncaughtExceptionCatcher.disable();
        }
        UCNativeExceptionCatcher uCNativeExceptionCatcher = this.mUCNativeExceptionCatcher;
        if (uCNativeExceptionCatcher != null) {
            uCNativeExceptionCatcher.disable();
        }
    }

    /* access modifiers changed from: package-private */
    public void doScan() {
        this.mUCNativeExceptionCatcher.doScan();
        ANRCatcher aNRCatcher = this.mANRCatcher;
        if (aNRCatcher != null) {
            aNRCatcher.doScan();
        }
    }

    /* access modifiers changed from: package-private */
    public void enable() {
        UncaughtExceptionCatcher uncaughtExceptionCatcher = this.mUncaughtExceptionCatcher;
        if (uncaughtExceptionCatcher != null) {
            uncaughtExceptionCatcher.enable(this.mContext);
        }
        UCNativeExceptionCatcher uCNativeExceptionCatcher = this.mUCNativeExceptionCatcher;
        if (uCNativeExceptionCatcher != null) {
            uCNativeExceptionCatcher.enable();
        }
    }

    /* access modifiers changed from: package-private */
    public List<UncaughtExceptionLinster> getAllUncaughtExceptionLinster() {
        UncaughtExceptionCatcher uncaughtExceptionCatcher = this.mUncaughtExceptionCatcher;
        if (uncaughtExceptionCatcher != null) {
            return uncaughtExceptionCatcher.getAllLinster();
        }
        return null;
    }

    public void refreshNativeInfo() {
        this.mUCNativeExceptionCatcher.refreshNativeInfo();
    }

    @TargetApi(14)
    public void registerLifeCallbacks(Context context) {
        Application application;
        if ((this.mConfiguration.getBoolean(Configuration.enableUncaughtExceptionCatch, true) || this.mConfiguration.getBoolean(Configuration.enableNativeExceptionCatch, true)) && context != null) {
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            if (application != null) {
                LogUtil.d("register lifecycle callbacks");
                application.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ANRCatcher implements Runnable {
        volatile boolean canScan;
        volatile boolean enable;
        private final boolean isForegroundANR;
        final boolean isSigQuitAnr;
        File mProcessANRFlagFile;
        File mSystemTraceFile;
        String mSystemTraceFilePath;
        AtomicBoolean scaning;

        /* compiled from: Taobao */
        public class TracesFinder {
            boolean found = false;
            File mSystemTraceFile;
            String strEndFlag = "";
            String strPid = "";
            String strProcessName = "";
            String strStartFlag = "";
            String strTriggerTime = "";

            public TracesFinder(File file) {
                this.mSystemTraceFile = file;
            }

            /* JADX WARNING: Removed duplicated region for block: B:53:0x00f3  */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x00ff A[SYNTHETIC, Splitter:B:58:0x00ff] */
            /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
            public void find() {
                BufferedReader bufferedReader;
                Throwable th;
                IOException e;
                String readLine;
                try {
                    File file = this.mSystemTraceFile;
                    if (file != null) {
                        if (file.exists()) {
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.mSystemTraceFile)));
                            do {
                                try {
                                    readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    try {
                                        LogUtil.e("do scan traces file", e);
                                        if (bufferedReader == null) {
                                            bufferedReader.close();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e3) {
                                                LogUtil.e("close traces file", e3);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } while (!com.alibaba.motu.tbrest.utils.StringUtils.isNotBlank(readLine));
                            if (readLine == null) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e4) {
                                    LogUtil.e("close traces file", e4);
                                    return;
                                }
                            } else {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e5) {
                                        LogUtil.e("close traces file", e5);
                                        return;
                                    }
                                } else {
                                    Matcher matcher = Pattern.compile("-----\\spid\\s(\\d+?)\\sat\\s(.+?)\\s-----").matcher(readLine);
                                    if (matcher.find()) {
                                        this.strPid = matcher.group(1);
                                        this.strTriggerTime = matcher.group(2);
                                        Matcher matcher2 = Pattern.compile("Cmd\\sline:\\s(.+)").matcher(readLine2);
                                        if (matcher2.find()) {
                                            String group = matcher2.group(1);
                                            this.strProcessName = group;
                                            if (group.equals(CatcherManager.this.mProcessName)) {
                                                String readLine3 = AppUtils.readLine(ANRCatcher.this.mProcessANRFlagFile);
                                                if (com.alibaba.motu.tbrest.utils.StringUtils.isNotBlank(readLine3)) {
                                                    try {
                                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                        if (simpleDateFormat.parse(this.strTriggerTime).getTime() > simpleDateFormat.parse(readLine3).getTime() && AppUtils.writeFile(ANRCatcher.this.mProcessANRFlagFile, this.strTriggerTime)) {
                                                            this.strStartFlag = readLine;
                                                            this.strEndFlag = String.format("----- end %s -----", this.strPid);
                                                            this.found = true;
                                                        }
                                                    } catch (Exception e6) {
                                                        LogUtil.e("compare triggerTime", e6);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e7) {
                                        LogUtil.e("close traces file", e7);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    LogUtil.e("try to find system trace file, but file not exist. ");
                } catch (IOException e8) {
                    bufferedReader = null;
                    e = e8;
                    LogUtil.e("do scan traces file", e);
                    if (bufferedReader == null) {
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        }

        public ANRCatcher() {
            this.enable = false;
            this.canScan = false;
            this.scaning = new AtomicBoolean(false);
            this.mSystemTraceFilePath = "/data/anr/traces.txt";
            this.isSigQuitAnr = false;
            this.isForegroundANR = false;
        }

        public void doScan() {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.canScan && this.scaning.compareAndSet(false, true)) {
                try {
                    AsyncThreadPool.start(new Runnable() {
                        /* class com.alibaba.motu.crashreporter2.CatcherManager.ANRCatcher.AnonymousClass1 */

                        public void run() {
                            boolean z;
                            CrashReport crashReport;
                            try {
                                long uptimeMillis = SystemClock.uptimeMillis();
                                ANRCatcher aNRCatcher = ANRCatcher.this;
                                TracesFinder tracesFinder = new TracesFinder(aNRCatcher.mSystemTraceFile);
                                tracesFinder.find();
                                long uptimeMillis2 = SystemClock.uptimeMillis();
                                LogUtil.d("CatcherManager scan anr time:" + (uptimeMillis2 - uptimeMillis));
                                try {
                                    z = ANRCatcher.this.mSystemTraceFilePath.contains("anr.log");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    z = false;
                                }
                                if (tracesFinder.found || z) {
                                    HashMap hashMap = new HashMap();
                                    ANRCatcher aNRCatcher2 = ANRCatcher.this;
                                    if (aNRCatcher2.isSigQuitAnr) {
                                        crashReport = CatcherManager.this.mReportBuilder.buildSigQuitANRReport(tracesFinder, aNRCatcher2.isForegroundANR);
                                        try {
                                            tracesFinder.mSystemTraceFile.delete();
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        crashReport = CatcherManager.this.mReportBuilder.buildANRReport(tracesFinder, hashMap);
                                    }
                                    CatcherManager.this.mSendManager.sendReport(crashReport);
                                    Log.e(CatcherManager.TAG, ANRCatcher.this.mSystemTraceFilePath);
                                    TLogAdapter.log(CatcherManager.TAG, ANRCatcher.this.mSystemTraceFilePath);
                                }
                            } catch (Exception e2) {
                                LogUtil.e("send anr report", e2);
                            }
                        }
                    });
                } catch (Exception e) {
                    LogUtil.e("do scan traces file", e);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.d("scaning anr complete elapsed time:" + (currentTimeMillis2 - currentTimeMillis) + ".ms");
        }

        public void run() {
            try {
                this.mSystemTraceFile = new File(this.mSystemTraceFilePath);
                Log.e(CatcherManager.TAG, this.mSystemTraceFilePath);
                if (!this.mSystemTraceFile.exists()) {
                    String str = Utils.SystemPropertiesUtils.get("dalvik.vm.stack-trace-file");
                    if (!this.mSystemTraceFile.equals(str)) {
                        try {
                            this.mSystemTraceFile = new File(str);
                            this.mSystemTraceFilePath = str;
                        } catch (Exception e) {
                            LogUtil.e("system traces file error", e);
                        }
                    }
                }
                if (this.mSystemTraceFile != null) {
                    File processTombstoneFile = CatcherManager.this.mStorageManager.getProcessTombstoneFile("ANR_MONITOR");
                    this.mProcessANRFlagFile = processTombstoneFile;
                    if (processTombstoneFile.exists() || AppUtils.writeFile(this.mProcessANRFlagFile, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())))) {
                        this.canScan = true;
                    }
                }
            } catch (Exception e2) {
                LogUtil.e("anr catcher error ", e2);
            }
        }

        public ANRCatcher(String str, boolean z, boolean z2) {
            this.enable = false;
            this.canScan = false;
            this.scaning = new AtomicBoolean(false);
            this.mSystemTraceFilePath = str;
            this.isSigQuitAnr = z;
            this.isForegroundANR = z2;
            run();
        }
    }
}
