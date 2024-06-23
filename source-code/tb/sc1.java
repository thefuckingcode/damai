package tb;

import com.alibaba.pictures.bricks.util.blur.Cache;
import com.alibaba.pictures.bricks.util.blur.CachePolicy;
import com.alibaba.pictures.bricks.util.blur.KeyTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class sc1<K, V> implements Cache<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private CachePolicy<K, V> a;
    private KeyTransformer b;

    public sc1(CachePolicy cachePolicy, KeyTransformer keyTransformer) {
        this.a = cachePolicy;
        this.b = keyTransformer;
    }

    @Override // com.alibaba.pictures.bricks.util.blur.Cache
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893379458")) {
            ipChange.ipc$dispatch("-893379458", new Object[]{this});
            return;
        }
        this.a.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.alibaba.pictures.bricks.util.blur.CachePolicy<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.bricks.util.blur.Cache
    public V get(K k) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591358049")) {
            return (V) ipChange.ipc$dispatch("1591358049", new Object[]{this, k});
        }
        return (V) this.a.getValue(this.b.transform(k));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.alibaba.pictures.bricks.util.blur.CachePolicy<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.bricks.util.blur.Cache
    public void save(K k, V v) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1378150234")) {
            ipChange.ipc$dispatch("1378150234", new Object[]{this, k, v});
            return;
        }
        this.a.cacheValue(this.b.transform(k), v);
        if (this.a.shouldTrim()) {
            this.a.trim();
        }
    }
}
