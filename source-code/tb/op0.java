package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alibaba.gaiax.render.view.basic.GXText;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class op0 {
    @NotNull
    public static final op0 INSTANCE = new op0();
    private static final int a;
    private static final int b;
    @NotNull
    private static final Pools.SynchronizedPool<WeakReference<GXText>> c;
    private static boolean d;
    @Nullable
    private static Typeface e;
    private static float f;
    private static float g;
    private static float h;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int i = (availableProcessors * 2) + 1;
        b = i;
        c = new Pools.SynchronizedPool<>(i);
    }

    private op0() {
    }

    private final GXText a(Context context) {
        GXText gXText = (GXText) dr0.b(dr0.INSTANCE, context, "text", null, 4, null);
        gXText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return gXText;
    }

    private final GXText c(Context context) {
        WeakReference<GXText> acquire = c.acquire();
        if (acquire == null) {
            return a(context);
        }
        GXText gXText = acquire.get();
        if (gXText == null || !(gXText.getContext() instanceof Activity)) {
            return a(context);
        }
        if (!k21.d(gXText.getContext(), context)) {
            return a(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Context context2 = gXText.getContext();
            Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context2).isDestroyed()) {
                return a(context);
            }
        }
        return gXText;
    }

    private final void e(GXText gXText) {
        GXViewExtKt.C(gXText, e);
        GXViewExtKt.k(gXText, Float.valueOf(f));
        gXText.setLineSpacing(g, h);
        gXText.setSingleLine(false);
        gXText.setMaxLines(Integer.MAX_VALUE);
        gXText.setPadding(0, 0, 0, 0);
    }

    @NotNull
    public final GXText b(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        GXText c2 = c(context);
        if (!d) {
            d = true;
            e = c2.getTypeface();
            f = c2.getTextSize();
            g = c2.getLineSpacingExtra();
            h = c2.getLineSpacingMultiplier();
        }
        return c2;
    }

    public final void d(@NotNull GXText gXText) {
        k21.i(gXText, "gxText");
        try {
            e(gXText);
            c.release(new WeakReference<>(gXText));
        } catch (Exception unused) {
        }
    }
}
