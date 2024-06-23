package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import tb.be;
import tb.py;

/* compiled from: Taobao */
public class d extends f {
    private final ArrayList<DXWidgetNode> a = new ArrayList<>(1);
    boolean b = false;

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new d();
        }
    }

    private int a() {
        int i = this.paddingBottom;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    private int b() {
        int paddingLeftWithDirection = getPaddingLeftWithDirection();
        if (paddingLeftWithDirection > 0) {
            return paddingLeftWithDirection;
        }
        return 0;
    }

    private int c() {
        int paddingRightWithDirection = getPaddingRightWithDirection();
        if (paddingRightWithDirection > 0) {
            return paddingRightWithDirection;
        }
        return 0;
    }

    private int d() {
        int i = this.paddingTop;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new d();
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* access modifiers changed from: package-private */
    public void e(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int virtualChildCount = getVirtualChildCount();
        int direction = getDirection();
        int b2 = b();
        int c = (i3 - i) - c();
        int d = d();
        int a2 = (i4 - i2) - a();
        for (int i10 = 0; i10 < virtualChildCount; i10++) {
            DXWidgetNode childAt = getChildAt(i10);
            if (childAt.getVisibility() != 2) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = childAt.layoutGravity;
                if (i11 == 0 && (childAt.propertyInitFlag & 1) == 0) {
                    i11 = 0;
                }
                int absoluteGravity = DXWidgetNode.getAbsoluteGravity(i11, direction);
                switch (absoluteGravity) {
                    case 3:
                    case 4:
                    case 5:
                        i9 = (((c - b2) - measuredWidth) / 2) + b2 + childAt.getLeftMarginWithDirection();
                        i8 = childAt.getRightMarginWithDirection();
                        i5 = i9 - i8;
                        break;
                    case 6:
                    case 7:
                    case 8:
                        if (!z) {
                            i9 = c - measuredWidth;
                            i8 = childAt.getRightMarginWithDirection();
                            i5 = i9 - i8;
                            break;
                        }
                    default:
                        i5 = childAt.getLeftMarginWithDirection() + b2;
                        break;
                }
                switch (absoluteGravity) {
                    case 0:
                    case 3:
                    case 6:
                        i7 = childAt.marginTop;
                        i6 = i7 + d;
                        break;
                    case 1:
                    case 4:
                    case 7:
                        i6 = (((((a2 - d) - measuredHeight) / 2) + d) + childAt.marginTop) - childAt.marginBottom;
                        break;
                    case 2:
                    case 5:
                    case 8:
                        i6 = (a2 - measuredHeight) - childAt.marginBottom;
                        break;
                    default:
                        i7 = childAt.marginTop;
                        i6 = i7 + d;
                        break;
                }
                childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public ViewGroup.LayoutParams generateLayoutParams(py pyVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pyVar.a, pyVar.b);
        layoutParams.gravity = pyVar.d;
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeFrameLayout(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e(i, i2, i3, i4, false);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean z = (DXWidgetNode.DXMeasureSpec.a(i) == 1073741824 && DXWidgetNode.DXMeasureSpec.a(i2) == 1073741824) ? false : true;
        this.a.clear();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            DXWidgetNode childAt = getChildAt(i8);
            if (this.b || childAt.getVisibility() != 2) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                i7 = Math.max(i7, childAt.getMeasuredWidth() + childAt.marginLeft + childAt.marginRight);
                i6 = Math.max(i6, childAt.getMeasuredHeight() + childAt.marginTop + childAt.marginBottom);
                i5 = DXWidgetNode.combineMeasuredStates(i5, childAt.getMeasuredState());
                if (z && (childAt.layoutWidth == -1 || childAt.layoutHeight == -1)) {
                    this.a.add(childAt);
                }
            }
        }
        setMeasuredDimension(DXWidgetNode.resolveSizeAndState(Math.max(i7 + b() + c(), getSuggestedMinimumWidth()), i, i5), DXWidgetNode.resolveSizeAndState(Math.max(i6 + d() + a(), getSuggestedMinimumHeight()), i2, i5 << 16));
        int size = this.a.size();
        if (size > 1) {
            for (int i9 = 0; i9 < size; i9++) {
                DXWidgetNode dXWidgetNode = this.a.get(i9);
                int i10 = dXWidgetNode.layoutWidth;
                if (i10 == -1) {
                    i3 = DXWidgetNode.DXMeasureSpec.c(Math.max(0, (((getMeasuredWidth() - this.paddingLeft) - this.paddingRight) - dXWidgetNode.marginLeft) - dXWidgetNode.marginRight), 1073741824);
                } else {
                    i3 = f.getChildMeasureSpec(i, this.paddingLeft + this.paddingRight + dXWidgetNode.marginLeft + dXWidgetNode.marginRight, i10);
                }
                int i11 = dXWidgetNode.layoutHeight;
                if (i11 == -1) {
                    i4 = DXWidgetNode.DXMeasureSpec.c(Math.max(0, (((getMeasuredHeight() - this.paddingTop) - this.paddingBottom) - dXWidgetNode.marginTop) - dXWidgetNode.marginBottom), 1073741824);
                } else {
                    i4 = f.getChildMeasureSpec(i2, this.paddingTop + this.paddingBottom + dXWidgetNode.marginTop + dXWidgetNode.marginBottom, i11);
                }
                dXWidgetNode.measure(i3, i4);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (9346582897824575L == j) {
            this.layoutHeight = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (hasCornerRadius()) {
            DXNativeFrameLayout dXNativeFrameLayout = (DXNativeFrameLayout) view;
            be beVar = new be();
            int i = this.cornerRadius;
            if (i > 0) {
                beVar.j(view, (float) i);
            } else {
                beVar.k(view, (float) this.cornerRadiusLeftTop, (float) this.cornerRadiusRightTop, (float) this.cornerRadiusLeftBottom, (float) this.cornerRadiusRightBottom);
            }
            dXNativeFrameLayout.setClipRadiusHandler(beVar);
        } else {
            be cLipRadiusHandler = ((DXNativeFrameLayout) view).getCLipRadiusHandler();
            if (cLipRadiusHandler != null) {
                cLipRadiusHandler.j(view, 0.0f);
            }
        }
        super.setBackground(view);
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public ViewGroup.LayoutParams generateLayoutParams(@NonNull py pyVar, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = pyVar.d;
        }
        layoutParams.width = pyVar.a;
        layoutParams.height = pyVar.b;
        return layoutParams;
    }
}
