package cn.damai.commonbusiness.city.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class FloatingTitleDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int[] k = {16843284};
    private Drawable a;
    private int b;
    private Map<Integer, String> c = new HashMap();
    private int d;
    private Paint e;
    private Paint f;
    private float g;
    private float h;
    private Context i;
    private boolean j = true;

    public FloatingTitleDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(k);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.b = this.a.getIntrinsicHeight();
        this.a.getIntrinsicWidth();
        b(context);
    }

    private String a(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-333949845")) {
            return (String) ipChange.ipc$dispatch("-333949845", new Object[]{this, Integer.valueOf(i2)});
        }
        while (i2 >= 0) {
            if (this.c.containsKey(Integer.valueOf(i2))) {
                return this.c.get(Integer.valueOf(i2));
            }
            i2--;
        }
        return null;
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385752456")) {
            ipChange.ipc$dispatch("385752456", new Object[]{this, context});
            return;
        }
        this.i = context;
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setTextSize(TypedValue.applyDimension(1, 13.0f, context.getResources().getDisplayMetrics()));
        this.e.setColor(Color.parseColor("#AAAAAA"));
        Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
        float f2 = fontMetrics.bottom;
        this.g = f2 - fontMetrics.top;
        this.h = f2;
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setAntiAlias(true);
        this.f.setColor(Color.parseColor("#F5F5F5"));
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "329650728")) {
            ipChange.ipc$dispatch("329650728", new Object[]{this, canvas, recyclerView});
            return;
        }
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!this.c.containsKey(Integer.valueOf(layoutParams.getViewLayoutPosition()))) {
                int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i3 = this.b;
                int i4 = top - i3;
                this.a.setBounds(paddingLeft, i4, width, i3 + i4);
                this.a.draw(canvas);
            } else {
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i5 = this.d;
                int i6 = top2 - i5;
                float f2 = (float) (i5 + i6);
                canvas.drawRect((float) paddingLeft, (float) i6, (float) width, f2, this.f);
                float applyDimension = TypedValue.applyDimension(1, 15.0f, this.i.getResources().getDisplayMetrics());
                float f3 = (f2 - ((((float) this.d) - this.g) / 2.0f)) - this.h;
                if (!TextUtils.isEmpty(this.c.get(Integer.valueOf(layoutParams.getViewLayoutPosition())))) {
                    canvas.drawText(this.c.get(Integer.valueOf(layoutParams.getViewLayoutPosition())), applyDimension, f3, this.e);
                }
            }
        }
    }

    public void c(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587433680")) {
            ipChange.ipc$dispatch("587433680", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.d = i2;
    }

    public void d(Map<Integer, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204798120")) {
            ipChange.ipc$dispatch("204798120", new Object[]{this, map});
            return;
        }
        this.c.clear();
        this.c.putAll(map);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1975746363")) {
            ipChange.ipc$dispatch("-1975746363", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.c.containsKey(Integer.valueOf(recyclerView.getChildViewHolder(view).getAdapterPosition()))) {
            rect.set(0, this.d, 0, 0);
        } else {
            rect.set(0, this.b, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599368757")) {
            ipChange.ipc$dispatch("-1599368757", new Object[]{this, canvas, recyclerView, state});
            return;
        }
        super.onDraw(canvas, recyclerView, state);
        drawVertical(canvas, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int findFirstVisibleItemPosition;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1701989697")) {
            ipChange.ipc$dispatch("-1701989697", new Object[]{this, canvas, recyclerView, state});
            return;
        }
        super.onDrawOver(canvas, recyclerView, state);
        if (this.j && (findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) != -1) {
            String a2 = a(findFirstVisibleItemPosition);
            if (!TextUtils.isEmpty(a2)) {
                int i2 = findFirstVisibleItemPosition + 1;
                if (!(a(i2) == null || a2.equals(a(i2)) || recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition) == null)) {
                    View view = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition).itemView;
                    if (view.getTop() + view.getMeasuredHeight() < this.d) {
                        canvas.save();
                        canvas.translate(0.0f, (float) ((view.getTop() + view.getMeasuredHeight()) - this.d));
                        z = true;
                    }
                }
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                int paddingTop = recyclerView.getPaddingTop();
                float f2 = (float) (this.d + paddingTop);
                canvas.drawRect((float) paddingLeft, (float) paddingTop, (float) width, f2, this.f);
                canvas.drawText(a2, TypedValue.applyDimension(1, 15.0f, this.i.getResources().getDisplayMetrics()), (f2 - ((((float) this.d) - this.g) / 2.0f)) - this.h, this.e);
                if (z) {
                    canvas.restore();
                }
            }
        }
    }
}
