package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.ca;
import com.xiaomi.push.service.u;

/* compiled from: Taobao */
public class hi {
    public static boolean a(Context context) {
        return !ca.f956a.isEmpty() && bj.e(context) && j.m690b(context);
    }

    public static boolean a(Context context, int i) {
        if (context != null && i > 0) {
            String a = u.m871a(context);
            if (!TextUtils.isEmpty(a)) {
                for (int i2 = 1; i2 <= i; i2++) {
                    if (g.a(10) == w.a(a.substring(a.length() - 1, a.length()), -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
