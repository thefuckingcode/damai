package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¨\u0006\u0005"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/content/res/Resources;", "resources", "Landroid/graphics/drawable/BitmapDrawable;", "toDrawable", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BitmapDrawableKt {
    @NotNull
    public static final BitmapDrawable toDrawable(@NotNull Bitmap bitmap, @NotNull Resources resources) {
        k21.i(bitmap, "$this$toDrawable");
        k21.i(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
