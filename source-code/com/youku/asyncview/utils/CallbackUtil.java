package com.youku.asyncview.utils;

import android.os.Looper;

/* compiled from: Taobao */
public final class CallbackUtil {
    public static boolean isRunOnUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
