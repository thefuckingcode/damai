package com.amap.api.col.s;

import android.content.Context;

/* compiled from: Taobao */
abstract class at<T, V> extends b<T, V> {
    public at(Context context, T t) {
        super(context, t);
    }

    public final T c_() {
        return ((a) this).b;
    }

    @Override // com.amap.api.col.s.df
    public String h() {
        return h.a() + "/weather/weatherInfo?";
    }
}
