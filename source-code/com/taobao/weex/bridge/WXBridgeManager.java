package com.taobao.weex.bridge;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.adapter.IWXJsFileLoaderAdapter;
import com.taobao.weex.adapter.IWXJscProcessManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.bridge.WXValidateProcessor;
import com.taobao.weex.common.IWXBridge;
import com.taobao.weex.common.IWXDebugConfig;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXJSExceptionInfo;
import com.taobao.weex.common.WXRefreshData;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.devtools.debug.DebugServerProxy;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.jsEngine.JSEngine;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.ui.WXComponentRegistry;
import com.taobao.weex.ui.WXRenderManager;
import com.taobao.weex.ui.action.ActionReloadPage;
import com.taobao.weex.ui.action.GraphicActionAddChildToRichtext;
import com.taobao.weex.ui.action.GraphicActionAddElement;
import com.taobao.weex.ui.action.GraphicActionAddEvent;
import com.taobao.weex.ui.action.GraphicActionAppendTreeCreateFinish;
import com.taobao.weex.ui.action.GraphicActionCreateBody;
import com.taobao.weex.ui.action.GraphicActionCreateFinish;
import com.taobao.weex.ui.action.GraphicActionLayout;
import com.taobao.weex.ui.action.GraphicActionMoveElement;
import com.taobao.weex.ui.action.GraphicActionRefreshFinish;
import com.taobao.weex.ui.action.GraphicActionRemoveChildFromRichtext;
import com.taobao.weex.ui.action.GraphicActionRemoveElement;
import com.taobao.weex.ui.action.GraphicActionRemoveEvent;
import com.taobao.weex.ui.action.GraphicActionRenderSuccess;
import com.taobao.weex.ui.action.GraphicActionUpdateAttr;
import com.taobao.weex.ui.action.GraphicActionUpdateRichtextAttr;
import com.taobao.weex.ui.action.GraphicActionUpdateRichtextStyle;
import com.taobao.weex.ui.action.GraphicActionUpdateStyle;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.module.WXDomModule;
import com.taobao.weex.utils.FeatureSwitches;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXJsonUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.WXWsonJSONSwitch;
import com.taobao.weex.utils.batch.BactchExecutor;
import com.taobao.weex.utils.batch.Interceptor;
import com.taobao.weex.utils.tools.LogDetail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;
import tb.kx2;
import tb.s42;

/* compiled from: Taobao */
public class WXBridgeManager implements Handler.Callback, BactchExecutor {
    public static final String ARGS = "args";
    private static final boolean BRIDGE_LOG_SWITCH = false;
    private static final String BUNDLE_TYPE = "bundleType";
    public static final String COMPONENT = "component";
    private static final int CRASHREINIT = 50;
    private static String GLOBAL_CONFIG_KEY = "global_switch_config";
    public static final String INITLOGFILE = "/jsserver_start.log";
    private static final int INIT_FRAMEWORK_OK = 1;
    public static final String KEY_ARGS = "args";
    public static final String KEY_METHOD = "method";
    public static final String KEY_PARAMS = "params";
    private static long LOW_MEM_VALUE = 120;
    public static final String METHD_COMPONENT_HOOK_SYNC = "componentHook";
    public static final String METHD_FIRE_EVENT_SYNC = "fireEventSync";
    public static final String METHOD = "method";
    public static final String METHOD_CALLBACK = "callback";
    public static final String METHOD_CALL_JS = "callJS";
    public static final String METHOD_CREATE_INSTANCE = "createInstance";
    public static final String METHOD_CREATE_INSTANCE_CONTEXT = "createInstanceContext";
    public static final String METHOD_CREATE_PAGE_WITH_CONTENT = "CreatePageWithContent";
    public static final String METHOD_DESTROY_INSTANCE = "destroyInstance";
    public static final String METHOD_FIRE_EVENT = "fireEvent";
    private static final String METHOD_JSFM_NOT_INIT_IN_EAGLE_MODE = "JsfmNotInitInEagleMode";
    public static final String METHOD_NOTIFY_SERIALIZE_CODE_CACHE = "notifySerializeCodeCache";
    public static final String METHOD_NOTIFY_TRIM_MEMORY = "notifyTrimMemory";
    private static final String METHOD_POST_TASK_TO_MSG_LOOP = "PostTaskToMsgLoop";
    public static final String METHOD_REFRESH_INSTANCE = "refreshInstance";
    public static final String METHOD_REGISTER_COMPONENTS = "registerComponents";
    public static final String METHOD_REGISTER_MODULES = "registerModules";
    public static final String METHOD_SET_TIMEOUT = "setTimeoutCallback";
    public static final String METHOD_UPDATE_COMPONENT_WITH_DATA = "UpdateComponentData";
    public static final String MODULE = "module";
    private static final String NON_CALLBACK = "-1";
    public static final String OPTIONS = "options";
    public static final String REF = "ref";
    private static final String RENDER_STRATEGY = "renderStrategy";
    private static final String UNDEFINED = "undefined";
    private static Class clazz_debugProxy = null;
    private static String crashUrl = null;
    private static String globalConfig = "none";
    private static volatile boolean isJsEngineMultiThreadEnable = false;
    private static volatile boolean isSandBoxContext = true;
    private static boolean isUseSingleProcess = false;
    private static long lastCrashTime = 0;
    static volatile WXBridgeManager mBridgeManager = null;
    private static volatile boolean mInit = false;
    private static String mRaxApi = null;
    private static Map<String, String> mWeexCoreEnvOptions = new HashMap();
    public static volatile int reInitCount = 1;
    private static volatile int sInitFrameWorkCount;
    public static StringBuilder sInitFrameWorkMsg = new StringBuilder();
    public static long sInitFrameWorkTimeOrigin;
    private HashSet<String> mDestroyedInstanceId = new HashSet<>();
    private WXParams mInitParams;
    private Interceptor mInterceptor;
    Handler mJSHandler;
    private WXThread mJSThread;
    private StringBuilder mLodBuilder = new StringBuilder(50);
    private boolean mMock = false;
    private WXHashMap<String, ArrayList<WXHashMap<String, Object>>> mNextTickTasks = new WXHashMap<>();
    private List<Map<String, Object>> mRegisterComponentFailList = new ArrayList(8);
    private List<Map<String, Object>> mRegisterModuleFailList = new ArrayList(8);
    private List<String> mRegisterServiceFailList = new ArrayList(8);
    private IWXBridge mWXBridge;
    private Object mWxDebugProxy;

    /* compiled from: Taobao */
    public enum BundType {
        Vue,
        Rax,
        Others
    }

    /* compiled from: Taobao */
    public static class TimerInfo {
        public String callbackId;
        public String instanceId;
        public long time;
    }

    private WXBridgeManager() {
        initWXBridge(WXEnvironment.sRemoteDebugMode);
        WXThread wXThread = new WXThread("WeexJSBridgeThread", this);
        this.mJSThread = wXThread;
        this.mJSHandler = wXThread.getHandler();
    }

    private void addJSEventTask(final String str, final String str2, final List<Object> list, final Object... objArr) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass12 */

            public void run() {
                Object[] objArr = objArr;
                if (!(objArr == null || objArr.length == 0)) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : objArr) {
                        arrayList.add(obj);
                    }
                    if (list != null) {
                        ArrayMap arrayMap = new ArrayMap(4);
                        arrayMap.put("params", list);
                        arrayList.add(arrayMap);
                    }
                    WXHashMap wXHashMap = new WXHashMap();
                    wXHashMap.put("method", str);
                    wXHashMap.put("args", arrayList);
                    if (WXBridgeManager.this.mNextTickTasks.get(str2) == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(wXHashMap);
                        WXBridgeManager.this.mNextTickTasks.put(str2, arrayList2);
                        return;
                    }
                    ((ArrayList) WXBridgeManager.this.mNextTickTasks.get(str2)).add(wXHashMap);
                }
            }
        });
    }

    private void addJSTask(String str, String str2, Object... objArr) {
        addJSEventTask(str, str2, null, objArr);
    }

    @NonNull
    public static String argsToJSON(WXJSObject[] wXJSObjectArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START_STR);
        for (WXJSObject wXJSObject : wXJSObjectArr) {
            sb.append(WXWsonJSONSwitch.fromObjectToJSONString(wXJSObject));
            sb.append(",");
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x017b  */
    private WXParams assembleDefaultOptions() {
        Exception e;
        checkJsEngineMultiThread();
        Map<String, String> config = WXEnvironment.getConfig();
        WXParams wXParams = new WXParams();
        wXParams.setPlatform(config.get("os"));
        wXParams.setCacheDir(config.get(WXConfig.cacheDir));
        wXParams.setOsVersion(config.get(WXConfig.sysVersion));
        wXParams.setAppVersion(config.get("appVersion"));
        wXParams.setWeexVersion(config.get("weexVersion"));
        wXParams.setDeviceModel(config.get(WXConfig.sysModel));
        wXParams.setShouldInfoCollect(config.get(WXDebugConstants.ENV_INFO_COLLECT));
        wXParams.setLogLevel(config.get("logLevel"));
        wXParams.setLayoutDirection(config.get(WXConfig.layoutDirection));
        String str = "true";
        wXParams.setUseSingleProcess(isUseSingleProcess ? str : "false");
        wXParams.setCrashFilePath(WXEnvironment.getCrashFilePath(WXEnvironment.getApplication().getApplicationContext()));
        wXParams.setLibJsbPath(WXEnvironment.CORE_JSB_SO_PATH);
        wXParams.setLibJssPath(WXEnvironment.getLibJssRealPath());
        wXParams.setLibIcuPath(WXEnvironment.getLibJssIcuPath());
        wXParams.setLibLdPath(WXEnvironment.getLibLdPath());
        String libJScRealPath = WXEnvironment.getLibJScRealPath();
        wXParams.setLibJscPath(TextUtils.isEmpty(libJScRealPath) ? "" : new File(libJScRealPath).getParent());
        String str2 = config.get("appName");
        if (!TextUtils.isEmpty(str2)) {
            wXParams.setAppName(str2);
        }
        wXParams.setDeviceWidth(TextUtils.isEmpty(config.get("deviceWidth")) ? String.valueOf(WXViewUtils.getScreenWidth(WXEnvironment.sApplication)) : config.get("deviceWidth"));
        wXParams.setDeviceHeight(TextUtils.isEmpty(config.get("deviceHeight")) ? String.valueOf(WXViewUtils.getScreenHeight(WXEnvironment.sApplication)) : config.get("deviceHeight"));
        Map<String, String> customOptions = WXEnvironment.getCustomOptions();
        customOptions.put("enableBackupThread", String.valueOf(jsEngineMultiThreadEnable()));
        IWXJscProcessManager F = WXSDKManager.v().F();
        if (F != null) {
            customOptions.put("enableBackupThreadCache", String.valueOf(F.enableBackUpThreadCache()));
        }
        if (!WXEnvironment.sUseRunTimeApi) {
            customOptions.put("__enable_native_promise__", str);
        }
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null) {
            try {
                if (J.checkMode("white_screen_fix_open")) {
                    WXEnvironment.isWsFixMode = true;
                } else {
                    String configWhenInit = J.getConfigWhenInit(kx2.WXAPM_CONFIG_GROUP, "enableAlarmSignal", str);
                    try {
                        WXEnvironment.isWsFixMode = str.equalsIgnoreCase(configWhenInit);
                        str = configWhenInit;
                    } catch (Exception e2) {
                        str = configWhenInit;
                        e = e2;
                        e.printStackTrace();
                        if (str != null) {
                        }
                        WXLogUtils.e("weex", "enableAlarmSignal:" + str);
                        wXParams.setOptions(customOptions);
                        wXParams.setNeedInitV8(WXSDKManager.v().L());
                        this.mInitParams = wXParams;
                        return wXParams;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (str != null) {
                }
                WXLogUtils.e("weex", "enableAlarmSignal:" + str);
                wXParams.setOptions(customOptions);
                wXParams.setNeedInitV8(WXSDKManager.v().L());
                this.mInitParams = wXParams;
                return wXParams;
            }
        }
        if (str != null) {
            customOptions.put("enableAlarmSignal", str);
        }
        WXLogUtils.e("weex", "enableAlarmSignal:" + str);
        wXParams.setOptions(customOptions);
        wXParams.setNeedInitV8(WXSDKManager.v().L());
        this.mInitParams = wXParams;
        return wXParams;
    }

    private void asyncCallJSEventWithResult(final EventResult eventResult, final String str, final String str2, final List<Object> list, final Object... objArr) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass11 */

            public void run() {
                try {
                    Object[] objArr = objArr;
                    if (objArr == null) {
                        return;
                    }
                    if (objArr.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : objArr) {
                            arrayList.add(obj);
                        }
                        if (list != null) {
                            ArrayMap arrayMap = new ArrayMap(4);
                            arrayMap.put("params", list);
                            arrayList.add(arrayMap);
                        }
                        WXHashMap wXHashMap = new WXHashMap();
                        wXHashMap.put("method", str);
                        wXHashMap.put("args", arrayList);
                        WXJSObject[] wXJSObjectArr = {new WXJSObject(2, str2), WXWsonJSONSwitch.toWsonOrJsonWXJSObject(new Object[]{wXHashMap})};
                        WXBridgeManager.this.invokeExecJSWithCallback(String.valueOf(str2), null, WXBridgeManager.METHOD_CALL_JS, wXJSObjectArr, eventResult != null ? new ResultCallback<byte[]>() {
                            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass11.AnonymousClass1 */

                            public void onReceiveResult(byte[] bArr) {
                                JSONArray jSONArray = (JSONArray) WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                                if (jSONArray != null && jSONArray.size() > 0) {
                                    eventResult.onCallback(jSONArray.get(0));
                                }
                            }
                        } : null, true);
                        wXJSObjectArr[0] = null;
                    }
                } catch (Exception e) {
                    WXLogUtils.e("asyncCallJSEventWithResult", e);
                }
            }
        });
    }

    private boolean checkMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private void doReportJSException(String str, String str2, WXErrorCode wXErrorCode, String str3) {
        String str4;
        String str5;
        Throwable th;
        Throwable th2;
        Exception e;
        WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
        if (WXSDKManager.v().p() != null) {
            if (TextUtils.isEmpty(str)) {
                str = "instanceIdisNull";
            }
            if (wXSDKInstance == null && IWXUserTrackAdapter.INIT_FRAMEWORK.equals(str2)) {
                try {
                    if (WXEnvironment.getApplication() != null) {
                        try {
                            File file = new File(WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath() + INITLOGFILE);
                            if (file.exists()) {
                                if (file.length() > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    try {
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                                        while (true) {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            sb.append(readLine + StringUtils.LF);
                                        }
                                        str4 = sb.toString();
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            str5 = str4;
                                            e = e2;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        str5 = null;
                                        try {
                                            WXLogUtils.e(WXLogUtils.getStackTrace(e));
                                            str4 = str5;
                                            file.delete();
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            try {
                                                WXLogUtils.e(WXLogUtils.getStackTrace(th2));
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                            str4 = str5;
                                            str3 = str3 + StringUtils.LF + str4;
                                            WXLogUtils.e("reportJSException:" + str3);
                                            WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                                        }
                                        str3 = str3 + StringUtils.LF + str4;
                                        WXLogUtils.e("reportJSException:" + str3);
                                        WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                                    }
                                } else {
                                    str4 = null;
                                }
                                try {
                                    file.delete();
                                } catch (Throwable th5) {
                                    str5 = str4;
                                    th2 = th5;
                                }
                                str3 = str3 + StringUtils.LF + str4;
                                WXLogUtils.e("reportJSException:" + str3);
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            str5 = null;
                            WXLogUtils.e(WXLogUtils.getStackTrace(th2));
                            str4 = str5;
                            str3 = str3 + StringUtils.LF + str4;
                            WXLogUtils.e("reportJSException:" + str3);
                            WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                        }
                    }
                    str4 = null;
                } catch (Throwable th7) {
                    th = th7;
                    str5 = null;
                    WXLogUtils.e(WXLogUtils.getStackTrace(th));
                    str4 = str5;
                    str3 = str3 + StringUtils.LF + str4;
                    WXLogUtils.e("reportJSException:" + str3);
                    WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                }
                str3 = str3 + StringUtils.LF + str4;
                WXLogUtils.e("reportJSException:" + str3);
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
        }
    }

    private void execJSOnInstance(final EventResult eventResult, final String str, final String str2, final int i) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass25 */

            public void run() {
                eventResult.onCallback(WXBridgeManager.this.invokeExecJSOnInstance(str, str2, i));
            }
        });
    }

    private void execRegisterFailTask() {
        if (this.mRegisterModuleFailList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = this.mRegisterModuleFailList.size();
            for (int i = 0; i < size; i++) {
                invokeRegisterModules(this.mRegisterModuleFailList.get(i), arrayList);
            }
            this.mRegisterModuleFailList.clear();
            if (arrayList.size() > 0) {
                this.mRegisterModuleFailList.addAll(arrayList);
            }
        }
        if (this.mRegisterComponentFailList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            invokeRegisterComponents(this.mRegisterComponentFailList, arrayList2);
            this.mRegisterComponentFailList.clear();
            if (arrayList2.size() > 0) {
                this.mRegisterComponentFailList.addAll(arrayList2);
            }
        }
        if (this.mRegisterServiceFailList.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (String str : this.mRegisterServiceFailList) {
                invokeExecJSService(str, arrayList3);
            }
            this.mRegisterServiceFailList.clear();
            if (arrayList3.size() > 0) {
                this.mRegisterServiceFailList.addAll(arrayList3);
            }
        }
    }

    private Pair<Pair<String, Object>, Boolean> extractCallbackArgs(String str) {
        try {
            JSONObject jSONObject = JSON.parseArray(str).getJSONObject(0);
            JSONArray jSONArray = jSONObject.getJSONArray("args");
            if (jSONArray.size() == 3 && METHOD_CALLBACK.equals(jSONObject.getString("method"))) {
                return new Pair<>(new Pair(jSONArray.getString(0), jSONArray.getJSONObject(1)), Boolean.valueOf(jSONArray.getBooleanValue(2)));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void fireEventOnDataRenderNode(final WXEaglePlugin wXEaglePlugin, final String str, final String str2, final String str3, final Map<String, Object> map, final Map<String, Object> map2) {
        this.mJSHandler.postDelayed(WXThread.secure(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass14 */

            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.d("fireEventOnDataRenderNode >>>> instanceId:" + str + ", data:" + map);
                    }
                    WXEaglePlugin wXEaglePlugin = wXEaglePlugin;
                    String str = str;
                    String str2 = str2;
                    String str3 = str3;
                    Map map = map;
                    String str4 = "{}";
                    String jSONString = (map == null || map.isEmpty()) ? str4 : JSON.toJSONString(map);
                    Map map2 = map2;
                    if (map2 != null && !map2.isEmpty()) {
                        str4 = JSON.toJSONString(map2);
                    }
                    wXEaglePlugin.fireEvent(str, str2, str3, jSONString, str4);
                    WXLogUtils.renderPerformanceLog("fireEventOnDataRenderNode", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    String str5 = "[WXBridgeManager] fireEventOnDataRenderNode " + WXLogUtils.getStackTrace(th);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "fireEventOnDataRenderNode", str5, null);
                    WXLogUtils.e(str5);
                }
            }
        }), 0);
    }

    public static WXBridgeManager getInstance() {
        if (mBridgeManager == null) {
            synchronized (WXBridgeManager.class) {
                if (mBridgeManager == null) {
                    mBridgeManager = new WXBridgeManager();
                }
            }
        }
        return mBridgeManager;
    }

    private void getNextTick(String str, String str2) {
        addJSTask(METHOD_CALLBACK, str, str2, "{}");
        sendMessage(str, 6);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010d, code lost:
        if (android.os.Build.VERSION.SDK_INT < 16) goto L_0x0119;
     */
    private void initFramework(String str) {
        boolean z;
        long currentTimeMillis;
        String str2;
        LogDetail logDetail = new LogDetail();
        logDetail.name(IWXUserTrackAdapter.INIT_FRAMEWORK);
        logDetail.taskStart();
        if (WXSDKEngine.isSoInitialized() && !isJSFrameworkInit()) {
            sInitFrameWorkTimeOrigin = System.currentTimeMillis();
            if (TextUtils.isEmpty(str)) {
                WXLogUtils.d("weex JS framework from assets");
                LogDetail logDetail2 = new LogDetail();
                logDetail2.name("loadJSFramework");
                logDetail2.taskStart();
                IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter = WXSDKEngine.getIWXJsFileLoaderAdapter();
                if (!isSandBoxContext) {
                    if (iWXJsFileLoaderAdapter != null) {
                        str = iWXJsFileLoaderAdapter.loadJsFramework();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = WXFileUtils.loadAsset("main.js", WXEnvironment.getApplication());
                    }
                } else {
                    if (iWXJsFileLoaderAdapter != null) {
                        str = iWXJsFileLoaderAdapter.loadJsFrameworkForSandBox();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = WXFileUtils.loadAsset("weex-main-jsfm.js", WXEnvironment.getApplication());
                    }
                }
                StringBuilder sb = sInitFrameWorkMsg;
                sb.append("| weex JS framework from assets, isSandBoxContext: ");
                sb.append(isSandBoxContext);
                logDetail2.taskEnd();
            }
            z = false;
            if (TextUtils.isEmpty(str)) {
                setJSFrameworkInit(false);
                sInitFrameWorkMsg.append("| framework isEmpty ");
                WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_ERR_JS_FRAMEWORK, IWXUserTrackAdapter.INIT_FRAMEWORK, "framework is empty!! ", null);
                return;
            }
            try {
                if (WXSDKManager.v().H() != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    WXSDKManager.v().H().onJsFrameworkStart();
                    WXEnvironment.sJSFMStartListenerTime = System.currentTimeMillis() - currentTimeMillis2;
                    try {
                        IWXUserTrackAdapter t = WXSDKManager.v().t();
                        if (t != null) {
                            HashMap hashMap = new HashMap(1);
                            hashMap.put("time", String.valueOf(WXEnvironment.sJSFMStartListenerTime));
                            t.commit(WXEnvironment.getApplication(), "sJSFMStartListener", IWXUserTrackAdapter.COUNTER, null, hashMap);
                        }
                    } catch (Exception e) {
                        WXLogUtils.e(WXLogUtils.getStackTrace(e));
                    }
                }
                currentTimeMillis = System.currentTimeMillis();
                str2 = "";
                try {
                    str2 = WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath();
                } catch (Exception e2) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(e2));
                }
                try {
                } catch (Exception e3) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(e3));
                }
            } catch (Throwable th) {
                StringBuilder sb2 = sInitFrameWorkMsg;
                sb2.append(" | invokeInitFramework exception ");
                sb2.append(th.toString());
                if (reInitCount > 1) {
                    WXLogUtils.e("[WXBridgeManager] invokeInitFramework ", th);
                    return;
                } else {
                    WXLogUtils.e("[WXBridgeManager] invokeInitFramework ", th);
                    return;
                }
            }
        } else {
            return;
        }
        z = true;
        StringBuilder sb3 = sInitFrameWorkMsg;
        sb3.append(" | pieSupport:");
        sb3.append(z);
        WXLogUtils.d("[WXBridgeManager] initFrameworkEnv crashFile:" + str2 + " pieSupport:" + z);
        LogDetail logDetail3 = new LogDetail();
        logDetail3.name("native initFrameworkEnv");
        logDetail3.taskStart();
        if (this.mWXBridge.initFrameworkEnv(str, assembleDefaultOptions(), str2, z) == 1) {
            logDetail3.taskEnd();
            WXEnvironment.sJSLibInitTime = System.currentTimeMillis() - currentTimeMillis;
            WXEnvironment.sSDKInitTime = System.currentTimeMillis() - WXEnvironment.sSDKInitStart;
            setJSFrameworkInit(true);
            logDetail.taskEnd();
            if (WXSDKManager.v().H() != null) {
                WXSDKManager.v().H().onJsFrameworkReady();
            }
            execRegisterFailTask();
            WXEnvironment.JsFrameworkInit = true;
            sInitFrameWorkCount++;
            WXLogUtils.e("initFrameWorkCount :" + sInitFrameWorkCount);
            registerDomModule();
            trackComponentAndModulesTime();
            return;
        }
        StringBuilder sb4 = sInitFrameWorkMsg;
        sb4.append(" | ExecuteJavaScript fail, reInitCount");
        sb4.append(reInitCount);
        if (reInitCount > 1) {
            WXLogUtils.e("[WXBridgeManager] invokeReInitFramework  ExecuteJavaScript fail");
        } else {
            WXLogUtils.e("[WXBridgeManager] invokeInitFramework  ExecuteJavaScript fail");
        }
    }

    private void initWXBridge(boolean z) {
        Method method;
        Constructor constructor;
        Method method2;
        if (z && WXEnvironment.isApkDebugable()) {
            WXEnvironment.sDebugServerConnectable = true;
        }
        if (WXEnvironment.sDebugServerConnectable) {
            WXEnvironment.isApkDebugable();
            if (WXEnvironment.getApplication() != null) {
                try {
                    if (clazz_debugProxy == null) {
                        clazz_debugProxy = DebugServerProxy.class;
                    }
                    Class cls = clazz_debugProxy;
                    if (!(cls == null || (constructor = cls.getConstructor(Context.class, IWXDebugConfig.class)) == null)) {
                        Object newInstance = constructor.newInstance(WXEnvironment.getApplication(), new IWXDebugConfig() {
                            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass4 */

                            @Override // com.taobao.weex.common.IWXDebugConfig
                            public WXDebugJsBridge getWXDebugJsBridge() {
                                return new WXDebugJsBridge();
                            }

                            @Override // com.taobao.weex.common.IWXDebugConfig
                            public WXBridgeManager getWXJSManager() {
                                return WXBridgeManager.this;
                            }
                        });
                        this.mWxDebugProxy = newInstance;
                        if (!(newInstance == null || (method2 = clazz_debugProxy.getMethod("start", new Class[0])) == null)) {
                            method2.invoke(this.mWxDebugProxy, new Object[0]);
                        }
                    }
                } catch (Throwable unused) {
                }
                WXServiceManager.execAllCacheJsService();
            } else {
                WXLogUtils.e("WXBridgeManager", "WXEnvironment.sApplication is null, skip init Inspector");
            }
        }
        if (!z || this.mWxDebugProxy == null) {
            this.mWXBridge = new WXBridge();
            return;
        }
        try {
            if (clazz_debugProxy == null) {
                clazz_debugProxy = DebugServerProxy.class;
            }
            Class cls2 = clazz_debugProxy;
            if (cls2 != null && (method = cls2.getMethod("getWXBridge", new Class[0])) != null) {
                this.mWXBridge = (IWXBridge) method.invoke(this.mWxDebugProxy, new Object[0]);
            }
        } catch (Throwable unused2) {
        }
    }

    private void invokeCallJSBatch(Message message) {
        if (!this.mNextTickTasks.isEmpty() && isJSFrameworkInit()) {
            try {
                Object obj = message.obj;
                Stack<String> instanceStack = this.mNextTickTasks.getInstanceStack();
                int size = instanceStack.size() - 1;
                ArrayList<WXHashMap<String, Object>> arrayList = null;
                while (true) {
                    if (size >= 0) {
                        obj = instanceStack.get(size);
                        arrayList = this.mNextTickTasks.remove(obj);
                        if (arrayList != null && !arrayList.isEmpty()) {
                            break;
                        }
                        size--;
                    } else {
                        break;
                    }
                }
                if (arrayList != null) {
                    invokeExecJS(String.valueOf(obj), null, METHOD_CALL_JS, new WXJSObject[]{new WXJSObject(2, obj), WXWsonJSONSwitch.toWsonOrJsonWXJSObject(arrayList.toArray())});
                }
            } catch (Throwable th) {
                WXLogUtils.e("WXBridgeManager", th);
                WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_ERR_JS_FRAMEWORK, "invokeCallJSBatch", "invokeCallJSBatch#" + WXLogUtils.getStackTrace(th), null);
            }
            if (!this.mNextTickTasks.isEmpty()) {
                this.mJSHandler.sendEmptyMessage(6);
            }
        } else if (!isJSFrameworkInit()) {
            WXLogUtils.e("[WXBridgeManager] invokeCallJSBatch: framework.js uninitialized!!  message:" + message.toString());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0225 A[Catch:{ all -> 0x03a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0257 A[Catch:{ all -> 0x03a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d1 A[Catch:{ all -> 0x03a6 }] */
    private void invokeCreateInstance(@NonNull final WXSDKInstance wXSDKInstance, final s42 s42, Map<String, Object> map, final String str) {
        String str2;
        Throwable th;
        HashMap hashMap;
        WXJSObject wXJSObject;
        WXJSObject wXJSObject2;
        Object obj;
        String str3;
        String str4;
        String str5;
        BundType bundType;
        WXJSObject wXJSObject3;
        String str6;
        WXJSObject wXJSObject4;
        char c;
        Throwable th2;
        if (!isSkipFrameworkInit(wXSDKInstance)) {
            initFramework("");
        }
        if (this.mMock) {
            mock(wXSDKInstance.getInstanceId());
        } else if (isSkipFrameworkInit(wXSDKInstance) || isJSFrameworkInit()) {
            WXModuleManager.registerWhenCreateInstance();
            try {
                BundType bundType2 = BundType.Others;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    bundType2 = getBundleType(wXSDKInstance.getBundleUrl(), s42.b());
                    if (WXEnvironment.isOpenDebugLog()) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        WXLogUtils.e("end getBundleType type:" + bundType2.toString() + " time:" + (currentTimeMillis2 - currentTimeMillis));
                    }
                } catch (Throwable th3) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(th3));
                }
                if (map == null) {
                    try {
                        hashMap = new HashMap();
                    } catch (Throwable th4) {
                        th2 = th4;
                        hashMap = map;
                        WXLogUtils.e(WXLogUtils.getStackTrace(th2));
                        wXSDKInstance.bundleType = bundType2;
                        WXEnvironment.isApkDebugable();
                        WXJSObject wXJSObject5 = new WXJSObject(2, wXSDKInstance.getInstanceId());
                        if (TextUtils.isEmpty(s42.b())) {
                        }
                        if (hashMap != null) {
                        }
                        obj = null;
                        if (obj == null) {
                        }
                        WXJSObject wXJSObject6 = new WXJSObject(3, str3);
                        if (hashMap == null) {
                        }
                        WXJSObject optionObjConvert = optionObjConvert(isSandBoxContext, bundType2, new WXJSObject(3, str4));
                        if (str == null) {
                        }
                        WXJSObject wXJSObject7 = new WXJSObject(3, str5);
                        bundType = BundType.Rax;
                        if (bundType2 != bundType) {
                        }
                        if (mRaxApi == null) {
                        }
                        wXJSObject3 = new WXJSObject(2, mRaxApi);
                        if (wXSDKInstance.isUsingEaglePlugin()) {
                        }
                        c = 2;
                        WXJSObject[] wXJSObjectArr = new WXJSObject[7];
                        wXJSObjectArr[0] = wXJSObject5;
                        wXJSObjectArr[1] = wXJSObject2;
                        wXJSObjectArr[c] = optionObjConvert;
                        wXJSObjectArr[3] = wXJSObject7;
                        wXJSObjectArr[4] = wXJSObject3;
                        wXJSObjectArr[5] = wXJSObject4;
                        wXJSObjectArr[6] = wXJSObject6;
                        wXSDKInstance.setTemplate(s42.b());
                        if (!isSandBoxContext) {
                        }
                    }
                } else {
                    hashMap = map;
                }
                try {
                    if (hashMap.get(BUNDLE_TYPE) == null) {
                        if (bundType2 == BundType.Vue) {
                            hashMap.put(BUNDLE_TYPE, "Vue");
                        } else if (bundType2 == BundType.Rax) {
                            hashMap.put(BUNDLE_TYPE, "Rax");
                        } else {
                            hashMap.put(BUNDLE_TYPE, "Others");
                        }
                        Object obj2 = hashMap.get(BUNDLE_TYPE);
                        if ((obj2 instanceof String) && "Others".equalsIgnoreCase((String) obj2)) {
                            obj2 = "other";
                        }
                        if (obj2 != null) {
                            wXSDKInstance.getApmForInstance().e(WXInstanceApm.KEY_PAGE_PROPERTIES_BUNDLE_TYPE, obj2);
                        }
                    }
                    if (hashMap.get("env") == null) {
                        hashMap.put("env", this.mInitParams.toMap());
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    WXLogUtils.e(WXLogUtils.getStackTrace(th2));
                    wXSDKInstance.bundleType = bundType2;
                    WXEnvironment.isApkDebugable();
                    WXJSObject wXJSObject52 = new WXJSObject(2, wXSDKInstance.getInstanceId());
                    if (TextUtils.isEmpty(s42.b())) {
                    }
                    if (hashMap != null) {
                    }
                    obj = null;
                    if (obj == null) {
                    }
                    WXJSObject wXJSObject62 = new WXJSObject(3, str3);
                    if (hashMap == null) {
                    }
                    WXJSObject optionObjConvert2 = optionObjConvert(isSandBoxContext, bundType2, new WXJSObject(3, str4));
                    if (str == null) {
                    }
                    WXJSObject wXJSObject72 = new WXJSObject(3, str5);
                    bundType = BundType.Rax;
                    if (bundType2 != bundType) {
                    }
                    if (mRaxApi == null) {
                    }
                    wXJSObject3 = new WXJSObject(2, mRaxApi);
                    if (wXSDKInstance.isUsingEaglePlugin()) {
                    }
                    c = 2;
                    WXJSObject[] wXJSObjectArr2 = new WXJSObject[7];
                    wXJSObjectArr2[0] = wXJSObject52;
                    wXJSObjectArr2[1] = wXJSObject2;
                    wXJSObjectArr2[c] = optionObjConvert2;
                    wXJSObjectArr2[3] = wXJSObject72;
                    wXJSObjectArr2[4] = wXJSObject3;
                    wXJSObjectArr2[5] = wXJSObject4;
                    wXJSObjectArr2[6] = wXJSObject62;
                    wXSDKInstance.setTemplate(s42.b());
                    if (!isSandBoxContext) {
                    }
                }
                wXSDKInstance.bundleType = bundType2;
                WXEnvironment.isApkDebugable();
                WXJSObject wXJSObject522 = new WXJSObject(2, wXSDKInstance.getInstanceId());
                if (TextUtils.isEmpty(s42.b())) {
                    wXJSObject2 = new WXJSObject(2, s42.a());
                    wXJSObject = new WXJSObject(2, "binary");
                } else {
                    wXJSObject2 = new WXJSObject(2, s42.b());
                    wXJSObject = new WXJSObject(1, "string");
                }
                if (hashMap != null || !hashMap.containsKey("extraOption")) {
                    obj = null;
                } else {
                    obj = hashMap.get("extraOption");
                    hashMap.remove("extraOption");
                }
                if (obj == null) {
                    str3 = "{}";
                } else {
                    str3 = WXJsonUtils.fromObjectToJSONString(obj);
                }
                WXJSObject wXJSObject622 = new WXJSObject(3, str3);
                if (hashMap == null) {
                    str4 = "{}";
                } else {
                    str4 = WXJsonUtils.fromObjectToJSONString(hashMap);
                }
                WXJSObject optionObjConvert22 = optionObjConvert(isSandBoxContext, bundType2, new WXJSObject(3, str4));
                if (str == null) {
                    str5 = "{}";
                } else {
                    str5 = str;
                }
                WXJSObject wXJSObject722 = new WXJSObject(3, str5);
                bundType = BundType.Rax;
                if (bundType2 != bundType || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER) {
                    if (mRaxApi == null) {
                        IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter = WXSDKEngine.getIWXJsFileLoaderAdapter();
                        if (iWXJsFileLoaderAdapter != null) {
                            mRaxApi = iWXJsFileLoaderAdapter.loadRaxApi();
                        }
                        if (TextUtils.isEmpty(mRaxApi)) {
                            mRaxApi = WXFileUtils.loadAsset("weex-rax-api.js", WXEnvironment.getApplication());
                        }
                    }
                    wXJSObject3 = new WXJSObject(2, mRaxApi);
                } else {
                    wXJSObject3 = new WXJSObject(2, "");
                }
                if (wXSDKInstance.isUsingEaglePlugin()) {
                    str6 = "Render error : ";
                    try {
                        wXJSObject4 = new WXJSObject(2, wXSDKInstance.getEaglePluginName());
                    } catch (Throwable th6) {
                        th = th6;
                        str2 = str6;
                        String str7 = "[WXBridgeManager] invokeCreateInstance " + th.getCause() + wXSDKInstance.getTemplateInfo();
                        wXSDKInstance.getApmForInstance().r("createInstance error :" + th.toString());
                        WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + str2 + str7);
                        WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                        wXSDKInstance.onRenderError(wXErrorCode.getErrorCode(), wXErrorCode.getErrorMsg() + str7);
                        WXLogUtils.e(str7);
                    }
                } else {
                    str6 = "Render error : ";
                    if (wXSDKInstance.getRenderStrategy() != WXRenderStrategy.DATA_RENDER_BINARY) {
                        if (wXSDKInstance.getRenderStrategy() != WXRenderStrategy.DATA_RENDER) {
                            WXRenderStrategy renderStrategy = wXSDKInstance.getRenderStrategy();
                            WXRenderStrategy wXRenderStrategy = WXRenderStrategy.JSON_RENDER;
                            if (renderStrategy == wXRenderStrategy) {
                                wXJSObject4 = new WXJSObject(2, wXRenderStrategy.getFlag());
                            } else {
                                c = 2;
                                wXJSObject4 = null;
                                WXJSObject[] wXJSObjectArr22 = new WXJSObject[7];
                                wXJSObjectArr22[0] = wXJSObject522;
                                wXJSObjectArr22[1] = wXJSObject2;
                                wXJSObjectArr22[c] = optionObjConvert22;
                                wXJSObjectArr22[3] = wXJSObject722;
                                wXJSObjectArr22[4] = wXJSObject3;
                                wXJSObjectArr22[5] = wXJSObject4;
                                wXJSObjectArr22[6] = wXJSObject622;
                                wXSDKInstance.setTemplate(s42.b());
                                if (!isSandBoxContext) {
                                    wXSDKInstance.getApmForInstance().r("!isSandBoxContext,and excute");
                                    WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + " Did Not Render in SandBox Mode");
                                    invokeExecJS(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE, wXJSObjectArr22, false);
                                    return;
                                } else if (wXSDKInstance.getReactorPage() != null) {
                                    if (getInstance().getJSLooper() == Looper.myLooper()) {
                                        wXSDKInstance.getReactorPage().render(s42.b(), str);
                                        return;
                                    } else if (wXSDKInstance.getReactorPage() != null) {
                                        getInstance().post(new Runnable() {
                                            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass21 */

                                            public void run() {
                                                wXSDKInstance.getReactorPage().render(s42.b(), str);
                                            }
                                        });
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (bundType2 == BundType.Vue || bundType2 == bundType || wXSDKInstance.isUsingEaglePlugin() || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER_BINARY || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.DATA_RENDER || wXSDKInstance.getRenderStrategy() == WXRenderStrategy.JSON_RENDER) {
                                    wXSDKInstance.getApmForInstance().r("wxBeforeInvokeCreateInstanceContext");
                                    WXLogUtils.d("Instance " + wXSDKInstance.getInstanceId() + " Render in SandBox Mode And Render Type is " + bundType2 + " Render Strategy is " + wXSDKInstance.getRenderStrategy());
                                    WXJSObject[] wXJSObjectArr3 = (WXJSObject[]) Arrays.copyOf(wXJSObjectArr22, 8);
                                    wXJSObjectArr3[wXJSObjectArr3.length - 1] = wXJSObject;
                                    int invokeCreateInstanceContext = invokeCreateInstanceContext(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE_CONTEXT, wXJSObjectArr3, false);
                                    wXSDKInstance.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                                    if (invokeCreateInstanceContext == 0) {
                                        String str8 = "[WXBridgeManager] invokeCreateInstance : " + wXSDKInstance.getTemplateInfo();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Instance ");
                                        sb.append(wXSDKInstance.getInstanceId());
                                        str2 = str6;
                                        try {
                                            sb.append(str2);
                                            sb.append(str8);
                                            WXLogUtils.e(sb.toString());
                                            WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                                            wXSDKInstance.onRenderError(wXErrorCode2.getErrorCode(), wXErrorCode2.getErrorMsg() + str8);
                                            return;
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    WXLogUtils.d("Instance " + wXSDKInstance.getInstanceId() + "Did not Render in SandBox Mode And Render Type is " + bundType2 + " Render Strategy is " + wXSDKInstance.getRenderStrategy());
                                    wXSDKInstance.getApmForInstance().r("StartInvokeExecJSBadBundleType");
                                    invokeExecJS(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE, wXJSObjectArr22, false);
                                    wXSDKInstance.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                                    return;
                                }
                            }
                        }
                    }
                    c = 2;
                    wXJSObject4 = new WXJSObject(2, "DATA_RENDER");
                    WXJSObject[] wXJSObjectArr222 = new WXJSObject[7];
                    wXJSObjectArr222[0] = wXJSObject522;
                    wXJSObjectArr222[1] = wXJSObject2;
                    wXJSObjectArr222[c] = optionObjConvert22;
                    wXJSObjectArr222[3] = wXJSObject722;
                    wXJSObjectArr222[4] = wXJSObject3;
                    wXJSObjectArr222[5] = wXJSObject4;
                    wXJSObjectArr222[6] = wXJSObject622;
                    wXSDKInstance.setTemplate(s42.b());
                    if (!isSandBoxContext) {
                    }
                }
                c = 2;
                WXJSObject[] wXJSObjectArr2222 = new WXJSObject[7];
                wXJSObjectArr2222[0] = wXJSObject522;
                wXJSObjectArr2222[1] = wXJSObject2;
                wXJSObjectArr2222[c] = optionObjConvert22;
                wXJSObjectArr2222[3] = wXJSObject722;
                wXJSObjectArr2222[4] = wXJSObject3;
                wXJSObjectArr2222[5] = wXJSObject4;
                wXJSObjectArr2222[6] = wXJSObject622;
                wXSDKInstance.setTemplate(s42.b());
                if (!isSandBoxContext) {
                }
            } catch (Throwable th8) {
                th = th8;
                str2 = "Render error : ";
                String str72 = "[WXBridgeManager] invokeCreateInstance " + th.getCause() + wXSDKInstance.getTemplateInfo();
                wXSDKInstance.getApmForInstance().r("createInstance error :" + th.toString());
                WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + str2 + str72);
                WXErrorCode wXErrorCode3 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                wXSDKInstance.onRenderError(wXErrorCode3.getErrorCode(), wXErrorCode3.getErrorMsg() + str72);
                WXLogUtils.e(str72);
            }
        } else {
            WXErrorCode wXErrorCode4 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
            wXSDKInstance.onRenderError(wXErrorCode4.getErrorCode(), wXErrorCode4.getErrorMsg());
            WXLogUtils.e("[WXBridgeManager] invokeCreateInstance: framework.js uninitialized.");
            wXSDKInstance.getApmForInstance().r("framework.js uninitialized and return");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeDestroyInstance(String str) {
        try {
            WXEnvironment.isApkDebugable();
            WXJSObject[] wXJSObjectArr = {new WXJSObject(2, str)};
            if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
                invokeDestoryInstance(str, null, METHOD_DESTROY_INSTANCE, wXJSObjectArr, true);
            }
        } catch (Throwable th) {
            String str2 = "[WXBridgeManager] invokeDestroyInstance " + th.getCause();
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "invokeDestroyInstance", str2, null);
            WXLogUtils.e(str2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeExecJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr) {
        invokeExecJS(str, str2, str3, wXJSObjectArr, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String invokeExecJSOnInstance(String str, String str2, int i) {
        StringBuilder sb = this.mLodBuilder;
        sb.append("execJSOnInstance >>>> instanceId:");
        sb.append(str);
        WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            return this.mWXBridge.execJSOnInstance(str, str2, i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeExecJSService(String str, List<String> list) {
        try {
            if (!isJSFrameworkInit()) {
                WXLogUtils.e("[WXBridgeManager] invoke execJSService: framework.js uninitialized.");
                list.add(str);
                return;
            }
            this.mWXBridge.execJSService(str);
        } catch (Throwable th) {
            WXLogUtils.e("[WXBridgeManager] invokeRegisterService:", th);
            HashMap hashMap = new HashMap();
            hashMap.put("inputParams", str + jl1.OR + list.toString());
            WXErrorCode wXErrorCode = WXErrorCode.WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE;
            WXExceptionUtils.commitCriticalExceptionRT("invokeExecJSService", wXErrorCode, "invokeExecJSService", wXErrorCode.getErrorMsg() + "[WXBridgeManager] invokeRegisterService:" + WXLogUtils.getStackTrace(th), hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeExecJSWithCallback(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, ResultCallback resultCallback, boolean z) {
        WXEnvironment.isOpenDebugLog();
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.execJSWithCallback(str, str2, str3, wXJSObjectArr, resultCallback);
        }
    }

    private void invokeInitFramework(Message message) {
        Object obj = message.obj;
        String str = obj != null ? (String) obj : "";
        if (WXUtils.getAvailMemory(WXEnvironment.getApplication()) > LOW_MEM_VALUE) {
            initFramework(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeRefreshInstance(String str, WXRefreshData wXRefreshData) {
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
                System.currentTimeMillis();
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("refreshInstance >>>> instanceId:" + str + ", data:" + wXRefreshData.data + ", isDirty:" + wXRefreshData.isDirty);
                }
                if (!wXRefreshData.isDirty) {
                    WXJSObject wXJSObject = new WXJSObject(2, str);
                    String str2 = wXRefreshData.data;
                    if (str2 == null) {
                        str2 = "{}";
                    }
                    this.mWXBridge.refreshInstance(str, null, METHOD_REFRESH_INSTANCE, new WXJSObject[]{wXJSObject, new WXJSObject(3, str2)});
                    return;
                }
                return;
            }
            if (y != null) {
                WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                y.onRenderError(wXErrorCode.getErrorCode(), wXErrorCode.getErrorMsg() + "invokeRefreshInstance FAILED for JSFrameworkInit FAILED, intance will invoke instance.onRenderError");
            }
            WXLogUtils.e("[WXBridgeManager] invokeRefreshInstance: framework.js uninitialized.");
        } catch (Throwable th) {
            String str3 = "[WXBridgeManager] invokeRefreshInstance " + WXLogUtils.getStackTrace(th);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "invokeRefreshInstance", str3, null);
            WXLogUtils.e(str3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeRegisterComponents(List<Map<String, Object>> list, List<Map<String, Object>> list2) {
        String str;
        if (list == list2) {
            throw new RuntimeException("Fail receiver should not use source.");
        } else if (!isJSFrameworkInit()) {
            for (Map<String, Object> map : list) {
                list2.add(map);
            }
        } else if (list != null) {
            WXJSObject[] wXJSObjectArr = {WXWsonJSONSwitch.toWsonOrJsonWXJSObject(list)};
            try {
                str = this.mWXBridge.execJS("", null, METHOD_REGISTER_COMPONENTS, wXJSObjectArr) == 0 ? "execJS error" : null;
            } catch (Throwable th) {
                str = WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT + wXJSObjectArr.toString() + WXLogUtils.getStackTrace(th);
            }
            if (!TextUtils.isEmpty(str)) {
                WXLogUtils.e("[WXBridgeManager] invokeRegisterComponents ", str);
                WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT, METHOD_REGISTER_COMPONENTS, str, null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeRegisterModules(Map<String, Object> map, List<Map<String, Object>> list) {
        String str;
        if (map == null || !isJSFrameworkInit()) {
            if (!isJSFrameworkInit()) {
                WXLogUtils.d("[WXinvokeRegisterModulesBridgeManager] invokeRegisterModules: framework.js uninitialized.");
            }
            list.add(map);
            return;
        }
        try {
            str = this.mWXBridge.execJS("", null, METHOD_REGISTER_MODULES, new WXJSObject[]{WXWsonJSONSwitch.toWsonOrJsonWXJSObject(map)}) == 0 ? "execJS error" : null;
            try {
                for (String str2 : map.keySet()) {
                    if (str2 != null) {
                        WXModuleManager.resetModuleState(str2, true);
                    }
                }
            } catch (Throwable th) {
                WXLogUtils.e("Weex [invokeRegisterModules]", th);
            }
        } catch (Throwable th2) {
            str = WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES.getErrorMsg() + " \n " + th2.getMessage() + map.entrySet().toString();
        }
        if (!TextUtils.isEmpty(str)) {
            WXLogUtils.e("[WXBridgeManager] invokeRegisterModules:", str);
            WXExceptionUtils.commitCriticalExceptionRT(null, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES, "invokeRegisterModules", str, null);
        }
    }

    private boolean isSkipFrameworkInit(String str) {
        return isSkipFrameworkInit(WXSDKManager.v().y(str));
    }

    private void mock(String str) {
    }

    private void onJsFrameWorkInitSuccees() {
        for (Map.Entry<String, String> entry : mWeexCoreEnvOptions.entrySet()) {
            this.mWXBridge.registerCoreEnv(entry.getKey(), entry.getValue());
        }
        mWeexCoreEnvOptions.clear();
    }

    private void registerDomModule() throws WXException {
        HashMap hashMap = new HashMap();
        hashMap.put(WXDomModule.WXDOM, WXDomModule.METHODS);
        registerModules(hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeTaskByInstance(String str) {
        this.mNextTickTasks.removeFromMapAndStack(str);
    }

    private void sendMessage(String str, int i) {
        Message obtain = Message.obtain(this.mJSHandler);
        obtain.obj = str;
        obtain.what = i;
        obtain.sendToTarget();
    }

    private void setExceedGPULimitComponentsInfo(String str, String str2, GraphicSize graphicSize) {
        float openGLRenderLimitValue = (float) WXRenderManager.getOpenGLRenderLimitValue();
        if (openGLRenderLimitValue <= 0.0f) {
            return;
        }
        if (graphicSize.getHeight() > openGLRenderLimitValue || graphicSize.getWidth() > openGLRenderLimitValue) {
            JSONObject jSONObject = new JSONObject();
            WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(str, str2);
            jSONObject.put("GPU limit", (Object) String.valueOf(openGLRenderLimitValue));
            jSONObject.put("component.width", (Object) String.valueOf(graphicSize.getWidth()));
            jSONObject.put("component.height", (Object) String.valueOf(graphicSize.getHeight()));
            if (wXComponent.getComponentType() != null && !wXComponent.getComponentType().isEmpty()) {
                jSONObject.put("component.type", (Object) wXComponent.getComponentType());
            }
            if (wXComponent.getStyles() != null && !wXComponent.getStyles().isEmpty()) {
                jSONObject.put("component.style", (Object) wXComponent.getStyles().toString());
            }
            if (wXComponent.getAttrs() != null && !wXComponent.getAttrs().isEmpty()) {
                jSONObject.put("component.attr", (Object) wXComponent.getAttrs().toString());
            }
            if (wXComponent.getEvents() != null && !wXComponent.getEvents().isEmpty()) {
                jSONObject.put("component.event", (Object) wXComponent.getEvents().toString());
            }
            if (wXComponent.getMargin() != null) {
                jSONObject.put("component.margin", (Object) wXComponent.getMargin().toString());
            }
            if (wXComponent.getPadding() != null) {
                jSONObject.put("component.padding", (Object) wXComponent.getPadding().toString());
            }
            if (wXComponent.getBorder() != null) {
                jSONObject.put("component.border", (Object) wXComponent.getBorder().toString());
            }
            WXSDKManager.v().y(str).setComponentsInfoExceedGPULimit(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setJSFrameworkInit(boolean z) {
        mInit = z;
        WXStateRecord d = WXStateRecord.d();
        d.n("setJsfmInitFlag:" + z);
        if (z) {
            onJsFrameWorkInitSuccees();
            JSEngine.getInstance().engineInitFinished();
        }
    }

    private void trackComponentAndModulesTime() {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass26 */

            public void run() {
                WXEnvironment.sComponentsAndModulesReadyTime = System.currentTimeMillis() - WXEnvironment.sSDKInitStart;
            }
        });
    }

    public static void updateGlobalConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "none";
        }
        if (!TextUtils.equals(str, globalConfig)) {
            globalConfig = str;
            WXEnvironment.addCustomOptions(GLOBAL_CONFIG_KEY, str);
            AnonymousClass30 r1 = new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass30 */

                public void run() {
                    if (WXBridgeManager.mBridgeManager != null && WXBridgeManager.mBridgeManager.isJSFrameworkInit() && (WXBridgeManager.mBridgeManager.mWXBridge instanceof WXBridge)) {
                        ((WXBridge) WXBridgeManager.mBridgeManager.mWXBridge).nativeUpdateGlobalConfig(WXBridgeManager.globalConfig);
                    }
                    if (WXBridgeManager.globalConfig.contains(WXWsonJSONSwitch.WSON_OFF)) {
                        WXWsonJSONSwitch.USE_WSON = false;
                    } else {
                        WXWsonJSONSwitch.USE_WSON = true;
                    }
                }
            };
            if (mBridgeManager == null || !mBridgeManager.isJSFrameworkInit()) {
                r1.run();
            } else {
                mBridgeManager.post(r1);
            }
        }
    }

    public void asyncCallJSEventVoidResult(final String str, final String str2, final List<Object> list, final Object... objArr) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass10 */

            public void run() {
                try {
                    Object[] objArr = objArr;
                    if (objArr == null) {
                        return;
                    }
                    if (objArr.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : objArr) {
                            arrayList.add(obj);
                        }
                        if (list != null) {
                            ArrayMap arrayMap = new ArrayMap(4);
                            arrayMap.put("params", list);
                            arrayList.add(arrayMap);
                        }
                        WXHashMap wXHashMap = new WXHashMap();
                        wXHashMap.put("method", str);
                        wXHashMap.put("args", arrayList);
                        WXJSObject[] wXJSObjectArr = {new WXJSObject(2, str2), WXWsonJSONSwitch.toWsonOrJsonWXJSObject(new Object[]{wXHashMap})};
                        WXBridgeManager.this.invokeExecJS(String.valueOf(str2), null, WXBridgeManager.METHOD_CALL_JS, wXJSObjectArr, true);
                        wXJSObjectArr[0] = null;
                    }
                } catch (Exception e) {
                    WXLogUtils.e("asyncCallJSEventVoidResult", e);
                }
            }
        });
    }

    public void bindMeasurementToRenderObject(long j) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.bindMeasurementToRenderObject(j);
        }
    }

    public int callAddChildToRichtext(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callAddChildToRichtext arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddChildToRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionAddChildToRichtext graphicActionAddChildToRichtext = new GraphicActionAddChildToRichtext(y, str2, str3, str4, str5, hashMap, hashMap2);
            WXSDKManager.v().G().postGraphicAction(graphicActionAddChildToRichtext.getPageId(), graphicActionAddChildToRichtext);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callAddChildToRichtext exception: ", WXLogUtils.getStackTrace(e));
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddChildToRichtext", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callAddElement(String str, String str2, String str3, int i, String str4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callAddElement arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet2 = this.mDestroyedInstanceId;
        if (hashSet2 != null && hashSet2.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionAddElement graphicActionAddElement = new GraphicActionAddElement(y, str3, str2, str4, i, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3);
            if (z) {
                y.addInActiveAddElementAction(str3, graphicActionAddElement);
                return 1;
            }
            WXSDKManager.v().G().postGraphicAction(str, graphicActionAddElement);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callAddElement exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddElement", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callAddEvent(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callAddEvent arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddEvent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y != null) {
                new GraphicActionAddEvent(y, str2, str3).executeActionOnRender();
            }
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callAddEvent exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddEvent", WXLogUtils.getStackTrace(e), null);
        }
        getNextTick(str);
        return 1;
    }

    public int callAppendTreeCreateFinish(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            WXLogUtils.d("[WXBridgeManager] call callAppendTreeCreateFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAppendTreeCreateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKManager.v().G().postGraphicAction(str, new GraphicActionAppendTreeCreateFinish(WXSDKManager.v().y(str), str2));
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callAppendTreeCreateFinish exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAppendTreeCreateFinish", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callCreateBody(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashSet<String> hashSet, float[] fArr, float[] fArr2, float[] fArr3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            WXLogUtils.d("[WXBridgeManager] call callCreateBody arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callCreateBody", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet2 = this.mDestroyedInstanceId;
        if (hashSet2 != null && hashSet2.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionCreateBody graphicActionCreateBody = new GraphicActionCreateBody(y, str3, str2, hashMap, hashMap2, hashSet, fArr, fArr2, fArr3);
            WXSDKManager.v().G().postGraphicAction(graphicActionCreateBody.getPageId(), graphicActionCreateBody);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callCreateBody exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callCreateBody", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callCreateFinish(String str) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callCreateFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callCreateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            y.getApmForInstance().r("callCreateFinish");
            y.firstScreenCreateInstanceTime(currentTimeMillis);
            WXSDKManager.v().G().postGraphicAction(str, new GraphicActionCreateFinish(y));
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callCreateFinish exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callCreateFinish", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callHasTransitionPros(String str, String str2, HashMap<String, String> hashMap) {
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(str, str2);
        if (wXComponent == null || wXComponent.getTransition() == null || wXComponent.getTransition().getProperties() == null) {
            return -1;
        }
        for (String str3 : wXComponent.getTransition().getProperties()) {
            if (hashMap.containsKey(str3)) {
                return 1;
            }
        }
        return 0;
    }

    public int callLayout(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callLayout arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callLayout", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicSize graphicSize = new GraphicSize((float) i6, (float) i5);
            GraphicPosition graphicPosition = new GraphicPosition((float) i3, (float) i, (float) i4, (float) i2);
            setExceedGPULimitComponentsInfo(str, str2, graphicSize);
            GraphicActionAddElement inActiveAddElementAction = y.getInActiveAddElementAction(str2);
            if (inActiveAddElementAction != null) {
                inActiveAddElementAction.setRTL(z);
                inActiveAddElementAction.setSize(graphicSize);
                inActiveAddElementAction.setPosition(graphicPosition);
                if (!TextUtils.equals(str2, WXComponent.ROOT)) {
                    inActiveAddElementAction.setIndex(i7);
                }
                WXSDKManager.v().G().postGraphicAction(str, inActiveAddElementAction);
                y.removeInActiveAddElmentAction(str2);
                return 1;
            }
            GraphicActionLayout graphicActionLayout = new GraphicActionLayout(y, str2, graphicPosition, graphicSize, z);
            WXSDKManager.v().G().postGraphicAction(graphicActionLayout.getPageId(), graphicActionLayout);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callLayout exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callLayout", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public Object callModuleMethod(String str, String str2, String str3, JSONArray jSONArray) {
        return callModuleMethod(str, str2, str3, jSONArray, null);
    }

    public int callMoveElement(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callMoveElement arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callMoveElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionMoveElement graphicActionMoveElement = new GraphicActionMoveElement(y, str2, str3, i);
            WXSDKManager.v().G().postGraphicAction(graphicActionMoveElement.getPageId(), graphicActionMoveElement);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callMoveElement exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callMoveElement", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callNative(String str, JSONArray jSONArray, String str2) {
        int i;
        int i2;
        JSONArray jSONArray2 = jSONArray;
        if (TextUtils.isEmpty(str) || jSONArray2 == null) {
            WXLogUtils.d("[WXBridgeManager] call callNative arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNative", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        long nanoTime = System.nanoTime() - System.nanoTime();
        int i3 = 1;
        if (jSONArray.size() > 0) {
            int size = jSONArray.size();
            int i4 = 0;
            while (i4 < size) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray2.get(i4);
                    if (!(jSONObject == null || WXSDKManager.v().y(str) == null)) {
                        Object obj = jSONObject.get("module");
                        if (obj == null) {
                            i2 = i4;
                            i = size;
                            if (jSONObject.get("component") != null) {
                                WXDomModule domModule = WXModuleManager.getDomModule(str);
                                WXStateRecord d = WXStateRecord.d();
                                d.i(str, "callDomMethod:" + str + "," + jSONObject.get("method"));
                                domModule.invokeMethod((String) jSONObject.get("ref"), (String) jSONObject.get("method"), (JSONArray) jSONObject.get("args"));
                            } else {
                                throw new IllegalArgumentException("unknown callNative");
                            }
                        } else if (WXDomModule.WXDOM.equals(obj)) {
                            WXDomModule domModule2 = WXModuleManager.getDomModule(str);
                            long[] jArr = new long[i3];
                            jArr[0] = nanoTime;
                            domModule2.callDomMethod(jSONObject, jArr);
                        } else {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(OPTIONS);
                            WXStateRecord d2 = WXStateRecord.d();
                            d2.i(str, "callModuleMethod:" + str + "," + obj + "," + jSONObject.get("method"));
                            i2 = i4;
                            i = size;
                            callModuleMethod(str, (String) obj, (String) jSONObject.get("method"), (JSONArray) jSONObject.get("args"), jSONObject2);
                        }
                        i4 = i2 + 1;
                        jSONArray2 = jSONArray;
                        size = i;
                        i3 = 1;
                    }
                    i2 = i4;
                    i = size;
                    i4 = i2 + 1;
                    jSONArray2 = jSONArray;
                    size = i;
                    i3 = 1;
                } catch (Exception e) {
                    WXLogUtils.e("[WXBridgeManager] callNative exception: ", e);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNative", WXLogUtils.getStackTrace(e), null);
                }
            }
        }
        if ("undefined".equals(str2) || "-1".equals(str2)) {
            return 0;
        }
        getNextTick(str, str2);
        return 1;
    }

    public Object callNativeComponent(String str, String str2, String str3, JSONArray jSONArray, Object obj) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            WXLogUtils.d("[WXBridgeManager] call callNativeComponent arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeComponent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        try {
            WXDomModule domModule = WXModuleManager.getDomModule(str);
            if (domModule != null) {
                domModule.invokeMethod(str2, str3, jSONArray);
            } else {
                WXSDKInstance y = WXSDKManager.v().y(str);
                if (y == null || !y.isDestroy()) {
                    WXLogUtils.e("WXBridgeManager", "callNativeComponent exception :null == dom ,method:" + str3);
                }
            }
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callNativeComponent exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNativeComponent", WXLogUtils.getStackTrace(e), null);
        }
        return null;
    }

    public Object callNativeModule(String str, String str2, String str3, JSONArray jSONArray, Object obj) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            WXLogUtils.d("[WXBridgeManager] call callNativeModule arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeModule", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        try {
            if (WXDomModule.WXDOM.equals(str2)) {
                return WXModuleManager.getDomModule(str).callDomMethod(str3, jSONArray, new long[0]);
            }
            return callModuleMethod(str, str2, str3, jSONArray);
        } catch (Exception e) {
            String str4 = "[WXBridgeManager] callNative exception: " + WXLogUtils.getStackTrace(e);
            WXLogUtils.e(str4);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNativeModule", str4, null);
            return null;
        }
    }

    public int callRefreshFinish(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callRefreshFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRefreshFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y != null) {
                WXSDKManager.v().G().postGraphicAction(str, new GraphicActionRefreshFinish(y));
            }
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callRefreshFinish exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRefreshFinish", WXLogUtils.getStackTrace(e), null);
        }
        if ("undefined".equals(str2) || "-1".equals(str2)) {
            return 0;
        }
        getNextTick(str, str2);
        return 1;
    }

    public int callRemoveChildFromRichtext(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callRemoveChildFromRichtext arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveChildFromRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionRemoveChildFromRichtext graphicActionRemoveChildFromRichtext = new GraphicActionRemoveChildFromRichtext(y, str2, str3, str4);
            WXSDKManager.v().G().postGraphicAction(graphicActionRemoveChildFromRichtext.getPageId(), graphicActionRemoveChildFromRichtext);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callRemoveChildFromRichtext exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveChildFromRichtext", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callRemoveElement(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callRemoveElement arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionRemoveElement graphicActionRemoveElement = new GraphicActionRemoveElement(y, str2);
            if (y.getInActiveAddElementAction(str2) != null) {
                y.removeInActiveAddElmentAction(str2);
                return 1;
            }
            WXSDKManager.v().G().postGraphicAction(graphicActionRemoveElement.getPageId(), graphicActionRemoveElement);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callRemoveElement exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveElement", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callRemoveEvent(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callRemoveEvent arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveEvent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y != null) {
                new GraphicActionRemoveEvent(y, str2, str3).executeActionOnRender();
            }
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callRemoveEvent exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveEvent", WXLogUtils.getStackTrace(e), null);
        }
        getNextTick(str);
        return 1;
    }

    public int callRenderSuccess(String str) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callRenderSuccess arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRenderSuccess", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            y.getApmForInstance().r("callRenderSuccess");
            WXSDKManager.v().G().postGraphicAction(str, new GraphicActionRenderSuccess(y));
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callRenderSuccess exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRenderSuccess", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public void callReportCrash(String str, final String str2, final String str3, final Map<String, String> map) {
        final String str4 = str + "." + new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        File file = new File(str);
        File file2 = new File(str4);
        if (file.exists()) {
            file.renameTo(file2);
        }
        new Thread(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass6 */

            public void run() {
                try {
                    File file = new File(str4);
                    if (file.exists()) {
                        if (file.length() > 0) {
                            StringBuilder sb = new StringBuilder();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new FileReader(str4));
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else if (!"".equals(readLine)) {
                                        sb.append(readLine + StringUtils.LF);
                                    }
                                }
                                WXBridgeManager.this.commitJscCrashAlarmMonitor(IWXUserTrackAdapter.JS_BRIDGE, WXErrorCode.WX_ERR_JSC_CRASH, sb.toString(), str2, str3, map);
                                bufferedReader.close();
                            } catch (Exception e) {
                                WXLogUtils.e(WXLogUtils.getStackTrace(e));
                            }
                        } else {
                            WXLogUtils.e("[WXBridgeManager] callReportCrash crash file is empty");
                        }
                        if (!WXEnvironment.isApkDebugable()) {
                            file.delete();
                        }
                    }
                } catch (Throwable th) {
                    WXLogUtils.e("[WXBridgeManager] callReportCrash exception: ", th);
                }
            }
        }).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ff  */
    public int callReportCrashReloadPage(String str, String str2) {
        String str3;
        HashMap hashMap;
        String str4;
        Throwable th;
        boolean isEmpty = TextUtils.isEmpty(str2);
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y != null) {
                String bundleUrl = y.getBundleUrl();
                y.setHasException(true);
                str3 = bundleUrl;
            } else {
                str3 = null;
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("weexCoreThreadStackTrace:", getInstance().getWeexCoreThreadStackTrace());
            hashMap2.put("wxStateInfo", WXStateRecord.d().e().toString());
            String str5 = "null";
            if (!isEmpty) {
                try {
                    if (WXEnvironment.getApplication() != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.mInitParams.getCrashFilePath());
                        str4 = str2;
                        try {
                            sb.append(str4);
                            str4 = sb.toString();
                            Log.d("jsengine", "callReportCrashReloadPage crashFile:" + str4);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        str4 = str2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str4 = str2;
                    WXLogUtils.e(WXLogUtils.getStackTrace(th));
                    WXStateRecord d = WXStateRecord.d();
                    if (!TextUtils.isEmpty(str)) {
                    }
                    d.f(str5);
                    callReportCrash(str4, str, str3, hashMap2);
                    hashMap = hashMap2;
                    JSEngine.getInstance().engineCrashed();
                    WXLogUtils.e("reInitCount:" + reInitCount);
                    if (reInitCount <= 50) {
                    }
                }
                WXStateRecord d2 = WXStateRecord.d();
                if (!TextUtils.isEmpty(str)) {
                    str5 = str;
                }
                d2.f(str5);
                callReportCrash(str4, str, str3, hashMap2);
                hashMap = hashMap2;
            } else {
                WXStateRecord d3 = WXStateRecord.d();
                if (!TextUtils.isEmpty(str)) {
                    str5 = str;
                }
                d3.g(str5);
                hashMap = hashMap2;
                commitJscCrashAlarmMonitor(IWXUserTrackAdapter.JS_BRIDGE, WXErrorCode.WX_ERR_RELOAD_PAGE, "reboot jsc Engine", str, str3, hashMap2);
            }
            JSEngine.getInstance().engineCrashed();
            WXLogUtils.e("reInitCount:" + reInitCount);
            if (reInitCount <= 50) {
                WXExceptionUtils.commitCriticalExceptionRT("jsEngine", WXErrorCode.WX_ERR_RELOAD_PAGE_EXCEED_LIMIT, "callReportCrashReloadPage", "reInitCount:" + reInitCount, hashMap);
                return 0;
            }
            reInitCount++;
            if (isEmpty && FeatureSwitches.isOpenWithConfig("restartNewJSThread", "android_weex_ext_config", "restartNewJSThread", false)) {
                this.mJSThread.quit();
                this.mJSThread = null;
                this.mJSHandler = null;
                WXThread wXThread = new WXThread("WeexJSBridgeThread" + reInitCount, this);
                this.mJSThread = wXThread;
                this.mJSHandler = wXThread.getHandler();
            }
            try {
                if (FeatureSwitches.isOpenWithConfig("weexEnableProcessNotify", "android_weex_ext_config", "weexEnableProcessNotify", true)) {
                    Map<String, WXSDKInstance> i = WXSDKManager.v().i();
                    if (i instanceof HashMap) {
                        for (Map.Entry<String, WXSDKInstance> entry : i.entrySet()) {
                            if (!(entry == null || entry.getValue() == null || entry.getValue().getWxProcessNotify() == null)) {
                                WXSDKInstance.WXProcessNotify wxProcessNotify = entry.getValue().getWxProcessNotify();
                                if (isEmpty) {
                                    wxProcessNotify.reboot();
                                } else {
                                    wxProcessNotify.crashed();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            setJSFrameworkInit(false);
            WXModuleManager.resetAllModuleState();
            initScriptsFramework("");
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet != null && hashSet.contains(str)) {
                return -1;
            }
            try {
                if (WXSDKManager.v().y(str) != null) {
                    new ActionReloadPage(str, shouldReloadCurrentInstance(WXSDKManager.v().y(str).getBundleUrl())).executeAction();
                }
            } catch (Exception e) {
                WXLogUtils.e("[WXBridgeManager] callReloadPage exception: ", e);
                WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callReportCrashReloadPage", WXLogUtils.getStackTrace(e), null);
            }
            return 0;
        } catch (Exception e2) {
            WXLogUtils.e("[WXBridgeManager] callReportCrashReloadPage exception: ", e2);
        }
    }

    public int callUpdateAttrs(String str, String str2, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callUpdateAttrs arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateAttrs", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionUpdateAttr graphicActionUpdateAttr = new GraphicActionUpdateAttr(y, str2, hashMap);
            WXSDKManager.v().G().postGraphicAction(graphicActionUpdateAttr.getPageId(), graphicActionUpdateAttr);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callUpdateAttrs exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateAttrs", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callUpdateFinish(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            WXLogUtils.d("[WXBridgeManager] call callUpdateFinish arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKManager.v().y(str);
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callUpdateFinish exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateFinish", WXLogUtils.getStackTrace(e), null);
        }
        if (str2 == null || str2.isEmpty() || "undefined".equals(str2) || "-1".equals(str2)) {
            return 0;
        }
        getNextTick(str, str2);
        return 1;
    }

    public int callUpdateRichtextChildAttr(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callUpdateRichtextChildAttr arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateRichtextChildAttr", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionUpdateRichtextAttr graphicActionUpdateRichtextAttr = new GraphicActionUpdateRichtextAttr(y, str2, hashMap, str3, str4);
            WXSDKManager.v().G().postGraphicAction(graphicActionUpdateRichtextAttr.getPageId(), graphicActionUpdateRichtextAttr);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callUpdateRichtextChildAttr exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateRichtextChildAttr", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callUpdateRichtextStyle(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callUpdateRichtextStyle arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateRichtextStyle", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionUpdateRichtextStyle graphicActionUpdateRichtextStyle = new GraphicActionUpdateRichtextStyle(y, str2, hashMap, str3, str4);
            WXSDKManager.v().G().postGraphicAction(graphicActionUpdateRichtextStyle.getPageId(), graphicActionUpdateRichtextStyle);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callUpdateRichtextStyle exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateRichtextStyle", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callUpdateStyle(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, HashMap<String, String> hashMap4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("[WXBridgeManager] call callUpdateStyle arguments is null");
            }
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateStyle", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            WXSDKInstance y = WXSDKManager.v().y(str);
            if (y == null) {
                return 1;
            }
            GraphicActionUpdateStyle graphicActionUpdateStyle = new GraphicActionUpdateStyle(y, str2, hashMap, hashMap2, hashMap3, hashMap4);
            WXSDKManager.v().G().postGraphicAction(graphicActionUpdateStyle.getPageId(), graphicActionUpdateStyle);
            return 1;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callUpdateStyle exception: ", e);
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateStyle", WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    @Deprecated
    public void callback(String str, String str2, String str3) {
        callback(str, str2, str3, false);
    }

    /* access modifiers changed from: package-private */
    public void callbackJavascript(String str, final String str2, final Object obj, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.mJSHandler != null) {
            final WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
            if (wXSDKInstance != null && wXSDKInstance.isUsingEaglePlugin()) {
                int isSupportJSCallback = wXSDKInstance.getEaglePlugin().isSupportJSCallback(str);
                if (isSupportJSCallback != 0) {
                    callbackJavascriptOnDataRender(wXSDKInstance.getEaglePlugin(), str, str2, obj, z);
                    if (isSupportJSCallback == 1) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!(wXSDKInstance == null || wXSDKInstance.getReactorPage() == null)) {
                if (getInstance().getJSLooper() == Looper.myLooper()) {
                    wXSDKInstance.getReactorPage().invokeCallBack(str2, JSON.toJSONString(obj));
                } else {
                    getInstance().post(new Runnable() {
                        /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass15 */

                        public void run() {
                            wXSDKInstance.getReactorPage().invokeCallBack(str2, JSON.toJSONString(obj));
                        }
                    });
                }
            }
            addJSTask(METHOD_CALLBACK, str, str2, obj, Boolean.valueOf(z));
            sendMessage(str, 6);
        }
    }

    /* access modifiers changed from: package-private */
    public void callbackJavascriptOnDataRender(final WXEaglePlugin wXEaglePlugin, final String str, final String str2, final Object obj, final boolean z) {
        this.mJSHandler.postDelayed(WXThread.secure(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass16 */

            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String jSONString = JSON.toJSONString(obj);
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.d("callbackJavascriptOnDataRender >>>> instanceId:" + str + ", data:" + jSONString);
                    }
                    wXEaglePlugin.invokeJSCallback(str, str2, jSONString, z);
                    WXLogUtils.renderPerformanceLog("callbackJavascriptOnDataRender", System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    String str = "[WXBridgeManager] callbackJavascriptOnDataRender " + WXLogUtils.getStackTrace(th);
                    WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callbackJavascriptOnDataRender", str, null);
                    WXLogUtils.e(str);
                }
            }
        }), 0);
    }

    public void checkJsEngineMultiThread() {
        IWXJscProcessManager F = WXSDKManager.v().F();
        boolean enableBackupThread = F != null ? F.enableBackupThread() : false;
        if (enableBackupThread != isJsEngineMultiThreadEnable) {
            isJsEngineMultiThreadEnable = enableBackupThread;
            if (!isJSFrameworkInit()) {
                return;
            }
            if (isJSThread()) {
                WXSDKEngine.reload();
            } else {
                post(new Runnable() {
                    /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass2 */

                    public void run() {
                        WXSDKEngine.reload();
                    }
                });
            }
        }
    }

    public void commitJscCrashAlarmMonitor(String str, WXErrorCode wXErrorCode, String str2, String str3, String str4, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && wXErrorCode != null) {
            Log.d("ReportCrash", " commitJscCrashAlarmMonitor errMsg " + str2);
            HashMap hashMap = new HashMap();
            hashMap.put("jscCrashStack", str2);
            if (map != null) {
                hashMap.putAll(map);
            }
            IWXJSExceptionAdapter p = WXSDKManager.v().p();
            if (p != null) {
                WXJSExceptionInfo wXJSExceptionInfo = new WXJSExceptionInfo(str3, str4, wXErrorCode, "callReportCrash", "weex core process crash and restart exception", hashMap);
                p.onJSException(wXJSExceptionInfo);
                WXLogUtils.e(wXJSExceptionInfo.toString());
            }
        }
    }

    public void createInstance(String str, String str2, Map<String, Object> map, String str3) {
        createInstance(str, new s42(str2), map, str3);
    }

    public void destroy() {
        WXThread wXThread = this.mJSThread;
        if (wXThread != null) {
            wXThread.quit();
        }
        mBridgeManager = null;
        HashSet<String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public void destroyInstance(final String str) {
        if (this.mJSHandler != null && !TextUtils.isEmpty(str)) {
            HashSet<String> hashSet = this.mDestroyedInstanceId;
            if (hashSet != null) {
                hashSet.add(str);
            }
            this.mJSHandler.removeCallbacksAndMessages(str);
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass22 */

                public void run() {
                    WXBridgeManager.this.removeTaskByInstance(str);
                    WXBridgeManager.this.invokeDestroyInstance(str);
                }
            }, str, null, METHOD_DESTROY_INSTANCE);
        }
    }

    public String dumpIpcPageInfo() {
        IWXBridge iWXBridge = this.mWXBridge;
        return iWXBridge instanceof WXBridge ? ((WXBridge) iWXBridge).nativeDumpIpcPageQueueInfo() : "";
    }

    public void execJSService(final String str) {
        postWithName(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass29 */

            public void run() {
                WXBridgeManager wXBridgeManager = WXBridgeManager.this;
                wXBridgeManager.invokeExecJSService(str, wXBridgeManager.mRegisterServiceFailList);
            }
        }, null, "execJSService");
    }

    @Deprecated
    public void fireEvent(String str, String str2, String str3, Map<String, Object> map) {
        fireEvent(str, str2, str3, map, null);
    }

    public void fireEventOnNode(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        fireEventOnNode(str, str2, str3, map, map2, null, null);
    }

    @UiThread
    public void forceLayout(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.forceLayout(str);
        }
    }

    public BundType getBundleType(String str, String str2) {
        if (str != null) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(BUNDLE_TYPE);
                if (!"Vue".equals(queryParameter)) {
                    if (!"vue".equals(queryParameter)) {
                        if ("Rax".equals(queryParameter) || "rax".equals(queryParameter)) {
                            return BundType.Rax;
                        }
                    }
                }
                return BundType.Vue;
            } catch (Throwable th) {
                WXLogUtils.e(WXLogUtils.getStackTrace(th));
                return BundType.Others;
            }
        }
        if (str2 != null) {
            int indexOf = str2.indexOf(WVUtils.URL_SEPARATOR);
            String string = JSON.parseObject(str2.substring(indexOf + 2, str2.indexOf(StringUtils.LF, indexOf))).getString("framework");
            if ("vue".equalsIgnoreCase(string)) {
                return BundType.Vue;
            }
            if ("rax".equalsIgnoreCase(string)) {
                return BundType.Rax;
            }
            if (Pattern.compile("(use)(\\s+)(weex:vue)", 2).matcher(str2).find()) {
                return BundType.Vue;
            }
            if (Pattern.compile("(use)(\\s+)(weex:rax)", 2).matcher(str2).find()) {
                return BundType.Rax;
            }
        }
        return BundType.Others;
    }

    public long[] getFirstScreenRenderTime(String str) {
        return isJSFrameworkInit() ? this.mWXBridge.getFirstScreenRenderTime(str) : new long[]{0, 0, 0};
    }

    public WXParams getInitParams() {
        return this.mInitParams;
    }

    @Nullable
    public Looper getJSLooper() {
        WXThread wXThread = this.mJSThread;
        if (wXThread != null) {
            return wXThread.getLooper();
        }
        return null;
    }

    public ContentBoxMeasurement getMeasurementFunc(String str, long j) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            return y.getContentBoxMeasurement(j);
        }
        return null;
    }

    public long[] getRenderFinishTime(String str) {
        return isJSFrameworkInit() ? this.mWXBridge.getRenderFinishTime(str) : new long[]{0, 0, 0};
    }

    public String getWeexCoreThreadStackTrace() {
        if (this.mJSThread == null) {
            return "null == mJSThread";
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("Thread Name: '%s'\n", this.mJSThread.getName()));
            sb.append(String.format(Locale.ENGLISH, "\"%s\" prio=%d tid=%d %s\n", this.mJSThread.getName(), Integer.valueOf(this.mJSThread.getPriority()), Long.valueOf(this.mJSThread.getId()), this.mJSThread.getState()));
            StackTraceElement[] stackTrace = this.mJSThread.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("\tat %s\n", stackTrace[i].toString()));
            }
        } catch (Exception e) {
            Log.e("weex", "getJSThreadStackTrace error:", e);
        }
        return sb.toString();
    }

    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        int i = message.what;
        if (i == 1) {
            TimerInfo timerInfo = (TimerInfo) message.obj;
            if (timerInfo != null) {
                invokeExecJS("", null, METHOD_SET_TIMEOUT, new WXJSObject[]{new WXJSObject(2, timerInfo.callbackId)});
            }
        } else if (i == 13) {
            Object obj = message.obj;
            if (obj != null) {
                this.mWXBridge.takeHeapSnapshot((String) obj);
            }
        } else if (i == 6) {
            invokeCallJSBatch(message);
        } else if (i == 7) {
            invokeInitFramework(message);
        }
        return false;
    }

    public synchronized void initScriptsFramework(String str) {
        Message obtainMessage = this.mJSHandler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 7;
        obtainMessage.setTarget(this.mJSHandler);
        obtainMessage.sendToTarget();
    }

    public int invokeCreateInstanceContext(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, boolean z) {
        WXLogUtils.d("invokeCreateInstanceContext instanceId:" + str + " function:" + str3 + String.format(" isJSFrameworkInit：%b", Boolean.valueOf(isJSFrameworkInit())));
        StringBuilder sb = this.mLodBuilder;
        sb.append("createInstanceContext >>>> instanceId:");
        sb.append(str);
        sb.append("function:");
        sb.append(str3);
        if (z) {
            StringBuilder sb2 = this.mLodBuilder;
            sb2.append(" tasks:");
            sb2.append(WXJsonUtils.fromObjectToJSONString(wXJSObjectArr));
        }
        WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        return this.mWXBridge.createInstanceContext(str, str2, str3, wXJSObjectArr);
    }

    public void invokeDestoryInstance(String str, String str2, String str3, WXJSObject[] wXJSObjectArr, boolean z) {
        StringBuilder sb = this.mLodBuilder;
        sb.append("callJS >>>> instanceId:");
        sb.append(str);
        sb.append("function:");
        sb.append(str3);
        if (z) {
            StringBuilder sb2 = this.mLodBuilder;
            sb2.append(" tasks:");
            sb2.append(WXJsonUtils.fromObjectToJSONString(wXJSObjectArr));
        }
        WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        this.mWXBridge.removeInstanceRenderType(str);
        this.mWXBridge.destoryInstance(str, str2, str3, wXJSObjectArr);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isJSFrameworkInit() {
        return mInit;
    }

    public boolean isJSThread() {
        WXThread wXThread = this.mJSThread;
        return wXThread != null && wXThread.getId() == Thread.currentThread().getId();
    }

    public boolean isRebootExceedLimit() {
        return reInitCount > 50;
    }

    public boolean jsEngineMultiThreadEnable() {
        return isJsEngineMultiThreadEnable;
    }

    public void loadJsBundleInPreInitMode(final String str, final String str2) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass8 */

            public void run() {
                WXBridgeManager.this.invokeExecJSOnInstance(str, str2, -1);
                WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
                if (wXSDKInstance != null && wXSDKInstance.isPreInitMode()) {
                    wXSDKInstance.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                    wXSDKInstance.getApmForInstance().s(WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, WXUtils.getFixUnixTime() + 600);
                }
            }
        });
    }

    public void markDirty(String str, String str2, boolean z) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.markDirty(str, str2, z);
        }
    }

    @UiThread
    public boolean notifyLayout(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            return this.mWXBridge.notifyLayout(str);
        }
        return false;
    }

    public void notifySerializeCodeCache() {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass31 */

            public void run() {
                if (WXBridgeManager.this.isJSFrameworkInit()) {
                    WXBridgeManager.this.invokeExecJS("", null, WXBridgeManager.METHOD_NOTIFY_SERIALIZE_CODE_CACHE, new WXJSObject[0]);
                }
            }
        });
    }

    @Deprecated
    public void notifyTrimMemory() {
    }

    public void onInstanceClose(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.onInstanceClose(str);
        }
    }

    public void onInteractionTimeUpdate(final String str) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass1 */

            public void run() {
                if (WXBridgeManager.this.mWXBridge instanceof WXBridge) {
                    ((WXBridge) WXBridgeManager.this.mWXBridge).nativeOnInteractionTimeUpdate(str);
                }
            }
        });
    }

    public WXJSObject optionObjConvert(boolean z, BundType bundType, WXJSObject wXJSObject) {
        JSONObject jSONObject;
        if (!z) {
            return wXJSObject;
        }
        try {
            JSONObject parseObject = JSON.parseObject(wXJSObject.data.toString());
            JSONObject jSONObject2 = parseObject.getJSONObject("env");
            if (!(jSONObject2 == null || (jSONObject = jSONObject2.getJSONObject(OPTIONS)) == null)) {
                for (String str : jSONObject.keySet()) {
                    jSONObject2.put(str, (Object) jSONObject.getString(str));
                }
            }
            return new WXJSObject(3, parseObject.toString());
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
            return wXJSObject;
        }
    }

    @Override // com.taobao.weex.utils.batch.BactchExecutor
    public void post(Runnable runnable) {
        postWithName(runnable, null, null);
    }

    public void postDelay(Runnable runnable, long j) {
        Handler handler = this.mJSHandler;
        if (handler != null) {
            handler.postDelayed(WXThread.secure(runnable), j);
        }
    }

    public void postWithName(Runnable runnable, WXSDKInstance wXSDKInstance, String str) {
        Handler handler;
        Runnable secure = WXThread.secure(runnable, wXSDKInstance, str);
        Interceptor interceptor = this.mInterceptor;
        if ((interceptor == null || !interceptor.take(secure)) && (handler = this.mJSHandler) != null) {
            handler.post(secure);
        }
    }

    public void refreshInstance(final String str, final WXRefreshData wXRefreshData) {
        if (!TextUtils.isEmpty(str) && wXRefreshData != null) {
            this.mJSHandler.postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass17 */

                public void run() {
                    WXBridgeManager.this.invokeRefreshInstance(str, wXRefreshData);
                }
            }), 0);
        }
    }

    public void registerComponents(final List<Map<String, Object>> list) {
        if (this.mJSHandler != null && list != null && list.size() != 0) {
            AnonymousClass28 r0 = new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass28 */

                public void run() {
                    WXBridgeManager wXBridgeManager = WXBridgeManager.this;
                    wXBridgeManager.invokeRegisterComponents(list, wXBridgeManager.mRegisterComponentFailList);
                }
            };
            if (!isJSThread() || !isJSFrameworkInit()) {
                post(r0);
            } else {
                r0.run();
            }
        }
    }

    public void registerCoreEnv(String str, String str2) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.registerCoreEnv(str, str2);
        } else {
            mWeexCoreEnvOptions.put(str, str2);
        }
    }

    public void registerModules(final Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            if (isJSThread()) {
                invokeRegisterModules(map, this.mRegisterModuleFailList);
            } else {
                post(new Runnable() {
                    /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass27 */

                    public void run() {
                        WXBridgeManager wXBridgeManager = WXBridgeManager.this;
                        wXBridgeManager.invokeRegisterModules(map, wXBridgeManager.mRegisterModuleFailList);
                    }
                });
            }
        }
    }

    public void reloadPageLayout(String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.reloadPageLayout(str);
        }
    }

    public void removeMessage(int i, Object obj) {
        WXThread wXThread;
        if (this.mJSHandler != null && (wXThread = this.mJSThread) != null && wXThread.isWXThreadAlive() && this.mJSThread.getLooper() != null) {
            this.mJSHandler.removeMessages(i, obj);
        }
    }

    public void reportJSException(String str, String str2, String str3) {
        WXSDKInstance y;
        WXLogUtils.e("reportJSException >>>> instanceId:" + str + ", exception function:" + str2 + ", exception:" + str3);
        WXErrorCode wXErrorCode = WXErrorCode.WX_ERR_JS_EXECUTE;
        if (!(str == null || (y = WXSDKManager.v().y(str)) == null)) {
            y.setHasException(true);
            str3 = str3 + "\n getTemplateInfo==" + y.getTemplateInfo();
            if (METHOD_CREATE_INSTANCE.equals(str2) || !y.isContentMd5Match()) {
                try {
                    if (isSkipFrameworkInit(str) || !isJSFrameworkInit() || reInitCount <= 1 || reInitCount >= 10 || y.isNeedReLoad()) {
                        StringBuilder sb = new StringBuilder();
                        WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
                        sb.append(wXErrorCode2.getErrorMsg());
                        sb.append(", exception function:");
                        sb.append(str2);
                        sb.append(", exception:");
                        sb.append(str3);
                        sb.append(", extInitTime:");
                        sb.append(System.currentTimeMillis() - sInitFrameWorkTimeOrigin);
                        sb.append("ms");
                        sb.append(", extInitErrorMsg:");
                        sb.append(sInitFrameWorkMsg.toString());
                        y.onRenderError(wXErrorCode2.getErrorCode(), sb.toString());
                        if (!WXEnvironment.sInAliWeex) {
                            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE, str2, str3, null);
                            return;
                        }
                        return;
                    }
                    new ActionReloadPage(str, true).executeAction();
                    y.setNeedLoad(true);
                    return;
                } catch (Exception e) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(e));
                }
            }
            if (METHOD_CREATE_INSTANCE.equals(str2) && !y.getApmForInstance().o) {
                wXErrorCode = WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE;
            } else if (METHOD_CREATE_INSTANCE_CONTEXT.equals(str2) && !y.getApmForInstance().o) {
                wXErrorCode = WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT;
            } else if ((METHOD_UPDATE_COMPONENT_WITH_DATA.equals(str2) || METHOD_CREATE_PAGE_WITH_CONTENT.equals(str2) || METHOD_POST_TASK_TO_MSG_LOOP.equals(str2) || METHOD_JSFM_NOT_INIT_IN_EAGLE_MODE.equals(str2)) && !y.getApmForInstance().o) {
                wXErrorCode = WXErrorCode.WX_DEGRAD_EAGLE_RENDER_ERROR;
            }
            y.onJSException(wXErrorCode.getErrorCode(), str2, str3);
        }
        doReportJSException(str, str2, wXErrorCode, str3);
    }

    public void restart() {
        setJSFrameworkInit(false);
        WXModuleManager.resetAllModuleState();
        initWXBridge(WXEnvironment.sRemoteDebugMode);
        this.mWXBridge.resetWXBridge(WXEnvironment.sRemoteDebugMode);
    }

    public void sendMessageDelayed(Message message, long j) {
        WXThread wXThread;
        if (message != null && this.mJSHandler != null && (wXThread = this.mJSThread) != null && wXThread.isWXThreadAlive() && this.mJSThread.getLooper() != null) {
            this.mJSHandler.sendMessageDelayed(message, j);
        }
    }

    public void setDefaultRootSize(String str, float f, float f2, boolean z, boolean z2) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setDefaultHeightAndWidthIntoRootDom(str, f, f2, z, z2);
        }
    }

    public void setDeviceDisplay(final String str, final float f, final float f2, final float f3) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass32 */

            public void run() {
                WXBridgeManager.this.mWXBridge.setDeviceDisplay(str, f, f2, f3);
            }
        });
    }

    public void setDeviceDisplayOfPage(String str, float f, float f2) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setDeviceDisplayOfPage(str, f, f2);
        }
    }

    @Override // com.taobao.weex.utils.batch.BactchExecutor
    public void setInterceptor(Interceptor interceptor) {
        this.mInterceptor = interceptor;
    }

    public void setLogLevel(final int i, final boolean z) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass18 */

            public void run() {
                if (WXBridgeManager.this.mWXBridge != null) {
                    WXBridgeManager.this.mWXBridge.setLogType((float) i, z);
                }
            }
        });
    }

    public void setMargin(String str, String str2, CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setMargin(str, str2, edge, f);
        }
    }

    public void setPadding(String str, String str2, CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPadding(str, str2, edge, f);
        }
    }

    public void setPageArgument(String str, String str2, String str3) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPageArgument(str, str2, str3);
        }
    }

    public void setPosition(String str, String str2, CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPosition(str, str2, edge, f);
        }
    }

    public void setRenderContentWrapContentToCore(boolean z, String str) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.setRenderContainerWrapContent(z, str);
        }
    }

    public void setSandBoxContext(boolean z) {
        String str;
        if (z != isSandBoxContext) {
            isSandBoxContext = z;
            if (isJSThread()) {
                setJSFrameworkInit(false);
                WXModuleManager.resetAllModuleState();
                if (!isSandBoxContext) {
                    str = WXFileUtils.loadAsset("main.js", WXEnvironment.getApplication());
                } else {
                    str = WXFileUtils.loadAsset("weex-main-jsfm.js", WXEnvironment.getApplication());
                }
                initFramework(str);
                WXServiceManager.reload();
                WXModuleManager.reload();
                WXComponentRegistry.reload();
                return;
            }
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass3 */

                public void run() {
                    String str;
                    WXBridgeManager.this.setJSFrameworkInit(false);
                    WXModuleManager.resetAllModuleState();
                    if (!WXBridgeManager.isSandBoxContext) {
                        str = WXFileUtils.loadAsset("main.js", WXEnvironment.getApplication());
                    } else {
                        str = WXFileUtils.loadAsset("weex-main-jsfm.js", WXEnvironment.getApplication());
                    }
                    WXBridgeManager.this.initFramework(str);
                    WXServiceManager.reload();
                    WXModuleManager.reload();
                    WXComponentRegistry.reload();
                }
            });
        }
    }

    public synchronized void setStackTopInstance(final String str) {
        post(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass5 */

            public void run() {
                WXBridgeManager.this.mNextTickTasks.setStackTopInstance(str);
            }
        }, str, null, null);
    }

    public void setStyleHeight(String str, String str2, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setStyleHeight(str, str2, f);
        }
    }

    public void setStyleWidth(String str, String str2, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setStyleWidth(str, str2, f);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTimeout(String str, String str2) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        TimerInfo timerInfo = new TimerInfo();
        timerInfo.callbackId = str;
        long parseFloat = (long) Float.parseFloat(str2);
        timerInfo.time = parseFloat;
        obtain.obj = timerInfo;
        this.mJSHandler.sendMessageDelayed(obtain, parseFloat);
    }

    public void setUseSingleProcess(boolean z) {
        if (z != isUseSingleProcess) {
            isUseSingleProcess = z;
        }
    }

    public void setViewPortWidth(String str, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setViewPortWidth(str, f);
        }
    }

    public boolean shouldReloadCurrentInstance(String str) {
        Uri parse;
        long currentTimeMillis = System.currentTimeMillis();
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J != null) {
            boolean parseBoolean = Boolean.parseBoolean(J.getConfig("android_weex_ext_config", "check_biz_url", "true"));
            WXLogUtils.e("check_biz_url : " + parseBoolean);
            if (parseBoolean && !TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                str = parse.buildUpon().clearQuery().build().toString();
            }
        }
        String str2 = crashUrl;
        if (str2 == null || ((str2 != null && !str2.equals(str)) || currentTimeMillis - lastCrashTime > 15000)) {
            crashUrl = str;
            lastCrashTime = currentTimeMillis;
            return true;
        }
        lastCrashTime = currentTimeMillis;
        return false;
    }

    public void stopRemoteDebug() {
        Method method;
        if (this.mWxDebugProxy != null) {
            try {
                if (clazz_debugProxy == null) {
                    clazz_debugProxy = DebugServerProxy.class;
                }
                Class cls = clazz_debugProxy;
                if (cls != null && (method = cls.getMethod("stop", Boolean.TYPE)) != null) {
                    method.invoke(this.mWxDebugProxy, Boolean.TRUE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public EventResult syncCallJSEventWithResult(String str, String str2, List<Object> list, Object... objArr) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AnonymousClass9 r1 = new EventResult() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass9 */

            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            asyncCallJSEventWithResult(r1, str, str2, list, objArr);
            countDownLatch.await(100, TimeUnit.MILLISECONDS);
            return r1;
        } catch (Exception e) {
            WXLogUtils.e("syncCallJSEventWithResult", e);
            return r1;
        }
    }

    public String syncExecJsOnInstanceWithResult(String str, String str2, int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AnonymousClass7 r2 = new EventResult() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass7 */

            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            execJSOnInstance(r2, str, str2, i);
            countDownLatch.await(100, TimeUnit.MILLISECONDS);
            if (r2.getResult() != null) {
                return r2.getResult().toString();
            }
            return "";
        } catch (Throwable th) {
            WXLogUtils.e("syncCallExecJsOnInstance", th);
            return "";
        }
    }

    public void takeJSHeapSnapshot(String str) {
        Message obtainMessage = this.mJSHandler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 13;
        obtainMessage.setTarget(this.mJSHandler);
        obtainMessage.sendToTarget();
    }

    public void updateInitDeviceParams(final String str, final String str2, final String str3, final String str4) {
        if (isJSFrameworkInit()) {
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass33 */

                public void run() {
                    WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("deviceWidth", str, "deviceWidth");
                }
            });
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass34 */

                public void run() {
                    WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("deviceHeight", str2, "deviceHeight");
                }
            });
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass35 */

                public void run() {
                    WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("scale", str3, "scale");
                }
            });
            if (str4 != null) {
                post(new Runnable() {
                    /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass36 */

                    public void run() {
                        WXBridgeManager.this.mWXBridge.updateInitFrameworkParams(WXConfig.androidStatusBarHeight, str4, WXConfig.androidStatusBarHeight);
                    }
                });
            }
        }
    }

    public Object callModuleMethod(String str, String str2, String str3, JSONArray jSONArray, JSONObject jSONObject) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y == null) {
            return null;
        }
        if (y.hasModuleIntercept(str2)) {
            y.moduleIntercept(str2, str3, jSONArray, jSONObject);
        }
        if (!y.isNeedValidate() || WXSDKManager.v().B() == null) {
            try {
                return WXModuleManager.callModuleMethod(str, str2, str3, jSONArray);
            } catch (NumberFormatException unused) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("moduleName", str2);
                arrayMap.put("methodName", str3);
                arrayMap.put("args", jSONArray.toJSONString());
                WXLogUtils.e("[WXBridgeManager] callNative : numberFormatException when parsing string to numbers in args", arrayMap.toString());
                return null;
            }
        } else {
            WXValidateProcessor.WXModuleValidateResult onModuleValidate = WXSDKManager.v().B().onModuleValidate(y, str2, str3, jSONArray, jSONObject);
            if (onModuleValidate == null) {
                return null;
            }
            if (onModuleValidate.isSuccess) {
                return WXModuleManager.callModuleMethod(str, str2, str3, jSONArray);
            }
            JSONObject jSONObject2 = onModuleValidate.validateInfo;
            if (jSONObject2 != null) {
                WXLogUtils.e("[WXBridgeManager] module validate fail. >>> " + jSONObject2.toJSONString());
            }
            return jSONObject2;
        }
    }

    @Deprecated
    public void callback(String str, String str2, Map<String, Object> map) {
        callback(str, str2, map, false);
    }

    public void createInstance(final String str, final s42 s42, final Map<String, Object> map, final String str2) {
        final WXSDKInstance y = WXSDKManager.v().y(str);
        if (y == null) {
            WXLogUtils.e("WXBridgeManager", "createInstance failed, SDKInstance does not exist");
            return;
        }
        boolean z = true;
        if (TextUtils.isEmpty(str) || s42 == null || s42.c() || this.mJSHandler == null) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
            String errorCode = wXErrorCode.getErrorCode();
            y.onRenderError(errorCode, wXErrorCode.getErrorMsg() + " instanceId==" + str + " template ==" + s42 + " mJSHandler== " + this.mJSHandler.toString());
            WXInstanceApm apmForInstance = y.getApmForInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("createInstance failed return; ");
            sb.append(TextUtils.isEmpty(str));
            sb.append(",");
            sb.append(s42.c());
            sb.append(",");
            if (this.mJSHandler != null) {
                z = false;
            }
            sb.append(z);
            apmForInstance.r(sb.toString());
        } else if (isSkipFrameworkInit(str) || isJSFrameworkInit() || reInitCount != 1 || WXEnvironment.sDebugServerConnectable) {
            WXModuleManager.createDomModule(y);
            y.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START);
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass20 */

                public void run() {
                    y.getApmForInstance().r("wxLoadBundleStartOnJsThread");
                    long currentTimeMillis = System.currentTimeMillis();
                    WXBridgeManager.this.mWXBridge.setPageArgument(str, "renderTimeOrigin", String.valueOf(y.getWXPerformance().renderTimeOrigin));
                    WXBridgeManager.this.mWXBridge.setInstanceRenderType(y.getInstanceId(), y.getRenderType());
                    WXBridgeManager.this.invokeCreateInstance(y, s42, map, str2);
                    y.getWXPerformance().callCreateInstanceTime = System.currentTimeMillis() - currentTimeMillis;
                    y.getWXPerformance().communicateTime = y.getWXPerformance().callCreateInstanceTime;
                }
            }, str, y, METHOD_CREATE_INSTANCE);
        } else {
            WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
            String errorCode2 = wXErrorCode2.getErrorCode();
            y.onRenderError(errorCode2, wXErrorCode2.getErrorMsg() + " isJSFrameworkInit==" + isJSFrameworkInit() + " reInitCount == 1");
            y.getApmForInstance().r("createInstance failed jsfm isn't init return;");
            post(new Runnable() {
                /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass19 */

                public void run() {
                    WXBridgeManager.this.initFramework("");
                }
            }, str, y, "initFrameworkInCreateInstance");
        }
    }

    @Deprecated
    public void fireEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        fireEventOnNode(str, str2, str3, map, map2);
    }

    public void fireEventOnNode(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2, List<Object> list) {
        fireEventOnNode(str, str2, str3, map, map2, list, null);
    }

    public void invokeExecJS(final String str, final String str2, final String str3, final WXJSObject[] wXJSObjectArr, boolean z) {
        WXEnvironment.isOpenDebugLog();
        long currentTimeMillis = System.currentTimeMillis();
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null && y.isUsingEaglePlugin()) {
            final WXEaglePlugin eaglePlugin = y.getEaglePlugin();
            int isSupportInvokeExecJS = eaglePlugin.isSupportInvokeExecJS(str);
            if (isSupportInvokeExecJS != 0) {
                WXThread.secure(new Runnable() {
                    /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass23 */

                    public void run() {
                        eaglePlugin.invokeExecJS(str, str2, str3, wXJSObjectArr);
                    }
                }, y, "ExecJsEagle").run();
                if (isSupportInvokeExecJS == 1) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_NUM, 1.0d);
                    y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_TIME, (double) currentTimeMillis2);
                    y.callJsTime(currentTimeMillis2);
                    return;
                }
            } else {
                return;
            }
        }
        WXThread.secure(new Runnable() {
            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass24 */

            public void run() {
                WXBridgeManager.this.mWXBridge.execJS(str, str2, str3, wXJSObjectArr);
            }
        }, y, "ExecJs").run();
        if (y != null) {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_NUM, 1.0d);
            y.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_TIME, (double) currentTimeMillis3);
            y.callJsTime(currentTimeMillis3);
        }
    }

    public void post(Runnable runnable, Object obj, WXSDKInstance wXSDKInstance, String str) {
        Handler handler = this.mJSHandler;
        if (handler != null) {
            Message obtain = Message.obtain(handler, WXThread.secure(runnable, wXSDKInstance, str));
            obtain.obj = obj;
            obtain.sendToTarget();
        }
    }

    private void getNextTick(String str) {
        addJSTask(METHOD_CALLBACK, str, "", "{}");
        sendMessage(str, 6);
    }

    private boolean isSkipFrameworkInit(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return false;
        }
        return wXSDKInstance.skipFrameworkInit();
    }

    @Deprecated
    public void callback(String str, String str2, Object obj, boolean z) {
        callbackJavascript(str, str2, obj, z);
    }

    public void fireEventOnNode(String str, final String str2, final String str3, Map<String, Object> map, final Map<String, Object> map2, List<Object> list, EventResult eventResult) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || this.mJSHandler == null)) {
            if (checkMainThread()) {
                final WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(str);
                if (wXSDKInstance != null && wXSDKInstance.isUsingEaglePlugin()) {
                    int isSupportFireEvent = wXSDKInstance.getEaglePlugin().isSupportFireEvent(str);
                    if (isSupportFireEvent != 0) {
                        fireEventOnDataRenderNode(wXSDKInstance.getEaglePlugin(), str, str2, str3, map, map2);
                        if (isSupportFireEvent == 1) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(wXSDKInstance == null || wXSDKInstance.getReactorPage() == null)) {
                    final HashMap hashMap = new HashMap();
                    if (map != null && !map.isEmpty()) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                        }
                    }
                    if (getInstance().getJSLooper() == Looper.myLooper()) {
                        wXSDKInstance.getReactorPage().fireEvent(str2, str3, hashMap, (map2 == null || map2.isEmpty()) ? "{}" : JSON.toJSONString(map2));
                        return;
                    } else {
                        getInstance().post(new Runnable() {
                            /* class com.taobao.weex.bridge.WXBridgeManager.AnonymousClass13 */

                            public void run() {
                                WXReactorPage reactorPage = wXSDKInstance.getReactorPage();
                                String str = str2;
                                String str2 = str3;
                                HashMap hashMap = hashMap;
                                Map map = map2;
                                reactorPage.fireEvent(str, str2, hashMap, (map == null || map.isEmpty()) ? "{}" : JSON.toJSONString(map2));
                            }
                        });
                        return;
                    }
                }
                if (eventResult == null) {
                    addJSEventTask(METHOD_FIRE_EVENT, str, list, str2, str3, map, map2);
                    sendMessage(str, 6);
                    return;
                }
                asyncCallJSEventWithResult(eventResult, METHD_FIRE_EVENT_SYNC, str, list, str2, str3, map, map2);
                return;
            }
            throw new WXRuntimeException("fireEvent must be called by main thread");
        }
    }

    public void post(Runnable runnable, Object obj) {
        post(runnable, obj, null, null);
    }

    public Object callNativeModule(String str, String str2, String str3, JSONArray jSONArray, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            WXLogUtils.d("[WXBridgeManager] call callNativeModule arguments is null");
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeModule", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        WXEnvironment.isApkDebugable();
        try {
            if (!WXDomModule.WXDOM.equals(str2)) {
                return callModuleMethod(str, str2, str3, jSONArray, jSONObject);
            }
            WXDomModule domModule = WXModuleManager.getDomModule(str);
            if (domModule != null) {
                return domModule.callDomMethod(str3, jSONArray, new long[0]);
            }
            WXModuleManager.createDomModule(WXSDKManager.v().y(str));
            return null;
        } catch (Exception e) {
            WXLogUtils.e("[WXBridgeManager] callNativeModule exception: " + WXLogUtils.getStackTrace(e));
        }
    }
}
