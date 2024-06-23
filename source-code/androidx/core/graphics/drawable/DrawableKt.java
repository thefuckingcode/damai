package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import com.youku.arch.v3.core.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a2\u0010\r\u001a\u00020\f*\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00012\b\b\u0003\u0010\t\u001a\u00020\u00012\b\b\u0003\u0010\n\u001a\u00020\u00012\b\b\u0003\u0010\u000b\u001a\u00020\u0001¨\u0006\u000e"}, d2 = {"Landroid/graphics/drawable/Drawable;", "", "width", "height", "Landroid/graphics/Bitmap$Config;", Constants.CONFIG, "Landroid/graphics/Bitmap;", "toBitmap", "left", "top", "right", "bottom", "Ltb/ur2;", "updateBounds", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DrawableKt {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        if (r0.getConfig() == r9) goto L_0x001d;
     */
    @NotNull
    public static final Bitmap toBitmap(@NotNull Drawable drawable, @Px int i, @Px int i2, @Nullable Bitmap.Config config) {
        k21.i(drawable, "$this$toBitmap");
        if (drawable instanceof BitmapDrawable) {
            if (config != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                k21.h(bitmap, "bitmap");
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (i == bitmapDrawable.getIntrinsicWidth() && i2 == bitmapDrawable.getIntrinsicHeight()) {
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                k21.h(bitmap2, "bitmap");
                return bitmap2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i2, true);
            k21.h(createScaledBitmap, "Bitmap.createScaledBitma…map, width, height, true)");
            return createScaledBitmap;
        }
        Rect bounds = drawable.getBounds();
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i3, i4, i5, i6);
        k21.h(createBitmap, "bitmap");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i, i2, config);
    }

    public static final void updateBounds(@NotNull Drawable drawable, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        k21.i(drawable, "$this$updateBounds");
        drawable.setBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = drawable.getBounds().left;
        }
        if ((i5 & 2) != 0) {
            i2 = drawable.getBounds().top;
        }
        if ((i5 & 4) != 0) {
            i3 = drawable.getBounds().right;
        }
        if ((i5 & 8) != 0) {
            i4 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i, i2, i3, i4);
    }
}
