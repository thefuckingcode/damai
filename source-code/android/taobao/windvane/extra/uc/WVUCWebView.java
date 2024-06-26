package android.taobao.windvane.extra.uc;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.UCParamData;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.config.WVCookieConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVUCPrecacheManager;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.embed.WVEVManager;
import android.taobao.windvane.extra.config.TBConfigManager;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.jsbridge.WVUCBase;
import android.taobao.windvane.extra.performance.WVErrorManager;
import android.taobao.windvane.extra.performance.WVH5PPManager;
import android.taobao.windvane.extra.performance2.IPerformance;
import android.taobao.windvane.extra.performance2.WVFSPManager;
import android.taobao.windvane.extra.performance2.WVPageTracker;
import android.taobao.windvane.extra.performance2.WVPerformance;
import android.taobao.windvane.extra.performance2.WVWPData;
import android.taobao.windvane.extra.uc.preRender.BasePreInitManager;
import android.taobao.windvane.filter.WVSecurityFilter;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.ha.UCHAManager;
import android.taobao.windvane.ha.WVHAManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVAppEvent;
import android.taobao.windvane.jsbridge.WVBridgeEngine;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVH5PP;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginEntryManager;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVFalco;
import android.taobao.windvane.jsbridge.api.WVFullTrace;
import android.taobao.windvane.jspatch.WVJsPatchListener;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.UserTrackUtil;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.NetWork;
import android.taobao.windvane.util.ReflectUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.view.PopupWindowController;
import android.taobao.windvane.webview.CoreEventCallback;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVRenderPolicy;
import android.taobao.windvane.webview.WVSchemeInterceptService;
import android.taobao.windvane.webview.WVSchemeIntercepterInterface;
import android.taobao.windvane.webview.WVUIModel;
import android.taobao.windvane.webview.WVURLFilter;
import android.taobao.windvane.webview.WindVaneError;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.monitor.procedure.ViewToken;
import com.taobao.orange.OrangeConfig;
import com.taobao.uc.UCSoSettings;
import com.taobao.weaver.prefetch.WMLPrefetch;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.ServiceWorkerController;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.business.BusinessWrapper;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.extension.UCSettings;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;
import tv.cjump.jni.DeviceUtils;

@Keep
/* compiled from: Taobao */
public class WVUCWebView extends WebView implements Handler.Callback, IPerformance, IFullTrace, IWVWebView {
    public static int INNER_FLAG = 0;
    private static final String STATIC_WEBVIEW_URL = "about:blank?static";
    private static final String TAG = "WVUCWebView";
    public static String UC_CORE_URL = UCSoSettings.getInstance().UC_CORE_URL_32;
    private static String UC_PLAYER_URL = UCSoSettings.getInstance().UC_PLAYER_URL;
    private static final String WIFI = "WIFI";
    public static final String WINDVANE = "windvane";
    private static final String _2G = "2g";
    private static final String _3G = "3g";
    private static final String _4G = "4g";
    private static final String _5g = "5g";
    public static String bizId = "windvane";
    private static int coreCode = -1;
    private static CoreEventCallback coreEventCallback = null;
    private static boolean evaluateJavascriptSupported;
    private static int fromType = 70;
    private static int gpuMultiPolicy = 0;
    private static AtomicBoolean initAfterUCCoreReady = new AtomicBoolean(false);
    private static boolean initedJSBridge = false;
    private static boolean isSWInit = false;
    public static boolean isStop;
    private static boolean mDegradeAliNetwork = false;
    private static boolean mUseAliNetwork = true;
    private static boolean mUseSystemWebView = false;
    private static boolean needDownLoad = false;
    private static boolean openUCDebug;
    private static Pattern pattern;
    private static int renderMultiPolicy = 0;
    private static final AtomicBoolean sCoreInitialized = new AtomicBoolean(false);
    private static final SpanWrapper sSpanWrapper = new SpanWrapper();
    private static WVUCWebView sStaticUCWebView;
    private static final AtomicBoolean shouldUCLibInit = new AtomicBoolean(false);
    private AliNetworkAdapter aliRequestAdapter = null;
    public String bizCode = "";
    private String cachedUrl = null;
    private FalcoSpan containerSpan;
    protected Context context;
    private String currentUrl = null;
    private String dataOnActive = null;
    float dx;
    float dy;
    protected WVPluginEntryManager entryManager;
    boolean firstTimeLoad;
    private boolean flag4commit = false;
    StringBuilder injectJs;
    private boolean isLive = false;
    private boolean isPreInit = false;
    boolean isUser;
    private WVJsPatchListener jsPatchListener = null;
    private boolean longPressSaveImage = true;
    private boolean mAllowAllOpen;
    SparseArray<MotionEvent> mEventSparseArray;
    private Hashtable<String, Hashtable<String, String>> mH5MonitorCache;
    protected Handler mHandler = null;
    private String mImageUrl;
    private boolean mIsCoreDestroy = false;
    private boolean mIsStaticWebView;
    private View.OnLongClickListener mLongClickListener;
    private int mPageLoadedCount;
    public long mPageStart;
    private PopupWindowController mPopupController;
    private String[] mPopupMenuTags;
    private final SpanWrapper mSpanWrapper = new SpanWrapper();
    private boolean mUseGlobalUrlConfig;
    private int mWvNativeCallbackId = 1000;
    private long onErrorTime;
    private Map<String, String> openTracingContextMap;
    public WVPageTracker pageTracker = new WVPageTracker();
    private WVPerformance performanceDelegate;
    private String pid;
    private View.OnClickListener popupClickListener;
    private boolean reportedFSP = false;
    protected boolean supportDownload = true;
    private String ucParam = "";
    private String uid;
    private boolean useUrlConfig;
    protected WVUCWebChromeClient webChromeClient;
    protected WVUCWebViewClient webViewClient;
    public WVWPData wpData = new WVWPData();
    public WVErrorManager wvErrorManager = new WVErrorManager();
    private WVSecurityFilter wvSecurityFilter = null;
    private WVUIModel wvUIModel;
    public WVFSPManager wvfspManager = new WVFSPManager();
    public WVH5PPManager wvh5PPManager = new WVH5PPManager(this);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class CorePreparedCallback implements ValueCallback<SetupTask> {
        long startTime = 0;

        CorePreparedCallback(long j) {
            this.startTime = j;
        }

        public void onReceiveValue(SetupTask setupTask) {
            Application application = GlobalConfig.context;
            if (application != null) {
                WVUCWebView.onUCMCoreSwitched(application, this.startTime);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class DecompressCallable implements UCCore.Callable<Boolean, Bundle> {
        private Context mContext;

        public DecompressCallable(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public Boolean call(Bundle bundle) throws Exception {
            TaoLog.d(WVUCWebView.TAG, "decompress parameters:" + bundle);
            ProcessLockUtil processLockUtil = new ProcessLockUtil(this.mContext.getCacheDir() + "/.taobaoDec7zSo.lock");
            try {
                processLockUtil.lock();
                long currentTimeMillis = System.currentTimeMillis();
                this.mContext.getDir("h5container", 0);
                if (WVUCWebView.isMainProcess()) {
                    TaoLog.d(WVUCWebView.TAG, "init on main process, mark uc not init!");
                }
                String string = bundle.getString("decDirPath");
                boolean extractWebCoreLibraryIfNeeded = UCCore.extractWebCoreLibraryIfNeeded(this.mContext, bundle.getString("zipFilePath"), bundle.getString("zipFileType"), string, bundle.getBoolean("deleteAfterExtract"));
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                TaoLog.d(WVUCWebView.TAG, "taobaoDec7zSo elapse " + currentTimeMillis2);
                Boolean valueOf = Boolean.valueOf(extractWebCoreLibraryIfNeeded);
                processLockUtil.unlock();
                return valueOf;
            } catch (Exception e) {
                TaoLog.e(WVUCWebView.TAG, "catch exception ", e, new Object[0]);
                throw e;
            } catch (Throwable th) {
                processLockUtil.unlock();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class DownLoadCallback implements ValueCallback<SetupTask> {
        private DownLoadCallback() {
        }

        public void onReceiveValue(SetupTask setupTask) {
            int percent = setupTask.getPercent();
            if (WVCore.getInstance().getCoreDownLoadBack() != null) {
                WVCore.getInstance().getCoreDownLoadBack().progress(percent);
            }
            TaoLog.i("UCCore", "download progress:[" + percent + "]%");
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static final class DownloadEnv implements Callable<Boolean> {
        Context context;

        DownloadEnv(Context context2) {
            this.context = context2;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            String currentNetworkType = WVUCWebView.getCurrentNetworkType(GlobalConfig.context);
            boolean z = true;
            boolean z2 = GlobalConfig.getInstance().isOpen4GDownload() && TextUtils.equals("4g", currentNetworkType);
            WVCommonConfig.getInstance();
            if (!(WVCommonConfig.commonConfig.open5GAdapter && GlobalConfig.getInstance().isOpen5GDownload() && TextUtils.equals(WVUCWebView._5g, currentNetworkType)) && !z2 && !TextUtils.equals(WVUCWebView.WIFI, currentNetworkType)) {
                z = false;
            }
            if (!z) {
                WVUCWebView.sCoreInitialized.set(false);
                WVUCWebView.shouldUCLibInit.set(false);
                TaoLog.e("UCCore", "current env cannot download u4 core");
            } else {
                TaoLog.i("UCCore", "start download u4 core,is4G=[" + WVCore.getInstance().isOpen4GDownload() + jl1.ARRAY_END_STR);
            }
            return Boolean.valueOf(z);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class ExceptionValueCallback implements ValueCallback<SetupTask> {
        private ExceptionValueCallback() {
        }

        public void onReceiveValue(SetupTask setupTask) {
            WVUCWebView.shouldUCLibInit.set(false);
            WVUCWebView.sCoreInitialized.set(false);
            try {
                if (setupTask.getException() != null) {
                    StringWriter stringWriter = new StringWriter();
                    setupTask.getException().printStackTrace(new PrintWriter(stringWriter));
                    TaoLog.e("UCCore", "UC ExceptionValueCallback : " + stringWriter.toString());
                }
                if (WVCore.getInstance().getCoreDownLoadBack() != null) {
                    WVCore.getInstance().getCoreDownLoadBack().initError();
                }
            } catch (Throwable th) {
                TaoLog.e(WVUCWebView.TAG, "UC ExceptionValueCallback Throwable : " + th.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class OldCoreVersionCallable implements UCCore.Callable<Boolean, String> {
        private OldCoreVersionCallable() {
        }

        public Boolean call(String str) {
            TaoLog.i(WVUCWebView.TAG, "version callable value:" + str);
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class OnInitStart implements ValueCallback<Bundle> {
        private OnInitStart() {
        }

        public void onReceiveValue(Bundle bundle) {
            TaoLog.i(WVUCWebView.TAG, "on init start:[" + bundle + jl1.ARRAY_END_STR);
            if (bundle != null) {
                UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR.equals(bundle.getString(UCCore.OPTION_BUSINESS_INIT_TYPE));
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class SwitchValueCallback implements ValueCallback<SetupTask> {
        long startTime = 0;

        SwitchValueCallback(long j) {
            this.startTime = j;
        }

        public void onReceiveValue(SetupTask setupTask) {
            WVThreadPool.getInstance().execute(new Runnable() {
                /* class android.taobao.windvane.extra.uc.WVUCWebView.SwitchValueCallback.AnonymousClass1 */

                public void run() {
                    if (WVUCWebView.coreEventCallback != null) {
                        WVCoreSettings.getInstance().setCoreEventCallback(WVUCWebView.coreEventCallback);
                    }
                    if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
                        for (CoreEventCallback coreEventCallback : WVCoreSettings.getInstance().coreEventCallbacks) {
                            if (coreEventCallback != null) {
                                coreEventCallback.onCoreSwitch();
                            }
                        }
                    }
                    WVEventService.getInstance().onEvent(WVEventId.WV_CORE_SWITCH);
                    if (!WVCore.getInstance().isUCSupport() && WebView.getCoreType() == 3) {
                        WVCore.getInstance().setUCSupport(true);
                        WVEventService.getInstance().onEvent(3016);
                        TaoLog.i(WVUCWebView.TAG, "UCSDK onUCMCoreSwitched: " + WebView.getCoreType());
                        if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
                            for (CoreEventCallback coreEventCallback2 : WVCoreSettings.getInstance().coreEventCallbacks) {
                                if (coreEventCallback2 != null) {
                                    coreEventCallback2.onUCCorePrepared();
                                }
                            }
                        }
                        if (GlobalConfig.context != null && WVUCWebView.initAfterUCCoreReady.compareAndSet(false, true)) {
                            WVUCWebView.initAfterUCReady(GlobalConfig.context, SwitchValueCallback.this.startTime);
                        }
                    } else if (WebView.getCoreType() == 2) {
                        WVCore.getInstance().setUCSupport(false);
                    }
                }
            });
        }
    }

    /* compiled from: Taobao */
    protected class WVDownLoadListener implements DownloadListener {
        protected WVDownLoadListener() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(WVUCWebView.TAG, "Download start, url: " + str + " contentDisposition: " + str3 + " mimetype: " + str4 + " contentLength: " + j);
            }
            if (!WVUCWebView.this.supportDownload) {
                TaoLog.w(WVUCWebView.TAG, "DownloadListener is not support for webview.");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            try {
                WVUCWebView.this.context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(WVUCWebView.this._getContext(), EnvUtil.isCN() ? "对不起，您的设备找不到相应的程序" : "Can not find the corresponding application", 1).show();
                TaoLog.e(WVUCWebView.TAG, "DownloadListener not found activity to open this url." + e.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    public static class WVValueCallback implements ValueCallback<String> {
        public void onReceiveValue(String str) {
            TaoLog.i(WVUCWebView.TAG, "support : " + WVCore.getInstance().isUCSupport() + " UC SDK Callback : " + str);
            try {
                UserTrackUtil.commitEvent(UserTrackUtil.EVENTID_PA_UCSDK, String.valueOf(WVCore.getInstance().isUCSupport()), String.valueOf(WVUCWebView.getUseTaobaoNetwork()), str);
            } catch (Throwable th) {
                TaoLog.e(WVUCWebView.TAG, "UC commitEvent failed : " + th.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    public interface whiteScreenCallback {
        void isPageEmpty(String str);
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 19) {
            z = false;
        }
        evaluateJavascriptSupported = z;
        TaoLog.d(TAG, "static init uc core");
        if (GlobalConfig.getInstance().getInjectCode() == -1) {
            GlobalConfig.getInstance().setInjectCode(2);
        }
        if (!GlobalConfig.getInstance().isUcCoreOuterControl()) {
            initUCCore();
        }
    }

    public WVUCWebView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i, isUseSystemWebView(context2));
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1 */

            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                Context context = WVUCWebView.this.context;
                                if (context != null) {
                                    ImageTool.saveImageToDCIM(context.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                                }
                            }
                        }).setTaskOnPermissionDenied(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context2;
        init();
    }

    private static boolean checkOldCoreVersion(String str) {
        return false;
    }

    private static void checkSW() {
        try {
            TaoLog.d(TAG, "start to set ServiceWorker client");
            ServiceWorkerController instance = ServiceWorkerController.getInstance();
            if (instance != null) {
                instance.setServiceWorkerClient(new WVUCServiceWorkerClient());
            }
            isSWInit = true;
        } catch (Throwable unused) {
            isSWInit = false;
            TaoLog.w(TAG, "failed to set ServiceWorker client");
        }
    }

    public static void createStaticWebViewIfNeeded(final Context context2) {
        if (isWebViewMultiProcessEnabled()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass4 */

                public void run() {
                    WVUCWebView.createStaticWebViewOnMainThread(context2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void createStaticWebViewOnMainThread(Context context2) {
        TaoLog.i("sandbox", "createStaticWebViewOnMainThread");
        if (sStaticUCWebView == null) {
            WVUCWebView wVUCWebView = new WVUCWebView(context2.getApplicationContext(), true);
            sStaticUCWebView = wVUCWebView;
            wVUCWebView.loadUrl(STATIC_WEBVIEW_URL);
        }
    }

    public static void destroyStaticWebViewIfNeeded() {
        if (isWebViewMultiProcessEnabled()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass5 */

                public void run() {
                    WVUCWebView.destroyStaticWebViewOnMainThread();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void destroyStaticWebViewOnMainThread() {
        TaoLog.i("sandbox", "destroyStaticWebViewOnMainThread");
        WVUCWebView wVUCWebView = sStaticUCWebView;
        if (wVUCWebView != null) {
            wVUCWebView.destroy();
            sStaticUCWebView = null;
        }
    }

    private static String getBusinessDecompressRootDir(Context context2) {
        return UCCore.getExtractRootDirPath(context2);
    }

    private static String getCore7zDecompressDir(Context context2, String str) {
        return UCCore.getExtractDirPath(context2, str);
    }

    public static String getCurrentNetworkType(Context context2) {
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context2.getSystemService("connectivity"));
        if (activeNetworkInfo == null) {
            return "null";
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
            return WIFI;
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 4 || subtype == 1 || subtype == 2) {
                return "2g";
            }
            if (subtype == 3 || subtype == 8 || subtype == 6 || subtype == 5 || subtype == 12) {
                return "3g";
            }
            if (subtype == 13) {
                return "4g";
            }
            WVCommonConfig.getInstance();
            return (!WVCommonConfig.commonConfig.open5GAdapter || subtype != 20) ? "" : _5g;
        }
    }

    public static boolean getDegradeAliNetwork() {
        return mDegradeAliNetwork;
    }

    public static int getFromType() {
        fromType = 70;
        if (WVCore.getInstance().isUCSupport()) {
            fromType = getUseTaobaoNetwork() ? 6 : 5;
        } else if (!mUseSystemWebView) {
            fromType = 71;
        }
        return fromType;
    }

    private static String getMultiProcessPrivateDataDirectorySuffix() {
        if (isMainProcess()) {
            return "0";
        }
        String substring = CommonUtils.getProcessName(GlobalConfig.context).substring(GlobalConfig.context.getPackageName().length() + 1);
        if (substring != null && substring.length() > 0) {
            return substring;
        }
        throw new RuntimeException(String.format("%s getMultiProcessPrivateDataDirectorySuffix failure!Subprocess name: %s illegal.", TAG, CommonUtils.getProcessName(GlobalConfig.context)));
    }

    private static String getOld7zDecompressPath(Context context2) {
        String stringVal = ConfigStorage.getStringVal("WindVane", "UC_PATH");
        TaoLog.i(TAG, "get dex path:[" + stringVal + jl1.ARRAY_END_STR);
        return stringVal;
    }

    @Deprecated
    public static boolean getUCSDKSupport() {
        return WVCore.getInstance().isUCSupport();
    }

    public static boolean getUseTaobaoNetwork() {
        return WVCore.getInstance().isUCSupport() && mUseAliNetwork;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        String str;
        FalcoSpan makeSpanChildOf = FullTraceUtils.makeSpanChildOf("windvanePage", "H5Page", this.isPreInit ? null : getOpenTracingContext());
        this.containerSpan = makeSpanChildOf;
        setFalcoSpan(makeSpanChildOf);
        try {
            setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_INVALID);
            setTag(ViewToken.VIEW_MANUAL_CALCULATE, Boolean.TRUE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.wvh5PPManager.webViewDidStartInit();
        if (!sCoreInitialized.get()) {
            Log.e(TAG, "uc compensation initialization");
            initUCCore();
        }
        if (WVMonitorService.getWvMonitorInterface() != null) {
            WVMonitorService.getWvMonitorInterface().WebViewWrapType(this.context.getClass().getSimpleName());
        }
        this.mIsCoreDestroy = false;
        TaoLog.i(TAG, "uc webview init ");
        setContentDescription(TAG);
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        if (GlobalConfig.getInstance().needSpeed() && !isSWInit) {
            checkSW();
        }
        if (WebView.getCoreType() == 3 && EnvUtil.isAppDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.isLive = true;
        WVCommonConfig.getInstance();
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        setUseTaobaoNetwork(!mDegradeAliNetwork && wVCommonConfigData.ucsdk_alinetwork_rate > Math.random());
        TaoLog.d(TAG, "Webview init setUseTaobaoNetwork =" + getUseTaobaoNetwork());
        WVCommonConfig.getInstance();
        if (!TextUtils.isEmpty(wVCommonConfigData.ucCoreUrl)) {
            String str2 = UC_CORE_URL;
            WVCommonConfig.getInstance();
            if (!str2.equals(wVCommonConfigData.ucCoreUrl)) {
                Application application = GlobalConfig.context;
                WVCommonConfig.getInstance();
                UCCore.update(application, wVCommonConfigData.ucCoreUrl, new Callable<Boolean>() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass6 */

                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        return Boolean.valueOf(NetWork.isConnectionInexpensive());
                    }
                });
            }
        }
        try {
            WVCommonConfig.getInstance();
            if (!TextUtils.isEmpty(wVCommonConfigData.cookieUrlRule)) {
                pattern = Pattern.compile(wVCommonConfigData.cookieUrlRule);
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "Pattern complile Exception" + e.getMessage());
        }
        WVRenderPolicy.disableAccessibility(this.context);
        WebSettings settings = getSettings();
        if (getCurrentViewCoreType() == 2 && Build.VERSION.SDK_INT >= 21 && settings != null) {
            settings.setMixedContentMode(0);
        }
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        int i = Build.VERSION.SDK_INT;
        if (i < 18) {
            settings.setSavePassword(false);
        }
        settings.setDatabaseEnabled(false);
        settings.setDatabasePath(this.context.getApplicationInfo().dataDir + "/localstorage");
        settings.setGeolocationEnabled(true);
        String appTag = GlobalConfig.getInstance().getAppTag();
        String appVersion = GlobalConfig.getInstance().getAppVersion();
        String userAgentString = settings.getUserAgentString();
        if (userAgentString != null) {
            if (!TextUtils.isEmpty(appTag) && !TextUtils.isEmpty(appVersion)) {
                userAgentString = userAgentString + " AliApp(" + appTag + "/" + appVersion + jl1.BRACKET_END_STR;
            }
            if (!userAgentString.contains("UCBS/") && getCurrentViewCoreType() == 3) {
                userAgentString = userAgentString + " UCBS/2.11.1.1";
            }
            if (!userAgentString.contains("TTID/") && !TextUtils.isEmpty(GlobalConfig.getInstance().getTtid())) {
                userAgentString = userAgentString + " TTID/" + GlobalConfig.getInstance().getTtid();
            }
        }
        settings.setUserAgentString(userAgentString + GlobalConfig.DEFAULT_UA);
        settings.setCacheMode(-1);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        UCCore.setGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM, appVersion);
        if (i >= 14) {
            settings.setTextZoom(WebSettings.TextSize.NORMAL.value);
        }
        if (mUseAliNetwork && getUCExtension() != null) {
            getUCExtension().getUCSettings();
            UCSettings.setGlobalIntValue(SettingKeys.UCCookieType, 1);
        }
        if (getCurrentViewCoreType() == 1 || getCurrentViewCoreType() == 3) {
            TaoLog.d(TAG, "init  CurrentViewCoreType()= " + getCurrentViewCoreType());
            WVCore.getInstance().setUCSupport(true);
            if (mUseAliNetwork) {
                AliNetworkAdapter aliNetworkAdapter = new AliNetworkAdapter(this.context.getApplicationContext(), bizId, this);
                this.aliRequestAdapter = aliNetworkAdapter;
                UCCore.setThirdNetwork(aliNetworkAdapter, new AliNetworkDecider());
            }
            WVCommonConfigData wVCommonConfigData2 = WVCommonConfig.commonConfig;
            if (wVCommonConfigData2.openLog) {
                UCCore.setNetLogger(new UCLog());
            }
            UCSettings.setGlobalBoolValue(SettingKeys.EnableCustomErrPage, true);
            UCSettings.updateBussinessInfo(1, 1, "u4_focus_auto_popup_input_list", wVCommonConfigData2.ucParam.u4FocusAutoPopupInputHostList);
            UCSettings.updateBussinessInfo(1, 1, "crwp_embed_surface_embed_view_enable_list", wVCommonConfigData2.ucParam.cdResourceEmbedSurfaceEmbedViewEnableList);
            UCSettings.updateBussinessInfo(1, 1, "crwp_embed_view_reattach_list", "map");
            setPageCacheCapacity(5);
            try {
                String str3 = WVCookieConfig.getInstance().cookieBlackList;
                if (!TextUtils.isEmpty(str3)) {
                    TaoLog.i(TAG, "set cookie black list = " + str3 + " to uc");
                    UCSettings.setGlobalStringValue("CookiesBlacklistForJs", str3);
                }
            } catch (Throwable unused) {
            }
            AppMonitorUtil.commitSuccess(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE, null);
        } else {
            TaoLog.e(TAG, "core type: Android");
            if (WVCommonConfig.commonConfig.useSystemWebView) {
                str = "forceSystem";
            } else if (GlobalConfig.getInstance().getInjectCode() == 0) {
                str = "injectError";
            } else if (!sCoreInitialized.get()) {
                str = "coreNotInit";
            } else if (!WVCore.getInstance().isUCSupport()) {
                str = "core_" + coreCode;
            } else {
                str = "successInit";
            }
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE, WebView.getCoreType(), str + JSMethod.NOT_SET + GlobalConfig.getInstance().getInjectCode(), CommonUtils.getProcessName(this.context));
            TaoLog.e(TAG, "WebViewCoreTypeByPV coreType=" + WebView.getCoreType() + " errorMsg=" + str + JSMethod.NOT_SET + GlobalConfig.getInstance().getInjectCode() + " process=" + CommonUtils.getProcessName(this.context));
        }
        UCCore.setStatDataCallback(new WVValueCallback());
        setWebViewClient(new WVUCWebViewClient(this.context));
        setWebChromeClient(new WVUCWebChromeClient(this.context));
        UCExtension uCExtension = getUCExtension();
        if (uCExtension != null) {
            uCExtension.setClient(new WVUCClient(this));
        }
        this.wvUIModel = new WVUIModel(_getContext(), this);
        WVJsBridge.getInstance().init();
        this.entryManager = new WVPluginEntryManager(this.context, this);
        WVAppEvent wVAppEvent = new WVAppEvent();
        wVAppEvent.initialize(_getContext(), this);
        addJsObject("AppEvent", wVAppEvent);
        if (!initedJSBridge) {
            WVPluginManager.registerPlugin("WVUCBase", (Class<? extends WVApiPlugin>) WVUCBase.class);
            WVPluginManager.registerPlugin("WVPerformance", (Class<? extends WVApiPlugin>) WVH5PP.class);
            WVPluginManager.registerPlugin("WVFullTrace", (Class<? extends WVApiPlugin>) WVFullTrace.class);
            WVPluginManager.registerPlugin("WVFalco", (Class<? extends WVApiPlugin>) WVFalco.class);
            initedJSBridge = true;
        }
        try {
            ((WVH5PP) getJsObject("WVPerformance")).resetAllStoredSet();
        } catch (Exception e2) {
            TaoLog.d(TAG, "resetAllStoredSet error: " + e2);
        }
        setSupportLocalStorageFile();
        this.jsPatchListener = new WVJsPatchListener(this);
        WVEventService.getInstance().addEventListener(this.jsPatchListener, WVEventService.WV_BACKWARD_EVENT);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 17) {
            try {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th2) {
                TaoLog.d(TAG, "removeJavascriptInterface " + th2.getMessage());
            }
        }
        View.OnLongClickListener r2 = new View.OnLongClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass7 */

            public boolean onLongClick(View view) {
                try {
                    WebView.HitTestResult hitTestResult = WVUCWebView.this.getHitTestResult();
                    if (hitTestResult == null || !WVUCWebView.this.longPressSaveImage) {
                        return false;
                    }
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(WVUCWebView.TAG, "Long click on WebView, " + hitTestResult.getExtra());
                    }
                    if (hitTestResult.getType() != 8 && hitTestResult.getType() != 5) {
                        return false;
                    }
                    WVUCWebView.this.mImageUrl = hitTestResult.getExtra();
                    WVUCWebView wVUCWebView = WVUCWebView.this;
                    Context _getContext = wVUCWebView._getContext();
                    WVUCWebView wVUCWebView2 = WVUCWebView.this;
                    wVUCWebView.mPopupController = new PopupWindowController(_getContext, wVUCWebView2, wVUCWebView2.mPopupMenuTags, WVUCWebView.this.popupClickListener);
                    WVUCWebView.this.mPopupController.show();
                    return true;
                } catch (Exception e) {
                    TaoLog.e(WVUCWebView.TAG, "getHitTestResult error:" + e.getMessage());
                    return false;
                }
            }
        };
        this.mLongClickListener = r2;
        setOnLongClickListener(r2);
        if (WVMonitorService.getPackageMonitorInterface() != null) {
            WVMonitorService.getPerformanceMonitor().didWebViewInitAtTime(System.currentTimeMillis());
        }
        if (Build.VERSION.SDK_INT >= 11 && WVRenderPolicy.shouldDisableHardwareRenderInLayer()) {
            try {
                setLayerType(1, null);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            CookieManager.getInstance().setAcceptCookie(true);
        } catch (Throwable unused2) {
        }
        setAcceptThirdPartyCookies();
        addJavascriptInterface(new WVBridgeEngine(this), "__windvane__");
        injectJsEarly(WVBridgeEngine.WINDVANE_CORE_JS);
        try {
            ArrayList<String> embedViewNames = WVEVManager.getEmbedViewNames();
            for (String str4 : WVCommonConfig.commonConfig.disableMixViews) {
                embedViewNames.remove(str4);
            }
            StringBuilder sb = new StringBuilder("window.__mix_view_environment__={availableTypes:{");
            Iterator<String> it = embedViewNames.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(":");
                sb.append("[]");
                sb.append(",");
            }
            if (sb.toString().contains(",")) {
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("},matchType:'name',isForAppX:'no'}");
            injectJsEarly(sb.toString());
        } catch (Throwable unused3) {
        }
        this.wvh5PPManager.webViewDidFinishInit();
    }

    /* access modifiers changed from: private */
    public static void initAfterUCReady(Context context2, long j) {
        new UCHAManager().initHAParam(GlobalConfig.getInstance().getUcHASettings());
        try {
            Application application = GlobalConfig.context;
            UCCore.updateUCPlayer(application, UC_PLAYER_URL, new DownloadEnv(application));
        } catch (Exception e) {
            TaoLog.e("UCCore", "UCCore update UCPlayer failed:" + e.getMessage());
        }
        WVEventService.getInstance().onEvent(3016);
    }

    @Keep
    @Deprecated
    public static void initUCCore() {
        initUCCore(GlobalConfig.context);
    }

    @Deprecated
    public static boolean initUCLIb(Context context2) {
        if (!shouldUCLibInit.get()) {
            RuntimeException runtimeException = new RuntimeException("init uclib outer");
            runtimeException.fillInStackTrace();
            TaoLog.e(TAG, runtimeException.getStackTrace()[0].toString() + StringUtils.LF + runtimeException.getStackTrace()[1].toString() + StringUtils.LF + runtimeException.getStackTrace()[2].toString());
            return false;
        } else if (context2 == null) {
            return false;
        } else {
            return initUCLIb(GlobalConfig.getInstance().getUcsdkappkeySec(), context2.getApplicationContext());
        }
    }

    public static boolean initUCLibBy7Z(String[] strArr, Context context2, Object[] objArr) {
        INNER_FLAG = 1;
        String ucCore7ZFilePath = ucCore7ZFilePath(context2);
        String old7zDecompressPath = getOld7zDecompressPath(context2);
        if (old7zDecompressPath.equals(getCore7zDecompressDir(context2, ucCore7ZFilePath))) {
            old7zDecompressPath = "";
        }
        TaoLog.i(TAG, "UCSDK initUCLibBy7Z zipPath: " + ucCore7ZFilePath);
        try {
            SetupTask upVar = BusinessWrapper.setup("CONTEXT", context2.getApplicationContext());
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            Boolean bool = Boolean.TRUE;
            ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) upVar.setup(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH, (Object) getBusinessDecompressRootDir(context2))).setup(UCCore.OPTION_WEBVIEW_MULTI_PROCESS, (Object) Integer.valueOf(renderMultiPolicy))).setup(UCCore.OPTION_GPU_PROCESS_MODE, (Object) Integer.valueOf(gpuMultiPolicy))).setup(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_FALLBACK_TIMEOUT, (Object) Integer.valueOf(wVCommonConfigData.ucMultiTimeOut))).setup(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SERVICE_SPEEDUP, (Object) Boolean.valueOf(wVCommonConfigData.ucMultiServiceSpeedUp))).setup(UCCore.OPTION_FORCE_USE_BUSINESS_DECOMPRESS_ROOT_PATH, (Object) bool)).setup(UCCore.OPTION_FIRST_USE_SYSTEM_WEBVIEW, (Object) Boolean.valueOf(wVCommonConfigData.firstUseSystemWebViewOn7zInit))).setup(UCCore.OPTION_NEW_UCM_ZIP_FILE, (Object) ucCore7ZFilePath)).setup(UCCore.OPTION_NEW_UCM_ZIP_TYPE, (Object) "7z")).setup(UCCore.OPTION_OLD_DEX_DIR_PATH, (Object) old7zDecompressPath)).setup(UCCore.OPTION_DELETE_OLD_DEX_DIR, (Object) Boolean.valueOf(isMainProcess()))).setup(UCCore.OPTION_SKIP_PRECONDITIONS_IO_CHECK, (Object) bool)).setup(UCCore.OPTION_PROMISE_SPECIAL_VERSION_CORE_INIT, (Object) new OldCoreVersionCallable())).setup(UCCore.OPTION_START_INIT_UC_CORE, (Object) new OnInitStart())).setup(UCCore.OPTION_DECOMPRESS_CALLBACK, (Object) new DecompressCallable(context2))).onEvent(UCCore.EVENT_INIT_CORE_SUCCESS, (ValueCallback) new ValueCallback<SetupTask>() {
                /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass3 */

                public void onReceiveValue(SetupTask setupTask) {
                    Object field;
                    UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
                    if (totalLoadedUCM != null && (field = ReflectUtils.getField(totalLoadedUCM, "ucmPackageInfo")) != null) {
                        Object field2 = ReflectUtils.getField(field, "dataDir");
                        if (field2 instanceof String) {
                            WVUCWebView.saveUCCoeDexDirPath((String) field2);
                        }
                    }
                }
            });
            setupUCParam(ucCore7ZFilePath);
            ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) upVar.setup("CONTEXT", (Object) context2.getApplicationContext())).setup(UCCore.OPTION_PROVIDED_KEYS, (Object) strArr)).setup(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED, (Object) bool)).setup(UCCore.OPTION_HARDWARE_ACCELERATED, (Object) bool)).setup("core_ver_excludes", (Object) wVCommonConfigData.excludeUCVersions)).setup(UCCore.OPTION_MULTI_CORE_TYPE, (Object) bool)).setup(UCCore.OPTION_USE_SYSTEM_WEBVIEW, (Object) Boolean.valueOf(mUseSystemWebView))).setup(UCCore.OPTION_WEBVIEW_POLICY, (Object) 2)).setup(UCCore.OPTION_LOAD_POLICY, (Object) UCCore.LOAD_POLICY_SPECIFIED_ONLY)).setup(UCCore.OPTION_VERIFY_POLICY, (Object) 0)).setup(UCCore.OPTION_DELETE_CORE_POLICY, (Object) Integer.valueOf(GlobalConfig.getInstance().getDeleteCorePolicy()))).setup(UCCore.OPTION_LOG_CONFIG, (Object) objArr)).setup(UCCore.OPTION_WEBVIEW_POLICY_WAIT_MILLIS, (Object) Integer.valueOf(GlobalConfig.getInstance().getUcCoreWaitMills()))).setup(UCCore.OPTION_USE_UC_PLAYER, (Object) Boolean.valueOf(wVCommonConfigData.useUCPlayer))).setup(UCCore.OPTION_SKIP_OLD_KERNEL, (Object) Boolean.valueOf(wVCommonConfigData.ucSkipOldKernel))).setup(UCCore.OPTION_SDK_INTERNATIONAL_ENV, (Object) Boolean.valueOf(GlobalConfig.getInstance().isUcSdkInternationalEnv()))).setup(UCCore.OPTION_STARTUP_POLICY, (Object) Integer.valueOf(wVCommonConfigData.initWebPolicy))).setup(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX, (Object) getMultiProcessPrivateDataDirectorySuffix())).setup(UCCore.OPTION_MULTI_UNKNOWN_CRASH_DISABLE, (Object) Boolean.valueOf(GlobalConfig.getInstance().isDisableMultiUnknownCrash()))).onEvent("exception", (ValueCallback) new ExceptionValueCallback())).onEvent("success", (ValueCallback) new CorePreparedCallback(System.currentTimeMillis()))).onEvent("switch", (ValueCallback) new SwitchValueCallback(System.currentTimeMillis()))).setAsDefault().start();
        } catch (Exception e) {
            TaoLog.e(TAG, "initUCLibBy7Z fail " + e.getMessage());
        }
        return !mUseSystemWebView;
    }

    public static boolean initUCLibByDownload(String[] strArr, Context context2, Object[] objArr) {
        SetupTask setupTask;
        try {
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            setUcCoreUrl(wVCommonConfigData.ucCoreUrl);
            if (!TextUtils.isEmpty(GlobalConfig.getInstance().getUcLibDir())) {
                setupTask = UCCore.setup(UCCore.OPTION_DEX_FILE_PATH, GlobalConfig.getInstance().getUcLibDir());
                TaoLog.i(TAG, "asset目录内核初始化");
                INNER_FLAG = 2;
            } else {
                TaoLog.i(TAG, "下载内核初始化");
                setupUCParam(null);
                setupTask = (SetupTask) UCCore.setup(UCCore.OPTION_DOWNLOAD_CHECKER, GlobalConfig.getInstance().getUcDownloadChecker() != null ? GlobalConfig.getInstance().getUcDownloadChecker() : new DownloadEnv(GlobalConfig.context)).setup(UCCore.OPTION_UCM_UPD_URL, (Object) UC_CORE_URL);
            }
            int i = wVCommonConfigData.webMultiPolicy;
            int i2 = wVCommonConfigData.gpuMultiPolicy;
            Boolean bool = Boolean.TRUE;
            ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) setupTask.setup("CONTEXT", (Object) context2.getApplicationContext())).setup(UCCore.OPTION_WEBVIEW_MULTI_PROCESS, (Object) Integer.valueOf(renderMultiPolicy))).setup(UCCore.OPTION_GPU_PROCESS_MODE, (Object) Integer.valueOf(gpuMultiPolicy))).setup(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_FALLBACK_TIMEOUT, (Object) Integer.valueOf(wVCommonConfigData.ucMultiTimeOut))).setup(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SERVICE_SPEEDUP, (Object) Boolean.valueOf(wVCommonConfigData.ucMultiServiceSpeedUp))).setup(UCCore.OPTION_PROVIDED_KEYS, (Object) strArr)).setup(UCCore.OPTION_VIDEO_HARDWARE_ACCELERATED, (Object) bool)).setup(UCCore.OPTION_HARDWARE_ACCELERATED, (Object) bool)).setup("core_ver_excludes", (Object) wVCommonConfigData.excludeUCVersions)).setup(UCCore.OPTION_MULTI_CORE_TYPE, (Object) bool)).setup(UCCore.OPTION_USE_SYSTEM_WEBVIEW, (Object) Boolean.valueOf(mUseSystemWebView))).setup(UCCore.OPTION_WEBVIEW_POLICY, (Object) 2)).setup(UCCore.OPTION_LOAD_POLICY, (Object) UCCore.LOAD_POLICY_SPECIFIED_ONLY)).setup(UCCore.OPTION_VERIFY_POLICY, (Object) 0)).setup(UCCore.OPTION_DELETE_CORE_POLICY, (Object) Integer.valueOf(GlobalConfig.getInstance().getDeleteCorePolicy()))).setup(UCCore.OPTION_LOG_CONFIG, (Object) objArr)).setup(UCCore.OPTION_WEBVIEW_POLICY_WAIT_MILLIS, (Object) Integer.valueOf(GlobalConfig.getInstance().getUcCoreWaitMills()))).setup(UCCore.OPTION_USE_UC_PLAYER, (Object) Boolean.valueOf(wVCommonConfigData.useUCPlayer))).setup(UCCore.OPTION_SKIP_OLD_KERNEL, (Object) Boolean.valueOf(wVCommonConfigData.ucSkipOldKernel))).setup(UCCore.OPTION_SDK_INTERNATIONAL_ENV, (Object) Boolean.valueOf(GlobalConfig.getInstance().isUcSdkInternationalEnv()))).setup(UCCore.OPTION_STARTUP_POLICY, (Object) Integer.valueOf(wVCommonConfigData.initWebPolicy))).setup(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX, (Object) getMultiProcessPrivateDataDirectorySuffix())).setup(UCCore.OPTION_MULTI_UNKNOWN_CRASH_DISABLE, (Object) Boolean.valueOf(GlobalConfig.getInstance().isDisableMultiUnknownCrash()))).onEvent(UCCore.EVENT_UPDATE_PROGRESS, (ValueCallback) new DownLoadCallback())).onEvent("exception", (ValueCallback) new ExceptionValueCallback())).onEvent("success", (ValueCallback) new CorePreparedCallback(System.currentTimeMillis()))).onEvent("switch", (ValueCallback) new SwitchValueCallback(System.currentTimeMillis()))).setAsDefault().start();
            TaoLog.i("UCCore", "final UCCore:" + UC_CORE_URL);
        } catch (Exception e) {
            TaoLog.e("UCCore", "UCCore init fail " + e.getMessage());
        }
        return !mUseSystemWebView;
    }

    /* access modifiers changed from: private */
    public static boolean isMainProcess() {
        boolean isMainProcess = CommonUtils.isMainProcess(GlobalConfig.context);
        TaoLog.i(TAG, "是否在主进程:" + isMainProcess);
        return isMainProcess;
    }

    public static boolean isNeedCookie(String str) {
        Matcher matcher;
        try {
            Pattern pattern2 = pattern;
            if (pattern2 == null || (matcher = pattern2.matcher(str)) == null || !matcher.matches()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            TaoLog.e(TAG, "Pattern complile Exception" + e.getMessage());
            return true;
        }
    }

    public static boolean isNeedDownLoad() {
        return needDownLoad;
    }

    private static boolean isUseSystemWebView(Context context2) {
        boolean z = mUseSystemWebView;
        if (!z) {
            try {
                String config = OrangeConfig.getInstance().getConfig(TBConfigManager.WINDVANE_COMMMON_CONFIG, "useSysWebViewBizList", "");
                if (!TextUtils.isEmpty(config)) {
                    String[] split = config.split(";");
                    String name = context2.getClass().getName();
                    for (String str : split) {
                        if (name.equals(str)) {
                            z = true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public static boolean isWebViewMultiProcessEnabled() {
        return WVCommonConfig.commonConfig.webMultiPolicy > 0;
    }

    private static Object[] logConfigCreate() {
        return new Object[]{Boolean.TRUE, Boolean.FALSE, new ValueCallback<Object[]>() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass2 */

            public void onReceiveValue(Object[] objArr) {
                WVUCWebView.uploadLog(objArr);
            }
        }, "[all]", "[all]"};
    }

    /* access modifiers changed from: private */
    public static void onUCMCoreSwitched(Context context2, long j) {
        TaoLog.i(TAG, "UCSDK init onUCMCoreSwitched: " + WebView.getCoreType());
        if (!WVCore.getInstance().isUCSupport() && WebView.getCoreType() == 3) {
            TaoLog.i(TAG, "CorePreparedCallback   isUCSDKSupport = true");
            WVCore.getInstance().setUCSupport(true);
            coreCode = 0;
            if (coreEventCallback != null) {
                WVCoreSettings.getInstance().setCoreEventCallback(coreEventCallback);
            }
            if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
                for (CoreEventCallback coreEventCallback2 : WVCoreSettings.getInstance().coreEventCallbacks) {
                    if (coreEventCallback2 != null) {
                        coreEventCallback2.onUCCorePrepared();
                    }
                }
            }
            WVCommonConfig.getInstance();
            if (WVCommonConfig.commonConfig.enableThreadWatchdog) {
                UCCoreController.registerThreadANRCallback(sSpanWrapper);
            }
            if (initAfterUCCoreReady.compareAndSet(false, true)) {
                initAfterUCReady(context2, j);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void saveUCCoeDexDirPath(String str) {
        TaoLog.i(TAG, "save dex path:[" + str + jl1.ARRAY_END_STR);
        ConfigStorage.putStringVal("WindVane", "UC_PATH", str);
    }

    private void setAcceptThirdPartyCookies() {
        if (Build.VERSION.SDK_INT >= 21 && WebView.getCoreType() != 1 && WebView.getCoreType() != 3) {
            try {
                View view = getView();
                if (view != null && (view instanceof android.webkit.WebView)) {
                    CookieManager.getInstance().setAcceptThirdPartyCookies((android.webkit.WebView) view, true);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void setBizCode(String str) {
        bizId = str;
    }

    @Deprecated
    public static void setCoreEventCallback(CoreEventCallback coreEventCallback2) {
        coreEventCallback = coreEventCallback2;
    }

    public static void setDegradeAliNetwork(boolean z) {
        mDegradeAliNetwork = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r0 != false) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
    private static void setMultiPolicy(Context context2) {
        int i;
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        String valueOf = String.valueOf(wVCommonConfigData.webMultiPolicy);
        String valueOf2 = String.valueOf(wVCommonConfigData.gpuMultiPolicy);
        boolean equals = TextUtils.equals("1", valueOf);
        boolean equals2 = TextUtils.equals("2", valueOf);
        boolean equals3 = TextUtils.equals("1", valueOf2);
        boolean equals4 = TextUtils.equals("2", valueOf2);
        int i2 = 2;
        if (isMainProcess()) {
            if (!equals) {
                if (equals2) {
                    if (WVCore.getInstance().checkIsolateIfOpen(context2)) {
                        i = 2;
                        renderMultiPolicy = i;
                        if (Build.VERSION.SDK_INT >= 21 && isMainProcess()) {
                            if (equals3) {
                                i2 = 1;
                            }
                            gpuMultiPolicy = i2;
                            WVCore.getInstance().setUsedWebMulti(renderMultiPolicy);
                            WVCore.getInstance().setUsedGpuMulti(gpuMultiPolicy);
                        }
                        i2 = 0;
                        gpuMultiPolicy = i2;
                        WVCore.getInstance().setUsedWebMulti(renderMultiPolicy);
                        WVCore.getInstance().setUsedGpuMulti(gpuMultiPolicy);
                    }
                }
            }
            i = 1;
            renderMultiPolicy = i;
            if (equals3) {
            }
            gpuMultiPolicy = i2;
            WVCore.getInstance().setUsedWebMulti(renderMultiPolicy);
            WVCore.getInstance().setUsedGpuMulti(gpuMultiPolicy);
        }
        i = 0;
        renderMultiPolicy = i;
        if (equals3) {
        }
        gpuMultiPolicy = i2;
        WVCore.getInstance().setUsedWebMulti(renderMultiPolicy);
        WVCore.getInstance().setUsedGpuMulti(gpuMultiPolicy);
    }

    private void setSupportLocalStorageFile() {
        if (Build.VERSION.SDK_INT < 23) {
            this.wvSecurityFilter = new WVSecurityFilter();
            WVEventService.getInstance().addEventListener(this.wvSecurityFilter, WVEventService.WV_FORWARD_EVENT);
        }
    }

    public static void setUcCoreUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            UC_CORE_URL = str;
        }
    }

    public static void setUseSystemWebView(boolean z) {
        mUseSystemWebView = z;
        fromType = 70;
    }

    public static void setUseTaobaoNetwork(boolean z) {
        mUseAliNetwork = z;
    }

    private static void setupUCParam(String str) {
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        UCParamData uCParamData = wVCommonConfigData.ucParam;
        if (!wVCommonConfigData.enableUcShareCore || uCParamData == null || (!UCParamData.hostApp() && !UCParamData.needLoadNeedShareCoreApp())) {
            TaoLog.w(TAG, "not taobao, or shared core disabled by config, or uc param is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (UCParamData.hostApp() && TextUtils.isEmpty(uCParamData.scLoadPolicyCd) && !NetWork.isConnectionInexpensive()) {
                uCParamData.scLoadPolicyCd = CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE;
                uCParamData.scWaitMilts = "1";
            }
            if (!TextUtils.isEmpty(uCParamData.scWaitMilts)) {
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_HOST_UPD_SETUP_TASK_WAIT_MILIS, uCParamData.scWaitMilts);
            }
            if (UCParamData.hostApp() && uCParamData.validShareCoreToSdcardParams()) {
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH, uCParamData.sdCopyPathCd);
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_HOST_COPY_SDCARD, uCParamData.scCopyToSdcardCd);
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_HOST_PUSH_UCM_VERSIONS, uCParamData.hostUcmVersionsCd);
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_HOST_UPDATE_STILL, uCParamData.scStillUpd);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_HOST_COMPRESSED_CORE_FILE_PATH, str);
                }
            }
            if (uCParamData.validShareCoreFromSdcardParams()) {
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH, uCParamData.sdCopyPathCd);
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_UCM_VERSIONS, uCParamData.thirtyUcmVersionsCd);
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY, uCParamData.scLoadPolicyCd);
                jSONObject.put(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST, uCParamData.scPkgNames);
            }
            String str2 = "JSON_CMD" + jSONObject.toString();
            TaoLog.d(TAG, str2);
            UCCore.setParam(str2);
        } catch (Throwable th) {
            TaoLog.w(TAG, "failed to setup uc param", th, new Object[0]);
        }
    }

    private void tryPrcacheDocument(String str) {
        if (WVUCPrecacheManager.getInstance().canPrecacheDoc(str) && this.webViewClient != null) {
            WebResourceResponse shouldInterceptRequest = this.webViewClient.shouldInterceptRequest(this, new WebResourceRequest(str, new HashMap()));
            if (shouldInterceptRequest != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(str, shouldInterceptRequest);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("maxAge", "10");
                hashMap2.put("ignoreQuery", "0");
                UCCore.precacheResources(hashMap, hashMap2);
                return;
            }
            WVUCPrecacheManager.getInstance().addPrecacheDoc(str);
        }
    }

    private static String ucCore7ZFilePath(Context context2) {
        String uc7ZPath = GlobalConfig.getInstance().getUc7ZPath();
        if (!TextUtils.isEmpty(uc7ZPath) && new File(uc7ZPath).exists()) {
            return uc7ZPath;
        }
        return context2.getApplicationInfo().nativeLibraryDir + "/libkernelu4_7z_uc.so";
    }

    /* access modifiers changed from: private */
    public static void uploadLog(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(":");
        stringBuffer.append(objArr[1]);
        stringBuffer.append(":");
        stringBuffer.append(objArr[2]);
        stringBuffer.append(":");
        stringBuffer.append(objArr[5]);
        String stringBuffer2 = stringBuffer.toString();
        if (objArr[6] != null) {
            if (objArr[6] instanceof UCKnownException) {
                int errCode = ((UCKnownException) objArr[6]).errCode();
                coreCode = errCode;
                if (errCode == 3007) {
                    try {
                        System.loadLibrary("webviewuc");
                    } catch (Throwable unused) {
                        coreCode = 307;
                    }
                }
            }
            WVCommonConfig.getInstance();
            if (WVCommonConfig.commonConfig.enableUCUploadToTlog) {
                TaoLog.e((String) objArr[4], stringBuffer2, (Throwable) objArr[6], new Object[0]);
            } else {
                SpanWrapper spanWrapper = sSpanWrapper;
                spanWrapper.log(objArr[4] + " " + stringBuffer2 + " " + objArr[6]);
            }
            if (TextUtils.equals("uc.Loading", (String) objArr[4])) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("tbNet", "false");
                hashMap.put("msg", stringBuffer2);
                WVHAManager.uploadApmStage("uc loading", hashMap);
                return;
            }
            return;
        }
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.enableUCUploadToTlog) {
            TaoLog.e((String) objArr[4], stringBuffer2);
        } else {
            SpanWrapper spanWrapper2 = sSpanWrapper;
            spanWrapper2.log(objArr[4] + " " + stringBuffer2);
        }
        if (TextUtils.equals("uc.Loading", (String) objArr[4])) {
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("tbNet", "false");
            hashMap2.put("msg", stringBuffer2);
            WVHAManager.uploadApmStage("uc loading", hashMap2);
        }
    }

    public void OnScrollChanged(int i, int i2, int i3, int i4) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onScrollChanged(i, i2, i3, i4);
        }
        try {
            super.onScrollChanged(i, i2, i3, i4);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Context _getContext() {
        Context context2 = getContext();
        return context2 instanceof MutableContextWrapper ? ((MutableContextWrapper) context2).getBaseContext() : context2;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    @TargetApi(19)
    public boolean _post(Runnable runnable) {
        if (isAttachedToWindow() || Build.VERSION.SDK_INT >= 24) {
            return post(runnable);
        }
        TaoLog.d(TAG, " wait webview attach to window");
        IWVWebView.taskQueue.add(runnable);
        return true;
    }

    @Override // com.uc.webview.export.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (!"accessibility".equals(str) && !"accessibilityTraversal".equals(str)) {
            super.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void addJsObject(String str, Object obj) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.addEntry(str, obj);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean allowAllOpen() {
        return this.mAllowAllOpen;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean back() {
        if (!canGoBack()) {
            return false;
        }
        goBack();
        int i = this.mPageLoadedCount;
        if (i > 0) {
            this.mPageLoadedCount = i - 1;
        } else {
            TaoLog.e(TAG, "back pressed, mPageLoadedCount=" + this.mPageLoadedCount);
        }
        return true;
    }

    @Override // com.uc.webview.export.WebView
    public boolean canGoBack() {
        if (WVEventService.getInstance().onEvent(3004).isSuccess) {
            return false;
        }
        return super.canGoBack();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean canUseGlobalUrlConfig() {
        return this.mUseGlobalUrlConfig;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean canUseUrlConfig() {
        return this.useUrlConfig;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void clearCache() {
        super.clearCache(true);
    }

    public void clearH5MonitorData() {
        Hashtable<String, Hashtable<String, String>> hashtable = this.mH5MonitorCache;
        if (hashtable != null) {
            hashtable.clear();
        }
    }

    public boolean containsH5MonitorData(String str) {
        Hashtable<String, Hashtable<String, String>> hashtable = this.mH5MonitorCache;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[Catch:{ all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011f A[Catch:{ all -> 0x0123 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017c A[Catch:{ all -> 0x012a, all -> 0x0198, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d2 A[Catch:{ all -> 0x01d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride, com.uc.webview.export.WebView
    public void coreDestroy() {
        StringBuilder sb;
        Throwable th;
        FalcoSpan falcoSpan;
        FalcoSpan falcoSpan2;
        FalcoSpan falcoSpan3;
        FalcoSpan falcoSpan4;
        try {
            boolean z = this.mIsCoreDestroy;
            if (!z) {
                this.wvh5PPManager.uploadInfo();
                TaoLog.e(TAG, "call core destroy");
                this.mPageLoadedCount = 0;
                InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(getApplicationWindowToken(), 0);
                }
                super.setWebViewClient(null);
                super.setWebChromeClient(null);
                this.webViewClient = null;
                this.webChromeClient = null;
                this.context = null;
                WVJsBridge.getInstance().tryToRunTailBridges();
                this.entryManager.onDestroy();
                setOnLongClickListener(null);
                this.mLongClickListener = null;
                WVEventService.getInstance().onEvent(3003);
                WVEventService.getInstance().removeEventListener(this.wvSecurityFilter);
                WVEventService.getInstance().removeEventListener(this.jsPatchListener);
                removeAllViews();
                ConcurrentHashMap<String, Integer> concurrentHashMap = IWVWebView.JsbridgeHis;
                if (concurrentHashMap != null) {
                    concurrentHashMap.clear();
                }
                this.isLive = false;
                if (getParent() != null && (getParent() instanceof ViewGroup)) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                try {
                    if (!this.mIsCoreDestroy) {
                        if (WebView.getCoreType() != 2) {
                            if (Build.VERSION.SDK_INT >= 19 || !WVUCUtils.isArchContains(DeviceUtils.ABI_X86)) {
                                super.coreDestroy();
                                this.mIsCoreDestroy = true;
                                super.destroy();
                                falcoSpan3 = this.containerSpan;
                                if (falcoSpan3 == null) {
                                    falcoSpan3.finish();
                                    return;
                                }
                                return;
                            }
                        }
                        TaoLog.e(TAG, "Delay destroy core");
                        getSettings().setJavaScriptEnabled(false);
                        new Handler().postDelayed(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass9 */

                            public void run() {
                                WVUCWebView.super.coreDestroy();
                                WVUCWebView.this.mIsCoreDestroy = true;
                            }
                        }, 50);
                        falcoSpan3 = this.containerSpan;
                        if (falcoSpan3 == null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sb = new StringBuilder();
                    sb.append("WVUCWebView::coreDestroy finally Exception:");
                    sb.append(th.getMessage());
                    TaoLog.i(TAG, sb.toString());
                }
            } else if (!z) {
                try {
                    if (WebView.getCoreType() != 2) {
                        if (Build.VERSION.SDK_INT >= 19 || !WVUCUtils.isArchContains(DeviceUtils.ABI_X86)) {
                            super.coreDestroy();
                            this.mIsCoreDestroy = true;
                            super.destroy();
                            falcoSpan4 = this.containerSpan;
                            if (falcoSpan4 == null) {
                                falcoSpan4.finish();
                                return;
                            }
                            return;
                        }
                    }
                    TaoLog.e(TAG, "Delay destroy core");
                    getSettings().setJavaScriptEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass9 */

                        public void run() {
                            WVUCWebView.super.coreDestroy();
                            WVUCWebView.this.mIsCoreDestroy = true;
                        }
                    }, 50);
                    falcoSpan4 = this.containerSpan;
                    if (falcoSpan4 == null) {
                    }
                } catch (Throwable th3) {
                    TaoLog.i(TAG, "WVUCWebView::coreDestroy finally Exception:" + th3.getMessage());
                }
            }
        } catch (Throwable th4) {
            th = th4;
            sb = new StringBuilder();
            sb.append("WVUCWebView::coreDestroy finally Exception:");
            sb.append(th.getMessage());
            TaoLog.i(TAG, sb.toString());
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride, com.uc.webview.export.WebView
    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (action == 0) {
            this.dx = motionEvent.getX();
            this.dy = motionEvent.getY();
            if (!this.isUser) {
                this.mEventSparseArray.put(pointerId, MotionEvent.obtain(motionEvent));
                return true;
            }
        } else if (action == 2) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.dy) > 5.0f) {
                return true;
            }
        } else if (action == 1) {
            if (this.isUser || Math.abs(motionEvent.getY() - this.dy) <= 5.0f) {
                MotionEvent motionEvent2 = this.mEventSparseArray.get(pointerId);
                if (motionEvent2 != null) {
                    super.coreDispatchTouchEvent(motionEvent2);
                    motionEvent2.recycle();
                    this.mEventSparseArray.remove(pointerId);
                }
            } else {
                this.isUser = true;
                return true;
            }
        }
        return super.coreDispatchTouchEvent(motionEvent);
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride, com.uc.webview.export.WebView
    public void coreOnScrollChanged(int i, int i2, int i3, int i4) {
        OnScrollChanged(i, i2, i3, i4);
        super.coreOnScrollChanged(i, i2, i3, i4);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str) {
        evaluateJavascript(str, null);
    }

    public void fireEvent(String str) {
        getWVCallBackContext().fireEvent(str, "{}");
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public String getCachedUrl() {
        if (!TextUtils.isEmpty(this.cachedUrl)) {
            return this.cachedUrl;
        }
        return null;
    }

    @Override // com.uc.webview.export.WebView
    public int getContentHeight() {
        return (int) (((float) super.getContentHeight()) * super.getScale());
    }

    public Context getCurrentContext() {
        return _getContext();
    }

    public String getCurrentUrl() {
        String str;
        try {
            str = super.getUrl();
        } catch (Exception unused) {
            TaoLog.w(TAG, "WebView had destroyed,forbid to be called getUrl. currentUrl : " + this.currentUrl);
            str = null;
        }
        if (str == null) {
            TaoLog.v(TAG, "getUrl by currentUrl: " + this.currentUrl);
            return this.currentUrl;
        }
        TaoLog.v(TAG, "getUrl by webview: " + str);
        return str;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getDataOnActive() {
        return this.dataOnActive;
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public FalcoSpan getFalcoSpan() {
        return this.containerSpan;
    }

    public String getH5MonitorData(String str, String str2) {
        Hashtable<String, String> hashtable;
        Hashtable<String, Hashtable<String, String>> hashtable2 = this.mH5MonitorCache;
        if (hashtable2 == null || (hashtable = hashtable2.get(str)) == null) {
            return null;
        }
        return hashtable.get(str2);
    }

    public JSONObject getH5MonitorDatas() throws JSONException {
        if (this.mH5MonitorCache == null) {
            return new JSONObject();
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : this.mH5MonitorCache.keySet()) {
            Hashtable<String, String> hashtable = this.mH5MonitorCache.get(str);
            JSONObject jSONObject = new JSONObject();
            Enumeration<String> keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                jSONObject.put(nextElement, hashtable.get(nextElement));
            }
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("resources", jSONArray);
        return jSONObject2;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Object getJsObject(String str) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager == null) {
            return null;
        }
        return wVPluginEntryManager.getEntry(str);
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public Map<String, String> getOpenTracingContext() {
        return this.openTracingContextMap;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public int getPageLoadedCount() {
        return this.mPageLoadedCount;
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public WVPerformance getPerformanceDelegate() {
        return this.performanceDelegate;
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public SpanWrapper getSpanWrapper() {
        return this.mSpanWrapper;
    }

    @Override // com.uc.webview.export.WebView, android.taobao.windvane.webview.IWVWebView
    public String getUrl() {
        return getCurrentUrl();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getUserAgentString() {
        return getSettings().getUserAgentString();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public View getView() {
        return super.getCoreView();
    }

    public WVCallBackContext getWVCallBackContext() {
        return new WVCallBackContext(this);
    }

    public WVUIModel getWvUIModel() {
        return this.wvUIModel;
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 400:
                WVUIModel wVUIModel = this.wvUIModel;
                if (wVUIModel != null) {
                    z = true;
                }
                if (wVUIModel.isShowLoading() && z) {
                    this.wvUIModel.showLoadingView();
                    this.wvUIModel.switchNaviBar(1);
                }
                this.mPageLoadedCount++;
                TaoLog.d(TAG, "NOTIFY_PAGE_START mPageLoadedCount=" + this.mPageLoadedCount);
                return true;
            case 401:
                WVUIModel wVUIModel2 = this.wvUIModel;
                if (wVUIModel2 != null) {
                    z = true;
                }
                if (wVUIModel2.isShowLoading() && z) {
                    this.wvUIModel.hideLoadingView();
                    this.wvUIModel.resetNaviBar();
                }
                if (this.onErrorTime != 0 && System.currentTimeMillis() - this.onErrorTime > 3000) {
                    this.wvUIModel.hideErrorPage();
                }
                return true;
            case 402:
                WVUIModel wVUIModel3 = this.wvUIModel;
                if (wVUIModel3 != null) {
                    wVUIModel3.loadErrorPage();
                }
                this.onErrorTime = System.currentTimeMillis();
                WVUIModel wVUIModel4 = this.wvUIModel;
                if (wVUIModel4 != null) {
                    z = true;
                }
                if (wVUIModel4.isShowLoading() && z) {
                    this.wvUIModel.hideLoadingView();
                }
                return true;
            case 403:
                WVUIModel wVUIModel5 = this.wvUIModel;
                if (wVUIModel5 != null) {
                    z = true;
                }
                if (wVUIModel5.isShowLoading() && z) {
                    this.wvUIModel.hideLoadingView();
                }
                return true;
            case 404:
                try {
                    Toast.makeText(_getContext(), EnvUtil.isCN() ? "图片保存到相册成功" : "Success to save picture", 1).show();
                } catch (Exception e) {
                    TaoLog.e(TAG, "NOTIFY_SAVE_IMAGE_SUCCESS fail " + e.getMessage());
                }
                return true;
            case 405:
                try {
                    Toast.makeText(_getContext(), EnvUtil.isCN() ? "图片保存到相册失败" : "Failed to save picture", 1).show();
                } catch (Exception e2) {
                    TaoLog.e(TAG, "NOTIFY_SAVE_IMAGE_FAIL fail " + e2.getMessage());
                }
                return true;
            default:
                return false;
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void hideLoadingView() {
        WVUIModel wVUIModel = this.wvUIModel;
        if (wVUIModel != null) {
            wVUIModel.hideLoadingView();
        }
    }

    public void injectJsEarly(String str) {
        if (str.startsWith("javascript:")) {
            str = str.replace("javascript:", "");
        }
        StringBuilder sb = this.injectJs;
        sb.append(str);
        sb.append(";\n");
        if (getUCExtension() != null) {
            getUCExtension().setInjectJSProvider(new UCExtension.InjectJSProvider() {
                /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass10 */

                @Override // com.uc.webview.export.extension.UCExtension.InjectJSProvider
                public String getJS(int i) {
                    return WVUCWebView.this.injectJs.toString();
                }
            }, 1);
        }
    }

    public void insertH5MonitorData(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mH5MonitorCache == null) {
                this.mH5MonitorCache = new Hashtable<>();
            }
            Hashtable<String, String> hashtable = this.mH5MonitorCache.get(str);
            if (hashtable == null) {
                hashtable = new Hashtable<>();
                this.mH5MonitorCache.put(str, hashtable);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            hashtable.put(str2, str3);
        }
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void isPageEmpty(final whiteScreenCallback whitescreencallback) {
        evaluateJavascript("(function(d){var filteredTagNames={'IFRAME':1,'STYLE':1,'HTML':1,'BODY':1,'HEAD':1,'SCRIPT':1,'TITLE':1};if(d.body){for(var nodes=d.body.childNodes,i=0;i<nodes.length;i++){var node=nodes[i];if(node!=undefined){if(node.nodeType==1&&filteredTagNames[node.tagName]!=1&&node.style.display!='none'){return'0'}else if(node.nodeType==3&&node.nodeValue.trim().length>0){return'0'}}}}return'1'}(document))", new ValueCallback<String>() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass11 */

            public void onReceiveValue(String str) {
                whiteScreenCallback whitescreencallback = whitescreencallback;
                if (whitescreencallback != null) {
                    whitescreencallback.isPageEmpty(str);
                }
            }
        });
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public boolean isPreInit() {
        return this.isPreInit;
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public boolean isReportedFSP() {
        return false;
    }

    public boolean isStaticWebView() {
        return this.mIsStaticWebView;
    }

    @Override // com.uc.webview.export.WebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(String str) {
        if (str != null) {
            SpanWrapper spanWrapper = this.mSpanWrapper;
            spanWrapper.log("loadUrl: " + str);
            boolean isCommonUrl = WVUrlUtil.isCommonUrl(str);
            if (isCommonUrl && WVServerConfig.isBlackUrl(str, this)) {
                String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
                if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("cause", "GET_ACCESS_FORBIDDEN");
                    hashMap.put("url", str);
                    onMessage(402, hashMap);
                    return;
                }
                try {
                    super.loadUrl(forbiddenDomainRedirectURL);
                } catch (Exception e) {
                    TaoLog.e(TAG, e.getMessage());
                }
            } else if (WVURLFilter.doFilter(str, this.context, this)) {
                TaoLog.e(TAG, "loadUrl filter url=" + str);
                AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_FILTER_TYPE, 1, "WVUCWebView.loadUrl", str);
            } else {
                if (this.firstTimeLoad && !str.contains(BasePreInitManager.PRE_RENDER_URL_ADDITION)) {
                    this.firstTimeLoad = false;
                }
                if (isCommonUrl) {
                    try {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("userAgent", getUserAgentString());
                        String prefetchData = WMLPrefetch.getInstance().prefetchData(str, hashMap2);
                        if (!TextUtils.isEmpty(prefetchData)) {
                            str = prefetchData;
                        }
                    } catch (Throwable th) {
                        TaoLog.e(TAG, "failed to call prefetch: " + th.getMessage());
                        th.getStackTrace();
                    }
                }
                WVSchemeIntercepterInterface wVSchemeIntercepter = WVSchemeInterceptService.getWVSchemeIntercepter();
                if (wVSchemeIntercepter != null) {
                    str = wVSchemeIntercepter.dealUrlScheme(str);
                }
                if (isCommonUrl) {
                    if (WebView.getCoreType() == 3) {
                        tryPrcacheDocument(str);
                    }
                    if (this.firstTimeLoad && !str.contains(BasePreInitManager.PRE_RENDER_URL_ADDITION_JUDGE)) {
                        this.wvh5PPManager.pageDidLoadRequest();
                        this.firstTimeLoad = false;
                    }
                    this.wvh5PPManager.receiveHtmlUrl(str);
                }
                try {
                    UCNetworkDelegate.getInstance().onUrlChange(this, str);
                    TaoLog.i(TAG, "loadUrl : " + str);
                    super.loadUrl(str);
                } catch (Exception e2) {
                    TaoLog.e(TAG, e2.getMessage());
                }
                setCachedUrl(str);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 15 && this.webChromeClient.mFilePathCallback != null) {
            this.webChromeClient.mFilePathCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
            this.webChromeClient.mFilePathCallback = null;
        }
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.WebView
    public void onAttachedToWindow() {
        TaoLog.d(TAG, " webview attach to window, and execute remain task");
        for (Runnable runnable : IWVWebView.taskQueue) {
            runnable.run();
        }
        IWVWebView.taskQueue.clear();
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.WebView
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UCNetworkDelegate.getInstance().removeWebview(this);
        List<Runnable> list = IWVWebView.taskQueue;
        if (list.size() != 0) {
            list.clear();
        }
    }

    public void onLowMemory() {
    }

    public void onMessage(int i, Object obj) {
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.mHandler.sendMessage(obtain);
        }
    }

    @Override // com.uc.webview.export.WebView
    @TargetApi(11)
    public void onPause() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onPause();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
        WVEventService.getInstance().onEvent(3001);
    }

    @Override // com.uc.webview.export.WebView
    @TargetApi(11)
    public void onResume() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onResume();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                super.onResume();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        WVEventService.getInstance().onEvent(3002, this, getUrl(), new Object[0]);
        this.isLive = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.WebView
    public void onWindowVisibilityChanged(int i) {
        Window window;
        if (i == 0 && Build.VERSION.SDK_INT > 18) {
            Context _getContext = _getContext();
            if ((_getContext instanceof Activity) && (window = ((Activity) _getContext).getWindow()) != null) {
                final View decorView = window.getDecorView();
                decorView.postDelayed(new Runnable() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass8 */

                    public void run() {
                        decorView.requestLayout();
                    }
                }, 100);
            }
        }
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.uc.webview.export.WebView
    public void postUrl(String str, byte[] bArr) {
        if (str != null) {
            if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, this)) {
                String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
                if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("cause", "POST_ACCESS_FORBIDDEN");
                    hashMap.put("url", str);
                    onMessage(402, hashMap);
                    return;
                }
                try {
                    loadUrl(forbiddenDomainRedirectURL);
                } catch (Exception e) {
                    TaoLog.e(TAG, e.getMessage());
                }
            } else if (WVURLFilter.doFilter(str, this.context, this)) {
                TaoLog.e(TAG, "postUrl filter url=" + str);
                AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_FILTER_TYPE, 2, "WVUCWebView.loadUrl", str);
            } else {
                WVSchemeIntercepterInterface wVSchemeIntercepter = WVSchemeInterceptService.getWVSchemeIntercepter();
                if (wVSchemeIntercepter != null) {
                    str = wVSchemeIntercepter.dealUrlScheme(str);
                }
                try {
                    UCNetworkDelegate.getInstance().onUrlChange(this, str);
                    TaoLog.i(TAG, "postUrl : " + str);
                    super.postUrl(str, bArr);
                } catch (Exception e2) {
                    TaoLog.e(TAG, e2.getMessage());
                }
                setCachedUrl(str);
            }
        }
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForCustomizedFSP(long j) {
        this.pageTracker.onPageReceivedCustomizedFSP(j);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForCustomizedStage(long j, String str) {
        this.pageTracker.onPageReceivedCustomizedStage(j, str);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForFP(long j) {
        this.wvh5PPManager.receiveFPTime(j);
        this.pageTracker.onPageReceivedFP(j);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForFSP(long j) {
        this.wvfspManager.receiveJSMessage(j);
        this.pageTracker.onPageReceivedFSP(j);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForTTI(long j) {
        this.wvh5PPManager.receiveTTITime(j);
        this.pageTracker.onPageReceivedTTI(j);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void refresh() {
        reload();
    }

    @Override // com.uc.webview.export.WebView
    public void reload() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("userAgent", getUserAgentString());
            WMLPrefetch.getInstance().prefetchData(getCurrentUrl(), hashMap);
        } catch (Throwable th) {
            TaoLog.e(TAG, "failed to call prefetch: " + th.getMessage());
            th.printStackTrace();
        }
        super.reload();
    }

    public void script2NativeCallback(String str, ValueCallback<String> valueCallback) {
        int i = this.mWvNativeCallbackId + 1;
        this.mWvNativeCallbackId = i;
        WVNativeCallbackUtil.putNativeCallbak(String.valueOf(i), valueCallback);
        loadUrl("javascript:console.log('wvNativeCallback/" + i + "/'+function(){var s = " + str + "; return (typeof s === 'object' ? JSON.stringify(s) : typeof s === 'string' ? '\"' + s + '\"' : s);}())");
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setAllowAllOpen(boolean z) {
        this.mAllowAllOpen = z;
    }

    public void setCachedUrl(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.startsWith("about:")) {
            this.cachedUrl = str;
        }
    }

    public void setCurrentUrl(String str, String str2) {
        this.currentUrl = str;
        TaoLog.v(TAG, "setCurrentUrl: " + str + " state : " + str2);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setDataOnActive(String str) {
        this.dataOnActive = str;
    }

    public void setFalcoPageName(String str) {
        try {
            ((WVFalco) getJsObject("WVFalco")).setPageName(str);
        } catch (Exception e) {
            TaoLog.e(TAG, "setPageName fail " + e);
        }
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public void setFalcoSpan(FalcoSpan falcoSpan) {
        this.containerSpan = falcoSpan;
        sSpanWrapper.setFalcoSpan(falcoSpan);
        this.mSpanWrapper.setFalcoSpan(falcoSpan);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setGlobalUrlConfigSwitch(boolean z) {
        this.mUseGlobalUrlConfig = z;
    }

    /* access modifiers changed from: protected */
    public void setOnErrorTime(long j) {
        this.onErrorTime = j;
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public void setOpenTracingContext(Map<String, String> map) {
        this.openTracingContextMap = map;
    }

    public void setOuterContext(Context context2) {
        Context context3 = this.context;
        if (context3 instanceof MutableContextWrapper) {
            ((MutableContextWrapper) context3).setBaseContext(context2);
        } else {
            this.context = context2;
        }
        if (WVCore.getInstance().isUCSupport() && (getContext() instanceof MutableContextWrapper)) {
            ((MutableContextWrapper) getContext()).setBaseContext(context2);
        }
    }

    public void setPageCacheCapacity(int i) {
        if (getUCExtension() != null) {
            getUCExtension().getUCSettings();
            UCSettings.setGlobalIntValue("CachePageNumber", i);
        }
    }

    public void setPerformanceDelegate(WVPerformance wVPerformance) {
        this.performanceDelegate = wVPerformance;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPreInitState(boolean z) {
        this.isPreInit = z;
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void setReportedFSP(boolean z) {
        this.reportedFSP = z;
    }

    public void setSupportDownload(boolean z) {
        this.supportDownload = z;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUrlConfigSwitch(boolean z) {
        this.useUrlConfig = z;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUserAgentString(String str) {
        getSettings().setUserAgentString(str);
    }

    @Override // com.uc.webview.export.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient2) {
        if (webChromeClient2 instanceof WVUCWebChromeClient) {
            WVUCWebChromeClient wVUCWebChromeClient = (WVUCWebChromeClient) webChromeClient2;
            this.webChromeClient = wVUCWebChromeClient;
            wVUCWebChromeClient.mWebView = this;
            super.setWebChromeClient(webChromeClient2);
            return;
        }
        throw new WindVaneError("Your WebChromeClient must be extended from WVUCWebChromeClient");
    }

    @Override // com.uc.webview.export.WebView
    public void setWebViewClient(WebViewClient webViewClient2) {
        if (webViewClient2 instanceof WVUCWebViewClient) {
            this.webViewClient = (WVUCWebViewClient) webViewClient2;
            super.setWebViewClient(webViewClient2);
            return;
        }
        throw new WindVaneError("Your WebViewClient must be extended from WVUCWebViewClient");
    }

    public void setWvUIModel(WVUIModel wVUIModel) {
        this.wvUIModel = wVUIModel;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void showLoadingView() {
        WVUIModel wVUIModel = this.wvUIModel;
        if (wVUIModel != null) {
            wVUIModel.showLoadingView();
        }
    }

    @Override // com.uc.webview.export.WebView
    public void stopLoading() {
        isStop = true;
        super.stopLoading();
    }

    public static void initUCCore(Context context2) {
        String str;
        String str2;
        if (GlobalConfig.getInstance().getUcsdkappkeySec() == null) {
            new AndroidRuntimeException("WVUCWebView: can not init uc core for uc key is null").printStackTrace();
        } else if (GlobalConfig.context == null) {
            new AndroidRuntimeException("WVUCWebView: can not init uc core for context is nulll").printStackTrace();
        } else {
            if (!WVCommonConfig.getInstance().hasInited()) {
                WVCommonConfig.getInstance().init();
                TaoLog.i(TAG, "init WVCommonConfig before init core");
            }
            AtomicBoolean atomicBoolean = sCoreInitialized;
            if (atomicBoolean.compareAndSet(false, true)) {
                try {
                    boolean is64Bit = WVUCUtils.is64Bit();
                    if (is64Bit || !WVUCUtils.isArchContains(DeviceUtils.ABI_X86)) {
                        if (EnvUtil.isAppDebug()) {
                            if (TextUtils.equals("true", UCSoSettings.getInstance().UC_CORE_THICK) && GlobalConfig.getInstance().openUCDebug()) {
                                openUCDebug = true;
                            }
                            if (is64Bit) {
                                str2 = UCSoSettings.getInstance().UC_CORE_URL_DEBUG_64;
                            } else {
                                str2 = UCSoSettings.getInstance().UC_CORE_URL_DEBUG_32;
                            }
                            UC_CORE_URL = str2;
                            TaoLog.i(TAG, "use 3.0 debug core, use 64bit = [" + is64Bit + "] " + UC_CORE_URL);
                        } else {
                            TaoLog.i(TAG, "use 3.0 release core, use 64bit = [" + is64Bit + "] " + UC_CORE_URL);
                            if (is64Bit) {
                                str = UCSoSettings.getInstance().UC_CORE_URL_64;
                            } else {
                                str = UCSoSettings.getInstance().UC_CORE_URL_32;
                            }
                            UC_CORE_URL = str;
                        }
                        try {
                            shouldUCLibInit.set(true);
                            TaoLog.e(TAG, "init uclib inner");
                            if (!initUCLIb(GlobalConfig.getInstance().getUcsdkappkeySec(), GlobalConfig.context)) {
                                sCoreInitialized.set(false);
                            }
                        } catch (Throwable unused) {
                            sCoreInitialized.set(false);
                        }
                    } else {
                        UC_CORE_URL = UCSoSettings.getInstance().UC_CORE_URL_DEBUG_X86;
                        TaoLog.i(TAG, "UCCore use x86 core " + UC_CORE_URL);
                        atomicBoolean.set(true);
                    }
                } catch (Exception unused2) {
                    sCoreInitialized.set(false);
                }
            } else {
                TaoLog.d(TAG, "uc core has been initialized");
            }
        }
    }

    @Override // com.uc.webview.export.WebView, android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        TaoLog.d(TAG, "evaluateJavascript : " + str);
        if (this.isLive) {
            if (str.length() > 10 && "javascript:".equals(str.substring(0, 11).toLowerCase())) {
                str = str.substring(11);
            }
            if (evaluateJavascriptSupported || getCurrentViewCoreType() == 3) {
                try {
                    super.evaluateJavascript(str, valueCallback);
                } catch (NoSuchMethodError unused) {
                    if (getCurrentViewCoreType() != 3) {
                        evaluateJavascriptSupported = false;
                        evaluateJavascript(str, valueCallback);
                    }
                } catch (Exception unused2) {
                    if (getCurrentViewCoreType() != 3) {
                        evaluateJavascriptSupported = false;
                        evaluateJavascript(str, valueCallback);
                        AppMonitorUtil.commitUCWebviewError("2", str, "exception");
                    }
                }
            } else if (valueCallback == null) {
                loadUrl("javascript:" + str);
            } else {
                script2NativeCallback(str, valueCallback);
            }
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void fireEvent(String str, String str2) {
        getWVCallBackContext().fireEvent(str, str2);
    }

    private static boolean initUCLIb(String[] strArr, Context context2) {
        TaoLog.d(TAG, "UCSDK initUCLib begin ");
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        setUseSystemWebView(wVCommonConfigData.useSystemWebView);
        if (EnvUtil.isAppDebug()) {
            UCCore.setPrintLog(true);
        } else {
            UCCore.setPrintLog(false);
        }
        TaoLog.d(TAG, "UCSDK initUCLib UseSystemWebView " + mUseSystemWebView);
        if (WVCore.getInstance().isUCSupport()) {
            return true;
        }
        try {
            setUcCoreUrl(wVCommonConfigData.ucCoreUrl);
            if (strArr == null && EnvUtil.isTaobao()) {
                strArr = WindVaneSDKForTB.TB_UC_SDK_APP_KEY_SEC;
            }
            Object[] logConfigCreate = logConfigCreate();
            File file = new File(ucCore7ZFilePath(context2));
            TaoLog.i(TAG, "uccore policy:[" + wVCommonConfigData.initUCCorePolicy + jl1.ARRAY_END_STR);
            TaoLog.i(TAG, "sandbox:policy [" + wVCommonConfigData.webMultiPolicy + "];timeout [" + wVCommonConfigData.ucMultiTimeOut + "]]");
            String processName = CommonUtils.getProcessName(context2);
            if (!TextUtils.equals(processName, context2.getPackageName() + ":sandboxed_privilege_process0")) {
                String processName2 = CommonUtils.getProcessName(context2);
                if (!TextUtils.equals(processName2, context2.getPackageName() + ":sandboxed_process0")) {
                    String processName3 = CommonUtils.getProcessName(context2);
                    if (!TextUtils.equals(processName3, context2.getPackageName() + ":gpu_process")) {
                        setMultiPolicy(context2);
                        if (wVCommonConfigData.initUCCorePolicy == 0 && file.exists()) {
                            TaoLog.e(TAG, "内置uc初始化");
                            return initUCLibBy7Z(strArr, context2, logConfigCreate);
                        } else if (!TextUtils.isEmpty(UC_CORE_URL)) {
                            return initUCLibByDownload(strArr, context2, logConfigCreate);
                        } else {
                            TaoLog.e(TAG, "UC_CORE_URL为空");
                            new AndroidRuntimeException("neither inner so, nor download so").printStackTrace();
                            if (WVUCUtils.is64Bit()) {
                                coreCode = 300764;
                            } else {
                                coreCode = 300732;
                            }
                            return false;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            TaoLog.e(TAG, "UCCore init fail " + e.getMessage());
            return false;
        }
    }

    public WVUCWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet, isUseSystemWebView(context2));
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1 */

            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                Context context = WVUCWebView.this.context;
                                if (context != null) {
                                    ImageTool.saveImageToDCIM(context.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                                }
                            }
                        }).setTaskOnPermissionDenied(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context2;
        init();
    }

    public WVUCWebView(Context context2) {
        super(context2, isUseSystemWebView(context2));
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1 */

            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                Context context = WVUCWebView.this.context;
                                if (context != null) {
                                    ImageTool.saveImageToDCIM(context.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                                }
                            }
                        }).setTaskOnPermissionDenied(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context2;
        init();
    }

    public WVUCWebView(Context context2, Map<String, String> map) {
        super(context2, isUseSystemWebView(context2));
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1 */

            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                Context context = WVUCWebView.this.context;
                                if (context != null) {
                                    ImageTool.saveImageToDCIM(context.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                                }
                            }
                        }).setTaskOnPermissionDenied(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context2;
        this.openTracingContextMap = map;
        init();
    }

    public WVUCWebView(Context context2, @Nullable String str) {
        super(context2, isUseSystemWebView(context2));
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1 */

            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                Context context = WVUCWebView.this.context;
                                if (context != null) {
                                    ImageTool.saveImageToDCIM(context.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                                }
                            }
                        }).setTaskOnPermissionDenied(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0;
        this.injectJs = new StringBuilder("javascript:");
        if (!TextUtils.isEmpty(str)) {
            this.pid = str;
        }
        this.context = context2;
        init();
    }

    public WVUCWebView(Context context2, boolean z) {
        super(context2, isUseSystemWebView(context2));
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() {
            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1 */

            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                Context context = WVUCWebView.this.context;
                                if (context != null) {
                                    ImageTool.saveImageToDCIM(context.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                                }
                            }
                        }).setTaskOnPermissionDenied(new Runnable() {
                            /* class android.taobao.windvane.extra.uc.WVUCWebView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(405);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context2;
        this.mIsStaticWebView = z;
        if (WVMonitorService.getWvMonitorInterface() != null) {
            WVMonitorService.getWvMonitorInterface().WebViewWrapType(context2.getClass().getSimpleName());
        }
        if (z) {
            setWebViewClient(new WVUCWebViewClient(context2));
            setWebChromeClient(new WVUCWebChromeClient(context2));
            UCExtension uCExtension = getUCExtension();
            if (uCExtension != null) {
                uCExtension.setClient(new WVUCClient(this));
                return;
            }
            return;
        }
        init();
    }
}
