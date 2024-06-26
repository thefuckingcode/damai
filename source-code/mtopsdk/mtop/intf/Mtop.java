package mtopsdk.mtop.intf;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anetwork.network.cache.Cache;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.init.IMtopInitTask;
import mtopsdk.mtop.global.init.MtopInitTaskFactory;
import mtopsdk.mtop.intf.MtopPrefetch;
import mtopsdk.mtop.network.NetworkPropertyService;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.XState;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class Mtop {
    private static final int MAX_PREFETCH_LENGTH = 50;
    private static final String TAG = "mtopsdk.Mtop";
    protected static final Map<String, Mtop> instanceMap = new ConcurrentHashMap();
    public static boolean mIsFullTrackValid;
    final byte[] initLock = new byte[0];
    final IMtopInitTask initTask;
    volatile String instanceId;
    private volatile boolean isInit = false;
    volatile boolean isInited = false;
    public volatile long lastPrefetchResponseTime = System.currentTimeMillis();
    final MtopConfig mtopConfig;
    private Map<String, MtopBuilder> prefetchBuilderMap = new ConcurrentHashMap();
    private final int type;

    /* access modifiers changed from: package-private */
    /* renamed from: mtopsdk.mtop.intf.Mtop$3  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public interface Id {
        public static final String INNER = "INNER";
        public static final String OPEN = "OPEN";
        public static final String PRODUCT = "PRODUCT";

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: Taobao */
        public @interface Definition {
        }
    }

    /* compiled from: Taobao */
    public interface Type {
        public static final int INNER = 0;
        public static final int OPEN = 1;
        public static final int PRODUCT = 2;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: Taobao */
        public @interface Definition {
        }
    }

    private Mtop(String str, @NonNull MtopConfig mtopConfig2) {
        this.instanceId = str;
        this.mtopConfig = mtopConfig2;
        this.type = 0;
        IMtopInitTask mtopInitTask = MtopInitTaskFactory.getMtopInitTask(str);
        this.initTask = mtopInitTask;
        if (mtopInitTask != null) {
            try {
                Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
                mIsFullTrackValid = true;
            } catch (Throwable unused) {
                mIsFullTrackValid = false;
            }
        } else {
            throw new RuntimeException("IMtopInitTask is null,instanceId=" + str);
        }
    }

    @Nullable
    public static Mtop getInstance(String str) {
        return getMtopInstance(str);
    }

    public static Mtop getMtopInstance(String str) {
        if (!StringUtils.isNotBlank(str)) {
            str = Id.INNER;
        }
        return instanceMap.get(str);
    }

    private synchronized void init(Context context, String str) {
        if (!this.isInit) {
            if (context == null) {
                TBSdkLog.e(TAG, this.instanceId + " [init] The Parameter context can not be null.");
                return;
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, this.instanceId + " [init] context=" + context + ", ttid=" + str);
            }
            this.mtopConfig.context = context.getApplicationContext();
            if (StringUtils.isNotBlank(str)) {
                this.mtopConfig.ttid = str;
            }
            MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
                /* class mtopsdk.mtop.intf.Mtop.AnonymousClass1 */

                public void run() {
                    try {
                        synchronized (Mtop.this.initLock) {
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                Mtop.this.updateAppKeyIndex();
                                Mtop mtop = Mtop.this;
                                mtop.initTask.executeCoreTask(mtop.mtopConfig);
                                MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
                                    /* class mtopsdk.mtop.intf.Mtop.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        try {
                                            Mtop mtop = Mtop.this;
                                            mtop.initTask.executeExtraTask(mtop.mtopConfig);
                                        } catch (Throwable th) {
                                            TBSdkLog.e(Mtop.TAG, Mtop.this.instanceId + " [init] executeExtraTask error.", th);
                                        }
                                    }
                                });
                            } finally {
                                String str = Mtop.TAG;
                                TBSdkLog.i(str, Mtop.this.instanceId + " [init]do executeCoreTask cost[ms]: " + (System.currentTimeMillis() - currentTimeMillis));
                                Mtop.this.isInited = true;
                                Mtop.this.initLock.notifyAll();
                            }
                        }
                    } catch (Exception e) {
                        TBSdkLog.e(Mtop.TAG, Mtop.this.instanceId + " [init] executeCoreTask error.", e);
                    }
                }
            });
            this.isInit = true;
        }
    }

    @Deprecated
    public static Mtop instance(Context context) {
        return instance(null, context, null);
    }

    @Deprecated
    public static void setAppKeyIndex(int i, int i2) {
        MtopSetting.setAppKeyIndex(i, i2);
    }

    @Deprecated
    public static void setAppVersion(String str) {
        MtopSetting.setAppVersion(str);
    }

    @Deprecated
    public static void setMtopDomain(String str, String str2, String str3) {
        MtopSetting.setMtopDomain(str, str2, str3);
    }

    @Deprecated
    public static void setSecurityAppKey(String str) {
        MtopSetting.setSecurityAppKey(str);
    }

    public void addPrefetchBuilderToMap(@NonNull MtopBuilder mtopBuilder, String str) {
        if (this.prefetchBuilderMap.size() >= 50) {
            MtopPrefetch.cleanPrefetchCache(mtopBuilder.mtopInstance);
        }
        if (this.prefetchBuilderMap.size() >= 50) {
            MtopPrefetch.onPrefetchAndCommit(MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_FULL, mtopBuilder.getMtopPrefetch(), mtopBuilder.getMtopContext(), null);
        }
        this.prefetchBuilderMap.put(str, mtopBuilder);
    }

    public MtopBuilder build(IMTOPDataObject iMTOPDataObject, String str) {
        return new MtopBuilder(this, iMTOPDataObject, str);
    }

    public boolean checkMtopSDKInit() {
        if (this.isInited) {
            return this.isInited;
        }
        synchronized (this.initLock) {
            try {
                if (!this.isInited) {
                    this.initLock.wait(DateUtils.MILLIS_PER_MINUTE);
                    if (!this.isInited) {
                        TBSdkLog.e(TAG, this.instanceId + " [checkMtopSDKInit]Didn't call Mtop.instance(...),please execute global init.");
                    }
                }
            } catch (Exception e) {
                TBSdkLog.e(TAG, this.instanceId + " [checkMtopSDKInit] wait Mtop initLock failed---" + e.toString());
            }
        }
        return this.isInited;
    }

    public String getDeviceId() {
        return XState.getValue(this.instanceId, "deviceId");
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public MtopConfig getMtopConfig() {
        return this.mtopConfig;
    }

    public String getMultiAccountSid(String str) {
        String str2 = this.instanceId;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return XState.getValue(StringUtils.concatStr(str2, str), "sid");
    }

    public String getMultiAccountUserId(String str) {
        String str2 = this.instanceId;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return XState.getValue(StringUtils.concatStr(str2, str), "uid");
    }

    public Map<String, MtopBuilder> getPrefetchBuilderMap() {
        return this.prefetchBuilderMap;
    }

    @Deprecated
    public String getSid() {
        return getMultiAccountSid(null);
    }

    public String getTtid() {
        return XState.getValue(this.instanceId, "ttid");
    }

    public int getType() {
        return this.type;
    }

    @Deprecated
    public String getUserId() {
        return getMultiAccountUserId(null);
    }

    public String getUtdid() {
        return XState.getValue("utdid");
    }

    public boolean isInited() {
        return this.isInited;
    }

    public Mtop logSwitch(boolean z) {
        TBSdkLog.setPrintLog(z);
        return this;
    }

    public Mtop logout() {
        return logoutMultiAccountSession(null);
    }

    public Mtop logoutMultiAccountSession(@Nullable String str) {
        String str2 = this.instanceId;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        String concatStr = StringUtils.concatStr(str2, str);
        XState.removeKey(concatStr, "sid");
        XState.removeKey(concatStr, "uid");
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(concatStr);
            sb.append(" [logout] remove sessionInfo succeed.");
            TBSdkLog.i(TAG, sb.toString());
        }
        NetworkPropertyService networkPropertyService = this.mtopConfig.networkPropertyService;
        if (networkPropertyService != null) {
            networkPropertyService.setUserId(null);
        }
        return this;
    }

    public Mtop registerDeviceId(String str) {
        if (str != null) {
            this.mtopConfig.deviceId = str;
            XState.setValue(this.instanceId, "deviceId", str);
        }
        return this;
    }

    public Mtop registerMultiAccountSession(@Nullable String str, String str2, String str3) {
        String str4 = this.instanceId;
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        String concatStr = StringUtils.concatStr(str4, str);
        XState.setValue(concatStr, "sid", str2);
        XState.setValue(concatStr, "uid", str3);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(concatStr);
            sb.append(" [registerSessionInfo]register sessionInfo succeed: sid=");
            sb.append(str2);
            sb.append(",uid=");
            sb.append(str3);
            TBSdkLog.i(TAG, sb.toString());
        }
        NetworkPropertyService networkPropertyService = this.mtopConfig.networkPropertyService;
        if (networkPropertyService != null) {
            networkPropertyService.setUserId(str3);
        }
        return this;
    }

    @Deprecated
    public Mtop registerSessionInfo(String str, @Deprecated String str2, String str3) {
        return registerMultiAccountSession(null, str, str3);
    }

    public Mtop registerTtid(String str) {
        if (str != null) {
            this.mtopConfig.ttid = str;
            XState.setValue(this.instanceId, "ttid", str);
            NetworkPropertyService networkPropertyService = this.mtopConfig.networkPropertyService;
            if (networkPropertyService != null) {
                networkPropertyService.setTtid(str);
            }
        }
        return this;
    }

    public Mtop registerUtdid(String str) {
        if (str != null) {
            this.mtopConfig.utdid = str;
            XState.setValue("utdid", str);
        }
        return this;
    }

    public boolean removeCacheBlock(String str) {
        Cache cache = this.mtopConfig.cacheImpl;
        return cache != null && cache.remove(str);
    }

    public boolean removeCacheItem(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            TBSdkLog.e(TAG, "[removeCacheItem] remove CacheItem failed,invalid cacheKey=" + str2);
            return false;
        }
        Cache cache = this.mtopConfig.cacheImpl;
        if (cache == null || !cache.remove(str, str2)) {
            return false;
        }
        return true;
    }

    public Mtop setCoordinates(String str, String str2) {
        XState.setValue("lng", str);
        XState.setValue("lat", str2);
        return this;
    }

    public Mtop switchEnvMode(final EnvModeEnum envModeEnum) {
        if (envModeEnum != null) {
            MtopConfig mtopConfig2 = this.mtopConfig;
            if (mtopConfig2.envMode != envModeEnum) {
                if (MtopUtils.isApkDebug(mtopConfig2.context) || this.mtopConfig.isAllowSwitchEnv.compareAndSet(true, false)) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i(TAG, this.instanceId + " [switchEnvMode]MtopSDK switchEnvMode called.envMode=" + envModeEnum);
                    }
                    MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
                        /* class mtopsdk.mtop.intf.Mtop.AnonymousClass2 */

                        public void run() {
                            Mtop.this.checkMtopSDKInit();
                            if (Mtop.this.mtopConfig.envMode == envModeEnum) {
                                TBSdkLog.i(Mtop.TAG, Mtop.this.instanceId + " [switchEnvMode] Current EnvMode matches target EnvMode,envMode=" + envModeEnum);
                                return;
                            }
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.i(Mtop.TAG, Mtop.this.instanceId + " [switchEnvMode]MtopSDK switchEnvMode start");
                            }
                            Mtop mtop = Mtop.this;
                            mtop.mtopConfig.envMode = envModeEnum;
                            try {
                                mtop.updateAppKeyIndex();
                                if (EnvModeEnum.ONLINE == envModeEnum) {
                                    TBSdkLog.setPrintLog(false);
                                }
                                Mtop mtop2 = Mtop.this;
                                mtop2.initTask.executeCoreTask(mtop2.mtopConfig);
                                Mtop mtop3 = Mtop.this;
                                mtop3.initTask.executeExtraTask(mtop3.mtopConfig);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.i(Mtop.TAG, Mtop.this.instanceId + " [switchEnvMode]MtopSDK switchEnvMode end. envMode =" + envModeEnum);
                            }
                        }
                    });
                } else {
                    TBSdkLog.e(TAG, this.instanceId + " [switchEnvMode]release package can switch environment only once!");
                    return this;
                }
            }
        }
        return this;
    }

    public void unInit() {
        this.isInited = false;
        this.isInit = false;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, this.instanceId + "[unInit] MTOPSDK unInit called");
        }
    }

    public boolean unintallCacheBlock(String str) {
        Cache cache = this.mtopConfig.cacheImpl;
        return cache != null && cache.uninstall(str);
    }

    /* access modifiers changed from: package-private */
    public void updateAppKeyIndex() {
        EnvModeEnum envModeEnum = this.mtopConfig.envMode;
        if (envModeEnum != null) {
            int i = AnonymousClass3.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
            if (i == 1 || i == 2) {
                MtopConfig mtopConfig2 = this.mtopConfig;
                mtopConfig2.appKeyIndex = mtopConfig2.onlineAppKeyIndex;
            } else if (i == 3 || i == 4) {
                MtopConfig mtopConfig3 = this.mtopConfig;
                mtopConfig3.appKeyIndex = mtopConfig3.dailyAppkeyIndex;
            }
        }
    }

    @Deprecated
    public static Mtop instance(Context context, String str) {
        return instance(null, context, str);
    }

    public MtopBuilder build(MtopRequest mtopRequest, String str) {
        return new MtopBuilder(this, mtopRequest, str);
    }

    public Mtop registerSessionInfo(String str, String str2) {
        return registerMultiAccountSession(null, str, str2);
    }

    public static Mtop instance(String str, @NonNull Context context) {
        return instance(str, context, null);
    }

    @Deprecated
    public MtopBuilder build(Object obj, String str) {
        return new MtopBuilder(this, obj, str);
    }

    public static Mtop instance(String str, @NonNull Context context, String str2) {
        if (!StringUtils.isNotBlank(str)) {
            str = Id.INNER;
        }
        Map<String, Mtop> map = instanceMap;
        Mtop mtop = map.get(str);
        if (mtop == null) {
            synchronized (Mtop.class) {
                mtop = map.get(str);
                if (mtop == null) {
                    MtopConfig mtopConfig2 = MtopSetting.mtopConfigMap.get(str);
                    if (mtopConfig2 == null) {
                        mtopConfig2 = new MtopConfig(str);
                    }
                    Mtop mtop2 = new Mtop(str, mtopConfig2);
                    mtopConfig2.mtopInstance = mtop2;
                    map.put(str, mtop2);
                    mtop = mtop2;
                }
            }
        }
        if (!mtop.isInit) {
            mtop.init(context, str2);
        }
        return mtop;
    }

    public static Mtop instance(String str, @NonNull Context context, String str2, int i) {
        new MtopConfig(str).envMode = EnvModeEnum.PREPARE;
        return instance(str, context, str2, i, null);
    }

    public static Mtop instance(String str, @NonNull Context context, String str2, int i, MtopConfig mtopConfig2) {
        if (!StringUtils.isNotBlank(str)) {
            str = Id.INNER;
        }
        Map<String, Mtop> map = instanceMap;
        Mtop mtop = map.get(str);
        if (mtop == null) {
            synchronized (Mtop.class) {
                mtop = map.get(str);
                if (mtop == null) {
                    MtopConfig mtopConfig3 = MtopSetting.mtopConfigMap.get(str);
                    if (mtopConfig3 != null) {
                        mtopConfig2 = mtopConfig3;
                    } else if (mtopConfig2 == null) {
                        mtopConfig2 = new MtopConfig(str);
                    }
                    mtop = new Mtop(str, mtopConfig2);
                    mtopConfig2.mtopInstance = mtop;
                    map.put(str, mtop);
                }
            }
        }
        if (!mtop.isInit) {
            mtop.init(context, str2);
        }
        return mtop;
    }
}
