package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.Env;
import com.tencent.stat.common.SdkProtection;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.AdditionEvent;
import com.tencent.stat.event.CustomEvent;
import com.tencent.stat.event.ErrorEvent;
import com.tencent.stat.event.Event;
import com.tencent.stat.event.EventType;
import com.tencent.stat.event.MonitorStatEvent;
import com.tencent.stat.event.PageView;
import com.tencent.stat.event.SessionEnv;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class StatService {
    public static final /* synthetic */ int a = 0;
    private static boolean firstSession = true;
    private static Handler handler;
    private static volatile long lastActivityTimestamp = 0;
    private static volatile String lastReferPageId = "";
    private static volatile String last_pageId = "";
    private static StatLogger logger = StatCommonHelper.getLogger();
    private static volatile long nextDayStartTimestamp = 0;
    private static Thread.UncaughtExceptionHandler originalExceptionHandler = null;
    private static volatile int sessionId = 0;
    private static Map<CustomEvent.Key, Long> timedEventMap = new WeakHashMap();
    private static Map<String, Long> timedPageEventMap = new WeakHashMap();

    /* renamed from: com.tencent.stat.StatService$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$stat$StatReportStrategy;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[StatReportStrategy.values().length];
            $SwitchMap$com$tencent$stat$StatReportStrategy = iArr;
            iArr[StatReportStrategy.INSTANT.ordinal()] = 1;
            $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.ONLY_WIFI.ordinal()] = 2;
            $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
            $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.DEVELOPER.ordinal()] = 4;
            $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.BATCH.ordinal()] = 5;
            $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.PERIOD.ordinal()] = 6;
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class StatTask implements Runnable {
        private Event ev;
        private StatReportStrategy strategy = null;

        public StatTask(Event event) {
            this.ev = event;
            this.strategy = StatConfig.getStatSendStrategy();
        }

        private void sendEvents() {
            if (StatStore.getInstance().getNumStoredEvents() > 0) {
                StatStore.getInstance().storeEvent(this.ev, null);
                StatStore.getInstance().loadEvents(-1);
                return;
            }
            sendEventsNow(true);
        }

        private void sendEventsNow(boolean z) {
            StatDispatcher.getInstance().send(this.ev, z ? new StatDispatchCallback() {
                /* class com.tencent.stat.StatService.StatTask.AnonymousClass1 */

                @Override // com.tencent.stat.StatDispatchCallback
                public void onDispatchFailure() {
                    StatStore.getInstance().storeEvent(StatTask.this.ev, null);
                }

                @Override // com.tencent.stat.StatDispatchCallback
                public void onDispatchSuccess() {
                    StatStore.getInstance().loadEvents(-1);
                }
            } : null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0162, code lost:
            if (com.tencent.stat.common.StatCommonHelper.isWiFiActive(r0) != false) goto L_0x0164;
         */
        public void run() {
            Event event;
            StatStore statStore;
            if (StatConfig.isEnableStatService()) {
                if (this.ev.getType() == EventType.ERROR || this.ev.toJsonString().length() <= StatConfig.getMaxReportEventLength()) {
                    if (StatConfig.getMaxSessionStatReportCount() > 0) {
                        if (StatConfig.getCurSessionStatReportCount() >= StatConfig.getMaxSessionStatReportCount()) {
                            StatService.logger.e("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
                            return;
                        }
                        StatConfig.incCurSessionStatReportCount();
                    }
                    StatLogger statLogger = StatService.logger;
                    statLogger.i("Lauch stat task in thread:" + Thread.currentThread().getName());
                    Context context = this.ev.getContext();
                    AnonymousClass2 r2 = null;
                    if (!StatCommonHelper.isNetworkAvailable(context)) {
                        StatStore.getInstance(context).storeEvent(this.ev, null);
                        return;
                    }
                    if (StatConfig.isEnableSmartReporting() && this.strategy != StatReportStrategy.ONLY_WIFI_NO_CACHE && StatCommonHelper.isWifiNet(context)) {
                        this.strategy = StatReportStrategy.INSTANT;
                    }
                    switch (AnonymousClass2.$SwitchMap$com$tencent$stat$StatReportStrategy[this.strategy.ordinal()]) {
                        case 1:
                            sendEvents();
                            return;
                        case 2:
                            break;
                        case 3:
                        case 4:
                            statStore = StatStore.getInstance(context);
                            event = this.ev;
                            statStore.storeEvent(event, r2);
                            return;
                        case 5:
                            if (StatStore.getInstance(this.ev.getContext()) != null) {
                                statStore = StatStore.getInstance(context);
                                event = this.ev;
                                r2 = new StatDispatchCallback() {
                                    /* class com.tencent.stat.StatService.StatTask.AnonymousClass2 */

                                    @Override // com.tencent.stat.StatDispatchCallback
                                    public void onDispatchFailure() {
                                    }

                                    @Override // com.tencent.stat.StatDispatchCallback
                                    public void onDispatchSuccess() {
                                        if (StatStore.getInstance().getNumStoredEvents() >= StatConfig.getMaxBatchReportCount()) {
                                            StatStore.getInstance().loadEvents(StatConfig.getMaxBatchReportCount());
                                        }
                                    }
                                };
                                statStore.storeEvent(event, r2);
                                return;
                            }
                            return;
                        case 6:
                            try {
                                StatStore.getInstance(context).storeEvent(this.ev, null);
                                Long valueOf = Long.valueOf(StatPreferences.getLong(context, "last_period_ts", 0));
                                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                                if (Long.valueOf(Long.valueOf(valueOf2.longValue() - valueOf.longValue()).longValue() / DateUtils.MILLIS_PER_MINUTE).longValue() > ((long) StatConfig.getSendPeriodMinutes())) {
                                    StatStore.getInstance(context).loadEvents(-1);
                                    StatPreferences.putLong(context, "last_period_ts", valueOf2.longValue());
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                StatService.logger.e(e);
                                return;
                            }
                        case 7:
                            if (StatCommonHelper.isWiFiActive(context)) {
                                sendEventsNow(false);
                                return;
                            }
                            return;
                        default:
                            StatLogger statLogger2 = StatService.logger;
                            statLogger2.error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
                            return;
                    }
                } else {
                    StatLogger statLogger3 = StatService.logger;
                    statLogger3.e("Event length exceed StatConfig.getMaxReportEventLength(): " + StatConfig.getMaxReportEventLength());
                }
            }
        }
    }

    public static void commitEvents(Context context, int i) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str = "The Context of StatService.commitEvents() can not be null!";
            } else if (i < -1 || i == 0) {
                statLogger = logger;
                str = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            } else {
                try {
                    StatStore.getInstance(context).loadEvents(i);
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str);
        }
    }

    static JSONObject getEncodeConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i = StatConfig.sdkCfg.version;
            if (i != 0) {
                jSONObject2.put("v", i);
            }
            jSONObject.put(Integer.toString(StatConfig.sdkCfg.type), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            int i2 = StatConfig.userCfg.version;
            if (i2 != 0) {
                jSONObject3.put("v", i2);
            }
            jSONObject.put(Integer.toString(StatConfig.userCfg.type), jSONObject3);
        } catch (JSONException e) {
            logger.e((Exception) e);
        }
        return jSONObject;
    }

    private static Handler getHandler(Context context) {
        init(context);
        return handler;
    }

    static int getSessionID(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        boolean z3 = z && currentTimeMillis - lastActivityTimestamp >= ((long) StatConfig.getSessionTimoutMillis());
        lastActivityTimestamp = currentTimeMillis;
        if (nextDayStartTimestamp == 0) {
            nextDayStartTimestamp = StatCommonHelper.getTomorrowStartMilliseconds();
        }
        if (currentTimeMillis >= nextDayStartTimestamp) {
            nextDayStartTimestamp = StatCommonHelper.getTomorrowStartMilliseconds();
            if (StatStore.getInstance(context).getUser(context).getType() != 1) {
                StatStore.getInstance(context).getUser(context).setType(1);
            }
            StatConfig.setCurrentDaySessionNumbers(0);
            z3 = true;
        }
        if (!firstSession) {
            z2 = z3;
        }
        if (z2) {
            if (StatConfig.getCurrentDaySessionNumbers() < StatConfig.getMaxDaySessionNumbers()) {
                sendNewSessionEnv(context);
            } else {
                logger.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (firstSession) {
            SdkProtection.endCheck(context);
            firstSession = false;
        }
        return sessionId;
    }

    static void init(Context context) {
        if (context == null || handler != null || !isServiceStatActive(context)) {
            return;
        }
        if (!SdkProtection.beginCheck(context)) {
            logger.error("ooh, Compatibility problem was found in this device!");
            logger.error("If you are on debug mode, please delete apk and try again.");
            StatConfig.setEnableStatService(false);
            return;
        }
        StatStore.getInstance(context);
        HandlerThread handlerThread = new HandlerThread("StatService");
        handlerThread.start();
        StatDispatcher.setApplicationContext(context);
        handler = new Handler(handlerThread.getLooper());
        originalExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (StatConfig.isAutoExceptionCaught()) {
            final Context applicationContext = context.getApplicationContext();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class com.tencent.stat.StatService.AnonymousClass1 */

                public void uncaughtException(Thread thread, Throwable th) {
                    if (StatConfig.isEnableStatService()) {
                        StatStore instance = StatStore.getInstance(applicationContext);
                        Context context = applicationContext;
                        instance.storeEvent(new ErrorEvent(context, StatService.getSessionID(context, false), 2, th), null);
                        StatService.logger.debug("MTA has caught the following uncaught exception:");
                        StatService.logger.error(th);
                        if (StatService.originalExceptionHandler != null) {
                            StatService.logger.debug("Call the original uncaught exception handler.");
                            StatService.originalExceptionHandler.uncaughtException(thread, th);
                            return;
                        }
                        StatService.logger.debug("Original uncaught exception handler not set.");
                    }
                }
            });
        } else {
            logger.warn("MTA SDK AutoExceptionCaught is disable");
        }
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH && StatCommonHelper.isNetworkAvailable(context)) {
            StatStore.getInstance(context).loadEvents(-1);
        }
        logger.d("Init MTA StatService success.");
    }

    static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    static boolean isServiceStatActive(Context context) {
        if (StatCommonHelper.getSDKLongVersion("1.0.0") > StatPreferences.getLong(context, StatConfig.HIBERNATE, 0)) {
            return true;
        }
        StatConfig.setEnableStatService(false);
        return false;
    }

    public static void onPause(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.onPause() can not be null!");
                return;
            }
            try {
                String activityName = StatCommonHelper.getActivityName(context);
                Long remove = timedPageEventMap.remove(activityName);
                if (remove != null) {
                    Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                    if (valueOf.longValue() == 0) {
                        valueOf = 1L;
                    }
                    if (lastReferPageId.equals(activityName)) {
                        lastReferPageId = "-";
                    }
                    PageView pageView = new PageView(context, lastReferPageId, getSessionID(context, false), valueOf);
                    if (!pageView.getPageId().equals(last_pageId)) {
                        logger.warn("Invalid invocation since previous onResume on diff page.");
                    }
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(pageView));
                    }
                    lastReferPageId = activityName;
                    return;
                }
                StatLogger statLogger = logger;
                statLogger.e("Starttime for PageID:" + activityName + " not found, lost onResume()?");
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    public static void onResume(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.onResume() can not be null!");
                return;
            }
            try {
                if (timedPageEventMap.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    StatLogger statLogger = logger;
                    statLogger.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    return;
                }
                last_pageId = StatCommonHelper.getActivityName(context);
                if (last_pageId != null) {
                    if (timedPageEventMap.containsKey(last_pageId)) {
                        StatLogger statLogger2 = logger;
                        statLogger2.e("Duplicate PageID : " + last_pageId + ", onResume() repeated?");
                        return;
                    }
                    timedPageEventMap.put(last_pageId, Long.valueOf(System.currentTimeMillis()));
                    getSessionID(context, true);
                }
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str = "The Context of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor == null) {
                statLogger = logger;
                str = "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor.getInterfaceName() == null) {
                statLogger = logger;
                str = "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!";
            } else {
                try {
                    MonitorStatEvent monitorStatEvent = new MonitorStatEvent(context, getSessionID(context, false), statAppMonitor);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(monitorStatEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str);
        }
    }

    public static void reportError(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.reportError() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "Error message in StatService.reportError() is empty.";
            } else {
                try {
                    ErrorEvent errorEvent = new ErrorEvent(context, getSessionID(context, false), str);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(errorEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }

    public static void reportException(Context context, Throwable th) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str = "The Context of StatService.reportException() can not be null!";
            } else if (th == null) {
                statLogger = logger;
                str = "The Throwable error message of StatService.reportException() can not be null!";
            } else {
                ErrorEvent errorEvent = new ErrorEvent(context, getSessionID(context, false), 1, th);
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(errorEvent));
                    return;
                }
                return;
            }
            statLogger.error(str);
        }
    }

    public static void reportQQ(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (!StatConfig.qq.equals(str)) {
            StatConfig.qq = str;
            sendAdditionEvent(context, null);
        }
    }

    static void reportSdkSelfException(Context context, Throwable th) {
        try {
            if (StatConfig.isEnableStatService()) {
                if (context == null) {
                    logger.error("The Context of StatService.reportSdkSelfException() can not be null!");
                    return;
                }
                ErrorEvent errorEvent = new ErrorEvent(context, getSessionID(context, false), 99, th);
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(errorEvent));
                }
            }
        } catch (Throwable th2) {
            StatLogger statLogger = logger;
            statLogger.e("reportSdkSelfException error: " + th2);
        }
    }

    static void sendAdditionEvent(Context context, Map<String, ?> map) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.sendAdditionEvent() can not be null!");
                return;
            }
            try {
                AdditionEvent additionEvent = new AdditionEvent(context, getSessionID(context, false), map);
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(additionEvent));
                }
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    static void sendNewSessionEnv(Context context) {
        if (getHandler(context) != null) {
            logger.d("start new session.");
            sessionId = StatCommonHelper.getNextSessionID();
            StatConfig.setCurSessionStatReportCount(0);
            StatConfig.incCurrentDaySessionNumbers();
            getHandler(context).post(new StatTask(new SessionEnv(context, sessionId, getEncodeConfig())));
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            logger.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            Env.appendEnvAttr(context, map);
        } catch (JSONException e) {
            logger.e((Exception) e);
        }
    }

    public static void startNewSession(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.startNewSession() can not be null!");
                return;
            }
            try {
                stopSession();
                getSessionID(context, true);
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2) throws MtaSDkException {
        if (!StatConfig.isEnableStatService()) {
            logger.error("MTA StatService is disable.");
            return false;
        }
        logger.d("MTA SDK version, current: " + "1.0.0" + " ,required: " + str2);
        if (context == null || str2 == null) {
            logger.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        } else if (StatCommonHelper.getSDKLongVersion("1.0.0") >= StatCommonHelper.getSDKLongVersion(str2)) {
            try {
                String installChannel = StatConfig.getInstallChannel(context);
                if (installChannel == null || installChannel.length() == 0) {
                    StatConfig.setInstallChannel("-");
                }
                StatConfig.setAppKey(context, str);
                getHandler(context);
                return true;
            } catch (Throwable th) {
                logger.e(th);
                return false;
            }
        } else {
            String str3 = ("MTA SDK version conflicted, current: " + "1.0.0" + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
            logger.error(str3);
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException(str3);
        }
    }

    public static void stopSession() {
        lastActivityTimestamp = 0;
    }

    public static void trackCustomBeginEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            } else {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setArgs(strArr);
                    CustomEvent.Key key = customEvent.getKey();
                    if (timedEventMap.containsKey(key)) {
                        StatLogger statLogger2 = logger;
                        statLogger2.error("Duplicate CustomEvent key: " + key.toString() + ", trackCustomBeginEvent() repeated?");
                        return;
                    } else if (timedEventMap.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        timedEventMap.put(key, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        StatLogger statLogger3 = logger;
                        statLogger3.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            } else {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setProperties(properties);
                    CustomEvent.Key key = customEvent.getKey();
                    if (timedEventMap.containsKey(key)) {
                        StatLogger statLogger2 = logger;
                        statLogger2.error("Duplicate CustomEvent key: " + key.toString() + ", trackCustomBeginKVEvent() repeated?");
                        return;
                    } else if (timedEventMap.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        timedEventMap.put(key, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        StatLogger statLogger3 = logger;
                        statLogger3.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEndEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            } else {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setArgs(strArr);
                    Long remove = timedEventMap.remove(customEvent.getKey());
                    if (remove != null) {
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                        customEvent.setDuration(Long.valueOf(valueOf.longValue() == 0 ? 1 : valueOf.longValue()).longValue());
                        if (getHandler(context) != null) {
                            getHandler(context).post(new StatTask(customEvent));
                            return;
                        }
                        return;
                    }
                    StatLogger statLogger2 = logger;
                    statLogger2.error("No start time found for custom event: " + customEvent.getKey().toString() + ", lost trackCustomBeginEvent()?");
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            } else {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setProperties(properties);
                    Long remove = timedEventMap.remove(customEvent.getKey());
                    if (remove != null) {
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                        customEvent.setDuration(Long.valueOf(valueOf.longValue() == 0 ? 1 : valueOf.longValue()).longValue());
                        if (getHandler(context) != null) {
                            getHandler(context).post(new StatTask(customEvent));
                            return;
                        }
                        return;
                    }
                    StatLogger statLogger2 = logger;
                    statLogger2.error("No start time found for custom event: " + customEvent.getKey().toString() + ", lost trackCustomBeginKVEvent()?");
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            } else {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setArgs(strArr);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(customEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (isEmpty(str)) {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            } else {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setProperties(properties);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(customEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            }
            statLogger.error(str2);
        }
    }
}
