package com.youku.live.dago.widgetlib.interactive.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v;

/* compiled from: Taobao */
public class DensityUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "546289423")) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("546289423", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298675053")) {
            return ((Integer) ipChange.ipc$dispatch("1298675053", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static final int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319138868")) {
            return ((Integer) ipChange.ipc$dispatch("-319138868", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static int getWindowHeight(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426503887")) {
            return ((Integer) ipChange.ipc$dispatch("426503887", new Object[]{activity})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int getWindowWidth(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996093272")) {
            return ((Integer) ipChange.ipc$dispatch("996093272", new Object[]{activity})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static int px2dip(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "251612285")) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("251612285", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static int sp2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "658557285")) {
            return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("658557285", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static int getWindowHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-284528655")) {
            return ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getHeight();
        }
        return ((Integer) ipChange.ipc$dispatch("-284528655", new Object[]{context})).intValue();
    }

    public static int getWindowWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1062946616")) {
            return ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getWidth();
        }
        return ((Integer) ipChange.ipc$dispatch("-1062946616", new Object[]{context})).intValue();
    }
}
