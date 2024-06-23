package com.taobao.android.dinamicx.widget.viewpager.tab.view;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* compiled from: Taobao */
public class a {
    static final Interpolator a = new LinearInterpolator();
    static final Interpolator b = new FastOutSlowInInterpolator();

    static {
        new FastOutLinearInInterpolator();
        new LinearOutSlowInInterpolator();
        new DecelerateInterpolator();
    }

    static int a(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
