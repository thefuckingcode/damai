package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CompletableDeferred;
import kotlinx.coroutines.experimental.selects.SelectClause1;
import kotlinx.coroutines.experimental.selects.SelectInstance;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\r\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019JH\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0001\u0010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\"\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0!\u0012\u0006\u0012\u0004\u0018\u00010\"0 H\u0016ø\u0001\u0000¢\u0006\u0002\u0010#R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8PX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\t¨\u0006$"}, d2 = {"Lkotlinx/coroutines/experimental/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/experimental/JobSupport;", "Lkotlinx/coroutines/experimental/CompletableDeferred;", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "parent", "Lkotlinx/coroutines/experimental/Job;", "(Lkotlinx/coroutines/experimental/Job;)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/experimental/selects/SelectClause1;", "onCancelMode", "", "getOnCancelMode$kotlinx_coroutines_core", "()I", "await", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "complete", "", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CompletableDeferred.kt */
public final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T>, SelectClause1<T> {
    @Override // kotlinx.coroutines.experimental.JobSupport
    public int getOnCancelMode$kotlinx_coroutines_core() {
        return 1;
    }

    @Override // kotlinx.coroutines.experimental.Deferred
    public boolean isComputing() {
        return CompletableDeferred.DefaultImpls.isComputing(this);
    }

    public CompletableDeferredImpl(Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
    }

    @Override // kotlinx.coroutines.experimental.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    @Override // kotlinx.coroutines.experimental.Deferred
    public Object await(Continuation<? super T> continuation) {
        CompletableDeferredImpl$await$1 completableDeferredImpl$await$1;
        int label;
        if (continuation instanceof CompletableDeferredImpl$await$1) {
            completableDeferredImpl$await$1 = (CompletableDeferredImpl$await$1) continuation;
            if ((completableDeferredImpl$await$1.getLabel() & Integer.MIN_VALUE) != 0) {
                completableDeferredImpl$await$1.setLabel(completableDeferredImpl$await$1.getLabel() - Integer.MIN_VALUE);
                Object obj = completableDeferredImpl$await$1.data;
                Throwable th = completableDeferredImpl$await$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = completableDeferredImpl$await$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        CompletableDeferredImpl completableDeferredImpl = (CompletableDeferredImpl) completableDeferredImpl$await$1.L$0;
                        if (th != null) {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    completableDeferredImpl$await$1.L$0 = this;
                    completableDeferredImpl$await$1.setLabel(1);
                    obj = awaitInternal$kotlinx_coroutines_core(completableDeferredImpl$await$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw th;
                }
                return obj;
            }
        }
        completableDeferredImpl$await$1 = new CompletableDeferredImpl$await$1(this, continuation);
        Object obj2 = completableDeferredImpl$await$1.data;
        Throwable th2 = completableDeferredImpl$await$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = completableDeferredImpl$await$1.getLabel();
        if (label == 0) {
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.experimental.Deferred
    public SelectClause1<T> getOnAwait() {
        return this;
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectClause1
    public <R> void registerSelectClause1(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        registerSelectClause1Internal$kotlinx_coroutines_core(selectInstance, function2);
    }

    @Override // kotlinx.coroutines.experimental.CompletableDeferred
    public boolean complete(T t) {
        return makeCompleting$kotlinx_coroutines_core(t);
    }

    @Override // kotlinx.coroutines.experimental.CompletableDeferred
    public boolean completeExceptionally(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th));
    }
}
