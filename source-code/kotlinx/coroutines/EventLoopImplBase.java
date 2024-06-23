package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cf0;
import tb.jc0;
import tb.jl1;
import tb.k21;
import tb.kf;
import tb.l2;
import tb.n30;
import tb.ok2;
import tb.rk2;
import tb.t81;
import tb.ur2;
import tb.ww1;
import tb.zi1;

/* compiled from: Taobao */
public abstract class EventLoopImplBase extends l implements Delay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    @NotNull
    private volatile /* synthetic */ Object _delayed = null;
    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;
    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ltb/ur2;", "run", "", "toString", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    private final class DelayedResumeTask extends DelayedTask {
        @NotNull
        private final CancellableContinuation<ur2> cont;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super tb.ur2> */
        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
            super(j);
            this.cont = cancellableContinuation;
        }

        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, ur2.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        @NotNull
        public String toString() {
            return k21.r(super.toString(), this.cont);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ltb/ur2;", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Ljava/lang/Runnable;", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    private static final class DelayedRunnableTask extends DelayedTask {
        @NotNull
        private final Runnable block;

        public DelayedRunnableTask(long j, @NotNull Runnable runnable) {
            super(j);
            this.block = runnable;
        }

        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        @NotNull
        public String toString() {
            return k21.r(super.toString(), this.block);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R0\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010!8V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "other", "", "compareTo", "", "now", "", "timeToExecute", "Lkotlinx/coroutines/EventLoopImplBase$a;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "Ltb/ur2;", "dispose", "", "toString", "nanoTime", "J", "", "_heap", "Ljava/lang/Object;", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Ltb/rk2;", "value", "getHeap", "()Ltb/rk2;", "setHeap", "(Ltb/rk2;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        @Nullable
        private Object _heap;
        private int index = -1;
        @JvmField
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != cf0.b()) {
                a aVar = obj instanceof a ? (a) obj : null;
                if (aVar != null) {
                    aVar.g(this);
                }
                this._heap = cf0.b();
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        @Nullable
        public rk2<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof rk2) {
                return (rk2) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final synchronized int scheduleTask(long j, @NotNull a aVar, @NotNull EventLoopImplBase eventLoopImplBase) {
            if (this._heap == cf0.b()) {
                return 2;
            }
            synchronized (aVar) {
                DelayedTask delayedTask = (DelayedTask) aVar.b();
                if (eventLoopImplBase.isCompleted()) {
                    return 1;
                }
                if (delayedTask == null) {
                    aVar.b = j;
                } else {
                    long j2 = delayedTask.nanoTime;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - aVar.b > 0) {
                        aVar.b = j;
                    }
                }
                long j3 = this.nanoTime;
                long j4 = aVar.b;
                if (j3 - j4 < 0) {
                    this.nanoTime = j4;
                }
                aVar.a(this);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(@Nullable rk2<?> rk2) {
            if (this._heap != cf0.b()) {
                this._heap = rk2;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + jl1.ARRAY_END;
        }

        public int compareTo(@NotNull DelayedTask delayedTask) {
            int i = ((this.nanoTime - delayedTask.nanoTime) > 0 ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }
    }

    /* compiled from: Taobao */
    public static final class a extends rk2<DelayedTask> {
        @JvmField
        public long b;

        public a(long j) {
            this.b = j;
        }
    }

    private final void closeQueue() {
        if (!n30.a() || isCompleted()) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (_queue$FU.compareAndSet(this, null, cf0.a())) {
                        return;
                    }
                } else if (obj instanceof t81) {
                    ((t81) obj).d();
                    return;
                } else if (obj != cf0.a()) {
                    t81 t81 = new t81(8, true);
                    t81.a((Runnable) obj);
                    if (_queue$FU.compareAndSet(this, obj, t81)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof t81) {
                t81 t81 = (t81) obj;
                Object j = t81.j();
                if (j != t81.REMOVE_FROZEN) {
                    return (Runnable) j;
                }
                _queue$FU.compareAndSet(this, obj, t81.i());
            } else if (obj == cf0.a()) {
                return null;
            } else {
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            }
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
            } else if (obj instanceof t81) {
                t81 t81 = (t81) obj;
                int a2 = t81.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    _queue$FU.compareAndSet(this, obj, t81.i());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == cf0.a()) {
                return false;
            } else {
                t81 t812 = new t81(8, true);
                t812.a((Runnable) obj);
                t812.a(runnable);
                if (_queue$FU.compareAndSet(this, obj, t812)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final boolean isCompleted() {
        return this._isCompleted;
    }

    private final void rescheduleAllDelayed() {
        l2.a();
        long nanoTime = System.nanoTime();
        while (true) {
            a aVar = (a) this._delayed;
            DelayedTask delayedTask = aVar == null ? null : (DelayedTask) aVar.i();
            if (delayedTask != null) {
                reschedule(nanoTime, delayedTask);
            } else {
                return;
            }
        }
    }

    private final int scheduleImpl(long j, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        a aVar = (a) this._delayed;
        if (aVar == null) {
            _delayed$FU.compareAndSet(this, null, new a(j));
            aVar = (a) this._delayed;
            k21.f(aVar);
        }
        return delayedTask.scheduleTask(j, aVar, this);
    }

    private final void setCompleted(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        a aVar = (a) this._delayed;
        return (aVar == null ? null : (DelayedTask) aVar.e()) == delayedTask;
    }

    @Override // kotlinx.coroutines.Delay
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super ur2> continuation) {
        return Delay.a.a(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        enqueue(runnable);
    }

    public final void enqueue(@NotNull Runnable runnable) {
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.k
    public long getNextTime() {
        if (super.getNextTime() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof t81) {
                if (!((t81) obj).g()) {
                    return 0;
                }
            } else if (obj == cf0.a()) {
                return AbsPerformance.LONG_NIL;
            } else {
                return 0;
            }
        }
        a aVar = (a) this._delayed;
        DelayedTask delayedTask = aVar == null ? null : (DelayedTask) aVar.e();
        if (delayedTask == null) {
            return AbsPerformance.LONG_NIL;
        }
        long j = delayedTask.nanoTime;
        l2.a();
        return ww1.b(j - System.nanoTime(), 0);
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.a.b(this, j, runnable, coroutineContext);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.k
    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        a aVar = (a) this._delayed;
        if (aVar != null && !aVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof t81) {
                return ((t81) obj).g();
            }
            if (obj == cf0.a()) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f  */
    @Override // kotlinx.coroutines.k
    public long processNextEvent() {
        Runnable dequeue;
        Object obj;
        if (processUnconfinedEvent()) {
            return 0;
        }
        a aVar = (a) this._delayed;
        if (aVar == null || aVar.d()) {
            dequeue = dequeue();
            if (dequeue != null) {
                return getNextTime();
            }
            dequeue.run();
            return 0;
        }
        l2.a();
        long nanoTime = System.nanoTime();
        do {
            synchronized (aVar) {
                ThreadSafeHeapNode b = aVar.b();
                obj = null;
                if (b != null) {
                    DelayedTask delayedTask = (DelayedTask) b;
                    if (delayedTask.timeToExecute(nanoTime) ? enqueueImpl(delayedTask) : false) {
                        obj = aVar.h(0);
                    }
                }
            }
        } while (((DelayedTask) obj) != null);
        dequeue = dequeue();
        if (dequeue != null) {
        }
    }

    /* access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    public final void schedule(long j, @NotNull DelayedTask delayedTask) {
        int scheduleImpl = scheduleImpl(j, delayedTask);
        if (scheduleImpl != 0) {
            if (scheduleImpl == 1) {
                reschedule(j, delayedTask);
            } else if (scheduleImpl != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (shouldUnpark(delayedTask)) {
            unpark();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final DisposableHandle scheduleInvokeOnTimeout(long j, @NotNull Runnable runnable) {
        long d = cf0.d(j);
        if (d >= jc0.MAX_MILLIS) {
            return zi1.INSTANCE;
        }
        l2.a();
        long nanoTime = System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(d + nanoTime, runnable);
        schedule(nanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
        long d = cf0.d(j);
        if (d < jc0.MAX_MILLIS) {
            l2.a();
            long nanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(d + nanoTime, cancellableContinuation);
            kf.a(cancellableContinuation, delayedResumeTask);
            schedule(nanoTime, delayedResumeTask);
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.k
    public void shutdown() {
        ok2.INSTANCE.c();
        setCompleted(true);
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }
}
