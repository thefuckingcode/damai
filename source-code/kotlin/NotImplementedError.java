package kotlin;

import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotImplementedError(@NotNull String str) {
        super(str);
        k21.i(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotImplementedError(String str, int i, m40 m40) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
