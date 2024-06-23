package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"timeSource", "Lkotlinx/coroutines/experimental/TimeSource;", "getTimeSource", "()Lkotlinx/coroutines/experimental/TimeSource;", "setTimeSource", "(Lkotlinx/coroutines/experimental/TimeSource;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: TimeSource.kt */
public final class TimeSourceKt {
    private static TimeSource timeSource = DefaultTimeSource.INSTANCE;

    public static final TimeSource getTimeSource() {
        return timeSource;
    }

    public static final void setTimeSource(TimeSource timeSource2) {
        Intrinsics.checkParameterIsNotNull(timeSource2, "<set-?>");
        timeSource = timeSource2;
    }
}
