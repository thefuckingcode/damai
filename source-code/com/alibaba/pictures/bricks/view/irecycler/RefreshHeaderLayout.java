package com.alibaba.pictures.bricks.view.irecycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RefreshHeaderLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public RefreshHeaderLayout(Context context) {
        this(context, null);
    }

    private void layoutChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630132303")) {
            ipChange.ipc$dispatch("-630132303", new Object[]{this});
            return;
        }
        getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i = paddingLeft + marginLayoutParams.leftMargin;
            int i2 = (paddingTop + marginLayoutParams.topMargin) - (measuredHeight2 - measuredHeight);
            childAt.layout(i, i2, measuredWidth + i, measuredHeight2 + i2);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1485580543")) {
            return new LayoutParams(-1, -1);
        }
        return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-1485580543", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "171953909")) {
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("171953909", new Object[]{this, layoutParams});
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471801187")) {
            ipChange.ipc$dispatch("471801187", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        layoutChildren();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1726987407")) {
            ipChange.ipc$dispatch("-1726987407", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (getChildCount() > 0) {
            measureChildWithMargins(getChildAt(0), i, 0, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        }
        super.onMeasure(i, i2);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "647448998")) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("647448998", new Object[]{this, attributeSet});
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
