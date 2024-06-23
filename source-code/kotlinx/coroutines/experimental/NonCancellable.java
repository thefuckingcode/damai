package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.selects.SelectClause0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\f\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0016JA\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00180 j\u0002`#H\u0016J9\u0010\u001c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\t2'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00180 j\u0002`#H\u0016J1\u0010\u001c\u001a\u00020\u00122'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00180 j\u0002`#H\u0016J9\u0010\u001c\u001a\u00020\u00122'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00180 j\u0002`#2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0011\u0010%\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\t¨\u0006("}, d2 = {"Lkotlinx/coroutines/experimental/NonCancellable;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/experimental/Job;", "()V", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/experimental/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/experimental/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/experimental/DisposableHandle;", "child", "cancel", "cause", "", "cancelChildren", "", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/experimental/CancellationException;", "invokeOnCompletion", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "Lkotlinx/coroutines/experimental/CompletionHandler;", "onCancelling_", "join", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "start", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: NonCancellable.kt */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable INSTANCE = new NonCancellable();

    @Override // kotlinx.coroutines.experimental.Job
    public boolean cancel(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public /* synthetic */ void cancelChildren(Throwable th) {
    }

    @Override // kotlinx.coroutines.experimental.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public boolean start() {
        return false;
    }

    private NonCancellable() {
        super(Job.Key);
    }

    @Override // kotlinx.coroutines.experimental.Job
    @Deprecated(message = "Renamed to getCancellationException", replaceWith = @ReplaceWith(expression = "getCancellationException()", imports = {}))
    public Throwable getCompletionException() {
        return Job.DefaultImpls.getCompletionException(this);
    }

    @Override // kotlinx.coroutines.experimental.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job job) {
        Intrinsics.checkParameterIsNotNull(job, "other");
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlinx.coroutines.experimental.Job
    public Object join(Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.experimental.Job
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.experimental.Job
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.experimental.Job
    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public /* synthetic */ DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1, boolean z) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public DisposableHandle invokeOnCompletion(boolean z, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public Sequence<Job> getChildren() {
        return SequencesKt.emptySequence();
    }

    @Override // kotlinx.coroutines.experimental.Job
    public DisposableHandle attachChild(Job job) {
        Intrinsics.checkParameterIsNotNull(job, "child");
        return NonDisposableHandle.INSTANCE;
    }
}
