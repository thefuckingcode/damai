package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.cache.CacheEntity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ProducerJob;", "E", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "Lkotlinx/coroutines/experimental/Job;", "channel", "channel$annotations", "()V", "getChannel", "()Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
@Deprecated(message = "Use `ReceiveChannel`", replaceWith = @ReplaceWith(expression = "ReceiveChannel", imports = {}))
/* compiled from: Produce.kt */
public interface ProducerJob<E> extends ReceiveChannel<E>, Job {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Produce.kt */
    public static final class DefaultImpls {
        @Deprecated(message = "Use ReceiveChannel itself")
        public static /* synthetic */ void channel$annotations() {
        }

        public static <E, R> R fold(ProducerJob<? extends E> producerJob, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "operation");
            return (R) Job.DefaultImpls.fold(producerJob, r, function2);
        }

        public static <E_I1, E extends CoroutineContext.Element> E get(ProducerJob<? extends E_I1> producerJob, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
            return (E) Job.DefaultImpls.get(producerJob, key);
        }

        @Deprecated(message = "Renamed to getCancellationException", replaceWith = @ReplaceWith(expression = "getCancellationException()", imports = {}))
        public static <E> Throwable getCompletionException(ProducerJob<? extends E> producerJob) {
            return Job.DefaultImpls.getCompletionException(producerJob);
        }

        public static <E> CoroutineContext minusKey(ProducerJob<? extends E> producerJob, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
            return Job.DefaultImpls.minusKey(producerJob, key);
        }

        public static <E> CoroutineContext plus(ProducerJob<? extends E> producerJob, CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return Job.DefaultImpls.plus(producerJob, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <E> Job plus(ProducerJob<? extends E> producerJob, Job job) {
            Intrinsics.checkParameterIsNotNull(job, "other");
            return Job.DefaultImpls.plus((Job) producerJob, job);
        }
    }

    ReceiveChannel<E> getChannel();
}
