package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: X5CoreWizard */
public class v {
    private DexLoader a;

    public v(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public boolean a() throws Throwable {
        Method method = this.a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke instanceof Boolean) {
            return ((Boolean) invoke).booleanValue();
        }
        return ((Boolean) invoke).booleanValue();
    }

    public DexLoader b() {
        return this.a;
    }

    public Object c() {
        return this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    public boolean d() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void e() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    public boolean a(Map<String, String[]> map) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void a(boolean z) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075 A[RETURN] */
    public IX5WebViewBase a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Exception e;
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) invokeStaticMethod2));
                }
                invokeStaticMethod = null;
                iX5WebViewBase = null;
            } catch (Exception e2) {
                e = e2;
                iX5WebViewBase = null;
                e.printStackTrace();
                if (invokeStaticMethod == null) {
                }
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (invokeStaticMethod == null) {
                    }
                }
            }
        }
        if (invokeStaticMethod == null) {
            return null;
        }
        return iX5WebViewBase;
    }

    public String a(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public String f() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public InputStream a(String str, boolean z) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (invokeStaticMethod == null) {
            return null;
        }
        return (InputStream) invokeStaticMethod;
    }

    public Object g() {
        return this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    public boolean h() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public IX5WebChromeClient i() {
        Object invokeStaticMethod;
        DexLoader dexLoader = this.a;
        if (dexLoader == null || (invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0])) == null) {
            return null;
        }
        return (IX5WebChromeClient) invokeStaticMethod;
    }

    public IX5WebViewClient j() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClient) invokeStaticMethod;
    }

    public IX5WebViewClientExtension k() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClientExtension) invokeStaticMethod;
    }

    public void b(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    public Uri[] a(int i, Intent intent) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (Uri[]) invokeStaticMethod;
    }

    public void l() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    public void a(String str, IconListener iconListener) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    public void c(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    public void d(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    public void m() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    public boolean b(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void c(Context context) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    public boolean d(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void e(Context context) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    public boolean f(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void g(Context context) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    public void a(ValueCallback<Map> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
    }

    public void a(String str, ValueCallback<Long> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    public void b(String str, ValueCallback<Long> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    public void a(String str, long j) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
    }

    public void e(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    public void n() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    public IX5DateSorter h(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5DateSorter) invokeStaticMethod;
    }

    public void b(ValueCallback<Set<String>> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
    }

    public void c(String str, ValueCallback<Boolean> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    public void f(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
    }

    public void g(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
    }

    public void o() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    }

    public String h(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public boolean i(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public String j(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public boolean k(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public String l(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public String m(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public String a(String str, String str2, String str3) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public byte[] a(byte[] bArr) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (byte[]) invokeStaticMethod;
    }

    public boolean n(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean o(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean p(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean q(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean r(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean s(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean t(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean u(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean v(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean w(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean x(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public String y(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public String b(String str, String str2, String str3) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public void a(Context context, boolean z) {
        TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            return;
        }
        try {
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
        } catch (Exception unused) {
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            Object invokeStaticMethod2 = this.a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod2 != null) {
                this.a.invokeMethod(invokeStaticMethod2, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        }
    }

    public int a(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        if (TbsDownloader.getOverSea(context)) {
            return -103;
        }
        if (str2 == null) {
            Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, context, str, map, valueCallback);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            if (invokeStaticMethod == null) {
                return -104;
            }
            return ((Integer) invokeStaticMethod).intValue();
        }
        Object invokeStaticMethod2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
        if (invokeStaticMethod2 == null) {
            return -104;
        }
        return ((Integer) invokeStaticMethod2).intValue();
    }

    public boolean a(Context context, String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    public void p() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }

    public String i(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof String) {
            return (String) invokeStaticMethod;
        }
        return null;
    }

    public IX5CoreServiceWorkerController q() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getServiceWorkerController", new Class[0], new Object[0]);
        if (invokeStaticMethod instanceof IX5CoreServiceWorkerController) {
            return (IX5CoreServiceWorkerController) invokeStaticMethod;
        }
        return null;
    }
}
