package tb;

import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class nk1 {
    @NotNull
    public static final mk1 a(@NotNull String str) {
        k21.i(str, "value");
        if ((o.L(str, "0x", false, 2, null)) || (o.L(str, "0X", false, 2, null))) {
            String substring = str.substring(2);
            k21.h(substring, "(this as java.lang.String).substring(startIndex)");
            return new mk1(substring, 16);
        } else if (!(o.L(str, "0b", false, 2, null)) && !(o.L(str, "0B", false, 2, null))) {
            return new mk1(str, 10);
        } else {
            String substring2 = str.substring(2);
            k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
            return new mk1(substring2, 2);
        }
    }
}
