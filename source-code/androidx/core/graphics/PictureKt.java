package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b11;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"Landroid/graphics/Picture;", "", "width", "height", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Ltb/ur2;", "Lkotlin/ExtensionFunctionType;", "block", "record", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture picture, int i, int i2, @NotNull Function1<? super Canvas, ur2> function1) {
        k21.i(picture, "$this$record");
        k21.i(function1, "block");
        Canvas beginRecording = picture.beginRecording(i, i2);
        k21.h(beginRecording, "beginRecording(width, height)");
        try {
            function1.invoke(beginRecording);
            return picture;
        } finally {
            b11.b(1);
            picture.endRecording();
            b11.a(1);
        }
    }
}
