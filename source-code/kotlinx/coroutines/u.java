package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l41;
import tb.ur2;

/* compiled from: Taobao */
final class u<T, R> extends l41 {
    @NotNull
    private final SelectInstance<R> e;
    @NotNull
    private final Function2<T, Continuation<? super R>, Object> f;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        this.e = selectInstance;
        this.f = function2;
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
        if (this.e.trySelect()) {
            v().selectAwaitCompletion$kotlinx_coroutines_core(this.e, this.f);
        }
    }
}
