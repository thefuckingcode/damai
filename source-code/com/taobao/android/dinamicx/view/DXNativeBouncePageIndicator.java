package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/* compiled from: Taobao */
public class DXNativeBouncePageIndicator extends HorizontalScrollView {
    private int currentIndex;
    DXNativePageIndicator dxNativePageIndicator = null;
    private int itemMargin;
    private int itemRoundDiameter;
    private int itemSelectedBorderColor;
    private int itemSelectedBorderWidth;
    private int itemUnSelectedBorderColor;
    private int itemUnSelectedBorderWidth;
    private int leftRange = -1;
    private int maxDisplayCount;
    private int pageCount;
    private int previousIndex;
    private int rightRange = -1;
    private GradientDrawable selectedDrawable;
    private GradientDrawable unselectedDrawable;

    public DXNativeBouncePageIndicator(Context context) {
        super(context);
        init(context);
    }

    private void checkRangeChange(int i) {
        int i2;
        int i3;
        int i4;
        if (!inRange(i) && (i2 = this.maxDisplayCount) < (i3 = this.pageCount)) {
            int i5 = i2 - 1;
            int i6 = i3 - i2;
            if (i >= i5) {
                i4 = Math.min(i6, Math.max((i - i5) + 1, this.leftRange - 1));
            } else {
                i4 = Math.max(0, Math.min(i - 1, this.leftRange - 1));
            }
            int i7 = (this.maxDisplayCount + i4) - 1;
            int i8 = this.leftRange;
            if (i4 != i8 || i7 != this.rightRange) {
                boolean z = i8 == -1 && this.rightRange == -1;
                this.leftRange = i4;
                this.rightRange = i7;
                if (z) {
                    post(new Runnable() {
                        /* class com.taobao.android.dinamicx.view.DXNativeBouncePageIndicator.AnonymousClass1 */

                        public void run() {
                            DXNativeBouncePageIndicator dXNativeBouncePageIndicator = DXNativeBouncePageIndicator.this;
                            dXNativeBouncePageIndicator.scrollTo((dXNativeBouncePageIndicator.itemMargin + DXNativeBouncePageIndicator.this.itemRoundDiameter) * DXNativeBouncePageIndicator.this.leftRange, DXNativeBouncePageIndicator.this.getScrollY());
                        }
                    });
                } else {
                    smoothScrollTo((this.itemMargin + this.itemRoundDiameter) * i4, getScrollY());
                }
                int i9 = this.leftRange;
                if (i9 == 0) {
                    setInitWindowDisplay(0);
                } else if (this.rightRange == this.pageCount - 1) {
                    setLastWindowDisplay(i9);
                } else {
                    setMiddleWindowDisplay(i9);
                }
            }
        }
    }

    private boolean inRange(int i) {
        return i > this.leftRange && i < this.rightRange;
    }

    private void init(Context context) {
        setHorizontalScrollBarEnabled(false);
        DXNativePageIndicator dXNativePageIndicator = new DXNativePageIndicator(context);
        this.dxNativePageIndicator = dXNativePageIndicator;
        addView(dXNativePageIndicator);
        this.currentIndex = this.dxNativePageIndicator.getCurrentIndex();
    }

    public void addChildViews(int i, int i2) {
        this.pageCount = i;
        this.dxNativePageIndicator.addChildViews(i, i2);
        this.currentIndex = this.dxNativePageIndicator.getCurrentIndex();
        checkRangeChange(i2);
    }

    public int getCurrentIndex() {
        return this.dxNativePageIndicator.getCurrentIndex();
    }

    public int getItemMargin() {
        return this.itemMargin;
    }

    public int getItemRoundDiameter() {
        return this.itemRoundDiameter;
    }

    public int getItemSelectedBorderColor() {
        return this.itemSelectedBorderColor;
    }

    public int getItemSelectedBorderWidth() {
        return this.itemSelectedBorderWidth;
    }

    public int getItemUnSelectedBorderColor() {
        return this.itemUnSelectedBorderColor;
    }

    public int getItemUnSelectedBorderWidth() {
        return this.itemUnSelectedBorderWidth;
    }

    public int getMaxDisplayCount() {
        return this.maxDisplayCount;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public void setInitWindowDisplay(int i) {
        int i2 = this.maxDisplayCount + i;
        while (i < i2) {
            this.dxNativePageIndicator.setItemNormal(i);
            if (i == i2 - 1) {
                this.dxNativePageIndicator.setItemSmall(i);
            }
            i++;
        }
    }

    public void setItemMargin(int i) {
        this.dxNativePageIndicator.setItemMargin(i);
        this.itemMargin = i;
    }

    public void setItemRoundDiameter(int i) {
        this.dxNativePageIndicator.setItemRoundDiameter(i);
        this.itemRoundDiameter = i;
    }

    public void setItemSelectedBorderColor(int i) {
        this.dxNativePageIndicator.setItemSelectedBorderColor(i);
        this.itemSelectedBorderColor = i;
    }

    public void setItemSelectedBorderWidth(int i) {
        this.dxNativePageIndicator.setItemSelectedBorderWidth(i);
        this.itemSelectedBorderWidth = i;
    }

    public void setItemUnSelectedBorderColor(int i) {
        this.dxNativePageIndicator.setItemUnSelectedBorderColor(i);
        this.itemUnSelectedBorderColor = i;
    }

    public void setItemUnSelectedBorderWidth(int i) {
        this.itemUnSelectedBorderWidth = i;
    }

    public void setLastWindowDisplay(int i) {
        int i2 = this.maxDisplayCount + i;
        this.dxNativePageIndicator.setItemSmall(i);
        while (true) {
            i++;
            if (i < i2) {
                this.dxNativePageIndicator.setItemNormal(i);
            } else {
                return;
            }
        }
    }

    public void setMaxDisplayCount(int i) {
        this.maxDisplayCount = i;
    }

    public void setMiddleWindowDisplay(int i) {
        int i2 = this.maxDisplayCount + i;
        this.dxNativePageIndicator.setItemSmall(i);
        while (true) {
            i++;
            if (i < i2) {
                this.dxNativePageIndicator.setItemNormal(i);
                if (i == i2 - 1) {
                    this.dxNativePageIndicator.setItemSmall(i);
                }
            } else {
                return;
            }
        }
    }

    public void setSelectedDrawable(int i) {
        this.dxNativePageIndicator.setSelectedDrawable(i);
    }

    public void setSelectedView(int i) {
        if (i < this.pageCount) {
            this.previousIndex = this.dxNativePageIndicator.getCurrentIndex();
            this.dxNativePageIndicator.setSelectedView(i);
            int currentIndex2 = this.dxNativePageIndicator.getCurrentIndex();
            this.currentIndex = currentIndex2;
            checkRangeChange(currentIndex2);
        }
    }

    public void setUnselectedDrawable(int i) {
        this.dxNativePageIndicator.setUnselectedDrawable(i);
    }

    public DXNativeBouncePageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DXNativeBouncePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
