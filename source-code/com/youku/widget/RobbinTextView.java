package com.youku.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: Taobao */
public class RobbinTextView extends TextView {
    private static final int ROTATE_DEGREES = -45;

    public RobbinTextView(Context context) {
        super(context);
        setLayerType(2, null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.rotate(-45.0f, (float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    public RobbinTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(2, null);
    }

    public RobbinTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(2, null);
    }
}
