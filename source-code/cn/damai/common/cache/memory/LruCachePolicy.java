package cn.damai.common.cache.memory;

import androidx.collection.LruCache;
import cn.damai.common.cache.common.CachePolicy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class LruCachePolicy<K, V> implements CachePolicy<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private LruCache<K, V> b;

    public LruCachePolicy() {
        int maxCacheSize = maxCacheSize();
        this.a = maxCacheSize;
        if (maxCacheSize > 0) {
            this.b = new LruCache<K, V>(maxCacheSize) {
                /* class cn.damai.common.cache.memory.LruCachePolicy.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* access modifiers changed from: protected */
                @Override // androidx.collection.LruCache
                public void entryRemoved(boolean z, K k, V v, V v2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1704462287")) {
                        ipChange.ipc$dispatch("1704462287", new Object[]{this, Boolean.valueOf(z), k, v, v2});
                        return;
                    }
                    LruCachePolicy.this.a(z, k, v, v2);
                }

                /* access modifiers changed from: protected */
                @Override // androidx.collection.LruCache
                public int sizeOf(K k, V v) {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "155990714")) {
                        return LruCachePolicy.this.computeValueSize(v);
                    }
                    return ((Integer) ipChange.ipc$dispatch("155990714", new Object[]{this, k, v})).intValue();
                }
            };
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    public abstract void a(boolean z, K k, V v, V v2);

    @Override // cn.damai.common.cache.common.CachePolicy
    public V cacheValue(K k, V v) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1719640881")) {
            return this.b.put(k, v);
        }
        return (V) ipChange.ipc$dispatch("-1719640881", new Object[]{this, k, v});
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264222365")) {
            ipChange.ipc$dispatch("-1264222365", new Object[]{this});
            return;
        }
        this.b.evictAll();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int currentCacheSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-175671869")) {
            return this.b.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-175671869", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int evictionCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1325308269")) {
            return this.b.evictionCount();
        }
        return ((Integer) ipChange.ipc$dispatch("-1325308269", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int getHitCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1867063441")) {
            return this.b.hitCount();
        }
        return ((Integer) ipChange.ipc$dispatch("1867063441", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int getMissCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1820677584")) {
            return this.b.missCount();
        }
        return ((Integer) ipChange.ipc$dispatch("1820677584", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public V getValue(K k) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2085204951")) {
            return this.b.get(k);
        }
        return (V) ipChange.ipc$dispatch("2085204951", new Object[]{this, k});
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public boolean shouldTrim() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1922082409")) {
            return currentCacheSize() > this.a;
        }
        return ((Boolean) ipChange.ipc$dispatch("1922082409", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public void trim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541690536")) {
            ipChange.ipc$dispatch("-1541690536", new Object[]{this});
            return;
        }
        this.b.trimToSize(this.a);
    }
}
