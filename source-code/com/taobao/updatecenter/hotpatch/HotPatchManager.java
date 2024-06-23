package com.taobao.updatecenter.hotpatch;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.preference.PreferenceManager;
import android.taobao.atlas.framework.Atlas;
import android.taobao.atlas.framework.BundleImpl;
import android.taobao.atlas.runtime.BundleLifecycleHandler;
import android.taobao.atlas.versionInfo.BaselineInfoManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alipay.euler.andfix.patch.Patch;
import com.alipay.euler.andfix.patch.PatchManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.hotpatch.monitor.IPatchValidMonitor;
import com.taobao.hotpatch.monitor.IPatchVersionMonitor;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.time.DateUtils;
import tb.ay0;
import tb.by0;
import tb.cy0;
import tb.fw1;
import tb.io1;
import tb.is2;
import tb.sb0;
import tb.u21;
import tb.ub0;
import tb.uo1;
import tb.vo1;
import tb.wg1;
import tb.yo1;
import tb.yx0;
import tb.zx0;

/* compiled from: Taobao */
public class HotPatchManager {
    private static final String ANDFIX_FLAG = "andfix_flag";
    private static final String ANDFIX_TYPE = "andfix";
    private static final String DEFAULT_DIR = "hotpatch";
    private static final String DETAULT_TMP_DIR = "hotpatch_tmp";
    private static final String DEXPATCH_FLAG = "dexpatch_flag";
    private static final String DEXPATCH_MONITOR_KEY = "dexpatchVersion";
    private static final String DEXPATCH_TYPE = "dexpatch";
    private static final String DEXPATCH_VERSION = "dexpatch_version";
    private static final String HOTPATCH_MD5 = "hotpatch_md5";
    private static final String HOTPATCH_MONITOR_KEY = "patchVersion";
    private static final String HOTPATCH_PATH = "hotpatch_path";
    public static final String HOTPATCH_PRIORITY = "hotpatch_priority";
    private static final String HOTPATCH_SIZE = "hotpatch_size";
    private static final String HOTPATCH_VERSION = "hotpatch_version";
    private static final String JAVA_CRASH_FLAG = "is_java_crash";
    private static final String MAIN_DEX = "com_taobao_maindex";
    private static final String MAIN_VERSION = "main_version";
    private static final String NATIVE_CRASH_FLAG = "is_native_crash";
    private static final String PATCHABLE = "use_support";
    private static final String TAG = "HotPatchManager";
    private ArrayList<WeakReference<Activity>> activityList;
    private boolean isAppForeground;
    private boolean isNeedRestart;
    private boolean isSettingRunnable;
    private PatchManager mAndFixManager;
    private int mAndFixPatchVersion;
    private Application mApp;
    private HashMap<String, Object> mContentMap;
    private String mCustomDomain;
    private long mDexPatchVersion;
    private String mGroup;
    private Handler mHandler;
    private boolean mIsAutoLoad;
    private boolean mIsMainProcess;
    private boolean mIsTestMode;
    private ClassLoader mMainDexClassLoader;
    private String mMainVersion;
    private String mPatchDir;
    private PatchStateListener mPatchStateListener;
    private String mPatchTmpDir;
    private IPatchValidMonitor mPatchValidMonitor;
    private IPatchVersionMonitor mPatchVersionMonitor;
    private AtomicBoolean mQueryAtomic;
    private SharedPreferences mSharedPrefrences;
    private boolean mStartExcuted;
    private String mTtid;
    private int mUnEffectAndFixPatchVersion;
    private long mUnEffectDexPatchVersion;

    @TargetApi(14)
    /* compiled from: Taobao */
    class ActivityLifeCycleCallBack implements Application.ActivityLifecycleCallbacks {
        private int a = 0;

        ActivityLifeCycleCallBack() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            HotPatchManager.this.activityList.add(new WeakReference(activity));
        }

        public void onActivityDestroyed(Activity activity) {
            for (int i = 0; i < HotPatchManager.this.activityList.size(); i++) {
                WeakReference weakReference = (WeakReference) HotPatchManager.this.activityList.get(i);
                if (!(weakReference == null || weakReference.get() == null || weakReference.get() != activity)) {
                    HotPatchManager.this.activityList.remove(weakReference);
                }
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            HotPatchManager.this.isAppForeground = true;
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.a++;
        }

        public void onActivityStopped(Activity activity) {
            int i = this.a - 1;
            this.a = i;
            if (i == 0) {
                HotPatchManager.this.isAppForeground = false;
                AppMonitor.Counter.commit("Page_hotpatch", HotPatchManager.DEFAULT_DIR, HotPatchManager.this.mAndFixPatchVersion + "", 1.0d);
                if (HotPatchManager.this.isNeedRestart && !HotPatchManager.this.isSettingRunnable) {
                    HotPatchManager.this.mHandler.postDelayed(new Runnable() {
                        /* class com.taobao.updatecenter.hotpatch.HotPatchManager.ActivityLifeCycleCallBack.AnonymousClass1 */

                        public void run() {
                            if (!HotPatchManager.this.isAppForeground()) {
                                HotPatchManager hotPatchManager = HotPatchManager.this;
                                hotPatchManager.killChildProcesses(hotPatchManager.mApp);
                                Process.killProcess(Process.myPid());
                            }
                            HotPatchManager.this.isSettingRunnable = false;
                        }
                    }, DateUtils.MILLIS_PER_MINUTE);
                    HotPatchManager.this.isSettingRunnable = true;
                    Log.d(HotPatchManager.TAG, "设置杀掉进程定时器成功，间隔重复时间： " + DateUtils.MILLIS_PER_MINUTE);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends BundleLifecycleHandler {
        a(HotPatchManager hotPatchManager, Patch patch) {
        }
    }

    /* compiled from: Taobao */
    private class b extends AsyncTask<Boolean, Void, Void> {
        private b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Boolean... boolArr) {
            try {
                if (is2.i(HotPatchManager.this.mApp)) {
                    HotPatchManager hotPatchManager = HotPatchManager.this;
                    hotPatchManager.queryNewHotPatch(hotPatchManager.mGroup);
                    HotPatchManager.this.mIsAutoLoad = boolArr[0].booleanValue();
                }
                return null;
            } finally {
                HotPatchManager.this.mQueryAtomic.set(false);
            }
        }
    }

    /* compiled from: Taobao */
    private static class c {
        private static final HotPatchManager a = new HotPatchManager();
    }

    private void batchMonitor(String str, String str2) {
        IPatchVersionMonitor iPatchVersionMonitor = this.mPatchVersionMonitor;
        if (iPatchVersionMonitor != null) {
            iPatchVersionMonitor.patchVersion(str, str2);
        }
    }

    private void cleanInvalidPreferences() {
        if (this.mSharedPrefrences == null) {
            this.mSharedPrefrences = PreferenceManager.getDefaultSharedPreferences(this.mApp);
        }
        if (!this.mSharedPrefrences.getString(MAIN_VERSION, "").equals(this.mMainVersion)) {
            cleanSharePreferences();
            cleanPatchTmpDir();
            cleanDexPatchPreference();
            by0.b();
        }
    }

    private void cleanPatchDirs(boolean z) {
        File[] listFiles;
        File file = new File(this.mApp.getFilesDir(), DEFAULT_DIR);
        Log.d(TAG, "cleanPatchDirs");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (z) {
                    is2.d(file2);
                } else if (!file2.getName().equals(this.mMainVersion)) {
                    try {
                        is2.d(file2);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private void cleanPatchTmpDir() {
        File[] listFiles;
        File file = new File(this.mPatchTmpDir);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                is2.d(file2);
            }
        }
    }

    private void clearActivityStack() {
        Iterator<WeakReference<Activity>> it = this.activityList.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            Activity activity = null;
            if (next != null) {
                activity = next.get();
            }
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    private ClassLoader getClassLoaderByBundleName(String str) {
        BundleImpl bundle = Atlas.getInstance().getBundle(str);
        if (bundle == null) {
            return null;
        }
        return bundle.getClassLoader();
    }

    private String getDownloaderPathName(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.substring(str.lastIndexOf("/") + 1).split("\\.");
                return split[0] + JSMethod.NOT_SET + i + "." + split[1];
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static HotPatchManager getInstance() {
        return c.a;
    }

    private void initAndFix(String str, Context context) {
        try {
            this.mAndFixManager = new PatchManager(context, null, DEFAULT_DIR);
            this.mAndFixManager.init(str, is2.f(context), false);
        } catch (Throwable th) {
            is2.a("initAndFix", this.mAndFixPatchVersion + "", "1", cy0.a(th.getMessage(), th));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void killChildProcesses(Context context) {
        clearActivityStack();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                String str = runningAppProcessInfo.processName;
                if (str.contains(context.getPackageName() + ":")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void loadAndFixPatch(String str, boolean z, int i) throws IOException {
        if (z) {
            try {
                File file = new File(str);
                if (file.getName().endsWith("jar")) {
                    this.mAndFixManager.initAndfixManager();
                }
                Patch patch = new Patch(file);
                boolean z2 = false;
                for (String str2 : patch.getPatchNames()) {
                    if (str2.equals(MAIN_DEX)) {
                        this.mAndFixManager.loadPatch(str2, patch, this.mMainDexClassLoader);
                    } else {
                        ClassLoader classLoaderByBundleName = getClassLoaderByBundleName(str2.replace(JSMethod.NOT_SET, "."));
                        if (classLoaderByBundleName != null) {
                            this.mAndFixManager.loadPatch(str2, patch, classLoaderByBundleName);
                        } else {
                            if (!z2) {
                                Atlas.getInstance().addBundleListener(new a(this, patch));
                            }
                            z2 = true;
                        }
                    }
                }
                String str3 = this.mMainVersion;
                by0.d(true, "load", "0", "", str3, i + "", "");
            } catch (IOException e) {
                String message = e.getMessage();
                String str4 = this.mMainVersion;
                by0.d(false, "load", "1", message, str4, i + "", "");
                throw new IOException(e);
            }
        }
    }

    private synchronized boolean loadPatch(String str, int i, String str2, boolean z, boolean z2, final boolean z3) {
        if (!z) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!new File(str).exists()) {
            return false;
        }
        if (this.mSharedPrefrences.getString(NATIVE_CRASH_FLAG, "").equals(this.mMainVersion)) {
            return false;
        }
        if (this.mSharedPrefrences.getInt(JAVA_CRASH_FLAG, 0) == i) {
            return false;
        }
        if (!this.mSharedPrefrences.getBoolean(PATCHABLE, true)) {
            return false;
        }
        try {
            loadAndFixPatch(str, z3, i);
            if (z2) {
                AppMonitor.Counter.commit("Page_hotpatch", DEFAULT_DIR, i + "", 1.0d);
                String mainVersion = getMainVersion();
                zx0.b(true, zx0.ANDFIX_LOAD, "0", "", mainVersion, i + "", str);
                batchMonitor(HOTPATCH_MONITOR_KEY, i + "");
            }
            if (!z2 && z3) {
                String mainVersion2 = getMainVersion();
                zx0.b(true, zx0.ANDFIX_FRIST_LOAD, "0", "", mainVersion2, i + "", str);
                batchMonitor(HOTPATCH_MONITOR_KEY, i + "");
                this.mAndFixPatchVersion = i;
            }
            if (!z3) {
                this.isNeedRestart = true;
                this.mUnEffectAndFixPatchVersion = i;
            }
            if (this.mIsTestMode) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.taobao.updatecenter.hotpatch.HotPatchManager.AnonymousClass1 */

                    public void run() {
                        if (z3) {
                            Toast.makeText(HotPatchManager.this.mApp, "Patch 加载成功！！！", 1).show();
                        } else {
                            Toast.makeText(HotPatchManager.this.mApp, "请重启应用 patch 生效！！！", 1).show();
                        }
                    }
                });
            }
            return true;
        } catch (Throwable th) {
            String a2 = cy0.a(th.getMessage(), th);
            String str3 = zx0.ANDFIX_LOAD;
            is2.a(str3, i + "", "3", a2);
            if (!z2) {
                str3 = zx0.ANDFIX_FRIST_LOAD;
            }
            String message = th.getMessage();
            String mainVersion3 = getMainVersion();
            zx0.b(false, str3, "1", message, mainVersion3, i + "", str);
            th.printStackTrace();
            if (this.mIsTestMode) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.taobao.updatecenter.hotpatch.HotPatchManager.AnonymousClass2 */

                    public void run() {
                        Toast.makeText(HotPatchManager.this.mApp, "Patch 加载失败！！！", 1).show();
                    }
                });
            }
            return false;
        }
    }

    @TargetApi(14)
    public HotPatchManager appendInit(Application application, String str, String str2, HashMap<String, Object> hashMap) {
        this.mApp = application;
        this.mMainVersion = str;
        this.mContentMap = hashMap;
        this.mTtid = str2;
        this.mSharedPrefrences = PreferenceManager.getDefaultSharedPreferences(application);
        this.mMainDexClassLoader = HotPatchManager.class.getClassLoader();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mApp.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(DEFAULT_DIR);
        this.mPatchDir = sb.toString();
        File file = new File(this.mPatchDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mPatchTmpDir = this.mApp.getFilesDir().getAbsolutePath() + str3 + DETAULT_TMP_DIR;
        File file2 = new File(this.mPatchTmpDir);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        boolean h = is2.h(this.mApp);
        this.mIsMainProcess = h;
        if (h) {
            cleanInvalidPreferences();
        }
        String string = this.mSharedPrefrences.getString(HOTPATCH_VERSION, "0");
        if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string)) {
            this.mAndFixPatchVersion = Integer.parseInt(string);
        }
        initAndFix(this.mMainVersion, this.mApp);
        ub0.e(application);
        this.mApp.registerActivityLifecycleCallbacks(new ActivityLifeCycleCallBack());
        this.mHandler = new Handler(Looper.getMainLooper());
        return this;
    }

    public void cleanDexPatch() {
        BaselineInfoManager.instance().rollback(true);
        cleanDexPatchPreference();
    }

    public void cleanDexPatchPreference() {
        SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
        edit.remove(DEXPATCH_FLAG);
        edit.remove(DEXPATCH_VERSION);
        edit.commit();
    }

    public void cleanPatchs(boolean z) {
        cleanSharePreferences();
        this.mAndFixPatchVersion = 0;
        this.mUnEffectAndFixPatchVersion = 0;
        this.isNeedRestart = false;
        cleanPatchTmpDir();
        cleanPatchDirs(z);
    }

    public void cleanSharePreferences() {
        SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
        edit.remove(PATCHABLE);
        edit.remove(HOTPATCH_PRIORITY);
        edit.remove(HOTPATCH_PATH);
        edit.remove(HOTPATCH_MD5);
        edit.remove(HOTPATCH_VERSION);
        edit.remove(NATIVE_CRASH_FLAG);
        edit.remove(JAVA_CRASH_FLAG);
        edit.remove(HOTPATCH_SIZE);
        edit.remove(ANDFIX_FLAG);
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (((long) r3) != r19.mUnEffectDexPatchVersion) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        if (r20.f != r19.mUnEffectAndFixPatchVersion) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        if (r21 == null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        if (tb.fw1.HOME_SCAN_PAGE.equals(r21) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0067, code lost:
        r19.mIsTestMode = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        r19.mIsTestMode = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        android.util.Log.d(com.taobao.updatecenter.hotpatch.HotPatchManager.TAG, "start download");
        downloadPatch(r20, r21, r19.mIsTestMode);
        r2 = r19.mSharedPrefrences.edit();
        r2.putString(com.taobao.updatecenter.hotpatch.HotPatchManager.HOTPATCH_PRIORITY, r20.h + "");
        r2.apply();
        r9 = getMainVersion();
        tb.zx0.b(true, tb.zx0.ANDFIX_UPDATE, "0", "", r9, r20.f + "", r20.b);
        r2 = r19.mMainVersion;
        tb.by0.d(true, "revupdate", "0", "", r2, r20.f + "", "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e1, code lost:
        return;
     */
    public synchronized void dealPatchInfo(uo1 uo1, String str, String... strArr) {
        if (uo1 != null) {
            if (cy0.b(this.mApp)) {
                if (!uo1.a) {
                    Log.d(DEFAULT_DIR, "there is not update");
                } else if (!uo1.c) {
                    SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
                    edit.putBoolean(PATCHABLE, uo1.c);
                    edit.apply();
                } else if (!uo1.m) {
                    if (this.mMainVersion.equals(uo1.e)) {
                        if (uo1.k.equals("dexpatch")) {
                            int i = uo1.f;
                            if (((long) i) != this.mDexPatchVersion) {
                            }
                        }
                        if (uo1.k.equals(ANDFIX_TYPE)) {
                            if (uo1.f != getPatchSuccessedVersion()) {
                            }
                        }
                    }
                    if (str != null && fw1.HOME_SCAN_PAGE.equals(str)) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.taobao.updatecenter.hotpatch.HotPatchManager.AnonymousClass4 */

                            public void run() {
                                Toast.makeText(HotPatchManager.this.mApp, "patch针对的版本与当前版本号不匹配！", 1).show();
                            }
                        });
                    }
                } else {
                    int i2 = uo1.l;
                    if (i2 == this.mAndFixPatchVersion) {
                        cleanPatchs(true);
                        this.mAndFixPatchVersion = 0;
                        this.mUnEffectAndFixPatchVersion = 0;
                        queryNewHotPatch(this.mGroup);
                    } else if (((long) i2) == this.mDexPatchVersion) {
                        cleanDexPatch();
                        this.mDexPatchVersion = 0;
                        this.mUnEffectDexPatchVersion = 0;
                        queryNewHotPatch(this.mGroup);
                    }
                }
            }
        }
    }

    public synchronized void downloadPatch(uo1 uo1, String str, boolean z) {
        String downloaderPathName;
        if (uo1 == null) {
            Log.d(TAG, "This version patchInfo is null!");
            return;
        }
        HotPatchDownloaderListener hotPatchDownloaderListener = new HotPatchDownloaderListener(uo1, this.mApp, str, z);
        sb0 sb0 = new sb0();
        u21 u21 = new u21(uo1.b());
        u21.c = uo1.g;
        u21.b = uo1.d;
        if (uo1.k.equals(ANDFIX_TYPE) && (downloaderPathName = getDownloaderPathName(uo1.b, uo1.f)) != null) {
            u21.d = downloaderPathName;
        }
        io1 io1 = new io1();
        io1.f = this.mPatchTmpDir;
        io1.a = DEFAULT_DIR;
        sb0.b = io1;
        ArrayList arrayList = new ArrayList();
        sb0.a = arrayList;
        arrayList.add(u21);
        if (z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.taobao.updatecenter.hotpatch.HotPatchManager.AnonymousClass3 */

                public void run() {
                    Toast.makeText(HotPatchManager.this.mApp, "patch 包开始下载.....", 0).show();
                }
            });
        }
        ub0.c().b(sb0, hotPatchDownloaderListener);
    }

    public Context getContext() {
        return this.mApp;
    }

    public String getMainVersion() {
        return this.mMainVersion;
    }

    public int getPatchSuccessedVersion() {
        return this.mAndFixPatchVersion;
    }

    public uo1 getSuccessedPatchInfo() {
        uo1 uo1 = new uo1(true);
        uo1.e = this.mSharedPrefrences.getString(MAIN_VERSION, this.mMainVersion);
        uo1.g = this.mSharedPrefrences.getString(HOTPATCH_MD5, "");
        uo1.b = this.mSharedPrefrences.getString(HOTPATCH_PATH, "");
        String string = this.mSharedPrefrences.getString(HOTPATCH_PRIORITY, "0");
        if (TextUtils.isDigitsOnly(string)) {
            uo1.h = Integer.parseInt(string);
        }
        String string2 = this.mSharedPrefrences.getString(HOTPATCH_VERSION, "0");
        if (TextUtils.isDigitsOnly(string2)) {
            uo1.f = Integer.parseInt(string2);
        }
        uo1.d = this.mSharedPrefrences.getLong(HOTPATCH_SIZE, 0);
        return uo1;
    }

    @TargetApi(14)
    @Deprecated
    public void init(Application application, String str, String str2, String str3) {
        this.mApp = application;
        this.mMainVersion = str;
        this.isAppForeground = true;
        this.mSharedPrefrences = PreferenceManager.getDefaultSharedPreferences(application);
        this.mMainDexClassLoader = HotPatchManager.class.getClassLoader();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mApp.getFilesDir().getAbsolutePath());
        String str4 = File.separator;
        sb.append(str4);
        sb.append(DEFAULT_DIR);
        this.mPatchDir = sb.toString();
        File file = new File(this.mPatchDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mPatchTmpDir = this.mApp.getFilesDir().getAbsolutePath() + str4 + DETAULT_TMP_DIR;
        File file2 = new File(this.mPatchTmpDir);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(HotpatchReceiver.ACTION_AGOO_MSG);
        this.mApp.registerReceiver(new HotpatchReceiver(this.mMainVersion), intentFilter);
        this.mTtid = str3;
        boolean h = is2.h(this.mApp);
        this.mIsMainProcess = h;
        if (h) {
            cleanInvalidPreferences();
        }
        String string = this.mSharedPrefrences.getString(HOTPATCH_VERSION, "0");
        if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string)) {
            this.mAndFixPatchVersion = Integer.parseInt(string);
        }
        this.mPatchVersionMonitor = new yo1();
        batchMonitor(HOTPATCH_MONITOR_KEY, string);
        initAndFix(this.mMainVersion, this.mApp);
        ub0.e(application);
        UpdateDataSource.getInstance().registerListener(DEFAULT_DIR, new vo1());
        UpdateDataSource.getInstance().registerListener("dexpatch", new vo1());
        ay0.a(this.mApp);
        this.mApp.registerActivityLifecycleCallbacks(new ActivityLifeCycleCallBack());
        MotuCrashReporter.getInstance().setCrashCaughtListener(new wg1(System.currentTimeMillis()));
        this.mHandler = new Handler(Looper.getMainLooper());
        JSHotPatchBridge.init();
        this.mGroup = "taobao4android";
        setBatchMonitor(new yo1());
    }

    public boolean isAppForeground() {
        return this.isAppForeground;
    }

    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    public synchronized void loadDownloadedPatch(String str, uo1 uo1) {
        boolean z;
        String str2;
        Log.d(TAG, "onDownloadFinsh + " + str);
        if (uo1 != null) {
            boolean z2 = false;
            if (!uo1.k.equals(ANDFIX_TYPE) && uo1.k.equals("dexpatch")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                IPatchValidMonitor iPatchValidMonitor = this.mPatchValidMonitor;
                if (iPatchValidMonitor == null || iPatchValidMonitor.isValidPatch(str, uo1)) {
                    File file = new File(str);
                    File file2 = new File(this.mPatchDir);
                    File file3 = new File(file2, file.getName());
                    file2.setWritable(true);
                    try {
                        is2.c(file, file3);
                        file.delete();
                        str2 = file3.getAbsolutePath();
                        zx0.b(true, zx0.ANDFIX_COPY, "0", "", this.mMainVersion, uo1.f + "", uo1.b);
                        by0.d(true, by0.ARG_COPY, "0", "", this.mMainVersion, uo1.f + "", "");
                    } catch (Throwable th) {
                        String str3 = this.mMainVersion;
                        zx0.b(false, zx0.ANDFIX_COPY, "1", "", str3, uo1.f + ("目标文件目录是否为可写:" + file2.canWrite() + " and the parent dirs is exist " + file2.exists() + "" + th.getMessage()), uo1.b);
                        by0.d(false, by0.ARG_COPY, "1", "e.getMessage()", this.mMainVersion, uo1.f + "", "");
                        str2 = str;
                    }
                    if (this.mIsAutoLoad) {
                        z2 = loadPatch(str2, uo1.f, uo1.g, z, false, uo1.j);
                    }
                    if (z2 || !this.mIsAutoLoad) {
                        SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
                        edit.putString(HOTPATCH_PATH, str2);
                        edit.putString(HOTPATCH_VERSION, uo1.f + "");
                        edit.putString(HOTPATCH_MD5, uo1.g);
                        edit.putString(MAIN_VERSION, this.mMainVersion);
                        edit.putLong(HOTPATCH_SIZE, uo1.d);
                        edit.putBoolean(ANDFIX_FLAG, true);
                        edit.apply();
                    }
                } else {
                    return;
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, (Object) this.mMainVersion);
                jSONObject.put("updateBundles", (Object) uo1.n.f);
                jSONObject.put("updateVersion", (Object) (uo1.n.e + ""));
                Intent intent = new Intent("com.taobao.atlas.intent.DEX_PATCH_APP");
                intent.putExtra("dexpatch", true);
                intent.putExtra("patch_location", str);
                intent.putExtra("patch_info", jSONObject.toJSONString());
                this.mApp.sendBroadcast(intent);
                this.mUnEffectDexPatchVersion = uo1.n.e;
                SharedPreferences.Editor edit2 = this.mSharedPrefrences.edit();
                edit2.putBoolean(DEXPATCH_FLAG, true);
                edit2.putString(HOTPATCH_VERSION, uo1.n.e + "");
                edit2.putLong(DEXPATCH_VERSION, uo1.n.e);
                edit2.putString(MAIN_VERSION, this.mMainVersion);
                edit2.apply();
            }
            Log.d(TAG, "loaded result " + z2);
        }
    }

    public void queryNewHotPatch(String str) {
        if (is2.i(this.mApp)) {
            this.mIsAutoLoad = true;
            this.mGroup = str;
            if (!TextUtils.isEmpty(this.mTtid)) {
                yx0.a().d(this.mTtid);
            }
            String string = this.mSharedPrefrences.getString(HOTPATCH_VERSION, "0");
            dealPatchInfo(yx0.a().c(this.mApp, this.mMainVersion, (TextUtils.isEmpty(string) || !TextUtils.isDigitsOnly(string)) ? 0 : Integer.parseInt(string), str, this.mCustomDomain, this.mDexPatchVersion), "MTOP", new String[0]);
        }
    }

    public void setBatchMonitor(IPatchVersionMonitor iPatchVersionMonitor) {
        this.mPatchVersionMonitor = iPatchVersionMonitor;
    }

    public void setCustomDomain(String str) {
        this.mCustomDomain = str;
    }

    public void setJavaCrashFlag(boolean z) {
        if (z) {
            SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
            edit.putInt(JAVA_CRASH_FLAG, this.mAndFixPatchVersion);
            edit.apply();
        }
    }

    public void setNativeCrashFlag() {
        SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
        edit.putString(NATIVE_CRASH_FLAG, this.mMainVersion);
        edit.apply();
        is2.a("hotpatch_nativecrash", this.mAndFixPatchVersion + "", "4", "there is native crash during initiating stage");
    }

    public void setPatchStateListener(PatchStateListener patchStateListener) {
        this.mPatchStateListener = patchStateListener;
    }

    public void setPatchValidMonitor(IPatchValidMonitor iPatchValidMonitor) {
        this.mPatchValidMonitor = iPatchValidMonitor;
    }

    public void setUsedSupport(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPrefrences.edit();
        edit.putBoolean(PATCHABLE, z);
        edit.apply();
    }

    public synchronized void startHotPatch() {
        if (!this.mStartExcuted) {
            boolean z = this.mSharedPrefrences.getBoolean(ANDFIX_FLAG, false);
            if (!z) {
                batchMonitor(HOTPATCH_MONITOR_KEY, "0");
            } else if (!TextUtils.isEmpty(this.mMainVersion)) {
                if (this.mSharedPrefrences.getBoolean(PATCHABLE, true)) {
                    if (!this.mMainVersion.equals(this.mSharedPrefrences.getString(MAIN_VERSION, "")) && this.mIsMainProcess) {
                        cleanPatchs(true);
                        return;
                    } else if (!is2.i(this.mApp)) {
                        Log.w(TAG, "device is not support");
                        return;
                    } else {
                        String string = this.mSharedPrefrences.getString(HOTPATCH_PATH, "");
                        if (!TextUtils.isEmpty(string)) {
                            String string2 = this.mSharedPrefrences.getString(HOTPATCH_MD5, "");
                            if (!TextUtils.isEmpty(string2)) {
                                loadPatch(string, this.mAndFixPatchVersion, string2, z, true, true);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
            if (this.mSharedPrefrences.getBoolean(DEXPATCH_FLAG, false)) {
                long dexPatchVersion = BaselineInfoManager.instance().dexPatchVersion();
                this.mDexPatchVersion = dexPatchVersion;
                long j = this.mSharedPrefrences.getLong(DEXPATCH_VERSION, 0);
                if (dexPatchVersion != j) {
                    this.mSharedPrefrences.edit().putLong(DEXPATCH_VERSION, dexPatchVersion).apply();
                    String str = this.mMainVersion;
                    by0.d(false, "load", "1", "", str, j + "", "");
                } else {
                    String str2 = this.mMainVersion;
                    by0.d(true, "load", "0", "", str2, dexPatchVersion + "", "");
                }
                batchMonitor(DEXPATCH_MONITOR_KEY, dexPatchVersion + "");
            } else {
                batchMonitor(DEXPATCH_MONITOR_KEY, "0");
            }
            this.mStartExcuted = true;
        }
    }

    private HotPatchManager() {
        this.mUnEffectAndFixPatchVersion = 0;
        this.mUnEffectDexPatchVersion = 0;
        this.mDexPatchVersion = 0;
        this.mAndFixPatchVersion = 0;
        this.mContentMap = new HashMap<>();
        this.mIsAutoLoad = true;
        this.mQueryAtomic = new AtomicBoolean(false);
        this.mStartExcuted = false;
        this.mCustomDomain = null;
        this.isSettingRunnable = false;
        this.isNeedRestart = false;
        this.mIsTestMode = false;
        this.mIsMainProcess = true;
        this.activityList = new ArrayList<>();
    }

    @Deprecated
    public void queryNewHotPatch(boolean z) {
        if (this.mQueryAtomic.compareAndSet(false, true)) {
            new b().execute(Boolean.valueOf(z));
        }
    }
}
