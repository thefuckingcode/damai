package tb;

import com.alibaba.gaiax.template.GXIExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class xo0 {
    @NotNull
    private final GXIExpression a;

    public xo0(@NotNull GXIExpression gXIExpression) {
        k21.i(gXIExpression, "event");
        this.a = gXIExpression;
    }

    @NotNull
    public final GXIExpression a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof xo0) && k21.d(this.a, ((xo0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXEventBinding(event=" + this.a + ')';
    }
}
