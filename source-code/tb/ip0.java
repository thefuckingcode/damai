package tb;

import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXStyleConvert;
import java.util.List;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ip0 {
    @NotNull
    private final GradientDrawable.Orientation a;
    @NotNull
    private final List<ko0> b;

    public ip0(@NotNull GradientDrawable.Orientation orientation, @NotNull List<ko0> list) {
        k21.i(orientation, "direction");
        k21.i(list, "colors");
        this.a = orientation;
        this.b = list;
    }

    @NotNull
    public final GradientDrawable a() {
        int i = 0;
        if (this.b.size() == 1) {
            int c = ko0.c(this.b.get(0), null, 1, null);
            return new kp0(this.a, new int[]{c, c});
        }
        int[] iArr = new int[this.b.size()];
        for (T t : this.b) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            iArr[i] = ko0.c(t, null, 1, null);
            i = i2;
        }
        return new kp0(this.a, iArr);
    }

    @Nullable
    public final Shader b(@NotNull TextView textView) {
        k21.i(textView, "view");
        float f = (float) textView.getLayoutParams().height;
        float f2 = (float) textView.getLayoutParams().width;
        int i = 0;
        if (this.b.size() == 1) {
            int b2 = this.b.get(0).b(textView.getContext());
            return GXStyleConvert.Companion.a().i(f2, f, this.a, new int[]{b2, b2});
        }
        int[] iArr = new int[this.b.size()];
        for (T t : this.b) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            iArr[i] = t.b(textView.getContext());
            i = i2;
        }
        return GXStyleConvert.Companion.a().i(f2, f, this.a, iArr);
    }
}
