package com.taobao.weex;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.utils.FontDO;
import com.taobao.weex.utils.LogLevel;
import com.taobao.weex.utils.TypefaceUtil;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXSoInstallMgrSdk;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.arch.solid.monitor.SolidMonitor;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class WXEnvironment {
    public static boolean AUTO_ADJUST_ENV_DEVICE_WIDTH = true;
    public static boolean AUTO_UPDATE_APPLICATION_SCREEN_SIZE = true;
    private static String COPY_SO_DES_DIR = null;
    public static final String CORE_JSB_SO_NAME = "weexjsb";
    public static String CORE_JSB_SO_PATH = null;
    public static final String CORE_JSC_SO_NAME = "JavaScriptCore";
    private static String CORE_JSC_SO_PATH = null;
    private static String CORE_JSS_ICU_PATH = null;
    public static String CORE_JSS_RUNTIME_SO_PATH = null;
    public static final String CORE_JSS_SO_NAME = "weexjss";
    private static String CORE_JSS_SO_PATH = null;
    public static final String CORE_JST_SO_NAME = "weexjst";
    public static final String CORE_SO_NAME = "weexcore";
    public static final String DEV_Id = getDevId();
    public static final String EAGLE = "eagle";
    public static final String ENVIRONMENT = "environment";
    public static String JS_LIB_SDK_VERSION = "null";
    public static volatile boolean JsFrameworkInit = false;
    private static String LIB_LD_PATH = null;
    public static final String OS = "android";
    public static final String SETTING_EXCLUDE_X86SUPPORT = "env_exclude_x86";
    public static boolean SETTING_FORCE_VERTICAL_SCREEN = false;
    public static final String SYS_MODEL = Build.getMODEL();
    public static String SYS_VERSION = null;
    public static final String WEEX_CURRENT_KEY = "wx_current_url";
    public static String WXSDK_VERSION = "0.26.4.45";
    private static boolean isApkDebug = true;
    public static boolean isPerf = false;
    public static volatile boolean isWsFixMode = true;
    private static a mWXDefaultSettings = null;
    private static boolean openDebugLog = true;
    private static Map<String, String> options = null;
    public static Application sApplication = null;
    public static long sComponentsAndModulesReadyTime = 0;
    private static boolean sDebugFlagInit = false;
    public static boolean sDebugMode = false;
    public static boolean sDebugNetworkEventReporterEnable = false;
    public static boolean sDebugServerConnectable = false;
    public static String sDebugWsUrl = "";
    @Deprecated
    public static int sDefaultWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
    public static boolean sDynamicMode = false;
    public static String sDynamicUrl = "";
    public static final boolean sForceEnableDevTool = true;
    private static String sGlobalFontFamily;
    public static boolean sInAliWeex = false;
    public static long sJSFMStartListenerTime = 0;
    public static long sJSLibInitTime = 0;
    public static LogLevel sLogLevel = LogLevel.DEBUG;
    public static boolean sRemoteDebugMode = false;
    public static String sRemoteDebugProxyUrl = "";
    public static long sSDKInitExecuteTime = 0;
    public static long sSDKInitInvokeTime = 0;
    public static long sSDKInitStart = 0;
    public static long sSDKInitTime = 0;
    public static volatile boolean sUseRunTimeApi = false;

    /* compiled from: Taobao */
    public static class a {
        private String a = "weex_default_settings";
        private SharedPreferences b = null;

        public a(Application application) {
            if (application != null) {
                this.b = application.getSharedPreferences("weex_default_settings", 0);
            }
        }

        public synchronized String a(String str, String str2) {
            if (this.b != null) {
                if (!TextUtils.isEmpty(str)) {
                    String string = this.b.getString(str, str2);
                    WXLogUtils.i("get default settings " + str + " : " + string);
                    return string;
                }
            }
            WXLogUtils.i("get default settings " + str + " return default value :" + str2);
            return str2;
        }

        public synchronized void b(String str, String str2) {
            if (this.b != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    WXLogUtils.i("save default settings " + str + ":" + str2);
                    SharedPreferences.Editor edit = this.b.edit();
                    edit.putString(str, str2);
                    edit.apply();
                }
            }
        }
    }

    static {
        String release = Build.VERSION.getRELEASE();
        SYS_VERSION = release;
        if (release != null && release.toUpperCase(Locale.ROOT).equals("P")) {
            SYS_VERSION = "9.0.0";
        }
        String str = SYS_VERSION;
        if (str != null && str.toUpperCase(Locale.ROOT).equals("Q")) {
            SYS_VERSION = "10.0.0";
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        options = concurrentHashMap;
        concurrentHashMap.put("os", "android");
        options.put(WXConfig.osName, "android");
    }

    public static void addCustomOptions(String str, String str2) {
        options.put(str, str2);
    }

    @SuppressLint({"SdCardPath"})
    public static String copySoDesDir() {
        File file;
        try {
            if (TextUtils.isEmpty(COPY_SO_DES_DIR)) {
                if (sApplication == null) {
                    WXLogUtils.e("sApplication is null, so copy path will be null");
                    return null;
                }
                String path = getApplication().getApplicationContext().getCacheDir().getPath();
                if (TextUtils.isEmpty(path)) {
                    file = new File(path, "/cache/weex/libs");
                } else {
                    String packageName = sApplication.getPackageName();
                    file = new File("/data/data/" + packageName + "/cache/weex/libs");
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                COPY_SO_DES_DIR = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
        return COPY_SO_DES_DIR;
    }

    public static String extractSo() {
        File file = new File(getApplication().getApplicationContext().getApplicationInfo().sourceDir);
        String copySoDesDir = copySoDesDir();
        if (file.exists() && !TextUtils.isEmpty(copySoDesDir)) {
            try {
                WXFileUtils.extractSo(file.getAbsolutePath(), copySoDesDir);
                return copySoDesDir;
            } catch (IOException e) {
                WXLogUtils.e("extractSo error " + e.getMessage());
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r2 != null) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004a A[SYNTHETIC, Splitter:B:28:0x004a] */
    private static String findIcuPath() {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/maps")));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        try {
                            bufferedReader.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } while (!readLine.contains("icudt"));
            String trim = readLine.substring(readLine.indexOf(47)).trim();
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            return trim;
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            e.printStackTrace();
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static String findSoPath(String str) {
        String findLibrary = ((PathClassLoader) WXEnvironment.class.getClassLoader()).findLibrary(str);
        if (!TextUtils.isEmpty(findLibrary)) {
            File file = new File(findLibrary);
            if (file.exists()) {
                WXLogUtils.e(str + "'s Path is" + findLibrary);
                return file.getAbsolutePath();
            }
            WXLogUtils.e(str + "'s Path is " + findLibrary + " but file does not exist");
        }
        String str2 = SolidMonitor.CHECK_TYPE_LIB + str + ".so";
        String cacheDir = getCacheDir();
        if (TextUtils.isEmpty(cacheDir)) {
            WXLogUtils.e("cache dir is null");
            return "";
        }
        if (cacheDir.indexOf("/cache") > 0) {
            findLibrary = new File(cacheDir.replace("/cache", "/lib"), str2).getAbsolutePath();
        }
        if (new File(findLibrary).exists()) {
            WXLogUtils.e(str + "use lib so");
            return findLibrary;
        }
        String extractSo = extractSo();
        return !TextUtils.isEmpty(extractSo) ? new File(extractSo, str2).getAbsolutePath() : findLibrary;
    }

    private static String getAppCacheFile() {
        try {
            return sApplication.getApplicationContext().getCacheDir().getPath();
        } catch (Exception e) {
            WXLogUtils.e("WXEnvironment getAppCacheFile Exception: ", e);
            return "";
        }
    }

    public static String getAppVersionName() {
        try {
            return sApplication.getPackageManager().getPackageInfo(sApplication.getPackageName(), 0).versionName;
        } catch (Exception e) {
            WXLogUtils.e("WXEnvironment getAppVersionName Exception: ", e);
            return "";
        }
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static String getCacheDir() {
        Application application = getApplication();
        if (application == null || application.getApplicationContext() == null) {
            return null;
        }
        return application.getApplicationContext().getCacheDir().getPath();
    }

    public static Map<String, String> getConfig() {
        Application application;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("os", "android");
        hashMap.put("appVersion", getAppVersionName());
        hashMap.put(WXConfig.cacheDir, getAppCacheFile());
        hashMap.put(WXConfig.devId, DEV_Id);
        hashMap.put(WXConfig.sysVersion, SYS_VERSION);
        hashMap.put(WXConfig.sysModel, SYS_MODEL);
        hashMap.put("weexVersion", String.valueOf(WXSDK_VERSION));
        try {
            if (isLayoutDirectionRTL()) {
                str = Constants.Name.RTL;
            } else {
                str = "ltr";
            }
            hashMap.put(WXConfig.layoutDirection, str);
        } catch (Exception unused) {
            hashMap.put(WXConfig.layoutDirection, "ltr");
        }
        try {
            if (isApkDebugable()) {
                addCustomOptions(WXConfig.debugMode, "true");
            }
            addCustomOptions("scale", Float.toString(sApplication.getResources().getDisplayMetrics().density));
            addCustomOptions(WXConfig.androidStatusBarHeight, Float.toString((float) WXViewUtils.getStatusBarHeight(sApplication)));
        } catch (NullPointerException e) {
            WXLogUtils.e("WXEnvironment scale Exception: ", e);
        }
        hashMap.putAll(getCustomOptions());
        if (hashMap.get("appName") == null && (application = sApplication) != null) {
            hashMap.put("appName", application.getPackageName());
        }
        return hashMap;
    }

    public static String getCrashFilePath(Context context) {
        File dir;
        if (context == null || (dir = context.getDir("crash", 0)) == null) {
            return "";
        }
        return dir.getAbsolutePath();
    }

    @Deprecated
    public static Map<String, String> getCustomOptions() {
        return options;
    }

    public static synchronized String getDefaultSettingValue(String str, String str2) {
        synchronized (WXEnvironment.class) {
            a wXDefaultSettings = getWXDefaultSettings();
            if (wXDefaultSettings != null) {
                if (!TextUtils.isEmpty(str)) {
                    return wXDefaultSettings.a(str, str2);
                }
            }
            return str2;
        }
    }

    @SuppressLint({"HardwareIds"})
    private static String getDevId() {
        Application application = sApplication;
        if (application != null) {
            try {
                return TelephonyManager.getDeviceId((android.telephony.TelephonyManager) application.getSystemService("phone"));
            } catch (NullPointerException | SecurityException e) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
            }
        }
        return "";
    }

    public static String getDiskCacheDir(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (Environment.isExternalStorageRemovable()) {
                    str = context.getCacheDir().getPath();
                    return str;
                }
            }
            str = context.getExternalCacheDir().getPath();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFilesDir(Context context) {
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getPath();
        }
        return (getApplication().getApplicationInfo().dataDir + File.separator) + AVFSCacheConstants.AVFS_FIlE_PATH_NAME;
    }

    public static String getGlobalFontFamilyName() {
        return sGlobalFontFamily;
    }

    public static String getLibJScRealPath() {
        if (TextUtils.isEmpty(CORE_JSC_SO_PATH)) {
            CORE_JSC_SO_PATH = findSoPath(CORE_JSC_SO_NAME);
            WXLogUtils.e("findLibJscRealPath " + CORE_JSC_SO_PATH);
        }
        return CORE_JSC_SO_PATH;
    }

    public static String getLibJssIcuPath() {
        if (TextUtils.isEmpty(CORE_JSS_ICU_PATH)) {
            CORE_JSS_ICU_PATH = findIcuPath();
        }
        return CORE_JSS_ICU_PATH;
    }

    public static String getLibJssRealPath() {
        if (!sUseRunTimeApi || TextUtils.isEmpty(CORE_JSS_RUNTIME_SO_PATH)) {
            if (TextUtils.isEmpty(CORE_JSS_SO_PATH)) {
                CORE_JSS_SO_PATH = findSoPath(CORE_JSS_SO_NAME);
                WXLogUtils.d("test-> findLibJssRealPath " + CORE_JSS_SO_PATH);
            }
            return CORE_JSS_SO_PATH;
        }
        WXLogUtils.d("test-> findLibJssRuntimeRealPath " + CORE_JSS_RUNTIME_SO_PATH);
        return CORE_JSS_RUNTIME_SO_PATH;
    }

    public static String getLibLdPath() {
        if (TextUtils.isEmpty(LIB_LD_PATH)) {
            ClassLoader classLoader = WXEnvironment.class.getClassLoader();
            try {
                LIB_LD_PATH = (String) classLoader.getClass().getMethod("getLdLibraryPath", new Class[0]).invoke(classLoader, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(LIB_LD_PATH)) {
            try {
                String property = System.getProperty("java.library.path");
                String libJScRealPath = getLibJScRealPath();
                if (!TextUtils.isEmpty(libJScRealPath)) {
                    LIB_LD_PATH = new File(libJScRealPath).getParent() + ":" + property;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        WXLogUtils.d("getLibLdPath is " + LIB_LD_PATH);
        return LIB_LD_PATH;
    }

    public static synchronized a getWXDefaultSettings() {
        a aVar;
        synchronized (WXEnvironment.class) {
            if (mWXDefaultSettings == null && getApplication() != null) {
                mWXDefaultSettings = new a(getApplication());
            }
            aVar = mWXDefaultSettings;
        }
        return aVar;
    }

    public static boolean isApkDebugable() {
        return isApkDebugable(sApplication);
    }

    public static boolean isCPUSupport() {
        boolean z = true;
        boolean z2 = WXSoInstallMgrSdk.isX86() && "true".equals(getCustomOptions().get(SETTING_EXCLUDE_X86SUPPORT));
        if (!WXSoInstallMgrSdk.isCPUSupport() || z2) {
            z = false;
        }
        if (isApkDebugable()) {
            WXLogUtils.d("WXEnvironment.sSupport:" + z + "isX86AndExclueded: " + z2);
        }
        return z;
    }

    @Deprecated
    public static boolean isHardwareSupport() {
        if (isApkDebugable()) {
            WXLogUtils.d("isTableDevice:" + WXUtils.isTabletDevice());
        }
        return isCPUSupport();
    }

    public static boolean isLayoutDirectionRTL() {
        if (Build.VERSION.SDK_INT >= 17) {
            return sApplication.getApplicationContext().getResources().getBoolean(R$bool.weex_is_right_to_left);
        }
        return false;
    }

    public static boolean isOpenDebugLog() {
        return openDebugLog;
    }

    public static boolean isPerf() {
        return isPerf;
    }

    @Deprecated
    public static boolean isSupport() {
        boolean isInitialized = WXSDKEngine.isInitialized();
        if (!isInitialized) {
            WXLogUtils.e("WXSDKEngine.isInitialized():" + isInitialized);
        }
        return isHardwareSupport() && isInitialized;
    }

    public static int memfd_create(String str, int i) {
        if (Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        try {
            Object invoke = Os.class.getMethod("memfd_create", String.class, Integer.TYPE).invoke(null, str, 0);
            if (!(invoke instanceof FileDescriptor)) {
                return 0;
            }
            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            int parseInt = Integer.parseInt(String.valueOf(declaredField.get(invoke)));
            try {
                declaredField.setAccessible(false);
                Os.ftruncate((FileDescriptor) invoke, (long) i);
            } catch (Throwable unused) {
            }
            return parseInt;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static void setApkDebugable(boolean z) {
        isApkDebug = z;
        if (!z) {
            openDebugLog = false;
        }
    }

    public static void setGlobalFontFamily(String str, Typeface typeface) {
        WXLogUtils.d("GlobalFontFamily", "Set global font family: " + str);
        sGlobalFontFamily = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (typeface == null) {
            TypefaceUtil.removeFontDO(str);
            return;
        }
        TypefaceUtil.putFontDO(new FontDO(str, typeface));
        WXLogUtils.d("TypefaceUtil", "Add new font: " + str);
    }

    public static void setOpenDebugLog(boolean z) {
        openDebugLog = z;
    }

    public static synchronized void writeDefaultSettingsValue(String str, String str2) {
        synchronized (WXEnvironment.class) {
            a wXDefaultSettings = getWXDefaultSettings();
            if (wXDefaultSettings != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    wXDefaultSettings.b(str, str2);
                }
            }
        }
    }

    public void initMetrics() {
    }

    public static String getCustomOptions(String str) {
        return options.get(str);
    }

    public static boolean isApkDebugable(Application application) {
        if (application == null || isPerf) {
            return false;
        }
        if (sDebugFlagInit) {
            return isApkDebug;
        }
        try {
            String str = getCustomOptions().get(WXConfig.debugMode);
            if (TextUtils.isEmpty(str)) {
                isApkDebug = (application.getApplicationInfo().flags & 2) != 0;
            } else {
                isApkDebug = Boolean.valueOf(str).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            isApkDebug = false;
        }
        sDebugFlagInit = true;
        return isApkDebug;
    }
}
