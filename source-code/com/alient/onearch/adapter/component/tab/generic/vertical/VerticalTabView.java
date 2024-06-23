package com.alient.onearch.adapter.component.tab.generic.vertical;

import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alient.onearch.adapter.component.tab.base.BaseTabView;
import com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.util.ViewUtil;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 A2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001AB\u000f\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b?\u0010@J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J \u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0016J@\u0010*\u001a\u00020\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0018\u0010+\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u001bH\u0016R\"\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00104\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00106\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0019\u0010;\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView;", "Lcom/alient/onearch/adapter/component/tab/base/BaseTabView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabModel;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabPresenter;", "Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabContract$View;", "", "Lcom/youku/arch/v3/core/Node;", "componentNodes", "Ltb/ur2;", "createChildComponents", "scrollToTop", "Lcom/alibaba/android/vlayout/DelegateAdapter;", "delegateAdapter", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "innerAdapter", "", "getRealPositionForAdapter", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "onTabSelected", "onTabReselected", "onTabUnselected", "position", "", "positionOffset", "", "updateSelectedText", "setScrollPosition", "selectedPosition", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "tabLayout", "isScroll", "updateTabTextSize", "Lcom/youku/arch/v3/IItem;", "containerItem", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "childComponentNodes", "setChildComponentData", "showCurrentComponent", "", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "childComponents", "Ljava/util/List;", "", "", "Lcom/alient/oneservice/ut/TrackInfo;", "tabTrackInfos", "Ljava/util/Map;", "componentTrackInfos", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class VerticalTabView extends BaseTabView<GenericItem<ItemValue>, VerticalTabModel, VerticalTabPresenter> implements VerticalTabContract.View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.VerticalTabView";
    private final List<IComponent<ComponentValue>> childComponents = new ArrayList();
    private Map<String, TrackInfo> componentTrackInfos = new LinkedHashMap();
    private LinearLayoutManager layoutManager;
    private Map<String, TrackInfo> tabTrackInfos = new LinkedHashMap();
    @NotNull
    private final View view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalTabView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
    }

    private final void createChildComponents(List<? extends Node> list) {
        getContainerItem().getPageContext().runOnLoaderThreadLocked(new VerticalTabView$createChildComponents$1(this, list));
    }

    public int getRealPositionForAdapter(@NotNull DelegateAdapter delegateAdapter, @NotNull DelegateAdapter.Adapter<?> adapter) {
        k21.i(delegateAdapter, "delegateAdapter");
        k21.i(adapter, "innerAdapter");
        int itemCount = delegateAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            Pair<DelegateAdapter.AdapterDataObserver, DelegateAdapter.Adapter> findAdapterByPosition = delegateAdapter.findAdapterByPosition(i);
            if (findAdapterByPosition != null && ((DelegateAdapter.Adapter) findAdapterByPosition.second) == adapter) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        super.onTabReselected(tab);
        onTabSelected(tab);
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        super.onTabSelected(tab);
        setCurrentSelectedTabPosition(tab.getPosition());
        ((VerticalTabPresenter) getPresenter()).tabSelected(tab.getPosition());
        showCurrentComponent(tab.getPosition(), true);
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        super.onTabUnselected(tab);
        ((VerticalTabPresenter) getPresenter()).onTabUnselected(tab);
    }

    public void scrollToTop() {
        int realPositionForAdapter;
        GenericFragment fragment;
        RecyclerView recyclerView;
        IContainer<ModelValue> pageContainer = getContainerItem().getPageContext().getPageContainer();
        ContentAdapter contentAdapter = pageContainer != null ? pageContainer.getContentAdapter() : null;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getContainerItem().getComponent().getAdapter();
        if (adapter != null && contentAdapter != null && (realPositionForAdapter = getRealPositionForAdapter(contentAdapter, adapter)) > 0 && (fragment = getContainerItem().getPageContext().getFragment()) != null && (recyclerView = fragment.getRecyclerView()) != null) {
            recyclerView.scrollToPosition(realPositionForAdapter + 1);
            recyclerView.post(new VerticalTabView$$special$$inlined$apply$lambda$1(recyclerView, realPositionForAdapter));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118 A[Catch:{ Exception -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c A[Catch:{ Exception -> 0x0166 }] */
    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void setChildComponentData(@NotNull IItem<ItemValue> iItem, @NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3) {
        JSONObject data;
        String string;
        TrackInfo trackInfo;
        JSONObject jSONObject;
        String str;
        String str2;
        TrackInfo trackInfo2;
        JSONObject data2;
        String string2;
        TrackInfo trackInfo3;
        String string3;
        Node parent;
        Node parent2;
        JSONObject data3;
        RecyclerView recyclerView;
        k21.i(iItem, "containerItem");
        k21.i(list, "childComponentTitles");
        k21.i(list2, "childComponentBtns");
        k21.i(list3, "childComponentNodes");
        setContainerItem(iItem);
        setChildComponentTitles(list);
        setChildComponentBtns(list2);
        setChildComponentNodes(list3);
        GenericFragment fragment = getContainerItem().getPageContext().getFragment();
        RecyclerView.LayoutManager layoutManager2 = (fragment == null || (recyclerView = fragment.getRecyclerView()) == null) ? null : recyclerView.getLayoutManager();
        if (!(layoutManager2 instanceof LinearLayoutManager)) {
            layoutManager2 = null;
        }
        this.layoutManager = (LinearLayoutManager) layoutManager2;
        List<Node> childComponentNodes = getChildComponentNodes();
        if (childComponentNodes != null) {
            int i = 0;
            for (T t : childComponentNodes) {
                int i2 = i + 1;
                if (i < 0) {
                    m.p();
                }
                T t2 = t;
                JSONObject data4 = t2.getData();
                if (!(data4 == null || (jSONObject = data4.getJSONObject("action")) == null)) {
                    Node parent3 = t2.getParent();
                    if (!(parent3 == null || (parent = parent3.getParent()) == null || (parent2 = parent.getParent()) == null || (data3 = parent2.getData()) == null)) {
                        String string4 = data3.getString(GenericPagerLoader.UT_SPM_AB);
                        if (!(string4 == null || string4.length() == 0)) {
                            List list4 = StringsKt__StringsKt.z0(string4, new String[]{"."}, false, 0, 6, null);
                            if (!(list4 == null || list4.isEmpty()) && list4.size() > 1) {
                                str = (String) list4.get(0);
                                str2 = (String) list4.get(1);
                                HashMap hashMap = (HashMap) JSON.parseObject(jSONObject.toJSONString(), new VerticalTabView$setChildComponentData$1$1$actions$1(), new Feature[0]);
                                Action action = (Action) hashMap.get("tab");
                                if (!(action == null || (trackInfo3 = action.getTrackInfo()) == null)) {
                                    trackInfo3.setSpma(str);
                                    trackInfo3.setSpmb(str2);
                                    String spmd = trackInfo3.getSpmd();
                                    k21.h(spmd, "spmd");
                                    trackInfo3.setSpmd(!(o.v(spmd, JSMethod.NOT_SET, false, 2, null)) ? trackInfo3.getSpmd() + i : trackInfo3.getSpmd());
                                    JSONObject data5 = t2.getData();
                                    if (!(data5 == null || (string3 = data5.getString("nodeId")) == null)) {
                                        this.tabTrackInfos.put(string3, trackInfo3);
                                    }
                                }
                                Action action2 = (Action) hashMap.get("item");
                                if (!(action2 == null || (trackInfo2 = action2.getTrackInfo()) == null || (data2 = t2.getData()) == null || (string2 = data2.getString("nodeId")) == null)) {
                                    this.componentTrackInfos.put(string2, trackInfo2);
                                }
                            }
                        }
                    }
                    str2 = null;
                    str = null;
                    try {
                        HashMap hashMap2 = (HashMap) JSON.parseObject(jSONObject.toJSONString(), new VerticalTabView$setChildComponentData$1$1$actions$1(), new Feature[0]);
                        Action action3 = (Action) hashMap2.get("tab");
                        trackInfo3.setSpma(str);
                        trackInfo3.setSpmb(str2);
                        String spmd2 = trackInfo3.getSpmd();
                        k21.h(spmd2, "spmd");
                        if (!(o.v(spmd2, JSMethod.NOT_SET, false, 2, null))) {
                        }
                        trackInfo3.setSpmd(!(o.v(spmd2, JSMethod.NOT_SET, false, 2, null)) ? trackInfo3.getSpmd() + i : trackInfo3.getSpmd());
                        JSONObject data52 = t2.getData();
                        this.tabTrackInfos.put(string3, trackInfo3);
                        Action action22 = (Action) hashMap2.get("item");
                        this.componentTrackInfos.put(string2, trackInfo2);
                    } catch (Exception e) {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                i = i2;
            }
        }
        this.childComponents.clear();
        getTabLayout().removeAllTabs();
        getTabLayout().clearOnTabSelectedListeners();
        TextView btnOne = getBtnOne();
        if (btnOne != null) {
            btnOne.setText("");
        }
        TextView btnTwo = getBtnTwo();
        if (btnTwo != null) {
            btnTwo.setText("");
        }
        View rightArrow = getRightArrow();
        if (rightArrow != null) {
            rightArrow.setVisibility(8);
        }
        OneTabLayout tabLayout = getTabLayout();
        tabLayout.setTitles(list, getCurrentSelectedTabPosition());
        int tabCount = tabLayout.getTabCount();
        for (int i3 = 0; i3 < tabCount; i3++) {
            View tabView = ViewUtil.getTabView(tabLayout.getTabAt(i3));
            if (!(tabView == null || i3 >= list3.size() || (data = ((Node) list3.get(i3)).getData()) == null || (string = data.getString("nodeId")) == null || (trackInfo = this.tabTrackInfos.get(string)) == null)) {
                UserTrackProviderProxy.expose(tabView, String.valueOf(i3), trackInfo);
            }
        }
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        createChildComponents(list3);
        iItem.getPageContext().runOnLoaderThreadLocked(new VerticalTabView$setChildComponentData$$inlined$apply$lambda$1(this, list, list3, iItem));
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void setScrollPosition(int i, float f, boolean z) {
        setCurrentSelectedTabPosition(i);
        getTabLayout().setScrollPosition(i, f, z);
        updateTabTextSize(i, getTabLayout(), true);
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void showCurrentComponent(int i, boolean z) {
        RefreshLayout refreshLayout;
        String string;
        TrackInfo trackInfo;
        if (i < this.childComponents.size()) {
            IComponent<ComponentValue> iComponent = this.childComponents.get(i);
            JSONObject data = iComponent.getProperty().getData();
            if (!(data == null || (string = data.getString("nodeId")) == null || (trackInfo = this.tabTrackInfos.get(string)) == null)) {
                UserTrackProviderProxy.click(trackInfo, false);
            }
            GenericFragment fragment = getContainerItem().getPageContext().getFragment();
            if (!(fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null)) {
                refreshLayout.setEnableLoadMore(iComponent.hasNext());
                refreshLayout.setNoMoreData(false);
            }
            IModule<ModuleValue> module = getContainerItem().getComponent().getModule();
            module.getChildState().setChanged();
            module.replaceComponent(module.getComponents().size() - 1, iComponent);
        }
        if (z) {
            getContainerItem().getPageContext().runOnUIThreadLocked(new VerticalTabView$showCurrentComponent$4(this));
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View
    public void updateTabTextSize(int i, @NotNull OneTabLayout oneTabLayout, boolean z) {
        k21.i(oneTabLayout, "tabLayout");
        updateSelectedTab(i, oneTabLayout, z);
    }
}
