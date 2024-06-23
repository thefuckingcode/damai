package com.ali.user.mobile.utils;

import android.app.Activity;
import android.content.Context;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;

/* compiled from: Taobao */
public class ScreenUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int pxTodip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void setOrientation(Activity activity) {
        if (DataProviderFactory.getDataProvider().getOrientation() != 0) {
            if (activity.getResources().getConfiguration().orientation == 2) {
                activity.setRequestedOrientation(1);
            }
            activity.getWindow().setSoftInputMode(18);
        } else if (activity.getResources().getConfiguration().orientation == 1) {
            activity.setRequestedOrientation(0);
        }
    }
}
