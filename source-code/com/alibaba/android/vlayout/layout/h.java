package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import tb.bk;
import tb.s61;

/* compiled from: Taobao */
public class h extends bk {
    public h() {
        setItemCount(1);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (!isOutOfRange(dVar.c())) {
            View l = dVar.l(recycler);
            boolean z = true;
            if (l == null) {
                s61.b = true;
                return;
            }
            layoutManagerHelper.addChildView(dVar, l);
            VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) l.getLayoutParams();
            int i7 = 0;
            boolean z2 = layoutManagerHelper.getOrientation() == 1;
            int contentWidth = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
            int contentHeight = (((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin()) - getVerticalPadding();
            if (!Float.isNaN(this.mAspectRatio)) {
                if (z2) {
                    contentHeight = (int) ((((float) contentWidth) / this.mAspectRatio) + 0.5f);
                } else {
                    contentWidth = (int) ((((float) contentHeight) * this.mAspectRatio) + 0.5f);
                }
            }
            if (z2) {
                int childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(contentWidth, Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : contentWidth, !z2 && Float.isNaN(this.mAspectRatio));
                int i8 = Float.isNaN(layoutParams.a) ? Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : contentHeight : (int) ((((float) contentWidth) / layoutParams.a) + 0.5f);
                if (!z2 || !Float.isNaN(this.mAspectRatio)) {
                    z = false;
                }
                layoutManagerHelper.measureChildWithMargins(l, childMeasureSpec, layoutManagerHelper.getChildMeasureSpec(contentHeight, i8, z));
            } else {
                int childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(contentWidth, Float.isNaN(layoutParams.a) ? Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : contentWidth : (int) ((((float) contentHeight) * layoutParams.a) + 0.5f), !z2 && Float.isNaN(this.mAspectRatio));
                int i9 = Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : contentHeight;
                if (!z2 || !Float.isNaN(this.mAspectRatio)) {
                    z = false;
                }
                layoutManagerHelper.measureChildWithMargins(l, childMeasureSpec2, layoutManagerHelper.getChildMeasureSpec(contentHeight, i9, z));
            }
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            s61.a = mainOrientationHelper.e(l);
            if (z2) {
                int f = contentWidth - mainOrientationHelper.f(l);
                if (f >= 0) {
                    i7 = f;
                }
                int i10 = i7 / 2;
                int paddingLeft = this.mMarginLeft + this.mPaddingLeft + layoutManagerHelper.getPaddingLeft() + i10;
                int contentWidth2 = (((layoutManagerHelper.getContentWidth() - this.mMarginRight) - this.mPaddingRight) - layoutManagerHelper.getPaddingRight()) - i10;
                if (dVar.f() == -1) {
                    i6 = (dVar.g() - this.mMarginBottom) - this.mPaddingBottom;
                    i5 = i6 - s61.a;
                } else {
                    i5 = this.mPaddingTop + dVar.g() + this.mMarginTop;
                    i6 = s61.a + i5;
                }
                i4 = paddingLeft;
                i = i6;
                i2 = contentWidth2;
                i3 = i5;
            } else {
                int f2 = contentHeight - mainOrientationHelper.f(l);
                if (f2 >= 0) {
                    i7 = f2;
                }
                int i11 = i7 / 2;
                int paddingTop = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop + i11;
                int contentHeight2 = (((layoutManagerHelper.getContentHeight() - (-this.mMarginBottom)) - this.mPaddingBottom) - layoutManagerHelper.getPaddingBottom()) - i11;
                if (dVar.f() == -1) {
                    int g = (dVar.g() - this.mMarginRight) - this.mPaddingRight;
                    i2 = g;
                    i4 = g - s61.a;
                } else {
                    int g2 = dVar.g() + this.mMarginLeft + this.mPaddingLeft;
                    i4 = g2;
                    i2 = s61.a + g2;
                }
                i = contentHeight2;
                i3 = paddingTop;
            }
            if (z2) {
                s61.a += getVerticalMargin() + getVerticalPadding();
            } else {
                s61.a += getHorizontalMargin() + getHorizontalPadding();
            }
            layoutChildWithMargin(l, i4, i3, i2, i, layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void setItemCount(int i) {
        if (i > 0) {
            super.setItemCount(1);
        } else {
            super.setItemCount(0);
        }
    }
}
