package kotlinx.coroutines.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cl1;
import tb.h8;
import tb.i8;
import tb.j8;
import tb.k21;
import tb.n30;
import tb.r81;

@InternalCoroutinesApi
/* compiled from: Taobao */
public class b {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev");
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_removedRef");
    @NotNull
    volatile /* synthetic */ Object _next = this;
    @NotNull
    volatile /* synthetic */ Object _prev = this;
    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: Taobao */
    public static abstract class a extends h8 {
        @Override // tb.h8
        public final void a(@NotNull j8<?> j8Var, @Nullable Object obj) {
            boolean z = obj == null;
            b h = h();
            if (h != null) {
                b i = i();
                if (i != null) {
                    if (b.a.compareAndSet(h, j8Var, z ? n(h, i) : i) && z) {
                        f(h, i);
                    }
                } else if (n30.a() && !(!z)) {
                    throw new AssertionError();
                }
            } else if (n30.a() && !(!z)) {
                throw new AssertionError();
            }
        }

        @Override // tb.h8
        @Nullable
        public final Object c(@NotNull j8<?> j8Var) {
            while (true) {
                b m = m(j8Var);
                if (m == null) {
                    return i8.RETRY_ATOMIC;
                }
                Object obj = m._next;
                if (obj == j8Var || j8Var.h()) {
                    return null;
                }
                if (obj instanceof cl1) {
                    cl1 cl1 = (cl1) obj;
                    if (j8Var.b(cl1)) {
                        return i8.RETRY_ATOMIC;
                    }
                    cl1.c(m);
                } else {
                    Object e = e(m);
                    if (e != null) {
                        return e;
                    }
                    if (l(m, obj)) {
                        continue;
                    } else {
                        d dVar = new d(m, (b) obj, this);
                        if (b.a.compareAndSet(m, obj, dVar)) {
                            try {
                                Object c = dVar.c(m);
                                if (c != r81.REMOVE_PREPARED) {
                                    if (n30.a()) {
                                        if (!(c == null)) {
                                            throw new AssertionError();
                                        }
                                    }
                                    return null;
                                }
                            } catch (Throwable th) {
                                b.a.compareAndSet(m, dVar, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object e(@NotNull b bVar) {
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract void f(@NotNull b bVar, @NotNull b bVar2);

        public abstract void g(@NotNull d dVar);

        /* access modifiers changed from: protected */
        @Nullable
        public abstract b h();

        /* access modifiers changed from: protected */
        @Nullable
        public abstract b i();

        @Nullable
        public Object j(@NotNull d dVar) {
            g(dVar);
            return null;
        }

        public void k(@NotNull b bVar) {
        }

        /* access modifiers changed from: protected */
        public abstract boolean l(@NotNull b bVar, @NotNull Object obj);

        /* access modifiers changed from: protected */
        @Nullable
        public abstract b m(@NotNull cl1 cl1);

        @NotNull
        public abstract Object n(@NotNull b bVar, @NotNull b bVar2);
    }

    /* renamed from: kotlinx.coroutines.internal.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0290b<T extends b> extends a {
        private static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(C0290b.class, Object.class, "_affectedNode");
        @NotNull
        private volatile /* synthetic */ Object _affectedNode;
        @JvmField
        @NotNull
        public final b b;
        @JvmField
        @NotNull
        public final T c;

        public C0290b(@NotNull b bVar, @NotNull T t) {
            this.b = bVar;
            this.c = t;
            if (n30.a()) {
                if (!(t._next == t && t._prev == t)) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        public void f(@NotNull b bVar, @NotNull b bVar2) {
            this.c.i(this.b);
        }

        @Override // kotlinx.coroutines.internal.b.a
        public void g(@NotNull d dVar) {
            d.compareAndSet(this, null, dVar.a);
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public final b h() {
            return (b) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @NotNull
        public final b i() {
            return this.b;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        public boolean l(@NotNull b bVar, @NotNull Object obj) {
            return obj != this.b;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public final b m(@NotNull cl1 cl1) {
            return this.b.g(cl1);
        }

        @Override // kotlinx.coroutines.internal.b.a
        @NotNull
        public Object n(@NotNull b bVar, @NotNull b bVar2) {
            T t = this.c;
            b.b.compareAndSet(t, t, bVar);
            T t2 = this.c;
            b.a.compareAndSet(t2, t2, this.b);
            return this.c;
        }
    }

    @PublishedApi
    /* compiled from: Taobao */
    public static abstract class c extends j8<b> {
        @JvmField
        @NotNull
        public final b b;
        @JvmField
        @Nullable
        public b c;

        public c(@NotNull b bVar) {
            this.b = bVar;
        }

        /* renamed from: j */
        public void d(@NotNull b bVar, @Nullable Object obj) {
            boolean z = obj == null;
            b bVar2 = z ? this.b : this.c;
            if (bVar2 != null && b.a.compareAndSet(bVar, this, bVar2) && z) {
                b bVar3 = this.b;
                b bVar4 = this.c;
                k21.f(bVar4);
                bVar3.i(bVar4);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class d extends cl1 {
        @JvmField
        @NotNull
        public final b a;
        @JvmField
        @NotNull
        public final b b;
        @JvmField
        @NotNull
        public final a c;

        public d(@NotNull b bVar, @NotNull b bVar2, @NotNull a aVar) {
            this.a = bVar;
            this.b = bVar2;
            this.c = aVar;
        }

        @Override // tb.cl1
        @NotNull
        public j8<?> a() {
            return this.c.b();
        }

        @Override // tb.cl1
        @Nullable
        public Object c(@Nullable Object obj) {
            Object obj2;
            Object obj3;
            if (n30.a()) {
                if (!(obj == this.a)) {
                    throw new AssertionError();
                }
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            b bVar = (b) obj;
            Object j = this.c.j(this);
            Object obj4 = r81.REMOVE_PREPARED;
            if (j == obj4) {
                b bVar2 = this.b;
                if (b.a.compareAndSet(bVar, this, bVar2.s())) {
                    this.c.k(bVar);
                    bVar2.g(null);
                }
                return obj4;
            }
            if (j != null) {
                obj2 = a().e(j);
            } else {
                obj2 = a().f();
            }
            if (obj2 == i8.NO_DECISION) {
                obj3 = a();
            } else if (obj2 == null) {
                obj3 = this.c.n(bVar, this.b);
            } else {
                obj3 = this.b;
            }
            b.a.compareAndSet(bVar, this, obj3);
            return null;
        }

        public final void d() {
            this.c.g(this);
        }

        @Override // tb.cl1
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    /* compiled from: Taobao */
    public static class e<T> extends a {
        private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_affectedNode");
        private static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_originalNext");
        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;
        @NotNull
        private volatile /* synthetic */ Object _originalNext = null;
        @JvmField
        @NotNull
        public final b b;

        public e(@NotNull b bVar) {
            this.b = bVar;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public Object e(@NotNull b bVar) {
            if (bVar == this.b) {
                return a.b();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        public final void f(@NotNull b bVar, @NotNull b bVar2) {
            bVar2.g(null);
        }

        @Override // kotlinx.coroutines.internal.b.a
        public void g(@NotNull d dVar) {
            c.compareAndSet(this, null, dVar.a);
            d.compareAndSet(this, null, dVar.b);
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public final b h() {
            return (b) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public final b i() {
            return (b) this._originalNext;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        public final boolean l(@NotNull b bVar, @NotNull Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            ((c) obj).a.n();
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public final b m(@NotNull cl1 cl1) {
            b bVar = this.b;
            while (true) {
                Object obj = bVar._next;
                if (!(obj instanceof cl1)) {
                    return (b) obj;
                }
                cl1 cl12 = (cl1) obj;
                if (cl1.b(cl12)) {
                    return null;
                }
                cl12.c(this.b);
            }
        }

        @Override // kotlinx.coroutines.internal.b.a
        @NotNull
        public final Object n(@NotNull b bVar, @NotNull b bVar2) {
            return bVar2.s();
        }

        public final T o() {
            T t = (T) h();
            k21.f(t);
            return t;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (kotlinx.coroutines.internal.b.a.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.c) r4).a) != false) goto L_0x004b;
     */
    private final b g(cl1 cl1) {
        while (true) {
            b bVar = (b) this._prev;
            b bVar2 = bVar;
            while (true) {
                b bVar3 = null;
                while (true) {
                    Object obj = bVar2._next;
                    if (obj == this) {
                        if (bVar == bVar2 || b.compareAndSet(this, bVar, bVar2)) {
                            return bVar2;
                        }
                    } else if (o()) {
                        return null;
                    } else {
                        if (obj == cl1) {
                            return bVar2;
                        }
                        if (obj instanceof cl1) {
                            if (cl1 != null && cl1.b((cl1) obj)) {
                                return null;
                            }
                            ((cl1) obj).c(bVar2);
                        } else if (!(obj instanceof c)) {
                            bVar3 = bVar2;
                            bVar2 = (b) obj;
                        } else if (bVar3 != null) {
                            break;
                        } else {
                            bVar2 = (b) bVar2._prev;
                        }
                    }
                }
                bVar2 = bVar3;
            }
        }
    }

    private final b h(b bVar) {
        while (bVar.o()) {
            bVar = (b) bVar._prev;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void i(b bVar) {
        b bVar2;
        do {
            bVar2 = (b) bVar._prev;
            if (j() != bVar) {
                return;
            }
        } while (!b.compareAndSet(bVar, bVar2, this));
        if (o()) {
            bVar.g(null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final c s() {
        c cVar = (c) this._removedRef;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        c.lazySet(this, cVar2);
        return cVar2;
    }

    public final void d(@NotNull b bVar) {
        do {
        } while (!l().e(bVar, this));
    }

    @PublishedApi
    public final boolean e(@NotNull b bVar, @NotNull b bVar2) {
        b.lazySet(bVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(bVar, bVar2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, bVar2, bVar)) {
            return false;
        }
        bVar.i(bVar2);
        return true;
    }

    public final boolean f(@NotNull b bVar) {
        b.lazySet(bVar, this);
        a.lazySet(bVar, this);
        while (j() == this) {
            if (a.compareAndSet(this, this, bVar)) {
                bVar.i(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Object j() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof cl1)) {
                return obj;
            }
            ((cl1) obj).c(this);
        }
    }

    @NotNull
    public final b k() {
        return a.c(j());
    }

    @NotNull
    public final b l() {
        b g = g(null);
        return g == null ? h((b) this._prev) : g;
    }

    public final void m() {
        ((c) j()).a.g(null);
    }

    @PublishedApi
    public final void n() {
        b bVar = this;
        while (true) {
            Object j = bVar.j();
            if (!(j instanceof c)) {
                bVar.g(null);
                return;
            }
            bVar = ((c) j).a;
        }
    }

    public boolean o() {
        return j() instanceof c;
    }

    public boolean p() {
        return r() == null;
    }

    @Nullable
    public final b q() {
        while (true) {
            b bVar = (b) j();
            if (bVar == this) {
                return null;
            }
            if (bVar.p()) {
                return bVar;
            }
            bVar.m();
        }
    }

    @PublishedApi
    @Nullable
    public final b r() {
        Object j;
        b bVar;
        do {
            j = j();
            if (j instanceof c) {
                return ((c) j).a;
            }
            if (j == this) {
                return (b) j;
            }
            bVar = (b) j;
        } while (!a.compareAndSet(this, j, bVar.s()));
        bVar.g(null);
        return null;
    }

    @PublishedApi
    public final int t(@NotNull b bVar, @NotNull b bVar2, @NotNull c cVar) {
        b.lazySet(bVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(bVar, bVar2);
        cVar.c = bVar2;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, bVar2, cVar)) {
            return 0;
        }
        return cVar.c(this) == null ? 1 : 2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }
}
