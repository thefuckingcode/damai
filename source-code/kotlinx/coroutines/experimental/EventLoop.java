package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoop;", "", "processNextEvent", "", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: EventLoop.kt */
public interface EventLoop {
    public static final Factory Factory = Factory.$$INSTANCE;

    long processNextEvent();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoop$Factory;", "", "()V", "invoke", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "thread", "Ljava/lang/Thread;", "parentJob", "Lkotlinx/coroutines/experimental/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    @Deprecated(message = "Companion object to be removed, no replacement")
    /* compiled from: EventLoop.kt */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public static /* bridge */ /* synthetic */ CoroutineDispatcher invoke$default(Factory factory, Thread thread, Job job, int i, Object obj) {
            if ((i & 1) != 0) {
                thread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "Thread.currentThread()");
            }
            if ((i & 2) != 0) {
                job = null;
            }
            return factory.invoke(thread, job);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with top-level function")
        public final /* synthetic */ CoroutineDispatcher invoke(Thread thread, Job job) {
            Intrinsics.checkParameterIsNotNull(thread, "thread");
            EventLoopImpl eventLoopImpl = new EventLoopImpl(thread);
            if (job != null) {
                eventLoopImpl.initParentJob(job);
            }
            return eventLoopImpl;
        }
    }
}
