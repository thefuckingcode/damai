package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: Taobao */
public class NavigatorHelper {
    private SparseBooleanArray a = new SparseBooleanArray();
    private SparseArray<Float> b = new SparseArray<>();
    private int c;
    private int d;
    private int e;
    private float f;
    private int g;
    private boolean h;
    private OnNavigatorScrollListener i;

    /* compiled from: Taobao */
    public interface OnNavigatorScrollListener {
        void onDeselected(int i, int i2);

        void onEnter(int i, int i2, float f, boolean z);

        void onLeave(int i, int i2, float f, boolean z);

        void onSelected(int i, int i2);
    }

    private void a(int i2) {
        OnNavigatorScrollListener onNavigatorScrollListener = this.i;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onDeselected(i2, this.c);
        }
        this.a.put(i2, true);
    }

    private void b(int i2, float f2, boolean z, boolean z2) {
        if (this.h || i2 == this.d || this.g == 1 || z2) {
            OnNavigatorScrollListener onNavigatorScrollListener = this.i;
            if (onNavigatorScrollListener != null) {
                onNavigatorScrollListener.onEnter(i2, this.c, f2, z);
            }
            this.b.put(i2, Float.valueOf(1.0f - f2));
        }
    }

    private void c(int i2, float f2, boolean z, boolean z2) {
        if (!(this.h || i2 == this.e || this.g == 1)) {
            int i3 = this.d;
            if ((!(i2 == i3 - 1 || i2 == i3 + 1) || this.b.get(i2, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        OnNavigatorScrollListener onNavigatorScrollListener = this.i;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onLeave(i2, this.c, f2, z);
        }
        this.b.put(i2, Float.valueOf(f2));
    }

    private void d(int i2) {
        OnNavigatorScrollListener onNavigatorScrollListener = this.i;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onSelected(i2, this.c);
        }
        this.a.put(i2, false);
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.c;
    }

    public void h(int i2) {
        this.g = i2;
    }

    public void i(int i2, float f2, int i3) {
        boolean z;
        float f3 = ((float) i2) + f2;
        float f4 = this.f;
        boolean z2 = f4 <= f3;
        if (this.g == 0) {
            for (int i4 = 0; i4 < this.c; i4++) {
                if (i4 != this.d) {
                    if (!this.a.get(i4)) {
                        a(i4);
                    }
                    if (this.b.get(i4, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i4, 1.0f, false, true);
                    }
                }
            }
            b(this.d, 1.0f, false, true);
            d(this.d);
        } else if (f3 != f4) {
            int i5 = i2 + 1;
            if (f2 != 0.0f || !z2) {
                z = true;
            } else {
                i5 = i2 - 1;
                z = false;
            }
            for (int i6 = 0; i6 < this.c; i6++) {
                if (!(i6 == i2 || i6 == i5 || this.b.get(i6, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                    c(i6, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f5 = 1.0f - f2;
                c(i5, f5, true, false);
                b(i2, f5, true, false);
            } else if (z2) {
                c(i2, f2, true, false);
                b(i5, f2, true, false);
            } else {
                float f6 = 1.0f - f2;
                c(i5, f6, false, false);
                b(i2, f6, false, false);
            }
        } else {
            return;
        }
        this.f = f3;
    }

    public void j(int i2) {
        this.e = this.d;
        this.d = i2;
        d(i2);
        for (int i3 = 0; i3 < this.c; i3++) {
            if (i3 != this.d && !this.a.get(i3)) {
                a(i3);
            }
        }
    }

    public void k(OnNavigatorScrollListener onNavigatorScrollListener) {
        this.i = onNavigatorScrollListener;
    }

    public void l(boolean z) {
        this.h = z;
    }

    public void m(int i2) {
        this.c = i2;
        this.a.clear();
        this.b.clear();
    }
}
