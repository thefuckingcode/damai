package cn.damai.commonbusiness.scriptmurder.shopdetail;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.live.LiveActivity;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.ga2;
import tb.hp1;
import tb.k21;
import tb.lp1;
import tb.m40;

/* compiled from: Taobao */
public final class ShopDetailFragment extends BaseFragment implements StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String VERSION = "2.0";
    @NotNull
    private final String configPath = "://commonbusiness/raw/script_murder_shop_detail_component_config";
    @NotNull
    private final String pageName = "ShopDetail";
    @NotNull
    private final Handler refreshHeaderHandler = new Handler();
    @Nullable
    private View stickyHeader;
    @Nullable
    private String storeId;

    /* compiled from: Taobao */
    public final class ShopDetailLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final JSONObject dividerComponentData;
        final /* synthetic */ ShopDetailFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShopDetailLoader(@NotNull ShopDetailFragment shopDetailFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = shopDetailFragment;
            JSONObject jSONObject = new JSONObject();
            this.dividerComponentData = jSONObject;
            jSONObject.put((Object) DividerModel.DIVIDER_COLOR, (Object) "#F5F6F7");
            ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.After;
            addComponentDecorate(7506, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7516, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7520, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7526, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7503, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            JSONObject data;
            Object obj;
            JSONObject data2;
            JSONObject data3;
            JSONObject data4;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-379511963")) {
                ipChange.ipc$dispatch("-379511963", new Object[]{this, node, node2});
                return;
            }
            k21.i(node, "componentNode");
            k21.i(node2, "itemNode");
            if (node.getType() == 7507) {
                List<Node> children = node.getChildren();
                if (children != null && (data4 = node2.getData()) != null) {
                    data4.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("展开全部" + children.size() + "个商品"));
                    data4.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                    data4.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
                }
            } else if (node.getType() == 7520) {
                List<Node> children2 = node.getChildren();
                if (children2 != null && (data3 = node2.getData()) != null) {
                    data3.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("展开全部" + children2.size() + "个商品"));
                    data3.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                    data3.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
                }
            } else if (node.getType() == 7516 && (data = node.getData()) != null && (obj = data.get(Constants.TOTAL_NUM)) != null && (data2 = node2.getData()) != null) {
                data2.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("查看全部" + obj + "个剧本"));
                data2.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                data2.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            JSONObject data;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-790106445")) {
                ipChange.ipc$dispatch("-790106445", new Object[]{this, node, node2});
                return;
            }
            k21.i(node, "componentNode");
            k21.i(node2, "itemNode");
            if (node.getType() == 7503 && (data = node2.getData()) != null) {
                data.put((Object) StyleConstant.HEADER_RIGHT_TEXT_COLOR, (Object) "#999999");
            }
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1055620289")) {
                ipChange.ipc$dispatch("-1055620289", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                ShopDetailFragment shopDetailFragment = this.this$0;
                shopDetailFragment.getPageContext().runOnUIThread(new ShopDetailFragment$ShopDetailLoader$handleLoadFailure$1$1(shopDetailFragment, activity, iResponse));
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "576282013")) {
                ipChange.ipc$dispatch("576282013", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            this.this$0.getPageContext().runOnUIThread(new ShopDetailFragment$ShopDetailLoader$handleLoadSuccess$1(this.this$0));
            FragmentActivity activity = this.this$0.getActivity();
            ShopDetailActivity shopDetailActivity = activity instanceof ShopDetailActivity ? (ShopDetailActivity) activity : null;
            if (shopDetailActivity != null) {
                shopDetailActivity.onRefresh();
            }
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1082508325")) {
                ipChange.ipc$dispatch("-1082508325", new Object[]{this, map});
                return;
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            super.load(map);
            Object obj = map.get("reload");
            if (!k21.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                ShopDetailFragment shopDetailFragment = this.this$0;
                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(shopDetailFragment, shopDetailFragment.getActivity(), null, false, 6, null);
            }
        }
    }

    /* compiled from: Taobao */
    public final class ShopDetailRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ShopDetailRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078341023")) {
                return (IRequest) ipChange.ipc$dispatch("-1078341023", new Object[]{this, map});
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            this.params.put("patternName", "dm_app_script_store");
            this.params.put("patternVersion", LiveFullInfo.VER);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String utdid = UTDevice.getUtdid(ShopDetailFragment.this.getContext());
            k21.h(utdid, "getUtdid(context)");
            linkedHashMap.put("utdid", utdid);
            String c = d20.c();
            k21.h(c, "getCityId()");
            linkedHashMap.put("comboDamaiCityId", c);
            if (hp1.i(lp1.LOCATION)) {
                linkedHashMap.put("latitude", Double.valueOf(d20.n()));
                linkedHashMap.put("longitude", Double.valueOf(d20.o()));
            }
            String p = AppConfig.p();
            k21.h(p, "getTtid()");
            linkedHashMap.put(LiveActivity.OPTION_TTID, p);
            linkedHashMap.put("comboChannel", "1");
            linkedHashMap.put("pageIndex", "1");
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 15);
            String storeId = ShopDetailFragment.this.getStoreId();
            if (storeId != null) {
                linkedHashMap.put("storeId", storeId);
            }
            Map<String, Object> map2 = this.params;
            String jSONString = JSON.toJSONString(linkedHashMap);
            k21.h(jSONString, "toJSONString(args)");
            map2.put("args", jSONString);
            return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion("2.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(this.strategy).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(this.params)).build();
        }

        @NotNull
        public final Map<String, Object> getParams() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "504809242")) {
                return this.params;
            }
            return (Map) ipChange.ipc$dispatch("504809242", new Object[]{this});
        }

        public final long getStrategy() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "91088652")) {
                return this.strategy;
            }
            return ((Long) ipChange.ipc$dispatch("91088652", new Object[]{this})).longValue();
        }

        public final void setParams(@NotNull Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1280347212")) {
                ipChange.ipc$dispatch("1280347212", new Object[]{this, map});
                return;
            }
            k21.i(map, "<set-?>");
            this.params = map;
        }

        public final void setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-560435784")) {
                ipChange.ipc$dispatch("-560435784", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.strategy = j;
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

    /* access modifiers changed from: private */
    /* renamed from: onMessageGet$lambda-3$lambda-2  reason: not valid java name */
    public static final void m12onMessageGet$lambda3$lambda2(ShopDetailFragment shopDetailFragment, Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027449155")) {
            ipChange.ipc$dispatch("-2027449155", new Object[]{shopDetailFragment, event});
            return;
        }
        k21.i(shopDetailFragment, "this$0");
        k21.i(event, "$event");
        Object obj = event.data;
        shopDetailFragment.fireComponentEvent(GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE, obj instanceof Map ? (Map) obj : null);
    }

    private final void updateRefreshHeaderBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1045337630")) {
            ipChange.ipc$dispatch("-1045337630", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RefreshInternal refreshHeader = getRefreshHeader();
        SimpleHeader simpleHeader = refreshHeader instanceof SimpleHeader ? (SimpleHeader) refreshHeader : null;
        if (simpleHeader != null) {
            simpleHeader.setBackgroundColor(i);
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876390001")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("1876390001", new Object[]{this, genericPageContainer});
        }
        k21.i(genericPageContainer, "container");
        ShopDetailLoader shopDetailLoader = new ShopDetailLoader(this, genericPageContainer);
        shopDetailLoader.addComponentDisplayLimit(7507, 5);
        return shopDetailLoader;
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-721040010")) {
            return new ShopDetailRequestBuilder();
        }
        return (RequestBuilder) ipChange.ipc$dispatch("-721040010", new Object[]{this, map});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1598094995")) {
            return this.configPath;
        }
        return (String) ipChange.ipc$dispatch("1598094995", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1735576904")) {
            return R$layout.fragment_script_murder_shop_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-1735576904", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-308548986")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("-308548986", new Object[]{this});
    }

    @NotNull
    public final Handler getRefreshHeaderHandler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1515013844")) {
            return this.refreshHeaderHandler;
        }
        return (Handler) ipChange.ipc$dispatch("1515013844", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "440947048")) {
            return this.stickyHeader;
        }
        return (View) ipChange.ipc$dispatch("440947048", new Object[]{this});
    }

    @Nullable
    public final String getStoreId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1431489926")) {
            return this.storeId;
        }
        return (String) ipChange.ipc$dispatch("1431489926", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120425935")) {
            ipChange.ipc$dispatch("120425935", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("storeId") : null;
        this.storeId = string;
        if (string != null && (bundle2 = getPageContext().getBundle()) != null) {
            bundle2.putString("storeId", string);
        }
    }

    @Subscribe(eventType = {GenericBannerPresenterExt.MSG_BANNER_DETACHED, GenericBannerPresenterExt.MSG_BANNER_ATTACHED, GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE, "EventBus://business/notification/scriptMurder/get_header_info"})
    public final void onMessageGet(@NotNull Event event) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914030274")) {
            ipChange.ipc$dispatch("1914030274", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        String str = event.type;
        if (str != null) {
            CommonNavbarActivity commonNavbarActivity = null;
            ShopDetailActivity shopDetailActivity = null;
            ShopDetailActivity shopDetailActivity2 = null;
            CommonNavbarActivity commonNavbarActivity2 = null;
            switch (str.hashCode()) {
                case -1469126409:
                    if (str.equals(GenericBannerPresenterExt.MSG_BANNER_BG_UPDATE)) {
                        Object obj2 = event.data;
                        Map map = obj2 instanceof Map ? (Map) obj2 : null;
                        if (map != null && (obj = map.get("color")) != null) {
                            FragmentActivity activity = getActivity();
                            if (activity instanceof CommonNavbarActivity) {
                                commonNavbarActivity = (CommonNavbarActivity) activity;
                            }
                            if (commonNavbarActivity != null) {
                                commonNavbarActivity.setNavBarColor(((Integer) obj).intValue());
                            }
                            updateRefreshHeaderBgColor(((Integer) obj).intValue());
                            this.refreshHeaderHandler.postDelayed(new ga2(this, event), 30);
                            return;
                        }
                        return;
                    }
                    return;
                case -938649949:
                    if (str.equals("EventBus://business/notification/scriptMurder/get_header_info")) {
                        Object obj3 = event.data;
                        HashMap hashMap = obj3 instanceof HashMap ? (HashMap) obj3 : null;
                        if (hashMap != null) {
                            FragmentActivity activity2 = getActivity();
                            if (activity2 instanceof CommonNavbarActivity) {
                                commonNavbarActivity2 = (CommonNavbarActivity) activity2;
                            }
                            if (commonNavbarActivity2 != null) {
                                commonNavbarActivity2.onHeaderInfoUpdate(hashMap);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1462675504:
                    if (str.equals(GenericBannerPresenterExt.MSG_BANNER_ATTACHED)) {
                        FragmentActivity activity3 = getActivity();
                        if (activity3 instanceof ShopDetailActivity) {
                            shopDetailActivity2 = (ShopDetailActivity) activity3;
                        }
                        if (shopDetailActivity2 != null) {
                            shopDetailActivity2.stopWithCheck();
                            return;
                        }
                        return;
                    }
                    return;
                case 1968485886:
                    if (str.equals(GenericBannerPresenterExt.MSG_BANNER_DETACHED)) {
                        FragmentActivity activity4 = getActivity();
                        if (activity4 instanceof ShopDetailActivity) {
                            shopDetailActivity = (ShopDetailActivity) activity4;
                        }
                        if (shopDetailActivity != null) {
                            shopDetailActivity.startWithCheck();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590608920")) {
            ipChange.ipc$dispatch("-1590608920", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        View realView = getRealView();
        SimpleHeader simpleHeader = null;
        this.stickyHeader = realView != null ? realView.findViewById(R$id.sticky_header) : null;
        RefreshInternal refreshHeader = getRefreshHeader();
        if (refreshHeader instanceof SimpleHeader) {
            simpleHeader = (SimpleHeader) refreshHeader;
        }
        if (simpleHeader != null) {
            simpleHeader.setBackgroundColor(ColorUtil.parseColorSafely("#825542"));
        }
        load(new LinkedHashMap());
    }

    public final void setStoreId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189738832")) {
            ipChange.ipc$dispatch("-189738832", new Object[]{this, str});
            return;
        }
        this.storeId = str;
    }
}
