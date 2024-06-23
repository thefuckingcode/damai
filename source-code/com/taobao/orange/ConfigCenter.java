package com.taobao.orange;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.RemoteException;
import android.taobao.windvane.connect.api.ApiConstants;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.ta.utdid2.device.UTDevice;
import com.taobao.orange.OConstant;
import com.taobao.orange.accssupport.OrangeAccsService;
import com.taobao.orange.aidl.OrangeConfigListenerStub;
import com.taobao.orange.aidl.ParcelableConfigListener;
import com.taobao.orange.cache.ConfigCache;
import com.taobao.orange.cache.IndexCache;
import com.taobao.orange.candidate.MultiAnalyze;
import com.taobao.orange.inner.OInitListener;
import com.taobao.orange.model.CandidateDO;
import com.taobao.orange.model.ConfigAckDO;
import com.taobao.orange.model.ConfigDO;
import com.taobao.orange.model.CustomConfigDO;
import com.taobao.orange.model.IndexAckDO;
import com.taobao.orange.model.IndexDO;
import com.taobao.orange.model.NameSpaceDO;
import com.taobao.orange.receiver.OrangeReceiver;
import com.taobao.orange.sync.BaseAuthRequest;
import com.taobao.orange.sync.BaseCdnRequest;
import com.taobao.orange.sync.BaseRequest;
import com.taobao.orange.sync.IndexUpdateHandler;
import com.taobao.orange.sync.NetworkInterceptor;
import com.taobao.orange.util.FileUtil;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeMonitor;
import com.taobao.orange.util.OrangeMonitorData;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.orange.util.ReportAckUtils;
import com.taobao.orange.util.SPUtil;
import com.taobao.orange.util.StringUtil;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.Constants;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import tb.e21;
import tb.ke1;

/* compiled from: Taobao */
public class ConfigCenter {
    static final int BASE_ACKDELAY_INTERVAL = 10;
    public static final int DEFAULT_BIND_TIMEOUT = 3;
    private static final long FAIL_LOAD_INDEX_UPD_INTERVAL = 180000;
    private static final long FAIL_LOAD_INDEX_UPD_NUM = 10;
    private static final long MAX_LISTENER_NUM = 10;
    private static final String NULL_VALUE = "null";
    static final String TAG = "ConfigCenter";
    private static volatile long failLastIndexUpdTime;
    static ConfigCenter mInstance = new ConfigCenter();
    private boolean channelIndexUpdate = false;
    Set<String> failCandidateSet = new HashSet();
    public AtomicBoolean isAfterIdle = new AtomicBoolean(false);
    ConfigCache mConfigCache = new ConfigCache();
    final ConcurrentLinkedQueue<NameSpaceDO> mConfigWaitingNetworkQueue = new ConcurrentLinkedQueue<>();
    private Map<String, Long> mDowngradeConfigMap = new ConcurrentHashMap();
    final Set<String> mFailRequestsSet = new HashSet();
    final Set<ParcelableConfigListener> mGlobalListeners = Collections.synchronizedSet(new HashSet());
    IndexCache mIndexCache = new IndexCache();
    volatile OInitListener mInitListener = null;
    volatile boolean mIsFirstInstall = false;
    public AtomicBoolean mIsOrangeInit = new AtomicBoolean(false);
    final Map<String, Set<ParcelableConfigListener>> mListeners = new HashMap();
    final Map<String, Long> mLoadingConfigMap = new ConcurrentHashMap();
    private AtomicInteger mRequestCount = new AtomicInteger(0);

    private ConfigCenter() {
    }

    private void addFail(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mFailRequestsSet) {
                if (this.mFailRequestsSet.add(str) && OLog.isPrintLog(2)) {
                    OLog.i(TAG, "addFail", "namespace", str);
                }
            }
        }
    }

    private boolean checkLoading(String str, boolean z) {
        if (this.mLoadingConfigMap.get(str) != null) {
            OLog.d(TAG, Constants.CONFIG, str, "is loading");
            return true;
        }
        if (z) {
            this.mLoadingConfigMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return false;
    }

    private <T> T getConfigObj(String str) {
        if (TextUtils.isEmpty(str)) {
            OLog.e(TAG, "getConfigObj error, namespace is empty", new Object[0]);
            return null;
        } else if ("orange".equals(str) || IndexCache.INDEX_STORE_NAME.equals(str)) {
            OLog.e(TAG, "getConfigObj error, namespace is occupied by sdk", new Object[0]);
            return null;
        } else {
            T t = (T) this.mConfigCache.getConfigObj(str);
            if (t == null) {
                if (OLog.isPrintLog(0)) {
                    OLog.v(TAG, "getConfigObj", "namespace", str, "...null");
                }
                final NameSpaceDO nameSpace = this.mIndexCache.getNameSpace(str);
                if (nameSpace == null || !this.mIsOrangeInit.get()) {
                    addFail(str);
                } else if (!checkLoading(str, false)) {
                    OThreadFactory.execute(new Runnable() {
                        /* class com.taobao.orange.ConfigCenter.AnonymousClass2 */

                        public void run() {
                            if (OLog.isPrintLog(0)) {
                                OLog.d(ConfigCenter.TAG, "getConfigObj force to load", "namespace", nameSpace.name);
                            }
                            ConfigCenter.this.loadConfigLazy(nameSpace);
                        }
                    });
                }
            }
            return t;
        }
    }

    public static ConfigCenter getInstance() {
        return mInstance;
    }

    private boolean loadIndex(final IndexUpdateHandler.IndexUpdateInfo indexUpdateInfo) {
        double d;
        String str;
        int i;
        if (indexUpdateInfo == null || !indexUpdateInfo.checkValid()) {
            OLog.e(TAG, "updateIndex param is null", new Object[0]);
            return false;
        } else if (TextUtils.isEmpty(this.mIndexCache.getIndex().md5) || !this.mIndexCache.getIndex().md5.equals(indexUpdateInfo.md5)) {
            if (((long) GlobalOrange.indexContinueFailsNum.get()) >= 10) {
                long currentTimeMillis = System.currentTimeMillis();
                if (failLastIndexUpdTime == 0) {
                    failLastIndexUpdTime = currentTimeMillis;
                    if (OLog.isPrintLog(3)) {
                        OLog.w(TAG, "updateIndex continuous fail numbers exceed 10", new Object[0]);
                    }
                    return false;
                } else if (currentTimeMillis - failLastIndexUpdTime <= FAIL_LOAD_INDEX_UPD_INTERVAL) {
                    return false;
                } else {
                    GlobalOrange.indexContinueFailsNum.set(0);
                    failLastIndexUpdTime = 0;
                    if (OLog.isPrintLog(3)) {
                        OLog.w(TAG, "updateIndex continuous fail already wait 100s", new Object[0]);
                    }
                }
            }
            GlobalOrange.indexContinueFailsNum.incrementAndGet();
            if (OLog.isPrintLog(2)) {
                OLog.i(TAG, "loadIndex start", ConnType.PK_CDN, indexUpdateInfo.cdn, "resource", indexUpdateInfo.resourceId, "md5", indexUpdateInfo.md5);
            }
            try {
                BaseRequest r1 = new BaseCdnRequest<IndexDO>(GlobalOrange.schema + ke1.SCHEME_SLASH + indexUpdateInfo.cdn + File.separator + indexUpdateInfo.resourceId, indexUpdateInfo.md5) {
                    /* class com.taobao.orange.ConfigCenter.AnonymousClass7 */

                    /* access modifiers changed from: protected */
                    @Override // com.taobao.orange.sync.BaseCdnRequest
                    public IndexDO parseResContent(String str) {
                        return (IndexDO) JSON.parseObject(str, IndexDO.class);
                    }
                };
                IndexDO indexDO = (IndexDO) r1.syncRequest();
                if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                    this.mRequestCount.incrementAndGet();
                }
                if (GlobalOrange.fallbackAvoid) {
                    str = OConstant.MONITOR_PRIVATE_MODULE;
                    d = 1.0d;
                    OrangeMonitor.commitCount(str, OConstant.POINT_FALLBACK_AVOID, indexUpdateInfo.resourceId, 1.0d);
                } else if (indexDO == null || !indexDO.checkValid()) {
                    if (OLog.isPrintLog(0)) {
                        OLog.v(TAG, "loadIndex cdnReq fail downgrade to authReq", "code", r1.getCode(), "msg", r1.getMessage());
                    }
                    String str2 = indexUpdateInfo.md5;
                    d = 1.0d;
                    str = OConstant.MONITOR_PRIVATE_MODULE;
                    BaseRequest r0 = new BaseAuthRequest<IndexDO>(str2, false, OConstant.REQTYPE_DOWNLOAD_RESOURCE) {
                        /* class com.taobao.orange.ConfigCenter.AnonymousClass8 */

                        /* access modifiers changed from: protected */
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        public Map<String, String> getReqParams() {
                            HashMap hashMap = new HashMap();
                            hashMap.put("resourceId", indexUpdateInfo.resourceId);
                            return hashMap;
                        }

                        /* access modifiers changed from: protected */
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        public String getReqPostBody() {
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        public IndexDO parseResContent(String str) {
                            return (IndexDO) JSON.parseObject(str, IndexDO.class);
                        }
                    };
                    r1 = r0;
                    indexDO = (IndexDO) r0.syncRequest();
                } else {
                    str = OConstant.MONITOR_PRIVATE_MODULE;
                    d = 1.0d;
                }
                if (indexDO == null || !indexDO.checkValid()) {
                    if (!"-200".equals(r1.getCode())) {
                        if (indexDO != null && !indexDO.checkValid()) {
                            r1.setCode(-5);
                            r1.setMessage("index is invaild");
                        }
                        OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_INDEX_RATE, indexUpdateInfo.resourceId, r1.getCode(), r1.getMessage());
                    }
                    OLog.e(TAG, "loadIndex fail", "code", r1.getCode(), "msg", r1.getMessage());
                    return false;
                }
                GlobalOrange.indexContinueFailsNum.set(0);
                if (indexDO.id.equals(this.mIndexCache.getIndex().id) || indexDO.version.equals(this.mIndexCache.getIndex().version)) {
                    OLog.w(TAG, "loadIndex fail", "id or version is match");
                    return false;
                }
                indexDO.md5 = indexUpdateInfo.md5;
                List<String> cache = this.mIndexCache.cache(indexDO);
                OrangeMonitor.commitSuccess(OConstant.MONITOR_MODULE, OConstant.POINT_INDEX_RATE, indexUpdateInfo.resourceId);
                OrangeMonitor.commitIndexUpdateMonitor(indexDO.appIndexVersion, indexDO.baseVersion, GlobalOrange.indexResponseHeader);
                if (OLog.isPrintLog(1)) {
                    i = 2;
                    OLog.d(TAG, "loadIndex success", "indexDO", OrangeUtils.formatIndexDO(indexDO));
                } else {
                    i = 2;
                }
                try {
                    ReportAckUtils.reportIndexAck(new IndexAckDO(indexDO.id, OrangeUtils.getCurFormatTime(), indexUpdateInfo.md5));
                } catch (Exception e) {
                    OLog.w(TAG, "loadIndex", e, new Object[0]);
                }
                if (cache.size() <= 0) {
                    return true;
                }
                if (OLog.isPrintLog(i)) {
                    Object[] objArr = new Object[i];
                    objArr[0] = "removeNamespaces";
                    objArr[1] = cache;
                    OLog.i(TAG, "loadIndex remove diff namespace", objArr);
                }
                for (String str3 : cache) {
                    OrangeMonitor.commitCount(str, OConstant.POINT_CONFIG_REMOVE_COUNTS, str3, d);
                    this.mConfigCache.remove(str3);
                }
                return true;
            } catch (Throwable th) {
                OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_INDEX_RATE, indexUpdateInfo.resourceId, "0", th.getMessage());
                OLog.e(TAG, "loadIndex fail", th, new Object[0]);
                return false;
            }
        } else {
            OLog.w(TAG, "loadIndex fail", "cdnMd5 is match");
            return false;
        }
    }

    private void removeLoading(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mLoadingConfigMap.remove(str);
        }
    }

    private void reportNullValue(String str, String str2, String str3) {
        ConfigDO configDO;
        try {
            if (TextUtils.equals(NULL_VALUE, str3) && (configDO = this.mConfigCache.getConfigMap().get(str)) != null) {
                OrangeMonitor.commitConfigMonitor(OConstant.POINT_CONFIG_USE_DETAIL, str, configDO.version, configDO.getChangeVersion(), str2);
            }
        } catch (Throwable th) {
            OLog.e(TAG, "reportNullValue " + th.getMessage(), new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateLocalEnvironment() {
        if (((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue() > 0) {
            String str = (String) SPUtil.getFromSharePreference(GlobalOrange.context, "osVersion", "");
            if (!TextUtils.equals((String) SPUtil.getFromSharePreference(GlobalOrange.context, "appVersion", ""), GlobalOrange.appVersion)) {
                SPUtil.saveToSharePreference(GlobalOrange.context, "appVersion", GlobalOrange.appVersion);
            }
            int i = Build.VERSION.SDK_INT;
            if (!TextUtils.equals(str, String.valueOf(i))) {
                SPUtil.saveToSharePreference(GlobalOrange.context, "osVersion", String.valueOf(i));
            }
        }
    }

    public void addFails(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (this.mFailRequestsSet) {
                if (this.mFailRequestsSet.addAll(arrayList) && OLog.isPrintLog(2)) {
                    OLog.i(TAG, "addFails", "namespaces", arrayList);
                }
            }
        }
    }

    public boolean addGlobalListener(OConfigListener oConfigListener) {
        if (oConfigListener != null) {
            return this.mGlobalListeners.add(new OrangeConfigListenerStub(oConfigListener));
        }
        return false;
    }

    public void delayLoadConfig() {
        OLog.d(TAG, "delayLoadConfig", new Object[0]);
        if (!this.mIsOrangeInit.get()) {
            this.isAfterIdle.compareAndSet(false, true);
            OLog.w(TAG, "delayLoadConfig fail as not finish orange init", new Object[0]);
        } else if (this.isAfterIdle.compareAndSet(false, true)) {
            OrangeMonitorData orangeMonitorData = new OrangeMonitorData();
            orangeMonitorData.performance.bootType = this.mIsFirstInstall;
            orangeMonitorData.performance.downgradeType = GlobalOrange.downgrade;
            OrangeMonitorData.PerformanceStat performanceStat = orangeMonitorData.performance;
            performanceStat.monitorType = 0;
            performanceStat.requestCount = this.mRequestCount.get();
            orangeMonitorData.performance.persistCount = FileUtil.persistCount.get();
            orangeMonitorData.performance.restoreCount = FileUtil.restoreCount.get();
            orangeMonitorData.performance.persistTime = FileUtil.persistTime.get();
            orangeMonitorData.performance.restoreTime = FileUtil.restoreTime.get();
            orangeMonitorData.performance.ioTime = FileUtil.ioTime.get();
            if (getConfigWaitingNetworkQueue() != null) {
                OThreadFactory.execute(new Runnable() {
                    /* class com.taobao.orange.ConfigCenter.AnonymousClass10 */

                    public void run() {
                        HashSet<NameSpaceDO> hashSet = new HashSet();
                        while (!ConfigCenter.this.getConfigWaitingNetworkQueue().isEmpty()) {
                            NameSpaceDO poll = ConfigCenter.this.getConfigWaitingNetworkQueue().poll();
                            if (poll != null) {
                                hashSet.add(poll);
                            }
                        }
                        for (NameSpaceDO nameSpaceDO : hashSet) {
                            if (nameSpaceDO != null) {
                                if (OLog.isPrintLog(0)) {
                                    OLog.d(ConfigCenter.TAG, "idle load config", "namespace", nameSpaceDO.name);
                                }
                                ConfigCenter.this.loadConfig(nameSpaceDO);
                            }
                        }
                    }
                });
            }
            for (String str : getConfigCache().getConfigMap().keySet()) {
                final ConfigDO configDO = getConfigCache().getConfigMap().get(str);
                if (configDO != null && !configDO.persisted) {
                    OThreadFactory.executeDisk(new Runnable() {
                        /* class com.taobao.orange.ConfigCenter.AnonymousClass11 */

                        public void run() {
                            if (OLog.isPrintLog(0)) {
                                OLog.d(ConfigCenter.TAG, "idle persist config", "namespace", configDO.name);
                            }
                            ConfigDO configDO = configDO;
                            configDO.persisted = true;
                            FileUtil.persistObject(configDO, configDO.name);
                        }
                    });
                }
            }
            OrangeMonitor.commitBootPerformanceInfo(orangeMonitorData);
        }
    }

    public void forceCheckUpdate() {
        if (!this.mIsOrangeInit.get()) {
            OLog.w(TAG, "forceCheckUpdate fail as not finish orange init", new Object[0]);
        } else if (GlobalOrange.indexUpdMode != OConstant.UPDMODE.O_XMD) {
            OLog.i(TAG, "forceCheckUpdate start", new Object[0]);
            IndexUpdateHandler.checkIndexUpdate(this.mIndexCache.getAppIndexVersion(), this.mIndexCache.getVersionIndexVersion());
        } else {
            OLog.w(TAG, "forceCheckUpdate fail as not allow in O_XMD mode", new Object[0]);
        }
    }

    public JSONObject getAllConfigs() {
        try {
            return new JSONObject(JSON.toJSONString(OrangeUtils.sortMapByKey(this.mConfigCache.getConfigMap(), true)));
        } catch (Exception e) {
            OLog.e(TAG, "getAllConfigs", e, new Object[0]);
            return null;
        }
    }

    public String getConfig(String str, String str2, String str3) {
        String str4;
        Map<String, String> configs = getConfigs(str);
        if (configs == null || (str4 = configs.get(str2)) == null) {
            reportNullValue(str, str2, str3);
            return str3;
        }
        reportNullValue(str, str2, str4);
        return str4;
    }

    public ConfigCache getConfigCache() {
        return this.mConfigCache;
    }

    public ConcurrentLinkedQueue<NameSpaceDO> getConfigWaitingNetworkQueue() {
        return this.mConfigWaitingNetworkQueue;
    }

    public Map<String, String> getConfigs(String str) {
        try {
            return (Map) getConfigObj(str);
        } catch (Throwable th) {
            OLog.w(TAG, "getConfigs error", th, "namespace", str);
            return null;
        }
    }

    public String getCustomConfig(String str, String str2) {
        try {
            String str3 = (String) getConfigObj(str);
            return str3 == null ? str2 : str3;
        } catch (Throwable th) {
            OLog.w(TAG, "getCustomConfig error", th, "namespace", str);
            return str2;
        }
    }

    public JSONObject getIndex() {
        try {
            IndexDO indexDO = new IndexDO(this.mIndexCache.getIndex());
            Collections.sort(indexDO.mergedNamespaces, new Comparator<NameSpaceDO>() {
                /* class com.taobao.orange.ConfigCenter.AnonymousClass12 */

                public int compare(NameSpaceDO nameSpaceDO, NameSpaceDO nameSpaceDO2) {
                    return nameSpaceDO.name.compareTo(nameSpaceDO2.name);
                }
            });
            return new JSONObject(JSON.toJSONString(indexDO));
        } catch (Exception e) {
            OLog.e(TAG, "getIndex", e, new Object[0]);
            return null;
        }
    }

    public JSONObject getIndexAndConfigs() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("index", getIndex());
            hashMap.put(Constants.CONFIG, getAllConfigs());
            return new JSONObject(hashMap);
        } catch (Exception e) {
            OLog.e(TAG, "getIndexAndConfigs", e, new Object[0]);
            return null;
        }
    }

    public void init(final Context context, final OConfig oConfig) {
        if (context == null || TextUtils.isEmpty(oConfig.appKey) || TextUtils.isEmpty(oConfig.appVersion)) {
            OLog.e(TAG, "init start", "input param error");
            return;
        }
        OThreadFactory.execute(new Runnable() {
            /* class com.taobao.orange.ConfigCenter.AnonymousClass1 */

            public void run() {
                synchronized (ConfigCenter.this) {
                    if (!ConfigCenter.this.mIsOrangeInit.get()) {
                        GlobalOrange.deviceId = UTDevice.getUtdid(context);
                        if (OLog.isPrintLog(2)) {
                            SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(OConfig.class, new String[0]);
                            simplePropertyPreFilter.getExcludes().add(ApiConstants.APPSECRET);
                            OLog.i(ConfigCenter.TAG, "init start", "sdkVersion", "1.6.5.2", "utdid", GlobalOrange.deviceId, Constants.CONFIG, JSON.toJSONString(oConfig, simplePropertyPreFilter, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.SortField));
                        }
                        GlobalOrange.context = context.getApplicationContext();
                        OConfig oConfig = oConfig;
                        GlobalOrange.appKey = oConfig.appKey;
                        GlobalOrange.appVersion = oConfig.appVersion;
                        GlobalOrange.userId = oConfig.userId;
                        GlobalOrange.appSecret = oConfig.appSecret;
                        GlobalOrange.authCode = oConfig.authCode;
                        GlobalOrange.reportUpdateAck = oConfig.reportAck;
                        OConfig oConfig2 = oConfig;
                        GlobalOrange.statUsedConfig = oConfig2.statUsedConfig;
                        GlobalOrange.indexUpdMode = OConstant.UPDMODE.valueOf(oConfig2.indexUpdateMode);
                        GlobalOrange.env = OConstant.ENV.valueOf(oConfig.env);
                        GlobalOrange.randomDelayAckInterval = ConfigCenter.this.updateRandomDelayAckInterval(10);
                        GlobalOrange.probeHosts.addAll(Arrays.asList(oConfig.probeHosts));
                        OConfig oConfig3 = oConfig;
                        GlobalOrange.dcHost = oConfig3.dcHost;
                        String[] strArr = oConfig3.dcVips;
                        if (strArr != null) {
                            GlobalOrange.dcVips.addAll(Arrays.asList(strArr));
                        }
                        OConfig oConfig4 = oConfig;
                        GlobalOrange.ackHost = oConfig4.ackHost;
                        String[] strArr2 = oConfig4.ackVips;
                        if (strArr2 != null) {
                            GlobalOrange.ackVips.addAll(Arrays.asList(strArr2));
                        }
                        if (oConfig.enableDiffIndex) {
                            GlobalOrange.indexDiff = 2;
                        }
                        ConfigCenter.this.channelIndexUpdate = oConfig.channelIndexUpdate;
                        ConfigCenter.this.mListeners.put("orange", new HashSet<ParcelableConfigListener>() {
                            /* class com.taobao.orange.ConfigCenter.AnonymousClass1.AnonymousClass1 */

                            {
                                add(new ParcelableConfigListener.Stub() {
                                    /* class com.taobao.orange.ConfigCenter.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.taobao.orange.aidl.ParcelableConfigListener
                                    public void onConfigUpdate(String str, Map map) throws RemoteException {
                                        ConfigCenter.this.updateSystemConfig(map);
                                    }
                                });
                            }
                        });
                        MultiAnalyze.initBuildInCandidates();
                        ConfigCenter.this.loadCaches();
                        File file = new File(FileUtil.getOrangeConfigDir(), IndexCache.INDEX_STORE_NAME);
                        ConfigCenter.this.mIsFirstInstall = !file.exists();
                        OrangeMonitor.init();
                        try {
                            int i = e21.b;
                            e21.a(new NetworkInterceptor());
                            OLog.i(ConfigCenter.TAG, UCCore.LEGACY_EVENT_INIT, "add orange interceptor success to networksdk");
                        } catch (ClassNotFoundException e) {
                            OLog.w(ConfigCenter.TAG, UCCore.LEGACY_EVENT_INIT, e, "add orange interceptor fail as not found networksdk");
                        }
                        ConfigCenter.this.mIsOrangeInit.set(true);
                        ConfigCenter.this.forceCheckUpdate();
                        OrangeAccsService.complete();
                        if (ConfigCenter.this.mInitListener != null) {
                            ConfigCenter.this.mInitListener.complete();
                        }
                        if (oConfig.time >= 0) {
                            OThreadFactory.execute(new Runnable() {
                                /* class com.taobao.orange.ConfigCenter.AnonymousClass1.AnonymousClass2 */

                                public void run() {
                                    ConfigCenter.this.delayLoadConfig();
                                }
                            }, oConfig.time);
                        }
                        OThreadFactory.execute(new Runnable() {
                            /* class com.taobao.orange.ConfigCenter.AnonymousClass1.AnonymousClass3 */

                            public void run() {
                                OrangeMonitorData orangeMonitorData = new OrangeMonitorData();
                                orangeMonitorData.performance.bootType = ConfigCenter.this.mIsFirstInstall;
                                orangeMonitorData.performance.downgradeType = GlobalOrange.downgrade;
                                OrangeMonitorData.PerformanceStat performanceStat = orangeMonitorData.performance;
                                performanceStat.monitorType = 2;
                                performanceStat.requestCount = ConfigCenter.this.mRequestCount.get();
                                orangeMonitorData.performance.persistCount = FileUtil.persistCount.get();
                                orangeMonitorData.performance.restoreCount = FileUtil.restoreCount.get();
                                orangeMonitorData.performance.persistTime = FileUtil.persistTime.get();
                                orangeMonitorData.performance.restoreTime = FileUtil.restoreTime.get();
                                orangeMonitorData.performance.ioTime = FileUtil.ioTime.get();
                                OrangeMonitor.commitBootPerformanceInfo(orangeMonitorData);
                                OrangeMonitor.mPerformanceInfoRecordDone = true;
                            }
                        }, 90000);
                        OLog.i(ConfigCenter.TAG, "init completed", new Object[0]);
                    } else {
                        OLog.w(ConfigCenter.TAG, "already init", new Object[0]);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void loadCaches() {
        Set<NameSpaceDO> set;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            OLog.i(TAG, "loadCaches", "start index");
            this.mIndexCache.load();
            Set<NameSpaceDO> allNameSpaces = this.mIndexCache.getAllNameSpaces();
            OLog.i(TAG, "loadCaches", "start restore configs", Integer.valueOf(allNameSpaces.size()));
            if (this.channelIndexUpdate) {
                set = this.mConfigCache.loadByUseNamespacesFilter(allNameSpaces);
            } else {
                set = this.mConfigCache.load(allNameSpaces);
            }
            OLog.i(TAG, "loadCaches", "finish restore configs", Integer.valueOf(allNameSpaces.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (set != null && !set.isEmpty()) {
                OLog.i(TAG, "loadCaches", "start load notMatchNamespaces", Integer.valueOf(set.size()));
                long currentTimeMillis2 = System.currentTimeMillis();
                for (NameSpaceDO nameSpaceDO : set) {
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_CONFIG_NOTMATCH_COUNTS, nameSpaceDO.name, 1.0d);
                    loadConfig(nameSpaceDO);
                    set = set;
                }
                OLog.i(TAG, "loadCaches", "finish load notMatchNamespaces", Integer.valueOf(set.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            GlobalOrange.context.registerReceiver(new OrangeReceiver(), intentFilter);
        } catch (Throwable th) {
            OLog.e(TAG, "loadCaches", th, new Object[0]);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "0", OConstant.CODE_POINT_EXP_LOAD_CACHE, byteArrayOutputStream.toString());
        }
    }

    public void loadConfig(NameSpaceDO nameSpaceDO) {
        loadConfig(nameSpaceDO, false);
    }

    public void loadConfigLazy(NameSpaceDO nameSpaceDO) {
        if (nameSpaceDO == null) {
            OLog.e(TAG, "loadConfigLazy fail", "nameSpaceDO is null");
        } else if ("orange".equals(nameSpaceDO.name)) {
            loadConfig(nameSpaceDO);
        } else if (GlobalOrange.downgrade > 0) {
            OLog.w(TAG, "loadConfigLazy downgrade, back to old strategy", nameSpaceDO.name, nameSpaceDO.loadLevel, Integer.valueOf(GlobalOrange.downgrade));
            loadConfig(nameSpaceDO);
            if (OrangeMonitor.mAppMonitorValid && this.mDowngradeConfigMap.get(nameSpaceDO.name) == null) {
                this.mDowngradeConfigMap.put(nameSpaceDO.name, Long.valueOf(System.currentTimeMillis()));
                OrangeMonitor.commitCount(OConstant.MONITOR_MODULE, OConstant.POINT_DOWNGRADE, nameSpaceDO.name, 1.0d);
            }
        } else {
            OLog.d(TAG, "loadConfigLazy", nameSpaceDO.name, nameSpaceDO.loadLevel, nameSpaceDO.highLazy);
            if (nameSpaceDO.highLazy.intValue() == 0 || !this.mIsFirstInstall) {
                loadConfig(nameSpaceDO);
            } else if (this.isAfterIdle.get()) {
                loadConfig(nameSpaceDO);
            } else {
                getConfigWaitingNetworkQueue().offer(nameSpaceDO);
                OLog.d(TAG, "offer a namespace", nameSpaceDO.name, "to network queue");
            }
        }
    }

    public void notifyListeners(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("fromCache", String.valueOf(z));
            hashMap.put("configVersion", str2);
            if (!z && !this.mGlobalListeners.isEmpty()) {
                for (ParcelableConfigListener parcelableConfigListener : this.mGlobalListeners) {
                    try {
                        parcelableConfigListener.onConfigUpdate(str, hashMap);
                    } catch (Throwable th) {
                        OLog.w(TAG, "notifyGlobalListeners", th, new Object[0]);
                    }
                }
            }
            HashSet<ParcelableConfigListener> hashSet = new HashSet();
            synchronized (this.mListeners) {
                Set<ParcelableConfigListener> set = this.mListeners.get(str);
                if (set != null && set.size() > 0) {
                    hashSet.addAll(set);
                }
            }
            if (hashSet.size() > 0) {
                if (OLog.isPrintLog(1)) {
                    OLog.d(TAG, "notifyListeners ", "namespace", str, "args", hashMap, "listenerSet.size", Integer.valueOf(hashSet.size()));
                }
                for (ParcelableConfigListener parcelableConfigListener2 : hashSet) {
                    try {
                        parcelableConfigListener2.onConfigUpdate(str, hashMap);
                    } catch (Throwable th2) {
                        OLog.w(TAG, "notifyListeners", th2, new Object[0]);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        r13 = r10.mConfigCache.getConfigMap().get(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
        if (r13 == null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        r13 = r13.getCurVersion();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (com.taobao.orange.util.OLog.isPrintLog(0) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        com.taobao.orange.util.OLog.v(com.taobao.orange.ConfigCenter.TAG, "registerListener onConfigUpdate", "namespace", r11, "version", r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0 = new java.util.HashMap();
        r0.put("fromCache", "true");
        r0.put("configVersion", r13);
        r12.onConfigUpdate(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bb, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bc, code lost:
        com.taobao.orange.util.OLog.w(com.taobao.orange.ConfigCenter.TAG, "registerListener", r11, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c6, code lost:
        r12 = r10.mIndexCache;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c8, code lost:
        if (r12 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ce, code lost:
        if (r12.getNameSpace(r11) == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        if (r10.mIsOrangeInit.get() == false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dc, code lost:
        if (checkLoading(r11, false) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00de, code lost:
        com.taobao.orange.OThreadFactory.execute(new com.taobao.orange.ConfigCenter.AnonymousClass6(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        addFail(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    public void registerListener(final String str, ParcelableConfigListener parcelableConfigListener, boolean z) {
        if (!TextUtils.isEmpty(str) && parcelableConfigListener != null) {
            synchronized (this.mListeners) {
                Set<ParcelableConfigListener> set = this.mListeners.get(str);
                if (set == null) {
                    set = Collections.newSetFromMap(new LinkedHashMap<ParcelableConfigListener, Boolean>() {
                        /* class com.taobao.orange.ConfigCenter.AnonymousClass5 */

                        /* access modifiers changed from: protected */
                        @Override // java.util.LinkedHashMap
                        public boolean removeEldestEntry(Map.Entry<ParcelableConfigListener, Boolean> entry) {
                            return ((long) size()) > 10;
                        }
                    });
                    this.mListeners.put(str, set);
                }
                if (!set.contains(parcelableConfigListener)) {
                    if (z) {
                        set.add(parcelableConfigListener);
                        if (OLog.isPrintLog(1)) {
                            OLog.d(TAG, "registerListener append", "namespace", str, "size", Integer.valueOf(set.size()));
                        }
                    } else {
                        if (OLog.isPrintLog(1)) {
                            OLog.d(TAG, "registerListener cover", "namespace", str);
                        }
                        set.clear();
                        set.add(parcelableConfigListener);
                    }
                }
            }
        }
    }

    public void rematchNamespace(final Set<String> set, final boolean z) {
        OThreadFactory.execute(new Runnable() {
            /* class com.taobao.orange.ConfigCenter.AnonymousClass9 */

            public void run() {
                Map<String, Set<String>> map;
                synchronized (ConfigCenter.this) {
                    Set set = set;
                    if (!(set == null || set.isEmpty() || (map = ConfigCenter.this.mIndexCache.candidateNamespace) == null)) {
                        if (!map.isEmpty()) {
                            set.addAll(ConfigCenter.this.failCandidateSet);
                            ConfigCenter.this.failCandidateSet.clear();
                            if (OLog.isPrintLog(1)) {
                                OLog.d(ConfigCenter.TAG, "rematchNamespace", "<<<<<<<<<<<<<< START >>>>>>>>>>>>>>");
                            }
                            if (OLog.isPrintLog(1)) {
                                OLog.d(ConfigCenter.TAG, "rematchNamespace", "candidateKeys", set);
                            }
                            HashSet<String> hashSet = new HashSet();
                            for (String str : set) {
                                Set<String> set2 = ConfigCenter.this.mIndexCache.candidateNamespace.get(str);
                                if (set2 != null) {
                                    hashSet.addAll(set2);
                                }
                            }
                            if (OLog.isPrintLog(1)) {
                                OLog.d(ConfigCenter.TAG, "rematchNamespace", "specialNamespaces", hashSet);
                            }
                            for (String str2 : hashSet) {
                                if (!ConfigCenter.this.mConfigCache.getConfigMap().containsKey(str2)) {
                                    OLog.w(ConfigCenter.TAG, "rematchNamespace break as not used DEFAULT", "namespace", str2);
                                } else {
                                    ConfigCenter configCenter = ConfigCenter.this;
                                    configCenter.loadConfig(configCenter.mIndexCache.getNameSpace(str2), z);
                                }
                            }
                            ConfigCenter.this.updateLocalEnvironment();
                            if (OLog.isPrintLog(1)) {
                                OLog.d(ConfigCenter.TAG, "rematchNamespace", "<<<<<<<<<<<<<< END >>>>>>>>>>>>>>");
                            }
                            return;
                        }
                    }
                    if (OLog.isPrintLog(3)) {
                        OLog.w(ConfigCenter.TAG, "rematchNamespace fail", new Object[0]);
                    }
                    ConfigCenter.this.failCandidateSet.addAll(set);
                }
            }
        });
    }

    public void removeFail(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mFailRequestsSet) {
                if (this.mFailRequestsSet.remove(str) && OLog.isPrintLog(2)) {
                    OLog.i(TAG, "removeFail", "namespace", str);
                }
            }
        }
    }

    public boolean removeGlobalListener(OConfigListener oConfigListener) {
        if (oConfigListener != null) {
            return this.mGlobalListeners.remove(new OrangeConfigListenerStub(oConfigListener));
        }
        return false;
    }

    public synchronized void retryFailRequests() {
        HashSet<NameSpaceDO> hashSet = new HashSet();
        synchronized (this.mFailRequestsSet) {
            for (String str : this.mFailRequestsSet) {
                NameSpaceDO nameSpace = this.mIndexCache.getNameSpace(str);
                if (nameSpace != null) {
                    hashSet.add(nameSpace);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            OLog.i(TAG, "retryFailRequests", "start load retryNamespaces", Integer.valueOf(hashSet.size()));
            long currentTimeMillis = System.currentTimeMillis();
            for (NameSpaceDO nameSpaceDO : hashSet) {
                loadConfig(nameSpaceDO);
            }
            OLog.i(TAG, "retryFailRequests", "finish load retryNamespaces", Integer.valueOf(hashSet.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } else if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "retryFailRequests no any", new Object[0]);
        }
    }

    @Deprecated
    public void setGlobalListener(OConfigListener oConfigListener) {
        this.mGlobalListeners.add(new OrangeConfigListenerStub(oConfigListener));
    }

    public void setInitListener(OInitListener oInitListener) {
        this.mInitListener = oInitListener;
    }

    public void unregisterListener(String str, ParcelableConfigListener parcelableConfigListener) {
        if (!TextUtils.isEmpty(str) && parcelableConfigListener != null) {
            synchronized (this.mListeners) {
                Set<ParcelableConfigListener> set = this.mListeners.get(str);
                if (set != null && set.size() > 0 && set.remove(parcelableConfigListener) && OLog.isPrintLog(1)) {
                    OLog.d(TAG, "unregisterListener", "namespace", str, "size", Integer.valueOf(set.size()));
                }
            }
        }
    }

    public void unregisterListeners(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mListeners) {
                this.mListeners.remove(str);
            }
        }
    }

    public synchronized void updateIndex(IndexUpdateHandler.IndexUpdateInfo indexUpdateInfo) {
        Set<NameSpaceDO> set;
        if (!loadIndex(indexUpdateInfo)) {
            if (OLog.isPrintLog(0)) {
                OLog.v(TAG, "updateIndex", "no need update or update fail index file");
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashSet hashSet = new HashSet((int) (((double) (this.mConfigCache.getConfigMap().size() + this.mFailRequestsSet.size())) * 1.4d));
        hashSet.addAll(this.mConfigCache.getConfigMap().keySet());
        synchronized (this.mFailRequestsSet) {
            hashSet.addAll(this.mFailRequestsSet);
        }
        if (this.channelIndexUpdate) {
            set = this.mIndexCache.getUpdateNameSpacesByUsedList(hashSet);
        } else {
            set = this.mIndexCache.getUpdateNameSpaces(hashSet);
        }
        OLog.i(TAG, "updateIndex", "start load updateNameSpaces", Integer.valueOf(set.size()));
        for (NameSpaceDO nameSpaceDO : set) {
            loadConfigLazy(nameSpaceDO);
        }
        OLog.i(TAG, "updateIndex", "finish load updateNameSpaces", Integer.valueOf(set.size()), "cost(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: package-private */
    public long updateRandomDelayAckInterval(long j) {
        if (j == 0) {
            return 0;
        }
        return OrangeUtils.hash(GlobalOrange.deviceId) % (j * 1000);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0339 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0359 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0374 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a3 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c1 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cd A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0123 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0147 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016b A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018f A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01b7 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e1 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0223 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0249 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0293 A[Catch:{ all -> 0x0382 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02af A[Catch:{ all -> 0x0382 }] */
    public void updateSystemConfig(Map map) {
        Object obj;
        boolean z;
        String str;
        boolean z2;
        String str2;
        boolean z3;
        String str3;
        boolean z4;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        List parseArray;
        List parseArray2;
        JSONArray parseArray3;
        ArrayList arrayList;
        int i;
        int i2;
        ConfigDO configDO;
        boolean z5;
        boolean z6;
        boolean z7;
        try {
            Map map2 = (Map) this.mConfigCache.getConfigObj("orange");
            int i3 = 3;
            if (OLog.isPrintLog(2)) {
                OLog.i(TAG, "updateSystemConfig", "args", map, "orangeConfigs", map2);
            }
            if (map2 != null && !map2.isEmpty()) {
                String str15 = (String) map2.get("processIsolated");
                if (!TextUtils.isEmpty(str15)) {
                    boolean parseBoolean = Boolean.parseBoolean(str15);
                    obj = OConstant.SYSKEY_ACKVIPS;
                    if (parseBoolean != GlobalOrange.processIsolated) {
                        z = true;
                        str = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY);
                        if (TextUtils.isEmpty(str)) {
                            z7 = z;
                            if (Boolean.parseBoolean(str) != GlobalOrange.processQuery) {
                                z2 = true;
                                str2 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_FORBID_TIME);
                                if (!TextUtils.isEmpty(str2)) {
                                    z6 = z2;
                                    if (!GlobalOrange.processQueryForbidTime.equals(str2)) {
                                        z3 = true;
                                        str3 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_STRATEGY);
                                        if (TextUtils.isEmpty(str3)) {
                                            z5 = z3;
                                            if (!GlobalOrange.processQueryStrategy.equals(str3)) {
                                                z4 = true;
                                                if (z4 && (configDO = this.mConfigCache.getConfigMap().get("orange")) != null) {
                                                    ConfigDO configDO2 = new ConfigDO();
                                                    configDO2.appKey = configDO.appKey;
                                                    configDO2.appVersion = configDO.appVersion;
                                                    configDO2.id = configDO.id;
                                                    configDO2.name = configDO.name;
                                                    configDO2.resourceId = configDO.resourceId;
                                                    configDO2.type = configDO.type;
                                                    configDO2.loadLevel = configDO.loadLevel;
                                                    configDO2.version = configDO.version;
                                                    HashMap hashMap = new HashMap();
                                                    configDO2.content = hashMap;
                                                    hashMap.putAll(configDO.content);
                                                    FileUtil.persistObjectLocked(configDO2, OConstant.PROCESS_ISOLATED_LOCAL_CONFIG);
                                                }
                                                str4 = (String) map2.get("indexDiff");
                                                if (!TextUtils.isEmpty(str4)) {
                                                    GlobalOrange.indexDiff = Integer.parseInt(str4);
                                                    OLog.i(TAG, "updateSystemConfig", "indexDiff", Integer.valueOf(GlobalOrange.indexDiff));
                                                }
                                                str5 = (String) map2.get(OConstant.SYSKEY_FALLBACK_AVOID);
                                                if (!TextUtils.isEmpty(str5)) {
                                                    GlobalOrange.fallbackAvoid = Boolean.parseBoolean(str5);
                                                    OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_FALLBACK_AVOID, Boolean.valueOf(GlobalOrange.fallbackAvoid));
                                                }
                                                str6 = (String) map2.get(OConstant.SYSKEY_INDEX_ENV_CHECK);
                                                if (!TextUtils.isEmpty(str6)) {
                                                    GlobalOrange.indexEnvCheck = Boolean.parseBoolean(str6);
                                                    OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_INDEX_ENV_CHECK, Boolean.valueOf(GlobalOrange.indexEnvCheck));
                                                }
                                                str7 = (String) map2.get(OConstant.SYSKEY_REQ_RETRY_NUM);
                                                if (!TextUtils.isEmpty(str7)) {
                                                    int parseInt = Integer.parseInt(str7);
                                                    if (parseInt > 5) {
                                                        parseInt = 5;
                                                    }
                                                    GlobalOrange.reqRetryNum = parseInt;
                                                    OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_REQ_RETRY_NUM, Integer.valueOf(GlobalOrange.reqRetryNum));
                                                }
                                                str8 = (String) map2.get(OConstant.SYSKEY_REPORT_UPDACK);
                                                if (!TextUtils.isEmpty(str8)) {
                                                    GlobalOrange.reportUpdateAck = Integer.parseInt(str8) == 1;
                                                    OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_REPORT_UPDACK, Boolean.valueOf(GlobalOrange.reportUpdateAck));
                                                }
                                                str9 = (String) map2.get(OConstant.SYSKEY_DELAYACK_INTERVAL);
                                                if (!TextUtils.isEmpty(str9)) {
                                                    long parseLong = Long.parseLong(str9);
                                                    OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_DELAYACK_INTERVAL, Long.valueOf(parseLong));
                                                    if (parseLong > 0) {
                                                        GlobalOrange.randomDelayAckInterval = updateRandomDelayAckInterval(parseLong);
                                                        OLog.i(TAG, "updateSystemConfig", "randomDelayAckInterval", Long.valueOf(GlobalOrange.randomDelayAckInterval));
                                                    }
                                                }
                                                str10 = (String) map2.get(OConstant.SYSKEY_INDEXUPD_MODE);
                                                if (!TextUtils.isEmpty(str10)) {
                                                    GlobalOrange.indexUpdMode = OConstant.UPDMODE.valueOf(Integer.parseInt(str10));
                                                    OLog.i(TAG, "updateSystemConfig", "indexUpdMode", GlobalOrange.indexUpdMode);
                                                }
                                                str11 = (String) map2.get(OConstant.SYSKEY_DOWNGRADE);
                                                if (!TextUtils.isEmpty(str11)) {
                                                    if (Boolean.valueOf(str11).booleanValue()) {
                                                        i2 = 2;
                                                        GlobalOrange.downgrade = 2;
                                                    } else {
                                                        i2 = 2;
                                                    }
                                                    Object[] objArr = new Object[i2];
                                                    objArr[0] = OConstant.SYSKEY_DOWNGRADE;
                                                    objArr[1] = Integer.valueOf(GlobalOrange.downgrade);
                                                    OLog.i(TAG, "updateSystemConfig", objArr);
                                                }
                                                String str16 = (String) map2.get("hosts");
                                                if (!TextUtils.isEmpty(str16) && (parseArray3 = JSON.parseArray(str16)) != null && parseArray3.size() >= 0) {
                                                    arrayList = new ArrayList(parseArray3.size());
                                                    for (i = 0; i < parseArray3.size(); i++) {
                                                        String string = parseArray3.getJSONObject(i).getString("host");
                                                        if (!TextUtils.isEmpty(string)) {
                                                            arrayList.add(string);
                                                        }
                                                    }
                                                    if (arrayList.size() > 0) {
                                                        GlobalOrange.probeHosts.clear();
                                                        GlobalOrange.probeHosts.addAll(arrayList);
                                                        OLog.i(TAG, "updateSystemConfig", "probeHosts", GlobalOrange.probeHosts);
                                                    }
                                                }
                                                String str17 = (String) map2.get(OConstant.SYSKEY_DCVIPS);
                                                if (!TextUtils.isEmpty(str17) && (parseArray2 = JSON.parseArray(str17, String.class)) != null && parseArray2.size() > 0) {
                                                    GlobalOrange.dcVips.clear();
                                                    GlobalOrange.dcVips.addAll(parseArray2);
                                                    OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_DCVIPS, GlobalOrange.dcVips);
                                                }
                                                String str18 = (String) map2.get(obj);
                                                if (!TextUtils.isEmpty(str18) && (parseArray = JSON.parseArray(str18, String.class)) != null && parseArray.size() > 0) {
                                                    GlobalOrange.ackVips.clear();
                                                    GlobalOrange.ackVips.addAll(parseArray);
                                                    OLog.i(TAG, "updateSystemConfig", obj, GlobalOrange.ackVips);
                                                }
                                                str12 = (String) map2.get(OConstant.SYSKEY_BIND_TIMEOUT);
                                                if (!TextUtils.isEmpty(str12)) {
                                                    int parseInt2 = StringUtil.parseInt(str12);
                                                    Context context = GlobalOrange.context;
                                                    if (parseInt2 != 0) {
                                                        i3 = parseInt2;
                                                    }
                                                    SPUtil.saveToSharePreference(context, OConstant.SYSKEY_BIND_TIMEOUT, Integer.valueOf(i3));
                                                }
                                                str13 = (String) map2.get(OConstant.SYSKEY_RECOVERY_SERVICE_STATE);
                                                if (!TextUtils.isEmpty(str13)) {
                                                    SPUtil.saveToSharePreference(GlobalOrange.context, OConstant.SYSKEY_RECOVERY_SERVICE_STATE, Integer.valueOf(StringUtil.parseInt(str13)));
                                                }
                                                str14 = (String) map2.get("enableChangeVersion");
                                                if (!TextUtils.isEmpty(str14)) {
                                                    SPUtil.saveToSharePreference(GlobalOrange.context, "enableChangeVersion", Integer.valueOf(StringUtil.parseInt(str14)));
                                                    return;
                                                }
                                                return;
                                            }
                                        } else {
                                            z5 = z3;
                                        }
                                        z4 = z5;
                                        ConfigDO configDO22 = new ConfigDO();
                                        configDO22.appKey = configDO.appKey;
                                        configDO22.appVersion = configDO.appVersion;
                                        configDO22.id = configDO.id;
                                        configDO22.name = configDO.name;
                                        configDO22.resourceId = configDO.resourceId;
                                        configDO22.type = configDO.type;
                                        configDO22.loadLevel = configDO.loadLevel;
                                        configDO22.version = configDO.version;
                                        HashMap hashMap2 = new HashMap();
                                        configDO22.content = hashMap2;
                                        hashMap2.putAll(configDO.content);
                                        FileUtil.persistObjectLocked(configDO22, OConstant.PROCESS_ISOLATED_LOCAL_CONFIG);
                                        str4 = (String) map2.get("indexDiff");
                                        if (!TextUtils.isEmpty(str4)) {
                                        }
                                        str5 = (String) map2.get(OConstant.SYSKEY_FALLBACK_AVOID);
                                        if (!TextUtils.isEmpty(str5)) {
                                        }
                                        str6 = (String) map2.get(OConstant.SYSKEY_INDEX_ENV_CHECK);
                                        if (!TextUtils.isEmpty(str6)) {
                                        }
                                        str7 = (String) map2.get(OConstant.SYSKEY_REQ_RETRY_NUM);
                                        if (!TextUtils.isEmpty(str7)) {
                                        }
                                        str8 = (String) map2.get(OConstant.SYSKEY_REPORT_UPDACK);
                                        if (!TextUtils.isEmpty(str8)) {
                                        }
                                        str9 = (String) map2.get(OConstant.SYSKEY_DELAYACK_INTERVAL);
                                        if (!TextUtils.isEmpty(str9)) {
                                        }
                                        str10 = (String) map2.get(OConstant.SYSKEY_INDEXUPD_MODE);
                                        if (!TextUtils.isEmpty(str10)) {
                                        }
                                        str11 = (String) map2.get(OConstant.SYSKEY_DOWNGRADE);
                                        if (!TextUtils.isEmpty(str11)) {
                                        }
                                        String str162 = (String) map2.get("hosts");
                                        arrayList = new ArrayList(parseArray3.size());
                                        while (i < parseArray3.size()) {
                                        }
                                        if (arrayList.size() > 0) {
                                        }
                                        String str172 = (String) map2.get(OConstant.SYSKEY_DCVIPS);
                                        GlobalOrange.dcVips.clear();
                                        GlobalOrange.dcVips.addAll(parseArray2);
                                        OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_DCVIPS, GlobalOrange.dcVips);
                                        String str182 = (String) map2.get(obj);
                                        GlobalOrange.ackVips.clear();
                                        GlobalOrange.ackVips.addAll(parseArray);
                                        OLog.i(TAG, "updateSystemConfig", obj, GlobalOrange.ackVips);
                                        str12 = (String) map2.get(OConstant.SYSKEY_BIND_TIMEOUT);
                                        if (!TextUtils.isEmpty(str12)) {
                                        }
                                        str13 = (String) map2.get(OConstant.SYSKEY_RECOVERY_SERVICE_STATE);
                                        if (!TextUtils.isEmpty(str13)) {
                                        }
                                        str14 = (String) map2.get("enableChangeVersion");
                                        if (!TextUtils.isEmpty(str14)) {
                                        }
                                    }
                                } else {
                                    z6 = z2;
                                }
                                z3 = z6;
                                str3 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_STRATEGY);
                                if (TextUtils.isEmpty(str3)) {
                                }
                                z4 = z5;
                                ConfigDO configDO222 = new ConfigDO();
                                configDO222.appKey = configDO.appKey;
                                configDO222.appVersion = configDO.appVersion;
                                configDO222.id = configDO.id;
                                configDO222.name = configDO.name;
                                configDO222.resourceId = configDO.resourceId;
                                configDO222.type = configDO.type;
                                configDO222.loadLevel = configDO.loadLevel;
                                configDO222.version = configDO.version;
                                HashMap hashMap22 = new HashMap();
                                configDO222.content = hashMap22;
                                hashMap22.putAll(configDO.content);
                                FileUtil.persistObjectLocked(configDO222, OConstant.PROCESS_ISOLATED_LOCAL_CONFIG);
                                str4 = (String) map2.get("indexDiff");
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                str5 = (String) map2.get(OConstant.SYSKEY_FALLBACK_AVOID);
                                if (!TextUtils.isEmpty(str5)) {
                                }
                                str6 = (String) map2.get(OConstant.SYSKEY_INDEX_ENV_CHECK);
                                if (!TextUtils.isEmpty(str6)) {
                                }
                                str7 = (String) map2.get(OConstant.SYSKEY_REQ_RETRY_NUM);
                                if (!TextUtils.isEmpty(str7)) {
                                }
                                str8 = (String) map2.get(OConstant.SYSKEY_REPORT_UPDACK);
                                if (!TextUtils.isEmpty(str8)) {
                                }
                                str9 = (String) map2.get(OConstant.SYSKEY_DELAYACK_INTERVAL);
                                if (!TextUtils.isEmpty(str9)) {
                                }
                                str10 = (String) map2.get(OConstant.SYSKEY_INDEXUPD_MODE);
                                if (!TextUtils.isEmpty(str10)) {
                                }
                                str11 = (String) map2.get(OConstant.SYSKEY_DOWNGRADE);
                                if (!TextUtils.isEmpty(str11)) {
                                }
                                String str1622 = (String) map2.get("hosts");
                                arrayList = new ArrayList(parseArray3.size());
                                while (i < parseArray3.size()) {
                                }
                                if (arrayList.size() > 0) {
                                }
                                String str1722 = (String) map2.get(OConstant.SYSKEY_DCVIPS);
                                GlobalOrange.dcVips.clear();
                                GlobalOrange.dcVips.addAll(parseArray2);
                                OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_DCVIPS, GlobalOrange.dcVips);
                                String str1822 = (String) map2.get(obj);
                                GlobalOrange.ackVips.clear();
                                GlobalOrange.ackVips.addAll(parseArray);
                                OLog.i(TAG, "updateSystemConfig", obj, GlobalOrange.ackVips);
                                str12 = (String) map2.get(OConstant.SYSKEY_BIND_TIMEOUT);
                                if (!TextUtils.isEmpty(str12)) {
                                }
                                str13 = (String) map2.get(OConstant.SYSKEY_RECOVERY_SERVICE_STATE);
                                if (!TextUtils.isEmpty(str13)) {
                                }
                                str14 = (String) map2.get("enableChangeVersion");
                                if (!TextUtils.isEmpty(str14)) {
                                }
                            }
                        } else {
                            z7 = z;
                        }
                        z2 = z7;
                        str2 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_FORBID_TIME);
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        z3 = z6;
                        str3 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_STRATEGY);
                        if (TextUtils.isEmpty(str3)) {
                        }
                        z4 = z5;
                        ConfigDO configDO2222 = new ConfigDO();
                        configDO2222.appKey = configDO.appKey;
                        configDO2222.appVersion = configDO.appVersion;
                        configDO2222.id = configDO.id;
                        configDO2222.name = configDO.name;
                        configDO2222.resourceId = configDO.resourceId;
                        configDO2222.type = configDO.type;
                        configDO2222.loadLevel = configDO.loadLevel;
                        configDO2222.version = configDO.version;
                        HashMap hashMap222 = new HashMap();
                        configDO2222.content = hashMap222;
                        hashMap222.putAll(configDO.content);
                        FileUtil.persistObjectLocked(configDO2222, OConstant.PROCESS_ISOLATED_LOCAL_CONFIG);
                        str4 = (String) map2.get("indexDiff");
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        str5 = (String) map2.get(OConstant.SYSKEY_FALLBACK_AVOID);
                        if (!TextUtils.isEmpty(str5)) {
                        }
                        str6 = (String) map2.get(OConstant.SYSKEY_INDEX_ENV_CHECK);
                        if (!TextUtils.isEmpty(str6)) {
                        }
                        str7 = (String) map2.get(OConstant.SYSKEY_REQ_RETRY_NUM);
                        if (!TextUtils.isEmpty(str7)) {
                        }
                        str8 = (String) map2.get(OConstant.SYSKEY_REPORT_UPDACK);
                        if (!TextUtils.isEmpty(str8)) {
                        }
                        str9 = (String) map2.get(OConstant.SYSKEY_DELAYACK_INTERVAL);
                        if (!TextUtils.isEmpty(str9)) {
                        }
                        str10 = (String) map2.get(OConstant.SYSKEY_INDEXUPD_MODE);
                        if (!TextUtils.isEmpty(str10)) {
                        }
                        str11 = (String) map2.get(OConstant.SYSKEY_DOWNGRADE);
                        if (!TextUtils.isEmpty(str11)) {
                        }
                        String str16222 = (String) map2.get("hosts");
                        arrayList = new ArrayList(parseArray3.size());
                        while (i < parseArray3.size()) {
                        }
                        if (arrayList.size() > 0) {
                        }
                        String str17222 = (String) map2.get(OConstant.SYSKEY_DCVIPS);
                        GlobalOrange.dcVips.clear();
                        GlobalOrange.dcVips.addAll(parseArray2);
                        OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_DCVIPS, GlobalOrange.dcVips);
                        String str18222 = (String) map2.get(obj);
                        GlobalOrange.ackVips.clear();
                        GlobalOrange.ackVips.addAll(parseArray);
                        OLog.i(TAG, "updateSystemConfig", obj, GlobalOrange.ackVips);
                        str12 = (String) map2.get(OConstant.SYSKEY_BIND_TIMEOUT);
                        if (!TextUtils.isEmpty(str12)) {
                        }
                        str13 = (String) map2.get(OConstant.SYSKEY_RECOVERY_SERVICE_STATE);
                        if (!TextUtils.isEmpty(str13)) {
                        }
                        str14 = (String) map2.get("enableChangeVersion");
                        if (!TextUtils.isEmpty(str14)) {
                        }
                    }
                } else {
                    obj = OConstant.SYSKEY_ACKVIPS;
                }
                z = false;
                str = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY);
                if (TextUtils.isEmpty(str)) {
                }
                z2 = z7;
                str2 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_FORBID_TIME);
                if (!TextUtils.isEmpty(str2)) {
                }
                z3 = z6;
                str3 = (String) map2.get(OConstant.SYSKEY_PROCESS_QUERY_STRATEGY);
                if (TextUtils.isEmpty(str3)) {
                }
                z4 = z5;
                ConfigDO configDO22222 = new ConfigDO();
                configDO22222.appKey = configDO.appKey;
                configDO22222.appVersion = configDO.appVersion;
                configDO22222.id = configDO.id;
                configDO22222.name = configDO.name;
                configDO22222.resourceId = configDO.resourceId;
                configDO22222.type = configDO.type;
                configDO22222.loadLevel = configDO.loadLevel;
                configDO22222.version = configDO.version;
                HashMap hashMap2222 = new HashMap();
                configDO22222.content = hashMap2222;
                hashMap2222.putAll(configDO.content);
                FileUtil.persistObjectLocked(configDO22222, OConstant.PROCESS_ISOLATED_LOCAL_CONFIG);
                str4 = (String) map2.get("indexDiff");
                if (!TextUtils.isEmpty(str4)) {
                }
                str5 = (String) map2.get(OConstant.SYSKEY_FALLBACK_AVOID);
                if (!TextUtils.isEmpty(str5)) {
                }
                str6 = (String) map2.get(OConstant.SYSKEY_INDEX_ENV_CHECK);
                if (!TextUtils.isEmpty(str6)) {
                }
                str7 = (String) map2.get(OConstant.SYSKEY_REQ_RETRY_NUM);
                if (!TextUtils.isEmpty(str7)) {
                }
                str8 = (String) map2.get(OConstant.SYSKEY_REPORT_UPDACK);
                if (!TextUtils.isEmpty(str8)) {
                }
                str9 = (String) map2.get(OConstant.SYSKEY_DELAYACK_INTERVAL);
                if (!TextUtils.isEmpty(str9)) {
                }
                str10 = (String) map2.get(OConstant.SYSKEY_INDEXUPD_MODE);
                if (!TextUtils.isEmpty(str10)) {
                }
                str11 = (String) map2.get(OConstant.SYSKEY_DOWNGRADE);
                if (!TextUtils.isEmpty(str11)) {
                }
                String str162222 = (String) map2.get("hosts");
                arrayList = new ArrayList(parseArray3.size());
                while (i < parseArray3.size()) {
                }
                if (arrayList.size() > 0) {
                }
                String str172222 = (String) map2.get(OConstant.SYSKEY_DCVIPS);
                GlobalOrange.dcVips.clear();
                GlobalOrange.dcVips.addAll(parseArray2);
                OLog.i(TAG, "updateSystemConfig", OConstant.SYSKEY_DCVIPS, GlobalOrange.dcVips);
                String str182222 = (String) map2.get(obj);
                GlobalOrange.ackVips.clear();
                GlobalOrange.ackVips.addAll(parseArray);
                OLog.i(TAG, "updateSystemConfig", obj, GlobalOrange.ackVips);
                str12 = (String) map2.get(OConstant.SYSKEY_BIND_TIMEOUT);
                if (!TextUtils.isEmpty(str12)) {
                }
                str13 = (String) map2.get(OConstant.SYSKEY_RECOVERY_SERVICE_STATE);
                if (!TextUtils.isEmpty(str13)) {
                }
                str14 = (String) map2.get("enableChangeVersion");
                if (!TextUtils.isEmpty(str14)) {
                }
            }
        } catch (Throwable th) {
            OLog.e(TAG, "updateSystemConfig", th, new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f5 A[Catch:{ all -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01fb A[Catch:{ all -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0206 A[Catch:{ all -> 0x02a7 }] */
    public void loadConfig(final NameSpaceDO nameSpaceDO, boolean z) {
        final Class cls;
        int i;
        String str;
        Throwable th;
        String str2;
        String str3;
        String str4;
        Object obj;
        String str5;
        String str6;
        char c;
        ConfigDO configDO;
        if (nameSpaceDO == null) {
            OLog.e(TAG, "loadConfig fail", "nameSpaceDO is null");
            return;
        }
        if (NameSpaceDO.TYPE_STANDARD.equals(nameSpaceDO.type)) {
            cls = ConfigDO.class;
        } else if ("CUSTOM".equals(nameSpaceDO.type)) {
            cls = CustomConfigDO.class;
        } else {
            OLog.e(TAG, "loadConfig fail not support type", "namespace", nameSpaceDO.name, "type", nameSpaceDO.type);
            return;
        }
        if (!checkLoading(nameSpaceDO.name, true)) {
            try {
                String cdnUrl = this.mIndexCache.getCdnUrl();
                if (TextUtils.isEmpty(cdnUrl)) {
                    OLog.e(TAG, "loadConfig fail", "cdnUrl is null");
                    addFail(nameSpaceDO.name);
                    removeLoading(nameSpaceDO.name);
                    return;
                }
                if (OLog.isPrintLog(1)) {
                    OLog.d(TAG, "loadConfig start", nameSpaceDO);
                }
                ConfigDO configDO2 = this.mConfigCache.getConfigMap().get(nameSpaceDO.name);
                if (!nameSpaceDO.checkValid(configDO2, z)) {
                    removeFail(nameSpaceDO.name);
                    removeLoading(nameSpaceDO.name);
                    return;
                }
                CandidateDO candidateDO = nameSpaceDO.curCandidateDO;
                if (candidateDO != null) {
                    str3 = candidateDO.resourceId;
                    str2 = candidateDO.md5;
                    str4 = candidateDO.version;
                } else {
                    str3 = nameSpaceDO.resourceId;
                    str2 = nameSpaceDO.md5;
                    str4 = nameSpaceDO.version;
                }
                if (OLog.isPrintLog(0)) {
                    OLog.v(TAG, "loadConfig check", Constants.CONFIG, nameSpaceDO.name, "version", str4);
                }
                BaseRequest r3 = new BaseCdnRequest<ConfigDO>(cdnUrl + File.separator + str3, str2) {
                    /* class com.taobao.orange.ConfigCenter.AnonymousClass3 */

                    /* access modifiers changed from: protected */
                    @Override // com.taobao.orange.sync.BaseCdnRequest
                    public ConfigDO parseResContent(String str) {
                        return (ConfigDO) JSON.parseObject(str, cls);
                    }
                };
                ConfigDO configDO3 = (ConfigDO) r3.syncRequest();
                if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                    this.mRequestCount.incrementAndGet();
                }
                if (GlobalOrange.fallbackAvoid) {
                    str5 = str4;
                    str6 = "loadConfig fail";
                    obj = "msg";
                    c = 4;
                    configDO = configDO2;
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_FALLBACK_AVOID, nameSpaceDO.name, 1.0d);
                } else if (configDO3 == null || !configDO3.checkValid()) {
                    if (OLog.isPrintLog(0)) {
                        try {
                            Object[] objArr = new Object[4];
                            objArr[0] = "code";
                            objArr[1] = r3.getCode();
                            objArr[2] = "msg";
                            objArr[3] = r3.getMessage();
                            OLog.v(TAG, "loadConfig cdnReq fail downgrade to authReq", objArr);
                        } catch (Throwable th2) {
                            th = th2;
                            str = "loadConfig fail";
                            i = 2;
                            addFail(nameSpaceDO.name);
                            removeLoading(nameSpaceDO.name);
                            OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name, "0", th.getMessage());
                            Object[] objArr2 = new Object[i];
                            objArr2[0] = "namespace";
                            objArr2[1] = nameSpaceDO.name;
                            OLog.e(TAG, str, th, objArr2);
                        }
                    }
                    str6 = "loadConfig fail";
                    configDO = configDO2;
                    str5 = str4;
                    obj = "msg";
                    c = 4;
                    try {
                        BaseRequest r21 = new BaseAuthRequest<ConfigDO>(nameSpaceDO.md5, false, OConstant.REQTYPE_DOWNLOAD_RESOURCE) {
                            /* class com.taobao.orange.ConfigCenter.AnonymousClass4 */

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public Map<String, String> getReqParams() {
                                HashMap hashMap = new HashMap();
                                hashMap.put("resourceId", nameSpaceDO.resourceId);
                                return hashMap;
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public String getReqPostBody() {
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            public ConfigDO parseResContent(String str) {
                                return (ConfigDO) JSON.parseObject(str, cls);
                            }
                        };
                        configDO3 = (ConfigDO) r21.syncRequest();
                        r3 = r21;
                    } catch (Throwable th3) {
                        th = th3;
                        str = str6;
                        i = 2;
                        addFail(nameSpaceDO.name);
                        removeLoading(nameSpaceDO.name);
                        OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name, "0", th.getMessage());
                        Object[] objArr22 = new Object[i];
                        objArr22[0] = "namespace";
                        objArr22[1] = nameSpaceDO.name;
                        OLog.e(TAG, str, th, objArr22);
                    }
                } else {
                    str5 = str4;
                    str6 = "loadConfig fail";
                    obj = "msg";
                    c = 4;
                    configDO = configDO2;
                }
                if (configDO3 != null) {
                    try {
                        if (configDO3.checkValid() && configDO3.version.equals(str5) && configDO3.name.equals(nameSpaceDO.name)) {
                            configDO3.candidate = nameSpaceDO.curCandidateDO;
                            if (((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue() > 0) {
                                configDO3.setChangeVersion(nameSpaceDO.getChangeVersion());
                                if (configDO != null) {
                                    i = 2;
                                    if (configDO.getConfigStatus() == 2) {
                                        try {
                                            configDO3.setConfigStatus(0);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            str = str6;
                                            addFail(nameSpaceDO.name);
                                            removeLoading(nameSpaceDO.name);
                                            OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name, "0", th.getMessage());
                                            Object[] objArr222 = new Object[i];
                                            objArr222[0] = "namespace";
                                            objArr222[1] = nameSpaceDO.name;
                                            OLog.e(TAG, str, th, objArr222);
                                        }
                                    }
                                    removeFail(nameSpaceDO.name);
                                    removeLoading(nameSpaceDO.name);
                                    OrangeMonitor.commitSuccess(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name);
                                    OrangeMonitor.commitConfigMonitor(OConstant.POINT_CONFIG_UPDATE, nameSpaceDO.name, str5, configDO3.getChangeVersion());
                                    if (!this.channelIndexUpdate) {
                                        this.mConfigCache.cacheAndUpdateUsedNamespaceFilterToLocal(configDO3);
                                    } else {
                                        this.mConfigCache.cache(configDO3);
                                    }
                                    if (OLog.isPrintLog(i)) {
                                        OLog.i(TAG, "loadConfig success", configDO3);
                                    }
                                    ReportAckUtils.reportConfigAck(new ConfigAckDO(configDO3.name, configDO3.id, OrangeUtils.getCurFormatTime(), configDO3.version));
                                    return;
                                }
                            }
                            i = 2;
                            removeFail(nameSpaceDO.name);
                            removeLoading(nameSpaceDO.name);
                            OrangeMonitor.commitSuccess(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name);
                            OrangeMonitor.commitConfigMonitor(OConstant.POINT_CONFIG_UPDATE, nameSpaceDO.name, str5, configDO3.getChangeVersion());
                            if (!this.channelIndexUpdate) {
                            }
                            if (OLog.isPrintLog(i)) {
                            }
                            try {
                                ReportAckUtils.reportConfigAck(new ConfigAckDO(configDO3.name, configDO3.id, OrangeUtils.getCurFormatTime(), configDO3.version));
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        i = 2;
                        str = str6;
                        addFail(nameSpaceDO.name);
                        removeLoading(nameSpaceDO.name);
                        OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name, "0", th.getMessage());
                        Object[] objArr2222 = new Object[i];
                        objArr2222[0] = "namespace";
                        objArr2222[1] = nameSpaceDO.name;
                        OLog.e(TAG, str, th, objArr2222);
                    }
                }
                i = 2;
                if (((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue() > 0 && configDO != null && configDO.getConfigStatus() == 2) {
                    if (this.channelIndexUpdate) {
                        this.mConfigCache.cacheAndUpdateUsedNamespaceFilterToLocal(configDO);
                    } else {
                        this.mConfigCache.cache(configDO);
                    }
                }
                addFail(nameSpaceDO.name);
                removeLoading(nameSpaceDO.name);
                if (!"-200".equals(r3.getCode())) {
                    if (configDO3 != null && !configDO3.checkValid()) {
                        r3.setCode(-5);
                        r3.setMessage("config is invaild");
                    }
                    OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name, r3.getCode(), r3.getMessage());
                }
                Object[] objArr3 = new Object[6];
                objArr3[0] = "namespace";
                objArr3[1] = nameSpaceDO.name;
                objArr3[2] = "code";
                objArr3[3] = r3.getCode();
                objArr3[c] = obj;
                objArr3[5] = r3.getMessage();
                str = str6;
                try {
                    OLog.e(TAG, str, objArr3);
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                str = "loadConfig fail";
                i = 2;
                addFail(nameSpaceDO.name);
                removeLoading(nameSpaceDO.name);
                OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_CFG_RATE, nameSpaceDO.name, "0", th.getMessage());
                Object[] objArr22222 = new Object[i];
                objArr22222[0] = "namespace";
                objArr22222[1] = nameSpaceDO.name;
                OLog.e(TAG, str, th, objArr22222);
            }
        } else if (OLog.isPrintLog(3)) {
            OLog.w(TAG, "loadConfig break as is loading", "namespace", nameSpaceDO.name);
        }
    }
}
