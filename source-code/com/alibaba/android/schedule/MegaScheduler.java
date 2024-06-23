package com.alibaba.android.schedule;

import com.taobao.orange.OConstant;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;
import tb.sg1;
import tb.ur2;

/* compiled from: Taobao */
public final class MegaScheduler {
    @NotNull
    public static final a Companion = new a(null);
    private static ExecutorService f;
    private static DelayHandler g;
    private final AtomicInteger a = new AtomicInteger();
    private final LinkedList<b> b = new LinkedList<>();
    private int c;
    private final String d;
    private final int e;

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/alibaba/android/schedule/MegaScheduler$DelayHandler;", "Ljava/lang/Runnable;", "Lcom/alibaba/android/schedule/MegaScheduler$b;", "task", "Ltb/ur2;", "submit", "run", "Ljava/lang/Object;", OConstant.DIMEN_FILE_LOCK, "Ljava/lang/Object;", "Ljava/util/PriorityQueue;", "mDelayList", "Ljava/util/PriorityQueue;", "<init>", "()V", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Taobao */
    public static final class DelayHandler implements Runnable {
        private final Object lock = new Object();
        private final PriorityQueue<b> mDelayList = new PriorityQueue<>(10);

        public void run() {
            while (true) {
                b bVar = null;
                synchronized (this.lock) {
                    if (this.mDelayList.isEmpty()) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        long b = this.mDelayList.peek().b() - (System.nanoTime() / 1000000);
                        if (b > 0) {
                            this.lock.wait(b);
                        } else {
                            bVar = this.mDelayList.remove();
                        }
                    }
                    ur2 ur2 = ur2.INSTANCE;
                }
                if (bVar != null) {
                    MegaScheduler.i(bVar.c(), bVar.d(), 0, 2, null);
                }
            }
        }

        public final void submit(@NotNull b bVar) {
            k21.i(bVar, "task");
            synchronized (this.lock) {
                this.mDelayList.add(bVar);
                this.lock.notify();
                ur2 ur2 = ur2.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/android/schedule/MegaScheduler$TaskExecutor;", "Ljava/lang/Runnable;", "Ltb/ur2;", "run", "Lcom/alibaba/android/schedule/MegaScheduler;", "scheduler", "Lcom/alibaba/android/schedule/MegaScheduler;", "<init>", "(Lcom/alibaba/android/schedule/MegaScheduler;)V", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Taobao */
    public static final class TaskExecutor implements Runnable {
        private final MegaScheduler scheduler;

        public TaskExecutor(@NotNull MegaScheduler megaScheduler) {
            k21.i(megaScheduler, "scheduler");
            this.scheduler = megaScheduler;
        }

        public void run() {
            do {
            } while (this.scheduler.g(this.scheduler.a.incrementAndGet()));
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @JvmStatic
        private final DelayHandler c() {
            if (MegaScheduler.g == null) {
                a aVar = MegaScheduler.Companion;
                synchronized (aVar) {
                    MegaScheduler.g = new DelayHandler();
                    aVar.d().submit(MegaScheduler.g);
                }
            }
            DelayHandler delayHandler = MegaScheduler.g;
            k21.f(delayHandler);
            return delayHandler;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @JvmStatic
        private final ExecutorService d() {
            if (MegaScheduler.f == null) {
                synchronized (MegaScheduler.Companion) {
                    MegaScheduler.f = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 120, TimeUnit.SECONDS, new SynchronousQueue(), new sg1("mega-pool", 0, 2, null));
                    ur2 ur2 = ur2.INSTANCE;
                }
            }
            ExecutorService executorService = MegaScheduler.f;
            k21.f(executorService);
            return executorService;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b implements Comparable<b> {
        @NotNull
        private final MegaScheduler a;
        private final long b;
        @NotNull
        private final Runnable c;

        public b(@NotNull MegaScheduler megaScheduler, long j, @NotNull Runnable runnable) {
            k21.i(megaScheduler, "megaScheduler");
            k21.i(runnable, "runnable");
            this.a = megaScheduler;
            this.b = j;
            this.c = runnable;
        }

        /* renamed from: a */
        public int compareTo(@NotNull b bVar) {
            k21.i(bVar, "other");
            long j = this.b;
            long j2 = bVar.b;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }

        public final long b() {
            return this.b;
        }

        @NotNull
        public final MegaScheduler c() {
            return this.a;
        }

        @NotNull
        public final Runnable d() {
            return this.c;
        }
    }

    public MegaScheduler(@NotNull String str, int i) {
        k21.i(str, "name");
        this.d = str;
        this.e = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = java.lang.Thread.currentThread();
        r2 = r0.getName();
        r0.setName(r5.d + '-' + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.d().run();
     */
    private final boolean g(int i) {
        Thread currentThread;
        String name;
        synchronized (this.b) {
            if (this.b.isEmpty()) {
                this.c--;
                return false;
            }
            b removeFirst = this.b.removeFirst();
            k21.h(removeFirst, "taskQ.removeFirst()");
            b bVar = removeFirst;
            ur2 ur2 = ur2.INSTANCE;
        }
        currentThread.setName(name);
        return true;
    }

    public static /* synthetic */ void i(MegaScheduler megaScheduler, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        megaScheduler.h(runnable, j);
    }

    @JvmOverloads
    public final void h(@NotNull Runnable runnable, long j) {
        k21.i(runnable, "runnable");
        if (j > 0) {
            Companion.c().submit(new b(this, (System.nanoTime() / 1000000) + j, runnable));
            return;
        }
        synchronized (this.b) {
            this.b.addLast(new b(this, 0, runnable));
            int i = this.e;
            int i2 = this.c;
            if (i2 >= 0) {
                if (i > i2) {
                    this.c = i2 + 1;
                    Companion.d().submit(new TaskExecutor(this));
                }
            }
            ur2 ur2 = ur2.INSTANCE;
        }
    }
}
