package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.responsive.IConfig;

/* compiled from: Taobao */
public class f12 {
    private static int a = -1;

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Context b(View view) {
        Context context = view.getContext();
        return (!(context instanceof Activity) && view.getParent() != null) ? b((View) view.getParent()) : context;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Display display = null;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode()) {
                return e(activity);
            }
            display = activity.getWindowManager().getDefaultDisplay();
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
            if (windowManager != null) {
                display = windowManager.getDefaultDisplay();
            }
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (display != null) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display, displayMetrics);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Display display = null;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode()) {
                return g(activity);
            }
            display = activity.getWindowManager().getDefaultDisplay();
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
            if (windowManager != null) {
                display = windowManager.getDefaultDisplay();
            }
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (display != null) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display, displayMetrics);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static int e(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        Activity activity = (Activity) context;
        return (int) Math.round(((double) (((float) activity.getResources().getConfiguration().screenHeightDp) * activity.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int f(Context context) {
        Display defaultDisplay;
        if (!(context instanceof Activity) || (defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay()) == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int g(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        Activity activity = (Activity) context;
        return (int) Math.round(((double) (((float) activity.getResources().getConfiguration().screenWidthDp) * activity.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int h(Context context) {
        Display defaultDisplay;
        if (!(context instanceof Activity) || (defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay()) == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static boolean i(Context context) {
        int i = a;
        if (i != -1) {
            return i == 1;
        }
        IConfig a2 = x02.c().a();
        if (a2 == null || a2.isOpenResponsiveSwitch()) {
            if (d70.m(context) || d70.g(context) || d70.c()) {
                a = 1;
            } else {
                a = 0;
            }
            if (a == 1) {
                return true;
            }
            return false;
        }
        a = 0;
        return !true;
    }
}
