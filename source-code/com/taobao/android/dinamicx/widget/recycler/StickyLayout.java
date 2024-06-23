package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import tb.vx;

/* compiled from: Taobao */
public class StickyLayout extends FrameLayout {
    private IEleSectionHeightListener mHeightListener;
    private ViewGroup mOuterRecyclerView;

    public StickyLayout(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void onDescendantInvalidated(@NonNull View view, @NonNull View view2) {
        super.onDescendantInvalidated(view, view2);
        ViewGroup viewGroup = this.mOuterRecyclerView;
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            ViewGroup viewGroup = this.mOuterRecyclerView;
            return viewGroup != null && viewGroup.onInterceptTouchEvent(motionEvent);
        } catch (Throwable th) {
            vx.b(th);
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.isLayoutRequested()) {
                childAt.layout(childAt.getLeft(), childAt.getTop(), childAt.getLeft() + childAt.getMeasuredWidth(), childAt.getTop() + childAt.getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IEleSectionHeightListener iEleSectionHeightListener;
        boolean z = false;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int measuredHeight = childAt.getMeasuredHeight();
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            if (measuredHeight != childAt.getMeasuredHeight()) {
                z = true;
            }
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (z && (iEleSectionHeightListener = this.mHeightListener) != null) {
            iEleSectionHeightListener.onSectionHeightUpdated();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            ViewGroup viewGroup = this.mOuterRecyclerView;
            return viewGroup != null && viewGroup.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            vx.b(th);
            return super.onTouchEvent(motionEvent);
        }
    }

    public void setHeightUpdateListener(IEleSectionHeightListener iEleSectionHeightListener) {
        this.mHeightListener = iEleSectionHeightListener;
    }

    public void setRecyclerView(ViewGroup viewGroup) {
        this.mOuterRecyclerView = viewGroup;
    }
}
