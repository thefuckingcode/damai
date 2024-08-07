package com.baseproject.basecard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.youku.utils.DensityUtils;

/* compiled from: Taobao */
public class RoundCornerFrameLayout extends FrameLayout {
    Context mContext;
    private Drawable mDrawable;

    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int dp2px = DensityUtils.dp2px(this.mContext, 4.0f);
        Path path = new Path();
        float f = (float) dp2px;
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight()), f, f, Path.Direction.CW);
        canvas.clipPath(path, Region.Op.REPLACE);
        super.dispatchDraw(canvas);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setMask(Drawable drawable) {
        this.mDrawable = drawable;
    }
}
