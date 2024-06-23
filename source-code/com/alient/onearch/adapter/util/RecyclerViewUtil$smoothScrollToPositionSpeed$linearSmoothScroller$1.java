package com.alient.onearch.adapter.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\u000f"}, d2 = {"com/alient/onearch/adapter/util/RecyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "getVerticalSnapPreference", "Landroid/view/View;", "view", "snapPreference", "calculateDyToMakeVisible", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RecyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1 extends LinearSmoothScroller {
    final /* synthetic */ Context $context;
    final /* synthetic */ float $millisecondsPerInch;
    final /* synthetic */ RecyclerView $recyclerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1(RecyclerView recyclerView, float f, Context context, Context context2) {
        super(context2);
        this.$recyclerView = recyclerView;
        this.$millisecondsPerInch = f;
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
                return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        } catch (Exception unused) {
            return super.calculateDyToMakeVisible(view, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
        k21.i(displayMetrics, "displayMetrics");
        return this.$millisecondsPerInch / ((float) displayMetrics.densityDpi);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @Nullable
    public PointF computeScrollVectorForPosition(int i) {
        try {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.$recyclerView.getLayoutManager();
            k21.f(linearLayoutManager);
            View childAt = linearLayoutManager.getChildAt(0);
            k21.f(childAt);
            return new PointF(0.0f, (float) (i < linearLayoutManager.getPosition(childAt) ? -1 : 1));
        } catch (Exception unused) {
            return new PointF(0.0f, 1.0f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int getVerticalSnapPreference() {
        return -1;
    }
}
