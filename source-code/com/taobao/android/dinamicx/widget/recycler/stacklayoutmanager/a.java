package com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager;

import android.view.View;
import com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    private final float a;
    private final float b;
    protected int c;

    public a(StackLayoutManager.ScrollOrientation scrollOrientation, int i, float f, float f2) {
        this.a = f;
        this.b = f2;
        this.c = i;
    }

    /* access modifiers changed from: package-private */
    public void a(float f, View view, int i) {
        float f2 = 0.0f;
        if (i != this.c) {
            f2 = 1.0f;
        } else if (f != 0.0f) {
            float f3 = this.b;
            f2 = f3 + ((1.0f - f3) * f);
        }
        float b2 = b(f, i);
        view.setScaleY(b2);
        view.setScaleX(b2);
        view.setAlpha(f2);
    }

    public float b(float f, int i) {
        int i2;
        if (i == 0 || (i2 = this.c) == 0) {
            return 1.0f;
        }
        float f2 = (1.0f - this.a) / ((float) i2);
        float f3 = 1.0f - (((float) i) * f2);
        return (((1.0f - (f2 * ((float) (i - 1)))) - f3) * f) + f3;
    }
}
