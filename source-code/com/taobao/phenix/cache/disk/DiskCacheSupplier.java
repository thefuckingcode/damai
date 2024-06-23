package com.taobao.phenix.cache.disk;

import java.util.Collection;

/* compiled from: Taobao */
public interface DiskCacheSupplier {
    DiskCache get(int i);

    Collection<DiskCache> getAll();
}
