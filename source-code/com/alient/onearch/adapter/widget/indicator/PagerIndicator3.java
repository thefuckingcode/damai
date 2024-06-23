package com.alient.onearch.adapter.widget.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alient.onearch.adapter.widget.indicator.BasePagerIndicator;

/* compiled from: Taobao */
public class PagerIndicator3 extends BasePagerIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver = new RecyclerView.AdapterDataObserver() {
        /* class com.alient.onearch.adapter.widget.indicator.PagerIndicator3.AnonymousClass2 */

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (PagerIndicator3.this.viewpager != null) {
                RecyclerView.Adapter adapter = PagerIndicator3.this.viewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount != PagerIndicator3.this.getChildCount()) {
                    PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                    if (pagerIndicator3.mLastPosition < itemCount) {
                        pagerIndicator3.mLastPosition = pagerIndicator3.viewpager.getCurrentItem();
                    } else {
                        pagerIndicator3.mLastPosition = -1;
                    }
                    PagerIndicator3.this.createIndicators();
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
    private final ViewPager2.OnPageChangeCallback mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        /* class com.alient.onearch.adapter.widget.indicator.PagerIndicator3.AnonymousClass1 */

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
            if (i != pagerIndicator3.mLastPosition && pagerIndicator3.viewpager.getAdapter() != null && PagerIndicator3.this.viewpager.getAdapter().getItemCount() > 0) {
                PagerIndicator3.this.animatePageSelected(i);
            }
        }
    };
    private ViewPager2 viewpager;

    public PagerIndicator3(Context context) {
        super(context);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void animatePageSelected(int i) {
        super.animatePageSelected(i);
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

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable BasePagerIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    public void setViewPager(@Nullable ViewPager2 viewPager2) {
        this.viewpager = viewPager2;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.mLastPosition = -1;
            createIndicators();
            this.viewpager.unregisterOnPageChangeCallback(this.mInternalPageChangeCallback);
            this.viewpager.registerOnPageChangeCallback(this.mInternalPageChangeCallback);
            this.mInternalPageChangeCallback.onPageSelected(this.viewpager.getCurrentItem());
        }
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i) {
        super.tintIndicator(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createIndicators() {
        int i;
        RecyclerView.Adapter adapter = this.viewpager.getAdapter();
        if (adapter == null) {
            i = 0;
        } else {
            i = adapter.getItemCount();
        }
        createIndicators(i, this.viewpager.getCurrentItem());
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        super.tintIndicator(i, i2);
    }

    public PagerIndicator3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagerIndicator3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PagerIndicator3(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
