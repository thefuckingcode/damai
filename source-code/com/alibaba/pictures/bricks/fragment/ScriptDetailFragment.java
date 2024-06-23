package com.alibaba.pictures.bricks.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.live.LiveActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoHeaderBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoPresent;
import com.alibaba.pictures.bricks.util.share.ShareProxy;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.amap.api.location.AMapLocation;
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
import com.youku.arch.v3.util.DisplayUtils;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i01;
import tb.k21;
import tb.m40;
import tb.nl;
import tb.o81;
import tb.ur2;
import tb.v42;
import tb.w42;
import tb.wm2;
import tb.x42;
import tb.y42;
import tb.z42;

/* compiled from: Taobao */
public final class ScriptDetailFragment extends BaseFragment implements StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String SCRIPT_ID = "scriptId";
    @NotNull
    public static final String STORE_ID = "storeId";
    @NotNull
    public static final String VERSION = "2.0";
    public Action actionAuth;
    public Action actionShare;
    @Nullable
    private Bitmap blurBit;
    @NotNull
    private final String configPath = "://bricks/raw/script_murder_script_detail_component_config";
    public View mAppNavbar;
    public ImageView mAppTopBg;
    @NotNull
    private final String pageName = "ScriptDetail";
    @Nullable
    private String scriptId;
    @Nullable
    private ScriptInfoHeaderBean scriptInfo;
    @Nullable
    private View stickyHeader;
    @Nullable
    private String storeId;

    /* compiled from: Taobao */
    public final class ScriptDetailLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScriptDetailFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScriptDetailLoader(@NotNull ScriptDetailFragment scriptDetailFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = scriptDetailFragment;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((Object) DividerModel.DIVIDER_COLOR, (Object) "#00000000");
            jSONObject.put((Object) DividerModel.DIVIDER_HEIGHT, (Object) Integer.valueOf(DisplayUtils.dp2px(18)));
            addComponentDecorate(9996, new ComponentDecorateItem(9993, 9993, jSONObject, ComponentDecorateItem.Indexer.Before));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1285743929")) {
                ipChange.ipc$dispatch("-1285743929", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "componentIterator");
            k21.i(node, "componentNode");
            if (node.getType() == 9996 && node.getData() == null) {
                node.setData(new JSONObject());
            }
            super.handleComponentNode(listIterator, node);
            List<Node> children = node.getChildren();
            if (children != null && !children.isEmpty()) {
                z = false;
            }
            if (!z && node.getType() == 7503) {
                handleCreateFooterComponentNode(listIterator, node);
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            List<Node> children;
            JSONObject data;
            JSONObject data2;
            JSONObject data3;
            ur2 ur2;
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2014341046")) {
                ipChange.ipc$dispatch("2014341046", new Object[]{this, node, node2});
                return;
            }
            k21.i(node, "componentNode");
            k21.i(node2, "itemNode");
            if (node.getType() == 7503) {
                if (node.getChildren() != null && (data3 = node2.getData()) != null) {
                    JSONObject data4 = node.getData();
                    if (data4 == null || (obj = data4.get(Constants.TOTAL_NUM)) == null) {
                        ur2 = null;
                    } else {
                        data3.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("查看全部" + obj + "条评价"));
                        ur2 = ur2.INSTANCE;
                    }
                    if (ur2 == null) {
                        data3.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("查看全部" + data3.size() + "条评价"));
                    }
                    data3.put((Object) StyleConstant.FOOTER_BG_START_COLOR, (Object) "#F4F5F6");
                    data3.put((Object) StyleConstant.FOOTER_BG_END_COLOR, (Object) "#F4F5F6");
                    data3.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
                }
            } else if (node.getType() == 7514) {
                List<Node> children2 = node.getChildren();
                if (children2 != null && (data2 = node2.getData()) != null) {
                    data2.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("展开全部" + children2.size() + "个门店"));
                    data2.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                    data2.put((Object) StyleConstant.FOOTER_BG_START_COLOR, (Object) "#F4F5F6");
                    data2.put((Object) StyleConstant.FOOTER_BG_END_COLOR, (Object) "#F4F5F6");
                    data2.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
                }
            } else if (node.getType() == 7520 && (children = node.getChildren()) != null && (data = node2.getData()) != null) {
                data.put((Object) GenericFooterPresent.KEY_EXPEND_CONTENT, (Object) ("展开全部" + children.size() + "个商品"));
                data.put((Object) GenericFooterPresent.KEY_COLLAPSE_CONTENT, (Object) "收起");
                data.put((Object) StyleConstant.FOOTER_BG_START_COLOR, (Object) "#F4F5F6");
                data.put((Object) StyleConstant.FOOTER_BG_END_COLOR, (Object) "#F4F5F6");
                data.put((Object) StyleConstant.FOOTER_TEXT_COLOR, (Object) "#30AEFF");
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1603746564")) {
                ipChange.ipc$dispatch("1603746564", new Object[]{this, node, node2});
                return;
            }
            k21.i(node, "componentNode");
            k21.i(node2, "itemNode");
            int type = node.getType();
            if (!(type == 7503 || type == 7520)) {
                switch (type) {
                    case 7512:
                    case 7513:
                        JSONObject data = node2.getData();
                        if (data != null) {
                            data.put((Object) StyleConstant.HEADER_BG_START_COLOR, (Object) "#00000000");
                            data.put((Object) StyleConstant.HEADER_BG_END_COLOR, (Object) "#00000000");
                            data.put((Object) StyleConstant.HEADER_TEXT_COLOR, (Object) "#FFFFFF");
                            data.put((Object) StyleConstant.HEADER_RIGHT_TEXT_COLOR, (Object) "#B3FFFFFF");
                            return;
                        }
                        return;
                    case 7514:
                    case 7515:
                        break;
                    default:
                        return;
                }
            }
            JSONObject data2 = node2.getData();
            if (data2 != null) {
                data2.put((Object) StyleConstant.HEADER_BG_START_COLOR, (Object) "#F4F5F6");
                data2.put((Object) StyleConstant.HEADER_BG_END_COLOR, (Object) "#F4F5F6");
                data2.put((Object) StyleConstant.HEADER_TEXT_COLOR, (Object) "#000000");
                data2.put((Object) StyleConstant.HEADER_RIGHT_TEXT_COLOR, (Object) "#999999");
            }
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "72606926")) {
                ipChange.ipc$dispatch("72606926", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            if (this.this$0.getActivity() != null) {
                ScriptDetailFragment scriptDetailFragment = this.this$0;
                scriptDetailFragment.getPageContext().runOnUIThread(new ScriptDetailFragment$ScriptDetailLoader$handleLoadFailure$1$1(scriptDetailFragment, iResponse));
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1191587310")) {
                ipChange.ipc$dispatch("1191587310", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                ScriptDetailFragment scriptDetailFragment = this.this$0;
                scriptDetailFragment.getPageContext().runOnUIThread(new ScriptDetailFragment$ScriptDetailLoader$handleLoadSuccess$1$1(scriptDetailFragment, activity));
            }
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "84570538")) {
                ipChange.ipc$dispatch("84570538", new Object[]{this, map});
                return;
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            super.load(map);
            Object obj = map.get("reload");
            if (!k21.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                ScriptDetailFragment scriptDetailFragment = this.this$0;
                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(scriptDetailFragment, scriptDetailFragment.getActivity(), null, false, 6, null);
            }
            this.this$0.setBlurBit(null);
        }
    }

    /* compiled from: Taobao */
    public final class ScriptDetailRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ScriptDetailRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-63061582")) {
                return (IRequest) ipChange.ipc$dispatch("-63061582", new Object[]{this, map});
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            this.params.put("patternName", "dm_app_script_detail");
            this.params.put("patternVersion", "1.0");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String utdid = UTDevice.getUtdid(ScriptDetailFragment.this.getContext());
            k21.h(utdid, "getUtdid(context)");
            linkedHashMap.put("utdid", utdid);
            linkedHashMap.put("comboDamaiCityId", nl.INSTANCE.a().getCityId());
            Context context = ScriptDetailFragment.this.getContext();
            if (context == null || !wm2.INSTANCE.e(context)) {
                z = false;
            }
            if (z) {
                o81 o81 = o81.INSTANCE;
                AMapLocation lastKnownLocation = o81.c().getLastKnownLocation();
                Double d = null;
                linkedHashMap.put("latitude", String.valueOf(lastKnownLocation != null ? Double.valueOf(lastKnownLocation.getLatitude()) : null));
                AMapLocation lastKnownLocation2 = o81.c().getLastKnownLocation();
                if (lastKnownLocation2 != null) {
                    d = Double.valueOf(lastKnownLocation2.getLongitude());
                }
                linkedHashMap.put("longitude", String.valueOf(d));
            }
            String ttid = AppInfoProviderProxy.getTTID();
            k21.h(ttid, "getTTID()");
            linkedHashMap.put(LiveActivity.OPTION_TTID, ttid);
            linkedHashMap.put("comboChannel", "1");
            Object obj = map.get("index");
            if (obj != null) {
                linkedHashMap.put("pageNo", obj);
            }
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 15);
            String str = ScriptDetailFragment.this.scriptId;
            if (str != null) {
                linkedHashMap.put("scriptId", str);
            }
            String str2 = ScriptDetailFragment.this.storeId;
            if (str2 != null) {
                linkedHashMap.put("storeId", str2);
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
            if (!AndroidInstantRuntime.support(ipChange, "-2014200215")) {
                return this.params;
            }
            return (Map) ipChange.ipc$dispatch("-2014200215", new Object[]{this});
        }

        public final long getStrategy() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1258167515")) {
                return this.strategy;
            }
            return ((Long) ipChange.ipc$dispatch("1258167515", new Object[]{this})).longValue();
        }

        public final void setParams(@NotNull Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "500465373")) {
                ipChange.ipc$dispatch("500465373", new Object[]{this, map});
                return;
            }
            k21.i(map, "<set-?>");
            this.params = map;
        }

        public final void setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1259270601")) {
                ipChange.ipc$dispatch("1259270601", new Object[]{this, Long.valueOf(j)});
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

    private final Bitmap getTransparentBitmap(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874518572")) {
            return (Bitmap) ipChange.ipc$dispatch("1874518572", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i2 = (i * 255) / 100;
        for (int i3 = 0; i3 < width; i3++) {
            iArr[i3] = (i2 << 24) | (iArr[i3] & 16777215);
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        k21.h(createBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        return createBitmap;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m158onViewCreated$lambda0(ScriptDetailFragment scriptDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746801426")) {
            ipChange.ipc$dispatch("746801426", new Object[]{scriptDetailFragment, view});
            return;
        }
        k21.i(scriptDetailFragment, "this$0");
        scriptDetailFragment.onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m159onViewCreated$lambda1(ScriptDetailFragment scriptDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530180401")) {
            ipChange.ipc$dispatch("1530180401", new Object[]{scriptDetailFragment, view});
            return;
        }
        k21.i(scriptDetailFragment, "this$0");
        scriptDetailFragment.share();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m160onViewCreated$lambda2(ScriptDetailFragment scriptDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981407920")) {
            ipChange.ipc$dispatch("-1981407920", new Object[]{scriptDetailFragment, view});
            return;
        }
        k21.i(scriptDetailFragment, "this$0");
        scriptDetailFragment.report();
    }

    private final void setDefaultHeaderBg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30329325")) {
            ipChange.ipc$dispatch("-30329325", new Object[]{this});
            return;
        }
        View realView = getRealView();
        View view = null;
        ImageView imageView = realView != null ? (ImageView) realView.findViewById(R$id.scriptkill_top_gaussimg) : null;
        k21.f(imageView);
        setMAppTopBg(imageView);
        View realView2 = getRealView();
        if (realView2 != null) {
            view = realView2.findViewById(R$id.nav_bar);
        }
        k21.f(view);
        setMAppNavbar(view);
        getMAppNavbar().setBackgroundColor(getResources().getColor(R$color.transparent));
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new ScriptDetailFragment$setDefaultHeaderBg$1(this));
        }
    }

    private final void updateHeaderBg(Event event) {
        String url;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392812533")) {
            ipChange.ipc$dispatch("-392812533", new Object[]{this, event});
            return;
        }
        Object obj = event.data;
        ScriptInfoHeaderBean scriptInfoHeaderBean = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap != null ? hashMap.get("value") : null;
        if (obj2 instanceof ScriptInfoHeaderBean) {
            scriptInfoHeaderBean = (ScriptInfoHeaderBean) obj2;
        }
        if (scriptInfoHeaderBean != null && (url = scriptInfoHeaderBean.getUrl()) != null) {
            ImageLoaderProviderProxy.getProxy().load(url, 0, new z42(this), y42.a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateHeaderBg$lambda-8$lambda-6  reason: not valid java name */
    public static final void m161updateHeaderBg$lambda8$lambda6(ScriptDetailFragment scriptDetailFragment, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686441351")) {
            ipChange.ipc$dispatch("1686441351", new Object[]{scriptDetailFragment, successEvent});
            return;
        }
        k21.i(scriptDetailFragment, "this$0");
        Bitmap a2 = i01.a(scriptDetailFragment.getActivity(), successEvent.bitmap, 2, 20);
        scriptDetailFragment.blurBit = a2;
        if (a2 != null) {
            scriptDetailFragment.getMAppTopBg().setImageBitmap(scriptDetailFragment.getTransparentBitmap(a2, 40));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateHeaderBg$lambda-8$lambda-7  reason: not valid java name */
    public static final void m162updateHeaderBg$lambda8$lambda7(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416195365")) {
            ipChange.ipc$dispatch("-1416195365", new Object[]{failEvent});
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-132458835")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-132458835", new Object[]{this, genericPageContainer});
        }
        k21.i(genericPageContainer, "container");
        ScriptDetailLoader scriptDetailLoader = new ScriptDetailLoader(this, genericPageContainer);
        scriptDetailLoader.addComponentDisplayLimit(7502, 5);
        return scriptDetailLoader;
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-221021518")) {
            return new ScriptDetailRequestBuilder();
        }
        return (RequestBuilder) ipChange.ipc$dispatch("-221021518", new Object[]{this, map});
    }

    @NotNull
    public final Action getActionAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306924059")) {
            return (Action) ipChange.ipc$dispatch("-306924059", new Object[]{this});
        }
        Action action = this.actionAuth;
        if (action != null) {
            return action;
        }
        k21.A("actionAuth");
        return null;
    }

    @NotNull
    public final Action getActionShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935003834")) {
            return (Action) ipChange.ipc$dispatch("-935003834", new Object[]{this});
        }
        Action action = this.actionShare;
        if (action != null) {
            return action;
        }
        k21.A("actionShare");
        return null;
    }

    @Nullable
    public final Bitmap getBlurBit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "835714290")) {
            return this.blurBit;
        }
        return (Bitmap) ipChange.ipc$dispatch("835714290", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1277538857")) {
            return this.configPath;
        }
        return (String) ipChange.ipc$dispatch("-1277538857", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-711620100")) {
            return R$layout.bricks_fragment_script_murder_script_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-711620100", new Object[]{this})).intValue();
    }

    @NotNull
    public final View getMAppNavbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121428718")) {
            return (View) ipChange.ipc$dispatch("1121428718", new Object[]{this});
        }
        View view = this.mAppNavbar;
        if (view != null) {
            return view;
        }
        k21.A("mAppNavbar");
        return null;
    }

    @NotNull
    public final ImageView getMAppTopBg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048926844")) {
            return (ImageView) ipChange.ipc$dispatch("2048926844", new Object[]{this});
        }
        ImageView imageView = this.mAppTopBg;
        if (imageView != null) {
            return imageView;
        }
        k21.A("mAppTopBg");
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "738736842")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("738736842", new Object[]{this});
    }

    @Nullable
    public final ScriptInfoHeaderBean getScriptInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "165183684")) {
            return this.scriptInfo;
        }
        return (ScriptInfoHeaderBean) ipChange.ipc$dispatch("165183684", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1490610852")) {
            return this.stickyHeader;
        }
        return (View) ipChange.ipc$dispatch("1490610852", new Object[]{this});
    }

    public final void initActionData(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530043344")) {
            ipChange.ipc$dispatch("-1530043344", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        boolean z = obj instanceof HashMap;
        View view = null;
        HashMap hashMap = z ? (HashMap) obj : null;
        if (!(hashMap == null || (obj3 = hashMap.get("report")) == null)) {
            Action action = obj3 instanceof Action ? (Action) obj3 : null;
            if (action != null) {
                setActionAuth(action);
                View realView = getRealView();
                View findViewById = realView != null ? realView.findViewById(R$id.title_navbar_report) : null;
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
            }
        }
        HashMap hashMap2 = z ? (HashMap) obj : null;
        if (hashMap2 != null && (obj2 = hashMap2.get("share")) != null) {
            Action action2 = obj2 instanceof Action ? (Action) obj2 : null;
            if (action2 != null) {
                setActionShare(action2);
                View realView2 = getRealView();
                if (realView2 != null) {
                    view = realView2.findViewById(R$id.title_navbar_share);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        }
    }

    public final void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340980694")) {
            ipChange.ipc$dispatch("-1340980694", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1785453301")) {
            ipChange.ipc$dispatch("-1785453301", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = null;
        this.scriptId = arguments != null ? arguments.getString("scriptId") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("storeId");
        }
        this.storeId = str;
    }

    public final void onInfoUpdate(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552184714")) {
            ipChange.ipc$dispatch("1552184714", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        ScriptInfoHeaderBean scriptInfoHeaderBean = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap != null ? hashMap.get("value") : null;
        if (obj2 instanceof ScriptInfoHeaderBean) {
            scriptInfoHeaderBean = (ScriptInfoHeaderBean) obj2;
        }
        if (scriptInfoHeaderBean != null) {
            this.scriptInfo = scriptInfoHeaderBean;
        }
    }

    public final void onInfoget(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1650164999")) {
            ipChange.ipc$dispatch("-1650164999", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        initActionData(obj);
        onInfoUpdate(obj);
    }

    @Subscribe(eventType = {ScriptInfoPresent.MSG_SCRIPT_BG_UPDATE})
    public final void onMessageGet(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476355070")) {
            ipChange.ipc$dispatch("1476355070", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        if (k21.d(event.type, ScriptInfoPresent.MSG_SCRIPT_BG_UPDATE)) {
            if (this.blurBit == null) {
                updateHeaderBg(event);
            }
            Object obj = event.data;
            HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
            if (hashMap != null) {
                onInfoget(hashMap);
            }
        }
    }

    public final void onShareClick() {
        Window window;
        ShareInfoBean shareDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652034588")) {
            ipChange.ipc$dispatch("652034588", new Object[]{this});
        } else if (this.scriptInfo != null) {
            Bundle bundle = new Bundle();
            ScriptInfoHeaderBean scriptInfoHeaderBean = this.scriptInfo;
            if (!(scriptInfoHeaderBean == null || (shareDO = scriptInfoHeaderBean.getShareDO()) == null)) {
                bundle.putString("title", shareDO.getShareTitle());
                bundle.putString("message", shareDO.getShareSubTitle());
                bundle.putString("imageurl", shareDO.getShareImage());
                bundle.putString("producturl", shareDO.getShareUrl());
            }
            ShareProxy.IShareProxy a2 = ShareProxy.a();
            FragmentActivity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            a2.share(activity, bundle, (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView());
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448402724")) {
            ipChange.ipc$dispatch("1448402724", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        View realView = getRealView();
        ViewGroup viewGroup = null;
        this.stickyHeader = realView != null ? realView.findViewById(R$id.sticky_header) : null;
        RefreshInternal refreshHeader = getRefreshHeader();
        if (refreshHeader instanceof ViewGroup) {
            viewGroup = (ViewGroup) refreshHeader;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ColorUtil.parseColorSafely("#211616"));
        }
        load(new LinkedHashMap());
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableRefresh(true);
        }
        setDefaultHeaderBg();
        View realView2 = getRealView();
        if (!(realView2 == null || (findViewById3 = realView2.findViewById(R$id.common_navbar_back)) == null)) {
            findViewById3.setOnClickListener(new w42(this));
        }
        View realView3 = getRealView();
        if (!(realView3 == null || (findViewById2 = realView3.findViewById(R$id.title_navbar_share)) == null)) {
            findViewById2.setOnClickListener(new v42(this));
        }
        View realView4 = getRealView();
        if (realView4 != null && (findViewById = realView4.findViewById(R$id.title_navbar_report)) != null) {
            findViewById.setOnClickListener(new x42(this));
        }
    }

    public final void report() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027473200")) {
            ipChange.ipc$dispatch("-1027473200", new Object[]{this});
        } else if (this.actionAuth != null) {
            Action actionAuth2 = getActionAuth();
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(actionAuth2.getActionUrl());
            NavProviderProxy.getProxy().toUri(getActivity(), action);
            TrackInfo trackInfo = actionAuth2.getTrackInfo();
            if (trackInfo != null) {
                k21.h(trackInfo, "trackInfo");
                TrackInfo trackInfo2 = new TrackInfo();
                trackInfo2.setSpmb(trackInfo.getSpmb());
                trackInfo2.setSpmc(trackInfo.getSpmc());
                trackInfo2.setSpmd(trackInfo.getSpmd());
                trackInfo2.setArgs(trackInfo.getArgs());
                UserTrackProviderProxy.getProxy().click(trackInfo2, true);
            }
        }
    }

    public final void setActionAuth(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "279857703")) {
            ipChange.ipc$dispatch("279857703", new Object[]{this, action});
            return;
        }
        k21.i(action, "<set-?>");
        this.actionAuth = action;
    }

    public final void setActionShare(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589120638")) {
            ipChange.ipc$dispatch("1589120638", new Object[]{this, action});
            return;
        }
        k21.i(action, "<set-?>");
        this.actionShare = action;
    }

    public final void setBlurBit(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925416462")) {
            ipChange.ipc$dispatch("1925416462", new Object[]{this, bitmap});
            return;
        }
        this.blurBit = bitmap;
    }

    public final void setMAppNavbar(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823489714")) {
            ipChange.ipc$dispatch("1823489714", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.mAppNavbar = view;
    }

    public final void setMAppTopBg(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598964134")) {
            ipChange.ipc$dispatch("-598964134", new Object[]{this, imageView});
            return;
        }
        k21.i(imageView, "<set-?>");
        this.mAppTopBg = imageView;
    }

    public final void setScriptInfo(@Nullable ScriptInfoHeaderBean scriptInfoHeaderBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351892014")) {
            ipChange.ipc$dispatch("-351892014", new Object[]{this, scriptInfoHeaderBean});
            return;
        }
        this.scriptInfo = scriptInfoHeaderBean;
    }

    public final void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312650823")) {
            ipChange.ipc$dispatch("1312650823", new Object[]{this});
            return;
        }
        onShareClick();
        shareUt();
    }

    public final void shareUt() {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219194200")) {
            ipChange.ipc$dispatch("-1219194200", new Object[]{this});
        } else if (this.actionShare != null && (trackInfo = getActionShare().getTrackInfo()) != null) {
            k21.h(trackInfo, "trackInfo");
            TrackInfo trackInfo2 = new TrackInfo();
            trackInfo2.setSpmb(trackInfo.getSpmb());
            String spmc = trackInfo.getSpmc();
            if (spmc == null) {
                spmc = "top";
            }
            trackInfo2.setSpmc(spmc);
            String spmd = trackInfo.getSpmd();
            if (spmd == null) {
                spmd = "share";
            }
            trackInfo2.setSpmd(spmd);
            trackInfo2.setArgs(trackInfo.getArgs());
            UserTrackProviderProxy.getProxy().click(trackInfo2, false);
        }
    }
}
