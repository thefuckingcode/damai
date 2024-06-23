package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c82;
import tb.d82;
import tb.k21;
import tb.kf;
import tb.n30;
import tb.p30;
import tb.sl;
import tb.tl;
import tb.ur2;

/* compiled from: Taobao */
final class c implements Semaphore {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "head");
    private static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(c.class, "deqIdx");
    private static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "tail");
    private static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(c.class, "enqIdx");
    static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(c.class, "_availablePermits");
    @NotNull
    volatile /* synthetic */ int _availablePermits;
    private final int a;
    @NotNull
    private final Function1<Throwable, ur2> b;
    @NotNull
    private volatile /* synthetic */ long deqIdx;
    @NotNull
    private volatile /* synthetic */ long enqIdx;
    @NotNull
    private volatile /* synthetic */ Object head;
    @NotNull
    private volatile /* synthetic */ Object tail;

    private final Object c(Continuation<? super ur2> continuation) {
        CancellableContinuationImpl b2 = kf.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        while (true) {
            if (!d(b2)) {
                if (g.getAndDecrement(this) > 0) {
                    b2.resume(ur2.INSTANCE, this.b);
                    break;
                }
            } else {
                break;
            }
        }
        Object result = b2.getResult();
        if (result == b.d()) {
            p30.c(continuation);
        }
        return result == b.d() ? result : ur2.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0074, code lost:
        continue;
     */
    private final boolean d(CancellableContinuation<? super ur2> cancellableContinuation) {
        Object obj;
        boolean z;
        boolean z2;
        c82 c82 = (d) this.tail;
        long andIncrement = f.getAndIncrement(this);
        long j = andIncrement / ((long) SemaphoreKt.f);
        do {
            c82 c822 = c82;
            while (true) {
                if (c822.m() >= j && !c822.g()) {
                    obj = d82.a(c822);
                    break;
                }
                Object a2 = tl.a(c822);
                if (a2 == sl.a()) {
                    obj = d82.a(sl.a());
                    break;
                }
                c82 c823 = (c82) ((tl) a2);
                if (c823 == null) {
                    c823 = SemaphoreKt.h(c822.m() + 1, (d) c822);
                    if (c822.k(c823)) {
                        if (c822.g()) {
                            c822.j();
                        }
                    }
                }
                c822 = c823;
            }
            z = true;
            if (d82.c(obj)) {
                break;
            }
            c82 b2 = d82.b(obj);
            while (true) {
                c82 c824 = (c82) this.tail;
                if (c824.m() >= b2.m()) {
                    break;
                } else if (!b2.p()) {
                    z2 = false;
                    continue;
                    break;
                } else if (e.compareAndSet(this, c824, b2)) {
                    if (c824.l()) {
                        c824.j();
                    }
                } else if (b2.l()) {
                    b2.j();
                }
            }
        } while (!z2);
        d dVar = (d) d82.b(obj);
        int i = (int) (andIncrement % ((long) SemaphoreKt.f));
        if (dVar.e.compareAndSet(i, null, cancellableContinuation)) {
            cancellableContinuation.invokeOnCancellation(new a(dVar, i));
            return true;
        }
        if (dVar.e.compareAndSet(i, SemaphoreKt.b, SemaphoreKt.c)) {
            cancellableContinuation.resume(ur2.INSTANCE, this.b);
            return true;
        }
        if (n30.a()) {
            if (dVar.e.get(i) != SemaphoreKt.d) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return false;
    }

    private final boolean e(CancellableContinuation<? super ur2> cancellableContinuation) {
        Object tryResume = cancellableContinuation.tryResume(ur2.INSTANCE, null, this.b);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0070, code lost:
        continue;
     */
    private final boolean f() {
        Object obj;
        int i;
        boolean z;
        c82 c82 = (d) this.head;
        long andIncrement = d.getAndIncrement(this);
        long j = andIncrement / ((long) SemaphoreKt.f);
        do {
            c82 c822 = c82;
            while (true) {
                if (c822.m() >= j && !c822.g()) {
                    obj = d82.a(c822);
                    break;
                }
                Object a2 = tl.a(c822);
                if (a2 == sl.a()) {
                    obj = d82.a(sl.a());
                    break;
                }
                c82 c823 = (c82) ((tl) a2);
                if (c823 == null) {
                    c823 = SemaphoreKt.h(c822.m() + 1, (d) c822);
                    if (c822.k(c823)) {
                        if (c822.g()) {
                            c822.j();
                        }
                    }
                }
                c822 = c823;
            }
            if (d82.c(obj)) {
                break;
            }
            c82 b2 = d82.b(obj);
            while (true) {
                c82 c824 = (c82) this.head;
                if (c824.m() >= b2.m()) {
                    break;
                } else if (!b2.p()) {
                    z = false;
                    continue;
                    break;
                } else if (c.compareAndSet(this, c824, b2)) {
                    if (c824.l()) {
                        c824.j();
                    }
                } else if (b2.l()) {
                    b2.j();
                }
            }
        } while (!z);
        d dVar = (d) d82.b(obj);
        dVar.b();
        if (dVar.m() > j) {
            return false;
        }
        int i2 = (int) (andIncrement % ((long) SemaphoreKt.f));
        Object andSet = dVar.e.getAndSet(i2, SemaphoreKt.b);
        if (andSet == null) {
            int i3 = SemaphoreKt.a;
            for (i = 0; i < i3; i++) {
                if (dVar.e.get(i2) == SemaphoreKt.c) {
                    return true;
                }
            }
            return !dVar.e.compareAndSet(i2, SemaphoreKt.b, SemaphoreKt.d);
        } else if (andSet == SemaphoreKt.e) {
            return false;
        } else {
            return e((CancellableContinuation) andSet);
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    @Nullable
    public Object acquire(@NotNull Continuation<? super ur2> continuation) {
        if (g.getAndDecrement(this) > 0) {
            return ur2.INSTANCE;
        }
        Object c2 = c(continuation);
        return c2 == b.d() ? c2 : ur2.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        while (true) {
            int i = this._availablePermits;
            int i2 = this.a;
            if (i < i2) {
                if (g.compareAndSet(this, i, i + 1) && (i >= 0 || f())) {
                    return;
                }
            } else {
                throw new IllegalStateException(k21.r("The number of released permits cannot be greater than ", Integer.valueOf(i2)).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!g.compareAndSet(this, i, i - 1));
        return true;
    }
}
