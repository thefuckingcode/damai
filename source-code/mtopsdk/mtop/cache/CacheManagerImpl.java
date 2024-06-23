package mtopsdk.mtop.cache;

import anetwork.network.cache.Cache;
import anetwork.network.cache.RpcCache;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.cache.domain.ApiCacheDo;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.protocol.converter.util.NetworkConverterUtils;
import mtopsdk.mtop.util.ReflectUtil;
import mtopsdk.network.domain.Request;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
public class CacheManagerImpl implements CacheManager {
    private static final String METHOD_GET = "GET";
    private static final String QUERY_KEY_DATA = "data";
    private static final String QUERY_KEY_WUA = "wua";
    private static final String TAG = "mtopsdk.CacheManagerImpl";
    private Cache cache = null;

    public CacheManagerImpl(Cache cache2) {
        this.cache = cache2;
    }

    private RpcCache handleCacheValidation(String str, RpcCache rpcCache) {
        if (rpcCache == null) {
            return rpcCache;
        }
        if (rpcCache.body == null) {
            rpcCache.cacheStatus = RpcCache.CacheStatus.TIMEOUT;
            return rpcCache;
        }
        String str2 = rpcCache.lastModified;
        if (str2 == null && rpcCache.etag == null) {
            if (rpcCache.offline) {
                rpcCache.cacheStatus = RpcCache.CacheStatus.NEED_UPDATE;
            } else {
                rpcCache.cacheStatus = RpcCache.CacheStatus.TIMEOUT;
            }
            return rpcCache;
        }
        if (StringUtils.isNotBlank(str2)) {
            long j = rpcCache.cacheCreateTime;
            long j2 = rpcCache.maxAge;
            long correctionTime = SDKUtils.getCorrectionTime();
            if (correctionTime >= j && correctionTime <= j + j2) {
                rpcCache.cacheStatus = RpcCache.CacheStatus.FRESH;
            } else if (rpcCache.offline) {
                rpcCache.cacheStatus = RpcCache.CacheStatus.NEED_UPDATE;
            } else {
                rpcCache.cacheStatus = RpcCache.CacheStatus.TIMEOUT;
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("[handleCacheValidation]cacheStatus=");
                sb.append(rpcCache.cacheStatus);
                sb.append(";lastModifiedStr=");
                sb.append(rpcCache.lastModified);
                sb.append(";lastModified=");
                sb.append(j);
                sb.append(";maxAge=");
                sb.append(j2);
                sb.append(";currentTime=");
                sb.append(correctionTime);
                sb.append(";t_offset=");
                sb.append(XState.getTimeOffset());
                TBSdkLog.i(TAG, str, sb.toString());
            }
        } else if (StringUtils.isNotBlank(rpcCache.etag)) {
            rpcCache.cacheStatus = RpcCache.CacheStatus.NEED_UPDATE;
        }
        return rpcCache;
    }

    private RpcCache handleResponseCacheFlag(String str, RpcCache rpcCache) {
        Map<String, List<String>> map;
        if (!(rpcCache == null || (map = rpcCache.header) == null)) {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "last-modified");
            String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "cache-control");
            String singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, HttpHeaderConstant.MTOP_X_ETAG);
            if (singleHeaderFieldByKey3 == null) {
                singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "etag");
            }
            if (singleHeaderFieldByKey2 == null && singleHeaderFieldByKey == null && singleHeaderFieldByKey3 == null) {
                return rpcCache;
            }
            if (StringUtils.isNotBlank(singleHeaderFieldByKey2) && StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                rpcCache.lastModified = singleHeaderFieldByKey;
                rpcCache.cacheCreateTime = MtopUtils.convertTimeFormatGMT2Long(singleHeaderFieldByKey);
                String[] split = singleHeaderFieldByKey2.split(",");
                if (split != null) {
                    for (String str2 : split) {
                        try {
                            if (str2.contains("max-age=")) {
                                rpcCache.maxAge = Long.parseLong(str2.substring(8));
                            } else if (HttpHeaderConstant.OFFLINE_FLAG_ON.equalsIgnoreCase(str2)) {
                                rpcCache.offline = true;
                            }
                        } catch (Exception unused) {
                            TBSdkLog.w(TAG, str, "[handleResponseCacheFlag] parse cacheControlStr error." + singleHeaderFieldByKey2);
                        }
                    }
                }
            }
            if (StringUtils.isNotBlank(singleHeaderFieldByKey3)) {
                rpcCache.etag = singleHeaderFieldByKey3;
            }
        }
        return rpcCache;
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public String getBlockName(String str) {
        ApiCacheDo apiCacheDoByKey;
        String str2;
        if (StringUtils.isBlank(str) || (apiCacheDoByKey = AppConfigManager.getInstance().getApiCacheDoByKey(str)) == null || (str2 = apiCacheDoByKey.blockName) == null) {
            return "";
        }
        return str2;
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public RpcCache getCache(String str, String str2, String str3) {
        Cache cache2 = this.cache;
        if (cache2 == null) {
            return null;
        }
        RpcCache rpcCache = cache2.get(str, str2);
        return rpcCache != null ? handleCacheValidation(str3, rpcCache) : rpcCache;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (r9.equals(mtopsdk.mtop.cache.domain.ApiCacheDo.CacheKeyType.EXC) == false) goto L_0x003c;
     */
    @Override // mtopsdk.mtop.cache.CacheManager
    public String getCacheKey(MtopContext mtopContext) {
        String str;
        boolean z;
        List<String> list;
        URL url;
        String multiAccountUserId;
        HashMap hashMap;
        if (mtopContext == null) {
            return null;
        }
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        String str2 = mtopContext.baseUrl;
        Map<String, String> map = mtopContext.queryParams;
        if (!(mtopRequest == null || mtopNetworkProp == null || str2 == null || map == null)) {
            ApiCacheDo apiCacheDoByKey = AppConfigManager.getInstance().getApiCacheDoByKey(mtopRequest.getKey());
            char c = 1;
            if (apiCacheDoByKey != null) {
                z = apiCacheDoByKey.privateScope;
                str = apiCacheDoByKey.cacheKeyType;
                list = apiCacheDoByKey.cacheKeyItems;
            } else {
                list = null;
                str = "ALL";
                z = true;
            }
            str.hashCode();
            switch (str.hashCode()) {
                case 64897:
                    if (str.equals("ALL")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 69104:
                    break;
                case 72638:
                    if (str.equals(ApiCacheDo.CacheKeyType.INC)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 2402104:
                    if (str.equals("NONE")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    url = NetworkConverterUtils.initUrl(str2, map);
                    break;
                case 1:
                    if (list == null) {
                        list = mtopNetworkProp.cacheKeyBlackList;
                    }
                    if (list == null) {
                        url = NetworkConverterUtils.initUrl(str2, map);
                        break;
                    } else {
                        if (mtopRequest.dataParams != null) {
                            for (String str3 : list) {
                                mtopRequest.dataParams.remove(str3);
                            }
                        }
                        String convertMapToDataStr = ReflectUtil.convertMapToDataStr(mtopRequest.dataParams);
                        HashMap hashMap2 = new HashMap();
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if ("data".equals(entry.getKey())) {
                                hashMap2.put(entry.getKey(), convertMapToDataStr);
                            } else if (!"wua".equalsIgnoreCase(entry.getKey())) {
                                hashMap2.put(entry.getKey(), entry.getValue());
                            }
                        }
                        url = NetworkConverterUtils.initUrl(str2, hashMap2);
                        break;
                    }
                case 2:
                    if (list == null) {
                        url = NetworkConverterUtils.initUrl(str2, null);
                        break;
                    } else {
                        if (mtopRequest.dataParams != null) {
                            hashMap = new HashMap(mtopRequest.dataParams.size());
                            for (String str4 : list) {
                                hashMap.put(str4, mtopRequest.dataParams.get(str4));
                            }
                        } else {
                            hashMap = null;
                        }
                        url = NetworkConverterUtils.initUrl(str2, hashMap);
                        break;
                    }
                case 3:
                    url = NetworkConverterUtils.initUrl(str2, null);
                    break;
                default:
                    url = NetworkConverterUtils.initUrl(str2, map);
                    break;
            }
            if (url == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder(url.getFile());
                if (z && (multiAccountUserId = mtopContext.mtopInstance.getMultiAccountUserId(mtopNetworkProp.userInfo)) != null) {
                    sb.append(multiAccountUserId);
                }
                String str5 = mtopNetworkProp.ttid;
                if (StringUtils.isNotBlank(str5)) {
                    sb.append(str5);
                }
                return sb.toString();
            } catch (Exception e) {
                TBSdkLog.e(TAG, mtopContext.seqNo, "[getCacheKey] getCacheKey error.", e);
            }
        }
        return null;
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public boolean isNeedReadCache(Request request, MtopListener mtopListener) {
        if (!SwitchConfig.getInstance().isGlobalCacheSwitchOpen()) {
            TBSdkLog.i(TAG, request.seqNo, "[isNeedReadCache]GlobalCacheSwitch=false,Don't read local cache.");
            return false;
        } else if (request != null && "GET".equalsIgnoreCase(request.method)) {
            return !HttpHeaderConstant.NO_CACHE.equalsIgnoreCase(request.header("cache-control"));
        } else {
            return false;
        }
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public boolean isNeedWriteCache(Request request, Map<String, List<String>> map) {
        if (!SwitchConfig.getInstance().isGlobalCacheSwitchOpen()) {
            TBSdkLog.i(TAG, request.seqNo, "[isNeedWriteCache]GlobalCacheSwitch=false,Don't write local cache.");
            return false;
        } else if (!"GET".equalsIgnoreCase(request.method) || map == null) {
            return false;
        } else {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "cache-control");
            if (singleHeaderFieldByKey != null && singleHeaderFieldByKey.contains(HttpHeaderConstant.NO_CACHE)) {
                return false;
            }
            String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "last-modified");
            String singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, HttpHeaderConstant.MTOP_X_ETAG);
            if (singleHeaderFieldByKey3 == null) {
                singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "etag");
            }
            if (singleHeaderFieldByKey == null && singleHeaderFieldByKey2 == null && singleHeaderFieldByKey3 == null) {
                return false;
            }
            return true;
        }
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public boolean putCache(String str, String str2, MtopResponse mtopResponse) {
        if (this.cache == null) {
            return false;
        }
        RpcCache rpcCache = new RpcCache();
        rpcCache.header = mtopResponse.getHeaderFields();
        rpcCache.body = mtopResponse.getBytedata();
        return this.cache.put(str, str2, handleResponseCacheFlag(mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().seqNo : "", rpcCache));
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    @Deprecated
    public String getBlockName(String str, String str2) {
        return getBlockName(StringUtils.concatStr2LowerCase(str, str2));
    }
}
