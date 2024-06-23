package mtopsdk.network.cookie;

import android.content.Context;
import android.webkit.CookieSyncManager;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
public class CookieManager {
    public static final String TAG = "mtopsdk.CookieManager";
    private static volatile boolean isSetup;
    public static android.webkit.CookieManager webkitCookMgr;

    public static synchronized String getCookie(String str) {
        synchronized (CookieManager.class) {
            String str2 = null;
            if (!isSetup) {
                return null;
            }
            try {
                str2 = webkitCookMgr.getCookie(str);
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "get cookie failed. url=" + str, th);
            }
            return str2;
        }
    }

    public static synchronized void setCookie(String str, String str2) {
        synchronized (CookieManager.class) {
            if (isSetup) {
                try {
                    webkitCookMgr.setCookie(str, str2);
                    CookieSyncManager.getInstance().sync();
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, "set cookie failed. url=" + str + " cookies=" + str2, th);
                }
            }
        }
    }

    public static synchronized void setup(Context context) {
        synchronized (CookieManager.class) {
            if (!isSetup) {
                if (context != null) {
                    CookieSyncManager.createInstance(context);
                    android.webkit.CookieManager instance = android.webkit.CookieManager.getInstance();
                    webkitCookMgr = instance;
                    instance.setAcceptCookie(true);
                    webkitCookMgr.removeExpiredCookie();
                    isSetup = true;
                }
            }
        }
    }
}
