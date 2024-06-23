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
import com.alibaba.pictures.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final View a;
    private int b;
    @Nullable
    private PopupWindow c;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final int a(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1743925177")) {
                return ((Integer) ipChange.ipc$dispatch("-1743925177", new Object[]{this, activity})).intValue();
            }
            k21.i(activity, "activity");
            try {
                Resources resources = activity.getResources();
                return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    public qr1(@NotNull View view, int i) {
        k21.i(view, "contentView");
        this.a = view;
        this.b = i;
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663169798")) {
            return ((Integer) ipChange.ipc$dispatch("663169798", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Nullable
    public final PopupWindow b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1754664240")) {
            return this.c;
        }
        return (PopupWindow) ipChange.ipc$dispatch("-1754664240", new Object[]{this});
    }

    public final int c(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180547562")) {
            return ((Integer) ipChange.ipc$dispatch("180547562", new Object[]{this, activity})).intValue();
        }
        k21.i(activity, "activity");
        Object systemService = activity.getSystemService(v.ATTACH_MODE_WINDOW);
        k21.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            Display.getRealSize(windowManager.getDefaultDisplay(), point);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
    }

    public final int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877668555")) {
            return ((Integer) ipChange.ipc$dispatch("1877668555", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public final int e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1291479207")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("-1291479207", new Object[]{this})).intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    public final boolean f(@Nullable Activity activity) {
        int i;
        int i2;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435915004")) {
            return ((Boolean) ipChange.ipc$dispatch("-435915004", new Object[]{this, activity})).booleanValue();
        } else if (activity == null) {
            return false;
        } else {
            Rect rect = new Rect();
            try {
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                try {
                    i2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
                    try {
                        i = (c(activity) - d()) - a();
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

    @NotNull
    public final qr1 g(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416951434")) {
            return (qr1) ipChange.ipc$dispatch("1416951434", new Object[]{this, activity});
        }
        k21.i(activity, "activity");
        int i = DisplayMetrics.getheightPixels(activity.getResources().getDisplayMetrics());
        int i2 = this.b;
        double d = ((double) i) * 0.8d;
        if (((double) i2) > d || i2 < 0) {
            this.b = (int) d;
        }
        PopupWindow popupWindow = new PopupWindow(this.a, -1, -1);
        this.c = popupWindow;
        if (Build.VERSION.SDK_INT > 21) {
            k21.f(popupWindow);
            popupWindow.setClippingEnabled(false);
        } else {
            k21.f(popupWindow);
            popupWindow.setHeight(i);
        }
        PopupWindow popupWindow2 = this.c;
        k21.f(popupWindow2);
        popupWindow2.setFocusable(true);
        PopupWindow popupWindow3 = this.c;
        k21.f(popupWindow3);
        popupWindow3.setBackgroundDrawable(new BitmapDrawable());
        PopupWindow popupWindow4 = this.c;
        k21.f(popupWindow4);
        popupWindow4.setOutsideTouchable(true);
        PopupWindow popupWindow5 = this.c;
        k21.f(popupWindow5);
        popupWindow5.setTouchable(true);
        if (activity.isFinishing()) {
            return this;
        }
        if (f(activity)) {
            PopupWindow popupWindow6 = this.c;
            k21.f(popupWindow6);
            popupWindow6.showAtLocation(this.a, 80, 0, Companion.a(activity));
        } else {
            PopupWindow popupWindow7 = this.c;
            k21.f(popupWindow7);
            popupWindow7.showAtLocation(this.a, 80, 0, 0);
        }
        PopupWindow popupWindow8 = this.c;
        k21.f(popupWindow8);
        popupWindow8.setAnimationStyle(R$style.bricks_pop_animation);
        return this;
    }
}
