package com.alibaba.pictures.bricks.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.channel.component.ProjectFilterComponentCreator;
import com.alibaba.pictures.bricks.channel.component.ProjectListComponentCreator;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eh;
import tb.k21;
import tb.nl;
import tb.pn1;
import tb.uq2;

/* compiled from: Taobao */
public final class NewChannelFragment extends BaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String configPath = "://bricks/raw/new_channel_component_config";
    @NotNull
    private final String pageName = "channel";
    @Nullable
    private String utPageName = "channel_default";

    /* compiled from: Taobao */
    public final class ChannelPageLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NewChannelFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChannelPageLoader(@NotNull NewChannelFragment newChannelFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = newChannelFragment;
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1124788765")) {
                ipChange.ipc$dispatch("-1124788765", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            if (k21.d(iResponse.getSource(), "remote")) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("reduce", Boolean.TRUE);
                this.this$0.m887getPageLoader().load(linkedHashMap);
                return;
            }
            super.handleLoadFailure(iResponse);
            this.this$0.getPageContext().runOnUIThread(new NewChannelFragment$ChannelPageLoader$handleLoadFailure$1(this.this$0));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1567940743")) {
                ipChange.ipc$dispatch("-1567940743", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadSuccess(iResponse, i);
            this.this$0.getPageContext().runOnUIThread(new NewChannelFragment$ChannelPageLoader$handleLoadSuccess$1(this.this$0));
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1773159807")) {
                ipChange.ipc$dispatch("1773159807", new Object[]{this, map});
                return;
            }
            k21.i(map, Constants.CONFIG);
            if (this.this$0.getPageContainer().getChildCount() == 0) {
                NewChannelFragment newChannelFragment = this.this$0;
                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(newChannelFragment, newChannelFragment.getActivity(), null, false, 6, null);
            }
            super.load(map);
        }
    }

    /* compiled from: Taobao */
    public final class ChannelPageRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ChannelPageRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            JSONObject parseArg2Json;
            Map<String, Object> innerMap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2123761603")) {
                return (IRequest) ipChange.ipc$dispatch("-2123761603", new Object[]{this, map});
            }
            k21.i(map, Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            PageArgument b = pn1.INSTANCE.b(NewChannelFragment.this.getPageContext().getBundle());
            Boolean bool = null;
            String str = b != null ? b.patternName : null;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = b != null ? b.patternVersion : null;
            if (str3 != null) {
                str2 = str3;
            }
            linkedHashMap.put("patternName", str);
            linkedHashMap.put("patternVersion", str2);
            if (!(b == null || (parseArg2Json = b.parseArg2Json()) == null || (innerMap = parseArg2Json.getInnerMap()) == null)) {
                innerMap.remove("patternName");
                innerMap.remove("patternVersion");
                linkedHashMap2.putAll(innerMap);
            }
            long j = 2;
            Bundle bundle = new Bundle();
            Object obj = map.get("reduce");
            if (obj instanceof Boolean) {
                bool = (Boolean) obj;
            }
            if (bool != null && bool.booleanValue()) {
                j = Constants.RequestStrategy.REMOTE_FILE;
                bundle.putParcelable("uri", Uri.parse("https://oss.taopiaopiao.com/dm_calendar_node_" + str2 + "_bak_" + nl.INSTANCE.a().getCityId() + "_1.json?v=" + System.currentTimeMillis()));
            }
            linkedHashMap2.put("currentCityId", nl.INSTANCE.a().getCityId());
            Request b2 = eh.b(eh.INSTANCE, j, linkedHashMap2, linkedHashMap, null, null, 24, null);
            b2.setBundle(bundle);
            return b2;
        }
    }

    /* compiled from: Taobao */
    public final class PageLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public PageLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516710636")) {
                ipChange.ipc$dispatch("516710636", new Object[]{this});
                return;
            }
            NewChannelFragment.this.getPageContext().runOnUIThread(new NewChannelFragment$PageLoadingListener$onAllPageLoaded$1(NewChannelFragment.this));
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402042170")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-402042170", new Object[]{this, genericPageContainer});
        }
        k21.i(genericPageContainer, "container");
        ChannelPageLoader channelPageLoader = new ChannelPageLoader(this, genericPageContainer);
        channelPageLoader.getLoadingViewManager().addLoadingStateListener(new PageLoadingListener());
        return channelPageLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public boolean enableUTReport() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "932651545")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("932651545", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1495659170")) {
            return this.configPath;
        }
        return (String) ipChange.ipc$dispatch("-1495659170", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-570738813")) {
            return R$layout.bricks_fragment_new_channel;
        }
        return ((Integer) ipChange.ipc$dispatch("-570738813", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-919588847")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("-919588847", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public String getUtPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1391463248")) {
            return this.utPageName;
        }
        return (String) ipChange.ipc$dispatch("1391463248", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public void initConfigManager() {
        ConfigManager.CreatorConfig creatorConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52709020")) {
            ipChange.ipc$dispatch("-52709020", new Object[]{this});
            return;
        }
        super.initConfigManager();
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager != null && (creatorConfig = configManager.getCreatorConfig(2)) != null) {
            creatorConfig.addCreator(7587, new ProjectFilterComponentCreator());
            creatorConfig.addCreator(7588, new ProjectListComponentCreator());
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377809636")) {
            ipChange.ipc$dispatch("377809636", new Object[]{this, bundle});
            return;
        }
        Bundle bundle2 = getPageContext().getBundle();
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        getPageContext().setBundle(bundle2);
        bundle2.putAll(pn1.INSTANCE.a(getArguments()));
        uq2.INSTANCE.i("", "");
        super.onCreate(bundle);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1064823293")) {
            ipChange.ipc$dispatch("1064823293", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableRefresh(false);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableLoadMore(true);
        }
        load(new LinkedHashMap());
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public void setUtPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924195698")) {
            ipChange.ipc$dispatch("-1924195698", new Object[]{this, str});
            return;
        }
        this.utPageName = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public ChannelPageRequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-978791093")) {
            return new ChannelPageRequestBuilder();
        }
        return (ChannelPageRequestBuilder) ipChange.ipc$dispatch("-978791093", new Object[]{this, map});
    }
}
