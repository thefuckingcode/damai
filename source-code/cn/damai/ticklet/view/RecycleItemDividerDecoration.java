package cn.damai.ticklet.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RecycleItemDividerDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private Drawable a;
    private boolean b;
    private int c;
    private final Rect d;

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "55327392")) {
            ipChange.ipc$dispatch("55327392", new Object[]{this, canvas, recyclerView});
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingTop();
            i = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), i);
        } else {
            i = recyclerView.getHeight();
            i2 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.d);
            int round = this.d.right + Math.round(childAt.getTranslationX());
            this.a.setBounds(round - this.a.getIntrinsicWidth(), i2, round, i);
            this.a.draw(canvas);
        }
        canvas.restore();
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44524110")) {
            ipChange.ipc$dispatch("44524110", new Object[]{this, canvas, recyclerView});
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingLeft();
            i = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i2, recyclerView.getPaddingTop(), i, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i = recyclerView.getWidth();
            i2 = 0;
        }
        int childCount = recyclerView.getChildCount();
        if (this.b) {
            childCount--;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.d);
            int round = this.d.bottom + Math.round(childAt.getTranslationY());
            this.a.setBounds(i2, round - this.a.getIntrinsicHeight(), i, round);
            this.a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676258325")) {
            ipChange.ipc$dispatch("-676258325", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        Drawable drawable = this.a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961892379")) {
            ipChange.ipc$dispatch("-1961892379", new Object[]{this, canvas, recyclerView, state});
        } else if (recyclerView.getLayoutManager() != null && this.a != null) {
            if (this.c == 1) {
                drawVertical(canvas, recyclerView);
            } else {
                drawHorizontal(canvas, recyclerView);
            }
        }
    }
}
