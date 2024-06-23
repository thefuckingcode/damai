package tb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Deprecated
/* compiled from: Taobao */
public class ib1 {
    public static Map<String, String> a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (map == null || map.size() <= 0 || (r1 = map.keySet().iterator()) == null) {
            return null;
        }
        for (String str : map.keySet()) {
            String c = zf2.c(map.get(str));
            if (str != null) {
                hashMap.put(str, c);
            }
        }
        return hashMap;
    }

    public static Map<String, String> b(Properties properties) {
        if (properties == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Object obj : properties.keySet()) {
            if (obj instanceof String) {
                String c = zf2.c(obj);
                String c2 = zf2.c(properties.get(obj));
                if (!zf2.f(c) && !zf2.f(c2)) {
                    hashMap.put(c, c2);
                }
            }
        }
        return hashMap;
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (str instanceof String) {
                String str2 = map.get(str);
                if (!zf2.f(str) && !zf2.f(str2)) {
                    try {
                        hashMap.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }
}
