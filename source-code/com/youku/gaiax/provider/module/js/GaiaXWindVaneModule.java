package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import android.taobao.windvane.jsbridge.IJsApiFailedCallBack;
import android.taobao.windvane.jsbridge.IJsApiSucceedCallBack;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.webview.WVWebView;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.annotation.GaiaXAsyncMethod;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;

@Keep
/* compiled from: Taobao */
public class GaiaXWindVaneModule extends GaiaXBaseModule {
    @GaiaXAsyncMethod
    public void call(final String str, final String str2, final JSONObject jSONObject, final IGaiaXCallback iGaiaXCallback) {
        final Activity activity = AppConfigProviderProxy.topActivity();
        if (activity != null) {
            try {
                GaiaXUiExecutor.INSTANCE.action(new Runnable() {
                    /* class com.youku.gaiax.provider.module.js.GaiaXWindVaneModule.AnonymousClass1 */

                    public void run() {
                        WVWebView wVWebView = new WVWebView(activity);
                        WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
                        wVCallMethodContext.objectName = str;
                        wVCallMethodContext.methodName = str2;
                        wVCallMethodContext.webview = wVWebView;
                        wVCallMethodContext.params = jSONObject.toJSONString();
                        wVCallMethodContext.succeedCallBack = new IJsApiSucceedCallBack() {
                            /* class com.youku.gaiax.provider.module.js.GaiaXWindVaneModule.AnonymousClass1.AnonymousClass1 */

                            @Override // android.taobao.windvane.jsbridge.IJsApiSucceedCallBack
                            public void succeed(String str) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("wvcode", (Object) str);
                                iGaiaXCallback.invoke(jSONObject);
                            }
                        };
                        AnonymousClass2 r6 = new IJsApiFailedCallBack() {
                            /* class com.youku.gaiax.provider.module.js.GaiaXWindVaneModule.AnonymousClass1.AnonymousClass2 */

                            @Override // android.taobao.windvane.jsbridge.IJsApiFailedCallBack
                            public void fail(String str) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("wvcode", (Object) str);
                                iGaiaXCallback.invoke(jSONObject);
                            }
                        };
                        wVCallMethodContext.failedCallBack = r6;
                        WVCallBackContext wVCallBackContext = new WVCallBackContext(wVWebView, "", str, str2, wVCallMethodContext.succeedCallBack, r6);
                        WVAPI.setup();
                        WVPluginManager.createPlugin(str, activity, wVWebView).executeSafe(str2, jSONObject.toJSONString(), wVCallBackContext);
                    }
                });
            } catch (Error e) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wvcode", (Object) ("GaiaX-JS invoke windvane API error. " + e.toString()));
                iGaiaXCallback.invoke(jSONObject2);
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException("GaiaX-JS invoke windvane API error.");
                }
            }
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("wvcode", (Object) "activity is null.");
            iGaiaXCallback.invoke(jSONObject3);
        }
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "WindVane";
    }
}
