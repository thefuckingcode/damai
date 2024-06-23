package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

/* compiled from: Taobao */
public class CityExpandView extends ExpandableListView {
    public CityExpandView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        System.currentTimeMillis();
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        System.currentTimeMillis();
    }

    public CityExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }
}
