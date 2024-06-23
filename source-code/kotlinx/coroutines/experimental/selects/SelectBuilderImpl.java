package kotlinx.coroutines.experimental.selects;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.experimental.DelayKt;
import kotlinx.coroutines.experimental.DispatchedKt;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.JobCancellationNode;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.internal.AtomicOp;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectBuilder;

public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R> {
    static final AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    volatile Object _result = SelectKt.UNDECIDED;
    volatile Object _state = this;
    private final Continuation<R> delegate;
    private volatile DisposableHandle parentHandle;

    @Override // kotlinx.coroutines.experimental.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectClause2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.experimental.Continuation<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        this.delegate = continuation;
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public Continuation<R> getCompletion() {
        return this;
    }

    private final void doResume(Function0<? extends Object> function0, Function0<Unit> function02) {
        if (isSelected()) {
            while (true) {
                Object obj = this._result;
                if (obj == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, function0.invoke())) {
                        return;
                    }
                } else if (obj != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    function02.invoke();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    public final Object getResult() {
        if (!isSelected()) {
            initCancellability();
        }
        Object obj = this._result;
        if (obj == SelectKt.UNDECIDED) {
            if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this._result;
        }
        if (obj == SelectKt.RESUMED) {
            throw new IllegalStateException("Already resumed");
        } else if (!(obj instanceof Fail)) {
            return obj;
        } else {
            throw ((Fail) obj).exception;
        }
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.Key);
        if (job != null) {
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new SelectOnCancellation(this, job), 2, null);
            this.parentHandle = invokeOnCompletion$default;
            if (isSelected()) {
                invokeOnCompletion$default.dispose();
            }
        }
    }

    public final class SelectOnCancellation extends JobCancellationNode<Job> {
        final /* synthetic */ SelectBuilderImpl this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectOnCancellation(SelectBuilderImpl selectBuilderImpl, Job job) {
            super(job);
            Intrinsics.checkParameterIsNotNull(job, "job");
            this.this$0 = selectBuilderImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.experimental.CompletionHandlerBase
        public void invoke(Throwable th) {
            if (this.this$0.trySelect(null)) {
                this.this$0.resumeSelectCancellableWithException(this.job.getCancellationException());
            }
        }

        @Override // kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode
        public String toString() {
            return "SelectOnCancellation[" + this.this$0 + ']';
        }
    }

    public final void handleBuilderException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        if (trySelect(null)) {
            resumeWithException(th);
        } else {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public boolean isSelected() {
        return getState() != this;
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public void disposeOnSelect(DisposableHandle disposableHandle) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        DisposeNode disposeNode = new DisposeNode(disposableHandle);
        while (getState() == this) {
            DisposeNode disposeNode2 = disposeNode;
            SelectBuilderImpl$disposeOnSelect$$inlined$addLastIf$1 selectBuilderImpl$disposeOnSelect$$inlined$addLastIf$1 = new SelectBuilderImpl$disposeOnSelect$$inlined$addLastIf$1(disposeNode2, disposeNode2, this);
            while (true) {
                Object prev = getPrev();
                if (prev != null) {
                    int tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(disposeNode2, this, selectBuilderImpl$disposeOnSelect$$inlined$addLastIf$1);
                    z = true;
                    if (tryCondAddNext != 1) {
                        if (tryCondAddNext == 2) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                }
            }
            if (z) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    private final void doAfterSelect() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Object next = getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof DisposeNode) {
                    ((DisposeNode) lockFreeLinkedListNode).handle.dispose();
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public boolean trySelect(Object obj) {
        if (!(obj instanceof OpDescriptor)) {
            do {
                Object state = getState();
                if (state != this) {
                    return obj != null && state == obj;
                }
            } while (!_state$FU.compareAndSet(this, this, obj));
            doAfterSelect();
            return true;
        }
        throw new IllegalStateException("cannot use OpDescriptor as idempotent marker".toString());
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public Object performAtomicTrySelect(AtomicDesc atomicDesc) {
        Intrinsics.checkParameterIsNotNull(atomicDesc, "desc");
        return new AtomicSelectOp(this, atomicDesc, true).perform(null);
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public Object performAtomicIfNotSelected(AtomicDesc atomicDesc) {
        Intrinsics.checkParameterIsNotNull(atomicDesc, "desc");
        return new AtomicSelectOp(this, atomicDesc, false).perform(null);
    }

    private final class AtomicSelectOp extends AtomicOp<Object> {
        public final AtomicDesc desc;
        public final boolean select;
        final /* synthetic */ SelectBuilderImpl this$0;

        public AtomicSelectOp(SelectBuilderImpl selectBuilderImpl, AtomicDesc atomicDesc, boolean z) {
            Intrinsics.checkParameterIsNotNull(atomicDesc, "desc");
            this.this$0 = selectBuilderImpl;
            this.desc = atomicDesc;
            this.select = z;
        }

        @Override // kotlinx.coroutines.experimental.internal.AtomicOp
        public Object prepare(Object obj) {
            Object prepareIfNotSelected;
            if (obj != null || (prepareIfNotSelected = prepareIfNotSelected()) == null) {
                return this.desc.prepare(this);
            }
            return prepareIfNotSelected;
        }

        @Override // kotlinx.coroutines.experimental.internal.AtomicOp
        public void complete(Object obj, Object obj2) {
            completeSelect(obj2);
            this.desc.complete(this, obj2);
        }

        public final Object prepareIfNotSelected() {
            SelectBuilderImpl selectBuilderImpl = this.this$0;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this.this$0);
                } else {
                    SelectBuilderImpl selectBuilderImpl2 = this.this$0;
                    if (obj != selectBuilderImpl2) {
                        return SelectKt.getALREADY_SELECTED();
                    }
                    if (SelectBuilderImpl._state$FU.compareAndSet(selectBuilderImpl2, this.this$0, this)) {
                        return null;
                    }
                }
            }
        }

        private final void completeSelect(Object obj) {
            SelectBuilderImpl selectBuilderImpl;
            boolean z = this.select && obj == null;
            if (z) {
                selectBuilderImpl = null;
            } else {
                selectBuilderImpl = this.this$0;
            }
            if (SelectBuilderImpl._state$FU.compareAndSet(this.this$0, this, selectBuilderImpl) && z) {
                this.this$0.doAfterSelect();
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(selectClause0, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        selectClause0.registerSelectClause0(this, function1);
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectClause1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        selectClause1.registerSelectClause1(this, function2);
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectClause2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        selectClause2.registerSelectClause2(this, p, function2);
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectBuilder
    public void onTimeout(long j, TimeUnit timeUnit, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        if (j > 0) {
            disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(j, timeUnit, new SelectBuilderImpl$onTimeout$$inlined$Runnable$1(this, function1)));
        } else if (trySelect(null)) {
            UndispatchedKt.startCoroutineUndispatched(function1, getCompletion());
        }
    }

    public static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle disposableHandle) {
            Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
            this.handle = disposableHandle;
        }
    }

    public static final class Fail {
        public final Throwable exception;

        public Fail(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "exception");
            this.exception = th;
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(R r) {
        if (isSelected()) {
            while (true) {
                Object obj = this._result;
                if (obj == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, r)) {
                        return;
                    }
                } else if (obj != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    DispatchedKt.resumeDirect(this.delegate, r);
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (isSelected()) {
            while (true) {
                Object obj = this._result;
                if (obj == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, new Fail(th))) {
                        return;
                    }
                } else if (obj != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    DispatchedKt.resumeDirectWithException(this.delegate, th);
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectInstance
    public void resumeSelectCancellableWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (isSelected()) {
            while (true) {
                Object obj = this._result;
                if (obj == SelectKt.UNDECIDED) {
                    if (_result$FU.compareAndSet(this, SelectKt.UNDECIDED, new Fail(th))) {
                        return;
                    }
                } else if (obj != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.RESUMED)) {
                    DispatchedKt.resumeCancellableWithException(this.delegate, th);
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be selected first".toString());
        }
    }

    /* access modifiers changed from: public */
    private final Object getState() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }
}
