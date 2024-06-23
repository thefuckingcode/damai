package com.alibaba.poplayer.factory.view.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import tb.cr1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class PenetrateFrame extends FrameLayout {
    private static final int DEFAULT_PENETRATE_ALPHA = 204;
    private boolean mBitmapCacheUpdated;
    private int mPenetrateAlpha = 204;
    private boolean mUseCacheMark = true;

    public PenetrateFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }

    private void initialize(Context context) {
        setLayoutTransition(null);
    }

    private void updateBitmapCacheIfNeed() {
        if (!this.mUseCacheMark || this.mBitmapCacheUpdated) {
            destroyDrawingCache();
            buildDrawingCache();
            this.mBitmapCacheUpdated = false;
        }
    }

    public void destroy() {
        removeAllViews();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            this.mBitmapCacheUpdated = true;
        } catch (Throwable th) {
            cr1.c("PenetrateFrame.dispatchDraw.error", th);
        }
    }

    public int getPenetrateAlpha() {
        return this.mPenetrateAlpha;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            int i = this.mPenetrateAlpha;
            if (255 == i) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x >= 0) {
                if (y >= 0) {
                    if (motionEvent.getAction() == 0) {
                        updateBitmapCacheIfNeed();
                    }
                    Bitmap drawingCache = getDrawingCache();
                    if (x <= drawingCache.getWidth()) {
                        if (y <= drawingCache.getHeight()) {
                            return 255 - Color.alpha(drawingCache.getPixel(x, y)) > this.mPenetrateAlpha;
                        }
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            cr1.c("PenetrateFrame.onInterceptTouchEvent.error", th);
            return true;
        }
    }

    public void setPenetrateAlpha(int i) {
        if (i > 255) {
            i = 255;
        } else if (i < 0) {
            i = 0;
        }
        this.mPenetrateAlpha = i;
        cr1.b("PenetrateFrame.setPenetrateAlpha.penetrateAlpha{%s}", Integer.valueOf(i));
    }

    public void setUseCacheMark(boolean z) {
        this.mUseCacheMark = z;
    }

    public PenetrateFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public PenetrateFrame(Context context) {
        super(context);
        initialize(context);
    }
}
