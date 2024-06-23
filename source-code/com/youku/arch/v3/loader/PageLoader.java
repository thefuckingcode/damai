package com.youku.arch.v3.loader;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ActivityValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.NetworkUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\b\u0016\u0018\u0000 .2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001.B\u0015\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b,\u0010-J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J \u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0014J\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0004H\u0014J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0006H\u0014J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'¨\u0006/"}, d2 = {"Lcom/youku/arch/v3/loader/PageLoader;", "Lcom/youku/arch/v3/loader/AbsLoader;", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "", "index", "", "hasData", "Ltb/ur2;", "setLoadingViewState", "dispatchRefreshEvent", "Lcom/alibaba/fastjson/JSONObject;", "response", "Lcom/youku/arch/v3/core/Node;", "parseNode", "node", "createModules", "hasNextPage", "refreshLoad", "Lcom/youku/arch/v3/io/IResponse;", "handleLoadSuccess", "tryCreateModules", "success", "handleLoadFinish", "data", "Lcom/youku/arch/v3/core/ActivityValue;", "parseActivityValue", "jsonObject", "findRootDataNode", "pageNo", "checkDuplicateModule", "hasItem", "handleLoadFailure", "reload", "getRealItemCount", "", "", "", "getLoadConfigParams", "()Ljava/util/Map;", "loadConfigParams", "getReloadConfigParams", "reloadConfigParams", "container", "<init>", "(Lcom/youku/arch/v3/IContainer;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class PageLoader extends AbsLoader<IContainer<ModelValue>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/loader/PageLoader$Companion;", "", "", "DEFAULT_PAGE_START", "I", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageLoader(@NotNull IContainer<ModelValue> iContainer) {
        super(iContainer);
        k21.i(iContainer, "container");
    }

    private final void dispatchRefreshEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846410965")) {
            ipChange.ipc$dispatch("846410965", new Object[]{this});
            return;
        }
        try {
            Event event = new Event(RefreshEvent.START_REFRESH_LOAD);
            EventBus eventBus = ((IContainer) getHost()).getPageContext().getEventBus();
            if (eventBus != null) {
                eventBus.post(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final Map<String, Object> getLoadConfigParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789009165")) {
            return (Map) ipChange.ipc$dispatch("1789009165", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap.put("cache", bool);
        hashMap.put("index", 1);
        hashMap.put("refresh", bool);
        return hashMap;
    }

    private final Map<String, Object> getReloadConfigParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156165882")) {
            return (Map) ipChange.ipc$dispatch("1156165882", new Object[]{this});
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put("cache", bool);
        linkedHashMap.put("index", 1);
        linkedHashMap.put("reload", bool);
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public final void setLoadingViewState(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695084261")) {
            ipChange.ipc$dispatch("-695084261", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        setLoadingPage(i);
        if (getLoadingPage() <= 1) {
            if (!z) {
                if (hasExtraData()) {
                    getLoadingViewManager().onAllPageLoaded();
                    getLoadingViewManager().onSuccess();
                } else {
                    getLoadingViewManager().onNoData();
                }
                setLoadingState(3);
                return;
            }
            getLoadingViewManager().onSuccess();
            if (!hasNextPage()) {
                setLoadingState(3);
                getLoadingViewManager().onAllPageLoaded();
                return;
            }
            setLoadingState(0);
            setLoadingPage(getLoadingPage() + 1);
        } else if (hasNextPage()) {
            getLoadingViewManager().onLoadNextSuccess();
            setLoadingState(0);
            setLoadingPage(getLoadingPage() + 1);
        } else {
            setLoadingState(3);
            getLoadingViewManager().onAllPageLoaded();
        }
    }

    /* access modifiers changed from: protected */
    public void checkDuplicateModule(@Nullable Node node, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683156838")) {
            ipChange.ipc$dispatch("1683156838", new Object[]{this, node, Integer.valueOf(i)});
        }
    }

    public void createModules(@NotNull Node node, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500913000")) {
            ipChange.ipc$dispatch("-1500913000", new Object[]{this, node, Integer.valueOf(i)});
            return;
        }
        k21.i(node, "node");
        ((IContainer) getHost()).initProperties(node);
        List<Node> children = ((IContainer) getHost()).getProperty().getChildren();
        if (children != null) {
            ((IContainer) getHost()).createModules(children);
        }
        ((IContainer) getHost()).getPageContext().runOnUIThreadLocked(new PageLoader$createModules$2(this, i));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public JSONObject findRootDataNode(@NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607959145")) {
            return (JSONObject) ipChange.ipc$dispatch("1607959145", new Object[]{this, jSONObject});
        }
        k21.i(jSONObject, "jsonObject");
        return jSONObject;
    }

    public int getRealItemCount() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-368848135")) {
            return ((Integer) ipChange.ipc$dispatch("-368848135", new Object[]{this})).intValue();
        }
        if (((IContainer) getHost()).getChildAdapters().size() > 0) {
            for (VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter : ((IContainer) getHost()).getChildAdapters()) {
                List<DATA> list = vBaseAdapter.data;
                if (list != null) {
                    i += list.size();
                }
            }
        }
        return i;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321597055")) {
            ipChange.ipc$dispatch("-321597055", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        try {
            ((IContainer) getHost()).getPageContext().runOnUIThreadLocked(new PageLoader$handleLoadFailure$1(this, iResponse));
        } catch (Exception e) {
            handleLoadFinish(iResponse, false, getLoadingPage());
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void handleLoadFinish(@NotNull IResponse iResponse, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127873603")) {
            ipChange.ipc$dispatch("-127873603", new Object[]{this, iResponse, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        k21.i(iResponse, "response");
        try {
            Callback callback = getCallback();
            if (callback != null) {
                callback.onResponse(iResponse);
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw new RuntimeException(e);
            }
        }
        ((IContainer) getHost()).getPageContext().runOnUIThreadLocked(new PageLoader$handleLoadFinish$1(iResponse, this, i));
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856165787")) {
            ipChange.ipc$dispatch("1856165787", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        k21.i(iResponse, "response");
        try {
            ((IContainer) getHost()).getPageContext().runOnLoaderThreadLocked(new PageLoader$handleLoadSuccess$1(iResponse, this, i));
        } catch (Exception e) {
            handleLoadFinish(iResponse, false, i);
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public boolean hasNextPage() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305523996")) {
            return ((Boolean) ipChange.ipc$dispatch("-305523996", new Object[]{this})).booleanValue();
        }
        if (((IContainer) getHost()).hasNext()) {
            return true;
        }
        int childCount = ((IContainer) getHost()).getChildCount();
        Log.v("hasNextPage", childCount + "");
        if (childCount <= 0 || ((IContainer) getHost()).getModules().size() <= (i = childCount - 1)) {
            return false;
        }
        try {
            Log.v("hasNextPage", String.valueOf(((IContainer) getHost()).getModules().get(i).hasNext()));
            return ((IContainer) getHost()).getModules().get(i).hasNext();
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ActivityValue parseActivityValue(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434014795")) {
            return (ActivityValue) ipChange.ipc$dispatch("-1434014795", new Object[]{this, jSONObject});
        }
        Object obj = null;
        if (jSONObject != null) {
            obj = JSON.toJavaObject(jSONObject, ActivityValue.class);
        }
        return (ActivityValue) obj;
    }

    @Nullable
    public Node parseNode(@NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408074411")) {
            return (Node) ipChange.ipc$dispatch("-408074411", new Object[]{this, jSONObject});
        }
        k21.i(jSONObject, "response");
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            k21.h(jSONObject, "response.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    public final void refreshLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034929861")) {
            ipChange.ipc$dispatch("-2034929861", new Object[]{this});
        } else if (!isLoading()) {
            setLoadingPage(getStartPage());
            setLoadingState(1);
            if (!hasExtraData() && ((IContainer) getHost()).getChildCount() == 0) {
                getLoadingViewManager().onLoading();
            }
            dispatchRefreshEvent();
            load(getLoadConfigParams());
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922524437")) {
            ipChange.ipc$dispatch("1922524437", new Object[]{this});
        } else if (!isLoading()) {
            setLoadingPage(getStartPage());
            setLoadingState(1);
            if (hasExtraData() || ((IContainer) getHost()).getChildCount() != 0) {
                getLoadingViewManager().onNextPageLoading();
            } else {
                getLoadingViewManager().onLoading();
            }
            load(getReloadConfigParams());
        }
    }

    /* access modifiers changed from: protected */
    public void tryCreateModules(@NotNull Node node, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "896494661")) {
            ipChange.ipc$dispatch("896494661", new Object[]{this, node, Integer.valueOf(i)});
            return;
        }
        k21.i(node, "node");
        ((IContainer) getHost()).initProperties(node);
        List<Node> children = ((IContainer) getHost()).getProperty().getChildren();
        if (children != null) {
            z = true;
        }
        List<Node> list = null;
        if (!z) {
            children = null;
        }
        if (children != null) {
            if (i != 1) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    PerformanceLogUtil.INSTANCE.markStartPoint("直接追加:createModules");
                }
                ((IContainer) getHost()).createModules(children);
                if (AppInfoProviderProxy.isDebuggable()) {
                    PerformanceLogUtil.INSTANCE.markEndPoint("直接追加:createModules");
                }
            } else {
                if (AppInfoProviderProxy.isDebuggable()) {
                    PerformanceLogUtil.INSTANCE.markStartPoint("局部刷新:updateModules");
                }
                ((IContainer) getHost()).updateModules(children);
                if (AppInfoProviderProxy.isDebuggable()) {
                    PerformanceLogUtil.INSTANCE.markEndPoint("局部刷新:updateModules");
                }
            }
            list = children;
        }
        if (list == null) {
            ((IContainer) getHost()).updateModules(new ArrayList());
        }
    }

    /* access modifiers changed from: protected */
    public void setLoadingViewState(@NotNull IResponse iResponse, boolean z) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1170588343")) {
            ipChange.ipc$dispatch("-1170588343", new Object[]{this, iResponse, Boolean.valueOf(z)});
            return;
        }
        k21.i(iResponse, "response");
        boolean isSuccess = iResponse.isSuccess();
        if (getLoadingPage() <= 1) {
            if (!z) {
                if (isSuccess) {
                    getLoadingViewManager().onNoData();
                } else if (NetworkUtil.isNetworkError(iResponse.getRetMessage()) || !NetworkUtil.isNetworkAvailable(((IContainer) getHost()).getPageContext().getApplication())) {
                    getLoadingViewManager().onNoNetwork();
                } else {
                    getLoadingViewManager().onFailure(iResponse.getRetMessage());
                }
            } else if (isSuccess) {
                getLoadingViewManager().onSuccess();
                if (hasNextPage()) {
                    setLoadingPage(getLoadingPage() + 1);
                } else {
                    getLoadingViewManager().onAllPageLoaded();
                }
            } else {
                getLoadingViewManager().onFailureWithData("response fails or is null");
            }
        } else if (!isSuccess) {
            getLoadingViewManager().onLoadNextFailure("response fails or is null");
        } else if (hasNextPage()) {
            getLoadingViewManager().onLoadNextSuccess();
            setLoadingPage(getLoadingPage() + 1);
        } else {
            getLoadingViewManager().onAllPageLoaded();
        }
        if (isSuccess) {
            i = !hasNextPage() ? 3 : 0;
        }
        setLoadingState(i);
    }
}
