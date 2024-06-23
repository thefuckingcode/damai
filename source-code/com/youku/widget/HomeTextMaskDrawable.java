package com.youku.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
public class HomeTextMaskDrawable extends ShapeDrawable {
    private static final String TAG = "HomeTextMaskDrawable";
    private static Paint mPaint;
    protected String mText = "Test";
    private float mTextBaselineY;
    protected float mTextCenterX;
    private int mTextColor = SupportMenu.CATEGORY_MASK;
    private int mTextSize = 20;

    static {
        Paint paint = new Paint();
        mPaint = paint;
        paint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    public HomeTextMaskDrawable(Shape shape) {
        super(shape);
    }

    /* access modifiers changed from: protected */
    public float getStringWidth(String str) {
        return mPaint.measureText(str);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);
        setTextLocation();
        canvas.drawText(this.mText, this.mTextCenterX, this.mTextBaselineY, mPaint);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    /* access modifiers changed from: protected */
    public void setTextLocation() {
        mPaint.setTextSize((float) this.mTextSize);
        mPaint.setColor(this.mTextColor);
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float f = fontMetrics.descent;
        float intrinsicHeight = (((float) (getIntrinsicHeight() / 2)) - f) + ((f - fontMetrics.ascent) / 2.0f);
        this.mTextCenterX = ((float) getIntrinsicWidth()) / 2.0f;
        this.mTextBaselineY = intrinsicHeight;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }
}
