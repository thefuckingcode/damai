package android.taobao.windvane.config;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Looper;
import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.monitor.WVConfigMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HttpHeaderConstant;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class WVConfigManager {
    public static final String CONFIGNAME_COMMON = "common";
    public static final String CONFIGNAME_COOKIE = "cookie_black_list";
    public static final String CONFIGNAME_CUSTOM = "customs";
    public static final String CONFIGNAME_DOMAIN = "domain";
    public static final String CONFIGNAME_LOCALE = "locale";
    public static final String CONFIGNAME_MONITOR = "monitor";
    public static final String CONFIGNAME_PACKAGE = "package";
    public static final String CONFIGNAME_PREFIXES = "prefixes";
    public static final String CONFIGNAME_URL_CONFIG = "url_config";
    public static final String CONFIG_UPDATETIME = "_updateTime";
    public static final String CONFIG_UPLOADDATA = "_uploadData";
    private static final String DEFAULT_DEMAIN = "https://wvcfg.alicdn.com/";
    public static final String SPNAME_CONFIG = "wv_main_config";
    private static final String TAG = "WVConfigManager";
    private static volatile WVConfigManager instance = null;
    public static boolean launch = EnvUtil.isTaobao();
    private static long updateInterval = 300000;
    private static long updateIntervalServer = 300000;
    private static long updateTime;
    private String configDomain;
    private boolean enableUpdateConfig;
    private ConcurrentHashMap<String, WVConfigHandler> mConfigMap;
    private ConcurrentHashMap<String, IConfig> mOtherConfigMap;
    private int updateConfigCount;

    /* access modifiers changed from: package-private */
    /* renamed from: android.taobao.windvane.config.WVConfigManager$5  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$android$taobao$windvane$config$EnvEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[EnvEnum.values().length];
            $SwitchMap$android$taobao$windvane$config$EnvEnum = iArr;
            iArr[EnvEnum.ONLINE.ordinal()] = 1;
            $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.PRE.ordinal()] = 2;
            try {
                $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.DAILY.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum WVConfigUpdateFromType {
        WVConfigUpdateFromTypeCustom,
        WVConfigUpdateFromTypeActive,
        WVConfigUpdateFromTypeFinish,
        WVConfigUpdateFromTypePush,
        WVConfigUpdateFromTypeLaunch,
        WVConfigUpdateFromTypeAppActive,
        WVConfigUpdateFromTypeLocaleChange,
        WVConfigUpdateFromZCache3_0
    }

    /* compiled from: Taobao */
    public static class WVPageEventListener implements WVEventListener {
        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            IWVWebView iWVWebView;
            if (i != 3002 && i != 1002) {
                return null;
            }
            if (WVConfigManager.launch && wVEventContext != null && (iWVWebView = wVEventContext.webView) != null && (iWVWebView._getContext() instanceof Activity) && !wVEventContext.webView._getContext().getClass().getSimpleName().equals("MainActivity3")) {
                WVConfigManager.launch = false;
            }
            if (i == 3002) {
                WVConfigManager.instance.updateConfig(WVConfigUpdateFromType.WVConfigUpdateFromTypeActive);
                return null;
            }
            WVConfigManager.instance.updateConfig(WVConfigUpdateFromType.WVConfigUpdateFromTypeFinish);
            return null;
        }
    }

    private WVConfigManager() {
        this.configDomain = DEFAULT_DEMAIN;
        this.updateConfigCount = 0;
        this.mConfigMap = null;
        this.enableUpdateConfig = true;
        this.mConfigMap = new ConcurrentHashMap<>();
        this.mOtherConfigMap = new ConcurrentHashMap<>();
        WVEventService.getInstance().addEventListener(new WVPageEventListener());
    }

    static /* synthetic */ int access$404(WVConfigManager wVConfigManager) {
        int i = wVConfigManager.updateConfigCount + 1;
        wVConfigManager.updateConfigCount = i;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doUpdateByKey(final String str, final String str2, String str3, final WVConfigUpdateFromType wVConfigUpdateFromType) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!"3".equals(GlobalConfig.zType) || wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromZCache3_0) {
                if (TextUtils.isEmpty(str3)) {
                    try {
                        z = WVConfigUtils.isNeedUpdate(str2, str);
                    } catch (Exception unused) {
                        z = false;
                    }
                } else {
                    z = true;
                }
                if ("3".equals(GlobalConfig.zType)) {
                    z = true;
                }
                TaoLog.i(TAG, "update key=[" + str + "],needUpdate=[" + z + jl1.ARRAY_END_STR);
                if (wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange) {
                    z = true;
                }
                if (z) {
                    final WVConfigHandler wVConfigHandler = this.mConfigMap.get(str);
                    if (wVConfigHandler != null) {
                        if (!wVConfigHandler.getUpdateStatus() || System.currentTimeMillis() - updateTime >= updateInterval) {
                            wVConfigHandler.setUpdateStatus(true);
                            wVConfigHandler.setSnapshotN(str2);
                            final long currentTimeMillis = System.currentTimeMillis();
                            wVConfigHandler.update(str3, new WVConfigUpdateCallback() {
                                /* class android.taobao.windvane.config.WVConfigManager.AnonymousClass4 */

                                @Override // android.taobao.windvane.config.WVConfigUpdateCallback
                                public void updateError(String str, String str2) {
                                    WVConfigMonitorInterface configMonitor = WVMonitorService.getConfigMonitor();
                                    if (configMonitor != null) {
                                        String str3 = str;
                                        configMonitor.didOccurUpdateConfigError(str3, 7, str + ":" + str2);
                                    }
                                }

                                @Override // android.taobao.windvane.config.WVConfigUpdateCallback
                                public void updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS config_update_status, int i) {
                                    wVConfigHandler.setUpdateStatus(false);
                                    WVConfigManager.access$404(WVConfigManager.this);
                                    if (WVConfigManager.this.updateConfigCount >= WVConfigManager.this.mConfigMap.size()) {
                                        WVConfigManager.this.updateConfigCount = 0;
                                        WVEventService.getInstance().onEvent(6002);
                                    }
                                    if (str.equals("common") || str.equals("domain") || str.equals("monitor") || !"3".equals(GlobalConfig.zType)) {
                                        boolean equals = WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.SUCCESS.equals(config_update_status);
                                        WVConfigMonitorInterface configMonitor = WVMonitorService.getConfigMonitor();
                                        if (equals) {
                                            ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, str, str2);
                                            if (configMonitor != null) {
                                                configMonitor.didOccurUpdateConfigSuccess(str);
                                            }
                                        } else if (configMonitor != null && !config_update_status.equals(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR)) {
                                            String str = str;
                                            int ordinal = config_update_status.ordinal();
                                            configMonitor.didOccurUpdateConfigError(str, ordinal, str + ":" + str2 + ":" + config_update_status);
                                        }
                                        if (configMonitor != null) {
                                            WVMonitorService.getConfigMonitor().didUpdateConfig(str, wVConfigUpdateFromType.ordinal(), System.currentTimeMillis() - currentTimeMillis, equals ? 1 : 0, i);
                                        }
                                    }
                                    TaoLog.i(WVConfigManager.TAG, "isUpdateSuccess " + str + " : " + config_update_status);
                                }
                            });
                        } else {
                            return;
                        }
                    }
                } else {
                    this.updateConfigCount++;
                }
                if (this.updateConfigCount >= this.mConfigMap.size()) {
                    this.updateConfigCount = 0;
                    WVEventService.getInstance().onEvent(6002);
                }
            }
        }
    }

    public static WVConfigManager getInstance() {
        if (instance == null) {
            synchronized (WVConfigManager.class) {
                if (instance == null) {
                    instance = new WVConfigManager();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateImmediately(final WVConfigUpdateFromType wVConfigUpdateFromType) {
        if (this.enableUpdateConfig && WVConfigUtils.checkAppKeyAvailable()) {
            final long currentTimeMillis = System.currentTimeMillis();
            ConnectManager.getInstance().connectSync(getConfigUrl("0", "0", WVConfigUtils.getTargetValue(), "0"), new HttpConnectListener<HttpResponse>() {
                /* class android.taobao.windvane.config.WVConfigManager.AnonymousClass1 */

                @Override // android.taobao.windvane.connect.HttpConnectListener
                public void onError(int i, String str) {
                    TaoLog.d(WVConfigManager.TAG, "update entry failed! : " + str);
                    if (WVMonitorService.getConfigMonitor() != null) {
                        WVMonitorService.getConfigMonitor().didOccurUpdateConfigError("entry-NoNetwork", WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR.ordinal(), str);
                    }
                    super.onError(i, str);
                }

                public void onFinish(HttpResponse httpResponse, int i) {
                    int i2;
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    if (httpResponse != null) {
                        try {
                            String str = new String(httpResponse.getData(), "utf-8");
                            ApiResponse apiResponse = new ApiResponse();
                            JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
                            if (WVMonitorService.getPackageMonitorInterface() != null) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                Map<String, String> headers = httpResponse.getHeaders();
                                if (headers != null) {
                                    String str2 = headers.get("Age");
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = headers.get("age");
                                    }
                                    String str3 = headers.get(HttpHeaderConstant.DATE);
                                    if (TextUtils.isEmpty(str3)) {
                                        str3 = headers.get("date");
                                    }
                                    long longValue = !TextUtils.isEmpty(str2) ? Long.valueOf(str2).longValue() * 1000 : 0;
                                    if (!TextUtils.isEmpty(str3)) {
                                        longValue += CommonUtils.parseDate(str3);
                                    }
                                    if (longValue != 0) {
                                        long j = currentTimeMillis2 - longValue;
                                        TaoLog.i(WVConfigManager.TAG, "updateDiffTime by config : " + j);
                                        WVMonitorService.getPackageMonitorInterface().uploadDiffTimeTime(j);
                                    }
                                }
                            }
                            boolean needFull = WVLocaleConfig.getInstance().needFull();
                            WVConfigUpdateFromType wVConfigUpdateFromType = wVConfigUpdateFromType;
                            if (needFull) {
                                wVConfigUpdateFromType = WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange;
                                WVPackageAppService.getWvPackageAppConfig().requestFullConfigNextTime();
                            }
                            if (!(jSONObject == null || WVConfigManager.this.mConfigMap == null)) {
                                Enumeration keys = WVConfigManager.this.mConfigMap.keys();
                                while (keys.hasMoreElements()) {
                                    String str4 = (String) keys.nextElement();
                                    WVConfigManager.this.doUpdateByKey(str4, jSONObject.optString(str4, "0"), null, wVConfigUpdateFromType);
                                }
                                if (WVMonitorService.getConfigMonitor() != null) {
                                    WVMonitorService.getConfigMonitor().didOccurUpdateConfigSuccess("entry");
                                }
                            }
                            WVEventService.getInstance().onEvent(7001);
                            i2 = 1;
                        } catch (Exception e) {
                            if (WVMonitorService.getConfigMonitor() != null) {
                                WVConfigMonitorInterface configMonitor = WVMonitorService.getConfigMonitor();
                                int ordinal = WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR.ordinal();
                                configMonitor.didOccurUpdateConfigError("entry", ordinal, "update entry error : " + e.getMessage());
                            }
                            TaoLog.d(WVConfigManager.TAG, "updateImmediately failed!");
                            i2 = 0;
                        }
                        if (WVMonitorService.getConfigMonitor() != null) {
                            WVMonitorService.getConfigMonitor().didUpdateConfig("entry", wVConfigUpdateFromType.ordinal(), currentTimeMillis, i2, WVConfigManager.this.mConfigMap.size());
                        }
                    }
                }
            });
        }
    }

    public boolean checkIfUpdate(WVConfigUpdateFromType wVConfigUpdateFromType) {
        int i = 0;
        if ("3".equals(GlobalConfig.zType) && wVConfigUpdateFromType != WVConfigUpdateFromType.WVConfigUpdateFromZCache3_0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeAppActive || wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange || currentTimeMillis - updateTime > updateInterval;
        if (z && WVConfigUtils.checkAppKeyAvailable()) {
            updateTime = currentTimeMillis;
        }
        if (WVConfigUtils.checkAppKeyAvailable()) {
            String format = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA).format(Calendar.getInstance().getTime());
            String stringVal = ConfigStorage.getStringVal(SPNAME_CONFIG, "package_uploadData", "0");
            TaoLog.d("WVConfigManager.updateConfig ==> ", "uploadDate = " + stringVal);
            if (!format.equals(stringVal) && WVCommonConfig.commonConfig.monitoredApps.length != 0) {
                StringBuilder sb = new StringBuilder();
                Map<String, ZipAppInfo> appsTable = WVPackageAppService.getWvPackageAppConfig().getGlobalConfig().getAppsTable();
                while (true) {
                    WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
                    String[] strArr = wVCommonConfigData.monitoredApps;
                    if (i >= strArr.length) {
                        break;
                    }
                    ZipAppInfo zipAppInfo = appsTable.get(strArr[i]);
                    if (zipAppInfo != null && zipAppInfo.isAppInstalled()) {
                        sb.append(zipAppInfo.name);
                        sb.append("-");
                        sb.append(zipAppInfo.installedSeq);
                        if (i != wVCommonConfigData.monitoredApps.length - 1) {
                            sb.append(",");
                        }
                    }
                    i++;
                }
                if (WVMonitorService.getPackageMonitorInterface() != null) {
                    WVMonitorService.getPackageMonitorInterface().commitZCacheDiurnalOverview(sb.toString());
                }
                ConfigStorage.putStringVal(SPNAME_CONFIG, "package_uploadData", format);
            }
        }
        return z;
    }

    public String configDomainByEnv() {
        int i = AnonymousClass5.$SwitchMap$android$taobao$windvane$config$EnvEnum[GlobalConfig.env.ordinal()];
        if (i != 2) {
            return i != 3 ? "https://wvcfg.alicdn.com" : "https://h5.waptest.taobao.com";
        }
        return "http://h5.wapa.taobao.com";
    }

    public String getConfigUrl(String str, String str2, String str3, String str4) {
        char charAt;
        String str5 = WVLocaleConfig.getInstance().mCurrentLocale;
        StringBuilder sb = new StringBuilder();
        if (!DEFAULT_DEMAIN.equals(this.configDomain)) {
            sb.append(this.configDomain);
        } else {
            sb.append(configDomainByEnv());
        }
        sb.append("/bizcache/5/windvane/");
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        sb.append("-");
        sb.append(str4);
        sb.append("/");
        sb.append(GlobalConfig.getInstance().getAppKey());
        sb.append("-");
        sb.append(WVConfigUtils.dealAppVersion());
        if (str5 != null) {
            sb.append("-");
            sb.append(str5);
        }
        sb.append("/");
        if (str3 == null && ('a' > (charAt = (str3 = ConfigStorage.getStringVal(SPNAME_CONFIG, "abt", "a")).charAt(0)) || charAt > 'c')) {
            str3 = "a";
        }
        sb.append(str3);
        sb.append("/settings.json");
        TaoLog.w("CONFIG_URL", sb.toString());
        return sb.toString();
    }

    public HashMap getConfigVersions() {
        HashMap hashMap = new HashMap();
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null) {
            Enumeration<String> keys = concurrentHashMap.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                String stringVal = ConfigStorage.getStringVal(SPNAME_CONFIG, nextElement, "0");
                if (!stringVal.contains(".")) {
                    Long valueOf = Long.valueOf(Long.parseLong(stringVal));
                    if (valueOf.longValue() == 0) {
                        stringVal = "NO VERSION";
                    } else if (valueOf.longValue() == AbsPerformance.LONG_NIL) {
                        stringVal = "CUSTOM VERION";
                    }
                }
                hashMap.put(nextElement, stringVal);
            }
        }
        return hashMap;
    }

    public WVConfigHandler registedHandler(String str) {
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public void registerConfigImpl(String str, IConfig iConfig) {
        this.mOtherConfigMap.put(str, iConfig);
    }

    public void registerHandler(String str, WVConfigHandler wVConfigHandler) {
        this.mConfigMap.put(str, wVConfigHandler);
    }

    public void removeHandler(String str) {
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
        }
    }

    public void resetConfig() {
        ConcurrentHashMap<String, WVConfigHandler> concurrentHashMap = this.mConfigMap;
        if (concurrentHashMap != null) {
            Enumeration<String> keys = concurrentHashMap.keys();
            while (keys.hasMoreElements()) {
                ConfigStorage.putStringVal(SPNAME_CONFIG, keys.nextElement(), "0");
            }
        }
        updateTime = 0;
    }

    public void setConfigDomain(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.configDomain = str;
        }
        TaoLog.w(TAG, "changeConfigDomain : " + str);
    }

    public void setUpdateConfigEnable(boolean z) {
        this.enableUpdateConfig = z;
    }

    public void setUpdateInterval(long j) {
        updateIntervalServer = j;
    }

    @TargetApi(11)
    public void updateConfig(final WVConfigUpdateFromType wVConfigUpdateFromType) {
        boolean z;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            if ("2".equals(GlobalConfig.zType)) {
                z = wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeAppActive || wVConfigUpdateFromType == WVConfigUpdateFromType.WVConfigUpdateFromTypeLocaleChange || currentTimeMillis - updateTime > updateInterval;
                if (z) {
                    TaoLog.i("ZCache", "update config zcache 2.0");
                }
            } else if (wVConfigUpdateFromType != WVConfigUpdateFromType.WVConfigUpdateFromZCache3_0) {
                TaoLog.i("ZCache", "skip update config, updateType=[" + wVConfigUpdateFromType.name() + jl1.ARRAY_END_STR);
                return;
            } else {
                TaoLog.i("ZCache", "update config zcache 3.0");
                z = true;
            }
            if (z && WVConfigUtils.checkAppKeyAvailable()) {
                updateTime = currentTimeMillis;
                if (launch) {
                    updateInterval = 30000;
                } else {
                    updateInterval = updateIntervalServer;
                }
                TaoLog.i(TAG, "updateInterval=[" + updateInterval + jl1.ARRAY_END_STR);
                AsyncTask.execute(new Runnable() {
                    /* class android.taobao.windvane.config.WVConfigManager.AnonymousClass2 */

                    public void run() {
                        WVConfigManager.this.updateImmediately(wVConfigUpdateFromType);
                    }
                });
            }
            if (WVConfigUtils.checkAppKeyAvailable()) {
                String format = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA).format(Calendar.getInstance().getTime());
                String stringVal = ConfigStorage.getStringVal(SPNAME_CONFIG, "package_uploadData", "0");
                TaoLog.d("WVConfigManager.updateConfig ==> ", "uploadDate = " + stringVal);
                if (!format.equals(stringVal) && WVCommonConfig.commonConfig.monitoredApps.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    Map<String, ZipAppInfo> appsTable = WVPackageAppService.getWvPackageAppConfig().getGlobalConfig().getAppsTable();
                    while (true) {
                        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
                        String[] strArr = wVCommonConfigData.monitoredApps;
                        if (i >= strArr.length) {
                            break;
                        }
                        ZipAppInfo zipAppInfo = appsTable.get(strArr[i]);
                        if (zipAppInfo != null && zipAppInfo.isAppInstalled()) {
                            sb.append(zipAppInfo.name);
                            sb.append("-");
                            sb.append(zipAppInfo.installedSeq);
                            if (i != wVCommonConfigData.monitoredApps.length - 1) {
                                sb.append(",");
                            }
                        }
                        i++;
                    }
                    if (WVMonitorService.getPackageMonitorInterface() != null) {
                        WVMonitorService.getPackageMonitorInterface().commitZCacheDiurnalOverview(sb.toString());
                    }
                    ConfigStorage.putStringVal(SPNAME_CONFIG, "package_uploadData", format);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateConfigByKey(String str, String str2) {
        IConfig iConfig = this.mOtherConfigMap.get(str);
        if (iConfig != null) {
            iConfig.setConfig(str2);
        }
    }

    public void updateConfig(final String str, final String str2, final String str3, final WVConfigUpdateFromType wVConfigUpdateFromType) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                WVThreadPool.getInstance().execute(new Runnable() {
                    /* class android.taobao.windvane.config.WVConfigManager.AnonymousClass3 */

                    public void run() {
                        WVConfigManager.this.doUpdateByKey(str, str2, str3, wVConfigUpdateFromType);
                    }
                });
            } else {
                doUpdateByKey(str, str2, str3, wVConfigUpdateFromType);
            }
        }
    }
}
