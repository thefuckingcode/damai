package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

/* compiled from: Taobao */
public class DownLoadListView extends ListView {
    public DownLoadListView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public DownLoadListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }
}
