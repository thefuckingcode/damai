package tb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class er0 {
    @NotNull
    public static final er0 INSTANCE = new er0();

    private er0() {
    }

    public static /* synthetic */ AbsoluteLayout.LayoutParams b(er0 er0, up0 up0, r61 r61, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        if ((i & 8) != 0) {
            f2 = 0.0f;
        }
        return er0.a(up0, r61, f, f2);
    }

    @NotNull
    public final AbsoluteLayout.LayoutParams a(@NotNull up0 up0, @Nullable r61 r61, float f, float f2) {
        k21.i(up0, "data");
        if (r61 != null) {
            return new AbsoluteLayout.LayoutParams((int) r61.e(), (int) r61.d(), ((int) r61.f()) + ((int) f), ((int) r61.g()) + ((int) f2));
        }
        return new AbsoluteLayout.LayoutParams(-2, -2, 0, 0);
    }

    public final void c(@NotNull View view, @NotNull r61 r61, float f, float f2) {
        k21.i(view, "view");
        k21.i(r61, "layout");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) r61.e();
        layoutParams.height = (int) r61.d();
        if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
            AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) layoutParams;
            layoutParams2.x = ((int) r61.f()) + ((int) f);
            layoutParams2.y = ((int) r61.g()) + ((int) f2);
        }
        view.setLayoutParams(layoutParams);
    }
}
