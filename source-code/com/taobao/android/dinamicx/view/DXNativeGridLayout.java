package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: Taobao */
public class DXNativeGridLayout extends DXNativeFrameLayout {
    private float[] linePts;
    private boolean needSeparator;
    private Paint paint;

    public DXNativeGridLayout(@NonNull Context context) {
        super(context);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.needSeparator) {
            canvas.drawLines(this.linePts, this.paint);
        }
    }

    public void setLines(boolean z, @ColorInt int i, int i2, @Size(multiple = 4) float[] fArr) {
        this.needSeparator = z;
        if (!z) {
            return;
        }
        if (fArr == null || fArr.length == 0 || i2 == 0) {
            this.needSeparator = false;
            return;
        }
        if (this.paint == null) {
            this.paint = new Paint();
        }
        this.paint.setColor(i);
        this.paint.setStrokeWidth((float) i2);
        this.linePts = fArr;
    }

    public DXNativeGridLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public DXNativeGridLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }
}
