package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import tb.cc2;
import tb.gd2;

/* compiled from: Taobao */
public class BezierRadarHeader extends InternalAbstract implements RefreshHeader {
    protected static final byte PROPERTY_DOT_ALPHA = 2;
    protected static final byte PROPERTY_RADAR_ANGLE = 4;
    protected static final byte PROPERTY_RADAR_SCALE = 0;
    protected static final byte PROPERTY_RIPPLE_RADIUS = 3;
    protected static final byte PROPERTY_WAVE_HEIGHT = 1;
    protected int mAccentColor;
    protected Animator mAnimatorSet;
    protected float mDotAlpha;
    protected float mDotFraction;
    protected float mDotRadius;
    protected boolean mEnableHorizontalDrag;
    protected boolean mManualAccentColor;
    protected boolean mManualPrimaryColor;
    protected Paint mPaint;
    protected Path mPath;
    protected int mPrimaryColor;
    protected int mRadarAngle;
    protected float mRadarCircle;
    protected float mRadarRadius;
    protected RectF mRadarRect;
    protected float mRadarScale;
    protected float mRippleRadius;
    protected int mWaveHeight;
    protected int mWaveOffsetX;
    protected int mWaveOffsetY;
    protected boolean mWavePulling;
    protected int mWaveTop;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            iArr[RefreshState.None.ordinal()] = 1;
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;
        }
    }

    /* compiled from: Taobao */
    protected class b implements ValueAnimator.AnimatorUpdateListener {
        byte a;

        b(byte b2) {
            this.a = b2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b2 = this.a;
            if (b2 == 0) {
                BezierRadarHeader.this.mRadarScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b2) {
                BezierRadarHeader bezierRadarHeader = BezierRadarHeader.this;
                if (bezierRadarHeader.mWavePulling) {
                    valueAnimator.cancel();
                    return;
                }
                bezierRadarHeader.mWaveHeight = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b2) {
                BezierRadarHeader.this.mDotAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b2) {
                BezierRadarHeader.this.mRippleRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b2) {
                BezierRadarHeader.this.mRadarAngle = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.mWaveOffsetY;
        drawWave(canvas, width);
        drawDot(canvas, width, height);
        drawRadar(canvas, width, height);
        drawRipple(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawDot(Canvas canvas, int i, int i2) {
        float f = 0.0f;
        if (this.mDotAlpha > 0.0f) {
            this.mPaint.setColor(this.mAccentColor);
            float px2dp = cc2.px2dp(i2);
            float f2 = (float) i;
            float f3 = 7.0f;
            float f4 = (f2 * 1.0f) / 7.0f;
            float f5 = this.mDotFraction;
            float f6 = (f4 * f5) - (f5 > 1.0f ? ((f5 - 1.0f) * f4) / f5 : 0.0f);
            float f7 = (float) i2;
            if (f5 > 1.0f) {
                f = (((f5 - 1.0f) * f7) / 2.0f) / f5;
            }
            float f8 = f7 - f;
            int i3 = 0;
            while (i3 < 7) {
                float f9 = (((float) i3) + 1.0f) - 4.0f;
                this.mPaint.setAlpha((int) (((double) (this.mDotAlpha * (1.0f - ((Math.abs(f9) / f3) * 2.0f)) * 255.0f)) * (1.0d - (1.0d / Math.pow((((double) px2dp) / 800.0d) + 1.0d, 15.0d)))));
                float f10 = this.mDotRadius * (1.0f - (1.0f / ((px2dp / 10.0f) + 1.0f)));
                canvas.drawCircle(((f2 / 2.0f) - (f10 / 2.0f)) + (f6 * f9), f8 / 2.0f, f10, this.mPaint);
                i3++;
                f3 = 7.0f;
            }
            this.mPaint.setAlpha(255);
        }
    }

    /* access modifiers changed from: protected */
    public void drawRadar(Canvas canvas, int i, int i2) {
        if (this.mAnimatorSet != null || isInEditMode()) {
            float f = this.mRadarRadius;
            float f2 = this.mRadarScale;
            float f3 = f * f2;
            float f4 = this.mRadarCircle * f2;
            this.mPaint.setColor(this.mAccentColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            float f5 = ((float) i) / 2.0f;
            float f6 = ((float) i2) / 2.0f;
            canvas.drawCircle(f5, f6, f3, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f7 = f4 + f3;
            canvas.drawCircle(f5, f6, f7, this.mPaint);
            this.mPaint.setColor((this.mPrimaryColor & 16777215) | 1426063360);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mRadarRect.set(f5 - f3, f6 - f3, f5 + f3, f3 + f6);
            canvas.drawArc(this.mRadarRect, 270.0f, (float) this.mRadarAngle, true, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mRadarRect.set(f5 - f7, f6 - f7, f5 + f7, f6 + f7);
            canvas.drawArc(this.mRadarRect, 270.0f, (float) this.mRadarAngle, false, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
    }

    /* access modifiers changed from: protected */
    public void drawRipple(Canvas canvas, int i, int i2) {
        if (this.mRippleRadius > 0.0f) {
            this.mPaint.setColor(this.mAccentColor);
            canvas.drawCircle(((float) i) / 2.0f, ((float) i2) / 2.0f, this.mRippleRadius, this.mPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawWave(Canvas canvas, int i) {
        this.mPath.reset();
        this.mPath.lineTo(0.0f, (float) this.mWaveTop);
        Path path = this.mPath;
        int i2 = this.mWaveOffsetX;
        float f = i2 >= 0 ? (float) i2 : ((float) i) / 2.0f;
        int i3 = this.mWaveTop;
        float f2 = (float) i;
        path.quadTo(f, (float) (this.mWaveHeight + i3), f2, (float) i3);
        this.mPath.lineTo(f2, 0.0f);
        this.mPaint.setColor(this.mPrimaryColor);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean isSupportHorizontalDrag() {
        return this.mEnableHorizontalDrag;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
        int width = getWidth();
        int i = this.mWaveOffsetY;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mRadarRadius, (float) Math.sqrt((double) ((width * width) + (i * i))));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new b((byte) 3));
        ofFloat.start();
        return 400;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onHorizontalDrag(float f, int i, int i2) {
        this.mWaveOffsetX = i;
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        this.mWaveOffsetY = i;
        if (z || this.mWavePulling) {
            this.mWavePulling = true;
            this.mWaveTop = Math.min(i2, i);
            this.mWaveHeight = (int) (((float) Math.max(0, i - i2)) * 1.9f);
            this.mDotFraction = f;
            invalidate();
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mWaveTop = i - 1;
        this.mWavePulling = false;
        cc2 cc2 = new cc2(cc2.INTERPOLATOR_DECELERATE);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(cc2);
        ofFloat.addUpdateListener(new b((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(cc2);
        ofFloat2.addUpdateListener(new b((byte) 0));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new b((byte) 4));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i3 = this.mWaveHeight;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, 0, -((int) (((float) i3) * 0.8f)), 0, -((int) (((float) i3) * 0.4f)), 0);
        ofInt2.addUpdateListener(new b((byte) 1));
        ofInt2.setInterpolator(new cc2(cc2.INTERPOLATOR_DECELERATE));
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.mAnimatorSet = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        int i = a.a[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mDotAlpha = 1.0f;
            this.mRadarScale = 0.0f;
            this.mRippleRadius = 0.0f;
        }
    }

    public BezierRadarHeader setAccentColor(@ColorInt int i) {
        this.mAccentColor = i;
        this.mManualAccentColor = true;
        return this;
    }

    public BezierRadarHeader setAccentColorId(@ColorRes int i) {
        setAccentColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public BezierRadarHeader setEnableHorizontalDrag(boolean z) {
        this.mEnableHorizontalDrag = z;
        if (!z) {
            this.mWaveOffsetX = -1;
        }
        return this;
    }

    public BezierRadarHeader setPrimaryColor(@ColorInt int i) {
        this.mPrimaryColor = i;
        this.mManualPrimaryColor = true;
        return this;
    }

    public BezierRadarHeader setPrimaryColorId(@ColorRes int i) {
        setPrimaryColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0 && !this.mManualPrimaryColor) {
            setPrimaryColor(iArr[0]);
            this.mManualPrimaryColor = false;
        }
        if (iArr.length > 1 && !this.mManualAccentColor) {
            setAccentColor(iArr[1]);
            this.mManualAccentColor = false;
        }
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mEnableHorizontalDrag = false;
        this.mWaveOffsetX = -1;
        this.mWaveOffsetY = 0;
        this.mRadarAngle = 0;
        this.mRadarRadius = 0.0f;
        this.mRadarCircle = 0.0f;
        this.mRadarScale = 0.0f;
        this.mRadarRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mSpinnerStyle = gd2.FixedBehind;
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mDotRadius = (float) cc2.dp2px(7.0f);
        this.mRadarRadius = (float) cc2.dp2px(20.0f);
        this.mRadarCircle = (float) cc2.dp2px(7.0f);
        this.mPaint.setStrokeWidth((float) cc2.dp2px(3.0f));
        setMinimumHeight(cc2.dp2px(100.0f));
        if (isInEditMode()) {
            this.mWaveTop = 1000;
            this.mRadarScale = 1.0f;
            this.mRadarAngle = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
        } else {
            this.mRadarScale = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BezierRadarHeader);
        this.mEnableHorizontalDrag = obtainStyledAttributes.getBoolean(R$styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.mEnableHorizontalDrag);
        int i = R$styleable.BezierRadarHeader_srlAccentColor;
        setAccentColor(obtainStyledAttributes.getColor(i, -1));
        int i2 = R$styleable.BezierRadarHeader_srlPrimaryColor;
        setPrimaryColor(obtainStyledAttributes.getColor(i2, -14540254));
        this.mManualAccentColor = obtainStyledAttributes.hasValue(i);
        this.mManualPrimaryColor = obtainStyledAttributes.hasValue(i2);
        obtainStyledAttributes.recycle();
    }
}
