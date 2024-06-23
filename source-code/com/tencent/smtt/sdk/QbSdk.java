package com.tencent.smtt.sdk;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import androidx.core.os.EnvironmentCompat;
import androidx.core.provider.FontsContractCompat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.sdk.b.a.d;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class QbSdk {
    private static String A = null;
    private static boolean B = false;
    private static boolean C = true;
    private static TbsListener D = null;
    private static TbsListener E = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    private static boolean F = false;
    public static final String FILERADER_MENUDATA = "menuData";
    private static boolean G = false;
    public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean a = false;
    static boolean b = false;
    static boolean c = true;
    static String d = null;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static Object h = new Object();
    static boolean i = true;
    public static boolean isDefaultDialog = false;
    static boolean j = true;
    static boolean k = false;
    static volatile boolean l = a;
    static TbsListener m = new TbsListener() {
        /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass7 */

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i) {
            if (TbsDownloader.needDownloadDecoupleCore()) {
                TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                TbsDownloader.a = true;
                return;
            }
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            TbsDownloader.a = false;
            if (QbSdk.D != null) {
                QbSdk.D.onDownloadFinish(i);
            }
            if (QbSdk.E != null) {
                QbSdk.E.onDownloadFinish(i);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i) {
            if (i != 200) {
            }
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.a = false;
            if (TbsDownloader.startDecoupleCoreIfNeeded()) {
                TbsDownloader.a = true;
            } else {
                TbsDownloader.a = false;
            }
            if (QbSdk.D != null) {
                QbSdk.D.onInstallFinish(i);
            }
            if (QbSdk.E != null) {
                QbSdk.E.onInstallFinish(i);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i) {
            if (QbSdk.E != null) {
                QbSdk.E.onDownloadProgress(i);
            }
            if (QbSdk.D != null) {
                QbSdk.D.onDownloadProgress(i);
            }
        }
    };
    public static boolean mDisableUseHostBackupCore = false;
    static Map<String, Object> n = null;
    private static int o = 0;
    private static String p = "";
    private static Class<?> q = null;
    private static Object r = null;
    private static boolean s = false;
    public static boolean sIsVersionPrinted = false;
    private static String[] t = null;
    private static String u = "NULL";
    private static String v = "UNKNOWN";
    private static boolean w = false;
    private static int x = 0;
    private static int y = 170;
    private static String z;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    public static void clear(Context context) {
    }

    public static int getTbsSdkVersion() {
        return 43903;
    }

    public static boolean startQBToLoadurl(Context context, String str, int i2, WebView webView) {
        u a2;
        Object invokeStaticMethod;
        IX5WebViewBase iX5WebViewBase;
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (!((str2 != TbsConfig.APP_WX && str2 != TbsConfig.APP_QQ) || (a2 = u.a()) == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0])) == null || (iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod) == null)) {
                    webView = (WebView) iX5WebViewBase.getView().getParent();
                }
            } catch (Exception unused) {
            }
        }
        if (c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0) {
            return true;
        }
        return false;
    }

    public static boolean startQBForVideo(Context context, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return c.a(context, str, hashMap);
    }

    public static boolean startQBForDoc(Context context, String str, int i2, int i3, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        return c.a(context, str, i3, str2, hashMap, bundle);
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    private static boolean a(Context context, boolean z2) {
        File file;
        String str;
        int i2;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43903; SDK_VERSION_NAME: 4.3.0.3");
            sIsVersionPrinted = true;
        }
        if (a && !z2) {
            TbsLog.e("QbSdk", "QbSdk init: " + v, false);
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED, new Throwable(v));
            return false;
        } else if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER, new Throwable(u));
            return false;
        } else {
            if (!C) {
                d(context);
            }
            try {
                File q2 = m.a().q(context);
                if (q2 == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    int i3 = o;
                    if (i3 == 0 || i3 == TbsShareManager.d(context)) {
                        o = TbsShareManager.d(context);
                    } else {
                        q = null;
                        r = null;
                        TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                        TbsCoreLoadStat instance = TbsCoreLoadStat.getInstance();
                        instance.a(context, TbsListener.ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                        return false;
                    }
                } else {
                    if (o != 0) {
                        i2 = m.a().a(true, context);
                        if (o != i2) {
                            q = null;
                            r = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
                            TbsCoreLoadStat instance2 = TbsCoreLoadStat.getInstance();
                            instance2.a(context, TbsListener.ErrorCode.ERROR_UNMATCH_TBSCORE_VER, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + i2));
                            return false;
                        }
                    } else {
                        i2 = 0;
                    }
                    o = i2;
                }
                if (TbsDownloader.a(context, o)) {
                    TbsLog.i("QbSdk", "version " + o + " is in blacklist,can not load! return");
                    return false;
                } else if (q != null && r != null) {
                    return true;
                } else {
                    if (!TbsShareManager.isThirdPartyApp(context)) {
                        file = new File(m.a().q(context), "tbs_sdk_extension_dex.jar");
                    } else if (TbsShareManager.j(context)) {
                        file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_HOST_UNAVAILABLE, new Throwable("isShareTbsCoreAvailable false!"));
                        return false;
                    }
                    if (!file.exists()) {
                        try {
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            int i4 = m.a().i(context);
                            if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i4 > 0) {
                                    TbsCoreLoadStat instance3 = TbsCoreLoadStat.getInstance();
                                    instance3.a(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i4));
                                } else {
                                    TbsCoreLoadStat instance4 = TbsCoreLoadStat.getInstance();
                                    instance4.a(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i4));
                                }
                            } else if (i4 > 0) {
                                TbsCoreLoadStat instance5 = TbsCoreLoadStat.getInstance();
                                instance5.a(context, TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i4));
                            } else {
                                TbsCoreLoadStat instance6 = TbsCoreLoadStat.getInstance();
                                instance6.a(context, TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i4));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return false;
                    }
                    if (TbsShareManager.getHostCorePathAppDefined() != null) {
                        str = TbsShareManager.getHostCorePathAppDefined();
                    } else {
                        str = q2.getAbsolutePath();
                    }
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + str);
                    TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                    u.a().b(context);
                    m.a(context);
                    q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, str, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    loadTBSSDKExtension(context, file.getParent());
                    k.a(r, "setClientVersion", new Class[]{Integer.TYPE}, 1);
                    return true;
                }
            } catch (Throwable th2) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th2));
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, th2);
                return false;
            }
        }
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        boolean z2;
        Constructor<?> constructor;
        if (r == null) {
            synchronized (QbSdk.class) {
                if (r == null) {
                    if (q == null) {
                        TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
                    }
                    try {
                        constructor = q.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                        z2 = true;
                    } catch (Throwable unused) {
                        constructor = null;
                        z2 = false;
                    }
                    try {
                        if (TbsShareManager.isThirdPartyApp(context)) {
                            Context e2 = TbsShareManager.e(context);
                            if (e2 == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                                TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                            } else if (z2) {
                                r = constructor.newInstance(context, e2, TbsShareManager.getHostCorePathAppDefined(), str, null);
                            } else if (e2 == null) {
                                r = q.getConstructor(Context.class, Context.class, String.class).newInstance(context, e2, TbsShareManager.getHostCorePathAppDefined(), str, null);
                            } else {
                                r = q.getConstructor(Context.class, Context.class).newInstance(context, e2);
                            }
                        } else if (!z2) {
                            Constructor<?> constructor2 = q.getConstructor(Context.class, Context.class);
                            if (context.getApplicationContext() != null) {
                                context = context.getApplicationContext();
                            }
                            r = constructor2.newInstance(context, context);
                        } else {
                            String str2 = (!TbsConfig.APP_WX.equals(getCurrentProcessName(context)) || WebView.mWebViewCreated) ? null : "notLoadSo";
                            if (context.getApplicationContext() != null) {
                                context = context.getApplicationContext();
                            }
                            r = constructor.newInstance(context, context, null, str, str2);
                        }
                    } catch (Throwable th) {
                        TbsLog.e("QbSdk", "throwable" + Log.getStackTraceString(th));
                    }
                }
            }
        }
    }

    public static void initForinitAndNotLoadSo(Context context) {
        if (q == null) {
            File q2 = m.a().q(context);
            if (q2 == null) {
                Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo optDir == null");
                return;
            }
            File file = new File(q2, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo dexFile.exists()=false");
                return;
            }
            String absolutePath = q2.getAbsolutePath();
            u.a().b(context);
            m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        }
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        String str;
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && Build.VERSION.SDK_INT == 19) {
                return true;
            }
            if (q == null) {
                File q2 = m.a().q(context);
                if (q2 == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (!file.exists()) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
                if (TbsShareManager.getHostCorePathAppDefined() != null) {
                    str = TbsShareManager.getHostCorePathAppDefined();
                } else {
                    str = q2.getAbsolutePath();
                }
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + str);
                TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                u.a().b(context);
                m.a(context);
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, str, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (r == null) {
                    if (TbsShareManager.e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                        return false;
                    }
                    loadTBSSDKExtension(context, file.getParent());
                }
            }
            Object a2 = k.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            if (a2 == null || !(a2 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    static boolean a(Context context) {
        try {
            if (q != null) {
                return true;
            }
            File q2 = m.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(q2, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            u.a().b(context);
            m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, q2.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            return true;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static boolean c(Context context) {
        File file;
        String str;
        try {
            if (q != null) {
                return true;
            }
            File q2 = m.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(m.a().q(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_HOST_UNAVAILABLE);
                return false;
            }
            if (!file.exists()) {
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_OLD, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
            if (TbsShareManager.getHostCorePathAppDefined() != null) {
                str = TbsShareManager.getHostCorePathAppDefined();
            } else {
                str = q2.getAbsolutePath();
            }
            TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + str);
            TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            u.a().b(context);
            m.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, str, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            k.a(r, "setClientVersion", new Class[]{Integer.TYPE}, 1);
            return true;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void setOnlyDownload(boolean z2) {
        k = z2;
    }

    public static boolean getOnlyDownload() {
        return k;
    }

    static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (!context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                return true;
            }
            TbsLog.i("QbSdk", "clearPluginConfigFile #1");
            String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
            TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
            if (string == null) {
                return true;
            }
            if (string.contains(str)) {
                return true;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("plugin_setting", 0);
            if (sharedPreferences == null) {
                return true;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
            return true;
        } catch (Throwable th) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            return false;
        }
    }

    static Bundle a(Context context, Bundle bundle) throws Exception {
        if (!a(context)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_ERROR, "initForPatch return false!");
            return null;
        }
        Object a2 = k.a(r, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
        if (a2 != null) {
            return (Bundle) a2;
        }
        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_ERROR, "incrUpdate return null!");
        return null;
    }

    static boolean a(Context context, int i2) {
        return a(context, i2, 20000);
    }

    static boolean a(Context context, int i2, int i3) {
        Map<String, Object> map = n;
        if (map == null || !map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) || !n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            m.a().b(context, d.a == 0);
            if (!c(context)) {
                return true;
            }
            Object a2 = k.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), 43903, Integer.valueOf(i3));
            if (a2 != null) {
                return ((Boolean) a2).booleanValue();
            }
            Object a3 = k.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), 43903);
            if (a3 != null) {
                return ((Boolean) a3).booleanValue();
            }
            return true;
        }
        TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
        return true;
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Properties] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f0 A[SYNTHETIC, Splitter:B:50:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0124 A[SYNTHETIC, Splitter:B:74:0x0124] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static boolean canOpenWebPlus(Context context) {
        Throwable th;
        if (x == 0) {
            x = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + x);
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 7 || x < y || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(m.a().q(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(Build.VERSION.SDK);
                if (parseInt3 <= parseInt) {
                    if (parseInt3 >= parseInt2) {
                        int parseInt4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused) {
                        }
                        try {
                            ?? fileInputStream = new FileInputStream(new File(m.s(context), "tbs_extension.conf"));
                            try {
                                ?? properties2 = new Properties();
                                properties2.load(fileInputStream);
                                int parseInt5 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                                int parseInt6 = Integer.parseInt(properties2.getProperty(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                                if (parseInt4 != 88888888) {
                                    if (parseInt5 != 88888888) {
                                        if (parseInt4 <= parseInt5) {
                                            if (parseInt4 == parseInt5) {
                                                if (parseInt6 <= 0 || parseInt6 == b.b(context)) {
                                                    if (Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false)) {
                                                        z2 = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused2) {
                                }
                            } catch (Throwable unused3) {
                                bufferedInputStream = fileInputStream;
                                try {
                                    TbsLog.i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                                    z2 = true;
                                    return !z2;
                                } finally {
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception unused4) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused5) {
                            TbsLog.i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                            z2 = true;
                            return !z2;
                        }
                        return !z2;
                    }
                }
                TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused6) {
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    return false;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
            return false;
        }
    }

    public static boolean isX5DisabledSync(Context context) {
        if (k.a(context).c() == 2) {
            return false;
        }
        if (!c(context)) {
            return true;
        }
        Object a2 = k.a(r, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(m.a().i(context)), 43903);
        if (a2 != null) {
            return ((Boolean) a2).booleanValue();
        }
        return true;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        d a2 = d.a(true);
        a2.a(context, false, false);
        if (a2 == null || !a2.b()) {
            return false;
        }
        return a2.a().a(context, str, str2, bundle);
    }

    public static boolean canUseVideoFeatrue(Context context, int i2) {
        Object a2 = k.a(r, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        if (a2 == null || !(a2 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public static boolean canLoadVideo(Context context) {
        Object a2 = k.a(r, "canLoadVideo", new Class[]{Integer.TYPE}, 0);
        if (a2 == null) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL);
        } else if (!((Boolean) a2).booleanValue()) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE);
        }
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    static boolean a(Context context, boolean z2, boolean z3) {
        int i2;
        int disabledCoreVersion = TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        boolean z4 = false;
        if (disabledCoreVersion != 0 && disabledCoreVersion == m.a().i(context)) {
            TbsLog.e("QbSdk", "force use sys by remote switch");
            return false;
        } else if (TbsShareManager.isThirdPartyApp(context) && !TbsShareManager.i(context)) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY);
            return false;
        } else if (!a(context, z2)) {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
            return false;
        } else {
            boolean z5 = true;
            Object a2 = k.a(r, "canLoadX5Core", new Class[]{Integer.TYPE}, 43903);
            if (a2 == null) {
                Object a3 = k.a(r, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
                if (a3 == null) {
                    TbsCoreLoadStat.getInstance().a(context, 308);
                } else if ((a3 instanceof String) && ((String) a3).equalsIgnoreCase("AuthenticationFail")) {
                    return false;
                } else {
                    if (a3 instanceof Boolean) {
                        o = d.d();
                        boolean a4 = a(context, d.d());
                        Boolean bool = (Boolean) a3;
                        if (bool.booleanValue() && !a4) {
                            z4 = true;
                        }
                        if (!z4) {
                            TbsLog.e(TbsListener.tag_load_error, "318");
                            TbsLog.w(TbsListener.tag_load_error, "isX5Disable:" + a4);
                            TbsLog.w(TbsListener.tag_load_error, "(Boolean) ret:" + bool);
                        }
                        return z4;
                    }
                }
            } else if ((a2 instanceof String) && ((String) a2).equalsIgnoreCase("AuthenticationFail")) {
                return false;
            } else {
                if (!(a2 instanceof Bundle)) {
                    TbsCoreLoadStat instance = TbsCoreLoadStat.getInstance();
                    instance.a(context, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable("" + a2));
                    TbsLog.e(TbsListener.tag_load_error, "ret not instance of bundle");
                    return false;
                }
                Bundle bundle = (Bundle) a2;
                if (bundle.isEmpty()) {
                    TbsCoreLoadStat instance2 = TbsCoreLoadStat.getInstance();
                    instance2.a(context, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new Throwable("" + a2));
                    TbsLog.e(TbsListener.tag_load_error, "empty bundle");
                    return false;
                }
                try {
                    i2 = bundle.getInt(FontsContractCompat.Columns.RESULT_CODE, -1);
                } catch (Exception e2) {
                    TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e2.toString());
                    i2 = -1;
                }
                boolean z6 = i2 == 0;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    d.a(TbsShareManager.d(context));
                    String valueOf = String.valueOf(TbsShareManager.d(context));
                    p = valueOf;
                    if (valueOf.length() == 5) {
                        p = "0" + p;
                    }
                    if (p.length() != 6) {
                        p = "";
                    }
                } else {
                    try {
                        if (Build.VERSION.SDK_INT >= 12) {
                            p = bundle.getString("tbs_core_version", "0");
                        } else {
                            String string = bundle.getString("tbs_core_version");
                            p = string;
                            if (string == null) {
                                p = "0";
                            }
                        }
                    } catch (Exception unused) {
                        p = "0";
                    }
                    try {
                        o = Integer.parseInt(p);
                    } catch (NumberFormatException unused2) {
                        o = 0;
                    }
                    d.a(o);
                    int i3 = o;
                    if (i3 == 0) {
                        TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sTbsVersion is 0"));
                        return false;
                    }
                    if ((i3 <= 0 || i3 > 25442) && i3 != 25472) {
                        z5 = false;
                    }
                    if (z5) {
                        TbsLog.e(TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + o);
                        f.b(m.a().q(context));
                        TbsCoreLoadStat instance3 = TbsCoreLoadStat.getInstance();
                        instance3.a(context, 307, new Throwable("is_obsolete --> delete old core:" + o));
                        return false;
                    }
                }
                try {
                    String[] stringArray = bundle.getStringArray("tbs_jarfiles");
                    t = stringArray;
                    if (!(stringArray instanceof String[])) {
                        TbsCoreLoadStat instance4 = TbsCoreLoadStat.getInstance();
                        instance4.a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + t));
                        return false;
                    }
                    try {
                        d = bundle.getString("tbs_librarypath");
                        Object obj = null;
                        if (i2 != 0) {
                            try {
                                obj = k.a(r, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (i2 != -2) {
                            if (i2 != -1) {
                                if (i2 != 0) {
                                    TbsCoreLoadStat instance5 = TbsCoreLoadStat.getInstance();
                                    instance5.a(context, TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT, new Throwable("detail: " + obj + "errcode" + i2));
                                }
                            } else if (obj instanceof Integer) {
                                TbsCoreLoadStat instance6 = TbsCoreLoadStat.getInstance();
                                int intValue = ((Integer) obj).intValue();
                                instance6.a(context, intValue, new Throwable("detail: " + obj));
                            } else {
                                TbsCoreLoadStat instance7 = TbsCoreLoadStat.getInstance();
                                instance7.a(context, 307, new Throwable("detail: " + obj));
                            }
                        } else if (obj instanceof Integer) {
                            TbsCoreLoadStat instance8 = TbsCoreLoadStat.getInstance();
                            int intValue2 = ((Integer) obj).intValue();
                            instance8.a(context, intValue2, new Throwable("detail: " + obj));
                        } else {
                            TbsCoreLoadStat instance9 = TbsCoreLoadStat.getInstance();
                            instance9.a(context, TbsListener.ErrorCode.INFO_DISABLE_X5, new Throwable("detail: " + obj));
                        }
                        z4 = z6;
                    } catch (Exception unused3) {
                        return false;
                    }
                } catch (Throwable th) {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th);
                    return false;
                }
            }
            if (!z4) {
                TbsLog.e(TbsListener.tag_load_error, "319");
            }
            return z4;
        }
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        if (!a(context, false)) {
        }
        return false;
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            z = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static String getTID() {
        return z;
    }

    public static String getTbsResourcesPath(Context context) {
        return TbsShareManager.g(context);
    }

    public static void setQQBuildNumber(String str) {
        A = str;
    }

    public static String getQQBuildNumber() {
        return A;
    }

    static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!a) {
                a = true;
                v = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + v);
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_INNER, new Throwable(v));
            }
        }
    }

    public static void forceSysWebView() {
        b = true;
        u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        new Thread() {
            /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass1 */

            public void run() {
                u a2 = u.a();
                a2.a(context);
                final boolean a3 = a2.b() ? a2.c().a(context, str) : false;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        valueCallback.onReceiveValue(Boolean.valueOf(a3));
                    }
                });
            }
        }.start();
    }

    public static void closeFileReader(Context context) {
        u a2 = u.a();
        a2.a(context);
        if (a2.b()) {
            a2.c().p();
        }
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z2) {
        mDisableUseHostBackupCore = z2;
        TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    }

    public static void setDisableUnpreinitBySwitch(boolean z2) {
        B = z2;
        TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
    }

    public static synchronized boolean unPreInit(Context context) {
        synchronized (QbSdk.class) {
        }
        return true;
    }

    public static String getCurrentProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static synchronized void preInit(final Context context, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
            TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            l = a;
            if (!s) {
                final AnonymousClass3 r1 = new Handler(Looper.getMainLooper()) {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass3 */

                    public void handleMessage(Message message) {
                        v c;
                        PreInitCallback preInitCallback;
                        int i = message.what;
                        if (i == 1) {
                            boolean unused = QbSdk.B = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                            if (QbSdk.j && (c = u.a().c()) != null) {
                                c.a(context);
                            }
                            PreInitCallback preInitCallback2 = preInitCallback;
                            if (preInitCallback2 != null) {
                                preInitCallback2.onViewInitFinished(true);
                            }
                            TbsLog.writeLogToDisk();
                        } else if (i == 2) {
                            PreInitCallback preInitCallback3 = preInitCallback;
                            if (preInitCallback3 != null) {
                                preInitCallback3.onViewInitFinished(false);
                            }
                            TbsLog.writeLogToDisk();
                        } else if (i == 3 && (preInitCallback = preInitCallback) != null) {
                            preInitCallback.onCoreInitFinished();
                        }
                    }
                };
                AnonymousClass4 r6 = new Thread() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass4 */

                    public void run() {
                        int a2 = m.a().a(true, context);
                        TbsDownloader.setAppContext(context);
                        TbsLog.i("QbSdk", "QbSdk preinit ver is " + a2);
                        if (a2 == 0) {
                            m.a().b(context, true);
                        }
                        TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
                        d.a(true).a(context, false, false);
                        u a3 = u.a();
                        a3.a(context);
                        boolean b2 = a3.b();
                        r1.sendEmptyMessage(3);
                        if (!b2) {
                            r1.sendEmptyMessage(2);
                        } else {
                            r1.sendEmptyMessage(1);
                        }
                    }
                };
                r6.setName("tbs_preinit");
                r6.setPriority(10);
                r6.start();
                s = true;
            }
        }
    }

    public static void setUploadCode(Context context, int i2) {
        if (i2 >= 130 && i2 <= 139) {
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
            instance.a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(i2));
            instance.commit();
        } else if (i2 >= 150 && i2 <= 159) {
            TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(context);
            instance2.a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(i2));
            instance2.commit();
        }
    }

    public static void checkTbsValidity(Context context) {
        if (context != null && !m.b(context)) {
            TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CORE_CHECK_VALIDITY_FALSE);
            forceSysWebView();
        }
    }

    public static void disableAutoCreateX5Webview() {
        j = false;
    }

    public static boolean isTbsCoreInited() {
        d a2 = d.a(false);
        if (a2 == null || !a2.g()) {
            return false;
        }
        return true;
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        if (context == null) {
            TbsLog.e("QbSdk", "initX5Environment,context=null");
            return;
        }
        b(context);
        E = new TbsListener() {
            /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass5 */

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i) {
                QbSdk.preInit(context, preInitCallback);
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            m.a().b(context, d.a == 0);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() {
            /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass6 */

            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z, int i) {
                if (TbsShareManager.findCoreForThirdPartyApp(context) == 0 && !TbsShareManager.getCoreDisabled()) {
                    TbsShareManager.forceToLoadX5ForThirdApp(context, false);
                }
                if (QbSdk.i && TbsShareManager.isThirdPartyApp(context)) {
                    TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                }
                QbSdk.preInit(context, preInitCallback);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    private static void d(Context context) {
        int i2;
        int i3;
        int i4;
        Throwable th;
        C = true;
        int i5 = 0;
        SharedPreferences sharedPreferences = null;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
            } else {
                sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            }
            int i6 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
            if (i6 >= 0) {
                i6++;
                if (i6 <= 4) {
                    i3 = i6;
                } else {
                    return;
                }
            } else {
                i3 = -1;
            }
            try {
                i2 = m.a().i(context);
                if (i2 > 0) {
                    if (i6 <= 4) {
                        try {
                            sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i6).commit();
                        } catch (Throwable th2) {
                            th = th2;
                            TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                            i4 = -1;
                            if (i4 > 3) {
                            }
                        }
                    }
                    int i7 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i7 >= 0) {
                        i4 = i7 + 1;
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4).commit();
                        if (i4 > 3) {
                            try {
                                int i8 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                if (i8 == i2) {
                                    f.a(m.a().q(context), false);
                                    File a2 = k.a(context).a();
                                    if (a2 != null) {
                                        f.a(a2, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                                } else {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i8);
                                }
                                edit.putInt("tbs_precheck_disable_version", i8);
                                edit.commit();
                                return;
                            } catch (Throwable th3) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                                return;
                            }
                        } else {
                            if (i3 <= 0 || i3 > 3) {
                                i5 = -1;
                            } else {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                u.a().a(context);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            }
                            try {
                                int i9 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i9 > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i9 - 1).commit();
                                }
                            } catch (Throwable th4) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th4));
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i5);
                            return;
                        }
                    }
                    i4 = -1;
                    if (i4 > 3) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                i2 = -1;
                TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                i4 = -1;
                if (i4 > 3) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            i3 = -1;
            i2 = -1;
            TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
            i4 = -1;
            if (i4 > 3) {
            }
        }
    }

    public static int getTbsVersion(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        return m.a().i(context);
    }

    public static int getTbsVersionForCrash(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int j2 = m.a().j(context);
        if (j2 == 0 && k.a(context).c() == 3) {
            reset(context);
        }
        return j2;
    }

    public static void continueLoadSo(Context context) {
        if (TbsConfig.APP_WX.equals(getCurrentProcessName(context)) && WebView.mWebViewCreated) {
            k.a(r, "continueLoadSo", new Class[0], new Object[0]);
        }
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        Object obj = r;
        if (obj == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
            return false;
        }
        Bundle bundle = (Bundle) k.a(obj, "canLoadX5CoreAndNotLoadSo", new Class[]{Integer.TYPE}, 43903);
        if (bundle == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + m.a().a(true, context));
            return false;
        }
        t = bundle.getStringArray("tbs_jarfiles");
        d = bundle.getString("tbs_librarypath");
        return true;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        String[] strArr = t;
        if (strArr instanceof String[]) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr2[i2] = str + t[i2];
            }
            return strArr2;
        }
        Object a2 = k.a(r, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        boolean z2 = a2 instanceof String[];
        String[] strArr3 = a2;
        if (!z2) {
            strArr3 = new String[]{""};
        }
        return (String[]) strArr3;
    }

    public static boolean useSoftWare() {
        Object obj = r;
        if (obj == null) {
            return false;
        }
        Object a2 = k.a(obj, "useSoftWare", new Class[0], new Object[0]);
        if (a2 == null) {
            a2 = k.a(r, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public static void setTbsListener(TbsListener tbsListener) {
        D = tbsListener;
    }

    public static void setDownloadWithoutWifi(boolean z2) {
        F = z2;
    }

    public static boolean getDownloadWithoutWifi() {
        return F;
    }

    public static long getApkFileSize(Context context) {
        if (context != null) {
            return TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
        }
        return 0;
    }

    public static void setTBSInstallingStatus(boolean z2) {
        G = z2;
    }

    public static boolean getTBSInstalling() {
        return G;
    }

    static String a() {
        return p;
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059 A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    public static void reset(Context context, boolean z2) {
        boolean z3;
        File file;
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            if (z2 && !TbsShareManager.isThirdPartyApp(context)) {
                int h2 = m.a().h(context);
                int i2 = m.a().i(context);
                if (h2 > 43300 && h2 != i2) {
                    z3 = true;
                    TbsDownloader.c(context);
                    f.a(getTbsFolderDir(context), false, "core_share_decouple");
                    TbsLog.i("QbSdk", "delete downloaded apk success", true);
                    m.a.set(0);
                    file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (!z3) {
                        f.b(m.a().p(context), m.a().f(context, 0));
                        m.a().b(context);
                        return;
                    }
                    return;
                }
            }
            z3 = false;
            TbsDownloader.c(context);
            f.a(getTbsFolderDir(context), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            m.a.set(0);
            file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
            }
            if (!z3) {
            }
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
        }
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            f.b(m.a().p(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c A[SYNTHETIC, Splitter:B:19:0x006c] */
    public static void clearAllWebViewCache(Context context, boolean z2) {
        boolean z3;
        Throwable th;
        TbsLog.i("QbSdk", "clearAllWebViewCache(" + context + ", " + z2 + ")");
        boolean z4 = false;
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                try {
                    u a2 = u.a();
                    if (a2 != null && a2.b()) {
                        a2.c().a(context, z2);
                    }
                    z4 = true;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = true;
                    TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th));
                    z4 = z3;
                    if (z4) {
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z3 = false;
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th));
            z4 = z3;
            if (z4) {
            }
        }
        if (z4) {
            TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            return;
        }
        try {
            WebView webView = new WebView(context);
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z2) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th4) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th4));
        }
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_COUNTS);
        if (context == null) {
            return -100;
        }
        u a2 = u.a();
        a2.a(context);
        if (!a2.b()) {
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
            Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
            return -102;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return -101;
        } else {
            int a3 = a2.c().a(context, str, hashMap, null, valueCallback);
            if (a3 == 0) {
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            } else {
                TbsLogReport instance = TbsLogReport.getInstance(context);
                instance.setLoadErrorCode(TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_FAILED, "" + a3);
            }
            Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + a3);
            return a3;
        }
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        u a2 = u.a();
        a2.a(context);
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && a2.b()) {
            Bundle bundle = (Bundle) a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (c.a(context, str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
            return true;
        }
        if (!a2.b() || ((context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) || a2.c().a(context, str, hashMap, null, valueCallback) != 0)) {
            return false;
        }
        return true;
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i2) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i2, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_COUNTS);
        if (!checkContentProviderPrivilage(context)) {
            return -5;
        }
        if (str != null) {
            String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
            if (substring != null) {
                substring = substring.toLowerCase();
            }
            if ("apk".equalsIgnoreCase(substring)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                Uri a2 = FileProvider.a(context, str);
                if (a2 == null) {
                    valueCallback.onReceiveValue("uri failed");
                    return -6;
                }
                intent.setDataAndType(a2, "application/vnd.android.package-archive");
                context.startActivity(intent);
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_APKFILE);
                Log.e("QbSdk", "open openFileReader ret = 4");
                return 4;
            }
            if (!c.b(context)) {
                Log.d("QbSdk", "openFileReader QQ browser not installed");
            } else if (!a(context, str, substring)) {
                Log.e("QbSdk", "openFileReader open in QB isQBSupport: false  ret = 3");
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT);
                return 3;
            } else if (startQBForDoc(context, str, 4, 0, substring, a(context, hashMap))) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("open QB");
                }
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT);
                Log.e("QbSdk", "open openFileReader open QB ret = 1");
                return 1;
            } else {
                Log.d("QbSdk", "openFileReader startQBForDoc return false");
            }
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("local", "true");
            TbsLog.setWriteLogJIT(true);
            int startMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            if (startMiniQBToLoadUrl != 0) {
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsLogReport instance = TbsLogReport.getInstance(context);
                instance.setLoadErrorCode(511, "" + startMiniQBToLoadUrl);
                return 3;
            }
            TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
            return 2;
        }
        if (valueCallback != null) {
            valueCallback.onReceiveValue("filepath error");
        }
        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_FILEPATHISNULL);
        Log.e("QbSdk", "open openFileReader filepath error ret -1");
        return -1;
    }

    public static boolean checkContentProviderPrivilage(Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 24 || Build.VERSION.SDK_INT < 24 || TbsConfig.APP_QQ.equals(context.getApplicationInfo().packageName)) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "androidx.core.content.FileProvider"), 0).authority)) {
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(context.getApplicationInfo().packageName + ".provider", 128);
        if (resolveContentProvider == null) {
            Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
        if (resolveContentProvider != null) {
            return true;
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        return isSuportOpenFile(str2, 2);
    }

    private static Bundle a(Context context, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : map.get("style"));
            try {
                bundle.putInt("topBarBgColor", Color.parseColor(map.get("topBarBgColor")));
            } catch (Exception unused) {
            }
            if (map != null && map.containsKey(FILERADER_MENUDATA)) {
                JSONObject jSONObject = new JSONObject(map.get(FILERADER_MENUDATA));
                JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                if (jSONArray != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    int i2 = 0;
                    while (i2 < jSONArray.length() && i2 < 5) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            arrayList.add(i2, BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt("iconResId")));
                            jSONObject2.put("iconResId", i2);
                        } catch (Exception unused2) {
                        }
                        i2++;
                    }
                    bundle.putParcelableArrayList("resArray", arrayList);
                }
                bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
            }
            return bundle;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMiniQBVersion(Context context) {
        u a2 = u.a();
        a2.a(context);
        if (a2 == null || !a2.b()) {
            return null;
        }
        return a2.c().f();
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        u a2;
        if (!(context == null || TbsDownloader.getOverSea(context) || isMiniQBShortCutExist(context, str, str2) || (a2 = u.a()) == null || !a2.b())) {
            Bitmap bitmap = null;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            DexLoader b2 = a2.c().b();
            TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = b2.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
            if (invokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        u a2;
        Object invokeStaticMethod;
        if (context == null || TbsDownloader.getOverSea(context) || (a2 = u.a()) == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str)) == null) {
            return false;
        }
        Boolean bool = false;
        if (invokeStaticMethod instanceof Boolean) {
            bool = (Boolean) invokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        u a2;
        if (context != null && !TbsDownloader.getOverSea(context) && (a2 = u.a()) != null && a2.b()) {
            if (a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        String str3;
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            try {
                str3 = context.getApplicationInfo().packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, str3);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (c.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                u a2 = u.a();
                if (a2 != null && a2.b() && a2.c().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        if (context != null && !context.getApplicationInfo().packageName.equals("com.tencent.qim") && !context.getApplicationInfo().packageName.equals("com.tencent.tim") && !context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
            String string = bundle != null ? bundle.getString("ChannelId") : "";
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            String c2 = d.c(str);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            Uri a2 = FileProvider.a(context, str);
            if (a2 == null) {
                valueCallback.onReceiveValue("uri failed");
                return;
            }
            intent.setDataAndType(a2, c2);
            isDefaultDialog = false;
            com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, c2, string);
            String a3 = cVar.a();
            if (a3 != null && !TextUtils.isEmpty(a3) && checkApkExist(context, a3)) {
                if (TbsConfig.APP_QB.equals(a3)) {
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
                }
                if (!TextUtils.isEmpty(string)) {
                    intent.putExtra("big_brother_source_key", string);
                }
                intent.setPackage(a3);
                context.startActivity(intent);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("default browser:" + a3);
                }
            } else if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && isDefaultDialog) {
                new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass8 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
            } else if (!isDefaultDialog) {
                try {
                    cVar.show();
                    cVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass9 */

                        public void onDismiss(DialogInterface dialogInterface) {
                            ValueCallback valueCallback = valueCallback;
                            if (valueCallback != null) {
                                valueCallback.onReceiveValue("TbsReaderDialogClosed");
                            }
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                    valueCallback.onReceiveValue("TbsReaderDialogClosed");
                }
            } else if (valueCallback != null) {
                valueCallback.onReceiveValue("can not open");
            }
        }
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean isSuportOpenFile(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {"rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        String[] strArr2 = {"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub"};
        if (i2 == 1) {
            return Arrays.asList(strArr2).contains(str.toLowerCase());
        }
        if (i2 != 2) {
            return false;
        }
        return Arrays.asList(strArr).contains(str.toLowerCase());
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    public static void openBrowserList(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        if (context != null) {
            String string = bundle != null ? bundle.getString("ChannelId") : "";
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(str));
            String c2 = d.c(str);
            isDefaultDialog = false;
            com.tencent.smtt.sdk.b.a.c cVar = new com.tencent.smtt.sdk.b.a.c(context, "选择其它应用打开", intent, valueCallback, c2, string);
            String a2 = cVar.a();
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                if (TbsConfig.APP_QB.equals(a2)) {
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
                }
                intent.setPackage(a2);
                intent.putExtra("big_brother_source_key", string);
                context.startActivity(intent);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("default browser:" + a2);
                }
            } else if (isDefaultDialog) {
                new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass10 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("can not open");
                }
            } else {
                cVar.show();
                cVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass2 */

                    public void onDismiss(DialogInterface dialogInterface) {
                        ValueCallback valueCallback = valueCallback;
                        if (valueCallback != null) {
                            valueCallback.onReceiveValue("TbsReaderDialogClosed");
                        }
                    }
                });
            }
        }
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Map<String, Object> map2 = n;
        if (map2 == null) {
            n = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Map<String, Object> getSettings() {
        return n;
    }

    static Object a(Context context, String str, Bundle bundle) {
        if (!a(context)) {
            return Integer.valueOf((int) EXTENSION_INIT_FAILURE);
        }
        Object a2 = k.a(r, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    protected static String b() {
        Object invokeStaticMethod;
        u a2 = u.a();
        if (a2 == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0])) == null || !(invokeStaticMethod instanceof String)) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            try {
                a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void disAllowThirdAppDownload() {
        c = false;
    }

    public static void initBuglyAsync(boolean z2) {
        i = z2;
    }

    public static void setNeedInitX5FirstTime(boolean z2) {
        w = z2;
    }

    public static boolean isNeedInitX5FirstTime() {
        return w;
    }

    public static int getTmpDirTbsVersion(Context context) {
        if (k.a(context).c() == 2) {
            return m.a().e(context, 0);
        }
        if (k.a(context).b("copy_status") == 1) {
            return m.a().e(context, 1);
        }
        return 0;
    }

    public static File getTbsFolderDir(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (b.c()) {
                return context.getDir("tbs_64", 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return context.getDir("tbs", 0);
    }
}
