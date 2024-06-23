package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: Taobao */
public class DrawView extends View {
    public static final int STATUS_END = 3;
    public static final int STATUS_FINISH = 2;
    public static final int STATUS_IN_BOUND = 1;
    public static final int STATUS_START = 0;
    private Bitmap[] bitmap = new Bitmap[10];
    private Bitmap bitmap1 = null;
    private Bitmap bitmap2 = null;
    private float boundaryX = 0.0f;
    private float boundaryY = 0.0f;
    private float centerX = 0.0f;
    private float centerX1 = 0.0f;
    private float centerY = 0.0f;
    private float centerY1 = 0.0f;
    private float currentX = 40.0f;
    private float currentY = 50.0f;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private Paint paint = null;
    private float radius = 120.0f;
    private float radiusInner = 60.0f;
    private float radiusInner1 = 80.0f;
    private int status = 0;

    public DrawView(Context context) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        this.bitmap2 = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ali_vsdk_frame1", "drawable", context.getPackageName()));
        this.bitmap[0] = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ali_vsdk_frame", "drawable", context.getPackageName()));
        Bitmap bitmap3 = this.bitmap[0];
        this.bitmap1 = bitmap3;
        this.radius = (float) (bitmap3.getWidth() / 2);
        this.radiusInner = (float) (this.bitmap1.getWidth() / 2);
        this.radiusInner1 = (float) (this.bitmap1.getWidth() / 2);
        this.paint = new Paint();
        float f = this.radius;
        initPostion(((float) this.mScreenWidth) - f, f);
    }

    public float getBoundaryBottom() {
        return this.boundaryY + (this.radiusInner * 2.0f);
    }

    public float getBoundaryLeft() {
        return this.boundaryX;
    }

    public float getBoundaryRight() {
        return this.boundaryX + (this.radiusInner * 2.0f);
    }

    public float getBoundaryTop() {
        return this.boundaryY;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterX1() {
        return this.centerX1;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getCenterY1() {
        return this.centerY1;
    }

    public float getRadius() {
        return this.radius;
    }

    public int getStatus() {
        return this.status;
    }

    public void initPostion(float f, float f2) {
        setStatus(0);
        this.currentX = f;
        this.currentY = f2;
        Bitmap bitmap3 = this.bitmap[0];
        this.bitmap1 = bitmap3;
        this.centerX = ((float) (bitmap3.getWidth() / 2)) + this.currentX;
        this.centerY = ((float) (this.bitmap1.getHeight() / 2)) + this.currentY;
        this.centerX1 = ((float) (this.bitmap1.getWidth() / 2)) + this.currentX;
        float f3 = this.currentY;
        this.centerY1 = ((float) (this.bitmap1.getHeight() / 2)) + f3;
        float f4 = this.currentX;
        float f5 = this.radius;
        float f6 = this.radiusInner;
        this.boundaryX = (f4 + f5) - f6;
        this.boundaryY = (f3 + f5) - f6;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.status;
        if (i == 0) {
            Bitmap bitmap3 = this.bitmap1;
            float f = this.currentX;
            float f2 = this.radius;
            float f3 = this.radiusInner1;
            canvas.drawBitmap(bitmap3, (f + f2) - f3, (this.currentY + f2) - f3, this.paint);
        } else if (i == 1) {
            Bitmap bitmap4 = this.bitmap2;
            float f4 = this.currentX;
            float f5 = this.radius;
            float f6 = this.radiusInner;
            canvas.drawBitmap(bitmap4, (f4 + f5) - f6, (this.currentY + f5) - f6, this.paint);
        }
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
