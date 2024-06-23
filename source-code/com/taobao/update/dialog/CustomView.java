package com.taobao.update.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
public class CustomView extends RelativeLayout {
    static final String ANDROIDXML = "http://schemas.android.com/apk/res/android";
    static final String MATERIALDESIGNXML = "http://schemas.android.com/apk/res-auto";
    boolean animation = false;
    int beforeBackground;
    final int disabledBackgroundColor = Color.parseColor("#E2E2E2");
    public boolean isLastTouch = false;

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onAnimationEnd() {
        super.onAnimationEnd();
        this.animation = false;
    }

    /* access modifiers changed from: protected */
    public void onAnimationStart() {
        super.onAnimationStart();
        this.animation = true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.animation) {
            invalidate();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setBackgroundColor(this.beforeBackground);
        } else {
            setBackgroundColor(this.disabledBackgroundColor);
        }
        invalidate();
    }
}
