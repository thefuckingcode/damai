package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jh2;
import tb.k21;
import tb.l2;
import tb.lj2;
import tb.m40;
import tb.n30;
import tb.q30;
import tb.qz2;
import tb.ur2;
import tb.us0;
import tb.ww1;
import tb.yi1;

/* compiled from: Taobao */
public final class CoroutineScheduler implements Closeable, Executor {
    @NotNull
    public static final a Companion = new a(null);
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    @JvmField
    @NotNull
    public static final jh2 NOT_IN_STACK = new jh2("NOT_IN_STACK");
    private static final /* synthetic */ AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    @NotNull
    private volatile /* synthetic */ int _isTerminated;
    @JvmField
    public final int a;
    @JvmField
    public final int b;
    @JvmField
    public final long c;
    @NotNull
    volatile /* synthetic */ long controlState;
    @JvmField
    @NotNull
    public final String d;
    @JvmField
    @NotNull
    public final us0 e;
    @JvmField
    @NotNull
    public final us0 f;
    @JvmField
    @NotNull
    public final AtomicReferenceArray<Worker> g;
    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, @NotNull String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.d = str;
        if (i2 >= 1) {
            if (i3 >= i2) {
                if (i3 <= 2097150) {
                    if (j2 > 0) {
                        this.e = new us0();
                        this.f = new us0();
                        this.parkedWorkersStack = 0;
                        this.g = new AtomicReferenceArray<>(i3 + 1);
                        this.controlState = ((long) i2) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
    }

    private final boolean a(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            return this.f.a(task);
        }
        return this.e.a(task);
    }

    private final int c() {
        synchronized (this.g) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            boolean z = false;
            int i3 = ww1.a(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (i3 >= this.a) {
                return 0;
            }
            if (i2 >= this.b) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (i4 > 0 && this.g.get(i4) == null) {
                Worker worker = new Worker(i4);
                this.g.set(i4, worker);
                if (i4 == ((int) (2097151 & i.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    worker.start();
                    return i3 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Worker e() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker != null && k21.d(CoroutineScheduler.this, this)) {
            return worker;
        }
        return null;
    }

    public static /* synthetic */ void g(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = yi1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.f(runnable, taskContext, z);
    }

    private final int h(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final Worker j() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            Worker worker = this.g.get((int) (2097151 & j2));
            if (worker == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            int h2 = h(worker);
            if (h2 >= 0 && h.compareAndSet(this, j2, ((long) h2) | j3)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }

    private final void o(boolean z) {
        long addAndGet = i.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (!z && !t() && !r(addAndGet)) {
            t();
        }
    }

    private final Task q(Worker worker, Task task, boolean z) {
        if (worker == null || worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.a(task, z);
    }

    private final boolean r(long j2) {
        if (ww1.a(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.a) {
            int c2 = c();
            if (c2 == 1 && this.a > 1) {
                c();
            }
            if (c2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean s(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.r(j2);
    }

    private final boolean t() {
        Worker j2;
        do {
            j2 = j();
            if (j2 == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(j2, -1, 0));
        LockSupport.unpark(j2);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n(10000);
    }

    @NotNull
    public final Task d(@NotNull Runnable runnable, @NotNull TaskContext taskContext) {
        long a2 = lj2.a.a();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, a2, taskContext);
        }
        Task task = (Task) runnable;
        task.submissionTime = a2;
        task.taskContext = taskContext;
        return task;
    }

    public void execute(@NotNull Runnable runnable) {
        g(this, runnable, null, false, 6, null);
    }

    public final void f(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        l2.a();
        Task d2 = d(runnable, taskContext);
        Worker e2 = e();
        Task q = q(e2, d2, z);
        if (q == null || a(q)) {
            boolean z2 = z && e2 != null;
            if (d2.taskContext.getTaskMode() != 0) {
                o(z2);
            } else if (!z2) {
                p();
            }
        } else {
            throw new RejectedExecutionException(k21.r(this.d, " was terminated"));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean k(@NotNull Worker worker) {
        long j2;
        long j3;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            indexInArray = worker.getIndexInArray();
            if (n30.a()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.g.get(i2));
        } while (!h.compareAndSet(this, j2, ((long) indexInArray) | j3));
        return true;
    }

    public final void l(@NotNull Worker worker, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            if (i4 == i2) {
                i4 = i3 == 0 ? h(worker) : i3;
            }
            if (i4 >= 0 && h.compareAndSet(this, j2, j3 | ((long) i4))) {
                return;
            }
        }
    }

    public final void m(@NotNull Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            l2.a();
            throw th;
        }
        l2.a();
    }

    public final void n(long j2) {
        int i2;
        Task task;
        boolean z = false;
        if (j.compareAndSet(this, 0, 1)) {
            Worker e2 = e();
            synchronized (this.g) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    Worker worker = this.g.get(i3);
                    k21.f(worker);
                    if (worker != e2) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(j2);
                        }
                        WorkerState workerState = worker.state;
                        if (n30.a()) {
                            if (!(workerState == WorkerState.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        worker.localQueue.g(this.f);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            this.f.b();
            this.e.b();
            while (true) {
                if (e2 == null) {
                    task = null;
                } else {
                    task = e2.findTask(true);
                }
                if (task == null) {
                    task = (Task) this.e.d();
                }
                if (task == null && (task = (Task) this.f.d()) == null) {
                    break;
                }
                m(task);
            }
            if (e2 != null) {
                e2.tryReleaseCpu(WorkerState.TERMINATED);
            }
            if (n30.a()) {
                if (((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.a) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final void p() {
        if (!t() && !s(this, 0, 1, null)) {
            t();
        }
    }

    @NotNull
    public String toString() {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        int length = this.g.length();
        int i6 = 0;
        if (1 < length) {
            i4 = 0;
            int i7 = 0;
            i3 = 0;
            i2 = 0;
            int i8 = 1;
            while (true) {
                int i9 = i8 + 1;
                Worker worker = this.g.get(i8);
                if (worker != null) {
                    int f2 = worker.localQueue.f();
                    int i10 = b.$EnumSwitchMapping$0[worker.state.ordinal()];
                    if (i10 == 1) {
                        i6++;
                    } else if (i10 == 2) {
                        i4++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(f2);
                        sb.append('b');
                        arrayList.add(sb.toString());
                    } else if (i10 == 3) {
                        i7++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(f2);
                        sb2.append('c');
                        arrayList.add(sb2.toString());
                    } else if (i10 == 4) {
                        i3++;
                        if (f2 > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(f2);
                            sb3.append('d');
                            arrayList.add(sb3.toString());
                        }
                    } else if (i10 == 5) {
                        i2++;
                    }
                }
                if (i9 >= length) {
                    break;
                }
                i8 = i9;
            }
            i5 = i6;
            i6 = i7;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        long j2 = this.controlState;
        return this.d + '@' + q30.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + i6 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i3 + ", terminated = " + i2 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bA\u0010BB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\bA\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0019R*\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0011R\u0016\u0010-\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u00101R\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010)R\u0016\u0010;\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020=8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", "tryAcquireCpuPermit", "()Z", "Ltb/ur2;", "runWorker", "()V", "tryPark", "inStack", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "taskMode", "beforeTask", "(I)V", "afterTask", "park", "tryTerminateWorker", "mode", "idleReset", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", "trySteal", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "nextInt", "(I)I", "findTask", "index", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "terminationDeadline", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "mayHaveLocalTasks", "Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public final class Worker extends Thread {
        static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        @JvmField
        @NotNull
        public final qz2 localQueue;
        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        @Nullable
        private volatile Object nextParkedWorker;
        private int rngState;
        @JvmField
        @NotNull
        public WorkerState state;
        private long terminationDeadline;
        @NotNull
        volatile /* synthetic */ int workerCtl;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        private Worker() {
            setDaemon(true);
            this.localQueue = new qz2();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        private final void afterTask(int i) {
            if (i != 0) {
                CoroutineScheduler.i.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.state;
                if (workerState != WorkerState.TERMINATED) {
                    if (n30.a()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.state = WorkerState.DORMANT;
                }
            }
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.p();
            }
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.m(task);
            afterTask(taskMode);
        }

        private final Task findAnyTask(boolean z) {
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (z) {
                boolean z2 = nextInt(CoroutineScheduler.this.a * 2) == 0;
                if (z2 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task h = this.localQueue.h();
                if (h != null) {
                    return h;
                }
                if (!z2 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(false);
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0;
            if (this.state == WorkerState.PARKING) {
                if (n30.a()) {
                    boolean z = true;
                    if (i != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.c);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.e.d();
                return task == null ? (Task) CoroutineScheduler.this.f.d() : task;
            }
            Task task2 = (Task) CoroutineScheduler.this.f.d();
            return task2 == null ? (Task) CoroutineScheduler.this.e.d() : task2;
        }

        private final void runWorker() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (!z) {
                            z = true;
                        } else {
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0;
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z;
            if (this.state != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                        if (CoroutineScheduler.i.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.state = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.k(this);
                return;
            }
            if (n30.a()) {
                if (!(this.localQueue.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (inStack() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(boolean z) {
            long j;
            if (n30.a()) {
                if (!(this.localQueue.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int nextInt = nextInt(i);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                nextInt++;
                if (nextInt > i) {
                    nextInt = 1;
                }
                Worker worker = coroutineScheduler.g.get(nextInt);
                if (!(worker == null || worker == this)) {
                    if (n30.a()) {
                        if (!(this.localQueue.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        j = this.localQueue.k(worker.localQueue);
                    } else {
                        j = this.localQueue.l(worker.localQueue);
                    }
                    if (j == -1) {
                        return this.localQueue.h();
                    }
                    if (j > 0) {
                        j2 = Math.min(j2, j);
                    }
                }
            }
            if (j2 == AbsPerformance.LONG_NIL) {
                j2 = 0;
            }
            this.minDelayUntilStealableTaskNs = j2;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.g) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (coroutineScheduler.controlState & 2097151)) > coroutineScheduler.a) {
                        if (workerCtl$FU.compareAndSet(this, -1, 1)) {
                            int indexInArray2 = getIndexInArray();
                            setIndexInArray(0);
                            coroutineScheduler.l(this, indexInArray2, 0);
                            int andDecrement = (int) (CoroutineScheduler.i.getAndDecrement(coroutineScheduler) & 2097151);
                            if (andDecrement != indexInArray2) {
                                Worker worker = coroutineScheduler.g.get(andDecrement);
                                k21.f(worker);
                                coroutineScheduler.g.set(indexInArray2, worker);
                                worker.setIndexInArray(indexInArray2);
                                coroutineScheduler.l(worker, andDecrement, indexInArray2);
                            }
                            coroutineScheduler.g.set(andDecrement, null);
                            ur2 ur2 = ur2.INSTANCE;
                            this.state = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        @Nullable
        public final Task findTask(boolean z) {
            Task task;
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            if (z) {
                task = this.localQueue.h();
                if (task == null) {
                    task = (Task) CoroutineScheduler.this.f.d();
                }
            } else {
                task = (Task) CoroutineScheduler.this.f.d();
            }
            return task == null ? trySteal(true) : task;
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public void run() {
            runWorker();
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.d);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public Worker(int i) {
            this();
            setIndexInArray(i);
        }
    }
}
