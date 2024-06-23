package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;

public class ProgressDrawable extends PaintDrawable implements Animatable, ValueAnimator.AnimatorUpdateListener {
    protected int mHeight = 0;
    protected Path mPath = new Path();
    protected int mProgressDegree = 0;
    protected ValueAnimator mValueAnimator;
    protected int mWidth = 0;

    public ProgressDrawable() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.mValueAnimator = ofInt;
        ofInt.setDuration(10000L);
        this.mValueAnimator.setInterpolator(null);
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.setRepeatMode(1);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.mProgressDegree = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f = (float) width;
        float max = Math.max(1.0f, f / 22.0f);
        if (!(this.mWidth == width && this.mHeight == height)) {
            this.mPath.reset();
            float f2 = f - max;
            float f3 = ((float) height) / 2.0f;
            this.mPath.addCircle(f2, f3, max, Path.Direction.CW);
            float f4 = f - (5.0f * max);
            this.mPath.addRect(f4, f3 - max, f2, f3 + max, Path.Direction.CW);
            this.mPath.addCircle(f4, f3, max, Path.Direction.CW);
            this.mWidth = width;
            this.mHeight = height;
        }
        canvas.save();
        float f5 = f / 2.0f;
        float f6 = ((float) height) / 2.0f;
        canvas.rotate((float) this.mProgressDegree, f5, f6);
        for (int i = 0; i < 12; i++) {
            this.mPaint.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.mPath, this.mPaint);
        }
        canvas.restore();
    }

    public void start() {
        if (!this.mValueAnimator.isRunning()) {
            this.mValueAnimator.addUpdateListener(this);
            this.mValueAnimator.start();
        }
    }

    public void stop() {
        if (this.mValueAnimator.isRunning()) {
            this.mValueAnimator.removeAllListeners();
            this.mValueAnimator.removeAllUpdateListeners();
            this.mValueAnimator.cancel();
        }
    }

    public boolean isRunning() {
        return this.mValueAnimator.isRunning();
    }
}
