package cn.damai.commonbusiness.scriptmurder.coupon;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.bean.GaiaXEventTelephone;
import cn.damai.live.LiveActivity;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.event.GaiaXEventDispatcher;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.onearch.adapter.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.IdGenerator;
import com.youku.kubus.Subscribe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.hp1;
import tb.k21;
import tb.lp1;
import tb.m40;
import tb.ne2;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponDetailFragment extends BaseFragment implements StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String API_NAME = "mtop.damai.item.detail.scriptkill.getdetail";
    @NotNull
    public static final String COUPON_ID = "couponId";
    @NotNull
    public static final a Companion = new a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String VERSION = "1.0";
    @NotNull
    private final String configPath = "://commonbusiness/raw/script_murder_coupon_detail_component_config";
    @Nullable
    private String couponId;
    @NotNull
    private final String pageName = "CouponDetail";
    @Nullable
    private View stickyHeader;

    /* compiled from: Taobao */
    public final class CouponDetailLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final JSONObject dividerComponentData;
        final /* synthetic */ CouponDetailFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CouponDetailLoader(@NotNull CouponDetailFragment couponDetailFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = couponDetailFragment;
            JSONObject jSONObject = new JSONObject();
            this.dividerComponentData = jSONObject;
            jSONObject.put((Object) DividerModel.DIVIDER_COLOR, (Object) "#F5F6F7");
            ComponentDecorateItem.Indexer indexer = ComponentDecorateItem.Indexer.After;
            addComponentDecorate(7522, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7524, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7525, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7520, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
            addComponentDecorate(7526, new ComponentDecorateItem(9993, 9993, jSONObject, indexer));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "-1748799467")) {
                ipChange.ipc$dispatch("-1748799467", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "componentIterator");
            k21.i(node, "componentNode");
            super.handleComponentNode(listIterator, node);
            if (node.getType() == 7523) {
                List<Node> children = node.getChildren();
                if (children == null || children.isEmpty()) {
                    z = true;
                }
                if (!(!z)) {
                    children = null;
                }
                if (children != null) {
                    handleCreateFooterComponentNode(listIterator, node);
                    createDecorateComponent(listIterator, node, new ComponentDecorateItem(9993, 9993, this.dividerComponentData, ComponentDecorateItem.Indexer.After));
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleCreateFooterComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "383590814")) {
                ipChange.ipc$dispatch("383590814", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "componentIterator");
            k21.i(node, "componentNode");
            if (node.getType() == 7523) {
                Node node2 = new Node();
                node2.setId(IdGenerator.getId());
                node2.setLevel(2);
                node2.setType(7528);
                node2.setParent(node.getParent());
                node2.setData(node.getData());
                node2.setRawJson(node.getRawJson());
                ArrayList arrayList = new ArrayList();
                Node node3 = new Node();
                node3.setId(IdGenerator.getId());
                node3.setLevel(3);
                node3.setType(7518);
                JSONObject data = node.getData();
                String str = null;
                if (data != null) {
                    Object obj = data.get(Constants.TOTAL_NUM);
                    if (obj instanceof String) {
                        str = (String) obj;
                    }
                    if (str != null) {
                        data.put("content", (Object) ("查看全部" + str + "条购买须知"));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    List<Node> children = node.getChildren();
                    if (children != null) {
                        Iterator<T> it = children.iterator();
                        while (it.hasNext()) {
                            JSONObject data2 = it.next().getData();
                            if (data2 != null) {
                                arrayList2.add(data2);
                            }
                        }
                    }
                    data.put("instructions", (Object) arrayList2);
                } else {
                    data = null;
                }
                node3.setData(data);
                node3.setRawJson(node.getRawJson());
                handleFooterItemProperty(node, node3);
                node3.setParent(node2);
                arrayList.add(node3);
                node2.setChildren(arrayList);
                listIterator.add(node2);
                return;
            }
            super.handleCreateFooterComponentNode(listIterator, node);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            JSONObject data;
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-503385212")) {
                ipChange.ipc$dispatch("-503385212", new Object[]{this, node, node2});
                return;
            }
            k21.i(node, "componentNode");
            k21.i(node2, "itemNode");
            if (node.getType() == 7525 && (data = node2.getData()) != null) {
                JSONObject data2 = node.getData();
                if (data2 == null || (obj = data2.get(Constants.TOTAL_NUM)) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("查看全部");
                    List<Node> children = node.getChildren();
                    sb.append(children != null ? Integer.valueOf(children.size()) : null);
                    sb.append("个剧本");
                    data.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) sb.toString());
                    data.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                    data.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
                    ur2 ur2 = ur2.INSTANCE;
                    return;
                }
                data.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("查看全部" + obj + "个剧本"));
                data.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                data.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
            }
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1942753472")) {
                ipChange.ipc$dispatch("-1942753472", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                CouponDetailFragment couponDetailFragment = this.this$0;
                couponDetailFragment.getPageContext().runOnUIThread(new CouponDetailFragment$CouponDetailLoader$handleLoadFailure$1$1(couponDetailFragment, iResponse, activity));
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1155042884")) {
                ipChange.ipc$dispatch("-1155042884", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            this.this$0.getPageContext().runOnUIThread(new CouponDetailFragment$CouponDetailLoader$handleLoadSuccess$1(this.this$0));
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1269436516")) {
                ipChange.ipc$dispatch("-1269436516", new Object[]{this, map});
                return;
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            super.load(map);
            CouponDetailFragment couponDetailFragment = this.this$0;
            StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(couponDetailFragment, couponDetailFragment.getActivity(), null, false, 6, null);
        }
    }

    /* compiled from: Taobao */
    public final class CouponDetailRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public CouponDetailRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-142780544")) {
                return (IRequest) ipChange.ipc$dispatch("-142780544", new Object[]{this, map});
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            this.params.put("patternName", "dm_app_coupon_detail");
            this.params.put("patternVersion", "1.0");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
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
            String couponId = CouponDetailFragment.this.getCouponId();
            if (couponId != null) {
                linkedHashMap.put(CouponDetailFragment.COUPON_ID, couponId);
            }
            Map<String, Object> map2 = this.params;
            String jSONString = JSON.toJSONString(linkedHashMap);
            k21.h(jSONString, "toJSONString(args)");
            map2.put("args", jSONString);
            return new Request.Builder().setApiName(CouponDetailFragment.API_NAME).setVersion("1.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(this.strategy).setRequestId(com.youku.arch.v3.util.IdGenerator.getId()).setDataParams(new HashMap(this.params)).build();
        }

        @NotNull
        public final Map<String, Object> getParams() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "281403739")) {
                return this.params;
            }
            return (Map) ipChange.ipc$dispatch("281403739", new Object[]{this});
        }

        public final long getStrategy() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-95839539")) {
                return this.strategy;
            }
            return ((Long) ipChange.ipc$dispatch("-95839539", new Object[]{this})).longValue();
        }

        public final void setParams(@NotNull Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1350256085")) {
                ipChange.ipc$dispatch("-1350256085", new Object[]{this, map});
                return;
            }
            k21.i(map, "<set-?>");
            this.params = map;
        }

        public final void setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2060242409")) {
                ipChange.ipc$dispatch("-2060242409", new Object[]{this, Long.valueOf(j)});
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

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284200224")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("284200224", new Object[]{this, genericPageContainer});
        }
        k21.i(genericPageContainer, "container");
        return new CouponDetailLoader(this, genericPageContainer);
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1381596187")) {
            return new CouponDetailRequestBuilder();
        }
        return (RequestBuilder) ipChange.ipc$dispatch("-1381596187", new Object[]{this, map});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "530481988")) {
            return this.configPath;
        }
        return (String) ipChange.ipc$dispatch("530481988", new Object[]{this});
    }

    @Nullable
    public final String getCouponId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1386394594")) {
            return this.couponId;
        }
        return (String) ipChange.ipc$dispatch("-1386394594", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public List<IDelegate<GenericFragment>> getDelegates() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-863789298")) {
            return (List) ipChange.ipc$dispatch("-863789298", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CouponHeaderDelegate());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-431736471")) {
            return R$layout.fragment_script_murder_coupon_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-431736471", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1270552713")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("-1270552713", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1704682199")) {
            return this.stickyHeader;
        }
        return (View) ipChange.ipc$dispatch("1704682199", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474866878")) {
            ipChange.ipc$dispatch("1474866878", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(COUPON_ID) : null;
        this.couponId = string;
        if (!(string == null || (bundle2 = getPageContext().getBundle()) == null)) {
            bundle2.putString(COUPON_ID, string);
        }
        EventBus.getDefault().register(this);
        GaiaXEventTelephone gaiaXEventTelephone = new GaiaXEventTelephone(getActivity());
        GaiaXEventDispatcher.Companion companion = GaiaXEventDispatcher.Companion;
        companion.getInstance().register(getPageName(), "telephone", gaiaXEventTelephone);
        companion.getInstance().register(getPageName(), "map", gaiaXEventTelephone);
        companion.getInstance().register(getPageName(), GaiaXEventTelephone.GAIAX_TELEPHONES_EVENT, gaiaXEventTelephone);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068795010")) {
            ipChange.ipc$dispatch("-1068795010", new Object[]{this});
            return;
        }
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        GaiaXEventDispatcher instance = GaiaXEventDispatcher.Companion.getInstance();
        instance.unregister(getPageName(), "telephone");
        instance.unregister(getPageName(), "map");
        instance.unregister(getPageName(), GaiaXEventTelephone.GAIAX_TELEPHONES_EVENT);
    }

    @Subscribe(eventType = {"EventBus://business/notification/msg_scroll_to_top"})
    public final void onMessageGet(@NotNull Event event) {
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778794319")) {
            ipChange.ipc$dispatch("-778794319", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        if (k21.d(event.type, "EventBus://business/notification/msg_scroll_to_top") && (recyclerView = getRecyclerView()) != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String pathConfig;
        ComponentConfigBean.ComponentBean componentBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549516841")) {
            ipChange.ipc$dispatch("-1549516841", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableRefresh(false);
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
        ConfigManager configManager = getPageContext().getConfigManager();
        if (!(configManager == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null)) {
            ComponentConfigManager instance = ComponentConfigManager.Companion.getInstance();
            FragmentActivity requireActivity = requireActivity();
            k21.h(requireActivity, "requireActivity()");
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = instance.getComponentConfigs(requireActivity, pathConfig);
            if (!(componentConfigs == null || (componentBean = componentConfigs.get(9996)) == null)) {
                if (componentBean.getLayout().getParams() == null) {
                    componentBean.getLayout().setParams(new HashMap<>());
                }
                DisplayUtil displayUtil = DisplayUtil.INSTANCE;
                FragmentActivity requireActivity2 = requireActivity();
                k21.h(requireActivity2, "requireActivity()");
                int dp2px = ((int) displayUtil.dp2px(requireActivity2, 43.0f)) + ne2.a(requireActivity());
                HashMap<String, Object> params = componentBean.getLayout().getParams();
                k21.h(params, "layout.params");
                params.put("offset", Integer.valueOf(dp2px));
                Bundle bundle2 = getPageContext().getBundle();
                if (bundle2 != null) {
                    bundle2.putInt("offset", dp2px);
                }
            }
        }
        load(new LinkedHashMap());
    }

    @Subscribe(eventType = {"scriptCouponRefresh"})
    public final void scriptCouponRefresh(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052987163")) {
            ipChange.ipc$dispatch("-2052987163", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        getPageContainer().reload();
    }

    public final void setCouponId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "89112704")) {
            ipChange.ipc$dispatch("89112704", new Object[]{this, str});
            return;
        }
        this.couponId = str;
    }
}
