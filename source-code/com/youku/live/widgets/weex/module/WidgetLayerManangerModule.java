package com.youku.live.widgets.weex.module;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;

/* compiled from: Taobao */
public class WidgetLayerManangerModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    @JSMethod
    public void addLayer(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1360236561")) {
            ipChange.ipc$dispatch("1360236561", new Object[]{this, str, jSCallback, jSCallback2});
            return;
        }
        HashMap hashMap = new HashMap();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            String addLayer = widgetEngineInstance.addLayer(str);
            if (!TextUtils.isEmpty(addLayer)) {
                hashMap.put("layerId", addLayer);
                if (!z) {
                    if (jSCallback != null) {
                        jSCallback.invoke(hashMap);
                        return;
                    }
                    return;
                } else if (jSCallback2 != null) {
                    jSCallback2.invoke(hashMap);
                    return;
                } else {
                    return;
                }
            }
        }
        z = false;
        if (!z) {
        }
    }

    @JSMethod
    public void hideDialog(JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427739571")) {
            ipChange.ipc$dispatch("-427739571", new Object[]{this, jSCallback, jSCallback2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        String str = null;
        if (widgetEngineInstance != null) {
            str = widgetEngineInstance.closeDialog(null);
        }
        if (str != null) {
            if (jSCallback != null) {
                jSCallback.invoke(new HashMap());
            }
        } else if (jSCallback2 != null) {
            jSCallback2.invoke(new HashMap());
        }
    }

    @JSMethod
    public void removeLayer(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1939334736")) {
            ipChange.ipc$dispatch("-1939334736", new Object[]{this, str, jSCallback, jSCallback2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null && !TextUtils.isEmpty(str)) {
            z = widgetEngineInstance.removeLayer(str);
        }
        if (z) {
            if (jSCallback != null) {
                jSCallback.invoke(new HashMap());
            }
        } else if (jSCallback2 != null) {
            jSCallback2.invoke(new HashMap());
        }
    }

    @JSMethod
    public void showDialog(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596571388")) {
            ipChange.ipc$dispatch("596571388", new Object[]{this, str, jSCallback, jSCallback2});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        HashMap hashMap = new HashMap(1);
        String str2 = null;
        if (widgetEngineInstance != null && !TextUtils.isEmpty(str)) {
            str2 = widgetEngineInstance.showDialog(str);
        }
        if (str2 != null) {
            if (jSCallback != null) {
                hashMap.put("layerId", str2);
                jSCallback.invoke(hashMap);
            }
        } else if (jSCallback2 != null) {
            jSCallback2.invoke(hashMap);
        }
    }
}
