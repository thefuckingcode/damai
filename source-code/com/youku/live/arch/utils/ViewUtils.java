package com.youku.live.arch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gl1;
import tb.v;

/* compiled from: Taobao */
public class ViewUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean mHasCheckAllScreen = false;
    private static boolean mIsAllScreenDevice = false;
    private static int sScreenHeight = -1;
    private static int sScreenWidth = -1;

    public static void addView(ViewGroup viewGroup, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1341575632")) {
            ipChange.ipc$dispatch("1341575632", new Object[]{viewGroup, view});
        } else if (view != null && viewGroup != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    if (!parent.equals(viewGroup)) {
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(view);
                        }
                    } else {
                        return;
                    }
                }
                viewGroup.addView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        if ("0".equals(r1) != false) goto L_0x0098;
     */
    public static boolean checkNavigationBarShow(@NonNull Context context) {
        int i;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1116596609")) {
            return ((Boolean) ipChange.ipc$dispatch("-1116596609", new Object[]{context})).booleanValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            if (!isMIUI()) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
                if (Build.VERSION.SDK_INT < 21) {
                    i = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                } else {
                    i = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                }
                if (!"1".equals(str) && 1 != i) {
                }
                z = false;
                return z;
            } else if (Build.VERSION.SDK_INT >= 17) {
                if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
                    return z;
                }
                z = false;
                return z;
            }
            z = z2;
            return z;
        } catch (Exception unused) {
            return z2;
        }
    }

    public static void forceActivityOrientationLandscape(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561004202")) {
            ipChange.ipc$dispatch("-561004202", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(0);
        }
    }

    public static void forceActivityOrientationPortrait(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661944802")) {
            ipChange.ipc$dispatch("661944802", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(1);
        }
    }

    public static void forceActivityOrientationSensor(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "830341155")) {
            ipChange.ipc$dispatch("830341155", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(4);
        }
    }

    public static void forceActivityOrientationSensorLandscape(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941767376")) {
            ipChange.ipc$dispatch("-1941767376", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(6);
        }
    }

    public static Activity getActivity(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014803612")) {
            return (Activity) ipChange.ipc$dispatch("-2014803612", new Object[]{context});
        } else if (context == null || !(context instanceof ContextWrapper)) {
            return null;
        } else {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
    }

    public static int getDpi(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133667519")) {
            return ((Integer) ipChange.ipc$dispatch("-133667519", new Object[]{context})).intValue();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getNavigationBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "592099274")) {
            return ((Integer) ipChange.ipc$dispatch("592099274", new Object[]{context})).intValue();
        } else if (checkNavigationBarShow(context)) {
            return getDpi(context) - getScreenHeight(context);
        } else {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    public static int[] getScreenConfig(Context context) {
        int i;
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843423041")) {
            return (int[]) ipChange.ipc$dispatch("1843423041", new Object[]{context});
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        if (Build.VERSION.SDK_INT >= 21) {
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
                i = 1;
                int[] iArr = new int[3];
                iArr[0] = i2 < i3 ? i2 : i3;
                if (i2 >= i3) {
                    i2 = i3;
                }
                iArr[1] = i2;
                iArr[2] = i;
                return iArr;
            }
        }
        i = 0;
        int[] iArr2 = new int[3];
        iArr2[0] = i2 < i3 ? i2 : i3;
        if (i2 >= i3) {
        }
        iArr2[1] = i2;
        iArr2[2] = i;
        return iArr2;
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928999333")) {
            return ((Integer) ipChange.ipc$dispatch("-1928999333", new Object[]{context})).intValue();
        }
        if (sScreenHeight < 0) {
            Resources resources = context.getResources();
            sScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(resources.getDisplayMetrics());
            sScreenHeight = i;
            int i2 = sScreenWidth;
            if (i > i2) {
                i = i2;
            }
            sScreenWidth = i;
        }
        return sScreenHeight;
    }

    public static int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947278050")) {
            return ((Integer) ipChange.ipc$dispatch("-1947278050", new Object[]{context})).intValue();
        }
        if (sScreenWidth < 0) {
            Resources resources = context.getResources();
            sScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(resources.getDisplayMetrics());
            sScreenHeight = i;
            int i2 = sScreenWidth;
            if (i > i2) {
                i = i2;
            }
            sScreenWidth = i;
        }
        return sScreenWidth;
    }

    public static boolean isAllScreenDevice(Activity activity) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598035642")) {
            return ((Boolean) ipChange.ipc$dispatch("-1598035642", new Object[]{activity})).booleanValue();
        } else if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        } else {
            mHasCheckAllScreen = true;
            mIsAllScreenDevice = false;
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            WindowManager windowManager = (WindowManager) activity.getSystemService(v.ATTACH_MODE_WINDOW);
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

    public static boolean isMIUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31353771")) {
            return ((Boolean) ipChange.ipc$dispatch("31353771", new Object[0])).booleanValue();
        }
        if ("xiaomi".equalsIgnoreCase(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER())) {
            return true;
        }
        return false;
    }

    public static void removeFromParent(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170815881")) {
            ipChange.ipc$dispatch("170815881", new Object[]{view});
        } else if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865291394")) {
            ipChange.ipc$dispatch("-1865291394", new Object[]{activity});
        } else if (activity != null) {
            View decorView = activity.getWindow().getDecorView();
            int i = Build.VERSION.SDK_INT;
            if (i < 16 || i >= 19) {
                if (i >= 19 && decorView != null) {
                    decorView.setSystemUiVisibility(5894);
                }
            } else if (decorView != null) {
                decorView.setSystemUiVisibility(6);
            }
        }
    }

    public static void setNotFullScreen(Activity activity) {
        View decorView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600204935")) {
            ipChange.ipc$dispatch("1600204935", new Object[]{activity});
        } else if (activity != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setSystemUiVisibility(0);
        }
    }
}
