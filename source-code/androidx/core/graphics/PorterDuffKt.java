package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¨\u0006\u0007"}, d2 = {"Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/PorterDuffXfermode;", "toXfermode", "", "color", "Landroid/graphics/PorterDuffColorFilter;", "toColorFilter", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PorterDuffKt {
    @NotNull
    public static final PorterDuffColorFilter toColorFilter(@NotNull PorterDuff.Mode mode, int i) {
        k21.i(mode, "$this$toColorFilter");
        return new PorterDuffColorFilter(i, mode);
    }

    @NotNull
    public static final PorterDuffXfermode toXfermode(@NotNull PorterDuff.Mode mode) {
        k21.i(mode, "$this$toXfermode");
        return new PorterDuffXfermode(mode);
    }
}
