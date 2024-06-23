package com.scwang.smartrefresh.header.waterdrop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.youku.live.livesdk.wkit.component.common.utils.SystemBarTintManager;
import tb.yh;

/* compiled from: Taobao */
public class WaterDropView extends View {
    protected static final int BACK_ANIM_DURATION = 180;
    protected static int STROKE_WIDTH = 2;
    protected yh bottomCircle = new yh();
    protected int mMaxCircleRadius;
    protected int mMinCircleRadius;
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected yh topCircle = new yh();

    /* compiled from: Taobao */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.updateCompleteState(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.mPaint;
        int dp2px = DensityUtil.dp2px(1.0f);
        STROKE_WIDTH = dp2px;
        paint2.setStrokeWidth((float) dp2px);
        Paint paint3 = this.mPaint;
        int i = STROKE_WIDTH;
        paint3.setShadowLayer((float) i, (float) (i / 2), (float) i, SystemBarTintManager.DEFAULT_TINT_COLOR);
        setLayerType(1, null);
        int i2 = STROKE_WIDTH * 4;
        setPadding(i2, i2, i2, i2);
        this.mPaint.setColor(-7829368);
        int dp2px2 = DensityUtil.dp2px(20.0f);
        this.mMaxCircleRadius = dp2px2;
        this.mMinCircleRadius = dp2px2 / 5;
        yh yhVar = this.topCircle;
        yhVar.c = (float) dp2px2;
        yh yhVar2 = this.bottomCircle;
        yhVar2.c = (float) dp2px2;
        int i3 = STROKE_WIDTH;
        yhVar.a = (float) (i3 + dp2px2);
        yhVar.b = (float) (i3 + dp2px2);
        yhVar2.a = (float) (i3 + dp2px2);
        yhVar2.b = (float) (i3 + dp2px2);
    }

    private double getAngle() {
        yh yhVar = this.bottomCircle;
        float f = yhVar.c;
        yh yhVar2 = this.topCircle;
        float f2 = yhVar2.c;
        if (f > f2) {
            return 0.0d;
        }
        return Math.asin((double) ((f2 - f) / (yhVar.b - yhVar2.b)));
    }

    private void makeBezierPath() {
        this.mPath.reset();
        Path path = this.mPath;
        yh yhVar = this.topCircle;
        path.addCircle(yhVar.a, yhVar.b, yhVar.c, Path.Direction.CCW);
        if (this.bottomCircle.b > this.topCircle.b + ((float) DensityUtil.dp2px(1.0f))) {
            Path path2 = this.mPath;
            yh yhVar2 = this.bottomCircle;
            path2.addCircle(yhVar2.a, yhVar2.b, yhVar2.c, Path.Direction.CCW);
            double angle = getAngle();
            yh yhVar3 = this.topCircle;
            float cos = (float) (((double) yhVar3.a) - (((double) yhVar3.c) * Math.cos(angle)));
            yh yhVar4 = this.topCircle;
            float sin = (float) (((double) yhVar4.b) + (((double) yhVar4.c) * Math.sin(angle)));
            yh yhVar5 = this.topCircle;
            float cos2 = (float) (((double) yhVar5.a) + (((double) yhVar5.c) * Math.cos(angle)));
            yh yhVar6 = this.bottomCircle;
            float cos3 = (float) (((double) yhVar6.a) - (((double) yhVar6.c) * Math.cos(angle)));
            yh yhVar7 = this.bottomCircle;
            float sin2 = (float) (((double) yhVar7.b) + (((double) yhVar7.c) * Math.sin(angle)));
            yh yhVar8 = this.bottomCircle;
            float cos4 = (float) (((double) yhVar8.a) + (((double) yhVar8.c) * Math.cos(angle)));
            Path path3 = this.mPath;
            yh yhVar9 = this.topCircle;
            path3.moveTo(yhVar9.a, yhVar9.b);
            this.mPath.lineTo(cos, sin);
            Path path4 = this.mPath;
            yh yhVar10 = this.bottomCircle;
            path4.quadTo(yhVar10.a - yhVar10.c, (yhVar10.b + this.topCircle.b) / 2.0f, cos3, sin2);
            this.mPath.lineTo(cos4, sin2);
            Path path5 = this.mPath;
            yh yhVar11 = this.bottomCircle;
            path5.quadTo(yhVar11.a + yhVar11.c, (yhVar11.b + sin) / 2.0f, cos2, sin);
        }
        this.mPath.close();
    }

    public ValueAnimator createAnimator() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new a());
        return duration;
    }

    public yh getBottomCircle() {
        return this.bottomCircle;
    }

    public int getIndicatorColor() {
        return this.mPaint.getColor();
    }

    public int getMaxCircleRadius() {
        return this.mMaxCircleRadius;
    }

    public yh getTopCircle() {
        return this.topCircle;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = (float) height;
        float f2 = this.topCircle.c;
        float f3 = (float) paddingTop;
        float f4 = (float) paddingBottom;
        if (f <= (f2 * 2.0f) + f3 + f4) {
            canvas.translate((float) paddingLeft, (f - (f2 * 2.0f)) - f4);
            yh yhVar = this.topCircle;
            canvas.drawCircle(yhVar.a, yhVar.b, yhVar.c, this.mPaint);
        } else {
            canvas.translate((float) paddingLeft, f3);
            makeBezierPath();
            canvas.drawPath(this.mPath, this.mPaint);
        }
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateCompleteState(getHeight());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.mMaxCircleRadius;
        int i4 = STROKE_WIDTH;
        yh yhVar = this.bottomCircle;
        super.setMeasuredDimension(((i3 + i4) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil((double) (yhVar.b + yhVar.c + ((float) (i4 * 2))))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void setIndicatorColor(@ColorInt int i) {
        this.mPaint.setColor(i);
    }

    public void updateCompleteState(float f) {
        int i = this.mMaxCircleRadius;
        float f2 = f * 4.0f * ((float) i);
        yh yhVar = this.topCircle;
        yhVar.c = (float) (((double) i) - ((((double) f) * 0.25d) * ((double) i)));
        yh yhVar2 = this.bottomCircle;
        yhVar2.c = (((float) (this.mMinCircleRadius - i)) * f) + ((float) i);
        yhVar2.b = yhVar.b + f2;
    }

    public void updateCompleteState(int i, int i2) {
    }

    public void updateCompleteState(int i) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.mMaxCircleRadius;
        float f = (float) ((i2 * 2) + paddingTop + paddingBottom);
        float f2 = (float) i;
        if (f2 < f) {
            yh yhVar = this.topCircle;
            yhVar.c = (float) i2;
            yh yhVar2 = this.bottomCircle;
            yhVar2.c = (float) i2;
            yhVar2.b = yhVar.b;
            return;
        }
        float pow = (float) (((double) ((float) (i2 - this.mMinCircleRadius))) * (1.0d - Math.pow(100.0d, (double) ((-Math.max(0.0f, f2 - f)) / ((float) DensityUtil.dp2px(200.0f))))));
        yh yhVar3 = this.topCircle;
        int i3 = this.mMaxCircleRadius;
        yhVar3.c = ((float) i3) - (pow / 4.0f);
        yh yhVar4 = this.bottomCircle;
        float f3 = ((float) i3) - pow;
        yhVar4.c = f3;
        yhVar4.b = ((float) ((i - paddingTop) - paddingBottom)) - f3;
    }
}
