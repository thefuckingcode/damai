package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Deferred;
import kotlinx.coroutines.experimental.selects.SelectClause1;
import kotlinx.coroutines.experimental.selects.SelectInstance;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\r\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010JH\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\t¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/experimental/DeferredCoroutine;", "T", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "Lkotlinx/coroutines/experimental/Deferred;", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/experimental/selects/SelectClause1;", "await", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Deferred.kt */
public class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T>, SelectClause1<T> {
    @Override // kotlinx.coroutines.experimental.Deferred
    public Object await(Continuation<? super T> continuation) {
        return await$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.experimental.Deferred
    public boolean isComputing() {
        return Deferred.DefaultImpls.isComputing(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeferredCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
    }

    @Override // kotlinx.coroutines.experimental.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    static /* synthetic */ Object await$suspendImpl(DeferredCoroutine deferredCoroutine, Continuation continuation) {
        DeferredCoroutine$await$1 deferredCoroutine$await$1;
        int label;
        if (continuation instanceof DeferredCoroutine$await$1) {
            deferredCoroutine$await$1 = (DeferredCoroutine$await$1) continuation;
            if ((deferredCoroutine$await$1.getLabel() & Integer.MIN_VALUE) != 0) {
                deferredCoroutine$await$1.setLabel(deferredCoroutine$await$1.getLabel() - Integer.MIN_VALUE);
                Object obj = deferredCoroutine$await$1.data;
                Throwable th = deferredCoroutine$await$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = deferredCoroutine$await$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        DeferredCoroutine deferredCoroutine2 = (DeferredCoroutine) deferredCoroutine$await$1.L$0;
                        if (th != null) {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    deferredCoroutine$await$1.L$0 = deferredCoroutine;
                    deferredCoroutine$await$1.setLabel(1);
                    obj = deferredCoroutine.awaitInternal$kotlinx_coroutines_core(deferredCoroutine$await$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw th;
                }
                return obj;
            }
        }
        deferredCoroutine$await$1 = new DeferredCoroutine$await$1(deferredCoroutine, continuation);
        Object obj2 = deferredCoroutine$await$1.data;
        Throwable th2 = deferredCoroutine$await$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = deferredCoroutine$await$1.getLabel();
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
}
