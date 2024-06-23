package com.youku.gaiax.provider.module.js;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.impl.GaiaXContext;
import com.youku.gaiax.impl.js.IJSDelegate;
import com.youku.gaiax.impl.register.GXMixNodeEvent;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.support.GaiaXNativeEventManager;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.js.utils.TimeUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.hp0;
import tb.k21;
import tb.m40;
import tb.up0;
import tb.ur2;
import tb.wq0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 J.\u0010&\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$J\u001e\u0010'\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000bJ\u0016\u0010)\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bJ&\u0010+\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020*J&\u0010.\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002J\u001e\u0010/\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0002J\u0016\u00100\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bJ\u0010\u00101\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016R\"\u00103\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0005028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/youku/gaiax/provider/module/js/JSDelegate;", "Lcom/youku/gaiax/impl/js/IJSDelegate;", "", "isJSEngineDefault", "isJSEngineStarted", "Lcom/youku/gaiax/impl/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "templateInfo", "Ltb/ur2;", "registerTemplateTree", "", "targetId", "gaiaxContext", "Lcom/alibaba/fastjson/JSONObject;", "getNodeInfo", "Landroid/content/Context;", "Lkotlin/Function0;", WXBridgeManager.METHOD_CALLBACK, "startEngine", "onReadyComponent", "onReuseComponent", "onShowComponent", "onHiddenComponent", "onDestroyComponent", "data", "onLoadMoreComponent", "unregisterComponent", "registerComponent", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "dispatcherEvent", "", "componentId", "eventType", "optionCover", "", "optionLevel", "addEventListener", "removeEventListener", "templateId", "getData", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", "setData", "resetOffset", "noRequest", "refreshPage", "refreshCard", "refreshComponent", "dispatcherNativeMessageEvent", "", "links", "Ljava/util/Map;", "jsEngineStatus", "I", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class JSDelegate implements IJSDelegate {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<JSDelegate> instance$delegate = b.b(JSDelegate$Companion$instance$2.INSTANCE);
    private volatile int jsEngineStatus = 1;
    @NotNull
    private final Map<Long, GaiaXContext> links = new ConcurrentHashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001d\u0010\t\u001a\u00020\u00048F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/provider/module/js/JSDelegate$Companion;", "", "Lcom/youku/gaiax/impl/js/IJSDelegate;", "getJSDelegate", "Lcom/youku/gaiax/provider/module/js/JSDelegate;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/provider/module/js/JSDelegate;", "instance", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final JSDelegate getInstance() {
            return (JSDelegate) JSDelegate.instance$delegate.getValue();
        }

        @JvmStatic
        @NotNull
        public final IJSDelegate getJSDelegate() {
            return getInstance();
        }
    }

    @JvmStatic
    @NotNull
    public static final IJSDelegate getJSDelegate() {
        return Companion.getJSDelegate();
    }

    private final boolean isJSEngineDefault() {
        return (this.jsEngineStatus & 1) == 1;
    }

    private final boolean isJSEngineStarted() {
        return (this.jsEngineStatus & 4) == 4;
    }

    private final void registerTemplateTree(GaiaXContext gaiaXContext, GXTemplateInfo gXTemplateInfo) {
        String a = gXTemplateInfo.r().a();
        String d = gXTemplateInfo.r().d();
        String valueOf = String.valueOf(gXTemplateInfo.r().h());
        String n = gXTemplateInfo.n();
        hp0 o = gXTemplateInfo.o();
        boolean z = false;
        if (n != null) {
            if (n.length() > 0) {
                z = true;
            }
        }
        if (z) {
            long registerComponent = GaiaXJS.Companion.getInstance().registerComponent(a, d, valueOf, n);
            Set<Long> jsComponentIds = gaiaXContext.getJsComponentIds();
            if (jsComponentIds != null) {
                jsComponentIds.add(Long.valueOf(registerComponent));
            }
            this.links.put(Long.valueOf(registerComponent), gaiaXContext);
        }
        List<GXTemplateInfo> k = gXTemplateInfo.k();
        if (!(o.m() || k == null || !(!k.isEmpty()))) {
            for (GXTemplateInfo gXTemplateInfo2 : k) {
                registerTemplateTree(gaiaXContext, gXTemplateInfo2);
            }
        }
    }

    public final void addEventListener(@NotNull String str, long j, @NotNull String str2, boolean z, int i) {
        View rootView;
        GXINodeEvent gXINodeEvent;
        k21.i(str, "targetId");
        k21.i(str2, "eventType");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null && (rootView = gaiaXContext.getRootView()) != null) {
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            wq0 n = aVar.a().n(rootView);
            if (n != null) {
                up0 m = aVar.a().m(rootView, str);
                if (m != null) {
                    m.q();
                }
                GXMixNodeEvent gXMixNodeEvent = null;
                if (m == null) {
                    gXINodeEvent = null;
                } else {
                    gXINodeEvent = m.f();
                }
                if (gXINodeEvent instanceof GXMixNodeEvent) {
                    gXMixNodeEvent = (GXMixNodeEvent) gXINodeEvent;
                }
                if (gXMixNodeEvent != null) {
                    gXMixNodeEvent.addJSEvent(n, m, j, str2, z, i);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        if (r7.equals(r4) == false) goto L_0x0073;
     */
    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void dispatcherEvent(@NotNull EventParams eventParams) {
        GaiaXContext gaiaXContext;
        String viewId;
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("dispatcherEvent() called with: eventParams = ", eventParams));
        }
        if (isJSEngineStarted() && eventParams.getJsComponentId() != -1 && (gaiaXContext = this.links.get(Long.valueOf(eventParams.getJsComponentId()))) != null && (viewId = eventParams.getViewId()) != null) {
            JSONObject nodeInfo = getNodeInfo(viewId, gaiaXContext);
            String type = eventParams.getType();
            int hashCode = type.hashCode();
            String str = "longpress";
            if (hashCode == 114595) {
                type.equals(EventParams.CLICK_TYPE_TAP);
            } else if (hashCode == 94750088) {
                type.equals("click");
            } else if (hashCode == 143756103) {
            }
            str = "click";
            nodeInfo.put((Object) "timeStamp", (Object) Long.valueOf(System.currentTimeMillis()));
            Set<Long> jsComponentIds = gaiaXContext.getJsComponentIds();
            if (jsComponentIds != null) {
                Iterator<T> it = jsComponentIds.iterator();
                while (it.hasNext()) {
                    GaiaXJS.Companion.getInstance().onEventComponent(it.next().longValue(), str, nodeInfo);
                }
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void dispatcherNativeMessageEvent(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        for (T t : GaiaXNativeEventManager.Companion.getInstance().getEventsData()) {
            long longValue = t.getLongValue("instanceId");
            if (this.links.containsKey(Long.valueOf(longValue))) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put((Object) "userData", (Object) jSONObject);
                jSONObject2.putAll(t);
                jSONObject2.put((Object) "timestamp", (Object) Long.valueOf(TimeUtils.INSTANCE.elapsedRealtime()));
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d(k21.r("dispatcherNativeMessageEvent() called with: result = ", jSONObject2));
                }
                GaiaXJS.Companion.getInstance().onNativeEventComponent(longValue, jSONObject2);
            } else {
                Log log2 = Log.INSTANCE;
                if (log2.isLog()) {
                    log2.d(k21.r("dispatcherNativeMessageEvent componentId not exist ", Long.valueOf(longValue)));
                }
            }
        }
    }

    @NotNull
    public final JSONObject getData(long j, @NotNull String str) {
        GaiaX.Params params;
        k21.i(str, "templateId");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        JSONObject jSONObject = null;
        if (!(gaiaXContext == null || (params = gaiaXContext.getParams()) == null)) {
            jSONObject = params.getData();
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @NotNull
    public final JSONObject getNodeInfo(@NotNull String str, long j) {
        k21.i(str, "targetId");
        return getNodeInfo(str, this.links.get(Long.valueOf(j)));
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onDestroyComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("onDestroyComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                GaiaXJS.Companion.getInstance().onDestroyComponent(it.next().longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onHiddenComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("onHiddenComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                GaiaXJS.Companion.getInstance().onHiddenComponent(it.next().longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onLoadMoreComponent(@NotNull GaiaXContext gaiaXContext, @NotNull JSONObject jSONObject) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(jSONObject, "data");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("onLoadMoreComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                GaiaXJS.Companion.getInstance().onLoadMoreComponent(it.next().longValue(), jSONObject);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onReadyComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("onReadyComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                GaiaXJS.Companion.getInstance().onReadyComponent(it.next().longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onReuseComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("onReuseComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                GaiaXJS.Companion.getInstance().onReuseComponent(it.next().longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onShowComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("onShowComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                GaiaXJS.Companion.getInstance().onShowComponent(it.next().longValue());
            }
        }
    }

    public final void refreshCard(long j, @NotNull String str, boolean z) {
        k21.i(str, "templateId");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null) {
            GaiaXUiExecutor.INSTANCE.action(new JSDelegate$refreshCard$1$1(gaiaXContext, z));
        }
    }

    public final void refreshComponent(long j, @NotNull String str) {
        k21.i(str, "templateId");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null) {
            GaiaXUiExecutor.INSTANCE.action(new JSDelegate$refreshComponent$1$1(gaiaXContext));
        }
    }

    public final void refreshPage(long j, @NotNull String str, boolean z, boolean z2) {
        k21.i(str, "templateId");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null) {
            GaiaXUiExecutor.INSTANCE.action(new JSDelegate$refreshPage$1$1(gaiaXContext, z, z2));
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void registerComponent(@NotNull GaiaXContext gaiaXContext) {
        GXTemplateInfo k;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("registerComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted()) {
            if (gaiaXContext.getJsComponentIds() == null) {
                gaiaXContext.setJsComponentIds(new CopyOnWriteArraySet());
            }
            wq0 gxTemplateContext = gaiaXContext.getGxTemplateContext();
            if (gxTemplateContext != null && (k = gxTemplateContext.k()) != null) {
                registerTemplateTree(gaiaXContext, k);
            }
        }
    }

    public final void removeEventListener(@NotNull String str, long j, @NotNull String str2) {
        View rootView;
        GXINodeEvent gXINodeEvent;
        k21.i(str, "targetId");
        k21.i(str2, "eventType");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null && (rootView = gaiaXContext.getRootView()) != null) {
            up0 m = GXTemplateEngine.Companion.a().m(rootView, str);
            if (m != null) {
                m.q();
            }
            GXMixNodeEvent gXMixNodeEvent = null;
            if (m == null) {
                gXINodeEvent = null;
            } else {
                gXINodeEvent = m.f();
            }
            if (gXINodeEvent instanceof GXMixNodeEvent) {
                gXMixNodeEvent = (GXMixNodeEvent) gXINodeEvent;
            }
            if (gXMixNodeEvent != null) {
                gXMixNodeEvent.removeJSEvent(j, str2);
            }
        }
    }

    public final void setData(long j, @NotNull String str, @NotNull JSONObject jSONObject, @NotNull IGaiaXCallback iGaiaXCallback) {
        k21.i(str, "templateId");
        k21.i(jSONObject, "data");
        k21.i(iGaiaXCallback, WXBridgeManager.METHOD_CALLBACK);
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null) {
            GaiaXUiExecutor.INSTANCE.action(new JSDelegate$setData$1$1(gaiaXContext, jSONObject, iGaiaXCallback));
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void startEngine(@NotNull Context context, @NotNull Function0<ur2> function0) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (isJSEngineDefault()) {
            this.jsEngineStatus <<= 1;
            GaiaXJS.Companion companion = GaiaXJS.Companion;
            companion.getInstance().init(context).initListener(new JSDelegate$startEngine$1());
            companion.getInstance().startEngine(new JSDelegate$startEngine$2(this, function0));
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void unregisterComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("unregisterComponent() called with: context = ", gaiaXContext));
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            Iterator<T> it = jsComponentIds.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                GaiaXJS.Companion.getInstance().unregisterComponent(longValue);
                Set<Long> jsComponentIds2 = gaiaXContext.getJsComponentIds();
                if (jsComponentIds2 != null) {
                    jsComponentIds2.remove(Long.valueOf(longValue));
                }
                this.links.remove(Long.valueOf(longValue));
            }
        }
    }

    private final JSONObject getNodeInfo(String str, GaiaXContext gaiaXContext) {
        if (gaiaXContext == null) {
            return new JSONObject();
        }
        View rootView = gaiaXContext.getRootView();
        if (rootView == null) {
            return new JSONObject();
        }
        up0 m = GXTemplateEngine.Companion.a().m(rootView, str);
        if (m == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "targetType", (Object) m.n().n().k());
        jSONObject.put((Object) "targetSubType", (Object) m.n().n().j());
        jSONObject.put((Object) "targetId", (Object) str);
        return jSONObject;
    }
}
