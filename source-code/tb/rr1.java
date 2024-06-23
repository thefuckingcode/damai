package tb;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import cn.damai.commonbusiness.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
public class rr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private int b;
    private PopupWindow c;

    public rr1(View view, int i) {
        this.a = view;
        this.b = i;
    }

    public static int b(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301321258")) {
            return ((Integer) ipChange.ipc$dispatch("-301321258", new Object[]{activity})).intValue();
        }
        try {
            Resources resources = activity.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793172465")) {
            return ((Integer) ipChange.ipc$dispatch("-1793172465", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public PopupWindow c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "776960665")) {
            return this.c;
        }
        return (PopupWindow) ipChange.ipc$dispatch("776960665", new Object[]{this});
    }

    public int d(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134393459")) {
            return ((Integer) ipChange.ipc$dispatch("2134393459", new Object[]{this, activity})).intValue();
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService(v.ATTACH_MODE_WINDOW);
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            Display.getRealSize(windowManager.getDefaultDisplay(), point);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656866526")) {
            return ((Integer) ipChange.ipc$dispatch("-1656866526", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1443593438")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("-1443593438", new Object[]{this})).intValue();
    }

    public rr1 g(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067241378")) {
            return (rr1) ipChange.ipc$dispatch("-2067241378", new Object[]{this, activity});
        }
        int i = DisplayMetrics.getheightPixels(activity.getResources().getDisplayMetrics());
        double d = ((double) i) * 0.8d;
        if (((double) this.b) > d) {
            this.b = (int) d;
        }
        PopupWindow popupWindow = new PopupWindow(this.a, -1, -1);
        this.c = popupWindow;
        if (Build.VERSION.SDK_INT > 21) {
            popupWindow.setClippingEnabled(false);
        } else {
            popupWindow.setHeight(i);
        }
        this.c.setFocusable(true);
        this.c.setBackgroundDrawable(new BitmapDrawable());
        this.c.setOutsideTouchable(true);
        this.c.setTouchable(true);
        if (activity.isFinishing()) {
            return this;
        }
        if (h(activity)) {
            this.c.showAtLocation(this.a, 80, 0, b(activity));
        } else {
            this.c.showAtLocation(this.a, 80, 0, 0);
        }
        this.c.setAnimationStyle(R$style.pop_animation);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    public boolean h(Activity activity) {
        int i;
        int i2;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2095709901")) {
            return ((Boolean) ipChange.ipc$dispatch("2095709901", new Object[]{this, activity})).booleanValue();
        } else if (activity == null) {
            return false;
        } else {
            Rect rect = new Rect();
            try {
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                try {
                    i2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
                    try {
                        i = (d(activity) - e()) - a();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        i = 0;
                        if (i2 == i) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    i2 = 0;
                    e.printStackTrace();
                    i = 0;
                    if (i2 == i) {
                    }
                }
                if (i2 == i) {
                    return true;
                }
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
    }
}
