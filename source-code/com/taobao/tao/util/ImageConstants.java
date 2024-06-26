package com.taobao.tao.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class ImageConstants {
    public static final String isTaobaocdnPic = ".*taobao.*|.*cdn.*";
    private static Pattern sCDNPattern;

    public static boolean isTaboCDN(String str) {
        if (sCDNPattern == null) {
            sCDNPattern = Pattern.compile(isTaobaocdnPic);
        }
        if (!TextUtils.isEmpty(str) && !str.contains("a.tbcdn") && !str.contains("b.tbcdn")) {
            return sCDNPattern.matcher(str).matches();
        }
        return false;
    }
}
