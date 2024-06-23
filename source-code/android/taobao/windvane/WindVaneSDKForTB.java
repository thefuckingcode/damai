package android.taobao.windvane;

import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVAppParams;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.extra.WVIAdapter;
import android.taobao.windvane.extra.WVSchemeProcessor;
import android.taobao.windvane.extra.config.TBConfigManager;
import android.taobao.windvane.extra.jsbridge.TBJsApiManager;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVLocPerformanceMonitor;
import android.taobao.windvane.monitor.WVMonitor;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.packageapp.WVPackageAppManager;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.urlintercept.WVURLIntercepterDefault;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.WVSchemeInterceptService;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taobao.application.common.Apm;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.pq2;

/* compiled from: Taobao */
public class WindVaneSDKForTB {
    public static final String TAG = "WindVaneSDKForTB";
    public static final String[] TB_UC_SDK_APP_KEY_SEC = {"YKIXAXN/9v6Tez0oeIRx9ilCfTkSFozXf+nmGRTPG7ruP1KycnZL8vCcjyaMMGajricmE9blrBlr\nO+HGrJUsuw==\n", "RjpgSKj6piHyametkuIC/9mWn1DKkVntRLhh4mOYlf6/g/wO1kioAHE7weTqAdqn05FXCu0dJU+p6pKC6I+k8w=="};
    private static AtomicBoolean inited = new AtomicBoolean(false);
    private static boolean isForeground;
    public static WVIAdapter wvAdapter = null;

    /* compiled from: Taobao */
    public static class OrangeRegisterEventLister implements WVEventListener {
        Context context;

        public OrangeRegisterEventLister(Context context2) {
            this.context = context2;
        }

        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            WVEventResult wVEventResult = new WVEventResult(false);
            if (i == 7001) {
                TaoLog.i("WVConfigManager", "receive orange register");
                TBConfigManager.getInstance().init(this.context);
                WVEventService.getInstance().removeEventListener(this);
            }
            return wVEventResult;
        }
    }

    public static void init(Context context, String str, int i, WVAppParams wVAppParams) {
        if (inited.compareAndSet(false, true)) {
            TaoLog.e("InitWindVane", "first init");
            long currentTimeMillis = System.currentTimeMillis();
            if (wVAppParams.ucsdkappkeySec == null) {
                wVAppParams.ucsdkappkeySec = TB_UC_SDK_APP_KEY_SEC;
            }
            WindVaneSDK.init(context, str, i, wVAppParams);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            WVPackageAppManager.getInstance().init(context, true);
            if (WVCommonConfig.commonConfig.urlRuleStatus != 0) {
                WVURLInterceptService.registerWVURLIntercepter(new WVURLIntercepterDefault());
            }
            WVAPI.setup();
            WVMonitor.init();
            TBJsApiManager.initJsApi();
            if (EnvUtil.isDebug()) {
                WVEventService.getInstance().addEventListener(WVLocPerformanceMonitor.getInstance(), WVEventService.WV_BACKWARD_EVENT);
                WVEventService.getInstance().onEvent(3009);
            }
            WVSchemeInterceptService.registerWVURLintercepter(new WVSchemeProcessor());
            MotuCrashReporter.getInstance().setCrashCaughtListener(new pq2());
            try {
                WVEventService.getInstance().addEventListener(new OrangeRegisterEventLister(context), WVEventService.WV_FORWARD_EVENT);
                final IAppPreferences d = b.d();
                b.a(new Apm.OnApmEventListener() {
                    /* class android.taobao.windvane.WindVaneSDKForTB.AnonymousClass1 */

                    @Override // com.taobao.application.common.IApmEventListener
                    public void onEvent(int i) {
                        boolean unused = WindVaneSDKForTB.isForeground = d.getBoolean("isInBackground", false);
                        boolean z = WVMonitorService.getPackageMonitorInterface() != null;
                        if (i == 2 && z) {
                            long currentTimeMillis = System.currentTimeMillis();
                            TaoLog.i(WindVaneSDKForTB.TAG, "app active at time : " + currentTimeMillis);
                            GlobalConfig.isBackground = false;
                            WVConfigManager.getInstance().updateConfig(WVConfigManager.WVConfigUpdateFromType.WVConfigUpdateFromTypeAppActive);
                            WVMonitorService.getPackageMonitorInterface().uploadStartAppTime(currentTimeMillis);
                        }
                        if (i == 1 && z) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            TaoLog.i(WindVaneSDKForTB.TAG, "app background at time : " + currentTimeMillis2);
                            GlobalConfig.isBackground = true;
                            WVMonitorService.getPackageMonitorInterface().uploadBackgroundTime(currentTimeMillis2);
                        }
                    }
                });
            } catch (Throwable unused) {
            }
            if (GlobalConfig.getInstance().needSpeed()) {
                WVConfigManager.getInstance().updateConfig(WVConfigManager.WVConfigUpdateFromType.WVConfigUpdateFromTypeAppActive);
            }
            AppMonitorUtil.commitWVInitTime(currentTimeMillis2, System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        TaoLog.e("InitWindVane", "windvane has already initiated");
    }
}
