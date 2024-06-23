package cn.damai.h5container;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import tb.gl1;

/* compiled from: Taobao */
public class AndroidBug5497Workaround {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Activity activity;
    private FrameLayout.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private int statusBarHeight;
    private int usableHeightPrevious;

    private AndroidBug5497Workaround(final Activity activity2) {
        this.activity = activity2;
        if (checkDeviceHasNavigationBar(activity2)) {
            this.statusBarHeight = activity2.getResources().getDimensionPixelSize(activity2.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
        }
        View childAt = ((FrameLayout) activity2.findViewById(16908290)).getChildAt(0);
        this.mChildOfContent = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class cn.damai.h5container.AndroidBug5497Workaround.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onGlobalLayout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "759213108")) {
                    ipChange.ipc$dispatch("759213108", new Object[]{this});
                    return;
                }
                AndroidBug5497Workaround.this.possiblyResizeChildOfContent(AndroidBug5497Workaround.checkDeviceHasNavigationBar(activity2));
            }
        });
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    public static void assistActivity(Activity activity2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "818805709")) {
            ipChange.ipc$dispatch("818805709", new Object[]{activity2});
            return;
        }
        new AndroidBug5497Workaround(activity2);
    }

    /* access modifiers changed from: private */
    public static boolean checkDeviceHasNavigationBar(Activity activity2) {
        Exception e;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1500348342")) {
            return ((Boolean) ipChange.ipc$dispatch("-1500348342", new Object[]{activity2})).booleanValue();
        }
        try {
            Resources resources = activity2.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
                if ("1".equals(str)) {
                    return false;
                }
                if ("0".equals(str)) {
                    return true;
                }
                return hasNavBar(activity2);
            } catch (Exception e2) {
                e = e2;
                z = identifier > 0 ? resources.getBoolean(identifier) : false;
                Log.e("exception", e.getMessage());
                return z;
            }
        } catch (Exception e3) {
            e = e3;
            Log.e("exception", e.getMessage());
            return z;
        }
    }

    private int computeUsableHeight(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23038618")) {
            return ((Integer) ipChange.ipc$dispatch("-23038618", new Object[]{this, Boolean.valueOf(z)})).intValue();
        } else if (z) {
            Rect rect = new Rect();
            this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            int i2 = this.statusBarHeight;
            if (i < i2) {
                return rect.bottom - i2;
            }
            return rect.bottom - i;
        } else {
            Rect rect2 = new Rect();
            this.activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            int i3 = rect2.top;
            Rect rect3 = new Rect();
            this.mChildOfContent.getWindowVisibleDisplayFrame(rect3);
            if (Build.VERSION.SDK_INT >= 19) {
                return (rect3.bottom - rect3.top) + i3;
            }
            return rect3.bottom - rect3.top;
        }
    }

    private static boolean hasNavBar(Activity activity2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030383619")) {
            return ((Boolean) ipChange.ipc$dispatch("2030383619", new Object[]{activity2})).booleanValue();
        }
        Display defaultDisplay = activity2.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 19) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealMetrics(defaultDisplay, displayMetrics);
        }
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics2);
        int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2);
        if (i2 - com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) > 0 || i - i3 > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void possiblyResizeChildOfContent(boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138074176")) {
            ipChange.ipc$dispatch("-138074176", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int computeUsableHeight = computeUsableHeight(z);
        if (computeUsableHeight != this.usableHeightPrevious) {
            if (z) {
                i = this.mChildOfContent.getHeight();
            } else {
                i = this.mChildOfContent.getRootView().getHeight();
                if (Build.VERSION.SDK_INT < 19) {
                    Rect rect = new Rect();
                    this.activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    i -= rect.top;
                }
            }
            int i2 = i - computeUsableHeight;
            if (i2 > i / 4) {
                if (Build.VERSION.SDK_INT < 19 || !z) {
                    this.frameLayoutParams.height = i - i2;
                } else {
                    this.frameLayoutParams.height = (i - i2) + this.statusBarHeight;
                }
            } else if (z) {
                this.frameLayoutParams.height = this.statusBarHeight + computeUsableHeight;
            } else {
                this.frameLayoutParams.height = i;
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = computeUsableHeight;
        }
    }
}
