package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.responsive.IConfig;
import com.alibaba.pictures.responsive.ResponsiveManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class g12 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final g12 INSTANCE = new g12();
    private static int a = -1;

    private g12() {
    }

    @JvmStatic
    public static final int a(@NotNull Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609816663")) {
            return ((Integer) ipChange.ipc$dispatch("-609816663", new Object[]{context, Float.valueOf(f)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @JvmStatic
    @NotNull
    public static final Context c(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090551129")) {
            return (Context) ipChange.ipc$dispatch("-2090551129", new Object[]{view});
        }
        k21.i(view, "view");
        Context context = view.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            return activity;
        }
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
            context = c((View) parent);
        }
        k21.h(context, "if (view.parent != null)…           } else context");
        return context;
    }

    @JvmStatic
    public static final int d(@Nullable Context context) {
        Display display;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014073868")) {
            return ((Integer) ipChange.ipc$dispatch("2014073868", new Object[]{context})).intValue();
        } else if (context == null) {
            return 0;
        } else {
            if (!(context instanceof Activity)) {
                Object systemService = context.getSystemService(v.ATTACH_MODE_WINDOW);
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                display = ((WindowManager) systemService).getDefaultDisplay();
            } else if (Build.VERSION.SDK_INT >= 24 && ((Activity) context).isInMultiWindowMode()) {
                return INSTANCE.f(context);
            } else {
                display = ((Activity) context).getWindowManager().getDefaultDisplay();
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (display != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display, displayMetrics);
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        }
    }

    @JvmStatic
    public static final int e(@Nullable Context context) {
        Display display;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434608819")) {
            return ((Integer) ipChange.ipc$dispatch("-434608819", new Object[]{context})).intValue();
        } else if (context == null) {
            return 0;
        } else {
            if (!(context instanceof Activity)) {
                Object systemService = context.getSystemService(v.ATTACH_MODE_WINDOW);
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                display = ((WindowManager) systemService).getDefaultDisplay();
            } else if (Build.VERSION.SDK_INT >= 24 && ((Activity) context).isInMultiWindowMode()) {
                return INSTANCE.h(context);
            } else {
                display = ((Activity) context).getWindowManager().getDefaultDisplay();
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (display != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(display, displayMetrics);
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        }
    }

    public final void b(@Nullable RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-121059607")) {
            ipChange.ipc$dispatch("-121059607", new Object[]{this, recyclerView});
        } else if (recyclerView != null) {
            recyclerView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        }
    }

    public final int f(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664584699")) {
            return ((Integer) ipChange.ipc$dispatch("-1664584699", new Object[]{this, context})).intValue();
        } else if (!(context instanceof Activity)) {
            return 0;
        } else {
            Activity activity = (Activity) context;
            return tb1.a(((double) (((float) activity.getResources().getConfiguration().screenHeightDp) * activity.getResources().getDisplayMetrics().density)) + 0.5d);
        }
    }

    public final int g(@Nullable Context context) {
        Display defaultDisplay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143098096")) {
            return ((Integer) ipChange.ipc$dispatch("1143098096", new Object[]{this, context})).intValue();
        }
        if (!(context instanceof Activity) || (defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay()) == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public final int h(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426692668")) {
            return ((Integer) ipChange.ipc$dispatch("426692668", new Object[]{this, context})).intValue();
        } else if (!(context instanceof Activity)) {
            return 0;
        } else {
            Activity activity = (Activity) context;
            return tb1.a(((double) (((float) activity.getResources().getConfiguration().screenWidthDp) * activity.getResources().getDisplayMetrics().density)) + 0.5d);
        }
    }

    public final int i(@Nullable Context context) {
        Display defaultDisplay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640164647")) {
            return ((Integer) ipChange.ipc$dispatch("-1640164647", new Object[]{this, context})).intValue();
        }
        if (!(context instanceof Activity) || (defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay()) == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public final boolean j(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913698051")) {
            return ((Boolean) ipChange.ipc$dispatch("1913698051", new Object[]{this, context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int i = a;
        if (i != -1) {
            return i == 1;
        }
        IConfig b = ResponsiveManager.Companion.a().b();
        if (b == null || b.isOpenResponsiveSwitch()) {
            e70 e70 = e70.INSTANCE;
            int i2 = (e70.o(context) || e70.g(context) || e70.c()) ? 1 : 0;
            a = i2;
            if (i2 == 1) {
                return true;
            }
            return false;
        }
        a = 0;
        return !true;
    }
}
