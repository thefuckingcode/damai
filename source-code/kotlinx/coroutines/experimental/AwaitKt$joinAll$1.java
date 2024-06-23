package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000"}, d2 = {"joinAll", "", "jobs", "", "Lkotlinx/coroutines/experimental/Job;", "continuation", "Lkotlin/coroutines/experimental/Continuation;", ""}, k = 3, mv = {1, 1, 10})
/* compiled from: Await.kt */
public final class AwaitKt$joinAll$1 extends CoroutineImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    /* synthetic */ Object data;
    /* synthetic */ Throwable exception;

    AwaitKt$joinAll$1(Continuation continuation) {
        super(0, continuation);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        this.data = obj;
        this.exception = th;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Job[]) null, this);
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
