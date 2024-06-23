package com.youku.arch.v3.recyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J0\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¨\u0006\u0010"}, d2 = {"com/youku/arch/v3/recyclerview/WrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class WrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1 extends LinearSmoothScroller {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ WrappedLinearLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1(WrappedLinearLayoutManager wrappedLinearLayoutManager, Context context) {
        super(context);
        this.this$0 = wrappedLinearLayoutManager;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1360159129")) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }
        return ((Integer) ipChange.ipc$dispatch("-1360159129", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821174082")) {
            return ((Float) ipChange.ipc$dispatch("-1821174082", new Object[]{this, displayMetrics})).floatValue();
        }
        k21.i(displayMetrics, "displayMetrics");
        return 160.0f / ((float) displayMetrics.densityDpi);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @Nullable
    public PointF computeScrollVectorForPosition(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-127325546")) {
            return this.this$0.computeScrollVectorForPosition(i);
        }
        return (PointF) ipChange.ipc$dispatch("-127325546", new Object[]{this, Integer.valueOf(i)});
    }
}
