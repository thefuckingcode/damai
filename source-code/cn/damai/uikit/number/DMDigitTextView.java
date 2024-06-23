package cn.damai.uikit.number;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public class DMDigitTextView extends TextView {
    public DMDigitTextView(Context context) {
        this(context, null);
    }

    public DMDigitTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMDigitTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTypeface(Typeface.createFromAsset(getContext().getApplicationContext().getAssets(), "damai_digit.otf"));
    }
}
