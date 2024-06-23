package kotlin.text;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ww1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class q extends p {
    @NotNull
    public static final String U0(@NotNull String str, int i) {
        k21.i(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(ww1.d(i, str.length()));
            k21.h(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char V0(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(StringsKt__StringsKt.Z(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @Nullable
    public static Character W0(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }
}
