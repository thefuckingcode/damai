package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hl;
import tb.jl1;
import tb.k21;
import tb.kl;
import tb.q30;
import tb.qn;
import tb.sn;

@InternalCoroutinesApi
/* compiled from: Taobao */
public abstract class a<T> extends JobSupport implements Job, Continuation<T> {
    @NotNull
    private final CoroutineContext context;

    public a(@NotNull CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            initParentJob((Job) coroutineContext.get(Job.Key));
        }
        this.context = coroutineContext.plus(this);
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    /* access modifiers changed from: protected */
    public void afterResume(@Nullable Object obj) {
        afterCompletion(obj);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String cancellationExceptionMessage() {
        return k21.r(q30.a(this), " was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        sn.a(this.context, th);
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.JobSupport
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        String b = qn.b(this.context);
        if (b == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return jl1.QUOTE + b + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    /* access modifiers changed from: protected */
    public void onCancelled(@NotNull Throwable th, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onCompleted(T t) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(@Nullable Object obj) {
        if (obj instanceof hl) {
            hl hlVar = (hl) obj;
            onCancelled(hlVar.a, hlVar.a());
            return;
        }
        onCompleted(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(kl.d(obj, null, 1, null));
        if (makeCompletingOnce$kotlinx_coroutines_core != q.COMPLETING_WAITING_CHILDREN) {
            afterResume(makeCompletingOnce$kotlinx_coroutines_core);
        }
    }

    public final <R> void start(@NotNull CoroutineStart coroutineStart, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r, this);
    }
}
