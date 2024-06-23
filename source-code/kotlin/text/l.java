package kotlin.text;

import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class l extends k {
    @NotNull
    public static StringBuilder g(@NotNull StringBuilder sb, @NotNull String... strArr) {
        k21.i(sb, "<this>");
        k21.i(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }
}
