package kotlinx.coroutines.experimental;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.experimental.Job;

public final /* synthetic */ class JobKt__JobKt {
    public static final Job Job(Job job) {
        return new JobImpl(job);
    }

    public static /* bridge */ /* synthetic */ Job Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final DisposableHandle unregisterOnCompletion(Job job, DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(job, "$receiver");
        Intrinsics.checkParameterIsNotNull(disposableHandle, "registration");
        return job.invokeOnCompletion(new DisposeOnCompletion(job, disposableHandle));
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(job, "$receiver");
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        return job.invokeOnCompletion(new DisposeOnCompletion(job, disposableHandle));
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        return job.join(continuation);
    }

    public static /* bridge */ /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        JobKt.cancelChildren(job, th);
    }

    public static final void cancelChildren(Job job, Throwable th) {
        Intrinsics.checkParameterIsNotNull(job, "$receiver");
        for (Job job2 : job.getChildren()) {
            job2.cancel(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final Object joinChildren(Job job, Continuation<? super Unit> continuation) {
        JobKt__JobKt$joinChildren$1 jobKt__JobKt$joinChildren$1;
        int label;
        Job job2;
        Iterator<Job> it;
        Sequence<Job> sequence;
        if (continuation instanceof JobKt__JobKt$joinChildren$1) {
            jobKt__JobKt$joinChildren$1 = (JobKt__JobKt$joinChildren$1) continuation;
            if ((jobKt__JobKt$joinChildren$1.getLabel() & Integer.MIN_VALUE) != 0) {
                jobKt__JobKt$joinChildren$1.setLabel(jobKt__JobKt$joinChildren$1.getLabel() - Integer.MIN_VALUE);
                Object obj = jobKt__JobKt$joinChildren$1.data;
                Throwable th = jobKt__JobKt$joinChildren$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = jobKt__JobKt$joinChildren$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Job job3 = (Job) jobKt__JobKt$joinChildren$1.L$4;
                        Object obj2 = jobKt__JobKt$joinChildren$1.L$3;
                        it = (Iterator) jobKt__JobKt$joinChildren$1.L$2;
                        sequence = (Sequence) jobKt__JobKt$joinChildren$1.L$1;
                        Job job4 = (Job) jobKt__JobKt$joinChildren$1.L$0;
                        if (th == null) {
                            job2 = job4;
                        } else {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    Sequence<Job> children = job.getChildren();
                    Iterator<Job> it2 = children.iterator();
                    job2 = job;
                    it = it2;
                    sequence = children;
                } else {
                    throw th;
                }
                while (it.hasNext()) {
                    Job next = it.next();
                    Job job5 = next;
                    jobKt__JobKt$joinChildren$1.L$0 = job2;
                    jobKt__JobKt$joinChildren$1.L$1 = sequence;
                    jobKt__JobKt$joinChildren$1.L$2 = it;
                    jobKt__JobKt$joinChildren$1.L$3 = next;
                    jobKt__JobKt$joinChildren$1.L$4 = job5;
                    jobKt__JobKt$joinChildren$1.setLabel(1);
                    if (job5.join(jobKt__JobKt$joinChildren$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        jobKt__JobKt$joinChildren$1 = new JobKt__JobKt$joinChildren$1(continuation);
        Object obj3 = jobKt__JobKt$joinChildren$1.data;
        Throwable th2 = jobKt__JobKt$joinChildren$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = jobKt__JobKt$joinChildren$1.getLabel();
        if (label == 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$receiver");
        Job job = (Job) coroutineContext.get(Job.Key);
        return job != null && job.isActive();
    }

    public static /* bridge */ /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return JobKt.cancel(coroutineContext, th);
    }

    public static final boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$receiver");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job.cancel(th);
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        JobKt.cancelChildren(coroutineContext, th);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$receiver");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            JobKt.cancelChildren(job, th);
        }
    }

    public static final Object join(Job job, Continuation<? super Unit> continuation) {
        return job.join(continuation);
    }
}
