package com.alibaba.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.responsive.widget.size.OnResponsiveListener;
import tb.f12;
import tb.z02;

/* compiled from: Taobao */
public class ResponsiveRecyclerView extends RecyclerView {
    private OnResponsiveListener mOnResponsiveListener;
    private z02 responsiveSize;

    public ResponsiveRecyclerView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onMeasure(int i, int i2) {
        int defaultSize = ViewGroup.getDefaultSize(0, i);
        int defaultSize2 = ViewGroup.getDefaultSize(0, i2);
        if (!(defaultSize == getMeasuredWidth() || this.mOnResponsiveListener == null)) {
            if (this.responsiveSize == null) {
                this.responsiveSize = new z02();
            }
            this.responsiveSize.h(defaultSize);
            this.responsiveSize.g(defaultSize2);
            this.responsiveSize.f(f12.d(getContext()));
            this.responsiveSize.e(f12.c(getContext()));
            this.mOnResponsiveListener.onResponsive(this.responsiveSize);
        }
        super.onMeasure(i, i2);
    }

    public void setOnResponsiveListener(OnResponsiveListener onResponsiveListener) {
        this.mOnResponsiveListener = onResponsiveListener;
    }

    public ResponsiveRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResponsiveRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
