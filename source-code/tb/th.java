package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class th extends h41 {
    @JvmField
    @NotNull
    public final CancellableContinuationImpl<?> e;

    public th(@NotNull CancellableContinuationImpl<?> cancellableContinuationImpl) {
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
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.e;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(v()));
    }
}
