package com.youku.live.livesdk.wkit.module;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.download.IGuideDownloadApp;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;

/* compiled from: Taobao */
public class DagoApp extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isAppHasInstall(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105025074")) {
            return ((Boolean) ipChange.ipc$dispatch("1105025074", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            Context context = null;
            WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
            if (wXSDKInstance != null) {
                context = wXSDKInstance.getContext();
            }
            if (context == null) {
                return false;
            }
            try {
                return ((IGuideDownloadApp) Dsl.getService(IGuideDownloadApp.class)).isInstalled(context, str);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    @JSMethod
    public void canOpen(final String str, final JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271689020")) {
            ipChange.ipc$dispatch("271689020", new Object[]{this, str, jSCallback});
            return;
        }
        if (TextUtils.isEmpty(str) && jSCallback != null) {
            jSCallback.invoke(Boolean.FALSE);
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() {
            /* class com.youku.live.livesdk.wkit.module.DagoApp.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                JSCallback jSCallback;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1057791869")) {
                    ipChange.ipc$dispatch("-1057791869", new Object[]{this});
                    return;
                }
                if (DagoApp.this.isAppHasInstall(str) && (jSCallback = jSCallback) != null) {
                    jSCallback.invoke(Boolean.TRUE);
                }
                JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 != null) {
                    jSCallback2.invoke(Boolean.FALSE);
                }
            }
        });
    }

    @JSMethod
    public void check(final String str, final JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605433418")) {
            ipChange.ipc$dispatch("1605433418", new Object[]{this, str, jSCallback});
            return;
        }
        if (TextUtils.isEmpty(str) && jSCallback != null) {
            jSCallback.invoke(Boolean.FALSE);
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() {
            /* class com.youku.live.livesdk.wkit.module.DagoApp.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                JSCallback jSCallback;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-861278364")) {
                    ipChange.ipc$dispatch("-861278364", new Object[]{this});
                    return;
                }
                if (DagoApp.this.isAppHasInstall(str) && (jSCallback = jSCallback) != null) {
                    jSCallback.invoke(Boolean.TRUE);
                }
                JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 != null) {
                    jSCallback2.invoke(Boolean.FALSE);
                }
            }
        });
    }

    @JSMethod
    public void downloadAdrApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882164172")) {
            ipChange.ipc$dispatch("-882164172", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            try {
                ((IGuideDownloadApp) Dsl.getService(IGuideDownloadApp.class)).guideDownload(widgetEngineInstance.getContext());
            } catch (Exception unused) {
            }
        }
    }
}
