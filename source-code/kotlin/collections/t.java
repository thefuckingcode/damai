package kotlin.collections;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class t extends s {
    public static final <T> void G(@NotNull List<T> list) {
        k21.i(list, "<this>");
        Collections.reverse(list);
    }
}
