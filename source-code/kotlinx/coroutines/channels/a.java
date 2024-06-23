package kotlinx.coroutines.channels;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.b;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a11;
import tb.e82;
import tb.fh;
import tb.fj;
import tb.i1;
import tb.i8;
import tb.jf;
import tb.jf0;
import tb.jh2;
import tb.jl1;
import tb.jx1;
import tb.k12;
import tb.k21;
import tb.k82;
import tb.kf;
import tb.l82;
import tb.lf;
import tb.m82;
import tb.n30;
import tb.p30;
import tb.po2;
import tb.pr2;
import tb.q30;
import tb.q81;
import tb.r81;
import tb.sd2;
import tb.ur2;

/* compiled from: Taobao */
public abstract class a<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "onCloseHandler");
    @JvmField
    @Nullable
    protected final Function1<E, ur2> a;
    @NotNull
    private final q81 b = new q81();
    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* renamed from: kotlinx.coroutines.channels.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0288a<E> extends k82 {
        @JvmField
        public final E d;

        public C0288a(E e) {
            this.d = e;
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "SendBuffered@" + q30.b(this) + '(' + ((Object) this.d) + ')';
        }

        @Override // tb.k82
        public void u() {
        }

        @Override // tb.k82
        @Nullable
        public Object v() {
            return this.d;
        }

        @Override // tb.k82
        public void w(@NotNull fj<?> fjVar) {
            if (n30.a()) {
                throw new AssertionError();
            }
        }

        @Override // tb.k82
        @Nullable
        public jh2 x(@Nullable b.d dVar) {
            jh2 jh2 = jf.RESUME_TOKEN;
            if (dVar != null) {
                dVar.d();
            }
            return jh2;
        }
    }

    /* compiled from: Taobao */
    private static class b<E> extends b.C0290b<C0288a<? extends E>> {
        public b(@NotNull q81 q81, E e) {
            super(q81, new C0288a(e));
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public Object e(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (bVar instanceof fj) {
                return bVar;
            }
            if (bVar instanceof ReceiveOrClosed) {
                return i1.OFFER_FAILED;
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c<E, R> extends k82 implements DisposableHandle {
        private final E d;
        @JvmField
        @NotNull
        public final a<E> e;
        @JvmField
        @NotNull
        public final SelectInstance<R> f;
        @JvmField
        @NotNull
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> g;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.SendChannel<? super E>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(E e2, @NotNull a<E> aVar, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.d = e2;
            this.e = aVar;
            this.f = selectInstance;
            this.g = function2;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (p()) {
                y();
            }
        }

        @Override // kotlinx.coroutines.internal.b
        @NotNull
        public String toString() {
            return "SendSelect@" + q30.b(this) + '(' + ((Object) v()) + ")[" + this.e + AVFSCacheConstants.COMMA_SEP + this.f + jl1.ARRAY_END;
        }

        @Override // tb.k82
        public void u() {
            lf.d(this.g, this.e, this.f.getCompletion(), null, 4, null);
        }

        @Override // tb.k82
        public E v() {
            return this.d;
        }

        @Override // tb.k82
        public void w(@NotNull fj<?> fjVar) {
            if (this.f.trySelect()) {
                this.f.resumeSelectWithException(fjVar.C());
            }
        }

        @Override // tb.k82
        @Nullable
        public jh2 x(@Nullable b.d dVar) {
            return (jh2) this.f.trySelectOther(dVar);
        }

        @Override // tb.k82
        public void y() {
            Function1<E, ur2> function1 = this.e.a;
            if (function1 != null) {
                OnUndeliveredElementKt.b(function1, v(), this.f.getCompletion().getContext());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static final class d<E> extends b.e<ReceiveOrClosed<? super E>> {
        @JvmField
        public final E e;

        public d(E e2, @NotNull q81 q81) {
            super(q81);
            this.e = e2;
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.b.a, kotlinx.coroutines.internal.b.e
        @Nullable
        public Object e(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (bVar instanceof fj) {
                return bVar;
            }
            if (!(bVar instanceof ReceiveOrClosed)) {
                return i1.OFFER_FAILED;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.b.a
        @Nullable
        public Object j(@NotNull b.d dVar) {
            jh2 tryResumeReceive = ((ReceiveOrClosed) dVar.a).tryResumeReceive(this.e, dVar);
            if (tryResumeReceive == null) {
                return r81.REMOVE_PREPARED;
            }
            Object obj = i8.RETRY_ATOMIC;
            if (tryResumeReceive == obj) {
                return obj;
            }
            if (!n30.a()) {
                return null;
            }
            if (tryResumeReceive == jf.RESUME_TOKEN) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Taobao */
    public static final class e extends b.c {
        final /* synthetic */ a d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(kotlinx.coroutines.internal.b bVar, a aVar) {
            super(bVar);
            this.d = aVar;
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (this.d.s()) {
                return null;
            }
            return kotlinx.coroutines.internal.a.a();
        }
    }

    /* compiled from: Taobao */
    public static final class f implements SelectClause2<E, SendChannel<? super E>> {
        final /* synthetic */ a<E> a;

        f(a<E> aVar) {
            this.a = aVar;
        }

        @Override // kotlinx.coroutines.selects.SelectClause2
        public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, E e, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.a.x(selectInstance, e, function2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super E, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable Function1<? super E, ur2> function1) {
        this.a = function1;
    }

    private final int d() {
        q81 q81 = this.b;
        int i = 0;
        for (kotlinx.coroutines.internal.b bVar = (kotlinx.coroutines.internal.b) q81.j(); !k21.d(bVar, q81); bVar = bVar.k()) {
            if (bVar instanceof kotlinx.coroutines.internal.b) {
                i++;
            }
        }
        return i;
    }

    private final String l() {
        String str;
        kotlinx.coroutines.internal.b k = this.b.k();
        if (k == this.b) {
            return "EmptyQueue";
        }
        if (k instanceof fj) {
            str = k.toString();
        } else if (k instanceof jx1) {
            str = "ReceiveQueued";
        } else if (k instanceof k82) {
            str = "SendQueued";
        } else {
            str = k21.r("UNEXPECTED:", k);
        }
        kotlinx.coroutines.internal.b l = this.b.l();
        if (l == k) {
            return str;
        }
        String str2 = str + ",queueSize=" + d();
        if (!(l instanceof fj)) {
            return str2;
        }
        return str2 + ",closedForSend=" + l;
    }

    private final void m(fj<?> fjVar) {
        Object b2 = a11.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.b l = fjVar.l();
            jx1 jx1 = l instanceof jx1 ? (jx1) l : null;
            if (jx1 == null) {
                break;
            } else if (!jx1.p()) {
                jx1.m();
            } else {
                b2 = a11.c(b2, jx1);
            }
        }
        if (b2 != null) {
            if (!(b2 instanceof ArrayList)) {
                ((jx1) b2).w(fjVar);
            } else {
                ArrayList arrayList = (ArrayList) b2;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((jx1) arrayList.get(size)).w(fjVar);
                        if (i < 0) {
                            break;
                        }
                        size = i;
                    }
                }
            }
        }
        w(fjVar);
    }

    private final Throwable n(E e2, fj<?> fjVar) {
        UndeliveredElementException d2;
        m(fjVar);
        Function1<E, ur2> function1 = this.a;
        if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) == null) {
            return fjVar.C();
        }
        jf0.a(d2, fjVar.C());
        throw d2;
    }

    private final Throwable o(fj<?> fjVar) {
        m(fjVar);
        return fjVar.C();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void p(Continuation<?> continuation, E e2, fj<?> fjVar) {
        UndeliveredElementException d2;
        m(fjVar);
        Throwable C = fjVar.C();
        Function1<E, ur2> function1 = this.a;
        if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) == null) {
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(k12.a(C)));
            return;
        }
        jf0.a(d2, C);
        Result.a aVar2 = Result.Companion;
        continuation.resumeWith(Result.m913constructorimpl(k12.a(d2)));
    }

    private final void q(Throwable th) {
        jh2 jh2;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (jh2 = i1.HANDLER_INVOKED) && c.compareAndSet(this, obj, jh2)) {
            ((Function1) po2.e(obj, 1)).invoke(th);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean t() {
        return !(this.b.k() instanceof ReceiveOrClosed) && s();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final <R> void x(SelectInstance<? super R> selectInstance, E e2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (t()) {
                c cVar = new c(e2, this, selectInstance, function2);
                Object g = g(cVar);
                if (g == null) {
                    selectInstance.disposeOnSelect(cVar);
                    return;
                } else if (g instanceof fj) {
                    throw sd2.k(n(e2, (fj) g));
                } else if (g != i1.ENQUEUE_FAILED && !(g instanceof jx1)) {
                    throw new IllegalStateException(("enqueueSend returned " + g + ' ').toString());
                }
            }
            Object v = v(e2, selectInstance);
            if (v != e82.d()) {
                if (v != i1.OFFER_FAILED && v != i8.RETRY_ATOMIC) {
                    if (v == i1.OFFER_SUCCESS) {
                        pr2.d(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (v instanceof fj) {
                        throw sd2.k(n(e2, (fj) v));
                    } else {
                        throw new IllegalStateException(k21.r("offerSelectInternal returned ", v).toString());
                    }
                }
            } else {
                return;
            }
        }
    }

    private final Object z(E e2, Continuation<? super ur2> continuation) {
        k82 k82;
        CancellableContinuationImpl b2 = kf.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        while (true) {
            if (t()) {
                if (this.a == null) {
                    k82 = new l82(e2, b2);
                } else {
                    k82 = new m82(e2, b2, this.a);
                }
                Object g = g(k82);
                if (g == null) {
                    kf.c(b2, k82);
                    break;
                } else if (g instanceof fj) {
                    p(b2, e2, (fj) g);
                    break;
                } else if (g != i1.ENQUEUE_FAILED && !(g instanceof jx1)) {
                    throw new IllegalStateException(k21.r("enqueueSend returned ", g).toString());
                }
            }
            Object u = u(e2);
            if (u == i1.OFFER_SUCCESS) {
                ur2 ur2 = ur2.INSTANCE;
                Result.a aVar = Result.Companion;
                b2.resumeWith(Result.m913constructorimpl(ur2));
                break;
            } else if (u != i1.OFFER_FAILED) {
                if (u instanceof fj) {
                    p(b2, e2, (fj) u);
                } else {
                    throw new IllegalStateException(k21.r("offerInternal returned ", u).toString());
                }
            }
        }
        Object result = b2.getResult();
        if (result == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.b.d() ? result : ur2.INSTANCE;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ReceiveOrClosed<E> A() {
        kotlinx.coroutines.internal.b bVar;
        kotlinx.coroutines.internal.b r;
        q81 q81 = this.b;
        while (true) {
            bVar = (kotlinx.coroutines.internal.b) q81.j();
            if (bVar != q81 && (bVar instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) bVar) instanceof fj) && !bVar.o()) || (r = bVar.r()) == null) {
                    break;
                }
                r.n();
            }
        }
        bVar = null;
        return (ReceiveOrClosed) bVar;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final k82 B() {
        kotlinx.coroutines.internal.b bVar;
        kotlinx.coroutines.internal.b r;
        q81 q81 = this.b;
        while (true) {
            bVar = (kotlinx.coroutines.internal.b) q81.j();
            if (bVar != q81 && (bVar instanceof k82)) {
                if (((((k82) bVar) instanceof fj) && !bVar.o()) || (r = bVar.r()) == null) {
                    break;
                }
                r.n();
            }
        }
        bVar = null;
        return (k82) bVar;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable th) {
        boolean z;
        fj<?> fjVar = new fj<>(th);
        kotlinx.coroutines.internal.b bVar = this.b;
        while (true) {
            kotlinx.coroutines.internal.b l = bVar.l();
            z = true;
            if (!(l instanceof fj)) {
                if (l.e(fjVar, bVar)) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            fjVar = (fj) this.b.l();
        }
        m(fjVar);
        if (z) {
            q(th);
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final b.C0290b<?> e(E e2) {
        return new b(this.b, e2);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final d<E> f(E e2) {
        return new d<>(e2, this.b);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object g(@NotNull k82 k82) {
        boolean z;
        kotlinx.coroutines.internal.b l;
        if (r()) {
            kotlinx.coroutines.internal.b bVar = this.b;
            do {
                l = bVar.l();
                if (l instanceof ReceiveOrClosed) {
                    return l;
                }
            } while (!l.e(k82, bVar));
            return null;
        }
        kotlinx.coroutines.internal.b bVar2 = this.b;
        e eVar = new e(k82, this);
        while (true) {
            kotlinx.coroutines.internal.b l2 = bVar2.l();
            if (!(l2 instanceof ReceiveOrClosed)) {
                int t = l2.t(k82, bVar2, eVar);
                z = true;
                if (t != 1) {
                    if (t == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return l2;
            }
        }
        if (!z) {
            return i1.ENQUEUE_FAILED;
        }
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new f(this);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String h() {
        return "";
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final fj<?> i() {
        kotlinx.coroutines.internal.b k = this.b.k();
        fj<?> fjVar = k instanceof fj ? (fj) k : null;
        if (fjVar == null) {
            return null;
        }
        m(fjVar);
        return fjVar;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, ur2> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == i1.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException(k21.r("Another handler was already registered: ", obj));
        }
        fj<?> j = j();
        if (j != null && atomicReferenceFieldUpdater.compareAndSet(this, function1, i1.HANDLER_INVOKED)) {
            function1.invoke(j.d);
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return j() != null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final fj<?> j() {
        kotlinx.coroutines.internal.b l = this.b.l();
        fj<?> fjVar = l instanceof fj ? (fj) l : null;
        if (fjVar == null) {
            return null;
        }
        m(fjVar);
        return fjVar;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final q81 k() {
        return this.b;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e2) {
        UndeliveredElementException d2;
        try {
            return SendChannel.a.b(this, e2);
        } catch (Throwable th) {
            Function1<E, ur2> function1 = this.a;
            if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) == null) {
                throw th;
            }
            jf0.a(d2, th);
            throw d2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean r();

    /* access modifiers changed from: protected */
    public abstract boolean s();

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public final Object send(E e2, @NotNull Continuation<? super ur2> continuation) {
        if (u(e2) == i1.OFFER_SUCCESS) {
            return ur2.INSTANCE;
        }
        Object z = z(e2, continuation);
        return z == kotlin.coroutines.intrinsics.b.d() ? z : ur2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return q30.a(this) + '@' + q30.b(this) + '{' + l() + '}' + h();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: tb.fh$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public final Object m932trySendJP2dKIU(E e2) {
        Object u = u(e2);
        if (u == i1.OFFER_SUCCESS) {
            return fh.Companion.c(ur2.INSTANCE);
        }
        if (u == i1.OFFER_FAILED) {
            fj<?> j = j();
            if (j == null) {
                return fh.Companion.b();
            }
            return fh.Companion.a(o(j));
        } else if (u instanceof fj) {
            return fh.Companion.a(o((fj) u));
        } else {
            throw new IllegalStateException(k21.r("trySend returned ", u).toString());
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object u(E e2) {
        ReceiveOrClosed<E> A;
        jh2 tryResumeReceive;
        do {
            A = A();
            if (A == null) {
                return i1.OFFER_FAILED;
            }
            tryResumeReceive = A.tryResumeReceive(e2, null);
        } while (tryResumeReceive == null);
        if (n30.a()) {
            if (!(tryResumeReceive == jf.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        A.completeResumeReceive(e2);
        return A.getOfferResult();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object v(E e2, @NotNull SelectInstance<?> selectInstance) {
        d<E> f2 = f(e2);
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(f2);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) f2.o();
        receiveOrClosed.completeResumeReceive(e2);
        return receiveOrClosed.getOfferResult();
    }

    /* access modifiers changed from: protected */
    public void w(@NotNull kotlinx.coroutines.internal.b bVar) {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final ReceiveOrClosed<?> y(E e2) {
        kotlinx.coroutines.internal.b l;
        kotlinx.coroutines.internal.b bVar = this.b;
        C0288a aVar = new C0288a(e2);
        do {
            l = bVar.l();
            if (l instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) l;
            }
        } while (!l.e(aVar, bVar));
        return null;
    }
}
