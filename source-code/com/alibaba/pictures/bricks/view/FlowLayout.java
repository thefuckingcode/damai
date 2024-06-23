package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class FlowLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HORIZONTAL = 0;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int VERTICAL = 1;
    private final LayoutConfiguration config;
    protected List<a> lines = new ArrayList();
    private int showLineLimit = Integer.MAX_VALUE;
    private boolean singleLine = false;

    public FlowLayout(Context context) {
        super(context);
        this.config = new LayoutConfiguration(context, null);
    }

    private void applyGravityToLine(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200900728")) {
            ipChange.ipc$dispatch("-200900728", new Object[]{this, aVar});
            return;
        }
        List<View> j = aVar.j();
        int size = j.size();
        if (size > 0) {
            float f = 0.0f;
            for (int i = 0; i < size; i++) {
                f += getWeight((LayoutParams) j.get(i).getLayoutParams());
            }
            LayoutParams layoutParams = (LayoutParams) j.get(size - 1).getLayoutParams();
            int f2 = aVar.f() - (layoutParams.f() + layoutParams.d());
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                LayoutParams layoutParams2 = (LayoutParams) j.get(i3).getLayoutParams();
                float weight = getWeight(layoutParams2);
                int gravity = getGravity(layoutParams2);
                int round = Math.round((((float) f2) * weight) / f);
                int f3 = layoutParams2.f() + layoutParams2.g();
                int i4 = layoutParams2.i() + layoutParams2.h();
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = i2;
                rect.right = f3 + round + i2;
                rect.bottom = aVar.i();
                Rect rect2 = new Rect();
                Gravity.apply(gravity, f3, i4, rect, rect2);
                i2 += round;
                layoutParams2.l(rect2.left + layoutParams2.d());
                layoutParams2.m(rect2.top);
                layoutParams2.n(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) - layoutParams2.g());
                layoutParams2.p(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) - layoutParams2.h());
            }
        }
    }

    private void applyGravityToLines(List<a> list, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734001276")) {
            ipChange.ipc$dispatch("1734001276", new Object[]{this, list, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = list.size();
        if (size > 0) {
            a aVar = list.get(size - 1);
            int i3 = i2 - (aVar.i() + aVar.h());
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                a aVar2 = list.get(i5);
                int gravity = getGravity();
                int round = Math.round((float) ((i3 * 1) / size));
                int f = aVar2.f();
                int i6 = aVar2.i();
                Rect rect = new Rect();
                rect.top = i4;
                rect.left = 0;
                rect.right = i;
                rect.bottom = i6 + round + i4;
                Rect rect2 = new Rect();
                Gravity.apply(gravity, f, i6, rect, rect2);
                i4 += round;
                aVar2.a(rect2.left);
                aVar2.b(rect2.top);
                aVar2.k(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2));
                aVar2.l(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2));
            }
        }
    }

    private void applyPositionsToViews(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972381476")) {
            ipChange.ipc$dispatch("-972381476", new Object[]{this, aVar});
            return;
        }
        List<View> j = aVar.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            View view = j.get(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.config.c() == 0) {
                layoutParams.o(getPaddingLeft() + aVar.g() + layoutParams.d(), getPaddingTop() + aVar.h() + layoutParams.e());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.f(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.i(), 1073741824));
            } else {
                layoutParams.o(getPaddingLeft() + aVar.h() + layoutParams.e(), getPaddingTop() + aVar.g() + layoutParams.d());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.i(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.f(), 1073741824));
            }
        }
    }

    private void calculateLinesAndChildPosition(List<a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078884283")) {
            ipChange.ipc$dispatch("-1078884283", new Object[]{this, list});
            return;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = list.get(i2);
            aVar.b(i);
            i += aVar.i();
            List<View> j = aVar.j();
            int size2 = j.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                LayoutParams layoutParams = (LayoutParams) j.get(i4).getLayoutParams();
                layoutParams.l(i3);
                i3 += layoutParams.f() + layoutParams.g();
            }
        }
    }

    private Paint createPaint(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798483669")) {
            return (Paint) ipChange.ipc$dispatch("1798483669", new Object[]{this, Integer.valueOf(i)});
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    private void drawDebugInfo(Canvas canvas, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410167617")) {
            ipChange.ipc$dispatch("-1410167617", new Object[]{this, canvas, view});
        } else if (this.config.e()) {
            Paint createPaint = createPaint(InputDeviceCompat.SOURCE_ANY);
            Paint createPaint2 = createPaint(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin > 0) {
                float right = (float) view.getRight();
                float top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(right, top, right + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin), top, createPaint);
                int i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                canvas.drawLine((((float) i) + right) - 4.0f, top - 4.0f, right + ((float) i), top, createPaint);
                int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                canvas.drawLine((((float) i2) + right) - 4.0f, top + 4.0f, right + ((float) i2), top, createPaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin > 0) {
                float left = (float) view.getLeft();
                float top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(left, top2, left - ((float) ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin), top2, createPaint);
                int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                canvas.drawLine((left - ((float) i3)) + 4.0f, top2 - 4.0f, left - ((float) i3), top2, createPaint);
                int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                canvas.drawLine((left - ((float) i4)) + 4.0f, top2 + 4.0f, left - ((float) i4), top2, createPaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin > 0) {
                float left2 = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
                float bottom = (float) view.getBottom();
                canvas.drawLine(left2, bottom, left2, bottom + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin), createPaint);
                int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                canvas.drawLine(left2 - 4.0f, (((float) i5) + bottom) - 4.0f, left2, bottom + ((float) i5), createPaint);
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                canvas.drawLine(left2 + 4.0f, (((float) i6) + bottom) - 4.0f, left2, bottom + ((float) i6), createPaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).topMargin > 0) {
                float left3 = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
                float top3 = (float) view.getTop();
                canvas.drawLine(left3, top3, left3, top3 - ((float) ((ViewGroup.MarginLayoutParams) layoutParams).topMargin), createPaint);
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                canvas.drawLine(left3 - 4.0f, (top3 - ((float) i7)) + 4.0f, left3, top3 - ((float) i7), createPaint);
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                canvas.drawLine(left3 + 4.0f, (top3 - ((float) i8)) + 4.0f, left3, top3 - ((float) i8), createPaint);
            }
            if (!layoutParams.a) {
                return;
            }
            if (this.config.c() == 0) {
                float left4 = (float) view.getLeft();
                float top4 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(left4, top4 - 6.0f, left4, top4 + 6.0f, createPaint2);
                return;
            }
            float left5 = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
            float top5 = (float) view.getTop();
            canvas.drawLine(left5 - 6.0f, top5, left5 + 6.0f, top5, createPaint2);
        }
    }

    private int findSize(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263832011")) {
            return ((Integer) ipChange.ipc$dispatch("-263832011", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        } else if (i != Integer.MIN_VALUE) {
            return i != 1073741824 ? i3 : i2;
        } else {
            return Math.min(i3, i2);
        }
    }

    private int getGravity(LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1629243729")) {
            return layoutParams.j() ? layoutParams.b : this.config.a();
        }
        return ((Integer) ipChange.ipc$dispatch("-1629243729", new Object[]{this, layoutParams})).intValue();
    }

    private float getWeight(LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1297607306")) {
            return layoutParams.q() ? layoutParams.c : this.config.d();
        }
        return ((Float) ipChange.ipc$dispatch("1297607306", new Object[]{this, layoutParams})).floatValue();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "451405098")) {
            return layoutParams instanceof LayoutParams;
        }
        return ((Boolean) ipChange.ipc$dispatch("451405098", new Object[]{this, layoutParams})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586938468")) {
            return ((Boolean) ipChange.ipc$dispatch("586938468", new Object[]{this, canvas, view, Long.valueOf(j)})).booleanValue();
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        drawDebugInfo(canvas, view);
        return drawChild;
    }

    public int getLayoutDirection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496205103")) {
            return ((Integer) ipChange.ipc$dispatch("1496205103", new Object[]{this})).intValue();
        }
        LayoutConfiguration layoutConfiguration = this.config;
        if (layoutConfiguration == null) {
            return 0;
        }
        return layoutConfiguration.b();
    }

    public int getOrientation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2095487220")) {
            return this.config.c();
        }
        return ((Integer) ipChange.ipc$dispatch("2095487220", new Object[]{this})).intValue();
    }

    public int getShowLineLimit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1042844634")) {
            return this.showLineLimit;
        }
        return ((Integer) ipChange.ipc$dispatch("1042844634", new Object[]{this})).intValue();
    }

    public float getWeightDefault() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1607624584")) {
            return this.config.d();
        }
        return ((Float) ipChange.ipc$dispatch("-1607624584", new Object[]{this})).floatValue();
    }

    public boolean isDebugDraw() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1955170694")) {
            return this.config.e();
        }
        return ((Boolean) ipChange.ipc$dispatch("1955170694", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339602686")) {
            ipChange.ipc$dispatch("-339602686", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.j + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutParams.k + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.j + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + childAt.getMeasuredWidth(), layoutParams.k + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440879824")) {
            ipChange.ipc$dispatch("1440879824", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = this.config.c() == 0 ? size : size2;
        if (this.config.c() == 0) {
            size = size2;
        }
        if (this.config.c() != 0) {
            mode = mode2;
        }
        this.config.c();
        this.lines.clear();
        a aVar = new a(i5, this.config);
        this.lines.add(aVar);
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
                layoutParams.c(this.config.c());
                if (this.config.c() == 0) {
                    layoutParams.n(childAt.getMeasuredWidth());
                    layoutParams.p(childAt.getMeasuredHeight());
                } else {
                    layoutParams.n(childAt.getMeasuredHeight());
                    layoutParams.p(childAt.getMeasuredWidth());
                }
                boolean z = layoutParams.a || (mode != 0 && !aVar.e(childAt));
                if ((this.singleLine || this.showLineLimit <= this.lines.size()) && z) {
                    childAt.setVisibility(8);
                    break;
                }
                if (z) {
                    aVar = new a(i5, this.config);
                    if (this.config.c() == 1 && this.config.b() == 1) {
                        this.lines.add(0, aVar);
                    } else {
                        this.lines.add(aVar);
                    }
                }
                if (this.config.c() == 0) {
                    if (this.config.b() == 1) {
                        aVar.c(0, childAt);
                    }
                }
                aVar.d(childAt);
            }
            i6++;
        }
        calculateLinesAndChildPosition(this.lines);
        int size3 = this.lines.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size3; i8++) {
            i7 = Math.max(i7, this.lines.get(i8).f());
        }
        int h = aVar.h() + aVar.i();
        applyGravityToLines(this.lines, findSize(mode, i5, i7), findSize(mode2, size, h));
        for (int i9 = 0; i9 < size3; i9++) {
            a aVar2 = this.lines.get(i9);
            applyGravityToLine(aVar2);
            applyPositionsToViews(aVar2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.config.c() == 0) {
            i4 = paddingLeft + i7;
            i3 = paddingBottom + h;
        } else {
            i4 = paddingLeft + h;
            i3 = paddingBottom + i7;
        }
        setMeasuredDimension(ViewGroup.resolveSize(i4, i), ViewGroup.resolveSize(i3, i2));
    }

    public void setDebugDraw(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540304462")) {
            ipChange.ipc$dispatch("1540304462", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.config.f(z);
        invalidate();
    }

    public void setGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445319404")) {
            ipChange.ipc$dispatch("-1445319404", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.g(i);
        requestLayout();
    }

    public void setLayoutDirection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450876091")) {
            ipChange.ipc$dispatch("450876091", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.h(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455657878")) {
            ipChange.ipc$dispatch("1455657878", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.i(i);
        requestLayout();
    }

    public void setShowLineLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652519024")) {
            ipChange.ipc$dispatch("1652519024", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.showLineLimit = i;
    }

    public void setSingleLine(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575233987")) {
            ipChange.ipc$dispatch("1575233987", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.singleLine = z;
    }

    public void setWeightDefault(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092349100")) {
            ipChange.ipc$dispatch("1092349100", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.config.j(f);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "18700508")) {
            return new LayoutParams(-2, -2);
        }
        return (LayoutParams) ipChange.ipc$dispatch("18700508", new Object[]{this});
    }

    public int getGravity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1513492042")) {
            return this.config.a();
        }
        return ((Integer) ipChange.ipc$dispatch("-1513492042", new Object[]{this})).intValue();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1624220887")) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) ipChange.ipc$dispatch("1624220887", new Object[]{this, attributeSet});
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "826067368")) {
            return new LayoutParams(layoutParams);
        }
        return (LayoutParams) ipChange.ipc$dispatch("826067368", new Object[]{this, layoutParams});
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static transient /* synthetic */ IpChange $ipChange;
        public boolean a = false;
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 48, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = "CENTER"), @ViewDebug.IntToString(from = 119, to = "FILL")})
        public int b = 0;
        public float c = -1.0f;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            k(context, attributeSet);
        }

        private void k(Context context, AttributeSet attributeSet) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1144955840")) {
                ipChange.ipc$dispatch("-1144955840", new Object[]{this, context, attributeSet});
                return;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout_LayoutParams);
            try {
                this.a = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_LayoutParams_layout_newLine, false);
                this.b = obtainStyledAttributes.getInt(R$styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.c = obtainStyledAttributes.getFloat(R$styleable.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-388518968")) {
                ipChange.ipc$dispatch("-388518968", new Object[]{this, Integer.valueOf(i2)});
            } else if (i2 == 0) {
                this.d = ((ViewGroup.MarginLayoutParams) this).leftMargin + ((ViewGroup.MarginLayoutParams) this).rightMargin;
                this.e = ((ViewGroup.MarginLayoutParams) this).topMargin + ((ViewGroup.MarginLayoutParams) this).bottomMargin;
            } else {
                this.d = ((ViewGroup.MarginLayoutParams) this).topMargin + ((ViewGroup.MarginLayoutParams) this).bottomMargin;
                this.e = ((ViewGroup.MarginLayoutParams) this).leftMargin + ((ViewGroup.MarginLayoutParams) this).rightMargin;
            }
        }

        /* access modifiers changed from: package-private */
        public int d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1458124155")) {
                return this.f;
            }
            return ((Integer) ipChange.ipc$dispatch("-1458124155", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-72570671")) {
                return this.i;
            }
            return ((Integer) ipChange.ipc$dispatch("-72570671", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int f() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "862100278")) {
                return this.g;
            }
            return ((Integer) ipChange.ipc$dispatch("862100278", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "154136267")) {
                return this.d;
            }
            return ((Integer) ipChange.ipc$dispatch("154136267", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int h() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "158389963")) {
                return this.e;
            }
            return ((Integer) ipChange.ipc$dispatch("158389963", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int i() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1470148992")) {
                return this.h;
            }
            return ((Integer) ipChange.ipc$dispatch("-1470148992", new Object[]{this})).intValue();
        }

        public boolean j() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1851358515")) {
                return this.b != 0;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1851358515", new Object[]{this})).booleanValue();
        }

        /* access modifiers changed from: package-private */
        public void l(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1238740261")) {
                ipChange.ipc$dispatch("1238740261", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            this.f = i2;
        }

        /* access modifiers changed from: package-private */
        public void m(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "699772657")) {
                ipChange.ipc$dispatch("699772657", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            this.i = i2;
        }

        /* access modifiers changed from: package-private */
        public void n(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1729465900")) {
                ipChange.ipc$dispatch("1729465900", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            this.g = i2;
        }

        /* access modifiers changed from: package-private */
        public void o(int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "809411572")) {
                ipChange.ipc$dispatch("809411572", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            this.j = i2;
            this.k = i3;
        }

        /* access modifiers changed from: package-private */
        public void p(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-161391478")) {
                ipChange.ipc$dispatch("-161391478", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            this.h = i2;
        }

        public boolean q() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1883515381")) {
                return this.c >= 0.0f;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1883515381", new Object[]{this})).booleanValue();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.config = new LayoutConfiguration(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.config = new LayoutConfiguration(context, attributeSet);
    }
}
