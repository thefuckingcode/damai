package tb;

import cn.damai.common.cache.common.Cache;
import cn.damai.common.cache.common.CachePolicy;
import cn.damai.common.cache.common.KeyTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class tc1<K, V> implements Cache<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private CachePolicy<K, V> a;
    private KeyTransformer b;

    public tc1(CachePolicy cachePolicy, KeyTransformer keyTransformer) {
        this.a = cachePolicy;
        this.b = keyTransformer;
    }

    @Override // cn.damai.common.cache.common.Cache
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115935073")) {
            ipChange.ipc$dispatch("-115935073", new Object[]{this});
            return;
        }
        this.a.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: cn.damai.common.cache.common.CachePolicy<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.damai.common.cache.common.Cache
    public V get(K k) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15146592")) {
            return (V) ipChange.ipc$dispatch("15146592", new Object[]{this, k});
        }
        return (V) this.a.getValue(this.b.transform(k));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: cn.damai.common.cache.common.CachePolicy<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.damai.common.cache.common.Cache
    public void save(K k, V v) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532571751")) {
            ipChange.ipc$dispatch("-1532571751", new Object[]{this, k, v});
            return;
        }
        this.a.cacheValue(this.b.transform(k), v);
        if (this.a.shouldTrim()) {
            this.a.trim();
        }
    }
}
