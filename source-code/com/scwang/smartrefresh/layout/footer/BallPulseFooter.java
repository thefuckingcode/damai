package com.scwang.smartrefresh.layout.footer;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import tb.cc2;
import tb.gd2;

/* compiled from: Taobao */
public class BallPulseFooter extends InternalAbstract implements RefreshFooter {
    protected int mAnimatingColor;
    protected float mCircleSpacing;
    protected TimeInterpolator mInterpolator;
    protected boolean mIsStarted;
    protected boolean mManualAnimationColor;
    protected boolean mManualNormalColor;
    protected int mNormalColor;
    protected Paint mPaint;
    protected long mStartTime;

    public BallPulseFooter(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = this.mCircleSpacing;
        float min = (((float) Math.min(width, height)) - (f * 2.0f)) / 6.0f;
        float f2 = min * 2.0f;
        float f3 = (((float) width) / 2.0f) - (f + f2);
        float f4 = ((float) height) / 2.0f;
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            long j = (currentTimeMillis - this.mStartTime) - ((long) (i2 * 120));
            float interpolation = this.mInterpolator.getInterpolation(j > 0 ? ((float) (j % 750)) / 750.0f : 0.0f);
            canvas.save();
            float f5 = (float) i;
            canvas.translate((f2 * f5) + f3 + (this.mCircleSpacing * f5), f4);
            if (((double) interpolation) < 0.5d) {
                float f6 = 1.0f - ((interpolation * 2.0f) * 0.7f);
                canvas.scale(f6, f6);
            } else {
                float f7 = ((interpolation * 2.0f) * 0.7f) - 0.4f;
                canvas.scale(f7, f7);
            }
            canvas.drawCircle(0.0f, 0.0f, min, this.mPaint);
            canvas.restore();
            i = i2;
        }
        super.dispatchDraw(canvas);
        if (this.mIsStarted) {
            invalidate();
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mIsStarted = false;
        this.mStartTime = 0;
        this.mPaint.setColor(this.mNormalColor);
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        if (!this.mIsStarted) {
            invalidate();
            this.mIsStarted = true;
            this.mStartTime = System.currentTimeMillis();
            this.mPaint.setColor(this.mAnimatingColor);
        }
    }

    public BallPulseFooter setAnimatingColor(@ColorInt int i) {
        this.mAnimatingColor = i;
        this.mManualAnimationColor = true;
        if (this.mIsStarted) {
            this.mPaint.setColor(i);
        }
        return this;
    }

    public BallPulseFooter setNormalColor(@ColorInt int i) {
        this.mNormalColor = i;
        this.mManualNormalColor = true;
        if (!this.mIsStarted) {
            this.mPaint.setColor(i);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (!this.mManualAnimationColor && iArr.length > 1) {
            setAnimatingColor(iArr[0]);
            this.mManualAnimationColor = false;
        }
        if (!this.mManualNormalColor) {
            if (iArr.length > 1) {
                setNormalColor(iArr[1]);
            } else if (iArr.length > 0) {
                setNormalColor(ColorUtils.compositeColors(-1711276033, iArr[0]));
            }
            this.mManualNormalColor = false;
        }
    }

    public BallPulseFooter setSpinnerStyle(gd2 gd2) {
        this.mSpinnerStyle = gd2;
        return this;
    }

    public BallPulseFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mNormalColor = -1118482;
        this.mAnimatingColor = -1615546;
        this.mStartTime = 0;
        this.mIsStarted = false;
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        setMinimumHeight(cc2.dp2px(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BallPulseFooter);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        gd2 gd2 = gd2.Translate;
        this.mSpinnerStyle = gd2;
        this.mSpinnerStyle = gd2.values[obtainStyledAttributes.getInt(R$styleable.BallPulseFooter_srlClassicsSpinnerStyle, gd2.a)];
        int i = R$styleable.BallPulseFooter_srlNormalColor;
        if (obtainStyledAttributes.hasValue(i)) {
            setNormalColor(obtainStyledAttributes.getColor(i, 0));
        }
        int i2 = R$styleable.BallPulseFooter_srlAnimatingColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            setAnimatingColor(obtainStyledAttributes.getColor(i2, 0));
        }
        obtainStyledAttributes.recycle();
        this.mCircleSpacing = (float) cc2.dp2px(4.0f);
    }
}
