package android.taobao.windvane.cache;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class WVMemoryCacheInfo {
    public long cachedTime = 0;
    public byte[] mCachedDatas = null;
    public Map<String, List<String>> mCachedHeaders = null;

    WVMemoryCacheInfo(Map<String, List<String>> map, byte[] bArr) {
        this.mCachedDatas = bArr;
        this.mCachedHeaders = map;
        this.cachedTime = System.currentTimeMillis();
    }
}
