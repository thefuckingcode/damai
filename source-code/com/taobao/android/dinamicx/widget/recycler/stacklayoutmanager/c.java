package com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager;

import com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager;

/* compiled from: Taobao */
public class c {
    StackLayoutManager.ScrollOrientation a = StackLayoutManager.ScrollOrientation.LEFT;
    int b = 4;
    float c = 50.0f;
    boolean d = true;
    public boolean e;
    float f;
    float g;

    public c a(boolean z) {
        this.e = z;
        return this;
    }

    public c b(float f2) {
        this.g = f2;
        return this;
    }

    public c c(float f2) {
        this.f = f2;
        return this;
    }

    public c d(StackLayoutManager.ScrollOrientation scrollOrientation) {
        this.a = scrollOrientation;
        return this;
    }

    public c e(boolean z) {
        this.d = z;
        return this;
    }

    public c f(float f2) {
        this.c = f2;
        return this;
    }

    public c g(int i) {
        this.b = i;
        return this;
    }
}
