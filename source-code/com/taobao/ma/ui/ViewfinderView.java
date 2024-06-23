package com.taobao.ma.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: Taobao */
public final class ViewfinderView extends View {
    public long ANIMATION_DELAY = 20;
    public int SPEEN_DISTANCE = 6;
    public int VIEWFINDER_CORNER_HEIGHT = 16;
    public int VIEWFINDER_CORNER_WIDTH = 8;
    public int VIEWFINDER_HEIGHT = 660;
    public int VIEWFINDER_MIDDLE_LINE_PADDING = 15;
    public int VIEWFINDER_MIDDLE_LINE_WIDTH = 5;
    public int VIEWFINDER_WIDTH = 660;
    private boolean isFirst = false;
    public int laserColor = Color.parseColor("#ffcc0000");
    private Context mContext;
    private DisplayMetrics metrics;
    private final Paint paint;
    private int slideTop;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.paint = new Paint(1);
        this.metrics = this.mContext.getResources().getDisplayMetrics();
    }

    private Point getScreenSize() {
        DisplayMetrics displayMetrics = this.metrics;
        return new Point(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
    }

    private Rect getViewFinderRect() {
        Point screenSize = getScreenSize();
        int i = this.VIEWFINDER_WIDTH;
        int i2 = this.VIEWFINDER_HEIGHT;
        int xVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenSize) - i) / 2;
        int yVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenSize) - i2) / 2;
        return new Rect(xVar, yVar, i + xVar, i2 + yVar);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mContext = null;
        this.isFirst = false;
        this.metrics = null;
    }

    public void onDraw(Canvas canvas) {
        Rect viewFinderRect = getViewFinderRect();
        if (viewFinderRect != null) {
            if (!this.isFirst) {
                this.isFirst = true;
                this.slideTop = viewFinderRect.top;
                this.VIEWFINDER_CORNER_HEIGHT = (int) (((float) this.VIEWFINDER_CORNER_HEIGHT) * this.metrics.density);
            }
            this.paint.setColor(-1);
            int i = viewFinderRect.left;
            int i2 = viewFinderRect.top;
            canvas.drawRect((float) i, (float) i2, (float) (i + this.VIEWFINDER_CORNER_HEIGHT), (float) (i2 + this.VIEWFINDER_CORNER_WIDTH), this.paint);
            int i3 = viewFinderRect.left;
            int i4 = viewFinderRect.top;
            canvas.drawRect((float) i3, (float) i4, (float) (i3 + this.VIEWFINDER_CORNER_WIDTH), (float) (i4 + this.VIEWFINDER_CORNER_HEIGHT), this.paint);
            int i5 = viewFinderRect.right;
            float f = (float) (i5 - this.VIEWFINDER_CORNER_HEIGHT);
            int i6 = viewFinderRect.top;
            canvas.drawRect(f, (float) i6, (float) i5, (float) (i6 + this.VIEWFINDER_CORNER_WIDTH), this.paint);
            int i7 = viewFinderRect.right;
            float f2 = (float) (i7 - this.VIEWFINDER_CORNER_WIDTH);
            int i8 = viewFinderRect.top;
            canvas.drawRect(f2, (float) i8, (float) i7, (float) (i8 + this.VIEWFINDER_CORNER_HEIGHT), this.paint);
            int i9 = viewFinderRect.left;
            int i10 = viewFinderRect.bottom;
            canvas.drawRect((float) i9, (float) (i10 - this.VIEWFINDER_CORNER_WIDTH), (float) (i9 + this.VIEWFINDER_CORNER_HEIGHT), (float) i10, this.paint);
            int i11 = viewFinderRect.left;
            int i12 = viewFinderRect.bottom;
            canvas.drawRect((float) i11, (float) (i12 - this.VIEWFINDER_CORNER_HEIGHT), (float) (i11 + this.VIEWFINDER_CORNER_WIDTH), (float) i12, this.paint);
            int i13 = viewFinderRect.right;
            float f3 = (float) (i13 - this.VIEWFINDER_CORNER_HEIGHT);
            int i14 = viewFinderRect.bottom;
            canvas.drawRect(f3, (float) (i14 - this.VIEWFINDER_CORNER_WIDTH), (float) i13, (float) i14, this.paint);
            int i15 = viewFinderRect.right;
            float f4 = (float) (i15 - this.VIEWFINDER_CORNER_WIDTH);
            int i16 = viewFinderRect.bottom;
            canvas.drawRect(f4, (float) (i16 - this.VIEWFINDER_CORNER_HEIGHT), (float) i15, (float) i16, this.paint);
            int i17 = this.slideTop + this.SPEEN_DISTANCE;
            this.slideTop = i17;
            if (i17 >= viewFinderRect.bottom) {
                this.slideTop = viewFinderRect.top;
            }
            this.paint.setColor(this.laserColor);
            int i18 = viewFinderRect.left;
            int i19 = this.VIEWFINDER_MIDDLE_LINE_PADDING;
            float f5 = (float) (i18 + i19);
            int i20 = this.slideTop;
            int i21 = this.VIEWFINDER_MIDDLE_LINE_WIDTH;
            canvas.drawRect(f5, (float) (i20 - (i21 / 2)), (float) (viewFinderRect.right - i19), (float) (i20 + (i21 / 2)), this.paint);
            postInvalidateDelayed(this.ANIMATION_DELAY, viewFinderRect.left, viewFinderRect.top, viewFinderRect.right, viewFinderRect.bottom);
        }
    }
}
