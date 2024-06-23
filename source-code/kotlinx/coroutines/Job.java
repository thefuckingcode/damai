package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

public interface Job extends CoroutineContext.Element {
    public static final b Key = b.a;

    public static final class a {
        public static /* synthetic */ void b(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                job.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R c(Job job, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.a.a(job, r, function2);
        }

        public static <E extends CoroutineContext.Element> E d(Job job, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.a.b(job, key);
        }

        public static /* synthetic */ DisposableHandle e(Job job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
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

        public static CoroutineContext f(Job job, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.a.c(job, key);
        }

        public static CoroutineContext g(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.a.d(job, coroutineContext);
        }

        public static Job h(Job job, Job job2) {
            return job2;
        }
    }

    public static final class b implements CoroutineContext.Key<Job> {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    @InternalCoroutinesApi
    @NotNull
    ChildHandle attachChild(@NotNull ChildJob childJob);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(Throwable th);

    @InternalCoroutinesApi
    @NotNull
    CancellationException getCancellationException();

    @NotNull
    Sequence<Job> getChildren();

    @NotNull
    SelectClause0 getOnJoin();

    @NotNull
    DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, ur2> function1);

    @InternalCoroutinesApi
    @NotNull
    DisposableHandle invokeOnCompletion(boolean z, boolean z2, @NotNull Function1<? super Throwable, ur2> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @Nullable
    Object join(@NotNull Continuation<? super ur2> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    Job plus(@NotNull Job job);

    boolean start();
}
