package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\b¨\u0006\u0005"}, d2 = {"Landroid/graphics/Paint;", "Landroidx/core/graphics/BlendModeCompat;", "blendModeCompat", "", "setBlendMode", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PaintKt {
    public static final boolean setBlendMode(@NotNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        k21.i(paint, "$this$setBlendMode");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
