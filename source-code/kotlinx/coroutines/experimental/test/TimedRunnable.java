package kotlinx.coroutines.experimental.test;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B%\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0000H\u0002J\b\u0010\u0005\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/experimental/test/TimedRunnable;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "run", "count", "", "time", "(Ljava/lang/Runnable;JJ)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: TestCoroutineContext.kt */
public final class TimedRunnable implements Comparable<TimedRunnable>, Runnable, ThreadSafeHeapNode {
    private final long count;
    private int index;
    private final Runnable run;
    public final long time;

    public TimedRunnable(Runnable runnable, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(runnable, "run");
        this.run = runnable;
        this.count = j;
        this.time = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimedRunnable(Runnable runnable, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? 0 : j, (i & 4) != 0 ? 0 : j2);
    }

    @Override // kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.index;
    }

    @Override // kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.index = i;
    }

    public void run() {
        this.run.run();
    }

    public int compareTo(TimedRunnable timedRunnable) {
        Intrinsics.checkParameterIsNotNull(timedRunnable, "other");
        long j = this.time;
        long j2 = timedRunnable.time;
        if (j == j2) {
            j = this.count;
            j2 = timedRunnable.count;
        }
        return (j > j2 ? 1 : (j == j2 ? 0 : -1));
    }

    public String toString() {
        return "TimedRunnable(time=" + this.time + ", run=" + this.run + ')';
    }
}
