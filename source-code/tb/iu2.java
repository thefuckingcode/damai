package tb;

import android.content.Context;
import android.content.res.Resources;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class iu2 {
    public static final iu2 INSTANCE = new iu2();

    private iu2() {
    }

    public final int a(@NotNull Context context, float f) {
        k21.j(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        k21.e(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final int b(int i, int i2, float f) {
        if (f <= ((float) 0)) {
            return i;
        }
        if (f >= ((float) 1)) {
            return i2;
        }
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return (i6 + ((int) (f * ((float) ((i2 & 255) - i6))))) | ((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f))) << 16) | ((i5 + ((int) (((float) (((i2 >> 8) & 255) - i5)) * f))) << 8);
    }

    public final int c(@NotNull Context context) {
        k21.j(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        k21.e(resources, "context.resources");
        return DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
    }

    public final int d(@NotNull Context context, float f) {
        k21.j(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        k21.e(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
