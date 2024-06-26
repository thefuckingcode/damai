package com.youku.live.dago.liveplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import tb.v;

/* compiled from: Taobao */
public class UIUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LANDSCAPE = 1;
    private static final int PORTRAIT = 0;
    private static volatile boolean mHasCheckAllScreen;
    private static volatile boolean mIsAllScreenDevice;
    private static volatile Point[] mRealSizes = new Point[2];

    public static final int dip2px(int i, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683707790")) {
            return ((Integer) ipChange.ipc$dispatch("683707790", new Object[]{Integer.valueOf(i), context})).intValue();
        } else if (context == null) {
            return 0;
        } else {
            return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static int dp2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1577494716")) {
            return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("1577494716", new Object[]{Float.valueOf(f)})).intValue();
    }

    public static int getFullActivityHeight(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143901713")) {
            return ((Integer) ipChange.ipc$dispatch("1143901713", new Object[]{context})).intValue();
        } else if (!isAllScreenDevice(context)) {
            return getScreenHeight(context);
        } else {
            return getScreenRealHeight(context);
        }
    }

    public static int getScreenHeight(Context context) {
        Display defaultDisplay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273513663")) {
            return ((Integer) ipChange.ipc$dispatch("273513663", new Object[]{context})).intValue();
        }
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int getScreenRealHeight(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        char c = 1;
        if (AndroidInstantRuntime.support(ipChange, "1445200381")) {
            return ((Integer) ipChange.ipc$dispatch("1445200381", new Object[]{context})).intValue();
        } else if (context == null) {
            return 0;
        } else {
            if (Build.VERSION.SDK_INT < 17) {
                return getScreenHeight(context);
            }
            if (context.getResources() == null || context.getResources().getConfiguration() == null) {
                return 0;
            }
            if (context.getResources().getConfiguration().orientation == 1) {
                c = 0;
            }
            if (mRealSizes[c] == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
                if (windowManager == null) {
                    return getScreenHeight(context);
                }
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point);
                mRealSizes[c] = point;
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(mRealSizes[c]);
        }
    }

    public static final int getScreenWidth(Context context) {
        Display defaultDisplay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75113926")) {
            return ((Integer) ipChange.ipc$dispatch("-75113926", new Object[]{context})).intValue();
        }
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9545016")) {
            return ((Integer) ipChange.ipc$dispatch("-9545016", new Object[]{context})).intValue();
        }
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isAllScreenDevice(Context context) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79706432")) {
            return ((Boolean) ipChange.ipc$dispatch("79706432", new Object[]{context})).booleanValue();
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

    @TargetApi(21)
    public static void setViewRoundedCorner(View view, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119134139")) {
            ipChange.ipc$dispatch("119134139", new Object[]{view, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 21 && view != null && i >= 0) {
            if (i > 0) {
                view.setClipToOutline(true);
            } else {
                view.setClipToOutline(false);
            }
            view.setOutlineProvider(new ViewOutlineProvider() {
                /* class com.youku.live.dago.liveplayback.UIUtils.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void getOutline(View view, Outline outline) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-124645283")) {
                        ipChange.ipc$dispatch("-124645283", new Object[]{this, view, outline});
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) i);
                }
            });
        }
    }

    public static String stampToDate(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430153845")) {
            return (String) ipChange.ipc$dispatch("1430153845", new Object[]{Long.valueOf(j)});
        }
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(j));
        Log.e("fornia", "offset url播放date点:" + format + " time url播放时间点:" + j);
        return format;
    }
}
