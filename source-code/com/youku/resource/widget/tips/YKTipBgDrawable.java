package com.youku.resource.widget.tips;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;

/* compiled from: Taobao */
public class YKTipBgDrawable extends Drawable {
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ARROW_DOWN = 1;
    public static final int ARROW_UP = 0;
    public static final int GRADIENT_LEFT_RIGHT = 1;
    public static final int GRADIENT_TOPLEFT_BOTTOMRIGHT = 2;
    public static final int GRADIENT_TOP_BOTTOM = 0;
    private final int mAlign;
    private final int mArrowHeight;
    private final int mEndColor;
    private final int mGradient;
    private final int mOffset;
    private final int mPositon;
    private final int mStartColor;

    public YKTipBgDrawable(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mPositon = i;
        this.mAlign = i2;
        this.mStartColor = i6;
        this.mEndColor = i7;
        this.mGradient = i5;
        this.mOffset = i3;
        this.mArrowHeight = i4;
    }

    public void draw(@NonNull Canvas canvas) {
        LinearGradient linearGradient;
        Path path = new Path();
        Paint paint = new Paint();
        int i = this.mGradient;
        if (i == 0) {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) Rect.height(getBounds()), this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        } else if (i == 1) {
            linearGradient = new LinearGradient(0.0f, 0.0f, (float) Rect.width(getBounds()), 0.0f, this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, (float) Rect.width(getBounds()), (float) Rect.height(getBounds()), this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        }
        paint.setShader(linearGradient);
        int i2 = this.mPositon;
        if (i2 == 0) {
            path.moveTo((float) (this.mArrowHeight / 2), 0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                path.addRoundRect((float) getBounds().left, 0.0f, (float) getBounds().right, (float) (getBounds().bottom - (this.mArrowHeight / 2)), 9999.0f, 9999.0f, Path.Direction.CW);
            } else {
                path.addRect((float) getBounds().left, 0.0f, (float) getBounds().right, (float) (getBounds().bottom - (this.mArrowHeight / 2)), Path.Direction.CW);
            }
            int i3 = this.mAlign;
            if (i3 == 1) {
                path.moveTo((float) (this.mOffset - (this.mArrowHeight / 2)), (float) (getBounds().bottom - (this.mArrowHeight / 2)));
                path.lineTo((float) (this.mOffset + (this.mArrowHeight / 2)), (float) (getBounds().bottom - (this.mArrowHeight / 2)));
                path.lineTo((float) this.mOffset, (float) getBounds().bottom);
            } else if (i3 == 2) {
                path.moveTo((float) ((Rect.width(getBounds()) - this.mOffset) - (this.mArrowHeight / 2)), (float) (getBounds().bottom - (this.mArrowHeight / 2)));
                path.lineTo((float) ((Rect.width(getBounds()) - this.mOffset) + (this.mArrowHeight / 2)), (float) (getBounds().bottom - (this.mArrowHeight / 2)));
                path.lineTo((float) (Rect.width(getBounds()) - this.mOffset), (float) getBounds().bottom);
            } else {
                path.moveTo((float) ((Rect.width(getBounds()) / 2) - (this.mArrowHeight / 2)), (float) (getBounds().bottom - (this.mArrowHeight / 2)));
                path.lineTo((float) ((Rect.width(getBounds()) / 2) + (this.mArrowHeight / 2)), (float) (getBounds().bottom - (this.mArrowHeight / 2)));
                path.lineTo((float) (Rect.width(getBounds()) / 2), (float) getBounds().bottom);
            }
        } else if (i2 == 1) {
            int i4 = this.mAlign;
            if (i4 == 1) {
                path.moveTo((float) this.mOffset, 0.0f);
                int i5 = this.mOffset;
                int i6 = this.mArrowHeight;
                path.lineTo((float) (i5 - (i6 / 2)), (float) (i6 / 2));
                int i7 = this.mOffset;
                int i8 = this.mArrowHeight;
                path.lineTo((float) (i7 + (i8 / 2)), (float) (i8 / 2));
            } else if (i4 == 2) {
                path.moveTo((float) (Rect.width(getBounds()) - this.mOffset), 0.0f);
                int width = Rect.width(getBounds()) - this.mOffset;
                int i9 = this.mArrowHeight;
                path.lineTo((float) (width - (i9 / 2)), (float) (i9 / 2));
                int width2 = Rect.width(getBounds()) - this.mOffset;
                int i10 = this.mArrowHeight;
                path.lineTo((float) (width2 + (i10 / 2)), (float) (i10 / 2));
            } else {
                path.moveTo((float) (Rect.width(getBounds()) / 2), 0.0f);
                int i11 = this.mArrowHeight;
                path.lineTo((float) ((Rect.width(getBounds()) / 2) - (i11 / 2)), (float) (i11 / 2));
                int i12 = this.mArrowHeight;
                path.lineTo((float) ((Rect.width(getBounds()) / 2) + (i12 / 2)), (float) (i12 / 2));
            }
            path.moveTo((float) (this.mArrowHeight / 2), 0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                path.addRoundRect((float) getBounds().left, (float) (this.mArrowHeight / 2), (float) getBounds().right, (float) getBounds().bottom, 9999.0f, 9999.0f, Path.Direction.CW);
            } else {
                path.addRect((float) getBounds().left, (float) (this.mArrowHeight / 2), (float) getBounds().right, (float) getBounds().bottom, Path.Direction.CW);
            }
        }
        canvas.drawPath(path, paint);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
