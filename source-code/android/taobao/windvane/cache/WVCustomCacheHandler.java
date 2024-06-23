package android.taobao.windvane.cache;

import java.io.InputStream;
import java.util.Map;

/* compiled from: Taobao */
public interface WVCustomCacheHandler {
    InputStream loadRequest(String[] strArr, String str, Map<String, String> map, Map<String, String> map2);
}
