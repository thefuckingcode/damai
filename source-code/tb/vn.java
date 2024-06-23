package tb;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vn extends l1 {
    @NotNull
    public static final a Key = new a(null);
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    public static final class a implements CoroutineContext.Key<vn> {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof vn) && k21.d(this.a, ((vn) obj).a);
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.a + ')';
    }
}
