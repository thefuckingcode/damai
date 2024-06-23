package kotlinx.coroutines.experimental;

import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.SequenceBuilderKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import kotlinx.coroutines.experimental.intrinsics.CancellableKt;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectClause0;
import kotlinx.coroutines.experimental.selects.SelectInstance;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0002J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0001J\u0015\u00101\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u00103J\u0012\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010#H\u0016J\u0010\u00107\u001a\u0002082\b\u00106\u001a\u0004\u0018\u00010#J\u001c\u00109\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010;\u001a\u0002082\u0006\u0010*\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\u0017H\u0002J\u001f\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bAJ\u001a\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010@2\u0006\u0010\u001f\u001a\u00020'H\u0002J\n\u0010F\u001a\u00060Gj\u0002`HJ\u000f\u0010I\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bJJ\n\u0010K\u001a\u0004\u0018\u00010#H\u0004J\b\u0010L\u001a\u0004\u0018\u00010#J\u0015\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020#H\u0010¢\u0006\u0002\bOJ\u0017\u0010P\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0002\bQJ\u0017\u0010R\u001a\u0002082\b\u0010S\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\bTJA\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00042'\u0010X\u001a#\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002080Yj\u0002`\\H\u0016J7\u0010U\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020\u00042'\u0010X\u001a#\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002080Yj\u0002`\\J/\u0010U\u001a\u00020\u001e2'\u0010X\u001a#\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002080Yj\u0002`\\J7\u0010U\u001a\u00020\u001e2'\u0010X\u001a#\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002080Yj\u0002`\\2\u0006\u0010V\u001a\u00020\u0004J\u001a\u0010^\u001a\u00020\u00042\u0006\u0010D\u001a\u00020C2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0002J\u0011\u0010_\u001a\u000208H@ø\u0001\u0000¢\u0006\u0002\u00103J\b\u0010`\u001a\u00020\u0004H\u0002J\u0011\u0010a\u001a\u000208H@ø\u0001\u0000¢\u0006\u0002\u00103J\u001f\u0010b\u001a\u00020c2\u0014\u0010d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u0002080YH\bJ\u0012\u0010e\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010#H\u0002J\u0017\u0010f\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bgJ\u001a\u0010h\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0012\u0010i\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010#H\u0002J\u001f\u0010j\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\u0017H\u0000¢\u0006\u0002\bkJ=\u0010l\u001a\u0006\u0012\u0002\b\u00030.2'\u0010X\u001a#\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002080Yj\u0002`\\2\u0006\u0010V\u001a\u00020\u0004H\u0002J\r\u0010m\u001a\u00020nH\u0010¢\u0006\u0002\boJ\u001a\u0010p\u001a\u0002082\u0006\u0010+\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010#H\u0002J+\u0010q\u001a\u000208\"\u000e\b\u0000\u0010r\u0018\u0001*\u0006\u0012\u0002\b\u00030.2\u0006\u0010+\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010#H\bJ\u0017\u0010s\u001a\u0002082\b\u0010t\u001a\u0004\u0018\u00010uH\u0010¢\u0006\u0002\bvJ\u001f\u0010w\u001a\u0002082\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\u0017H\u0010¢\u0006\u0002\bxJ\u0017\u0010y\u001a\u0002082\b\u0010<\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0002\bzJ\r\u0010{\u001a\u000208H\u0010¢\u0006\u0002\b|J\u0010\u0010}\u001a\u0002082\u0006\u0010\u001f\u001a\u00020~H\u0002J\u0014\u0010\u001a\u0002082\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030.H\u0002JH\u0010\u0001\u001a\u000208\"\u0005\b\u0000\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012\u001e\u0010d\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0Yø\u0001\u0000¢\u0006\u0003\u0010\u0001JZ\u0010\u0001\u001a\u000208\"\u0004\b\u0000\u0010r\"\u0005\b\u0001\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012%\u0010d\u001a!\b\u0001\u0012\u0004\u0012\u0002Hr\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u0002082\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0000¢\u0006\u0003\b\u0001JZ\u0010\u0001\u001a\u000208\"\u0004\b\u0000\u0010r\"\u0005\b\u0001\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012%\u0010d\u001a!\b\u0001\u0012\u0004\u0012\u0002Hr\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u0004J\u0013\u0010\u0001\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0002J\t\u0010\u0001\u001a\u00020nH\u0002J\t\u0010\u0001\u001a\u00020nH\u0016J#\u0010\u0001\u001a\u00020\u00042\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010#H\u0002J\u001b\u0010\u0001\u001a\u00020\u00042\u0006\u0010*\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u0001\u001a\u00020\u00042\u0006\u00100\u001a\u00020@2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0010J#\u0010\u0001\u001a\u00020\u00042\u0006\u0010*\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\u0017H\u0002J\u001b\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020'2\b\u00106\u001a\u0004\u0018\u00010#H\u0002J\u0016\u0010\u0001\u001a\u000208*\u00020@2\u0006\u00106\u001a\u00020#H\u0010J\u0010\u0010\u0001\u001a\u0004\u0018\u00010@*\u00030\u0001H\u0002J\u0017\u0010\u0001\u001a\u000208*\u00020,2\b\u00106\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010\u0001\u001a\u00060Gj\u0002`H*\u00020#2\u0007\u0010\u0001\u001a\u00020nH\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\b8@X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#*\u0004\u0018\u00010\b8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u0004*\u00020'8BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(\u0002\u0004\n\u0002\b\t¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport;", "Lkotlinx/coroutines/experimental/Job;", "Lkotlinx/coroutines/experimental/selects/SelectClause0;", "active", "", "(Z)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "()Z", "isCancelled", "isCompleted", "isCompletedExceptionally", CacheEntity.KEY, "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "onCancelMode", "", "getOnCancelMode$kotlinx_coroutines_core", "()I", "onJoin", "getOnJoin", "()Lkotlinx/coroutines/experimental/selects/SelectClause0;", "parentHandle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/experimental/Incomplete;", "(Lkotlinx/coroutines/experimental/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/experimental/NodeList;", "node", "Lkotlinx/coroutines/experimental/JobNode;", "attachChild", "child", "awaitInternal", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "cause", "cancelChildren", "", "coerceProposedUpdate", "proposedUpdate", "completeUpdateState", "update", "mode", "continueCompleting", "lastChild", "Lkotlinx/coroutines/experimental/ChildJob;", "continueCompleting$kotlinx_coroutines_core", "createCancelled", "Lkotlinx/coroutines/experimental/Cancelled;", "cancelled", "firstChild", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/experimental/CancellationException;", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionCause", "getCompletionExceptionOrNull", "handleException", "exception", "handleException$kotlinx_coroutines_core", "hasOnFinishingHandler", "hasOnFinishingHandler$kotlinx_coroutines_core", "initParentJobInternal", "parent", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCompletion", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "Lkotlinx/coroutines/experimental/CompletionHandler;", "onCancelling_", "isCorrespondinglyCancelled", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingInternal", "makeCompletingOnCancel", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "", "nameString$kotlinx_coroutines_core", "notifyCancellation", "notifyHandlers", "T", "onCancellationInternal", "exceptionally", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "onCancellationInternal$kotlinx_coroutines_core", "onCompletionInternal", "onCompletionInternal$kotlinx_coroutines_core", "onFinishingInternal", "onFinishingInternal$kotlinx_coroutines_core", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "promoteEmptyToNodeList", "Lkotlinx/coroutines/experimental/Empty;", "promoteSingleToNodeList", "registerSelectClause0", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "registerSelectClause1Internal", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "removeNode", "removeNode$kotlinx_coroutines_core", "selectAwaitCompletion", "selectAwaitCompletion$kotlinx_coroutines_core", "start", "startInternal", "stateString", "toString", "tryMakeCancelling", "tryUpdateState", "tryWaitForChild", "updateState", "updateStateCancelled", "cancelChildrenInternal", "nextChild", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "message", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: JobSupport.kt */
public class JobSupport implements Job, SelectClause0 {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile Object _state;
    private volatile DisposableHandle parentHandle;

    public int getOnCancelMode$kotlinx_coroutines_core() {
        return 0;
    }

    public boolean hasOnFinishingHandler$kotlinx_coroutines_core(Object obj) {
        return false;
    }

    public void onCancellationInternal$kotlinx_coroutines_core(CompletedExceptionally completedExceptionally) {
    }

    public void onCompletionInternal$kotlinx_coroutines_core(Object obj, int i) {
    }

    public void onFinishingInternal$kotlinx_coroutines_core(Object obj) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.access$getEmptyActive$p() : JobSupportKt.access$getEmptyNew$p();
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element, kotlin.coroutines.experimental.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element, kotlin.coroutines.experimental.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.experimental.Job
    @Deprecated(message = "Renamed to getCancellationException", replaceWith = @ReplaceWith(expression = "getCancellationException()", imports = {}))
    public Throwable getCompletionException() {
        return Job.DefaultImpls.getCompletionException(this);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element, kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkParameterIsNotNull(key, CacheEntity.KEY);
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.experimental.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job job) {
        Intrinsics.checkParameterIsNotNull(job, "other");
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlin.coroutines.experimental.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(Job job) {
        if (!(this.parentHandle == null)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (job == null) {
            this.parentHandle = NonDisposableHandle.INSTANCE;
        } else {
            job.start();
            DisposableHandle attachChild = job.attachChild(this);
            this.parentHandle = attachChild;
            if (isCompleted()) {
                attachChild.dispose();
                this.parentHandle = NonDisposableHandle.INSTANCE;
            }
        }
    }

    private final Void loopOnState(Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(getState$kotlinx_coroutines_core());
        }
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Cancelled) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).cancelled != null);
    }

    private final boolean updateState(Incomplete incomplete, Object obj, int i) {
        Object coerceProposedUpdate = coerceProposedUpdate(incomplete, obj);
        if (!tryUpdateState(incomplete, coerceProposedUpdate)) {
            return false;
        }
        completeUpdateState(incomplete, coerceProposedUpdate, i);
        return true;
    }

    private final Object coerceProposedUpdate(Incomplete incomplete, Object obj) {
        if (!(incomplete instanceof Finishing)) {
            return obj;
        }
        Finishing finishing = (Finishing) incomplete;
        return (finishing.cancelled == null || isCorrespondinglyCancelled(finishing.cancelled, obj)) ? obj : createCancelled(finishing.cancelled, obj);
    }

    private final boolean isCorrespondinglyCancelled(Cancelled cancelled, Object obj) {
        if (!(obj instanceof Cancelled)) {
            return false;
        }
        Cancelled cancelled2 = (Cancelled) obj;
        if (Intrinsics.areEqual(cancelled2.cause, cancelled.cause) || (cancelled2.cause instanceof JobCancellationException)) {
            return true;
        }
        return false;
    }

    private final Cancelled createCancelled(Cancelled cancelled, Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            return cancelled;
        }
        Throwable th = ((CompletedExceptionally) obj).cause;
        if (Intrinsics.areEqual(cancelled.cause, th)) {
            return cancelled;
        }
        if (!(cancelled.cause instanceof JobCancellationException)) {
            ExceptionsKt.addSuppressed(th, cancelled.cause);
        }
        return new Cancelled(this, th);
    }

    private final boolean tryUpdateState(Incomplete incomplete, Object obj) {
        if (!(!(obj instanceof Incomplete))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!_state$FU.compareAndSet(this, incomplete, obj)) {
            return false;
        } else {
            DisposableHandle disposableHandle = this.parentHandle;
            if (disposableHandle != null) {
                disposableHandle.dispose();
                this.parentHandle = NonDisposableHandle.INSTANCE;
            }
            return true;
        }
    }

    private final void completeUpdateState(Incomplete incomplete, Object obj, int i) {
        Throwable th = null;
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
        if (!isCancelling(incomplete)) {
            onCancellationInternal$kotlinx_coroutines_core(completedExceptionally);
        }
        onCompletionInternal$kotlinx_coroutines_core(obj, i);
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
            } catch (Throwable th2) {
                handleException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList list = incomplete.getList();
            if (list != null) {
                notifyCompletion(list, th);
            }
        }
    }

    private final <T extends JobNode<?>> void notifyHandlers(NodeList nodeList, Throwable th) {
        Throwable th2 = null;
        Object next = nodeList.getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        th2 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                    }
                }
            }
            if (th2 != null) {
                handleException$kotlinx_coroutines_core(th2);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    private final int startInternal(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!_state$FU.compareAndSet(this, obj, JobSupportKt.access$getEmptyActive$p())) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        } else if (!(obj instanceof NodeList)) {
            return 0;
        } else {
            int tryMakeActive = ((NodeList) obj).tryMakeActive();
            if (tryMakeActive == 1) {
                onStartInternal$kotlinx_coroutines_core();
            }
            return tryMakeActive;
        }
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Finishing finishing = (Finishing) state$kotlinx_coroutines_core;
            if (finishing.cancelled != null) {
                return toCancellationException(finishing.cancelled.cause, "Job is being cancelled");
            }
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job was not completed or cancelled yet: " + this).toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause, "Job has failed");
        } else {
            return new JobCancellationException("Job has completed normally", null, this);
        }
    }

    private final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        return cancellationException != null ? cancellationException : new JobCancellationException(str, th, this);
    }

    /* access modifiers changed from: protected */
    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Finishing finishing = (Finishing) state$kotlinx_coroutines_core;
            if (finishing.cancelled != null) {
                return finishing.cancelled.cause;
            }
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException("Job was not completed or cancelled yet".toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            return null;
        }
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final /* synthetic */ DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1, boolean z) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return invokeOnCompletion(z, true, function1);
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final DisposableHandle invokeOnCompletion(boolean z, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return invokeOnCompletion(z, true, function1);
    }

    @Override // kotlinx.coroutines.experimental.Job
    public DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        Throwable th = null;
        JobNode<?> jobNode = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive()) {
                    if (jobNode == null) {
                        jobNode = makeNode(function1, z);
                    }
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, jobNode)) {
                        return jobNode;
                    }
                } else {
                    promoteEmptyToNodeList(empty);
                }
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    if (state$kotlinx_coroutines_core instanceof Finishing) {
                        Finishing finishing = (Finishing) state$kotlinx_coroutines_core;
                        if (finishing.cancelled != null && z) {
                            if (z2) {
                                function1.invoke(finishing.cancelled.cause);
                            }
                            return NonDisposableHandle.INSTANCE;
                        }
                    }
                    if (jobNode == null) {
                        jobNode = makeNode(function1, z);
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                        return jobNode;
                    }
                } else if (state$kotlinx_coroutines_core != null) {
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.JobNode<*>");
                }
            } else {
                if (z2) {
                    if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                        state$kotlinx_coroutines_core = null;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
                    if (completedExceptionally != null) {
                        th = completedExceptionally.cause;
                    }
                    function1.invoke(th);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    private final JobNode<?> makeNode(Function1<? super Throwable, Unit> function1, boolean z) {
        boolean z2 = true;
        JobCancellationNode jobCancellationNode = null;
        if (z) {
            if (function1 instanceof JobCancellationNode) {
                jobCancellationNode = function1;
            }
            JobCancellationNode jobCancellationNode2 = jobCancellationNode;
            if (jobCancellationNode2 != null) {
                if (jobCancellationNode2.job != this) {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                } else if (jobCancellationNode2 != null) {
                    return jobCancellationNode2;
                }
            }
            return new InvokeOnCancellation(this, function1);
        }
        if (function1 instanceof JobNode) {
            jobCancellationNode = function1;
        }
        JobNode<?> jobNode = jobCancellationNode;
        if (jobNode != null) {
            if (jobNode.job != this || (jobNode instanceof JobCancellationNode)) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (jobNode != null) {
                return jobNode;
            }
        }
        return new InvokeOnCompletion(this, function1);
    }

    private final void promoteEmptyToNodeList(Empty empty) {
        _state$FU.compareAndSet(this, empty, new NodeList(empty.isActive()));
    }

    private final void promoteSingleToNodeList(JobNode<?> jobNode) {
        jobNode.addOneIfEmpty(new NodeList(true));
        _state$FU.compareAndSet(this, jobNode, jobNode.getNextNode());
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final Object join(Continuation<? super Unit> continuation) {
        if (joinInternal()) {
            return joinSuspend(continuation);
        }
        YieldKt.checkCompletion(CoroutineIntrinsics.normalizeContinuation(continuation).getContext());
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final SelectClause0 getOnJoin() {
        return this;
    }

    @Override // kotlinx.coroutines.experimental.Job
    public boolean cancel(Throwable th) {
        int onCancelMode$kotlinx_coroutines_core = getOnCancelMode$kotlinx_coroutines_core();
        if (onCancelMode$kotlinx_coroutines_core == 0) {
            return makeCancelling(th);
        }
        if (onCancelMode$kotlinx_coroutines_core == 1) {
            return makeCompletingOnCancel(th);
        }
        throw new IllegalStateException(("Invalid onCancelMode " + getOnCancelMode$kotlinx_coroutines_core()).toString());
    }

    private final boolean updateStateCancelled(Incomplete incomplete, Throwable th) {
        return updateState(incomplete, new Cancelled(this, th), 0);
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, NodeList nodeList, Throwable th) {
        Cancelled cancelled = new Cancelled(this, th);
        if (!_state$FU.compareAndSet(this, incomplete, new Finishing(nodeList, cancelled, false))) {
            return false;
        }
        onFinishingInternal$kotlinx_coroutines_core(cancelled);
        onCancellationInternal$kotlinx_coroutines_core(cancelled);
        notifyCancellation(nodeList, th);
        return true;
    }

    private final boolean makeCompletingOnCancel(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new Cancelled(this, th));
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        return makeCompletingInternal(obj, 0) != 0;
    }

    public final boolean makeCompletingOnce$kotlinx_coroutines_core(Object obj, int i) {
        int makeCompletingInternal = makeCompletingInternal(obj, i);
        if (makeCompletingInternal == 1) {
            return true;
        }
        if (makeCompletingInternal == 2) {
            return false;
        }
        throw new IllegalStateException("Job " + this + " is already complete or completing, " + "but is being completed with " + obj, getExceptionOrNull(obj));
    }

    private final void cancelChildrenInternal(ChildJob childJob, Throwable th) {
        do {
            childJob.childJob.cancel(new JobCancellationException("Child job was cancelled because of parent failure", th, childJob.childJob));
            childJob = nextChild(childJob);
        } while (childJob != null);
    }

    private final Throwable getExceptionOrNull(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildJob firstChild(Incomplete incomplete) {
        ChildJob childJob = (ChildJob) (!(incomplete instanceof ChildJob) ? null : incomplete);
        if (childJob != null) {
            return childJob;
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final boolean tryWaitForChild(ChildJob childJob, Object obj) {
        while (Job.DefaultImpls.invokeOnCompletion$default(childJob.childJob, false, false, new ChildCompletion(this, childJob, obj), 1, null) == NonDisposableHandle.INSTANCE) {
            childJob = nextChild(childJob);
            if (childJob == null) {
                return false;
            }
        }
        return true;
    }

    private final ChildJob nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildJob) {
                    return (ChildJob) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final Sequence<Job> getChildren() {
        return SequenceBuilderKt.buildSequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final DisposableHandle attachChild(Job job) {
        Intrinsics.checkParameterIsNotNull(job, "child");
        return Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildJob(this, job), 2, null);
    }

    @Override // kotlinx.coroutines.experimental.Job
    public final /* synthetic */ void cancelChildren(Throwable th) {
        JobKt.cancelChildren((Job) this, th);
    }

    public void handleException$kotlinx_coroutines_core(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        throw th;
    }

    public String toString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString() + "}@" + DebugKt.getHexAddress(this);
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugKt.getClassSimpleName(this);
    }

    private final String stateString() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            StringBuilder sb = new StringBuilder();
            Finishing finishing = (Finishing) state$kotlinx_coroutines_core;
            if (finishing.cancelled != null) {
                sb.append("Cancelling");
            }
            if (finishing.completing) {
                sb.append("Completing");
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            return ((Incomplete) state$kotlinx_coroutines_core).isActive() ? "Active" : "New";
        } else {
            if (state$kotlinx_coroutines_core instanceof Cancelled) {
                return "Cancelled";
            }
            return state$kotlinx_coroutines_core instanceof CompletedExceptionally ? "CompletedExceptionally" : "Completed";
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$Finishing;", "Lkotlinx/coroutines/experimental/Incomplete;", "list", "Lkotlinx/coroutines/experimental/NodeList;", "cancelled", "Lkotlinx/coroutines/experimental/Cancelled;", "completing", "", "(Lkotlinx/coroutines/experimental/NodeList;Lkotlinx/coroutines/experimental/Cancelled;Z)V", "isActive", "()Z", "getList", "()Lkotlinx/coroutines/experimental/NodeList;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: JobSupport.kt */
    public static final class Finishing implements Incomplete {
        public final Cancelled cancelled;
        public final boolean completing;
        private final NodeList list;

        public Finishing(NodeList nodeList, Cancelled cancelled2, boolean z) {
            Intrinsics.checkParameterIsNotNull(nodeList, "list");
            this.list = nodeList;
            this.cancelled = cancelled2;
            this.completing = z;
        }

        @Override // kotlinx.coroutines.experimental.Incomplete
        public NodeList getList() {
            return this.list;
        }

        @Override // kotlinx.coroutines.experimental.Incomplete
        public boolean isActive() {
            return this.cancelled == null;
        }
    }

    private final boolean isCancelling(Incomplete incomplete) {
        return (incomplete instanceof Finishing) && ((Finishing) incomplete).cancelled != null;
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return state$kotlinx_coroutines_core;
        } else {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
    }

    public final Object awaitInternal$kotlinx_coroutines_core(Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return state$kotlinx_coroutines_core;
                }
                throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            selectInstance.resumeSelectCancellableWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            CancellableKt.startCoroutineCancellable(function2, state$kotlinx_coroutines_core, selectInstance.getCompletion());
        }
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th) {
        Throwable th2 = null;
        Object next = nodeList.getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        th2 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                    }
                }
            }
            if (th2 != null) {
                handleException$kotlinx_coroutines_core(th2);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    private final void notifyCancellation(NodeList nodeList, Throwable th) {
        Throwable th2 = null;
        Object next = nodeList.getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobCancellationNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        th2 = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                    }
                }
            }
            if (th2 != null) {
                handleException$kotlinx_coroutines_core(th2);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.experimental.Job
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

    private final boolean addLastAtomic(Object obj, NodeList nodeList, JobNode<?> jobNode) {
        int tryCondAddNext;
        JobNode<?> jobNode2 = jobNode;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode2, jobNode2, this, obj);
        do {
            Object prev = nodeList.getPrev();
            if (prev != null) {
                tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(jobNode2, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
                if (tryCondAddNext == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (tryCondAddNext != 2);
        return false;
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

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, invokeOnCompletion(new ResumeOnCompletion(this, cancellableContinuationImpl2)));
        return cancellableContinuationImpl.getResult();
    }

    @Override // kotlinx.coroutines.experimental.selects.SelectClause0
    public final <R> void registerSelectClause0(SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (selectInstance.trySelect(null)) {
                        YieldKt.checkCompletion(selectInstance.getCompletion().getContext());
                        UndispatchedKt.startCoroutineUndispatched(function1, selectInstance.getCompletion());
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(this, selectInstance, function1)));
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode<?> jobNode) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(jobNode, "node");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof JobNode) {
                if (state$kotlinx_coroutines_core != jobNode) {
                    return;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                jobNode.remove();
                return;
            } else {
                return;
            }
        } while (!_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, JobSupportKt.access$getEmptyActive$p()));
    }

    private final boolean makeCancelling(Throwable th) {
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive()) {
                    promoteEmptyToNodeList(empty);
                } else if (updateStateCancelled((Incomplete) state$kotlinx_coroutines_core, th)) {
                    return true;
                }
            } else if (state$kotlinx_coroutines_core instanceof JobNode) {
                promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
            } else if (state$kotlinx_coroutines_core instanceof NodeList) {
                NodeList nodeList = (NodeList) state$kotlinx_coroutines_core;
                if (nodeList.isActive()) {
                    if (tryMakeCancelling((Incomplete) state$kotlinx_coroutines_core, nodeList.getList(), th)) {
                        return true;
                    }
                } else if (updateStateCancelled((Incomplete) state$kotlinx_coroutines_core, th)) {
                    return true;
                }
            } else if (!(state$kotlinx_coroutines_core instanceof Finishing)) {
                return false;
            } else {
                Finishing finishing = (Finishing) state$kotlinx_coroutines_core;
                if (finishing.cancelled != null) {
                    return false;
                }
                if (tryMakeCancelling((Incomplete) state$kotlinx_coroutines_core, finishing.getList(), th)) {
                    return true;
                }
            }
        }
    }

    private final int makeCompletingInternal(Object obj, int i) {
        Cancelled cancelled;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return 0;
            }
            boolean z = state$kotlinx_coroutines_core instanceof Finishing;
            if (z && ((Finishing) state$kotlinx_coroutines_core).completing) {
                return 0;
            }
            Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
            ChildJob firstChild = firstChild(incomplete);
            Cancelled cancelled2 = null;
            if (firstChild == null) {
                if (!z && hasOnFinishingHandler$kotlinx_coroutines_core(obj)) {
                    firstChild = null;
                } else if (updateState(incomplete, obj, i)) {
                    return 1;
                }
            }
            NodeList list = incomplete.getList();
            if (list != null) {
                if ((obj instanceof CompletedExceptionally) && firstChild != null) {
                    cancelChildrenInternal(firstChild, ((CompletedExceptionally) obj).cause);
                }
                Finishing finishing = (Finishing) (!z ? null : state$kotlinx_coroutines_core);
                if (finishing == null || (cancelled = finishing.cancelled) == null) {
                    if (obj instanceof Cancelled) {
                        cancelled2 = obj;
                    }
                    cancelled = cancelled2;
                }
                Finishing finishing2 = new Finishing(list, cancelled, true);
                if (!_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, finishing2)) {
                    continue;
                } else {
                    if (!z) {
                        onFinishingInternal$kotlinx_coroutines_core(obj);
                    }
                    if (firstChild != null && tryWaitForChild(firstChild, obj)) {
                        return 2;
                    }
                    if (updateState(finishing2, obj, 0)) {
                        return 1;
                    }
                }
            } else if (state$kotlinx_coroutines_core instanceof Empty) {
                promoteEmptyToNodeList((Empty) state$kotlinx_coroutines_core);
            } else if (state$kotlinx_coroutines_core instanceof JobNode) {
                promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
            } else {
                throw new IllegalStateException(("Unexpected state with an empty list: " + state$kotlinx_coroutines_core).toString());
            }
        }
    }

    public final void continueCompleting$kotlinx_coroutines_core(ChildJob childJob, Object obj) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(childJob, "lastChild");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Finishing) {
                ChildJob nextChild = nextChild(childJob);
                if (nextChild != null && tryWaitForChild(nextChild, obj)) {
                    return;
                }
            } else {
                throw new IllegalStateException("Job " + this + " is found in expected state while completing with " + obj, getExceptionOrNull(obj));
            }
        } while (!updateState((Incomplete) state$kotlinx_coroutines_core, obj, 0));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object awaitSuspend(Continuation<Object> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, invokeOnCompletion(new JobSupport$awaitSuspend$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl2, this)));
        return cancellableContinuationImpl.getResult();
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (!selectInstance.trySelect(null)) {
                        return;
                    }
                    if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                        selectInstance.resumeSelectCancellableWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        return;
                    } else {
                        UndispatchedKt.startCoroutineUndispatched(function2, state$kotlinx_coroutines_core, selectInstance.getCompletion());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new SelectAwaitOnCompletion(this, selectInstance, function2)));
    }
}
