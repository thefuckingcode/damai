package tb;

import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class k90 extends l41 {
    @NotNull
    private final DisposableHandle e;

    public k90(@NotNull DisposableHandle disposableHandle) {
        this.e = disposableHandle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
        u(th);
        return ur2.INSTANCE;
    }

    @Override // tb.jl
    public void u(@Nullable Throwable th) {
        this.e.dispose();
    }
}
