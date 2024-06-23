package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$styleable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.u50;

/* compiled from: Taobao */
public class MaxHeightLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mMaxHeight;
    private float mMaxRatio = 0.75f;
    private float mMinHeight;

    public MaxHeightLinearLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1490804825")) {
            ipChange.ipc$dispatch("1490804825", new Object[]{this});
            return;
        }
        float f = this.mMaxRatio;
        u50 u50 = u50.INSTANCE;
        this.mMaxHeight = f * ((float) DisplayMetrics.getheightPixels(u50.d(getContext())));
        float b = (float) u50.b(getContext(), 125);
        this.mMinHeight = b;
        this.mMaxHeight = Math.max(this.mMaxHeight, b);
    }

    private void initAtts(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429297459")) {
            ipChange.ipc$dispatch("-429297459", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaxHeightLinearLayout);
        if (obtainStyledAttributes != null) {
            this.mMaxRatio = obtainStyledAttributes.getFloat(R$styleable.MaxHeightLinearLayout_linear_max_ratio, 0.75f);
            obtainStyledAttributes.recycle();
        }
    }

    public int getMaxHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-73182649")) {
            return (int) this.mMaxHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("-73182649", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78945022")) {
            ipChange.ipc$dispatch("-78945022", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            float f = this.mMaxHeight;
            if (((float) size) > f) {
                size = (int) f;
            }
        }
        if (mode == 0) {
            float f2 = this.mMaxHeight;
            if (((float) size) > f2) {
                size = (int) f2;
            }
        }
        if (mode == Integer.MIN_VALUE) {
            float f3 = this.mMaxHeight;
            if (((float) size) > f3) {
                size = (int) f3;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public MaxHeightLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initAtts(context, attributeSet);
        init();
    }

    public MaxHeightLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAtts(context, attributeSet);
        init();
    }
}
