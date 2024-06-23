package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.taobao.orange.OConstant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public final class m {
    private final boolean a;
    private final ReentrantLock b;
    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private a c;

    @Beta
    /* compiled from: Taobao */
    public static abstract class a {
        @Weak
        final m a;
        final Condition b;
        @GuardedBy("monitor.lock")
        int c = 0;
        @NullableDecl
        @GuardedBy("monitor.lock")
        a d;

        protected a(m mVar) {
            this.a = (m) ds1.q(mVar, "monitor");
            this.b = mVar.b.newCondition();
        }

        public abstract boolean a();
    }

    public m() {
        this(false);
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private boolean b(a aVar, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        p();
                    } catch (Throwable th) {
                        if (!z2) {
                            e(aVar);
                        }
                        throw th;
                    }
                }
                d(aVar);
                z2 = false;
            }
            j = aVar.b.awaitNanos(j);
            if (aVar.a()) {
                if (!z2) {
                    e(aVar);
                }
                return true;
            }
        }
        if (!z2) {
            e(aVar);
        }
        return false;
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void c(a aVar, boolean z) {
        if (z) {
            p();
        }
        d(aVar);
        do {
            try {
                aVar.b.awaitUninterruptibly();
            } finally {
                e(aVar);
            }
        } while (!aVar.a());
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void d(a aVar) {
        int i = aVar.c;
        aVar.c = i + 1;
        if (i == 0) {
            aVar.d = this.c;
            this.c = aVar;
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void e(a aVar) {
        int i = aVar.c - 1;
        aVar.c = i;
        if (i == 0) {
            a aVar2 = this.c;
            a aVar3 = null;
            while (aVar2 != aVar) {
                aVar3 = aVar2;
                aVar2 = aVar2.d;
            }
            if (aVar3 == null) {
                this.c = aVar2.d;
            } else {
                aVar3.d = aVar2.d;
            }
            aVar2.d = null;
        }
    }

    private static long j(long j) {
        if (j <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private boolean l(a aVar) {
        try {
            return aVar.a();
        } catch (Throwable th) {
            o();
            throw th;
        }
    }

    private static long n(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return j2 - (System.nanoTime() - j);
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void o() {
        for (a aVar = this.c; aVar != null; aVar = aVar.d) {
            aVar.b.signalAll();
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void p() {
        for (a aVar = this.c; aVar != null; aVar = aVar.d) {
            if (l(aVar)) {
                aVar.b.signal();
                return;
            }
        }
    }

    private static long q(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (nanos <= 0) {
            return 0;
        }
        if (nanos > 6917529027641081853L) {
            return 6917529027641081853L;
        }
        return nanos;
    }

    public void f() {
        this.b.lock();
    }

    public boolean g(a aVar) {
        if (aVar.a == this) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                boolean a2 = aVar.a();
                if (!a2) {
                }
                return a2;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void h(a aVar) {
        if (aVar.a == this) {
            ReentrantLock reentrantLock = this.b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!aVar.a()) {
                    c(aVar, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                m();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|37|38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0070, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0071, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0076, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0076  */
    public boolean i(a aVar, long j, TimeUnit timeUnit) {
        long j2;
        long j3;
        long q = q(j, timeUnit);
        if (aVar.a == this) {
            ReentrantLock reentrantLock = this.b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean interrupted = Thread.interrupted();
            boolean z = true;
            try {
                if (!this.a) {
                    if (reentrantLock.tryLock()) {
                        j2 = 0;
                        while (true) {
                            try {
                                break;
                            } catch (InterruptedException unused) {
                                isHeldByCurrentThread = false;
                                interrupted = true;
                            } catch (Throwable th) {
                                reentrantLock.unlock();
                                throw th;
                            }
                        }
                        if (aVar.a()) {
                            if (j2 == 0) {
                                j(q);
                                j3 = q;
                            } else {
                                j3 = n(j2, q);
                            }
                            z = b(aVar, j3, isHeldByCurrentThread);
                        }
                        if (!z) {
                            reentrantLock.unlock();
                        }
                        if (interrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return z;
                    }
                }
                j2 = j(q);
                long j4 = q;
                while (true) {
                    j4 = n(j2, q);
                    interrupted = true;
                }
                if (!reentrantLock.tryLock(j4, TimeUnit.NANOSECONDS)) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                while (true) {
                    break;
                    break;
                }
                if (aVar.a()) {
                }
                if (!z) {
                }
                if (interrupted) {
                }
                return z;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                if (interrupted) {
                }
                throw th3;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean k() {
        return this.b.isHeldByCurrentThread();
    }

    public void m() {
        ReentrantLock reentrantLock = this.b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                p();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public m(boolean z) {
        this.c = null;
        this.a = z;
        this.b = new ReentrantLock(z);
    }
}
