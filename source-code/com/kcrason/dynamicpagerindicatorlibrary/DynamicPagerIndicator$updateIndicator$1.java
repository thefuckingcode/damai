package com.kcrason.dynamicpagerindicatorlibrary;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
final class DynamicPagerIndicator$updateIndicator$1 implements Runnable {
    final /* synthetic */ DynamicPagerIndicator this$0;

    DynamicPagerIndicator$updateIndicator$1(DynamicPagerIndicator dynamicPagerIndicator) {
        this.this$0 = dynamicPagerIndicator;
    }

    public final void run() {
        DynamicPagerIndicator dynamicPagerIndicator = this.this$0;
        ViewPager access$getMViewPager$p = DynamicPagerIndicator.access$getMViewPager$p(dynamicPagerIndicator);
        if (access$getMViewPager$p == null) {
            k21.u();
        }
        dynamicPagerIndicator.onPageScrolled(access$getMViewPager$p.getCurrentItem(), 0.0f, 0);
        DynamicPagerIndicator dynamicPagerIndicator2 = this.this$0;
        ViewPager access$getMViewPager$p2 = DynamicPagerIndicator.access$getMViewPager$p(dynamicPagerIndicator2);
        if (access$getMViewPager$p2 == null) {
            k21.u();
        }
        dynamicPagerIndicator2.onPageSelected(access$getMViewPager$p2.getCurrentItem());
    }
}
