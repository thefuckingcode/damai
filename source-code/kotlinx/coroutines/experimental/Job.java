package kotlinx.coroutines.experimental;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.experimental.CoroutineExceptionHandler;
import kotlinx.coroutines.experimental.selects.SelectClause0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0000H'J\u0014\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0014\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H'J\f\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H&J\b\u0010\u001a\u001a\u00020\u0014H\u0017JE\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\u001fj\u0002`\"H&J;\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00072'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\u001fj\u0002`\"H'J1\u0010\u001b\u001a\u00020\u00102'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\u001fj\u0002`\"H&J9\u0010\u001b\u001a\u00020\u00102'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\u001fj\u0002`\"2\u0006\u0010\u001c\u001a\u00020\u0007H'J\u0011\u0010$\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0002J\b\u0010(\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\t¨\u0006*"}, d2 = {"Lkotlinx/coroutines/experimental/Job;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/experimental/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/experimental/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/experimental/DisposableHandle;", "child", "cancel", "cause", "", "cancelChildren", "", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/experimental/CancellationException;", "getCompletionException", "invokeOnCompletion", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "Lkotlinx/coroutines/experimental/CompletionHandler;", "onCancelling_", "join", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Job.kt */
public interface Job extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Start child coroutine with 'parent' parameter")
    DisposableHandle attachChild(Job job);

    boolean cancel(Throwable th);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility, it is an extension now")
    /* synthetic */ void cancelChildren(Throwable th);

    CancellationException getCancellationException();

    Sequence<Job> getChildren();

    @Deprecated(message = "Renamed to getCancellationException", replaceWith = @ReplaceWith(expression = "getCancellationException()", imports = {}))
    Throwable getCompletionException();

    SelectClause0 getOnJoin();

    DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "For binary compatibility")
    /* synthetic */ DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1, boolean z);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use with named `onCancelling` and `handler` parameters", replaceWith = @ReplaceWith(expression = "this.invokeOnCompletion(onCancelling = onCancelling_, handler = handler)", imports = {}))
    DisposableHandle invokeOnCompletion(boolean z, Function1<? super Throwable, Unit> function1);

    DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation<? super Unit> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    Job plus(Job job);

    boolean start();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/experimental/Job$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlinx/coroutines/experimental/Job;", "()V", "invoke", "parent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Job.kt */
    public static final class Key implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        static {
            CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
        }

        private Key() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public static /* bridge */ /* synthetic */ Job invoke$default(Key key, Job job, int i, Object obj) {
            if ((i & 1) != 0) {
                job = null;
            }
            return key.invoke(job);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public final /* synthetic */ Job invoke(Job job) {
            return JobKt.Job(job);
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Job.kt */
    public static final class DefaultImpls {
        public static <R> R fold(Job job, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(job, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(Job job, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
            return (E) CoroutineContext.Element.DefaultImpls.get(job, key);
        }

        public static CoroutineContext minusKey(Job job, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
            return CoroutineContext.Element.DefaultImpls.minusKey(job, key);
        }

        public static CoroutineContext plus(Job job, CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return CoroutineContext.Element.DefaultImpls.plus(job, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(Job job, Job job2) {
            Intrinsics.checkParameterIsNotNull(job2, "other");
            return job2;
        }

        @Deprecated(message = "Renamed to getCancellationException", replaceWith = @ReplaceWith(expression = "getCancellationException()", imports = {}))
        public static Throwable getCompletionException(Job job) {
            return job.getCancellationException();
        }

        public static /* bridge */ /* synthetic */ boolean cancel$default(Job job, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return job.cancel(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility, it is an extension now")
        public static /* bridge */ /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                job.cancelChildren(th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelChildren");
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use with named `onCancelling` and `handler` parameters", replaceWith = @ReplaceWith(expression = "this.invokeOnCompletion(onCancelling = onCancelling_, handler = handler)", imports = {}))
        public static /* bridge */ /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return job.invokeOnCompletion(z, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static /* bridge */ /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return job.invokeOnCompletion(z, z2, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
    }
}
