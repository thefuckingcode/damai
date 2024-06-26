package com.youku.resource.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.youku.resource.R;

/* compiled from: Taobao */
public class DownloadProgressBar extends View {
    private int mIconBellowColor;
    private int mIconUpColor;
    private float mRoundWidth;
    private int mTextColor;
    private float mTextSize;
    private int max = 100;
    private Paint paint;
    private int progress = 0;

    public DownloadProgressBar(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (this.paint == null) {
            this.paint = new Paint();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YoukuCommonDownLoadProgressBar);
            this.mTextColor = obtainStyledAttributes.getColor(R.styleable.YoukuCommonDownLoadProgressBar_perTextColor, -1);
            this.mIconBellowColor = obtainStyledAttributes.getColor(R.styleable.YoukuCommonDownLoadProgressBar_iconBellowColor, 16762120);
            this.mIconUpColor = obtainStyledAttributes.getColor(R.styleable.YoukuCommonDownLoadProgressBar_iconUpColor, -419430401);
            this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.YoukuCommonDownLoadProgressBar_perTextSize, 32.0f);
            this.mRoundWidth = obtainStyledAttributes.getDimension(R.styleable.YoukuCommonDownLoadProgressBar_roundWidth, 5.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = (float) width;
        int i = (int) (f - (this.mRoundWidth / 2.0f));
        this.paint.setColor(this.mIconBellowColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.mRoundWidth);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(f, f, (float) i, this.paint);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.mTextColor);
        this.paint.setTextSize(this.mTextSize);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((((float) this.progress) / ((float) this.max)) * 100.0f);
        Paint paint2 = this.paint;
        float measureText = paint2.measureText(i2 + "%");
        if (i2 != 0) {
            canvas.drawText(i2 + "%", f - (measureText / 2.0f), f + (this.mTextSize / 2.0f), this.paint);
        }
        this.paint.setStrokeWidth(this.mRoundWidth);
        this.paint.setColor(this.mIconUpColor);
        float f2 = (float) (width - i);
        float f3 = (float) (width + i);
        canvas.drawArc(new RectF(f2, f2, f3, f3), -90.0f, (float) ((this.progress * 360) / this.max), false, this.paint);
    }

    public synchronized void setProgress(int i) {
        if (i >= 0) {
            int i2 = this.max;
            if (i > i2) {
                i = i2;
            }
            if (i <= i2) {
                this.progress = i;
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
