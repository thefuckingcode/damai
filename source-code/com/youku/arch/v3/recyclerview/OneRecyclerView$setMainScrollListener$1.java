package com.youku.arch.v3.recyclerview;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.recyclerview.OneRecyclerView;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"com/youku/arch/v3/recyclerview/OneRecyclerView$setMainScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Ltb/ur2;", GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED, "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.f.TYPE_ON_SCROLLED, "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class OneRecyclerView$setMainScrollListener$1 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OneRecyclerView this$0;

    OneRecyclerView$setMainScrollListener$1(OneRecyclerView oneRecyclerView) {
        this.this$0 = oneRecyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949810653")) {
            ipChange.ipc$dispatch("-1949810653", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        if (i == 0 && this.this$0.onScrollIdleListeners != null) {
            List list = this.this$0.onScrollIdleListeners;
            k21.f(list);
            if (!list.isEmpty()) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.this$0.getLayoutManager();
                k21.f(linearLayoutManager);
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) this.this$0.getLayoutManager();
                k21.f(linearLayoutManager2);
                int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
                List<OneRecyclerView.OnScrollIdleListener> list2 = this.this$0.onScrollIdleListeners;
                k21.f(list2);
                for (OneRecyclerView.OnScrollIdleListener onScrollIdleListener : list2) {
                    onScrollIdleListener.onScrollIdle(this.this$0, findFirstVisibleItemPosition, findLastVisibleItemPosition);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175948132")) {
            ipChange.ipc$dispatch("-1175948132", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        if (this.this$0.onScrolledListeners != null) {
            List list = this.this$0.onScrolledListeners;
            k21.f(list);
            if (!list.isEmpty()) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.this$0.getLayoutManager();
                k21.f(linearLayoutManager);
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) this.this$0.getLayoutManager();
                k21.f(linearLayoutManager2);
                int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
                List<OneRecyclerView.OnScrolledListener> list2 = this.this$0.onScrolledListeners;
                k21.f(list2);
                for (OneRecyclerView.OnScrolledListener onScrolledListener : list2) {
                    onScrolledListener.onScrolled(this.this$0, i, i2, findFirstVisibleItemPosition, findLastVisibleItemPosition);
                }
                if (AppInfoProviderProxy.isDebuggable()) {
                    Log.i("OneRecyclerView", k21.r("onScrolled start = ", Integer.valueOf(findFirstVisibleItemPosition)));
                }
            }
        }
    }
}
