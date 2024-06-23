package tb;

import android.view.View;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class hr0 extends gr0<View> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hr0(@NotNull wq0 wq0, @NotNull up0 up0) {
        super(wq0, up0);
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(up0, "rootNode");
    }

    @Nullable
    /* renamed from: f */
    public View d(@NotNull wq0 wq0, @NotNull View view, @NotNull String str, @Nullable String str2, @NotNull up0 up0, @NotNull r61 r61, float f, float f2) {
        View i;
        GXShadowLayout b;
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(view, "parentMergeView");
        k21.i(str, "childType");
        k21.i(up0, "childNode");
        k21.i(r61, "childLayout");
        View p = up0.p();
        if (p == null) {
            return null;
        }
        if (up0.z() && (b = up0.b()) != null) {
            er0.INSTANCE.c(b, r61, f, f2);
        }
        if (up0.y() && (i = up0.i()) != null) {
            er0.INSTANCE.c(i, r61, f, f2);
        }
        er0.INSTANCE.c(p, r61, f, f2);
        return p;
    }

    @Nullable
    /* renamed from: g */
    public View e(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull r61 r61) {
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(up0, "node");
        k21.i(r61, "layout");
        View p = up0.p();
        if (p == null) {
            return null;
        }
        er0.INSTANCE.c(p, r61, 0.0f, 0.0f);
        return p;
    }
}
