package com.youku.live.livesdk.wkit.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import tb.v;

/* compiled from: Taobao */
public class UIUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile boolean mHasCheckAllScreen;
    private static volatile boolean mIsAllScreenDevice;

    public static int getCurrentNavigationBarHeight(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459181763")) {
            return ((Integer) ipChange.ipc$dispatch("1459181763", new Object[]{activity})).intValue();
        } else if (isNavigationBarShown(activity)) {
            return getNavigationBarHeight(activity);
        } else {
            return 0;
        }
    }

    public static String getDeviceInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788684327")) {
            return (String) ipChange.ipc$dispatch("-788684327", new Object[0]);
        }
        String brand = Build.getBRAND();
        if (TextUtils.isEmpty(brand) || brand.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        }
        if (brand.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        }
        if (!brand.equalsIgnoreCase("VIVO") && !brand.equalsIgnoreCase("OPPO")) {
            return "navigationbar_is_min";
        }
        return "navigation_gesture_on";
    }

    public static int getNavigationBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812563874")) {
            return ((Integer) ipChange.ipc$dispatch("1812563874", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @RequiresApi(api = 17)
    public static int getNavigationBarHeightIfRoom(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362290778")) {
            return ((Integer) ipChange.ipc$dispatch("362290778", new Object[]{context})).intValue();
        } else if (navigationGestureEnabled(context)) {
            return 0;
        } else {
            return getCurrentNavigationBarHeight((Activity) context);
        }
    }

    public static boolean isAllScreenDevice(Context context) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783677692")) {
            return ((Boolean) ipChange.ipc$dispatch("-1783677692", new Object[]{context})).booleanValue();
        } else if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        } else {
            mHasCheckAllScreen = true;
            mIsAllScreenDevice = false;
            if (Build.VERSION.SDK_INT < 21 || context == null) {
                return false;
            }
            WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW);
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point);
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                if (xVar < yVar) {
                    f = (float) xVar;
                    f2 = (float) yVar;
                } else {
                    float f3 = (float) yVar;
                    f2 = (float) xVar;
                    f = f3;
                }
                if (f2 / f >= 1.97f) {
                    mIsAllScreenDevice = true;
                }
            }
            return mIsAllScreenDevice;
        }
    }

    public static boolean isNavigationBarShown(Activity activity) {
        int visibility;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477907005")) {
            return ((Boolean) ipChange.ipc$dispatch("-1477907005", new Object[]{activity})).booleanValue();
        }
        View findViewById = activity.findViewById(16908336);
        return (findViewById == null || (visibility = findViewById.getVisibility()) == 8 || visibility == 4) ? false : true;
    }

    @RequiresApi(api = 17)
    public static boolean navigationGestureEnabled(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1139585169")) {
            return Settings.Global.getInt(context.getContentResolver(), getDeviceInfo(), 0) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1139585169", new Object[]{context})).booleanValue();
    }
}
