package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.gaiax.GXTemplateEngine;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class kq0 {
    @NotNull
    public static final kq0 INSTANCE = new kq0();
    private static float a;
    private static float b;
    @NotNull
    private static final DisplayMetrics c = new DisplayMetrics();

    private kq0() {
    }

    private final float a(float f) {
        return f / (((float) Resources.getSystem().getDisplayMetrics().densityDpi) / ((float) 160));
    }

    private final void d(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            a = (float) activity.getWindow().getDecorView().getMeasuredWidth();
            float measuredHeight = (float) activity.getWindow().getDecorView().getMeasuredHeight();
            b = measuredHeight;
            boolean z = true;
            if (!(a == 0.0f)) {
                if (!(measuredHeight == 0.0f)) {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode()) {
                a = (float) Math.round(((double) (((float) activity.getResources().getConfiguration().screenWidthDp) * activity.getResources().getDisplayMetrics().density)) + 0.5d);
                float round = (float) Math.round(((double) (((float) activity.getResources().getConfiguration().screenHeightDp) * activity.getResources().getDisplayMetrics().density)) + 0.5d);
                b = round;
                if (!(a == 0.0f)) {
                    if (round != 0.0f) {
                        z = false;
                    }
                    if (!z) {
                        return;
                    }
                }
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = c;
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
            a = (float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            b = (float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            return;
        }
        Object systemService = GXTemplateEngine.Companion.a().k().getSystemService(v.ATTACH_MODE_WINDOW);
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            Display defaultDisplay2 = windowManager.getDefaultDisplay();
            if (defaultDisplay2 != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay2, c);
            }
            DisplayMetrics displayMetrics2 = c;
            a = (float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2);
            b = (float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2);
        }
    }

    public final float b(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        d(context);
        return a(b);
    }

    public final float c(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        d(context);
        return a(a);
    }
}
