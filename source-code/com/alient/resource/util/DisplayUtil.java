package com.alient.resource.util;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: Taobao */
public class DisplayUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }
}
