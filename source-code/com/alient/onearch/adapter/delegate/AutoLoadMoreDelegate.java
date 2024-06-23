package com.alient.onearch.adapter.delegate;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.FragmentInterceptor;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\b\u0018\u00010\u0007R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate;", "Lcom/alient/onearch/adapter/delegate/BasicDelegate;", "Lcom/youku/arch/v3/page/GenericFragment;", Subject.FRAGMENT, "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "onFragmentDestroy", "Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate$ScrollListener;", "scrollListener", "Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate$ScrollListener;", "", "threshold", "I", "<init>", "()V", "ScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AutoLoadMoreDelegate extends BasicDelegate {
    private ScrollListener scrollListener;
    private int threshold = 3;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate$ScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "getLastVisiblePosition", "dx", Constants.Name.DISTANCE_Y, "Ltb/ur2;", GXTemplateEngine.f.TYPE_ON_SCROLLED, "<init>", "(Lcom/alient/onearch/adapter/delegate/AutoLoadMoreDelegate;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class ScrollListener extends RecyclerView.OnScrollListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ScrollListener() {
        }

        private final int getLastVisiblePosition(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                return linearLayoutManager.findLastVisibleItemPosition();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            GenericFragment fragment;
            RefreshLayout refreshLayout;
            GenericFragment fragment2;
            FragmentInterceptor fragmentInterceptor;
            k21.i(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null && getLastVisiblePosition(recyclerView) == adapter.getItemCount() - AutoLoadMoreDelegate.this.threshold && (fragment = AutoLoadMoreDelegate.this.getFragment()) != null && (refreshLayout = fragment.getRefreshLayout()) != null && (fragment2 = AutoLoadMoreDelegate.this.getFragment()) != null && (fragmentInterceptor = fragment2.getFragmentInterceptor()) != null) {
                fragmentInterceptor.onLoadMore(refreshLayout);
            }
        }
    }

    @Override // com.alient.onearch.adapter.delegate.BasicDelegate
    public void init(@NotNull GenericFragment genericFragment) {
        k21.i(genericFragment, Subject.FRAGMENT);
        super.init(genericFragment);
        ScrollListener scrollListener2 = new ScrollListener();
        RecyclerView recyclerView = genericFragment.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(scrollListener2);
        }
        ur2 ur2 = ur2.INSTANCE;
        this.scrollListener = scrollListener2;
    }

    @Override // com.alient.onearch.adapter.delegate.BasicDelegate
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.scrollListener = null;
    }
}
