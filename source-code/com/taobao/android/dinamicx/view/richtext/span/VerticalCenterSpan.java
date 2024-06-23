package com.taobao.android.dinamicx.view.richtext.span;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class VerticalCenterSpan extends CharacterStyle implements PublicCloneable {
    private int mLayoutBottom;
    private int mLayoutTop;
    private int mOffset;

    public VerticalCenterSpan(int i, int i2) {
        this.mLayoutTop = i;
        this.mLayoutBottom = i2;
    }

    @Override // java.lang.Object, com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        return new VerticalCenterSpan(this.mLayoutTop, this.mLayoutBottom);
    }

    public void updateDrawState(TextPaint textPaint) {
        int i = this.mLayoutBottom;
        int i2 = (((i - this.mLayoutTop) / 2) - i) + this.mOffset;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        textPaint.baselineShift = (int) ((((fontMetrics.descent - fontMetrics.ascent) / 2.0f) - fontMetrics.bottom) - ((float) i2));
    }

    public VerticalCenterSpan(int i, int i2, int i3) {
        this.mLayoutTop = i;
        this.mLayoutBottom = i2;
        this.mOffset = i3;
    }
}
