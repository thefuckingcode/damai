package kotlinx.coroutines.experimental.sync;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@ø\u0001\u0000"}, d2 = {"withLock", "", "T", "Lkotlinx/coroutines/experimental/sync/Mutex;", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "continuation"}, k = 3, mv = {1, 1, 10})
/* compiled from: Mutex.kt */
public final class MutexKt$withLock$4 extends CoroutineImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    /* synthetic */ Object data;
    /* synthetic */ Throwable exception;

    MutexKt$withLock$4(Continuation continuation) {
        super(0, continuation);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        this.data = obj;
        this.exception = th;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.withLock(null, null, this);
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
