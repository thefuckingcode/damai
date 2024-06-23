package kotlinx.coroutines;

import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hl;
import tb.k12;
import tb.l41;
import tb.n30;
import tb.ur2;

/* compiled from: Taobao */
final class s<T> extends l41 {
    @NotNull
    private final CancellableContinuationImpl<T> e;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.CancellableContinuationImpl<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public s(@NotNull CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.e = cancellableContinuationImpl;
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
        Object state$kotlinx_coroutines_core = v().getState$kotlinx_coroutines_core();
        if (n30.a() && !(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new AssertionError();
        } else if (state$kotlinx_coroutines_core instanceof hl) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.e;
            Throwable th2 = ((hl) state$kotlinx_coroutines_core).a;
            Result.a aVar = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m913constructorimpl(k12.a(th2)));
        } else {
            CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.e;
            Object h = q.h(state$kotlinx_coroutines_core);
            Result.a aVar2 = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.m913constructorimpl(h));
        }
    }
}
