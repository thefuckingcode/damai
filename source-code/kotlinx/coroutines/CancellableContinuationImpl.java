package kotlinx.coroutines;

import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d90;
import tb.hb;
import tb.hf;
import tb.hl;
import tb.jf;
import tb.jh2;
import tb.k21;
import tb.kl;
import tb.n30;
import tb.nf;
import tb.q30;
import tb.sd2;
import tb.sn;
import tb.th;
import tb.ur2;
import tb.zi1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000t\u0012\u0006\u0010-\u001a\u00020'¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\b¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u0017\u001a\u00020\u000e2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u00152\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJB\u0010\"\u001a\u00020\u000e2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u00152\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J8\u0010%\u001a\u00020$2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u0015H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*JZ\u00100\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020'2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\b\u0010/\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b0\u00101JH\u00102\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020'2%\b\u0002\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0004\b2\u00103JJ\u00105\u001a\u0004\u0018\u0001042\b\u0010,\u001a\u0004\u0018\u00010 2\b\u0010/\u001a\u0004\u0018\u00010 2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u0002072\b\u0010,\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u001fJ\u000f\u0010;\u001a\u00020\u000eH\u0016¢\u0006\u0004\b;\u0010\u001fJ\u000f\u0010<\u001a\u00020\u0006H\u0001¢\u0006\u0004\b<\u0010\bJ\u0017\u0010?\u001a\n\u0018\u00010=j\u0004\u0018\u0001`>H\u0016¢\u0006\u0004\b?\u0010@J\u0011\u0010C\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\bA\u0010BJ!\u0010G\u001a\u00020\u000e2\b\u0010D\u001a\u0004\u0018\u00010 2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bH\u0010\fJ\u0017\u0010K\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\bI\u0010JJ\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010LJ8\u0010M\u001a\u00020\u000e2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bM\u0010\u0018J\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u0011\u0010R\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\bR\u0010BJ \u0010U\u001a\u00020\u000e2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000SH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ<\u0010X\u001a\u00020\u000e2\u0006\u0010W\u001a\u00028\u00002#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0016¢\u0006\u0004\bX\u0010YJ8\u0010Z\u001a\u00020\u000e2'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0012j\u0002`\u0015H\u0016¢\u0006\u0004\bZ\u0010[J\u000f\u0010]\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\\\u0010\u001fJ#\u0010\u001a\u001a\u0004\u0018\u00010 2\u0006\u0010W\u001a\u00028\u00002\b\u0010/\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\u001a\u0010^JH\u0010\u001a\u001a\u0004\u0018\u00010 2\u0006\u0010W\u001a\u00028\u00002\b\u0010/\u001a\u0004\u0018\u00010 2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010_J\u0019\u0010a\u001a\u0004\u0018\u00010 2\u0006\u0010`\u001a\u00020\tH\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020 H\u0016¢\u0006\u0004\bd\u0010VJ\u001b\u0010f\u001a\u00020\u000e*\u00020e2\u0006\u0010W\u001a\u00028\u0000H\u0016¢\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u00020\u000e*\u00020e2\u0006\u0010`\u001a\u00020\tH\u0016¢\u0006\u0004\bh\u0010iJ\u001f\u0010l\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010!\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\bj\u0010kJ\u001b\u0010o\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\bm\u0010nJ\u000f\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020pH\u0014¢\u0006\u0004\bs\u0010rR\"\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000t8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001c\u0010z\u001a\u00020y8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010R\u0018\u0010\u0001\u001a\u00020p8B@\u0002X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010rR\u0019\u0010!\u001a\u0004\u0018\u00010 8@@\u0000X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010BR\u0018\u0010\u0001\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR\u0018\u0010\u0001\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR\u0018\u0010\u0001\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR!\u0010\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058V@\u0016X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "isReusable", "()Z", "", "cause", "cancelLater", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", "Ltb/ur2;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "callCancelHandler", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "trySuspend", "tryResume", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "releaseClaimedReusableContinuation", "()V", "", "state", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "Ltb/hf;", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Ltb/hf;", "", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Ltb/jh2;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ltb/jh2;", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "detachChildIfNonResuable", "initCancellability", "resetStateReusable", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancel", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "(Ltb/hf;Ljava/lang/Throwable;)V", "callOnCancellation", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "detachChild$kotlinx_coroutines_core", "detachChild", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "nameString", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getStateDebugRepresentation", "stateDebugRepresentation", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@PublishedApi
/* compiled from: Taobao */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    @NotNull
    private volatile /* synthetic */ int _decision;
    @NotNull
    private volatile /* synthetic */ Object _state;
    @NotNull
    private final CoroutineContext context;
    @NotNull
    private final Continuation<T> delegate;
    @Nullable
    private DisposableHandle parentHandle;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        if (n30.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.context = continuation.getContext();
        this._decision = 0;
        this._state = b.INSTANCE;
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(k21.r("Already resumed, but proposed with update ", obj).toString());
    }

    private final void callCancelHandlerSafely(Function0<ur2> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            sn.a(getContext(), new CompletionHandlerException(k21.r("Exception in invokeOnCancellation handler for ", this), th));
        }
    }

    private final boolean cancelLater(Throwable th) {
        if (d90.c(this.resumeMode) && isReusable()) {
            return ((DispatchedContinuation) this.delegate).postponeCancellation(th);
        }
        return false;
    }

    private final void detachChildIfNonResuable() {
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int i) {
        if (!tryResume()) {
            d90.a(this, i);
        }
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof NotCompleted) {
            return "Active";
        }
        return state$kotlinx_coroutines_core instanceof nf ? "Cancelled" : "Completed";
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null) {
            return null;
        }
        DisposableHandle e = Job.a.e(job, true, false, new th(this), 2, null);
        this.parentHandle = e;
        return e;
    }

    private final boolean isReusable() {
        Continuation<T> continuation = this.delegate;
        return (continuation instanceof DispatchedContinuation) && ((DispatchedContinuation) continuation).isReusable(this);
    }

    private final hf makeCancelHandler(Function1<? super Throwable, ur2> function1) {
        return function1 instanceof hf ? (hf) function1 : new n(function1);
    }

    private final void multipleHandlersError(Function1<? super Throwable, ur2> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void releaseClaimedReusableContinuation() {
        Continuation<T> continuation = this.delegate;
        Throwable th = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            th = dispatchedContinuation.tryReleaseClaimedContinuation(this);
        }
        if (th != null) {
            detachChild$kotlinx_coroutines_core();
            cancel(th);
        }
    }

    private final void resumeImpl(Object obj, int i, Function1<? super Throwable, ur2> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof nf) {
                    nf nfVar = (nf) obj2;
                    if (nfVar.c()) {
                        if (function1 != null) {
                            callOnCancellation(function1, nfVar.a);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(obj);
                throw new KotlinNothingValueException();
            }
        } while (!_state$FU.compareAndSet(this, obj2, resumedState((NotCompleted) obj2, obj, i, function1, null)));
        detachChildIfNonResuable();
        dispatchResume(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.CancellableContinuationImpl */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.resumeImpl(obj, i, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object resumedState(NotCompleted notCompleted, Object obj, int i, Function1<? super Throwable, ur2> function1, Object obj2) {
        if (obj instanceof hl) {
            boolean z = true;
            if (n30.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!n30.a()) {
                return obj;
            }
            if (function1 != null) {
                z = false;
            }
            if (z) {
                return obj;
            }
            throw new AssertionError();
        } else if (!d90.b(i) && obj2 == null) {
            return obj;
        } else {
            if (function1 == null && ((!(notCompleted instanceof hf) || (notCompleted instanceof hb)) && obj2 == null)) {
                return obj;
            }
            return new h(obj, notCompleted instanceof hf ? (hf) notCompleted : null, function1, obj2, null, 16, null);
        }
    }

    private final jh2 tryResumeImpl(Object obj, Object obj2, Function1<? super Throwable, ur2> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof h) || obj2 == null) {
                return null;
            } else {
                h hVar = (h) obj3;
                if (hVar.d != obj2) {
                    return null;
                }
                if (!n30.a() || k21.d(hVar.a, obj)) {
                    return jf.RESUME_TOKEN;
                }
                throw new AssertionError();
            }
        } while (!_state$FU.compareAndSet(this, obj3, resumedState((NotCompleted) obj3, obj, this.resumeMode, function1, obj2)));
        detachChildIfNonResuable();
        return jf.RESUME_TOKEN;
    }

    private final boolean trySuspend() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    public final void callCancelHandler(@NotNull hf hfVar, @Nullable Throwable th) {
        try {
            hfVar.a(th);
        } catch (Throwable th2) {
            sn.a(getContext(), new CompletionHandlerException(k21.r("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void callOnCancellation(@NotNull Function1<? super Throwable, ur2> function1, @NotNull Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            sn.a(getContext(), new CompletionHandlerException(k21.r("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof hf;
        } while (!_state$FU.compareAndSet(this, obj, new nf(this, th, z)));
        hf hfVar = z ? (hf) obj : null;
        if (hfVar != null) {
            callCancelHandler(hfVar, th);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof hl)) {
                if (obj2 instanceof h) {
                    h hVar = (h) obj2;
                    if (!hVar.c()) {
                        if (_state$FU.compareAndSet(this, obj2, h.b(hVar, null, null, null, null, th, 15, null))) {
                            hVar.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (_state$FU.compareAndSet(this, obj2, new h(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@NotNull Object obj) {
        if (n30.a()) {
            if (!(obj == jf.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
            this.parentHandle = zi1.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job job) {
        return job.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            return null;
        }
        Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
        return (!n30.d() || !(delegate$kotlinx_coroutines_core instanceof CoroutineStackFrame)) ? exceptionalResult$kotlinx_coroutines_core : sd2.a(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame) delegate$kotlinx_coroutines_core);
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Job job;
        boolean isReusable = isReusable();
        if (trySuspend()) {
            if (this.parentHandle == null) {
                installParentHandle();
            }
            if (isReusable) {
                releaseClaimedReusableContinuation();
            }
            return b.d();
        }
        if (isReusable) {
            releaseClaimedReusableContinuation();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof hl) {
            Throwable th = ((hl) state$kotlinx_coroutines_core).a;
            if (n30.d()) {
                throw sd2.a(th, this);
            }
            throw th;
        } else if (!d90.b(this.resumeMode) || (job = (Job) getContext().get(Job.Key)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        } else {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            if (n30.d()) {
                throw sd2.a(cancellationException, this);
            }
            throw cancellationException;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj instanceof h ? (T) ((h) obj).a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle installParentHandle = installParentHandle();
        if (installParentHandle != null && isCompleted()) {
            installParentHandle.dispose();
            this.parentHandle = zi1.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, ur2> function1) {
        hf makeCancelHandler = makeCancelHandler(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                if (_state$FU.compareAndSet(this, obj, makeCancelHandler)) {
                    return;
                }
            } else if (obj instanceof hf) {
                multipleHandlersError(function1, obj);
            } else {
                boolean z = obj instanceof hl;
                if (z) {
                    hl hlVar = (hl) obj;
                    if (!hlVar.b()) {
                        multipleHandlersError(function1, obj);
                    }
                    if (obj instanceof nf) {
                        Throwable th = null;
                        if (!z) {
                            hlVar = null;
                        }
                        if (hlVar != null) {
                            th = hlVar.a;
                        }
                        callCancelHandler(function1, th);
                        return;
                    }
                    return;
                } else if (obj instanceof h) {
                    h hVar = (h) obj;
                    if (hVar.b != null) {
                        multipleHandlersError(function1, obj);
                    }
                    if (!(makeCancelHandler instanceof hb)) {
                        if (hVar.c()) {
                            callCancelHandler(function1, hVar.e);
                            return;
                        }
                        if (_state$FU.compareAndSet(this, obj, h.b(hVar, null, makeCancelHandler, null, null, null, 29, null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(makeCancelHandler instanceof hb)) {
                    if (_state$FU.compareAndSet(this, obj, new h(obj, makeCancelHandler, null, null, null, 28, null))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof nf;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable th) {
        if (!cancelLater(th)) {
            cancel(th);
            detachChildIfNonResuable();
        }
    }

    @JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        if (n30.a()) {
            if (!(this.resumeMode == 2)) {
                throw new AssertionError();
            }
        }
        if (n30.a()) {
            if (!(this.parentHandle != zi1.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (n30.a() && !(!(obj instanceof NotCompleted))) {
            throw new AssertionError();
        } else if (!(obj instanceof h) || ((h) obj).d == null) {
            this._decision = 0;
            this._state = b.INSTANCE;
            return true;
        } else {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t, @Nullable Function1<? super Throwable, ur2> function1) {
        resumeImpl(t, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.delegate;
        CoroutineDispatcher coroutineDispatcher2 = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl$default(this, t, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Continuation<T> continuation = this.delegate;
        CoroutineDispatcher coroutineDispatcher2 = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        hl hlVar = new hl(th, false, 2, null);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl$default(this, hlVar, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        resumeImpl$default(this, kl.c(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @NotNull
    public String toString() {
        return nameString() + '(' + q30.c(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + q30.b(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T t, @Nullable Object obj) {
        return tryResumeImpl(t, obj, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable th) {
        return tryResumeImpl(new hl(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, ur2> function1) {
        return tryResumeImpl(t, obj, function1);
    }

    private final boolean tryResume() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final void callCancelHandler(Function1<? super Throwable, ur2> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            sn.a(getContext(), new CompletionHandlerException(k21.r("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }
}
