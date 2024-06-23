package com.alibaba.gaiax.render.view.container.slider;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.TimerTask;
import kotlin.Metadata;
import tb.k21;
import tb.qq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/alibaba/gaiax/render/view/container/slider/GXSliderView$startTimer$1$1", "Ljava/util/TimerTask;", "Ltb/ur2;", "run", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXSliderView$startTimer$1$1 extends TimerTask {
    final /* synthetic */ GXSliderView this$0;

    GXSliderView$startTimer$1$1(GXSliderView gXSliderView) {
        this.this$0 = gXSliderView;
    }

    /* access modifiers changed from: private */
    /* renamed from: run$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m97run$lambda2$lambda1$lambda0(GXSliderView gXSliderView, int i, int i2) {
        k21.i(gXSliderView, "this$0");
        ViewPager viewPager = gXSliderView.getViewPager();
        if (viewPager != null) {
            viewPager.setCurrentItem((i + 1) % i2, true);
        }
    }

    public void run() {
        PagerAdapter adapter;
        ViewPager viewPager = this.this$0.getViewPager();
        if (viewPager != null) {
            int currentItem = viewPager.getCurrentItem();
            GXSliderView gXSliderView = this.this$0;
            ViewPager viewPager2 = gXSliderView.getViewPager();
            if (viewPager2 != null && (adapter = viewPager2.getAdapter()) != null) {
                gXSliderView.mainHandler.post(new qq0(gXSliderView, currentItem, adapter.getCount()));
            }
        }
    }
}
