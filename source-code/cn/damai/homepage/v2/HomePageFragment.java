package cn.damai.homepage.v2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.commonbusiness.tab.DamaiTabViewHelper;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.HomePageGuideBarSearchKeywords;
import cn.damai.homepage.bean.KeyWord;
import cn.damai.homepage.request.HomeConfigRequest;
import cn.damai.homepage.ui.fragment.FragmentAgent;
import cn.damai.homepage.ui.fragment.HomeTabFragment;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import cn.damai.homepage.util.HomeHeadUiBinder;
import cn.damai.homepage.util.LottieMockHelper;
import cn.damai.homepage.v2.feed.FeedComponentCreator;
import cn.damai.homepage.v2.feed.container.FeedTabContainer;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.abtest.provider.ABTestProvider;
import com.alibaba.pictures.bricks.component.home.StateAtmo;
import com.alibaba.pictures.bricks.view.NestedRecyclerView;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.delegate.AutoLoadMoreDelegate;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.resource.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.stat.StatsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bx0;
import tb.d20;
import tb.f8;
import tb.fh0;
import tb.fw0;
import tb.hw0;
import tb.hx0;
import tb.iw0;
import tb.jw0;
import tb.k21;
import tb.kw0;
import tb.m40;
import tb.ns1;
import tb.po2;
import tb.s72;
import tb.ur2;

/* compiled from: Taobao */
public final class HomePageFragment extends BaseFragment implements FragmentAgent, StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final String configPath = "://homepage/raw/homepage_component_config";
    @Nullable
    private HomePageGuideBar guideBar;
    @Nullable
    private HomeHeadUiBinder mHomeHeadUiBinder;
    @NotNull
    private final String pageName = "home";
    @Nullable
    private View stickyHeaderView;
    @Nullable
    private String utPageName = "page_home";

    /* compiled from: Taobao */
    public final class HomePageLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final JSONObject dividerComponentData;
        final /* synthetic */ HomePageFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomePageLoader(@NotNull HomePageFragment homePageFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = homePageFragment;
            JSONObject jSONObject = new JSONObject();
            this.dividerComponentData = jSONObject;
            jSONObject.put((Object) DividerModel.DIVIDER_COLOR, (Object) "#00000000");
            addComponentDecorate(StatsUtil.MSG_SAVE_STATS_HEARTBEAT, new ComponentDecorateItem(9993, 9993, jSONObject, ComponentDecorateItem.Indexer.Before));
        }

        private final void cacheRequestData(IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2055129881")) {
                ipChange.ipc$dispatch("2055129881", new Object[]{this, iResponse});
                return;
            }
            this.this$0.getPageContext().runOnLoaderThread(new HomePageFragment$HomePageLoader$cacheRequestData$1(this, iResponse));
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
            if (r2.intValue() == 7545) goto L_0x007c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x008f A[Catch:{ Exception -> 0x00a2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x009e A[Catch:{ Exception -> 0x00a2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x004e A[SYNTHETIC] */
        public final ur2 filterNeedCacheData(JSONArray jSONArray) {
            Integer num;
            boolean z;
            boolean z2;
            JSONArray jSONArray2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "56465508")) {
                return (ur2) ipChange.ipc$dispatch("56465508", new Object[]{this, jSONArray});
            }
            if (jSONArray == null) {
                return null;
            }
            for (Object obj : jSONArray) {
                try {
                    JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                    Iterator<Object> it = (jSONObject == null || (jSONArray2 = jSONObject.getJSONArray("nodes")) == null) ? null : jSONArray2.iterator();
                    if (!po2.l(it)) {
                        it = null;
                    }
                    if (it != null) {
                        while (it.hasNext()) {
                            String string = ((JSONObject) it.next()).getString("type");
                            if (string != null) {
                                k21.h(string, "getString(\"type\")");
                                num = Integer.valueOf(Integer.parseInt(string));
                            } else {
                                num = null;
                            }
                            if (num == null) {
                                if (num != null) {
                                    if (num.intValue() == 7546) {
                                    }
                                }
                                z = false;
                                if (!z) {
                                    if (num != null) {
                                        if (num.intValue() == 9990) {
                                        }
                                    }
                                    z2 = false;
                                    if (z2) {
                                        it.remove();
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                            z2 = true;
                            if (z2) {
                            }
                        }
                    }
                } catch (Exception e) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return ur2.INSTANCE;
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "-116474219")) {
                ipChange.ipc$dispatch("-116474219", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "componentIterator");
            k21.i(node, "componentNode");
            super.handleComponentNode(listIterator, node);
            if (node.getType() == 9990) {
                List<Node> children = node.getChildren();
                if (children != null) {
                    int size = children.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        List<Node> children2 = children.get(i).getChildren();
                        if (!(children2 == null || children2.isEmpty())) {
                            listIterator.add(children.get(i));
                            node.setMore(true);
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z) {
                    this.this$0.getPageContext().runOnUIThread(new HomePageFragment$HomePageLoader$handleComponentNode$2(this.this$0));
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            Map<String, Object> map;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1776350546")) {
                ipChange.ipc$dispatch("1776350546", new Object[]{this, node, node2});
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

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-392773625")) {
                ipChange.ipc$dispatch("-392773625", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "itemIterator");
            k21.i(node, "itemNode");
            fh0.INSTANCE.a(node);
            super.handleItemNode(listIterator, node);
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1663110976")) {
                ipChange.ipc$dispatch("-1663110976", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            if (k21.d(iResponse.getSource(), "remote")) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("reduce", Boolean.TRUE);
                this.this$0.m887getPageLoader().load(linkedHashMap);
            } else if (!k21.d(iResponse.getSource(), Constants.ResponseSource.REMOTE_FILE) || this.this$0.getPageContainer().getPageLoader().getRealItemCount() > 0) {
                super.handleLoadFailure(iResponse);
                this.this$0.getPageContext().runOnUIThread(new HomePageFragment$HomePageLoader$handleLoadFailure$1(this.this$0, iResponse));
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(Constants.ResponseSource.LOCAL_FILE, Boolean.TRUE);
                this.this$0.m887getPageLoader().load(linkedHashMap2);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.youku.arch.v3.loader.PageLoader
        public void handleLoadFinish(@NotNull IResponse iResponse, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1234867806")) {
                ipChange.ipc$dispatch("1234867806", new Object[]{this, iResponse, Boolean.valueOf(z), Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadFinish(iResponse, z, i);
            if (k21.d(iResponse.getSource(), "remote")) {
                cacheRequestData(iResponse);
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1076060100")) {
                ipChange.ipc$dispatch("-1076060100", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            this.this$0.getPageContext().runOnUIThread(new HomePageFragment$HomePageLoader$handleLoadSuccess$1(this.this$0));
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handlePageBaseInfo(@Nullable String str, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
            List<KeyWord> keywords;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2110679651")) {
                ipChange.ipc$dispatch("2110679651", new Object[]{this, str, jSONObject, jSONObject2});
                return;
            }
            HomePageGuideBarSearchKeywords homePageGuideBarSearchKeywords = jSONObject != null ? (HomePageGuideBarSearchKeywords) jSONObject.toJavaObject(HomePageGuideBarSearchKeywords.class) : null;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (!(homePageGuideBarSearchKeywords == null || (keywords = homePageGuideBarSearchKeywords.getKeywords()) == null)) {
                for (T t : keywords) {
                    arrayList.add(t.getKeyword());
                    arrayList2.add(t);
                }
            }
            this.this$0.getPageContext().runOnUIThread(new HomePageFragment$HomePageLoader$handlePageBaseInfo$2(this.this$0, arrayList, arrayList2));
            super.handlePageBaseInfo(str, jSONObject, jSONObject2);
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public boolean hasNextPage() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-637400733")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-637400733", new Object[]{this})).booleanValue();
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2060676836")) {
                ipChange.ipc$dispatch("-2060676836", new Object[]{this, map});
                return;
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            if (this.this$0.getPageContainer().getChildCount() == 0 || map.containsKey("dialogLoading")) {
                HomePageFragment homePageFragment = this.this$0;
                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(homePageFragment, homePageFragment.getActivity(), null, false, 6, null);
            }
            HashMap hashMap = new HashMap(map);
            if (d20.v()) {
                hashMap.put("reduce", Boolean.TRUE);
            }
            super.load(hashMap);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader
        @Nullable
        public Node parseNode(@NotNull JSONObject jSONObject) {
            HomeHeadUiBinder homeHeadUiBinder;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-832211594")) {
                return (Node) ipChange.ipc$dispatch("-832211594", new Object[]{this, jSONObject});
            }
            k21.i(jSONObject, "response");
            if (AppConfig.v()) {
                LottieMockHelper.c(jSONObject);
            }
            Node node = null;
            try {
                node = super.parseNode(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean d = f8.INSTANCE.d(this.this$0.getPageContext(), node);
            HomePageFragment homePageFragment = this.this$0;
            if (!d && (homeHeadUiBinder = homePageFragment.mHomeHeadUiBinder) != null) {
                homeHeadUiBinder.d();
            }
            Bundle bundle = this.this$0.getPageContext().getBundle();
            if (bundle != null) {
                bundle.putString("initElapsedRealtime", String.valueOf(SystemClock.elapsedRealtime()));
            }
            return node;
        }
    }

    /* compiled from: Taobao */
    public final class HomePageRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        private long strategy = 3;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public HomePageRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-446953984")) {
                return (IRequest) ipChange.ipc$dispatch("-446953984", new Object[]{this, map});
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = (T) new Bundle();
            this.strategy = 2;
            Object obj = map.get("reload");
            String str = null;
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null && bool.booleanValue()) {
                this.strategy = 2;
            }
            Object obj2 = map.get("reduce");
            Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            if (bool2 != null && bool2.booleanValue()) {
                this.strategy = Constants.RequestStrategy.REMOTE_FILE;
                T t = (T) new Bundle();
                t.putParcelable("uri", Uri.parse("https://oss.taopiaopiao.com/app_home_3.2_bak_" + d20.c() + ".json?v=" + System.currentTimeMillis()));
                ref$ObjectRef.element = t;
            }
            Object obj3 = map.get(Constants.ResponseSource.LOCAL_FILE);
            Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            if (bool3 != null) {
                HomePageFragment homePageFragment = HomePageFragment.this;
                if (bool3.booleanValue()) {
                    this.strategy = Constants.RequestStrategy.LOCAL_FILE;
                    T t2 = ref$ObjectRef.element;
                    StringBuilder sb = new StringBuilder();
                    sb.append("android.resource://");
                    Context context = homePageFragment.getContext();
                    if (context != null) {
                        str = context.getPackageName();
                    }
                    sb.append(str);
                    sb.append("/raw/home_cms_local_data");
                    t2.putParcelable("uri", Uri.parse(sb.toString()));
                }
            }
            if (!d20.K()) {
                linkedHashMap2.put("filterComponents", "7541,7542,7543");
            }
            Request b = hx0.b(hx0.INSTANCE, this.strategy, linkedHashMap2, linkedHashMap, null, null, 24, null);
            b.setBundle(ref$ObjectRef.element);
            return b;
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
            if (AndroidInstantRuntime.support(ipChange, "-1764439217")) {
                ipChange.ipc$dispatch("-1764439217", new Object[]{this});
                return;
            }
            HomePageFragment.this.getPageContext().runOnUIThread(new HomePageFragment$PageLoadingListener$onAllPageLoaded$1(HomePageFragment.this));
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final HomePageFragment a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1230876939")) {
                return new HomePageFragment();
            }
            return (HomePageFragment) ipChange.ipc$dispatch("1230876939", new Object[]{this});
        }
    }

    /* access modifiers changed from: private */
    public final void dispatchTabIconUpdate() {
        DamaiTabViewHelper h;
        DamaiTabViewHelper h2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679989275")) {
            ipChange.ipc$dispatch("-1679989275", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof MainActivity)) {
            if (FeedTabContainer.Companion.a(getGuideBarHeight())) {
                DamaiTabbarManager tabbarManager = ((MainActivity) activity).getTabbarManager();
                if (tabbarManager != null && (h2 = tabbarManager.h()) != null) {
                    h2.i();
                    return;
                }
                return;
            }
            DamaiTabbarManager tabbarManager2 = ((MainActivity) activity).getTabbarManager();
            if (tabbarManager2 != null && (h = tabbarManager2.h()) != null) {
                h.h();
            }
        }
    }

    private final void ensureSetUpPageSpmb() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336818686")) {
            ipChange.ipc$dispatch("-336818686", new Object[]{this});
            return;
        }
        new PageUtExecutor(getActivity(), hw0.a).a();
    }

    /* access modifiers changed from: private */
    /* renamed from: ensureSetUpPageSpmb$lambda-6  reason: not valid java name */
    public static final a.b m45ensureSetUpPageSpmb$lambda6(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "672135750")) {
            return new a.b().i("home").a(d20.d());
        }
        return (a.b) ipChange.ipc$dispatch("672135750", new Object[]{Integer.valueOf(i)});
    }

    private final int getGuideBarHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208343999")) {
            return ((Integer) ipChange.ipc$dispatch("-1208343999", new Object[]{this})).intValue();
        }
        HomePageGuideBar homePageGuideBar = this.guideBar;
        if (homePageGuideBar == null) {
            return 0;
        }
        k21.f(homePageGuideBar);
        return homePageGuideBar.getGuideLayoutHeight();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m46onViewCreated$lambda5() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928175047")) {
            ipChange.ipc$dispatch("-1928175047", new Object[0]);
            return;
        }
        HomeTabFragment.requestCalendarData();
        ns1.a(new HomePageFragment$onViewCreated$6$1());
        HomeConfigRequest.requestAppGlobalConfig();
    }

    /* access modifiers changed from: private */
    /* renamed from: scrollToRecommend$lambda-16$lambda-15$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m47xe042fecd(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "294734337")) {
            ipChange.ipc$dispatch("294734337", new Object[]{recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "$this_apply");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i + 1);
        if (findViewHolderForAdapterPosition != null) {
            recyclerView.scrollBy(0, findViewHolderForAdapterPosition.itemView.getTop() - DisplayUtil.dip2px(recyclerView.getContext(), 42.0f));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: stickyTabScrollTop$lambda-20  reason: not valid java name */
    public static final void m48stickyTabScrollTop$lambda20(HomePageFragment homePageFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-162197654")) {
            ipChange.ipc$dispatch("-162197654", new Object[]{homePageFragment});
            return;
        }
        k21.i(homePageFragment, "this$0");
        homePageFragment.dispatchTabIconUpdate();
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787696919")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-1787696919", new Object[]{this, genericPageContainer});
        }
        k21.i(genericPageContainer, "container");
        HomePageLoader homePageLoader = new HomePageLoader(this, genericPageContainer);
        homePageLoader.getLoadingViewManager().addLoadingStateListener(new PageLoadingListener());
        return homePageLoader;
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1086860306")) {
            return new HomePageRequestBuilder();
        }
        return (RequestBuilder) ipChange.ipc$dispatch("-1086860306", new Object[]{this, map});
    }

    @Subscribe(eventType = {f8.KEY_EVENT_ATMOSPHERE_STATE})
    public final void dispatchAtmosphereEvent(@NotNull Event event) {
        HomeHeadUiBinder homeHeadUiBinder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600740784")) {
            ipChange.ipc$dispatch("1600740784", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        Object obj = event.data;
        StateAtmo stateAtmo = obj instanceof StateAtmo ? (StateAtmo) obj : null;
        if (stateAtmo != null && (homeHeadUiBinder = this.mHomeHeadUiBinder) != null) {
            homeHeadUiBinder.f(stateAtmo);
        }
    }

    @Subscribe(eventType = {RefreshEvent.ON_REFRESH_STATE_CHANGED, RefreshEvent.ON_HEADER_MOVING})
    public final void dispatchEvent(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025825394")) {
            ipChange.ipc$dispatch("1025825394", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        HomeHeadUiBinder homeHeadUiBinder = this.mHomeHeadUiBinder;
        if (homeHeadUiBinder != null) {
            homeHeadUiBinder.c(event);
        }
    }

    @Subscribe(eventType = {"EventBus://fragment/notification/home/item/follow-request"})
    public final void dispatchFollowEvent(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976652225")) {
            ipChange.ipc$dispatch("1976652225", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        FragmentActivity activity = getActivity();
        k21.g(activity, "null cannot be cast to non-null type cn.damai.homepage.MainActivity");
        Object obj = event.data;
        k21.g(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        ((MainActivity) activity).showWantSee((String) ((Map) obj).get("id"));
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public boolean enableUTReport() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-72769578")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-72769578", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2051313381")) {
            return this.configPath;
        }
        return (String) ipChange.ipc$dispatch("-2051313381", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1576159936")) {
            return R$layout.homepage_fragment_v2;
        }
        return ((Integer) ipChange.ipc$dispatch("-1576159936", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2141282062")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("2141282062", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1021562912")) {
            return this.stickyHeaderView;
        }
        return (View) ipChange.ipc$dispatch("-1021562912", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public String getUtPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "835809037")) {
            return this.utPageName;
        }
        return (String) ipChange.ipc$dispatch("835809037", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public void initConfigManager() {
        ConfigManager.CreatorConfig creatorConfig;
        ConfigManager.CreatorConfig creatorConfig2;
        ConfigManager.CreatorConfig creatorConfig3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548537991")) {
            ipChange.ipc$dispatch("548537991", new Object[]{this});
            return;
        }
        super.initConfigManager();
        ConfigManager configManager = getPageContext().getConfigManager();
        if (!(configManager == null || (creatorConfig3 = configManager.getCreatorConfig(2)) == null)) {
            creatorConfig3.addCreator(7541, new FeedComponentCreator());
        }
        ConfigManager configManager2 = getPageContext().getConfigManager();
        if (!(configManager2 == null || (creatorConfig2 = configManager2.getCreatorConfig(2)) == null)) {
            creatorConfig2.addCreator(7542, new FeedComponentCreator());
        }
        ConfigManager configManager3 = getPageContext().getConfigManager();
        if (configManager3 != null && (creatorConfig = configManager3.getCreatorConfig(2)) != null) {
            creatorConfig.addCreator(7543, new FeedComponentCreator());
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void logoutRefreshUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581152227")) {
            ipChange.ipc$dispatch("-1581152227", new Object[]{this});
            return;
        }
        HomePageGuideBar homePageGuideBar = this.guideBar;
        if (homePageGuideBar != null) {
            homePageGuideBar.logoutUpdateUI();
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199452743")) {
            ipChange.ipc$dispatch("199452743", new Object[]{this, bundle});
            return;
        }
        HomeFragmentPreloadDelegate homeFragmentPreloadDelegate = bx0.a;
        if (homeFragmentPreloadDelegate != null) {
            if (homeFragmentPreloadDelegate.isInited()) {
                setFragmentPreloadDelegate(homeFragmentPreloadDelegate);
            } else {
                homeFragmentPreloadDelegate.release();
            }
        }
        super.onCreate(bundle);
        getPageContainer().setRequestBuilder(createRequestBuilder(new HashMap<>()));
        ABTestProvider aBTestProvider = ABTestProvider.INSTANCE;
        fw0 fw0 = fw0.INSTANCE;
        aBTestProvider.n(fw0.d(), Long.valueOf(fw0.c()));
        ABTestProvider.k(aBTestProvider, fw0.d(), Long.valueOf(fw0.c()), fw0.a, null, 8, null);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        RecyclerView.Adapter adapter;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "790441568")) {
            ipChange.ipc$dispatch("790441568", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        View realView = getRealView();
        ContentAdapter contentAdapter = null;
        this.stickyHeaderView = realView != null ? realView.findViewById(R$id.feed_tab) : null;
        View realView2 = getRealView();
        HomePageGuideBar homePageGuideBar = realView2 != null ? (HomePageGuideBar) realView2.findViewById(R$id.home_page_guide) : null;
        this.guideBar = homePageGuideBar;
        if (homePageGuideBar != null) {
            homePageGuideBar.initDefault(getActivity(), false);
        }
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableRefresh(true);
        }
        RefreshLayout refreshLayout3 = getRefreshLayout();
        if (refreshLayout3 != null) {
            refreshLayout3.setEnableOverScrollBounce(false);
        }
        RefreshInternal refreshHeader = getRefreshHeader();
        SimpleHeader simpleHeader = refreshHeader instanceof SimpleHeader ? (SimpleHeader) refreshHeader : null;
        if (simpleHeader != null) {
            simpleHeader.setVisibility(4);
            simpleHeader.setId(R$id.one_arch_header);
            simpleHeader.getView().setPadding(0, com.youku.arch.v3.util.DisplayUtil.dip2px(getActivity(), 12.0f), 0, com.youku.arch.v3.util.DisplayUtil.dip2px(getActivity(), 18.0f));
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new HomePageFragment$onViewCreated$2(this));
        }
        this.mHomeHeadUiBinder = new HomeHeadUiBinder(getRealView(), this.guideBar, getRecyclerView());
        ensureSetUpPageSpmb();
        ContentAdapter contentAdapter2 = getPageContainer().getContentAdapter();
        if (contentAdapter2.getAdaptersCount() > 0) {
            z = true;
        }
        if (z) {
            contentAdapter = contentAdapter2;
        }
        if (contentAdapter != null) {
            getPageLoader().getLoadingViewManager().onSuccess();
            getPageContainer().updateContentAdapter();
            RecyclerView recyclerView2 = getRecyclerView();
            if (!(recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("index", 1);
            linkedHashMap.put("reload", Boolean.TRUE);
            load(linkedHashMap);
        } else {
            load(new LinkedHashMap());
        }
        new Handler(Looper.getMainLooper()).postDelayed(kw0.a, 1000);
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshAllFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176041042")) {
            ipChange.ipc$dispatch("176041042", new Object[]{this});
            return;
        }
        refreshHomeFragment(true);
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void refreshHomeFragment(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438717660")) {
            ipChange.ipc$dispatch("438717660", new Object[]{this, Boolean.valueOf(z)});
        } else if (isFragmentVisible() && getRecyclerView() != null) {
            RecyclerView recyclerView = getRecyclerView();
            if (recyclerView != null && recyclerView.canScrollVertically(-1)) {
                recyclerView.scrollToPosition(0);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (z) {
                linkedHashMap.put("dialogLoading", Boolean.TRUE);
            }
            linkedHashMap.put("reload", Boolean.TRUE);
            load(linkedHashMap);
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToRecommend() {
        int realPositionForAdapter;
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136489138")) {
            ipChange.ipc$dispatch("-2136489138", new Object[]{this});
        } else if (!s72.c()) {
            RecyclerView recyclerView2 = getRecyclerView();
            if (recyclerView2 != null && (recyclerView2 instanceof NestedRecyclerView)) {
                ((NestedRecyclerView) recyclerView2).stopDispatchScrollUtilIdle();
            }
            if (!(getActivity() == null || getRecyclerView() == null)) {
                for (T t : getPageContainer().getModules()) {
                    if (t != null) {
                        Iterator<T> it = t.getComponents().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            T next = it.next();
                            if (next.getType() == 9990) {
                                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = next.getAdapter();
                                if (adapter != null && (realPositionForAdapter = getRealPositionForAdapter(getPageContainer().getContentAdapter(), adapter)) > 0 && (recyclerView = getRecyclerView()) != null) {
                                    recyclerView.scrollToPosition(realPositionForAdapter + 1);
                                    recyclerView.post(new iw0(recyclerView, realPositionForAdapter));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // cn.damai.homepage.ui.fragment.FragmentAgent
    public void scrollToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927984683")) {
            ipChange.ipc$dispatch("-927984683", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null && recyclerView.getAdapter() != null && recyclerView.getLayoutManager() != null && recyclerView.getChildAt(0) != null) {
            if ((recyclerView instanceof NestedRecyclerView) && recyclerView.canScrollVertically(-1)) {
                ((NestedRecyclerView) recyclerView).stopDispatchScrollUtilIdle();
            }
            recyclerView.smoothScrollToPosition(0);
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    public void setUtPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969607055")) {
            ipChange.ipc$dispatch("-1969607055", new Object[]{this, str});
            return;
        }
        this.utPageName = str;
    }

    @Subscribe(eventType = {FeedTabContainer.STICKY_SCROLL_TOP})
    public final void stickyTabScrollTop(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161605288")) {
            ipChange.ipc$dispatch("161605288", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        new Handler(Looper.getMainLooper()).postDelayed(new jw0(this), 50);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922614871")) {
            return (List) ipChange.ipc$dispatch("-922614871", new Object[]{this, list});
        }
        List<IDelegate<GenericFragment>> wrapperDelegates = super.wrapperDelegates(list);
        if (wrapperDelegates == null) {
            wrapperDelegates = new ArrayList<>();
        }
        wrapperDelegates.add(new AutoLoadMoreDelegate());
        return wrapperDelegates;
    }
}
