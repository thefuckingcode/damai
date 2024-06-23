package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* access modifiers changed from: package-private */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class d {
    private static final b ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(d.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(d dVar, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int b(d dVar);
    }

    /* compiled from: Taobao */
    private static final class c extends b {
        final AtomicReferenceFieldUpdater<d, Set<Throwable>> a;
        final AtomicIntegerFieldUpdater<d> b;

        c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.d.b
        public void a(d dVar, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(dVar, set, set2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.d.b
        public int b(d dVar) {
            return this.b.decrementAndGet(dVar);
        }
    }

    /* renamed from: com.google.common.util.concurrent.d$d  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static final class C0172d extends b {
        private C0172d() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.d.b
        public void a(d dVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (dVar) {
                if (dVar.seenExceptions == set) {
                    dVar.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.d.b
        public int b(d dVar) {
            int i;
            synchronized (dVar) {
                d.access$310(dVar);
                i = dVar.remaining;
            }
            return i;
        }
    }

    static {
        b bVar;
        Throwable th = null;
        try {
            bVar = new c(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(d.class, "remaining"));
        } catch (Throwable th2) {
            bVar = new C0172d();
            th = th2;
        }
        ATOMIC_HELPER = bVar;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    d(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int access$310(d dVar) {
        int i = dVar.remaining;
        dVar.remaining = i - 1;
        return i;
    }

    /* access modifiers changed from: package-private */
    public abstract void addInitialException(Set<Throwable> set);

    /* access modifiers changed from: package-private */
    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.b(this);
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> c2 = Sets.c();
        addInitialException(c2);
        ATOMIC_HELPER.a(this, null, c2);
        return this.seenExceptions;
    }
}
