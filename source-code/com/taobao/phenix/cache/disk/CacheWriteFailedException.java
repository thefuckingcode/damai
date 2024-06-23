package com.taobao.phenix.cache.disk;

/* compiled from: Taobao */
public class CacheWriteFailedException extends Exception {
    public CacheWriteFailedException(DiskCache diskCache, String str) {
        super("disk cache=" + diskCache + " write failed, url=" + str);
    }
}
