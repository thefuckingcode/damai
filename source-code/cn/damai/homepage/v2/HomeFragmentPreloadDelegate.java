package cn.damai.homepage.v2;

import android.app.Activity;
import cn.damai.homepage.v2.feed.FeedComponentCreator;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.parser.component.BasicComponentParser;
import com.alient.onearch.adapter.parser.item.BasicItemParser;
import com.alient.onearch.adapter.parser.model.BasicModelParser;
import com.alient.onearch.adapter.parser.module.BasicModuleParser;
import com.alient.onearch.adapter.style.StyleConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragmentPreloadDelegate;
import com.youku.arch.v3.style.Style;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f8;
import tb.hx0;
import tb.k21;

/* compiled from: Taobao */
public final class HomeFragmentPreloadDelegate extends GenericFragmentPreloadDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isInited;

    /* compiled from: Taobao */
    public final class HomePageLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeFragmentPreloadDelegate this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomePageLoader(@NotNull HomeFragmentPreloadDelegate homeFragmentPreloadDelegate, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = homeFragmentPreloadDelegate;
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            Map<String, Object> map;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "209515827")) {
                ipChange.ipc$dispatch("209515827", new Object[]{this, node, node2});
                return;
            }
            k21.i(node, "componentNode");
            k21.i(node2, "itemNode");
            node.getType();
            if (node2.getStyle() == null) {
                node2.setStyle(new Style());
            }
            Style style = node2.getStyle();
            k21.f(style);
            if (style.cssMap == null) {
                Style style2 = node2.getStyle();
                k21.f(style2);
                style2.cssMap = new LinkedHashMap();
            }
            Style style3 = node2.getStyle();
            if (style3 != null && (map = style3.cssMap) != null) {
                map.put(StyleConstant.HEADER_CORNER, "9");
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.PageLoader
        public void handleLoadFinish(@NotNull IResponse iResponse, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-379168193")) {
                ipChange.ipc$dispatch("-379168193", new Object[]{this, iResponse, Boolean.valueOf(z), Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            this.this$0.setInited(true);
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-107870885")) {
                ipChange.ipc$dispatch("-107870885", new Object[]{this, map});
                return;
            }
            k21.i(map, Constants.CONFIG);
            this.this$0.setInited(false);
            super.load(map);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader
        @Nullable
        public Node parseNode(@NotNull JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "807501527")) {
                return (Node) ipChange.ipc$dispatch("807501527", new Object[]{this, jSONObject});
            }
            k21.i(jSONObject, "response");
            Node parseNode = super.parseNode(jSONObject);
            f8.INSTANCE.d(this.this$0.getPageContext(), parseNode);
            return parseNode;
        }
    }

    /* compiled from: Taobao */
    public final class HomeRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public HomeRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "887239666")) {
                return (IRequest) ipChange.ipc$dispatch("887239666", new Object[]{this, map});
            }
            k21.i(map, Constants.CONFIG);
            return hx0.b(hx0.INSTANCE, 1, new LinkedHashMap(), new LinkedHashMap(), null, null, 24, null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragmentPreloadDelegate(@NotNull Activity activity) {
        super(activity);
        k21.i(activity, "activity");
        setPageName("home");
        ConfigManager configManager = new ConfigManager();
        configManager.getParserConfig(0).addParser(0, new BasicModelParser());
        configManager.getParserConfig(1).addParser(0, new BasicModuleParser());
        configManager.getParserConfig(2).addParser(0, new BasicComponentParser());
        configManager.getParserConfig(3).addParser(0, new BasicItemParser());
        configManager.getCreatorConfig(2).addCreator(7541, new FeedComponentCreator());
        configManager.getCreatorConfig(2).addCreator(7542, new FeedComponentCreator());
        configManager.getCreatorConfig(2).addCreator(7543, new FeedComponentCreator());
        configManager.setPathConfig(ConfigManager.COMPONENT_CONFIG_FILE, "android.resource://home/raw/homepage_component_config");
        setConfigManager(configManager);
        setPageContext(new PageContext());
        PageContext pageContext = getPageContext();
        k21.f(pageContext);
        pageContext.setActivity(activity);
        PageContext pageContext2 = getPageContext();
        k21.f(pageContext2);
        pageContext2.setConfigManager(getConfigManager());
        PageContext pageContext3 = getPageContext();
        k21.f(pageContext3);
        setPageContainer(new GenericPageContainer(pageContext3, null));
        PageContainer<ModelValue> pageContainer = getPageContainer();
        k21.g(pageContainer, "null cannot be cast to non-null type com.youku.arch.v3.core.PageContainer<com.youku.arch.v3.core.ModelValue>");
        setPageLoader(new HomePageLoader(this, pageContainer));
        PageContainer<ModelValue> pageContainer2 = getPageContainer();
        k21.f(pageContainer2);
        PageLoader pageLoader = getPageLoader();
        k21.f(pageLoader);
        pageContainer2.setPageLoader(pageLoader);
        setRequestBuilder(new HomeRequestBuilder());
    }

    public final boolean isInited() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1185136654")) {
            return this.isInited;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1185136654", new Object[]{this})).booleanValue();
    }

    public final void setInited(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106393534")) {
            ipChange.ipc$dispatch("-106393534", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isInited = z;
    }
}
