package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.n30;
import tb.sd2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__ErrorsKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object a(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        int i;
        Throwable th;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuation;
            int i2 = flowKt__ErrorsKt$catchImpl$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ErrorsKt$catchImpl$1.result;
                Object obj2 = b.d();
                i = flowKt__ErrorsKt$catchImpl$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    try {
                        FlowCollector<? super Object> flowKt__ErrorsKt$catchImpl$$inlined$collect$1 = new FlowKt__ErrorsKt$catchImpl$$inlined$collect$1(flowCollector, ref$ObjectRef2);
                        flowKt__ErrorsKt$catchImpl$1.L$0 = ref$ObjectRef2;
                        flowKt__ErrorsKt$catchImpl$1.label = 1;
                        if (flow.collect(flowKt__ErrorsKt$catchImpl$$inlined$collect$1, flowKt__ErrorsKt$catchImpl$1) == obj2) {
                            return obj2;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        ref$ObjectRef = ref$ObjectRef2;
                        if (!c(th, ref$ObjectRef.element) && !b(th, flowKt__ErrorsKt$catchImpl$1.getContext())) {
                            return th;
                        }
                        throw th;
                    }
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$0;
                    try {
                        k12.b(obj);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
        Object obj3 = flowKt__ErrorsKt$catchImpl$1.result;
        Object obj22 = b.d();
        i = flowKt__ErrorsKt$catchImpl$1.label;
        if (i != 0) {
        }
    }

    private static final boolean b(Throwable th, CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return c(th, job.getCancellationException());
    }

    private static final boolean c(Throwable th, Throwable th2) {
        if (th2 != null) {
            if (n30.d()) {
                th2 = sd2.m(th2);
            }
            if (n30.d()) {
                th = sd2.m(th);
            }
            if (k21.d(th2, th)) {
                return true;
            }
        }
        return false;
    }
}
