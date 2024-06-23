package android.taobao.windvane.util;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"DefaultLocale"})
/* compiled from: Taobao */
public class WVUrlUtil {
    private static Map<String, String> mimeTypes = new HashMap();

    static {
        MimeTypeEnum[] values = MimeTypeEnum.values();
        for (MimeTypeEnum mimeTypeEnum : values) {
            mimeTypes.put(mimeTypeEnum.getSuffix(), mimeTypeEnum.getMimeType());
        }
    }

    public static String addParam(String str, String str2, String str3) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (parse.getQueryParameter(str2) != null) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.appendQueryParameter(str2, str3);
        return buildUpon.toString();
    }

    public static String force2HttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("^((?i)https:)?//", "http://");
    }

    private static char getLastChar(String str) {
        return str.charAt(str.length() - 1);
    }

    public static String getMimeType(String str) {
        String str2 = mimeTypes.get(getSuffix(str));
        return str2 == null ? "" : str2;
    }

    public static String getMimeTypeExtra(String str) {
        if (str.contains("??")) {
            str = str.replaceFirst("\\?\\?", "");
        }
        return getMimeType(str);
    }

    public static Map<String, String> getParamMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            if (substring.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                substring = substring.substring(0, substring.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
            }
            for (String str2 : substring.split("&")) {
                String[] split = str2.split("=");
                if (split.length < 2) {
                    hashMap.put(split[0], "");
                } else {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static String getParamVal(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return Uri.parse(str).getQueryParameter(str2);
    }

    public static int getQureyIndex(String str) {
        int indexOf;
        int length = str.length();
        int i = 0;
        while (true) {
            indexOf = str.indexOf("?", i);
            if (indexOf == -1) {
                return -1;
            }
            int i2 = indexOf + 1;
            if (i2 >= length || str.charAt(i2) != '?') {
                return indexOf;
            }
            i = indexOf + 2;
        }
        return indexOf;
    }

    public static String getRemoveQueriesUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                if (parse.isHierarchical()) {
                    return new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).toString();
                }
            } catch (Throwable unused) {
            }
            int indexOf = str.indexOf("?");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String getSuffix(String str) {
        String path;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (lastIndexOf = path.lastIndexOf(".")) == -1) {
            return "";
        }
        return path.substring(lastIndexOf + 1);
    }

    public static boolean isCommonUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://")) {
            return true;
        }
        return false;
    }

    public static boolean isHtml(String str) {
        String path;
        if (!TextUtils.isEmpty(str) && !str.contains("??") && (path = Uri.parse(str).getPath()) != null) {
            if (path.endsWith("." + MimeTypeEnum.HTM.getSuffix())) {
                return true;
            }
            if (path.endsWith("." + MimeTypeEnum.HTML.getSuffix()) || TextUtils.isEmpty(path) || "/".equals(path)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isImg(String str) {
        return getMimeType(str).startsWith("image");
    }

    public static boolean isRes(String str) {
        String suffix = getSuffix(str);
        return MimeTypeEnum.JS.getSuffix().equals(suffix) || MimeTypeEnum.CSS.getSuffix().equals(suffix);
    }

    public static String[] parseCombo(String str) {
        String removeQueryParam = removeQueryParam(str);
        int indexOf = removeQueryParam.indexOf("??");
        if (-1 == indexOf) {
            return null;
        }
        return removeQueryParam.substring(indexOf + 2).split("\\,");
    }

    public static String rebuildWVurl(String str, String str2) {
        StringBuilder sb = new StringBuilder(str2);
        char lastChar = getLastChar(str2);
        if (!('?' == lastChar || '&' == lastChar)) {
            if (str2.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
        }
        if ('?' != getLastChar(str) && str.contains("?")) {
            String[] split = str.split("\\?");
            for (int i = 1; i < split.length; i++) {
                if (split[i] != null) {
                    sb.append(split[i]);
                }
                if (i != split.length - 1) {
                    sb.append("?");
                }
            }
        }
        return sb.toString();
    }

    public static String removeHashCode(String str) {
        return (!TextUtils.isEmpty(str) && str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) != -1) ? str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) : str;
    }

    public static String removeQueryParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int qureyIndex = getQureyIndex(str);
        if (qureyIndex != -1) {
            return str.substring(0, qureyIndex);
        }
        return str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0 ? str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) : str;
    }

    public static String removeScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = null;
        if (str.startsWith("http:")) {
            str2 = str.replace("http:", "");
        }
        if (str.startsWith("https:")) {
            str2 = str.replace("https:", "");
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static boolean shouldTryABTest(String str) {
        Uri parse = Uri.parse(str);
        if (!parse.isHierarchical()) {
            return false;
        }
        String path = parse.getPath();
        if (path.endsWith(".htm") || path.endsWith(".html") || path.endsWith(".js")) {
            return true;
        }
        return false;
    }
}
