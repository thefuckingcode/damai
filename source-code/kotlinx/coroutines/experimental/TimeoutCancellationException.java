package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/experimental/CancellationException;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/experimental/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/experimental/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Scheduled.kt */
public final class TimeoutCancellationException extends CancellationException {
    public final Job coroutine;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(String str, Job job) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.coroutine = job;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(String str) {
        this(str, null);
        Intrinsics.checkParameterIsNotNull(str, "message");
    }
}
