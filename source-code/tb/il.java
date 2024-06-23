package tb;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class il {
    @JvmField
    @Nullable
    public final Object a;
    @JvmField
    @NotNull
    public final Function1<Throwable, ur2> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public il(@Nullable Object obj, @NotNull Function1<? super Throwable, ur2> function1) {
        this.a = obj;
        this.b = function1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof il)) {
            return false;
        }
        il ilVar = (il) obj;
        return k21.d(this.a, ilVar.a) && k21.d(this.b, ilVar.b);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ')';
    }
}
