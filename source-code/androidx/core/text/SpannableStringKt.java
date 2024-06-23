package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.w11;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0001H\b\u001a%\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\n\u001a\u001d\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\n¨\u0006\r"}, d2 = {"", "Landroid/text/Spannable;", "toSpannable", "Ltb/ur2;", "clearSpans", "", "start", "end", "", "span", "set", "Ltb/w11;", "range", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable spannable) {
        k21.i(spannable, "$this$clearSpans");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        k21.h(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable spannable, int i, int i2, @NotNull Object obj) {
        k21.i(spannable, "$this$set");
        k21.i(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "$this$toSpannable");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        k21.h(valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }

    public static final void set(@NotNull Spannable spannable, @NotNull w11 w11, @NotNull Object obj) {
        k21.i(spannable, "$this$set");
        k21.i(w11, "range");
        k21.i(obj, "span");
        spannable.setSpan(obj, w11.getStart().intValue(), w11.getEndInclusive().intValue(), 17);
    }
}
