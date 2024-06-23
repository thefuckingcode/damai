package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
public class c {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable != null) {
            a.post(runnable);
        }
    }
}
