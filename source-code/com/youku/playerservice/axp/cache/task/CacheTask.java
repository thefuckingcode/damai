package com.youku.playerservice.axp.cache.task;

import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
public class CacheTask implements Callable {
    @Override // java.util.concurrent.Callable
    public CachePreloadResult call() {
        return null;
    }

    /* access modifiers changed from: protected */
    public CachePreloadResult generateResult(PlayInfoResponse playInfoResponse) {
        CachePreloadResult cachePreloadResult = new CachePreloadResult();
        cachePreloadResult.setError(playInfoResponse.getError());
        return cachePreloadResult;
    }
}
