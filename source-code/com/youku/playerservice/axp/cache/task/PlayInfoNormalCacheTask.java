package com.youku.playerservice.axp.cache.task;

import com.youku.playerservice.axp.cache.CachePreloadParams;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.IInternalCachePreloadCallback;

/* compiled from: Taobao */
public class PlayInfoNormalCacheTask extends CacheTask {
    private IInternalCachePreloadCallback mInternalCallback;
    private String mKey;
    private CachePreloadParams mPreloadParams;

    public PlayInfoNormalCacheTask(String str, CachePreloadParams cachePreloadParams, IInternalCachePreloadCallback iInternalCachePreloadCallback) {
        this.mKey = str;
        this.mPreloadParams = cachePreloadParams;
        this.mInternalCallback = iInternalCachePreloadCallback;
    }

    @Override // java.util.concurrent.Callable, com.youku.playerservice.axp.cache.task.CacheTask, com.youku.playerservice.axp.cache.task.CacheTask
    public CachePreloadResult call() {
        return null;
    }
}
