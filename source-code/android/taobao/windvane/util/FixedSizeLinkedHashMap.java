package android.taobao.windvane.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 2230704826523879449L;
    private Object lock = new Object();
    private long maxSize = 10;

    public FixedSizeLinkedHashMap() {
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public V get(Object obj) {
        V v;
        synchronized (this.lock) {
            v = (V) super.get(obj);
        }
        return v;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public V put(K k, V v) {
        V v2;
        synchronized (this.lock) {
            v2 = (V) super.put(k, v);
        }
        return v2;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return ((long) size()) > this.maxSize;
    }

    public void setMaxSize(long j) {
        this.maxSize = j;
    }

    public FixedSizeLinkedHashMap(long j) {
        this.maxSize = j;
    }
}
