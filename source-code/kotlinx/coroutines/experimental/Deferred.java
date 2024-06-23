package kotlinx.coroutines.experimental;

import com.lzy.okgo.cache.CacheEntity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.selects.SelectClause1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\r\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00048VX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0006\u0010\u0005R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\t¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/experimental/Deferred;", "T", "Lkotlinx/coroutines/experimental/Job;", "isCompletedExceptionally", "", "()Z", "isComputing", "isComputing$annotations", "()V", "onAwait", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/experimental/selects/SelectClause1;", "await", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Deferred.kt */
public interface Deferred<T> extends Job {
    Object await(Continuation<? super T> continuation);

    T getCompleted();

    Throwable getCompletionExceptionOrNull();

    SelectClause1<T> getOnAwait();

    boolean isCompletedExceptionally();

    boolean isComputing();

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Deferred.kt */
    public static final class DefaultImpls {
        public static <T, R> R fold(Deferred<? extends T> deferred, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "operation");
            return (R) Job.DefaultImpls.fold(deferred, r, function2);
        }

        public static <T, E extends CoroutineContext.Element> E get(Deferred<? extends T> deferred, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
            return (E) Job.DefaultImpls.get(deferred, key);
        }

        @Deprecated(message = "Renamed to getCancellationException", replaceWith = @ReplaceWith(expression = "getCancellationException()", imports = {}))
        public static <T> Throwable getCompletionException(Deferred<? extends T> deferred) {
            return Job.DefaultImpls.getCompletionException(deferred);
        }

        @Deprecated(message = "Use `isActive`", replaceWith = @ReplaceWith(expression = "isActive", imports = {}))
        public static /* synthetic */ void isComputing$annotations() {
        }

        public static <T> CoroutineContext minusKey(Deferred<? extends T> deferred, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
            return Job.DefaultImpls.minusKey(deferred, key);
        }

        public static <T> CoroutineContext plus(Deferred<? extends T> deferred, CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return Job.DefaultImpls.plus(deferred, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> Job plus(Deferred<? extends T> deferred, Job job) {
            Intrinsics.checkParameterIsNotNull(job, "other");
            return Job.DefaultImpls.plus((Job) deferred, job);
        }

        public static <T> boolean isComputing(Deferred<? extends T> deferred) {
            return deferred.isActive();
        }
    }
}
