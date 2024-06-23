package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: Taobao */
public class RLScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;

    /* compiled from: Taobao */
    public interface OnScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public RLScrollView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedListener onScrollChangedListener2 = this.onScrollChangedListener;
        if (onScrollChangedListener2 != null) {
            onScrollChangedListener2.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setOnScrollListener(OnScrollChangedListener onScrollChangedListener2) {
        this.onScrollChangedListener = onScrollChangedListener2;
    }

    public RLScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RLScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
