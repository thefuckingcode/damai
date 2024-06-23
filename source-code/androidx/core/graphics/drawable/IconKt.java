package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\b¨\u0006\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Icon;", "toAdaptiveIcon", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class IconKt {
    @RequiresApi(26)
    @NotNull
    public static final Icon toAdaptiveIcon(@NotNull Bitmap bitmap) {
        k21.i(bitmap, "$this$toAdaptiveIcon");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        k21.h(createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Bitmap bitmap) {
        k21.i(bitmap, "$this$toIcon");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        k21.h(createWithBitmap, "Icon.createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Uri uri) {
        k21.i(uri, "$this$toIcon");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        k21.h(createWithContentUri, "Icon.createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull byte[] bArr) {
        k21.i(bArr, "$this$toIcon");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        k21.h(createWithData, "Icon.createWithData(this, 0, size)");
        return createWithData;
    }
}
