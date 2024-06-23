package kotlinx.coroutines.selects;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.b;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cl1;
import tb.e82;
import tb.h41;
import tb.h8;
import tb.hl;
import tb.i8;
import tb.j8;
import tb.jf;
import tb.k12;
import tb.k21;
import tb.kl;
import tb.n30;
import tb.pr2;
import tb.q81;
import tb.sd2;
import tb.sn;
import tb.ur2;

@PublishedApi
/* compiled from: Taobao */
public final class SelectBuilderImpl<R> extends q81 implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    @NotNull
    private volatile /* synthetic */ Object _parentHandle = null;
    @NotNull
    volatile /* synthetic */ Object _result = e82.c;
    @NotNull
    volatile /* synthetic */ Object _state = e82.e();
    @NotNull
    private final Continuation<R> d;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a extends j8<Object> {
        @JvmField
        @NotNull
        public final SelectBuilderImpl<?> b;
        @JvmField
        @NotNull
        public final h8 c;
        private final long d = e82.e.a();

        public a(@NotNull SelectBuilderImpl<?> selectBuilderImpl, @NotNull h8 h8Var) {
            this.b = selectBuilderImpl;
            this.c = h8Var;
            h8Var.d(this);
        }

        private final void j(Object obj) {
            boolean z = obj == null;
            if (SelectBuilderImpl.e.compareAndSet(this.b, this, z ? null : e82.e()) && z) {
                this.b.w();
            }
        }

        private final Object k() {
            SelectBuilderImpl<?> selectBuilderImpl = this.b;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof cl1) {
                    ((cl1) obj).c(this.b);
                } else if (obj != e82.e()) {
                    return e82.d();
                } else {
                    if (SelectBuilderImpl.e.compareAndSet(this.b, e82.e(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void l() {
            SelectBuilderImpl.e.compareAndSet(this.b, this, e82.e());
        }

        @Override // tb.j8
        public void d(@Nullable Object obj, @Nullable Object obj2) {
            j(obj2);
            this.c.a(this, obj2);
        }

        @Override // tb.j8
        public long g() {
            return this.d;
        }

        @Override // tb.j8
        @Nullable
        public Object i(@Nullable Object obj) {
            Object k;
            if (obj == null && (k = k()) != null) {
                return k;
            }
            try {
                return this.c.c(this);
            } catch (Throwable th) {
                if (obj == null) {
                    l();
                }
                throw th;
            }
        }

        @Override // tb.cl1
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b extends kotlinx.coroutines.internal.b {
        @JvmField
        @NotNull
        public final DisposableHandle d;

        public b(@NotNull DisposableHandle disposableHandle) {
            this.d = disposableHandle;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c extends cl1 {
        @JvmField
        @NotNull
        public final b.d a;

        public c(@NotNull b.d dVar) {
            this.a = dVar;
        }

        @Override // tb.cl1
        @NotNull
        public j8<?> a() {
            return this.a.a();
        }

        @Override // tb.cl1
        @Nullable
        public Object c(@Nullable Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
            this.a.d();
            Object e = this.a.a().e(null);
            SelectBuilderImpl.e.compareAndSet(selectBuilderImpl, this, e == null ? this.a.c : e82.e());
            return e;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class d extends h41 {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
            u(th);
            return ur2.INSTANCE;
        }

        @Override // tb.jl
        public void u(@Nullable Throwable th) {
            if (SelectBuilderImpl.this.trySelect()) {
                SelectBuilderImpl.this.resumeSelectWithException(v().getCancellationException());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        this.d = continuation;
    }

    private final void A(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.Key);
        if (job != null) {
            DisposableHandle e2 = Job.a.e(job, true, false, new d(), 2, null);
            A(e2);
            if (isSelected()) {
                e2.dispose();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void w() {
        DisposableHandle x = x();
        if (x != null) {
            x.dispose();
        }
        for (kotlinx.coroutines.internal.b bVar = (kotlinx.coroutines.internal.b) j(); !k21.d(bVar, this); bVar = bVar.k()) {
            if (bVar instanceof b) {
                ((b) bVar).d.dispose();
            }
        }
    }

    private final DisposableHandle x() {
        return (DisposableHandle) this._parentHandle;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(@NotNull DisposableHandle disposableHandle) {
        b bVar = new b(disposableHandle);
        if (!isSelected()) {
            d(bVar);
            if (!isSelected()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public Continuation<R> getCompletion() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.d.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.a.a(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            Object obj = this._state;
            if (obj == e82.e()) {
                return false;
            }
            if (!(obj instanceof cl1)) {
                return true;
            }
            ((cl1) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j > 0) {
            disposeOnSelect(DelayKt.c(getContext()).invokeOnTimeout(j, new SelectBuilderImpl$onTimeout$$inlined$Runnable$1(this, function1), getContext()));
        } else if (trySelect()) {
            pr2.c(function1, getCompletion());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    public Object performAtomicTrySelect(@NotNull h8 h8Var) {
        return new a(this, h8Var).c(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(@NotNull Throwable th) {
        if (!n30.a() || isSelected()) {
            while (true) {
                Object obj = this._result;
                if (obj == e82.c) {
                    Continuation<R> continuation = this.d;
                    if (f.compareAndSet(this, e82.c, new hl((!n30.d() || !(continuation instanceof CoroutineStackFrame)) ? th : sd2.j(th, (CoroutineStackFrame) continuation), false, 2, null))) {
                        return;
                    }
                } else if (obj != kotlin.coroutines.intrinsics.b.d()) {
                    throw new IllegalStateException("Already resumed");
                } else if (f.compareAndSet(this, kotlin.coroutines.intrinsics.b.d(), e82.d)) {
                    Continuation continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(this.d);
                    Result.a aVar = Result.Companion;
                    continuation2.resumeWith(Result.m913constructorimpl(k12.a(th)));
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        if (!n30.a() || isSelected()) {
            while (true) {
                Object obj2 = this._result;
                if (obj2 == e82.c) {
                    if (f.compareAndSet(this, e82.c, kl.d(obj, null, 1, null))) {
                        return;
                    }
                } else if (obj2 != kotlin.coroutines.intrinsics.b.d()) {
                    throw new IllegalStateException("Already resumed");
                } else if (f.compareAndSet(this, kotlin.coroutines.intrinsics.b.d(), e82.d)) {
                    if (Result.m919isFailureimpl(obj)) {
                        Continuation<R> continuation = this.d;
                        Throwable r4 = Result.m916exceptionOrNullimpl(obj);
                        k21.f(r4);
                        Result.a aVar = Result.Companion;
                        if (n30.d() && (continuation instanceof CoroutineStackFrame)) {
                            r4 = sd2.j(r4, (CoroutineStackFrame) continuation);
                        }
                        continuation.resumeWith(Result.m913constructorimpl(k12.a(r4)));
                        return;
                    }
                    this.d.resumeWith(obj);
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.internal.b
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == jf.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new IllegalStateException(k21.r("Unexpected trySelectIdempotent result ", trySelectOther).toString());
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    public Object trySelectOther(@Nullable b.d dVar) {
        while (true) {
            Object obj = this._state;
            if (obj == e82.e()) {
                if (dVar == null) {
                    if (e.compareAndSet(this, e82.e(), null)) {
                        break;
                    }
                } else {
                    c cVar = new c(dVar);
                    if (e.compareAndSet(this, e82.e(), cVar)) {
                        Object c2 = cVar.c(this);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
            } else if (obj instanceof cl1) {
                if (dVar != null) {
                    j8<?> a2 = dVar.a();
                    if ((a2 instanceof a) && ((a) a2).b == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    } else if (a2.b((cl1) obj)) {
                        return i8.RETRY_ATOMIC;
                    }
                }
                ((cl1) obj).c(this);
            } else if (dVar != null && obj == dVar.c) {
                return jf.RESUME_TOKEN;
            } else {
                return null;
            }
        }
        w();
        return jf.RESUME_TOKEN;
    }

    @PublishedApi
    @Nullable
    public final Object y() {
        if (!isSelected()) {
            initCancellability();
        }
        Object obj = this._result;
        if (obj == e82.c) {
            if (f.compareAndSet(this, e82.c, kotlin.coroutines.intrinsics.b.d())) {
                return kotlin.coroutines.intrinsics.b.d();
            }
            obj = this._result;
        }
        if (obj == e82.d) {
            throw new IllegalStateException("Already resumed");
        } else if (!(obj instanceof hl)) {
            return obj;
        } else {
            throw ((hl) obj).a;
        }
    }

    @PublishedApi
    public final void z(@NotNull Throwable th) {
        if (trySelect()) {
            Result.a aVar = Result.Companion;
            resumeWith(Result.m913constructorimpl(k12.a(th)));
        } else if (!(th instanceof CancellationException)) {
            Object y = y();
            if (y instanceof hl) {
                Throwable th2 = ((hl) y).a;
                if (n30.d()) {
                    th2 = sd2.m(th2);
                }
                if (th2 == (!n30.d() ? th : sd2.m(th))) {
                    return;
                }
            }
            sn.a(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.registerSelectClause2(this, p, function2);
    }
}
