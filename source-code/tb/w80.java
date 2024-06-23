package tb;

import android.util.SparseIntArray;
import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;

/* compiled from: Taobao */
public class w80 implements Builder<DiskCacheSupplier> {
    private final SparseIntArray a;
    private boolean b;
    private DiskCacheSupplier c;

    public w80() {
        SparseIntArray sparseIntArray = new SparseIntArray(4);
        this.a = sparseIntArray;
        sparseIntArray.put(17, 83886080);
        sparseIntArray.put(34, 10485760);
        sparseIntArray.put(51, 31457280);
        sparseIntArray.put(68, 10485760);
        sparseIntArray.put(85, 20971520);
    }

    /* renamed from: a */
    public synchronized DiskCacheSupplier build() {
        if (this.b) {
            return this.c;
        }
        if (this.c == null) {
            this.c = new dj1();
            vr2.i("DiskCache", "use default non-operation DiskCacheSupplier, cause not implement a custom DiskCacheSupplier", new Object[0]);
        }
        this.b = true;
        cs1.d(this.c.get(17), "DiskCache for the priority(TOP_USED_1) cannot be null");
        for (DiskCache diskCache : this.c.getAll()) {
            diskCache.maxSize(this.a.get(diskCache.getPriority(), 0));
        }
        return this.c;
    }

    public w80 b(int i, int i2) {
        cs1.e(!this.b, "DiskCacheBuilder has been built, not allow maxSize() now");
        this.a.put(i, i2);
        return this;
    }

    /* renamed from: c */
    public w80 with(DiskCacheSupplier diskCacheSupplier) {
        cs1.e(!this.b, "DiskCacheBuilder has been built, not allow with() now");
        this.c = diskCacheSupplier;
        return this;
    }
}
