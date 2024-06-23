package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements Function1<String, String> {
    public static final StringsKt__IndentKt$getIndentFunction$1 INSTANCE = new StringsKt__IndentKt$getIndentFunction$1();

    StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        k21.i(str, "line");
        return str;
    }
}
