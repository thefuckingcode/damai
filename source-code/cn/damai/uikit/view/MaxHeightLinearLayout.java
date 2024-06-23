package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$styleable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s50;

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
        if (AndroidInstantRuntime.support(ipChange, "-1337277467")) {
            ipChange.ipc$dispatch("-1337277467", new Object[]{this});
            return;
        }
        this.mMaxHeight = this.mMaxRatio * ((float) DisplayMetrics.getheightPixels(s50.b(getContext())));
        float a = (float) s50.a(getContext(), 125.0f);
        this.mMinHeight = a;
        float f = this.mMaxHeight;
        if (f >= a) {
            a = f;
        }
        this.mMaxHeight = a;
    }

    private void initAtts(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322420647")) {
            ipChange.ipc$dispatch("-322420647", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.mMaxRatio);
        if (obtainStyledAttributes != null) {
            this.mMaxRatio = obtainStyledAttributes.getFloat(R$styleable.mMaxRatio_linear_max_ratio, 0.75f);
            obtainStyledAttributes.recycle();
        }
    }

    public int getMaxHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-924063277")) {
            return (int) this.mMaxHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("-924063277", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046055434")) {
            ipChange.ipc$dispatch("-2046055434", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
