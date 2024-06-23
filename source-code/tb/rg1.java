package tb;

import com.taobao.weex.annotation.JSMethod;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class rg1 {
    @NotNull
    public static final rg1 INSTANCE = new rg1();
    @NotNull
    private static final Regex a = new Regex("[^\\p{L}\\p{Digit}]");

    private rg1() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String str) {
        k21.i(str, "name");
        return a.replace(str, JSMethod.NOT_SET);
    }
}
