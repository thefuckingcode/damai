package cn.damai.search.component.script;

import cn.damai.common.AppConfig;
import cn.damai.live.LiveActivity;
import cn.damai.onearch.errpage.ErrorControlView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.loader.BaseComponentLoader;
import com.alient.onearch.adapter.request.DRParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.IdGenerator;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a20;
import tb.d20;
import tb.hp1;
import tb.jl1;
import tb.k21;
import tb.lp1;
import tb.m40;

/* compiled from: Taobao */
public final class ScriptComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String API_NAME = "mtop.damai.mec.aristotle.get";
    @NotNull
    public static final a Companion = new a(null);
    private static final boolean NEED_ENCODE = false;
    private static final boolean NEED_SESSION = false;
    private static final int REQUEST_TIME_OUT = 3000;
    @NotNull
    private static final String VERSION = "1.0";
    @NotNull
    private final IContext context;
    @Nullable
    private ScriptLoadingListener scriptLoadingListener = new ScriptLoadingListener();

    /* compiled from: Taobao */
    public final class ScriptComponentLoader extends BaseComponentLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final LoadingViewManager componentLoadingViewManager = new LoadingViewManager();
        private int startPage = 2;
        final /* synthetic */ ScriptComponent this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScriptComponentLoader(@NotNull ScriptComponent scriptComponent, IComponent<ComponentValue> iComponent) {
            super(iComponent);
            k21.i(iComponent, "component");
            this.this$0 = scriptComponent;
        }

        /* access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.AbsLoader
        public int getStartPage() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1904625958")) {
                return this.startPage;
            }
            return ((Integer) ipChange.ipc$dispatch("-1904625958", new Object[]{this})).intValue();
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.ComponentLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2011330167")) {
                ipChange.ipc$dispatch("-2011330167", new Object[]{this, map});
                return;
            }
            k21.i(map, Constants.CONFIG);
            super.load(map);
            setLoadingViewManager(this.componentLoadingViewManager);
            getLoadingViewManager().addLoadingStateListener(this.this$0.scriptLoadingListener);
            if (getLoadingPage() == getStartPage()) {
                GenericFragment fragment = this.this$0.getContext().getFragment();
                ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
                if (errorControlView != null) {
                    errorControlView.showDialogLoading(true);
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.BaseComponentLoader
        public int parseComponentType(@Nullable String str) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1628606523")) {
                return ((Integer) ipChange.ipc$dispatch("1628606523", new Object[]{this, str})).intValue();
            }
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (z) {
                return -1;
            }
            return ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(str);
        }

        /* access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.AbsLoader
        public void setStartPage(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-745275536")) {
                ipChange.ipc$dispatch("-745275536", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.startPage = i;
        }
    }

    /* compiled from: Taobao */
    public final class ScriptLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ScriptLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1893740302")) {
                ipChange.ipc$dispatch("-1893740302", new Object[]{this});
            } else if (ScriptComponent.this.getComponentLoader() != null) {
                ScriptComponent scriptComponent = ScriptComponent.this;
                HashMap hashMap = new HashMap();
                hashMap.put("componentId", Integer.valueOf(scriptComponent.getType()));
                EventDispatcher eventDispatcher = scriptComponent.getPageContext().getEventDispatcher();
                if (eventDispatcher != null) {
                    eventDispatcher.dispatchEvent("script_all_loaded", hashMap);
                }
                scriptComponent.getPageContext().runOnUIThread(new ScriptComponent$ScriptLoadingListener$onAllPageLoaded$1$1(scriptComponent));
            }
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextFailure(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-677035808")) {
                ipChange.ipc$dispatch("-677035808", new Object[]{this, str});
                return;
            }
            ScriptComponent.this.getPageContext().runOnUIThread(new ScriptComponent$ScriptLoadingListener$onLoadNextFailure$1(ScriptComponent.this, str));
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1167721341")) {
                ipChange.ipc$dispatch("1167721341", new Object[]{this});
                return;
            }
            ScriptComponent.this.getPageContext().runOnUIThread(new ScriptComponent$ScriptLoadingListener$onLoadNextSuccess$1(ScriptComponent.this));
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onNextPageLoading() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1686611059")) {
                ipChange.ipc$dispatch("-1686611059", new Object[]{this});
                return;
            }
            GenericFragment fragment = ScriptComponent.this.getContext().getFragment();
            ErrorControlView errorControlView = fragment instanceof ErrorControlView ? (ErrorControlView) fragment : null;
            if (errorControlView != null) {
                errorControlView.showDialogLoading(true);
            }
        }
    }

    /* compiled from: Taobao */
    public final class ScriptRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ScriptRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1790578468")) {
                return (IRequest) ipChange.ipc$dispatch("1790578468", new Object[]{this, map});
            }
            k21.i(map, Constants.CONFIG);
            HashMap hashMap = new HashMap();
            hashMap.put("patternName", "searchScriptKill");
            hashMap.put("patternVersion", "1.0");
            HashMap hashMap2 = new HashMap();
            String c = d20.c();
            k21.h(c, "getCityId()");
            hashMap2.put("comboDamaiCityId", c);
            if (hp1.i(lp1.LOCATION)) {
                hashMap2.put("latitude", Double.valueOf(d20.n()));
                hashMap2.put("longitude", Double.valueOf(d20.o()));
            }
            hashMap2.put(Constants.Name.PAGE_SIZE, 5);
            String p = AppConfig.p();
            k21.h(p, "getTtid()");
            hashMap2.put(LiveActivity.OPTION_TTID, p);
            Object obj2 = map.get("index");
            Object obj3 = null;
            Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
            if (num != null) {
                hashMap2.put("pageNo", Integer.valueOf(num.intValue()));
            }
            ConcurrentMap<String, Object> concurrentMap = ScriptComponent.this.getPageContext().getConcurrentMap();
            if (!(concurrentMap == null || (obj = concurrentMap.get("keyword")) == null)) {
                hashMap2.put("keyword", obj);
            }
            JSONObject data = ScriptComponent.this.getModule().getProperty().getData();
            String str = (String) (data != null ? data.get("layerId") : null);
            JSONObject data2 = ScriptComponent.this.getProperty().getData();
            if (data2 != null) {
                obj3 = data2.get("sectionId");
            }
            DRParam dRParam = new DRParam(str, (String) obj3, JSON.toJSONString(hashMap2));
            hashMap.put("dr", jl1.ARRAY_START + JSON.toJSONString(dRParam) + jl1.ARRAY_END);
            String jSONString = JSON.toJSONString(hashMap2);
            k21.h(jSONString, "toJSONString(args)");
            hashMap.put("args", jSONString);
            Map<String, String> c2 = a20.b().c(ScriptComponent.API_NAME, hashMap);
            k21.h(c2, "getInstance().getParams(…AME, params\n            )");
            return new Request.Builder().setApiName(ScriptComponent.API_NAME).setVersion("1.0").setNeedECode(false).setNeedSession(false).setTimeout(3000).setStrategy(2).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(c2)).build();
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(node, com.youku.arch.v3.core.Constants.CONFIG);
        this.context = iContext;
        setComponentLoader(new ScriptComponentLoader(this, this));
        setRequestBuilder(new ScriptRequestBuilder());
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-782855056")) {
            return this.context;
        }
        return (IContext) ipChange.ipc$dispatch("-782855056", new Object[]{this});
    }

    @Override // com.youku.arch.v3.event.EventHandler, com.youku.arch.v3.core.component.GenericComponent
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578815838")) {
            return ((Boolean) ipChange.ipc$dispatch("578815838", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        if (!k21.d(str, "script_load_more")) {
            return super.onMessage(str, map);
        }
        if (!(map == null || (obj = map.get("componentId")) == null || !k21.d(obj, Integer.valueOf(getType())))) {
            loadMore();
        }
        return true;
    }
}
