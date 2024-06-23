package com.alibaba.pictures.bricks.channel.component;

import cn.damai.projectfiltercopy.bean.CategoryRequestNewParams;
import cn.damai.projectfiltercopy.bean.FilterReqParamBean;
import cn.damai.projectfiltercopy.listener.RequestParamProvider;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.alient.onearch.adapter.loader.v2.GenericComponentLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.loader.PagingLoader;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eh;
import tb.jk1;
import tb.k21;
import tb.pn1;

/* compiled from: Taobao */
public final class ProjectListComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private ProjectLoadingListener projectLoadingListener = new ProjectLoadingListener();

    /* compiled from: Taobao */
    public final class ProjectComponentLoader extends GenericComponentLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectListComponent this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProjectComponentLoader(@NotNull ProjectListComponent projectListComponent, IComponent<ComponentValue> iComponent) {
            super(iComponent);
            k21.i(iComponent, "component");
            this.this$0 = projectListComponent;
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1826259711")) {
                ipChange.ipc$dispatch("1826259711", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            this.this$0.getPageContext().runOnUIThread(new ProjectListComponent$ProjectComponentLoader$handleLoadFailure$1(this.this$0));
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-279751203")) {
                ipChange.ipc$dispatch("-279751203", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadSuccess(iResponse, i);
            this.this$0.getPageContext().runOnUIThread(new ProjectListComponent$ProjectComponentLoader$handleLoadSuccess$1(this.this$0));
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1542343579")) {
                ipChange.ipc$dispatch("1542343579", new Object[]{this, map});
                return;
            }
            k21.i(map, Constants.CONFIG);
            this.this$0.getPageContext().runOnUIThread(new ProjectListComponent$ProjectComponentLoader$load$1(this.this$0, map));
            super.load(map);
        }
    }

    /* compiled from: Taobao */
    public final class ProjectLoadBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ProjectLoadBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            RequestParamProvider requestParamProvider;
            FilterReqParamBean obtainRequestParam;
            CategoryRequestNewParams createReqParams;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1142776973")) {
                return (IRequest) ipChange.ipc$dispatch("1142776973", new Object[]{this, map});
            }
            k21.i(map, Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            PageArgument b = pn1.INSTANCE.b(ProjectListComponent.this.getContext().getBundle());
            String str = b != null ? b.patternName : null;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            linkedHashMap2.put("patternName", str);
            String str3 = b != null ? b.patternVersion : null;
            if (str3 != null) {
                str2 = str3;
            }
            linkedHashMap2.put("patternVersion", str2);
            IComponent projectFilterComponent = ProjectListComponent.this.getProjectFilterComponent();
            ProjectFilterComponent projectFilterComponent2 = projectFilterComponent instanceof ProjectFilterComponent ? (ProjectFilterComponent) projectFilterComponent : null;
            if (!(projectFilterComponent2 == null || (requestParamProvider = projectFilterComponent2.getRequestParamProvider()) == null || (obtainRequestParam = requestParamProvider.obtainRequestParam()) == null || (createReqParams = obtainRequestParam.createReqParams()) == null)) {
                ProjectListComponent projectListComponent = ProjectListComponent.this;
                JSONObject data = projectListComponent.getProperty().getData();
                String string = data != null ? data.getString("nextPageIndex") : null;
                JSONObject data2 = projectListComponent.getProperty().getData();
                String string2 = data2 != null ? data2.getString("nextCityOption") : null;
                if (k21.d(map.get("index"), 1)) {
                    createReqParams.pageIndex = 1;
                    createReqParams.cityOption = 0;
                } else if (k21.d("1", string2)) {
                    createReqParams.pageIndex = jk1.e(string, 1);
                    createReqParams.cityOption = jk1.e(string2, 0);
                } else {
                    Object obj = map.get("index");
                    k21.g(obj, "null cannot be cast to non-null type kotlin.Int");
                    createReqParams.pageIndex = ((Integer) obj).intValue();
                    createReqParams.cityOption = 0;
                }
                Map createRequestArgs = projectListComponent.createRequestArgs(b != null ? b.parseArg2Json() : null, createReqParams);
                createRequestArgs.remove("patternName");
                createRequestArgs.remove("patternVersion");
                linkedHashMap.putAll(createRequestArgs);
            }
            JSONObject data3 = ProjectListComponent.this.getModule().getProperty().getData();
            String str4 = (String) (data3 != null ? data3.get("nodeId") : null);
            JSONObject data4 = ProjectListComponent.this.getProperty().getData();
            return eh.INSTANCE.a(2, linkedHashMap, linkedHashMap2, str4, (String) (data4 != null ? data4.get("nodeId") : null));
        }
    }

    /* compiled from: Taobao */
    public final class ProjectLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ProjectLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-440898556")) {
                ipChange.ipc$dispatch("-440898556", new Object[]{this});
                return;
            }
            PagingLoader componentLoader = ProjectListComponent.this.getComponentLoader();
            if (componentLoader != null) {
                ProjectListComponent projectListComponent = ProjectListComponent.this;
                projectListComponent.getPageContext().runOnUIThread(new ProjectListComponent$ProjectLoadingListener$onAllPageLoaded$1$1(componentLoader, projectListComponent));
            }
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextFailure(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1906548466")) {
                ipChange.ipc$dispatch("1906548466", new Object[]{this, str});
                return;
            }
            ProjectListComponent.this.getPageContext().runOnUIThread(ProjectListComponent$ProjectLoadingListener$onLoadNextFailure$1.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProjectListComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(node, Constants.CONFIG);
        this.context = iContext;
        setRequestBuilder(new ProjectLoadBuilder());
        setComponentLoader(new ProjectComponentLoader(this, this));
        setRequestBuilder(new ProjectLoadBuilder());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final Map<String, Object> createRequestArgs(JSONObject jSONObject, CategoryRequestNewParams categoryRequestNewParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1269183065")) {
            return (Map) ipChange.ipc$dispatch("-1269183065", new Object[]{this, jSONObject, categoryRequestNewParams});
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONObject != null) {
            Map<String, Object> innerMap = jSONObject.getInnerMap();
            k21.h(innerMap, "innerMap");
            linkedHashMap.putAll(innerMap);
        }
        try {
            JSONObject parseObject = JSON.parseObject(JSON.toJSONString(categoryRequestNewParams));
            k21.h(parseObject, "parseObject(JSON.toJSONS…g(categoryRequestParams))");
            linkedHashMap.putAll(parseObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final IComponent<ComponentValue> getProjectFilterComponent() {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100127833")) {
            return (IComponent) ipChange.ipc$dispatch("2100127833", new Object[]{this});
        }
        Iterator<T> it = getModule().getComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof ProjectFilterComponent) {
                break;
            }
        }
        return t;
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1454696244")) {
            return this.context;
        }
        return (IContext) ipChange.ipc$dispatch("-1454696244", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.core.component.GenericComponent
    public void onAdd() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143038965")) {
            ipChange.ipc$dispatch("-143038965", new Object[]{this});
            return;
        }
        super.onAdd();
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader != null && (loadingViewManager = componentLoader.getLoadingViewManager()) != null) {
            loadingViewManager.removeLoadingStateListener(this.projectLoadingListener);
            loadingViewManager.addLoadingStateListener(this.projectLoadingListener);
        }
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.core.component.GenericComponent
    public void onRemove() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916472890")) {
            ipChange.ipc$dispatch("1916472890", new Object[]{this});
            return;
        }
        super.onRemove();
        ProjectLoadingListener projectLoadingListener2 = this.projectLoadingListener;
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader != null && (loadingViewManager = componentLoader.getLoadingViewManager()) != null) {
            loadingViewManager.removeLoadingStateListener(projectLoadingListener2);
        }
    }

    public final void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824461614")) {
            ipChange.ipc$dispatch("-1824461614", new Object[]{this});
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("index", 1);
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader != null) {
            componentLoader.load(linkedHashMap);
        }
    }
}
