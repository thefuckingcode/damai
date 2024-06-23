package kotlin.text;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class m extends l {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static Double h(@NotNull String str) {
        k21.i(str, "<this>");
        try {
            if (f.value.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Float i(@NotNull String str) {
        k21.i(str, "<this>");
        try {
            if (f.value.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
