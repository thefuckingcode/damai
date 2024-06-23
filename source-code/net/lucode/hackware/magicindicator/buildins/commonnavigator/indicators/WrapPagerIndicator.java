package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.gn0;
import tb.sp2;
import tb.sr1;

/* compiled from: Taobao */
public class WrapPagerIndicator extends View implements IPagerIndicator {
    private Interpolator mEndInterpolator = new LinearInterpolator();
    private int mFillColor;
    private int mHorizontalPadding;
    private Paint mPaint;
    private List<sr1> mPositionDataList;
    private RectF mRect = new RectF();
    private float mRoundRadius;
    private boolean mRoundRadiusSet;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private int mVerticalPadding;

    public WrapPagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mVerticalPadding = sp2.a(context, 6.0d);
        this.mHorizontalPadding = sp2.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.mEndInterpolator;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public int getHorizontalPadding() {
        return this.mHorizontalPadding;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public float getRoundRadius() {
        return this.mRoundRadius;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public int getVerticalPadding() {
        return this.mVerticalPadding;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mFillColor);
        RectF rectF = this.mRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        List<sr1> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            sr1 a = gn0.a(this.mPositionDataList, i);
            sr1 a2 = gn0.a(this.mPositionDataList, i + 1);
            RectF rectF = this.mRect;
            int i3 = a.e;
            rectF.left = ((float) (i3 - this.mHorizontalPadding)) + (((float) (a2.e - i3)) * this.mEndInterpolator.getInterpolation(f));
            RectF rectF2 = this.mRect;
            rectF2.top = (float) (a.f - this.mVerticalPadding);
            int i4 = a.g;
            rectF2.right = ((float) (this.mHorizontalPadding + i4)) + (((float) (a2.g - i4)) * this.mStartInterpolator.getInterpolation(f));
            RectF rectF3 = this.mRect;
            rectF3.bottom = (float) (a.h + this.mVerticalPadding);
            if (!this.mRoundRadiusSet) {
                this.mRoundRadius = rectF3.height() / 2.0f;
            }
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

    public void setEndInterpolator(Interpolator interpolator) {
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
    }

    public void setHorizontalPadding(int i) {
        this.mHorizontalPadding = i;
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
        this.mRoundRadiusSet = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i) {
        this.mVerticalPadding = i;
    }
}
