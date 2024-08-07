package com.taobao.alivfssdk.fresco.cache.disk;

import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import com.taobao.alivfssdk.fresco.cache.disk.DiskStorage;
import com.taobao.alivfssdk.fresco.common.disk.DiskTrimmable;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
public interface FileCache extends DiskTrimmable, Closeable {
    void clearAll();

    long clearOldEntries(long j);

    List<String> getCatalogs(CacheKey cacheKey);

    long getCount();

    DiskStorage.a getDumpInfo() throws IOException;

    Collection<DiskStorage.Entry> getEntries() throws IOException;

    BinaryResource getResource(CacheKey cacheKey);

    long getSize();

    boolean hasKey(CacheKey cacheKey);

    boolean hasKeySync(CacheKey cacheKey);

    BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException;

    boolean isEnabled();

    boolean probe(CacheKey cacheKey);

    boolean remove(CacheKey cacheKey);
}
