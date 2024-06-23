package cn.damai.h5container;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVJsbridgeService;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.webview.IWVWebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.util.ToastUtil;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import com.taobao.uc.UCSoSettings;
import com.taomai.android.h5container.TaoMaiH5Container;
import com.taomai.android.h5container.api.TMActionPlugin;
import com.uploader.export.UploaderGlobal;
import tb.ol1;
import tb.ws2;
import tb.yi2;

/* compiled from: Taobao */
public class WindvaneAgent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String Pre = "https://androiddownload.damai.cn/uc/";
    private static final String name = "libkernelu4_zip_uc_3.22.1.238.so";

    public static void initWdBasic(Context context) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063157673")) {
            ipChange.ipc$dispatch("2063157673", new Object[]{context});
            return;
        }
        UploaderGlobal.g(context);
        if (AppConfig.v()) {
            if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                i = 1;
            } else if (AppConfig.g() == AppConfig.EnvMode.test) {
                i = 2;
            }
            UploaderGlobal.e(0, AppConfig.k());
            UploaderGlobal.e(2, AppConfig.f());
            UploaderGlobal.e(1, AppConfig.k());
            UploaderEnvironmentImplDM uploaderEnvironmentImplDM = new UploaderEnvironmentImplDM(context);
            uploaderEnvironmentImplDM.setEnvironment(i);
            UploaderGlobal.c(new ws2(context, uploaderEnvironmentImplDM));
            WVPluginManager.registerPlugin("DMBridge", (Class<? extends WVApiPlugin>) DMBridge.class, true);
            WVPluginManager.registerPlugin("aluAuthJSBridge", (Class<? extends WVApiPlugin>) SNSJsbridge.class);
            WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        }
        i = 0;
        UploaderGlobal.e(0, AppConfig.k());
        UploaderGlobal.e(2, AppConfig.f());
        UploaderGlobal.e(1, AppConfig.k());
        UploaderEnvironmentImplDM uploaderEnvironmentImplDM2 = new UploaderEnvironmentImplDM(context);
        uploaderEnvironmentImplDM2.setEnvironment(i);
        UploaderGlobal.c(new ws2(context, uploaderEnvironmentImplDM2));
        WVPluginManager.registerPlugin("DMBridge", (Class<? extends WVApiPlugin>) DMBridge.class, true);
        WVPluginManager.registerPlugin("aluAuthJSBridge", (Class<? extends WVApiPlugin>) SNSJsbridge.class);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
    }

    public static void initWindVane(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157517432")) {
            ipChange.ipc$dispatch("-157517432", new Object[]{context});
            return;
        }
        yi2 yi2 = new yi2(" DamaiApp Android v" + AppConfig.q(), true);
        yi2.appKey = AppConfig.c();
        yi2.ttid = AppConfig.p();
        yi2.appTag = "DM";
        yi2.appVersion = AppConfig.q();
        yi2.reducePermission = true;
        yi2.ucsdkappkeySec = AppConfig.l;
        yi2.d(true);
        WindVaneSDK.setEnvMode(EnvEnum.ONLINE);
        if (AppConfig.v()) {
            WindVaneSDK.openLog(true);
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                WindVaneSDK.setEnvMode(EnvEnum.DAILY);
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                WindVaneSDK.setEnvMode(EnvEnum.PRE);
            }
        }
        UCSoSettings.getInstance().setUCCoreRelease32("https://androiddownload.damai.cn/uc/release/armeabi-v7a/libkernelu4_zip_uc_3.22.1.238.so").setUCCoreDebug32("https://androiddownload.damai.cn/uc/debug/armeabi-v7a/libkernelu4_zip_uc_3.22.1.238.so").setUCCoreRelease64("https://androiddownload.damai.cn/uc/release/arm64-v8a/libkernelu4_zip_uc_3.22.1.238.so").setUCCoreDebug64("https://androiddownload.damai.cn/uc/debug/arm64-v8a/libkernelu4_zip_uc_3.22.1.238.so");
        TaoMaiH5Container.c(context, yi2);
        TaoMaiH5Container.g("cn.damai.h5.fileProvider");
        String b = OrangeConfigCenter.c().b(ol1.WVPLUGIN_NAMESPACE, "whitelist", "");
        DmJSBridgeAuthAopHandler dmJSBridgeAuthAopHandler = new DmJSBridgeAuthAopHandler();
        dmJSBridgeAuthAopHandler.setAuthHost(b);
        WVJsbridgeService.registerJsbridgePreprocessor(dmJSBridgeAuthAopHandler);
        initWdBasic(context);
        TaoMaiH5Container.h(new TaoMaiH5Container.NavHandler() {
            /* class cn.damai.h5container.WindvaneAgent.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taomai.android.h5container.TaoMaiH5Container.NavHandler
            public void handleUrl(@NonNull Context context, @NonNull String str, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1276298654")) {
                    ipChange.ipc$dispatch("1276298654", new Object[]{this, context, str, Boolean.valueOf(z)});
                } else if (!z) {
                    try {
                        DMNav.from(context).toUri(Uri.parse(str));
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.taomai.android.h5container.TaoMaiH5Container.NavHandler
            public boolean shouldOverrideUrlLoading(@NonNull Context context, @NonNull String str, @NonNull IWVWebView iWVWebView) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "328643231")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("328643231", new Object[]{this, context, str, iWVWebView})).booleanValue();
            }
        });
        TaoMaiH5Container.e("getCacheLocation", new TMActionPlugin.IWVAPIPlugin() {
            /* class cn.damai.h5container.WindvaneAgent.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taomai.android.h5container.api.TMActionPlugin.IWVAPIPlugin
            public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "468251266")) {
                    return ((Boolean) ipChange.ipc$dispatch("468251266", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
                }
                try {
                    double[] dMCoordinates = Util.getDMCoordinates();
                    if (dMCoordinates == null || dMCoordinates.length != 2) {
                        if (wVCallBackContext != null) {
                            wVCallBackContext.error("result", "failed");
                        }
                        WindvaneAgent.showToast("getCacheLocation fail");
                        return true;
                    }
                    WVResult wVResult = new WVResult();
                    wVResult.addData("longitude", Double.valueOf(dMCoordinates[0]));
                    wVResult.addData("latitude", Double.valueOf(dMCoordinates[1]));
                    wVResult.addData("result", "success");
                    if (wVCallBackContext != null) {
                        wVCallBackContext.success(wVResult);
                    }
                    WindvaneAgent.showToast("getCacheLocation success");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (wVCallBackContext != null) {
                        wVCallBackContext.error();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void showToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101831792")) {
            ipChange.ipc$dispatch("101831792", new Object[]{str});
        } else if (AppConfig.v()) {
            ToastUtil.i(str);
        }
    }
}
