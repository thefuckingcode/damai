package com.taobao.orange;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.orange.OConstant;
import com.taobao.orange.aidl.IOrangeApiService;
import com.taobao.orange.aidl.OrangeApiServiceStub;
import com.taobao.orange.aidl.OrangeConfigListenerStub;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.model.ConfigDO;
import com.taobao.orange.service.OrangeApiService;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.FileUtil;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeMonitor;
import com.taobao.orange.util.SPUtil;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public class OrangeConfigImpl extends OrangeConfig {
    private static final int SECONDS_IN_DAY = 86400;
    static final String TAG = "OrangeConfigImpl";
    static OrangeConfigImpl mInstance = new OrangeConfigImpl();
    private static final String orangeService = "com.taobao.orange.service.OrangeApiService";
    volatile CountDownLatch mBindServiceLock;
    final Set<String> mBlackNamespaces = new HashSet<String>() {
        /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass1 */

        {
            add("android_download_task");
            add("flow_customs_config");
            add("custom_out_config");
        }
    };
    private ServiceConnection mConnection = new ServiceConnection() {
        /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass7 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OLog.i(OrangeConfigImpl.TAG, "onServiceConnected", new Object[0]);
            OrangeConfigImpl.this.mRemoteService = IOrangeApiService.Stub.asInterface(iBinder);
            OrangeConfigImpl.this.mIsBindingService.set(false);
            if (OrangeConfigImpl.this.mBindServiceLock != null) {
                OrangeConfigImpl.this.mBindServiceLock.countDown();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            OLog.w(OrangeConfigImpl.TAG, "onServiceDisconnected", new Object[0]);
            OrangeConfigImpl.this.mRemoteService = null;
            OrangeConfigImpl.this.mIsBindingService.set(false);
            if (OrangeConfigImpl.this.mBindServiceLock != null) {
                OrangeConfigImpl.this.mBindServiceLock.countDown();
            }
        }
    };
    volatile Context mContext;
    final List<OCandidate> mFailCandidates = Collections.synchronizedList(new ArrayList());
    final Map<String, Set<OrangeConfigListenerStub>> mFailListeners = new ConcurrentHashMap();
    final Set<String> mFailNamespaces = Collections.synchronizedSet(new HashSet());
    volatile String mFailUserId = null;
    AtomicBoolean mIsBindingService = new AtomicBoolean(false);
    volatile IOrangeApiService mRemoteService;

    private OrangeConfigImpl() {
    }

    private void bindRemoteService(Context context) {
        int i;
        boolean z;
        ConfigDO configDO;
        Map<String, String> map;
        Map<String, String> map2;
        if (context != null && this.mRemoteService == null && this.mIsBindingService.compareAndSet(false, true)) {
            try {
                GlobalOrange.isChannelProcess = AndroidUtil.isTaobaoChannelProcess(context);
                OLog.e(TAG, "current process is channel", Boolean.valueOf(GlobalOrange.isChannelProcess));
                if (GlobalOrange.isChannelProcess) {
                    ConfigDO configDO2 = (ConfigDO) FileUtil.restoreObjectLocked(OConstant.PROCESS_ISOLATED_LOCAL_CONFIG);
                    if (!(configDO2 == null || (map2 = configDO2.content) == null)) {
                        String str = map2.get("processIsolated");
                        if (!TextUtils.isEmpty(str)) {
                            GlobalOrange.processIsolated = Boolean.parseBoolean(str);
                        }
                        String str2 = configDO2.content.get(OConstant.SYSKEY_PROCESS_QUERY);
                        if (!TextUtils.isEmpty(str2)) {
                            GlobalOrange.processQuery = Boolean.parseBoolean(str2);
                        }
                        String str3 = configDO2.content.get(OConstant.SYSKEY_PROCESS_QUERY_FORBID_TIME);
                        if (!TextUtils.isEmpty(str3)) {
                            GlobalOrange.processQueryForbidTime = str3;
                        }
                        String str4 = configDO2.content.get(OConstant.SYSKEY_PROCESS_QUERY_STRATEGY);
                        if (!TextUtils.isEmpty(str4)) {
                            GlobalOrange.processQueryStrategy = str4;
                        }
                        FileUtil.persistObjectLocked(configDO2, OConstant.ORANGE_LOCAL_FILE);
                    }
                } else if (!(!GlobalOrange.isMainProcess || (configDO = (ConfigDO) FileUtil.restoreObjectLocked(OConstant.ORANGE_LOCAL_FILE)) == null || (map = configDO.content) == null)) {
                    String str5 = map.get("processIsolated");
                    if (!TextUtils.isEmpty(str5)) {
                        GlobalOrange.processIsolated = Boolean.parseBoolean(str5);
                    }
                }
                if (GlobalOrange.processIsolated) {
                    OLog.i(TAG, "create local service at channel process start", new Object[0]);
                    if (GlobalOrange.isChannelProcess && !GlobalOrange.isMainProcessAlive) {
                        this.mRemoteService = new OrangeApiServiceStub(context);
                        this.mIsBindingService.set(false);
                        if (this.mBindServiceLock != null) {
                            this.mBindServiceLock.countDown();
                        }
                        OLog.i(TAG, "create local service at channel process done", new Object[0]);
                        return;
                    }
                }
                i = 0;
            } catch (Throwable th) {
                i = 0;
                OLog.e(TAG, "parse from local process isolated result failed", th.toString());
            }
            OLog.i(TAG, "bindRemoteService start", new Object[i]);
            try {
                Intent intent = new Intent(context, OrangeApiService.class);
                intent.setAction(OrangeApiService.class.getName());
                intent.addCategory("android.intent.category.DEFAULT");
                if (!context.bindService(intent, this.mConnection, 1)) {
                    OLog.e(TAG, "bindRemoteService fail", new Object[0]);
                    z = false;
                } else {
                    z = true;
                }
                OLog.i(TAG, "bindRemoteService", "serviceEnabled", Boolean.valueOf(z));
                if (!z) {
                    int intValue = GlobalOrange.isMainProcess ? ((Integer) SPUtil.getFromSharePreference(context, OConstant.SYSKEY_RECOVERY_SERVICE_STATE, 1)).intValue() : 1;
                    if (intValue == 0) {
                        recoverComponentState(context);
                    }
                    OLog.e(TAG, "recovery component", "state", Integer.valueOf(intValue));
                    OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_SERVICE_ENABLED, "bindService", OConstant.CODE_POINT_EXP_SERVICE_DISABLED, "service disabled");
                }
            } catch (Throwable th2) {
                int intValue2 = GlobalOrange.isMainProcess ? ((Integer) SPUtil.getFromSharePreference(context, OConstant.SYSKEY_RECOVERY_SERVICE_STATE, 1)).intValue() : 1;
                if (intValue2 == 0) {
                    recoverComponentState(context);
                }
                OLog.e(TAG, "recovery component", "state", Integer.valueOf(intValue2));
                OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_SERVICE_ENABLED, "bindService", OConstant.CODE_POINT_EXP_SERVICE_DISABLED, "service disabled");
                throw th2;
            }
        }
    }

    private Set<OrangeConfigListenerStub> getFailListenerStubByKey(String str) {
        Set<OrangeConfigListenerStub> set = this.mFailListeners.get(str);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.mFailListeners.put(str, hashSet);
        return hashSet;
    }

    private String getIndexQueryUrl() {
        return "http://" + OConstant.SUB_PROCESS_INDEX_QUERY_HOSTS[GlobalOrange.env.getEnvMode()] + OConstant.SUB_PROCESS_INDEX_QUERY_URL;
    }

    public static boolean isSameDay(long j, long j2, TimeZone timeZone) {
        long j3 = j - j2;
        return j3 < 86400 && j3 > -86400 && millis2Days(j, timeZone) == millis2Days(j2, timeZone);
    }

    private static long millis2Days(long j, TimeZone timeZone) {
        return (((long) timeZone.getOffset(j)) + j) / 86400;
    }

    private static void recoverComponentState(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(context.getPackageName(), orangeService);
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable th) {
            OLog.e(TAG, "try to change component state failed, component:com.taobao.orange.service.OrangeApiService", th, new Object[0]);
        }
    }

    private <T extends OBaseListener> void regCommonListener(final String[] strArr, T t, boolean z) {
        if (strArr == null || strArr.length == 0 || t == null) {
            OLog.e(TAG, "registerListener error as param null", new Object[0]);
            return;
        }
        final OrangeConfigListenerStub orangeConfigListenerStub = new OrangeConfigListenerStub(t, z);
        if (this.mRemoteService == null) {
            OLog.w(TAG, "registerListener wait", "namespaces", Arrays.asList(strArr));
            for (String str : strArr) {
                getFailListenerStubByKey(str).add(orangeConfigListenerStub);
            }
            return;
        }
        OThreadFactory.execute(new Runnable() {
            /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass6 */

            public void run() {
                OrangeConfigImpl.this.registerListener(strArr, orangeConfigListenerStub);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private void triggerIndexUpdate(int i) {
        Throwable th;
        INetConnection iNetConnection = null;
        try {
            INetConnection iNetConnection2 = (INetConnection) GlobalOrange.netConnection.newInstance();
            try {
                String indexQueryUrl = getIndexQueryUrl();
                if (TextUtils.isEmpty(indexQueryUrl)) {
                    OLog.e(TAG, "triggerIndexUpdate", "get request url failed");
                    if (iNetConnection2 != null) {
                        iNetConnection2.disconnect();
                        return;
                    }
                    return;
                }
                iNetConnection2.openConnection(indexQueryUrl);
                iNetConnection2.setMethod("GET");
                iNetConnection2.connect();
                int responseCode = iNetConnection2.getResponseCode();
                OLog.e(TAG, "triggerIndexUpdate", "send success", Integer.valueOf(responseCode));
                if (200 == responseCode) {
                    SPUtil.saveToSharePreference(GlobalOrange.context, OConstant.PROCESS_QUERY_SENT_COUNT, Integer.valueOf(i + 1));
                    SPUtil.saveToSharePreference(GlobalOrange.context, OConstant.PROCESS_QUERY_SENT_LAST_TIME_SECONDS, Long.valueOf(System.currentTimeMillis() / 1000));
                }
                iNetConnection2.disconnect();
            } catch (Throwable th2) {
                th = th2;
                iNetConnection = iNetConnection2;
                try {
                    OLog.e(TAG, "triggerIndexUpdate", "send failed", th.getMessage());
                } finally {
                    if (iNetConnection != null) {
                        iNetConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            OLog.e(TAG, "triggerIndexUpdate", "send failed", th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void trySendIndexTriggerQuery(Context context) {
        int i;
        final int i2;
        OLog.e(TAG, "processQuery ", Boolean.valueOf(GlobalOrange.processQuery));
        if (GlobalOrange.processQuery) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (!TextUtils.isEmpty(GlobalOrange.processQueryForbidTime)) {
                String[] split = GlobalOrange.processQueryForbidTime.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                long parseLong = Long.parseLong(split[0]);
                long parseLong2 = Long.parseLong(split[1]);
                if (currentTimeMillis > parseLong && currentTimeMillis < parseLong2) {
                    OLog.e(TAG, "hit query forbid time", new Object[0]);
                    return;
                }
            }
            long longValue = ((Long) SPUtil.getFromSharePreference(context, OConstant.PROCESS_QUERY_SENT_LAST_TIME_SECONDS, 0L)).longValue();
            int i3 = 1200;
            if (!TextUtils.isEmpty(GlobalOrange.processQueryStrategy)) {
                String[] split2 = GlobalOrange.processQueryStrategy.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                i3 = (int) ((Math.random() * ((double) Integer.parseInt(split2[0]))) + 1.0d);
                if (longValue > 0) {
                    long j = currentTimeMillis - longValue;
                    if (j < Long.parseLong(split2[1])) {
                        OLog.e(TAG, "last query time send too near ", Long.valueOf(j));
                        return;
                    }
                    int parseInt = Integer.parseInt(split2[2]);
                    i2 = ((Integer) SPUtil.getFromSharePreference(context, OConstant.PROCESS_QUERY_SENT_COUNT, 5)).intValue();
                    if (i2 < parseInt || !isSameDay(currentTimeMillis, longValue, TimeZone.getDefault())) {
                        i = 1;
                        Object[] objArr = new Object[i];
                        objArr[0] = Integer.valueOf(i3);
                        OLog.e(TAG, "ready to send query at delay time", objArr);
                        OThreadFactory.execute(new Runnable() {
                            /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass3 */

                            public void run() {
                                OLog.e(OrangeConfigImpl.TAG, "trigger index update", new Object[0]);
                                OrangeConfigImpl.this.triggerIndexUpdate(i2);
                            }
                        }, (long) (i3 * 1000));
                    }
                    OLog.e(TAG, "exceed sent count limit ", Integer.valueOf(i2), Integer.valueOf(parseInt));
                    return;
                }
            }
            i = 1;
            i2 = 0;
            Object[] objArr2 = new Object[i];
            objArr2[0] = Integer.valueOf(i3);
            OLog.e(TAG, "ready to send query at delay time", objArr2);
            OThreadFactory.execute(new Runnable() {
                /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass3 */

                public void run() {
                    OLog.e(OrangeConfigImpl.TAG, "trigger index update", new Object[0]);
                    OrangeConfigImpl.this.triggerIndexUpdate(i2);
                }
            }, (long) (i3 * 1000));
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void addCandidate(@NonNull OCandidate oCandidate) {
        if (oCandidate == null) {
            OLog.e(TAG, "addCandidate error as candidate is null", new Object[0]);
            return;
        }
        String key = oCandidate.getKey();
        if ("app_ver".equals(key) || OConstant.CANDIDATE_OSVER.equals(key) || OConstant.CANDIDATE_MANUFACTURER.equals(key) || OConstant.CANDIDATE_BRAND.equals(key) || OConstant.CANDIDATE_MODEL.equals(key) || "did_hash".equals(key)) {
            OLog.e(TAG, "addCandidate fail as not allow override build-in candidate", "key", key);
        } else if (this.mRemoteService != null) {
            try {
                if (GlobalOrange.isMainProcess) {
                    this.mRemoteService.addCandidate(oCandidate.getKey(), oCandidate.getClientVal(), oCandidate.getCompare());
                }
            } catch (Throwable th) {
                OLog.e(TAG, "addCandidate", th, new Object[0]);
            }
        } else if (this.mFailCandidates.add(oCandidate)) {
            OLog.w(TAG, "addCandidate wait", "candidate", oCandidate);
        }
    }

    /* access modifiers changed from: package-private */
    public void asyncGetRemoteService(Context context, boolean z) {
        if (this.mRemoteService == null) {
            bindRemoteService(context);
            if (z) {
                if (this.mBindServiceLock == null) {
                    this.mBindServiceLock = new CountDownLatch(1);
                }
                if (this.mRemoteService == null) {
                    try {
                        int i = 3;
                        if (GlobalOrange.isMainProcess) {
                            i = ((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, OConstant.SYSKEY_BIND_TIMEOUT, 3)).intValue();
                        }
                        OLog.i(TAG, "syncGetBindService bindTimeout", Integer.valueOf(i));
                        this.mBindServiceLock.await((long) i, TimeUnit.SECONDS);
                    } catch (Throwable th) {
                        OLog.e(TAG, "syncGetBindService", th, new Object[0]);
                    }
                    if (this.mRemoteService != null || context == null || !GlobalOrange.isMainProcess) {
                        OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, String.valueOf(System.currentTimeMillis() - 0), OConstant.CODE_POINT_EXP_BIND_SERVICE, "bind fail in other process");
                        return;
                    }
                    OLog.w(TAG, "syncGetBindService", "bind service timeout local stub in main process");
                    this.mRemoteService = new OrangeApiServiceStub(context);
                    OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, String.valueOf(System.currentTimeMillis() - 0), OConstant.CODE_POINT_EXP_BIND_SERVICE, "bind fail and start local stub");
                }
            }
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void enterBackground() {
        OLog.e(TAG, "enterBackground api is @Deprecated", new Object[0]);
    }

    @Override // com.taobao.orange.OrangeConfig
    public void enterForeground() {
        forceCheckUpdate();
    }

    @Override // com.taobao.orange.OrangeConfig
    public void forceCheckUpdate() {
        if (this.mRemoteService != null) {
            try {
                this.mRemoteService.forceCheckUpdate();
            } catch (Throwable th) {
                OLog.e(TAG, "forceCheckUpdate", th, new Object[0]);
            }
        } else {
            OLog.w(TAG, "forceCheckUpdate fail", new Object[0]);
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public String getConfig(@NonNull String str, @NonNull String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            OLog.e(TAG, "getConfig error as param is empty", new Object[0]);
            return str3;
        }
        asyncGetRemoteService(this.mContext, false);
        if (this.mRemoteService == null) {
            if (!this.mFailNamespaces.add(str)) {
                return str3;
            }
            OLog.w(TAG, "getConfig wait", "namespace", str);
            return str3;
        } else if (GlobalOrange.isTaobaoPackage && !GlobalOrange.isMainProcess && this.mBlackNamespaces.contains(str)) {
            return str3;
        } else {
            try {
                return this.mRemoteService.getConfig(str, str2, str3);
            } catch (Throwable th) {
                OLog.e(TAG, "getConfig", th, new Object[0]);
                return str3;
            }
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public Map<String, String> getConfigs(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            OLog.e(TAG, "getConfig error as param is empty", new Object[0]);
            return null;
        }
        asyncGetRemoteService(this.mContext, false);
        if (this.mRemoteService == null) {
            if (!this.mFailNamespaces.add(str)) {
                return null;
            }
            OLog.w(TAG, "getConfigs wait", "namespace", str);
            return null;
        } else if (GlobalOrange.isTaobaoPackage && !GlobalOrange.isMainProcess && this.mBlackNamespaces.contains(str)) {
            return null;
        } else {
            try {
                return this.mRemoteService.getConfigs(str);
            } catch (Throwable th) {
                OLog.e(TAG, "getConfigs", th, new Object[0]);
                return null;
            }
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public String getCustomConfig(@NonNull String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            OLog.e(TAG, "getCustomConfig error as param is empty", new Object[0]);
            return null;
        }
        asyncGetRemoteService(this.mContext, false);
        if (this.mRemoteService == null) {
            if (this.mFailNamespaces.add(str)) {
                OLog.w(TAG, "getCustomConfig wait", "namespace", str);
            }
        } else if (GlobalOrange.isTaobaoPackage && !GlobalOrange.isMainProcess && this.mBlackNamespaces.contains(str)) {
            return null;
        } else {
            try {
                return this.mRemoteService.getCustomConfig(str, str2);
            } catch (Throwable th) {
                OLog.e(TAG, "getCustomConfig", th, new Object[0]);
            }
        }
        return str2;
    }

    public Map<String, String> getSyncConfigs(@NonNull String str, long j) {
        final Map<String, String> configs = getConfigs(str);
        if (configs == null) {
            configs = new HashMap<>();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                OLog.e(TAG, "getSyncConfigs in main thread", "namespace", str, "timeout", Long.valueOf(j));
            } else if (OLog.isPrintLog(0)) {
                OLog.v(TAG, "getSyncConfigs", "namespace", str, "timeout", Long.valueOf(j));
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            registerListener(new String[]{str}, new OConfigListener() {
                /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass4 */

                @Override // com.taobao.orange.OConfigListener
                public void onConfigUpdate(String str, Map<String, String> map) {
                    countDownLatch.countDown();
                    configs.putAll(OrangeConfigImpl.this.getConfigs(str));
                }
            }, false);
            if (j > 0) {
                try {
                    countDownLatch.await(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    OLog.w(TAG, "getSyncConfigs", e, new Object[0]);
                }
            } else {
                countDownLatch.await();
            }
        }
        return configs;
    }

    public String getSyncCustomConfig(@NonNull String str, final String str2, long j) {
        final StringBuilder sb = new StringBuilder(str2);
        getCustomConfig(str, str2);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        registerListener(new String[]{str}, new OConfigListener() {
            /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass5 */

            @Override // com.taobao.orange.OConfigListener
            public void onConfigUpdate(String str, Map<String, String> map) {
                countDownLatch.countDown();
                sb.setLength(0);
                sb.append(OrangeConfigImpl.this.getCustomConfig(str, str2));
            }
        }, false);
        if (j > 0) {
            try {
                countDownLatch.await(j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                OLog.w(TAG, "getSyncCustomConfig", e, new Object[0]);
            }
        } else {
            countDownLatch.await();
        }
        return sb.toString();
    }

    @Override // com.taobao.orange.OrangeConfig
    public void init(@NonNull final Context context, @NonNull final OConfig oConfig) {
        if (context == null) {
            OLog.e(TAG, "init error as ctx is null", new Object[0]);
            return;
        }
        String packageName = context.getPackageName();
        GlobalOrange.isTaobaoPackage = !TextUtils.isEmpty(packageName) && packageName.equals("com.taobao.taobao");
        GlobalOrange.isMainProcess = AndroidUtil.isMainProcess(context);
        boolean z = (context.getApplicationInfo().flags & 2) != 0;
        if (z) {
            OLog.isUseTlog = false;
        } else {
            OLog.isUseTlog = true;
        }
        OLog.i(TAG, UCCore.LEGACY_EVENT_INIT, "isDebug", Boolean.valueOf(z), "isMainProcess", Boolean.valueOf(GlobalOrange.isMainProcess));
        if (TextUtils.isEmpty(oConfig.appKey) || TextUtils.isEmpty(oConfig.appVersion)) {
            OLog.e(TAG, "init error as appKey or appVersion is empty", new Object[0]);
            return;
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        GlobalOrange.context = this.mContext;
        GlobalOrange.env = OConstant.ENV.valueOf(oConfig.env);
        GlobalOrange.appKey = oConfig.appKey;
        GlobalOrange.appVersion = oConfig.appVersion;
        OThreadFactory.execute(new Runnable() {
            /* class com.taobao.orange.OrangeConfigImpl.AnonymousClass2 */

            public void run() {
                OrangeConfigImpl.this.asyncGetRemoteService(context, true);
                if (OrangeConfigImpl.this.mRemoteService != null) {
                    if (GlobalOrange.isChannelProcess && (OrangeConfigImpl.this.mRemoteService instanceof OrangeApiServiceStub)) {
                        try {
                            OrangeConfigImpl.this.sendFailItems();
                            OConfig oConfig = oConfig;
                            oConfig.time = 0;
                            oConfig.channelIndexUpdate = true;
                            OrangeConfigImpl.this.mRemoteService.init(oConfig);
                            OLog.e(OrangeConfigImpl.TAG, "init local stub on channel process", new Object[0]);
                            OrangeConfigImpl.this.trySendIndexTriggerQuery(context);
                            return;
                        } catch (Throwable th) {
                            OLog.e(OrangeConfigImpl.TAG, "int local stub failed", th.toString());
                        }
                    }
                    try {
                        OrangeConfigImpl.this.sendFailItems();
                        OrangeConfigImpl.this.mRemoteService.init(oConfig);
                    } catch (Throwable th2) {
                        OLog.e(OrangeConfigImpl.TAG, "asyncInit", th2, new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.taobao.orange.OrangeConfig
    public void registerListener(@NonNull String[] strArr, @NonNull OrangeConfigListener orangeConfigListener) {
        regCommonListener(strArr, orangeConfigListener, true);
    }

    /* access modifiers changed from: package-private */
    public void sendFailItems() {
        if (this.mRemoteService != null) {
            try {
                OLog.i(TAG, "sendFailItems start", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                if (this.mFailUserId != null) {
                    this.mRemoteService.setUserId(this.mFailUserId);
                    this.mFailUserId = null;
                }
                if (this.mFailNamespaces.size() > 0) {
                    IOrangeApiService iOrangeApiService = this.mRemoteService;
                    Set<String> set = this.mFailNamespaces;
                    iOrangeApiService.addFails((String[]) set.toArray(new String[set.size()]));
                }
                this.mFailNamespaces.clear();
                for (Map.Entry<String, Set<OrangeConfigListenerStub>> entry : this.mFailListeners.entrySet()) {
                    for (OrangeConfigListenerStub orangeConfigListenerStub : entry.getValue()) {
                        this.mRemoteService.registerListener(entry.getKey(), orangeConfigListenerStub, orangeConfigListenerStub.isAppend());
                    }
                }
                this.mFailListeners.clear();
                if (GlobalOrange.isMainProcess) {
                    for (OCandidate oCandidate : this.mFailCandidates) {
                        this.mRemoteService.addCandidate(oCandidate.getKey(), oCandidate.getClientVal(), oCandidate.getCompare());
                    }
                }
                this.mFailCandidates.clear();
                OLog.i(TAG, "sendFailItems end", "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th) {
                OLog.e(TAG, "sendFailItems", th, new Object[0]);
            }
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void setAppSecret(String str) {
        OLog.e(TAG, "setAppSecret api is @Deprecated, please set appSecret in init(OConfig config) api", new Object[0]);
    }

    @Override // com.taobao.orange.OrangeConfig
    public void setEnableDiffIndex(boolean z) {
        GlobalOrange.indexDiff = z ? 2 : 0;
    }

    @Override // com.taobao.orange.OrangeConfig
    public void setHosts(List<String> list) {
        OLog.e(TAG, "setHosts api is @Deprecated, please set probeHosts in init(OConfig config) api", new Object[0]);
    }

    @Override // com.taobao.orange.OrangeConfig
    public void setIndexUpdateMode(int i) {
        OLog.e(TAG, "setIndexUpdateMode api is @Deprecated, please set indexUpdateMode in init(OConfig config) api", new Object[0]);
    }

    @Override // com.taobao.orange.OrangeConfig
    public void setUserId(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mRemoteService == null) {
            this.mFailUserId = str;
            return;
        }
        try {
            this.mRemoteService.setUserId(str);
        } catch (Throwable th) {
            OLog.e(TAG, "setUserId", th, new Object[0]);
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void unregisterListener(@NonNull String[] strArr, OrangeConfigListenerV1 orangeConfigListenerV1) {
        if (strArr == null || strArr.length == 0 || orangeConfigListenerV1 == null) {
            OLog.e(TAG, "unregisterListenerV1 error as param null", new Object[0]);
        } else if (this.mRemoteService != null) {
            try {
                for (String str : strArr) {
                    this.mRemoteService.unregisterListener(str, new OrangeConfigListenerStub(orangeConfigListenerV1));
                }
            } catch (Throwable th) {
                OLog.e(TAG, "unregisterListenerV1", th, new Object[0]);
            }
        } else {
            OLog.w(TAG, "unregisterListenerV1 fail", new Object[0]);
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void registerListener(@NonNull String[] strArr, @NonNull OrangeConfigListenerV1 orangeConfigListenerV1) {
        regCommonListener(strArr, orangeConfigListenerV1, true);
    }

    @Override // com.taobao.orange.OrangeConfig
    public void registerListener(@NonNull String[] strArr, @NonNull OConfigListener oConfigListener, boolean z) {
        regCommonListener(strArr, oConfigListener, z);
    }

    /* access modifiers changed from: package-private */
    public void registerListener(String[] strArr, OrangeConfigListenerStub orangeConfigListenerStub) {
        if (!(this.mRemoteService == null || strArr == null || strArr.length == 0 || orangeConfigListenerStub == null)) {
            for (String str : strArr) {
                try {
                    this.mRemoteService.registerListener(str, orangeConfigListenerStub, orangeConfigListenerStub.isAppend());
                } catch (Throwable th) {
                    OLog.w(TAG, "registerListener", th, new Object[0]);
                }
            }
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void unregisterListener(@NonNull String[] strArr, OConfigListener oConfigListener) {
        if (strArr == null || strArr.length == 0 || oConfigListener == null) {
            OLog.e(TAG, "unregisterListener error as param null", new Object[0]);
        } else if (this.mRemoteService != null) {
            try {
                for (String str : strArr) {
                    this.mRemoteService.unregisterListener(str, new OrangeConfigListenerStub(oConfigListener));
                }
            } catch (Throwable th) {
                OLog.e(TAG, "unregisterListener", th, new Object[0]);
            }
        } else {
            OLog.w(TAG, "unregisterListener fail", new Object[0]);
        }
    }

    @Override // com.taobao.orange.OrangeConfig
    public void unregisterListener(@NonNull String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            OLog.e(TAG, "unregisterListeners error as namespaces is null", new Object[0]);
        } else if (this.mRemoteService != null) {
            try {
                for (String str : strArr) {
                    this.mRemoteService.unregisterListeners(str);
                }
            } catch (Throwable th) {
                OLog.e(TAG, "unregisterListeners", th, new Object[0]);
            }
        } else {
            OLog.w(TAG, "unregisterListeners fail", new Object[0]);
        }
    }
}
