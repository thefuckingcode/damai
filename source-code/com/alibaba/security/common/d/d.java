package com.alibaba.security.common.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import tb.v;

/* compiled from: Taobao */
public class d {
    private static final String a = "d";

    public static int a(Context context) {
        return (Math.min(b(context), c(context)) / 2) - a(context, 50.0f);
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static boolean d(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return false;
        }
        String configuration2 = configuration.toString();
        if (configuration2.contains("hwMultiwindow-magic") || configuration2.contains("hw-magic-windows")) {
            return true;
        }
        return false;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(Activity activity, int i) {
        if (i >= 0 && i <= 255) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.screenBrightness = ((float) i) / 255.0f;
                activity.getWindow().setAttributes(attributes);
            } catch (Throwable unused) {
            }
        }
    }
}
