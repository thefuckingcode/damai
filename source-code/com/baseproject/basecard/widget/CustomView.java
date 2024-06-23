package com.baseproject.basecard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: Taobao */
public class CustomView extends ImageView {
    private Drawable mDrawable;

    public CustomView(Context context) {
        super(context);
    }

    private void initattrs(AttributeSet attributeSet) {
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void setMask(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initattrs(attributeSet);
    }
}
