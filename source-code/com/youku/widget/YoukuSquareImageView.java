package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* compiled from: Taobao */
public class YoukuSquareImageView extends ImageView {
    public YoukuSquareImageView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, size);
    }

    public YoukuSquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
