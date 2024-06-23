package com.youku.resource.widget.tips;

import android.view.animation.BaseInterpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 22)
/* compiled from: Taobao */
public class YKTipsInterpolator extends BaseInterpolator {
    public float getInterpolation(float f) {
        return (float) ((1.0d - Math.cos(((double) (f * 12.0f)) * 3.141592653589793d)) * 0.5d);
    }
}
