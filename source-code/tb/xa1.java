package tb;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class xa1 extends CoroutineDispatcher {
    @NotNull
    public abstract xa1 a();

    /* access modifiers changed from: protected */
    @InternalCoroutinesApi
    @Nullable
    public final String c() {
        xa1 xa1;
        f90 f90 = f90.INSTANCE;
        xa1 c = f90.c();
        if (this == c) {
            return "Dispatchers.Main";
        }
        try {
            xa1 = c.a();
        } catch (UnsupportedOperationException unused) {
            xa1 = null;
        }
        if (this == xa1) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String c = c();
        if (c != null) {
            return c;
        }
        return q30.a(this) + '@' + q30.b(this);
    }
}
