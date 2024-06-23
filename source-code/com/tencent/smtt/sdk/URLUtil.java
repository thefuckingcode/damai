package com.tencent.smtt.sdk;

public final class URLUtil {
    public static String guessUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.guessUrl(str);
        }
        return a.c().m(str);
    }

    public static String composeSearchUrl(String str, String str2, String str3) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
        }
        return a.c().a(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.decode(bArr);
        }
        return a.c().a(bArr);
    }

    public static boolean isAssetUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isAssetUrl(str);
        }
        return a.c().n(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isCookielessProxyUrl(str);
        }
        return a.c().o(str);
    }

    public static boolean isFileUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isFileUrl(str);
        }
        return a.c().p(str);
    }

    public static boolean isAboutUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isAboutUrl(str);
        }
        return a.c().q(str);
    }

    public static boolean isDataUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isDataUrl(str);
        }
        return a.c().r(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isJavaScriptUrl(str);
        }
        return a.c().s(str);
    }

    public static boolean isHttpUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isHttpUrl(str);
        }
        return a.c().t(str);
    }

    public static boolean isHttpsUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isHttpsUrl(str);
        }
        return a.c().u(str);
    }

    public static boolean isNetworkUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isNetworkUrl(str);
        }
        return a.c().v(str);
    }

    public static boolean isContentUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isContentUrl(str);
        }
        return a.c().w(str);
    }

    public static boolean isValidUrl(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.isValidUrl(str);
        }
        return a.c().x(str);
    }

    public static String stripAnchor(String str) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.stripAnchor(str);
        }
        return a.c().y(str);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        u a = u.a();
        if (a == null || !a.b()) {
            return android.webkit.URLUtil.guessFileName(str, str2, str3);
        }
        return a.c().b(str, str2, str3);
    }
}
