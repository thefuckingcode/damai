package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\n\u001a\r\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\n\u001a\r\u0010\u0003\u001a\u00020\u0005*\u00020\u0004H\n¨\u0006\u0006"}, d2 = {"Landroid/util/Size;", "", "component1", "component2", "Landroid/util/SizeF;", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@NotNull Size size) {
        k21.i(size, "$this$component1");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@NotNull Size size) {
        k21.i(size, "$this$component2");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@NotNull SizeF sizeF) {
        k21.i(sizeF, "$this$component1");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@NotNull SizeF sizeF) {
        k21.i(sizeF, "$this$component2");
        return sizeF.getHeight();
    }
}
