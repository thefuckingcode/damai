package com.alibaba.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.responsive.widget.size.OnResponsiveListener;
import tb.c12;
import tb.z02;

/* compiled from: Taobao */
public class ResponsiveRelativeLayout extends RelativeLayout {
    c12 responsiveSizeManager;

    public ResponsiveRelativeLayout(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        z02 e = this.responsiveSizeManager.e(i, i2);
        if (e.d() > 0) {
            i = View.MeasureSpec.makeMeasureSpec(e.d(), 1073741824);
        }
        if (e.c() > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(e.c(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setHGap(int i) {
        this.responsiveSizeManager.f(i);
        requestLayout();
    }

    public void setLayoutRatio(int i) {
        this.responsiveSizeManager.g(i);
        requestLayout();
    }

    public void setMargin(int i) {
        this.responsiveSizeManager.h(i);
        requestLayout();
    }

    public void setOnResponsiveListener(OnResponsiveListener onResponsiveListener) {
        this.responsiveSizeManager.i(onResponsiveListener);
    }

    public void setRatio(String str) {
        this.responsiveSizeManager.j(str);
        requestLayout();
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResponsiveRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c12 c12 = new c12(this);
        this.responsiveSizeManager = c12;
        c12.d(context, attributeSet);
    }
}
