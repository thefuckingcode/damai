package com.youku.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baseproject.ui.R$styleable;

/* compiled from: Taobao */
public class GridItem extends LinearLayout {
    private int height;
    private Paint mPaint = new Paint();
    private float percent;
    private int width;

    public GridItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hisPercent);
        this.percent = obtainStyledAttributes.getFloat(R$styleable.hisPercent_percent, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.percent != 0.0f) {
            this.mPaint.setColor(-13382401);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(4.0f);
            float f = this.percent;
            if (f <= 25.0f && f > 0.0f) {
                canvas.drawLine(0.0f, 0.0f, (f * ((float) this.width)) / 25.0f, 0.0f, this.mPaint);
            } else if (f > 25.0f && f <= 50.0f) {
                canvas.drawLine(0.0f, 0.0f, (float) this.width, 0.0f, this.mPaint);
                int i = this.width;
                canvas.drawLine((float) i, 0.0f, (float) i, ((this.percent - 25.0f) * ((float) i)) / 25.0f, this.mPaint);
            } else if (f > 50.0f && f <= 75.0f) {
                canvas.drawLine(0.0f, 0.0f, (float) this.width, 0.0f, this.mPaint);
                int i2 = this.width;
                canvas.drawLine((float) i2, 0.0f, (float) i2, (float) i2, this.mPaint);
                int i3 = this.width;
                canvas.drawLine(((float) i3) - (((this.percent - 50.0f) * ((float) i3)) / 25.0f), (float) i3, (float) i3, (float) i3, this.mPaint);
            } else if (f > 75.0f && f <= 100.0f) {
                canvas.drawLine(0.0f, 0.0f, (float) this.width, 0.0f, this.mPaint);
                int i4 = this.width;
                canvas.drawLine((float) i4, 0.0f, (float) i4, (float) i4, this.mPaint);
                int i5 = this.width;
                canvas.drawLine((float) i5, (float) i5, 0.0f, (float) i5, this.mPaint);
                int i6 = this.width;
                canvas.drawLine(0.0f, (float) i6, 0.0f, ((float) i6) - (((this.percent - 75.0f) * ((float) i6)) / 25.0f), this.mPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        this.width = size;
        this.height = size;
        setMeasuredDimension(size, size);
    }

    public void setPercent(float f) {
        this.percent = f;
    }
}
