package com.alient.onearch.adapter.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/alient/onearch/adapter/util/RecyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getVerticalSnapPreference", "Landroid/view/View;", "view", "snapPreference", "calculateDyToMakeVisible", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RecyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1 extends LinearSmoothScroller {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $scrollByHeight;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1(int i, Context context, Context context2) {
        super(context2);
        this.$scrollByHeight = i;
        this.$context = context;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateDyToMakeVisible(@NotNull View view, int i) {
        k21.i(view, "view");
        try {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            if (!layoutManager.canScrollVertically()) {
                return 0;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                return calculateDtToFit((layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - this.$scrollByHeight, (layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.$scrollByHeight, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        } catch (Exception unused) {
            return super.calculateDyToMakeVisible(view, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int getVerticalSnapPreference() {
        return -1;
    }
}
