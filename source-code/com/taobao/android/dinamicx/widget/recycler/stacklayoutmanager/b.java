package com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager;

/* compiled from: Taobao */
public class b {
    protected StackLayoutManager.ScrollOrientation a;
    protected int b;
    protected float c;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[StackLayoutManager.ScrollOrientation.values().length];
            a = iArr;
            iArr[StackLayoutManager.ScrollOrientation.LEFT.ordinal()] = 1;
            a[StackLayoutManager.ScrollOrientation.RIGHT.ordinal()] = 2;
            a[StackLayoutManager.ScrollOrientation.TOP.ordinal()] = 3;
            try {
                a[StackLayoutManager.ScrollOrientation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public b(StackLayoutManager.ScrollOrientation scrollOrientation, int i2, float f2) {
        this.a = scrollOrientation;
        this.b = i2;
        this.c = f2;
    }

    private int b(int i2, float f2) {
        int i3 = a.a[this.a.ordinal()];
        if (i3 == 1) {
            return (int) (((float) this.g) + (this.c * (((float) i2) - f2)));
        }
        if (i3 != 2) {
            return this.e / 2;
        }
        return (int) (((float) this.g) - (this.c * (((float) i2) - f2)));
    }

    private int c(int i2, float f2) {
        int i3 = a.a[this.a.ordinal()];
        if (i3 == 3) {
            return (int) (((float) this.g) + (this.c * (((float) i2) - f2)));
        }
        if (i3 != 4) {
            return this.f / 2;
        }
        return (int) (((float) this.g) - (this.c * (((float) i2) - f2)));
    }

    private int d() {
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 1) {
            return this.g - (this.j % this.h);
        }
        if (i2 != 2) {
            return this.e / 2;
        }
        int i3 = this.j;
        int i4 = this.h;
        if (i3 % i4 == 0) {
            return this.g;
        }
        return this.g + (i4 - (i3 % i4));
    }

    private int e() {
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 3) {
            return this.g - (this.j % this.i);
        }
        if (i2 != 4) {
            return this.f / 2;
        }
        int i3 = this.j;
        int i4 = this.i;
        if (i3 % i4 == 0) {
            return this.g;
        }
        return this.g + (i4 - (i3 % i4));
    }

    private int f() {
        float f2;
        float f3;
        int max;
        float f4;
        float f5;
        float f6;
        int max2;
        int i2 = a.a[this.a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                f5 = (float) this.e;
                f6 = this.c;
                max2 = Math.max(0, this.b - 1);
            } else if (i2 != 3) {
                f5 = (float) this.f;
                f6 = this.c;
                max2 = Math.max(0, this.b - 1);
            } else {
                f2 = (float) this.f;
                f3 = this.c;
                max = Math.max(0, this.b - 1);
                f4 = f2 - (f3 * ((float) max));
            }
            f4 = f5 + (f6 * ((float) max2));
        } else {
            f2 = (float) this.e;
            f3 = this.c;
            max = Math.max(0, this.b - 1);
            f4 = f2 - (f3 * ((float) max));
        }
        return (int) (f4 / 2.0f);
    }

    /* access modifiers changed from: package-private */
    public void a(StackLayoutManager stackLayoutManager, int i2, float f2, View view, int i3, a aVar) {
        int i4;
        int i5;
        this.h = stackLayoutManager.getWidth();
        this.i = stackLayoutManager.getHeight();
        this.j = i2;
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            childAt.setClickable(true);
            childAt.setFocusable(true);
        }
        int decoratedMeasuredWidth = childAt == null ? stackLayoutManager.getDecoratedMeasuredWidth(view) : childAt.getMeasuredWidth();
        int decoratedMeasuredHeight = childAt == null ? stackLayoutManager.getDecoratedMeasuredHeight(view) : childAt.getMeasuredHeight();
        if (!this.d) {
            this.e = this.h - decoratedMeasuredWidth;
            this.f = this.i - decoratedMeasuredHeight;
            this.g = f();
            this.d = true;
        }
        if (i3 == 0) {
            i5 = d();
            i4 = e();
        } else {
            i5 = b(i3, f2);
            i4 = c(i3, f2);
        }
        float b2 = aVar.b(f2, i3);
        int i6 = a.a[this.a.ordinal()];
        if (i6 == 1) {
            i5 += (int) ((((float) decoratedMeasuredWidth) * (1.0f - b2)) / 2.0f);
        } else if (i6 == 2) {
            i5 -= (int) ((((float) decoratedMeasuredWidth) * (1.0f - b2)) / 2.0f);
        } else if (i6 == 3) {
            i4 += (int) ((((float) decoratedMeasuredWidth) * (1.0f - b2)) / 2.0f);
        } else if (i6 == 4) {
            i4 -= (int) ((((float) decoratedMeasuredHeight) * (1.0f - b2)) / 2.0f);
        }
        stackLayoutManager.layoutDecorated(view, i5, i4, i5 + decoratedMeasuredWidth, i4 + decoratedMeasuredHeight);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.d = false;
    }
}
