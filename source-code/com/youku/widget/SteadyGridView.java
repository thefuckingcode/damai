package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* compiled from: Taobao */
public class SteadyGridView extends GridView {
    private int height = 0;

    public SteadyGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        if (this.height <= 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            return;
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(GridView.getDefaultSize(0, i), this.height);
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public SteadyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SteadyGridView(Context context) {
        super(context);
    }
}
