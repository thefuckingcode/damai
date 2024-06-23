package com.taobao.weex.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public class ImageDrawable extends PaintDrawable {
    private float[] a;
    private int b;
    private int c;

    private ImageDrawable() {
    }

    @NonNull
    private static Matrix a(@NonNull ImageView.ScaleType scaleType, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        if (i3 * i2 > i4 * i) {
            f3 = ((float) i2) / ((float) i4);
            f2 = (((float) i) - (((float) i3) * f3)) * 0.5f;
            f = 0.0f;
        } else {
            f3 = ((float) i) / ((float) i3);
            f = (((float) i2) - (((float) i4) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        Matrix matrix = new Matrix();
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            matrix.setScale(((float) i) / ((float) i3), ((float) i2) / ((float) i4));
        } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) i3, (float) i4), new RectF(0.0f, 0.0f, (float) i, (float) i2), Matrix.ScaleToFit.CENTER);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            matrix.setScale(f3, f3);
            matrix.postTranslate(f2 + 0.5f, f + 0.5f);
        }
        return matrix;
    }

    private static void b(@NonNull ImageView.ScaleType scaleType, int i, int i2, ImageDrawable imageDrawable, BitmapShader bitmapShader) {
        Matrix a2 = a(scaleType, i, i2, imageDrawable.c, imageDrawable.b);
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) imageDrawable.c, (float) imageDrawable.b);
            RectF rectF2 = new RectF();
            a2.mapRect(rectF2, rectF);
            i = (int) rectF2.width();
            i2 = (int) rectF2.height();
            a2 = a(scaleType, i, i2, imageDrawable.c, imageDrawable.b);
        }
        imageDrawable.setIntrinsicWidth(i);
        imageDrawable.setIntrinsicHeight(i2);
        bitmapShader.setLocalMatrix(a2);
    }

    public static Drawable createImageDrawable(@Nullable Drawable drawable, @NonNull ImageView.ScaleType scaleType, @Nullable float[] fArr, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z && i > 0 && i2 > 0) {
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                ImageDrawable imageDrawable = new ImageDrawable();
                imageDrawable.getPaint().setFilterBitmap(true);
                imageDrawable.c = bitmap.getWidth();
                imageDrawable.b = bitmap.getHeight();
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                b(scaleType, i, i2, imageDrawable, bitmapShader);
                imageDrawable.getPaint().setShader(bitmapShader);
                return imageDrawable;
            } else if (drawable instanceof ImageDrawable) {
                ImageDrawable imageDrawable2 = (ImageDrawable) drawable;
                if (imageDrawable2.getPaint() != null && (imageDrawable2.getPaint().getShader() instanceof BitmapShader)) {
                    b(scaleType, i, i2, imageDrawable2, (BitmapShader) imageDrawable2.getPaint().getShader());
                    return imageDrawable2;
                }
            }
        }
        return drawable;
    }

    public int getBitmapHeight() {
        return this.b;
    }

    public int getBitmapWidth() {
        return this.c;
    }

    @Nullable
    public float[] getCornerRadii() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Shape shape, Canvas canvas, Paint paint) {
        if (Build.VERSION.SDK_INT == 21) {
            paint.setAntiAlias(false);
        }
        super.onDraw(shape, canvas, paint);
    }

    public void setCornerRadii(float[] fArr) {
        this.a = fArr;
        super.setCornerRadii(fArr);
    }
}
