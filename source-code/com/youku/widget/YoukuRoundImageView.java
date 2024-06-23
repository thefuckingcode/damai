package com.youku.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: Taobao */
public class YoukuRoundImageView extends ImageView {
    private Bitmap bitmap;
    private Rect bitmapRect = new Rect();
    private Bitmap mDstB = null;
    private Paint paint = new Paint();
    private PaintFlagsDrawFilter pdf = new PaintFlagsDrawFilter(0, 3);
    private PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);

    public YoukuRoundImageView(Context context) {
        super(context);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        init();
    }

    private void init() {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap makeDst(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.parseColor("#ffffffff"));
        canvas.drawOval(new RectF(0.0f, 0.0f, (float) i, (float) i2), paint2);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.bitmap != null) {
            if (this.mDstB == null) {
                this.mDstB = makeDst(getWidth(), getHeight());
            }
            this.bitmapRect.set(0, 0, getWidth(), getHeight());
            canvas.save();
            canvas.setDrawFilter(this.pdf);
            canvas.drawBitmap(this.mDstB, 0.0f, 0.0f, this.paint);
            this.paint.setXfermode(this.xfermode);
            canvas.drawBitmap(this.bitmap, (Rect) null, this.bitmapRect, this.paint);
            this.paint.setXfermode(null);
            canvas.restore();
        }
    }

    public void setImageBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
    }

    public YoukuRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        init();
    }

    public YoukuRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        init();
    }
}
