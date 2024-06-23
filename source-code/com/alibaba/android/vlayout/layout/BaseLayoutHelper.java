package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import tb.s61;

/* compiled from: Taobao */
public abstract class BaseLayoutHelper extends d {
    public static boolean DEBUG = false;
    private static final String TAG = "BaseLayoutHelper";
    float mAspectRatio = Float.NaN;
    int mBgColor;
    private int mItemCount = 0;
    protected Rect mLayoutRegion = new Rect();
    View mLayoutView;
    private LayoutViewBindListener mLayoutViewBindListener;
    private LayoutViewUnBindListener mLayoutViewUnBindListener;

    /* compiled from: Taobao */
    public interface LayoutViewBindListener {
        void onBind(View view, BaseLayoutHelper baseLayoutHelper);
    }

    /* compiled from: Taobao */
    public interface LayoutViewHelper {
        void onBindViewSuccess(View view, String str);
    }

    /* compiled from: Taobao */
    public interface LayoutViewUnBindListener {
        void onUnbind(View view, BaseLayoutHelper baseLayoutHelper);
    }

    /* compiled from: Taobao */
    public static class a implements LayoutViewBindListener, LayoutViewHelper, LayoutViewUnBindListener {
    }

    private int calGap(int i, int i2) {
        if (i < i2) {
            return i2 - i;
        }
        return 0;
    }

    @Override // com.alibaba.android.vlayout.a
    public void adjustLayout(int i, int i2, LayoutManagerHelper layoutManagerHelper) {
        if (requireLayoutView()) {
            Rect rect = new Rect();
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            for (int i3 = 0; i3 < layoutManagerHelper.getChildCount(); i3++) {
                View childAt = layoutManagerHelper.getChildAt(i3);
                if (getRange().a(Integer.valueOf(layoutManagerHelper.getPosition(childAt)))) {
                    if (childAt.getVisibility() == 8) {
                        rect.setEmpty();
                    } else {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                        if (layoutManagerHelper.getOrientation() == 1) {
                            rect.union(layoutManagerHelper.getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, mainOrientationHelper.d(childAt));
                        } else {
                            rect.union(mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, mainOrientationHelper.d(childAt), layoutManagerHelper.getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    }
                }
            }
            if (!rect.isEmpty()) {
                this.mLayoutRegion.set(rect.left - this.mPaddingLeft, rect.top - this.mPaddingTop, rect.right + this.mPaddingRight, rect.bottom + this.mPaddingBottom);
            } else {
                this.mLayoutRegion.setEmpty();
            }
            View view = this.mLayoutView;
            if (view != null) {
                Rect rect2 = this.mLayoutRegion;
                view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (DEBUG) {
            Log.d(TAG, "call afterLayout() on " + getClass().getSimpleName());
        }
        if (requireLayoutView()) {
            if (isValidScrolled(i3) && (view = this.mLayoutView) != null) {
                this.mLayoutRegion.union(view.getLeft(), this.mLayoutView.getTop(), this.mLayoutView.getRight(), this.mLayoutView.getBottom());
            }
            if (!this.mLayoutRegion.isEmpty()) {
                if (isValidScrolled(i3)) {
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.mLayoutRegion.offset(0, -i3);
                    } else {
                        this.mLayoutRegion.offset(-i3, 0);
                    }
                }
                int contentWidth = layoutManagerHelper.getContentWidth();
                int contentHeight = layoutManagerHelper.getContentHeight();
                if (layoutManagerHelper.getOrientation() != 1 ? !this.mLayoutRegion.intersects((-contentWidth) / 4, 0, contentWidth + (contentWidth / 4), contentHeight) : !this.mLayoutRegion.intersects(0, (-contentHeight) / 4, contentWidth, contentHeight + (contentHeight / 4))) {
                    this.mLayoutRegion.set(0, 0, 0, 0);
                    View view2 = this.mLayoutView;
                    if (view2 != null) {
                        view2.layout(0, 0, 0, 0);
                    }
                } else {
                    if (this.mLayoutView == null) {
                        View generateLayoutView = layoutManagerHelper.generateLayoutView();
                        this.mLayoutView = generateLayoutView;
                        layoutManagerHelper.addOffFlowView(generateLayoutView, true);
                    }
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.mLayoutRegion.left = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft;
                        this.mLayoutRegion.right = (layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight;
                    } else {
                        this.mLayoutRegion.top = layoutManagerHelper.getPaddingTop() + this.mMarginTop;
                        this.mLayoutRegion.bottom = (layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - this.mMarginBottom;
                    }
                    bindLayoutView(this.mLayoutView);
                    return;
                }
            }
        }
        View view3 = this.mLayoutView;
        if (view3 != null) {
            LayoutViewUnBindListener layoutViewUnBindListener = this.mLayoutViewUnBindListener;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view3, this);
            }
            layoutManagerHelper.removeChildView(this.mLayoutView);
            this.mLayoutView = null;
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (DEBUG) {
            Log.d(TAG, "call beforeLayout() on " + getClass().getSimpleName());
        }
        if (!requireLayoutView() && (view = this.mLayoutView) != null) {
            LayoutViewUnBindListener layoutViewUnBindListener = this.mLayoutViewUnBindListener;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, this);
            }
            layoutManagerHelper.removeChildView(this.mLayoutView);
            this.mLayoutView = null;
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void bindLayoutView(@NonNull View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mLayoutRegion), 1073741824), View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mLayoutRegion), 1073741824));
        Rect rect = this.mLayoutRegion;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        view.setBackgroundColor(this.mBgColor);
        LayoutViewBindListener layoutViewBindListener = this.mLayoutViewBindListener;
        if (layoutViewBindListener != null) {
            layoutViewBindListener.onBind(view, this);
        }
        this.mLayoutRegion.set(0, 0, 0, 0);
    }

    @Override // com.alibaba.android.vlayout.a
    public final void clear(LayoutManagerHelper layoutManagerHelper) {
        View view = this.mLayoutView;
        if (view != null) {
            LayoutViewUnBindListener layoutViewUnBindListener = this.mLayoutViewUnBindListener;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, this);
            }
            layoutManagerHelper.removeChildView(this.mLayoutView);
            this.mLayoutView = null;
        }
        onClear(layoutManagerHelper);
    }

    /* access modifiers changed from: protected */
    public int computeEndSpace(LayoutManagerHelper layoutManagerHelper, boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        if (z) {
            i2 = this.mMarginBottom;
            i = this.mPaddingBottom;
        } else {
            i2 = this.mMarginLeft;
            i = this.mPaddingLeft;
        }
        return i2 + i;
    }

    /* access modifiers changed from: protected */
    public int computeStartSpace(LayoutManagerHelper layoutManagerHelper, boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        d dVar = null;
        com.alibaba.android.vlayout.a findNeighbourNonfixLayoutHelper = layoutManagerHelper instanceof VirtualLayoutManager ? ((VirtualLayoutManager) layoutManagerHelper).findNeighbourNonfixLayoutHelper(this, z2) : null;
        if (findNeighbourNonfixLayoutHelper != null && (findNeighbourNonfixLayoutHelper instanceof d)) {
            dVar = (d) findNeighbourNonfixLayoutHelper;
        }
        if (findNeighbourNonfixLayoutHelper == this) {
            return 0;
        }
        if (!z3) {
            if (z) {
                i9 = this.mMarginTop;
                i8 = this.mPaddingTop;
            } else {
                i9 = this.mMarginLeft;
                i8 = this.mPaddingLeft;
            }
            return i9 + i8;
        }
        if (dVar == null) {
            if (z) {
                i7 = this.mMarginTop;
                i6 = this.mPaddingTop;
            } else {
                i7 = this.mMarginLeft;
                i6 = this.mPaddingLeft;
            }
            i = i7 + i6;
        } else if (z) {
            if (z2) {
                i5 = dVar.mMarginBottom;
                i4 = this.mMarginTop;
            } else {
                i5 = dVar.mMarginTop;
                i4 = this.mMarginBottom;
            }
            i = calGap(i5, i4);
        } else {
            if (z2) {
                i3 = dVar.mMarginRight;
                i2 = this.mMarginLeft;
            } else {
                i3 = dVar.mMarginLeft;
                i2 = this.mMarginRight;
            }
            i = calGap(i3, i2);
        }
        return i + (z ? z2 ? this.mPaddingTop : this.mPaddingBottom : z2 ? this.mPaddingLeft : this.mPaddingRight) + 0;
    }

    @Override // com.alibaba.android.vlayout.a
    public void doLayout(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        layoutViews(recycler, state, dVar, s61, layoutManagerHelper);
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getBgColor() {
        return this.mBgColor;
    }

    @Override // com.alibaba.android.vlayout.a
    public int getItemCount() {
        return this.mItemCount;
    }

    /* access modifiers changed from: protected */
    public void handleStateOnResult(s61 s61, View view) {
        if (view != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            boolean z = true;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                s61.c = true;
            }
            if (!s61.d && !view.isFocusable()) {
                z = false;
            }
            s61.d = z;
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public boolean isFixLayout() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidScrolled(int i) {
        return (i == Integer.MAX_VALUE || i == Integer.MIN_VALUE) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper) {
        layoutChild(view, i, i2, i3, i4, layoutManagerHelper, false);
    }

    /* access modifiers changed from: protected */
    public void layoutChildWithMargin(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper) {
        layoutChildWithMargin(view, i, i2, i3, i4, layoutManagerHelper, false);
    }

    public abstract void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper);

    @Nullable
    public final View nextView(RecyclerView.Recycler recycler, VirtualLayoutManager.d dVar, LayoutManagerHelper layoutManagerHelper, s61 s61) {
        View l = dVar.l(recycler);
        if (l != null) {
            layoutManagerHelper.addChildView(dVar, l);
            return l;
        } else if (!DEBUG || dVar.i()) {
            s61.b = true;
            return null;
        } else {
            throw new RuntimeException("received null view when unexpected");
        }
    }

    /* access modifiers changed from: protected */
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
    }

    @Override // com.alibaba.android.vlayout.a
    public boolean requireLayoutView() {
        return (this.mBgColor == 0 && this.mLayoutViewBindListener == null) ? false : true;
    }

    public void setAspectRatio(float f) {
        this.mAspectRatio = f;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    @Override // com.alibaba.android.vlayout.a
    public void setItemCount(int i) {
        this.mItemCount = i;
    }

    public void setLayoutViewBindListener(LayoutViewBindListener layoutViewBindListener) {
        this.mLayoutViewBindListener = layoutViewBindListener;
    }

    public void setLayoutViewHelper(a aVar) {
        this.mLayoutViewBindListener = aVar;
        this.mLayoutViewUnBindListener = aVar;
    }

    public void setLayoutViewUnBindListener(LayoutViewUnBindListener layoutViewUnBindListener) {
        this.mLayoutViewUnBindListener = layoutViewUnBindListener;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper, boolean z) {
        layoutManagerHelper.layoutChild(view, i, i2, i3, i4);
        if (!requireLayoutView()) {
            return;
        }
        if (z) {
            this.mLayoutRegion.union((i - this.mPaddingLeft) - this.mMarginLeft, (i2 - this.mPaddingTop) - this.mMarginTop, i3 + this.mPaddingRight + this.mMarginRight, i4 + this.mPaddingBottom + this.mMarginBottom);
        } else {
            this.mLayoutRegion.union(i - this.mPaddingLeft, i2 - this.mPaddingTop, i3 + this.mPaddingRight, i4 + this.mPaddingBottom);
        }
    }

    /* access modifiers changed from: protected */
    public void layoutChildWithMargin(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper, boolean z) {
        layoutManagerHelper.layoutChildWithMargins(view, i, i2, i3, i4);
        if (!requireLayoutView()) {
            return;
        }
        if (z) {
            this.mLayoutRegion.union((i - this.mPaddingLeft) - this.mMarginLeft, (i2 - this.mPaddingTop) - this.mMarginTop, i3 + this.mPaddingRight + this.mMarginRight, i4 + this.mPaddingBottom + this.mMarginBottom);
        } else {
            this.mLayoutRegion.union(i - this.mPaddingLeft, i2 - this.mPaddingTop, i3 + this.mPaddingRight, i4 + this.mPaddingBottom);
        }
    }

    /* access modifiers changed from: protected */
    public void handleStateOnResult(s61 s61, View[] viewArr) {
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    boolean z = true;
                    if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                        s61.c = true;
                    }
                    if (!s61.d && !view.isFocusable()) {
                        z = false;
                    }
                    s61.d = z;
                    if (z && s61.c) {
                        return;
                    }
                }
            }
        }
    }
}
