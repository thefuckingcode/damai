package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0007\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"CompletableDeferred", "Lkotlinx/coroutines/experimental/CompletableDeferred;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/CompletableDeferred;", "parent", "Lkotlinx/coroutines/experimental/Job;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: CompletableDeferred.kt */
public final class CompletableDeferredKt {
    public static final <T> CompletableDeferred<T> CompletableDeferred(Job job) {
        return new CompletableDeferredImpl(job);
    }

    public static /* bridge */ /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return CompletableDeferred(job);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    public static final /* synthetic */ <T> CompletableDeferred<T> CompletableDeferred() {
        return new CompletableDeferredImpl(null);
    }

    public static final <T> CompletableDeferred<T> CompletableDeferred(T t) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(null);
        completableDeferredImpl.complete(t);
        return completableDeferredImpl;
    }
}
