package anet.channel.strategy.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class SerialLruCache<K, V> extends LinkedHashMap<K, V> {
    private static final int DEFAULT_CACHE_SIZE = 256;
    private static final long serialVersionUID = -4331642331292721006L;
    private int cacheSize;

    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap, int i) {
        super(linkedHashMap);
        this.cacheSize = i;
    }

    /* access modifiers changed from: protected */
    public boolean entryRemoved(Map.Entry<K, V> entry) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.cacheSize) {
            return entryRemoved(entry);
        }
        return false;
    }

    @Deprecated
    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap) {
        this(linkedHashMap, 256);
    }

    public SerialLruCache(int i) {
        super(i + 1, 1.0f, true);
        this.cacheSize = i;
    }
}
