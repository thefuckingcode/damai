package kotlinx.coroutines.experimental;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001fJA\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2'\u0010$\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u001b0%j\u0002`(H\u0016J\r\u0010)\u001a\u00020*H\u0010¢\u0006\u0002\b+J\u0012\u0010,\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0017\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0010¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00028\u0000H\u0014¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0014J\u001f\u00105\u001a\u00020\u001b2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0014H\u0010¢\u0006\u0002\b9J\b\u0010:\u001a\u00020\u001bH\u0014J\r\u0010;\u001a\u00020\u001bH\u0000¢\u0006\u0002\b<J\u0013\u0010=\u001a\u00020\u001b2\u0006\u00102\u001a\u00028\u0000¢\u0006\u0002\u00103J\u000e\u0010>\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019JM\u0010?\u001a\u00020\u001b\"\u0004\b\u0001\u0010@2\u0006\u0010?\u001a\u00020A2\u0006\u0010B\u001a\u0002H@2'\u0010C\u001a#\b\u0001\u0012\u0004\u0012\u0002H@\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u0001070D¢\u0006\u0002\bEø\u0001\u0000¢\u0006\u0002\u0010FJ4\u0010?\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020A2\u001c\u0010C\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u0001070%ø\u0001\u0000¢\u0006\u0002\u0010GR\u001c\u0010\u000b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148PX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006H"}, d2 = {"Lkotlinx/coroutines/experimental/AbstractCoroutine;", "T", "Lkotlinx/coroutines/experimental/JobSupport;", "Lkotlinx/coroutines/experimental/Job;", "Lkotlin/coroutines/experimental/Continuation;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "coroutineContext", "coroutineContext$annotations", "getCoroutineContext", "defaultResumeMode", "", "getDefaultResumeMode$kotlinx_coroutines_core", "()I", "cancel", "cause", "", "handleException", "", "exception", "handleException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "invokeOnCompletion", "Lkotlinx/coroutines/experimental/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "Lkotlinx/coroutines/experimental/CompletionHandler;", "nameString", "", "nameString$kotlinx_coroutines_core", "onCancellation", "onCancellationInternal", "exceptionally", "Lkotlinx/coroutines/experimental/CompletedExceptionally;", "onCancellationInternal$kotlinx_coroutines_core", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletedExceptionally", "onCompletionInternal", "state", "", "mode", "onCompletionInternal$kotlinx_coroutines_core", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resume", "resumeWithException", "start", "R", "Lkotlinx/coroutines/experimental/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/experimental/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: AbstractCoroutine.kt */
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    private final CoroutineContext context;
    private final CoroutineContext parentContext;

    public static /* synthetic */ void context$annotations() {
    }

    @Deprecated(message = "Replaced with context", replaceWith = @ReplaceWith(expression = "context", imports = {}))
    public static /* synthetic */ void coroutineContext$annotations() {
    }

    public int getDefaultResumeMode$kotlinx_coroutines_core() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCancellation(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void onCompleted(T t) {
    }

    /* access modifiers changed from: protected */
    public void onCompletedExceptionally(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractCoroutine(CoroutineContext coroutineContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, (i & 2) != 0 ? true : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        this.parentContext = coroutineContext;
        this.context = coroutineContext.plus(this);
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.experimental.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.context;
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.Key));
    }

    @Override // kotlinx.coroutines.experimental.JobSupport
    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    @Override // kotlinx.coroutines.experimental.JobSupport
    public void onCancellationInternal$kotlinx_coroutines_core(CompletedExceptionally completedExceptionally) {
        onCancellation(completedExceptionally != null ? completedExceptionally.cause : null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.experimental.JobSupport
    public void onCompletionInternal$kotlinx_coroutines_core(Object obj, int i) {
        if (obj instanceof CompletedExceptionally) {
            onCompletedExceptionally(((CompletedExceptionally) obj).cause);
        } else {
            onCompleted(obj);
        }
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public final void resume(T t) {
        makeCompletingOnce$kotlinx_coroutines_core(t, getDefaultResumeMode$kotlinx_coroutines_core());
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public final void resumeWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        makeCompletingOnce$kotlinx_coroutines_core(new CompletedExceptionally(th), getDefaultResumeMode$kotlinx_coroutines_core());
    }

    @Override // kotlinx.coroutines.experimental.JobSupport
    public final void handleException$kotlinx_coroutines_core(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineExceptionHandlerKt.handleCoroutineException(this.parentContext, th);
    }

    @Override // kotlinx.coroutines.experimental.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return Typography.quote + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    public final void start(CoroutineStart coroutineStart, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function1, this);
    }

    public final <R> void start(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function2, r, this);
    }

    @Override // kotlinx.coroutines.experimental.JobSupport, kotlinx.coroutines.experimental.Job
    public DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return super.invokeOnCompletion(z, z2, function1);
    }

    @Override // kotlinx.coroutines.experimental.JobSupport, kotlinx.coroutines.experimental.Job
    public boolean cancel(Throwable th) {
        return super.cancel(th);
    }
}
