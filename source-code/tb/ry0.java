package tb;

import android.text.TextUtils;
import anet.channel.request.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
public class ry0 {
    public static boolean a(a aVar, int i) {
        return aVar.s() && i >= 300 && i < 400 && i != 304 && aVar.m() < 10;
    }

    public static Map<String, List<String>> b(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return hashMap;
    }

    public static List<String> c(Map<String, List<String>> map, String str) {
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(str)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public static String d(Map<String, List<String>> map, String str) {
        List<String> c = c(map, str);
        if (c == null || c.isEmpty()) {
            return null;
        }
        return c.get(0);
    }

    public static boolean e(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("X-Cache");
            if (list != null && !list.isEmpty()) {
                return list.get(0).toUpperCase().startsWith("HIT");
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int f(Map<String, List<String>> map) {
        try {
            return Integer.parseInt(d(map, Constants.Protocol.CONTENT_LENGTH));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String g(Map<String, List<String>> map) {
        return d(map, HttpHeaderConstant.EAGLE_TRACE_ID);
    }

    public static long h(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("s-rt");
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return Long.parseLong(list.get(0));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static int i(Map<String, List<String>> map) {
        try {
            List<String> list = map.get(okhttp3.internal.http2.a.RESPONSE_STATUS_UTF8);
            if (list != null && !list.isEmpty()) {
                return Integer.parseInt(list.get(0));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }

    public static void j(Map<String, List<String>> map, String str) {
        if (str != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equalsIgnoreCase(it.next())) {
                        break;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            if (str != null) {
                map.remove(str);
            }
        }
    }

    public static String k(String str) {
        int lastIndexOf;
        if (str == null) {
            return null;
        }
        try {
            int length = str.length();
            if (length <= 1 || (lastIndexOf = str.lastIndexOf(47)) == -1) {
                return null;
            }
            if (lastIndexOf == length - 1) {
                return null;
            }
            int lastIndexOf2 = str.lastIndexOf(46);
            if (lastIndexOf2 == -1) {
                return null;
            }
            if (lastIndexOf2 <= lastIndexOf) {
                return null;
            }
            return str.substring(lastIndexOf2 + 1, length);
        } catch (Exception unused) {
            return null;
        }
    }
}
