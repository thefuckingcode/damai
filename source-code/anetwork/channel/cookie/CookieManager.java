package anetwork.channel.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.taobao.windvane.connect.HttpConnector;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.http.NetworkSdkSetting;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.sh1;
import tb.w6;
import tb.yy0;

/* compiled from: Taobao */
public class CookieManager {
    public static final String TAG = "anet.CookieManager";
    private static volatile boolean a = false;
    private static android.webkit.CookieManager b = null;
    private static boolean c = true;
    private static a d;
    private static SharedPreferences e;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        String a;
        String b;
        String c;
        String d;
        long e;

        a(String str) {
            this.a = str;
            String string = CookieManager.e.getString("networksdk_cookie_monitor", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (!TextUtils.isEmpty(this.a) && this.a.equals(jSONObject.getString("cookieName"))) {
                        this.e = jSONObject.getLong("time");
                        if (System.currentTimeMillis() - this.e < 86400000) {
                            this.b = jSONObject.getString("cookieText");
                            this.c = jSONObject.getString("setCookie");
                            this.d = jSONObject.getString("domain");
                            return;
                        }
                        this.e = 0;
                        CookieManager.e.edit().remove("networksdk_cookie_monitor").apply();
                    }
                } catch (JSONException e2) {
                    ALog.d(CookieManager.TAG, "cookie json parse error.", null, e2, new Object[0]);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.a);
                jSONObject.put("cookieText", this.b);
                jSONObject.put("setCookie", this.c);
                long currentTimeMillis = System.currentTimeMillis();
                this.e = currentTimeMillis;
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("domain", this.d);
                CookieManager.e.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e2) {
                ALog.d(CookieManager.TAG, "cookie json save error.", null, e2, new Object[0]);
            }
        }
    }

    private static boolean e() {
        if (!a && NetworkSdkSetting.getContext() != null) {
            n(NetworkSdkSetting.getContext());
        }
        return a;
    }

    private static void f(Context context) {
        ThreadPoolExecutorFactory.d(new Runnable() {
            /* class anetwork.channel.cookie.CookieManager.AnonymousClass1 */

            public void run() {
                try {
                    if (!TextUtils.isEmpty(CookieManager.j())) {
                        a unused = CookieManager.d = new a(CookieManager.j());
                    }
                } catch (Exception e) {
                    ALog.d(CookieManager.TAG, "", null, e, new Object[0]);
                }
            }
        });
    }

    private static void g(final String str, final String str2) {
        ThreadPoolExecutorFactory.d(new Runnable() {
            /* class anetwork.channel.cookie.CookieManager.AnonymousClass3 */

            public void run() {
                if (CookieManager.d != null) {
                    try {
                        if (!TextUtils.isEmpty(CookieManager.d.a) && HttpCookie.domainMatches(CookieManager.d.d, yy0.g(str).d()) && !TextUtils.isEmpty(str2)) {
                            String str = str2;
                            if (!str.contains(CookieManager.d.a + "=")) {
                                CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(str);
                                cookieMonitorStat.cookieName = CookieManager.d.a;
                                cookieMonitorStat.cookieText = CookieManager.d.b;
                                cookieMonitorStat.setCookie = CookieManager.d.c;
                                cookieMonitorStat.missType = 1;
                                w6.b().commitStat(cookieMonitorStat);
                            }
                        }
                    } catch (Exception e) {
                        ALog.d(CookieManager.TAG, "cookieMonitorReport error.", null, e, new Object[0]);
                    }
                }
            }
        });
    }

    private static void h(final String str) {
        ThreadPoolExecutorFactory.d(new Runnable() {
            /* class anetwork.channel.cookie.CookieManager.AnonymousClass2 */

            public void run() {
                if (CookieManager.d != null) {
                    try {
                        for (HttpCookie httpCookie : HttpCookie.parse(str)) {
                            if (httpCookie.getName().equals(CookieManager.d.a)) {
                                CookieManager.d.b = httpCookie.toString();
                                CookieManager.d.d = httpCookie.getDomain();
                                CookieManager.d.c = str;
                                CookieManager.d.a();
                                return;
                            }
                        }
                    } catch (Exception e) {
                        ALog.d(CookieManager.TAG, "cookieMonitorSave error.", null, e, new Object[0]);
                    }
                }
            }
        });
    }

    public static synchronized String i(String str) {
        synchronized (CookieManager.class) {
            String str2 = null;
            if (!e() || !c) {
                return null;
            }
            try {
                str2 = b.getCookie(str);
            } catch (Throwable th) {
                ALog.d(TAG, "get cookie failed. url=" + str, null, th, new Object[0]);
            }
            g(str, str2);
            return str2;
        }
    }

    /* access modifiers changed from: private */
    public static String j() {
        SharedPreferences sharedPreferences = e;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    public static synchronized void k(String str, String str2) {
        synchronized (CookieManager.class) {
            if (e() && c) {
                try {
                    b.setCookie(str, str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        b.flush();
                    }
                } catch (Throwable th) {
                    ALog.d(TAG, "set cookie failed.", null, th, "url", str, "cookies", str2);
                }
            }
        }
    }

    public static void l(String str, Map<String, List<String>> map) {
        if (str != null && map != null) {
            try {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null && (key.equalsIgnoreCase(HttpConnector.SET_COOKIE) || key.equalsIgnoreCase("Set-Cookie2"))) {
                        for (String str2 : entry.getValue()) {
                            k(str, str2);
                            h(str2);
                        }
                    }
                }
            } catch (Exception e2) {
                ALog.d(TAG, "set cookie failed", null, e2, "url", str, "\nheaders", map);
            }
        }
    }

    public static void m(String str) {
        SharedPreferences sharedPreferences;
        if (str != null && (sharedPreferences = e) != null) {
            sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
        }
    }

    public static synchronized void n(Context context) {
        synchronized (CookieManager.class) {
            if (!a) {
                if (sh1.n()) {
                    ALog.e(TAG, "cookie manager disable.", null, new Object[0]);
                    a = true;
                    c = false;
                    return;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = Build.VERSION.SDK_INT;
                    if (i < 21) {
                        CookieSyncManager.createInstance(context);
                    }
                    android.webkit.CookieManager instance = android.webkit.CookieManager.getInstance();
                    b = instance;
                    instance.setAcceptCookie(true);
                    if (i < 21) {
                        b.removeExpiredCookie();
                    }
                    e = PreferenceManager.getDefaultSharedPreferences(context);
                    f(context);
                    ALog.e(TAG, "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    c = false;
                    ALog.d(TAG, "Cookie Manager setup failed!!!", null, th, new Object[0]);
                }
                a = true;
            }
        }
    }
}
