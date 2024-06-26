package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager;
import tb.be;
import tb.c00;

/* compiled from: Taobao */
public class DXNativeRecyclerView extends RecyclerView {
    private be cLipRadiusHandler;
    private int contentHorizontalLength;
    private int contentOffsetX;
    private int contentOffsetY;
    private int contentVerticalLength;
    private int lastX = 0;
    private int lastY = 0;
    private int mScrolledX;
    private int mScrolledY;
    private int needFixScrollConflict = 0;
    private boolean needScrollAfterLayout;
    private Parcelable saveInstanceState;

    public DXNativeRecyclerView(Context context) {
        super(context);
    }

    public void dispatchDraw(Canvas canvas) {
        be beVar = this.cLipRadiusHandler;
        if (beVar == null) {
            super.dispatchDraw(canvas);
        } else if (beVar.h()) {
            super.dispatchDraw(canvas);
        } else {
            this.cLipRadiusHandler.b(this, canvas);
            super.dispatchDraw(canvas);
            this.cLipRadiusHandler.a(this, canvas);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.needFixScrollConflict != 0) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            boolean z = true;
            if (action == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 2) {
                int abs = Math.abs(rawX - this.lastX) + 0;
                int abs2 = Math.abs(rawY - this.lastY) + 0;
                if (this.needFixScrollConflict == 1) {
                    RecyclerView.LayoutManager layoutManager = getLayoutManager();
                    if (layoutManager instanceof StackLayoutManager) {
                        boolean z2 = ((StackLayoutManager) layoutManager).l() != 0.0f;
                        ViewParent parent = getParent();
                        if (abs < abs2 && !z2) {
                            z = false;
                        }
                        parent.requestDisallowInterceptTouchEvent(z);
                    } else {
                        ViewParent parent2 = getParent();
                        if (abs < abs2) {
                            z = false;
                        }
                        parent2.requestDisallowInterceptTouchEvent(z);
                    }
                }
                this.lastX = rawX;
                this.lastY = rawY;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public be getCLipRadiusHandler() {
        return this.cLipRadiusHandler;
    }

    public Parcelable getSaveInstanceState() {
        return this.saveInstanceState;
    }

    public int getScrolledX() {
        return this.mScrolledX;
    }

    public int getScrolledY() {
        return this.mScrolledY;
    }

    public boolean isNeedScrollAfterLayout() {
        return this.needScrollAfterLayout;
    }

    public boolean isSlider() {
        return false;
    }

    public void needScrollAfterLayout(int i, int i2, int i3, int i4) {
        needScrollAfterLayout(i, i2, i3, i4, false);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (this.needScrollAfterLayout) {
                scrollBy(this.contentOffsetX, this.contentOffsetY);
                this.contentOffsetX = 0;
                this.contentOffsetY = 0;
                this.needScrollAfterLayout = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        this.mScrolledX += i;
        this.mScrolledY += i2;
    }

    public void setClipRadiusHandler(be beVar) {
        this.cLipRadiusHandler = beVar;
    }

    public void setContentHorizontalLength(int i) {
        this.contentHorizontalLength = i;
    }

    public void setContentVerticalLength(int i) {
        this.contentVerticalLength = i;
    }

    public void setNeedFixScrollConflict(int i) {
        this.needFixScrollConflict = i;
    }

    public void setSaveInstanceState(Parcelable parcelable) {
        this.saveInstanceState = parcelable;
    }

    public void setScrolledX(int i) {
        this.mScrolledX = i;
    }

    public void setScrolledY(int i) {
        this.mScrolledY = i;
    }

    public void needScrollAfterLayout(int i, int i2, int i3, int i4, boolean z) {
        this.needScrollAfterLayout = true;
        if (i3 < this.contentHorizontalLength) {
            this.contentOffsetX = i;
            this.mScrolledX = 0;
            if (z) {
                c00.m(new Runnable() {
                    /* class com.taobao.android.dinamicx.view.DXNativeRecyclerView.AnonymousClass1 */

                    public void run() {
                        DXNativeRecyclerView.this.scrollToPosition(0);
                    }
                });
            } else {
                scrollToPosition(0);
            }
        } else {
            this.contentOffsetX = i - this.mScrolledX;
        }
        if (i4 < this.contentVerticalLength) {
            this.contentOffsetY = i2;
            this.mScrolledY = 0;
            scrollToPosition(0);
        } else {
            this.contentOffsetY = i2 - this.mScrolledY;
        }
        this.contentHorizontalLength = i3;
        this.contentVerticalLength = i4;
    }

    public DXNativeRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DXNativeRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
