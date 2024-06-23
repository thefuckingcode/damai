package mtopsdk.framework.filter.duplex;

import android.content.Context;
import anetwork.network.cache.Cache;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.cache.CacheManager;
import mtopsdk.mtop.cache.CacheManagerImpl;
import mtopsdk.mtop.cache.domain.ApiCacheDo;
import mtopsdk.mtop.cache.handler.CacheStatusHandler;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.global.SwitchConfig;

/* compiled from: Taobao */
public class CacheDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.CacheDuplexFilter";
    private static final Map<Cache, CacheManager> cacheManagerMap = new ConcurrentHashMap(2);

    private void updateApiCacheConf(MtopContext mtopContext, MtopResponse mtopResponse, String str, Map<String, List<String>> map) {
        String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "cache-control");
        if (!StringUtils.isBlank(singleHeaderFieldByKey)) {
            AppConfigManager instance = AppConfigManager.getInstance();
            String api = mtopResponse.getApi();
            String v = mtopResponse.getV();
            String concatStr2LowerCase = StringUtils.concatStr2LowerCase(api, v);
            ApiCacheDo apiCacheDoByKey = instance.getApiCacheDoByKey(concatStr2LowerCase);
            Context context = mtopContext.mtopInstance.getMtopConfig().context;
            if (apiCacheDoByKey == null) {
                ApiCacheDo apiCacheDo = new ApiCacheDo(api, v, str);
                instance.parseCacheControlHeader(singleHeaderFieldByKey, apiCacheDo);
                instance.addApiCacheDoToGroup(concatStr2LowerCase, apiCacheDo);
                instance.storeApiCacheDoMap(context, mtopContext.seqNo);
            } else if (!singleHeaderFieldByKey.equals(apiCacheDoByKey.cacheControlHeader)) {
                instance.parseCacheControlHeader(singleHeaderFieldByKey, apiCacheDoByKey);
                instance.storeApiCacheDoMap(context, mtopContext.seqNo);
            }
        }
    }

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        if (SwitchConfig.getInstance().degradeApiCacheSet != null) {
            String key = mtopContext.mtopRequest.getKey();
            if (SwitchConfig.getInstance().degradeApiCacheSet.contains(key)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    String str = mtopContext.seqNo;
                    TBSdkLog.i(TAG, str, "apiKey in degradeApiCacheList,apiKey=" + key);
                }
                return "CONTINUE";
            }
        }
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        ResponseSource responseSource = mtopContext.responseSource;
        if (mtopResponse.isApiSuccess() && responseSource != null) {
            Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
            CacheManager cacheManager = responseSource.cacheManager;
            if (cacheManager.isNeedWriteCache(mtopContext.networkRequest, headerFields)) {
                cacheManager.putCache(responseSource.getCacheKey(), responseSource.getCacheBlock(), mtopResponse);
                updateApiCacheConf(mtopContext, mtopResponse, responseSource.getCacheBlock(), headerFields);
            }
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        ResponseSource responseSource;
        Exception e;
        if (SwitchConfig.getInstance().degradeApiCacheSet != null) {
            String key = mtopContext.mtopRequest.getKey();
            if (SwitchConfig.getInstance().degradeApiCacheSet.contains(key)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, mtopContext.seqNo, "apiKey in degradeApiCacheList,apiKey=" + key);
                }
                return "CONTINUE";
            }
        }
        mtopContext.stats.cacheSwitch = 1;
        Cache cache = mtopContext.mtopInstance.getMtopConfig().cacheImpl;
        if (cache == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, mtopContext.seqNo, " CacheImpl is null. instanceId=" + mtopContext.mtopInstance.getInstanceId());
            }
            return "CONTINUE";
        }
        Map<Cache, CacheManager> map = cacheManagerMap;
        CacheManager cacheManager = map.get(cache);
        if (cacheManager == null) {
            synchronized (map) {
                cacheManager = map.get(cache);
                if (cacheManager == null) {
                    cacheManager = new CacheManagerImpl(cache);
                    map.put(cache, cacheManager);
                }
            }
        }
        ResponseSource responseSource2 = null;
        try {
            if (cacheManager.isNeedReadCache(mtopContext.networkRequest, mtopContext.mtopListener)) {
                responseSource = new ResponseSource(mtopContext, cacheManager);
                try {
                    mtopContext.responseSource = responseSource;
                    responseSource.rpcCache = cacheManager.getCache(responseSource.getCacheKey(), responseSource.getCacheBlock(), mtopContext.seqNo);
                    CacheStatusHandler.handleCacheStatus(responseSource, mtopContext.property.handler);
                } catch (Exception e2) {
                    e = e2;
                }
                responseSource2 = responseSource;
            }
        } catch (Exception e3) {
            responseSource = null;
            e = e3;
            TBSdkLog.e(TAG, mtopContext.seqNo, "[initResponseSource] initResponseSource error,apiKey=" + mtopContext.mtopRequest.getKey(), e);
            responseSource2 = responseSource;
            if (responseSource2 != null) {
            }
            return "CONTINUE";
        }
        if (responseSource2 != null || responseSource2.requireConnection) {
            return "CONTINUE";
        }
        mtopContext.mtopResponse = responseSource2.cacheResponse;
        FilterUtils.handleExceptionCallBack(mtopContext);
        return "STOP";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
