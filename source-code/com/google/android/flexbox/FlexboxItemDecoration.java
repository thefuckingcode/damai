package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: Taobao */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    private static final int[] c = {16843284};
    private Drawable a;
    private int b;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (d()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = recyclerView.getChildAt(i8);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    i2 = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i = this.a.getIntrinsicHeight() + i2;
                } else {
                    i = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i2 = i - this.a.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    i5 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i7 = childAt.getRight();
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (flexboxLayoutManager.y()) {
                    i3 = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.a.getIntrinsicWidth(), right);
                    i4 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.a.setBounds(i4, i2, i3, i);
                    this.a.draw(canvas);
                } else {
                    i5 = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.a.getIntrinsicWidth(), left);
                    i7 = childAt.getRight();
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i3 = i7 + i6;
                i4 = i5;
                this.a.setBounds(i4, i2, i3, i);
                this.a.draw(canvas);
            }
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2;
        int i3;
        int i4;
        int bottom;
        int i5;
        if (e()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = recyclerView.getChildAt(i6);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.y()) {
                    i2 = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    i = this.a.getIntrinsicWidth() + i2;
                } else {
                    i = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i2 = i - this.a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    i3 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i5 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.a.getIntrinsicHeight(), bottom2);
                    i3 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i4 = min;
                    this.a.setBounds(i2, i3, i, i4);
                    this.a.draw(canvas);
                } else {
                    i3 = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.a.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i5 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i4 = bottom + i5;
                this.a.setBounds(i2, i3, i, i4);
                this.a.draw(canvas);
            }
        }
    }

    private boolean c(int i, List<a> list, FlexboxLayoutManager flexboxLayoutManager) {
        int v = flexboxLayoutManager.v(i);
        if ((v != -1 && v < flexboxLayoutManager.getFlexLinesInternal().size() && flexboxLayoutManager.getFlexLinesInternal().get(v).o == i) || i == 0) {
            return true;
        }
        if (list.size() != 0 && list.get(list.size() - 1).p == i - 1) {
            return true;
        }
        return false;
    }

    private boolean d() {
        return (this.b & 1) > 0;
    }

    private boolean e() {
        return (this.b & 2) > 0;
    }

    private void f(Rect rect, int i, FlexboxLayoutManager flexboxLayoutManager, List<a> list) {
        if (list.size() != 0 && flexboxLayoutManager.v(i) != 0) {
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                if (!d()) {
                    rect.top = 0;
                    rect.bottom = 0;
                    return;
                }
                rect.top = this.a.getIntrinsicHeight();
                rect.bottom = 0;
            } else if (e()) {
                if (flexboxLayoutManager.y()) {
                    rect.right = this.a.getIntrinsicWidth();
                    rect.left = 0;
                    return;
                }
                rect.left = this.a.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    private void g(Rect rect, int i, FlexboxLayoutManager flexboxLayoutManager, List<a> list, int i2) {
        if (!c(i, list, flexboxLayoutManager)) {
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                if (!e()) {
                    rect.left = 0;
                    rect.right = 0;
                } else if (flexboxLayoutManager.y()) {
                    rect.right = this.a.getIntrinsicWidth();
                    rect.left = 0;
                } else {
                    rect.left = this.a.getIntrinsicWidth();
                    rect.right = 0;
                }
            } else if (!d()) {
                rect.top = 0;
                rect.bottom = 0;
            } else if (i2 == 3) {
                rect.bottom = this.a.getIntrinsicHeight();
                rect.top = 0;
            } else {
                rect.top = this.a.getIntrinsicHeight();
                rect.bottom = 0;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            if (d() || e()) {
                FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
                List<a> flexLines = flexboxLayoutManager.getFlexLines();
                g(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
                f(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
                return;
            }
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    public void setOrientation(int i) {
        this.b = i;
    }
}
