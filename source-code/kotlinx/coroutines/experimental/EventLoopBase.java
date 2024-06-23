package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.experimental.Delay;
import kotlinx.coroutines.experimental.internal.LockFreeMPSCQueueCore;
import kotlinx.coroutines.experimental.internal.ThreadSafeHeap;
import kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003678B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\u0010\u0010\u0017\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0018j\u0002`\u0019H\u0016J\u0014\u0010\u001e\u001a\u00020\f2\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u0019H\u0002J\u0019\u0010 \u001a\u00020\u00162\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0002\b!J(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00122\n\u0010%\u001a\u00060&j\u0002`'2\n\u0010\u001d\u001a\u00060\u0018j\u0002`\u0019H\u0016J\b\u0010(\u001a\u00020\fH$J\b\u0010)\u001a\u00020\u0012H\u0016J\u0019\u0010*\u001a\u00020\u00162\n\u0010+\u001a\u00060\bR\u00020\u0000H\u0000¢\u0006\u0002\b,J\b\u0010-\u001a\u00020\u0016H\u0004J\b\u0010.\u001a\u00020\u0016H\u0004J\u0019\u0010/\u001a\u00020\u00162\n\u0010+\u001a\u00060\bR\u00020\u0000H\u0000¢\u0006\u0002\b0J\u0014\u00101\u001a\u00020\f2\n\u0010+\u001a\u00060\bR\u00020\u0000H\u0002J*\u00102\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00122\n\u0010%\u001a\u00060&j\u0002`'2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001604H\u0016J\b\u00105\u001a\u00020\u0016H$R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\b\u0012\u00060\bR\u00020\u0000\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00069"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopBase;", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "Lkotlinx/coroutines/experimental/Delay;", "Lkotlinx/coroutines/experimental/EventLoop;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/experimental/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/experimental/EventLoopBase$DelayedTask;", "_queue", "", "isCompleted", "", "()Z", "isDelayedEmpty", "isEmpty", "isQueueEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "dispatch", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "block", "enqueueImpl", "task", "execute", "execute$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/experimental/DisposableHandle;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "isCorrectThread", "processNextEvent", "removeDelayedImpl", "delayedTask", "removeDelayedImpl$kotlinx_coroutines_core", "rescheduleAllDelayed", "resetAll", "schedule", "schedule$kotlinx_coroutines_core", "scheduleImpl", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: EventLoop.kt */
public abstract class EventLoopBase extends CoroutineDispatcher implements Delay, EventLoop {
    static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopBase.class, Object.class, "_delayed");
    private static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopBase.class, Object.class, "_queue");
    volatile Object _delayed = null;
    private volatile Object _queue = null;

    /* access modifiers changed from: protected */
    public abstract boolean isCompleted();

    /* access modifiers changed from: protected */
    public abstract boolean isCorrectThread();

    /* access modifiers changed from: protected */
    public abstract void unpark();

    @Override // kotlinx.coroutines.experimental.Delay
    public Object delay(long j, TimeUnit timeUnit, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, timeUnit, continuation);
    }

    /* access modifiers changed from: protected */
    public final boolean isEmpty() {
        return isQueueEmpty() && isDelayedEmpty();
    }

    private final boolean isQueueEmpty() {
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof LockFreeMPSCQueueCore) {
            return ((LockFreeMPSCQueueCore) obj).isEmpty();
        }
        if (obj == EventLoopKt.access$getCLOSED_EMPTY$p()) {
            return true;
        }
        return false;
    }

    private final boolean isDelayedEmpty() {
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        return threadSafeHeap == null || threadSafeHeap.isEmpty();
    }

    private final long getNextTime() {
        DelayedTask delayedTask;
        if (!isQueueEmpty()) {
            return 0;
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap == null || (delayedTask = (DelayedTask) threadSafeHeap.peek()) == null) {
            return LongCompanionObject.MAX_VALUE;
        }
        return RangesKt.coerceAtLeast(delayedTask.nanoTime - TimeSourceKt.getTimeSource().nanoTime(), 0L);
    }

    @Override // kotlinx.coroutines.experimental.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        execute$kotlinx_coroutines_core(runnable);
    }

    @Override // kotlinx.coroutines.experimental.Delay
    public void scheduleResumeAfterDelay(long j, TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        schedule$kotlinx_coroutines_core(new DelayedResumeTask(this, j, timeUnit, cancellableContinuation));
    }

    @Override // kotlinx.coroutines.experimental.Delay
    public DisposableHandle invokeOnTimeout(long j, TimeUnit timeUnit, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(this, j, timeUnit, runnable);
        schedule$kotlinx_coroutines_core(delayedRunnableTask);
        return delayedRunnableTask;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f  */
    @Override // kotlinx.coroutines.experimental.EventLoop
    public long processNextEvent() {
        Runnable dequeue;
        Object obj;
        if (!isCorrectThread()) {
            return LongCompanionObject.MAX_VALUE;
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap == null || threadSafeHeap.isEmpty()) {
            dequeue = dequeue();
            if (dequeue != null) {
                dequeue.run();
            }
            return getNextTime();
        }
        long nanoTime = TimeSourceKt.getTimeSource().nanoTime();
        do {
            synchronized (threadSafeHeap) {
                ThreadSafeHeapNode firstImpl = threadSafeHeap.firstImpl();
                obj = null;
                if (firstImpl != null) {
                    DelayedTask delayedTask = (DelayedTask) firstImpl;
                    if (delayedTask.timeToExecute(nanoTime) ? enqueueImpl(delayedTask) : false) {
                        obj = threadSafeHeap.removeAtImpl(0);
                    }
                }
            }
        } while (((DelayedTask) obj) != null);
        dequeue = dequeue();
        if (dequeue != null) {
        }
        return getNextTime();
    }

    public final void execute$kotlinx_coroutines_core(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "task");
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public final void closeQueue() {
        isCompleted();
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, EventLoopKt.access$getCLOSED_EMPTY$p())) {
                    return;
                }
            } else if (obj instanceof LockFreeMPSCQueueCore) {
                ((LockFreeMPSCQueueCore) obj).close();
                return;
            } else if (obj != EventLoopKt.access$getCLOSED_EMPTY$p()) {
                LockFreeMPSCQueueCore lockFreeMPSCQueueCore = new LockFreeMPSCQueueCore(8);
                if (obj != null) {
                    lockFreeMPSCQueueCore.addLast((Runnable) obj);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore)) {
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */");
                }
            } else {
                return;
            }
        }
    }

    public final void schedule$kotlinx_coroutines_core(DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        if (scheduleImpl(delayedTask)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(delayedTask);
        }
    }

    private final boolean scheduleImpl(DelayedTask delayedTask) {
        if (isCompleted()) {
            return false;
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap == null) {
            EventLoopBase eventLoopBase = this;
            _delayed$FU.compareAndSet(eventLoopBase, null, new ThreadSafeHeap());
            Object obj = eventLoopBase._delayed;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            threadSafeHeap = (ThreadSafeHeap) obj;
        }
        return threadSafeHeap.addLastIf(delayedTask, new EventLoopBase$scheduleImpl$1(this));
    }

    public final void removeDelayedImpl$kotlinx_coroutines_core(DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap != null) {
            threadSafeHeap.remove(delayedTask);
        }
    }

    /* access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    /* access modifiers changed from: protected */
    public final void rescheduleAllDelayed() {
        DelayedTask delayedTask;
        while (true) {
            ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
            if (threadSafeHeap != null && (delayedTask = (DelayedTask) threadSafeHeap.removeFirstOrNull()) != null) {
                delayedTask.rescheduleOnShutdown();
            } else {
                return;
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\f\u0012\b\u0012\u00060\u0000R\u00020\u00040\u00032\u00020\u00052\u00020\u0006B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u00060\nj\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0017\u001a\u00020\u000e2\n\u0010\u0018\u001a\u00060\u0000R\u00020\u0004H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bJ\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006!"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "", "Lkotlinx/coroutines/experimental/EventLoopBase;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "Lkotlinx/coroutines/experimental/internal/ThreadSafeHeapNode;", "time", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "(Lkotlinx/coroutines/experimental/EventLoopBase;JLjava/util/concurrent/TimeUnit;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "state", "getState", "setState", "compareTo", "other", "dispose", "", "rescheduleOnShutdown", "timeToExecute", "", "now", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: EventLoop.kt */
    public abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private int index = -1;
        public final long nanoTime;
        private int state;
        final /* synthetic */ EventLoopBase this$0;

        public DelayedTask(EventLoopBase eventLoopBase, long j, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            this.this$0 = eventLoopBase;
            this.nanoTime = TimeSourceKt.getTimeSource().nanoTime() + timeUnit.toNanos(j);
        }

        @Override // kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.experimental.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public final int getState() {
            return this.state;
        }

        public final void setState(int i) {
            this.state = i;
        }

        public int compareTo(DelayedTask delayedTask) {
            Intrinsics.checkParameterIsNotNull(delayedTask, "other");
            long j = this.nanoTime - delayedTask.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        public final void rescheduleOnShutdown() {
            synchronized (this) {
                if (this.state == 0) {
                    Object obj = this.this$0._delayed;
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    if (((ThreadSafeHeap) obj).remove(this)) {
                        this.state = 2;
                        DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(this);
                    } else {
                        this.state = 1;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override // kotlinx.coroutines.experimental.DisposableHandle
        public final void dispose() {
            synchronized (this) {
                int i = this.state;
                if (i == 0) {
                    ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this.this$0._delayed;
                    if (threadSafeHeap != null) {
                        threadSafeHeap.remove(this);
                    }
                } else if (i == 2) {
                    DefaultExecutor.INSTANCE.removeDelayedImpl$kotlinx_coroutines_core(this);
                } else {
                    return;
                }
                this.state = 1;
                Unit unit = Unit.INSTANCE;
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopBase$DelayedResumeTask;", "Lkotlinx/coroutines/experimental/EventLoopBase$DelayedTask;", "Lkotlinx/coroutines/experimental/EventLoopBase;", "time", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "cont", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "(Lkotlinx/coroutines/experimental/EventLoopBase;JLjava/util/concurrent/TimeUnit;Lkotlinx/coroutines/experimental/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: EventLoop.kt */
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopBase this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlinx.coroutines.experimental.CancellableContinuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DelayedResumeTask(EventLoopBase eventLoopBase, long j, TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(eventLoopBase, j, timeUnit);
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.this$0 = eventLoopBase;
            this.cont = cancellableContinuation;
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, this);
        }

        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopBase$DelayedRunnableTask;", "Lkotlinx/coroutines/experimental/EventLoopBase$DelayedTask;", "Lkotlinx/coroutines/experimental/EventLoopBase;", "time", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/experimental/Runnable;", "(Lkotlinx/coroutines/experimental/EventLoopBase;JLjava/util/concurrent/TimeUnit;Ljava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: EventLoop.kt */
    private final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;
        final /* synthetic */ EventLoopBase this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DelayedRunnableTask(EventLoopBase eventLoopBase, long j, TimeUnit timeUnit, Runnable runnable) {
            super(eventLoopBase, j, timeUnit);
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            this.this$0 = eventLoopBase;
            this.block = runnable;
        }

        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.experimental.EventLoopBase.DelayedTask
        public String toString() {
            return super.toString() + this.block.toString();
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeMPSCQueueCore) {
                if (obj != null) {
                    LockFreeMPSCQueueCore lockFreeMPSCQueueCore = (LockFreeMPSCQueueCore) obj;
                    int addLast = lockFreeMPSCQueueCore.addLast(runnable);
                    if (addLast == 0) {
                        return true;
                    }
                    if (addLast == 1) {
                        _queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore.next());
                    } else if (addLast == 2) {
                        return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.Queue<kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.experimental.internal.LockFreeMPSCQueueCore<kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == EventLoopKt.access$getCLOSED_EMPTY$p()) {
                return false;
            } else {
                LockFreeMPSCQueueCore lockFreeMPSCQueueCore2 = new LockFreeMPSCQueueCore(8);
                if (obj != null) {
                    lockFreeMPSCQueueCore2.addLast((Runnable) obj);
                    lockFreeMPSCQueueCore2.addLast(runnable);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore2)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeMPSCQueueCore) {
                if (obj != null) {
                    LockFreeMPSCQueueCore lockFreeMPSCQueueCore = (LockFreeMPSCQueueCore) obj;
                    Object removeFirstOrNull = lockFreeMPSCQueueCore.removeFirstOrNull();
                    if (removeFirstOrNull != LockFreeMPSCQueueCore.REMOVE_FROZEN) {
                        return (Runnable) removeFirstOrNull;
                    }
                    _queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore.next());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.Queue<kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.experimental.internal.LockFreeMPSCQueueCore<kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == EventLoopKt.access$getCLOSED_EMPTY$p()) {
                return null;
            } else {
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
