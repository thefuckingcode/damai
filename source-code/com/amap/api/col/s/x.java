package com.amap.api.col.s;

import android.content.Context;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class x<T, V> extends b<T, V> {
    public x(Context context, T t) {
        super(context, t);
    }

    protected static boolean c(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
