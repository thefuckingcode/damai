package com.alibaba.pictures.bricks.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RoundRadiusImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mClipPath;
    private int mLastHeight;
    private int mLastWidth;
    private Paint mPaint;
    private int mRoundRadius;
    private int mStrokeColor;
    private int mStrokeWidth;

    public RoundRadiusImageView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[Catch:{ Exception -> 0x0086 }] */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        boolean z;
        int i;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1934188059")) {
            ipChange.ipc$dispatch("-1934188059", new Object[]{this, canvas});
            return;
        }
        try {
            int width = getWidth();
            int height = getHeight();
            if (width == this.mLastWidth) {
                if (height == this.mLastHeight) {
                    z = false;
                    if (this.mRoundRadius > 0) {
                        this.mClipPath = null;
                    } else if (z) {
                        Path path = new Path();
                        this.mClipPath = path;
                        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
                        int i2 = this.mRoundRadius;
                        path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
                    }
                    this.mLastWidth = width;
                    this.mLastHeight = height;
                    if (this.mClipPath != null) {
                        z2 = false;
                    }
                    if (z2) {
                        canvas.save();
                        canvas.clipPath(this.mClipPath);
                    }
                    super.onDraw(canvas);
                    if (z2) {
                        canvas.restore();
                    }
                    if (this.mClipPath != null && (i = this.mStrokeWidth) > 0) {
                        this.mPaint.setStrokeWidth((float) i);
                        this.mPaint.setColor(this.mStrokeColor);
                        canvas.drawPath(this.mClipPath, this.mPaint);
                        return;
                    }
                }
            }
            z = true;
            if (this.mRoundRadius > 0) {
            }
            this.mLastWidth = width;
            this.mLastHeight = height;
            if (this.mClipPath != null) {
            }
            if (z2) {
            }
            super.onDraw(canvas);
            if (z2) {
            }
            if (this.mClipPath != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRoundRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746121154")) {
            ipChange.ipc$dispatch("-1746121154", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLastHeight = -1;
        this.mLastWidth = -1;
        this.mRoundRadius = i;
        invalidate();
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        this.mLastWidth = -1;
        this.mLastHeight = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BricksRoundRadiusImageView);
        this.mRoundRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksRoundRadiusImageView_r_round_radius, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksRoundRadiusImageView_r_stroke_width, 0);
        this.mStrokeColor = obtainStyledAttributes.getColor(R$styleable.BricksRoundRadiusImageView_r_stroke_color, 0);
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
    }
}
