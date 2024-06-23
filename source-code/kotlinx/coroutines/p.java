package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l41;
import tb.ur2;

/* compiled from: Taobao */
final class p extends l41 {
    @NotNull
    private final Function1<Throwable, ur2> e;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Function1<? super Throwable, ur2> function1) {
        this.e = function1;
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
        this.e.invoke(th);
    }
}
