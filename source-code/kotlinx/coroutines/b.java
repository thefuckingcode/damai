package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b implements NotCompleted {
    @NotNull
    public static final b INSTANCE = new b();

    private b() {
    }

    @NotNull
    public String toString() {
        return "Active";
    }
}
