package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.f7;
import tb.gn0;
import tb.sp2;
import tb.sr1;

/* compiled from: Taobao */
public class LinePagerIndicator extends View implements IPagerIndicator {
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private List<Integer> mColors;
    private Interpolator mEndInterpolator = new LinearInterpolator();
    private float mLineHeight;
    private RectF mLineRect = new RectF();
    private float mLineWidth;
    private int mMode;
    private Paint mPaint;
    private List<sr1> mPositionDataList;
    private float mRoundRadius;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private float mXOffset;
    private float mYOffset;

    public LinePagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = (float) sp2.a(context, 3.0d);
        this.mLineWidth = (float) sp2.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public Interpolator getEndInterpolator() {
        return this.mEndInterpolator;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public int getMode() {
        return this.mMode;
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

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.mLineRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i3;
        List<sr1> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.mColors;
            if (list2 != null && list2.size() > 0) {
                this.mPaint.setColor(f7.a(f, this.mColors.get(Math.abs(i) % this.mColors.size()).intValue(), this.mColors.get(Math.abs(i + 1) % this.mColors.size()).intValue()));
            }
            sr1 a = gn0.a(this.mPositionDataList, i);
            sr1 a2 = gn0.a(this.mPositionDataList, i + 1);
            int i4 = this.mMode;
            if (i4 == 0) {
                f6 = this.mXOffset;
                f5 = ((float) a.a) + f6;
                f4 = ((float) a2.a) + f6;
                f2 = ((float) a.c) - f6;
                i3 = a2.c;
            } else if (i4 == 1) {
                f6 = this.mXOffset;
                f5 = ((float) a.e) + f6;
                f4 = ((float) a2.e) + f6;
                f2 = ((float) a.g) - f6;
                i3 = a2.g;
            } else {
                f5 = ((float) a.a) + ((((float) a.b()) - this.mLineWidth) / 2.0f);
                float b = ((float) a2.a) + ((((float) a2.b()) - this.mLineWidth) / 2.0f);
                f2 = ((((float) a.b()) + this.mLineWidth) / 2.0f) + ((float) a.a);
                f3 = ((((float) a2.b()) + this.mLineWidth) / 2.0f) + ((float) a2.a);
                f4 = b;
                this.mLineRect.left = f5 + ((f4 - f5) * this.mStartInterpolator.getInterpolation(f));
                this.mLineRect.right = f2 + ((f3 - f2) * this.mEndInterpolator.getInterpolation(f));
                this.mLineRect.top = (((float) getHeight()) - this.mLineHeight) - this.mYOffset;
                this.mLineRect.bottom = ((float) getHeight()) - this.mYOffset;
                invalidate();
            }
            f3 = ((float) i3) - f6;
            this.mLineRect.left = f5 + ((f4 - f5) * this.mStartInterpolator.getInterpolation(f));
            this.mLineRect.right = f2 + ((f3 - f2) * this.mEndInterpolator.getInterpolation(f));
            this.mLineRect.top = (((float) getHeight()) - this.mLineHeight) - this.mYOffset;
            this.mLineRect.bottom = ((float) getHeight()) - this.mYOffset;
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
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        this.mXOffset = f;
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
