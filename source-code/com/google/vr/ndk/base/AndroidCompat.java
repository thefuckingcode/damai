package com.google.vr.ndk.base;

import android.app.Activity;
import com.google.vr.cardboard.annotations.UsedByReflection;
import tb.f5;

@UsedByReflection("Unity")
/* compiled from: Taobao */
public final class AndroidCompat {
    private AndroidCompat() {
    }

    @UsedByReflection("Unity")
    public static void setSustainedPerformanceMode(Activity activity, boolean z) {
        f5.g(activity, z);
    }

    @UsedByReflection("Unity")
    public static boolean setVrModeEnabled(Activity activity, boolean z) {
        return f5.h(activity, z);
    }
}
