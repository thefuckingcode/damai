package com.alibaba.android.bindingx.core.internal;

import android.text.TextUtils;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class h {
    String a;
    double b = 0.0d;
    double c = 0.0d;
    double d = 0.0d;
    boolean e = true;

    h() {
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, double d3, double d4, String str) {
        this.b = d2;
        this.c = d3;
        this.d = d4;
        if (TextUtils.isEmpty(str)) {
            str = "XYZ";
        }
        this.a = str;
    }
}
