package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c90;
import tb.kl;

/* compiled from: Taobao */
public class d<T> extends a<T> implements CoroutineStackFrame {
    @JvmField
    @NotNull
    public final Continuation<T> uCont;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.uCont = continuation;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        c90.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont), kl.a(obj, this.uCont), null, 2, null);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    public void afterResume(@Nullable Object obj) {
        Continuation<T> continuation = this.uCont;
        continuation.resumeWith(kl.a(obj, continuation));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.uCont;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public final Job getParent$kotlinx_coroutines_core() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core == null) {
            return null;
        }
        return parentHandle$kotlinx_coroutines_core.getParent();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public final boolean isScopedCoroutine() {
        return true;
    }
}
