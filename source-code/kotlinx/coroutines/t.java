package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l41;
import tb.ur2;

/* compiled from: Taobao */
final class t extends l41 {
    @NotNull
    private final Continuation<ur2> e;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull Continuation<? super ur2> continuation) {
        this.e = continuation;
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
        Continuation<ur2> continuation = this.e;
        ur2 ur2 = ur2.INSTANCE;
        Result.a aVar = Result.Companion;
        continuation.resumeWith(Result.m913constructorimpl(ur2));
    }
}
