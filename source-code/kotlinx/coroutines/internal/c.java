package kotlinx.coroutines.internal;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c {
    @JvmField
    @NotNull
    public final b a;

    public c(@NotNull b bVar) {
        this.a = bVar;
    }

    @NotNull
    public String toString() {
        return "Removed[" + this.a + jl1.ARRAY_END;
    }
}
