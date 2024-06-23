package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\b¨\u0006\u0004"}, d2 = {"", "Landroid/graphics/drawable/ColorDrawable;", "toDrawable", "Landroid/graphics/Color;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ColorDrawableKt {
    @NotNull
    public static final ColorDrawable toDrawable(@ColorInt int i) {
        return new ColorDrawable(i);
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorDrawable toDrawable(@NotNull Color color) {
        k21.i(color, "$this$toDrawable");
        return new ColorDrawable(color.toArgb());
    }
}
