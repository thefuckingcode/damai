package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* compiled from: Taobao */
public class SteadyListView extends ListView {
    public SteadyListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        if (i2 > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        super.onMeasure(i, i3);
    }

    public SteadyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SteadyListView(Context context) {
        super(context);
    }
}
