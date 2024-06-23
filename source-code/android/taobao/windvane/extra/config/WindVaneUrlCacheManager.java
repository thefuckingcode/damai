package android.taobao.windvane.extra.config;

import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WindVaneUrlCacheManager {
    static Map<String, String> urlMap;

    public static String getCacheFilePath(String str) {
        String str2 = null;
        if (urlMap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (WindVaneUrlCacheManager.class) {
            if (urlMap.containsKey(str)) {
                str2 = urlMap.get(str);
            }
        }
        return str2;
    }

    public static boolean registerUrl(String str, String str2) {
        synchronized (WindVaneUrlCacheManager.class) {
            if (urlMap == null) {
                urlMap = new HashMap();
            }
            if (!new File(str).exists()) {
                return false;
            }
            Map<String, String> map = urlMap;
            map.put(str2, "File://" + str);
            return true;
        }
    }

    public static void unRegisterUrl(String str) {
        if (urlMap != null) {
            synchronized (WindVaneUrlCacheManager.class) {
                if (urlMap.containsKey(str)) {
                    urlMap.remove(str);
                }
            }
        }
    }
}
