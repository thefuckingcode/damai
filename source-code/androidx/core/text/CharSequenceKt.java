package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\b¨\u0006\u0005"}, d2 = {"", "", "isDigitsOnly", "", "trimmedLength", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "$this$isDigitsOnly");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "$this$trimmedLength");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
