package com.youku.live.widgets.weex.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IEventHandler;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WidgetEventDispatcherModule extends WXModule implements IEventHandler {
    private static transient /* synthetic */ IpChange $ipChange;

    @JSMethod
    public void addListener(String str, final JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167546659")) {
            ipChange.ipc$dispatch("1167546659", new Object[]{this, str, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addEventHandler(str, new IEventHandler() {
                /* class com.youku.live.widgets.weex.module.WidgetEventDispatcherModule.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.widgets.protocol.IEventHandler
                public void onEvent(String str, Map<String, Object> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2052225997")) {
                        ipChange.ipc$dispatch("-2052225997", new Object[]{this, str, map});
                        return;
                    }
                    jSCallback.invokeAndKeepAlive(new HashMap<String, Object>(str, map) {
                        /* class com.youku.live.widgets.weex.module.WidgetEventDispatcherModule.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ Map val$eventMessage;
                        final /* synthetic */ String val$eventType;

                        {
                            this.val$eventType = r2;
                            this.val$eventMessage = r3;
                            put("eventType", r2);
                            put("eventMessage", r3);
                        }
                    });
                }
            });
        }
    }

    @JSMethod
    public void async(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526748102")) {
            ipChange.ipc$dispatch("-526748102", new Object[]{this, str, obj});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("eventType", str);
        hashMap.put("eventMessage", obj);
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.postEvent(1, str, hashMap);
        }
    }

    @Override // com.youku.live.widgets.protocol.IEventHandler
    public void onEvent(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696893274")) {
            ipChange.ipc$dispatch("-1696893274", new Object[]{this, str, map});
        }
    }

    @JSMethod
    public void removeListener(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213713108")) {
            ipChange.ipc$dispatch("-1213713108", new Object[]{this, str});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.deleteEventHandler(str, this);
        }
    }

    @JSMethod
    public void removeListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030597291")) {
            ipChange.ipc$dispatch("-2030597291", new Object[]{this});
            return;
        }
        WeexHelper.getWidgetEngineInstance(this);
    }

    @JSMethod
    public void sync(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821278629")) {
            ipChange.ipc$dispatch("1821278629", new Object[]{this, str, obj});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("eventType", str);
        hashMap.put("eventMessage", obj);
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.postEvent(0, str, hashMap);
        }
    }
}
