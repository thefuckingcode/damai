package com.youku.miniplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: Taobao */
public class AlwaysMarqueeTextView extends TextView {
    public AlwaysMarqueeTextView(Context context) {
        super(context);
    }

    public boolean isFocused() {
        return true;
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
