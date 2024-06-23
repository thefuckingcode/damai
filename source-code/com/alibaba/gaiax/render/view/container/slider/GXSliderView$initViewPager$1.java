package com.alibaba.gaiax.render.view.container.slider;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import tb.oq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/view/container/slider/GXSliderView$initViewPager$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXSliderView$initViewPager$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GXSliderView a;

    GXSliderView$initViewPager$1(GXSliderView gXSliderView) {
        this.a = gXSliderView;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        GXSliderBaseIndicatorView gXSliderBaseIndicatorView;
        oq0 oq0 = this.a.config;
        boolean z = false;
        if (oq0 != null && oq0.a()) {
            z = true;
        }
        if (z && (gXSliderBaseIndicatorView = this.a.indicatorView) != null) {
            gXSliderBaseIndicatorView.updateSelectedIndex(i % this.a.pageSize);
        }
    }
}
