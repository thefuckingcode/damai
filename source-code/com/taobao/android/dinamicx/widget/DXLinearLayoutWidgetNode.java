package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.view.DXNativeLinearLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.be;
import tb.py;

/* compiled from: Taobao */
public class DXLinearLayoutWidgetNode extends f implements Cloneable {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int mOrientation;
    int mTotalLength;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXLinearLayoutWidgetNode();
        }
    }

    private void setChildFrame(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4) {
        dXWidgetNode.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXLinearLayoutWidgetNode();
    }

    /* access modifiers changed from: protected */
    public void forceUniformHeight(int i, int i2) {
        int c = DXWidgetNode.DXMeasureSpec.c(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i3);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 2 || virtualChildAt.layoutHeight != -1)) {
                int i4 = virtualChildAt.layoutWidth;
                virtualChildAt.layoutWidth = virtualChildAt.getMeasuredWidth();
                measureChildWithMargins(virtualChildAt, i2, 0, c, 0);
                virtualChildAt.layoutWidth = i4;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void forceUniformWidth(int i, int i2) {
        int c = DXWidgetNode.DXMeasureSpec.c(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i3);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 2 || virtualChildAt.layoutWidth != -1)) {
                int i4 = virtualChildAt.layoutHeight;
                virtualChildAt.layoutHeight = virtualChildAt.getMeasuredHeight();
                measureChildWithMargins(virtualChildAt, c, 0, i2, 0);
                virtualChildAt.layoutHeight = i4;
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public ViewGroup.LayoutParams generateLayoutParams(py pyVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pyVar.a, pyVar.b);
        layoutParams.gravity = pyVar.d;
        return layoutParams;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(DXWidgetNode dXWidgetNode, int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(DXWidgetNode dXWidgetNode) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    /* access modifiers changed from: package-private */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean isLayoutRtl = isLayoutRtl();
        int i12 = this.paddingTop;
        int i13 = i4 - i2;
        int i14 = this.paddingBottom;
        int i15 = i13 - i14;
        int i16 = (i13 - i12) - i14;
        int virtualChildCount = getVirtualChildCount();
        int i17 = 2;
        switch (DXWidgetNode.getAbsoluteGravity(this.childGravity, getDirection())) {
            case 3:
            case 4:
            case 5:
                i5 = getPaddingLeftWithDirection() + (((i3 - i) - this.mTotalLength) / 2);
                break;
            case 6:
            case 7:
            case 8:
                i5 = ((getPaddingLeftWithDirection() + i3) - i) - this.mTotalLength;
                break;
            default:
                i5 = getPaddingLeftWithDirection();
                break;
        }
        if (isLayoutRtl) {
            i7 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i7 = 0;
            i6 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i7 + (i6 * i18);
            DXWidgetNode virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i19);
            } else if (virtualChildAt.getVisibility() != i17) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                int i20 = virtualChildAt.layoutGravity;
                if ((virtualChildAt.propertyInitFlag & 1) == 0 && i20 == 0) {
                    i20 = this.childGravity;
                }
                switch (i20) {
                    case 0:
                    case 3:
                    case 6:
                        i9 = virtualChildAt.marginTop + i12;
                        i8 = i9;
                        break;
                    case 1:
                    case 4:
                    case 7:
                        i11 = ((i16 - measuredHeight) / i17) + i12 + virtualChildAt.marginTop;
                        i10 = virtualChildAt.marginBottom;
                        i9 = i11 - i10;
                        i8 = i9;
                        break;
                    case 2:
                    case 5:
                    case 8:
                        i11 = i15 - measuredHeight;
                        i10 = virtualChildAt.marginBottom;
                        i9 = i11 - i10;
                        i8 = i9;
                        break;
                    default:
                        i8 = i12;
                        break;
                }
                int leftMarginWithDirection = i5 + virtualChildAt.getLeftMarginWithDirection();
                setChildFrame(virtualChildAt, leftMarginWithDirection + getLocationOffset(virtualChildAt), i8, measuredWidth, measuredHeight);
                i18 += getChildrenSkipCount(virtualChildAt, i19);
                i5 = leftMarginWithDirection + measuredWidth + virtualChildAt.getRightMarginWithDirection() + getNextLocationOffset(virtualChildAt);
            }
            i18++;
            i17 = 2;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int direction = getDirection();
        int i10 = i3 - i;
        int paddingRightWithDirection = i10 - getPaddingRightWithDirection();
        int paddingLeftWithDirection = (i10 - getPaddingLeftWithDirection()) - getPaddingRightWithDirection();
        int virtualChildCount = getVirtualChildCount();
        int i11 = this.childGravity;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 4) {
                    if (i11 != 5) {
                        if (i11 != 7) {
                            if (i11 != 8) {
                                i5 = this.paddingTop;
                                i6 = 0;
                                while (i6 < virtualChildCount) {
                                    DXWidgetNode virtualChildAt = getVirtualChildAt(i6);
                                    if (virtualChildAt == null) {
                                        i5 += measureNullChild(i6);
                                    } else if (virtualChildAt.getVisibility() != 2) {
                                        int measuredWidth = virtualChildAt.getMeasuredWidth();
                                        int measuredHeight = virtualChildAt.getMeasuredHeight();
                                        int i12 = virtualChildAt.layoutGravity;
                                        if ((virtualChildAt.propertyInitFlag & 1) == 0 && i12 == 0) {
                                            i12 = this.childGravity;
                                        }
                                        switch (DXWidgetNode.getAbsoluteGravity(i12, direction)) {
                                            case 3:
                                            case 4:
                                            case 5:
                                                i8 = getPaddingLeftWithDirection() + ((paddingLeftWithDirection - measuredWidth) / 2) + virtualChildAt.getLeftMarginWithDirection();
                                                i7 = virtualChildAt.getRightMarginWithDirection();
                                                i9 = i8 - i7;
                                                break;
                                            case 6:
                                            case 7:
                                            case 8:
                                                i8 = paddingRightWithDirection - measuredWidth;
                                                i7 = virtualChildAt.getRightMarginWithDirection();
                                                i9 = i8 - i7;
                                                break;
                                            default:
                                                i9 = getPaddingLeftWithDirection() + virtualChildAt.getLeftMarginWithDirection();
                                                break;
                                        }
                                        int i13 = i5 + virtualChildAt.marginTop;
                                        setChildFrame(virtualChildAt, i9, i13 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                                        i6 += getChildrenSkipCount(virtualChildAt, i6);
                                        i5 = i13 + measuredHeight + virtualChildAt.marginBottom + getNextLocationOffset(virtualChildAt);
                                    }
                                    i6++;
                                }
                            }
                        }
                    }
                }
            }
            i5 = ((this.paddingTop + i4) - i2) - this.mTotalLength;
            i6 = 0;
            while (i6 < virtualChildCount) {
            }
        }
        i5 = this.paddingTop + (((i4 - i2) - this.mTotalLength) / 2);
        i6 = 0;
        while (i6 < virtualChildCount) {
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(dXWidgetNode, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012b  */
    public void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        DXWidgetNode dXWidgetNode;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        float f;
        int i13;
        int i14;
        boolean z2;
        int max;
        int i15;
        int i16;
        int i17;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int a2 = DXWidgetNode.DXMeasureSpec.a(i);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i2);
        boolean z3 = a2 == 1073741824;
        float f2 = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            i3 = 2;
            if (i21 >= virtualChildCount) {
                break;
            }
            DXWidgetNode virtualChildAt = getVirtualChildAt(i21);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i21);
            } else if (virtualChildAt.getVisibility() == 2) {
                i21 += getChildrenSkipCount(virtualChildAt, i21);
            } else {
                i9 = virtualChildCount;
                double d = virtualChildAt.weight;
                float f3 = (float) (((double) f2) + d);
                if (d > 0.0d) {
                    virtualChildAt.layoutWidth = 0;
                }
                boolean z7 = virtualChildAt.layoutWidth == 0 && d > 0.0d;
                if (a2 != 1073741824 || !z7) {
                    if (z7) {
                        virtualChildAt.layoutWidth = -2;
                    }
                    f = f3;
                    i12 = i18;
                    i11 = i19;
                    i13 = i20;
                    i10 = i21;
                    measureChildBeforeLayout(virtualChildAt, i21, i, f3 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        virtualChildAt.layoutWidth = 0;
                        i22 += measuredWidth;
                    }
                    if (z3) {
                        this.mTotalLength += measuredWidth + virtualChildAt.marginLeft + virtualChildAt.marginRight + getNextLocationOffset(virtualChildAt);
                    } else {
                        int i23 = this.mTotalLength;
                        this.mTotalLength = Math.max(i23, measuredWidth + i23 + virtualChildAt.marginLeft + virtualChildAt.marginRight + getNextLocationOffset(virtualChildAt));
                    }
                } else {
                    if (z3) {
                        this.mTotalLength += virtualChildAt.marginLeft + virtualChildAt.marginRight;
                    } else {
                        int i24 = this.mTotalLength;
                        this.mTotalLength = Math.max(i24, virtualChildAt.marginLeft + i24 + virtualChildAt.marginRight);
                    }
                    f = f3;
                    i12 = i18;
                    i11 = i19;
                    i13 = i20;
                    i10 = i21;
                    z4 = true;
                }
                if (a3 != 1073741824) {
                    i14 = -1;
                    if (virtualChildAt.layoutHeight == -1) {
                        z2 = true;
                        z6 = true;
                        int i25 = virtualChildAt.marginTop + virtualChildAt.marginBottom;
                        int measuredHeight = virtualChildAt.getMeasuredHeight() + i25;
                        max = Math.max(i12, measuredHeight);
                        z5 = !z5 && virtualChildAt.layoutHeight == i14;
                        if (virtualChildAt.layoutWidth <= 0) {
                            if (!z2) {
                                i25 = measuredHeight;
                            }
                            i16 = Math.max(i11, i25);
                            i20 = i13;
                            i15 = i10;
                        } else {
                            if (!z2) {
                                i25 = measuredHeight;
                            }
                            i15 = i10;
                            i20 = Math.max(i13, i25);
                            i16 = i11;
                        }
                        i21 = i15 + getChildrenSkipCount(virtualChildAt, i15);
                        i17 = i16;
                        f2 = f;
                        i21++;
                        i18 = max;
                        virtualChildCount = i9;
                        i19 = i17;
                    }
                } else {
                    i14 = -1;
                }
                z2 = false;
                int i252 = virtualChildAt.marginTop + virtualChildAt.marginBottom;
                int measuredHeight2 = virtualChildAt.getMeasuredHeight() + i252;
                max = Math.max(i12, measuredHeight2);
                if (!z5) {
                }
                if (virtualChildAt.layoutWidth <= 0) {
                }
                i21 = i15 + getChildrenSkipCount(virtualChildAt, i15);
                i17 = i16;
                f2 = f;
                i21++;
                i18 = max;
                virtualChildCount = i9;
                i19 = i17;
            }
            i17 = i19;
            i9 = virtualChildCount;
            max = i18;
            i21++;
            i18 = max;
            virtualChildCount = i9;
            i19 = i17;
        }
        int i26 = i20;
        int i27 = this.mTotalLength + this.paddingLeft + this.paddingRight;
        this.mTotalLength = i27;
        int resolveSizeAndState = DXWidgetNode.resolveSizeAndState(Math.max(i27, getSuggestedMinimumWidth()), i, 0);
        int i28 = ((16777215 & resolveSizeAndState) - this.mTotalLength) + i22;
        if (z4 || (i28 != 0 && f2 > 0.0f)) {
            this.mTotalLength = 0;
            float f4 = f2;
            int i29 = i28;
            i5 = virtualChildCount;
            int i30 = 0;
            int i31 = -1;
            while (i30 < i5) {
                DXWidgetNode virtualChildAt2 = getVirtualChildAt(i30);
                if (virtualChildAt2 == null || virtualChildAt2.getVisibility() == i3) {
                    i8 = resolveSizeAndState;
                } else {
                    double d2 = virtualChildAt2.weight;
                    if (d2 > 0.0d) {
                        i8 = resolveSizeAndState;
                        double d3 = (double) f4;
                        int i32 = (int) ((((double) i29) * d2) / d3);
                        i29 -= i32;
                        f4 = (float) (d3 - d2);
                        dXWidgetNode = virtualChildAt2;
                        dXWidgetNode.measure(DXWidgetNode.DXMeasureSpec.c(Math.max(0, i32), 1073741824), f.getChildMeasureSpec(i2, this.paddingTop + this.paddingBottom + dXWidgetNode.marginTop + dXWidgetNode.marginBottom, dXWidgetNode.layoutHeight));
                    } else {
                        i8 = resolveSizeAndState;
                        dXWidgetNode = virtualChildAt2;
                    }
                    if (z3) {
                        this.mTotalLength += dXWidgetNode.getMeasuredWidth() + dXWidgetNode.marginLeft + dXWidgetNode.marginRight + getNextLocationOffset(dXWidgetNode);
                    } else {
                        int i33 = this.mTotalLength;
                        this.mTotalLength = Math.max(i33, dXWidgetNode.getMeasuredWidth() + i33 + dXWidgetNode.marginLeft + dXWidgetNode.marginRight + getNextLocationOffset(dXWidgetNode));
                    }
                    boolean z8 = a3 != 1073741824 && dXWidgetNode.layoutHeight == -1;
                    int i34 = dXWidgetNode.marginTop + dXWidgetNode.marginBottom;
                    int measuredHeight3 = dXWidgetNode.getMeasuredHeight() + i34;
                    i31 = Math.max(i31, measuredHeight3);
                    if (!z8) {
                        i34 = measuredHeight3;
                    }
                    int max2 = Math.max(i26, i34);
                    if (z5) {
                        if (dXWidgetNode.layoutHeight == -1) {
                            z = true;
                            i26 = max2;
                            z5 = z;
                        }
                    }
                    z = false;
                    i26 = max2;
                    z5 = z;
                }
                i30++;
                resolveSizeAndState = i8;
                i3 = 2;
            }
            i4 = resolveSizeAndState;
            this.mTotalLength += this.paddingLeft + this.paddingRight;
            i6 = i31;
            i7 = i26;
        } else {
            i7 = Math.max(i26, i19);
            i4 = resolveSizeAndState;
            i6 = i18;
            i5 = virtualChildCount;
        }
        if (z5 || a3 == 1073741824) {
            i7 = i6;
        }
        setMeasuredDimension(i4 | 0, DXWidgetNode.resolveSizeAndState(Math.max(i7 + this.paddingTop + this.paddingBottom, getSuggestedMinimumHeight()), i2, 0));
        if (z6) {
            forceUniformHeight(i5, i);
        }
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c8  */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        DXWidgetNode dXWidgetNode;
        int i7;
        boolean z;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f;
        DXWidgetNode dXWidgetNode2;
        int i13;
        int i14;
        boolean z3;
        int childrenSkipCount;
        int a2 = DXWidgetNode.DXMeasureSpec.a(i);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i2);
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        float f2 = 0.0f;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            i3 = 2;
            if (i18 >= virtualChildCount) {
                break;
            }
            DXWidgetNode childAt = getChildAt(i18);
            if (childAt == null) {
                this.mTotalLength += measureNullChild(i18);
            }
            if (childAt.getVisibility() == 2) {
                childrenSkipCount = i18 + getChildrenSkipCount(childAt, i18);
                i16 = i16;
            } else {
                double d = childAt.weight;
                float f3 = (float) (((double) f2) + d);
                if (d > 0.0d) {
                    childAt.layoutHeight = 0;
                }
                if (childAt.layoutHeight != 0 || d <= 0.0d) {
                    i8 = 1073741824;
                    z2 = false;
                } else {
                    i8 = 1073741824;
                    z2 = true;
                }
                if (a3 != i8 || !z2) {
                    if (z2) {
                        childAt.layoutHeight = -2;
                    }
                    f = f3;
                    i12 = i15;
                    i11 = i16;
                    i10 = i17;
                    i9 = i18;
                    measureChildBeforeLayout(childAt, i18, i, 0, i2, f3 == 0.0f ? this.mTotalLength : 0);
                    int measuredHeight = childAt.getMeasuredHeight();
                    dXWidgetNode2 = childAt;
                    if (z2) {
                        dXWidgetNode2.layoutHeight = 0;
                        i19 += measuredHeight;
                    }
                    int i20 = this.mTotalLength;
                    this.mTotalLength = Math.max(i20, measuredHeight + i20 + dXWidgetNode2.marginTop + dXWidgetNode2.marginBottom);
                    i13 = 1073741824;
                } else {
                    int i21 = this.mTotalLength;
                    this.mTotalLength = Math.max(i21, childAt.marginTop + i21 + childAt.marginBottom);
                    f = f3;
                    i12 = i15;
                    dXWidgetNode2 = childAt;
                    i10 = i17;
                    i9 = i18;
                    i11 = i16;
                    i13 = 1073741824;
                    z4 = true;
                }
                if (a2 != i13) {
                    i14 = -1;
                    if (dXWidgetNode2.layoutWidth == -1) {
                        z3 = true;
                        z6 = true;
                        int i22 = dXWidgetNode2.marginLeft + dXWidgetNode2.marginRight;
                        int measuredWidth = dXWidgetNode2.getMeasuredWidth() + i22;
                        int max = Math.max(i12, measuredWidth);
                        z5 = !z5 && dXWidgetNode2.layoutWidth == i14;
                        if (dXWidgetNode2.weight <= 0.0d) {
                            if (!z3) {
                                i22 = measuredWidth;
                            }
                            i16 = Math.max(i11, i22);
                        } else {
                            if (!z3) {
                                i22 = measuredWidth;
                            }
                            i10 = Math.max(i10, i22);
                            i16 = i11;
                        }
                        childrenSkipCount = i9 + getChildrenSkipCount(dXWidgetNode2, i9);
                        i15 = max;
                        f2 = f;
                        i17 = i10;
                    }
                } else {
                    i14 = -1;
                }
                z3 = false;
                int i222 = dXWidgetNode2.marginLeft + dXWidgetNode2.marginRight;
                int measuredWidth2 = dXWidgetNode2.getMeasuredWidth() + i222;
                int max2 = Math.max(i12, measuredWidth2);
                if (!z5) {
                }
                if (dXWidgetNode2.weight <= 0.0d) {
                }
                childrenSkipCount = i9 + getChildrenSkipCount(dXWidgetNode2, i9);
                i15 = max2;
                f2 = f;
                i17 = i10;
            }
            i18 = childrenSkipCount + 1;
        }
        int i23 = i17;
        int i24 = i15;
        int i25 = this.mTotalLength + this.paddingTop + this.paddingBottom;
        this.mTotalLength = i25;
        int resolveSizeAndState = DXWidgetNode.resolveSizeAndState(Math.max(i25, getSuggestedMinimumHeight()), i2, 0);
        int i26 = ((16777215 & resolveSizeAndState) - this.mTotalLength) + i19;
        if (z4 || (i26 != 0 && f2 > 0.0f)) {
            this.mTotalLength = 0;
            int i27 = 0;
            while (i27 < virtualChildCount) {
                DXWidgetNode virtualChildAt = getVirtualChildAt(i27);
                if (virtualChildAt.getVisibility() == i3) {
                    i6 = virtualChildCount;
                } else {
                    double d2 = virtualChildAt.weight;
                    if (d2 > 0.0d) {
                        i6 = virtualChildCount;
                        double d3 = (double) f2;
                        int i28 = (int) ((((double) i26) * d2) / d3);
                        float f4 = (float) (d3 - d2);
                        i26 -= i28;
                        dXWidgetNode = virtualChildAt;
                        dXWidgetNode.measure(f.getChildMeasureSpec(i, this.paddingLeft + this.paddingRight + dXWidgetNode.marginLeft + dXWidgetNode.marginRight, dXWidgetNode.layoutWidth), DXWidgetNode.DXMeasureSpec.c(Math.max(0, i28), 1073741824));
                        f2 = f4;
                    } else {
                        i6 = virtualChildCount;
                        dXWidgetNode = virtualChildAt;
                    }
                    int i29 = dXWidgetNode.marginLeft + dXWidgetNode.marginRight;
                    int measuredWidth3 = dXWidgetNode.getMeasuredWidth() + i29;
                    i24 = Math.max(i24, measuredWidth3);
                    if (a2 != 1073741824) {
                        i7 = -1;
                        if (dXWidgetNode.layoutWidth == -1) {
                            z = true;
                            if (!z) {
                                i29 = measuredWidth3;
                            }
                            int max3 = Math.max(i23, i29);
                            z5 = !z5 && dXWidgetNode.layoutWidth == i7;
                            int i30 = this.mTotalLength;
                            this.mTotalLength = Math.max(i30, dXWidgetNode.getMeasuredHeight() + i30 + dXWidgetNode.marginTop + dXWidgetNode.marginBottom + getNextLocationOffset(dXWidgetNode));
                            i23 = max3;
                        }
                    } else {
                        i7 = -1;
                    }
                    z = false;
                    if (!z) {
                    }
                    int max32 = Math.max(i23, i29);
                    if (!z5) {
                    }
                    int i302 = this.mTotalLength;
                    this.mTotalLength = Math.max(i302, dXWidgetNode.getMeasuredHeight() + i302 + dXWidgetNode.marginTop + dXWidgetNode.marginBottom + getNextLocationOffset(dXWidgetNode));
                    i23 = max32;
                }
                i27++;
                virtualChildCount = i6;
                i3 = 2;
            }
            i4 = virtualChildCount;
            this.mTotalLength += this.paddingTop + this.paddingBottom;
            i5 = i23;
        } else {
            i5 = Math.max(i23, i16);
            i4 = virtualChildCount;
        }
        if (z5 || a2 == 1073741824) {
            i5 = i24;
        }
        setMeasuredDimension(DXWidgetNode.resolveSizeAndState(Math.max(i5 + this.paddingLeft + this.paddingRight, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState);
        if (z6) {
            forceUniformWidth(i4, i2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXLinearLayoutWidgetNode) {
            this.mOrientation = ((DXLinearLayoutWidgetNode) dXWidgetNode).mOrientation;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeLinearLayout(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null && (view instanceof LinearLayout)) {
            ((LinearLayout) view).setOrientation(this.mOrientation);
        }
        super.onRenderView(context, view);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (-7199229155167727177L == j) {
            this.mOrientation = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (view instanceof DXNativeLinearLayout) {
            if (hasCornerRadius()) {
                DXNativeLinearLayout dXNativeLinearLayout = (DXNativeLinearLayout) view;
                be beVar = new be();
                int i = this.cornerRadius;
                if (i > 0) {
                    beVar.j(view, (float) i);
                } else {
                    beVar.k(view, (float) this.cornerRadiusLeftTop, (float) this.cornerRadiusRightTop, (float) this.cornerRadiusLeftBottom, (float) this.cornerRadiusRightBottom);
                }
                dXNativeLinearLayout.setClipRadiusHandler(beVar);
            } else {
                be cLipRadiusHandler = ((DXNativeLinearLayout) view).getCLipRadiusHandler();
                if (cLipRadiusHandler != null) {
                    cLipRadiusHandler.j(view, 0.0f);
                }
            }
        }
        super.setBackground(view);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public ViewGroup.LayoutParams generateLayoutParams(@NonNull py pyVar, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = pyVar.d;
        }
        layoutParams.width = pyVar.a;
        layoutParams.height = pyVar.b;
        return layoutParams;
    }
}
