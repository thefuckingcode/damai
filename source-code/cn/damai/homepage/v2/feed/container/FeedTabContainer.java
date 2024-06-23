package cn.damai.homepage.v2.feed.container;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alient.resource.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.lang.ref.WeakReference;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gw0;
import tb.hh0;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class FeedTabContainer extends VerticalTabView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String STICKY_SCROLL_TOP = "STICKY_SCROLL_TOP";
    @Nullable
    private static WeakReference<View> weakTabView;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final boolean a(int i) {
            View view;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-732237854")) {
                return ((Boolean) ipChange.ipc$dispatch("-732237854", new Object[]{this, Integer.valueOf(i)})).booleanValue();
            }
            WeakReference weakReference = FeedTabContainer.weakTabView;
            if (weakReference == null || (view = (View) weakReference.get()) == null || !view.isAttachedToWindow() || view.getTop() > i) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTabContainer(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        weakTabView = new WeakReference<>(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: scrollToTop$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m49scrollToTop$lambda3$lambda2$lambda1(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-243430886")) {
            ipChange.ipc$dispatch("-243430886", new Object[]{recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "$this_apply");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i + 1);
        if (findViewHolderForAdapterPosition != null) {
            recyclerView.scrollBy(0, findViewHolderForAdapterPosition.itemView.getTop() - DisplayUtil.dip2px(recyclerView.getContext(), 42.0f));
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView
    public void scrollToTop() {
        int realPositionForAdapter;
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308603060")) {
            ipChange.ipc$dispatch("-1308603060", new Object[]{this});
            return;
        }
        IContainer<ModelValue> pageContainer = getContainerItem().getPageContext().getPageContainer();
        ContentAdapter contentAdapter = pageContainer != null ? pageContainer.getContentAdapter() : null;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getContainerItem().getComponent().getAdapter();
        if (adapter != null && contentAdapter != null && (realPositionForAdapter = getRealPositionForAdapter(contentAdapter, adapter)) > 0) {
            GenericFragment fragment = getContainerItem().getPageContext().getFragment();
            if (!(fragment == null || (recyclerView = fragment.getRecyclerView()) == null)) {
                recyclerView.scrollToPosition(realPositionForAdapter + 1);
                recyclerView.post(new hh0(recyclerView, realPositionForAdapter));
            }
            EventBus eventBus = getContainerItem().getPageContext().getEventBus();
            if (eventBus != null) {
                eventBus.post(new Event(STICKY_SCROLL_TOP));
            }
        }
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View, com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView
    public void setChildComponentData(@NotNull IItem<ItemValue> iItem, @NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022460345")) {
            ipChange.ipc$dispatch("1022460345", new Object[]{this, iItem, list, list2, list3});
            return;
        }
        k21.i(iItem, "containerItem");
        k21.i(list, "childComponentTitles");
        k21.i(list2, "childComponentBtns");
        k21.i(list3, "childComponentNodes");
        gw0.i().p(list);
        super.setChildComponentData(iItem, list, list2, list3);
    }

    @Override // com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabContract.View, com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView
    public void showCurrentComponent(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873131745")) {
            ipChange.ipc$dispatch("1873131745", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        gw0.i().o(i);
        super.showCurrentComponent(i, z);
    }
}
