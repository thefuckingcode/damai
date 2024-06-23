package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import java.util.Arrays;
import tb.p1;
import tb.s61;

/* compiled from: Taobao */
public class e extends p1 {
    private Rect d = new Rect();
    private View[] e;
    private float[] f = new float[0];
    private float g = Float.NaN;

    public e() {
        setItemCount(0);
    }

    private float f(int i) {
        float[] fArr = this.f;
        if (fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }

    private int g(VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper, boolean z, int i, int i2, int i3, int i4) {
        c cVar;
        View view;
        int i5;
        VirtualLayoutManager.LayoutParams layoutParams;
        int i6;
        View view2;
        View view3;
        int i7;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View view4 = this.e[0];
        VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
        View view5 = layoutManagerHelper.getReverseLayout() ? this.e[6] : this.e[1];
        VirtualLayoutManager.LayoutParams layoutParams3 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
        View view6 = layoutManagerHelper.getReverseLayout() ? this.e[5] : this.e[2];
        VirtualLayoutManager.LayoutParams layoutParams4 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
        View view7 = layoutManagerHelper.getReverseLayout() ? this.e[4] : this.e[3];
        VirtualLayoutManager.LayoutParams layoutParams5 = (VirtualLayoutManager.LayoutParams) view7.getLayoutParams();
        boolean reverseLayout = layoutManagerHelper.getReverseLayout();
        View[] viewArr = this.e;
        View view8 = reverseLayout ? viewArr[3] : viewArr[4];
        VirtualLayoutManager.LayoutParams layoutParams6 = (VirtualLayoutManager.LayoutParams) view8.getLayoutParams();
        boolean reverseLayout2 = layoutManagerHelper.getReverseLayout();
        View[] viewArr2 = this.e;
        View view9 = reverseLayout2 ? viewArr2[2] : viewArr2[5];
        VirtualLayoutManager.LayoutParams layoutParams7 = (VirtualLayoutManager.LayoutParams) view9.getLayoutParams();
        if (layoutManagerHelper.getReverseLayout()) {
            cVar = mainOrientationHelper;
            view = this.e[1];
        } else {
            cVar = mainOrientationHelper;
            view = this.e[6];
        }
        VirtualLayoutManager.LayoutParams layoutParams8 = (VirtualLayoutManager.LayoutParams) view.getLayoutParams();
        float f2 = f(0);
        float f3 = f(1);
        float f4 = f(2);
        float f5 = f(3);
        float f6 = f(4);
        float f7 = f(5);
        float f8 = f(6);
        if (z) {
            if (!Float.isNaN(this.mAspectRatio)) {
                layoutParams = layoutParams6;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (((float) (i - i3)) / this.mAspectRatio);
            } else {
                layoutParams = layoutParams6;
            }
            int i8 = ((((((i - i3) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            int i9 = (int) ((Float.isNaN(f2) ? ((float) i8) / 3.0f : (((float) i8) * f2) / 100.0f) + 0.5f);
            if (Float.isNaN(f3)) {
                i6 = (i8 - i9) / 2;
                view2 = view7;
            } else {
                view2 = view7;
                i6 = (int) (((((float) i8) * f3) / 100.0f) + 0.5f);
            }
            if (Float.isNaN(f4)) {
                view3 = view6;
                i7 = i6;
            } else {
                view3 = view6;
                i7 = (int) (((double) ((((float) i8) * f4) / 100.0f)) + 0.5d);
            }
            int i10 = Float.isNaN(f5) ? i6 : (int) (((((float) i8) * f5) / 100.0f) + 0.5f);
            int i11 = Float.isNaN(f6) ? i6 : (int) (((((float) i8) * f6) / 100.0f) + 0.5f);
            int i12 = Float.isNaN(f7) ? i6 : (int) (((((float) i8) * f7) / 100.0f) + 0.5f);
            int i13 = Float.isNaN(f7) ? i6 : (int) (((((float) i8) * f8) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view4, View.MeasureSpec.makeMeasureSpec(i9 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, 1073741824), layoutManagerHelper.getChildMeasureSpec(layoutManagerHelper.getContentHeight(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
            int measuredHeight = view4.getMeasuredHeight();
            int i14 = (int) ((Float.isNaN(this.g) ? ((float) ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin)) / 3.0f : (((float) ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin)) * this.g) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view5, View.MeasureSpec.makeMeasureSpec(i6 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view3, View.MeasureSpec.makeMeasureSpec(i7 + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view2, View.MeasureSpec.makeMeasureSpec(i10 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view8, View.MeasureSpec.makeMeasureSpec(i11 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view9, View.MeasureSpec.makeMeasureSpec(i12 + ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view, View.MeasureSpec.makeMeasureSpec(i13 + ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin, 1073741824));
            int max = Math.max(measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, Math.max(((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) + Math.max(((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + Math.max(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, i14 + ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin)) + getVerticalMargin() + getVerticalPadding();
            a((max - getVerticalMargin()) - getVerticalPadding(), this.d, dVar, layoutManagerHelper);
            int f9 = this.d.left + cVar.f(view4);
            Rect rect = this.d;
            layoutChildWithMargin(view4, rect.left, rect.top, f9, rect.bottom, layoutManagerHelper);
            int f10 = f9 + cVar.f(view5);
            int i15 = this.d.top;
            layoutChildWithMargin(view5, f9, i15, f10, i15 + cVar.e(view5), layoutManagerHelper);
            int f11 = f10 + cVar.f(view3);
            int i16 = this.d.top;
            layoutChildWithMargin(view3, f10, i16, f11, i16 + cVar.e(view3), layoutManagerHelper);
            int f12 = f9 + cVar.f(view2);
            layoutChildWithMargin(view2, f9, this.d.top + cVar.e(view5), f12, this.d.bottom - cVar.e(view9), layoutManagerHelper);
            layoutChildWithMargin(view8, f12, this.d.top + cVar.e(view5), f12 + cVar.f(view8), this.d.bottom - cVar.e(view), layoutManagerHelper);
            int f13 = f9 + cVar.f(view9);
            layoutChildWithMargin(view9, f9, this.d.bottom - cVar.e(view9), f13, this.d.bottom, layoutManagerHelper);
            layoutChildWithMargin(view, f13, this.d.bottom - cVar.e(view), f13 + cVar.f(view), this.d.bottom, layoutManagerHelper);
            i5 = max;
        } else {
            i5 = 0;
        }
        handleStateOnResult(s61, this.e);
        return i5;
    }

    private int h(VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper, boolean z, int i, int i2, int i3, int i4) {
        e eVar;
        int i5;
        View view;
        View view2;
        int i6;
        int i7;
        VirtualLayoutManager.LayoutParams layoutParams;
        int i8;
        VirtualLayoutManager.LayoutParams layoutParams2;
        float f2;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View view3 = this.e[0];
        VirtualLayoutManager.LayoutParams layoutParams3 = (VirtualLayoutManager.LayoutParams) view3.getLayoutParams();
        View view4 = layoutManagerHelper.getReverseLayout() ? this.e[5] : this.e[1];
        VirtualLayoutManager.LayoutParams layoutParams4 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
        View view5 = layoutManagerHelper.getReverseLayout() ? this.e[4] : this.e[2];
        VirtualLayoutManager.LayoutParams layoutParams5 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
        View view6 = layoutManagerHelper.getReverseLayout() ? this.e[3] : this.e[3];
        VirtualLayoutManager.LayoutParams layoutParams6 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
        boolean reverseLayout = layoutManagerHelper.getReverseLayout();
        View[] viewArr = this.e;
        View view7 = reverseLayout ? viewArr[2] : viewArr[4];
        VirtualLayoutManager.LayoutParams layoutParams7 = (VirtualLayoutManager.LayoutParams) view7.getLayoutParams();
        boolean reverseLayout2 = layoutManagerHelper.getReverseLayout();
        View[] viewArr2 = this.e;
        View view8 = reverseLayout2 ? viewArr2[1] : viewArr2[5];
        VirtualLayoutManager.LayoutParams layoutParams8 = (VirtualLayoutManager.LayoutParams) view8.getLayoutParams();
        float f3 = f(0);
        float f4 = f(1);
        float f5 = f(2);
        float f6 = f(3);
        float f7 = f(4);
        float f8 = f(5);
        if (z) {
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = i9;
            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = i9;
            ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            if (!Float.isNaN(this.mAspectRatio)) {
                view = view6;
                ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) (((float) (i - i3)) / this.mAspectRatio);
            } else {
                view = view6;
            }
            int i10 = i - i3;
            int i11 = (((i10 - ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            int i12 = (int) ((Float.isNaN(f3) ? ((float) i11) / 2.0f : (((float) i11) * f3) / 100.0f) + 0.5f);
            if (Float.isNaN(f4)) {
                view2 = view4;
                i6 = i11 - i12;
            } else {
                view2 = view4;
                i6 = (int) (((((float) i11) * f4) / 100.0f) + 0.5f);
            }
            if (Float.isNaN(f5)) {
                layoutParams = layoutParams5;
                i7 = i6;
                i8 = i7;
            } else {
                i7 = i6;
                layoutParams = layoutParams5;
                i8 = (int) (((double) ((((float) i11) * f5) / 100.0f)) + 0.5d);
            }
            int i13 = (int) ((Float.isNaN(f6) ? ((float) ((((((i10 - ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin)) / 3.0f : (((float) i11) * f6) / 100.0f) + 0.5f);
            int i14 = Float.isNaN(f7) ? i13 : (int) (((((float) i11) * f7) / 100.0f) + 0.5f);
            int i15 = Float.isNaN(f8) ? i13 : (int) (((((float) i11) * f8) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view3, View.MeasureSpec.makeMeasureSpec(i12 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, 1073741824), layoutManagerHelper.getChildMeasureSpec(layoutManagerHelper.getContentHeight(), ((ViewGroup.MarginLayoutParams) layoutParams3).height, true));
            int measuredHeight = view3.getMeasuredHeight();
            if (Float.isNaN(this.g)) {
                layoutParams2 = layoutParams;
                f2 = ((float) ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin)) / 2.0f;
            } else {
                layoutParams2 = layoutParams;
                f2 = (((float) ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin)) * this.g) / 100.0f;
            }
            int i16 = (int) (f2 + 0.5f);
            int i17 = ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - i16;
            layoutManagerHelper.measureChildWithMargins(view2, View.MeasureSpec.makeMeasureSpec(i7 + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i16 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view5, View.MeasureSpec.makeMeasureSpec(i8 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view, View.MeasureSpec.makeMeasureSpec(i13 + ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view7, View.MeasureSpec.makeMeasureSpec(i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view8, View.MeasureSpec.makeMeasureSpec(i15 + ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin, 1073741824));
            int max = Math.max(measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, (i16 + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) * 2) + Math.max(((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin, Math.max(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, i17 + ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin)) + getVerticalMargin() + getVerticalPadding();
            eVar = this;
            eVar.a((max - getVerticalMargin()) - getVerticalPadding(), eVar.d, dVar, layoutManagerHelper);
            int f9 = eVar.d.left + mainOrientationHelper.f(view3);
            Rect rect = eVar.d;
            layoutChildWithMargin(view3, rect.left, rect.top, f9, rect.bottom - mainOrientationHelper.e(view), layoutManagerHelper);
            int f10 = f9 + mainOrientationHelper.f(view2);
            int i18 = eVar.d.top;
            layoutChildWithMargin(view2, f9, i18, f10, i18 + mainOrientationHelper.e(view2), layoutManagerHelper);
            layoutChildWithMargin(view5, f9, eVar.d.top + mainOrientationHelper.e(view5), f9 + mainOrientationHelper.f(view5), eVar.d.bottom - mainOrientationHelper.e(view), layoutManagerHelper);
            int f11 = eVar.d.left + mainOrientationHelper.f(view);
            Rect rect2 = eVar.d;
            layoutChildWithMargin(view, rect2.left, rect2.bottom - mainOrientationHelper.e(view), f11, eVar.d.bottom, layoutManagerHelper);
            int f12 = f11 + mainOrientationHelper.f(view7);
            layoutChildWithMargin(view7, f11, eVar.d.bottom - mainOrientationHelper.e(view7), f12, eVar.d.bottom, layoutManagerHelper);
            layoutChildWithMargin(view8, f12, eVar.d.bottom - mainOrientationHelper.e(view8), f12 + mainOrientationHelper.f(view8), eVar.d.bottom, layoutManagerHelper);
            i5 = max;
        } else {
            eVar = this;
            i5 = 0;
        }
        eVar.handleStateOnResult(s61, eVar.e);
        return i5;
    }

    private int i(VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper, boolean z, int i, int i2, int i3, int i4) {
        e eVar;
        int i5;
        c cVar;
        View view;
        int i6;
        VirtualLayoutManager.LayoutParams layoutParams;
        int i7;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View view2 = this.e[0];
        VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view2.getLayoutParams();
        View view3 = layoutManagerHelper.getReverseLayout() ? this.e[4] : this.e[1];
        VirtualLayoutManager.LayoutParams layoutParams3 = (VirtualLayoutManager.LayoutParams) view3.getLayoutParams();
        View view4 = layoutManagerHelper.getReverseLayout() ? this.e[3] : this.e[2];
        VirtualLayoutManager.LayoutParams layoutParams4 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
        View view5 = layoutManagerHelper.getReverseLayout() ? this.e[2] : this.e[3];
        VirtualLayoutManager.LayoutParams layoutParams5 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
        boolean reverseLayout = layoutManagerHelper.getReverseLayout();
        View[] viewArr = this.e;
        View view6 = reverseLayout ? viewArr[1] : viewArr[4];
        VirtualLayoutManager.LayoutParams layoutParams6 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
        float f2 = f(0);
        float f3 = f(1);
        float f4 = f(2);
        float f5 = f(3);
        float f6 = f(4);
        if (z) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = i8;
            ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i8;
            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            if (!Float.isNaN(this.mAspectRatio)) {
                cVar = mainOrientationHelper;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (((float) (i - i3)) / this.mAspectRatio);
            } else {
                cVar = mainOrientationHelper;
            }
            int i9 = ((((((i - i3) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            int i10 = (int) ((Float.isNaN(f2) ? ((float) i9) / 3.0f : (((float) i9) * f2) / 100.0f) + 0.5f);
            if (Float.isNaN(f3)) {
                i6 = (i9 - i10) / 2;
                view = view6;
            } else {
                view = view6;
                i6 = (int) (((((float) i9) * f3) / 100.0f) + 0.5f);
            }
            int i11 = Float.isNaN(f4) ? i6 : (int) (((((float) i9) * f4) / 100.0f) + 0.5f);
            if (Float.isNaN(f5)) {
                layoutParams = layoutParams6;
                i7 = i6;
            } else {
                layoutParams = layoutParams6;
                i7 = (int) (((((float) i9) * f5) / 100.0f) + 0.5f);
            }
            int i12 = Float.isNaN(f6) ? i6 : (int) (((((float) i9) * f6) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view2, View.MeasureSpec.makeMeasureSpec(i10 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, 1073741824), layoutManagerHelper.getChildMeasureSpec(layoutManagerHelper.getContentHeight(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
            int measuredHeight = view2.getMeasuredHeight();
            int i13 = (int) ((Float.isNaN(this.g) ? ((float) ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin)) / 2.0f : (((float) ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin)) * this.g) / 100.0f) + 0.5f);
            int i14 = ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin) - i13;
            layoutManagerHelper.measureChildWithMargins(view3, View.MeasureSpec.makeMeasureSpec(i6 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i13 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view4, View.MeasureSpec.makeMeasureSpec(i11 + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view5, View.MeasureSpec.makeMeasureSpec(i7 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view, View.MeasureSpec.makeMeasureSpec(i12 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
            int max = Math.max(measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, i13 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + Math.max(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin)) + getVerticalMargin() + getVerticalPadding();
            eVar = this;
            eVar.a((max - getVerticalMargin()) - getVerticalPadding(), eVar.d, dVar, layoutManagerHelper);
            int f7 = eVar.d.left + cVar.f(view2);
            Rect rect = eVar.d;
            layoutChildWithMargin(view2, rect.left, rect.top, f7, rect.bottom, layoutManagerHelper);
            int f8 = f7 + cVar.f(view3);
            int i15 = eVar.d.top;
            layoutChildWithMargin(view3, f7, i15, f8, i15 + cVar.e(view3), layoutManagerHelper);
            int f9 = f8 + cVar.f(view4);
            int i16 = eVar.d.top;
            layoutChildWithMargin(view4, f8, i16, f9, i16 + cVar.e(view4), layoutManagerHelper);
            int f10 = f7 + cVar.f(view5);
            layoutChildWithMargin(view5, f7, eVar.d.bottom - cVar.e(view5), f10, eVar.d.bottom, layoutManagerHelper);
            layoutChildWithMargin(view, f10, eVar.d.bottom - cVar.e(view), f10 + cVar.f(view), eVar.d.bottom, layoutManagerHelper);
            i5 = max;
        } else {
            eVar = this;
            i5 = 0;
        }
        eVar.handleStateOnResult(s61, eVar.e);
        return i5;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a, tb.p1
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (getItemCount() == 3) {
            if (i == 1 && z) {
                Log.w("OnePlusNLayoutHelper", "Should not happen after adjust anchor");
                return 0;
            }
        } else if (getItemCount() == 4 && i == 1 && z) {
            return 0;
        }
        if (layoutManagerHelper.getOrientation() == 1) {
            if (z) {
                return this.mMarginBottom + this.mPaddingBottom;
            }
            return (-this.mMarginTop) - this.mPaddingTop;
        } else if (z) {
            return this.mMarginRight + this.mPaddingRight;
        } else {
            return (-this.mMarginLeft) - this.mPaddingLeft;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        if (!isOutOfRange(dVar.c())) {
            View[] viewArr = this.e;
            if (viewArr == null || viewArr.length != getItemCount()) {
                this.e = new View[getItemCount()];
            }
            int e2 = e(this.e, recycler, dVar, s61, layoutManagerHelper);
            if (e2 != getItemCount()) {
                Log.w("OnePlusNLayoutHelper", "The real number of children is not match with range of LayoutHelper");
            }
            int i = 0;
            boolean z = layoutManagerHelper.getOrientation() == 1;
            int contentWidth = layoutManagerHelper.getContentWidth();
            int contentHeight = layoutManagerHelper.getContentHeight();
            int paddingLeft = layoutManagerHelper.getPaddingLeft() + layoutManagerHelper.getPaddingRight() + getHorizontalMargin() + getHorizontalPadding();
            int paddingTop = layoutManagerHelper.getPaddingTop() + layoutManagerHelper.getPaddingBottom() + getVerticalMargin() + getVerticalPadding();
            if (e2 == 5) {
                i = i(dVar, s61, layoutManagerHelper, z, contentWidth, contentHeight, paddingLeft, paddingTop);
            } else if (e2 == 6) {
                i = h(dVar, s61, layoutManagerHelper, z, contentWidth, contentHeight, paddingLeft, paddingTop);
            } else if (e2 == 7) {
                i = g(dVar, s61, layoutManagerHelper, z, contentWidth, contentHeight, paddingLeft, paddingTop);
            }
            s61.a = i;
            Arrays.fill(this.e, (Object) null);
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 4) {
            throw new IllegalArgumentException("pls use OnePlusNLayoutHelper instead of OnePlusNLayoutHelperEx which childcount <= 5");
        } else if (i3 > 6) {
            throw new IllegalArgumentException("OnePlusNLayoutHelper only supports maximum 7 children now");
        }
    }
}
