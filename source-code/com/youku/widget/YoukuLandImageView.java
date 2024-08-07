package com.youku.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.uikit.extend.feature.view.TUrlImageView;

/* compiled from: Taobao */
public class YoukuLandImageView extends TUrlImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 1;
    private int radius = 4;

    public YoukuLandImageView(Context context) {
        super(context);
    }

    private void drawDrawable(Canvas canvas, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        RectF rectF = new RectF(1.0f, 1.0f, (float) (getWidth() - 1), (float) (getHeight() - 1));
        int i = this.radius;
        canvas.drawRoundRect(rectF, (float) (i + 1), (float) (i + 1), paint);
        paint.setXfermode(porterDuffXfermode);
        Matrix matrix = new Matrix();
        matrix.postScale(((float) getWidth()) / ((float) bitmap.getWidth()), ((float) getHeight()) / ((float) bitmap.getHeight()));
        canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), 0.0f, 0.0f, paint);
        canvas.restore();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap;
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(1, 1, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            drawDrawable(canvas, getBitmapFromDrawable(drawable));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, (size * 1) / 3);
    }

    public YoukuLandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
