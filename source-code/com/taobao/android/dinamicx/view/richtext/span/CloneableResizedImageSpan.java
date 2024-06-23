package com.taobao.android.dinamicx.view.richtext.span;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;

/* compiled from: Taobao */
public class CloneableResizedImageSpan extends DynamicDrawableSpan implements PublicCloneable {
    private int mAppendTransX;
    private int mAppendTransY;
    private Drawable mDefaultDrawable;
    private int mHeight;
    private Drawable mShowingDrawable;
    private int mWidth;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends Drawable {
        public a(int i, int i2) {
            setBounds(0, 0, i, i2);
        }

        public void draw(@NonNull Canvas canvas) {
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }

    public CloneableResizedImageSpan(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    private Drawable getDefaultDrawable() {
        if (this.mDefaultDrawable == null) {
            this.mDefaultDrawable = new a(this.mWidth, this.mHeight);
        }
        return this.mDefaultDrawable;
    }

    @Override // java.lang.Object, com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        CloneableResizedImageSpan cloneableResizedImageSpan = new CloneableResizedImageSpan(this.mWidth, this.mHeight);
        cloneableResizedImageSpan.mDefaultDrawable = this.mDefaultDrawable;
        cloneableResizedImageSpan.mShowingDrawable = this.mShowingDrawable;
        return cloneableResizedImageSpan;
    }

    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        int i6 = i5 - drawable.getBounds().bottom;
        int i7 = ((DynamicDrawableSpan) this).mVerticalAlignment;
        if (i7 == 1) {
            i6 -= paint.getFontMetricsInt().descent;
        } else if (i7 == 2) {
            i6 = ((i5 - i3) / 2) - (Rect.height(drawable.getBounds()) / 2);
        }
        canvas.translate(f + ((float) this.mAppendTransX), (float) (i6 + this.mAppendTransY));
        drawable.draw(canvas);
        canvas.restore();
    }

    public int getAppendTransX() {
        return this.mAppendTransX;
    }

    public int getAppendTransY() {
        return this.mAppendTransY;
    }

    public Drawable getDrawable() {
        Drawable drawable = this.mShowingDrawable;
        if (drawable == null) {
            return getDefaultDrawable();
        }
        this.mDefaultDrawable = null;
        return drawable;
    }

    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        android.graphics.Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            int i3 = -bounds.bottom;
            fontMetricsInt.ascent = i3;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i3;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }

    public void refreshDrawable(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, this.mWidth, this.mHeight, false));
        this.mShowingDrawable = bitmapDrawable;
        bitmapDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
    }

    public void setAppendTransX(int i) {
        this.mAppendTransX = i;
    }

    public void setAppendTransY(int i) {
        this.mAppendTransY = i;
    }
}
