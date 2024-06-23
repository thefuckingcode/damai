package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import androidx.annotation.ColorInt;
import tb.ec0;

/* compiled from: Taobao */
public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {
    protected static final float[][] APPEAR_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    protected static final float[][] BEGIN_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    protected static final long DROP_BOUNCE_ANIMATOR_DURATION = 500;
    protected static final long DROP_CIRCLE_ANIMATOR_DURATION = 500;
    protected static final int DROP_REMOVE_ANIMATOR_DURATION = 200;
    protected static final long DROP_VERTEX_ANIMATION_DURATION = 500;
    protected static final float[][] EXPAND_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};
    protected static final float MAX_WAVE_HEIGHT = 0.2f;
    protected static final int SHADOW_COLOR = -1728053248;
    protected static final int WAVE_ANIMATOR_DURATION = 1000;
    protected ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new a();
    protected float mCurrentCircleCenterY;
    protected ValueAnimator mDisappearCircleAnimator;
    protected ValueAnimator mDropBounceHorizontalAnimator;
    protected ValueAnimator mDropBounceVerticalAnimator;
    protected ValueAnimator mDropCircleAnimator;
    protected Path mDropCirclePath;
    protected float mDropCircleRadius = 100.0f;
    protected boolean mDropHeightUpdated = false;
    protected RectF mDropRect;
    protected Path mDropTangentPath;
    protected ValueAnimator mDropVertexAnimator;
    protected boolean mIsManualRefreshing = false;
    protected int mMaxDropHeight;
    protected Paint mPaint;
    protected Path mShadowPath;
    protected int mUpdateMaxDropHeight;
    protected Path mWavePath;
    protected ValueAnimator mWaveReverseAnimator;
    protected int mWidth;

    /* compiled from: Taobao */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.mCurrentCircleCenterY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView waveView = WaveView.this;
            if (Build.VERSION.SDK_INT >= 16) {
                waveView.postInvalidateOnAnimation();
            } else {
                waveView.invalidate();
            }
        }
    }

    /* compiled from: Taobao */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            WaveView.this.resetAnimator();
            WaveView.this.mIsManualRefreshing = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.mWavePath.moveTo(0.0f, 0.0f);
            WaveView waveView = WaveView.this;
            Path path = waveView.mWavePath;
            int i = waveView.mWidth;
            float f = floatValue * 0.5f;
            path.quadTo(((float) i) * 0.25f, 0.0f, ((float) i) * 0.333f, f);
            WaveView waveView2 = WaveView.this;
            Path path2 = waveView2.mWavePath;
            int i2 = waveView2.mWidth;
            path2.quadTo(((float) i2) * 0.5f, floatValue * 1.4f, ((float) i2) * 0.666f, f);
            WaveView waveView3 = WaveView.this;
            Path path3 = waveView3.mWavePath;
            int i3 = waveView3.mWidth;
            path3.quadTo(((float) i3) * 0.75f, 0.0f, (float) i3, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    public WaveView(Context context) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-14575885);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setShadowLayer((float) ((int) ((f * 2.0f) + 0.5f)), 0.0f, 0.0f, -1728053248);
        this.mWavePath = new Path();
        this.mDropTangentPath = new Path();
        this.mDropCirclePath = new Path();
        this.mShadowPath = new Path();
        resetAnimator();
        this.mDropRect = new RectF();
        setLayerType(1, null);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void animationDropCircle() {
        if (!this.mDisappearCircleAnimator.isRunning()) {
            startDropAnimation();
            startWaveAnimation(0.1f);
        }
    }

    public void appearPhase(float f, float f2) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = APPEAR_PHASE_POINTS;
        float[][] fArr2 = BEGIN_PHASE_POINTS;
        path.cubicTo(fArr[0][0] * ((float) i), fArr[0][1] * ((float) i), Math.min(fArr2[1][0] + f2, fArr[1][0]) * ((float) i), Math.max((fArr2[1][1] + f) - f2, fArr[1][1]) * ((float) this.mWidth), Math.max(fArr2[2][0] - f2, fArr[2][0]) * ((float) this.mWidth), Math.max((fArr2[2][1] + f) - f2, fArr[2][1]) * ((float) this.mWidth));
        Path path2 = this.mWavePath;
        float max = ((float) this.mWidth) * Math.max(fArr2[3][0] - f2, fArr[3][0]);
        float min = ((float) this.mWidth) * Math.min(fArr2[3][1] + f + f2, fArr[3][1]);
        float max2 = ((float) this.mWidth) * Math.max(fArr2[4][0] - f2, fArr[4][0]);
        float min2 = ((float) this.mWidth) * Math.min(fArr2[4][1] + f + f2, fArr[4][1]);
        int i2 = this.mWidth;
        path2.cubicTo(max, min, max2, min2, ((float) i2) * fArr[5][0], ((float) i2) * Math.min(fArr2[0][1] + f + f2, fArr[5][1]));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float max3 = ((float) i3) - (((float) i3) * Math.max(fArr2[4][0] - f2, fArr[4][0]));
        float min3 = ((float) this.mWidth) * Math.min(fArr2[4][1] + f + f2, fArr[4][1]);
        int i4 = this.mWidth;
        float max4 = ((float) i4) - (((float) i4) * Math.max(fArr2[3][0] - f2, fArr[3][0]));
        float min4 = ((float) this.mWidth) * Math.min(fArr2[3][1] + f + f2, fArr[3][1]);
        int i5 = this.mWidth;
        path3.cubicTo(max3, min3, max4, min4, ((float) i5) - (((float) i5) * Math.max(fArr2[2][0] - f2, fArr[2][0])), ((float) this.mWidth) * Math.max((fArr2[2][1] + f) - f2, fArr[2][1]));
        Path path4 = this.mWavePath;
        int i6 = this.mWidth;
        float min5 = ((float) i6) - (((float) i6) * Math.min(fArr2[1][0] + f2, fArr[1][0]));
        float max5 = ((float) this.mWidth) * Math.max((fArr2[1][1] + f) - f2, fArr[1][1]);
        int i7 = this.mWidth;
        path4.cubicTo(min5, max5, ((float) i7) - (((float) i7) * fArr[0][0]), ((float) i7) * fArr[0][1], (float) i7, 0.0f);
        this.mCurrentCircleCenterY = (((float) this.mWidth) * Math.min(fArr2[3][1] + f + f2, fArr[3][1])) + this.mDropCircleRadius;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public void beginPhase(float f) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = BEGIN_PHASE_POINTS;
        path.cubicTo(fArr[0][0] * ((float) i), fArr[0][1], fArr[1][0] * ((float) i), (fArr[1][1] + f) * ((float) i), fArr[2][0] * ((float) i), ((float) i) * (fArr[2][1] + f));
        Path path2 = this.mWavePath;
        int i2 = this.mWidth;
        path2.cubicTo(((float) i2) * fArr[3][0], ((float) i2) * (fArr[3][1] + f), ((float) i2) * fArr[4][0], ((float) i2) * (fArr[4][1] + f), ((float) i2) * fArr[5][0], ((float) i2) * (fArr[5][1] + f));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        path3.cubicTo(((float) i3) - (((float) i3) * fArr[4][0]), ((float) i3) * (fArr[4][1] + f), ((float) i3) - (((float) i3) * fArr[3][0]), ((float) i3) * (fArr[3][1] + f), ((float) i3) - (((float) i3) * fArr[2][0]), ((float) i3) * (fArr[2][1] + f));
        Path path4 = this.mWavePath;
        int i4 = this.mWidth;
        path4.cubicTo(((float) i4) - (((float) i4) * fArr[1][0]), ((float) i4) * (fArr[1][1] + f), ((float) i4) - (((float) i4) * fArr[0][0]), fArr[0][1], (float) i4, 0.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public void expandPhase(float f, float f2, float f3) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = EXPAND_PHASE_POINTS;
        float[][] fArr2 = BEGIN_PHASE_POINTS;
        float[][] fArr3 = APPEAR_PHASE_POINTS;
        path.cubicTo(fArr[0][0] * ((float) i), fArr[0][1] * ((float) i), Math.min(Math.min(fArr2[1][0] + f2, fArr3[1][0]) + f3, fArr[1][0]) * ((float) i), Math.max(Math.max((fArr2[1][1] + f) - f2, fArr3[1][1]) - f3, fArr[1][1]) * ((float) this.mWidth), Math.max(fArr2[2][0] - f2, fArr[2][0]) * ((float) this.mWidth), Math.min(Math.max((fArr2[2][1] + f) - f2, fArr3[2][1]) + f3, fArr[2][1]) * ((float) this.mWidth));
        Path path2 = this.mWavePath;
        float min = ((float) this.mWidth) * Math.min(Math.max(fArr2[3][0] - f2, fArr3[3][0]) + f3, fArr[3][0]);
        float min2 = ((float) this.mWidth) * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1]);
        float max = ((float) this.mWidth) * Math.max(fArr2[4][0] - f2, fArr[4][0]);
        float min3 = ((float) this.mWidth) * Math.min(Math.min(fArr2[4][1] + f + f2, fArr3[4][1]) + f3, fArr[4][1]);
        int i2 = this.mWidth;
        path2.cubicTo(min, min2, max, min3, ((float) i2) * fArr[5][0], ((float) i2) * Math.min(Math.min(fArr2[0][1] + f + f2, fArr3[5][1]) + f3, fArr[5][1]));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float max2 = ((float) i3) - (((float) i3) * Math.max(fArr2[4][0] - f2, fArr[4][0]));
        float min4 = ((float) this.mWidth) * Math.min(Math.min(fArr2[4][1] + f + f2, fArr3[4][1]) + f3, fArr[4][1]);
        int i4 = this.mWidth;
        float min5 = ((float) i4) - (((float) i4) * Math.min(Math.max(fArr2[3][0] - f2, fArr3[3][0]) + f3, fArr[3][0]));
        float min6 = ((float) this.mWidth) * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1]);
        int i5 = this.mWidth;
        path3.cubicTo(max2, min4, min5, min6, ((float) i5) - (((float) i5) * Math.max(fArr2[2][0] - f2, fArr[2][0])), ((float) this.mWidth) * Math.min(Math.max((fArr2[2][1] + f) - f2, fArr3[2][1]) + f3, fArr[2][1]));
        Path path4 = this.mWavePath;
        int i6 = this.mWidth;
        float min7 = ((float) i6) - (((float) i6) * Math.min(Math.min(fArr2[1][0] + f2, fArr3[1][0]) + f3, fArr[1][0]));
        float max3 = ((float) this.mWidth) * Math.max(Math.max((fArr2[1][1] + f) - f2, fArr3[1][1]) - f3, fArr[1][1]);
        int i7 = this.mWidth;
        path4.cubicTo(min7, max3, ((float) i7) - (((float) i7) * fArr[0][0]), ((float) i7) * fArr[0][1], (float) i7, 0.0f);
        this.mCurrentCircleCenterY = (((float) this.mWidth) * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1])) + this.mDropCircleRadius;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public float getCurrentCircleCenterY() {
        return this.mCurrentCircleCenterY;
    }

    public void manualRefresh() {
        if (!this.mIsManualRefreshing) {
            this.mIsManualRefreshing = true;
            int i = this.mMaxDropHeight;
            ValueAnimator ofFloat = ValueAnimator.ofFloat((float) i, (float) i);
            this.mDropCircleAnimator = ofFloat;
            ofFloat.start();
            int i2 = this.mMaxDropHeight;
            float f = this.mDropCircleRadius;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(((float) i2) - f, ((float) i2) - f);
            this.mDropVertexAnimator = ofFloat2;
            ofFloat2.start();
            this.mCurrentCircleCenterY = (float) this.mMaxDropHeight;
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.mDisappearCircleAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mDisappearCircleAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.mDropCircleAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.mDropCircleAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mDropVertexAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.mDropVertexAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.mWaveReverseAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.mWaveReverseAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.mDropBounceHorizontalAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.mDropBounceHorizontalAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.mDropBounceVerticalAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.mDropBounceVerticalAnimator.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mWavePath, this.mPaint);
        if (!isInEditMode()) {
            this.mWavePath.rewind();
            this.mDropTangentPath.rewind();
            this.mDropCirclePath.rewind();
        }
        float floatValue = ((Float) this.mDropCircleAnimator.getAnimatedValue()).floatValue();
        float f = ((float) this.mWidth) / 2.0f;
        float floatValue2 = ((Float) this.mDisappearCircleAnimator.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.mDropBounceVerticalAnimator.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.mDropBounceHorizontalAnimator.getAnimatedValue()).floatValue();
        RectF rectF = this.mDropRect;
        float f2 = this.mDropCircleRadius;
        float f3 = floatValue3 + 1.0f;
        float f4 = 1.0f + floatValue4;
        rectF.set((f - ((f2 * f3) * floatValue2)) + ((f2 * floatValue4) / 2.0f), (((f2 * f4) * floatValue2) + floatValue) - ((f2 * floatValue3) / 2.0f), (((f3 * f2) * floatValue2) + f) - ((floatValue4 * f2) / 2.0f), (floatValue - ((f4 * f2) * floatValue2)) + ((f2 * floatValue3) / 2.0f));
        float floatValue5 = ((Float) this.mDropVertexAnimator.getAnimatedValue()).floatValue();
        this.mDropTangentPath.moveTo(f, floatValue5);
        double d2 = (double) floatValue;
        double pow = ((Math.pow((double) this.mDropCircleRadius, 2.0d) + ((double) (floatValue * floatValue5))) - Math.pow(d2, 2.0d)) / ((double) (floatValue5 - floatValue));
        double d3 = (((double) this.mWidth) * -2.0d) / 2.0d;
        double d4 = -d3;
        double pow2 = (d3 * d3) - (((Math.pow(pow - d2, 2.0d) + Math.pow((double) f, 2.0d)) - Math.pow((double) this.mDropCircleRadius, 2.0d)) * 4.0d);
        float f5 = (float) pow;
        this.mDropTangentPath.lineTo((float) ((Math.sqrt(pow2) + d4) / 2.0d), f5);
        this.mDropTangentPath.lineTo((float) ((d4 - Math.sqrt(pow2)) / 2.0d), f5);
        this.mDropTangentPath.close();
        this.mShadowPath.set(this.mDropTangentPath);
        this.mShadowPath.addOval(this.mDropRect, Path.Direction.CCW);
        this.mDropCirclePath.addOval(this.mDropRect, Path.Direction.CCW);
        canvas.drawPath(this.mDropTangentPath, this.mPaint);
        canvas.drawPath(this.mDropCirclePath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onPreDragWave() {
        ValueAnimator valueAnimator = this.mWaveReverseAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mWaveReverseAnimator.cancel();
        }
    }

    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (!this.mDropHeightUpdated) {
            return false;
        }
        updateMaxDropHeight(this.mUpdateMaxDropHeight);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mDropCircleRadius = ((float) i) / 14.4f;
        updateMaxDropHeight((int) Math.min((float) Math.min(i, i2), ((float) getHeight()) - this.mDropCircleRadius));
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void resetAnimator() {
        this.mDropVertexAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mDropBounceVerticalAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mDropBounceHorizontalAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.mDropCircleAnimator = ofFloat;
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.mDisappearCircleAnimator = ofFloat2;
        ofFloat2.setDuration(1L);
        this.mDisappearCircleAnimator.start();
    }

    public void setShadow(int i, int i2) {
        this.mPaint.setShadowLayer((float) i, 0.0f, 0.0f, i2);
    }

    public void setWaveColor(@ColorInt int i) {
        this.mPaint.setColor(i);
        invalidate();
    }

    public void startDisappearCircleAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mDisappearCircleAnimator = ofFloat;
        ofFloat.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDisappearCircleAnimator.setDuration(200L);
        this.mDisappearCircleAnimator.addListener(new c());
        this.mDisappearCircleAnimator.start();
    }

    public void startDropAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.mDisappearCircleAnimator = ofFloat;
        ofFloat.setDuration(1L);
        this.mDisappearCircleAnimator.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((((float) this.mWidth) / 1440.0f) * 500.0f, (float) this.mMaxDropHeight);
        this.mDropCircleAnimator = ofFloat2;
        ofFloat2.setDuration(500L);
        this.mDropCircleAnimator.addUpdateListener(new b());
        this.mDropCircleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mDropCircleAnimator.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, ((float) this.mMaxDropHeight) - this.mDropCircleRadius);
        this.mDropVertexAnimator = ofFloat3;
        ofFloat3.setDuration(500L);
        this.mDropVertexAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropVertexAnimator.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropBounceVerticalAnimator = ofFloat4;
        ofFloat4.setDuration(500L);
        this.mDropBounceVerticalAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropBounceVerticalAnimator.setInterpolator(new ec0());
        this.mDropBounceVerticalAnimator.setStartDelay(500);
        this.mDropBounceVerticalAnimator.start();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropBounceHorizontalAnimator = ofFloat5;
        ofFloat5.setDuration(500L);
        this.mDropBounceHorizontalAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropBounceHorizontalAnimator.setInterpolator(new ec0());
        this.mDropBounceHorizontalAnimator.setStartDelay(625);
        this.mDropBounceHorizontalAnimator.start();
    }

    public void startWaveAnimation(float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.min(f, 0.2f) * ((float) this.mWidth), 0.0f);
        this.mWaveReverseAnimator = ofFloat;
        ofFloat.setDuration(1000L);
        this.mWaveReverseAnimator.addUpdateListener(new d());
        this.mWaveReverseAnimator.setInterpolator(new BounceInterpolator());
        this.mWaveReverseAnimator.start();
    }

    /* access modifiers changed from: protected */
    public void updateMaxDropHeight(int i) {
        float f = (float) i;
        if ((((float) this.mWidth) / 1440.0f) * 500.0f <= f) {
            this.mMaxDropHeight = (int) Math.min(f, ((float) getHeight()) - this.mDropCircleRadius);
            if (this.mIsManualRefreshing) {
                this.mIsManualRefreshing = false;
                manualRefresh();
            }
        }
    }
}
