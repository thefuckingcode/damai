package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import tb.s61;

/* compiled from: Taobao */
public class c extends BaseLayoutHelper {
    private int a;
    private boolean b;

    public c() {
        this(0);
    }

    public void a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.a = i;
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        super.checkAnchorInfo(state, cVar, layoutManagerHelper);
        this.b = true;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        if (z) {
            if (i == getItemCount() - 1) {
                if (z3) {
                    i5 = this.mMarginBottom;
                    i4 = this.mPaddingBottom;
                } else {
                    i5 = this.mMarginRight;
                    i4 = this.mPaddingRight;
                }
                return i5 + i4;
            }
        } else if (i == 0) {
            if (z3) {
                i3 = -this.mMarginTop;
                i2 = this.mPaddingTop;
            } else {
                i3 = -this.mMarginLeft;
                i2 = this.mPaddingLeft;
            }
            return i3 - i2;
        }
        return super.computeAlignOffset(i, z, z2, layoutManagerHelper);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d0  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!isOutOfRange(dVar.c())) {
            int c = dVar.c();
            View nextView = nextView(recycler, dVar, layoutManagerHelper, s61);
            if (nextView != null) {
                boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
                VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) nextView.getLayoutParams();
                boolean z = layoutManagerHelper.getOrientation() == 1;
                boolean z2 = dVar.f() == 1;
                boolean z3 = !z2 ? c == getRange().e().intValue() : c == getRange().d().intValue();
                boolean z4 = !z2 ? c == getRange().d().intValue() : c == getRange().e().intValue();
                int computeStartSpace = z3 ? computeStartSpace(layoutManagerHelper, z, z2, isEnableMarginOverLap) : 0;
                int computeEndSpace = z4 ? computeEndSpace(layoutManagerHelper, z, z2, isEnableMarginOverLap) : 0;
                if (!z3) {
                    if (!isEnableMarginOverLap) {
                        if (!this.b) {
                            i = this.a;
                        }
                    } else if (z2) {
                        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        View findViewByPosition = layoutManagerHelper.findViewByPosition(c - 1);
                        int i10 = findViewByPosition != null ? ((ViewGroup.MarginLayoutParams) ((VirtualLayoutManager.LayoutParams) findViewByPosition.getLayoutParams())).bottomMargin : 0;
                        i = (i10 < 0 || i9 < 0) ? i10 + i9 : Math.max(i10, i9);
                    } else {
                        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        View findViewByPosition2 = layoutManagerHelper.findViewByPosition(c + 1);
                        int i12 = findViewByPosition2 != null ? ((ViewGroup.MarginLayoutParams) ((VirtualLayoutManager.LayoutParams) findViewByPosition2.getLayoutParams())).topMargin : 0;
                        i = (i11 < 0 || i12 < 0) ? i12 + i11 : Math.max(i11, i12);
                    }
                    int contentWidth = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
                    int childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(contentWidth, ((ViewGroup.MarginLayoutParams) layoutParams).width, !z);
                    f = layoutParams.a;
                    if (!Float.isNaN(f) || f <= 0.0f) {
                        if (!Float.isNaN(this.mAspectRatio)) {
                            float f2 = this.mAspectRatio;
                            if (f2 > 0.0f) {
                                i2 = View.MeasureSpec.makeMeasureSpec((int) (((double) (((float) contentWidth) / f2)) + 0.5d), 1073741824);
                            }
                        }
                        i2 = layoutManagerHelper.getChildMeasureSpec((((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin()) - getVerticalPadding(), ((ViewGroup.MarginLayoutParams) layoutParams).height, z);
                    } else {
                        i2 = View.MeasureSpec.makeMeasureSpec((int) ((((float) contentWidth) / f) + 0.5f), 1073741824);
                    }
                    if (isEnableMarginOverLap) {
                        layoutManagerHelper.measureChildWithMargins(nextView, childMeasureSpec, i2);
                    } else {
                        layoutManagerHelper.measureChild(nextView, childMeasureSpec, i2);
                    }
                    com.alibaba.android.vlayout.c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
                    s61.a = mainOrientationHelper.e(nextView) + computeStartSpace + computeEndSpace + i;
                    if (layoutManagerHelper.getOrientation() != 1) {
                        if (layoutManagerHelper.isDoLayoutRTL()) {
                            i8 = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight) - this.mPaddingRight;
                            i7 = i8 - mainOrientationHelper.f(nextView);
                        } else {
                            i7 = this.mPaddingLeft + layoutManagerHelper.getPaddingLeft() + this.mMarginLeft;
                            i8 = mainOrientationHelper.f(nextView) + i7;
                        }
                        if (dVar.f() == -1) {
                            int g = dVar.g() - computeStartSpace;
                            if (z3) {
                                i = 0;
                            }
                            int i13 = g - i;
                            i4 = i8;
                            i5 = i13 - mainOrientationHelper.e(nextView);
                            i3 = i13;
                            i6 = i7;
                        } else {
                            int g2 = dVar.g() + computeStartSpace;
                            if (z3) {
                                i = 0;
                            }
                            int i14 = g2 + i;
                            int e = mainOrientationHelper.e(nextView) + i14;
                            i4 = i8;
                            i5 = i14;
                            i6 = i7;
                            i3 = e;
                        }
                    } else {
                        i5 = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop;
                        i3 = mainOrientationHelper.f(nextView) + i5;
                        if (dVar.f() == -1) {
                            int g3 = dVar.g() - computeStartSpace;
                            if (z3) {
                                i = 0;
                            }
                            int i15 = g3 - i;
                            i4 = i15;
                            i6 = i15 - mainOrientationHelper.e(nextView);
                        } else {
                            int g4 = dVar.g() + computeStartSpace;
                            if (z3) {
                                i = 0;
                            }
                            i6 = g4 + i;
                            i4 = mainOrientationHelper.e(nextView) + i6;
                        }
                    }
                    layoutChildWithMargin(nextView, i6, i5, i4, i3, layoutManagerHelper);
                    handleStateOnResult(s61, nextView);
                    this.b = false;
                }
                i = 0;
                int contentWidth2 = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
                int childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(contentWidth2, ((ViewGroup.MarginLayoutParams) layoutParams).width, !z);
                f = layoutParams.a;
                if (!Float.isNaN(f)) {
                }
                if (!Float.isNaN(this.mAspectRatio)) {
                }
                i2 = layoutManagerHelper.getChildMeasureSpec((((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin()) - getVerticalPadding(), ((ViewGroup.MarginLayoutParams) layoutParams).height, z);
                if (isEnableMarginOverLap) {
                }
                com.alibaba.android.vlayout.c mainOrientationHelper2 = layoutManagerHelper.getMainOrientationHelper();
                s61.a = mainOrientationHelper2.e(nextView) + computeStartSpace + computeEndSpace + i;
                if (layoutManagerHelper.getOrientation() != 1) {
                }
                layoutChildWithMargin(nextView, i6, i5, i4, i3, layoutManagerHelper);
                handleStateOnResult(s61, nextView);
                this.b = false;
            }
        }
    }

    public c(int i) {
        this(i, 0);
    }

    public c(int i, int i2) {
        this.a = 0;
        this.b = false;
        setItemCount(i2);
        a(i);
    }
}
