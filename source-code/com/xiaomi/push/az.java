package com.xiaomi.push;

import android.content.Context;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class az {
    static int a;

    public static au a(Context context) {
        if (m.m734a()) {
            a = 1;
            return new ay(context);
        } else if (as.a(context)) {
            a = 2;
            return new as(context);
        } else if (bb.a(context)) {
            a = 4;
            return new bb(context);
        } else if (bf.a(context)) {
            a = 5;
            return new bf(context);
        } else if (ax.a(context)) {
            a = 3;
            return new av(context);
        } else {
            a = 0;
            return new be();
        }
    }
}
