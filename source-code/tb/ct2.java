package tb;

import android.net.Uri;
import android.taobao.windvane.config.WVServerConfig;
import android.text.TextUtils;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.a;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
public class ct2 {
    public static final String CONFIG_GROUP_URL_CHECK_SWITCH = "url_check_switch";
    public static final String CONFIG_GROUP_WEEX_BLACKURL_GROUP = "weex_config_render_black_urls";
    public static final String CONFIG_GROUP_WEEX_WHITEURL_GROUP = "weex_config_render_white_urls";
    public static final String CONFIG_GROUP_WEEX_WHITE_SCHEME_GROUP = "weex_config_render_white_schema";
    public static final String CONFIG_KEY_IS_CHECK = "is_check";
    public static final String CONFIG_KEY_IS_RENDER = "is_render";
    public static final String CONFIG_KEY_WEEX_BLACKURL = "blackurl";
    public static final String CONFIG_KEY_WEEX_WHITEURL = "whiteurl";
    public static final String CONFIG_KEY_WEEX_WHITE_SCHEME = "white_schema";

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            WXLogUtils.d("checkUrl expectedUrls is empty true");
            return false;
        }
        WXLogUtils.d("checkUrl hostUrl is " + str + "expectedUrls is " + str2);
        if (str2.startsWith(jl1.MUL)) {
            return str.endsWith(str2.substring(1));
        }
        return str.equals(str2);
    }

    private static String b(String str) {
        String str2;
        try {
            str2 = Uri.parse(str).getHost();
        } catch (Throwable unused) {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("/")) {
            return str2;
        }
        String substring = str.substring(1);
        while (substring.startsWith("/")) {
            substring = substring.substring(1);
        }
        try {
            return Uri.parse("https://" + substring).getHost();
        } catch (Throwable unused2) {
            return str2;
        }
    }

    public static boolean c(String str) {
        if (WVServerConfig.isBlackUrl(str)) {
            return false;
        }
        String str2 = null;
        try {
            str2 = b(str);
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
        if (e(str2)) {
            return false;
        }
        if (WVServerConfig.isTrustedUrl(str) || TextUtils.isEmpty(str2) || g(str2)) {
            return true;
        }
        return f(str);
    }

    public static boolean d(String str) {
        IConfigAdapter c = a.l().c();
        if (c != null) {
            boolean booleanValue = Boolean.valueOf(c.getConfig(CONFIG_GROUP_URL_CHECK_SWITCH, CONFIG_KEY_IS_CHECK, "")).booleanValue();
            boolean booleanValue2 = Boolean.valueOf(c.getConfig(CONFIG_GROUP_URL_CHECK_SWITCH, CONFIG_KEY_IS_RENDER, "")).booleanValue();
            if (booleanValue) {
                if (WVServerConfig.isBlackUrl(str)) {
                    return false;
                }
                String str2 = null;
                try {
                    str2 = b(str);
                } catch (Throwable th) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(th));
                }
                if (e(str2)) {
                    return false;
                }
                if (!WVServerConfig.isTrustedUrl(str) && !TextUtils.isEmpty(str2) && !g(str2) && !f(str)) {
                    return booleanValue2;
                }
                return true;
            }
        }
        return true;
    }

    public static boolean e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                WXLogUtils.d("urlHost is empty");
                return false;
            }
            IConfigAdapter c = a.l().c();
            if (c == null) {
                return false;
            }
            String config = c.getConfig(CONFIG_GROUP_WEEX_BLACKURL_GROUP, CONFIG_KEY_WEEX_BLACKURL, "");
            if (TextUtils.isEmpty(config)) {
                return false;
            }
            String[] split = config.split(",");
            if (split != null) {
                if (split.length != 0) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2) && a(str, str2)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            WXLogUtils.d("expectedUrls is empty");
            return false;
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
    }

    public static boolean f(String str) {
        IConfigAdapter c;
        String[] split;
        try {
            if (TextUtils.isEmpty(str) || (c = a.l().c()) == null) {
                return false;
            }
            String config = c.getConfig(CONFIG_GROUP_WEEX_WHITE_SCHEME_GROUP, CONFIG_KEY_WEEX_WHITE_SCHEME, "");
            if (TextUtils.isEmpty(config) || (split = config.split(",")) == null || split.length == 0) {
                return false;
            }
            String str2 = null;
            try {
                str2 = Uri.parse(str).getScheme();
            } catch (Throwable unused) {
            }
            boolean z = !TextUtils.isEmpty(str2);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    if (!z) {
                        if (str.startsWith(str3 + ke1.SCHEME_SLASH)) {
                            return true;
                        }
                    } else if (TextUtils.equals(str3, str2)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
    }

    public static boolean g(String str) {
        IConfigAdapter c;
        String[] split;
        try {
            if (TextUtils.isEmpty(str) || (c = a.l().c()) == null) {
                return false;
            }
            String config = c.getConfig(CONFIG_GROUP_WEEX_WHITEURL_GROUP, CONFIG_KEY_WEEX_WHITEURL, "*.m.taobao.com,xilivr.ewszjk.m.jaeapp.com,luckygiftphp.ewszjk.m.jaeapp.com,xuan.ews.m.jaeapp.com");
            if (!TextUtils.isEmpty(config) && (split = config.split(",")) != null) {
                if (split.length != 0) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2) && a(str, str2)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
    }

    public static boolean h(String str) {
        IConfigAdapter c = a.l().c();
        if (c != null) {
            boolean booleanValue = Boolean.valueOf(c.getConfig(CONFIG_GROUP_URL_CHECK_SWITCH, CONFIG_KEY_IS_CHECK, "")).booleanValue();
            boolean booleanValue2 = Boolean.valueOf(c.getConfig(CONFIG_GROUP_URL_CHECK_SWITCH, CONFIG_KEY_IS_RENDER, "")).booleanValue();
            if (!booleanValue || WVServerConfig.isBlackUrl(str) || c(str) || !booleanValue2) {
                return false;
            }
            return true;
        }
        return false;
    }
}
