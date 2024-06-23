package tb;

import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class p01 implements Incomplete {
    @NotNull
    private final xi1 a;

    public p01(@NotNull xi1 xi1) {
        this.a = xi1;
    }

    @Override // kotlinx.coroutines.Incomplete
    @NotNull
    public xi1 getList() {
        return this.a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return false;
    }

    @NotNull
    public String toString() {
        return n30.c() ? getList().v("New") : super.toString();
    }
}
