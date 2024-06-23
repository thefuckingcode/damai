package com.taobao.android.dinamicx.view.richtext.span;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class CloneableUnderlineSpan extends UnderlineSpan implements PublicCloneable {
    private static final int UNDERLINE_WIDTH = 4;
    private int mColor = 0;

    public CloneableUnderlineSpan(int i) {
        this.mColor = i;
    }

    @Override // java.lang.Object, com.taobao.android.dinamicx.view.richtext.span.PublicCloneable
    @NonNull
    public Object clone() {
        return null;
    }

    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
    }
}
