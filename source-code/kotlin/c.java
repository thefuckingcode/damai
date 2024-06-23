package kotlin;

import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class c extends b {
    @NotNull
    public static <T> Lazy<T> c(T t) {
        return new InitializedLazyImpl(t);
    }
}
