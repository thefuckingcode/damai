package kotlinx.coroutines.channels;

import com.taobao.weex.ui.component.AbstractEditComponent;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.b;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a11;
import tb.e82;
import tb.fh;
import tb.fj;
import tb.hb;
import tb.i1;
import tb.i8;
import tb.jf;
import tb.jh2;
import tb.jl1;
import tb.jx1;
import tb.k12;
import tb.k21;
import tb.k82;
import tb.kf;
import tb.lf;
import tb.n30;
import tb.p30;
import tb.pr2;
import tb.q30;
import tb.q81;
import tb.qc;
import tb.r81;
import tb.sd2;
import tb.ur2;

/* compiled from: Taobao */
public abstract class AbstractChannel<E> extends a<E> implements Channel<E> {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a<E> implements ChannelIterator<E> {
        @JvmField
        @NotNull
        public final AbstractChannel<E> a;
        @Nullable
        private Object b = i1.POLL_FAILED;

        public a(@NotNull AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        private final boolean b(Object obj) {
            if (!(obj instanceof fj)) {
                return true;
            }
            fj fjVar = (fj) obj;
            if (fjVar.d == null) {
                return false;
            }
            throw sd2.k(fjVar.B());
        }

        private final Object c(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl b2 = kf.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
            d dVar = new d(this, b2);
            while (true) {
                if (this.a.H(dVar)) {
                    this.a.W(b2, dVar);
                    break;
                }
                Object S = this.a.S();
                d(S);
                if (S instanceof fj) {
                    fj fjVar = (fj) S;
                    if (fjVar.d == null) {
                        Boolean a2 = qc.a(false);
                        Result.a aVar = Result.Companion;
                        b2.resumeWith(Result.m913constructorimpl(a2));
                    } else {
                        Throwable B = fjVar.B();
                        Result.a aVar2 = Result.Companion;
                        b2.resumeWith(Result.m913constructorimpl(k12.a(B)));
                    }
                } else if (S != i1.POLL_FAILED) {
                    Boolean a3 = qc.a(true);
                    Function1<E, ur2> function1 = this.a.a;
                    b2.resume(a3, function1 == null ? null : OnUndeliveredElementKt.a(function1, S, b2.getContext()));
                }
            }
            Object result = b2.getResult();
            if (result == kotlin.coroutines.intrinsics.b.d()) {
                p30.c(continuation);
            }
            return result;
        }

        @Nullable
        public final Object a() {
            return this.b;
        }

        public final void d(@Nullable Object obj) {
            this.b = obj;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) {
            Object a2 = a();
            jh2 jh2 = i1.POLL_FAILED;
            if (a2 != jh2) {
                return qc.a(b(a()));
            }
            d(this.a.S());
            if (a() != jh2) {
                return qc.a(b(a()));
            }
            return c(continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = AbstractEditComponent.ReturnTypes.NEXT)
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.a(this, continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.b;
            if (!(e instanceof fj)) {
                jh2 jh2 = i1.POLL_FAILED;
                if (e != jh2) {
                    this.b = jh2;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw sd2.k(e.B());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b<E> extends jx1<E> {
        @JvmField
        @NotNull
        public final CancellableContinuation<Object> d;
        @JvmField
        public final int e;

        public b(@NotNull CancellableContinuation<Object> cancellableContinuation, int i) {
            this.d = cancellableContinuation;
            this.e = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e2) {
            this.d.completeResume(jf.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "ReceiveElement@" + q30.b(this) + "[receiveMode=" + this.e + jl1.ARRAY_END;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public jh2 tryResumeReceive(E e2, @Nullable b.d dVar) {
            Object tryResume = this.d.tryResume(x(e2), dVar == null ? null : dVar.c, v(e2));
            if (tryResume == null) {
                return null;
            }
            if (n30.a()) {
                if (!(tryResume == jf.RESUME_TOKEN)) {
                    throw new AssertionError();
                }
            }
            if (dVar != null) {
                dVar.d();
            }
            return jf.RESUME_TOKEN;
        }

        @Override // tb.jx1
        public void w(@NotNull fj<?> fjVar) {
            if (this.e == 1) {
                CancellableContinuation<Object> cancellableContinuation = this.d;
                fh b = fh.b(fh.Companion.a(fjVar.d));
                Result.a aVar = Result.Companion;
                cancellableContinuation.resumeWith(Result.m913constructorimpl(b));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.d;
            Throwable B = fjVar.B();
            Result.a aVar2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m913constructorimpl(k12.a(B)));
        }

        @Nullable
        public final Object x(E e2) {
            return this.e == 1 ? fh.b(fh.Companion.c(e2)) : e2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c<E> extends b<E> {
        @JvmField
        @NotNull
        public final Function1<E, ur2> f;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super E, tb.ur2> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull CancellableContinuation<Object> cancellableContinuation, int i, @NotNull Function1<? super E, ur2> function1) {
            super(cancellableContinuation, i);
            this.f = function1;
        }

        @Override // tb.jx1
        @Nullable
        public Function1<Throwable, ur2> v(E e) {
            return OnUndeliveredElementKt.a(this.f, e, this.d.getContext());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d<E> extends jx1<E> {
        @JvmField
        @NotNull
        public final a<E> d;
        @JvmField
        @NotNull
        public final CancellableContinuation<Boolean> e;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull a<E> aVar, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.d = aVar;
            this.e = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e2) {
            this.d.d(e2);
            this.e.completeResume(jf.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return k21.r("ReceiveHasNext@", q30.b(this));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public jh2 tryResumeReceive(E e2, @Nullable b.d dVar) {
            Object tryResume = this.e.tryResume(Boolean.TRUE, dVar == null ? null : dVar.c, v(e2));
            if (tryResume == null) {
                return null;
            }
            if (n30.a()) {
                if (!(tryResume == jf.RESUME_TOKEN)) {
                    throw new AssertionError();
                }
            }
            if (dVar != null) {
                dVar.d();
            }
            return jf.RESUME_TOKEN;
        }

        @Override // tb.jx1
        @Nullable
        public Function1<Throwable, ur2> v(E e2) {
            Function1<E, ur2> function1 = this.d.a.a;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.a(function1, e2, this.e.getContext());
        }

        @Override // tb.jx1
        public void w(@NotNull fj<?> fjVar) {
            Object obj;
            if (fjVar.d == null) {
                obj = CancellableContinuation.a.a(this.e, Boolean.FALSE, null, 2, null);
            } else {
                obj = this.e.tryResumeWithException(fjVar.B());
            }
            if (obj != null) {
                this.d.d(fjVar);
                this.e.completeResume(obj);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class e<R, E> extends jx1<E> implements DisposableHandle {
        @JvmField
        @NotNull
        public final AbstractChannel<E> d;
        @JvmField
        @NotNull
        public final SelectInstance<R> e;
        @JvmField
        @NotNull
        public final Function2<Object, Continuation<? super R>, Object> f;
        @JvmField
        public final int g;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.d = abstractChannel;
            this.e = selectInstance;
            this.f = function2;
            this.g = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e2) {
            lf.c(this.f, this.g == 1 ? fh.b(fh.Companion.c(e2)) : e2, this.e.getCompletion(), v(e2));
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (p()) {
                this.d.Q();
            }
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + q30.b(this) + jl1.ARRAY_START + this.e + ",receiveMode=" + this.g + jl1.ARRAY_END;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public jh2 tryResumeReceive(E e2, @Nullable b.d dVar) {
            return (jh2) this.e.trySelectOther(dVar);
        }

        @Override // tb.jx1
        @Nullable
        public Function1<Throwable, ur2> v(E e2) {
            Function1<E, ur2> function1 = this.d.a;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.a(function1, e2, this.e.getCompletion().getContext());
        }

        @Override // tb.jx1
        public void w(@NotNull fj<?> fjVar) {
            if (this.e.trySelect()) {
                int i = this.g;
                if (i == 0) {
                    this.e.resumeSelectWithException(fjVar.B());
                } else if (i == 1) {
                    lf.d(this.f, fh.b(fh.Companion.a(fjVar.d)), this.e.getCompletion(), null, 4, null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class f extends hb {
        @NotNull
        private final jx1<?> a;

        public f(@NotNull jx1<?> jx1) {
            this.a = jx1;
        }

        @Override // tb.Cif
        public void a(@Nullable Throwable th) {
            if (this.a.p()) {
                AbstractChannel.this.Q();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
            a(th);
            return ur2.INSTANCE;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + jl1.ARRAY_END;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static final class g<E> extends b.e<k82> {
        public g(@NotNull q81 q81) {
            super(q81);
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a, kotlinx.coroutines.internal.b.e
        @Nullable
        public Object e(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (bVar instanceof fj) {
                return bVar;
            }
            if (!(bVar instanceof k82)) {
                return i1.POLL_FAILED;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public Object j(@NotNull b.d dVar) {
            jh2 x = ((k82) dVar.a).x(dVar);
            if (x == null) {
                return r81.REMOVE_PREPARED;
            }
            Object obj = i8.RETRY_ATOMIC;
            if (x == obj) {
                return obj;
            }
            if (!n30.a()) {
                return null;
            }
            if (x == jf.RESUME_TOKEN) {
                return null;
            }
            throw new AssertionError();
        }

        @Override // kotlinx.coroutines.internal.b.a
        public void k(@NotNull kotlinx.coroutines.internal.b bVar) {
            ((k82) bVar).y();
        }
    }

    /* compiled from: Taobao */
    public static final class h extends b.c {
        final /* synthetic */ AbstractChannel d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(kotlinx.coroutines.internal.b bVar, AbstractChannel abstractChannel) {
            super(bVar);
            this.d = abstractChannel;
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (this.d.M()) {
                return null;
            }
            return kotlinx.coroutines.internal.a.a();
        }
    }

    /* compiled from: Taobao */
    public static final class i implements SelectClause1<E> {
        final /* synthetic */ AbstractChannel<E> a;

        i(AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.SelectClause1
        public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
            this.a.V(selectInstance, 0, function2);
        }
    }

    /* compiled from: Taobao */
    public static final class j implements SelectClause1<fh<? extends E>> {
        final /* synthetic */ AbstractChannel<E> a;

        j(AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.SelectClause1
        public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super fh<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.a.V(selectInstance, 1, function2);
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, ur2> function1) {
        super(function1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean H(jx1<? super E> jx1) {
        boolean I = I(jx1);
        if (I) {
            R();
        }
        return I;
    }

    private final <R> boolean J(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i2) {
        e eVar = new e(this, selectInstance, function2, i2);
        boolean H = H(eVar);
        if (H) {
            selectInstance.disposeOnSelect(eVar);
        }
        return H;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final <R> Object U(int i2, Continuation<? super R> continuation) {
        c cVar;
        CancellableContinuationImpl b2 = kf.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        if (this.a == null) {
            cVar = new b(b2, i2);
        } else {
            cVar = new c(b2, i2, this.a);
        }
        while (true) {
            if (!H(cVar)) {
                Object S = S();
                if (!(S instanceof fj)) {
                    if (S != i1.POLL_FAILED) {
                        b2.resume(cVar.x(S), cVar.v(S));
                        break;
                    }
                } else {
                    cVar.w((fj) S);
                    break;
                }
            } else {
                W(b2, cVar);
                break;
            }
        }
        Object result = b2.getResult();
        if (result == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return result;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final <R> void V(SelectInstance<? super R> selectInstance, int i2, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (!N()) {
                Object T = T(selectInstance);
                if (T != e82.d()) {
                    if (!(T == i1.POLL_FAILED || T == i8.RETRY_ATOMIC)) {
                        X(function2, selectInstance, i2, T);
                    }
                } else {
                    return;
                }
            } else if (J(selectInstance, function2, i2)) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void W(CancellableContinuation<?> cancellableContinuation, jx1<?> jx1) {
        cancellableContinuation.invokeOnCancellation(new f(jx1));
    }

    private final <R> void X(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i2, Object obj) {
        boolean z = obj instanceof fj;
        if (z) {
            if (i2 == 0) {
                throw sd2.k(((fj) obj).B());
            } else if (i2 == 1 && selectInstance.trySelect()) {
                pr2.d(function2, fh.b(fh.Companion.a(((fj) obj).d)), selectInstance.getCompletion());
            }
        } else if (i2 == 1) {
            fh.b bVar = fh.Companion;
            pr2.d(function2, fh.b(z ? bVar.a(((fj) obj).d) : bVar.c(obj)), selectInstance.getCompletion());
        } else {
            pr2.d(function2, obj, selectInstance.getCompletion());
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @Nullable
    public ReceiveOrClosed<E> A() {
        ReceiveOrClosed<E> A = super.A();
        if (A != null && !(A instanceof fj)) {
            Q();
        }
        return A;
    }

    /* renamed from: F */
    public final boolean cancel(@Nullable Throwable th) {
        boolean close = close(th);
        O(close);
        return close;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final g<E> G() {
        return new g<>(k());
    }

    /* access modifiers changed from: protected */
    public boolean I(@NotNull jx1<? super E> jx1) {
        int t;
        kotlinx.coroutines.internal.b l;
        if (L()) {
            kotlinx.coroutines.internal.b k = k();
            do {
                l = k.l();
                if (!(!(l instanceof k82))) {
                    return false;
                }
            } while (!l.e(jx1, k));
        } else {
            kotlinx.coroutines.internal.b k2 = k();
            h hVar = new h(jx1, this);
            do {
                kotlinx.coroutines.internal.b l2 = k2.l();
                if (!(!(l2 instanceof k82))) {
                    return false;
                }
                t = l2.t(jx1, k2, hVar);
                if (t != 1) {
                }
            } while (t != 2);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean K() {
        return k().k() instanceof ReceiveOrClosed;
    }

    /* access modifiers changed from: protected */
    public abstract boolean L();

    /* access modifiers changed from: protected */
    public abstract boolean M();

    /* access modifiers changed from: protected */
    public final boolean N() {
        return !(k().k() instanceof k82) && M();
    }

    /* access modifiers changed from: protected */
    public void O(boolean z) {
        fj<?> j2 = j();
        if (j2 != null) {
            Object b2 = a11.b(null, 1, null);
            while (true) {
                kotlinx.coroutines.internal.b l = j2.l();
                if (l instanceof q81) {
                    P(b2, j2);
                    return;
                } else if (n30.a() && !(l instanceof k82)) {
                    throw new AssertionError();
                } else if (!l.p()) {
                    l.m();
                } else {
                    b2 = a11.c(b2, (k82) l);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    /* access modifiers changed from: protected */
    public void P(@NotNull Object obj, @NotNull fj<?> fjVar) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                ((k82) obj).w(fjVar);
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = size - 1;
                    ((k82) arrayList.get(size)).w(fjVar);
                    if (i2 >= 0) {
                        size = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void Q() {
    }

    /* access modifiers changed from: protected */
    public void R() {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object S() {
        while (true) {
            k82 B = B();
            if (B == null) {
                return i1.POLL_FAILED;
            }
            jh2 x = B.x(null);
            if (x != null) {
                if (n30.a()) {
                    if (!(x == jf.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                B.u();
                return B.v();
            }
            B.y();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object T(@NotNull SelectInstance<?> selectInstance) {
        g<E> G = G();
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(G);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ((k82) G.o()).u();
        return ((k82) G.o()).v();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        ReceiveChannel.DefaultImpls.a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<E> getOnReceive() {
        return new i(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<fh<E>> getOnReceiveCatching() {
        return new j(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return Channel.a.b(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return i() != null && M();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return N();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return (E) Channel.a.c(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final Object receive(@NotNull Continuation<? super E> continuation) {
        Object S = S();
        if (S == i1.POLL_FAILED || (S instanceof fj)) {
            return U(0, continuation);
        }
        return S;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: tb.fh$b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public final Object m926receiveCatchingJP2dKIU(@NotNull Continuation<? super fh<? extends E>> continuation) {
        AbstractChannel$receiveCatching$1 abstractChannel$receiveCatching$1;
        int i2;
        if (continuation instanceof AbstractChannel$receiveCatching$1) {
            abstractChannel$receiveCatching$1 = (AbstractChannel$receiveCatching$1) continuation;
            int i3 = abstractChannel$receiveCatching$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                abstractChannel$receiveCatching$1.label = i3 - Integer.MIN_VALUE;
                Object obj = abstractChannel$receiveCatching$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i2 = abstractChannel$receiveCatching$1.label;
                if (i2 != 0) {
                    k12.b(obj);
                    Object S = S();
                    if (S != i1.POLL_FAILED) {
                        return S instanceof fj ? fh.Companion.a(((fj) S).d) : fh.Companion.c(S);
                    }
                    abstractChannel$receiveCatching$1.label = 1;
                    obj = U(1, abstractChannel$receiveCatching$1);
                    if (obj == obj2) {
                        return obj2;
                    }
                } else if (i2 == 1) {
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((fh) obj).l();
            }
        }
        abstractChannel$receiveCatching$1 = new AbstractChannel$receiveCatching$1(this, continuation);
        Object obj3 = abstractChannel$receiveCatching$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i2 = abstractChannel$receiveCatching$1.label;
        if (i2 != 0) {
        }
        return ((fh) obj3).l();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return Channel.a.d(this, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: tb.fh$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public final Object m927tryReceivePtdJZtk() {
        Object S = S();
        if (S == i1.POLL_FAILED) {
            return fh.Companion.b();
        }
        if (S instanceof fj) {
            return fh.Companion.a(((fj) S).d);
        }
        return fh.Companion.c(S);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (!isClosedForReceive()) {
            if (cancellationException == null) {
                cancellationException = new CancellationException(k21.r(q30.a(this), " was cancelled"));
            }
            cancel(cancellationException);
        }
    }
}
