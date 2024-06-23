package kotlinx.coroutines.test;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.rk2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B'\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\"\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lkotlinx/coroutines/test/TimedRunnableObsolete;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "Ltb/ur2;", "run", "other", "", "compareTo", "", "toString", "Ljava/lang/Runnable;", "", AdUtConstants.XAD_UT_ARG_COUNT, "J", "time", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Ltb/rk2;", "heap", "Ltb/rk2;", "getHeap", "()Ltb/rk2;", "setHeap", "(Ltb/rk2;)V", "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
final class TimedRunnableObsolete implements Comparable<TimedRunnableObsolete>, Runnable, ThreadSafeHeapNode {
    private final long count;
    @Nullable
    private rk2<?> heap;
    private int index;
    @NotNull
    private final Runnable run;
    @JvmField
    public final long time;

    public TimedRunnableObsolete(@NotNull Runnable runnable, long j, long j2) {
        this.run = runnable;
        this.count = j;
        this.time = j2;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    @Nullable
    public rk2<?> getHeap() {
        return this.heap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.index;
    }

    public void run() {
        this.run.run();
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setHeap(@Nullable rk2<?> rk2) {
        this.heap = rk2;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.index = i;
    }

    @NotNull
    public String toString() {
        return "TimedRunnable(time=" + this.time + ", run=" + this.run + ')';
    }

    public int compareTo(@NotNull TimedRunnableObsolete timedRunnableObsolete) {
        long j = this.time;
        long j2 = timedRunnableObsolete.time;
        if (j == j2) {
            return k21.l(this.count, timedRunnableObsolete.count);
        }
        return k21.l(j, j2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimedRunnableObsolete(Runnable runnable, long j, long j2, int i, m40 m40) {
        this(runnable, (i & 2) != 0 ? 0 : j, (i & 4) != 0 ? 0 : j2);
    }
}
