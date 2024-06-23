package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a<\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "Landroid/text/Spanned;", "toSpanned", "", "T", "", "start", "end", "", "getSpans", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        k21.i(spanned, "$this$getSpans");
        k21.o(4, "T");
        T[] tArr = (T[]) spanned.getSpans(i, i2, Object.class);
        k21.h(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        k21.i(spanned, "$this$getSpans");
        k21.o(4, "T");
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        k21.h(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "$this$toSpanned");
        SpannedString valueOf = SpannedString.valueOf(charSequence);
        k21.h(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
