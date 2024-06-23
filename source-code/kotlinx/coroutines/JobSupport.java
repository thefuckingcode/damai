package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.e;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.b;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cl1;
import tb.h41;
import tb.hl;
import tb.j41;
import tb.jf0;
import tb.jl1;
import tb.k21;
import tb.kf;
import tb.l41;
import tb.lf;
import tb.n30;
import tb.p01;
import tb.p30;
import tb.pr2;
import tb.q30;
import tb.sd2;
import tb.uh;
import tb.ur2;
import tb.xi1;
import tb.zi1;

@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* compiled from: Taobao */
public class JobSupport implements ChildJob, Job, ParentJob, SelectClause0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    @NotNull
    private volatile /* synthetic */ Object _parentHandle;
    @NotNull
    private volatile /* synthetic */ Object _state;

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/Job;", "parent", "", "getContinuationCancellationCause", "", "nameString", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlinx/coroutines/JobSupport;", "Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        @NotNull
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job job2) {
            Throwable d;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if ((state$kotlinx_coroutines_core instanceof b) && (d = ((b) state$kotlinx_coroutines_core).d()) != null) {
                return d;
            }
            if (state$kotlinx_coroutines_core instanceof hl) {
                return ((hl) state$kotlinx_coroutines_core).a;
            }
            return job2.getCancellationException();
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public String nameString() {
            return "AwaitContinuation";
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a extends l41 {
        @NotNull
        private final JobSupport e;
        @NotNull
        private final b f;
        @NotNull
        private final uh g;
        @Nullable
        private final Object h;

        public a(@NotNull JobSupport jobSupport, @NotNull b bVar, @NotNull uh uhVar, @Nullable Object obj) {
            this.e = jobSupport;
            this.f = bVar;
            this.g = uhVar;
            this.h = obj;
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
            this.e.continueCompleting(this.f, this.g, this.h);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b implements Incomplete {
        @NotNull
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        @NotNull
        private volatile /* synthetic */ int _isCompleting;
        @NotNull
        private volatile /* synthetic */ Object _rootCause;
        @NotNull
        private final xi1 a;

        public b(@NotNull xi1 xi1, boolean z, @Nullable Throwable th) {
            this.a = xi1;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void j(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.ArrayList<java.lang.Throwable> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull Throwable th) {
            Throwable d = d();
            if (d == null) {
                k(th);
            } else if (th != d) {
                Object c = c();
                if (c == null) {
                    j(th);
                } else if (c instanceof Throwable) {
                    if (th != c) {
                        ArrayList<Throwable> b = b();
                        b.add(c);
                        b.add(th);
                        ur2 ur2 = ur2.INSTANCE;
                        j(b);
                    }
                } else if (c instanceof ArrayList) {
                    ((ArrayList) c).add(th);
                } else {
                    throw new IllegalStateException(k21.r("State is ", c).toString());
                }
            }
        }

        @Nullable
        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final boolean f() {
            return this._isCompleting;
        }

        public final boolean g() {
            return c() == q.d;
        }

        @Override // kotlinx.coroutines.Incomplete
        @NotNull
        public xi1 getList() {
            return this.a;
        }

        @NotNull
        public final List<Throwable> h(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            Object c = c();
            if (c == null) {
                arrayList = b();
            } else if (c instanceof Throwable) {
                ArrayList<Throwable> b = b();
                b.add(c);
                arrayList = b;
            } else if (c instanceof ArrayList) {
                arrayList = (ArrayList) c;
            } else {
                throw new IllegalStateException(k21.r("State is ", c).toString());
            }
            Throwable d = d();
            if (d != null) {
                arrayList.add(0, d);
            }
            if (th != null && !k21.d(th, d)) {
                arrayList.add(th);
            }
            j(q.d);
            return arrayList;
        }

        public final void i(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return d() == null;
        }

        public final void k(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + c() + ", list=" + getList() + jl1.ARRAY_END;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends b.c {
        final /* synthetic */ JobSupport d;
        final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.b bVar, JobSupport jobSupport, Object obj) {
            super(bVar);
            this.d = jobSupport;
            this.e = obj;
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.b bVar) {
            if (this.d.getState$kotlinx_coroutines_core() == this.e) {
                return null;
            }
            return kotlinx.coroutines.internal.a.a();
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? q.f : q.e;
        this._parentHandle = null;
    }

    private final boolean addLastAtomic(Object obj, xi1 xi1, l41 l41) {
        int t;
        c cVar = new c(l41, this, obj);
        do {
            t = xi1.l().t(l41, xi1, cVar);
            if (t == 1) {
                return true;
            }
        } while (t != 2);
        return false;
    }

    private final void addSuppressedExceptions(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable m = !n30.d() ? th : sd2.m(th);
            for (Throwable th2 : list) {
                if (n30.d()) {
                    th2 = sd2.m(th2);
                }
                if (th2 != th && th2 != m && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    jf0.a(th, th2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), this);
        awaitContinuation.initCancellability();
        kf.a(awaitContinuation, invokeOnCompletion(new s(awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return result;
    }

    private final Object cancelMakeCompleting(Object obj) {
        Object tryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).f())) {
                return q.a;
            }
            tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new hl(createCauseException(obj), false, 2, null));
        } while (tryMakeCompleting == q.b);
        return tryMakeCompleting;
    }

    private final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == zi1.INSTANCE) {
            return z;
        }
        if (parentHandle$kotlinx_coroutines_core.childCancelled(th) || z) {
            return true;
        }
        return false;
    }

    private final void completeStateFinalization(Incomplete incomplete, Object obj) {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(zi1.INSTANCE);
        }
        Throwable th = null;
        hl hlVar = obj instanceof hl ? (hl) obj : null;
        if (hlVar != null) {
            th = hlVar.a;
        }
        if (incomplete instanceof l41) {
            try {
                ((l41) incomplete).u(th);
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            xi1 list = incomplete.getList();
            if (list != null) {
                notifyCompletion(list, th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void continueCompleting(b bVar, uh uhVar, Object obj) {
        if (n30.a()) {
            if (!(getState$kotlinx_coroutines_core() == bVar)) {
                throw new AssertionError();
            }
        }
        uh nextChild = nextChild(uhVar);
        if (nextChild == null || !tryWaitForChild(bVar, nextChild, obj)) {
            afterCompletion(finalizeFinishingState(bVar, obj));
        }
    }

    private final Throwable createCauseException(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).getChildJobCancellationCause();
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.cancellationExceptionMessage();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final Object finalizeFinishingState(b bVar, Object obj) {
        boolean e;
        Throwable finalRootCause;
        boolean z = true;
        if (n30.a()) {
            if (!(getState$kotlinx_coroutines_core() == bVar)) {
                throw new AssertionError();
            }
        }
        if (n30.a() && !(!bVar.g())) {
            throw new AssertionError();
        } else if (!n30.a() || bVar.f()) {
            hl hlVar = obj instanceof hl ? (hl) obj : null;
            Throwable th = hlVar == null ? null : hlVar.a;
            synchronized (bVar) {
                e = bVar.e();
                List<Throwable> h = bVar.h(th);
                finalRootCause = getFinalRootCause(bVar, h);
                if (finalRootCause != null) {
                    addSuppressedExceptions(finalRootCause, h);
                }
            }
            if (!(finalRootCause == null || finalRootCause == th)) {
                obj = new hl(finalRootCause, false, 2, null);
            }
            if (finalRootCause != null) {
                if (!cancelParent(finalRootCause) && !handleJobException(finalRootCause)) {
                    z = false;
                }
                if (z) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    ((hl) obj).b();
                }
            }
            if (!e) {
                onCancelling(finalRootCause);
            }
            onCompletionInternal(obj);
            boolean compareAndSet = _state$FU.compareAndSet(this, bVar, q.g(obj));
            if (!n30.a() || compareAndSet) {
                completeStateFinalization(bVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    private final uh firstChild(Incomplete incomplete) {
        uh uhVar = incomplete instanceof uh ? (uh) incomplete : null;
        if (uhVar != null) {
            return uhVar;
        }
        xi1 list = incomplete.getList();
        if (list == null) {
            return null;
        }
        return nextChild(list);
    }

    private final Throwable getExceptionOrNull(Object obj) {
        hl hlVar = obj instanceof hl ? (hl) obj : null;
        if (hlVar == null) {
            return null;
        }
        return hlVar.a;
    }

    private final Throwable getFinalRootCause(b bVar, List<? extends Throwable> list) {
        T t;
        boolean z;
        T t2 = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (!(t instanceof CancellationException)) {
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                return t3;
            }
            Throwable th = (Throwable) list.get(0);
            if (th instanceof TimeoutCancellationException) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    T t4 = next;
                    if (t4 == th || !(t4 instanceof TimeoutCancellationException)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t2 = next;
                        break;
                    }
                }
                T t5 = t2;
                if (t5 != null) {
                    return t5;
                }
            }
            return th;
        } else if (bVar.e()) {
            return new JobCancellationException(cancellationExceptionMessage(), null, this);
        } else {
            return null;
        }
    }

    private final xi1 getOrPromoteCancellingList(Incomplete incomplete) {
        xi1 list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof j) {
            return new xi1();
        }
        if (incomplete instanceof l41) {
            promoteSingleToNodeList((l41) incomplete);
            return null;
        }
        throw new IllegalStateException(k21.r("State should have list: ", incomplete).toString());
    }

    private final boolean isCancelling(Incomplete incomplete) {
        return (incomplete instanceof b) && ((b) incomplete).e();
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* access modifiers changed from: private */
    public final Object joinSuspend(Continuation<? super ur2> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        kf.a(cancellableContinuationImpl, invokeOnCompletion(new t(cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.b.d() ? result : ur2.INSTANCE;
    }

    private final Void loopOnState(Function1<Object, ur2> function1) {
        while (true) {
            function1.invoke(getState$kotlinx_coroutines_core());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r0 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        notifyCancelling(((kotlinx.coroutines.JobSupport.b) r2).getList(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        return kotlinx.coroutines.q.a;
     */
    private final Object makeCancelling(Object obj) {
        Throwable th = null;
        Throwable th2 = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof b) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((b) state$kotlinx_coroutines_core).g()) {
                        return q.c;
                    }
                    boolean e = ((b) state$kotlinx_coroutines_core).e();
                    if (obj != null || !e) {
                        if (th2 == null) {
                            th2 = createCauseException(obj);
                        }
                        ((b) state$kotlinx_coroutines_core).a(th2);
                    }
                    Throwable d = ((b) state$kotlinx_coroutines_core).d();
                    if (!e) {
                        th = d;
                    }
                }
            } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return q.c;
            } else {
                if (th2 == null) {
                    th2 = createCauseException(obj);
                }
                Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                if (!incomplete.isActive()) {
                    Object tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new hl(th2, false, 2, null));
                    if (tryMakeCompleting == q.a) {
                        throw new IllegalStateException(k21.r("Cannot happen in ", state$kotlinx_coroutines_core).toString());
                    } else if (tryMakeCompleting != q.b) {
                        return tryMakeCompleting;
                    }
                } else if (tryMakeCancelling(incomplete, th2)) {
                    return q.a;
                }
            }
        }
    }

    private final l41 makeNode(Function1<? super Throwable, ur2> function1, boolean z) {
        l41 l41 = null;
        if (z) {
            if (function1 instanceof h41) {
                l41 = (h41) function1;
            }
            if (l41 == null) {
                l41 = new o(function1);
            }
        } else {
            l41 l412 = function1 instanceof l41 ? (l41) function1 : null;
            if (l412 != null) {
                if (!n30.a() || (!(l412 instanceof h41))) {
                    l41 = l412;
                } else {
                    throw new AssertionError();
                }
            }
            if (l41 == null) {
                l41 = new p(function1);
            }
        }
        l41.w(this);
        return l41;
    }

    private final uh nextChild(kotlinx.coroutines.internal.b bVar) {
        while (bVar.o()) {
            bVar = bVar.l();
        }
        while (true) {
            bVar = bVar.k();
            if (!bVar.o()) {
                if (bVar instanceof uh) {
                    return (uh) bVar;
                }
                if (bVar instanceof xi1) {
                    return null;
                }
            }
        }
    }

    private final void notifyCancelling(xi1 xi1, Throwable th) {
        CompletionHandlerException completionHandlerException;
        onCancelling(th);
        CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.b bVar = (kotlinx.coroutines.internal.b) xi1.j(); !k21.d(bVar, xi1); bVar = bVar.k()) {
            if (bVar instanceof h41) {
                l41 l41 = (l41) bVar;
                try {
                    l41.u(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        jf0.a(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + l41 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException2);
        }
        cancelParent(th);
    }

    private final void notifyCompletion(xi1 xi1, Throwable th) {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.b bVar = (kotlinx.coroutines.internal.b) xi1.j(); !k21.d(bVar, xi1); bVar = bVar.k()) {
            if (bVar instanceof l41) {
                l41 l41 = (l41) bVar;
                try {
                    l41.u(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        jf0.a(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + l41 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException2);
        }
    }

    private final /* synthetic */ void notifyHandlers(xi1 xi1, Throwable th) {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.b bVar = (kotlinx.coroutines.internal.b) xi1.j(); !k21.d(bVar, xi1); bVar = bVar.k()) {
            k21.o(3, "T");
            if (bVar instanceof kotlinx.coroutines.internal.b) {
                l41 l41 = (l41) bVar;
                try {
                    l41.u(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        jf0.a(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + l41 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [tb.p01] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void promoteEmptyToNodeList(j jVar) {
        xi1 xi1 = new xi1();
        if (!jVar.isActive()) {
            xi1 = new p01(xi1);
        }
        _state$FU.compareAndSet(this, jVar, xi1);
    }

    private final void promoteSingleToNodeList(l41 l41) {
        l41.f(new xi1());
        _state$FU.compareAndSet(this, l41, l41.k());
    }

    private final int startInternal(Object obj) {
        if (obj instanceof j) {
            if (((j) obj).isActive()) {
                return 0;
            }
            if (!_state$FU.compareAndSet(this, obj, q.f)) {
                return -1;
            }
            onStart();
            return 1;
        } else if (!(obj instanceof p01)) {
            return 0;
        } else {
            if (!_state$FU.compareAndSet(this, obj, ((p01) obj).getList())) {
                return -1;
            }
            onStart();
            return 1;
        }
    }

    private final String stateString(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.e()) {
                return "Cancelling";
            }
            if (bVar.f()) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof Incomplete)) {
            return obj instanceof hl ? "Cancelled" : "Completed";
        } else {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.toCancellationException(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete, Object obj) {
        if (n30.a()) {
            if (!((incomplete instanceof j) || (incomplete instanceof l41))) {
                throw new AssertionError();
            }
        }
        if (n30.a() && !(!(obj instanceof hl))) {
            throw new AssertionError();
        } else if (!_state$FU.compareAndSet(this, incomplete, q.g(obj))) {
            return false;
        } else {
            onCancelling(null);
            onCompletionInternal(obj);
            completeStateFinalization(incomplete, obj);
            return true;
        }
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, Throwable th) {
        if (n30.a() && !(!(incomplete instanceof b))) {
            throw new AssertionError();
        } else if (!n30.a() || incomplete.isActive()) {
            xi1 orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
            if (orPromoteCancellingList == null) {
                return false;
            }
            if (!_state$FU.compareAndSet(this, incomplete, new b(orPromoteCancellingList, false, th))) {
                return false;
            }
            notifyCancelling(orPromoteCancellingList, th);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private final Object tryMakeCompleting(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return q.a;
        }
        if ((!(obj instanceof j) && !(obj instanceof l41)) || (obj instanceof uh) || (obj2 instanceof hl)) {
            return tryMakeCompletingSlowPath((Incomplete) obj, obj2);
        }
        if (tryFinalizeSimpleState((Incomplete) obj, obj2)) {
            return obj2;
        }
        return q.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0072, code lost:
        if (r2 != null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0075, code lost:
        notifyCancelling(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0078, code lost:
        r7 = firstChild(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007c, code lost:
        if (r7 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
        if (tryWaitForChild(r1, r7, r8) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0086, code lost:
        return kotlinx.coroutines.q.COMPLETING_WAITING_CHILDREN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008b, code lost:
        return finalizeFinishingState(r1, r8);
     */
    private final Object tryMakeCompletingSlowPath(Incomplete incomplete, Object obj) {
        xi1 orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
        if (orPromoteCancellingList == null) {
            return q.b;
        }
        Throwable th = null;
        b bVar = incomplete instanceof b ? (b) incomplete : null;
        if (bVar == null) {
            bVar = new b(orPromoteCancellingList, false, null);
        }
        synchronized (bVar) {
            if (bVar.f()) {
                return q.a;
            }
            bVar.i(true);
            if (bVar != incomplete && !_state$FU.compareAndSet(this, incomplete, bVar)) {
                return q.b;
            } else if (!n30.a() || (!bVar.g())) {
                boolean e = bVar.e();
                hl hlVar = obj instanceof hl ? (hl) obj : null;
                if (hlVar != null) {
                    bVar.a(hlVar.a);
                }
                Throwable d = bVar.d();
                if (true ^ e) {
                    th = d;
                }
                ur2 ur2 = ur2.INSTANCE;
            } else {
                throw new AssertionError();
            }
        }
    }

    private final boolean tryWaitForChild(b bVar, uh uhVar, Object obj) {
        while (Job.a.e(uhVar.e, false, false, new a(this, bVar, uhVar, obj), 1, null) == zi1.INSTANCE) {
            uhVar = nextChild(uhVar);
            if (uhVar == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void afterCompletion(@Nullable Object obj) {
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob childJob) {
        return (ChildHandle) Job.a.e(this, true, false, new uh(childJob), 2, null);
    }

    @Nullable
    public final Object awaitInternal$kotlinx_coroutines_core(@NotNull Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof hl)) {
                    return q.h(state$kotlinx_coroutines_core);
                }
                Throwable th = ((hl) state$kotlinx_coroutines_core).a;
                if (!n30.d()) {
                    throw th;
                } else if (!(continuation instanceof CoroutineStackFrame)) {
                    throw th;
                } else {
                    throw sd2.j(th, (CoroutineStackFrame) continuation);
                }
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((Job) ((CancellationException) null));
    }

    public final boolean cancelCoroutine(@Nullable Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object obj) {
        Object obj2 = q.a;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (obj2 = cancelMakeCompleting(obj)) == q.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (obj2 == q.a) {
            obj2 = makeCancelling(obj);
        }
        if (obj2 == q.a || obj2 == q.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (obj2 == q.c) {
            return false;
        }
        afterCompletion(obj2);
        return true;
    }

    public void cancelInternal(@NotNull Throwable th) {
        cancelImpl$kotlinx_coroutines_core(th);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!cancelImpl$kotlinx_coroutines_core(th) || !getHandlesException$kotlinx_coroutines_core()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.a.c(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) Job.a.d(this, key);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable d = ((b) state$kotlinx_coroutines_core).d();
            if (d != null) {
                return toCancellationException(d, k21.r(q30.a(this), " is cancelling"));
            }
            throw new IllegalStateException(k21.r("Job is still new or active: ", this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(k21.r("Job is still new or active: ", this).toString());
        } else if (state$kotlinx_coroutines_core instanceof hl) {
            return toCancellationException$default(this, ((hl) state$kotlinx_coroutines_core).a, null, 1, null);
        } else {
            return new JobCancellationException(k21.r(q30.a(this), " has completed normally"), null, this);
        }
    }

    @Override // kotlinx.coroutines.ParentJob
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException = null;
        if (state$kotlinx_coroutines_core instanceof b) {
            th = ((b) state$kotlinx_coroutines_core).d();
        } else if (state$kotlinx_coroutines_core instanceof hl) {
            th = ((hl) state$kotlinx_coroutines_core).a;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(k21.r("Cannot be cancelling child in this state: ", state$kotlinx_coroutines_core).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        return cancellationException == null ? new JobCancellationException(k21.r("Parent job is ", stateString(state$kotlinx_coroutines_core)), th, this) : cancellationException;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final Sequence<Job> getChildren() {
        return e.b(new JobSupport$children$1(this, null));
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(state$kotlinx_coroutines_core instanceof hl)) {
            return q.h(state$kotlinx_coroutines_core);
        } else {
            throw ((hl) state$kotlinx_coroutines_core).a;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable d = ((b) state$kotlinx_coroutines_core).d();
            if (d != null) {
                return d;
            }
            throw new IllegalStateException(k21.r("Job is still new or active: ", this).toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(k21.r("Job is still new or active: ", this).toString());
        } else if (state$kotlinx_coroutines_core instanceof hl) {
            return ((hl) state$kotlinx_coroutines_core).a;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof hl) && ((hl) state$kotlinx_coroutines_core).a();
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final SelectClause0 getOnJoin() {
        return this;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) this._parentHandle;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof cl1)) {
                return obj;
            }
            ((cl1) obj).c(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean handleJobException(@NotNull Throwable th) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public final void initParentJob(@Nullable Job job) {
        if (n30.a()) {
            if (!(getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            setParentHandle$kotlinx_coroutines_core(zi1.INSTANCE);
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(zi1.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, ur2> function1) {
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof hl) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).e());
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof hl;
    }

    /* access modifiers changed from: protected */
    public boolean isScopedCoroutine() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public final Object join(@NotNull Continuation<? super ur2> continuation) {
        if (!joinInternal()) {
            j41.f(continuation.getContext());
            return ur2.INSTANCE;
        }
        Object joinSuspend = joinSuspend(continuation);
        return joinSuspend == kotlin.coroutines.intrinsics.b.d() ? joinSuspend : ur2.INSTANCE;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == q.a) {
                return false;
            }
            if (tryMakeCompleting == q.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (tryMakeCompleting == q.b);
        afterCompletion(tryMakeCompleting);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object obj) {
        Object tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (tryMakeCompleting == q.a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, getExceptionOrNull(obj));
            }
        } while (tryMakeCompleting == q.b);
        return tryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.a.f(this, key);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return q30.a(this);
    }

    /* access modifiers changed from: protected */
    public void onCancelling(@Nullable Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void onCompletionInternal(@Nullable Object obj) {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@NotNull ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.a.g(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (selectInstance.trySelect()) {
                        pr2.c(function1, selectInstance.getCompletion());
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new v(selectInstance, function1)));
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (!selectInstance.trySelect()) {
                        return;
                    }
                    if (state$kotlinx_coroutines_core instanceof hl) {
                        selectInstance.resumeSelectWithException(((hl) state$kotlinx_coroutines_core).a);
                        return;
                    } else {
                        pr2.d(function2, q.h(state$kotlinx_coroutines_core), selectInstance.getCompletion());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new u(selectInstance, function2)));
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull l41 l41) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof l41) {
                if (state$kotlinx_coroutines_core != l41) {
                    return;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                l41.p();
                return;
            } else {
                return;
            }
        } while (!_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, q.f));
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof hl) {
            selectInstance.resumeSelectWithException(((hl) state$kotlinx_coroutines_core).a);
        } else {
            lf.d(function2, q.h(state$kotlinx_coroutines_core), selectInstance.getCompletion(), null, 4, null);
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final CancellationException toCancellationException(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    @NotNull
    public String toString() {
        return toDebugString() + '@' + q30.b(this);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, @NotNull Function1<? super Throwable, ur2> function1) {
        l41 makeNode = makeNode(function1, z);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof j) {
                j jVar = (j) state$kotlinx_coroutines_core;
                if (!jVar.isActive()) {
                    promoteEmptyToNodeList(jVar);
                } else if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, makeNode)) {
                    return makeNode;
                }
            } else {
                Throwable th = null;
                if (state$kotlinx_coroutines_core instanceof Incomplete) {
                    xi1 list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                    if (list == null) {
                        Objects.requireNonNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        promoteSingleToNodeList((l41) state$kotlinx_coroutines_core);
                    } else {
                        DisposableHandle disposableHandle = zi1.INSTANCE;
                        if (z && (state$kotlinx_coroutines_core instanceof b)) {
                            synchronized (state$kotlinx_coroutines_core) {
                                th = ((b) state$kotlinx_coroutines_core).d();
                                if (th == null || ((function1 instanceof uh) && !((b) state$kotlinx_coroutines_core).f())) {
                                    if (addLastAtomic(state$kotlinx_coroutines_core, list, makeNode)) {
                                        if (th == null) {
                                            return makeNode;
                                        }
                                        disposableHandle = makeNode;
                                    }
                                }
                                ur2 ur2 = ur2.INSTANCE;
                            }
                        }
                        if (th != null) {
                            if (z2) {
                                function1.invoke(th);
                            }
                            return disposableHandle;
                        } else if (addLastAtomic(state$kotlinx_coroutines_core, list, makeNode)) {
                            return makeNode;
                        }
                    }
                } else {
                    if (z2) {
                        hl hlVar = state$kotlinx_coroutines_core instanceof hl ? (hl) state$kotlinx_coroutines_core : null;
                        if (hlVar != null) {
                            th = hlVar.a;
                        }
                        function1.invoke(th);
                    }
                    return zi1.INSTANCE;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public Job plus(@NotNull Job job) {
        return Job.a.h(this, job);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable th) {
        Throwable th2;
        if (th == null) {
            th2 = new JobCancellationException(cancellationExceptionMessage(), null, this);
        } else {
            th2 = toCancellationException$default(this, th, null, 1, null);
        }
        cancelInternal(th2);
        return true;
    }
}
