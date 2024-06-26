package cn.damai.category.discountticket.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class HWRatioLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mHwRatio;

    public HWRatioLayout(@NonNull Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208592377")) {
            ipChange.ipc$dispatch("-1208592377", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mHwRatio != -1.0f) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
                i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.mHwRatio), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public HWRatioLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HWRatioLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HWRatioLayout);
        this.mHwRatio = obtainStyledAttributes.getFloat(R$styleable.HWRatioLayout_h_w_layout_ratio, -1.0f);
        obtainStyledAttributes.recycle();
    }
}
