package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u00052\b\u0012\u0004\u0012\u0002H\u00020\u0006B'\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u00060\nj\u0002`\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\rJ\r\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8PX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00060\nj\u0002`\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/experimental/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "Lkotlin/coroutines/experimental/Continuation;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "cont", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/experimental/Continuation;)V", "defaultResumeMode", "", "getDefaultResumeMode$kotlinx_coroutines_core", "()I", "nameString", "", "nameString$kotlinx_coroutines_core", "onCompletionInternal", "", "state", "", "mode", "onCompletionInternal$kotlinx_coroutines_core", "run", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Scheduled.kt */
public class TimeoutCoroutine<U, T extends U> extends AbstractCoroutine<T> implements Runnable, Continuation<T> {
    public final Continuation<U> cont;
    public final long time;
    public final TimeUnit unit;

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine
    public int getDefaultResumeMode$kotlinx_coroutines_core() {
        return 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.coroutines.experimental.Continuation<? super U> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeoutCoroutine(long j, TimeUnit timeUnit, Continuation<? super U> continuation) {
        super(continuation.getContext(), true);
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(continuation, "cont");
        this.time = j;
        this.unit = timeUnit;
        this.cont = continuation;
    }

    public void run() {
        cancel(ScheduledKt.TimeoutCancellationException(this.time, this.unit, this));
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport
    public void onCompletionInternal$kotlinx_coroutines_core(Object obj, int i) {
        if (obj instanceof CompletedExceptionally) {
            ResumeModeKt.resumeWithExceptionMode(this.cont, ((CompletedExceptionally) obj).cause, i);
        } else {
            ResumeModeKt.resumeMode(this.cont, obj, i);
        }
    }

    @Override // kotlinx.coroutines.experimental.AbstractCoroutine, kotlinx.coroutines.experimental.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + '(' + this.time + ' ' + this.unit + ')';
    }
}
