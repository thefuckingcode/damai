package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.ViewUtil;
import io.flutter.wpkbridge.WPKFactory;
import java.math.BigDecimal;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class u50 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final u50 INSTANCE = new u50();
    @Nullable
    private static DisplayMetrics a;

    private u50() {
    }

    public final int a(@NotNull Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557277650")) {
            return ((Integer) ipChange.ipc$dispatch("557277650", new Object[]{this, context, Float.valueOf(f)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (context.getResources() == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int b(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557280533")) {
            return ((Integer) ipChange.ipc$dispatch("557280533", new Object[]{this, context, Integer.valueOf(i)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (context.getResources() == null) {
            return 0;
        }
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int c(@Nullable Context context, @NotNull Map<String, ? extends Object> map, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922675110")) {
            return ((Integer) ipChange.ipc$dispatch("-1922675110", new Object[]{this, context, map, str})).intValue();
        }
        k21.i(map, "data");
        k21.i(str, "paramName");
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), Constants.DIMEN);
        }
        return 0;
    }

    @Nullable
    public final DisplayMetrics d(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046253554")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-2046253554", new Object[]{this, context});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (a == null) {
            a = context.getResources().getDisplayMetrics();
        }
        return a;
    }

    public final int e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277589199")) {
            return ((Integer) ipChange.ipc$dispatch("-277589199", new Object[]{this, context})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (g12.e(context) - a(context, 25.0f)) / bd2.INSTANCE.d(context, 2);
    }

    @NotNull
    public final DisplayMetrics f(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-357217241")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-357217241", new Object[]{this, context});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((Activity) context).getWindowManager().getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }

    public final double g(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896001047")) {
            return ((Double) ipChange.ipc$dispatch("-1896001047", new Object[]{this, context})).doubleValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            if (Build.VERSION.SDK_INT <= 16) {
                return 0.0d;
            }
            Object systemService = context.getSystemService(v.ATTACH_MODE_WINDOW);
            k21.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Point point = new Point();
            Display.getRealSize(((WindowManager) systemService).getDefaultDisplay(), point);
            return new BigDecimal(Math.pow((double) (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) / context.getResources().getDisplayMetrics().ydpi), 2.0d)).setScale(1, 4).doubleValue();
        } catch (Exception e) {
            LogUtil.d("DensityUtil", e.getMessage());
            return 0.0d;
        }
    }

    public final int h(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262603395")) {
            return ((Integer) ipChange.ipc$dispatch("262603395", new Object[]{this, context, Integer.valueOf(i)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (int) ((((float) i) / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
