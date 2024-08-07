package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.cache.disk.DiskCacheKeyValueStore;

/* compiled from: Taobao */
public class x80 implements Builder<DiskCacheKeyValueStore> {
    private boolean a;
    private DiskCacheKeyValueStore b;

    /* renamed from: a */
    public DiskCacheKeyValueStore build() {
        if (this.a) {
            return this.b;
        }
        this.a = true;
        DiskCacheKeyValueStore diskCacheKeyValueStore = this.b;
        if (diskCacheKeyValueStore != null) {
            diskCacheKeyValueStore.init();
        }
        return this.b;
    }

    /* renamed from: b */
    public Builder<DiskCacheKeyValueStore> with(DiskCacheKeyValueStore diskCacheKeyValueStore) {
        this.b = diskCacheKeyValueStore;
        return this;
    }
}
