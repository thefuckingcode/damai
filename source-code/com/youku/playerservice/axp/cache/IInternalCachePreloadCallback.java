package com.youku.playerservice.axp.cache;

import com.youku.playerservice.axp.cache.CachePreloadResult;

/* compiled from: Taobao */
public interface IInternalCachePreloadCallback {
    void onResult(String str, CachePreloadParams cachePreloadParams, CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus, CachePreloadResult cachePreloadResult);
}
