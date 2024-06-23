package com.alient.onearch.adapter.widget.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alient.onearch.adapter.widget.indicator.BasePagerIndicator;

/* compiled from: Taobao */
public class PagerIndicator extends BasePagerIndicator {
    private final DataSetObserver mInternalDataSetObserver = new DataSetObserver() {
        /* class com.alient.onearch.adapter.widget.indicator.PagerIndicator.AnonymousClass2 */

        public void onChanged() {
            super.onChanged();
            if (PagerIndicator.this.viewpager != null) {
                PagerAdapter adapter = PagerIndicator.this.viewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count != PagerIndicator.this.getChildCount()) {
                    PagerIndicator pagerIndicator = PagerIndicator.this;
                    if (pagerIndicator.mLastPosition < count) {
                        pagerIndicator.mLastPosition = pagerIndicator.viewpager.getCurrentItem();
                    } else {
                        pagerIndicator.mLastPosition = -1;
                    }
                    PagerIndicator.this.createIndicators();
                }
            }
        }
    };
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener = new ViewPager.OnPageChangeListener() {
        /* class com.alient.onearch.adapter.widget.indicator.PagerIndicator.AnonymousClass1 */

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerIndicator.this.viewpager.getAdapter() != null && PagerIndicator.this.viewpager.getAdapter().getCount() > 0) {
                PagerIndicator.this.animatePageSelected(i);
            }
        }
    };
    private ViewPager viewpager;

    public PagerIndicator(Context context) {
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

    public DataSetObserver getDataSetObserver() {
        return this.mInternalDataSetObserver;
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable BasePagerIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    public void setViewPager(@Nullable ViewPager viewPager) {
        this.viewpager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.mLastPosition = -1;
            createIndicators();
            this.viewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
            this.viewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
            this.mInternalPageChangeListener.onPageSelected(this.viewpager.getCurrentItem());
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
        PagerAdapter adapter = this.viewpager.getAdapter();
        if (adapter == null) {
            i = 0;
        } else {
            i = adapter.getCount();
        }
        createIndicators(i, this.viewpager.getCurrentItem());
        if (this.autoSize) {
            if (getOrientation() == 0) {
                getLayoutParams().width = this.mIndicatorWidth * i;
            } else {
                getLayoutParams().height = this.mIndicatorHeight * i;
            }
            invalidate();
        }
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        super.tintIndicator(i, i2);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PagerIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
