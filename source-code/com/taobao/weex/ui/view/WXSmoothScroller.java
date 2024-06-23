package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: Taobao */
public class WXSmoothScroller extends Scroller {
    private double mScrollFactor = 1.0d;

    public WXSmoothScroller(Context context) {
        super(context);
    }

    public void setScrollDurationFactor(double d) {
        this.mScrollFactor = d;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (((double) i5) * this.mScrollFactor));
    }

    public WXSmoothScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @SuppressLint({"NewApi"})
    public WXSmoothScroller(Context context, Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
    }
}
