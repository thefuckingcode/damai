package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;
    CopyOnWriteArrayList<b> a;
    String b;
    a c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* access modifiers changed from: package-private */
    public class b {
        int a;
        String b;
        String c;
        ValueCallback<Boolean> d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (d == null) {
            synchronized (CookieManager.class) {
                if (d == null) {
                    d = new CookieManager();
                }
            }
        }
        return d;
    }

    public void removeSessionCookie() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 21) {
            k.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public void removeAllCookie() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            a2.c().e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 21) {
            k.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public void flush() {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (Build.VERSION.SDK_INT >= 21) {
            k.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public void removeExpiredCookie() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (Build.VERSION.SDK_INT >= 21) {
            k.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            Object invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (invokeStaticMethod == null) {
                return true;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        } else if (Build.VERSION.SDK_INT < 21) {
            return true;
        } else {
            Object a3 = k.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            if (a3 == null) {
                return false;
            }
            return ((Boolean) a3).booleanValue();
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            if (this.f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!u.a().d()) {
                b bVar = new b();
                bVar.a = 2;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = null;
                if (this.a == null) {
                    this.a = new CopyOnWriteArrayList<>();
                }
                this.a.add(bVar);
            }
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        }
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            if (!u.a().d()) {
                b bVar = new b();
                bVar.a = 1;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = valueCallback;
                if (this.a == null) {
                    this.a = new CopyOnWriteArrayList<>();
                }
                this.a.add(bVar);
            }
            if (this.f) {
                if (Build.VERSION.SDK_INT >= 21) {
                    k.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
                }
            }
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public boolean hasCookies() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.CookieManager.getInstance().hasCookies();
        }
        return a2.c().h();
    }

    public boolean acceptCookie() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.CookieManager.getInstance().acceptCookie();
        }
        return a2.c().d();
    }

    public String getCookie(String str) {
        u a2 = u.a();
        if (a2 != null && a2.b()) {
            return a2.c().a(str);
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setCookies(Map<String, String[]> map) {
        u a2 = u.a();
        if (!((a2 == null || !a2.b()) ? false : a2.c().a(map))) {
            for (String str : map.keySet()) {
                for (String str2 : map.get(str)) {
                    setCookie(str, str2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        this.f = true;
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            if (copyOnWriteArrayList.size() != 0) {
                u a2 = u.a();
                if (a2 == null || !a2.b()) {
                    Iterator<b> it = this.a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        int i = next.a;
                        if (i != 1) {
                            if (i == 2) {
                                android.webkit.CookieManager.getInstance().setCookie(next.b, next.c);
                            }
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            k.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, next.b, next.c, next.d);
                        }
                    }
                } else {
                    Iterator<b> it2 = this.a.iterator();
                    while (it2.hasNext()) {
                        b next2 = it2.next();
                        int i2 = next2.a;
                        if (i2 == 1) {
                            setCookie(next2.b, next2.c, next2.d);
                        } else if (i2 == 2) {
                            setCookie(next2.b, next2.c);
                        }
                    }
                }
                this.a.clear();
            }
        }
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            return false;
        }
        this.c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (aVar == a.MODE_NONE || !z || u.a().d()) {
            return true;
        }
        u.a().a(context);
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0100  */
    public synchronized void a(Context context, boolean z, boolean z2) {
        int i;
        int i2;
        if (!(this.c == a.MODE_NONE || context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME))) {
            if (!this.e) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 0;
                String str = LOGTAG;
                TbsLog.i(str, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
                if (!z && !QbSdk.getIsSysWebViewForcedByOuter()) {
                    if (!QbSdk.a) {
                        u.a().a(context);
                        return;
                    }
                }
                int i3 = 0;
                r4 = false;
                r4 = false;
                boolean z3 = false;
                if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.a) {
                    z2 = false;
                }
                boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
                String str2 = LOGTAG;
                TbsLog.i(str2, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
                if (canUseFunction != z2) {
                    TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                    if (TextUtils.isEmpty(this.b)) {
                        tbsLogInfo.setErrorCode(701);
                        i = 0;
                    } else if (m.a().i(context) <= 0 || m.a().i(context) >= 36001) {
                        if (canUseFunction) {
                            i2 = h.d(context);
                            if (i2 > 0) {
                                i = getROMCookieDBVersion(context);
                                if (i <= 0) {
                                    z3 = true;
                                }
                                if (z3 && (i2 <= 0 || i <= 0)) {
                                    tbsLogInfo.setErrorCode(702);
                                } else if (i >= i2) {
                                    tbsLogInfo.setErrorCode(703);
                                } else {
                                    h.a(context, this.c, this.b, z3, z2);
                                    tbsLogInfo.setErrorCode(TbsListener.ErrorCode.INFO_COOKIE_SWITCH_TRANSFER);
                                    j = System.currentTimeMillis() - currentTimeMillis;
                                }
                                i3 = i2;
                            }
                        } else {
                            i2 = h.d(context);
                            if (i2 > 0) {
                                String d2 = m.a().d(context, "cookies_database_version");
                                if (!TextUtils.isEmpty(d2)) {
                                    try {
                                        i = Integer.parseInt(d2);
                                    } catch (Exception unused) {
                                    }
                                    if (z3) {
                                    }
                                    if (i >= i2) {
                                    }
                                    i3 = i2;
                                }
                            }
                        }
                        i = 0;
                        if (z3) {
                        }
                        if (i >= i2) {
                        }
                        i3 = i2;
                    } else {
                        return;
                    }
                    tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i3 + " to:" + i + ",timeused:" + j);
                    TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
                }
            }
        }
    }

    public static int getROMCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        return sharedPreferences.getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("db_version", i);
        edit.commit();
    }
}
