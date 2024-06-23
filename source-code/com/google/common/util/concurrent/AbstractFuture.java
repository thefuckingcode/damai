package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;
import tb.ds1;
import tb.jl1;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
/* compiled from: Taobao */
public abstract class AbstractFuture<V> extends com.google.common.util.concurrent.internal.a implements ListenableFuture<V> {
    private static final b ATOMIC_HELPER;
    private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
    @NullableDecl
    private volatile d listeners;
    @NullableDecl
    private volatile Object value;
    @NullableDecl
    private volatile i waiters;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class Failure {
        static final Failure b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            /* class com.google.common.util.concurrent.AbstractFuture.Failure.AnonymousClass1 */

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable a;

        Failure(Throwable th) {
            this.a = (Throwable) ds1.p(th);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        public void run() {
            if (((AbstractFuture) this.owner).value == this) {
                if (AbstractFuture.ATOMIC_HELPER.b(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                    AbstractFuture.complete(this.owner);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Trusted<V> extends ListenableFuture<V> {
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void d(i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void e(i iVar, Thread thread);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c {
        static final c c;
        static final c d;
        final boolean a;
        @NullableDecl
        final Throwable b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                d = null;
                c = null;
                return;
            }
            d = new c(false, null);
            c = new c(true, null);
        }

        c(boolean z, @NullableDecl Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class d {
        static final d d = new d(null, null);
        final Runnable a;
        final Executor b;
        @NullableDecl
        d c;

        d(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    /* compiled from: Taobao */
    private static final class e extends b {
        final AtomicReferenceFieldUpdater<i, Thread> a;
        final AtomicReferenceFieldUpdater<i, i> b;
        final AtomicReferenceFieldUpdater<AbstractFuture, i> c;
        final AtomicReferenceFieldUpdater<AbstractFuture, d> d;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;

        e(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return this.d.compareAndSet(abstractFuture, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.e.compareAndSet(abstractFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            return this.c.compareAndSet(abstractFuture, iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    /* compiled from: Taobao */
    private static final class f extends b {
        private f() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).listeners != dVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).listeners = dVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).value != obj) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).value = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).waiters != iVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).waiters = iVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class g<V> extends AbstractFuture<V> implements Trusted<V> {
        g() {
        }

        @Override // com.google.common.util.concurrent.ListenableFuture, com.google.common.util.concurrent.AbstractFuture
        public final void addListener(Runnable runnable, Executor executor) {
            AbstractFuture.super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return AbstractFuture.super.cancel(z);
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) AbstractFuture.super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) AbstractFuture.super.get(j, timeUnit);
        }
    }

    /* compiled from: Taobao */
    private static final class h extends b {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        /* compiled from: Taobao */
        static class a implements PrivilegedExceptionAction<Unsafe> {
            a() {
            }

            /* renamed from: a */
            public Unsafe run() throws Exception {
                Field[] declaredFields = Unsafe.class.getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            Unsafe unsafe = Unsafe.getUnsafe();
            try {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
                try {
                    c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                    b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                    d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
                    e = unsafe.objectFieldOffset(i.class.getDeclaredField("a"));
                    f = unsafe.objectFieldOffset(i.class.getDeclaredField("b"));
                    a = unsafe;
                } catch (Exception e2) {
                    com.google.common.base.i.f(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        private h() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return a.compareAndSwapObject(abstractFuture, b, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.compareAndSwapObject(abstractFuture, d, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, i iVar, i iVar2) {
            return a.compareAndSwapObject(abstractFuture, c, iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(i iVar, i iVar2) {
            a.putObject(iVar, f, iVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(i iVar, Thread thread) {
            a.putObject(iVar, e, thread);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class i {
        static final i c = new i(false);
        @NullableDecl
        volatile Thread a;
        @NullableDecl
        volatile i b;

        i(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar) {
            AbstractFuture.ATOMIC_HELPER.d(this, iVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            AbstractFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    static {
        b bVar;
        Throwable th;
        Throwable th2 = null;
        try {
            bVar = new h();
            th = null;
        } catch (Throwable th3) {
            bVar = new f();
            th2 = th3;
        }
        ATOMIC_HELPER = bVar;
        if (th2 != null) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
    }

    protected AbstractFuture() {
    }

    private void addDoneString(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(userObjectToString(uninterruptibly));
            sb.append(jl1.ARRAY_END_STR);
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(jl1.ARRAY_END_STR);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(@NullableDecl String str, @NullableDecl Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private d clearListeners(d dVar) {
        d dVar2;
        do {
            dVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, dVar2, d.d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.c;
            dVar4.c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.common.util.concurrent.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.util.concurrent.AbstractFuture$b] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void complete(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            d clearListeners = abstractFuture.clearListeners(dVar);
            while (true) {
                if (clearListeners != null) {
                    dVar = clearListeners.c;
                    Runnable runnable = clearListeners.a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.owner;
                        if (((AbstractFuture) abstractFuture).value == setFuture) {
                            if (ATOMIC_HELPER.b(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.b);
                    }
                    clearListeners = dVar;
                } else {
                    return;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        Throwable a2;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.a) {
                return cVar.b != null ? new c(false, cVar.b) : c.d;
            }
            return obj;
        } else if ((listenableFuture instanceof com.google.common.util.concurrent.internal.a) && (a2 = com.google.common.util.concurrent.internal.b.a((com.google.common.util.concurrent.internal.a) listenableFuture)) != null) {
            return new Failure(a2);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                return c.d;
            }
            try {
                Object uninterruptibly = getUninterruptibly(listenableFuture);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
            } catch (ExecutionException e2) {
                if (!isCancelled) {
                    return new Failure(e2.getCause());
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e2));
            } catch (CancellationException e3) {
                if (isCancelled) {
                    return new c(false, e3);
                }
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
            } catch (Throwable th) {
                return new Failure(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void releaseWaiters() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.b;
        }
    }

    private void removeWaiter(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 != i.c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.b;
                    if (iVar2.a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.b = iVar4;
                        if (iVar3.a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        ds1.q(runnable, "Runnable was null.");
        ds1.q(executor, "Executor was null.");
        if (isDone() || (dVar = this.listeners) == d.d) {
            executeListener(runnable, executor);
        }
        d dVar2 = new d(runnable, executor);
        do {
            dVar2.c = dVar;
            if (!ATOMIC_HELPER.a(this, dVar, dVar2)) {
                dVar = this.listeners;
            } else {
                return;
            }
        } while (dVar != d.d);
        executeListener(runnable, executor);
    }

    /* access modifiers changed from: protected */
    @Beta
    @ForOverride
    public void afterDone() {
    }

    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        c cVar = GENERATE_CANCELLATION_CAUSES ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d;
        boolean z2 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
                if (listenableFuture instanceof Trusted) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj = abstractFuture.value;
                    if (!(obj == null) && !(obj instanceof SetFuture)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.waiters;
                if (iVar != i.c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(iVar2);
                        } else {
                            iVar = this.waiters;
                        }
                    } while (iVar != i.c);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof c;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + jl1.ARRAY_END_STR;
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, v)) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, null, new Failure((Throwable) ds1.p(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        ds1.p(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.b;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).a);
        }
        return false;
        ATOMIC_HELPER.b(this, setFuture, failure);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append(jl1.ARRAY_END_STR);
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.internal.a
    @NullableDecl
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).a;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).a;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            i iVar = this.waiters;
            if (iVar != i.c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    iVar = this.waiters;
                } while (iVar != i.c);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
