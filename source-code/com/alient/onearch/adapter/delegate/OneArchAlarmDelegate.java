package com.alient.onearch.adapter.delegate;

import com.ali.user.open.core.util.ParamsConstants;
import com.alient.onearch.adapter.monitor.CMSMtopMonitorPoint;
import com.alient.onearch.adapter.monitor.CMSRenderMonitorPoint;
import com.alient.onearch.adapter.monitor.MonitorConstant;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.LoaderEvent;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.po2;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000f"}, d2 = {"Lcom/alient/onearch/adapter/delegate/OneArchAlarmDelegate;", "Lcom/alient/onearch/adapter/delegate/BasicDelegate;", "Lcom/youku/kubus/Event;", "event", "Ltb/ur2;", "onReceiveComponentNotSupport", "onReceiveModuleChildrenEmpty", "onReceiveComponentChildrenEmpty", "onReceiveItemDataEmpty", "onReceiveCoroutineRunFailed", "onReceiveComponentRenderFailed", "onReceiveRemoteRequestFailed", "onReceiveRemoteRequestSuccess", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class OneArchAlarmDelegate extends BasicDelegate {
    @Subscribe(eventType = {ArchExceptionEvent.COMPONENT_CHILDREN_EMPTY})
    public final void onReceiveComponentChildrenEmpty(@NotNull Event event) {
        k21.i(event, "event");
    }

    @Subscribe(eventType = {ArchExceptionEvent.COMPONENT_NOT_SUPPORT})
    public final void onReceiveComponentNotSupport(@NotNull Event event) {
        k21.i(event, "event");
    }

    @Subscribe(eventType = {ArchExceptionEvent.COMPONENT_RENDER_FAILED})
    public final void onReceiveComponentRenderFailed(@NotNull Event event) {
        k21.i(event, "event");
        Object obj = event.data;
        String str = null;
        if (!(obj instanceof HashMap)) {
            obj = null;
        }
        HashMap hashMap = (HashMap) obj;
        if (hashMap != null) {
            Object obj2 = hashMap.get("type");
            if (!(obj2 instanceof Integer)) {
                obj2 = null;
            }
            Object obj3 = (Integer) obj2;
            Object obj4 = hashMap.get("errorMsg");
            if (obj4 instanceof String) {
                str = obj4;
            }
            String str2 = str;
            CMSRenderMonitorPoint.Companion companion = CMSRenderMonitorPoint.Companion;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("scope", "component");
            if (obj3 == null) {
                obj3 = "none";
            }
            hashMap.put("type", obj3);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put("errorMsg", str2);
            ur2 ur2 = ur2.INSTANCE;
            companion.commitCMSRenderMonitorFail(MonitorConstant.COMPONENT_RENDER_ERROR, "ComponentRenderFailed", linkedHashMap);
        }
    }

    @Subscribe(eventType = {ArchExceptionEvent.COROUTINE_RUN_FAILED})
    public final void onReceiveCoroutineRunFailed(@NotNull Event event) {
        k21.i(event, "event");
        if (!AppInfoProviderProxy.isDebuggable()) {
            Object obj = event.data;
            String str = null;
            if (!(obj instanceof HashMap)) {
                obj = null;
            }
            HashMap hashMap = (HashMap) obj;
            if (hashMap != null) {
                Object obj2 = hashMap.get("errorMsg");
                if (obj2 instanceof String) {
                    str = obj2;
                }
                String str2 = str;
                CMSRenderMonitorPoint.Companion companion = CMSRenderMonitorPoint.Companion;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashMap.put("errorMsg", str2);
                ur2 ur2 = ur2.INSTANCE;
                companion.commitCMSRenderMonitorFail(MonitorConstant.COROUTINE_RUN_FAILED, "CoroutineRunFailed", linkedHashMap);
            }
        }
    }

    @Subscribe(eventType = {ArchExceptionEvent.ITEM_DATA_EMPTY})
    public final void onReceiveItemDataEmpty(@NotNull Event event) {
        k21.i(event, "event");
    }

    @Subscribe(eventType = {ArchExceptionEvent.MODULE_CHILDREN_EMPTY})
    public final void onReceiveModuleChildrenEmpty(@NotNull Event event) {
        k21.i(event, "event");
    }

    @Subscribe(eventType = {LoaderEvent.REMOTE_REQUEST_FAILED})
    public final void onReceiveRemoteRequestFailed(@NotNull Event event) {
        String str;
        String str2;
        k21.i(event, "event");
        if (!AppInfoProviderProxy.isDebuggable()) {
            Object obj = event.data;
            String str3 = null;
            if (!(obj instanceof HashMap)) {
                obj = null;
            }
            HashMap hashMap = (HashMap) obj;
            if (hashMap != null) {
                Object obj2 = hashMap.get("apiName");
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str4 = (String) obj2;
                Object obj3 = hashMap.get(ParamsConstants.Key.PARAM_TRACE_ID);
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str5 = (String) obj3;
                Object obj4 = hashMap.get("retCode");
                if (!(obj4 instanceof String)) {
                    obj4 = null;
                }
                String str6 = (String) obj4;
                Object obj5 = hashMap.get("retMessage");
                if (!(obj5 instanceof String)) {
                    obj5 = null;
                }
                String str7 = (String) obj5;
                Object obj6 = hashMap.get("apiParams");
                if (!po2.n(obj6)) {
                    obj6 = null;
                }
                Map map = (Map) obj6;
                if (!(map == null || (str2 = (String) map.get("patternName")) == null)) {
                    str4 = str4 + JSMethod.NOT_SET + str2;
                }
                if (!(map == null || (str = (String) map.get("patternVersion")) == null)) {
                    str4 = str4 + JSMethod.NOT_SET + str;
                }
                Object obj7 = hashMap.get("responseData");
                if (obj7 instanceof String) {
                    str3 = obj7;
                }
                String str8 = str3;
                CMSMtopMonitorPoint.Companion companion = CMSMtopMonitorPoint.Companion;
                String str9 = str4 != null ? str4 : "";
                String str10 = str6 != null ? str6 : "";
                String str11 = str7 != null ? str7 : "";
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (str5 == null) {
                    str5 = "";
                }
                linkedHashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, str5);
                if (str8 == null) {
                    str8 = "";
                }
                linkedHashMap.put("responseData", str8);
                ur2 ur2 = ur2.INSTANCE;
                companion.commitCMSMtopMonitorFail(str9, str10, str11, linkedHashMap, false);
            }
        }
    }

    @Subscribe(eventType = {LoaderEvent.REMOTE_REQUEST_SUCCESS})
    public final void onReceiveRemoteRequestSuccess(@NotNull Event event) {
        String str;
        String str2;
        k21.i(event, "event");
        if (!AppInfoProviderProxy.isDebuggable()) {
            Object obj = event.data;
            Map map = null;
            if (!(obj instanceof HashMap)) {
                obj = null;
            }
            HashMap hashMap = (HashMap) obj;
            if (hashMap != null) {
                Object obj2 = hashMap.get("apiName");
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str3 = (String) obj2;
                Object obj3 = hashMap.get(ParamsConstants.Key.PARAM_TRACE_ID);
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str4 = (String) obj3;
                Object obj4 = hashMap.get("retCode");
                if (!(obj4 instanceof String)) {
                    obj4 = null;
                }
                String str5 = (String) obj4;
                Object obj5 = hashMap.get("retMessage");
                if (!(obj5 instanceof String)) {
                    obj5 = null;
                }
                String str6 = (String) obj5;
                Object obj6 = hashMap.get("apiParams");
                if (po2.n(obj6)) {
                    map = obj6;
                }
                Map map2 = map;
                if (!(map2 == null || (str2 = (String) map2.get("patternName")) == null)) {
                    str3 = str3 + JSMethod.NOT_SET + str2;
                }
                if (!(map2 == null || (str = (String) map2.get("patternVersion")) == null)) {
                    str3 = str3 + JSMethod.NOT_SET + str;
                }
                CMSMtopMonitorPoint.Companion companion = CMSMtopMonitorPoint.Companion;
                String str7 = str3 != null ? str3 : "";
                String str8 = str5 != null ? str5 : "";
                String str9 = str6 != null ? str6 : "";
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (str4 == null) {
                    str4 = "";
                }
                linkedHashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, str4);
                ur2 ur2 = ur2.INSTANCE;
                companion.commitCMSMtopMonitorFail(str7, str8, str9, linkedHashMap, true);
            }
        }
    }
}
