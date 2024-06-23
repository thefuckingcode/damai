package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.gn0;
import tb.sp2;
import tb.sr1;

/* compiled from: Taobao */
public class TriangularPagerIndicator extends View implements IPagerIndicator {
    private float mAnchorX;
    private int mLineColor;
    private int mLineHeight;
    private Paint mPaint;
    private Path mPath = new Path();
    private List<sr1> mPositionDataList;
    private boolean mReverse;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private int mTriangleHeight;
    private int mTriangleWidth;
    private float mYOffset;

    public TriangularPagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = sp2.a(context, 3.0d);
        this.mTriangleWidth = sp2.a(context, 14.0d);
        this.mTriangleHeight = sp2.a(context, 8.0d);
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public int getLineHeight() {
        return this.mLineHeight;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public int getTriangleHeight() {
        return this.mTriangleHeight;
    }

    public int getTriangleWidth() {
        return this.mTriangleWidth;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public boolean isReverse() {
        return this.mReverse;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mLineColor);
        if (this.mReverse) {
            canvas.drawRect(0.0f, (((float) getHeight()) - this.mYOffset) - ((float) this.mTriangleHeight), (float) getWidth(), ((((float) getHeight()) - this.mYOffset) - ((float) this.mTriangleHeight)) + ((float) this.mLineHeight), this.mPaint);
        } else {
            canvas.drawRect(0.0f, ((float) (getHeight() - this.mLineHeight)) - this.mYOffset, (float) getWidth(), ((float) getHeight()) - this.mYOffset, this.mPaint);
        }
        this.mPath.reset();
        if (this.mReverse) {
            this.mPath.moveTo(this.mAnchorX - ((float) (this.mTriangleWidth / 2)), (((float) getHeight()) - this.mYOffset) - ((float) this.mTriangleHeight));
            this.mPath.lineTo(this.mAnchorX, ((float) getHeight()) - this.mYOffset);
            this.mPath.lineTo(this.mAnchorX + ((float) (this.mTriangleWidth / 2)), (((float) getHeight()) - this.mYOffset) - ((float) this.mTriangleHeight));
        } else {
            this.mPath.moveTo(this.mAnchorX - ((float) (this.mTriangleWidth / 2)), ((float) getHeight()) - this.mYOffset);
            this.mPath.lineTo(this.mAnchorX, ((float) (getHeight() - this.mTriangleHeight)) - this.mYOffset);
            this.mPath.lineTo(this.mAnchorX + ((float) (this.mTriangleWidth / 2)), ((float) getHeight()) - this.mYOffset);
        }
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
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
            int i3 = a.a;
            float f2 = (float) (i3 + ((a.c - i3) / 2));
            int i4 = a2.a;
            this.mAnchorX = f2 + ((((float) (i4 + ((a2.c - i4) / 2))) - f2) * this.mStartInterpolator.getInterpolation(f));
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

    public void setLineColor(int i) {
        this.mLineColor = i;
    }

    public void setLineHeight(int i) {
        this.mLineHeight = i;
    }

    public void setReverse(boolean z) {
        this.mReverse = z;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i) {
        this.mTriangleHeight = i;
    }

    public void setTriangleWidth(int i) {
        this.mTriangleWidth = i;
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
