package kotlinx.coroutines.experimental;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000"}, d2 = {"joinAll", "", "", "Lkotlinx/coroutines/experimental/Job;", "continuation", "Lkotlin/coroutines/experimental/Continuation;", ""}, k = 3, mv = {1, 1, 10})
/* compiled from: Await.kt */
public final class AwaitKt$joinAll$3 extends CoroutineImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    /* synthetic */ Object data;
    /* synthetic */ Throwable exception;

    AwaitKt$joinAll$3(Continuation continuation) {
        super(0, continuation);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        this.data = obj;
        this.exception = th;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Collection<? extends Job>) null, this);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int getLabel() {
        return this.label;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setLabel(int i) {
        this.label = i;
    }
}
