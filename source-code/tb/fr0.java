package tb;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fr0 extends gr0<View> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fr0(@NotNull wq0 wq0, @NotNull up0 up0) {
        super(wq0, up0);
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "rootNode");
    }

    @NotNull
    /* renamed from: f */
    public View d(@NotNull wq0 wq0, @NotNull View view, @NotNull String str, @Nullable String str2, @NotNull up0 up0, @NotNull r61 r61, float f, float f2) {
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(view, "parentMergeView");
        k21.i(str, "childType");
        k21.i(up0, "childNode");
        k21.i(r61, "childLayout");
        if (up0.z()) {
            View a = dr0.INSTANCE.a(wq0.c(), "shadow", null);
            a.setLayoutParams(er0.INSTANCE.a(up0, r61, f, f2));
            up0.M((GXShadowLayout) a);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(a);
            }
        }
        dr0 dr0 = dr0.INSTANCE;
        View a2 = dr0.a(wq0.c(), str, str2);
        er0 er0 = er0.INSTANCE;
        a2.setLayoutParams(er0.a(up0, r61, f, f2));
        up0.Y(a2);
        boolean z = view instanceof ViewGroup;
        if (z) {
            ((ViewGroup) view).addView(a2);
        }
        if (up0.y()) {
            View a3 = dr0.a(wq0.c(), "lottie", null);
            a3.setLayoutParams(er0.a(up0, r61, f, f2));
            up0.Q(a3);
            if (z) {
                ((ViewGroup) view).addView(a3);
            }
        }
        return a2;
    }

    @NotNull
    /* renamed from: g */
    public View e(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull r61 r61) {
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(up0, "node");
        k21.i(r61, "layout");
        View a = dr0.INSTANCE.a(wq0.c(), c().o(), c().e());
        a.setLayoutParams(er0.b(er0.INSTANCE, c(), r61, 0.0f, 0.0f, 12, null));
        c().Y(a);
        return a;
    }
}
