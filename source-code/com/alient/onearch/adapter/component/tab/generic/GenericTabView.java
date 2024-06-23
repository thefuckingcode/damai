package com.alient.onearch.adapter.component.tab.generic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alient.onearch.adapter.Constant;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.tab.GenericTabViewContainer;
import com.alient.onearch.adapter.component.tab.ITabSelectedListener;
import com.alient.onearch.adapter.component.tab.base.BaseTabView;
import com.alient.onearch.adapter.component.tab.generic.GenericTabContract;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.util.ViewUtil;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.GenericRenderPlugin;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.pn;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b7\u00108J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J@\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J&\u0010!\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R.\u0010+\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u0004\u0012\u00020*0)0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/GenericTabView;", "Lcom/alient/onearch/adapter/component/tab/base/BaseTabView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabModel;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabPresenter;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabContract$View;", "", "position", "", "clickTab", "Ltb/ur2;", "showCurrentComponent", "Lcom/youku/arch/v3/core/Node;", "componentNode", "index", "createChildComponent", "showTabIndicator", "hideTabIndicator", "Lcom/youku/arch/v3/IItem;", "containerItem", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "childComponentNodes", "setChildComponentData", "", "type", "", "", "map", "dispatchViewHolderMessage", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "onTabSelected", "Lcom/alient/onearch/adapter/component/tab/GenericTabViewContainer;", "contentContainer", "Lcom/alient/onearch/adapter/component/tab/GenericTabViewContainer;", "", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "componentViewHolders", "Ljava/util/List;", "", "Lcom/alient/oneservice/ut/TrackInfo;", "tabTrackInfos", "Ljava/util/Map;", "componentTrackInfos", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericTabView extends BaseTabView<GenericItem<ItemValue>, GenericTabModel, GenericTabPresenter> implements GenericTabContract.View {
    private Map<String, TrackInfo> componentTrackInfos = new LinkedHashMap();
    private final List<VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> componentViewHolders = new ArrayList();
    private final GenericTabViewContainer contentContainer;
    private Map<String, TrackInfo> tabTrackInfos = new LinkedHashMap();
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericTabView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        View findViewById = view2.findViewById(R.id.content_container);
        k21.h(findViewById, "view.findViewById(R.id.content_container)");
        this.contentContainer = (GenericTabViewContainer) findViewById;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v6, resolved type: java.util.List<com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v7, resolved type: java.util.List<com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v12, resolved type: java.util.List<com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v13, resolved type: java.util.List<com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> */
    /* JADX WARN: Multi-variable type inference failed */
    private final void createChildComponent(Node node, int i) {
        ViewTypeConfig viewTypeConfig;
        Integer layoutResId;
        ViewTypeSupport viewTypeSupport = getContainerItem().getPageContext().getViewTypeSupport();
        if (viewTypeSupport != null && (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node.getType() << 16)) != null && (layoutResId = viewTypeConfig.getLayoutResId()) != null) {
            GenericRenderPlugin genericRenderPlugin = null;
            View inflate = LayoutInflater.from(this.view.getContext()).inflate(layoutResId.intValue(), (ViewGroup) null, false);
            if (inflate != null) {
                Class<?> viewHolderClass = viewTypeConfig.getViewHolderClass();
                Constructor<?> constructor = viewHolderClass != null ? viewHolderClass.getConstructor(View.class) : null;
                VBaseHolder vBaseHolder = constructor != null ? (VBaseHolder) constructor.newInstance(inflate) : null;
                ConfigManager configManager = getContainerItem().getPageContext().getConfigManager();
                String pathConfig = configManager != null ? configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE) : null;
                RenderPluginConfigCenter.Companion companion = RenderPluginConfigCenter.Companion;
                if (companion.getInstance().isSupportRenderPlugin(getContainerItem().getPageContext(), pathConfig, String.valueOf(viewTypeConfig.getViewType()))) {
                    GenericRenderConfig genericRenderConfig = new GenericRenderConfig();
                    genericRenderConfig.setType(String.valueOf(viewTypeConfig.getViewType()));
                    genericRenderConfig.setMClassName(viewTypeConfig.getModel());
                    genericRenderConfig.setMClassNameOpt(viewTypeConfig.getModelOpt());
                    genericRenderConfig.setVClassName(viewTypeConfig.getView());
                    genericRenderConfig.setVClassNameOpt(viewTypeConfig.getViewOpt());
                    genericRenderConfig.setPClassName(viewTypeConfig.getPresenter());
                    genericRenderConfig.setPClassNameOpt(viewTypeConfig.getPresenterOpt());
                    genericRenderConfig.setLayoutId(viewTypeConfig.getLayoutResId());
                    genericRenderConfig.setLayoutIdOpt(viewTypeConfig.getLayoutResIdOpt());
                    genericRenderConfig.setLayoutStr(viewTypeConfig.getLayoutResString());
                    genericRenderConfig.setLayoutStrOpt(viewTypeConfig.getLayoutResStringOpt());
                    genericRenderConfig.setExtra(viewTypeConfig.wrapParams(genericRenderConfig.getExtra()));
                    RenderPluginFactory renderPluginFactory = companion.getInstance().getRenderPluginFactory(pathConfig, String.valueOf(viewTypeConfig.getViewType()));
                    AbsRenderPlugin<?, ?> create = renderPluginFactory != null ? renderPluginFactory.create() : null;
                    if (!(create instanceof AbsRenderPlugin)) {
                        create = null;
                    }
                    if (create != null) {
                        create.attachContext(getContainerItem().getPageContext());
                    }
                    if (create instanceof GenericRenderPlugin) {
                        genericRenderPlugin = create;
                    }
                    GenericRenderPlugin genericRenderPlugin2 = genericRenderPlugin;
                    if (genericRenderPlugin2 != null) {
                        genericRenderPlugin2.setRenderView(inflate);
                    }
                    if (create != null) {
                        try {
                            create.setConfig(genericRenderConfig);
                        } catch (Exception e) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw e;
                            }
                            return;
                        }
                    }
                    if (vBaseHolder != null) {
                        vBaseHolder.setPageContext(getContainerItem().getPageContext());
                        Context context = this.contentContainer.getContext();
                        k21.h(context, "contentContainer.context");
                        vBaseHolder.setContext(context);
                        vBaseHolder.setRenderPlugin(create);
                        GenericItem genericItem = new GenericItem(getContainerItem().getPageContext());
                        genericItem.setProperty(new ItemValue(node));
                        genericItem.setType(node.getType());
                        genericItem.setComponent(getContainerItem().getComponent());
                        genericItem.getProperty().setData(node.getData());
                        genericItem.getExtra().putInt("index", i);
                        vBaseHolder.setData(genericItem);
                        if (i < this.componentViewHolders.size()) {
                            this.componentViewHolders.set(i, vBaseHolder);
                        } else {
                            this.componentViewHolders.add(vBaseHolder);
                        }
                    }
                } else if (vBaseHolder != null) {
                    try {
                        vBaseHolder.setPageContext(getContainerItem().getPageContext());
                        Context context2 = this.contentContainer.getContext();
                        k21.h(context2, "contentContainer.context");
                        vBaseHolder.setContext(context2);
                        vBaseHolder.onCreate();
                        GenericItem genericItem2 = new GenericItem(getContainerItem().getPageContext());
                        genericItem2.setProperty(new ItemValue(node));
                        genericItem2.setType(node.getType());
                        genericItem2.setComponent(getContainerItem().getComponent());
                        genericItem2.getProperty().setData(node.getData());
                        genericItem2.getExtra().putInt("index", i);
                        vBaseHolder.setData(genericItem2);
                        if (i < this.componentViewHolders.size()) {
                            this.componentViewHolders.set(i, vBaseHolder);
                        } else {
                            this.componentViewHolders.add(vBaseHolder);
                        }
                    } catch (Exception e2) {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw e2;
                        }
                    }
                }
            }
        }
    }

    private final void showCurrentComponent(int i, boolean z) {
        TabLayout.Tab tabAt;
        ItemValue property;
        JSONObject data;
        String string;
        TrackInfo trackInfo;
        this.contentContainer.removeAllViews();
        int i2 = 0;
        for (T t : this.componentViewHolders) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                m.p();
            }
            T t2 = t;
            T t3 = null;
            T t4 = !(t2 instanceof ITabSelectedListener) ? null : t2;
            if (t4 != null) {
                t4.onTabSelected(i);
            }
            if (i2 == i) {
                if (t2 instanceof BaseViewHolder) {
                    t3 = t2;
                }
                T t5 = t3;
                if (t5 != null) {
                    t5.setSelected(true);
                }
                IItem data2 = t2.getData();
                if (!(data2 == null || (property = data2.getProperty()) == null || (data = property.getData()) == null || (string = data.getString("nodeId")) == null)) {
                    TrackInfo trackInfo2 = this.componentTrackInfos.get(string);
                    if (trackInfo2 != null) {
                        View view2 = t2.itemView;
                        StringBuilder sb = new StringBuilder();
                        View view3 = t2.itemView;
                        k21.h(view3, "viewHolder.itemView");
                        sb.append(String.valueOf(view3.getId()));
                        sb.append(trackInfo2.getSpmc());
                        sb.append(trackInfo2.getSpmd());
                        UserTrackProviderProxy.expose(view2, sb.toString(), trackInfo2);
                    }
                    if (z && (trackInfo = this.tabTrackInfos.get(string)) != null) {
                        UserTrackProviderProxy.click(trackInfo, false);
                    }
                }
                this.contentContainer.addView(t2.itemView, new ViewGroup.LayoutParams(-1, -2));
            } else {
                if (!(t2 instanceof BaseViewHolder)) {
                    t2 = null;
                }
                T t6 = t2;
                if (t6 != null) {
                    t6.setSelected(false);
                }
            }
            i2 = i3;
        }
        OneTabLayout tabLayout = getTabLayout();
        if (tabLayout.getTabCount() > i && (tabAt = tabLayout.getTabAt(i)) != null) {
            k21.h(tabAt, AdvanceSetting.NETWORK_TYPE);
            resetComponentRightBtns(tabAt);
        }
        int i4 = 0;
        for (T t7 : this.componentViewHolders) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                m.p();
            }
            T t8 = t7;
            HashMap hashMap = new HashMap(1);
            hashMap.put("selected", Boolean.valueOf(i4 == i));
            t8.onMessage(ViewHolderEvent.ON_VIEW_SELECTED, hashMap);
            i4 = i5;
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public boolean dispatchViewHolderMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        k21.i(str, "type");
        if (this.componentViewHolders.isEmpty()) {
            return false;
        }
        for (VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder : this.componentViewHolders) {
            vBaseHolder.onMessage(str, map);
        }
        return true;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public void hideTabIndicator() {
        getTabLayout().hideIndicator();
    }

    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabView, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        super.onTabSelected(tab);
        showCurrentComponent(getCurrentSelectedTabPosition(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:162:0x0169 A[SYNTHETIC] */
    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public void setChildComponentData(@NotNull IItem<ItemValue> iItem, @NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3) {
        boolean z;
        Bundle extra;
        ItemValue property;
        ItemValue property2;
        ItemValue property3;
        JSONObject data;
        String string;
        Iterator<T> it;
        JSONObject jSONObject;
        String str;
        String str2;
        Exception e;
        TrackInfo trackInfo;
        String string2;
        TrackInfo trackInfo2;
        String string3;
        Node parent;
        Node parent2;
        JSONObject data2;
        k21.i(iItem, "containerItem");
        k21.i(list, "childComponentTitles");
        k21.i(list2, "childComponentBtns");
        k21.i(list3, "childComponentNodes");
        setContainerItem(iItem);
        setChildComponentTitles(list);
        setChildComponentBtns(list2);
        setChildComponentNodes(list3);
        List<Node> childComponentNodes = getChildComponentNodes();
        int i = 1;
        if (childComponentNodes != null) {
            Iterator<T> it2 = childComponentNodes.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                T next = it2.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    m.p();
                }
                T t = next;
                JSONObject data3 = t.getData();
                if (data3 == null || (jSONObject = data3.getJSONObject("action")) == null) {
                    it = it2;
                } else {
                    Node parent3 = t.getParent();
                    if (parent3 == null || (parent = parent3.getParent()) == null || (parent2 = parent.getParent()) == null || (data2 = parent2.getData()) == null) {
                        str2 = null;
                        str = null;
                    } else {
                        String string4 = data2.getString(GenericPagerLoader.UT_SPM_AB);
                        if (!(string4 == null || string4.length() == 0)) {
                            List list4 = StringsKt__StringsKt.z0(string4, new String[]{"."}, false, 0, 6, null);
                            if (!(list4 == null || list4.isEmpty()) && list4.size() > i) {
                                str = (String) list4.get(0);
                                str2 = (String) list4.get(i);
                                ur2 ur2 = ur2.INSTANCE;
                            }
                        }
                        str2 = null;
                        str = null;
                        ur2 ur22 = ur2.INSTANCE;
                    }
                    try {
                        HashMap hashMap = (HashMap) JSON.parseObject(jSONObject.toJSONString(), new GenericTabView$setChildComponentData$1$1$actions$1(), new Feature[0]);
                        Action action = (Action) hashMap.get("tab");
                        if (action == null || (trackInfo2 = action.getTrackInfo()) == null) {
                            it = it2;
                        } else {
                            trackInfo2.setSpma(str);
                            trackInfo2.setSpmb(str2);
                            String spmd = trackInfo2.getSpmd();
                            k21.h(spmd, "spmd");
                            it = it2;
                            try {
                                trackInfo2.setSpmd(o.v(spmd, JSMethod.NOT_SET, false, 2, null) ? trackInfo2.getSpmd() + i2 : trackInfo2.getSpmd());
                                JSONObject data4 = t.getData();
                                if (!(data4 == null || (string3 = data4.getString("nodeId")) == null)) {
                                    this.tabTrackInfos.put(string3, trackInfo2);
                                    ur2 ur23 = ur2.INSTANCE;
                                }
                                ur2 ur24 = ur2.INSTANCE;
                            } catch (Exception e2) {
                                e = e2;
                                if (AppInfoProviderProxy.isDebuggable()) {
                                }
                                ur2 ur25 = ur2.INSTANCE;
                                it2 = it;
                                i2 = i3;
                                i = 1;
                            }
                        }
                        Action action2 = (Action) hashMap.get("item");
                        if (!(action2 == null || (trackInfo = action2.getTrackInfo()) == null)) {
                            trackInfo.setSpma(str);
                            trackInfo.setSpmb(str2);
                            JSONObject data5 = t.getData();
                            if (!(data5 == null || (string2 = data5.getString("nodeId")) == null)) {
                                this.componentTrackInfos.put(string2, trackInfo);
                                ur2 ur26 = ur2.INSTANCE;
                            }
                            ur2 ur27 = ur2.INSTANCE;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        it = it2;
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw new RuntimeException(e);
                        }
                        ur2 ur252 = ur2.INSTANCE;
                        it2 = it;
                        i2 = i3;
                        i = 1;
                    }
                    ur2 ur2522 = ur2.INSTANCE;
                }
                it2 = it;
                i2 = i3;
                i = 1;
            }
            ur2 ur28 = ur2.INSTANCE;
        }
        getTabLayout().clearOnTabSelectedListeners();
        getTabLayout().removeAllTabs();
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
        for (int i4 = 0; i4 < tabCount; i4++) {
            View tabView = ViewUtil.getTabView(tabLayout.getTabAt(i4));
            if (tabView != null) {
                if (!(i4 >= list3.size() || (data = ((Node) list3.get(i4)).getData()) == null || (string = data.getString("nodeId")) == null)) {
                    TrackInfo trackInfo3 = this.tabTrackInfos.get(string);
                    if (trackInfo3 != null) {
                        UserTrackProviderProxy.expose(tabView, String.valueOf(i4), trackInfo3);
                        ur2 ur29 = ur2.INSTANCE;
                    }
                    ur2 ur210 = ur2.INSTANCE;
                }
                ur2 ur211 = ur2.INSTANCE;
            }
        }
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        List<Node> childComponentNodes2 = getChildComponentNodes();
        if (childComponentNodes2 != null) {
            if (childComponentNodes2.size() < this.componentViewHolders.size()) {
                int size = this.componentViewHolders.size() - 1;
                int size2 = childComponentNodes2.size();
                if (size >= size2) {
                    while (true) {
                        List<VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> list5 = this.componentViewHolders;
                        list5.remove(list5.get(size));
                        if (size == size2) {
                            break;
                        }
                        size--;
                    }
                }
            }
            String string5 = pn.d().getString(Constant.KEY_VIEW_HOLDER_REUSABLE, "true");
            if (string5 != null) {
                z = Boolean.valueOf(Boolean.parseBoolean(string5)).booleanValue();
                ur2 ur212 = ur2.INSTANCE;
            } else {
                z = true;
            }
            int i5 = 0;
            for (T t2 : childComponentNodes2) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    m.p();
                }
                T t3 = t2;
                if (z && i5 < this.componentViewHolders.size()) {
                    int type = t3.getType();
                    IItem<ItemValue> data6 = this.componentViewHolders.get(i5).getData();
                    if (data6 != null && type == data6.getType()) {
                        IItem<ItemValue> data7 = this.componentViewHolders.get(i5).getData();
                        if (!(data7 == null || (property3 = data7.getProperty()) == null)) {
                            property3.setType(t3.getType());
                        }
                        if (!(data7 == null || (property2 = data7.getProperty()) == null)) {
                            property2.setData(t3.getData());
                        }
                        if (!(data7 == null || (property = data7.getProperty()) == null)) {
                            property.setChildren(t3.getChildren());
                        }
                        if (data7 != null) {
                            data7.setComponent(getContainerItem().getComponent());
                        }
                        if (!(data7 == null || (extra = data7.getExtra()) == null)) {
                            extra.putInt("index", i5);
                            ur2 ur213 = ur2.INSTANCE;
                        }
                        this.componentViewHolders.get(i5).setData(data7);
                        i5 = i6;
                    }
                }
                createChildComponent(t3, i5);
                i5 = i6;
            }
            updateSelectedTab(getCurrentSelectedTabPosition(), getTabLayout(), false);
            if (getCurrentSelectedTabPosition() < tabLayout.getTabCount()) {
                showCurrentComponent(getCurrentSelectedTabPosition(), false);
            }
            ur2 ur214 = ur2.INSTANCE;
        }
        ur2 ur215 = ur2.INSTANCE;
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.GenericTabContract.View
    public void showTabIndicator() {
        getTabLayout().showIndicator();
    }
}
