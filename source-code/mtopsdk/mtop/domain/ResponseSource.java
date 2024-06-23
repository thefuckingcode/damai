package mtopsdk.mtop.domain;

import androidx.annotation.NonNull;
import anetwork.network.cache.RpcCache;
import java.io.Serializable;
import mtopsdk.common.util.StringUtils;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.cache.CacheManager;

/* compiled from: Taobao */
public class ResponseSource implements Serializable {
    private String cacheBlock;
    private String cacheKey;
    public CacheManager cacheManager;
    public MtopResponse cacheResponse;
    public MtopContext mtopContext;
    public boolean requireConnection = true;
    public RpcCache rpcCache = null;
    public String seqNo;

    public ResponseSource(@NonNull MtopContext mtopContext2, @NonNull CacheManager cacheManager2) {
        this.mtopContext = mtopContext2;
        this.cacheManager = cacheManager2;
        this.seqNo = mtopContext2.seqNo;
    }

    public String getCacheBlock() {
        if (StringUtils.isNotBlank(this.cacheBlock)) {
            return this.cacheBlock;
        }
        String blockName = this.cacheManager.getBlockName(this.mtopContext.mtopRequest.getKey());
        this.cacheBlock = blockName;
        return blockName;
    }

    public String getCacheKey() {
        if (StringUtils.isNotBlank(this.cacheKey)) {
            return this.cacheKey;
        }
        String cacheKey2 = this.cacheManager.getCacheKey(this.mtopContext);
        this.cacheKey = cacheKey2;
        return cacheKey2;
    }
}
