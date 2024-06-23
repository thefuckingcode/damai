package kotlinx.coroutines.internal;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.c90;
import tb.il;
import tb.jh2;
import tb.jl1;
import tb.k12;
import tb.k21;
import tb.kl;
import tb.n30;
import tb.ok2;
import tb.or2;
import tb.q30;
import tb.qn;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010=\u001a\u00020<\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bN\u0010OJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001dH\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010#\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$JH\u0010)\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2%\b\b\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000f\u0018\u00010%H\bø\u0001\u0000¢\u0006\u0004\b)\u0010*J!\u0010.\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u0017H\u0010¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u001dH\b¢\u0006\u0004\b0\u00101J!\u00102\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\bø\u0001\u0000¢\u0006\u0004\b2\u0010$J\u001f\u00108\u001a\u00020\u000f2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00028\u0000H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010?R\u001e\u0010@\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u000e¢\u0006\f\n\u0004\b@\u0010A\u0012\u0004\bB\u0010\u0011R\u0016\u0010C\u001a\u00020\u001d8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\bC\u0010AR\u0016\u00104\u001a\u0002038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001e\u0010H\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0019\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8F@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010\u0014R\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "requester", "", "isReusable", "(Lkotlinx/coroutines/CancellableContinuationImpl;)Z", "Ltb/ur2;", "awaitReusability", "()V", "release", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "cause", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/Continuation;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "countOrElement", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getReusableCancellableContinuation", "reusableCancellableContinuation", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    @NotNull
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;
    @JvmField
    @Nullable
    public Object _state = c90.a();
    @JvmField
    @NotNull
    public final Continuation<T> continuation;
    @JvmField
    @NotNull
    public final Object countOrElement = ThreadContextKt.b(getContext());
    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation2) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation2;
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    public final void awaitReusability() {
        do {
        } while (this._reusableCancellableContinuation == c90.REUSABLE_CLAIMED);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof il) {
            ((il) obj).b.invoke(th);
        }
    }

    @Nullable
    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = c90.REUSABLE_CLAIMED;
                return null;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, c90.REUSABLE_CLAIMED)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != c90.REUSABLE_CLAIMED && !(obj instanceof Throwable)) {
                throw new IllegalStateException(k21.r("Inconsistent state ", obj).toString());
            }
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(@NotNull CoroutineContext coroutineContext, T t) {
        this._state = t;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation2 = this.continuation;
        if (continuation2 instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation2;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Nullable
    public final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isReusable(@NotNull CancellableContinuationImpl<?> cancellableContinuationImpl) {
        Object obj = this._reusableCancellableContinuation;
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CancellableContinuationImpl) || obj == cancellableContinuationImpl) {
            return true;
        }
        return false;
    }

    public final boolean postponeCancellation(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            jh2 jh2 = c90.REUSABLE_CLAIMED;
            if (k21.d(obj, jh2)) {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, jh2, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void release() {
        awaitReusability();
        CancellableContinuationImpl<?> reusableCancellableContinuation = getReusableCancellableContinuation();
        if (reusableCancellableContinuation != null) {
            reusableCancellableContinuation.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void resumeCancellableWith(@NotNull Object obj, @Nullable Function1<? super Throwable, ur2> function1) {
        boolean z;
        Object b = kl.b(obj, function1);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = b;
            this.resumeMode = 1;
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        n30.a();
        k b2 = ok2.INSTANCE.b();
        if (b2.isUnconfinedLoopActive()) {
            this._state = b;
            this.resumeMode = 1;
            b2.dispatchUnconfined(this);
            return;
        }
        b2.incrementUseCount(true);
        try {
            Job job = (Job) getContext().get(Job.Key);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(b, cancellationException);
                Result.a aVar = Result.Companion;
                resumeWith(Result.m913constructorimpl(k12.a(cancellationException)));
                z = true;
            }
            if (!z) {
                Continuation<T> continuation2 = this.continuation;
                Object obj2 = this.countOrElement;
                CoroutineContext context = continuation2.getContext();
                Object c = ThreadContextKt.c(context, obj2);
                or2<?> e = c != ThreadContextKt.NO_THREAD_ELEMENTS ? qn.e(continuation2, context, c) : null;
                try {
                    this.continuation.resumeWith(obj);
                    ur2 ur2 = ur2.INSTANCE;
                } finally {
                    b11.b(1);
                    if (e == null || e.a()) {
                        ThreadContextKt.a(context, c);
                    }
                    b11.a(1);
                }
            }
            do {
            } while (b2.processUnconfinedEvent());
            b11.b(1);
        } catch (Throwable th) {
            b11.b(1);
            b2.decrementUseCount(true);
            b11.a(1);
            throw th;
        }
        b2.decrementUseCount(true);
        b11.a(1);
    }

    public final boolean resumeCancelled(@Nullable Object obj) {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null || job.isActive()) {
            return false;
        }
        CancellationException cancellationException = job.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
        Result.a aVar = Result.Companion;
        resumeWith(Result.m913constructorimpl(k12.a(cancellationException)));
        return true;
    }

    public final void resumeUndispatchedWith(@NotNull Object obj) {
        Continuation<T> continuation2 = this.continuation;
        Object obj2 = this.countOrElement;
        CoroutineContext context = continuation2.getContext();
        Object c = ThreadContextKt.c(context, obj2);
        or2<?> e = c != ThreadContextKt.NO_THREAD_ELEMENTS ? qn.e(continuation2, context, c) : null;
        try {
            this.continuation.resumeWith(obj);
            ur2 ur2 = ur2.INSTANCE;
        } finally {
            b11.b(1);
            if (e == null || e.a()) {
                ThreadContextKt.a(context, c);
            }
            b11.a(1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        CoroutineContext context = this.continuation.getContext();
        Object d = kl.d(obj, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = d;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        n30.a();
        k b = ok2.INSTANCE.b();
        if (b.isUnconfinedLoopActive()) {
            this._state = d;
            this.resumeMode = 0;
            b.dispatchUnconfined(this);
            return;
        }
        b.incrementUseCount(true);
        try {
            CoroutineContext context2 = getContext();
            Object c = ThreadContextKt.c(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(obj);
                ur2 ur2 = ur2.INSTANCE;
                do {
                } while (b.processUnconfinedEvent());
                b.decrementUseCount(true);
            } finally {
                ThreadContextKt.a(context2, c);
            }
        } catch (Throwable th) {
            b.decrementUseCount(true);
            throw th;
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        if (n30.a()) {
            if (!(obj != c90.a())) {
                throw new AssertionError();
            }
        }
        this._state = c90.a();
        return obj;
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + AVFSCacheConstants.COMMA_SEP + q30.c(this.continuation) + jl1.ARRAY_END;
    }

    @Nullable
    public final Throwable tryReleaseClaimedContinuation(@NotNull CancellableContinuation<?> cancellableContinuation) {
        jh2 jh2;
        do {
            Object obj = this._reusableCancellableContinuation;
            jh2 = c90.REUSABLE_CLAIMED;
            if (obj != jh2) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(k21.r("Inconsistent state ", obj).toString());
                } else if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, jh2, cancellableContinuation));
        return null;
    }
}
