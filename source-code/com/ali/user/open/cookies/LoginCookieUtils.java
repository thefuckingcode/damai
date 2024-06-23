package com.ali.user.open.cookies;

import android.text.TextUtils;
import com.ali.user.open.core.trace.SDKLogger;
import org.json.JSONObject;

/* compiled from: Taobao */
public class LoginCookieUtils {
    private static final char COMMA = ',';
    private static final String DISCARD = "discard";
    private static final int DISCARD_LENGTH = 7;
    private static final String DOMAIN = "domain";
    private static final char EQUAL = '=';
    private static final String EXPIRES = "expires";
    private static final String HTTPS = "https";
    private static final String HTTP_ONLY = "httponly";
    private static final int HTTP_ONLY_LENGTH = 8;
    private static final String MAX_AGE = "max-age";
    private static final int MAX_COOKIE_LENGTH = 4096;
    private static final String PATH = "path";
    private static final char PATH_DELIM = '/';
    private static final char PERIOD = '.';
    private static final char QUESTION_MARK = '?';
    private static final char QUOTATION = '\"';
    private static final String SECURE = "secure";
    private static final int SECURE_LENGTH = 6;
    private static final char SEMICOLON = ';';
    private static final String TAG = "login.LoginCookieUtils";
    private static final String VERSION = "version";
    private static final char WHITE_SPACE = ' ';

    public static void expiresCookies(LoginCookie loginCookie) {
        Long l = 1000L;
        loginCookie.expires = l.longValue();
    }

    public static String getHttpDomin(LoginCookie loginCookie) {
        String str = loginCookie.domain;
        if (!TextUtils.isEmpty(str) && str.startsWith(".")) {
            str = str.substring(1);
        }
        return "https://" + str;
    }

    public static JSONObject getKeyValues(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            String cookie = CookieManagerService.getWebViewProxy().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                String[] split = cookie.split(";");
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        if (split2[0].contains(str)) {
                            if (split2.length == 2) {
                                jSONObject.put(split2[0].trim(), split2[1].trim());
                            } else {
                                jSONObject.put(split2[0].trim(), str2.substring(str2.indexOf("=") + 1));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String getValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String cookie = CookieManagerService.getWebViewProxy().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                String[] split = cookie.split(";");
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        if (str.equals(split2[0].trim())) {
                            int indexOf = str2.indexOf("=");
                            if (split2.length == 2) {
                                return split2[1].trim();
                            }
                            return str2.substring(indexOf + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c5, code lost:
        if (r20.charAt(r7) == r8) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e9, code lost:
        if (r20.charAt(r7) == r8) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0109, code lost:
        if (r20.charAt(r7) == r8) goto L_0x00c7;
     */
    public static LoginCookie parseCookie(String str) {
        int indexOf;
        int indexOf2;
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < 0 || i >= length) {
                break;
            }
            char c = ' ';
            if (str.charAt(i) == ' ') {
                i++;
            } else {
                int indexOf3 = str.indexOf(59, i);
                char c2 = '=';
                int indexOf4 = str.indexOf(61, i);
                LoginCookie loginCookie = new LoginCookie();
                if ((indexOf3 == -1 || indexOf3 >= indexOf4) && indexOf4 != -1) {
                    loginCookie.name = str.substring(i, indexOf4);
                    if (indexOf4 >= length - 1 || str.charAt(indexOf4 + 1) != '\"' || (i = str.indexOf(34, indexOf4 + 2)) != -1) {
                        int indexOf5 = str.indexOf(59, i);
                        indexOf3 = indexOf5 == -1 ? length : indexOf5;
                        if (indexOf3 - indexOf4 > 4096) {
                            int i2 = indexOf4 + 1;
                            loginCookie.value = str.substring(i2, i2 + 4096);
                        } else {
                            int i3 = indexOf4 + 1;
                            if (i3 == indexOf3 || indexOf3 < indexOf4) {
                                loginCookie.value = "";
                            } else {
                                loginCookie.value = str.substring(i3, indexOf3);
                            }
                        }
                    }
                } else {
                    if (indexOf3 == -1) {
                        indexOf3 = length;
                    }
                    loginCookie.name = str.substring(i, indexOf3);
                    loginCookie.value = null;
                }
                while (indexOf3 >= 0 && indexOf3 < length) {
                    if (str.charAt(indexOf3) != c && str.charAt(indexOf3) != ';') {
                        if (str.charAt(indexOf3) == ',') {
                            break;
                        }
                        int i4 = length - indexOf3;
                        int i5 = SECURE_LENGTH;
                        if (i4 < i5 || !str.substring(indexOf3, indexOf3 + i5).equalsIgnoreCase(SECURE)) {
                            int i6 = HTTP_ONLY_LENGTH;
                            if (i4 < i6 || !str.substring(indexOf3, indexOf3 + i6).equalsIgnoreCase(HTTP_ONLY)) {
                                int i7 = DISCARD_LENGTH;
                                if (i4 < i7 || !str.substring(indexOf3, indexOf3 + i7).equalsIgnoreCase(DISCARD)) {
                                    int indexOf6 = str.indexOf(c2, indexOf3);
                                    if (indexOf6 > 0) {
                                        String lowerCase = str.substring(indexOf3, indexOf6).toLowerCase();
                                        if (lowerCase.equals("expires") && (indexOf2 = str.indexOf(44, indexOf6)) != -1 && indexOf2 - indexOf6 <= 10) {
                                            indexOf3 = indexOf2 + 1;
                                        }
                                        int indexOf7 = str.indexOf(59, indexOf3);
                                        indexOf3 = str.indexOf(44, indexOf3);
                                        if (indexOf7 == -1 && indexOf3 == -1) {
                                            indexOf3 = length;
                                        } else if (indexOf7 != -1) {
                                            if (indexOf3 != -1) {
                                                indexOf7 = Math.min(indexOf7, indexOf3);
                                            }
                                            indexOf3 = indexOf7;
                                        }
                                        try {
                                            String substring = str.substring(indexOf6 + 1, indexOf3);
                                            if (substring.length() > 2 && substring.charAt(0) == '\"' && (indexOf = substring.indexOf(34, 1)) > 0) {
                                                substring = substring.substring(1, indexOf);
                                            }
                                            if (lowerCase.equals("expires")) {
                                                try {
                                                    loginCookie.expires = HttpDateTime.parse(substring);
                                                } catch (IllegalArgumentException e) {
                                                    SDKLogger.e(TAG, "illegal format for expires: " + substring, e);
                                                }
                                            } else if (lowerCase.equals(MAX_AGE)) {
                                                try {
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    long parseLong = Long.parseLong(substring);
                                                    Long.signum(parseLong);
                                                    loginCookie.expires = currentTimeMillis + (parseLong * 1000);
                                                } catch (NumberFormatException e2) {
                                                    SDKLogger.e(TAG, "illegal format for max-age: " + substring, e2);
                                                }
                                            } else if (lowerCase.equals("path")) {
                                                if (substring.length() > 0) {
                                                    loginCookie.path = substring;
                                                }
                                            } else if (lowerCase.equals("domain")) {
                                                int lastIndexOf = substring.lastIndexOf(46);
                                                if (lastIndexOf == 0) {
                                                    loginCookie.domain = null;
                                                } else {
                                                    try {
                                                        Integer.parseInt(substring.substring(lastIndexOf + 1));
                                                    } catch (NumberFormatException unused) {
                                                        String lowerCase2 = substring.toLowerCase();
                                                        if (lowerCase2.charAt(0) != '.') {
                                                            lowerCase2 = '.' + lowerCase2;
                                                        }
                                                        loginCookie.domain = lowerCase2;
                                                    }
                                                }
                                            } else if (lowerCase.equals("version") && substring.length() > 0) {
                                                loginCookie.version = substring;
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    } else {
                                        indexOf3 = length;
                                        c = ' ';
                                    }
                                } else {
                                    indexOf3 += i7;
                                    loginCookie.discard = true;
                                    if (indexOf3 == length) {
                                        break;
                                    }
                                }
                            } else {
                                indexOf3 += i6;
                                loginCookie.httpOnly = true;
                                if (indexOf3 == length) {
                                    break;
                                }
                            }
                        } else {
                            indexOf3 += i5;
                            loginCookie.secure = true;
                            if (indexOf3 == length) {
                                break;
                            }
                        }
                        indexOf3++;
                        c = ' ';
                    } else {
                        indexOf3++;
                    }
                    c = ' ';
                    c2 = '=';
                }
                return loginCookie;
            }
        }
        return null;
    }
}
