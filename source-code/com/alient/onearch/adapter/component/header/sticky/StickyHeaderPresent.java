package com.alient.onearch.adapter.component.header.sticky;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.a;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract;
import com.alient.onearch.adapter.event.StickyHeaderEvent;
import com.alient.onearch.adapter.pom.StickyHeaderTabValue;
import com.alient.onearch.adapter.util.DisplayUtil;
import com.alient.onearch.adapter.util.RecyclerViewUtil;
import com.alient.onearch.adapter.util.ViewUtil;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.onearch.adapter.widget.OnSetTabSelectedCallback;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.google.android.material.tabs.TabLayout;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 `2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002`aB3\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010Y\u001a\u00020W\u0012\b\u0010Z\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\\\u001a\u00020[\u0012\b\u0010]\u001a\u0004\u0018\u00010W¢\u0006\u0004\b^\u0010_J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0016\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020*H\u0016J\u0018\u0010/\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0010H\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0018H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020*H\u0016J\u0010\u00103\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020*H\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020*H\u0016J\u000e\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0018J\b\u00107\u001a\u00020\u000eH\u0016J \u0010;\u001a\u00020\u000e2\u0006\u00109\u001a\u0002082\u0006\u0010\u0011\u001a\u00020*2\u0006\u0010:\u001a\u00020\fH\u0016R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010B\u001a\b\u0018\u00010AR\u00020\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bQ\u0010RR\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006b"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderModel;", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderView;", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderContract$Presenter;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/alibaba/android/vlayout/layout/StickyLayoutHelper$StickyListener;", "Lcom/alient/onearch/adapter/widget/OnSetTabSelectedCallback;", "Landroid/view/View;", "stickyView", "", "isTabClickScroll", "Ltb/ur2;", "scrollToTabAnchor", "Lcom/alient/onearch/adapter/pom/StickyHeaderTabValue;", "tab", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "findViewHolderForTab", "Lcom/alibaba/android/vlayout/DelegateAdapter;", "delegateAdapter", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "innerAdapter", "", "getPositionForAdapter", "Lcom/alibaba/fastjson/JSONObject;", "data", "hasTitle", "item", UCCore.LEGACY_EVENT_INIT, "isValidTab", "", "tabs", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "createTitles", "enableAutoExposeTrack", "pos", "view", "onSticky", "onUnSticky", "Lcom/google/android/material/tabs/TabLayout$Tab;", "reportExposeUserTrack", "reportClickUserTrack", "selectedPosition", "stickyHeaderTabValue", "tabSelected", "unSelectedPosition", "tabUnSelected", "onTabSelected", "onTabUnselected", "onTabReselected", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "scrollToComponentAnchor", "fixLastComponentBackground", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "isScroll", "onSetTabSelected", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent$StickyScrollListener;", "stickyScrollListener", "Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent$StickyScrollListener;", "getStickyScrollListener", "()Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent$StickyScrollListener;", "setStickyScrollListener", "(Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent$StickyScrollListener;)V", "Landroid/view/View;", "getStickyView", "()Landroid/view/View;", "setStickyView", "(Landroid/view/View;)V", "currentAnchorPosition", "I", "offset", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfigs", "Landroid/util/SparseArray;", "", "mClassName", "vClassName", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "Companion", "StickyScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class StickyHeaderPresent extends AbsPresenter<GenericItem<ItemValue>, StickyHeaderModel, StickyHeaderView> implements StickyHeaderContract.Presenter, TabLayout.OnTabSelectedListener, StickyLayoutHelper.StickyListener, OnSetTabSelectedCallback {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "StickyHeaderPresent";
    private SparseArray<ComponentConfigBean.ComponentBean> componentConfigs;
    private int currentAnchorPosition;
    private int offset;
    private RecyclerView recyclerView;
    @Nullable
    private StickyScrollListener stickyScrollListener;
    @Nullable
    private View stickyView;
    @NotNull
    private List<StickyHeaderTabValue> tabs = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent$StickyScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Ltb/ur2;", GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED, "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.f.TYPE_ON_SCROLLED, "", "isTabClickScroll", "Z", "()Z", "setTabClickScroll", "(Z)V", "<init>", "(Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderPresent;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class StickyScrollListener extends RecyclerView.OnScrollListener {
        private boolean isTabClickScroll;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StickyScrollListener() {
        }

        public final boolean isTabClickScroll() {
            return this.isTabClickScroll;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
            k21.i(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                this.isTabClickScroll = false;
            } else if (i == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null && this.isTabClickScroll && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                    StickyHeaderPresent.this.fixLastComponentBackground();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            k21.i(recyclerView, "recyclerView");
            View stickyView = StickyHeaderPresent.this.getStickyView();
            if (stickyView != null) {
                try {
                    StickyHeaderPresent.this.scrollToTabAnchor(stickyView, this.isTabClickScroll);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final void setTabClickScroll(boolean z) {
            this.isTabClickScroll = z;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickyHeaderPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final RecyclerView.ViewHolder findViewHolderForTab(StickyHeaderTabValue stickyHeaderTabValue) {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter;
        RecyclerView recyclerView2;
        IContainer<ModelValue> pageContainer = ((GenericItem) getItem()).getPageContext().getPageContainer();
        if (pageContainer == null) {
            return null;
        }
        Iterator<T> it = pageContainer.getCurrentModules().iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = it.next().getComponents().iterator();
            while (true) {
                if (it2.hasNext()) {
                    T next = it2.next();
                    if (next.getType() == stickyHeaderTabValue.getComponentType() && (adapter = next.getAdapter()) != null) {
                        int positionForAdapter = getPositionForAdapter(pageContainer.getContentAdapter(), adapter);
                        JSONObject data = next.getProperty().getData();
                        if (data != null && hasTitle(data)) {
                            positionForAdapter--;
                        }
                        GenericFragment fragment = ((GenericItem) getItem()).getPageContext().getFragment();
                        if (fragment == null || (recyclerView2 = fragment.getRecyclerView()) == null) {
                            return null;
                        }
                        return recyclerView2.findViewHolderForAdapterPosition(positionForAdapter);
                    }
                }
            }
        }
        return null;
    }

    private final int getPositionForAdapter(DelegateAdapter delegateAdapter, DelegateAdapter.Adapter<?> adapter) {
        int itemCount = delegateAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            Pair<DelegateAdapter.AdapterDataObserver, DelegateAdapter.Adapter> findAdapterByPosition = delegateAdapter.findAdapterByPosition(i);
            if (findAdapterByPosition != null && ((DelegateAdapter.Adapter) findAdapterByPosition.second) == adapter) {
                return i;
            }
        }
        return -1;
    }

    private final boolean hasTitle(JSONObject jSONObject) {
        String string = jSONObject.getString("title");
        return !(string == null || string.length() == 0) && (k21.d(jSONObject.getString("hiddenTitle"), "true") ^ true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void scrollToTabAnchor(View view, boolean z) {
        if (!z) {
            int i = 0;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                k21.A("recyclerView");
            }
            ViewParent parent = recyclerView2.getParent();
            if (!(parent instanceof View)) {
                parent = null;
            }
            View view2 = (View) parent;
            if (view2 != null) {
                i = view2.getTop();
            }
            int size = this.tabs.size() - 1;
            while (size >= 0) {
                RecyclerView.ViewHolder findViewHolderForTab = findViewHolderForTab(this.tabs.get(size));
                if (findViewHolderForTab != null) {
                    DisplayUtil displayUtil = DisplayUtil.INSTANCE;
                    Context context = view.getContext();
                    k21.h(context, "stickyView.context");
                    View view3 = findViewHolderForTab.itemView;
                    k21.h(view3, "viewHolder.itemView");
                    if (((float) view.getBottom()) + displayUtil.dp2px(context, 10.0f) > ((float) (view3.getTop() + i))) {
                        break;
                    }
                }
                size--;
            }
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                k21.A("recyclerView");
            }
            int computeVerticalScrollExtent = recyclerView3.computeVerticalScrollExtent();
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                k21.A("recyclerView");
            }
            float computeVerticalScrollOffset = (float) (computeVerticalScrollExtent + recyclerView4.computeVerticalScrollOffset());
            DisplayUtil displayUtil2 = DisplayUtil.INSTANCE;
            RecyclerView recyclerView5 = this.recyclerView;
            if (recyclerView5 == null) {
                k21.A("recyclerView");
            }
            Context context2 = recyclerView5.getContext();
            k21.h(context2, "recyclerView.context");
            float dp2px = computeVerticalScrollOffset + displayUtil2.dp2px(context2, 100.0f);
            RecyclerView recyclerView6 = this.recyclerView;
            if (recyclerView6 == null) {
                k21.A("recyclerView");
            }
            if (dp2px >= ((float) recyclerView6.computeVerticalScrollRange())) {
                size = this.tabs.size() - 1;
            }
            if (size >= 0 && size < this.tabs.size() && this.currentAnchorPosition != size) {
                this.currentAnchorPosition = size;
                if (!(view instanceof OneTabLayout)) {
                    view = null;
                }
                OneTabLayout oneTabLayout = (OneTabLayout) view;
                if (oneTabLayout != null) {
                    oneTabLayout.setScrollPosition(size, 0.0f, true);
                    ((StickyHeaderView) getView()).updateTabTextSize(size, oneTabLayout, true);
                }
                ((StickyHeaderView) getView()).setScrollPosition(size, 0.0f, true);
            }
        }
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.Presenter
    @NotNull
    public List<RichTitle> createTitles(@NotNull List<StickyHeaderTabValue> list) {
        k21.i(list, "tabs");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            String text = t.getText();
            if (!(true ^ (text == null || text.length() == 0))) {
                text = null;
            }
            if (text != null) {
                arrayList.add(new RichTitle(text, Integer.valueOf(t.getIconType()), t.getIconUrl(), t.getTip(), 0, 16, null));
            }
        }
        return arrayList;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        return false;
    }

    public void fixLastComponentBackground() {
        IModule iModule = (IModule) k.b0(((GenericItem) getItem()).getComponent().getContainer().getCurrentModules());
        IComponent iComponent = (IComponent) k.b0(iModule.getComponents());
        JSONObject data = iComponent.getProperty().getData();
        if (data == null || data.isEmpty()) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iModule.getComponents().get(iComponent.getIndex() - 1).getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(0);
                return;
            }
            return;
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = iComponent.getAdapter();
        if (adapter2 != null) {
            adapter2.notifyDataSetChanged();
        }
    }

    @Nullable
    public final StickyScrollListener getStickyScrollListener() {
        return this.stickyScrollListener;
    }

    @Nullable
    public final View getStickyView() {
        return this.stickyView;
    }

    @NotNull
    public final List<StickyHeaderTabValue> getTabs() {
        return this.tabs;
    }

    public boolean isValidTab(@NotNull StickyHeaderTabValue stickyHeaderTabValue) {
        boolean z;
        ModelValue property;
        List<Node> children;
        k21.i(stickyHeaderTabValue, "tab");
        IContainer<ModelValue> pageContainer = ((GenericItem) getItem()).getPageContext().getPageContainer();
        if (pageContainer == null || (property = pageContainer.getProperty()) == null || (children = property.getChildren()) == null) {
            z = false;
        } else {
            Iterator<T> it = children.iterator();
            z = false;
            while (it.hasNext()) {
                List<Node> children2 = it.next().getChildren();
                if (children2 != null) {
                    Iterator<T> it2 = children2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next = it2.next();
                        if (next.getType() == stickyHeaderTabValue.getComponentType()) {
                            List<Node> children3 = next.getChildren();
                            if (!(children3 == null || children3.isEmpty())) {
                                z = true;
                                break;
                            }
                        }
                        Log.d(TAG, "component type：" + String.valueOf(stickyHeaderTabValue.getComponentType()) + " not support");
                    }
                }
            }
        }
        if (z) {
            String text = stickyHeaderTabValue.getText();
            if (!(text == null || text.length() == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.widget.OnSetTabSelectedCallback
    public void onSetTabSelected(@NotNull TabLayout tabLayout, @NotNull TabLayout.Tab tab, boolean z) {
        k21.i(tabLayout, "tabLayout");
        k21.i(tab, "tab");
    }

    @Override // com.alibaba.android.vlayout.layout.StickyLayoutHelper.StickyListener
    public void onSticky(int i, @Nullable View view) {
        if (view != null) {
            View view2 = this.stickyView;
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (!(view2 instanceof OneTabLayout)) {
                view2 = null;
            }
            OneTabLayout oneTabLayout = (OneTabLayout) view2;
            if (oneTabLayout != null) {
                ViewGroup.LayoutParams layoutParams = oneTabLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = layoutParams;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = this.offset;
                    oneTabLayout.setLayoutParams(marginLayoutParams2);
                }
            }
            View view3 = this.stickyView;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(StickyHeaderEvent.ON_STICKY, new LinkedHashMap());
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        this.currentAnchorPosition = tab.getPosition();
        tabSelected(tab.getPosition(), this.tabs.get(tab.getPosition()));
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        tabSelected(tab.getPosition(), this.tabs.get(tab.getPosition()));
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
    }

    @Override // com.alibaba.android.vlayout.layout.StickyLayoutHelper.StickyListener
    public void onUnSticky(int i, @Nullable View view) {
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(StickyHeaderEvent.ON_UN_STICKY, new LinkedHashMap());
        }
        View view2 = this.stickyView;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        if (view != null) {
            view.postDelayed(new StickyHeaderPresent$onUnSticky$1(this), 50);
        }
        ((StickyHeaderView) getView()).setScrollPosition(0, 0.0f, true);
    }

    public void reportClickUserTrack(@NotNull TabLayout.Tab tab) {
        TrackInfo trackInfo;
        k21.i(tab, "tab");
        try {
            int position = tab.getPosition();
            Action itemAction = getItemAction();
            if (itemAction != null && (trackInfo = itemAction.getTrackInfo()) != null) {
                trackInfo.setSpmd("tab_" + position);
                if (trackInfo.getArgs() == null) {
                    trackInfo.setArgs(new HashMap<>());
                }
                if (position < this.tabs.size()) {
                    HashMap<String, String> args = trackInfo.getArgs();
                    k21.h(args, "args");
                    args.put("tab_id", this.tabs.get(position).getText());
                }
                UserTrackProviderProxy.click(ViewUtil.getTabView(tab), trackInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportExposeUserTrack(@NotNull TabLayout.Tab tab) {
        TrackInfo trackInfo;
        k21.i(tab, "tab");
        try {
            int position = tab.getPosition();
            Action itemAction = getItemAction();
            if (itemAction != null && (trackInfo = itemAction.getTrackInfo()) != null) {
                trackInfo.setSpmd("tab_" + position);
                if (trackInfo.getArgs() == null) {
                    trackInfo.setArgs(new HashMap<>());
                }
                if (position < this.tabs.size()) {
                    HashMap<String, String> args = trackInfo.getArgs();
                    k21.h(args, "args");
                    args.put("tab_id", this.tabs.get(position).getText());
                }
                UserTrackProviderProxy.expose(ViewUtil.getTabView(tab), trackInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void scrollToComponentAnchor(int i) {
        IContainer<ModelValue> pageContainer;
        List<IModule<ModuleValue>> currentModules;
        GenericFragment fragment;
        RecyclerView recyclerView2;
        IContainer<ModelValue> pageContainer2 = ((GenericItem) getItem()).getPageContext().getPageContainer();
        ContentAdapter contentAdapter = pageContainer2 != null ? pageContainer2.getContentAdapter() : null;
        if (contentAdapter != null && (pageContainer = ((GenericItem) getItem()).getPageContext().getPageContainer()) != null && (currentModules = pageContainer.getCurrentModules()) != null) {
            Iterator<T> it = currentModules.iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = it.next().getComponents().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    if (next.getType() == i) {
                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = next.getAdapter();
                        if (adapter != null) {
                            int positionForAdapter = getPositionForAdapter(contentAdapter, adapter);
                            JSONObject data = next.getProperty().getData();
                            if (data != null && hasTitle(data)) {
                                positionForAdapter--;
                            }
                            if (positionForAdapter > 0 && (fragment = ((GenericItem) getItem()).getPageContext().getFragment()) != null && (recyclerView2 = fragment.getRecyclerView()) != null) {
                                StickyScrollListener stickyScrollListener2 = this.stickyScrollListener;
                                if (stickyScrollListener2 != null) {
                                    stickyScrollListener2.setTabClickScroll(true);
                                }
                                View view = this.stickyView;
                                if (view != null) {
                                    int i2 = 0;
                                    RecyclerView recyclerView3 = this.recyclerView;
                                    if (recyclerView3 == null) {
                                        k21.A("recyclerView");
                                    }
                                    if (recyclerView3.getParent() instanceof View) {
                                        RecyclerView recyclerView4 = this.recyclerView;
                                        if (recyclerView4 == null) {
                                            k21.A("recyclerView");
                                        }
                                        ViewParent parent = recyclerView4.getParent();
                                        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
                                        i2 = ((View) parent).getTop();
                                    }
                                    int bottom = view.getBottom() - i2;
                                    if (positionForAdapter == 0) {
                                        bottom -= view.getHeight();
                                    }
                                    RecyclerViewUtil recyclerViewUtil = RecyclerViewUtil.INSTANCE;
                                    Context context = recyclerView2.getContext();
                                    RecyclerView recyclerView5 = this.recyclerView;
                                    if (recyclerView5 == null) {
                                        k21.A("recyclerView");
                                    }
                                    recyclerViewUtil.smoothScrollToPosition(context, recyclerView5, positionForAdapter, bottom);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void setStickyScrollListener(@Nullable StickyScrollListener stickyScrollListener2) {
        this.stickyScrollListener = stickyScrollListener2;
    }

    public final void setStickyView(@Nullable View view) {
        this.stickyView = view;
    }

    public final void setTabs(@NotNull List<StickyHeaderTabValue> list) {
        k21.i(list, "<set-?>");
        this.tabs = list;
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.Presenter
    public void tabSelected(int i, @NotNull StickyHeaderTabValue stickyHeaderTabValue) {
        k21.i(stickyHeaderTabValue, "stickyHeaderTabValue");
        this.currentAnchorPosition = i;
        View view = this.stickyView;
        if (!(view instanceof OneTabLayout)) {
            view = null;
        }
        OneTabLayout oneTabLayout = (OneTabLayout) view;
        if (oneTabLayout != null) {
            oneTabLayout.setScrollPosition(i, 0.0f, true);
            int tabCount = oneTabLayout.getTabCount();
            for (int i2 = 0; i2 < tabCount; i2++) {
                if (i2 == i) {
                    TabLayout.Tab tabAt = oneTabLayout.getTabAt(i2);
                    if (tabAt != null) {
                        k21.h(tabAt, "this");
                        reportClickUserTrack(tabAt);
                        oneTabLayout.setSelectedTab(tabAt, false);
                    }
                } else {
                    TabLayout.Tab tabAt2 = oneTabLayout.getTabAt(i2);
                    if (tabAt2 != null) {
                        k21.h(tabAt2, "this");
                        oneTabLayout.setUnSelectedTab(tabAt2, false);
                    }
                }
            }
        }
        scrollToComponentAnchor(stickyHeaderTabValue.getComponentType());
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderContract.Presenter
    public void tabUnSelected(int i) {
        TabLayout.Tab tabAt;
        View view = this.stickyView;
        if (!(view instanceof OneTabLayout)) {
            view = null;
        }
        OneTabLayout oneTabLayout = (OneTabLayout) view;
        if (oneTabLayout != null && (tabAt = oneTabLayout.getTabAt(i)) != null) {
            k21.h(tabAt, AdvanceSetting.NETWORK_TYPE);
            oneTabLayout.setUnSelectedTab(tabAt, false);
        }
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        RecyclerView recyclerView2;
        JSONArray jSONArray;
        List<StickyHeaderTabValue> javaList;
        RecyclerView recyclerView3;
        View stickyView2;
        Activity activity;
        ConfigManager configManager;
        String pathConfig;
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        if (!(this.componentConfigs != null || (activity = genericItem.getComponent().getPageContext().getActivity()) == null || (configManager = genericItem.getComponent().getPageContext().getConfigManager()) == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null)) {
            this.componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
        }
        Bundle bundle = genericItem.getPageContext().getBundle();
        TabLayout tabLayout = null;
        Object obj = bundle != null ? bundle.get("offset") : null;
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            int intValue = num.intValue();
            if (((StickyHeaderView) getView()).getRenderView() != null) {
                this.offset = intValue;
            }
        }
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        if (!(fragment instanceof StickyHeaderFeature)) {
            fragment = null;
        }
        StickyHeaderFeature stickyHeaderFeature = (StickyHeaderFeature) fragment;
        if (!(stickyHeaderFeature == null || (stickyView2 = stickyHeaderFeature.getStickyView()) == null)) {
            this.stickyView = stickyView2;
        }
        GenericFragment fragment2 = genericItem.getPageContext().getFragment();
        if (!(fragment2 == null || (recyclerView3 = fragment2.getRecyclerView()) == null)) {
            this.recyclerView = recyclerView3;
        }
        JSONObject data = genericItem.getProperty().getData();
        if (!(data == null || (jSONArray = data.getJSONArray("tabs")) == null || (javaList = jSONArray.toJavaList(StickyHeaderTabValue.class)) == null)) {
            this.tabs.clear();
            for (StickyHeaderTabValue stickyHeaderTabValue : javaList) {
                k21.h(stickyHeaderTabValue, AdvanceSetting.NETWORK_TYPE);
                if (isValidTab(stickyHeaderTabValue)) {
                    SparseArray<ComponentConfigBean.ComponentBean> sparseArray = this.componentConfigs;
                    if (sparseArray == null || sparseArray.get(stickyHeaderTabValue.getComponentType()) == null) {
                        ComponentCreatorManager componentCreatorManager = genericItem.getPageContext().getComponentCreatorManager();
                        if (componentCreatorManager != null && componentCreatorManager.isSupport(stickyHeaderTabValue.getComponentType())) {
                            this.tabs.add(stickyHeaderTabValue);
                        }
                    } else {
                        this.tabs.add(stickyHeaderTabValue);
                    }
                }
            }
            ((StickyHeaderView) getView()).renderTab(this.tabs);
        }
        if (this.stickyScrollListener == null) {
            StickyScrollListener stickyScrollListener2 = new StickyScrollListener();
            GenericFragment fragment3 = genericItem.getComponent().getPageContext().getFragment();
            if (!(fragment3 == null || (recyclerView2 = fragment3.getRecyclerView()) == null)) {
                recyclerView2.addOnScrollListener(stickyScrollListener2);
            }
            ur2 ur2 = ur2.INSTANCE;
            this.stickyScrollListener = stickyScrollListener2;
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = genericItem.getComponent().getAdapter();
        a layoutHelper = adapter != null ? adapter.getLayoutHelper() : null;
        if (!(layoutHelper instanceof StickyLayoutHelper)) {
            layoutHelper = null;
        }
        StickyLayoutHelper stickyLayoutHelper = (StickyLayoutHelper) layoutHelper;
        if (stickyLayoutHelper != null) {
            stickyLayoutHelper.i(this);
        }
        View view = this.stickyView;
        if (!(view instanceof OneTabLayout)) {
            view = null;
        }
        OneTabLayout oneTabLayout = (OneTabLayout) view;
        if (oneTabLayout != null) {
            ViewGroup.LayoutParams layoutParams = oneTabLayout.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = this.offset;
                oneTabLayout.setLayoutParams(marginLayoutParams);
            }
            oneTabLayout.removeAllTabs();
            oneTabLayout.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            oneTabLayout.setTitles(createTitles(this.tabs), this.currentAnchorPosition);
            oneTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            oneTabLayout.setOnTabSelectedCallback(this);
            ((StickyHeaderView) getView()).updateTabTextSize(this.currentAnchorPosition, oneTabLayout, false);
            oneTabLayout.setScrollPosition(this.currentAnchorPosition, 0.0f, true);
        }
        TabLayout headerView = ((StickyHeaderView) getView()).headerView();
        if (headerView instanceof TabLayout) {
            tabLayout = headerView;
        }
        if (tabLayout != null) {
            int tabCount = tabLayout.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null) {
                    k21.h(tabAt, AdvanceSetting.NETWORK_TYPE);
                    reportExposeUserTrack(tabAt);
                }
            }
        }
    }
}
