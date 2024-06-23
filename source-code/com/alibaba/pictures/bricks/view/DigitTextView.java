package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.Nullable;
import tb.m40;

/* compiled from: Taobao */
public final class DigitTextView extends TextView {
    @JvmOverloads
    public DigitTextView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public DigitTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DigitTextView(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmOverloads
    public DigitTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTypeface(Typeface.createFromAsset(getContext().getApplicationContext().getAssets(), "damai_digit.otf"));
    }
}
