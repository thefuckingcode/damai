package tb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.scheduling.Task;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qz2 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(qz2.class, Object.class, "lastScheduledTask");
    private static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(qz2.class, "producerIndex");
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(qz2.class, "consumerIndex");
    private static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(qz2.class, "blockingTasksInBuffer");
    @NotNull
    private final AtomicReferenceArray<Task> a = new AtomicReferenceArray<>(128);
    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;
    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;
    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    public static /* synthetic */ Task b(qz2 qz2, Task task, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return qz2.a(task, z);
    }

    private final Task c(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            e.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    private final void d(Task task) {
        if (task != null) {
            boolean z = false;
            if (task.taskContext.getTaskMode() == 1) {
                int decrementAndGet = e.decrementAndGet(this);
                if (n30.a()) {
                    if (decrementAndGet >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final Task i() {
        Task andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.a.getAndSet(i2, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(us0 us0) {
        Task i = i();
        if (i == null) {
            return false;
        }
        us0.a(i);
        return true;
    }

    private final long m(qz2 qz2, boolean z) {
        Task task;
        do {
            task = (Task) qz2.lastScheduledTask;
            if (task == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            long a2 = lj2.a.a() - task.submissionTime;
            long j = lj2.WORK_STEALING_TIME_RESOLUTION_NS;
            if (a2 < j) {
                return j - a2;
            }
        } while (!b.compareAndSet(qz2, task, null));
        b(this, task, false, 2, null);
        return -1;
    }

    @Nullable
    public final Task a(@NotNull Task task, boolean z) {
        if (z) {
            return c(task);
        }
        Task task2 = (Task) b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return c(task2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull us0 us0) {
        Task task = (Task) b.getAndSet(this, null);
        if (task != null) {
            us0.a(task);
        }
        do {
        } while (j(us0));
    }

    @Nullable
    public final Task h() {
        Task task = (Task) b.getAndSet(this, null);
        return task == null ? i() : task;
    }

    public final long k(@NotNull qz2 qz2) {
        if (n30.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i = qz2.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = qz2.a;
        for (int i2 = qz2.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (qz2.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i3);
            if (task != null) {
                if ((task.taskContext.getTaskMode() == 1) && atomicReferenceArray.compareAndSet(i3, task, null)) {
                    e.decrementAndGet(qz2);
                    b(this, task, false, 2, null);
                    return -1;
                }
            }
        }
        return m(qz2, true);
    }

    public final long l(@NotNull qz2 qz2) {
        boolean z = true;
        if (n30.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        Task i = qz2.i();
        if (i == null) {
            return m(qz2, false);
        }
        Task b2 = b(this, i, false, 2, null);
        if (!n30.a()) {
            return -1;
        }
        if (b2 != null) {
            z = false;
        }
        if (z) {
            return -1;
        }
        throw new AssertionError();
    }
}
