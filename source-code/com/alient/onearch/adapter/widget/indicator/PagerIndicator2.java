package com.alient.onearch.adapter.widget.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.alient.onearch.adapter.widget.indicator.BasePagerIndicator;

/* compiled from: Taobao */
public class PagerIndicator2 extends BasePagerIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver = new RecyclerView.AdapterDataObserver() {
        /* class com.alient.onearch.adapter.widget.indicator.PagerIndicator2.AnonymousClass2 */

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (PagerIndicator2.this.recyclerView != null) {
                RecyclerView.Adapter adapter = PagerIndicator2.this.recyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount != PagerIndicator2.this.getChildCount()) {
                    PagerIndicator2 pagerIndicator2 = PagerIndicator2.this;
                    if (pagerIndicator2.mLastPosition < itemCount) {
                        pagerIndicator2.mLastPosition = pagerIndicator2.getSnapPosition(pagerIndicator2.recyclerView.getLayoutManager());
                    } else {
                        pagerIndicator2.mLastPosition = -1;
                    }
                    PagerIndicator2.this.createIndicators();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            onChanged();
        }
    };
    private final RecyclerView.OnScrollListener mInternalOnScrollListener = new RecyclerView.OnScrollListener() {
        /* class com.alient.onearch.adapter.widget.indicator.PagerIndicator2.AnonymousClass1 */

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            int snapPosition = PagerIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
            if (snapPosition != -1) {
                PagerIndicator2.this.animatePageSelected(snapPosition);
            }
        }
    };
    private RecyclerView recyclerView;
    private SnapHelper snapHelper;

    public PagerIndicator2(Context context) {
        super(context);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void animatePageSelected(int i) {
        super.animatePageSelected(i);
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView2, @NonNull SnapHelper snapHelper2) {
        this.recyclerView = recyclerView2;
        this.snapHelper = snapHelper2;
        this.mLastPosition = -1;
        createIndicators();
        recyclerView2.removeOnScrollListener(this.mInternalOnScrollListener);
        recyclerView2.addOnScrollListener(this.mInternalOnScrollListener);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i) {
        super.changeIndicatorResource(i);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void createIndicators(int i, int i2) {
        super.createIndicators(i, i2);
    }

    public RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterDataObserver;
    }

    public int getSnapPosition(@Nullable RecyclerView.LayoutManager layoutManager) {
        View findSnapView;
        if (layoutManager == null || (findSnapView = this.snapHelper.findSnapView(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.getPosition(findSnapView);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable BasePagerIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i) {
        super.tintIndicator(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createIndicators() {
        int i;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter == null) {
            i = 0;
        } else {
            i = adapter.getItemCount();
        }
        createIndicators(i, getSnapPosition(this.recyclerView.getLayoutManager()));
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        super.tintIndicator(i, i2);
    }

    public PagerIndicator2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagerIndicator2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PagerIndicator2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
