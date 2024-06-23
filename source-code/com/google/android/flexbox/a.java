package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class a {
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;
    int c = Integer.MIN_VALUE;
    int d = Integer.MIN_VALUE;
    int e;
    int f;
    int g;
    int h;
    int i;
    float j;
    float k;
    int l;
    int m;
    List<Integer> n = new ArrayList();
    int o;
    int p;

    a() {
    }

    public int a() {
        return this.g;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.h - this.i;
    }

    /* access modifiers changed from: package-private */
    public void d(View view, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.a = Math.min(this.a, (view.getLeft() - flexItem.getMarginLeft()) - i2);
        this.b = Math.min(this.b, (view.getTop() - flexItem.getMarginTop()) - i3);
        this.c = Math.max(this.c, view.getRight() + flexItem.getMarginRight() + i4);
        this.d = Math.max(this.d, view.getBottom() + flexItem.getMarginBottom() + i5);
    }
}
