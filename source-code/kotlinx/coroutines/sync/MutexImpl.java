package kotlinx.coroutines.sync;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.b;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cl1;
import tb.e82;
import tb.h8;
import tb.i8;
import tb.j8;
import tb.jl1;
import tb.k21;
import tb.kf;
import tb.lf;
import tb.n30;
import tb.p30;
import tb.pr2;
import tb.q81;
import tb.ur2;

/* compiled from: Taobao */
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    @NotNull
    volatile /* synthetic */ Object _state;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class LockCont extends a {
        @JvmField
        @NotNull
        public final CancellableContinuation<ur2> e;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super tb.ur2> */
        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(@Nullable Object obj, @NotNull CancellableContinuation<? super ur2> cancellableContinuation) {
            super(MutexImpl.this, obj);
            this.e = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "LockCont[" + this.d + AVFSCacheConstants.COMMA_SEP + this.e + "] for " + MutexImpl.this;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void u(@NotNull Object obj) {
            this.e.completeResume(obj);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        @Nullable
        public Object v() {
            return this.e.tryResume(ur2.INSTANCE, null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, this));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class LockSelect<R> extends a {
        @JvmField
        @NotNull
        public final SelectInstance<R> e;
        @JvmField
        @NotNull
        public final Function2<Mutex, Continuation<? super R>, Object> f;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.sync.Mutex, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(MutexImpl.this, obj);
            this.e = selectInstance;
            this.f = function2;
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "LockSelect[" + this.d + AVFSCacheConstants.COMMA_SEP + this.e + "] for " + MutexImpl.this;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void u(@NotNull Object obj) {
            if (n30.a()) {
                if (!(obj == MutexKt.c)) {
                    throw new AssertionError();
                }
            }
            lf.c(this.f, MutexImpl.this, this.e.getCompletion(), new MutexImpl$LockSelect$completeResumeLockWaiter$2(MutexImpl.this, this));
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        @Nullable
        public Object v() {
            if (this.e.trySelect()) {
                return MutexKt.c;
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public abstract class a extends kotlinx.coroutines.internal.b implements DisposableHandle {
        @JvmField
        @Nullable
        public final Object d;

        public a(@Nullable MutexImpl mutexImpl, Object obj) {
            this.d = obj;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            p();
        }

        public abstract void u(@NotNull Object obj);

        @Nullable
        public abstract Object v();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b extends q81 {
        @JvmField
        @NotNull
        public Object d;

        public b(@NotNull Object obj) {
            this.d = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.d + jl1.ARRAY_END;
        }
    }

    /* compiled from: Taobao */
    private static final class c extends h8 {
        @JvmField
        @NotNull
        public final MutexImpl b;
        @JvmField
        @Nullable
        public final Object c;

        /* compiled from: Taobao */
        private final class a extends cl1 {
            @NotNull
            private final j8<?> a;

            public a(@NotNull c cVar, j8<?> j8Var) {
                this.a = j8Var;
            }

            @Override // tb.cl1
            @NotNull
            public j8<?> a() {
                return this.a;
            }

            @Override // tb.cl1
            @Nullable
            public Object c(@Nullable Object obj) {
                Object a2 = a().h() ? MutexKt.g : a();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
                MutexImpl.a.compareAndSet((MutexImpl) obj, this, a2);
                return null;
            }
        }

        public c(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            this.b = mutexImpl;
            this.c = obj;
        }

        @Override // tb.h8
        public void a(@NotNull j8<?> j8Var, @Nullable Object obj) {
            b bVar;
            if (obj != null) {
                bVar = MutexKt.g;
            } else {
                Object obj2 = this.c;
                bVar = obj2 == null ? MutexKt.f : new b(obj2);
            }
            MutexImpl.a.compareAndSet(this.b, j8Var, bVar);
        }

        @Override // tb.h8
        @Nullable
        public Object c(@NotNull j8<?> j8Var) {
            a aVar = new a(this, j8Var);
            if (!MutexImpl.a.compareAndSet(this.b, MutexKt.g, aVar)) {
                return MutexKt.a;
            }
            return aVar.c(this.b);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class d extends j8<MutexImpl> {
        @JvmField
        @NotNull
        public final b b;

        public d(@NotNull b bVar) {
            this.b = bVar;
        }

        /* renamed from: j */
        public void d(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            MutexImpl.a.compareAndSet(mutexImpl, this, obj == null ? MutexKt.g : this.b);
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull MutexImpl mutexImpl) {
            if (this.b.u()) {
                return null;
            }
            return MutexKt.b;
        }
    }

    /* compiled from: Taobao */
    public static final class e extends b.c {
        final /* synthetic */ MutexImpl d;
        final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(kotlinx.coroutines.internal.b bVar, MutexImpl mutexImpl, Object obj) {
            super(bVar);
            this.d = mutexImpl;
            this.e = obj;
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (this.d._state == this.e) {
                return null;
            }
            return kotlinx.coroutines.internal.a.a();
        }
    }

    /* compiled from: Taobao */
    public static final class f extends b.c {
        final /* synthetic */ MutexImpl d;
        final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kotlinx.coroutines.internal.b bVar, MutexImpl mutexImpl, Object obj) {
            super(bVar);
            this.d = mutexImpl;
            this.e = obj;
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (this.d._state == this.e) {
                return null;
            }
            return kotlinx.coroutines.internal.a.a();
        }
    }

    private final Object a(Object obj, Continuation<? super ur2> continuation) {
        CancellableContinuationImpl b2 = kf.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        LockCont lockCont = new LockCont(obj, b2);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof b) {
                b bVar = (b) obj2;
                if (bVar.a != MutexKt.e) {
                    a.compareAndSet(this, obj2, new b(bVar.a));
                } else {
                    if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f : new b(obj))) {
                        b2.resume(ur2.INSTANCE, new MutexImpl$lockSuspend$2$1$1(this, obj));
                        break;
                    }
                }
            } else if (obj2 instanceof b) {
                boolean z = false;
                if (((b) obj2).d != obj) {
                    kotlinx.coroutines.internal.b bVar2 = (kotlinx.coroutines.internal.b) obj2;
                    e eVar = new e(lockCont, this, obj2);
                    while (true) {
                        int t = bVar2.l().t(lockCont, bVar2, eVar);
                        if (t != 1) {
                            if (t == 2) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        kf.c(b2, lockCont);
                        break;
                    }
                } else {
                    throw new IllegalStateException(k21.r("Already locked by ", obj).toString());
                }
            } else if (obj2 instanceof cl1) {
                ((cl1) obj2).c(this);
            } else {
                throw new IllegalStateException(k21.r("Illegal state ", obj2).toString());
            }
        }
        Object result = b2.getResult();
        if (result == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.b.d() ? result : ur2.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @NotNull
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(@NotNull Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof b) {
            if (((b) obj2).a == obj) {
                return true;
            }
        } else if (!(obj2 instanceof b) || ((b) obj2).d != obj) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                return ((b) obj).a != MutexKt.e;
            }
            if (obj instanceof b) {
                return true;
            }
            if (obj instanceof cl1) {
                ((cl1) obj).c(this);
            } else {
                throw new IllegalStateException(k21.r("Illegal state ", obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super ur2> continuation) {
        if (tryLock(obj)) {
            return ur2.INSTANCE;
        }
        Object a2 = a(obj, continuation);
        return a2 == kotlin.coroutines.intrinsics.b.d() ? a2 : ur2.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, @Nullable Object obj, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            Object obj2 = this._state;
            if (obj2 instanceof b) {
                b bVar = (b) obj2;
                if (bVar.a != MutexKt.e) {
                    a.compareAndSet(this, obj2, new b(bVar.a));
                } else {
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(new c(this, obj));
                    if (performAtomicTrySelect == null) {
                        pr2.d(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (performAtomicTrySelect != e82.d()) {
                        if (!(performAtomicTrySelect == MutexKt.a || performAtomicTrySelect == i8.RETRY_ATOMIC)) {
                            throw new IllegalStateException(k21.r("performAtomicTrySelect(TryLockDesc) returned ", performAtomicTrySelect).toString());
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj2 instanceof b) {
                boolean z = false;
                if (((b) obj2).d != obj) {
                    LockSelect lockSelect = new LockSelect(obj, selectInstance, function2);
                    kotlinx.coroutines.internal.b bVar2 = (kotlinx.coroutines.internal.b) obj2;
                    f fVar = new f(lockSelect, this, obj2);
                    while (true) {
                        int t = bVar2.l().t(lockSelect, bVar2, fVar);
                        if (t != 1) {
                            if (t == 2) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        selectInstance.disposeOnSelect(lockSelect);
                        return;
                    }
                } else {
                    throw new IllegalStateException(k21.r("Already locked by ", obj).toString());
                }
            } else if (obj2 instanceof cl1) {
                ((cl1) obj2).c(this);
            } else {
                throw new IllegalStateException(k21.r("Illegal state ", obj2).toString());
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                return "Mutex[" + ((b) obj).a + jl1.ARRAY_END;
            } else if (obj instanceof cl1) {
                ((cl1) obj).c(this);
            } else if (obj instanceof b) {
                return "Mutex[" + ((b) obj).d + jl1.ARRAY_END;
            } else {
                throw new IllegalStateException(k21.r("Illegal state ", obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof b) {
                if (((b) obj2).a != MutexKt.e) {
                    return false;
                }
                if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f : new b(obj))) {
                    return true;
                }
            } else if (obj2 instanceof b) {
                if (((b) obj2).d == obj) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                throw new IllegalStateException(k21.r("Already locked by ", obj).toString());
            } else if (obj2 instanceof cl1) {
                ((cl1) obj2).c(this);
            } else {
                throw new IllegalStateException(k21.r("Illegal state ", obj2).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof b) {
                if (obj == null) {
                    if (((b) obj2).a == MutexKt.e) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    b bVar = (b) obj2;
                    if (bVar.a != obj) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar.a + " but expected " + obj).toString());
                    }
                }
                if (a.compareAndSet(this, obj2, MutexKt.g)) {
                    return;
                }
            } else if (obj2 instanceof cl1) {
                ((cl1) obj2).c(this);
            } else if (obj2 instanceof b) {
                if (obj != null) {
                    b bVar2 = (b) obj2;
                    if (bVar2.d != obj) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.d + " but expected " + obj).toString());
                    }
                }
                b bVar3 = (b) obj2;
                kotlinx.coroutines.internal.b q = bVar3.q();
                if (q == null) {
                    d dVar = new d(bVar3);
                    if (a.compareAndSet(this, obj2, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    a aVar = (a) q;
                    Object v = aVar.v();
                    if (v != null) {
                        Object obj3 = aVar.d;
                        if (obj3 == null) {
                            obj3 = MutexKt.d;
                        }
                        bVar3.d = obj3;
                        aVar.u(v);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(k21.r("Illegal state ", obj2).toString());
            }
        }
    }
}
