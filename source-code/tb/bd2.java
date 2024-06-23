package tb;

import android.content.Context;
import com.alibaba.pictures.responsive.IConfig;
import com.alibaba.pictures.responsive.ResponsiveManager;
import com.alibaba.pictures.responsive.state.ResponsivePageStateCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class bd2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final bd2 INSTANCE = new bd2();
    public static final double NARROW_WIDTH_HEIGHT_RATIO = 2.3d;
    public static final double RESPONSIVE_HEIGHT_WIDTH_RATIO = 1.25d;

    private bd2() {
    }

    public static final int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "104761753") ? ((Integer) ipChange.ipc$dispatch("104761753", new Object[0])).intValue() : (int) (((double) e()) * 1.67d);
    }

    public static final int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206505228")) {
            return ((Integer) ipChange.ipc$dispatch("206505228", new Object[0])).intValue();
        }
        IConfig b = ResponsiveManager.Companion.a().b();
        if (b == null || b.getPhoneStandardWidthDp() <= 0) {
            return 400;
        }
        return b.getPhoneStandardWidthDp();
    }

    private final float c(Context context, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-478332991")) {
            return ((Float) ipChange.ipc$dispatch("-478332991", new Object[]{this, context, Float.valueOf(f), Integer.valueOf(i)})).floatValue();
        } else if (!g12.INSTANCE.j(context) || i <= b()) {
            return f;
        } else {
            float f2 = 0.0f;
            float f3 = (float) ((int) f);
            if (f > f3) {
                f2 = f - f3;
            }
            return ((float) tb1.b(((float) i) / (((float) b()) / f3))) + f2;
        }
    }

    public static final int e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685665404")) {
            return ((Integer) ipChange.ipc$dispatch("-1685665404", new Object[0])).intValue();
        }
        IConfig b = ResponsiveManager.Companion.a().b();
        if (b == null || b.getSplitScreenStandardWidthDp() <= 0) {
            return 360;
        }
        return b.getSplitScreenStandardWidthDp();
    }

    public final int d(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887223591")) {
            return ((Integer) ipChange.ipc$dispatch("887223591", new Object[]{this, context, Integer.valueOf(i)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (!g12.INSTANCE.j(context)) {
            return i;
        }
        return (int) c(context, (float) i, ResponsivePageStateCache.Companion.a().d(context));
    }
}
