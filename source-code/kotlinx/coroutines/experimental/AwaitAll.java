package kotlinx.coroutines.experimental;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/experimental/AwaitAll;", "T", "", "deferreds", "", "Lkotlinx/coroutines/experimental/Deferred;", "([Lkotlinx/coroutines/experimental/Deferred;)V", "[Lkotlinx/coroutines/experimental/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Await.kt */
public final class AwaitAll<T> {
    static final AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    private final Deferred<T>[] deferreds;
    volatile int notCompletedCount;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.experimental.Deferred<? extends T>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(Deferred<? extends T>[] deferredArr) {
        Intrinsics.checkParameterIsNotNull(deferredArr, "deferreds");
        this.deferreds = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/experimental/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/experimental/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/experimental/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/experimental/AwaitAll;", "(Lkotlinx/coroutines/experimental/AwaitAll;[Lkotlinx/coroutines/experimental/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/experimental/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Await.kt */
    public final class DisposeHandlersOnCancel extends CancelHandler {
        private final AwaitAll<T>.AwaitAllNode[] nodes;
        final /* synthetic */ AwaitAll this$0;

        public DisposeHandlersOnCancel(AwaitAll awaitAll, AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            Intrinsics.checkParameterIsNotNull(awaitAllNodeArr, "nodes");
            this.this$0 = awaitAll;
            this.nodes = awaitAllNodeArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        public final void disposeAll() {
            for (AwaitAll<T>.AwaitAllNode awaitAllNode : this.nodes) {
                awaitAllNode.getHandle().dispose();
            }
        }

        @Override // kotlinx.coroutines.experimental.CancelHandlerBase
        public void invoke(Throwable th) {
            disposeAll();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u000e\u0018\u00010\tR\b\u0012\u0004\u0012\u00028\u00000\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/experimental/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/experimental/JobNode;", "Lkotlinx/coroutines/experimental/Job;", "continuation", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "job", "(Lkotlinx/coroutines/experimental/AwaitAll;Lkotlinx/coroutines/experimental/CancellableContinuation;Lkotlinx/coroutines/experimental/Job;)V", "disposer", "Lkotlinx/coroutines/experimental/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/experimental/AwaitAll;", "getDisposer", "()Lkotlinx/coroutines/experimental/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/experimental/AwaitAll$DisposeHandlersOnCancel;)V", "handle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/experimental/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/experimental/DisposableHandle;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Await.kt */
    public final class AwaitAllNode extends JobNode<Job> {
        private final CancellableContinuation<List<? extends T>> continuation;
        private volatile AwaitAll<T>.DisposeHandlersOnCancel disposer;
        public DisposableHandle handle;
        final /* synthetic */ AwaitAll this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.experimental.CancellableContinuation<? super java.util.List<? extends T>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AwaitAllNode(AwaitAll awaitAll, CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
            super(job);
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
            Intrinsics.checkParameterIsNotNull(job, "job");
            this.this$0 = awaitAll;
            this.continuation = cancellableContinuation;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handle");
            }
            return disposableHandle;
        }

        public final void setHandle(DisposableHandle disposableHandle) {
            Intrinsics.checkParameterIsNotNull(disposableHandle, "<set-?>");
            this.handle = disposableHandle;
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel getDisposer() {
            return this.disposer;
        }

        public final void setDisposer(AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            this.disposer = disposeHandlersOnCancel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.experimental.CompletionHandlerBase
        public void invoke(Throwable th) {
            if (th != null) {
                Object tryResumeWithException = this.continuation.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    this.continuation.completeResume(tryResumeWithException);
                    AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = this.disposer;
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.disposeAll();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.notCompletedCount$FU.decrementAndGet(this.this$0) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.continuation;
                Deferred[] deferredArr = this.this$0.deferreds;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resume(arrayList);
            }
        }
    }

    public final Object await(Continuation<? super List<? extends T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int length = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        for (int i = 0; i < length; i++) {
            Deferred deferred = this.deferreds[i];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(this, cancellableContinuationImpl2, deferred);
            awaitAllNode.setHandle(deferred.invokeOnCompletion(awaitAllNode));
            awaitAllNodeArr[i] = awaitAllNode;
        }
        AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(this, awaitAllNodeArr);
        for (int i2 = 0; i2 < length; i2++) {
            awaitAllNodeArr[i2].setDisposer(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl2.isCompleted()) {
            disposeHandlersOnCancel.disposeAll();
        } else {
            cancellableContinuationImpl2.invokeOnCancellation(disposeHandlersOnCancel);
        }
        return cancellableContinuationImpl.getResult();
    }
}
