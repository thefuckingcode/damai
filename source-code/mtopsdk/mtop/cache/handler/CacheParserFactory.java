package mtopsdk.mtop.cache.handler;

import anetwork.network.cache.RpcCache;

/* compiled from: Taobao */
public class CacheParserFactory {

    /* access modifiers changed from: package-private */
    /* renamed from: mtopsdk.mtop.cache.handler.CacheParserFactory$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$anetwork$network$cache$RpcCache$CacheStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[RpcCache.CacheStatus.values().length];
            $SwitchMap$anetwork$network$cache$RpcCache$CacheStatus = iArr;
            iArr[RpcCache.CacheStatus.FRESH.ordinal()] = 1;
            $SwitchMap$anetwork$network$cache$RpcCache$CacheStatus[RpcCache.CacheStatus.NEED_UPDATE.ordinal()] = 2;
        }
    }

    public static ICacheParser createCacheParser(RpcCache.CacheStatus cacheStatus) {
        if (cacheStatus == null) {
            return new EmptyCacheParser();
        }
        int i = AnonymousClass1.$SwitchMap$anetwork$network$cache$RpcCache$CacheStatus[cacheStatus.ordinal()];
        if (i == 1) {
            return new FreshCacheParser();
        }
        if (i != 2) {
            return new EmptyCacheParser();
        }
        return new ExpiredCacheParser();
    }
}
