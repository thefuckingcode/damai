package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/experimental/DisposeOnCancel;", "Lkotlinx/coroutines/experimental/CancelHandler;", "handle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "(Lkotlinx/coroutines/experimental/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CancellableContinuation.kt */
public final class DisposeOnCancel extends CancelHandler {
    private final DisposableHandle handle;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        this.handle = disposableHandle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.experimental.CancelHandlerBase
    public void invoke(Throwable th) {
        this.handle.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }
}
