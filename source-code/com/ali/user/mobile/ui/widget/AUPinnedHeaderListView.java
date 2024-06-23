package com.ali.user.mobile.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/* compiled from: Taobao */
public class AUPinnedHeaderListView extends ListView {
    private static final int MAX_ALPHA = 255;
    private PinnedHeaderAdapter mAdapter;
    private View mHeaderView;
    private int mHeaderViewHeight;
    private boolean mHeaderViewVisible;
    private int mHeaderViewWidth;

    /* compiled from: Taobao */
    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        void configurePinnedHeader(View view, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    public AUPinnedHeaderListView(Context context) {
        super(context);
    }

    public void configureHeaderView(int i) {
        int i2;
        if (this.mHeaderView != null) {
            int pinnedHeaderState = this.mAdapter.getPinnedHeaderState(i);
            if (pinnedHeaderState != 0) {
                int i3 = 255;
                if (pinnedHeaderState == 1) {
                    this.mAdapter.configurePinnedHeader(this.mHeaderView, i, 255);
                    if (this.mHeaderView.getTop() != 0) {
                        this.mHeaderView.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
                    }
                    this.mHeaderViewVisible = true;
                } else if (pinnedHeaderState == 2) {
                    int bottom = getChildAt(0).getBottom();
                    int height = this.mHeaderView.getHeight();
                    if (bottom < height) {
                        i2 = bottom - height;
                        i3 = ((height + i2) * 255) / height;
                    } else {
                        i2 = 0;
                    }
                    this.mAdapter.configurePinnedHeader(this.mHeaderView, i, i3);
                    if (this.mHeaderView.getTop() != i2) {
                        this.mHeaderView.layout(0, i2, this.mHeaderViewWidth, this.mHeaderViewHeight + i2);
                    }
                    this.mHeaderViewVisible = true;
                }
            } else {
                this.mHeaderViewVisible = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mHeaderViewVisible) {
            drawChild(canvas, this.mHeaderView, getDrawingTime());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.mHeaderView;
        if (view != null) {
            view.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.mHeaderView;
        if (view != null) {
            measureChild(view, i, i2);
            this.mHeaderViewWidth = this.mHeaderView.getMeasuredWidth();
            this.mHeaderViewHeight = this.mHeaderView.getMeasuredHeight();
        }
    }

    public void setPinnedHeaderView(View view) {
        this.mHeaderView = view;
        if (view != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public AUPinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.widget.ListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.mAdapter = (PinnedHeaderAdapter) listAdapter;
    }

    public AUPinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
