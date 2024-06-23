package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.f7;
import tb.gn0;
import tb.sp2;
import tb.sr1;

/* compiled from: Taobao */
public class BezierPagerIndicator extends View implements IPagerIndicator {
    private List<Integer> mColors;
    private Interpolator mEndInterpolator = new DecelerateInterpolator();
    private float mLeftCircleRadius;
    private float mLeftCircleX;
    private float mMaxCircleRadius;
    private float mMinCircleRadius;
    private Paint mPaint;
    private Path mPath = new Path();
    private List<sr1> mPositionDataList;
    private float mRightCircleRadius;
    private float mRightCircleX;
    private Interpolator mStartInterpolator = new AccelerateInterpolator();
    private float mYOffset;

    public BezierPagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void drawBezierCurve(Canvas canvas) {
        this.mPath.reset();
        float height = (((float) getHeight()) - this.mYOffset) - this.mMaxCircleRadius;
        this.mPath.moveTo(this.mRightCircleX, height);
        this.mPath.lineTo(this.mRightCircleX, height - this.mRightCircleRadius);
        Path path = this.mPath;
        float f = this.mRightCircleX;
        float f2 = this.mLeftCircleX;
        path.quadTo(f + ((f2 - f) / 2.0f), height, f2, height - this.mLeftCircleRadius);
        this.mPath.lineTo(this.mLeftCircleX, this.mLeftCircleRadius + height);
        Path path2 = this.mPath;
        float f3 = this.mRightCircleX;
        path2.quadTo(((this.mLeftCircleX - f3) / 2.0f) + f3, height, f3, this.mRightCircleRadius + height);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mMaxCircleRadius = (float) sp2.a(context, 3.5d);
        this.mMinCircleRadius = (float) sp2.a(context, 2.0d);
        this.mYOffset = (float) sp2.a(context, 1.5d);
    }

    public float getMaxCircleRadius() {
        return this.mMaxCircleRadius;
    }

    public float getMinCircleRadius() {
        return this.mMinCircleRadius;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.mLeftCircleX, (((float) getHeight()) - this.mYOffset) - this.mMaxCircleRadius, this.mLeftCircleRadius, this.mPaint);
        canvas.drawCircle(this.mRightCircleX, (((float) getHeight()) - this.mYOffset) - this.mMaxCircleRadius, this.mRightCircleRadius, this.mPaint);
        drawBezierCurve(canvas);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        List<sr1> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.mColors;
            if (list2 != null && list2.size() > 0) {
                this.mPaint.setColor(f7.a(f, this.mColors.get(Math.abs(i) % this.mColors.size()).intValue(), this.mColors.get(Math.abs(i + 1) % this.mColors.size()).intValue()));
            }
            sr1 a = gn0.a(this.mPositionDataList, i);
            sr1 a2 = gn0.a(this.mPositionDataList, i + 1);
            int i3 = a.a;
            float f2 = (float) (i3 + ((a.c - i3) / 2));
            int i4 = a2.a;
            float f3 = ((float) (i4 + ((a2.c - i4) / 2))) - f2;
            this.mLeftCircleX = (this.mStartInterpolator.getInterpolation(f) * f3) + f2;
            this.mRightCircleX = f2 + (f3 * this.mEndInterpolator.getInterpolation(f));
            float f4 = this.mMaxCircleRadius;
            this.mLeftCircleRadius = f4 + ((this.mMinCircleRadius - f4) * this.mEndInterpolator.getInterpolation(f));
            float f5 = this.mMinCircleRadius;
            this.mRightCircleRadius = f5 + ((this.mMaxCircleRadius - f5) * this.mStartInterpolator.getInterpolation(f));
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<sr1> list) {
        this.mPositionDataList = list;
    }

    public void setColors(Integer... numArr) {
        this.mColors = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f) {
        this.mMaxCircleRadius = f;
    }

    public void setMinCircleRadius(float f) {
        this.mMinCircleRadius = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
