package tb;

import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class j90 extends hf {
    @NotNull
    private final DisposableHandle a;

    public j90(@NotNull DisposableHandle disposableHandle) {
        this.a = disposableHandle;
    }

    @Override // tb.Cif
    public void a(@Nullable Throwable th) {
        this.a.dispose();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        a(th);
        return ur2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + this.a + jl1.ARRAY_END;
    }
}
