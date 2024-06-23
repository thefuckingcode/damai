package android.taobao.windvane.cache;

import android.taobao.windvane.util.TaoLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class WVCustomCacheManager {
    private static final String TAG = "WVCustomCacheManager";
    private static WVCustomCacheManager sInstance;
    private List<WVCustomCacheHandler> mCacheHandlers = new ArrayList();

    private WVCustomCacheManager() {
    }

    public static WVCustomCacheManager getInstance() {
        if (sInstance == null) {
            synchronized (WVCustomCacheManager.class) {
                if (sInstance == null) {
                    sInstance = new WVCustomCacheManager();
                }
            }
        }
        return sInstance;
    }

    public InputStream getCacheResource(String str, String[] strArr, Map<String, String> map, Map<String, String> map2) {
        List<WVCustomCacheHandler> list = this.mCacheHandlers;
        if (list != null) {
            for (WVCustomCacheHandler wVCustomCacheHandler : list) {
                try {
                    InputStream loadRequest = wVCustomCacheHandler.loadRequest(strArr, str, map, map2);
                    if (loadRequest != null) {
                        TaoLog.d(TAG, "hit custom cache by " + wVCustomCacheHandler.toString() + " with url " + str);
                        return loadRequest;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        TaoLog.d(TAG, "custom cache not hit " + str);
        return null;
    }

    public void registerHandler(WVCustomCacheHandler wVCustomCacheHandler) {
        List<WVCustomCacheHandler> list = this.mCacheHandlers;
        if (list != null && wVCustomCacheHandler != null) {
            list.add(list.size(), wVCustomCacheHandler);
        }
    }
}
